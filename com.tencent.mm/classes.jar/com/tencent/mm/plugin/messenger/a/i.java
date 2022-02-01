package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.c.du;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.util.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class i
  implements com.tencent.mm.al.g, c
{
  private static Map<String, Long> txE;
  private int txF;
  private Map<String, String> txG;
  private Set<Long> txH;
  public final p txI;
  
  static
  {
    AppMethodBeat.i(196702);
    txE = new HashMap();
    AppMethodBeat.o(196702);
  }
  
  public i()
  {
    AppMethodBeat.i(196690);
    this.txF = -1;
    this.txG = new HashMap();
    this.txH = new HashSet();
    this.txI = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, final Map<String, String> paramAnonymousMap, final f.a paramAnonymousa)
      {
        AppMethodBeat.i(196688);
        if ("pat".equals(paramAnonymousString)) {
          com.tencent.e.h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196687);
              String str2 = (String)paramAnonymousMap.get(".sysmsg.pat.fromusername");
              String str1 = (String)paramAnonymousMap.get(".sysmsg.pat.chatusername");
              String str3 = (String)paramAnonymousMap.get(".sysmsg.pat.pattedusername");
              String str4 = (String)paramAnonymousMap.get(".sysmsg.pat.template");
              ad.i("MicroMsg.PatMsgExtension", "fromUser: %s, chatUser: %s, pattedUser: %s, template:%s", new Object[] { str2, str1, str3, str4 });
              if (!i.this.cOz())
              {
                AppMethodBeat.o(196687);
                return;
              }
              if (!bt.T(new String[] { str2, str1, str3 }))
              {
                if (!str1.equals(u.aqG())) {
                  break label294;
                }
                str1 = str2;
              }
              label294:
              for (;;)
              {
                if (!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOD().afZ(str1))
                {
                  bl localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(str1);
                  if ((localbl != null) && (localbl.field_msgId > 0L) && (localbl.getType() == 889192497))
                  {
                    i.a(localbl, str2, str3, str4, paramAnonymousa.fTo.CreateTime * 1000L, paramAnonymousa.fTo.uKZ);
                    AppMethodBeat.o(196687);
                    return;
                  }
                }
                i.c(str1, str2, str3, str4, paramAnonymousa.fTo.CreateTime * 1000L, paramAnonymousa.fTo.uKZ);
                AppMethodBeat.o(196687);
                return;
              }
            }
          }, "HandlePatMsg");
        }
        AppMethodBeat.o(196688);
      }
    };
    AppMethodBeat.o(196690);
  }
  
  public final String a(byl parambyl)
  {
    AppMethodBeat.i(196691);
    parambyl = d.b(parambyl);
    AppMethodBeat.o(196691);
    return parambyl;
  }
  
  public final byl afN(String paramString)
  {
    AppMethodBeat.i(196692);
    paramString = d.aMu(paramString);
    AppMethodBeat.o(196692);
    return paramString;
  }
  
  public final String c(String paramString1, String paramString2, List<Pair<Integer, Integer>> paramList, List<String> paramList1)
  {
    AppMethodBeat.i(196695);
    Object localObject3 = k.afR(paramString1);
    Object localObject2;
    Object localObject1;
    Object localObject4;
    if (this.txG.containsKey(paramString1))
    {
      ad.i("MicroMsg.PatMsgExtension", "find %s (%s) in cache", new Object[] { paramString1, this.txG.get(paramString1) });
      localObject2 = (String)this.txG.get(paramString1);
      if (this.txF == -1) {
        this.txF = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("SendPatUserShowBitVal", 0);
      }
      ad.i("MicroMsg.PatMsgExtension", "sendPat nick clickable %d", new Object[] { Integer.valueOf(this.txF) });
      if ((this.txF != 0) && (paramList != null) && (paramList1 != null))
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
    this.txG.put(paramString1, localObject2);
    AppMethodBeat.o(196695);
    return localObject2;
  }
  
  public final void cOy()
  {
    AppMethodBeat.i(196699);
    this.txG.clear();
    AppMethodBeat.o(196699);
  }
  
  public final boolean cOz()
  {
    AppMethodBeat.i(196693);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("DisableSendPat", 1);
    ad.i("MicroMsg.PatMsgExtension", "disable sendPat %d", new Object[] { Integer.valueOf(i) });
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      AppMethodBeat.o(196693);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(196693);
      return true;
    }
    AppMethodBeat.o(196693);
    return false;
  }
  
  public final void hk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196697);
    long l = System.currentTimeMillis();
    if (!cOz())
    {
      AppMethodBeat.o(196697);
      return;
    }
    if (((!w.sm(paramString1)) && (!w.sk(paramString1))) || (w.tk(paramString1)) || (w.tp(paramString1)) || (w.tg(paramString1)) || (w.sE(paramString1)))
    {
      ad.i("MicroMsg.PatMsgExtension", "talker %s cannot be patted!", new Object[] { paramString1 });
      AppMethodBeat.o(196697);
      return;
    }
    Object localObject3 = u.aqG();
    Object localObject1 = new cb();
    if (w.sm(paramString1))
    {
      ((cb)localObject1).dJu = 2;
      ((cb)localObject1).iN(paramString1);
      ((cb)localObject1).iL((String)localObject3);
      ((cb)localObject1).iM(paramString2);
      ((cb)localObject1).dQC = l;
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agq(paramString1);
      if ((localObject2 != null) && (((du)localObject2).field_msgId > 0L)) {
        if (((bl)localObject2).getType() != 889192497) {
          break label316;
        }
      }
    }
    label316:
    for (((cb)localObject1).dQF = (l - ((bym)((c)com.tencent.mm.kernel.g.ab(c.class)).afN(((du)localObject2).field_content).tdC.getLast()).createTime);; ((cb)localObject1).dQF = (l - ((du)localObject2).field_createTime))
    {
      if ((!txE.containsKey(paramString2)) || (l - ((Long)txE.get(paramString2)).longValue() >= 10000L)) {
        break label331;
      }
      ad.w("MicroMsg.PatMsgExtension", "pat (%s) last time from now < %d", new Object[] { paramString2, Integer.valueOf(10000) });
      ((cb)localObject1).dQG = 1;
      ((cb)localObject1).aBj();
      AppMethodBeat.o(196697);
      return;
      ((cb)localObject1).dJu = 1;
      break;
    }
    label331:
    ((cb)localObject1).aBj();
    txE.put(paramString2, Long.valueOf(l));
    com.tencent.mm.kernel.g.aeS().a(new h(paramString1, paramString2), 0);
    Object localObject2 = u.aqG();
    localObject1 = "";
    if (paramString2.equals(localObject3)) {
      localObject1 = aj.getContext().getString(2131766389);
    }
    for (;;)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("<sysmsg type=\"pat\">");
      ((StringBuilder)localObject3).append("<pat>");
      ((StringBuilder)localObject3).append("<fromusername>").append((String)localObject2).append("</fromusername>");
      ((StringBuilder)localObject3).append("<chatusername>").append(paramString1).append("</chatusername>");
      ((StringBuilder)localObject3).append("<pattedusername>").append(paramString2).append("</pattedusername>");
      ((StringBuilder)localObject3).append("<template>").append(bw.aGA((String)localObject1)).append("</template>");
      ((StringBuilder)localObject3).append("</pat>");
      ((StringBuilder)localObject3).append("</sysmsg>");
      paramString2 = new cs();
      paramString2.Cxz = z.BE(((StringBuilder)localObject3).toString());
      paramString2.Cxx = z.BE((String)localObject2);
      paramString2.Cxy = z.BE(paramString1);
      paramString2.saz = 10002;
      paramString2.CreateTime = ((int)(System.currentTimeMillis() / 1000L));
      paramString1 = new f.a(paramString2, false, false, false);
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b(paramString1);
      AppMethodBeat.o(196697);
      return;
      if (((String)localObject2).equals(localObject3)) {
        localObject1 = aj.getContext().getString(2131766390) + " \"${" + paramString2 + "}\"";
      }
    }
  }
  
  public final String hl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196694);
    paramString1 = c(paramString1, paramString2, null, null);
    AppMethodBeat.o(196694);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(196698);
    ad.i("MicroMsg.PatMsgExtension", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    cb localcb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(aj.getContext(), aj.getContext().getString(2131755733) + "(" + paramInt1 + "," + paramInt2 + ")", 0).show();
      paramString = ((cpj)((h)paramn).hdD.gUS.gUX).EiW;
      paramn = ((cpj)((h)paramn).hdD.gUS.gUX).EiX;
      if ((paramInt2 != -22) && (paramInt2 != -44)) {
        com.tencent.e.h.Iye.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196689);
            bl localbl = new bl();
            localbl.setContent(aj.getContext().getString(2131766388));
            localbl.setType(10000);
            localbl.jV(0);
            localbl.nY(paramString);
            localbl.kY(System.currentTimeMillis());
            ad.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bi.u(localbl)) });
            AppMethodBeat.o(196689);
          }
        });
      }
      localcb = new cb();
      if (!w.sm(paramString)) {
        break label248;
      }
      localcb.dJu = 2;
      localcb.iN(paramString);
    }
    for (;;)
    {
      localcb.iL(u.aqG());
      localcb.iM(paramn);
      localcb.dQC = System.currentTimeMillis();
      localcb.dQE = paramInt2;
      localcb.aBj();
      AppMethodBeat.o(196698);
      return;
      label248:
      localcb.dJu = 1;
    }
  }
  
  public final boolean rl(long paramLong)
  {
    AppMethodBeat.i(196696);
    if (this.txH.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(196696);
      return true;
    }
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(paramLong);
    if (((du)localObject).field_msgId > 0L)
    {
      localObject = d.aMu(((du)localObject).field_content).tdC.iterator();
      int i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (((bym)((Iterator)localObject).next()).DVm == 1) {}
        for (int j = 1;; j = 0)
        {
          i = j & i;
          break;
        }
      }
      if (i != 0)
      {
        this.txH.add(Long.valueOf(paramLong));
        AppMethodBeat.o(196696);
        return true;
      }
    }
    AppMethodBeat.o(196696);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.i
 * JD-Core Version:    0.7.0.1
 */