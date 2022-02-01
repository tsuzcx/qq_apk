package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class j
  implements o
{
  public static final j.a qme;
  private WeakReference<Activity> mActivityRef;
  private final a qlD;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final b qmc;
  private final c qmd;
  
  static
  {
    AppMethodBeat.i(195408);
    qme = new j.a((byte)0);
    AppMethodBeat.o(195408);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(195407);
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.qmc = new b(this);
    this.qmd = new c(this);
    AppMethodBeat.o(195407);
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195405);
    ac.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.qlD.cjq();
    this.qlE.a(5, null);
    AppMethodBeat.o(195405);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195404);
    ac.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.qlD.a((e)this.qmc, (p)this.qmd);
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
      AppMethodBeat.o(195404);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(195406);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(195406);
  }
  
  public final void report() {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195402);
      Object localObject = j.b(this.qmf);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ac.m("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(195402);
        return;
      }
      j.a(this.qmf).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195402);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(195401);
      j.a(this.qmf).g(paramViewGroup, j.Ct(paramInt));
      AppMethodBeat.o(195401);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kH(boolean paramBoolean)
    {
      AppMethodBeat.i(195403);
      ac.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.qmf).kG(paramBoolean);
      AppMethodBeat.o(195403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */