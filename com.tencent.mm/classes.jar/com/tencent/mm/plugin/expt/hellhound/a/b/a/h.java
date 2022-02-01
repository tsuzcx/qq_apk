package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class h
  implements o
{
  public static final h.a sDA;
  private WeakReference<Activity> mActivityRef;
  private final a sDf;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  private final b sDy;
  private final c sDz;
  
  static
  {
    AppMethodBeat.i(220879);
    sDA = new h.a((byte)0);
    AppMethodBeat.o(220879);
  }
  
  public h()
  {
    AppMethodBeat.i(220878);
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(13, "18260", "1013");
    this.sDy = new b(this);
    this.sDz = new c(this);
    AppMethodBeat.o(220878);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220873);
    kotlin.g.b.p.h(paramString, "aName");
    Log.i("HABBYGE-MALI.FinderLbsMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220873);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cNJ().m(744, paramString);
      AppMethodBeat.o(220873);
      return;
      c.cNJ().m(745, paramString);
      AppMethodBeat.o(220873);
      return;
      c.cNJ().m(746, paramString);
      AppMethodBeat.o(220873);
      return;
      c.cNJ().m(747, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220876);
    this.sDg.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(220876);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220877);
    this.sDg.a(3, null);
    AppMethodBeat.o(220877);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220874);
    com.tencent.mm.plugin.expt.hellhound.a.a.a locala;
    if (this.mActivityRef != null)
    {
      locala = this.sDg;
      localObject = this.mActivityRef;
      if (localObject == null) {
        break label67;
      }
    }
    label67:
    for (Object localObject = (Activity)((WeakReference)localObject).get();; localObject = null)
    {
      locala.a(0, (Activity)localObject);
      this.sDf.a((f)this.sDy, (p)this.sDz);
      AppMethodBeat.o(220874);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220875);
    this.sDf.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220875);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220871);
      Object localObject = h.b(this.sDB);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderLbsMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(220871);
        return;
      }
      h.a(this.sDB).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220871);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(220870);
      h.a(this.sDB).g(paramViewGroup, h.Hd(paramInt));
      AppMethodBeat.o(220870);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderLbsMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void md(boolean paramBoolean)
    {
      AppMethodBeat.i(220872);
      h.a(this.sDB).mc(paramBoolean);
      AppMethodBeat.o(220872);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */