package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.w;
import com.tencent.mm.b.o;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.me.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class p
  implements c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(22380);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22380);
      return;
      ad.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
      paramNotifyService = new p.b();
      paramNotifyService.deviceID = com.tencent.mm.compatible.deviceinfo.q.Xa();
      paramArrayOfByte2 = new w(paramNotifyService, 10);
      try
      {
        if (paramArrayOfByte2.a(10, paramArrayOfByte1, null, 0L)) {
          az.aeS().onSceneEnd(0, 0, "", new i(paramNotifyService));
        }
        AppMethodBeat.o(22380);
        return;
      }
      catch (RemoteException paramNotifyService)
      {
        ad.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
        AppMethodBeat.o(22380);
        return;
      }
      NotifyReceiver.NotifyService.om("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      paramNotifyService = new vj();
      paramNotifyService.dAP.dAR = true;
      com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
      paramNotifyService = paramNotifyService.dAQ.dAT;
      if (!bt.isNullOrNil(paramNotifyService))
      {
        ad.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(paramNotifyService)));
        paramNotifyService = new vj();
        paramNotifyService.dAP.dAS = true;
        com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        if (paramArrayOfByte1[0] == 1)
        {
          ad.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
          paramNotifyService = new ww();
          paramNotifyService.dCp.djq = 3;
          paramNotifyService.dCp.dCi = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 101)
        {
          ad.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
          paramNotifyService = new jr();
          paramNotifyService.dnR.dnS = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 3)
        {
          ad.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
          paramNotifyService = new ww();
          paramNotifyService.dCp.djq = 9;
          paramNotifyService.dCp.dCi = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 2)
        {
          ad.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new ww();
          paramNotifyService.dCp.djq = 10;
          paramNotifyService.dCp.dCi = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 102)
        {
          ad.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new wt();
          paramNotifyService.dCh.dCi = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          ad.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
          paramNotifyService = new ww();
          paramNotifyService.dCp.djq = 6;
          paramNotifyService.dCp.dCi = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          ad.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
          AppMethodBeat.o(22380);
          return;
          paramNotifyService = new gq();
          paramNotifyService.djX.djY = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          NotifyReceiver.NotifyService.om("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
          if (!bt.cw(paramArrayOfByte1))
          {
            paramNotifyService = new String(paramArrayOfByte1);
            paramArrayOfByte1 = new ao();
            paramArrayOfByte1.dcv.type = 4;
            paramArrayOfByte1.dcv.dcx = paramNotifyService;
            com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte1);
            AppMethodBeat.o(22380);
            return;
            ad.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
            if (paramArrayOfByte1.length >= 8)
            {
              paramNotifyService = new byte[4];
              paramArrayOfByte2 = new byte[4];
              System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
              System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
              paramArrayOfByte1 = new me();
              paramArrayOfByte1.drp.drq = o.v(paramNotifyService, 0);
              paramArrayOfByte1.drp.drr = o.v(paramArrayOfByte2, 0);
              ad.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.drp.drq), Integer.valueOf(paramArrayOfByte1.drp.drr) });
              com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte1);
            }
            AppMethodBeat.o(22380);
            return;
            Object localObject;
            if (paramArrayOfByte1 == null)
            {
              paramInt = -1;
              ad.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
              localObject = null;
              paramNotifyService = null;
              e.vIY.idkeyStat(403L, 38L, 1L, false);
              if (paramArrayOfByte1 != null) {
                paramNotifyService = new cop();
              }
            }
            for (;;)
            {
              try
              {
                paramNotifyService.parseFrom(paramArrayOfByte1);
                ad.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.Eiz), Integer.valueOf(paramNotifyService.EiA), Integer.valueOf(paramNotifyService.EiB), Integer.valueOf(paramNotifyService.EiC), Integer.valueOf(paramNotifyService.EiD), Integer.valueOf(paramNotifyService.EiE) });
                if (paramNotifyService.Eiz == 13)
                {
                  g.afC();
                  paramArrayOfByte1 = g.afA().mq(3);
                  paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte1, paramNotifyService.DcU.wA);
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
                ad.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                if (paramNotifyService == null) {
                  break label1189;
                }
                ad.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
                paramArrayOfByte1 = new sx();
                paramArrayOfByte1.dyz.data = paramNotifyService;
                com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte1);
                AppMethodBeat.o(22380);
                return;
              }
              catch (Exception paramArrayOfByte1)
              {
                break label1147;
              }
              paramInt = paramArrayOfByte1.length;
              break;
              paramInt = paramArrayOfByte1.length;
              continue;
              i = paramNotifyService.length;
              continue;
              paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.Eiz, paramNotifyService.EiA, paramNotifyService.EiB, paramNotifyService.EiC, paramNotifyService.EiD, paramNotifyService.EiE, paramNotifyService.EiF, paramNotifyService.DcU.wA);
              continue;
              label1147:
              ad.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramArrayOfByte1.getMessage());
              e.vIY.idkeyStat(403L, 39L, 1L, false);
            }
            label1189:
            ad.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
            e.vIY.idkeyStat(403L, 40L, 1L, false);
            AppMethodBeat.o(22380);
            return;
            paramNotifyService = new cwx();
            try
            {
              paramNotifyService.parseFrom(paramArrayOfByte1);
              paramNotifyService = new com.tencent.mm.bo.a(paramNotifyService.DKa, paramNotifyService.EoX, paramNotifyService.EoY, paramNotifyService.EoZ, paramNotifyService.Epa, paramNotifyService.Epc, paramNotifyService.Epb, paramNotifyService.EoU);
              g.afA().gcy.a(paramNotifyService, 0);
              AppMethodBeat.o(22380);
              return;
            }
            catch (Exception paramNotifyService)
            {
              ad.e("MicroMsg.NotifyReceiverCallbackImpl", "speed test parse data failed. e: " + paramNotifyService.getMessage());
              AppMethodBeat.o(22380);
              return;
            }
            ad.d("MicroMsg.NotifyReceiverCallbackImpl", "do disaster auth ");
            g.afA().gcy.a(new com.tencent.mm.modelsimple.b(), 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */