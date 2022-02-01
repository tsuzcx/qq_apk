package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class e
  implements o
{
  public static final a KFy;
  private final a KFq;
  private final b KFw;
  private final c KFx;
  private WeakReference<Activity> mActivityRef;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a pGv;
  
  static
  {
    AppMethodBeat.i(205115);
    KFy = new a((byte)0);
    AppMethodBeat.o(205115);
  }
  
  public e()
  {
    AppMethodBeat.i(205114);
    this.KFq = new a();
    this.pGv = new com.tencent.mm.plugin.expt.hellhound.a.a.a(8, "18260", "1008");
    this.KFw = new b(this);
    this.KFx = new c(this);
    AppMethodBeat.o(205114);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(205109);
    k.h(paramString, "aName");
    ad.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205109);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cbD().l(728, paramString);
      AppMethodBeat.o(205109);
      return;
      c.cbD().l(729, paramString);
      AppMethodBeat.o(205109);
      return;
      c.cbD().l(730, paramString);
      AppMethodBeat.o(205109);
      return;
      c.cbD().l(731, paramString);
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205111);
    this.KFq.ccd();
    this.pGv.a(1, null);
    AppMethodBeat.o(205111);
  }
  
  public final void cdL()
  {
    AppMethodBeat.i(205110);
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
      this.KFq.a((d)this.KFw, (p)this.KFx);
      AppMethodBeat.o(205110);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(205112);
    this.pGv.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(205112);
  }
  
  public final void report()
  {
    AppMethodBeat.i(205113);
    this.pGv.a(3, null);
    AppMethodBeat.o(205113);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements d
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205107);
      Object localObject = e.b(this.KFz);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(205107);
        return;
      }
      e.a(this.KFz).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205107);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(205106);
      e.a(this.KFz).g(paramViewGroup, e.agU(paramInt));
      AppMethodBeat.o(205106);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void yx(boolean paramBoolean)
    {
      AppMethodBeat.i(205108);
      e.a(this.KFz).kc(paramBoolean);
      AppMethodBeat.o(205108);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */