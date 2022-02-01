package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class h
  implements o
{
  public static final h.a qUV;
  private WeakReference<Activity> mActivityRef;
  private final a qUA;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qUB;
  private final b qUT;
  private final c qUU;
  
  static
  {
    AppMethodBeat.i(210747);
    qUV = new h.a((byte)0);
    AppMethodBeat.o(210747);
  }
  
  public h()
  {
    AppMethodBeat.i(210746);
    this.qUA = new a();
    this.qUB = new com.tencent.mm.plugin.expt.hellhound.a.a.a(13, "18260", "1013");
    this.qUT = new b(this);
    this.qUU = new c(this);
    AppMethodBeat.o(210746);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(210741);
    d.g.b.p.h(paramString, "aName");
    ad.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210741);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cnO().l(744, paramString);
      AppMethodBeat.o(210741);
      return;
      c.cnO().l(745, paramString);
      AppMethodBeat.o(210741);
      return;
      c.cnO().l(746, paramString);
      AppMethodBeat.o(210741);
      return;
      c.cnO().l(747, paramString);
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210743);
    this.qUA.coC();
    this.qUB.a(1, null);
    AppMethodBeat.o(210743);
  }
  
  public final void coL()
  {
    AppMethodBeat.i(210742);
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
      this.qUA.a((e)this.qUT, (p)this.qUU);
      AppMethodBeat.o(210742);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(210744);
    this.qUB.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(210744);
  }
  
  public final void report()
  {
    AppMethodBeat.i(210745);
    this.qUB.a(3, null);
    AppMethodBeat.o(210745);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(210739);
      Object localObject = h.b(this.qUW);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ad.m("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(210739);
        return;
      }
      h.a(this.qUW).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(210739);
    }
    
    public final void l(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(210738);
      h.a(this.qUW).h(paramViewGroup, h.Df(paramInt));
      AppMethodBeat.o(210738);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kZ(boolean paramBoolean)
    {
      AppMethodBeat.i(210740);
      h.a(this.qUW).kY(paramBoolean);
      AppMethodBeat.o(210740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */