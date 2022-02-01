package com.tencent.mm.plugin.exdevice.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.g;
import com.tencent.mm.plugin.exdevice.model.z;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import junit.framework.Assert;

public final class k
  implements com.tencent.mm.am.h
{
  public static k yoX = null;
  public MMHandler mHandler;
  private final HashMap<Long, e> yoW;
  public HashMap<String, Integer> yoY;
  
  private k()
  {
    AppMethodBeat.i(23172);
    this.yoW = new HashMap();
    this.mHandler = null;
    this.yoY = new HashMap();
    this.mHandler = new a(bh.baH().getLooper());
    AppMethodBeat.o(23172);
  }
  
  public static k dFm()
  {
    AppMethodBeat.i(23171);
    if (yoX != null)
    {
      localk = yoX;
      AppMethodBeat.o(23171);
      return localk;
    }
    k localk = new k();
    yoX = localk;
    AppMethodBeat.o(23171);
    return localk;
  }
  
  public final void b(int paramInt1, long paramLong, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23173);
    paramArrayOfByte = new f(paramLong, paramInt2, paramInt3, paramArrayOfByte);
    this.mHandler.obtainMessage(1, paramInt1, 0, paramArrayOfByte).sendToTarget();
    AppMethodBeat.o(23173);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23174);
    Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b localb = new b((byte)0);
    localb.yoO = paramInt2;
    localb.ypa = paramInt1;
    localb.rzc = paramString;
    localb.ypb = paramp;
    this.mHandler.obtainMessage(2, localb).sendToTarget();
    AppMethodBeat.o(23174);
  }
  
  final class a
    extends MMHandler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(23162);
      Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[] { Integer.valueOf(paramMessage.what) });
      long l;
      switch (paramMessage.what)
      {
      default: 
        Log.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(23162);
        return;
      case 1: 
        localObject2 = (f)paramMessage.obj;
        if (!u.dGD().lG(((c)localObject2).vyj))
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).vyj) });
          ((f)localObject2).b(-2, "", new byte[0]);
          paramMessage = new com.tencent.mm.plugin.exdevice.j.h((f)localObject2);
          u.dGE().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
          ((f)localObject2).b(-1, "", new byte[0]);
          paramMessage = new com.tencent.mm.plugin.exdevice.j.h((f)localObject2);
          u.dGE().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        com.tencent.mm.plugin.exdevice.i.b localb = ah.dFO().apH(((c)localObject2).vyj);
        if (localb == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
          AppMethodBeat.o(23162);
          return;
        }
        l = localb.kCZ;
        if (System.currentTimeMillis() / 1000L < l)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
          ((f)localObject2).b(-5, "Device Is Block", null);
          paramMessage = new com.tencent.mm.plugin.exdevice.j.h((f)localObject2);
          u.dGE().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        l = k.f.dFp();
        com.tencent.mm.plugin.exdevice.f.k localk = (com.tencent.mm.plugin.exdevice.f.k)((f)localObject2).dFk();
        if (localk == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
          ((f)localObject2).b(-4, "Decode failed", null);
          paramMessage = new com.tencent.mm.plugin.exdevice.j.h((f)localObject2);
          u.dGE().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (Integer)k.b(k.this).get(localb.field_deviceID);
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = Integer.valueOf(0);
        }
        Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[] { paramMessage });
        if (paramMessage.intValue() == 0)
        {
          if (localk.vhJ == 10001)
          {
            ah.dGc();
            g.d(localb.field_deviceID, localb.field_brandName, localk.vgA.toByteArray());
            AppMethodBeat.o(23162);
            return;
          }
          paramMessage = new z(((c)localObject2).vyj, localb.field_deviceType, localb.field_deviceID, l, Util.nowMilliSecond(), localk.vgA.toByteArray(), localk.vhJ);
          bh.aZW().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).ypf = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
          AppMethodBeat.o(23162);
          return;
        }
        if ((paramMessage.intValue() & 0x1) != 0)
        {
          ah.dGc();
          g.d(localb.field_deviceID, localb.field_brandName, localk.vgA.toByteArray());
        }
        if ((paramMessage.intValue() & 0x2) != 0)
        {
          paramMessage = new z(((c)localObject2).vyj, localb.field_deviceType, localb.field_deviceID, l, Util.nowMilliSecond(), localk.vgA.toByteArray(), localk.vhJ);
          bh.aZW().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).ypf = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
        }
        AppMethodBeat.o(23162);
        return;
      case 2: 
        paramMessage = (k.b)paramMessage.obj;
        if ((paramMessage.ypa == 0) && (paramMessage.yoO == 0))
        {
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (z)paramMessage.ypb;
        Assert.assertNotNull(((z)localObject1).mtC);
        l = ((exi)c.b.b(((z)localObject1).mtC.otB)).abzm.aaEe;
        localObject1 = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (localObject1 == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        localObject2 = ((k.e)localObject1).dFn();
        switch (paramMessage.yoO)
        {
        }
        for (int i = -1;; i = -5)
        {
          ((f)localObject2).b(i, paramMessage.rzc, null);
          paramMessage = new com.tencent.mm.plugin.exdevice.j.h(((k.e)localObject1).dFn());
          u.dGE().a(paramMessage);
          k.a(k.this).removeCallbacks(((k.e)localObject1).dFo());
          k.c(k.this).remove(Long.valueOf(l));
          AppMethodBeat.o(23162);
          return;
        }
      case 0: 
        l = ((Long)paramMessage.obj).longValue();
        paramMessage = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (paramMessage == null)
        {
          Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        paramMessage.dFn().b(-1, "", null);
        paramMessage = new com.tencent.mm.plugin.exdevice.j.h(paramMessage.dFn());
        u.dGE().a(paramMessage);
        k.c(k.this).remove(Long.valueOf(l));
        AppMethodBeat.o(23162);
        return;
      }
      paramMessage = (k.c)paramMessage.obj;
      Object localObject1 = (k.e)k.c(k.this).get(Long.valueOf(paramMessage.mSessionId));
      if (localObject1 == null)
      {
        Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(paramMessage.mSessionId) });
        AppMethodBeat.o(23162);
        return;
      }
      ((k.e)localObject1).ypd.b(0, "", paramMessage.mData);
      Object localObject2 = new com.tencent.mm.plugin.exdevice.j.h(((k.e)localObject1).dFn());
      u.dGE().a((ai)localObject2);
      k.a(k.this).removeCallbacks(((k.e)localObject1).dFo());
      k.c(k.this).remove(Long.valueOf(paramMessage.mSessionId));
      AppMethodBeat.o(23162);
    }
  }
  
  static final class b
  {
    public String rzc = null;
    public int yoO = 0;
    public int ypa = 0;
    public p ypb = null;
  }
  
  public static final class c
  {
    public byte[] mData = null;
    public long mSessionId = 0L;
  }
  
  final class d
    implements Runnable
  {
    private long ypc;
    
    public d(long paramLong)
    {
      AppMethodBeat.i(23163);
      this.ypc = -1L;
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.ypc = paramLong;
        AppMethodBeat.o(23163);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(23164);
      Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.ypc) });
      k.a(k.this).obtainMessage(0, Long.valueOf(this.ypc)).sendToTarget();
      AppMethodBeat.o(23164);
    }
  }
  
  static final class e
  {
    f ypd = null;
    private k.d ype = null;
    int ypf = 0;
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(23165);
      Assert.assertNotNull(paramf);
      this.ypd = paramf;
      AppMethodBeat.o(23165);
    }
    
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(23166);
      Assert.assertNotNull(paramd);
      this.ype = paramd;
      AppMethodBeat.o(23166);
    }
    
    public final f dFn()
    {
      AppMethodBeat.i(23167);
      Assert.assertNotNull(this.ypd);
      f localf = this.ypd;
      AppMethodBeat.o(23167);
      return localf;
    }
    
    public final k.d dFo()
    {
      AppMethodBeat.i(23168);
      Assert.assertNotNull(this.ype);
      k.d locald = this.ype;
      AppMethodBeat.o(23168);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.k
 * JD-Core Version:    0.7.0.1
 */