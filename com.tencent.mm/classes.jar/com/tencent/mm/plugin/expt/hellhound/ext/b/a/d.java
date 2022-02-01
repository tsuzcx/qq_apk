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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements o
{
  public static final d.a zFf;
  private WeakReference<Activity> mActivityRef;
  private final a zFc;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private final b zFg;
  private final c zFh;
  
  static
  {
    AppMethodBeat.i(300439);
    zFf = new d.a((byte)0);
    AppMethodBeat.o(300439);
  }
  
  public d()
  {
    AppMethodBeat.i(300409);
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(9, "18260", "1009");
    this.zFg = new b(this);
    this.zFh = new c(this);
    AppMethodBeat.o(300409);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300448);
    s.u(paramString, "aName");
    Log.i("HABBYGE-MALI.FinderFavMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300448);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.dJd().I(732, paramString);
      AppMethodBeat.o(300448);
      return;
      c.dJd().I(733, paramString);
      AppMethodBeat.o(300448);
      return;
      c.dJd().I(734, paramString);
      AppMethodBeat.o(300448);
      return;
      c.dJd().I(735, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300473);
    this.zFd.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(300473);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300479);
    this.zFd.a(3, null);
    AppMethodBeat.o(300479);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300459);
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
      this.zFc.a((f)this.zFg, (p)this.zFh);
      AppMethodBeat.o(300459);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300467);
    this.zFc.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300467);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(d paramd) {}
    
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(300543);
      Object localObject = d.b(this.zFi);
      if (localObject == null) {}
      for (localObject = null; (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = (Activity)((WeakReference)localObject).get())
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFavMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(300543);
        return;
      }
      d.a(this.zFi).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(300543);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(300540);
      d.a(this.zFi).g(paramViewGroup, d.LI(paramInt));
      AppMethodBeat.o(300540);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements p
  {
    c(d paramd) {}
    
    public final void oP(boolean paramBoolean)
    {
      AppMethodBeat.i(300537);
      d.a(this.zFi).oO(paramBoolean);
      AppMethodBeat.o(300537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.d
 * JD-Core Version:    0.7.0.1
 */