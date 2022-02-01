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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements o
{
  public static final h.a zFv;
  private WeakReference<Activity> mActivityRef;
  private final a zFc;
  private com.tencent.mm.plugin.expt.hellhound.ext.a.a zFd;
  private final b zFw;
  private final c zFx;
  
  static
  {
    AppMethodBeat.i(300501);
    zFv = new h.a((byte)0);
    AppMethodBeat.o(300501);
  }
  
  public h()
  {
    AppMethodBeat.i(300458);
    this.zFc = new a();
    this.zFd = new com.tencent.mm.plugin.expt.hellhound.ext.a.a(13, "18260", "1013");
    this.zFw = new b(this);
    this.zFx = new c(this);
    AppMethodBeat.o(300458);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(300515);
    s.u(paramString, "aName");
    Log.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(300515);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.dJd().I(744, paramString);
      AppMethodBeat.o(300515);
      return;
      c.dJd().I(745, paramString);
      AppMethodBeat.o(300515);
      return;
      c.dJd().I(746, paramString);
      AppMethodBeat.o(300515);
      return;
      c.dJd().I(747, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(300541);
    this.zFd.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(300541);
  }
  
  public final void report()
  {
    AppMethodBeat.i(300548);
    this.zFd.a(3, null);
    AppMethodBeat.o(300548);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(300524);
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
      this.zFc.a((f)this.zFw, (p)this.zFx);
      AppMethodBeat.o(300524);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300534);
    this.zFc.stopMonitor();
    this.zFd.a(1, null);
    AppMethodBeat.o(300534);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(h paramh) {}
    
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(300526);
      Object localObject = h.b(this.zFy);
      if (localObject == null) {}
      for (localObject = null; (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = (Activity)((WeakReference)localObject).get())
      {
        Log.printInfoStack("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(300526);
        return;
      }
      h.a(this.zFy).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(300526);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(300520);
      h.a(this.zFy).g(paramViewGroup, h.LM(paramInt));
      AppMethodBeat.o(300520);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements p
  {
    c(h paramh) {}
    
    public final void oP(boolean paramBoolean)
    {
      AppMethodBeat.i(300516);
      h.a(this.zFy).oO(paramBoolean);
      AppMethodBeat.o(300516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.h
 * JD-Core Version:    0.7.0.1
 */