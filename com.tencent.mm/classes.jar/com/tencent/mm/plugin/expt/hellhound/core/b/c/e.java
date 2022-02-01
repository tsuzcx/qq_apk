package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jz;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g;
import d.g.b.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "index", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "unmonitorHorizontalScroll", "plugin-expt_release"})
public final class e
{
  private static final Map<String, WeakReference<View>> mViewMap;
  public static final f raA;
  private static final f raB;
  public static final c raC;
  public static final e raD;
  public static final f raz;
  
  static
  {
    AppMethodBeat.i(196327);
    raD = new e();
    mViewMap = (Map)new LinkedHashMap();
    raz = g.O((d.g.a.a)e.d.raG);
    raA = g.O((d.g.a.a)e.a.raE);
    raB = g.O((d.g.a.a)e.b.raF);
    raC = new c();
    AppMethodBeat.o(196327);
  }
  
  private e()
  {
    AppMethodBeat.i(184341);
    AppMethodBeat.o(184341);
  }
  
  public static void a(dwx paramdwx)
  {
    AppMethodBeat.i(196325);
    raC.a(null, paramdwx);
    AppMethodBeat.o(196325);
  }
  
  public static final void b(dwx paramdwx)
  {
    Object localObject3 = null;
    AppMethodBeat.i(196326);
    if (paramdwx == null)
    {
      AppMethodBeat.o(196326);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    label92:
    label118:
    int j;
    if (paramdwx.duQ != null)
    {
      localObject1 = paramdwx.duQ;
      p.g(localObject1, "viewNode.pageName");
      if (((CharSequence)localObject1).length() == 0)
      {
        i = 1;
        if ((i == 0) && (paramdwx.Icp != -1) && (paramdwx.Icp != 0)) {
          break label634;
        }
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.csb();
      if (localObject2 == null) {
        break label561;
      }
      localObject1 = (bou)((Pair)localObject2).first;
      if (localObject2 == null) {
        break label567;
      }
      localObject2 = (Integer)((Pair)localObject2).second;
      if (localObject2 == null) {
        break label567;
      }
      i = ((Integer)localObject2).intValue();
      j = i;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        paramdwx.duQ = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((bou)localObject1).duQ);
        paramdwx.Icp = ((bou)localObject1).aHQ;
        paramdwx.GEY = i;
        localObject2 = localObject1;
        j = i;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (j < 0))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.csb();
        if (localObject2 != null)
        {
          localObject1 = (bou)((Pair)localObject2).first;
          label190:
          if (localObject2 == null) {
            break label578;
          }
          localObject2 = (Integer)((Pair)localObject2).second;
          if (localObject2 == null) {
            break label578;
          }
          i = ((Integer)localObject2).intValue();
        }
      }
      for (;;)
      {
        label216:
        localObject2 = paramdwx.id + "|" + paramdwx.aHQ + "|" + paramdwx.timestamp;
        localObject2 = (WeakReference)mViewMap.get(localObject2);
        if (localObject2 != null) {}
        for (localObject2 = (View)((WeakReference)localObject2).get();; localObject2 = null)
        {
          d.a locala = d.rhs;
          d.a.b((View)localObject2, paramdwx);
          if ((localObject1 == null) || (i < 0))
          {
            ae.e("HABBYGE-MALI.ViewMonitor", "ViewMonitor, addView2PageFlow illegal !!!");
            label316:
            localObject2 = localObject3;
            if (localObject1 != null) {
              localObject2 = ((bou)localObject1).duQ;
            }
            k.a(paramdwx, (String)localObject2);
            localObject1 = d.rhs;
            d.a.c(paramdwx);
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
            p.h(paramdwx, "viewNode");
            if (!p.i(paramdwx.id, "-1")) {
              break label601;
            }
            l.a.tn(115L);
            label378:
            if (paramdwx.Icq <= 10L) {
              break label610;
            }
            l.a.tn(117L);
          }
          for (;;)
          {
            localObject1 = new jz();
            localObject2 = ((jz)localObject1).sQ(paramdwx.duQ).sR(paramdwx.typeName).sP(paramdwx.id).jW(paramdwx.duP).qD(paramdwx.Icq);
            p.g(localObject2, "struct.setPageId(viewNod…g(viewNode.timeConsuming)");
            ((jz)localObject2).sS(paramdwx.Icn);
            boolean bool = ((jz)localObject1).aLH();
            ae.i("HABBYGE-MALI.QualityReport", "reportKv: page=" + ((jz)localObject1).getPageId() + ", viewId=" + ((jz)localObject1).getViewId() + ", resName=" + ((jz)localObject1).VC() + ',' + " time=" + paramdwx.Icq + ", reportRet=" + bool);
            AppMethodBeat.o(196326);
            return;
            i = 0;
            break;
            label561:
            localObject1 = null;
            break label92;
            label567:
            i = -1;
            break label118;
            localObject1 = null;
            break label190;
            label578:
            i = -1;
            break label216;
            ((bou)localObject1).GLD.addLast(paramdwx);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((bou)localObject1, i);
            break label316;
            label601:
            l.a.tn(116L);
            break label378;
            label610:
            l.a.tn(118L);
          }
        }
        i = j;
        localObject1 = localObject2;
      }
      label634:
      j = -1;
      localObject2 = null;
    }
  }
  
  private static b cpV()
  {
    AppMethodBeat.i(196322);
    b localb = (b)raB.getValue();
    AppMethodBeat.o(196322);
    return localb;
  }
  
  public static final void cpW()
  {
    AppMethodBeat.i(196323);
    b localb = cpV();
    localb.raa = ((c)raC);
    localb.afo = -1;
    List localList = (List)new ArrayList();
    Pair localPair = Pair.create("onPageChange", "(IZ)V");
    p.g(localPair, "Pair.create(METHOD_NAME, METHOD_DESC)");
    localList.add(localPair);
    localb.rai.put("com/tencent/mm/view/RecyclerHorizontalViewPager", localList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(localb.rai, (com.tencent.mm.hellhoundlib.a.c)localb.raj);
    AppMethodBeat.o(196323);
  }
  
  public static final void cpX()
  {
    AppMethodBeat.i(196324);
    b localb = cpV();
    localb.afo = -1;
    localb.raa = null;
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.b(localb.rai, (com.tencent.mm.hellhoundlib.a.c)localb.raj);
    AppMethodBeat.o(196324);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(View paramView, dwx paramdwx)
    {
      AppMethodBeat.i(196319);
      if (paramdwx == null)
      {
        AppMethodBeat.o(196319);
        return;
      }
      if (paramView != null)
      {
        String str = paramdwx.id + "|" + paramdwx.aHQ + "|" + paramdwx.timestamp;
        e locale = e.raD;
        e.cpY().put(str, new WeakReference(paramView));
      }
      paramdwx.Icq = (System.currentTimeMillis() - paramdwx.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cpq().l(800, paramdwx);
      AppMethodBeat.o(196319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.e
 * JD-Core Version:    0.7.0.1
 */