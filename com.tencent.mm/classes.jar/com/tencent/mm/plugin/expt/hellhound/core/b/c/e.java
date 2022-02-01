package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nx;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d;
import com.tencent.mm.plugin.expt.hellhound.a.f.e.d.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.erd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "index", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "unmonitorHorizontalScroll", "plugin-expt_release"})
public final class e
{
  private static final Map<String, WeakReference<View>> mViewMap;
  public static final kotlin.f sAQ;
  public static final kotlin.f sAR;
  private static final kotlin.f sAS;
  public static final c sAT;
  public static final e sAU;
  
  static
  {
    AppMethodBeat.i(220775);
    sAU = new e();
    mViewMap = (Map)new LinkedHashMap();
    sAQ = g.ah((kotlin.g.a.a)d.sAX);
    sAR = g.ah((kotlin.g.a.a)a.sAV);
    sAS = g.ah((kotlin.g.a.a)b.sAW);
    sAT = new c();
    AppMethodBeat.o(220775);
  }
  
  private e()
  {
    AppMethodBeat.i(184341);
    AppMethodBeat.o(184341);
  }
  
  public static void a(erd paramerd)
  {
    AppMethodBeat.i(220773);
    sAT.a(null, paramerd);
    AppMethodBeat.o(220773);
  }
  
  public static final void b(erd paramerd)
  {
    Object localObject3 = null;
    AppMethodBeat.i(220774);
    if (paramerd == null)
    {
      AppMethodBeat.o(220774);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    label88:
    label114:
    int j;
    if (paramerd.dMl != null)
    {
      localObject1 = paramerd.dMl;
      p.g(localObject1, "viewNode.pageName");
      if (((CharSequence)localObject1).length() == 0)
      {
        i = 1;
        if ((i == 0) && (paramerd.NoN != -1) && (paramerd.NoN != 0)) {
          break label520;
        }
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.cQJ();
      if (localObject2 == null) {
        break label452;
      }
      localObject1 = (cbm)((Pair)localObject2).first;
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
        paramerd.dMl = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((cbm)localObject1).dMl);
        paramerd.NoN = ((cbm)localObject1).aHK;
        paramerd.LCp = i;
        localObject2 = localObject1;
        j = i;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (j < 0))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.cQJ();
        if (localObject2 != null)
        {
          localObject1 = (cbm)((Pair)localObject2).first;
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
        localObject2 = paramerd.id + "|" + paramerd.aHK + "|" + paramerd.timestamp;
        localObject2 = (WeakReference)mViewMap.get(localObject2);
        if (localObject2 != null) {}
        for (localObject2 = (View)((WeakReference)localObject2).get();; localObject2 = null)
        {
          d.a locala = d.sIO;
          d.a.b((View)localObject2, paramerd);
          if ((localObject1 == null) || (i < 0))
          {
            label298:
            localObject2 = localObject3;
            if (localObject1 != null) {
              localObject2 = ((cbm)localObject1).dMl;
            }
            k.a(paramerd, (String)localObject2);
            localObject1 = d.sIO;
            d.a.c(paramerd);
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
            p.h(paramerd, "viewNode");
            if (!p.j(paramerd.id, "-1")) {
              break label488;
            }
            l.a.Bt(115L);
            label355:
            if (paramerd.NoO <= 10L) {
              break label497;
            }
            l.a.Bt(117L);
          }
          for (;;)
          {
            localObject1 = new nx();
            localObject2 = ((nx)localObject1).Bb(paramerd.dMl).Bc(paramerd.typeName).Ba(paramerd.id).mY(paramerd.eventId).ys(paramerd.NoO);
            p.g(localObject2, "struct.setPageId(viewNod…g(viewNode.timeConsuming)");
            ((nx)localObject2).Bd(paramerd.NoL);
            ((nx)localObject1).bfK();
            AppMethodBeat.o(220774);
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
            ((cbm)localObject1).LPH.addLast(paramerd);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a((cbm)localObject1, i);
            break label298;
            label488:
            l.a.Bt(116L);
            break label355;
            label497:
            l.a.Bt(118L);
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
  
  private static b cOo()
  {
    AppMethodBeat.i(220770);
    b localb = (b)sAS.getValue();
    AppMethodBeat.o(220770);
    return localb;
  }
  
  public static final void cOp()
  {
    AppMethodBeat.i(220771);
    b localb = cOo();
    localb.sAr = ((c)sAT);
    localb.afB = -1;
    List localList = (List)new ArrayList();
    Pair localPair = Pair.create("onPageChange", "(IZ)V");
    p.g(localPair, "Pair.create(METHOD_NAME, METHOD_DESC)");
    localList.add(localPair);
    localb.sAz.put("com/tencent/mm/view/RecyclerHorizontalViewPager", localList);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(localb.sAz, (com.tencent.mm.hellhoundlib.a.c)localb.sAA);
    AppMethodBeat.o(220771);
  }
  
  public static final void cOq()
  {
    AppMethodBeat.i(220772);
    b localb = cOo();
    localb.afB = -1;
    localb.sAr = null;
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.b(localb.sAz, (com.tencent.mm.hellhoundlib.a.c)localb.sAA);
    AppMethodBeat.o(220772);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<a>
  {
    public static final a sAV;
    
    static
    {
      AppMethodBeat.i(220764);
      sAV = new a();
      AppMethodBeat.o(220764);
    }
    
    a()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<b>
  {
    public static final b sAW;
    
    static
    {
      AppMethodBeat.i(220766);
      sAW = new b();
      AppMethodBeat.o(220766);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"})
  public static final class c
    implements c
  {
    public final void a(View paramView, erd paramerd)
    {
      AppMethodBeat.i(220767);
      if (paramerd == null)
      {
        AppMethodBeat.o(220767);
        return;
      }
      if (paramView != null)
      {
        String str = paramerd.id + "|" + paramerd.aHK + "|" + paramerd.timestamp;
        e locale = e.sAU;
        e.cOr().put(str, new WeakReference(paramView));
      }
      paramerd.NoO = (System.currentTimeMillis() - paramerd.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(800, paramerd);
      AppMethodBeat.o(220767);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<f>
  {
    public static final d sAX;
    
    static
    {
      AppMethodBeat.i(220769);
      sAX = new d();
      AppMethodBeat.o(220769);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.e
 * JD-Core Version:    0.7.0.1
 */