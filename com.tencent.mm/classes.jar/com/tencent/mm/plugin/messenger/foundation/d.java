package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.d;
import com.tencent.mm.as.a;
import com.tencent.mm.az.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class d
  implements com.tencent.mm.plugin.messenger.foundation.a.ab
{
  private static boolean aOi(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((com.tencent.mm.model.ab.Qq(paramString)) && (!b.isOverseasUser()))
    {
      AppMethodBeat.o(116878);
      return true;
    }
    AppMethodBeat.o(116878);
    return false;
  }
  
  public static h.b processAddMsg(h.a parama, ae paramae)
  {
    AppMethodBeat.i(116877);
    db localdb = parama.jQG;
    if ((10008 == ac.mFM) && (ac.mFN != 0))
    {
      Log.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localdb.HlH), Integer.valueOf(ac.mFN) });
      localdb.HlH = ac.mFN;
      ac.mFN = 0;
    }
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Os(localdb.HlH))
    {
      Log.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = com.tencent.mm.platformtools.z.a(localdb.RID);
    Object localObject = com.tencent.mm.platformtools.z.a(localdb.RIE);
    if ((str.equals(com.tencent.mm.model.z.bcZ())) && (((String)localObject).equals("newsapp")) && (localdb.COi != 51))
    {
      Log.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localdb.HlH), Integer.valueOf(localdb.COi) });
      AppMethodBeat.o(116877);
      return null;
    }
    Log.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localdb.HlH), Integer.valueOf(localdb.HlE), Integer.valueOf(localdb.RIK), Integer.valueOf(localdb.rVU), Integer.valueOf(localdb.COi), Integer.valueOf(localdb.CreateTime), Util.formatUnixTime(localdb.CreateTime), Long.valueOf(Util.nowSecond() - localdb.CreateTime), Integer.valueOf(localdb.RIG), Integer.valueOf(com.tencent.mm.platformtools.z.a(localdb.RIH, new byte[0]).length), Integer.valueOf(Util.nullAsNil(localdb.RII).length()), Integer.valueOf(Util.nullAsNil(localdb.RIJ).length()), Util.secPrint(com.tencent.mm.platformtools.z.a(localdb.RIF, "")) });
    Log.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localdb.RII, "" });
    af.k(localdb);
    if (str.equals("readerapp"))
    {
      localdb.RID = com.tencent.mm.platformtools.z.ZW("newsapp");
      localdb.COi = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localdb.COi != 10002)) {
      localdb.COi = 12399999;
    }
    if (localdb.COi == 52) {
      localdb.COi = 1000052;
    }
    if (localdb.COi == 53) {
      localdb.COi = 1000053;
    }
    bq.c(parama);
    int i = 0;
    h.b localb = null;
    com.tencent.mm.an.h localh = h.d.cj(Integer.valueOf(localdb.COi));
    localObject = localh;
    if (localh == null) {
      localObject = h.d.cj(str);
    }
    if (localObject != null)
    {
      localb = ((com.tencent.mm.an.h)localObject).b(parama);
      if (localb != null) {
        break label692;
      }
      localObject = null;
      if (localObject != null) {
        break label701;
      }
      Log.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localdb.COi), Long.valueOf(localdb.HlH), Integer.valueOf(localdb.RIK), Integer.valueOf(localdb.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      af.b(5, localdb);
      if (i == 0) {
        Log.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localdb.COi) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.fvt;
      break;
      label701:
      if (!aOi(str))
      {
        Log.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((et)localObject).field_msgId + "  " + paramae);
        if ((((et)localObject).field_msgId > 0L) && (paramae != null) && (localb.lCi)) {
          paramae.a((ca)localObject, localdb);
        }
      }
    }
  }
  
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
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
    switch (paramabu.SnG)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(116876);
      return;
    case 5: 
      paramArrayOfByte = (db)new db().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramabu = new h.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramabu, paramae);
        if (!paramabu.lCc)
        {
          paramabu = br.beX();
          paramae = com.tencent.mm.platformtools.z.a(paramArrayOfByte.RID);
          l1 = paramArrayOfByte.HlH;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.COi;
          if (paramae != null)
          {
            try
            {
              paramArrayOfByte = com.tencent.mm.model.z.bcZ();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramae);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramae);
              if (paramae.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.hDj;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                Log.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramae });
              }
              do
              {
                l3 = cm.bfC();
                if (l3 > 0L) {
                  break label343;
                }
                Log.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((com.tencent.mm.model.ab.QS(paramae)) || (as.bvH(paramae)) || (as.bvJ(paramae)) || (com.tencent.mm.model.ab.QO(paramae)) || (as.PY(paramae))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.hxX();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramabu)
            {
              Log.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramabu.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            Log.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramae, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.GC(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label712;
              }
              j = m;
              i = k;
              if (l3 - paramabu.luW[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 210L, 1L, false);
                paramabu.luW[11] = l3;
                i = 1;
                j = m;
              }
              label503:
              k = br.luQ.length - 1;
              label511:
              if (k < 0) {
                break label2374;
              }
              if (l5 < br.luQ[k]) {
                break label863;
              }
              if (!paramBoolean) {
                break label770;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, br.luR[k], 1L, false);
              label550:
              if (!paramBoolean) {
                break label791;
              }
              if (l3 - paramabu.luW[k] < 86400000L) {
                break label2371;
              }
              com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, br.luT[k], 1L, false);
              paramabu.luW[k] = l3;
              i = 1;
              label601:
              if (l5 < 2000L) {
                break label2368;
              }
              if (!paramBoolean) {
                break label841;
              }
              a.b(k, l3, l4, l2, l5, l1, paramae, n);
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
        if (i < paramabu.luW.length)
        {
          if (Util.isEqual(i, paramabu.luW.length - 1)) {
            paramArrayOfByte.append(paramabu.luW[i]);
          }
          for (;;)
          {
            i += 1;
            break label649;
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 101L, 1L, false);
            break;
            j = m;
            i = k;
            if (l3 - paramabu.luX[11] < 86400000L) {
              break label503;
            }
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 211L, 1L, false);
            paramabu.luX[11] = l3;
            j = 1;
            i = k;
            break label503;
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, br.luS[k], 1L, false);
            break label550;
            if (l3 - paramabu.luX[k] < 86400000L) {
              break label2371;
            }
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, br.luU[k], 1L, false);
            paramabu.luX[k] = l3;
            j = 1;
            break label601;
            a.a(k, l3, l4, l2, l5, l1, paramae, n);
            break label633;
            k -= 1;
            break label511;
            paramArrayOfByte.append(paramabu.luW[i] + ",");
          }
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCO, paramArrayOfByte.toString());
      }
      label712:
      label841:
      label863:
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramabu.luX.length)
        {
          if (Util.isEqual(i, paramabu.luX.length - 1)) {
            paramArrayOfByte.append(paramabu.luX[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramabu.luX[i] + ",");
          }
        }
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCP, paramArrayOfByte.toString());
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
        paramabu = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramabu = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            Log.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.f.Iyx.a(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramabu });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(780L, 155L, 1L, false);
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
      paramabu = (aft)new aft().parseFrom(paramArrayOfByte);
      bq.aC(com.tencent.mm.platformtools.z.a(paramabu.SrH), paramabu.SrK);
      AppMethodBeat.o(116876);
      return;
      paramabu = (aga)new aga().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramabu.SrN;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bq.A(com.tencent.mm.platformtools.z.a(paramabu.SrH), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
      break;
      continue;
      break label601;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */