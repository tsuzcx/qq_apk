package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderImageFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class z
  extends x
{
  public z(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(201333);
    AppMethodBeat.o(201333);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201331);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parame.adJ(2131302222);
    if (paramBaseFinderFeed.feedObject.getMediaList().size() > 1)
    {
      k.g(paramList, "mediaIcon");
      paramList.setImageDrawable(am.k(paramList.getContext(), 2131690348, a.n(paramList.getContext(), 2131099828)));
      paramList.setVisibility(0);
    }
    for (;;)
    {
      paramBaseFinderFeed = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
      parame = (ImageView)parame.adJ(2131305798);
      paramList = h.rtK;
      paramList = h.cwn();
      paramBaseFinderFeed = new f(paramBaseFinderFeed, m.rDR);
      k.g(parame, "thumbIv");
      h localh = h.rtK;
      paramList.a(paramBaseFinderFeed, parame, h.a(h.a.rtL));
      AppMethodBeat.o(201331);
      return;
      k.g(paramList, "mediaIcon");
      paramList.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.z
 * JD-Core Version:    0.7.0.1
 */