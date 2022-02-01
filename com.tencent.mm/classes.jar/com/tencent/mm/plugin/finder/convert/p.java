package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.bmd;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFavGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class p
  extends m
{
  private String TAG = "Finder.FinderFavGridConvert";
  
  public p()
  {
    super(2131496207);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(197379);
    k.h(parame, "holder");
    k.h(paramBaseFinderFeed, "item");
    Object localObject2 = (bmd)j.iy((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)parame.abq(2131307332);
    Object localObject1;
    com.tencent.mm.plugin.finder.loader.h localh;
    if (((bmd)localObject2).mediaType == 4)
    {
      localObject1 = new f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJZ);
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cmU();
      k.g(paramList, "imageView");
      localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject2).a(localObject1, paramList, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
      if (paramBaseFinderFeed.feedObject.getLikeCount() <= 0) {
        break label266;
      }
      paramList = parame.abq(2131307405);
      k.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(0);
      paramList = parame.abq(2131307406);
      k.g(paramList, "holder.getView<TextView>(R.id.item_like_count_tv)");
      ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.e.fz(2, paramBaseFinderFeed.feedObject.getLikeCount()));
      label174:
      parame = parame.abq(2131307404);
      k.g(parame, "holder.getView<ImageView>(R.id.if_item_image)");
      parame = (ImageView)parame;
      if (!(paramBaseFinderFeed instanceof i)) {
        break label291;
      }
    }
    label266:
    label291:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      parame.setVisibility(paramInt1);
      AppMethodBeat.o(197379);
      return;
      localObject1 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject1 = com.tencent.mm.plugin.finder.loader.h.cmU();
      localObject2 = new f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJZ);
      k.g(paramList, "imageView");
      localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((d)localObject1).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG));
      break;
      paramList = parame.abq(2131307405);
      k.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(8);
      break label174;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.p
 * JD-Core Version:    0.7.0.1
 */