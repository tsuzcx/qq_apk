package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class g
  implements o
{
  public static final g.a sDw;
  private WeakReference<Activity> mActivityRef;
  private final a sDf;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  private final b sDu;
  private final c sDv;
  
  static
  {
    AppMethodBeat.i(220869);
    sDw = new g.a((byte)0);
    AppMethodBeat.o(220869);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(220868);
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(11, "18260", "1011");
    this.mActivityRef = new WeakReference(paramActivity);
    this.sDu = new b(this);
    this.sDv = new c(this);
    AppMethodBeat.o(220868);
  }
  
  public final void free()
  {
    AppMethodBeat.i(220867);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(220867);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220865);
    Log.d("HABBYGE-MALI.FinderFriendMonitor", "startMonitor...");
    this.sDf.a((f)this.sDu, (p)this.sDv);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.sDg;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(220865);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220866);
    Log.d("HABBYGE-MALI.FinderFriendMonitor", "stopMonitor...");
    this.sDf.stopMonitor();
    this.sDg.a(5, null);
    AppMethodBeat.o(220866);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220863);
      Object localObject = g.b(this.sDx);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFriendMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(220863);
        return;
      }
      g.a(this.sDx).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220863);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(220862);
      g.a(this.sDx).g(paramViewGroup, g.Hc(paramInt));
      AppMethodBeat.o(220862);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void md(boolean paramBoolean)
    {
      AppMethodBeat.i(220864);
      Log.d("HABBYGE-MALI.FinderFriendMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      g.a(this.sDx).mc(paramBoolean);
      AppMethodBeat.o(220864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */