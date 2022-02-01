package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class w
  extends q
{
  public w()
  {
    super(2131494051);
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165436);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parame.adJ(2131302222);
    k.g(paramList, "mediaIcon");
    paramList.setVisibility(8);
    paramList = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramBaseFinderFeed = (ImageView)parame.adJ(2131305798);
    k.g(paramBaseFinderFeed, "thumbIv");
    Object localObject1 = paramBaseFinderFeed.getLayoutParams();
    Object localObject2 = parame.getContext();
    k.g(localObject2, "holder.context");
    localObject2 = ((Context)localObject2).getResources();
    k.g(localObject2, "holder.context.resources");
    paramInt1 = ((Resources)localObject2).getDisplayMetrics().widthPixels;
    parame = parame.getContext();
    k.g(parame, "holder.context");
    int i = (paramInt1 - (int)parame.getResources().getDimension(2131165284)) / 2;
    if (i > 0)
    {
      paramInt2 = (int)(paramList.height * i / paramList.width);
      paramInt1 = paramInt2;
      if (paramInt2 > i * 1.166666666666667D) {
        paramInt1 = (int)(i * 1.166666666666667D);
      }
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
      paramBaseFinderFeed.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (bs.isNullOrNil(paramList.coverUrl))
    {
      parame = new f(paramList, com.tencent.mm.plugin.finder.storage.m.rDR);
      paramList = h.rtK;
      paramList = h.cwn();
      localObject1 = h.rtK;
      paramList.a(parame, paramBaseFinderFeed, h.a(h.a.rtL));
      AppMethodBeat.o(165436);
      return;
    }
    parame = new com.tencent.mm.plugin.finder.loader.m(paramList, com.tencent.mm.plugin.finder.storage.m.rDQ);
    paramList = h.rtK;
    paramList = h.cwn();
    localObject1 = h.rtK;
    paramList.a(parame, paramBaseFinderFeed, h.a(h.a.rtL));
    AppMethodBeat.o(165436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.w
 * JD-Core Version:    0.7.0.1
 */