package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderVideoFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class cu
  extends ao
{
  public cu(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb, b.g.finder_folded_media_item);
    AppMethodBeat.i(290393);
    AppMethodBeat.o(290393);
  }
  
  public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(290391);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramBaseFinderFeed = (ImageView)parami.RD(b.f.thumb_iv);
    if (Util.isNullOrNil(paramList.coverUrl))
    {
      parami = new r(paramList, u.Alz, null, null, 12);
      paramList = t.ztT;
      paramList = t.dJe();
      localt = t.ztT;
      paramList = paramList.a(parami, t.a(t.a.ztU));
      parami = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() > 0) {}
      for (parami = new com.tencent.mm.loader.e.d(null, new g(paramBaseFinderFeed), 1);; parami = null)
      {
        parami = paramList.a((com.tencent.mm.loader.f.d)parami);
        p.j(paramBaseFinderFeed, "thumbIv");
        parami.c(paramBaseFinderFeed);
        AppMethodBeat.o(290391);
        return;
      }
    }
    parami = new y(paramList, u.Aly);
    paramList = t.ztT;
    paramList = t.dJe();
    t localt = t.ztT;
    paramList = paramList.a(parami, t.a(t.a.ztU));
    parami = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() > 0) {}
    for (parami = new com.tencent.mm.loader.e.d(null, new g(paramBaseFinderFeed), 1);; parami = null)
    {
      parami = paramList.a((com.tencent.mm.loader.f.d)parami);
      p.j(paramBaseFinderFeed, "thumbIv");
      parami.c(paramBaseFinderFeed);
      AppMethodBeat.o(290391);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cu
 * JD-Core Version:    0.7.0.1
 */