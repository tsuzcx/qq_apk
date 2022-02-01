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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"})
public final class k
{
  public static final k.a qWI;
  WeakReference<RecyclerView> qTE;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> qVC;
  final b qWG;
  final c qWH;
  
  static
  {
    AppMethodBeat.i(210843);
    qWI = new k.a((byte)0);
    AppMethodBeat.o(210843);
  }
  
  public k()
  {
    AppMethodBeat.i(210842);
    this.qVC = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((Map)this.qVC).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.qVC).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.qVC).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.qTE;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.qWG = new b(this);
    this.qWH = new c();
    AppMethodBeat.o(210842);
  }
  
  static boolean aep(String paramString)
  {
    AppMethodBeat.i(210841);
    if (((p.i("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString) ^ true)) && ((p.i("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString) ^ true)) && ((p.i("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString) ^ true)))
    {
      AppMethodBeat.o(210841);
      return true;
    }
    AppMethodBeat.o(210841);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210838);
      if (k.aeq(paramString1))
      {
        AppMethodBeat.o(210838);
        return;
      }
      if ((p.i(paramString2, "getItemOffsets")) && (p.i(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = k.a(this.qWJ);
        if (paramString1 != null) {
          paramString1 = (RecyclerView)paramString1.get();
        }
        while (paramString1 == null)
        {
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
            AppMethodBeat.o(210838);
            throw paramString1;
            paramString1 = null;
          }
          else
          {
            paramString1 = (RecyclerView)paramString1;
            paramString1.a((RecyclerView.m)k.b(this.qWJ));
            k.a(this.qWJ, new WeakReference(paramString1));
          }
        }
      }
      AppMethodBeat.o(210838);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210840);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      j.qWF.f(paramRecyclerView, paramInt2);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(210840);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(210839);
      b localb = new b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      j.qWF.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(210839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */