package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.ap.a;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.List;

public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.x
{
  private static boolean aqD(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((com.tencent.mm.model.x.As(paramString)) && (!b.aJG()))
    {
      AppMethodBeat.o(116878);
      return true;
    }
    AppMethodBeat.o(116878);
    return false;
  }
  
  public static e.b processAddMsg(e.a parama, aa paramaa)
  {
    AppMethodBeat.i(116877);
    cv localcv = parama.gte;
    if ((10008 == ac.iRH) && (ac.iRI != 0))
    {
      ae.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localcv.xrk), Integer.valueOf(ac.iRI) });
      localcv.xrk = ac.iRI;
      ac.iRI = 0;
    }
    if (((l)g.ab(l.class)).doJ().yu(localcv.xrk))
    {
      ae.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = z.a(localcv.FNG);
    Object localObject = z.a(localcv.FNH);
    if ((str.equals(v.aAC())) && (((String)localObject).equals("newsapp")) && (localcv.urJ != 51))
    {
      ae.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localcv.xrk), Integer.valueOf(localcv.urJ) });
      AppMethodBeat.o(116877);
      return null;
    }
    ae.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localcv.xrk), Integer.valueOf(localcv.xri), Integer.valueOf(localcv.FNN), Integer.valueOf(localcv.nJb), Integer.valueOf(localcv.urJ), Integer.valueOf(localcv.CreateTime), bu.DA(localcv.CreateTime), Long.valueOf(bu.aRi() - localcv.CreateTime), Integer.valueOf(localcv.FNJ), Integer.valueOf(z.a(localcv.FNK, new byte[0]).length), Integer.valueOf(bu.nullAsNil(localcv.FNL).length()), Integer.valueOf(bu.nullAsNil(localcv.FNM).length()), bu.aSM(z.a(localcv.FNI, "")) });
    ae.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localcv.FNL, "" });
    ab.j(localcv);
    if (str.equals("readerapp"))
    {
      localcv.FNG = z.Jw("newsapp");
      localcv.urJ = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localcv.urJ != 10002)) {
      localcv.urJ = 12399999;
    }
    if (localcv.urJ == 52) {
      localcv.urJ = 1000052;
    }
    if (localcv.urJ == 53) {
      localcv.urJ = 1000053;
    }
    bl.c(parama);
    int i = 0;
    e.b localb = null;
    com.tencent.mm.ak.e locale = e.d.ca(Integer.valueOf(localcv.urJ));
    localObject = locale;
    if (locale == null) {
      localObject = e.d.ca(str);
    }
    if (localObject != null)
    {
      localb = ((com.tencent.mm.ak.e)localObject).b(parama);
      if (localb != null) {
        break label692;
      }
      localObject = null;
      if (localObject != null) {
        break label701;
      }
      ae.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localcv.urJ), Long.valueOf(localcv.xrk), Integer.valueOf(localcv.FNN), Integer.valueOf(localcv.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      ab.b(5, localcv);
      if (i == 0) {
        ae.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localcv.urJ) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.dlw;
      break;
      label701:
      if (!aqD(str))
      {
        ae.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((ei)localObject).field_msgId + "  " + paramaa);
        if ((((ei)localObject).field_msgId > 0L) && (paramaa != null) && (localb.hQT)) {
          paramaa.a((bv)localObject, localcv);
        }
      }
    }
  }
  
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
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
    switch (paramzx.Gru)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(116876);
      return;
    case 5: 
      paramArrayOfByte = (cv)new cv().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramzx = new e.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramzx, paramaa);
        if (!paramzx.hQN)
        {
          paramzx = bm.aCw();
          paramaa = z.a(paramArrayOfByte.FNG);
          l1 = paramArrayOfByte.xrk;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.urJ;
          if (paramaa != null)
          {
            try
            {
              paramArrayOfByte = v.aAC();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramaa);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((l)g.ab(l.class)).azF().BH(paramaa);
              if (paramaa.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.eRd;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                ae.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramaa });
              }
              do
              {
                l3 = ch.aDa();
                if (l3 > 0L) {
                  break label343;
                }
                ae.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((com.tencent.mm.model.x.AU(paramaa)) || (an.aUn(paramaa)) || (an.aUp(paramaa)) || (com.tencent.mm.model.x.AQ(paramaa)) || (an.Ac(paramaa))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.fug();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramzx)
            {
              ae.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramzx.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            ae.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramaa, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.so(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label712;
              }
              j = m;
              i = k;
              if (l3 - paramzx.hKk[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 210L, 1L, false);
                paramzx.hKk[11] = l3;
                i = 1;
                j = m;
              }
              label503:
              k = bm.hKe.length - 1;
              label511:
              if (k < 0) {
                break label2374;
              }
              if (l5 < bm.hKe[k]) {
                break label863;
              }
              if (!paramBoolean) {
                break label770;
              }
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, bm.hKf[k], 1L, false);
              label550:
              if (!paramBoolean) {
                break label791;
              }
              if (l3 - paramzx.hKk[k] < 86400000L) {
                break label2371;
              }
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, bm.hKh[k], 1L, false);
              paramzx.hKk[k] = l3;
              i = 1;
              label601:
              if (l5 < 2000L) {
                break label2368;
              }
              if (!paramBoolean) {
                break label841;
              }
              a.b(k, l3, l4, l2, l5, l1, paramaa, n);
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
        if (i < paramzx.hKk.length)
        {
          if (bu.jB(i, paramzx.hKk.length - 1)) {
            paramArrayOfByte.append(paramzx.hKk[i]);
          }
          for (;;)
          {
            i += 1;
            break label649;
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 101L, 1L, false);
            break;
            j = m;
            i = k;
            if (l3 - paramzx.hKl[11] < 86400000L) {
              break label503;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 211L, 1L, false);
            paramzx.hKl[11] = l3;
            j = 1;
            i = k;
            break label503;
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, bm.hKg[k], 1L, false);
            break label550;
            if (l3 - paramzx.hKl[k] < 86400000L) {
              break label2371;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, bm.hKi[k], 1L, false);
            paramzx.hKl[k] = l3;
            j = 1;
            break label601;
            a.a(k, l3, l4, l2, l5, l1, paramaa, n);
            break label633;
            k -= 1;
            break label511;
            paramArrayOfByte.append(paramzx.hKk[i] + ",");
          }
        }
        g.ajR().ajA().set(am.a.JdV, paramArrayOfByte.toString());
      }
      label712:
      label841:
      label863:
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramzx.hKl.length)
        {
          if (bu.jB(i, paramzx.hKl.length - 1)) {
            paramArrayOfByte.append(paramzx.hKl[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramzx.hKl[i] + ",");
          }
        }
        g.ajR().ajA().set(am.a.JdW, paramArrayOfByte.toString());
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
        paramzx = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramzx = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            ae.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.e.ywz.f(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramzx });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(780L, 155L, 1L, false);
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
      paramzx = (adh)new adh().parseFrom(paramArrayOfByte);
      bl.ah(z.a(paramzx.GuF), paramzx.GuI);
      AppMethodBeat.o(116876);
      return;
      paramzx = (ado)new ado().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramzx.GuL;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bl.C(z.a(paramzx.GuF), ((Integer)paramArrayOfByte.get(i)).intValue());
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