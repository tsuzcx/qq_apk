package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "username", "", "isSelfFlag", "", "isShowLikeCount", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZZ)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cb
  extends ac
{
  private final BaseFinderFeedLoader ALH;
  private final boolean ALI;
  private final boolean AMc;
  private String TAG;
  private final String username;
  
  private cb(BaseFinderFeedLoader paramBaseFinderFeedLoader, String paramString, boolean paramBoolean)
  {
    super(e.f.finder_grid_feed_item_layout);
    AppMethodBeat.i(349753);
    this.ALH = paramBaseFinderFeedLoader;
    this.username = paramString;
    this.ALI = paramBoolean;
    this.AMc = false;
    this.TAG = "Finder.FinderFeedGridConvert";
    AppMethodBeat.o(349753);
  }
  
  private static final void a(j paramj, cb paramcb, RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(349804);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramj);
    ((b)localObject2).cH(paramcb);
    ((b)localObject2).cH(paramRecyclerView);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramj, "$holder");
    s.u(paramcb, "this$0");
    s.u(paramRecyclerView, "$recyclerView");
    paramj = (BaseFinderFeed)paramj.CSA;
    paramRecyclerView = paramRecyclerView.getContext();
    s.s(paramRecyclerView, "recyclerView.context");
    paramView = paramcb.ALH;
    int i;
    if (paramView == null)
    {
      i = 0;
      s.s(paramj, "item");
      paramView = new Intent();
      localObject1 = paramcb.ALH;
      if (localObject1 != null) {
        BaseFeedLoader.saveCache$default((BaseFeedLoader)localObject1, paramView, i, null, 4, null);
      }
      localObject1 = paramcb.ALH;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeedLoader)localObject1).getDataListJustForAdapter();
        if (localObject1 != null)
        {
          localObject2 = av.GiL;
          av.a(i, (List)localObject1, paramcb.ALH.getLastBuffer(), paramView);
        }
      }
      paramView.putExtra("KEY_FROM_SCENE", 1);
      paramView.putExtra("KEY_USERNAME", paramcb.username);
      paramView.putExtra("KEY_FINDER_SELF_FLAG", paramcb.ALI);
      if (!paramcb.ALI) {
        break label358;
      }
      paramView.putExtra("force_show_ad_tip", true);
      paramView.putExtra("key_from_page", g.Bkr.value);
    }
    for (;;)
    {
      paramView.putExtra("KEY_TITLE", paramRecyclerView.getResources().getString(e.h.finder_be_at_timeline_title));
      paramcb = as.GSQ;
      as.a.a(paramRecyclerView, paramView, 0L, 0, false, 124);
      paramcb = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.ar(paramRecyclerView, paramView);
      paramcb = z.FrZ;
      z.ab(paramj.bZA(), 1);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349804);
      return;
      paramView = paramView.getDataListJustForAdapter();
      if (paramView == null)
      {
        i = 0;
        break;
      }
      i = paramView.indexOf(paramj);
      break;
      label358:
      paramView.putExtra("key_from_page", g.Bkj.value);
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349836);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramj.caK.setOnClickListener(new cb..ExternalSyntheticLambda0(paramj, this, paramRecyclerView));
    ((WeImageView)paramj.caK.findViewById(e.e.awesomeIv)).setEnabled(false);
    AppMethodBeat.o(349836);
  }
  
  public final void a(j paramj, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(349861);
    s.u(paramj, "holder");
    s.u(paramBaseFinderFeed, "item");
    Object localObject2 = (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)paramj.UH(e.e.finder_grid_list_item_iv);
    Object localObject1;
    com.tencent.mm.plugin.finder.loader.p localp;
    if (((dji)localObject2).mediaType == 4)
    {
      localObject1 = new n((dji)localObject2, v.FKZ, null, null, 12);
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
      s.s(paramList, "imageView");
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject2).a(localObject1, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      if ((!this.AMc) || (paramBaseFinderFeed.feedObject.getLikeCount() <= 0)) {
        break label312;
      }
      paramj.UH(e.e.item_like_count_layout).setVisibility(0);
      ((TextView)paramj.UH(e.e.item_like_count_tv)).setText((CharSequence)r.ip(2, paramBaseFinderFeed.feedObject.getLikeCount()));
      label169:
      ((ImageView)paramj.UH(e.e.if_item_image)).setVisibility(8);
      localObject1 = paramj.UH(e.e.finder_grid_feed_item_layout_container);
      if (localObject1 != null)
      {
        paramInt1 = e.e.finder_accessibility_nickname_tag;
        paramj = paramBaseFinderFeed.feedObject;
        if (paramj != null) {
          break label327;
        }
        paramj = "";
        label215:
        ((View)localObject1).setTag(paramInt1, paramj);
        paramInt1 = e.e.finder_accessibility_content_desc_tag;
        paramj = paramBaseFinderFeed.feedObject;
        if (paramj != null) {
          break label348;
        }
        paramj = "";
      }
    }
    for (;;)
    {
      ((View)localObject1).setTag(paramInt1, paramj);
      AppMethodBeat.o(349861);
      return;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject2 = new n((dji)localObject2, v.FKZ, null, null, 12);
      s.s(paramList, "imageView");
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject1).a(localObject2, paramList, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
      break;
      label312:
      paramj.UH(e.e.item_like_count_layout).setVisibility(8);
      break label169;
      label327:
      paramList = paramj.getNickName();
      paramj = paramList;
      if (paramList != null) {
        break label215;
      }
      paramj = "";
      break label215;
      label348:
      paramBaseFinderFeed = paramj.getDescription();
      paramj = paramBaseFinderFeed;
      if (paramBaseFinderFeed == null) {
        paramj = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cb
 * JD-Core Version:    0.7.0.1
 */