package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.ap.a;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class c
  implements x
{
  private static boolean aDY(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((com.tencent.mm.model.ab.IX(paramString)) && (!b.isOverseasUser()))
    {
      AppMethodBeat.o(116878);
      return true;
    }
    AppMethodBeat.o(116878);
    return false;
  }
  
  public static h.b processAddMsg(h.a parama, aa paramaa)
  {
    AppMethodBeat.i(116877);
    de localde = parama.heO;
    if ((10008 == ac.jOC) && (ac.jOD != 0))
    {
      Log.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localde.Brn), Integer.valueOf(ac.jOD) });
      localde.Brn = ac.jOD;
      ac.jOD = 0;
    }
    if (((l)g.af(l.class)).eiy().Hd(localde.Brn))
    {
      Log.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = com.tencent.mm.platformtools.z.a(localde.KHl);
    Object localObject = com.tencent.mm.platformtools.z.a(localde.KHm);
    if ((str.equals(com.tencent.mm.model.z.aTY())) && (((String)localObject).equals("newsapp")) && (localde.xKb != 51))
    {
      Log.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localde.Brn), Integer.valueOf(localde.xKb) });
      AppMethodBeat.o(116877);
      return null;
    }
    Log.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localde.Brn), Integer.valueOf(localde.Brl), Integer.valueOf(localde.KHs), Integer.valueOf(localde.oTW), Integer.valueOf(localde.xKb), Integer.valueOf(localde.CreateTime), Util.formatUnixTime(localde.CreateTime), Long.valueOf(Util.nowSecond() - localde.CreateTime), Integer.valueOf(localde.KHo), Integer.valueOf(com.tencent.mm.platformtools.z.a(localde.KHp, new byte[0]).length), Integer.valueOf(Util.nullAsNil(localde.KHq).length()), Integer.valueOf(Util.nullAsNil(localde.KHr).length()), Util.secPrint(com.tencent.mm.platformtools.z.a(localde.KHn, "")) });
    Log.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localde.KHq, "" });
    com.tencent.mm.plugin.messenger.foundation.a.ab.k(localde);
    if (str.equals("readerapp"))
    {
      localde.KHl = com.tencent.mm.platformtools.z.Su("newsapp");
      localde.xKb = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localde.xKb != 10002)) {
      localde.xKb = 12399999;
    }
    if (localde.xKb == 52) {
      localde.xKb = 1000052;
    }
    if (localde.xKb == 53) {
      localde.xKb = 1000053;
    }
    bp.c(parama);
    int i = 0;
    h.b localb = null;
    h localh = h.d.ck(Integer.valueOf(localde.xKb));
    localObject = localh;
    if (localh == null) {
      localObject = h.d.ck(str);
    }
    if (localObject != null)
    {
      localb = ((h)localObject).b(parama);
      if (localb != null) {
        break label692;
      }
      localObject = null;
      if (localObject != null) {
        break label701;
      }
      Log.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localde.xKb), Long.valueOf(localde.Brn), Integer.valueOf(localde.KHs), Integer.valueOf(localde.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      com.tencent.mm.plugin.messenger.foundation.a.ab.b(5, localde);
      if (i == 0) {
        Log.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localde.xKb) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.dCM;
      break;
      label701:
      if (!aDY(str))
      {
        Log.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((eo)localObject).field_msgId + "  " + paramaa);
        if ((((eo)localObject).field_msgId > 0L) && (paramaa != null) && (localb.iMb)) {
          paramaa.a((ca)localObject, localde);
        }
      }
    }
  }
  
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
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
    switch (paramabn.Lms)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(116876);
      return;
    case 5: 
      paramArrayOfByte = (de)new de().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramabn = new h.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramabn, paramaa);
        if (!paramabn.iLV)
        {
          paramabn = bq.aVU();
          paramaa = com.tencent.mm.platformtools.z.a(paramArrayOfByte.KHl);
          l1 = paramArrayOfByte.Brn;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.xKb;
          if (paramaa != null)
          {
            try
            {
              paramArrayOfByte = com.tencent.mm.model.z.aTY();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramaa);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((l)g.af(l.class)).aSN().Kn(paramaa);
              if (paramaa.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.fuH;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                Log.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramaa });
              }
              do
              {
                l3 = cl.aWy();
                if (l3 > 0L) {
                  break label343;
                }
                Log.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((com.tencent.mm.model.ab.Jz(paramaa)) || (as.bjm(paramaa)) || (as.bjo(paramaa)) || (com.tencent.mm.model.ab.Jv(paramaa)) || (as.IG(paramaa))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.gBM();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramabn)
            {
              Log.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramabn.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            Log.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramaa, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.Au(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label712;
              }
              j = m;
              i = k;
              if (l3 - paramabn.iEU[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 210L, 1L, false);
                paramabn.iEU[11] = l3;
                i = 1;
                j = m;
              }
              label503:
              k = bq.iEO.length - 1;
              label511:
              if (k < 0) {
                break label2374;
              }
              if (l5 < bq.iEO[k]) {
                break label863;
              }
              if (!paramBoolean) {
                break label770;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, bq.iEP[k], 1L, false);
              label550:
              if (!paramBoolean) {
                break label791;
              }
              if (l3 - paramabn.iEU[k] < 86400000L) {
                break label2371;
              }
              com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, bq.iER[k], 1L, false);
              paramabn.iEU[k] = l3;
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
        if (i < paramabn.iEU.length)
        {
          if (Util.isEqual(i, paramabn.iEU.length - 1)) {
            paramArrayOfByte.append(paramabn.iEU[i]);
          }
          for (;;)
          {
            i += 1;
            break label649;
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 101L, 1L, false);
            break;
            j = m;
            i = k;
            if (l3 - paramabn.iEV[11] < 86400000L) {
              break label503;
            }
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 211L, 1L, false);
            paramabn.iEV[11] = l3;
            j = 1;
            i = k;
            break label503;
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, bq.iEQ[k], 1L, false);
            break label550;
            if (l3 - paramabn.iEV[k] < 86400000L) {
              break label2371;
            }
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, bq.iES[k], 1L, false);
            paramabn.iEV[k] = l3;
            j = 1;
            break label601;
            a.a(k, l3, l4, l2, l5, l1, paramaa, n);
            break label633;
            k -= 1;
            break label511;
            paramArrayOfByte.append(paramabn.iEU[i] + ",");
          }
        }
        g.aAh().azQ().set(ar.a.OnB, paramArrayOfByte.toString());
      }
      label712:
      label841:
      label863:
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramabn.iEV.length)
        {
          if (Util.isEqual(i, paramabn.iEV.length - 1)) {
            paramArrayOfByte.append(paramabn.iEV[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramabn.iEV[i] + ",");
          }
        }
        g.aAh().azQ().set(ar.a.OnC, paramArrayOfByte.toString());
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
        paramabn = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramabn = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            Log.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.e.Cxv.a(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramabn });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(780L, 155L, 1L, false);
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
      paramabn = (afk)new afk().parseFrom(paramArrayOfByte);
      bp.ak(com.tencent.mm.platformtools.z.a(paramabn.Lqk), paramabn.Lqn);
      AppMethodBeat.o(116876);
      return;
      paramabn = (afr)new afr().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramabn.Lqq;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bp.D(com.tencent.mm.platformtools.z.a(paramabn.Lqk), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
      break;
      continue;
      break label601;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */