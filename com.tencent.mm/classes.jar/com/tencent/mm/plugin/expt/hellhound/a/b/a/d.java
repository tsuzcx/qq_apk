package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class d
  implements o
{
  public static final d.a qlI;
  private WeakReference<Activity> mActivityRef;
  private final a qlD;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final b qlG;
  private final c qlH;
  
  static
  {
    AppMethodBeat.i(195364);
    qlI = new d.a((byte)0);
    AppMethodBeat.o(195364);
  }
  
  public d()
  {
    AppMethodBeat.i(195363);
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(9, "18260", "1009");
    this.qlG = new b(this);
    this.qlH = new c(this);
    AppMethodBeat.o(195363);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195358);
    k.h(paramString, "aName");
    ac.i("HABBYGE-MALI.FinderFavMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195358);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.ciO().l(732, paramString);
      AppMethodBeat.o(195358);
      return;
      c.ciO().l(733, paramString);
      AppMethodBeat.o(195358);
      return;
      c.ciO().l(734, paramString);
      AppMethodBeat.o(195358);
      return;
      c.ciO().l(735, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195360);
    this.qlD.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195360);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195359);
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
      this.qlD.a((e)this.qlG, (p)this.qlH);
      AppMethodBeat.o(195359);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(195361);
    this.qlE.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(195361);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195362);
    this.qlE.a(3, null);
    AppMethodBeat.o(195362);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195356);
      Object localObject = d.b(this.qlJ);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ac.m("HABBYGE-MALI.FinderFavMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(195356);
        return;
      }
      d.a(this.qlJ).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195356);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(195355);
      d.a(this.qlJ).g(paramViewGroup, d.Co(paramInt));
      AppMethodBeat.o(195355);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kH(boolean paramBoolean)
    {
      AppMethodBeat.i(195357);
      d.a(this.qlJ).kG(paramBoolean);
      AppMethodBeat.o(195357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */