package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class j
  implements o
{
  public static final j.a qVb;
  private WeakReference<Activity> mActivityRef;
  private final a qUA;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final b qUZ;
  private final c qVa;
  
  static
  {
    AppMethodBeat.i(210755);
    qVb = new j.a((byte)0);
    AppMethodBeat.o(210755);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(210754);
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.qUZ = new b(this);
    this.qVa = new c(this);
    AppMethodBeat.o(210754);
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210752);
    ad.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.qUA.coC();
    this.qUB.a(5, null);
    AppMethodBeat.o(210752);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210751);
    ad.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.qUA.a((e)this.qUZ, (p)this.qVa);
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
      AppMethodBeat.o(210751);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(210753);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(210753);
  }
  
  public final void report() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210749);
      Object localObject = j.b(this.qVc);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(210749);
        return;
      }
      j.a(this.qVc).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210749);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210748);
      j.a(this.qVc).h(paramViewGroup, j.Dg(paramInt));
      AppMethodBeat.o(210748);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(210750);
      ad.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.qVc).kY(paramBoolean);
      AppMethodBeat.o(210750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */