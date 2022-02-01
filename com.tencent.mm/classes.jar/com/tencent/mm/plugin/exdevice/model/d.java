package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ea;
import com.tencent.mm.f.a.ea.a;
import com.tencent.mm.model.bh;
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
  private static int vdJ = 0;
  com.tencent.mm.plugin.exdevice.service.c vdE;
  private w vdF;
  HashMap<Long, MTimerHandler> vdG;
  HashMap<Long, MTimerHandler> vdH;
  HashMap<Long, Integer> vdI;
  private j vdK;
  private Object vdL;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.vdK = null;
    this.vdL = new Object();
    u.dal().vdA = new c.a()
    {
      public final void cZc()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).vjh = null;
        }
        d.a(d.this).fg(MMApplicationContext.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.vdF == null) {
      this.vdF = new w()
      {
        public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Jx(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (MMApplicationContext.getContext() == null)
          {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.dak().Jp(paramAnonymousLong1);
            localObject = a.avG("shut_down_device");
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
                  d.IW(paramAnonymousLong2);
                  if (!a.af("shut_down_device", paramAnonymousLong2)) {
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
            localObject = new ea();
            EventCenter.instance.publish((IEvent)localObject);
            if ((!((ea)localObject).fzC.fgW) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.IW(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ae.cZx().avH(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.IW(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.dak().Jm(paramAnonymousLong1);
              if (locala != null) {
                locala.fAF = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ae.cZJ();
              e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.vdG = new HashMap();
    this.vdH = new HashMap();
    this.vdI = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  public static void IW(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.dal().vdz != null) {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.dal().vdz.Js(paramLong)) });
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
        int i = bh.aGY().bih();
        if ((i != 4) && (i != 6))
        {
          Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.vdH.containsKey(Long.valueOf(paramLong)))
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
            int i = u.dak().Jl(paramLong);
            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.vdV), Integer.valueOf(i) });
            d.IW(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.daX();
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localMTimerHandler.startTimer(l);
        this.vdH.put(Long.valueOf(paramLong), localMTimerHandler);
        if (u.dal().vdz != null)
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.dal().vdz.a(paramLong, paramInt, this.vdF);
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
  
  public static int cZd()
  {
    return vdJ;
  }
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (bh.aGY().bih() != 4)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    MTimerHandler localMTimerHandler;
    if (this.vdG.containsKey(Long.valueOf(paramLong)))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localMTimerHandler = (MTimerHandler)this.vdG.get(Long.valueOf(paramLong));
      localMTimerHandler.stopTimer();
      localMTimerHandler.startTimer(30000L);
    }
    while (u.dal().vdz == null)
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
          int i = u.dak().Jl(paramLong);
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.vdV), Integer.valueOf(i) });
          if (i != 2)
          {
            ae.cZJ();
            e.dC(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localMTimerHandler.startTimer(30000L);
      this.vdG.put(Long.valueOf(paramLong), localMTimerHandler);
    }
    paramString = u.dak().Jm(paramLong);
    if (paramString == null)
    {
      Log.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.fAF) });
    if ((paramString.fAF != 2) && (paramString.fAF != 1)) {
      u.dal().vdz.a(paramLong, paramInt, this.vdF);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.dal().vdz != null)
    {
      long[] arrayOfLong = u.dal().vdz.cZN();
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
        com.tencent.mm.plugin.exdevice.i.b localb = ae.cZx().Jw(l);
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
            u.dal().vdz.Js(l);
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
  
  public final void Kd(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      vdJ = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Ke(int paramInt)
  {
    AppMethodBeat.i(23231);
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.vdE == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.dal().vdz == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.dal().vdz.c(paramInt, this.vdK)) {
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
    this.vdK = paramj;
    if (this.vdE == null)
    {
      this.vdE = new com.tencent.mm.plugin.exdevice.service.c();
      this.vdE.vjh = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void cZf()
        {
          AppMethodBeat.i(23218);
          if (!u.dal().vdz.b(paramInt, d.e(d.this))) {
            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.vdE.fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.dal().vdz == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.dal().vdz.b(paramInt, this.vdK)) {
      Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.vdI.put(paramLong, Integer.valueOf(paramInt));
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
    a.af("shut_down_device", paramLong);
    if (this.vdE == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.vdE = new com.tencent.mm.plugin.exdevice.service.c();
      this.vdE.vjh = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void cZf()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).vjh = null;
          d.this.b(paramString, paramLong, this.fAV, this.vdU);
          AppMethodBeat.o(23212);
        }
      };
      this.vdE.fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.vdE != null) && (!this.vdE.vji))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.vdE.vjh = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void cZf()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).vjh = null;
          d.this.b(paramString, paramLong, this.fAV, this.vdU);
          AppMethodBeat.o(23213);
        }
      };
      this.vdE.fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void ar(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.vdE == null)
    {
      this.vdE = new com.tencent.mm.plugin.exdevice.service.c();
      this.vdE.vjh = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void cZf()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.vdE.fg(MMApplicationContext.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.vdE.as(paramRunnable);
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
  
  public final void cZe()
  {
    AppMethodBeat.i(23226);
    if ((this.vdE != null) && (this.vdE.vji)) {
      try
      {
        com.tencent.mm.by.c.a(this.vdE, "exdevice");
        AppMethodBeat.o(23226);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(23226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */