package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.az;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.protocal.protobuf.bjp;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onPause", "", "onResume", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$lifecycleObserver$1
  implements k
{
  @t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(245511);
    Object localObject = co.j(this.xph);
    if (localObject != null)
    {
      if (co.a(this.xph, (View)localObject))
      {
        an localan = co.b(this.xph).xpf;
        if (localan != null)
        {
          long l1 = System.currentTimeMillis();
          long l2 = co.b(this.xph).startTimeMs;
          int i = co.c(this.xph).xCg.getDataListJustForAdapter().indexOf(localan);
          localObject = x.zYS;
          String str = localan.xBH.PAf;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          x.a((String)localObject, localan, i, l1 - l2, co.d(this.xph));
          AppMethodBeat.o(245511);
          return;
        }
      }
      AppMethodBeat.o(245511);
      return;
    }
    AppMethodBeat.o(245511);
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(245512);
    View localView = co.j(this.xph);
    if (localView != null)
    {
      if (co.a(this.xph, localView)) {
        co.b(this.xph).startTimeMs = System.currentTimeMillis();
      }
      AppMethodBeat.o(245512);
      return;
    }
    AppMethodBeat.o(245512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */