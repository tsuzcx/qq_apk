package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.d;
import com.tencent.mm.aq.a;
import com.tencent.mm.au.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.util.b.a;
import java.util.List;

public final class d
  implements ab
{
  private static boolean aLh(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((au.bvT(paramString)) && (!b.isOverseasUser()))
    {
      AppMethodBeat.o(116878);
      return true;
    }
    AppMethodBeat.o(116878);
    return false;
  }
  
  public static g.b processAddMsg(g.a parama, ae paramae)
  {
    AppMethodBeat.i(116877);
    dl localdl = parama.mpN;
    if ((10008 == com.tencent.mm.platformtools.z.pCm) && (com.tencent.mm.platformtools.z.pCn != 0))
    {
      Log.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localdl.Njv), Integer.valueOf(com.tencent.mm.platformtools.z.pCn) });
      localdl.Njv = com.tencent.mm.platformtools.z.pCn;
      com.tencent.mm.platformtools.z.pCn = 0;
    }
    if (((n)h.ax(n.class)).gaZ().sn(localdl.Njv))
    {
      Log.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = w.a(localdl.YFE);
    Object localObject = w.a(localdl.YFF);
    if ((str.equals(com.tencent.mm.model.z.bAM())) && (((String)localObject).equals("newsapp")) && (localdl.IIs != 51))
    {
      Log.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localdl.Njv), Integer.valueOf(localdl.IIs) });
      AppMethodBeat.o(116877);
      return null;
    }
    Log.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localdl.Njv), Integer.valueOf(localdl.Njs), Integer.valueOf(localdl.YFL), Integer.valueOf(localdl.vhk), Integer.valueOf(localdl.IIs), Integer.valueOf(localdl.CreateTime), Util.formatUnixTime(localdl.CreateTime), Long.valueOf(Util.nowSecond() - localdl.CreateTime), Integer.valueOf(localdl.YFH), Integer.valueOf(w.a(localdl.YFI, new byte[0]).length), Integer.valueOf(Util.nullAsNil(localdl.YFJ).length()), Integer.valueOf(Util.nullAsNil(localdl.YFK).length()), Util.secPrint(w.a(localdl.YFG, "")) });
    Log.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localdl.YFJ, "" });
    af.k(localdl);
    if (str.equals("readerapp"))
    {
      localdl.YFE = w.Sk("newsapp");
      localdl.IIs = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localdl.IIs != 10002)) {
      localdl.IIs = 12399999;
    }
    if (localdl.IIs == 52) {
      localdl.IIs = 1000052;
    }
    if (localdl.IIs == 53) {
      localdl.IIs = 1000053;
    }
    br.c(parama);
    int i = 0;
    g.b localb = null;
    g localg = g.d.dB(Integer.valueOf(localdl.IIs));
    localObject = localg;
    if (localg == null) {
      localObject = g.d.dB(str);
    }
    if (localObject != null)
    {
      localb = ((g)localObject).b(parama);
      if (localb != null) {
        break label692;
      }
      localObject = null;
      if (localObject != null) {
        break label701;
      }
      Log.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localdl.IIs), Long.valueOf(localdl.Njv), Integer.valueOf(localdl.YFL), Integer.valueOf(localdl.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      af.b(5, localdl);
      if (i == 0) {
        Log.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localdl.IIs) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.hzO;
      break;
      label701:
      if (!aLh(str))
      {
        Log.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((fi)localObject).field_msgId + "  " + paramae);
        if ((((fi)localObject).field_msgId > 0L) && (paramae != null) && (localb.otS)) {
          paramae.a((cc)localObject, localdl);
        }
      }
    }
  }
  
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116876);
    long l1;
    long l2;
    int n;
    int i;
    long l3;
    label357:
    long l4;
    long l5;
    int k;
    int m;
    int j;
    switch (paramadw.Zmc)
    {
    case 6: 
    case 7: 
    default: 
    case 5: 
      do
      {
        AppMethodBeat.o(116876);
        return;
        paramadw = com.tencent.mm.util.i.agtt;
      } while (com.tencent.mm.util.i.a(b.a.agqK, 0) != 0);
      paramArrayOfByte = (dl)new dl().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramadw = new g.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramadw, paramae);
        if (!paramadw.otM)
        {
          paramadw = bs.bCO();
          paramae = w.a(paramArrayOfByte.YFE);
          l1 = paramArrayOfByte.Njv;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.IIs;
          if (paramae != null)
          {
            try
            {
              paramArrayOfByte = com.tencent.mm.model.z.bAM();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramae);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((n)h.ax(n.class)).bzA().JE(paramae);
              if (paramae.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.kaf;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                Log.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramae });
              }
              do
              {
                l3 = cn.bDu();
                if (l3 > 0L) {
                  break label357;
                }
                Log.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((au.bww(paramae)) || (au.bwL(paramae)) || (au.bwN(paramae)) || (au.bws(paramae)) || (au.bwS(paramae))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.iZC();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramadw)
            {
              Log.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramadw.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            Log.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramae, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.iN(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label726;
              }
              j = m;
              i = k;
              if (l3 - paramadw.omt[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 210L, 1L, false);
                paramadw.omt[11] = l3;
                i = 1;
                j = m;
              }
              label517:
              k = bs.omn.length - 1;
              label525:
              if (k < 0) {
                break label2386;
              }
              if (l5 < bs.omn[k]) {
                break label877;
              }
              if (!paramBoolean) {
                break label784;
              }
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, bs.omo[k], 1L, false);
              label564:
              if (!paramBoolean) {
                break label805;
              }
              if (l3 - paramadw.omt[k] < 86400000L) {
                break label2383;
              }
              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, bs.omq[k], 1L, false);
              paramadw.omt[k] = l3;
              i = 1;
              label615:
              if (l5 < 2000L) {
                break label2380;
              }
              if (!paramBoolean) {
                break label855;
              }
              a.b(k, l3, l4, l2, l5, l1, paramae, n);
            }
          }
        }
      }
      break;
    }
    label647:
    label663:
    label805:
    label2380:
    label2383:
    label2386:
    for (;;)
    {
      if (i != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramadw.omt.length)
        {
          if (Util.isEqual(i, paramadw.omt.length - 1)) {
            paramArrayOfByte.append(paramadw.omt[i]);
          }
          for (;;)
          {
            i += 1;
            break label663;
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 101L, 1L, false);
            break;
            label726:
            j = m;
            i = k;
            if (l3 - paramadw.omu[11] < 86400000L) {
              break label517;
            }
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 211L, 1L, false);
            paramadw.omu[11] = l3;
            j = 1;
            i = k;
            break label517;
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, bs.omp[k], 1L, false);
            break label564;
            if (l3 - paramadw.omu[k] < 86400000L) {
              break label2383;
            }
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, bs.omr[k], 1L, false);
            paramadw.omu[k] = l3;
            j = 1;
            break label615;
            label855:
            a.a(k, l3, l4, l2, l5, l1, paramae, n);
            break label647;
            label877:
            k -= 1;
            break label525;
            paramArrayOfByte.append(paramadw.omt[i] + ",");
          }
        }
        h.baE().ban().set(at.a.adfI, paramArrayOfByte.toString());
      }
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramadw.omu.length)
        {
          if (Util.isEqual(i, paramadw.omu.length - 1)) {
            paramArrayOfByte.append(paramadw.omu[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramadw.omu[i] + ",");
          }
        }
        h.baE().ban().set(at.a.adfJ, paramArrayOfByte.toString());
      }
      switch (n)
      {
      default: 
        if (paramBoolean)
        {
          j = 1;
          label1107:
          i = 0;
          switch (n)
          {
          }
        }
        break;
      }
      for (;;)
      {
        paramadw = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramadw = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            Log.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.f.Ozc.b(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramadw });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(780L, 155L, 1L, false);
        break;
        j = 2;
        break label1107;
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
      paramadw = (aig)new aig().parseFrom(paramArrayOfByte);
      br.aO(w.a(paramadw.ZqL), paramadw.ZqO);
      AppMethodBeat.o(116876);
      return;
      paramadw = (ain)new ain().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramadw.ZqR;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        br.E(w.a(paramadw.ZqL), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
      break;
      continue;
      break label615;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.d
 * JD-Core Version:    0.7.0.1
 */