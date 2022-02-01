package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderVideoFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class bg
  extends y
{
  public bg(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(201504);
    AppMethodBeat.o(201504);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201502);
    p.h(parame, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (bvf)j.jc((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramBaseFinderFeed = (ImageView)parame.Gd(2131305798);
    if (bt.isNullOrNil(paramList.coverUrl))
    {
      parame = new com.tencent.mm.plugin.finder.loader.g(paramList, r.syE);
      paramList = i.sja;
      paramList = i.cCB();
      locali = i.sja;
      paramList = paramList.a(parame, i.a(i.a.sjb));
      parame = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHX().value()).intValue() > 0) {}
      for (parame = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(paramBaseFinderFeed), 1);; parame = null)
      {
        parame = paramList.a((com.tencent.mm.loader.f.d)parame);
        p.g(paramBaseFinderFeed, "thumbIv");
        parame.c(paramBaseFinderFeed);
        AppMethodBeat.o(201502);
        return;
      }
    }
    parame = new n(paramList, r.syD);
    paramList = i.sja;
    paramList = i.cCB();
    i locali = i.sja;
    paramList = paramList.a(parame, i.a(i.a.sjb));
    parame = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cHX().value()).intValue() > 0) {}
    for (parame = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(paramBaseFinderFeed), 1);; parame = null)
    {
      parame = paramList.a((com.tencent.mm.loader.f.d)parame);
      p.g(paramBaseFinderFeed, "thumbIv");
      parame.c(paramBaseFinderFeed);
      AppMethodBeat.o(201502);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bg
 * JD-Core Version:    0.7.0.1
 */