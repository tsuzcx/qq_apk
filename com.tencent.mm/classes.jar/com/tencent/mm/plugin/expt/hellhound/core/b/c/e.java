package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qy;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.fbo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "index", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "unmonitorHorizontalScroll", "plugin-expt_release"})
public final class e
{
  private static final Map<String, WeakReference<View>> mViewMap;
  public static final kotlin.f wgK;
  public static final kotlin.f wgL;
  private static final kotlin.f wgM;
  public static final c wgN;
  public static final e wgO;
  
  static
  {
    AppMethodBeat.i(253109);
    wgO = new e();
    mViewMap = (Map)new LinkedHashMap();
    wgK = g.ar((kotlin.g.a.a)d.wgR);
    wgL = g.ar((kotlin.g.a.a)a.wgP);
    wgM = g.ar((kotlin.g.a.a)b.wgQ);
    wgN = new c();
    AppMethodBeat.o(253109);
  }
  
  private e()
  {
    AppMethodBeat.i(184341);
    AppMethodBeat.o(184341);
  }
  
  public static void a(fbo paramfbo)
  {
    AppMethodBeat.i(253106);
    wgN.a(null, paramfbo);
    AppMethodBeat.o(253106);
  }
  
  public static final void b(fbo paramfbo)
  {
    Object localObject3 = null;
    AppMethodBeat.i(253108);
    if (paramfbo == null)
    {
      AppMethodBeat.o(253108);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    label88:
    label114:
    int j;
    if (paramfbo.fFe != null)
    {
      localObject1 = paramfbo.fFe;
      p.j(localObject1, "viewNode.pageName");
      if (((CharSequence)localObject1).length() == 0)
      {
        i = 1;
        if ((i == 0) && (paramfbo.GcW != -1) && (paramfbo.GcW != 0)) {
          break label520;
        }
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.dfD();
      if (localObject2 == null) {
        break label452;
      }
      localObject1 = (cjp)((Pair)localObject2).first;
      if (localObject2 == null) {
        break label457;
      }
      localObject2 = (Integer)((Pair)localObject2).second;
      if (localObject2 == null) {
        break label457;
      }
      i = ((Integer)localObject2).intValue();
      j = i;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        paramfbo.fFe = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((cjp)localObject1).fFe);
        paramfbo.GcW = ((cjp)localObject1).aNf;
        paramfbo.SFr = i;
        localObject2 = localObject1;
        j = i;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (j < 0))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.dfD();
        if (localObject2 != null)
        {
          localObject1 = (cjp)((Pair)localObject2).first;
          label180:
          if (localObject2 == null) {
            break label467;
          }
          localObject2 = (Integer)((Pair)localObject2).second;
          if (localObject2 == null) {
            break label467;
          }
          i = ((Integer)localObject2).intValue();
        }
      }
      for (;;)
      {
        label206:
        localObject2 = paramfbo.id + "|" + paramfbo.aNf + "|" + paramfbo.timestamp;
        localObject2 = (WeakReference)mViewMap.get(localObject2);
        if (localObject2 != null) {}
        for (localObject2 = (View)((WeakReference)localObject2).get();; localObject2 = null)
        {
          d.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.e.d.woL;
          d.a.b((View)localObject2, paramfbo);
          if ((localObject1 == null) || (i < 0))
          {
            label298:
            localObject2 = localObject3;
            if (localObject1 != null) {
              localObject2 = ((cjp)localObject1).fFe;
            }
            k.a(paramfbo, (String)localObject2);
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.e.d.woL;
            d.a.c(paramfbo);
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
            p.k(paramfbo, "viewNode");
            if (!p.h(paramfbo.id, "-1")) {
              break label488;
            }
            l.a.HG(115L);
            label355:
            if (paramfbo.UBK <= 10L) {
              break label497;
            }
            l.a.HG(117L);
          }
          for (;;)
          {
            localObject1 = new qy();
            localObject2 = ((qy)localObject1).HO(paramfbo.fFe).HP(paramfbo.typeName).HN(paramfbo.id).pl(paramfbo.eventId).Et(paramfbo.UBK);
            p.j(localObject2, "struct.setPageId(viewNod…g(viewNode.timeConsuming)");
            ((qy)localObject2).HQ(paramfbo.UBI);
            ((qy)localObject1).bpa();
            AppMethodBeat.o(253108);
            return;
            i = 0;
            break;
            label452:
            localObject1 = null;
            break label88;
            label457:
            i = -1;
            break label114;
            localObject1 = null;
            break label180;
            label467:
            i = -1;
            break label206;
            ((cjp)localObject1).SXV.addLast(paramfbo);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cjp)localObject1, i);
            break label298;
            label488:
            l.a.HG(116L);
            break label355;
            label497:
            l.a.HG(118L);
          }
        }
        i = j;
        localObject1 = localObject2;
      }
      label520:
      j = -1;
      localObject2 = null;
    }
  }
  
  private static b ddg()
  {
    AppMethodBeat.i(253100);
    b localb = (b)wgM.getValue();
    AppMethodBeat.o(253100);
    return localb;
  }
  
  public static final void ddh()
  {
    AppMethodBeat.i(253102);
    b localb = ddg();
    localb.wgl = ((c)wgN);
    localb.lL = -1;
    List localList = (List)new ArrayList();
    Pair localPair = Pair.create("onPageChange", "(IZ)V");
    p.j(localPair, "Pair.create(METHOD_NAME, METHOD_DESC)");
    localList.add(localPair);
    localb.wgt.put("com/tencent/mm/view/RecyclerHorizontalViewPager", localList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(localb.wgt, (com.tencent.mm.hellhoundlib.a.d)localb.wgu);
    AppMethodBeat.o(253102);
  }
  
  public static final void ddi()
  {
    AppMethodBeat.i(253104);
    b localb = ddg();
    localb.lL = -1;
    localb.wgl = null;
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.b(localb.wgt, (com.tencent.mm.hellhoundlib.a.d)localb.wgu);
    AppMethodBeat.o(253104);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<a>
  {
    public static final a wgP;
    
    static
    {
      AppMethodBeat.i(251342);
      wgP = new a();
      AppMethodBeat.o(251342);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<b>
  {
    public static final b wgQ;
    
    static
    {
      AppMethodBeat.i(257559);
      wgQ = new b();
      AppMethodBeat.o(257559);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(View paramView, fbo paramfbo)
    {
      AppMethodBeat.i(256935);
      if (paramfbo == null)
      {
        AppMethodBeat.o(256935);
        return;
      }
      if (paramView != null)
      {
        String str = paramfbo.id + "|" + paramfbo.aNf + "|" + paramfbo.timestamp;
        e locale = e.wgO;
        e.ddj().put(str, new WeakReference(paramView));
      }
      paramfbo.UBK = (System.currentTimeMillis() - paramfbo.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(800, paramfbo);
      AppMethodBeat.o(256935);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<f>
  {
    public static final d wgR;
    
    static
    {
      AppMethodBeat.i(254528);
      wgR = new d();
      AppMethodBeat.o(254528);
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