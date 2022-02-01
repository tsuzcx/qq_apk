package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class j
  implements o
{
  public static final a KFQ;
  private final b KFO;
  private final c KFP;
  private final a KFq;
  private WeakReference<Activity> mActivityRef;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  static
  {
    AppMethodBeat.i(205149);
    KFQ = new a((byte)0);
    AppMethodBeat.o(205149);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(205148);
    this.KFq = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.KFO = new b(this);
    this.KFP = new c(this);
    AppMethodBeat.o(205148);
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205146);
    ad.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.KFq.ccd();
    this.pGv.a(5, null);
    AppMethodBeat.o(205146);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205145);
    ad.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.KFq.a((d)this.KFO, (p)this.KFP);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.pGv;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(205145);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(205147);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(205147);
  }
  
  public final void report() {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements d
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205143);
      Object localObject = j.b(this.KFR);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(205143);
        return;
      }
      j.a(this.KFR).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205143);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(205142);
      j.a(this.KFR).g(paramViewGroup, j.agY(paramInt));
      AppMethodBeat.o(205142);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void yx(boolean paramBoolean)
    {
      AppMethodBeat.i(205144);
      ad.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.KFR).kc(paramBoolean);
      AppMethodBeat.o(205144);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */