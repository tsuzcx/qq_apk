package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class h
  implements o
{
  public static final h.a rcT;
  private WeakReference<Activity> mActivityRef;
  private final b rcR;
  private final c rcS;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196414);
    rcT = new h.a((byte)0);
    AppMethodBeat.o(196414);
  }
  
  public h()
  {
    AppMethodBeat.i(196413);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(13, "18260", "1013");
    this.rcR = new b(this);
    this.rcS = new c(this);
    AppMethodBeat.o(196413);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196408);
    d.g.b.p.h(paramString, "aName");
    ae.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196408);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cpq().l(744, paramString);
      AppMethodBeat.o(196408);
      return;
      c.cpq().l(745, paramString);
      AppMethodBeat.o(196408);
      return;
      c.cpq().l(746, paramString);
      AppMethodBeat.o(196408);
      return;
      c.cpq().l(747, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196410);
    this.rcy.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196410);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196409);
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
      this.rcy.a((e)this.rcR, (p)this.rcS);
      AppMethodBeat.o(196409);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196411);
    this.rcz.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196411);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196412);
    this.rcz.a(3, null);
    AppMethodBeat.o(196412);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196406);
      Object localObject = h.b(this.rcU);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ae.m("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(196406);
        return;
      }
      h.a(this.rcU).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196406);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196405);
      h.a(this.rcU).h(paramViewGroup, h.Ds(paramInt));
      AppMethodBeat.o(196405);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196407);
      h.a(this.rcU).kY(paramBoolean);
      AppMethodBeat.o(196407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */