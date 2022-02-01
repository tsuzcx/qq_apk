package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "finalize", "getLayoutId", "jumpToFullVideo", "context", "Landroid/content/Context;", "jumpToMegaVideo", "makeTimeString", "", "d", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onViewRecycled", "plugin-finder_release"})
public class ak
  extends l<ad>
{
  private final i tAi;
  private final com.tencent.mm.plugin.finder.video.k tCD;
  
  public ak(com.tencent.mm.plugin.finder.video.k paramk, i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165434);
    this.tCD = paramk;
    this.tAi = parami;
    AppMethodBeat.o(165434);
  }
  
  private static String xt(int paramInt)
  {
    AppMethodBeat.i(243119);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(243119);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(243119);
    return str;
  }
  
  public final void a(RecyclerView paramRecyclerView, WxRecyclerAdapter<?> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(243111);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramWxRecyclerAdapter, "adapter");
    super.a(paramRecyclerView, paramWxRecyclerAdapter);
    Log.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
    AppMethodBeat.o(243111);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(165431);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    paramh = (FinderMediaBanner)paramh.Mn(2131304549);
    paramh.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.tCD));
    paramh.setViewPool(this.tAi.dcf());
    paramh.setParentRecyclerView(paramRecyclerView);
    paramh.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(165431);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165433);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObject");
    super.a(paramh, paramView, paramFinderObject);
    paramView = paramView.findViewById(2131307042);
    p.g(paramView, "view.findViewById<View>(R.id.retry_btn)");
    if (paramView.getVisibility() == 0)
    {
      AppMethodBeat.o(165433);
      return;
    }
    if (this.tCD.weV != paramFinderObject.id)
    {
      AppMethodBeat.o(165433);
      return;
    }
    paramView = y.vXH;
    paramView = y.X((RecyclerView.v)paramh);
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      paramh = paramh.aus;
      if (paramh != null) {
        paramh.findViewById(2131300776);
      }
    }
    paramh = com.tencent.mm.plugin.finder.report.k.vfA;
    com.tencent.mm.plugin.finder.report.k.h(paramFinderObject);
    AppMethodBeat.o(165433);
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, ad paramad, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243115);
    p.h(paramh, "holder");
    p.h(paramad, "item");
    super.a(paramh, (BaseFinderFeed)paramad, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramad.isPreview)
    {
      paramInt1 = com.tencent.mm.cb.a.n(paramh.getContext(), 2131100410);
      paramad = paramh.Mn(2131297134);
      p.g(paramad, "holder.getView<View>(R.id.avatar_iv)");
      paramad.setEnabled(false);
      paramad = paramh.Mn(2131305436);
      p.g(paramad, "holder.getView<View>(R.id.nickname)");
      paramad.setEnabled(false);
      a(false, paramh);
      paramad = paramh.Mn(2131306013);
      p.g(paramad, "holder.getView<TextView>(R.id.poi_name)");
      ((TextView)paramad).setEnabled(false);
      ((TextView)paramh.Mn(2131306013)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131306005)).setIconColor(paramInt1);
      ((TextView)paramh.Mn(2131300449)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131300448)).setIconColor(paramInt1);
      paramad = paramh.Mn(2131300490);
      p.g(paramad, "holder.getView<View>(R.id.fav_op_layout)");
      paramad.setEnabled(false);
      ((TextView)paramh.Mn(2131307827)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302494)).setIconColor(paramInt1);
      paramad = paramh.Mn(2131307809);
      p.g(paramad, "holder.getView<View>(R.id.share_icon_container)");
      paramad.setEnabled(false);
      ((TextView)paramh.Mn(2131300579)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302492)).setIconColor(paramInt1);
      paramad = paramh.Mn(2131297154);
      p.g(paramad, "holder.getView<View>(R.id.awesome_icon_container)");
      paramad.setEnabled(false);
      ((TextView)paramh.Mn(2131300558)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302490)).setIconColor(paramInt1);
      paramad = paramh.Mn(2131298948);
      p.g(paramad, "holder.getView<View>(R.id.comment_icon_container)");
      paramad.setEnabled(false);
      paramh = paramh.Mn(2131308992);
      p.g(paramh, "collapseTextLayout");
      paramh.setEnabled(false);
    }
    AppMethodBeat.o(243115);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(243118);
    p.h(paramh, "holder");
    super.b(paramh);
    y localy = y.vXH;
    paramh = y.X((RecyclerView.v)paramh);
    if (paramh != null)
    {
      Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + paramh.getId());
      paramh.dle();
      AppMethodBeat.o(243118);
      return;
    }
    AppMethodBeat.o(243118);
  }
  
  public final void c(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(243112);
    p.h(paramRecyclerView, "recyclerView");
    super.c(paramRecyclerView);
    Log.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
    AppMethodBeat.o(243112);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(243113);
    Log.d("Finder.FeedConvert", "finalize");
    AppMethodBeat.o(243113);
  }
  
  public final int getLayoutId()
  {
    return 2131492889;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$1$3"})
  static final class a
    implements View.OnClickListener
  {
    a(ak paramak, ad paramad, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243110);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.tEg;
      localObject = this.tzq.getContext();
      p.g(localObject, "holder.context");
      ak.a(paramView, (Context)localObject, this.tzq);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ak
 * JD-Core Version:    0.7.0.1
 */