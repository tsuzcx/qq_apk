package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class g
  implements o
{
  public static final g.a rcP;
  private WeakReference<Activity> mActivityRef;
  private final b rcN;
  private final c rcO;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196404);
    rcP = new g.a((byte)0);
    AppMethodBeat.o(196404);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(196403);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(11, "18260", "1011");
    this.mActivityRef = new WeakReference(paramActivity);
    this.rcN = new b(this);
    this.rcO = new c(this);
    AppMethodBeat.o(196403);
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196401);
    ae.d("HABBYGE-MALI.FinderFriendMonitor", "stopMonitor...");
    this.rcy.cqe();
    this.rcz.a(5, null);
    AppMethodBeat.o(196401);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196400);
    ae.d("HABBYGE-MALI.FinderFriendMonitor", "startMonitor...");
    this.rcy.a((e)this.rcN, (p)this.rcO);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.rcz;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(196400);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196402);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196402);
  }
  
  public final void report() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196398);
      Object localObject = g.b(this.rcQ);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ae.m("HABBYGE-MALI.FinderFriendMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(196398);
        return;
      }
      g.a(this.rcQ).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196398);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196397);
      g.a(this.rcQ).h(paramViewGroup, g.Dr(paramInt));
      AppMethodBeat.o(196397);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196399);
      ae.d("HABBYGE-MALI.FinderFriendMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      g.a(this.rcQ).kY(paramBoolean);
      AppMethodBeat.o(196399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */