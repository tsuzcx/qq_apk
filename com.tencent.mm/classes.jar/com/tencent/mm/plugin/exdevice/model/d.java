package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dl.a;
import com.tencent.mm.model.az;
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
  private static int oTM = 0;
  com.tencent.mm.plugin.exdevice.service.c oTH;
  private w oTI;
  HashMap<Long, av> oTJ;
  HashMap<Long, av> oTK;
  HashMap<Long, Integer> oTL;
  private j oTN;
  private Object oTO;
  
  public d()
  {
    AppMethodBeat.i(23219);
    this.oTN = null;
    this.oTO = new Object();
    u.cai().oTD = new c.a()
    {
      public final void bZn()
      {
        AppMethodBeat.i(23205);
        if (d.a(d.this) == null)
        {
          d.a(d.this, new com.tencent.mm.plugin.exdevice.service.c());
          d.a(d.this).oZg = null;
        }
        d.a(d.this).ew(aj.getContext());
        AppMethodBeat.o(23205);
      }
    };
    if (this.oTI == null) {
      this.oTI = new w()
      {
        public final void b(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
        {
          AppMethodBeat.i(23216);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[] { com.tencent.mm.plugin.exdevice.k.b.pe(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
          if (aj.getContext() == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            AppMethodBeat.o(23216);
            return;
          }
          Object localObject;
          if (4 == paramAnonymousInt2)
          {
            u.cah().oW(paramAnonymousLong1);
            localObject = com.tencent.mm.plugin.exdevice.i.a.UP("shut_down_device");
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
                  d.oH(paramAnonymousLong2);
                  if (!com.tencent.mm.plugin.exdevice.i.a.X("shut_down_device", paramAnonymousLong2)) {
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
            localObject = new dl();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            if ((!((dl)localObject).dfC.cOi) || ((((Integer)d.d(d.this).get(Long.valueOf(paramAnonymousLong1))).intValue() & 0x1) != 1)) {
              d.oH(paramAnonymousLong1);
            }
          }
          while (paramAnonymousInt1 != paramAnonymousInt2)
          {
            localObject = ad.bZG().UQ(String.valueOf(paramAnonymousLong1));
            if ((localObject == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName)))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              AppMethodBeat.o(23216);
              return;
              label341:
              d.oH(paramAnonymousLong1);
            }
            else
            {
              f.a locala = u.cah().oT(paramAnonymousLong1);
              if (locala != null) {
                locala.dgF = paramAnonymousInt2;
              }
              while (paramAnonymousInt2 == 2)
              {
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                AppMethodBeat.o(23216);
                return;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[] { Long.valueOf(paramAnonymousLong1) });
              }
              ad.bZR();
              e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_url, paramAnonymousInt2, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID);
            }
          }
          AppMethodBeat.o(23216);
        }
      };
    }
    this.oTJ = new HashMap();
    this.oTK = new HashMap();
    this.oTL = new HashMap();
    AppMethodBeat.o(23219);
  }
  
  public static int bZo()
  {
    return oTM;
  }
  
  private boolean c(String paramString, final long paramLong, final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23227);
        int i = az.aeS().auR();
        if ((i != 4) && (i != 6))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(23227);
          bool = false;
          return bool;
        }
        if (this.oTK.containsKey(Long.valueOf(paramLong)))
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
            int i = u.cah().oS(paramLong);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.oTY), Integer.valueOf(i) });
            d.oH(paramLong);
            d.b(d.this).remove(Long.valueOf(paramLong));
            AppMethodBeat.o(23214);
            return false;
          }
        }, false);
        long l = com.tencent.mm.plugin.exdevice.k.b.caU();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localav.av(l, l);
        this.oTK.put(Long.valueOf(paramLong), localav);
        if (u.cai().oTC != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.cai().oTC.a(paramLong, paramInt, this.oTI);
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
  
  private boolean d(String paramString, final long paramLong, final int paramInt)
  {
    AppMethodBeat.i(23228);
    if (az.aeS().auR() != 4)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(23228);
      return false;
    }
    av localav;
    if (this.oTJ.containsKey(Long.valueOf(paramLong)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localav = (av)this.oTJ.get(Long.valueOf(paramLong));
      localav.stopTimer();
      localav.av(30000L, 30000L);
    }
    while (u.cai().oTC == null)
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
          int i = u.cah().oS(paramLong);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[] { paramInt, Long.valueOf(paramLong), Integer.valueOf(this.oTY), Integer.valueOf(i) });
          if (i != 2)
          {
            ad.bZR();
            e.cP(paramInt, 2);
          }
          d.c(d.this).remove(Long.valueOf(paramLong));
          AppMethodBeat.o(23215);
          return false;
        }
      }, false);
      localav.av(30000L, 30000L);
      this.oTJ.put(Long.valueOf(paramLong), localav);
    }
    paramString = u.cah().oT(paramLong);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(23228);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.dgF) });
    if ((paramString.dgF != 2) && (paramString.dgF != 1)) {
      u.cai().oTC.a(paramLong, paramInt, this.oTI);
    }
    AppMethodBeat.o(23228);
    return true;
  }
  
  public static boolean jX(boolean paramBoolean)
  {
    AppMethodBeat.i(23229);
    if (u.cai().oTC != null)
    {
      long[] arrayOfLong = u.cai().oTC.bZV();
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
        com.tencent.mm.plugin.exdevice.i.b localb = ad.bZG().pd(l);
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
            u.cai().oTC.oZ(l);
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
  
  public static void oH(long paramLong)
  {
    AppMethodBeat.i(23225);
    if (u.cai().oTC != null) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.cai().oTC.oZ(paramLong)) });
    }
    AppMethodBeat.o(23225);
  }
  
  public final void AY(int paramInt)
  {
    try
    {
      AppMethodBeat.i(23220);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      oTM = paramInt;
      AppMethodBeat.o(23220);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void AZ(int paramInt)
  {
    AppMethodBeat.i(23231);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.oTH == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(23231);
      return;
    }
    if (u.cai().oTC == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23231);
      return;
    }
    if (!u.cai().oTC.c(paramInt, this.oTN)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(23231);
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
    this.oTN = paramj;
    if (this.oTH == null)
    {
      this.oTH = new com.tencent.mm.plugin.exdevice.service.c();
      this.oTH.oZg = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23218);
          if (!u.cai().oTC.b(paramInt, d.e(d.this))) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
          }
          AppMethodBeat.o(23218);
        }
      };
      this.oTH.ew(aj.getContext());
      AppMethodBeat.o(23230);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.cai().oTC == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(23230);
      return;
    }
    if (!u.cai().oTC.b(paramInt, this.oTN)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(23230);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(23221);
      this.oTL.put(paramLong, Integer.valueOf(paramInt));
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
    com.tencent.mm.plugin.exdevice.i.a.X("shut_down_device", paramLong);
    if (this.oTH == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.oTH = new com.tencent.mm.plugin.exdevice.service.c();
      this.oTH.oZg = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23212);
          d.a(d.this).oZg = null;
          d.this.b(paramString, paramLong, this.dgV, this.oTX);
          AppMethodBeat.o(23212);
        }
      };
      this.oTH.ew(aj.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    if ((this.oTH != null) && (!this.oTH.oZh))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.oTH.oZg = new com.tencent.mm.plugin.exdevice.service.c.a(paramInt)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23213);
          d.a(d.this).oZg = null;
          d.this.b(paramString, paramLong, this.dgV, this.oTX);
          AppMethodBeat.o(23213);
        }
      };
      this.oTH.ew(aj.getContext());
      AppMethodBeat.o(23223);
      return;
    }
    b(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(23223);
  }
  
  public final void ah(final Runnable paramRunnable)
  {
    AppMethodBeat.i(23232);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.oTH == null)
    {
      this.oTH = new com.tencent.mm.plugin.exdevice.service.c();
      this.oTH.oZg = new com.tencent.mm.plugin.exdevice.service.c.a(paramRunnable)
      {
        public final void onServiceConnected()
        {
          AppMethodBeat.i(23208);
          paramRunnable.run();
          AppMethodBeat.o(23208);
        }
      };
      this.oTH.ew(aj.getContext());
      AppMethodBeat.o(23232);
      return;
    }
    this.oTH.ai(paramRunnable);
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
  
  public final void bZp()
  {
    AppMethodBeat.i(23226);
    if ((this.oTH != null) && (this.oTH.oZh)) {
      try
      {
        com.tencent.mm.bs.d.a(this.oTH, "exdevice");
        AppMethodBeat.o(23226);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(23226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */