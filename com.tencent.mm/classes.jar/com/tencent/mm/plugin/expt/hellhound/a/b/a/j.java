package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class j
  implements o
{
  public static final j.a rcZ;
  private WeakReference<Activity> mActivityRef;
  private final b rcX;
  private final c rcY;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196422);
    rcZ = new j.a((byte)0);
    AppMethodBeat.o(196422);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(196421);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.rcX = new b(this);
    this.rcY = new c(this);
    AppMethodBeat.o(196421);
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196419);
    ae.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.rcy.cqe();
    this.rcz.a(5, null);
    AppMethodBeat.o(196419);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196418);
    ae.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.rcy.a((e)this.rcX, (p)this.rcY);
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
      AppMethodBeat.o(196418);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196420);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196420);
  }
  
  public final void report() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196416);
      Object localObject = j.b(this.rda);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ae.m("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(196416);
        return;
      }
      j.a(this.rda).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196416);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196415);
      j.a(this.rda).h(paramViewGroup, j.Dt(paramInt));
      AppMethodBeat.o(196415);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196417);
      ae.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.rda).kY(paramBoolean);
      AppMethodBeat.o(196417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */