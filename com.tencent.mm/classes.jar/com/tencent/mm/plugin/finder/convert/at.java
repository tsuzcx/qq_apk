package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderVideoFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class at
  extends x
{
  public at(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(201367);
    AppMethodBeat.o(201367);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201365);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramBaseFinderFeed = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
    parame = (ImageView)parame.adJ(2131305798);
    if (bs.isNullOrNil(paramBaseFinderFeed.coverUrl))
    {
      paramBaseFinderFeed = new f(paramBaseFinderFeed, com.tencent.mm.plugin.finder.storage.m.rDR);
      paramList = h.rtK;
      paramList = h.cwn();
      k.g(parame, "thumbIv");
      localh = h.rtK;
      paramList.a(paramBaseFinderFeed, parame, h.a(h.a.rtL));
      AppMethodBeat.o(201365);
      return;
    }
    paramBaseFinderFeed = new com.tencent.mm.plugin.finder.loader.m(paramBaseFinderFeed, com.tencent.mm.plugin.finder.storage.m.rDQ);
    paramList = h.rtK;
    paramList = h.cwn();
    k.g(parame, "thumbIv");
    h localh = h.rtK;
    paramList.a(paramBaseFinderFeed, parame, h.a(h.a.rtL));
    AppMethodBeat.o(201365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.at
 * JD-Core Version:    0.7.0.1
 */