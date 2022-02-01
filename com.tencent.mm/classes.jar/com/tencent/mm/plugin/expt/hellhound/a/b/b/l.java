package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback;", "", "()V", "mItemDecorationListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1;", "mMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "mRecyclerListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1;", "mRecyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "illegalPage", "", "pageName", "monitor", "", "needNotRun", "className", "unmonitor", "Companion", "plugin-expt_release"})
public final class l
{
  public static final l.a sGb;
  WeakReference<RecyclerView> sCb;
  final HashMap<String, Pair<String, List<Pair<String, String>>>> sEh;
  final b sFZ;
  final c sGa;
  
  static
  {
    AppMethodBeat.i(221004);
    sGb = new l.a((byte)0);
    AppMethodBeat.o(221004);
  }
  
  public l()
  {
    AppMethodBeat.i(221003);
    this.sEh = new HashMap();
    Object localObject = (List)new ArrayList();
    ((List)localObject).add(new Pair("getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((List)localObject).add(new Pair("onDrawOver", "(Landroid/graphics/Canvas;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V"));
    ((Map)this.sEh).put("com/tencent/mm/plugin/finder/feed/FinderTimelineMachineViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.sEh).put("com/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback$SpacesItemDecoration", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    ((Map)this.sEh).put("com/tencent/mm/plugin/finder/storage/FinderStaggeredConfig$getItemDecoration$", new Pair("android/support/v7/widget/RecyclerView$ItemDecoration", localObject));
    localObject = this.sCb;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    this.sFZ = new b(this);
    this.sGa = new c();
    AppMethodBeat.o(221003);
  }
  
  static boolean apW(String paramString)
  {
    AppMethodBeat.i(221002);
    if (((p.j("com.tencent.mm.plugin.finder.ui.FinderTimelineMachineUI", paramString) ^ true)) && ((p.j("com.tencent.mm.plugin.finder.search.FinderMixSearchUI", paramString) ^ true)) && ((p.j("com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI", paramString) ^ true)))
    {
      AppMethodBeat.o(221002);
      return true;
    }
    AppMethodBeat.o(221002);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mItemDecorationListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220999);
      if (l.apX(paramString1))
      {
        AppMethodBeat.o(220999);
        return;
      }
      if ((p.j(paramString2, "getItemOffsets")) && (p.j(paramString3, "(Landroid/graphics/Rect;Landroid/view/View;Landroid/support/v7/widget/RecyclerView;Landroid/support/v7/widget/RecyclerView$State;)V")) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4))
      {
        paramString1 = l.a(this.sGc);
        if (paramString1 != null) {
          paramString1 = (RecyclerView)paramString1.get();
        }
        while (paramString1 == null)
        {
          paramString1 = paramArrayOfObject[2];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView");
            AppMethodBeat.o(220999);
            throw paramString1;
            paramString1 = null;
          }
          else
          {
            paramString1 = (RecyclerView)paramString1;
            paramString1.a((RecyclerView.l)l.b(this.sGc));
            l.a(this.sGc, new WeakReference(paramString1));
          }
        }
      }
      AppMethodBeat.o(220999);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(221000);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      k.sFY.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(221000);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(221001);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      a.b("com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      k.sFY.e(paramRecyclerView, paramInt2);
      a.a(this, "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RecyclerItemDecorationCallback$mRecyclerListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(221001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.l
 * JD-Core Version:    0.7.0.1
 */