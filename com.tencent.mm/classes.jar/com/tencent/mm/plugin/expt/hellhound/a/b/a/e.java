package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class e
  implements o
{
  public static final e.a rcH;
  private WeakReference<Activity> mActivityRef;
  private final b rcF;
  private final c rcG;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196388);
    rcH = new e.a((byte)0);
    AppMethodBeat.o(196388);
  }
  
  public e()
  {
    AppMethodBeat.i(196387);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(8, "18260", "1008");
    this.rcF = new b(this);
    this.rcG = new c(this);
    AppMethodBeat.o(196387);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196382);
    d.g.b.p.h(paramString, "aName");
    ae.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196382);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cpq().l(728, paramString);
      AppMethodBeat.o(196382);
      return;
      c.cpq().l(729, paramString);
      AppMethodBeat.o(196382);
      return;
      c.cpq().l(730, paramString);
      AppMethodBeat.o(196382);
      return;
      c.cpq().l(731, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196384);
    this.rcy.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196384);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196383);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.rcz;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(0, (Activity)localObject);
      this.rcy.a((com.tencent.mm.plugin.expt.hellhound.a.a.e)this.rcF, (p)this.rcG);
      AppMethodBeat.o(196383);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196385);
    this.rcz.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196385);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196386);
    this.rcz.a(3, null);
    AppMethodBeat.o(196386);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196380);
      Object localObject = e.b(this.rcI);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ae.m("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(196380);
        return;
      }
      e.a(this.rcI).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196380);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196379);
      e.a(this.rcI).h(paramViewGroup, e.Dp(paramInt));
      AppMethodBeat.o(196379);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196381);
      e.a(this.rcI).kY(paramBoolean);
      AppMethodBeat.o(196381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */