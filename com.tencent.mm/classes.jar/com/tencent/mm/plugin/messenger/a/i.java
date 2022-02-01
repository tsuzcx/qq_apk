package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.dp;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import com.tencent.mm.util.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.g, c
{
  private static Map<String, Long> uGc;
  private int uGd;
  private Map<String, String> uGe;
  private Set<Long> uGf;
  public final p uGg;
  
  static
  {
    AppMethodBeat.i(198586);
    uGc = new HashMap();
    AppMethodBeat.o(198586);
  }
  
  public i()
  {
    AppMethodBeat.i(198574);
    this.uGd = -1;
    this.uGe = new HashMap();
    this.uGf = new HashSet();
    this.uGg = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final f.a paramAnonymousa)
      {
        AppMethodBeat.i(198572);
        if ("pat".equals(paramAnonymousString)) {
          com.tencent.e.h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198571);
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              ac.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str2, str1, str3, str4 });
              if (!i.this.dci())
              {
                AppMethodBeat.o(198571);
                return;
              }
              if (!bs.T(new String[] { str2, str1, str3 }))
              {
                if (!str1.equals(u.axw())) {
                  break label294;
                }
                str1 = str2;
              }
              label294:
              for (;;)
              {
                if (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcm().akT(str1))
                {
                  bo localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(str1);
                  if ((localbo != null) && (localbo.field_msgId > 0L) && (localbo.getType() == 889192497))
                  {
                    i.a(localbo, str2, str3, str4, paramAnonymousa.fXi.CreateTime * 1000L, paramAnonymousa.fXi.vTQ);
                    AppMethodBeat.o(198571);
                    return;
                  }
                }
                i.c(str1, str2, str3, str4, paramAnonymousa.fXi.CreateTime * 1000L, paramAnonymousa.fXi.vTQ);
                AppMethodBeat.o(198571);
                return;
              }
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(198572);
      }
    };
    AppMethodBeat.o(198574);
  }
  
  public final String a(cdh paramcdh)
  {
    AppMethodBeat.i(198575);
    paramcdh = d.b(paramcdh);
    AppMethodBeat.o(198575);
    return paramcdh;
  }
  
  public final cdh akH(String paramString)
  {
    AppMethodBeat.i(198576);
    paramString = d.aRW(paramString);
    AppMethodBeat.o(198576);
    return paramString;
  }
  
  public final String c(String paramString1, String paramString2, List<Pair<Integer, Integer>> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(198579);
    Object localObject3 = k.akL(paramString1);
    Object localObject2;
    Object localObject1;
    Object localObject4;
    if (this.uGe.containsKey(paramString1))
    {
      ac.i("MicroMsg.PatMsgExtension", "find %s (%s) in cache", new Object[] { paramString1, this.uGe.get(paramString1) });
      localObject2 = (String)this.uGe.get(paramString1);
      if (this.uGd == -1) {
        this.uGd = ((a)com.tencent.mm.kernel.g.ab(a.class)).ZY().getInt("SendPatUserShowBitVal", 0);
      }
      ac.i("MicroMsg.PatMsgExtension", "sendPat nick clickable %d", new Object[] { Integer.valueOf(this.uGd) });
      if ((this.uGd != 0) && (paramList != null) && (paramList1 != null))
      {
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (k.a)((Iterator)localObject1).next();
          localObject4 = v.getDisplayName(((k.a)localObject3).value, paramString2);
          int i = ((String)localObject2).indexOf((String)localObject4);
          paramList.add(Pair.create(Integer.valueOf(i), Integer.valueOf(((String)localObject4).length() + i)));
          paramList1.add(((k.a)localObject3).value);
        }
      }
    }
    else
    {
      localObject4 = ((List)localObject3).iterator();
      String str;
      for (localObject1 = paramString1;; localObject1 = ((String)localObject1).replace(((k.a)localObject2).group, str))
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject2 = (k.a)((Iterator)localObject4).next();
        str = v.getDisplayName(((k.a)localObject2).value, paramString2);
      }
    }
    this.uGe.put(paramString1, localObject2);
    AppMethodBeat.o(198579);
    return localObject2;
  }
  
  public final void dch()
  {
    AppMethodBeat.i(198583);
    this.uGe.clear();
    AppMethodBeat.o(198583);
  }
  
  public final boolean dci()
  {
    AppMethodBeat.i(198577);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).ZY().getInt("DisableSendPat", 1);
    ac.i("MicroMsg.PatMsgExtension", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      AppMethodBeat.o(198577);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(198577);
      return true;
    }
    AppMethodBeat.o(198577);
    return false;
  }
  
  public final void hD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198581);
    long l = System.currentTimeMillis();
    if (!dci())
    {
      AppMethodBeat.o(198581);
      return;
    }
    if (((!w.wp(paramString1)) && (!w.wn(paramString1))) || (w.xn(paramString1)) || (w.xs(paramString1)) || (w.xj(paramString1)) || (w.wH(paramString1)))
    {
      ac.i("MicroMsg.PatMsgExtension", "talker %s cannot be patted!", new Object[] { paramString1 });
      AppMethodBeat.o(198581);
      return;
    }
    Object localObject3 = u.axw();
    Object localObject1 = new dp();
    if (w.wp(paramString1))
    {
      ((dp)localObject1).dHw = 2;
      ((dp)localObject1).lD(paramString1);
      ((dp)localObject1).lB((String)localObject3);
      ((dp)localObject1).lC(paramString2);
      ((dp)localObject1).dSr = l;
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alk(paramString1);
      if ((localObject2 != null) && (((dy)localObject2).field_msgId > 0L)) {
        if (((bo)localObject2).getType() != 889192497) {
          break label316;
        }
      }
    }
    label316:
    for (((dp)localObject1).dSu = (l - ((cdi)((c)com.tencent.mm.kernel.g.ab(c.class)).akH(((dy)localObject2).field_content).ulR.getLast()).createTime);; ((dp)localObject1).dSu = (l - ((dy)localObject2).field_createTime))
    {
      if ((!uGc.containsKey(paramString2)) || (l - ((Long)uGc.get(paramString2)).longValue() >= 10000L)) {
        break label331;
      }
      ac.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(10000) });
      ((dp)localObject1).dSv = 1;
      ((dp)localObject1).aHZ();
      AppMethodBeat.o(198581);
      return;
      ((dp)localObject1).dHw = 1;
      break;
    }
    label331:
    ((dp)localObject1).aHZ();
    uGc.put(paramString2, Long.valueOf(l));
    com.tencent.mm.kernel.g.agi().a(new h(paramString1, paramString2), 0);
    Object localObject2 = u.axw();
    localObject1 = "";
    if (paramString2.equals(localObject3)) {
      localObject1 = ai.getContext().getString(2131766389);
    }
    for (;;)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("<sysmsg type=\"pat\">");
      ((StringBuilder)localObject3).append("<pat>");
      ((StringBuilder)localObject3).append("<fromusername>").append((String)localObject2).append("</fromusername>");
      ((StringBuilder)localObject3).append("<chatusername>").append(paramString1).append("</chatusername>");
      ((StringBuilder)localObject3).append("<pattedusername>").append(paramString2).append("</pattedusername>");
      ((StringBuilder)localObject3).append("<template>").append(bv.aLR((String)localObject1)).append("</template>");
      ((StringBuilder)localObject3).append("</pat>");
      ((StringBuilder)localObject3).append("</sysmsg>");
      paramString2 = new cu();
      paramString2.DPV = z.FI(((StringBuilder)localObject3).toString());
      paramString2.DPT = z.FI((String)localObject2);
      paramString2.DPU = z.FI(paramString1);
      paramString2.tit = 10002;
      paramString2.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      paramString1 = new f.a(paramString2, false, false, false);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b(paramString1);
      AppMethodBeat.o(198581);
      return;
      if (((String)localObject2).equals(localObject3)) {
        localObject1 = ai.getContext().getString(2131766390) + " \"${" + paramString2 + "}\"";
      }
    }
  }
  
  public final String hE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198578);
    paramString1 = c(paramString1, paramString2, null, null);
    AppMethodBeat.o(198578);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(198582);
    ac.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    dp localdp;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(ai.getContext(), ai.getContext().getString(2131755733) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramString = ((cuq)((h)paramn).hEg.hvr.hvw).FFU;
      paramn = ((cuq)((h)paramn).hEg.hvr.hvw).FFV;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        com.tencent.e.h.JZN.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198573);
            bo localbo = new bo();
            localbo.setContent(ai.getContext().getString(2131766388));
            localbo.setType(10000);
            localbo.jT(0);
            localbo.re(paramString);
            localbo.oA(System.currentTimeMillis());
            ac.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bi.u(localbo)) });
            AppMethodBeat.o(198573);
          }
        });
      }
      localdp = new dp();
      if (!w.wp(paramString)) {
        break label248;
      }
      localdp.dHw = 2;
      localdp.lD(paramString);
    }
    for (;;)
    {
      localdp.lB(u.axw());
      localdp.lC(paramn);
      localdp.dSr = System.currentTimeMillis();
      localdp.dSt = paramInt2;
      localdp.aHZ();
      AppMethodBeat.o(198582);
      return;
      label248:
      localdp.dHw = 1;
    }
  }
  
  public final boolean vO(long paramLong)
  {
    AppMethodBeat.i(198580);
    if (this.uGf.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(198580);
      return true;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(paramLong);
    if (((dy)localObject).field_msgId > 0L)
    {
      localObject = d.aRW(((dy)localObject).field_content).ulR.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((cdi)((Iterator)localObject).next()).Fsa == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.uGf.add(Long.valueOf(paramLong));
        AppMethodBeat.o(198580);
        return true;
      }
    }
    AppMethodBeat.o(198580);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.i
 * JD-Core Version:    0.7.0.1
 */