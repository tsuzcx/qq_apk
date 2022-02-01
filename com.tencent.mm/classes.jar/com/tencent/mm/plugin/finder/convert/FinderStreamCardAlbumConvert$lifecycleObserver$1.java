package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.bg;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onPause", "", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderStreamCardAlbumConvert$lifecycleObserver$1
  implements p
{
  FinderStreamCardAlbumConvert$lifecycleObserver$1(cq paramcq) {}
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(349763);
    Object localObject1 = cq.k(this.AMH);
    if (localObject1 != null)
    {
      Object localObject3 = this.AMH;
      if (cq.a((cq)localObject3, (View)localObject1))
      {
        au localau = cq.i((cq)localObject3).AMC;
        if (localau != null)
        {
          long l1 = System.currentTimeMillis();
          long l2 = cq.i((cq)localObject3).startTimeMs;
          int i = cq.b((cq)localObject3).AZs.getDataListJustForAdapter().indexOf(localau);
          localObject1 = aj.FtF;
          Object localObject2 = localau.AYW.Wqu;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localObject3 = cq.c((cq)localObject3);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("contextObj");
            localObject2 = null;
          }
          aj.a((String)localObject1, localau, i, l1 - l2, (bui)localObject2);
        }
      }
    }
    AppMethodBeat.o(349763);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(349775);
    View localView = cq.k(this.AMH);
    if (localView != null)
    {
      cq localcq = this.AMH;
      if (cq.a(localcq, localView)) {
        cq.i(localcq).startTimeMs = System.currentTimeMillis();
      }
    }
    AppMethodBeat.o(349775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */