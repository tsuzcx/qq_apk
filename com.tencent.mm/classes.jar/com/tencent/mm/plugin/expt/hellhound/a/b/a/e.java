package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class e
  implements o
{
  public static final e.a qUJ;
  private WeakReference<Activity> mActivityRef;
  private final a qUA;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final b qUH;
  private final c qUI;
  
  static
  {
    AppMethodBeat.i(210721);
    qUJ = new e.a((byte)0);
    AppMethodBeat.o(210721);
  }
  
  public e()
  {
    AppMethodBeat.i(210720);
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(8, "18260", "1008");
    this.qUH = new b(this);
    this.qUI = new c(this);
    AppMethodBeat.o(210720);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210715);
    d.g.b.p.h(paramString, "aName");
    ad.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210715);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cnO().l(728, paramString);
      AppMethodBeat.o(210715);
      return;
      c.cnO().l(729, paramString);
      AppMethodBeat.o(210715);
      return;
      c.cnO().l(730, paramString);
      AppMethodBeat.o(210715);
      return;
      c.cnO().l(731, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210717);
    this.qUA.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210717);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210716);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.qUB;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(0, (Activity)localObject);
      this.qUA.a((com.tencent.mm.plugin.expt.hellhound.a.a.e)this.qUH, (p)this.qUI);
      AppMethodBeat.o(210716);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(210718);
    this.qUB.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(210718);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210719);
    this.qUB.a(3, null);
    AppMethodBeat.o(210719);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.plugin.expt.hellhound.a.a.e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210713);
      Object localObject = e.b(this.qUK);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(210713);
        return;
      }
      e.a(this.qUK).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210713);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210712);
      e.a(this.qUK).h(paramViewGroup, e.Dc(paramInt));
      AppMethodBeat.o(210712);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(210714);
      e.a(this.qUK).kY(paramBoolean);
      AppMethodBeat.o(210714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */