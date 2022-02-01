package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.an.z;
import com.tencent.mm.b.o;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.aan;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.aw;
import com.tencent.mm.f.a.hg;
import com.tencent.mm.f.a.lo;
import com.tencent.mm.f.a.ok;
import com.tencent.mm.f.a.ok.a;
import com.tencent.mm.f.a.wb;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.emc;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
  implements com.tencent.mm.plugin.zero.a.c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(22380);
    switch (paramInt)
    {
    default: 
    case 10: 
    case 120: 
    case 174: 
    case 102: 
    case 192: 
    case 268369923: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(22380);
            return;
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
            paramNotifyService = new p.b();
            paramNotifyService.deviceID = com.tencent.mm.compatible.deviceinfo.q.auM();
            paramArrayOfByte2 = new z(paramNotifyService, 10);
            try
            {
              if (paramArrayOfByte2.a(10, paramArrayOfByte1, null, 0L)) {
                bh.aGY().onSceneEnd(0, 0, "", new j(paramNotifyService));
              }
              AppMethodBeat.o(22380);
              return;
            }
            catch (RemoteException paramNotifyService)
            {
              Log.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
              AppMethodBeat.o(22380);
              return;
            }
            NotifyReceiver.NotifyService.JF("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
            paramNotifyService = new yx();
            paramNotifyService.fYg.fYi = true;
            EventCenter.instance.publish(paramNotifyService);
            paramNotifyService = paramNotifyService.fYh.fYk;
            if (!Util.isNullOrNil(paramNotifyService))
            {
              Log.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(paramNotifyService)));
              paramNotifyService = new yx();
              paramNotifyService.fYg.fYj = true;
              EventCenter.instance.publish(paramNotifyService);
            }
          } while ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0));
          if (paramArrayOfByte1[0] == 1)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
            paramNotifyService = new aaq();
            paramNotifyService.fZM.fDn = 3;
            paramNotifyService.fZM.fZH = paramArrayOfByte1;
            EventCenter.instance.publish(paramNotifyService);
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 101)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
            paramNotifyService = new lo();
            paramNotifyService.fJq.fJr = paramArrayOfByte1;
            EventCenter.instance.publish(paramNotifyService);
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 3)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
            paramNotifyService = new aaq();
            paramNotifyService.fZM.fDn = 9;
            paramNotifyService.fZM.fZH = paramArrayOfByte1;
            EventCenter.instance.publish(paramNotifyService);
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 2)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
            paramNotifyService = new aaq();
            paramNotifyService.fZM.fDn = 10;
            paramNotifyService.fZM.fZH = paramArrayOfByte1;
            EventCenter.instance.publish(paramNotifyService);
            AppMethodBeat.o(22380);
            return;
          }
        } while (paramArrayOfByte1[0] != 102);
        Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
        paramNotifyService = new aan();
        paramNotifyService.fZG.fZH = paramArrayOfByte1;
        EventCenter.instance.publish(paramNotifyService);
        AppMethodBeat.o(22380);
        return;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
        paramNotifyService = new aaq();
        paramNotifyService.fZM.fDn = 6;
        paramNotifyService.fZM.fZH = paramArrayOfByte1;
        EventCenter.instance.publish(paramNotifyService);
        AppMethodBeat.o(22380);
        return;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
        AppMethodBeat.o(22380);
        return;
        paramNotifyService = new hg();
        paramNotifyService.fDW.fDX = paramArrayOfByte1;
        EventCenter.instance.publish(paramNotifyService);
        AppMethodBeat.o(22380);
        return;
        NotifyReceiver.NotifyService.JF("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      } while (Util.isNullOrNil(paramArrayOfByte1));
      paramNotifyService = new String(paramArrayOfByte1);
      paramArrayOfByte1 = new at();
      paramArrayOfByte1.fwm.type = 4;
      paramArrayOfByte1.fwm.event = paramNotifyService;
      EventCenter.instance.publish(paramArrayOfByte1);
      AppMethodBeat.o(22380);
      return;
    case 241: 
      Log.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
      if (paramArrayOfByte1.length >= 8)
      {
        paramNotifyService = new byte[4];
        paramArrayOfByte2 = new byte[4];
        System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
        System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
        paramArrayOfByte1 = new ok();
        paramArrayOfByte1.fNj.fNk = o.v(paramNotifyService, 0);
        paramArrayOfByte1.fNj.fNl = o.v(paramArrayOfByte2, 0);
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.fNj.fNk), Integer.valueOf(paramArrayOfByte1.fNj.fNl) });
        EventCenter.instance.publish(paramArrayOfByte1);
      }
      AppMethodBeat.o(22380);
      return;
    case 319: 
      if (paramArrayOfByte1 == null) {}
      for (paramInt = -1;; paramInt = paramArrayOfByte1.length)
      {
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_BYP_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
        if (paramArrayOfByte1 == null) {
          break;
        }
        paramNotifyService = new si();
        try
        {
          paramNotifyService.parseFrom(paramArrayOfByte1);
          paramArrayOfByte1 = new aw();
          paramArrayOfByte1.fwB.fwC = paramNotifyService;
          EventCenter.instance.publish(paramArrayOfByte1);
          AppMethodBeat.o(22380);
          return;
        }
        catch (Exception paramNotifyService)
        {
          Log.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_BYP_NOTIFY secureData parseFrom e: " + paramNotifyService.getMessage());
          AppMethodBeat.o(22380);
          return;
        }
      }
    case 318: 
      Object localObject;
      if (paramArrayOfByte1 == null)
      {
        paramInt = -1;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
        paramNotifyService = null;
        f.Iyx.idkeyStat(403L, 38L, 1L, false);
        if (paramArrayOfByte1 != null) {
          paramNotifyService = new edc();
        }
      }
      for (;;)
      {
        try
        {
          paramNotifyService.parseFrom(paramArrayOfByte1);
          Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.Uhy), Integer.valueOf(paramNotifyService.Uhz), Integer.valueOf(paramNotifyService.UhA), Integer.valueOf(paramNotifyService.UhB), Integer.valueOf(paramNotifyService.UhC), Integer.valueOf(paramNotifyService.UhD) });
          if (paramNotifyService.Uhy == 13)
          {
            h.aHH();
            paramArrayOfByte1 = h.aHF().sE(3);
            paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte1, paramNotifyService.Sth.UH);
            if (paramArrayOfByte1 == null)
            {
              paramInt = -1;
              if (paramNotifyService != null) {
                continue;
              }
              i = -1;
            }
          }
        }
        catch (Exception paramArrayOfByte1)
        {
          int i;
          paramNotifyService = localObject;
        }
        try
        {
          Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
          if (paramNotifyService == null) {
            break label1326;
          }
          Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
          paramArrayOfByte1 = new wb();
          paramArrayOfByte1.fVj.data = paramNotifyService;
          EventCenter.instance.publish(paramArrayOfByte1);
          AppMethodBeat.o(22380);
          return;
        }
        catch (Exception paramArrayOfByte1)
        {
          boolean bool;
          break label1284;
        }
        paramInt = paramArrayOfByte1.length;
        break;
        paramInt = paramArrayOfByte1.length;
        continue;
        i = paramNotifyService.length;
        continue;
        paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.Uhy, paramNotifyService.Uhz, paramNotifyService.UhA, paramNotifyService.UhB, paramNotifyService.UhC, paramNotifyService.UhD, paramNotifyService.UhE, paramNotifyService.Sth.UH);
        continue;
        Log.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramArrayOfByte1.getMessage());
        f.Iyx.idkeyStat(403L, 39L, 1L, false);
      }
      Log.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
      f.Iyx.idkeyStat(403L, 40L, 1L, false);
      AppMethodBeat.o(22380);
      return;
    case 271: 
      paramNotifyService = new emc();
      try
      {
        paramNotifyService.parseFrom(paramArrayOfByte1);
        paramNotifyService = new com.tencent.mm.bq.a(paramNotifyService.TAB, paramNotifyService.UoB, paramNotifyService.UoC, paramNotifyService.UoD, paramNotifyService.UoE, paramNotifyService.UoG, paramNotifyService.UoF, paramNotifyService.Uoy);
        h.aHF().kcd.a(paramNotifyService, 0);
        AppMethodBeat.o(22380);
        return;
      }
      catch (Exception paramNotifyService)
      {
        Log.e("MicroMsg.NotifyReceiverCallbackImpl", "speed test parse data failed. e: " + paramNotifyService.getMessage());
        AppMethodBeat.o(22380);
        return;
      }
    case 3941: 
      Log.d("MicroMsg.NotifyReceiverCallbackImpl", "do disaster auth ");
      h.aHF().kcd.a(new com.tencent.mm.modelsimple.c(), 0);
      AppMethodBeat.o(22380);
      return;
    case 6238: 
      label1284:
      label1326:
      Log.i("MicroMsg.NotifyReceiverCallbackImpl", "do netid request");
      if (!com.tencent.mm.bo.a.bsQ())
      {
        h.aHF().kcd.a(new com.tencent.mm.bo.a(), 0);
        AppMethodBeat.o(22380);
        return;
      }
      Log.w("MicroMsg.NotifyReceiverCallbackImpl", "netid is requesting ,wait a minute");
      AppMethodBeat.o(22380);
      return;
    }
    Log.d("MicroMsg.NotifyReceiverCallbackImpl", "receive weaknet notify " + paramArrayOfByte1[0]);
    if (paramArrayOfByte1[0] == 1) {}
    for (bool = true;; bool = false)
    {
      com.tencent.mm.cu.a.Il(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.q
 * JD-Core Version:    0.7.0.1
 */