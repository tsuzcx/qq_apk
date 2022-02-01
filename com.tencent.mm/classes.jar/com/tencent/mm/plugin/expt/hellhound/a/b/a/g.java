package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class g
  implements o
{
  public static final g.a qlU;
  private WeakReference<Activity> mActivityRef;
  private final a qlD;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final b qlS;
  private final c qlT;
  
  static
  {
    AppMethodBeat.i(195390);
    qlU = new g.a((byte)0);
    AppMethodBeat.o(195390);
  }
  
  public g(Activity paramActivity)
  {
    AppMethodBeat.i(195389);
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(11, "18260", "1011");
    this.mActivityRef = new WeakReference(paramActivity);
    this.qlS = new b(this);
    this.qlT = new c(this);
    AppMethodBeat.o(195389);
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195387);
    ac.d("HABBYGE-MALI.FinderFriendMonitor", "stopMonitor...");
    this.qlD.cjq();
    this.qlE.a(5, null);
    AppMethodBeat.o(195387);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195386);
    ac.d("HABBYGE-MALI.FinderFriendMonitor", "startMonitor...");
    this.qlD.a((e)this.qlS, (p)this.qlT);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.qlE;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(195386);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(195388);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(195388);
  }
  
  public final void report() {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195384);
      Object localObject = g.b(this.qlV);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ac.m("HABBYGE-MALI.FinderFriendMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(195384);
        return;
      }
      g.a(this.qlV).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195384);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(195383);
      g.a(this.qlV).g(paramViewGroup, g.Cr(paramInt));
      AppMethodBeat.o(195383);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFriendMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kH(boolean paramBoolean)
    {
      AppMethodBeat.i(195385);
      ac.d("HABBYGE-MALI.FinderFriendMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      g.a(this.qlV).kG(paramBoolean);
      AppMethodBeat.o(195385);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */