package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dt.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.i.a;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d
{
  private static int ryd = 0;
  com.tencent.mm.plugin.exdevice.service.c rxY;
  private w rxZ;
  HashMap<Long, MTimerHandler> rya;
  HashMap<Long, MTimerHandler> ryb;
  HashMap<Long, Integer> ryc;
  private j rye;
  private Object ryf;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.rye = null;
    this.ryf = new Object();
    u.cLy().rxU = new c.a()
    {
      public final void cKs()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).rDx = null;
        }
        d.a(d.this).fc(MMApplicationContext.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.rxZ == null) {
      this.rxZ = new w()
      {
        public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Dj(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (MMApplicationContext.getContext() == null)
          {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.cLx().Db(paramAnonymousLong1);
            localObject = a.anH("shut_down_device");
            if ((localObject != null) && (localObject.length != 0))
            {
              int i = localObject.length;
              paramAnonymousInt3 = 0;
              while (paramAnonymousInt3 < i)
              {
                paramAnonymousLong2 = localObject[paramAnonymousInt3];
                if (paramAnonymousLong2 == paramAnonymousLong1)
                {
                  Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramAnonymousLong2) });
                  d.CM(paramAnonymousLong2);
                  if (!a.ae("shut_down_device", paramAnonymousLong2)) {
                    Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                  }
                }
                paramAnonymousInt3 += 1;
              }
            }
            if (d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) == null) {
              break label341;
            }
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) });
            localObject = new dt();
            EventCenter.instance.publish((IEvent)localObject);
            if ((!((dt)localObject).dGM.dor) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.CM(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ad.cKL().anI(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.CM(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.cLx().CY(paramAnonymousLong1);
              if (locala != null) {
                locala.dHO = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ad.cKW();
              e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.rya = new HashMap();
    this.ryb = new HashMap();
    this.ryc = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  public static void CM(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.cLy().rxT != null) {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.cLy().rxT.De(paramLong)) });
    }
    AppMethodBeat.o(23225);
  }
  
  private boolean c(String paramString, final long paramLong, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23227);
        int i = bg.azz().aYS();
        if ((i != 4) && (i != 6))
        {
          Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.ryb.containsKey(Long.valueOf(paramLong)))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[] { paramString, Long.valueOf(paramLong) });
          AppMethodBeat.o(23227);
          bool = false;
          continue;
        }
        MTimerHandler localMTimerHandler = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(23214);
            int i = u.cLx().CX(paramLong);
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.ryp), Integer.valueOf(i) });
            d.CM(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.cMj();
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localMTimerHandler.startTimer(l);
        this.ryb.put(Long.valueOf(paramLong), localMTimerHandler);
        if (u.cLy().rxT != null)
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.cLy().rxT.a(paramLong, paramInt, this.rxZ);
          AppMethodBeat.o(23227);
          continue;
        }
        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
      }
      finally {}
      AppMethodBeat.o(23227);
      boolean bool = false;
    }
  }
  
  public static int cKt()
  {
    return ryd;
  }
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (bg.azz().aYS() != 4)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    MTimerHandler localMTimerHandler;
    if (this.rya.containsKey(Long.valueOf(paramLong)))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localMTimerHandler = (MTimerHandler)this.rya.get(Long.valueOf(paramLong));
      localMTimerHandler.stopTimer();
      localMTimerHandler.startTimer(30000L);
    }
    while (u.cLy().rxT == null)
    {
      Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(23228);
      return false;
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localMTimerHandler = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(23215);
          int i = u.cLx().CX(paramLong);
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.ryp), Integer.valueOf(i) });
          if (i != 2)
          {
            ad.cKW();
            e.dh(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localMTimerHandler.startTimer(30000L);
      this.rya.put(Long.valueOf(paramLong), localMTimerHandler);
    }
    paramString = u.cLx().CY(paramLong);
    if (paramString == null)
    {
      Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.dHO) });
    if ((paramString.dHO != 2) && (paramString.dHO != 1)) {
      u.cLy().rxT.a(paramLong, paramInt, this.rxZ);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean lO(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.cLy().rxT != null)
    {
      long[] arrayOfLong = u.cLy().rxT.cLa();
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        AppMethodBeat.o(23229);
        return false;
      }
      int j = arrayOfLong.length;
      int i = 0;
      if (i < j)
      {
        long l = arrayOfLong[i];
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.exdevice.i.b localb = ad.cKL().Di(l);
        if (localb == null) {
          Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
          {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
          }
          else
          {
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
            u.cLy().rxT.De(l);
          }
        }
      }
    }
    else
    {
      Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
      AppMethodBeat.o(23229);
      return false;
    }
    AppMethodBeat.o(23229);
    return true;
  }
  
  public final void Gw(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      ryd = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Gx(int paramInt)
  {
    AppMethodBeat.i(23231);
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.rxY == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.cLy().rxT == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.cLy().rxT.c(paramInt, this.rye)) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(23231);
  }
  
  public final void a(final int paramInt, j paramj)
  {
    AppMethodBeat.i(23230);
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      AppMethodBeat.o(23230);
      return;
    }
    this.rye = paramj;
    if (this.rxY == null)
    {
      this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
      this.rxY.rDx = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23218);
          if (!u.cLy().rxT.b(paramInt, d.e(d.this))) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.rxY.fc(MMApplicationContext.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.cLy().rxT == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.cLy().rxT.b(paramInt, this.rye)) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.ryc.put(paramLong, Integer.valueOf(paramInt));
      AppMethodBeat.o(23221);
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  public final void a(final String paramString, final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(23223);
    a.ae("shut_down_device", paramLong);
    if (this.rxY == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
      this.rxY.rDx = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).rDx = null;
          d.this.b(paramString, paramLong, this.dIe, this.ryo);
          AppMethodBeat.o(23212);
        }
      };
      this.rxY.fc(MMApplicationContext.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.rxY != null) && (!this.rxY.rDy))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.rxY.rDx = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).rDx = null;
          d.this.b(paramString, paramLong, this.dIe, this.ryo);
          AppMethodBeat.o(23213);
        }
      };
      this.rxY.fc(MMApplicationContext.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void am(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.rxY == null)
    {
      this.rxY = new com.tencent.mm.plugin.exdevice.service.c();
      this.rxY.rDx = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.rxY.fc(MMApplicationContext.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.rxY.an(paramRunnable);
    AppMethodBeat.o(23232);
  }
  
  public final void b(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(23222);
    a(paramString, paramLong, paramInt, false);
    AppMethodBeat.o(23222);
  }
  
  public final void b(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(23224);
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {}
    for (paramBoolean = c(paramString, paramLong, paramInt);; paramBoolean = d(paramString, paramLong, paramInt))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23224);
      return;
    }
  }
  
  public final void cKu()
  {
    AppMethodBeat.i(23226);
    if ((this.rxY != null) && (this.rxY.rDy)) {
      try
      {
        com.tencent.mm.br.c.a(this.rxY, "exdevice");
        AppMethodBeat.o(23226);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(23226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */