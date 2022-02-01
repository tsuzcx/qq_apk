package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.plugin.expt.hellhound.b.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
public final class d$a
{
  private static void a(Object paramObject, View paramView, dwx paramdwx, long paramLong, List<? extends dcc> paramList)
  {
    AppMethodBeat.i(196642);
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    label17:
    if (localIterator1.hasNext())
    {
      dcc localdcc = (dcc)localIterator1.next();
      paramList = localdcc.HKD;
      p.g(paramList, "it.viewOps");
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      Object localObject;
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label17;
        }
        localObject = (dwy)localIterator2.next();
        ae.i("HABBYGE-MALI.HellViewParamsCatcher", "catchParams: page=" + localdcc.duQ + ", " + paramdwx.id + " == " + ((dwy)localObject).aQj + ", " + paramdwx.Icn + " == " + ((dwy)localObject).Icn);
        paramList = g.raO;
        p.g(localObject, "viewOpIt");
        if (!g.a.a(paramdwx, (dwy)localObject)) {
          break;
        }
        switch (((dwy)localObject).type)
        {
        }
      }
      for (paramList = paramView;; paramList = paramObject)
      {
        localObject = ((dwy)localObject).HKC.iterator();
        while (((Iterator)localObject).hasNext())
        {
          cid localcid = (cid)((Iterator)localObject).next();
          if (localcid != null) {
            b.a(paramList, localcid, paramLong, paramdwx);
          }
        }
      }
    }
    AppMethodBeat.o(196642);
  }
  
  public static void b(View paramView, dwx paramdwx)
  {
    AppMethodBeat.i(196641);
    if (paramdwx == null)
    {
      AppMethodBeat.o(196641);
      return;
    }
    Object localObject2 = a.cpc();
    if (localObject2 == null)
    {
      AppMethodBeat.o(196641);
      return;
    }
    p.g(d.crw(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject1 = d.crx();
    if (localObject1 == null)
    {
      ae.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
      AppMethodBeat.o(196641);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
    p.g(localObject3, "HellSessionMonitor.getInstance()");
    localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).cri();
    ae.w("HABBYGE-MALI.HellViewParamsCatcher", "catchBizParams2ViewNode: curSid=".concat(String.valueOf(localObject3)));
    Iterator localIterator1 = ((dcd)localObject1).HKE.iterator();
    while (localIterator1.hasNext())
    {
      dcg localdcg = (dcg)localIterator1.next();
      if ((localdcg != null) && ((!(p.i(localdcg.rfp, localObject3) ^ true)) || (!(p.i("-1", localdcg.rfp) ^ true))))
      {
        localObject1 = localObject2.getClass().getName();
        Object localObject4 = e.rht;
        p.g(localObject1, "curPageName");
        p.h(localObject1, "curPageName");
        p.h(localdcg, "pathConfig");
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer((String)localObject1);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = (List)localObject4)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label316;
          }
          ae.w("HABBYGE-MALI.HellViewParamsCatcher", "doCatch, isPageLegal: FALSE!!");
          break;
          p.g(localObject1, "HellhoundUtil.getShortNa…rPageName) ?: return null");
          localObject4 = new ArrayList();
          Iterator localIterator2 = localdcg.HKI.iterator();
          while (localIterator2.hasNext())
          {
            dcc localdcc = (dcc)localIterator2.next();
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localdcc.duQ);
            if ((str != null) && (p.i(localObject1, str))) {
              ((ArrayList)localObject4).add(localdcc);
            }
          }
        }
        label316:
        localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
        localObject4 = paramdwx.id;
        p.g(localObject4, "viewNode.id");
        paramdwx.Icn = a.a.b((String)localObject4, (List)localObject1, paramdwx.Icn);
        a(localObject2, paramView, paramdwx, localdcg.GLJ, (List)localObject1);
      }
    }
    AppMethodBeat.o(196641);
  }
  
  public static void c(dwx paramdwx)
  {
    AppMethodBeat.i(196640);
    if (paramdwx == null)
    {
      AppMethodBeat.o(196640);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA;
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.d.a.cqU();
    if (localObject2 == null)
    {
      AppMethodBeat.o(196640);
      return;
    }
    localObject1 = (dca)((Pair)localObject2).first;
    localObject2 = (Integer)((Pair)localObject2).second;
    Iterator localIterator = ((dca)localObject1).GLy.iterator();
    label271:
    for (;;)
    {
      Object localObject3;
      if (localIterator.hasNext())
      {
        Object localObject4 = (aus)localIterator.next();
        if ((localObject4 != null) && (!((aus)localObject4).GLG.isEmpty()))
        {
          Object localObject5 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((aus)localObject4).GLF.duQ);
          localObject3 = ((aus)localObject4).GLG;
          p.g(localObject3, "path.pages");
          localObject3 = (aur)((LinkedList)localObject3).getLast();
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((aur)localObject3).name);
          if (p.i(str, localObject5))
          {
            ((aur)localObject3).GLD.add(paramdwx);
          }
          else
          {
            localObject4 = ((aus)localObject4).GLE.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject5 = (dcc)((Iterator)localObject4).next();
            } while ((localObject5 == null) || (!p.i(str, com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject5).duQ))));
          }
        }
      }
      else
      {
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label271;
          }
          ((aur)localObject3).GLD.add(paramdwx);
          break;
          paramdwx = com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA;
          p.g(localObject2, "index");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.a((dca)localObject1, ((Integer)localObject2).intValue());
          AppMethodBeat.o(196640);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a
 * JD-Core Version:    0.7.0.1
 */