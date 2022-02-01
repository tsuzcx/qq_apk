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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class h
  implements o
{
  public static final h.a qlY;
  private WeakReference<Activity> mActivityRef;
  private final a qlD;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a qlE;
  private final b qlW;
  private final c qlX;
  
  static
  {
    AppMethodBeat.i(195400);
    qlY = new h.a((byte)0);
    AppMethodBeat.o(195400);
  }
  
  public h()
  {
    AppMethodBeat.i(195399);
    this.qlD = new a();
    this.qlE = new com.tencent.mm.plugin.expt.hellhound.a.a.a(13, "18260", "1013");
    this.qlW = new b(this);
    this.qlX = new c(this);
    AppMethodBeat.o(195399);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(195394);
    k.h(paramString, "aName");
    ac.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195394);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.ciO().l(744, paramString);
      AppMethodBeat.o(195394);
      return;
      c.ciO().l(745, paramString);
      AppMethodBeat.o(195394);
      return;
      c.ciO().l(746, paramString);
      AppMethodBeat.o(195394);
      return;
      c.ciO().l(747, paramString);
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195396);
    this.qlD.cjq();
    this.qlE.a(1, null);
    AppMethodBeat.o(195396);
  }
  
  public final void cjz()
  {
    AppMethodBeat.i(195395);
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
      this.qlD.a((e)this.qlW, (p)this.qlX);
      AppMethodBeat.o(195395);
      return;
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(195397);
    this.qlE.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(195397);
  }
  
  public final void report()
  {
    AppMethodBeat.i(195398);
    this.qlE.a(3, null);
    AppMethodBeat.o(195398);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195392);
      Object localObject = h.b(this.qlZ);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        ac.m("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(195392);
        return;
      }
      h.a(this.qlZ).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195392);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(195391);
      h.a(this.qlZ).g(paramViewGroup, h.Cs(paramInt));
      AppMethodBeat.o(195391);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void kH(boolean paramBoolean)
    {
      AppMethodBeat.i(195393);
      h.a(this.qlZ).kG(paramBoolean);
      AppMethodBeat.o(195393);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */