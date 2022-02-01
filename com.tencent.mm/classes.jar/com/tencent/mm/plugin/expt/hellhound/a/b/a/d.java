package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class d
  implements o
{
  public static final d.a rcD;
  private WeakReference<Activity> mActivityRef;
  private final b rcB;
  private final c rcC;
  private final a rcy;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a rcz;
  
  static
  {
    AppMethodBeat.i(196378);
    rcD = new d.a((byte)0);
    AppMethodBeat.o(196378);
  }
  
  public d()
  {
    AppMethodBeat.i(196377);
    this.rcy = new a();
    this.rcz = new com.tencent.mm.plugin.expt.hellhound.a.a.a(9, "18260", "1009");
    this.rcB = new b(this);
    this.rcC = new c(this);
    AppMethodBeat.o(196377);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(196372);
    d.g.b.p.h(paramString, "aName");
    ae.i("HABBYGE-MALI.FinderFavMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196372);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cpq().l(732, paramString);
      AppMethodBeat.o(196372);
      return;
      c.cpq().l(733, paramString);
      AppMethodBeat.o(196372);
      return;
      c.cpq().l(734, paramString);
      AppMethodBeat.o(196372);
      return;
      c.cpq().l(735, paramString);
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196374);
    this.rcy.cqe();
    this.rcz.a(1, null);
    AppMethodBeat.o(196374);
  }
  
  public final void cqn()
  {
    AppMethodBeat.i(196373);
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
      this.rcy.a((e)this.rcB, (p)this.rcC);
      AppMethodBeat.o(196373);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(196375);
    this.rcz.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(196375);
  }
  
  public final void report()
  {
    AppMethodBeat.i(196376);
    this.rcz.a(3, null);
    AppMethodBeat.o(196376);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196370);
      Object localObject = d.b(this.rcE);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ae.m("HABBYGE-MALI.FinderFavMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(196370);
        return;
      }
      d.a(this.rcE).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(196370);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(196369);
      d.a(this.rcE).h(paramViewGroup, d.Do(paramInt));
      AppMethodBeat.o(196369);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(196371);
      d.a(this.rcE).kY(paramBoolean);
      AppMethodBeat.o(196371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */