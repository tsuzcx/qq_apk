package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class e
  implements o
{
  public static final e.a qlM;
  private WeakReference<Activity> mActivityRef;
  private final a qlD;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final b qlK;
  private final c qlL;
  
  static
  {
    AppMethodBeat.i(195374);
    qlM = new e.a((byte)0);
    AppMethodBeat.o(195374);
  }
  
  public e()
  {
    AppMethodBeat.i(195373);
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(8, "18260", "1008");
    this.qlK = new b(this);
    this.qlL = new c(this);
    AppMethodBeat.o(195373);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195368);
    k.h(paramString, "aName");
    ac.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195368);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.ciO().l(728, paramString);
      AppMethodBeat.o(195368);
      return;
      c.ciO().l(729, paramString);
      AppMethodBeat.o(195368);
      return;
      c.ciO().l(730, paramString);
      AppMethodBeat.o(195368);
      return;
      c.ciO().l(731, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195370);
    this.qlD.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195370);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195369);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.qlE;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(0, (Activity)localObject);
      this.qlD.a((com.tencent.mm.plugin.expt.hellhound.a.a.e)this.qlK, (p)this.qlL);
      AppMethodBeat.o(195369);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(195371);
    this.qlE.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(195371);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195372);
    this.qlE.a(3, null);
    AppMethodBeat.o(195372);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195366);
      Object localObject = e.b(this.qlN);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ac.m("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(195366);
        return;
      }
      e.a(this.qlN).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195366);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(195365);
      e.a(this.qlN).g(paramViewGroup, e.Cp(paramInt));
      AppMethodBeat.o(195365);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kH(boolean paramBoolean)
    {
      AppMethodBeat.i(195367);
      e.a(this.qlN).kG(paramBoolean);
      AppMethodBeat.o(195367);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */