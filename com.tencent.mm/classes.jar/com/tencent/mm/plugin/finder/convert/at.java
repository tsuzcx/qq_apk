package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderVideoFoldedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFoldedConvert;", "controller", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "(Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class at
  extends ae
{
  public at(FinderFoldedScrollLayout.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(197492);
    AppMethodBeat.o(197492);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197490);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramBaseFinderFeed = (bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList());
    parame = (ImageView)parame.abq(2131305798);
    if (bt.isNullOrNil(paramBaseFinderFeed.coverUrl))
    {
      paramBaseFinderFeed = new f(paramBaseFinderFeed, com.tencent.mm.plugin.finder.storage.h.qJZ);
      paramList = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramList = com.tencent.mm.plugin.finder.loader.h.cmU();
      k.g(parame, "thumbIv");
      localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramList.a(paramBaseFinderFeed, parame, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
      AppMethodBeat.o(197490);
      return;
    }
    paramBaseFinderFeed = new n(paramBaseFinderFeed, com.tencent.mm.plugin.finder.storage.h.qJY);
    paramList = com.tencent.mm.plugin.finder.loader.h.qCF;
    paramList = com.tencent.mm.plugin.finder.loader.h.cmU();
    k.g(parame, "thumbIv");
    com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
    paramList.a(paramBaseFinderFeed, parame, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
    AppMethodBeat.o(197490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.at
 * JD-Core Version:    0.7.0.1
 */