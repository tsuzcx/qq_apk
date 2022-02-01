package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.plugin.expt.hellhound.b.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
public final class d$a
{
  private static void a(Object paramObject, View paramView, erd paramerd, long paramLong, List<? extends dvg> paramList)
  {
    AppMethodBeat.i(221134);
    Iterator localIterator1 = ((Iterable)paramList).iterator();
    label17:
    if (localIterator1.hasNext())
    {
      dvg localdvg = (dvg)localIterator1.next();
      paramList = localdvg.MWm;
      p.g(paramList, "it.viewOps");
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      Object localObject;
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label17;
        }
        localObject = (ere)localIterator2.next();
        Log.i("HABBYGE-MALI.HellViewParamsCatcher", "catchParams: page=" + localdvg.dMl + ", " + paramerd.id + " == " + ((ere)localObject).viewId + ", " + paramerd.NoL + " == " + ((ere)localObject).NoL);
        paramList = g.sBf;
        p.g(localObject, "viewOpIt");
        if (!g.a.a(paramerd, (ere)localObject)) {
          break;
        }
        switch (((ere)localObject).type)
        {
        }
      }
      for (paramList = paramView;; paramList = paramObject)
      {
        localObject = ((ere)localObject).MWl.iterator();
        while (((Iterator)localObject).hasNext())
        {
          cyk localcyk = (cyk)((Iterator)localObject).next();
          if (localcyk != null) {
            b.a(paramList, localcyk, paramLong, paramerd);
          }
        }
      }
    }
    AppMethodBeat.o(221134);
  }
  
  public static void b(View paramView, erd paramerd)
  {
    AppMethodBeat.i(221133);
    if (paramerd == null)
    {
      AppMethodBeat.o(221133);
      return;
    }
    Object localObject2 = a.cNw();
    if (localObject2 == null)
    {
      AppMethodBeat.o(221133);
      return;
    }
    p.g(d.cQe(), "HellSessionPageCloudConfig.getInstance()");
    Object localObject1 = d.cQf();
    if (localObject1 == null)
    {
      Log.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
      AppMethodBeat.o(221133);
      return;
    }
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
    p.g(localObject3, "HellSessionMonitor.getInstance()");
    localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).cPQ();
    Iterator localIterator1 = ((dvh)localObject1).MWn.iterator();
    label336:
    while (localIterator1.hasNext())
    {
      dvk localdvk = (dvk)localIterator1.next();
      if ((localdvk != null) && ((!(p.j(localdvk.sGF, localObject3) ^ true)) || (!(p.j("-1", localdvk.sGF) ^ true))))
      {
        localObject1 = localObject2.getClass().getName();
        p.g(localObject1, "pageObj.javaClass.name");
        Object localObject4 = e.sIP;
        p.h(localObject1, "curPageName");
        p.h(localdvk, "pathConfig");
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE((String)localObject1);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = (List)localObject4)
        {
          if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
            break label336;
          }
          localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
          localObject4 = paramerd.id;
          p.g(localObject4, "viewNode.id");
          paramerd.NoL = a.a.b((String)localObject4, (List)localObject1, paramerd.NoL);
          a(localObject2, paramView, paramerd, localdvk.LPN, (List)localObject1);
          break;
          p.g(localObject1, "HellhoundUtil.getShortNa…rPageName) ?: return null");
          localObject4 = new ArrayList();
          Iterator localIterator2 = localdvk.MWr.iterator();
          while (localIterator2.hasNext())
          {
            dvg localdvg = (dvg)localIterator2.next();
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localdvg.dMl);
            if ((str != null) && (p.j(localObject1, str))) {
              ((ArrayList)localObject4).add(localdvg);
            }
          }
        }
      }
    }
    AppMethodBeat.o(221133);
  }
  
  public static void c(erd paramerd)
  {
    AppMethodBeat.i(221132);
    if (paramerd == null)
    {
      AppMethodBeat.o(221132);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.d.a.cPC();
    if (localObject2 == null)
    {
      AppMethodBeat.o(221132);
      return;
    }
    localObject1 = (dve)((Pair)localObject2).first;
    localObject2 = (Integer)((Pair)localObject2).second;
    Iterator localIterator = ((dve)localObject1).LPC.iterator();
    label271:
    for (;;)
    {
      Object localObject3;
      if (localIterator.hasNext())
      {
        Object localObject4 = (bgb)localIterator.next();
        if ((localObject4 != null) && (!((bgb)localObject4).LPK.isEmpty()))
        {
          Object localObject5 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((bgb)localObject4).LPJ.dMl);
          localObject3 = ((bgb)localObject4).LPK;
          p.g(localObject3, "path.pages");
          localObject3 = (bga)((LinkedList)localObject3).getLast();
          String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((bga)localObject3).name);
          if (p.j(str, localObject5))
          {
            ((bga)localObject3).LPH.add(paramerd);
          }
          else
          {
            localObject4 = ((bgb)localObject4).LPI.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject5 = (dvg)((Iterator)localObject4).next();
            } while ((localObject5 == null) || (!p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject5).dMl))));
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
          ((bga)localObject3).LPH.add(paramerd);
          break;
          paramerd = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
          p.g(localObject2, "index");
          com.tencent.mm.plugin.expt.hellhound.a.d.a.a((dve)localObject1, ((Integer)localObject2).intValue());
          AppMethodBeat.o(221132);
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