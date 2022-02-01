package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.am.y;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.ack;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.bb;
import com.tencent.mm.autogen.a.bc;
import com.tencent.mm.autogen.a.hr;
import com.tencent.mm.autogen.a.mt;
import com.tencent.mm.autogen.a.pt;
import com.tencent.mm.autogen.a.pt.a;
import com.tencent.mm.autogen.a.xs;
import com.tencent.mm.b.o;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bx.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fgw;
import com.tencent.mm.protocal.protobuf.ty;
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
            paramNotifyService.deviceID = com.tencent.mm.compatible.deviceinfo.q.aPg();
            paramArrayOfByte2 = new y(paramNotifyService, 10);
            try
            {
              if (paramArrayOfByte2.a(10, paramArrayOfByte1, null, 0L)) {
                bh.aZW().onSceneEnd(0, 0, "", new l(paramNotifyService));
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
            NotifyReceiver.NotifyService.Cl("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
            paramNotifyService = new aaq();
            paramNotifyService.ieg.iei = true;
            paramNotifyService.publish();
            paramNotifyService = paramNotifyService.ieh.iek;
            if (!Util.isNullOrNil(paramNotifyService))
            {
              Log.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(paramNotifyService)));
              paramNotifyService = new aaq();
              paramNotifyService.ieg.iej = true;
              paramNotifyService.publish();
            }
          } while ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0));
          if (paramArrayOfByte1[0] == 1)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
            paramNotifyService = new acn();
            paramNotifyService.ifU.hId = 3;
            paramNotifyService.ifU.ifP = paramArrayOfByte1;
            paramNotifyService.publish();
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 101)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
            paramNotifyService = new mt();
            paramNotifyService.hOT.hOU = paramArrayOfByte1;
            paramNotifyService.publish();
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 3)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
            paramNotifyService = new acn();
            paramNotifyService.ifU.hId = 9;
            paramNotifyService.ifU.ifP = paramArrayOfByte1;
            paramNotifyService.publish();
            AppMethodBeat.o(22380);
            return;
          }
          if (paramArrayOfByte1[0] == 2)
          {
            Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
            paramNotifyService = new acn();
            paramNotifyService.ifU.hId = 10;
            paramNotifyService.ifU.ifP = paramArrayOfByte1;
            paramNotifyService.publish();
            AppMethodBeat.o(22380);
            return;
          }
        } while (paramArrayOfByte1[0] != 102);
        Log.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
        paramNotifyService = new ack();
        paramNotifyService.ifO.ifP = paramArrayOfByte1;
        paramNotifyService.publish();
        AppMethodBeat.o(22380);
        return;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
        paramNotifyService = new acn();
        paramNotifyService.ifU.hId = 6;
        paramNotifyService.ifU.ifP = paramArrayOfByte1;
        paramNotifyService.publish();
        AppMethodBeat.o(22380);
        return;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
        AppMethodBeat.o(22380);
        return;
        paramNotifyService = new hr();
        paramNotifyService.hIM.hIN = paramArrayOfByte1;
        paramNotifyService.publish();
        AppMethodBeat.o(22380);
        return;
        NotifyReceiver.NotifyService.Cl("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      } while (Util.isNullOrNil(paramArrayOfByte1));
      paramNotifyService = new String(paramArrayOfByte1);
      paramArrayOfByte1 = new ay();
      paramArrayOfByte1.hAK.type = 4;
      paramArrayOfByte1.hAK.event = paramNotifyService;
      paramArrayOfByte1.publish();
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
        paramArrayOfByte1 = new pt();
        paramArrayOfByte1.hSV.hSW = o.t(paramNotifyService, 0);
        paramArrayOfByte1.hSV.hSX = o.t(paramArrayOfByte2, 0);
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.hSV.hSW), Integer.valueOf(paramArrayOfByte1.hSV.hSX) });
        paramArrayOfByte1.publish();
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
        paramNotifyService = new ty();
        try
        {
          paramNotifyService.parseFrom(paramArrayOfByte1);
          paramArrayOfByte1 = new bc();
          paramArrayOfByte1.hBb.hBc = paramNotifyService;
          paramArrayOfByte1.publish();
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
    case 320: 
      paramNotifyService = new bb();
      paramNotifyService.hAZ.hBa = 2L;
      paramNotifyService.hAZ.data = paramArrayOfByte1;
      paramNotifyService.publish();
      AppMethodBeat.o(22380);
      return;
    case 322: 
      paramNotifyService = new bb();
      paramNotifyService.hAZ.hBa = 4L;
      paramNotifyService.hAZ.data = paramArrayOfByte1;
      paramNotifyService.publish();
      AppMethodBeat.o(22380);
      return;
    case 318: 
      Object localObject;
      if (paramArrayOfByte1 == null)
      {
        paramInt = -1;
        Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
        localObject = null;
        paramNotifyService = null;
        f.Ozc.idkeyStat(403L, 38L, 1L, false);
        if (paramArrayOfByte1 != null) {
          paramNotifyService = new ewr();
        }
      }
      for (;;)
      {
        try
        {
          paramNotifyService.parseFrom(paramArrayOfByte1);
          Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.YCs), Integer.valueOf(paramNotifyService.YCt), Integer.valueOf(paramNotifyService.YCu), Integer.valueOf(paramNotifyService.YCv), Integer.valueOf(paramNotifyService.YCw), Integer.valueOf(paramNotifyService.YCx) });
          if (paramNotifyService.YCs == 13)
          {
            h.baF();
            paramArrayOfByte1 = h.baD().sA(3);
            paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte1, paramNotifyService.Zsu.Op);
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
            break label1379;
          }
          Log.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
          paramArrayOfByte1 = new xs();
          paramArrayOfByte1.ibg.data = paramNotifyService;
          paramArrayOfByte1.publish();
          AppMethodBeat.o(22380);
          return;
        }
        catch (Exception paramArrayOfByte1)
        {
          boolean bool;
          break label1337;
        }
        paramInt = paramArrayOfByte1.length;
        break;
        paramInt = paramArrayOfByte1.length;
        continue;
        i = paramNotifyService.length;
        continue;
        paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.YCs, paramNotifyService.YCt, paramNotifyService.YCu, paramNotifyService.YCv, paramNotifyService.YCw, paramNotifyService.YCx, paramNotifyService.YCy, paramNotifyService.Zsu.Op);
        continue;
        Log.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramArrayOfByte1.getMessage());
        f.Ozc.idkeyStat(403L, 39L, 1L, false);
      }
      Log.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
      f.Ozc.idkeyStat(403L, 40L, 1L, false);
      AppMethodBeat.o(22380);
      return;
    case 271: 
      paramNotifyService = new fgw();
      try
      {
        paramNotifyService.parseFrom(paramArrayOfByte1);
        paramNotifyService = new com.tencent.mm.bi.a(paramNotifyService.aaPP, paramNotifyService.abHf, paramNotifyService.abHg, paramNotifyService.abHh, paramNotifyService.abHi, paramNotifyService.abHk, paramNotifyService.abHj, paramNotifyService.abHc);
        h.baD().mCm.a(paramNotifyService, 0);
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
      h.baD().mCm.a(new e(), 0);
      AppMethodBeat.o(22380);
      return;
    case 6238: 
      label1337:
      label1379:
      Log.i("MicroMsg.NotifyReceiverCallbackImpl", "do netid request");
      if (!com.tencent.mm.bg.a.bQz())
      {
        h.baD().mCm.a(new com.tencent.mm.bg.a(), 0);
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
      com.tencent.mm.cn.a.Om(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.q
 * JD-Core Version:    0.7.0.1
 */