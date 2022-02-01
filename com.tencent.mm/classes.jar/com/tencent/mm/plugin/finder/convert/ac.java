package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class ac
  extends y
{
  public ac(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(201427);
    AppMethodBeat.o(201427);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201425);
    p.h(parame, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parame.Gd(2131302222);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      p.g(paramList, "mediaIcon");
      paramList.setImageDrawable(ao.k(paramList.getContext(), 2131690348, a.n(paramList.getContext(), 2131099828)));
      paramList.setVisibility(0);
      paramList = (bvf)j.jc((List)paramBaseFinderFeed.feedObject.getMediaList());
      paramBaseFinderFeed = (ImageView)parame.Gd(2131305798);
      parame = i.sja;
      parame = i.cCB();
      paramList = new com.tencent.mm.plugin.finder.loader.g(paramList, r.syE);
      i locali = i.sja;
      paramList = parame.a(paramList, i.a(i.a.sjb));
      parame = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHX().value()).intValue() <= 0) {
        break label245;
      }
    }
    label245:
    for (parame = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(paramBaseFinderFeed), 1);; parame = null)
    {
      parame = paramList.a((com.tencent.mm.loader.f.d)parame);
      p.g(paramBaseFinderFeed, "thumbIv");
      parame.c(paramBaseFinderFeed);
      AppMethodBeat.o(201425);
      return;
      p.g(paramList, "mediaIcon");
      paramList.setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ac
 * JD-Core Version:    0.7.0.1
 */