package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageRoundCornerConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "screenWidth", "", "getScreenWidth", "()I", "screenWidth$delegate", "Lkotlin/Lazy;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public class w
  extends ag
{
  private final f xlu;
  
  public w()
  {
    super(b.g.finder_feed_round_corner_media_item);
    AppMethodBeat.i(265682);
    this.xlu = g.ar((a)w.a.xlv);
    AppMethodBeat.o(265682);
  }
  
  public void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(165396);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    super.a(parami, paramBaseFinderFeed, paramInt1, paramInt2, paramBoolean, paramList);
    Object localObject1 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)parami.RD(b.f.thumb_iv);
    p.j(paramList, "thumbIv");
    Object localObject2 = paramList.getLayoutParams();
    paramInt1 = ((Number)this.xlu.getValue()).intValue();
    Object localObject3 = parami.getContext();
    p.j(localObject3, "holder.context");
    paramInt1 = (paramInt1 - (int)((Context)localObject3).getResources().getDimension(b.d.Edge_1_5_A)) / 2;
    localObject3 = aj.AGc;
    paramInt2 = aj.a(paramBaseFinderFeed, (csg)localObject1, paramInt1);
    if (paramInt2 > 0)
    {
      ((ViewGroup.LayoutParams)localObject2).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject2).height = paramInt2;
      paramList.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject2 = t.ztT;
    localObject2 = t.dJe();
    localObject1 = new r((csg)localObject1, u.Alz, null, null, 12);
    localObject3 = t.ztT;
    ((d)localObject2).a(localObject1, paramList, t.a(t.a.ztU));
    paramList = (ImageIndicatorView)parami.RD(b.f.image_indicator);
    if (paramList != null) {
      paramList.setVisibility(0);
    }
    if (paramList != null) {
      paramList.ahH(paramBaseFinderFeed.feedObject.getMediaList().size());
    }
    l(parami, paramBaseFinderFeed);
    if ((h(paramBaseFinderFeed)) && (paramList != null))
    {
      parami = parami.getContext();
      p.j(parami, "holder.context");
      paramList.setBackgroundColor(parami.getResources().getColor(b.c.finder_activity_item_covered_background));
      AppMethodBeat.o(165396);
      return;
    }
    AppMethodBeat.o(165396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.w
 * JD-Core Version:    0.7.0.1
 */