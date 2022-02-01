package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class j
  implements o
{
  public static final j.a sDG;
  private WeakReference<Activity> mActivityRef;
  private final b sDE;
  private final c sDF;
  private final a sDf;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  
  static
  {
    AppMethodBeat.i(220887);
    sDG = new j.a((byte)0);
    AppMethodBeat.o(220887);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(220886);
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.sDE = new b(this);
    this.sDF = new c(this);
    AppMethodBeat.o(220886);
  }
  
  public final void free()
  {
    AppMethodBeat.i(220885);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(220885);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220883);
    Log.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.sDf.a((f)this.sDE, (p)this.sDF);
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
      AppMethodBeat.o(220883);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220884);
    Log.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.sDf.stopMonitor();
    this.sDg.a(5, null);
    AppMethodBeat.o(220884);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220881);
      Object localObject = j.b(this.sDH);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(220881);
        return;
      }
      j.a(this.sDH).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220881);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(220880);
      j.a(this.sDH).g(paramViewGroup, j.He(paramInt));
      AppMethodBeat.o(220880);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void md(boolean paramBoolean)
    {
      AppMethodBeat.i(220882);
      Log.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.sDH).mc(paramBoolean);
      AppMethodBeat.o(220882);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.j
 * JD-Core Version:    0.7.0.1
 */