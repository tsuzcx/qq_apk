package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jx;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g;
import d.g.b.p;
import d.g.b.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "index", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "unmonitorHorizontalScroll", "plugin-expt_release"})
public final class e
{
  private static final Map<String, WeakReference<View>> mViewMap;
  public static final d.f qSB;
  public static final d.f qSC;
  private static final d.f qSD;
  public static final c qSE;
  public static final e qSF;
  
  static
  {
    AppMethodBeat.i(210660);
    qSF = new e();
    mViewMap = (Map)new LinkedHashMap();
    qSB = g.O((d.g.a.a)d.qSI);
    qSC = g.O((d.g.a.a)a.qSG);
    qSD = g.O((d.g.a.a)b.qSH);
    qSE = new c();
    AppMethodBeat.o(210660);
  }
  
  private e()
  {
    AppMethodBeat.i(184341);
    AppMethodBeat.o(184341);
  }
  
  public static void a(dwc paramdwc)
  {
    AppMethodBeat.i(210658);
    qSE.a(null, paramdwc);
    AppMethodBeat.o(210658);
  }
  
  public static final void b(dwc paramdwc)
  {
    Object localObject3 = null;
    AppMethodBeat.i(210659);
    if (paramdwc == null)
    {
      AppMethodBeat.o(210659);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    label92:
    label118:
    int j;
    if (paramdwc.dtL != null)
    {
      localObject1 = paramdwc.dtL;
      p.g(localObject1, "viewNode.pageName");
      if (((CharSequence)localObject1).length() == 0)
      {
        i = 1;
        if ((i == 0) && (paramdwc.HID != -1) && (paramdwc.HID != 0)) {
          break label634;
        }
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.cqz();
      if (localObject2 == null) {
        break label561;
      }
      localObject1 = (boc)((Pair)localObject2).first;
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
        paramdwc.dtL = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((boc)localObject1).dtL);
        paramdwc.HID = ((boc)localObject1).aHQ;
        paramdwc.GlW = i;
        localObject2 = localObject1;
        j = i;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (j < 0))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.cqz();
        if (localObject2 != null)
        {
          localObject1 = (boc)((Pair)localObject2).first;
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
        localObject2 = paramdwc.id + "|" + paramdwc.aHQ + "|" + paramdwc.timestamp;
        localObject2 = (WeakReference)mViewMap.get(localObject2);
        if (localObject2 != null) {}
        for (localObject2 = (View)((WeakReference)localObject2).get();; localObject2 = null)
        {
          d.a locala = d.qZm;
          d.a.b((View)localObject2, paramdwc);
          if ((localObject1 == null) || (i < 0))
          {
            ad.e("HABBYGE-MALI.ViewMonitor", "ViewMonitor, addView2PageFlow illegal !!!");
            label316:
            localObject2 = localObject3;
            if (localObject1 != null) {
              localObject2 = ((boc)localObject1).dtL;
            }
            k.a(paramdwc, (String)localObject2);
            localObject1 = d.qZm;
            d.a.c(paramdwc);
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
            p.h(paramdwc, "viewNode");
            if (!p.i(paramdwc.id, "-1")) {
              break label601;
            }
            l.a.vc(115L);
            label378:
            if (paramdwc.HIE <= 10L) {
              break label610;
            }
            l.a.vc(117L);
          }
          for (;;)
          {
            localObject1 = new jx();
            localObject2 = ((jx)localObject1).sv(paramdwc.dtL).sw(paramdwc.typeName).su(paramdwc.id).jU(paramdwc.dtK).qq(paramdwc.HIE);
            p.g(localObject2, "struct.setPageId(viewNod…g(viewNode.timeConsuming)");
            ((jx)localObject2).sx(paramdwc.HIB);
            boolean bool = ((jx)localObject1).aLk();
            ad.i("HABBYGE-MALI.QualityReport", "reportKv: page=" + ((jx)localObject1).getPageId() + ", viewId=" + ((jx)localObject1).getViewId() + ", resName=" + ((jx)localObject1).Vu() + ',' + " time=" + paramdwc.HIE + ", reportRet=" + bool);
            AppMethodBeat.o(210659);
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
            ((boc)localObject1).Gsf.addLast(paramdwc);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((boc)localObject1, i);
            break label316;
            label601:
            l.a.vc(116L);
            break label378;
            label610:
            l.a.vc(118L);
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
  
  private static b cot()
  {
    AppMethodBeat.i(210655);
    b localb = (b)qSD.getValue();
    AppMethodBeat.o(210655);
    return localb;
  }
  
  public static final void cou()
  {
    AppMethodBeat.i(210656);
    b localb = cot();
    localb.qSc = ((c)qSE);
    localb.afo = -1;
    List localList = (List)new ArrayList();
    Pair localPair = Pair.create("onPageChange", "(IZ)V");
    p.g(localPair, "Pair.create(METHOD_NAME, METHOD_DESC)");
    localList.add(localPair);
    localb.qSk.put("com/tencent/mm/view/RecyclerHorizontalViewPager", localList);
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(localb.qSk, (com.tencent.mm.hellhoundlib.a.c)localb.qSl);
    AppMethodBeat.o(210656);
  }
  
  public static final void cov()
  {
    AppMethodBeat.i(210657);
    b localb = cot();
    localb.afo = -1;
    localb.qSc = null;
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.b(localb.qSk, (com.tencent.mm.hellhoundlib.a.c)localb.qSl);
    AppMethodBeat.o(210657);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<a>
  {
    public static final a qSG;
    
    static
    {
      AppMethodBeat.i(210649);
      qSG = new a();
      AppMethodBeat.o(210649);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<b>
  {
    public static final b qSH;
    
    static
    {
      AppMethodBeat.i(210651);
      qSH = new b();
      AppMethodBeat.o(210651);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(View paramView, dwc paramdwc)
    {
      AppMethodBeat.i(210652);
      if (paramdwc == null)
      {
        AppMethodBeat.o(210652);
        return;
      }
      if (paramView != null)
      {
        String str = paramdwc.id + "|" + paramdwc.aHQ + "|" + paramdwc.timestamp;
        e locale = e.qSF;
        e.cow().put(str, new WeakReference(paramView));
      }
      paramdwc.HIE = (System.currentTimeMillis() - paramdwc.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(800, paramdwc);
      AppMethodBeat.o(210652);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<f>
  {
    public static final d qSI;
    
    static
    {
      AppMethodBeat.i(210654);
      qSI = new d();
      AppMethodBeat.o(210654);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.e
 * JD-Core Version:    0.7.0.1
 */