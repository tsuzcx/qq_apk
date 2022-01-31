package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;

public final class d
{
  private static int lDa = 0;
  com.tencent.mm.plugin.exdevice.service.c lCV;
  private w lCW;
  HashMap<Long, ap> lCX;
  HashMap<Long, ap> lCY;
  HashMap<Long, Integer> lCZ;
  private j lDb;
  private Object lDc;
  
  public d()
  {
    AppMethodBeat.i(19111);
    this.lDb = null;
    this.lDc = new Object();
    u.bqA().lCR = new d.1(this);
    if (this.lCW == null) {
      this.lCW = new d.10(this);
    }
    this.lCX = new HashMap();
    this.lCY = new HashMap();
    this.lCZ = new HashMap();
    AppMethodBeat.o(19111);
  }
  
  public static int bpH()
  {
    return lDa;
  }
  
  private boolean d(String paramString, long paramLong, int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(19119);
        int i = aw.Rc().adt();
        if ((i != 4) && (i != 6))
        {
          ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
          AppMethodBeat.o(19119);
          bool = false;
          return bool;
        }
        if (this.lCY.containsKey(Long.valueOf(paramLong)))
        {
          ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[] { paramString, Long.valueOf(paramLong) });
          AppMethodBeat.o(19119);
          bool = false;
          continue;
        }
        ap localap = new ap(Looper.getMainLooper(), new d.8(this, paramLong, paramString, paramInt), false);
        long l = com.tencent.mm.plugin.exdevice.j.b.brl();
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[] { Long.valueOf(l) });
        localap.ag(l, l);
        this.lCY.put(Long.valueOf(paramLong), localap);
        if (u.bqA().lCQ != null)
        {
          ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[] { paramString, Long.valueOf(paramLong) });
          bool = u.bqA().lCQ.a(paramLong, paramInt, this.lCW);
          AppMethodBeat.o(19119);
          continue;
        }
        ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
      }
      finally {}
      AppMethodBeat.o(19119);
      boolean bool = false;
    }
  }
  
  private boolean e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(19120);
    if (aw.Rc().adt() != 4)
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
      AppMethodBeat.o(19120);
      return false;
    }
    ap localap;
    if (this.lCX.containsKey(Long.valueOf(paramLong)))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localap = (ap)this.lCX.get(Long.valueOf(paramLong));
      localap.stopTimer();
      localap.ag(30000L, 30000L);
    }
    while (u.bqA().lCQ == null)
    {
      ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      AppMethodBeat.o(19120);
      return false;
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      localap = new ap(Looper.getMainLooper(), new d.9(this, paramLong, paramString, paramInt), false);
      localap.ag(30000L, 30000L);
      this.lCX.put(Long.valueOf(paramLong), localap);
    }
    paramString = u.bqz().jl(paramLong);
    if (paramString == null)
    {
      ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(19120);
      return false;
    }
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[] { Integer.valueOf(paramString.crJ) });
    if ((paramString.crJ != 2) && (paramString.crJ != 1)) {
      u.bqA().lCQ.a(paramLong, paramInt, this.lCW);
    }
    AppMethodBeat.o(19120);
    return true;
  }
  
  public static boolean hc(boolean paramBoolean)
  {
    AppMethodBeat.i(19121);
    if (u.bqA().lCQ != null)
    {
      long[] arrayOfLong = u.bqA().lCQ.bqn();
      if ((arrayOfLong == null) || (arrayOfLong.length <= 0))
      {
        ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
        AppMethodBeat.o(19121);
        return false;
      }
      int j = arrayOfLong.length;
      int i = 0;
      if (i < j)
      {
        long l = arrayOfLong[i];
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[] { Long.valueOf(l) });
        com.tencent.mm.plugin.exdevice.h.b localb = ad.bpY().jv(l);
        if (localb == null) {
          ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[] { Long.valueOf(l) });
        }
        for (;;)
        {
          i += 1;
          break;
          if ((paramBoolean) && ((localb.field_closeStrategy & 0x1) == 0))
          {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[] { Long.valueOf(l) });
          }
          else
          {
            ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[] { Long.valueOf(l) });
            u.bqA().lCQ.jr(l);
          }
        }
      }
    }
    else
    {
      ab.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher is null!");
      AppMethodBeat.o(19121);
      return false;
    }
    AppMethodBeat.o(19121);
    return true;
  }
  
  public static void iZ(long paramLong)
  {
    AppMethodBeat.i(19117);
    if (u.bqA().lCQ != null) {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(u.bqA().lCQ.jr(paramLong)) });
    }
    AppMethodBeat.o(19117);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(19124);
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
    if (this.lCV == null)
    {
      this.lCV = new com.tencent.mm.plugin.exdevice.service.c();
      this.lCV.lIv = new d.4(this, paramRunnable);
      this.lCV.dM(ah.getContext());
      AppMethodBeat.o(19124);
      return;
    }
    this.lCV.R(paramRunnable);
    AppMethodBeat.o(19124);
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(19122);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramj == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
      AppMethodBeat.o(19122);
      return;
    }
    this.lDb = paramj;
    if (this.lCV == null)
    {
      this.lCV = new com.tencent.mm.plugin.exdevice.service.c();
      this.lCV.lIv = new d.12(this, paramInt, paramInt);
      this.lCV.dM(ah.getContext());
      AppMethodBeat.o(19122);
      return;
    }
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
    if (u.bqA().lCQ == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(19122);
      return;
    }
    if (!u.bqA().lCQ.b(paramInt, this.lDb)) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
    }
    AppMethodBeat.o(19122);
  }
  
  public final void a(Long paramLong, int paramInt)
  {
    try
    {
      AppMethodBeat.i(19113);
      this.lCZ.put(paramLong, Integer.valueOf(paramInt));
      AppMethodBeat.o(19113);
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  public final void b(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19115);
    a.M("shut_down_device", paramLong);
    if (this.lCV == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
      this.lCV = new com.tencent.mm.plugin.exdevice.service.c();
      this.lCV.lIv = new d.6(this, paramInt, paramString, paramLong, paramBoolean);
      this.lCV.dM(ah.getContext());
      AppMethodBeat.o(19115);
      return;
    }
    if ((this.lCV != null) && (!this.lCV.lIw))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
      this.lCV.lIv = new d.7(this, paramInt, paramString, paramLong, paramBoolean);
      this.lCV.dM(ah.getContext());
      AppMethodBeat.o(19115);
      return;
    }
    c(paramString, paramLong, paramInt, paramBoolean);
    AppMethodBeat.o(19115);
  }
  
  public final void bpI()
  {
    AppMethodBeat.i(19118);
    if ((this.lCV != null) && (this.lCV.lIw)) {
      try
      {
        com.tencent.mm.bq.d.a(this.lCV, "exdevice");
        AppMethodBeat.o(19118);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(19118);
  }
  
  public final void c(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(19114);
    b(paramString, paramLong, paramInt, false);
    AppMethodBeat.o(19114);
  }
  
  public final void c(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19116);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
    if (paramBoolean) {}
    for (paramBoolean = d(paramString, paramLong, paramInt);; paramBoolean = e(paramString, paramLong, paramInt))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(19116);
      return;
    }
  }
  
  public final void uU(int paramInt)
  {
    try
    {
      AppMethodBeat.i(19112);
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[] { Integer.valueOf(paramInt) });
      lDa = paramInt;
      AppMethodBeat.o(19112);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void uV(int paramInt)
  {
    AppMethodBeat.i(19123);
    ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lCV == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
      AppMethodBeat.o(19123);
      return;
    }
    if (u.bqA().lCQ == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
      AppMethodBeat.o(19123);
      return;
    }
    if (!u.bqA().lCQ.c(paramInt, this.lDb)) {
      ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
    }
    AppMethodBeat.o(19123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d
 * JD-Core Version:    0.7.0.1
 */