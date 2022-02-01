package com.tencent.mm.plugin.exdevice.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.do;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.j.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import junit.framework.Assert;

public final class k
  implements i
{
  public static k rxE = null;
  public MMHandler mHandler;
  private final HashMap<Long, e> rxD;
  public HashMap<String, Integer> rxF;
  
  private k()
  {
    AppMethodBeat.i(23172);
    this.rxD = new HashMap();
    this.mHandler = null;
    this.rxF = new HashMap();
    this.mHandler = new a(bg.aAk().getLooper());
    AppMethodBeat.o(23172);
  }
  
  public static k cKl()
  {
    AppMethodBeat.i(23171);
    if (rxE != null)
    {
      localk = rxE;
      AppMethodBeat.o(23171);
      return localk;
    }
    k localk = new k();
    rxE = localk;
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23174);
    Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b localb = new b((byte)0);
    localb.rxv = paramInt2;
    localb.rxH = paramInt1;
    localb.lAr = paramString;
    localb.rxI = paramq;
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
        if (!u.cLx().Dc(((c)localObject2).pkb))
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).pkb) });
          ((f)localObject2).b(-2, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.cLy().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
          ((f)localObject2).b(-1, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.cLy().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        com.tencent.mm.plugin.exdevice.i.b localb = ad.cKL().anI(((c)localObject2).pkb);
        if (localb == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
          AppMethodBeat.o(23162);
          return;
        }
        l = localb.fLY;
        if (System.currentTimeMillis() / 1000L < l)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
          ((f)localObject2).b(-5, "Device Is Block", null);
          paramMessage = new h((f)localObject2);
          u.cLy().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        l = k.f.cKo();
        com.tencent.mm.plugin.exdevice.f.k localk = (com.tencent.mm.plugin.exdevice.f.k)((f)localObject2).cKj();
        if (localk == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
          ((f)localObject2).b(-4, "Decode failed", null);
          paramMessage = new h((f)localObject2);
          u.cLy().a(paramMessage);
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
          if (localk.oUv == 10001)
          {
            ad.cKW();
            e.c(localb.field_deviceID, localb.field_brandName, localk.oTm.toByteArray());
            AppMethodBeat.o(23162);
            return;
          }
          paramMessage = new w(((c)localObject2).pkb, localb.field_deviceType, localb.field_deviceID, l, Util.nowMilliSecond(), localk.oTm.toByteArray(), localk.oUv);
          bg.azz().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).rxM = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
          AppMethodBeat.o(23162);
          return;
        }
        if ((paramMessage.intValue() & 0x1) != 0)
        {
          ad.cKW();
          e.c(localb.field_deviceID, localb.field_brandName, localk.oTm.toByteArray());
        }
        if ((paramMessage.intValue() & 0x2) != 0)
        {
          paramMessage = new w(((c)localObject2).pkb, localb.field_deviceType, localb.field_deviceID, l, Util.nowMilliSecond(), localk.oTm.toByteArray(), localk.oUv);
          bg.azz().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).rxM = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
        }
        AppMethodBeat.o(23162);
        return;
      case 2: 
        paramMessage = (k.b)paramMessage.obj;
        if ((paramMessage.rxH == 0) && (paramMessage.rxv == 0))
        {
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (w)paramMessage.rxI;
        Assert.assertNotNull(((w)localObject1).hhm);
        l = ((dtp)((w)localObject1).hhm.iLK.iLR).MVD.Mgq;
        localObject1 = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (localObject1 == null)
        {
          Log.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        localObject2 = ((k.e)localObject1).cKm();
        switch (paramMessage.rxv)
        {
        }
        for (int i = -1;; i = -5)
        {
          ((f)localObject2).b(i, paramMessage.lAr, null);
          paramMessage = new h(((k.e)localObject1).cKm());
          u.cLy().a(paramMessage);
          k.a(k.this).removeCallbacks(((k.e)localObject1).cKn());
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
        paramMessage.cKm().b(-1, "", null);
        paramMessage = new h(paramMessage.cKm());
        u.cLy().a(paramMessage);
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
      ((k.e)localObject1).rxK.b(0, "", paramMessage.mData);
      Object localObject2 = new h(((k.e)localObject1).cKm());
      u.cLy().a((ae)localObject2);
      k.a(k.this).removeCallbacks(((k.e)localObject1).cKn());
      k.c(k.this).remove(Long.valueOf(paramMessage.mSessionId));
      AppMethodBeat.o(23162);
    }
  }
  
  static final class b
  {
    public String lAr = null;
    public int rxH = 0;
    public q rxI = null;
    public int rxv = 0;
  }
  
  public static final class c
  {
    public byte[] mData = null;
    public long mSessionId = 0L;
  }
  
  final class d
    implements Runnable
  {
    private long rxJ;
    
    public d(long paramLong)
    {
      AppMethodBeat.i(23163);
      this.rxJ = -1L;
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.rxJ = paramLong;
        AppMethodBeat.o(23163);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(23164);
      Log.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.rxJ) });
      k.a(k.this).obtainMessage(0, Long.valueOf(this.rxJ)).sendToTarget();
      AppMethodBeat.o(23164);
    }
  }
  
  static final class e
  {
    f rxK = null;
    private k.d rxL = null;
    int rxM = 0;
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(23165);
      Assert.assertNotNull(paramf);
      this.rxK = paramf;
      AppMethodBeat.o(23165);
    }
    
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(23166);
      Assert.assertNotNull(paramd);
      this.rxL = paramd;
      AppMethodBeat.o(23166);
    }
    
    public final f cKm()
    {
      AppMethodBeat.i(23167);
      Assert.assertNotNull(this.rxK);
      f localf = this.rxK;
      AppMethodBeat.o(23167);
      return localf;
    }
    
    public final k.d cKn()
    {
      AppMethodBeat.i(23168);
      Assert.assertNotNull(this.rxL);
      k.d locald = this.rxL;
      AppMethodBeat.o(23168);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.k
 * JD-Core Version:    0.7.0.1
 */