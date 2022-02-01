package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.w;
import com.tencent.mm.b.o;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mn.a;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

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
      ac.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
      paramNotifyService = new p.b();
      paramNotifyService.deviceID = com.tencent.mm.compatible.deviceinfo.q.XX();
      paramArrayOfByte2 = new w(paramNotifyService, 10);
      try
      {
        if (paramArrayOfByte2.a(10, paramArrayOfByte1, null, 0L)) {
          az.agi().onSceneEnd(0, 0, "", new i(paramNotifyService));
        }
        AppMethodBeat.o(22380);
        return;
      }
      catch (RemoteException paramNotifyService)
      {
        ac.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
        AppMethodBeat.o(22380);
        return;
      }
      NotifyReceiver.NotifyService.rs("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      paramNotifyService = new vt();
      paramNotifyService.dyB.dyD = true;
      com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
      paramNotifyService = paramNotifyService.dyC.dyF;
      if (!bs.isNullOrNil(paramNotifyService))
      {
        ac.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(paramNotifyService)));
        paramNotifyService = new vt();
        paramNotifyService.dyB.dyE = true;
        com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        if (paramArrayOfByte1[0] == 1)
        {
          ac.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
          paramNotifyService = new xh();
          paramNotifyService.dAb.dgL = 3;
          paramNotifyService.dAb.dzW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 101)
        {
          ac.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
          paramNotifyService = new jz();
          paramNotifyService.dlA.dlB = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 3)
        {
          ac.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
          paramNotifyService = new xh();
          paramNotifyService.dAb.dgL = 9;
          paramNotifyService.dAb.dzW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 2)
        {
          ac.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new xh();
          paramNotifyService.dAb.dgL = 10;
          paramNotifyService.dAb.dzW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
        }
        if (paramArrayOfByte1[0] == 102)
        {
          ac.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new xe();
          paramNotifyService.dzV.dzW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          ac.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
          paramNotifyService = new xh();
          paramNotifyService.dAb.dgL = 6;
          paramNotifyService.dAb.dzW = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          ac.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
          AppMethodBeat.o(22380);
          return;
          paramNotifyService = new gr();
          paramNotifyService.dhs.dht = paramArrayOfByte1;
          com.tencent.mm.sdk.b.a.GpY.l(paramNotifyService);
          AppMethodBeat.o(22380);
          return;
          NotifyReceiver.NotifyService.rs("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
          if (!bs.cv(paramArrayOfByte1))
          {
            paramNotifyService = new String(paramArrayOfByte1);
            paramArrayOfByte1 = new ap();
            paramArrayOfByte1.cZT.type = 4;
            paramArrayOfByte1.cZT.cZV = paramNotifyService;
            com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte1);
            AppMethodBeat.o(22380);
            return;
            ac.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
            if (paramArrayOfByte1.length >= 8)
            {
              paramNotifyService = new byte[4];
              paramArrayOfByte2 = new byte[4];
              System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
              System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
              paramArrayOfByte1 = new mn();
              paramArrayOfByte1.dpa.dpb = o.t(paramNotifyService, 0);
              paramArrayOfByte1.dpa.dpc = o.t(paramArrayOfByte2, 0);
              ac.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.dpa.dpb), Integer.valueOf(paramArrayOfByte1.dpa.dpc) });
              com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte1);
            }
            AppMethodBeat.o(22380);
            return;
            Object localObject;
            if (paramArrayOfByte1 == null)
            {
              paramInt = -1;
              ac.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
              localObject = null;
              paramNotifyService = null;
              e.wTc.idkeyStat(403L, 38L, 1L, false);
              if (paramArrayOfByte1 != null) {
                paramNotifyService = new ctw();
              }
            }
            for (;;)
            {
              try
              {
                paramNotifyService.parseFrom(paramArrayOfByte1);
                ac.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.FFx), Integer.valueOf(paramNotifyService.FFy), Integer.valueOf(paramNotifyService.FFz), Integer.valueOf(paramNotifyService.FFA), Integer.valueOf(paramNotifyService.FFB), Integer.valueOf(paramNotifyService.FFC) });
                if (paramNotifyService.FFx == 13)
                {
                  g.agS();
                  paramArrayOfByte1 = g.agQ().mp(3);
                  paramNotifyService = UtilsJni.AesGcmDecryptWithUncompress(paramArrayOfByte1, paramNotifyService.Ewb.xy);
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
                ac.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                if (paramNotifyService == null) {
                  break label1189;
                }
                ac.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
                paramArrayOfByte1 = new tg();
                paramArrayOfByte1.dwl.data = paramNotifyService;
                com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte1);
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
              paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.FFx, paramNotifyService.FFy, paramNotifyService.FFz, paramNotifyService.FFA, paramNotifyService.FFB, paramNotifyService.FFC, paramNotifyService.FFD, paramNotifyService.Ewb.xy);
              continue;
              label1147:
              ac.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramArrayOfByte1.getMessage());
              e.wTc.idkeyStat(403L, 39L, 1L, false);
            }
            label1189:
            ac.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
            e.wTc.idkeyStat(403L, 40L, 1L, false);
            AppMethodBeat.o(22380);
            return;
            paramNotifyService = new dcj();
            try
            {
              paramNotifyService.parseFrom(paramArrayOfByte1);
              paramNotifyService = new com.tencent.mm.bn.a(paramNotifyService.Fgp, paramNotifyService.FLW, paramNotifyService.FLX, paramNotifyService.FLY, paramNotifyService.FLZ, paramNotifyService.FMb, paramNotifyService.FMa, paramNotifyService.FLT);
              g.agQ().ghe.a(paramNotifyService, 0);
              AppMethodBeat.o(22380);
              return;
            }
            catch (Exception paramNotifyService)
            {
              ac.e("MicroMsg.NotifyReceiverCallbackImpl", "speed test parse data failed. e: " + paramNotifyService.getMessage());
              AppMethodBeat.o(22380);
              return;
            }
            ac.d("MicroMsg.NotifyReceiverCallbackImpl", "do disaster auth ");
            g.agQ().ghe.a(new com.tencent.mm.modelsimple.b(), 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */