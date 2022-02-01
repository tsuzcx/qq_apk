package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "username", "", "isSelfFlag", "", "isShowLikeCount", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZZ)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class bz
  extends ae
{
  private String TAG;
  final BaseFinderFeedLoader tFM;
  final boolean tFN;
  private final boolean tFO;
  final String username;
  
  private bz(BaseFinderFeedLoader paramBaseFinderFeedLoader, String paramString, boolean paramBoolean)
  {
    super(2131494337);
    AppMethodBeat.i(243249);
    this.tFM = paramBaseFinderFeedLoader;
    this.username = paramString;
    this.tFN = paramBoolean;
    this.tFO = false;
    this.TAG = "Finder.FinderFeedGridConvert";
    AppMethodBeat.o(243249);
  }
  
  public final void a(final RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    AppMethodBeat.i(243246);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramh.aus.setOnClickListener((View.OnClickListener)new a(this, paramh, paramRecyclerView));
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (WeImageView)paramRecyclerView.findViewById(2131297152);
    p.g(paramRecyclerView, "holder.itemView.awesomeIv");
    paramRecyclerView.setEnabled(false);
    AppMethodBeat.o(243246);
  }
  
  public final void a(h paramh, BaseFinderFeed paramBaseFinderFeed, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243247);
    p.h(paramh, "holder");
    p.h(paramBaseFinderFeed, "item");
    Object localObject2 = (cjl)j.ks((List)paramBaseFinderFeed.feedObject.getMediaList());
    paramList = (ImageView)paramh.Mn(2131300847);
    Object localObject1;
    m localm;
    if (((cjl)localObject2).mediaType == 4)
    {
      localObject1 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject2, x.vEo, null, null, 12);
      localObject2 = m.uJa;
      localObject2 = m.djY();
      p.g(paramList, "imageView");
      localm = m.uJa;
      ((d)localObject2).a(localObject1, paramList, m.a(m.a.uJb));
      if ((!this.tFO) || (paramBaseFinderFeed.feedObject.getLikeCount() <= 0)) {
        break label281;
      }
      paramList = paramh.Mn(2131302825);
      p.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(0);
      paramList = paramh.Mn(2131302826);
      p.g(paramList, "holder.getView<TextView>(R.id.item_like_count_tv)");
      ((TextView)paramList).setText((CharSequence)com.tencent.mm.plugin.finder.utils.k.gm(2, paramBaseFinderFeed.feedObject.getLikeCount()));
      label185:
      paramh = paramh.Mn(2131302524);
      p.g(paramh, "holder.getView<ImageView>(R.id.if_item_image)");
      paramh = (ImageView)paramh;
      if (!(paramBaseFinderFeed instanceof u)) {
        break label306;
      }
    }
    label281:
    label306:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      paramh.setVisibility(paramInt1);
      AppMethodBeat.o(243247);
      return;
      localObject1 = m.uJa;
      localObject1 = m.djY();
      localObject2 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject2, x.vEo, null, null, 12);
      p.g(paramList, "imageView");
      localm = m.uJa;
      ((d)localObject1).a(localObject2, paramList, m.a(m.a.uJb));
      break;
      paramList = paramh.Mn(2131302825);
      p.g(paramList, "holder.getView<View>(R.id.item_like_count_layout)");
      paramList.setVisibility(8);
      break label185;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(bz parambz, h paramh, RecyclerView paramRecyclerView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243245);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      paramView = (BaseFinderFeed)paramh.hgv();
      Object localObject2 = this.tFP;
      localObject1 = paramRecyclerView.getContext();
      p.g(localObject1, "recyclerView.context");
      Object localObject3 = this.tFP.tFM;
      if (localObject3 != null)
      {
        localObject3 = ((BaseFinderFeedLoader)localObject3).getDataListJustForAdapter();
        if (localObject3 == null) {}
      }
      for (int i = ((DataBuffer)localObject3).indexOf(paramView);; i = 0)
      {
        p.g(paramView, "item");
        localObject3 = new Intent();
        Object localObject4 = ((bz)localObject2).tFM;
        if (localObject4 != null) {
          BaseFeedLoader.saveCache$default((BaseFeedLoader)localObject4, (Intent)localObject3, i, null, 4, null);
        }
        localObject4 = ((bz)localObject2).tFM;
        if (localObject4 != null)
        {
          localObject4 = ((BaseFinderFeedLoader)localObject4).getDataListJustForAdapter();
          if (localObject4 != null)
          {
            y localy = y.vXH;
            y.a(i, (List)localObject4, ((bz)localObject2).tFM.getLastBuffer(), (Intent)localObject3);
          }
        }
        ((Intent)localObject3).putExtra("KEY_FROM_SCENE", 1);
        ((Intent)localObject3).putExtra("KEY_USERNAME", ((bz)localObject2).username);
        ((Intent)localObject3).putExtra("KEY_FINDER_SELF_FLAG", ((bz)localObject2).tFN);
        ((Intent)localObject3).putExtra("KEY_TITLE", ((Context)localObject1).getResources().getString(2131759547));
        localObject2 = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)localObject1, (Intent)localObject3, 0L, 0, false, 124);
        localObject2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.ab((Context)localObject1, (Intent)localObject3);
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.J(paramView.lT(), 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243245);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bz
 * JD-Core Version:    0.7.0.1
 */