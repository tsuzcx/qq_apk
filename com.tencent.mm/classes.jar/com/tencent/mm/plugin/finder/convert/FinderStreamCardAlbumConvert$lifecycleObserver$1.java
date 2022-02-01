package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.protocal.protobuf.bcu;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onPause", "", "onResume", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$lifecycleObserver$1
  implements LifecycleObserver
{
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(243292);
    Object localObject = ch.j(this.tGu);
    if (localObject != null)
    {
      if (ch.a(this.tGu, (View)localObject))
      {
        ag localag = ch.b(this.tGu).tGs;
        if (localag != null)
        {
          long l1 = System.currentTimeMillis();
          long l2 = ch.b(this.tGu).startTimeMs;
          int i = ch.c(this.tGu).tRo.getDataListJustForAdapter().indexOf(localag);
          localObject = t.vhJ;
          String str = localag.tQQ.IFO;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          t.a((String)localObject, localag, i, l1 - l2, ch.d(this.tGu));
          AppMethodBeat.o(243292);
          return;
        }
      }
      AppMethodBeat.o(243292);
      return;
    }
    AppMethodBeat.o(243292);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(243293);
    View localView = ch.j(this.tGu);
    if (localView != null)
    {
      if (ch.a(this.tGu, localView)) {
        ch.b(this.tGu).startTimeMs = System.currentTimeMillis();
      }
      AppMethodBeat.o(243293);
      return;
    }
    AppMethodBeat.o(243293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */