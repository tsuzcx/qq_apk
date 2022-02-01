package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.ap.a;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import java.util.List;

public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.u
{
  private static boolean akM(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((w.wL(paramString)) && (!b.aGf()))
    {
      AppMethodBeat.o(116878);
      return true;
    }
    AppMethodBeat.o(116878);
    return false;
  }
  
  public static f.b processAddMsg(f.a parama, x paramx)
  {
    AppMethodBeat.i(116877);
    cu localcu = parama.fXi;
    if ((10008 == ab.ivG) && (ab.ivH != 0))
    {
      ac.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localcu.vTQ), Integer.valueOf(ab.ivH) });
      localcu.vTQ = ab.ivH;
      ab.ivH = 0;
    }
    if (((k)g.ab(k.class)).dcr().vR(localcu.vTQ))
    {
      ac.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = z.a(localcu.DPT);
    Object localObject = z.a(localcu.DPU);
    if ((str.equals(com.tencent.mm.model.u.axw())) && (((String)localObject).equals("newsapp")) && (localcu.tit != 51))
    {
      ac.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localcu.vTQ), Integer.valueOf(localcu.tit) });
      AppMethodBeat.o(116877);
      return null;
    }
    ac.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localcu.vTQ), Integer.valueOf(localcu.vTO), Integer.valueOf(localcu.DQa), Integer.valueOf(localcu.ndj), Integer.valueOf(localcu.tit), Integer.valueOf(localcu.CreateTime), bs.Am(localcu.CreateTime), Long.valueOf(bs.aNx() - localcu.CreateTime), Integer.valueOf(localcu.DPW), Integer.valueOf(z.a(localcu.DPX, new byte[0]).length), Integer.valueOf(bs.nullAsNil(localcu.DPY).length()), Integer.valueOf(bs.nullAsNil(localcu.DPZ).length()), bs.aLJ(z.a(localcu.DPV, "")) });
    ac.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localcu.DPY, "" });
    y.j(localcu);
    if (str.equals("readerapp"))
    {
      localcu.DPT = z.FI("newsapp");
      localcu.tit = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localcu.tit != 10002)) {
      localcu.tit = 12399999;
    }
    if (localcu.tit == 52) {
      localcu.tit = 1000052;
    }
    if (localcu.tit == 53) {
      localcu.tit = 1000053;
    }
    bi.c(parama);
    int i = 0;
    f.b localb = null;
    f localf = f.d.bY(Integer.valueOf(localcu.tit));
    localObject = localf;
    if (localf == null) {
      localObject = f.d.bY(str);
    }
    if (localObject != null)
    {
      localb = ((f)localObject).b(parama);
      if (localb != null) {
        break label692;
      }
      localObject = null;
      if (localObject != null) {
        break label701;
      }
      ac.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localcu.tit), Long.valueOf(localcu.vTQ), Integer.valueOf(localcu.DQa), Integer.valueOf(localcu.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      y.b(5, localcu);
      if (i == 0) {
        ac.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localcu.tit) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.cZc;
      break;
      label701:
      if (!akM(str))
      {
        ac.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((dy)localObject).field_msgId + "  " + paramx);
        if ((((dy)localObject).field_msgId > 0L) && (paramx != null) && (localb.hvL)) {
          paramx.a((bo)localObject, localcu);
        }
      }
    }
  }
  
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116876);
    long l1;
    long l2;
    int n;
    int i;
    long l3;
    label343:
    long l4;
    long l5;
    int k;
    int m;
    int j;
    switch (paramxv.ErL)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(116876);
      return;
    case 5: 
      paramArrayOfByte = (cu)new cu().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramxv = new f.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramxv, paramx);
        if (!paramxv.hvF)
        {
          paramxv = com.tencent.mm.model.bj.azc();
          paramx = z.a(paramArrayOfByte.DPT);
          l1 = paramArrayOfByte.vTQ;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.tit;
          if (paramx != null)
          {
            try
            {
              paramArrayOfByte = com.tencent.mm.model.u.axw();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramx);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((k)g.ab(k.class)).awB().aNt(paramx);
              if (paramx.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.exT;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                ac.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramx });
              }
              do
              {
                l3 = ce.azH();
                if (l3 > 0L) {
                  break label343;
                }
                ac.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((w.xn(paramx)) || (ai.aMZ(paramx)) || (ai.aNb(paramx)) || (w.xj(paramx)) || (ai.ww(paramx))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.fad();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramxv)
            {
              ac.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramxv.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            ac.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramx, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.qc(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label712;
              }
              j = m;
              i = k;
              if (l3 - paramxv.hpa[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 210L, 1L, false);
                paramxv.hpa[11] = l3;
                i = 1;
                j = m;
              }
              label503:
              k = com.tencent.mm.model.bj.hoU.length - 1;
              label511:
              if (k < 0) {
                break label2374;
              }
              if (l5 < com.tencent.mm.model.bj.hoU[k]) {
                break label863;
              }
              if (!paramBoolean) {
                break label770;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, com.tencent.mm.model.bj.hoV[k], 1L, false);
              label550:
              if (!paramBoolean) {
                break label791;
              }
              if (l3 - paramxv.hpa[k] < 86400000L) {
                break label2371;
              }
              com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, com.tencent.mm.model.bj.hoX[k], 1L, false);
              paramxv.hpa[k] = l3;
              i = 1;
              label601:
              if (l5 < 2000L) {
                break label2368;
              }
              if (!paramBoolean) {
                break label841;
              }
              a.b(k, l3, l4, l2, l5, l1, paramx, n);
            }
          }
        }
      }
      break;
    }
    label649:
    label791:
    label2368:
    label2371:
    label2374:
    for (;;)
    {
      label633:
      if (i != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramxv.hpa.length)
        {
          if (bs.jl(i, paramxv.hpa.length - 1)) {
            paramArrayOfByte.append(paramxv.hpa[i]);
          }
          for (;;)
          {
            i += 1;
            break label649;
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 101L, 1L, false);
            break;
            j = m;
            i = k;
            if (l3 - paramxv.hpb[11] < 86400000L) {
              break label503;
            }
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 211L, 1L, false);
            paramxv.hpb[11] = l3;
            j = 1;
            i = k;
            break label503;
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, com.tencent.mm.model.bj.hoW[k], 1L, false);
            break label550;
            if (l3 - paramxv.hpb[k] < 86400000L) {
              break label2371;
            }
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, com.tencent.mm.model.bj.hoY[k], 1L, false);
            paramxv.hpb[k] = l3;
            j = 1;
            break label601;
            a.a(k, l3, l4, l2, l5, l1, paramx, n);
            break label633;
            k -= 1;
            break label511;
            paramArrayOfByte.append(paramxv.hpa[i] + ",");
          }
        }
        g.agR().agA().set(ah.a.GWr, paramArrayOfByte.toString());
      }
      label712:
      label841:
      label863:
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramxv.hpb.length)
        {
          if (bs.jl(i, paramxv.hpb.length - 1)) {
            paramArrayOfByte.append(paramxv.hpb[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramxv.hpb[i] + ",");
          }
        }
        g.agR().agA().set(ah.a.GWs, paramArrayOfByte.toString());
      }
      switch (n)
      {
      default: 
        if (paramBoolean)
        {
          j = 1;
          label1095:
          i = 0;
          switch (n)
          {
          }
        }
        break;
      }
      for (;;)
      {
        paramxv = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramxv = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            ac.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.e.wTc.f(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramxv });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(780L, 155L, 1L, false);
        break;
        j = 2;
        break label1095;
        i = 1;
        continue;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
        continue;
        i = 7;
        continue;
        i = 8;
      }
      paramxv = (aay)new aay().parseFrom(paramArrayOfByte);
      bi.ac(z.a(paramxv.EuE), paramxv.EuH);
      AppMethodBeat.o(116876);
      return;
      paramxv = (abf)new abf().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramxv.EuK;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bi.A(z.a(paramxv.EuE), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
      break;
      continue;
      break label601;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */