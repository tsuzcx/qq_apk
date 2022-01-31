package com.tencent.mm.plugin.exdevice.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.i.h;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import junit.framework.Assert;

final class k$a
  extends ah
{
  public k$a(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    y.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "handleMessage msg.what = %d", new Object[] { Integer.valueOf(paramMessage.what) });
    long l;
    switch (paramMessage.what)
    {
    default: 
      y.f("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "unknown message type = %d", new Object[] { Integer.valueOf(paramMessage.what) });
    case 1: 
    case 2: 
      do
      {
        com.tencent.mm.plugin.exdevice.h.b localb;
        com.tencent.mm.plugin.exdevice.e.k localk;
        do
        {
          return;
          localObject2 = (f)paramMessage.obj;
          if (!u.aMm().dX(((c)localObject2).hXu))
          {
            y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "This device send other cmd before do auth, device id = %d", new Object[] { Long.valueOf(((c)localObject2).hXu) });
            ((f)localObject2).e(-2, "", new byte[0]);
            paramMessage = new h((f)localObject2);
            u.aMn().a(paramMessage);
            return;
          }
          if ((-5 == paramMessage.arg1) || (-3 == paramMessage.arg1) || (-4 == paramMessage.arg1))
          {
            y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Error Code = %d, reply errorcode to device and close channel", new Object[] { Integer.valueOf(paramMessage.arg1) });
            ((f)localObject2).e(-1, "", new byte[0]);
            paramMessage = new h((f)localObject2);
            u.aMn().a(paramMessage);
            return;
          }
          localb = ad.aLL().BF(((c)localObject2).hXu);
          if (localb == null)
          {
            y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
          }
          l = localb.cMQ;
          if (System.currentTimeMillis() / 1000L < l)
          {
            y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "device has been blocked");
            ((f)localObject2).e(-5, "Device Is Block", null);
            paramMessage = new h((f)localObject2);
            u.aMn().a(paramMessage);
            return;
          }
          l = k.f.aLp();
          localk = (com.tencent.mm.plugin.exdevice.e.k)((f)localObject2).aLk();
          if (localk == null)
          {
            y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataToManufacturerSvr Request parse failed!!!, Tell device before stop this task");
            ((f)localObject2).e(-4, "Decode failed", null);
            paramMessage = new h((f)localObject2);
            u.aMn().a(paramMessage);
            return;
          }
          localObject1 = (Integer)k.b(this.jte).get(localb.field_deviceID);
          paramMessage = (Message)localObject1;
          if (localObject1 == null) {
            paramMessage = Integer.valueOf(0);
          }
          y.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "SendDataDirection = %s", new Object[] { paramMessage });
          if (paramMessage.intValue() == 0)
          {
            if (localk.hQR == 10001)
            {
              ad.aLW();
              e.d(localb.field_deviceID, localb.field_brandName, localk.hPF.toByteArray());
              return;
            }
            paramMessage = new w(((c)localObject2).hXu, localb.field_deviceType, localb.field_deviceID, l, bk.UY(), localk.hPF.toByteArray(), localk.hQR);
            au.Dk().a(paramMessage, 0);
            paramMessage = new k.d(this.jte, l);
            k.a(this.jte).postDelayed(paramMessage, 30000L);
            localObject1 = new k.e((byte)0);
            ((k.e)localObject1).a((f)localObject2);
            ((k.e)localObject1).a(paramMessage);
            ((k.e)localObject1).jtk = 0;
            k.c(this.jte).put(Long.valueOf(l), localObject1);
            return;
          }
          if ((paramMessage.intValue() & 0x1) != 0)
          {
            ad.aLW();
            e.d(localb.field_deviceID, localb.field_brandName, localk.hPF.toByteArray());
          }
        } while ((paramMessage.intValue() & 0x2) == 0);
        paramMessage = new w(((c)localObject2).hXu, localb.field_deviceType, localb.field_deviceID, l, bk.UY(), localk.hPF.toByteArray(), localk.hQR);
        au.Dk().a(paramMessage, 0);
        paramMessage = new k.d(this.jte, l);
        k.a(this.jte).postDelayed(paramMessage, 30000L);
        localObject1 = new k.e((byte)0);
        ((k.e)localObject1).a((f)localObject2);
        ((k.e)localObject1).a(paramMessage);
        ((k.e)localObject1).jtk = 0;
        k.c(this.jte).put(Long.valueOf(l), localObject1);
        return;
        paramMessage = (k.b)paramMessage.obj;
      } while ((paramMessage.jtf == 0) && (paramMessage.jsT == 0));
      localObject1 = (w)paramMessage.jtg;
      Assert.assertNotNull(((w)localObject1).jvQ);
      l = ((boy)((w)localObject1).jvQ.ecE.ecN).tHf.tkJ;
      localObject1 = (k.e)k.c(this.jte).get(Long.valueOf(l));
      if (localObject1 == null)
      {
        y.e("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(l) });
        return;
      }
      localObject2 = ((k.e)localObject1).aLn();
      switch (paramMessage.jsT)
      {
      }
      for (int i = -1;; i = -5)
      {
        ((f)localObject2).e(i, paramMessage.ghs, null);
        paramMessage = new h(((k.e)localObject1).aLn());
        u.aMn().a(paramMessage);
        k.a(this.jte).removeCallbacks(((k.e)localObject1).aLo());
        k.c(this.jte).remove(Long.valueOf(l));
        return;
      }
    case 0: 
      l = ((Long)paramMessage.obj).longValue();
      paramMessage = (k.e)k.c(this.jte).get(Long.valueOf(l));
      if (paramMessage == null)
      {
        y.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId(%d), or response has been send", new Object[] { Long.valueOf(l) });
        return;
      }
      paramMessage.aLn().e(-1, "", null);
      paramMessage = new h(paramMessage.aLn());
      u.aMn().a(paramMessage);
      k.c(this.jte).remove(Long.valueOf(l));
      return;
    }
    paramMessage = (k.c)paramMessage.obj;
    Object localObject1 = (k.e)k.c(this.jte).get(Long.valueOf(paramMessage.mSessionId));
    if (localObject1 == null)
    {
      y.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Cannot find SendDataToManufacturerCmdContext in the map by SessionId = %d", new Object[] { Long.valueOf(paramMessage.mSessionId) });
      return;
    }
    ((k.e)localObject1).jti.e(0, "", paramMessage.mData);
    Object localObject2 = new h(((k.e)localObject1).aLn());
    u.aMn().a((ae)localObject2);
    k.a(this.jte).removeCallbacks(((k.e)localObject1).aLo());
    k.c(this.jte).remove(Long.valueOf(paramMessage.mSessionId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k.a
 * JD-Core Version:    0.7.0.1
 */