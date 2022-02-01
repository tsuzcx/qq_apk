package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "run"})
final class h$be
  implements Runnable
{
  h$be(h paramh, View paramView, e parame, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(221452);
    int i = this.EIv.getHeight();
    int j = z.iF(this.oNd.getContext()) - this.xNk + i;
    ad.i("Finder.FeedConvert", "[openCommentDrawer] offset=" + j + " itemBottom=" + this.EIw + " recyclerViewBottom=" + h.g(this.rMP).bottom + " editLayoutHeight=" + i);
    if (j > 0)
    {
      FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = h.d(this.rMP).getVideoCore().sOZ;
      if (localFinderVideoAutoPlayManager != null) {
        FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, "openCommentDrawer", true);
      }
      this.oNd.getRecyclerView().smoothScrollBy(0, j);
    }
    AppMethodBeat.o(221452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.be
 * JD-Core Version:    0.7.0.1
 */