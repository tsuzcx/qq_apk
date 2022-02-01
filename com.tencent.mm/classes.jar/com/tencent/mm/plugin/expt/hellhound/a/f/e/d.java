package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.b.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a woL;
  
  static
  {
    AppMethodBeat.i(251222);
    woL = new a((byte)0);
    AppMethodBeat.o(251222);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/params/HellViewParamsCatcher$Companion;", "", "()V", "TAG", "", "addView2FuzzyPath", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "catchBizParams2ViewNode", "view", "Landroid/view/View;", "catchParams", "pageObj", "pathId", "", "matchPageList", "", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "catchViewParam", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "plugin-expt_release"})
  public static final class a
  {
    private static void a(Object paramObject, View paramView, fbo paramfbo, long paramLong, List<? extends efi> paramList)
    {
      AppMethodBeat.i(256673);
      Iterator localIterator1 = ((Iterable)paramList).iterator();
      label17:
      if (localIterator1.hasNext())
      {
        efi localefi = (efi)localIterator1.next();
        paramList = localefi.UiH;
        p.j(paramList, "it.viewOps");
        Iterator localIterator2 = ((Iterable)paramList).iterator();
        Object localObject;
        for (;;)
        {
          if (!localIterator2.hasNext()) {
            break label17;
          }
          localObject = (fbp)localIterator2.next();
          Log.i("HABBYGE-MALI.HellViewParamsCatcher", "catchParams: page=" + localefi.fFe + ", " + paramfbo.id + " == " + ((fbp)localObject).viewId + ", " + paramfbo.UBI + " == " + ((fbp)localObject).UBI);
          paramList = g.wgZ;
          p.j(localObject, "viewOpIt");
          if (!g.a.a(paramfbo, (fbp)localObject)) {
            break;
          }
          switch (((fbp)localObject).type)
          {
          }
        }
        for (paramList = paramView;; paramList = paramObject)
        {
          localObject = ((fbp)localObject).UiG.iterator();
          while (((Iterator)localObject).hasNext())
          {
            dhw localdhw = (dhw)((Iterator)localObject).next();
            if (localdhw != null) {
              b.a(paramList, localdhw, paramLong, paramfbo);
            }
          }
        }
      }
      AppMethodBeat.o(256673);
    }
    
    public static void b(View paramView, fbo paramfbo)
    {
      AppMethodBeat.i(256672);
      if (paramfbo == null)
      {
        AppMethodBeat.o(256672);
        return;
      }
      Object localObject2 = a.dco();
      if (localObject2 == null)
      {
        AppMethodBeat.o(256672);
        return;
      }
      p.j(com.tencent.mm.plugin.expt.hellhound.a.f.b.d.deY(), "HellSessionPageCloudConfig.getInstance()");
      Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.d.deZ();
      if (localObject1 == null)
      {
        Log.e("HABBYGE-MALI.HellViewParamsCatcher", "HellViewParamsCatcher, catchBizParams2ViewNode, config is NULL !!");
        AppMethodBeat.o(256672);
        return;
      }
      Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
      p.j(localObject3, "HellSessionMonitor.getInstance()");
      localObject3 = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject3).deK();
      Iterator localIterator1 = ((efj)localObject1).UiI.iterator();
      label336:
      while (localIterator1.hasNext())
      {
        efm localefm = (efm)localIterator1.next();
        if ((localefm != null) && ((!(p.h(localefm.wmA, localObject3) ^ true)) || (!(p.h("-1", localefm.wmA) ^ true))))
        {
          localObject1 = localObject2.getClass().getName();
          p.j(localObject1, "pageObj.javaClass.name");
          Object localObject4 = e.woM;
          p.k(localObject1, "curPageName");
          p.k(localefm, "pathConfig");
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD((String)localObject1);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = (List)localObject4)
          {
            if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
              break label336;
            }
            localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
            localObject4 = paramfbo.id;
            p.j(localObject4, "viewNode.id");
            paramfbo.UBI = a.a.b((String)localObject4, (List)localObject1, paramfbo.UBI);
            a(localObject2, paramView, paramfbo, localefm.SYb, (List)localObject1);
            break;
            p.j(localObject1, "HellhoundUtil.getShortNa…rPageName) ?: return null");
            localObject4 = new ArrayList();
            Iterator localIterator2 = localefm.UiM.iterator();
            while (localIterator2.hasNext())
            {
              efi localefi = (efi)localIterator2.next();
              String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localefi.fFe);
              if ((str != null) && (p.h(localObject1, str))) {
                ((ArrayList)localObject4).add(localefi);
              }
            }
          }
        }
      }
      AppMethodBeat.o(256672);
    }
    
    public static void c(fbo paramfbo)
    {
      AppMethodBeat.i(256671);
      if (paramfbo == null)
      {
        AppMethodBeat.o(256671);
        return;
      }
      Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR;
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.d.a.dew();
      if (localObject2 == null)
      {
        AppMethodBeat.o(256671);
        return;
      }
      localObject1 = (efg)((Pair)localObject2).first;
      localObject2 = (Integer)((Pair)localObject2).second;
      Iterator localIterator = ((efg)localObject1).SXQ.iterator();
      label271:
      for (;;)
      {
        Object localObject3;
        if (localIterator.hasNext())
        {
          Object localObject4 = (bnc)localIterator.next();
          if ((localObject4 != null) && (!((bnc)localObject4).SXY.isEmpty()))
          {
            Object localObject5 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((bnc)localObject4).SXX.fFe);
            localObject3 = ((bnc)localObject4).SXY;
            p.j(localObject3, "path.pages");
            localObject3 = (bnb)((LinkedList)localObject3).getLast();
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((bnb)localObject3).name);
            if (p.h(str, localObject5))
            {
              ((bnb)localObject3).SXV.add(paramfbo);
            }
            else
            {
              localObject4 = ((bnc)localObject4).SXW.iterator();
              do
              {
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject5 = (efi)((Iterator)localObject4).next();
              } while ((localObject5 == null) || (!p.h(str, com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject5).fFe))));
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
            ((bnb)localObject3).SXV.add(paramfbo);
            break;
            paramfbo = com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR;
            p.j(localObject2, "index");
            com.tencent.mm.plugin.expt.hellhound.a.d.a.a((efg)localObject1, ((Integer)localObject2).intValue());
            AppMethodBeat.o(256671);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.e.d
 * JD-Core Version:    0.7.0.1
 */