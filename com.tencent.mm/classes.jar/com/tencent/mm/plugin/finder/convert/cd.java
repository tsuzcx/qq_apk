package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "username", "", "isSelfFlag", "", "isShowLikeCount", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZZ)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class cd
  extends ag
{
  private String TAG;
  final String username;
  final BaseFinderFeedLoader xnX;
  final boolean xnY;
  private final boolean xov;
  
  private cd(BaseFinderFeedLoader paramBaseFinderFeedLoader, String paramString, boolean paramBoolean)
  {
    super(b.g.finder_grid_feed_item_layout);
    AppMethodBeat.i(271520);
    this.xnX = paramBaseFinderFeedLoader;
    this.username = paramString;
    this.xnY = paramBoolean;
    this.xov = false;
    this.TAG = "Finder.FinderFeedGridConvert";
    AppMethodBeat.o(271520);
  }
  
  public final void a(final RecyclerView paramRecyclerView, final i parami, int paramInt)
  {
    AppMethodBeat.i(271517);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    parami.amk.setOnClickListener((View.OnClickListener)new a(this, parami, paramRecyclerView));
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(b.f.awesomeIv);
    p.j(paramRecyclerView, "holder.itemView.awesomeIv");
    paramRecyclerView.setEnabled(false);
    AppMethodBeat.o(271517);
  }
  
  public final void a(i parami, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(271518);
    p.k(parami, "holder");
    p.k(paramBaseFinderFeed, "item");
    Object localObject2 = (csg)j.lo((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)parami.RD(b.f.finder_grid_list_item_iv);
    Object localObject1;
    t localt;
    if (((csg)localObject2).mediaType == 4)
    {
      localObject1 = new r((csg)localObject2, u.Alz, null, null, 12);
      localObject2 = t.ztT;
      localObject2 = t.dJe();
      p.j(paramList, "imageView");
      localt = t.ztT;
      ((d)localObject2).a(localObject1, paramList, t.a(t.a.ztU));
      if ((!this.xov) || (paramBaseFinderFeed.feedObject.getLikeCount() <= 0)) {
        break label275;
      }
      paramList = parami.RD(b.f.item_like_count_layout);
      p.j(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(0);
      paramList = parami.RD(b.f.item_like_count_tv);
      p.j(paramList, "holder.getView<TextView>(R.id.item_like_count_tv)");
      ((TextView)paramList).setText((CharSequence)m.gY(2, paramBaseFinderFeed.feedObject.getLikeCount()));
    }
    for (;;)
    {
      parami = parami.RD(b.f.if_item_image);
      p.j(parami, "holder.getView<ImageView>(R.id.if_item_image)");
      ((ImageView)parami).setVisibility(8);
      AppMethodBeat.o(271518);
      return;
      localObject1 = t.ztT;
      localObject1 = t.dJe();
      localObject2 = new r((csg)localObject2, u.Alz, null, null, 12);
      p.j(paramList, "imageView");
      localt = t.ztT;
      ((d)localObject1).a(localObject2, paramList, t.a(t.a.ztU));
      break;
      label275:
      paramBaseFinderFeed = parami.RD(b.f.item_like_count_layout);
      p.j(paramBaseFinderFeed, "holder.getView<View>(R.id.item_like_count_layout)");
      paramBaseFinderFeed.setVisibility(8);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(cd paramcd, i parami, RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223440);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      paramView = (BaseFinderFeed)parami.ihX();
      Object localObject2 = this.xow;
      localObject1 = paramRecyclerView.getContext();
      p.j(localObject1, "recyclerView.context");
      Object localObject3 = this.xow.xnX;
      int i;
      if (localObject3 != null)
      {
        localObject3 = ((BaseFinderFeedLoader)localObject3).getDataListJustForAdapter();
        if (localObject3 != null)
        {
          i = ((DataBuffer)localObject3).indexOf(paramView);
          p.j(paramView, "item");
          localObject3 = new Intent();
          Object localObject4 = ((cd)localObject2).xnX;
          if (localObject4 != null) {
            BaseFeedLoader.saveCache$default((BaseFeedLoader)localObject4, (Intent)localObject3, i, null, 4, null);
          }
          localObject4 = ((cd)localObject2).xnX;
          if (localObject4 != null)
          {
            localObject4 = ((BaseFinderFeedLoader)localObject4).getDataListJustForAdapter();
            if (localObject4 != null)
            {
              com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
              com.tencent.mm.plugin.finder.utils.aj.a(i, (List)localObject4, ((cd)localObject2).xnX.getLastBuffer(), (Intent)localObject3);
            }
          }
          ((Intent)localObject3).putExtra("KEY_FROM_SCENE", 1);
          ((Intent)localObject3).putExtra("KEY_USERNAME", ((cd)localObject2).username);
          ((Intent)localObject3).putExtra("KEY_FINDER_SELF_FLAG", ((cd)localObject2).xnY);
          if (!((cd)localObject2).xnY) {
            break label330;
          }
          ((Intent)localObject3).putExtra("force_show_ad_tip", true);
          ((Intent)localObject3).putExtra("key_from_page", g.xKC.value);
        }
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("KEY_TITLE", ((Context)localObject1).getResources().getString(b.j.finder_be_at_timeline_title));
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)localObject1, (Intent)localObject3, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.ab((Context)localObject1, (Intent)localObject3);
        localObject1 = n.zWF;
        n.P(paramView.mf(), 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223440);
        return;
        i = 0;
        break;
        label330:
        ((Intent)localObject3).putExtra("key_from_page", g.xKu.value);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cd
 * JD-Core Version:    0.7.0.1
 */