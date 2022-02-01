package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFavGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class c
  extends r
{
  private String TAG = "Finder.FinderFavGridConvert";
  
  public c()
  {
    super(2131496208);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201732);
    p.h(parame, "holder");
    p.h(paramBaseFinderFeed, "item");
    Object localObject2 = (bvz)j.jl((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)parame.GD(2131307401);
    Object localObject1;
    i locali;
    if (((bvz)localObject2).mediaType == 4)
    {
      localObject1 = new g((bvz)localObject2, com.tencent.mm.plugin.finder.storage.r.sJv);
      localObject2 = i.srW;
      localObject2 = i.cEn();
      p.g(paramList, "imageView");
      locali = i.srW;
      ((d)localObject2).a(localObject1, paramList, i.a(i.a.srX));
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label266;
      }
      paramList = parame.GD(2131307481);
      p.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(0);
      paramList = parame.GD(2131307482);
      p.g(paramList, "holder.getView<TextView>(R.id.item_like_count_tv)");
      ((TextView)paramList).setText((CharSequence)h.fR(2, paramBaseFinderFeed.feedObject.getLikeCount()));
      label174:
      parame = parame.GD(2131307477);
      p.g(parame, "holder.getView<ImageView>(R.id.if_item_image)");
      parame = (ImageView)parame;
      if (!(paramBaseFinderFeed instanceof o)) {
        break label291;
      }
    }
    label266:
    label291:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      parame.setVisibility(paramInt1);
      AppMethodBeat.o(201732);
      return;
      localObject1 = i.srW;
      localObject1 = i.cEn();
      localObject2 = new g((bvz)localObject2, com.tencent.mm.plugin.finder.storage.r.sJv);
      p.g(paramList, "imageView");
      locali = i.srW;
      ((d)localObject1).a(localObject2, paramList, i.a(i.a.srX));
      break;
      paramList = parame.GD(2131307481);
      p.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(8);
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.c
 * JD-Core Version:    0.7.0.1
 */