package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"})
public final class k
{
  public static final k.a reL;
  WeakReference<RecyclerView> rbC;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> rdA;
  final b reJ;
  final c reK;
  
  static
  {
    AppMethodBeat.i(196514);
    reL = new k.a((byte)0);
    AppMethodBeat.o(196514);
  }
  
  public k()
  {
    AppMethodBeat.i(196513);
    this.rdA = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((Map)this.rdA).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.rdA).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.rdA).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.rbC;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.reJ = new b(this);
    this.reK = new c();
    AppMethodBeat.o(196513);
  }
  
  static boolean afl(String paramString)
  {
    AppMethodBeat.i(196512);
    if (((p.i("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString) ^ true)) && ((p.i("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString) ^ true)) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString) ^ true)))
    {
      AppMethodBeat.o(196512);
      return true;
    }
    AppMethodBeat.o(196512);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196509);
      if (k.afm(paramString1))
      {
        AppMethodBeat.o(196509);
        return;
      }
      if ((p.i(paramString2, "getItemOffsets")) && (p.i(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = k.a(this.reM);
        if (paramString1 != null) {
          paramString1 = (RecyclerView)paramString1.get();
        }
        while (paramString1 == null)
        {
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
            AppMethodBeat.o(196509);
            throw paramString1;
            paramString1 = null;
          }
          else
          {
            paramString1 = (RecyclerView)paramString1;
            paramString1.a((RecyclerView.m)k.b(this.reM));
            k.a(this.reM, new WeakReference(paramString1));
          }
        }
      }
      AppMethodBeat.o(196509);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196511);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      j.reI.f(paramRecyclerView, paramInt2);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(196511);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(196510);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      j.reI.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(196510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */