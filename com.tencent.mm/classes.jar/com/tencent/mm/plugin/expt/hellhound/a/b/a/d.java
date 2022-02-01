package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class d
  implements o
{
  public static final a KFu;
  private final a KFq;
  private final b KFs;
  private final c KFt;
  private WeakReference<Activity> mActivityRef;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  static
  {
    AppMethodBeat.i(205105);
    KFu = new a((byte)0);
    AppMethodBeat.o(205105);
  }
  
  public d()
  {
    AppMethodBeat.i(205104);
    this.KFq = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(9, "18260", "1009");
    this.KFs = new b(this);
    this.KFt = new c(this);
    AppMethodBeat.o(205104);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205099);
    k.h(paramString, "aName");
    ad.i("HABBYGE-MALI.FinderFavMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205099);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cbD().l(732, paramString);
      AppMethodBeat.o(205099);
      return;
      c.cbD().l(733, paramString);
      AppMethodBeat.o(205099);
      return;
      c.cbD().l(734, paramString);
      AppMethodBeat.o(205099);
      return;
      c.cbD().l(735, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205101);
    this.KFq.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205101);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205100);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.pGv;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(0, (Activity)localObject);
      this.KFq.a((com.tencent.mm.plugin.expt.hellhound.a.a.d)this.KFs, (p)this.KFt);
      AppMethodBeat.o(205100);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(205102);
    this.pGv.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(205102);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205103);
    this.pGv.a(3, null);
    AppMethodBeat.o(205103);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.d
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205097);
      Object localObject = d.b(this.KFv);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderFavMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(205097);
        return;
      }
      d.a(this.KFv).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205097);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(205096);
      d.a(this.KFv).g(paramViewGroup, d.agT(paramInt));
      AppMethodBeat.o(205096);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFavMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void yx(boolean paramBoolean)
    {
      AppMethodBeat.i(205098);
      d.a(this.KFv).kc(paramBoolean);
      AppMethodBeat.o(205098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */