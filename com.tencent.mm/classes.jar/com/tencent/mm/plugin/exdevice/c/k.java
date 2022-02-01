package com.tencent.mm.plugin.exdevice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.j.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import junit.framework.Assert;

public final class k
  implements g
{
  public static k pwy = null;
  public ao mHandler;
  private final HashMap<Long, e> pwx;
  public HashMap<String, Integer> pwz;
  
  private k()
  {
    AppMethodBeat.i(23172);
    this.pwx = new HashMap();
    this.mHandler = null;
    this.pwz = new HashMap();
    this.mHandler = new a(az.agU().GrZ.getLooper());
    AppMethodBeat.o(23172);
  }
  
  public static k cgp()
  {
    AppMethodBeat.i(23171);
    if (pwy != null)
    {
      localk = pwy;
      AppMethodBeat.o(23171);
      return localk;
    }
    k localk = new k();
    pwy = localk;
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
    ac.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "******onSceneEnd******\r\n errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    b localb = new b((byte)0);
    localb.pwp = paramInt2;
    localb.pwB = paramInt1;
    localb.jYB = paramString;
    localb.pwC = paramn;
    this.mHandler.obtainMessage(2, localb).sendToTarget();
    AppMethodBeat.o(23174);
  }
  
  final class a
    extends ao
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(23162);
      ac.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[] { Integer.valueOf(paramMessage.what) });
      long l;
      switch (paramMessage.what)
      {
      default: 
        ac.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[] { Integer.valueOf(paramMessage.what) });
        AppMethodBeat.o(23162);
        return;
      case 1: 
        localObject2 = (f)paramMessage.obj;
        if (!u.chq().sJ(((c)localObject2).nsB))
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).nsB) });
          ((f)localObject2).b(-2, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.chr().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
          ((f)localObject2).b(-1, "", new byte[0]);
          paramMessage = new h((f)localObject2);
          u.chr().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        com.tencent.mm.plugin.exdevice.i.b localb = ad.cgP().Zc(((c)localObject2).nsB);
        if (localb == null)
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
          AppMethodBeat.o(23162);
          return;
        }
        l = localb.eNc;
        if (System.currentTimeMillis() / 1000L < l)
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
          ((f)localObject2).b(-5, "Device Is Block", null);
          paramMessage = new h((f)localObject2);
          u.chr().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        l = k.f.cgs();
        com.tencent.mm.plugin.exdevice.f.k localk = (com.tencent.mm.plugin.exdevice.f.k)((f)localObject2).cgn();
        if (localk == null)
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
          ((f)localObject2).b(-4, "Decode failed", null);
          paramMessage = new h((f)localObject2);
          u.chr().a(paramMessage);
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (Integer)k.b(k.this).get(localb.field_deviceID);
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = Integer.valueOf(0);
        }
        ac.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[] { paramMessage });
        if (paramMessage.intValue() == 0)
        {
          if (localk.ndI == 10001)
          {
            ad.cha();
            e.c(localb.field_deviceID, localb.field_brandName, localk.ncy.toByteArray());
            AppMethodBeat.o(23162);
            return;
          }
          paramMessage = new w(((c)localObject2).nsB, localb.field_deviceType, localb.field_deviceID, l, bs.eWj(), localk.ncy.toByteArray(), localk.ndI);
          az.agi().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).pwG = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
          AppMethodBeat.o(23162);
          return;
        }
        if ((paramMessage.intValue() & 0x1) != 0)
        {
          ad.cha();
          e.c(localb.field_deviceID, localb.field_brandName, localk.ncy.toByteArray());
        }
        if ((paramMessage.intValue() & 0x2) != 0)
        {
          paramMessage = new w(((c)localObject2).nsB, localb.field_deviceType, localb.field_deviceID, l, bs.eWj(), localk.ncy.toByteArray(), localk.ndI);
          az.agi().a(paramMessage, 0);
          paramMessage = new k.d(k.this, l);
          k.a(k.this).postDelayed(paramMessage, 30000L);
          localObject1 = new k.e((byte)0);
          ((k.e)localObject1).a((f)localObject2);
          ((k.e)localObject1).a(paramMessage);
          ((k.e)localObject1).pwG = 0;
          k.c(k.this).put(Long.valueOf(l), localObject1);
        }
        AppMethodBeat.o(23162);
        return;
      case 2: 
        paramMessage = (k.b)paramMessage.obj;
        if ((paramMessage.pwB == 0) && (paramMessage.pwp == 0))
        {
          AppMethodBeat.o(23162);
          return;
        }
        localObject1 = (w)paramMessage.pwC;
        Assert.assertNotNull(((w)localObject1).fYA);
        l = ((cuh)((w)localObject1).fYA.hvr.hvw).FFQ.EYr;
        localObject1 = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (localObject1 == null)
        {
          ac.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        localObject2 = ((k.e)localObject1).cgq();
        switch (paramMessage.pwp)
        {
        }
        for (int i = -1;; i = -5)
        {
          ((f)localObject2).b(i, paramMessage.jYB, null);
          paramMessage = new h(((k.e)localObject1).cgq());
          u.chr().a(paramMessage);
          k.a(k.this).removeCallbacks(((k.e)localObject1).cgr());
          k.c(k.this).remove(Long.valueOf(l));
          AppMethodBeat.o(23162);
          return;
        }
      case 0: 
        l = ((Long)paramMessage.obj).longValue();
        paramMessage = (k.e)k.c(k.this).get(Long.valueOf(l));
        if (paramMessage == null)
        {
          ac.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(23162);
          return;
        }
        paramMessage.cgq().b(-1, "", null);
        paramMessage = new h(paramMessage.cgq());
        u.chr().a(paramMessage);
        k.c(k.this).remove(Long.valueOf(l));
        AppMethodBeat.o(23162);
        return;
      }
      paramMessage = (k.c)paramMessage.obj;
      Object localObject1 = (k.e)k.c(k.this).get(Long.valueOf(paramMessage.mSessionId));
      if (localObject1 == null)
      {
        ac.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(paramMessage.mSessionId) });
        AppMethodBeat.o(23162);
        return;
      }
      ((k.e)localObject1).pwE.b(0, "", paramMessage.mData);
      Object localObject2 = new h(((k.e)localObject1).cgq());
      u.chr().a((ae)localObject2);
      k.a(k.this).removeCallbacks(((k.e)localObject1).cgr());
      k.c(k.this).remove(Long.valueOf(paramMessage.mSessionId));
      AppMethodBeat.o(23162);
    }
  }
  
  static final class b
  {
    public String jYB = null;
    public int pwB = 0;
    public n pwC = null;
    public int pwp = 0;
  }
  
  public static final class c
  {
    public byte[] mData = null;
    public long mSessionId = 0L;
  }
  
  final class d
    implements Runnable
  {
    private long pwD;
    
    public d(long paramLong)
    {
      AppMethodBeat.i(23163);
      this.pwD = -1L;
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        this.pwD = paramLong;
        AppMethodBeat.o(23163);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(23164);
      ac.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.pwD) });
      k.a(k.this).obtainMessage(0, Long.valueOf(this.pwD)).sendToTarget();
      AppMethodBeat.o(23164);
    }
  }
  
  static final class e
  {
    f pwE = null;
    private k.d pwF = null;
    int pwG = 0;
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(23165);
      Assert.assertNotNull(paramf);
      this.pwE = paramf;
      AppMethodBeat.o(23165);
    }
    
    public final void a(k.d paramd)
    {
      AppMethodBeat.i(23166);
      Assert.assertNotNull(paramd);
      this.pwF = paramd;
      AppMethodBeat.o(23166);
    }
    
    public final f cgq()
    {
      AppMethodBeat.i(23167);
      Assert.assertNotNull(this.pwE);
      f localf = this.pwE;
      AppMethodBeat.o(23167);
      return localf;
    }
    
    public final k.d cgr()
    {
      AppMethodBeat.i(23168);
      Assert.assertNotNull(this.pwF);
      k.d locald = this.pwF;
      AppMethodBeat.o(23168);
      return locald;
    }
  }
  
  public static final class f
  {
    private static f pwI = null;
    private long pwH;
    
    public f()
    {
      AppMethodBeat.i(23169);
      SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("exdevice_pref", 0);
      if (localSharedPreferences != null)
      {
        l = localSharedPreferences.getLong("local_message_seq", 0L);
        ac.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
      }
      this.pwH = l;
      AppMethodBeat.o(23169);
    }
    
    public static long cgs()
    {
      AppMethodBeat.i(23170);
      if (pwI == null) {
        pwI = new f();
      }
      Object localObject = pwI;
      if (9223372036854775807L == ((f)localObject).pwH)
      {
        ac.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
        ((f)localObject).pwH = 0L;
      }
      long l = ((f)localObject).pwH + 1L;
      ((f)localObject).pwH = l;
      localObject = ai.getContext().getSharedPreferences("exdevice_pref", 0);
      if (localObject != null)
      {
        ac.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
        ((SharedPreferences)localObject).edit().putLong("local_message_seq", l).commit();
      }
      AppMethodBeat.o(23170);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.k
 * JD-Core Version:    0.7.0.1
 */