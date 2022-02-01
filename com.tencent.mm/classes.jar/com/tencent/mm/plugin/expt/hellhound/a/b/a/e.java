package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFeedFlowMonitor;", "()V", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mFeedFlowCallback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FeedFlowCallback;", "mFeedMonitor", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/FeedMonitor;", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1;", "mSmoothListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1;", "convertState", "", "scrollState", "free", "", "monitor", "cmd", "aName", "", "activity", "report", "startMonitor", "stopMonitor", "Companion", "plugin-expt_release"})
public final class e
  implements o
{
  public static final e.a sDo;
  private WeakReference<Activity> mActivityRef;
  private final a sDf;
  private com.tencent.mm.plugin.expt.hellhound.a.a.a sDg;
  private final b sDm;
  private final c sDn;
  
  static
  {
    AppMethodBeat.i(220853);
    sDo = new e.a((byte)0);
    AppMethodBeat.o(220853);
  }
  
  public e()
  {
    AppMethodBeat.i(220852);
    this.sDf = new a();
    this.sDg = new com.tencent.mm.plugin.expt.hellhound.a.a.a(8, "18260", "1008");
    this.sDm = new b(this);
    this.sDn = new c(this);
    AppMethodBeat.o(220852);
  }
  
  public final void a(int paramInt, String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(220847);
    kotlin.g.b.p.h(paramString, "aName");
    Log.i("HABBYGE-MALI.FinderFeedRelMonitor", "monitor: %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220847);
      return;
      if (paramActivity != null) {
        this.mActivityRef = new WeakReference(paramActivity);
      }
      c.cNJ().m(728, paramString);
      AppMethodBeat.o(220847);
      return;
      c.cNJ().m(729, paramString);
      AppMethodBeat.o(220847);
      return;
      c.cNJ().m(730, paramString);
      AppMethodBeat.o(220847);
      return;
      c.cNJ().m(731, paramString);
    }
  }
  
  public final void free()
  {
    AppMethodBeat.i(220850);
    this.sDg.a(2, null);
    WeakReference localWeakReference = this.mActivityRef;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.mActivityRef = null;
    AppMethodBeat.o(220850);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220851);
    this.sDg.a(3, null);
    AppMethodBeat.o(220851);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(220848);
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
      this.sDf.a((f)this.sDm, (p)this.sDn);
      AppMethodBeat.o(220848);
      return;
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220849);
    this.sDf.stopMonitor();
    this.sDg.a(1, null);
    AppMethodBeat.o(220849);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/IFeedOnScrollListener;", "onScroll", "", "listView", "Landroid/view/ViewGroup;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "dx", "dy", "onScrollStateChanged", "scrollState", "plugin-expt_release"})
  public static final class b
    implements f
  {
    public final void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(220845);
      Object localObject = e.b(this.sDp);
      if (localObject != null) {}
      for (localObject = (Activity)((WeakReference)localObject).get(); (localObject == null) || (((Activity)localObject).isFinishing()) || (((Activity)localObject).isDestroyed()); localObject = null)
      {
        Log.printInfoStack("HABBYGE-MALI.FinderFeedRelMonitor", "onScroll, is NULL or finishing", new Object[0]);
        AppMethodBeat.o(220845);
        return;
      }
      e.a(this.sDp).a((Activity)localObject, paramViewGroup, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(220845);
    }
    
    public final void k(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(220844);
      e.a(this.sDp).g(paramViewGroup, e.Ha(paramInt));
      AppMethodBeat.o(220844);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/FinderFeedRelMonitor$mSmoothListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/feedflow/IFinderSmoothListener;", "scrollToPosition", "", "postion2Zero", "", "smoothScrollToPosition", "position", "", "plugin-expt_release"})
  public static final class c
    implements p
  {
    public final void md(boolean paramBoolean)
    {
      AppMethodBeat.i(220846);
      e.a(this.sDp).mc(paramBoolean);
      AppMethodBeat.o(220846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */