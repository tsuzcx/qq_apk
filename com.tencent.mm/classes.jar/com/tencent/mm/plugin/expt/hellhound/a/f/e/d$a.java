package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.plugin.expt.hellhound.b.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
public final class d$a
{
  private static void a(Object paramObject, View paramView, dwc paramdwc, long paramLong, List<? extends dbi> paramList)
  {
    AppMethodBeat.i(210971);
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    label17:
    if (localIterator1.hasNext())
    {
      dbi localdbi = (dbi)localIterator1.next();
      paramList = localdbi.Hrb;
      p.g(paramList, "it.viewOps");
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      Object localObject;
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label17;
        }
        localObject = (dwd)localIterator2.next();
        ad.i("HABBYGE-MALI.HellViewParamsCatcher", "catchParams: page=" + localdbi.dtL + ", " + paramdwc.id + " == " + ((dwd)localObject).aQj + ", " + paramdwc.HIB + " == " + ((dwd)localObject).HIB);
        paramList = g.qSQ;
        p.g(localObject, "viewOpIt");
        if (!g.a.a(paramdwc, (dwd)localObject)) {
          break;
        }
        switch (((dwd)localObject).type)
        {
        }
      }
      for (paramList = paramView;; paramList = paramObject)
      {
        localObject = ((dwd)localObject).Hra.iterator();
        while (((Iterator)localObject).hasNext())
        {
          chj localchj = (chj)((Iterator)localObject).next();
          if (localchj != null) {
            b.a(paramList, localchj, paramLong, paramdwc);
          }
        }
      }
    }
    AppMethodBeat.o(210971);
  }
  
  public static void b(View paramView, dwc paramdwc)
  {
    AppMethodBeat.i(210970);
    if (paramdwc == null)
    {
      AppMethodBeat.o(210970);
      return;
    }
    Object localObject2 = a.cnA();
    if (localObject2 == null)
    {
      AppMethodBeat.o(210970);
      return;
    }
    p.g(d.cpU(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject1 = d.cpV();
    if (localObject1 == null)
    {
      ad.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
      AppMethodBeat.o(210970);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
    p.g(localObject3, "HellSessionMonitor.getInstance()");
    localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).cpG();
    ad.w("HABBYGE-MALI.HellViewParamsCatcher", "catchBizParams2ViewNode: curSid=".concat(String.valueOf(localObject3)));
    Iterator localIterator1 = ((dbj)localObject1).Hrc.iterator();
    while (localIterator1.hasNext())
    {
      dbm localdbm = (dbm)localIterator1.next();
      if ((localdbm != null) && ((!(p.i(localdbm.qXk, localObject3) ^ true)) || (!(p.i("-1", localdbm.qXk) ^ true))))
      {
        localObject1 = localObject2.getClass().getName();
        Object localObject4 = e.qZn;
        p.g(localObject1, "curPageName");
        p.h(localObject1, "curPageName");
        p.h(localdbm, "pathConfig");
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx((String)localObject1);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = (List)localObject4)
        {
          if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
            break label316;
          }
          ad.w("HABBYGE-MALI.HellViewParamsCatcher", "doCatch, isPageLegal: FALSE!!");
          break;
          p.g(localObject1, "HellhoundUtil.getShortNa…rPageName) ?: return null");
          localObject4 = new ArrayList();
          Iterator localIterator2 = localdbm.Hrg.iterator();
          while (localIterator2.hasNext())
          {
            dbi localdbi = (dbi)localIterator2.next();
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localdbi.dtL);
            if ((str != null) && (p.i(localObject1, str))) {
              ((ArrayList)localObject4).add(localdbi);
            }
          }
        }
        label316:
        localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
        localObject4 = paramdwc.id;
        p.g(localObject4, "viewNode.id");
        paramdwc.HIB = a.a.b((String)localObject4, (List)localObject1, paramdwc.HIB);
        a(localObject2, paramView, paramdwc, localdbm.Gsl, (List)localObject1);
      }
    }
    AppMethodBeat.o(210970);
  }
  
  public static void c(dwc paramdwc)
  {
    AppMethodBeat.i(210969);
    if (paramdwc == null)
    {
      AppMethodBeat.o(210969);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu;
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.d.a.cps();
    if (localObject2 == null)
    {
      AppMethodBeat.o(210969);
      return;
    }
    localObject1 = (dbg)((Pair)localObject2).first;
    localObject2 = (Integer)((Pair)localObject2).second;
    Iterator localIterator = ((dbg)localObject1).Gsa.iterator();
    label271:
    for (;;)
    {
      Object localObject3;
      if (localIterator.hasNext())
      {
        Object localObject4 = (auc)localIterator.next();
        if ((localObject4 != null) && (!((auc)localObject4).Gsi.isEmpty()))
        {
          Object localObject5 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((auc)localObject4).Gsh.dtL);
          localObject3 = ((auc)localObject4).Gsi;
          p.g(localObject3, "path.pages");
          localObject3 = (aub)((LinkedList)localObject3).getLast();
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((aub)localObject3).name);
          if (p.i(str, localObject5))
          {
            ((aub)localObject3).Gsf.add(paramdwc);
          }
          else
          {
            localObject4 = ((auc)localObject4).Gsg.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject5 = (dbi)((Iterator)localObject4).next();
            } while ((localObject5 == null) || (!p.i(str, com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject5).dtL))));
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
          ((aub)localObject3).Gsf.add(paramdwc);
          break;
          paramdwc = com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu;
          p.g(localObject2, "index");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.a((dbg)localObject1, ((Integer)localObject2).intValue());
          AppMethodBeat.o(210969);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a
 * JD-Core Version:    0.7.0.1
 */