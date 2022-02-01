package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.h;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "finalize", "getLayoutId", "jumpToFullVideo", "context", "Landroid/content/Context;", "jumpToMegaVideo", "makeTimeString", "", "d", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onViewRecycled", "plugin-finder_release"})
public class am
  extends m<af>
{
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  
  public am(com.tencent.mm.plugin.finder.video.l paraml, com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165434);
    this.xkW = paraml;
    this.xhU = parami;
    AppMethodBeat.o(165434);
  }
  
  private static String AQ(int paramInt)
  {
    AppMethodBeat.i(286202);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(286202);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(286202);
    return str;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(286194);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    Log.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
    AppMethodBeat.o(286194);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(286193);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    parami = (FinderMediaBanner)parami.RD(b.f.media_banner);
    parami.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.xkW));
    parami.setViewPool(this.xhU.dsv());
    parami.setParentRecyclerView(paramRecyclerView);
    parami.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(286193);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165433);
    p.k(parami, "holder");
    p.k(paramView, "view");
    p.k(paramFinderObject, "finderObject");
    super.a(parami, paramView, paramFinderObject);
    paramView = paramView.findViewById(b.f.retry_btn);
    p.j(paramView, "view.findViewById<View>(R.id.retry_btn)");
    if (paramView.getVisibility() == 0)
    {
      AppMethodBeat.o(165433);
      return;
    }
    if (this.xkW.ANE != paramFinderObject.id)
    {
      AppMethodBeat.o(165433);
      return;
    }
    paramView = aj.AGc;
    paramView = aj.Y((RecyclerView.v)parami);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      parami = parami.amk;
      if (parami != null) {
        parami.findViewById(b.f.finder_banner_video_layout);
      }
    }
    parami = n.zWF;
    n.m(paramFinderObject);
    AppMethodBeat.o(165433);
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, af paramaf, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(286198);
    p.k(parami, "holder");
    p.k(paramaf, "item");
    super.a(parami, (BaseFinderFeed)paramaf, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramaf.isPreview)
    {
      paramInt1 = com.tencent.mm.ci.a.w(parami.getContext(), b.c.finder_btn_disable_color);
      paramaf = parami.RD(b.f.avatar_iv);
      p.j(paramaf, "holder.getView<View>(R.id.avatar_iv)");
      paramaf.setEnabled(false);
      paramaf = parami.RD(b.f.nickname);
      p.j(paramaf, "holder.getView<View>(R.id.nickname)");
      paramaf.setEnabled(false);
      a(false, parami);
      paramaf = parami.RD(b.f.poi_name);
      p.j(paramaf, "holder.getView<TextView>(R.id.poi_name)");
      ((TextView)paramaf).setEnabled(false);
      ((TextView)parami.RD(b.f.poi_name)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.poi_icon)).setIconColor(paramInt1);
      ((TextView)parami.RD(b.f.fav_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.fav_count_iv)).setIconColor(paramInt1);
      paramaf = parami.RD(b.f.fav_op_layout);
      p.j(paramaf, "holder.getView<View>(R.id.fav_op_layout)");
      paramaf.setEnabled(false);
      ((TextView)parami.RD(b.f.share_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_share)).setIconColor(paramInt1);
      paramaf = parami.RD(b.f.share_icon_container);
      p.j(paramaf, "holder.getView<View>(R.id.share_icon_container)");
      paramaf.setEnabled(false);
      ((TextView)parami.RD(b.f.feed_like_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_like)).setIconColor(paramInt1);
      paramaf = parami.RD(b.f.awesome_icon_container);
      p.j(paramaf, "holder.getView<View>(R.id.awesome_icon_container)");
      paramaf.setEnabled(false);
      ((TextView)parami.RD(b.f.feed_comment_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_comment)).setIconColor(paramInt1);
      paramaf = parami.RD(b.f.comment_icon_container);
      p.j(paramaf, "holder.getView<View>(R.id.comment_icon_container)");
      paramaf.setEnabled(false);
      parami = parami.RD(b.f.text_content);
      p.j(parami, "collapseTextLayout");
      parami.setEnabled(false);
    }
    AppMethodBeat.o(286198);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(286201);
    p.k(parami, "holder");
    super.b(parami);
    aj localaj = aj.AGc;
    parami = aj.Y((RecyclerView.v)parami);
    if (parami != null)
    {
      Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + parami.getId());
      parami.dLe();
      AppMethodBeat.o(286201);
      return;
    }
    AppMethodBeat.o(286201);
  }
  
  public final void e(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(286195);
    p.k(paramRecyclerView, "recyclerView");
    super.e(paramRecyclerView);
    Log.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
    AppMethodBeat.o(286195);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(286196);
    Log.d("Finder.FeedConvert", "finalize");
    AppMethodBeat.o(286196);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_video_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$1$3"})
  static final class a
    implements View.OnClickListener
  {
    a(am paramam, af paramaf, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253420);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.xmI;
      localObject = this.xhb.getContext();
      p.j(localObject, "holder.context");
      am.a(paramView, (Context)localObject, this.xhb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(253420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am
 * JD-Core Version:    0.7.0.1
 */