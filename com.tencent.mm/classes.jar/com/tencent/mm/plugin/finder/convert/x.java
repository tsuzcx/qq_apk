package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class x
  extends r
{
  public x()
  {
    super(2131494051);
  }
  
  public void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165436);
    p.h(parame, "holder");
    p.h(paramBaseFinderFeed, "item");
    super.a(parame, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    paramList = (ImageView)parame.GD(2131302222);
    p.g(paramList, "mediaIcon");
    paramList.setVisibility(8);
    paramList = (bvz)j.jl((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramBaseFinderFeed = (ImageView)parame.GD(2131305798);
    p.g(paramBaseFinderFeed, "thumbIv");
    Object localObject1 = paramBaseFinderFeed.getLayoutParams();
    Object localObject2 = parame.getContext();
    p.g(localObject2, "holder.context");
    localObject2 = ((Context)localObject2).getResources();
    p.g(localObject2, "holder.context.resources");
    paramInt1 = ((Resources)localObject2).getDisplayMetrics().widthPixels;
    parame = parame.getContext();
    p.g(parame, "holder.context");
    int i = (paramInt1 - (int)parame.getResources().getDimension(2131165284)) / 2;
    if (i > 0)
    {
      paramInt2 = (int)(paramList.height * i / paramList.width);
      paramInt1 = paramInt2;
      if (paramInt2 > i * 1.316667F) {
        paramInt1 = (int)(i * 1.316667F);
      }
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
      paramBaseFinderFeed.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (bu.isNullOrNil(paramList.coverUrl))
    {
      parame = new g(paramList, com.tencent.mm.plugin.finder.storage.r.sJv);
      paramList = i.srW;
      paramList = i.cEn();
      localObject1 = i.srW;
      paramList.a(parame, paramBaseFinderFeed, i.a(i.a.srX));
      AppMethodBeat.o(165436);
      return;
    }
    parame = new n(paramList, com.tencent.mm.plugin.finder.storage.r.sJu);
    paramList = i.srW;
    paramList = i.cEn();
    localObject1 = i.srW;
    paramList.a(parame, paramBaseFinderFeed, i.a(i.a.srX));
    AppMethodBeat.o(165436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.x
 * JD-Core Version:    0.7.0.1
 */