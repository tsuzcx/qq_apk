package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.dm.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class d
{
  private static int pwX = 0;
  com.tencent.mm.plugin.exdevice.service.c pwS;
  private w pwT;
  HashMap<Long, au> pwU;
  HashMap<Long, au> pwV;
  HashMap<Long, Integer> pwW;
  private j pwY;
  private Object pwZ;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.pwY = null;
    this.pwZ = new Object();
    u.chr().pwO = new c.a()
    {
      public final void cgw()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).pCr = null;
        }
        d.a(d.this).eE(ai.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.pwT == null) {
      this.pwT = new w()
      {
        public final void b(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.sQ(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (ai.getContext() == null)
          {
            ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.chq().sI(paramAnonymousLong1);
            localObject = com.tencent.mm.plugin.exdevice.i.a.Zb("shut_down_device");
            if ((localObject != null) && (localObject.length != 0))
            {
              int i = localObject.length;
              paramAnonymousInt3 = 0;
              while (paramAnonymousInt3 < i)
              {
                paramAnonymousLong2 = localObject[paramAnonymousInt3];
                if (paramAnonymousLong2 == paramAnonymousLong1)
                {
                  ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramAnonymousLong2) });
                  d.st(paramAnonymousLong2);
                  if (!com.tencent.mm.plugin.exdevice.i.a.Y("shut_down_device", paramAnonymousLong2)) {
                    ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                  }
                }
                paramAnonymousInt3 += 1;
              }
            }
            if (d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) == null) {
              break label341;
            }
            ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) });
            localObject = new dm();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            if ((!((dm)localObject).dcX.cLD) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.st(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ad.cgP().Zc(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (bs.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.st(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.chq().sF(paramAnonymousLong1);
              if (locala != null) {
                locala.dea = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ad.cha();
              e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.pwU = new HashMap();
    this.pwV = new HashMap();
    this.pwW = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  private boolean c(String paramString, final long paramLong, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23227);
        int i = az.agi().aBK();
        if ((i != 4) && (i != 6))
        {
          ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.pwV.containsKey(Long.valueOf(paramLong)))
        {
          ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[] { paramString, Long.valueOf(paramLong) });
          AppMethodBeat.o(23227);
          bool = false;
          continue;
        }
        au localau = new au(Looper.getMainLooper(), new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(23214);
            int i = u.chq().sE(paramLong);
            ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.pxj), Integer.valueOf(i) });
            d.st(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.cid();
        ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localau.au(l, l);
        this.pwV.put(Long.valueOf(paramLong), localau);
        if (u.chr().pwN != null)
        {
          ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.chr().pwN.a(paramLong, paramInt, this.pwT);
          AppMethodBeat.o(23227);
          continue;
        }
        ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
      }
      finally {}
      AppMethodBeat.o(23227);
      boolean bool = false;
    }
  }
  
  public static int cgx()
  {
    return pwX;
  }
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (az.agi().aBK() != 4)
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    au localau;
    if (this.pwU.containsKey(Long.valueOf(paramLong)))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localau = (au)this.pwU.get(Long.valueOf(paramLong));
      localau.stopTimer();
      localau.au(30000L, 30000L);
    }
    while (u.chr().pwN == null)
    {
      ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(23228);
      return false;
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localau = new au(Looper.getMainLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(23215);
          int i = u.chq().sE(paramLong);
          ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.pxj), Integer.valueOf(i) });
          if (i != 2)
          {
            ad.cha();
            e.cU(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localau.au(30000L, 30000L);
      this.pwU.put(Long.valueOf(paramLong), localau);
    }
    paramString = u.chq().sF(paramLong);
    if (paramString == null)
    {
      ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.dea) });
    if ((paramString.dea != 2) && (paramString.dea != 1)) {
      u.chr().pwN.a(paramLong, paramInt, this.pwT);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean kB(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.chr().pwN != null)
    {
      long[] arrayOfLong = u.chr().pwN.che();
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        AppMethodBeat.o(23229);
        return false;
      }
      int j = arrayOfLong.length;
      int i = 0;
      if (i < j)
      {
        long l = arrayOfLong[i];
        ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.exdevice.i.b localb = ad.cgP().sP(l);
        if (localb == null) {
          ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
          {
            ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
          }
          else
          {
            ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
            u.chr().pwN.sL(l);
          }
        }
      }
    }
    else
    {
      ac.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
      AppMethodBeat.o(23229);
      return false;
    }
    AppMethodBeat.o(23229);
    return true;
  }
  
  public static void st(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.chr().pwN != null) {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.chr().pwN.sL(paramLong)) });
    }
    AppMethodBeat.o(23225);
  }
  
  public final void BQ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      pwX = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void BR(int paramInt)
  {
    AppMethodBeat.i(23231);
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.pwS == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.chr().pwN == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.chr().pwN.c(paramInt, this.pwY)) {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(23231);
  }
  
  public final void a(final int paramInt, j paramj)
  {
    AppMethodBeat.i(23230);
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      AppMethodBeat.o(23230);
      return;
    }
    this.pwY = paramj;
    if (this.pwS == null)
    {
      this.pwS = new com.tencent.mm.plugin.exdevice.service.c();
      this.pwS.pCr = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23218);
          if (!u.chr().pwN.b(paramInt, d.e(d.this))) {
            ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.pwS.eE(ai.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.chr().pwN == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.chr().pwN.b(paramInt, this.pwY)) {
      ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.pwW.put(paramLong, Integer.valueOf(paramInt));
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
    com.tencent.mm.plugin.exdevice.i.a.Y("shut_down_device", paramLong);
    if (this.pwS == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.pwS = new com.tencent.mm.plugin.exdevice.service.c();
      this.pwS.pCr = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).pCr = null;
          d.this.b(paramString, paramLong, this.deq, this.pxi);
          AppMethodBeat.o(23212);
        }
      };
      this.pwS.eE(ai.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.pwS != null) && (!this.pwS.pCs))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.pwS.pCr = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).pCr = null;
          d.this.b(paramString, paramLong, this.deq, this.pxi);
          AppMethodBeat.o(23213);
        }
      };
      this.pwS.eE(ai.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void aj(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    ac.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.pwS == null)
    {
      this.pwS = new com.tencent.mm.plugin.exdevice.service.c();
      this.pwS.pCr = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.pwS.eE(ai.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.pwS.ak(paramRunnable);
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
    ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {}
    for (paramBoolean = c(paramString, paramLong, paramInt);; paramBoolean = d(paramString, paramLong, paramInt))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23224);
      return;
    }
  }
  
  public final void cgy()
  {
    AppMethodBeat.i(23226);
    if ((this.pwS != null) && (this.pwS.pCs)) {
      try
      {
        com.tencent.mm.br.d.a(this.pwS, "exdevice");
        AppMethodBeat.o(23226);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(23226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */