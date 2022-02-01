package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.d;
import com.tencent.mm.aq.a;
import com.tencent.mm.ax.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.List;

public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.u
{
  private static boolean afS(String paramString)
  {
    AppMethodBeat.i(116878);
    if ((w.sI(paramString)) && (!b.azo()))
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
    cs localcs = parama.fTo;
    if ((10008 == com.tencent.mm.platformtools.ab.hVC) && (com.tencent.mm.platformtools.ab.hVD != 0))
    {
      ad.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(localcs.uKZ), Integer.valueOf(com.tencent.mm.platformtools.ab.hVD) });
      localcs.uKZ = com.tencent.mm.platformtools.ab.hVD;
      com.tencent.mm.platformtools.ab.hVD = 0;
    }
    if (((k)g.ab(k.class)).cOI().ro(localcs.uKZ))
    {
      ad.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
      AppMethodBeat.o(116877);
      return null;
    }
    String str = z.a(localcs.Cxx);
    Object localObject = z.a(localcs.Cxy);
    if ((str.equals(com.tencent.mm.model.u.aqG())) && (((String)localObject).equals("newsapp")) && (localcs.saz != 51))
    {
      ad.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", new Object[] { Long.valueOf(localcs.uKZ), Integer.valueOf(localcs.saz) });
      AppMethodBeat.o(116877);
      return null;
    }
    ad.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", new Object[] { str, localObject, Long.valueOf(localcs.uKZ), Integer.valueOf(localcs.uKX), Integer.valueOf(localcs.CxE), Integer.valueOf(localcs.mBi), Integer.valueOf(localcs.saz), Integer.valueOf(localcs.CreateTime), bt.vJ(localcs.CreateTime), Long.valueOf(bt.aGK() - localcs.CreateTime), Integer.valueOf(localcs.CxA), Integer.valueOf(z.a(localcs.CxB, new byte[0]).length), Integer.valueOf(bt.nullAsNil(localcs.CxC).length()), Integer.valueOf(bt.nullAsNil(localcs.CxD).length()), bt.aGs(z.a(localcs.Cxz, "")) });
    ad.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { localcs.CxC, "" });
    y.j(localcs);
    if (str.equals("readerapp"))
    {
      localcs.Cxx = z.BE("newsapp");
      localcs.saz = 12399999;
    }
    if (((str.equals("blogapp")) || (str.equals("newsapp"))) && (localcs.saz != 10002)) {
      localcs.saz = 12399999;
    }
    if (localcs.saz == 52) {
      localcs.saz = 1000052;
    }
    if (localcs.saz == 53) {
      localcs.saz = 1000053;
    }
    bi.c(parama);
    int i = 0;
    f.b localb = null;
    f localf = f.d.ca(Integer.valueOf(localcs.saz));
    localObject = localf;
    if (localf == null) {
      localObject = f.d.ca(str);
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
      ad.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", new Object[] { Integer.valueOf(localcs.saz), Long.valueOf(localcs.uKZ), Integer.valueOf(localcs.CxE), Integer.valueOf(localcs.CreateTime), parama });
    }
    for (;;)
    {
      i = 1;
      y.b(5, localcs);
      if (i == 0) {
        ad.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", new Object[] { Integer.valueOf(localcs.saz) });
      }
      AppMethodBeat.o(116877);
      return localb;
      label692:
      localObject = localb.dbD;
      break;
      label701:
      if (!afS(str))
      {
        ad.d("MicroMsg.MessageSyncExtension", " msg , id =" + ((du)localObject).field_msgId + "  " + paramx);
        if ((((du)localObject).field_msgId > 0L) && (paramx != null) && (localb.gVm)) {
          paramx.a((bl)localObject, localcs);
        }
      }
    }
  }
  
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
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
    switch (paramxd.CYY)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(116876);
      return;
    case 5: 
      paramArrayOfByte = (cs)new cs().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        paramxd = new f.a(paramArrayOfByte, false, false, false);
        processAddMsg(paramxd, paramx);
        if (!paramxd.gVg)
        {
          paramxd = bj.asl();
          paramx = z.a(paramArrayOfByte.Cxx);
          l1 = paramArrayOfByte.uKZ;
          l2 = paramArrayOfByte.CreateTime * 1000L;
          n = paramArrayOfByte.saz;
          if (paramx != null)
          {
            try
            {
              paramArrayOfByte = com.tencent.mm.model.u.aqG();
              if (paramArrayOfByte != null)
              {
                paramBoolean = paramArrayOfByte.equals(paramx);
                if (paramBoolean)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
              }
              paramArrayOfByte = ((k)g.ab(k.class)).apM().aHY(paramx);
              if (paramx.endsWith("@chatroom"))
              {
                i = paramArrayOfByte.evx;
                if (i == 0)
                {
                  AppMethodBeat.o(116876);
                  return;
                }
                ad.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", new Object[] { paramx });
              }
              do
              {
                l3 = ce.asQ();
                if (l3 > 0L) {
                  break label343;
                }
                ad.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                AppMethodBeat.o(116876);
                return;
                if ((w.tk(paramx)) || (af.aHE(paramx)) || (af.aHG(paramx)) || (w.tg(paramx)) || (af.st(paramx))) {
                  break;
                }
                paramBoolean = paramArrayOfByte.eKB();
              } while (!paramBoolean);
              AppMethodBeat.o(116876);
              return;
            }
            catch (Exception paramxd)
            {
              ad.e("MicroMsg.MsgReporter", "something about contact has exception:%s", new Object[] { paramxd.getMessage() });
              AppMethodBeat.o(116876);
              return;
            }
            l4 = System.currentTimeMillis();
            l5 = l3 - l2;
            ad.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), paramx, Long.valueOf(l1), Integer.valueOf(n) });
            paramBoolean = a.mo(l2);
            if (paramBoolean)
            {
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 100L, 1L, false);
              k = 0;
              m = 0;
              if (!paramBoolean) {
                break label712;
              }
              j = m;
              i = k;
              if (l3 - paramxd.gOA[11] >= 86400000L)
              {
                com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 210L, 1L, false);
                paramxd.gOA[11] = l3;
                i = 1;
                j = m;
              }
              label503:
              k = bj.gOu.length - 1;
              label511:
              if (k < 0) {
                break label2374;
              }
              if (l5 < bj.gOu[k]) {
                break label863;
              }
              if (!paramBoolean) {
                break label770;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, bj.gOv[k], 1L, false);
              label550:
              if (!paramBoolean) {
                break label791;
              }
              if (l3 - paramxd.gOA[k] < 86400000L) {
                break label2371;
              }
              com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, bj.gOx[k], 1L, false);
              paramxd.gOA[k] = l3;
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
        if (i < paramxd.gOA.length)
        {
          if (bt.iY(i, paramxd.gOA.length - 1)) {
            paramArrayOfByte.append(paramxd.gOA[i]);
          }
          for (;;)
          {
            i += 1;
            break label649;
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 101L, 1L, false);
            break;
            j = m;
            i = k;
            if (l3 - paramxd.gOB[11] < 86400000L) {
              break label503;
            }
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 211L, 1L, false);
            paramxd.gOB[11] = l3;
            j = 1;
            i = k;
            break label503;
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, bj.gOw[k], 1L, false);
            break label550;
            if (l3 - paramxd.gOB[k] < 86400000L) {
              break label2371;
            }
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, bj.gOy[k], 1L, false);
            paramxd.gOB[k] = l3;
            j = 1;
            break label601;
            a.a(k, l3, l4, l2, l5, l1, paramx, n);
            break label633;
            k -= 1;
            break label511;
            paramArrayOfByte.append(paramxd.gOA[i] + ",");
          }
        }
        g.afB().afk().set(ae.a.Fxx, paramArrayOfByte.toString());
      }
      label712:
      label841:
      label863:
      if (j != 0)
      {
        paramArrayOfByte = new StringBuilder();
        i = 0;
        if (i < paramxd.gOB.length)
        {
          if (bt.iY(i, paramxd.gOB.length - 1)) {
            paramArrayOfByte.append(paramxd.gOB[i]);
          }
          for (;;)
          {
            i += 1;
            break;
            paramArrayOfByte.append(paramxd.gOB[i] + ",");
          }
        }
        g.afB().afk().set(ae.a.Fxy, paramArrayOfByte.toString());
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
        paramxd = "";
        try
        {
          paramArrayOfByte = Build.MANUFACTURER;
          paramxd = paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            ad.e("MicroMsg.MsgReporter", "kvReport %s %s", new Object[] { paramArrayOfByte.getClass().getSimpleName(), paramArrayOfByte.getMessage() });
          }
        }
        com.tencent.mm.plugin.report.e.vIY.f(17828, new Object[] { Integer.valueOf(j), Long.valueOf(l5), Integer.valueOf(i), Long.valueOf(l1), paramxd });
        AppMethodBeat.o(116876);
        return;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 113L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 118L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 112L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 117L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 111L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 116L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 110L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 115L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 123L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 128L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 122L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 127L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 121L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 126L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 120L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 125L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 133L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 138L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 132L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 137L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 131L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 136L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 130L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 135L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 143L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 148L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 142L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 147L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 141L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 146L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 140L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 145L, 1L, false);
        break;
        if (l5 >= 60000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 153L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 158L, 1L, false);
          break;
        }
        if (l5 >= 30000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 152L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 157L, 1L, false);
          break;
        }
        if (l5 >= 10000L)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 151L, 1L, false);
            break;
          }
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 156L, 1L, false);
          break;
        }
        if (l5 < 0L) {
          break;
        }
        if (paramBoolean)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 150L, 1L, false);
          break;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(780L, 155L, 1L, false);
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
      paramxd = (zz)new zz().parseFrom(paramArrayOfByte);
      bi.Y(z.a(paramxd.Dby), paramxd.DbB);
      AppMethodBeat.o(116876);
      return;
      paramxd = (aag)new aag().parseFrom(paramArrayOfByte);
      paramArrayOfByte = paramxd.DbE;
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        bi.z(z.a(paramxd.Dby), ((Integer)paramArrayOfByte.get(i)).intValue());
        i += 1;
      }
      break;
      continue;
      break label601;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */