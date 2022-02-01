package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.uu;
import com.tencent.mm.plugin.expt.hellhound.ext.session.d.d.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l.a;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.fxz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor;", "", "()V", "TAG", "", "mGestureCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "getMGestureCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "mGestureCallback$delegate", "Lkotlin/Lazy;", "mHorizontalCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "getMHorizontalCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;", "mHorizontalCallback$delegate", "mListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1;", "mViewMap", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mViewOpCallback", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "getMViewOpCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "mViewOpCallback$delegate", "addView2PageFlow", "", "pageItem", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "index", "", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "callback", "view", "monitor", "monitorHorizontalScroll", "onMonitorCallback", "registerHellEventListener", "listener", "Lcom/tencent/mm/plugin/expt/api/IHellhoundService$IHellEventListener;", "unmonitorHorizontalScroll", "unregisterHellEventListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final Map<String, WeakReference<View>> mViewMap;
  public static final e zCM;
  private static final j zCN;
  private static final j zCO;
  private static final j zCP;
  public static final c zCQ;
  
  static
  {
    AppMethodBeat.i(300130);
    zCM = new e();
    mViewMap = (Map)new LinkedHashMap();
    zCN = kotlin.k.cm((kotlin.g.a.a)d.zCT);
    zCO = kotlin.k.cm((kotlin.g.a.a)a.zCR);
    zCP = kotlin.k.cm((kotlin.g.a.a)b.zCS);
    zCQ = new c();
    AppMethodBeat.o(300130);
  }
  
  private e()
  {
    AppMethodBeat.i(184341);
    AppMethodBeat.o(184341);
  }
  
  public static void a(fxz paramfxz)
  {
    AppMethodBeat.i(300117);
    zCQ.a(null, paramfxz);
    AppMethodBeat.o(300117);
  }
  
  public static final void b(fxz paramfxz)
  {
    Object localObject3 = null;
    AppMethodBeat.i(300126);
    if (paramfxz == null)
    {
      AppMethodBeat.o(300126);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    label81:
    label88:
    int j;
    if (paramfxz.hJW != null)
    {
      localObject1 = paramfxz.hJW;
      s.s(localObject1, "viewNode.pageName");
      if (((CharSequence)localObject1).length() == 0)
      {
        i = 1;
        if ((i == 0) && (paramfxz.LYA != -1) && (paramfxz.LYA != 0)) {
          break label583;
        }
      }
    }
    else
    {
      localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.dMr();
      if (localObject2 != null) {
        break label418;
      }
      localObject1 = null;
      if (localObject2 != null) {
        break label430;
      }
      i = -1;
      j = i;
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        paramfxz.hJW = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((czu)localObject1).hJW);
        paramfxz.LYA = ((czu)localObject1).cHb;
        paramfxz.ZHp = i;
        localObject2 = localObject1;
        j = i;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (j < 0))
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.dMr();
        if (localObject2 == null)
        {
          localObject1 = null;
          label147:
          if (localObject2 != null) {
            break label471;
          }
          i = -1;
        }
      }
      for (;;)
      {
        label154:
        localObject2 = paramfxz.id + '|' + paramfxz.cHb + '|' + paramfxz.timestamp;
        localObject2 = (WeakReference)mViewMap.get(localObject2);
        if (localObject2 != null) {}
        for (localObject2 = (View)((WeakReference)localObject2).get();; localObject2 = null)
        {
          d.a locala = com.tencent.mm.plugin.expt.hellhound.ext.session.d.d.zKQ;
          d.a.b((View)localObject2, paramfxz);
          if ((localObject1 == null) || (i < 0))
          {
            label246:
            if (localObject1 != null) {
              break label516;
            }
            localObject1 = localObject3;
            label253:
            if ((paramfxz != null) && (localObject1 != null)) {
              break label524;
            }
            label261:
            localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.d.d.zKQ;
            d.a.c(paramfxz);
            localObject1 = l.zKT;
            s.u(paramfxz, "viewNode");
            if (!s.p(paramfxz.id, "-1")) {
              break label551;
            }
            l.a.jX(115L);
            label297:
            if (paramfxz.abVT <= 10L) {
              break label560;
            }
            l.a.jX(117L);
          }
          for (;;)
          {
            localObject1 = new uu();
            ((uu)localObject1).jGI = ((uu)localObject1).F("PageId", paramfxz.hJW, true);
            ((uu)localObject1).jHX = ((uu)localObject1).F("LayoutId", paramfxz.typeName, true);
            ((uu)localObject1).jHW = ((uu)localObject1).F("ViewId", paramfxz.id, true);
            ((uu)localObject1).jHY = paramfxz.eventId;
            ((uu)localObject1).jHZ = paramfxz.abVT;
            ((uu)localObject1).jIa = ((uu)localObject1).F("resName", paramfxz.abVR, true);
            ((uu)localObject1).bMH();
            AppMethodBeat.o(300126);
            return;
            i = 0;
            break;
            label418:
            localObject1 = (czu)((Pair)localObject2).first;
            break label81;
            label430:
            localObject2 = (Integer)((Pair)localObject2).second;
            if (localObject2 == null)
            {
              i = -1;
              break label88;
            }
            i = ((Integer)localObject2).intValue();
            break label88;
            localObject1 = (czu)((Pair)localObject2).first;
            break label147;
            label471:
            localObject2 = (Integer)((Pair)localObject2).second;
            if (localObject2 == null)
            {
              i = -1;
              break label154;
            }
            i = ((Integer)localObject2).intValue();
            break label154;
            ((czu)localObject1).aajR.addLast(paramfxz);
            com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.a((czu)localObject1, i);
            break label246;
            label516:
            localObject1 = ((czu)localObject1).hJW;
            break label253;
            label524:
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.a(paramfxz, (String)localObject1, com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.asV("mmkv_key_hellSPMatchSuche_"), false);
            com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.a(paramfxz, (String)localObject1, com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.asV("mmkv_key_hellSPMatchinghe_"), true);
            break label261;
            label551:
            l.a.jX(116L);
            break label297;
            label560:
            l.a.jX(118L);
          }
        }
        i = j;
        localObject1 = localObject2;
      }
      label583:
      j = -1;
      localObject2 = null;
    }
  }
  
  public static f dJM()
  {
    AppMethodBeat.i(300090);
    f localf = (f)zCN.getValue();
    AppMethodBeat.o(300090);
    return localf;
  }
  
  public static a dJN()
  {
    AppMethodBeat.i(300094);
    a locala = (a)zCO.getValue();
    AppMethodBeat.o(300094);
    return locala;
  }
  
  private static b dJO()
  {
    AppMethodBeat.i(300099);
    b localb = (b)zCP.getValue();
    AppMethodBeat.o(300099);
    return localb;
  }
  
  public static final void dJP()
  {
    AppMethodBeat.i(300107);
    b localb = dJO();
    localb.zCo = ((c)zCQ);
    localb.mI = -1;
    List localList = (List)new ArrayList();
    Pair localPair = Pair.create("onPageChange", "(IZ)V");
    s.s(localPair, "create(METHOD_NAME, METHOD_DESC)");
    localList.add(localPair);
    localb.zCw.put("com/tencent/mm/view/RecyclerHorizontalViewPager", localList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(localb.zCw, (com.tencent.mm.hellhoundlib.a.d)localb.zCx);
    AppMethodBeat.o(300107);
  }
  
  public static final void dJQ()
  {
    AppMethodBeat.i(300112);
    b localb = dJO();
    localb.mI = -1;
    localb.zCo = null;
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.b(localb.zCw, (com.tencent.mm.hellhoundlib.a.d)localb.zCx);
    AppMethodBeat.o(300112);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<a>
  {
    public static final a zCR;
    
    static
    {
      AppMethodBeat.i(300022);
      zCR = new a();
      AppMethodBeat.o(300022);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/HorizontalViewPagerCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<b>
  {
    public static final b zCS;
    
    static
    {
      AppMethodBeat.i(300028);
      zCS = new b();
      AppMethodBeat.o(300028);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onEvent", "", "view", "Landroid/view/View;", "viewNode", "Lcom/tencent/mm/protocal/protobuf/ViewNode;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c
  {
    public final void a(View paramView, fxz paramfxz)
    {
      AppMethodBeat.i(300027);
      if (paramfxz == null)
      {
        AppMethodBeat.o(300027);
        return;
      }
      if (paramView != null)
      {
        String str = paramfxz.id + '|' + paramfxz.cHb + '|' + paramfxz.timestamp;
        e.dJR().put(str, new WeakReference(paramView));
      }
      paramfxz.abVT = (System.currentTimeMillis() - paramfxz.timestamp);
      com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(800, paramfxz);
      AppMethodBeat.o(300027);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<f>
  {
    public static final d zCT;
    
    static
    {
      AppMethodBeat.i(300036);
      zCT = new d();
      AppMethodBeat.o(300036);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.e
 * JD-Core Version:    0.7.0.1
 */