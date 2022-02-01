package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dp.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class d
{
  private static int qaC = 0;
  HashMap<Long, av> qaA;
  HashMap<Long, Integer> qaB;
  private j qaD;
  private Object qaE;
  com.tencent.mm.plugin.exdevice.service.c qax;
  private w qay;
  HashMap<Long, av> qaz;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.qaD = null;
    this.qaE = new Object();
    u.clV().qat = new c.a()
    {
      public final void cla()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).qfW = null;
        }
        d.a(d.this).eE(aj.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.qay == null) {
      this.qay = new w()
      {
        public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.uO(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (aj.getContext() == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.clU().uG(paramAnonymousLong1);
            localObject = com.tencent.mm.plugin.exdevice.i.a.acH("shut_down_device");
            if ((localObject != null) && (localObject.length != 0))
            {
              int i = localObject.length;
              paramAnonymousInt3 = 0;
              while (paramAnonymousInt3 < i)
              {
                paramAnonymousLong2 = localObject[paramAnonymousInt3];
                if (paramAnonymousLong2 == paramAnonymousLong1)
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramAnonymousLong2) });
                  d.ur(paramAnonymousLong2);
                  if (!com.tencent.mm.plugin.exdevice.i.a.af("shut_down_device", paramAnonymousLong2)) {
                    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                  }
                }
                paramAnonymousInt3 += 1;
              }
            }
            if (d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) == null) {
              break label341;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) });
            localObject = new dp();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            if ((!((dp)localObject).dot.cWR) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.ur(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ad.clt().acI(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.ur(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.clU().uD(paramAnonymousLong1);
              if (locala != null) {
                locala.dpw = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ad.clE();
              e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.qaz = new HashMap();
    this.qaA = new HashMap();
    this.qaB = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  private boolean c(String paramString, final long paramLong, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23227);
        int i = ba.aiU().aEN();
        if ((i != 4) && (i != 6))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.qaA.containsKey(Long.valueOf(paramLong)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[] { paramString, Long.valueOf(paramLong) });
          AppMethodBeat.o(23227);
          bool = false;
          continue;
        }
        av localav = new av(Looper.getMainLooper(), new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(23214);
            int i = u.clU().uC(paramLong);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.qaO), Integer.valueOf(i) });
            d.ur(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.cmH();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localav.az(l, l);
        this.qaA.put(Long.valueOf(paramLong), localav);
        if (u.clV().qas != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.clV().qas.a(paramLong, paramInt, this.qay);
          AppMethodBeat.o(23227);
          continue;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
      }
      finally {}
      AppMethodBeat.o(23227);
      boolean bool = false;
    }
  }
  
  public static int clb()
  {
    return qaC;
  }
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (ba.aiU().aEN() != 4)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    av localav;
    if (this.qaz.containsKey(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localav = (av)this.qaz.get(Long.valueOf(paramLong));
      localav.stopTimer();
      localav.az(30000L, 30000L);
    }
    while (u.clV().qas == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(23228);
      return false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localav = new av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(23215);
          int i = u.clU().uC(paramLong);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.qaO), Integer.valueOf(i) });
          if (i != 2)
          {
            ad.clE();
            e.cX(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localav.az(30000L, 30000L);
      this.qaz.put(Long.valueOf(paramLong), localav);
    }
    paramString = u.clU().uD(paramLong);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.dpw) });
    if ((paramString.dpw != 2) && (paramString.dpw != 1)) {
      u.clV().qas.a(paramLong, paramInt, this.qay);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean kM(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.clV().qas != null)
    {
      long[] arrayOfLong = u.clV().qas.clI();
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        AppMethodBeat.o(23229);
        return false;
      }
      int j = arrayOfLong.length;
      int i = 0;
      if (i < j)
      {
        long l = arrayOfLong[i];
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.exdevice.i.b localb = ad.clt().uN(l);
        if (localb == null) {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
            u.clV().qas.uJ(l);
          }
        }
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
      AppMethodBeat.o(23229);
      return false;
    }
    AppMethodBeat.o(23229);
    return true;
  }
  
  public static void ur(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.clV().qas != null) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.clV().qas.uJ(paramLong)) });
    }
    AppMethodBeat.o(23225);
  }
  
  public final void CA(int paramInt)
  {
    AppMethodBeat.i(23231);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.qax == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.clV().qas == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.clV().qas.c(paramInt, this.qaD)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(23231);
  }
  
  public final void Cz(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      qaC = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(final int paramInt, j paramj)
  {
    AppMethodBeat.i(23230);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      AppMethodBeat.o(23230);
      return;
    }
    this.qaD = paramj;
    if (this.qax == null)
    {
      this.qax = new com.tencent.mm.plugin.exdevice.service.c();
      this.qax.qfW = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23218);
          if (!u.clV().qas.b(paramInt, d.e(d.this))) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.qax.eE(aj.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.clV().qas == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.clV().qas.b(paramInt, this.qaD)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.qaB.put(paramLong, Integer.valueOf(paramInt));
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
    com.tencent.mm.plugin.exdevice.i.a.af("shut_down_device", paramLong);
    if (this.qax == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.qax = new com.tencent.mm.plugin.exdevice.service.c();
      this.qax.qfW = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).qfW = null;
          d.this.b(paramString, paramLong, this.dpM, this.qaN);
          AppMethodBeat.o(23212);
        }
      };
      this.qax.eE(aj.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.qax != null) && (!this.qax.qfX))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.qax.qfW = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).qfW = null;
          d.this.b(paramString, paramLong, this.dpM, this.qaN);
          AppMethodBeat.o(23213);
        }
      };
      this.qax.eE(aj.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void ai(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.qax == null)
    {
      this.qax = new com.tencent.mm.plugin.exdevice.service.c();
      this.qax.qfW = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.qax.eE(aj.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.qax.aj(paramRunnable);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {}
    for (paramBoolean = c(paramString, paramLong, paramInt);; paramBoolean = d(paramString, paramLong, paramInt))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23224);
      return;
    }
  }
  
  public final void clc()
  {
    AppMethodBeat.i(23226);
    if ((this.qax != null) && (this.qax.qfX)) {
      try
      {
        com.tencent.mm.bs.d.a(this.qax, "exdevice");
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