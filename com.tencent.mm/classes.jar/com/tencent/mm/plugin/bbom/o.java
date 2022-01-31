package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.mm.a.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.v;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.ge;
import com.tencent.mm.h.a.im;
import com.tencent.mm.h.a.kl;
import com.tencent.mm.h.a.kl.a;
import com.tencent.mm.h.a.pw;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.a.tb;
import com.tencent.mm.h.a.td;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bop;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  implements c
{
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    switch (paramInt)
    {
    default: 
    case 10: 
    case 120: 
    case 174: 
    case 102: 
    case 192: 
    case 268369923: 
    case 241: 
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                y.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                paramNotifyService = new o.b();
                paramNotifyService.deviceID = q.zg();
                paramArrayOfByte2 = new v(paramNotifyService, 10);
                try
                {
                  if (paramArrayOfByte2.a(10, paramArrayOfByte1, null))
                  {
                    au.Dk().onSceneEnd(0, 0, "", new com.tencent.mm.modelsimple.f(paramNotifyService));
                    return;
                  }
                }
                catch (RemoteException paramNotifyService)
                {
                  y.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
                  return;
                }
              }
              NotifyReceiver.NotifyService.eo("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
              paramNotifyService = new ru();
              paramNotifyService.cbq.cbs = true;
              a.udP.m(paramNotifyService);
              paramNotifyService = paramNotifyService.cbr.cbu;
              if (!bk.bl(paramNotifyService))
              {
                y.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: " + paramNotifyService);
                paramNotifyService = new ru();
                paramNotifyService.cbq.cbt = true;
                a.udP.m(paramNotifyService);
              }
            } while ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length <= 0));
            if (paramArrayOfByte1[0] == 1)
            {
              y.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
              paramNotifyService = new td();
              paramNotifyService.ccJ.bNb = 3;
              paramNotifyService.ccJ.ccD = paramArrayOfByte1;
              a.udP.m(paramNotifyService);
              return;
            }
            if (paramArrayOfByte1[0] == 101)
            {
              y.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
              paramNotifyService = new im();
              paramNotifyService.bQJ.bQK = paramArrayOfByte1;
              a.udP.m(paramNotifyService);
              return;
            }
            if (paramArrayOfByte1[0] == 3)
            {
              y.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
              paramNotifyService = new td();
              paramNotifyService.ccJ.bNb = 9;
              paramNotifyService.ccJ.ccD = paramArrayOfByte1;
              a.udP.m(paramNotifyService);
              return;
            }
            if (paramArrayOfByte1[0] == 2)
            {
              y.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
              paramNotifyService = new td();
              paramNotifyService.ccJ.bNb = 10;
              paramNotifyService.ccJ.ccD = paramArrayOfByte1;
              a.udP.m(paramNotifyService);
              return;
            }
          } while (paramArrayOfByte1[0] != 102);
          y.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new tb();
          paramNotifyService.ccC.ccD = paramArrayOfByte1;
          a.udP.m(paramNotifyService);
          return;
          y.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
          paramNotifyService = new td();
          paramNotifyService.ccJ.bNb = 6;
          paramNotifyService.ccJ.ccD = paramArrayOfByte1;
          a.udP.m(paramNotifyService);
          return;
          y.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
          return;
          paramNotifyService = new ge();
          paramNotifyService.bND.bNE = paramArrayOfByte1;
          a.udP.m(paramNotifyService);
          return;
          NotifyReceiver.NotifyService.eo("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
        } while (bk.bE(paramArrayOfByte1));
        paramNotifyService = new String(paramArrayOfByte1);
        paramArrayOfByte1 = new aj();
        paramArrayOfByte1.bGr.type = 4;
        paramArrayOfByte1.bGr.bGt = paramNotifyService;
        a.udP.m(paramArrayOfByte1);
        return;
        y.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
      } while (paramArrayOfByte1.length < 8);
      paramNotifyService = new byte[4];
      paramArrayOfByte2 = new byte[4];
      System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
      System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
      paramArrayOfByte1 = new kl();
      paramArrayOfByte1.bTz.bTA = n.q(paramNotifyService, 0);
      paramArrayOfByte1.bTz.bTB = n.q(paramArrayOfByte2, 0);
      y.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.bTz.bTA), Integer.valueOf(paramArrayOfByte1.bTz.bTB) });
      a.udP.m(paramArrayOfByte1);
      return;
    }
    if (paramArrayOfByte1 == null)
    {
      paramInt = -1;
      y.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.report.f.nEG.a(403L, 38L, 1L, false);
      if (paramArrayOfByte1 == null) {
        break label991;
      }
    }
    label991:
    for (paramNotifyService = new bop();; paramNotifyService = null)
    {
      try
      {
        paramNotifyService.aH(paramArrayOfByte1);
        y.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.tGQ), Integer.valueOf(paramNotifyService.tGR), Integer.valueOf(paramNotifyService.tGS), Integer.valueOf(paramNotifyService.tGT), Integer.valueOf(paramNotifyService.tGU), Integer.valueOf(paramNotifyService.tGV) });
        paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.tGQ, paramNotifyService.tGR, paramNotifyService.tGS, paramNotifyService.tGT, paramNotifyService.tGU, paramNotifyService.tGV, paramNotifyService.tGW, paramNotifyService.sRj.oY);
        if (paramNotifyService == null) {
          break label996;
        }
        y.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
        paramArrayOfByte1 = new pw();
        paramArrayOfByte1.bZv.data = paramNotifyService;
        a.udP.m(paramArrayOfByte1);
        return;
      }
      catch (Exception paramNotifyService)
      {
        y.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramNotifyService.getMessage());
        com.tencent.mm.plugin.report.f.nEG.a(403L, 39L, 1L, false);
      }
      paramInt = paramArrayOfByte1.length;
      break;
    }
    label996:
    y.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
    com.tencent.mm.plugin.report.f.nEG.a(403L, 40L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */