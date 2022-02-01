package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class ag
  extends ae
{
  public ag(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(197458);
    AppMethodBeat.o(197458);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197456);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parame.abq(2131302222);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      k.g(paramList, "mediaIcon");
      paramList.setImageDrawable(am.i(paramList.getContext(), 2131690348, a.n(paramList.getContext(), 2131099828)));
      paramList.setVisibility(0);
    }
    for (;;)
    {
      paramBaseFinderFeed = (bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList());
      parame = (ImageView)parame.abq(2131305798);
      paramList = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramList = com.tencent.mm.plugin.finder.loader.h.cmU();
      paramBaseFinderFeed = new f(paramBaseFinderFeed, com.tencent.mm.plugin.finder.storage.h.qJZ);
      k.g(parame, "thumbIv");
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramList.a(paramBaseFinderFeed, parame, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
      AppMethodBeat.o(197456);
      return;
      k.g(paramList, "mediaIcon");
      paramList.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ag
 * JD-Core Version:    0.7.0.1
 */