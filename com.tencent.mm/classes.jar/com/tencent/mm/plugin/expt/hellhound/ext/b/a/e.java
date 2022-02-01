package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements o
{
  public static final e.a zFj;
  private WeakReference<Activity> mActivityRef;
  private final a zFc;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private final b zFk;
  private final c zFl;
  
  static
  {
    AppMethodBeat.i(300443);
    zFj = new e.a((byte)0);
    AppMethodBeat.o(300443);
  }
  
  public e()
  {
    AppMethodBeat.i(300419);
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(8, "18260", "1008");
    this.zFk = new b(this);
    this.zFl = new c(this);
    AppMethodBeat.o(300419);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300455);
    s.u(paramString, "aName");
    Log.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300455);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.dJd().I(728, paramString);
      AppMethodBeat.o(300455);
      return;
      c.dJd().I(729, paramString);
      AppMethodBeat.o(300455);
      return;
      c.dJd().I(730, paramString);
      AppMethodBeat.o(300455);
      return;
      c.dJd().I(731, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300478);
    this.zFd.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(300478);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300485);
    this.zFd.a(3, null);
    AppMethodBeat.o(300485);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300466);
    com.tencent.mm.plugin.expt.hellhound.ext.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.zFd;
      localObject = this.mActivityRef;
      if (localObject != null) {
        break label61;
      }
    }
    label61:
    for (Object localObject = null;; localObject = (Activity)((WeakReference)localObject).get())
    {
      locala.a(0, (Activity)localObject);
      this.zFc.a((f)this.zFk, (p)this.zFl);
      AppMethodBeat.o(300466);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300471);
    this.zFc.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300471);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(e parame) {}
    
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(300493);
      Object localObject = e.b(this.zFm);
      if (localObject == null) {}
      for (localObject = null; (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = (Activity)((WeakReference)localObject).get())
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(300493);
        return;
      }
      e.a(this.zFm).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(300493);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(300487);
      e.a(this.zFm).g(paramViewGroup, e.LJ(paramInt));
      AppMethodBeat.o(300487);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements p
  {
    c(e parame) {}
    
    public final void oP(boolean paramBoolean)
    {
      AppMethodBeat.i(300477);
      e.a(this.zFm).oO(paramBoolean);
      AppMethodBeat.o(300477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.e
 * JD-Core Version:    0.7.0.1
 */