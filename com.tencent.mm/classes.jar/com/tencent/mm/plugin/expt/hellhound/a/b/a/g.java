package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class g
  implements o
{
  public static final g.a qUR;
  private WeakReference<Activity> mActivityRef;
  private final a qUA;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final b qUP;
  private final c qUQ;
  
  static
  {
    AppMethodBeat.i(210737);
    qUR = new g.a((byte)0);
    AppMethodBeat.o(210737);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(210736);
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(11, "18260", "1011");
    this.mActivityRef = new WeakReference(paramActivity);
    this.qUP = new b(this);
    this.qUQ = new c(this);
    AppMethodBeat.o(210736);
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210734);
    ad.d("HABBYGE-MALI.FinderFriendMonitor", "stopMonitor...");
    this.qUA.coC();
    this.qUB.a(5, null);
    AppMethodBeat.o(210734);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210733);
    ad.d("HABBYGE-MALI.FinderFriendMonitor", "startMonitor...");
    this.qUA.a((e)this.qUP, (p)this.qUQ);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.qUB;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(210733);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(210735);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(210735);
  }
  
  public final void report() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210731);
      Object localObject = g.b(this.qUS);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderFriendMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(210731);
        return;
      }
      g.a(this.qUS).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210731);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210730);
      g.a(this.qUS).h(paramViewGroup, g.De(paramInt));
      AppMethodBeat.o(210730);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(210732);
      ad.d("HABBYGE-MALI.FinderFriendMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      g.a(this.qUS).kY(paramBoolean);
      AppMethodBeat.o(210732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */