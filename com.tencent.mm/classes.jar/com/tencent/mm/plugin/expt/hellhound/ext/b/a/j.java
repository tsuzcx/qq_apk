package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements o
{
  public static final j.a zFB;
  private WeakReference<Activity> mActivityRef;
  private final b zFC;
  private final c zFD;
  private final a zFc;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  
  static
  {
    AppMethodBeat.i(300499);
    zFB = new j.a((byte)0);
    AppMethodBeat.o(300499);
  }
  
  public j(Activity paramActivity)
  {
    AppMethodBeat.i(300464);
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(12, "18260", "1012");
    this.mActivityRef = new WeakReference(paramActivity);
    this.zFC = new b(this);
    this.zFD = new c(this);
    AppMethodBeat.o(300464);
  }
  
  public final void free()
  {
    AppMethodBeat.i(300535);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(300535);
  }
  
  public final void report() {}
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300511);
    Log.d("HABBYGE-MALI.FinderMachineMonitor", "startMonitor...");
    this.zFc.a((f)this.zFC, (p)this.zFD);
    com.tencent.mm.plugin.expt.hellhound.ext.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.zFd;
      localObject = this.mActivityRef;
      if (localObject != null) {
        break label68;
      }
    }
    label68:
    for (Object localObject = null;; localObject = (Activity)((WeakReference)localObject).get())
    {
      locala.a(4, (Activity)localObject);
      AppMethodBeat.o(300511);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300517);
    Log.d("HABBYGE-MALI.FinderMachineMonitor", "stopMonitor...");
    this.zFc.stopMonitor();
    this.zFd.a(5, null);
    AppMethodBeat.o(300517);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(j paramj) {}
    
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(300518);
      Object localObject = j.b(this.zFE);
      if (localObject == null) {}
      for (localObject = null; (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = (Activity)((WeakReference)localObject).get())
      {
        Log.printInfoStack("HABBYGE-MALI.FinderMachineMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(300518);
        return;
      }
      j.a(this.zFE).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(300518);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(300514);
      j.a(this.zFE).g(paramViewGroup, j.LN(paramInt));
      AppMethodBeat.o(300514);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderMachineMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements p
  {
    c(j paramj) {}
    
    public final void oP(boolean paramBoolean)
    {
      AppMethodBeat.i(300510);
      Log.d("HABBYGE-MALI.FinderMachineMonitor", "scrollToPosition: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      j.a(this.zFE).oO(paramBoolean);
      AppMethodBeat.o(300510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.j
 * JD-Core Version:    0.7.0.1
 */