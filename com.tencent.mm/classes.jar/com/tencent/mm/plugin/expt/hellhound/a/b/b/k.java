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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"})
public final class k
{
  public static final a KHw;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> KGr;
  final b KHu;
  final c KHv;
  WeakReference<RecyclerView> pFP;
  
  static
  {
    AppMethodBeat.i(205238);
    KHw = new a((byte)0);
    AppMethodBeat.o(205238);
  }
  
  public k()
  {
    AppMethodBeat.i(205237);
    this.KGr = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.KGr).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.pFP;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.KHu = new b(this);
    this.KHv = new c();
    AppMethodBeat.o(205237);
  }
  
  static boolean aVd(String paramString)
  {
    AppMethodBeat.i(205236);
    if (((d.g.b.k.g("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString) ^ true)) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString) ^ true)) && ((d.g.b.k.g("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString) ^ true)))
    {
      AppMethodBeat.o(205236);
      return true;
    }
    AppMethodBeat.o(205236);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$Companion;", "", "()V", "DESC_getItemOffsets", "", "DESC_onDrawOver", "HEADER", "HEADER_Fav", "HEADER_MixSearch", "NAME_getItemOffsets", "NAME_onDrawOver", "PAGE_NAME", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205233);
      if (k.aVe(paramString1))
      {
        AppMethodBeat.o(205233);
        return;
      }
      if ((d.g.b.k.g(paramString2, "getItemOffsets")) && (d.g.b.k.g(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = k.a(this.KHx);
        if (paramString1 != null) {
          paramString1 = (RecyclerView)paramString1.get();
        }
        while (paramString1 == null)
        {
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
            AppMethodBeat.o(205233);
            throw paramString1;
            paramString1 = null;
          }
          else
          {
            paramString1 = (RecyclerView)paramString1;
            paramString1.a((RecyclerView.m)k.b(this.KHx));
            k.a(this.KHx, new WeakReference(paramString1));
          }
        }
      }
      AppMethodBeat.o(205233);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class c
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205235);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      j.KHt.f(paramRecyclerView, paramInt2);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(205235);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(205234);
      b localb = new b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      j.KHt.b(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(205234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.k
 * JD-Core Version:    0.7.0.1
 */