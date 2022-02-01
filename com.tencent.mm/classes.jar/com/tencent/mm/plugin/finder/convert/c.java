package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.g;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.view.recyclerview.e;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFavGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class c
  extends q
{
  private String TAG = "Finder.FinderFavGridConvert";
  
  public c()
  {
    super(2131496208);
  }
  
  public final void a(e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(201254);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    Object localObject2 = (bqs)j.iO((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)parame.adJ(2131307401);
    Object localObject1;
    h localh;
    if (((bqs)localObject2).mediaType == 4)
    {
      localObject1 = new f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDR);
      localObject2 = h.rtK;
      localObject2 = h.cwn();
      k.g(paramList, "imageView");
      localh = h.rtK;
      ((d)localObject2).a(localObject1, paramList, h.a(h.a.rtL));
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label266;
      }
      paramList = parame.adJ(2131307481);
      k.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(0);
      paramList = parame.adJ(2131307482);
      k.g(paramList, "holder.getView<TextView>(R.id.item_like_count_tv)");
      ((TextView)paramList).setText((CharSequence)g.fD(2, paramBaseFinderFeed.feedObject.getLikeCount()));
      label174:
      parame = parame.adJ(2131307477);
      k.g(parame, "holder.getView<ImageView>(R.id.if_item_image)");
      parame = (ImageView)parame;
      if (!(paramBaseFinderFeed instanceof com.tencent.mm.plugin.finder.model.m)) {
        break label291;
      }
    }
    label266:
    label291:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      parame.setVisibility(paramInt1);
      AppMethodBeat.o(201254);
      return;
      localObject1 = h.rtK;
      localObject1 = h.cwn();
      localObject2 = new f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDR);
      k.g(paramList, "imageView");
      localh = h.rtK;
      ((d)localObject1).a(localObject2, paramList, h.a(h.a.rtL));
      break;
      paramList = parame.adJ(2131307481);
      k.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(8);
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.c
 * JD-Core Version:    0.7.0.1
 */