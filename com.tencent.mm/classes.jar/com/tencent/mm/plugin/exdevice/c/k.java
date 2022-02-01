package com.tencent.mm.plugin.exdevice.c;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.j.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import junit.framework.Assert;

public final class k
  implements com.tencent.mm.al.f
{
  public static k qad = null;
  public ap mHandler;
  private final HashMap<Long, e> qac;
  public HashMap<String, Integer> qae;
  
  private k()
  {
    AppMethodBeat.i(23172);
    this.qac = new HashMap();
    this.mHandler = null;
    this.qae = new HashMap();
    this.mHandler = new a(ba.ajF().IdO.getLooper());
    AppMethodBeat.o(23172);
  }
  
  public static k ckT()
  {
    AppMethodBeat.i(23171);
    if (qad != null)
    {
      localk = qad;
      AppMethodBeat.o(23171);
      return localk;
    }
    k localk = new k();
    qad = localk;
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23174);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b localb = new b((byte)0);
    localb.pZU = paramInt2;
    localb.qag = paramInt1;
    localb.ksX = paramString;
    localb.qah = paramn;
    this.mHandler.obtainMessage(2, localb).sendToTarget();
    AppMethodBeat.o(23174);
  }
  
  final class a
    extends ap
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(23162);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[] { Integer.valueOf(paramMessage.what) });
      long l;
      switch (paramMessage.what)
      {
      default: 
        com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(23162);
        return;
      case 1: 
        localObject2 = (f)paramMessage.obj;
        if (!u.clU().uH(((c)localObject2).nTx))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).nTx) });
          ((f)localObject2).b(-2, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.clV().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
          ((f)localObject2).b(-1, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.clV().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.clt().acI(((c)localObject2).nTx);
        if (localb == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
          AppMethodBeat.o(23162);
          return;
        }
        l = localb.ffy;
        if (System.currentTimeMillis() / 1000L < l)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
          ((f)localObject2).b(-5, "Device Is Block", null);
          paramMessage = new h((f)localObject2);
          u.clV().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        l = k.f.ckW();
        com.tencent.mm.plugin.exdevice.f.k localk = (com.tencent.mm.plugin.exdevice.f.k)((f)localObject2).ckR();
        if (localk == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
          ((f)localObject2).b(-4, "Decode failed", null);
          paramMessage = new h((f)localObject2);
          u.clV().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (Integer)k.b(k.this).get(localb.field_deviceID);
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = Integer.valueOf(0);
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[] { paramMessage });
        if (paramMessage.intValue() == 0)
        {
          if (localk.nEf == 10001)
          {
            com.tencent.mm.plugin.exdevice.model.ad.clE();
            e.c(localb.field_deviceID, localb.field_brandName, localk.nCV.toByteArray());
            AppMethodBeat.o(23162);
            return;
          }
          paramMessage = new w(((c)localObject2).nTx, localb.field_deviceType, localb.field_deviceID, l, bt.flT(), localk.nCV.toByteArray(), localk.nEf);
          ba.aiU().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).qal = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
          AppMethodBeat.o(23162);
          return;
        }
        if ((paramMessage.intValue() & 0x1) != 0)
        {
          com.tencent.mm.plugin.exdevice.model.ad.clE();
          e.c(localb.field_deviceID, localb.field_brandName, localk.nCV.toByteArray());
        }
        if ((paramMessage.intValue() & 0x2) != 0)
        {
          paramMessage = new w(((c)localObject2).nTx, localb.field_deviceType, localb.field_deviceID, l, bt.flT(), localk.nCV.toByteArray(), localk.nEf);
          ba.aiU().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).qal = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
        }
        AppMethodBeat.o(23162);
        return;
      case 2: 
        paramMessage = (k.b)paramMessage.obj;
        if ((paramMessage.qag == 0) && (paramMessage.pZU == 0))
        {
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (w)paramMessage.qah;
        Assert.assertNotNull(((w)localObject1).grW);
        l = ((czr)((w)localObject1).grW.hNK.hNQ).Hqp.GHN;
        localObject1 = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (localObject1 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        localObject2 = ((k.e)localObject1).ckU();
        switch (paramMessage.pZU)
        {
        }
        for (int i = -1;; i = -5)
        {
          ((f)localObject2).b(i, paramMessage.ksX, null);
          paramMessage = new h(((k.e)localObject1).ckU());
          u.clV().a(paramMessage);
          k.a(k.this).removeCallbacks(((k.e)localObject1).ckV());
          k.c(k.this).remove(Long.valueOf(l));
          AppMethodBeat.o(23162);
          return;
        }
      case 0: 
        l = ((Long)paramMessage.obj).longValue();
        paramMessage = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (paramMessage == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        paramMessage.ckU().b(-1, "", null);
        paramMessage = new h(paramMessage.ckU());
        u.clV().a(paramMessage);
        k.c(k.this).remove(Long.valueOf(l));
        AppMethodBeat.o(23162);
        return;
      }
      paramMessage = (k.c)paramMessage.obj;
      Object localObject1 = (k.e)k.c(k.this).get(Long.valueOf(paramMessage.mSessionId));
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(paramMessage.mSessionId) });
        AppMethodBeat.o(23162);
        return;
      }
      ((k.e)localObject1).qaj.b(0, "", paramMessage.mData);
      Object localObject2 = new h(((k.e)localObject1).ckU());
      u.clV().a((ae)localObject2);
      k.a(k.this).removeCallbacks(((k.e)localObject1).ckV());
      k.c(k.this).remove(Long.valueOf(paramMessage.mSessionId));
      AppMethodBeat.o(23162);
    }
  }
  
  static final class b
  {
    public String ksX = null;
    public int pZU = 0;
    public int qag = 0;
    public n qah = null;
  }
  
  public static final class c
  {
    public byte[] mData = null;
    public long mSessionId = 0L;
  }
  
  final class d
    implements Runnable
  {
    private long qai;
    
    public d(long paramLong)
    {
      AppMethodBeat.i(23163);
      this.qai = -1L;
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.qai = paramLong;
        AppMethodBeat.o(23163);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(23164);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.qai) });
      k.a(k.this).obtainMessage(0, Long.valueOf(this.qai)).sendToTarget();
      AppMethodBeat.o(23164);
    }
  }
  
  static final class e
  {
    f qaj = null;
    private k.d qak = null;
    int qal = 0;
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(23165);
      Assert.assertNotNull(paramf);
      this.qaj = paramf;
      AppMethodBeat.o(23165);
    }
    
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(23166);
      Assert.assertNotNull(paramd);
      this.qak = paramd;
      AppMethodBeat.o(23166);
    }
    
    public final f ckU()
    {
      AppMethodBeat.i(23167);
      Assert.assertNotNull(this.qaj);
      f localf = this.qaj;
      AppMethodBeat.o(23167);
      return localf;
    }
    
    public final k.d ckV()
    {
      AppMethodBeat.i(23168);
      Assert.assertNotNull(this.qak);
      k.d locald = this.qak;
      AppMethodBeat.o(23168);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.k
 * JD-Core Version:    0.7.0.1
 */