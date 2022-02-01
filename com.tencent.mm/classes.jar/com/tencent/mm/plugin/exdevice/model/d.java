package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dq.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class d
{
  private static int qhh = 0;
  com.tencent.mm.plugin.exdevice.service.c qhc;
  private w qhd;
  HashMap<Long, aw> qhe;
  HashMap<Long, aw> qhf;
  HashMap<Long, Integer> qhg;
  private j qhi;
  private Object qhj;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.qhi = null;
    this.qhj = new Object();
    u.cnl().qgY = new c.a()
    {
      public final void cmq()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).qmB = null;
        }
        d.a(d.this).eI(ak.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.qhd == null) {
      this.qhd = new w()
      {
        public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.vf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (ak.getContext() == null)
          {
            ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.cnk().uX(paramAnonymousLong1);
            localObject = com.tencent.mm.plugin.exdevice.i.a.ady("shut_down_device");
            if ((localObject != null) && (localObject.length != 0))
            {
              int i = localObject.length;
              paramAnonymousInt3 = 0;
              while (paramAnonymousInt3 < i)
              {
                paramAnonymousLong2 = localObject[paramAnonymousInt3];
                if (paramAnonymousLong2 == paramAnonymousLong1)
                {
                  ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[] { Long.valueOf(paramAnonymousLong2) });
                  d.uI(paramAnonymousLong2);
                  if (!com.tencent.mm.plugin.exdevice.i.a.af("shut_down_device", paramAnonymousLong2)) {
                    ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                  }
                }
                paramAnonymousInt3 += 1;
              }
            }
            if (d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) == null) {
              break label341;
            }
            ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[] { d.d(d.this).get(Long.valueOf(paramAnonymousLong1)) });
            localObject = new dq();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            if ((!((dq)localObject).dpy.cXO) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.uI(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ad.cmJ().adz(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (bu.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.uI(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.cnk().uU(paramAnonymousLong1);
              if (locala != null) {
                locala.dqB = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ad.cmU();
              e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.qhe = new HashMap();
    this.qhf = new HashMap();
    this.qhg = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  private boolean c(String paramString, final long paramLong, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23227);
        int i = bc.ajj().aFd();
        if ((i != 4) && (i != 6))
        {
          ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.qhf.containsKey(Long.valueOf(paramLong)))
        {
          ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[] { paramString, Long.valueOf(paramLong) });
          AppMethodBeat.o(23227);
          bool = false;
          continue;
        }
        aw localaw = new aw(Looper.getMainLooper(), new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(23214);
            int i = u.cnk().uT(paramLong);
            ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.qht), Integer.valueOf(i) });
            d.uI(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.cnX();
        ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localaw.ay(l, l);
        this.qhf.put(Long.valueOf(paramLong), localaw);
        if (u.cnl().qgX != null)
        {
          ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.cnl().qgX.a(paramLong, paramInt, this.qhd);
          AppMethodBeat.o(23227);
          continue;
        }
        ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
      }
      finally {}
      AppMethodBeat.o(23227);
      boolean bool = false;
    }
  }
  
  public static int cmr()
  {
    return qhh;
  }
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (bc.ajj().aFd() != 4)
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    aw localaw;
    if (this.qhe.containsKey(Long.valueOf(paramLong)))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localaw = (aw)this.qhe.get(Long.valueOf(paramLong));
      localaw.stopTimer();
      localaw.ay(30000L, 30000L);
    }
    while (u.cnl().qgX == null)
    {
      ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(23228);
      return false;
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localaw = new aw(Looper.getMainLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(23215);
          int i = u.cnk().uT(paramLong);
          ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.qht), Integer.valueOf(i) });
          if (i != 2)
          {
            ad.cmU();
            e.db(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localaw.ay(30000L, 30000L);
      this.qhe.put(Long.valueOf(paramLong), localaw);
    }
    paramString = u.cnk().uU(paramLong);
    if (paramString == null)
    {
      ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.dqB) });
    if ((paramString.dqB != 2) && (paramString.dqB != 1)) {
      u.cnl().qgX.a(paramLong, paramInt, this.qhd);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean kM(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.cnl().qgX != null)
    {
      long[] arrayOfLong = u.cnl().qgX.cmY();
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        AppMethodBeat.o(23229);
        return false;
      }
      int j = arrayOfLong.length;
      int i = 0;
      if (i < j)
      {
        long l = arrayOfLong[i];
        ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.exdevice.i.b localb = ad.cmJ().ve(l);
        if (localb == null) {
          ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
          {
            ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
          }
          else
          {
            ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
            u.cnl().qgX.va(l);
          }
        }
      }
    }
    else
    {
      ae.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
      AppMethodBeat.o(23229);
      return false;
    }
    AppMethodBeat.o(23229);
    return true;
  }
  
  public static void uI(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.cnl().qgX != null) {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.cnl().qgX.va(paramLong)) });
    }
    AppMethodBeat.o(23225);
  }
  
  public final void CL(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      qhh = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void CM(int paramInt)
  {
    AppMethodBeat.i(23231);
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.qhc == null)
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.cnl().qgX == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.cnl().qgX.c(paramInt, this.qhi)) {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(23231);
  }
  
  public final void a(final int paramInt, j paramj)
  {
    AppMethodBeat.i(23230);
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      AppMethodBeat.o(23230);
      return;
    }
    this.qhi = paramj;
    if (this.qhc == null)
    {
      this.qhc = new com.tencent.mm.plugin.exdevice.service.c();
      this.qhc.qmB = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23218);
          if (!u.cnl().qgX.b(paramInt, d.e(d.this))) {
            ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.qhc.eI(ak.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.cnl().qgX == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.cnl().qgX.b(paramInt, this.qhi)) {
      ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.qhg.put(paramLong, Integer.valueOf(paramInt));
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
    if (this.qhc == null)
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.qhc = new com.tencent.mm.plugin.exdevice.service.c();
      this.qhc.qmB = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).qmB = null;
          d.this.b(paramString, paramLong, this.dqR, this.qhs);
          AppMethodBeat.o(23212);
        }
      };
      this.qhc.eI(ak.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.qhc != null) && (!this.qhc.qmC))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.qhc.qmB = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).qmB = null;
          d.this.b(paramString, paramLong, this.dqR, this.qhs);
          AppMethodBeat.o(23213);
        }
      };
      this.qhc.eI(ak.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void ag(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    ae.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.qhc == null)
    {
      this.qhc = new com.tencent.mm.plugin.exdevice.service.c();
      this.qhc.qmB = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.qhc.eI(ak.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.qhc.ah(paramRunnable);
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
    ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {}
    for (paramBoolean = c(paramString, paramLong, paramInt);; paramBoolean = d(paramString, paramLong, paramInt))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23224);
      return;
    }
  }
  
  public final void cms()
  {
    AppMethodBeat.i(23226);
    if ((this.qhc != null) && (this.qhc.qmC)) {
      try
      {
        com.tencent.mm.br.d.a(this.qhc, "exdevice");
        AppMethodBeat.o(23226);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(23226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */