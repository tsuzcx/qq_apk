package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"})
public final class k
{
  public static final k.a qnK;
  WeakReference<RecyclerView> qkI;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> qmF;
  final b qnI;
  final c qnJ;
  
  static
  {
    AppMethodBeat.i(195497);
    qnK = new k.a((byte)0);
    AppMethodBeat.o(195497);
  }
  
  public k()
  {
    AppMethodBeat.i(195496);
    this.qmF = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.qmF).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.qkI;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.qnI = new b(this);
    this.qnJ = new c();
    AppMethodBeat.o(195496);
  }
  
  static boolean aaB(String paramString)
  {
    AppMethodBeat.i(195495);
    if (((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString) ^ true)) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString) ^ true)) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString) ^ true)))
    {
      AppMethodBeat.o(195495);
      return true;
    }
    AppMethodBeat.o(195495);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195492);
      if (k.aaC(paramString1))
      {
        AppMethodBeat.o(195492);
        return;
      }
      if ((d.g.b.k.g(paramString2, "getItemOffsets")) && (d.g.b.k.g(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = k.a(this.qnL);
        if (paramString1 != null) {
          paramString1 = (RecyclerView)paramString1.get();
        }
        while (paramString1 == null)
        {
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
            AppMethodBeat.o(195492);
            throw paramString1;
            paramString1 = null;
          }
          else
          {
            paramString1 = (RecyclerView)paramString1;
            paramString1.a((RecyclerView.m)k.b(this.qnL));
            k.a(this.qnL, new WeakReference(paramString1));
          }
        }
      }
      AppMethodBeat.o(195492);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(195494);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      j.qnH.f(paramRecyclerView, paramInt2);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(195494);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(195493);
      b localb = new b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      j.qnH.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(195493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */