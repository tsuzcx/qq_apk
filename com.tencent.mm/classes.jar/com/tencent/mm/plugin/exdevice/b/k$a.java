package com.tencent.mm.plugin.exdevice.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import junit.framework.Assert;

final class k$a
  extends ak
{
  public k$a(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(19054);
    ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[] { Integer.valueOf(paramMessage.what) });
    long l;
    switch (paramMessage.what)
    {
    default: 
      ab.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[] { Integer.valueOf(paramMessage.what) });
      AppMethodBeat.o(19054);
      return;
    case 1: 
      localObject2 = (f)paramMessage.obj;
      if (!u.bqz().jp(((c)localObject2).jRn))
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).jRn) });
        ((f)localObject2).f(-2, "", new byte[0]);
        paramMessage = new h((f)localObject2);
        u.bqA().a(paramMessage);
        AppMethodBeat.o(19054);
        return;
      }
      if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
        ((f)localObject2).f(-1, "", new byte[0]);
        paramMessage = new h((f)localObject2);
        u.bqA().a(paramMessage);
        AppMethodBeat.o(19054);
        return;
      }
      com.tencent.mm.plugin.exdevice.h.b localb = ad.bpY().LH(((c)localObject2).jRn);
      if (localb == null)
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
        AppMethodBeat.o(19054);
        return;
      }
      l = localb.dCG;
      if (System.currentTimeMillis() / 1000L < l)
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
        ((f)localObject2).f(-5, "Device Is Block", null);
        paramMessage = new h((f)localObject2);
        u.bqA().a(paramMessage);
        AppMethodBeat.o(19054);
        return;
      }
      l = k.f.bpC();
      com.tencent.mm.plugin.exdevice.e.k localk = (com.tencent.mm.plugin.exdevice.e.k)((f)localObject2).bpx();
      if (localk == null)
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
        ((f)localObject2).f(-4, "Decode failed", null);
        paramMessage = new h((f)localObject2);
        u.bqA().a(paramMessage);
        AppMethodBeat.o(19054);
        return;
      }
      localObject1 = (Integer)k.b(this.lCD).get(localb.field_deviceID);
      paramMessage = (Message)localObject1;
      if (localObject1 == null) {
        paramMessage = Integer.valueOf(0);
      }
      ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[] { paramMessage });
      if (paramMessage.intValue() == 0)
      {
        if (localk.jKs == 10001)
        {
          ad.bqj();
          e.d(localb.field_deviceID, localb.field_brandName, localk.jJh.toByteArray());
          AppMethodBeat.o(19054);
          return;
        }
        paramMessage = new w(((c)localObject2).jRn, localb.field_deviceType, localb.field_deviceID, l, bo.aoy(), localk.jJh.toByteArray(), localk.jKs);
        aw.Rc().a(paramMessage, 0);
        paramMessage = new k.d(this.lCD, l);
        k.a(this.lCD).postDelayed(paramMessage, 30000L);
        localObject1 = new k.e((byte)0);
        ((k.e)localObject1).a((f)localObject2);
        ((k.e)localObject1).a(paramMessage);
        ((k.e)localObject1).lCJ = 0;
        k.c(this.lCD).put(Long.valueOf(l), localObject1);
        AppMethodBeat.o(19054);
        return;
      }
      if ((paramMessage.intValue() & 0x1) != 0)
      {
        ad.bqj();
        e.d(localb.field_deviceID, localb.field_brandName, localk.jJh.toByteArray());
      }
      if ((paramMessage.intValue() & 0x2) != 0)
      {
        paramMessage = new w(((c)localObject2).jRn, localb.field_deviceType, localb.field_deviceID, l, bo.aoy(), localk.jJh.toByteArray(), localk.jKs);
        aw.Rc().a(paramMessage, 0);
        paramMessage = new k.d(this.lCD, l);
        k.a(this.lCD).postDelayed(paramMessage, 30000L);
        localObject1 = new k.e((byte)0);
        ((k.e)localObject1).a((f)localObject2);
        ((k.e)localObject1).a(paramMessage);
        ((k.e)localObject1).lCJ = 0;
        k.c(this.lCD).put(Long.valueOf(l), localObject1);
      }
      AppMethodBeat.o(19054);
      return;
    case 2: 
      paramMessage = (k.b)paramMessage.obj;
      if ((paramMessage.lCE == 0) && (paramMessage.lCs == 0))
      {
        AppMethodBeat.o(19054);
        return;
      }
      localObject1 = (w)paramMessage.lCF;
      Assert.assertNotNull(((w)localObject1).lFp);
      l = ((byv)((w)localObject1).lFp.fsV.fta).xLc.xjA;
      localObject1 = (k.e)k.c(this.lCD).get(Long.valueOf(l));
      if (localObject1 == null)
      {
        ab.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(19054);
        return;
      }
      localObject2 = ((k.e)localObject1).bpA();
      switch (paramMessage.lCs)
      {
      }
      for (int i = -1;; i = -5)
      {
        ((f)localObject2).f(i, paramMessage.hyJ, null);
        paramMessage = new h(((k.e)localObject1).bpA());
        u.bqA().a(paramMessage);
        k.a(this.lCD).removeCallbacks(((k.e)localObject1).bpB());
        k.c(this.lCD).remove(Long.valueOf(l));
        AppMethodBeat.o(19054);
        return;
      }
    case 0: 
      l = ((Long)paramMessage.obj).longValue();
      paramMessage = (k.e)k.c(this.lCD).get(Long.valueOf(l));
      if (paramMessage == null)
      {
        ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[] { Long.valueOf(l) });
        AppMethodBeat.o(19054);
        return;
      }
      paramMessage.bpA().f(-1, "", null);
      paramMessage = new h(paramMessage.bpA());
      u.bqA().a(paramMessage);
      k.c(this.lCD).remove(Long.valueOf(l));
      AppMethodBeat.o(19054);
      return;
    }
    paramMessage = (k.c)paramMessage.obj;
    Object localObject1 = (k.e)k.c(this.lCD).get(Long.valueOf(paramMessage.mSessionId));
    if (localObject1 == null)
    {
      ab.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(paramMessage.mSessionId) });
      AppMethodBeat.o(19054);
      return;
    }
    ((k.e)localObject1).lCH.f(0, "", paramMessage.mData);
    Object localObject2 = new h(((k.e)localObject1).bpA());
    u.bqA().a((ae)localObject2);
    k.a(this.lCD).removeCallbacks(((k.e)localObject1).bpB());
    k.c(this.lCD).remove(Long.valueOf(paramMessage.mSessionId));
    AppMethodBeat.o(19054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k.a
 * JD-Core Version:    0.7.0.1
 */