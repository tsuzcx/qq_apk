package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.v;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz.a;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o
  implements c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    AppMethodBeat.i(18274);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18274);
      return;
      ab.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
      paramNotifyService = new p.b();
      paramNotifyService.deviceID = q.LK();
      paramArrayOfByte2 = new v(paramNotifyService, 10);
      try
      {
        if (paramArrayOfByte2.a(10, paramArrayOfByte1, null, 0L)) {
          aw.Rc().onSceneEnd(0, 0, "", new h(paramNotifyService));
        }
        AppMethodBeat.o(18274);
        return;
      }
      catch (RemoteException paramNotifyService)
      {
        ab.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
        AppMethodBeat.o(18274);
        return;
      }
      NotifyReceiver.NotifyService.kv("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      paramNotifyService = new tl();
      paramNotifyService.cJT.cJV = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
      paramNotifyService = paramNotifyService.cJU.cJX;
      if (!bo.isNullOrNil(paramNotifyService))
      {
        ab.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(paramNotifyService)));
        paramNotifyService = new tl();
        paramNotifyService.cJT.cJW = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        if (paramArrayOfByte1[0] == 1)
        {
          ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
          paramNotifyService = new ux();
          paramNotifyService.cLs.cut = 3;
          paramNotifyService.cLs.cLl = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
        }
        if (paramArrayOfByte1[0] == 101)
        {
          ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
          paramNotifyService = new it();
          paramNotifyService.cyj.cyk = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
        }
        if (paramArrayOfByte1[0] == 3)
        {
          ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
          paramNotifyService = new ux();
          paramNotifyService.cLs.cut = 9;
          paramNotifyService.cLs.cLl = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
        }
        if (paramArrayOfByte1[0] == 2)
        {
          ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new ux();
          paramNotifyService.cLs.cut = 10;
          paramNotifyService.cLs.cLl = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
        }
        if (paramArrayOfByte1[0] == 102)
        {
          ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new uu();
          paramNotifyService.cLk.cLl = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
          ab.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
          paramNotifyService = new ux();
          paramNotifyService.cLs.cut = 6;
          paramNotifyService.cLs.cLl = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
          ab.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
          AppMethodBeat.o(18274);
          return;
          paramNotifyService = new gh();
          paramNotifyService.cuV.cuW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.ymk.l(paramNotifyService);
          AppMethodBeat.o(18274);
          return;
          NotifyReceiver.NotifyService.kv("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
          if (!bo.ce(paramArrayOfByte1))
          {
            paramNotifyService = new String(paramArrayOfByte1);
            paramArrayOfByte1 = new ak();
            paramArrayOfByte1.cnA.type = 4;
            paramArrayOfByte1.cnA.cnC = paramNotifyService;
            com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte1);
            AppMethodBeat.o(18274);
            return;
            ab.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
            if (paramArrayOfByte1.length >= 8)
            {
              paramNotifyService = new byte[4];
              paramArrayOfByte2 = new byte[4];
              System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
              System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
              paramArrayOfByte1 = new kz();
              paramArrayOfByte1.cBg.cBh = com.tencent.mm.a.o.r(paramNotifyService, 0);
              paramArrayOfByte1.cBg.cBi = com.tencent.mm.a.o.r(paramArrayOfByte2, 0);
              ab.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.cBg.cBh), Integer.valueOf(paramArrayOfByte1.cBg.cBi) });
              com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte1);
            }
            AppMethodBeat.o(18274);
            return;
            Object localObject;
            if (paramArrayOfByte1 == null)
            {
              paramInt = -1;
              ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
              localObject = null;
              paramNotifyService = null;
              e.qrI.idkeyStat(403L, 38L, 1L, false);
              if (paramArrayOfByte1 != null) {
                paramNotifyService = new bym();
              }
            }
            for (;;)
            {
              try
              {
                paramNotifyService.parseFrom(paramArrayOfByte1);
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.xKN), Integer.valueOf(paramNotifyService.xKO), Integer.valueOf(paramNotifyService.xKP), Integer.valueOf(paramNotifyService.xKQ), Integer.valueOf(paramNotifyService.xKR), Integer.valueOf(paramNotifyService.xKS) });
                if (paramNotifyService.xKN == 13)
                {
                  g.RM();
                  paramArrayOfByte1 = g.RK().jN(3);
                  paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte1, paramNotifyService.wPX.pW);
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
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                if (paramNotifyService == null) {
                  break label1189;
                }
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
                paramArrayOfByte1 = new re();
                paramArrayOfByte1.cHK.data = paramNotifyService;
                com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte1);
                AppMethodBeat.o(18274);
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
              paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.xKN, paramNotifyService.xKO, paramNotifyService.xKP, paramNotifyService.xKQ, paramNotifyService.xKR, paramNotifyService.xKS, paramNotifyService.xKT, paramNotifyService.wPX.pW);
              continue;
              label1147:
              ab.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramArrayOfByte1.getMessage());
              e.qrI.idkeyStat(403L, 39L, 1L, false);
            }
            label1189:
            ab.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
            e.qrI.idkeyStat(403L, 40L, 1L, false);
            AppMethodBeat.o(18274);
            return;
            paramNotifyService = new cfx();
            try
            {
              paramNotifyService.parseFrom(paramArrayOfByte1);
              paramNotifyService = new com.tencent.mm.bm.a(paramNotifyService.xpR, paramNotifyService.xQC, paramNotifyService.xQD, paramNotifyService.xQE, paramNotifyService.xQF, paramNotifyService.xQH, paramNotifyService.xQG, paramNotifyService.xQz);
              g.RK().eHt.a(paramNotifyService, 0);
              AppMethodBeat.o(18274);
              return;
            }
            catch (Exception paramNotifyService)
            {
              ab.e("MicroMsg.NotifyReceiverCallbackImpl", "speed test parse data failed. e: " + paramNotifyService.getMessage());
              AppMethodBeat.o(18274);
              return;
            }
            ab.d("MicroMsg.NotifyReceiverCallbackImpl", "do disaster auth ");
            g.RK().eHt.a(new com.tencent.mm.modelsimple.b(), 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */