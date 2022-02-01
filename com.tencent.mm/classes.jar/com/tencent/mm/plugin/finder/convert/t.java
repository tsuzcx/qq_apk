package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout.b;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "formatSecToMin", "", "second", "getLayoutId", "jumpToMegaVideo", "context", "Landroid/content/Context;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class t
  extends o<ad>
{
  public static final a tCP;
  private final i tAi;
  private final k tCD;
  
  static
  {
    AppMethodBeat.i(243008);
    tCP = new a((byte)0);
    AppMethodBeat.o(243008);
  }
  
  public t(k paramk, i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(243006);
    this.tCD = paramk;
    this.tAi = parami;
    AppMethodBeat.o(243006);
  }
  
  private void a(com.tencent.mm.view.recyclerview.h paramh, ad paramad, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243003);
    p.h(paramh, "holder");
    p.h(paramad, "item");
    super.a(paramh, (BaseFinderFeed)paramad, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramad.isPreview)
    {
      paramInt1 = com.tencent.mm.cb.a.n(paramh.getContext(), 2131100411);
      paramad = paramh.Mn(2131297134);
      p.g(paramad, "holder.getView<View>(R.id.avatar_iv)");
      paramad.setEnabled(false);
      paramad = paramh.Mn(2131305436);
      p.g(paramad, "holder.getView<View>(R.id.nickname)");
      paramad.setEnabled(false);
      paramad = paramh.Mn(2131301674);
      if (paramad != null)
      {
        ((TextView)paramad.findViewById(2131307800)).setTextColor(paramInt1);
        ((WeImageView)paramad.findViewById(2131302494)).setIconColor(paramInt1);
        paramList = paramad.findViewById(2131307809);
        p.g(paramList, "opLayout.findViewById<Vi….id.share_icon_container)");
        paramList.setEnabled(false);
        ((TextView)paramad.findViewById(2131303177)).setTextColor(paramInt1);
        paramList = ar.m(paramh.getContext(), 2131690243, paramInt1);
        ((ImageView)paramad.findViewById(2131302492)).setImageDrawable(paramList);
        paramList = paramad.findViewById(2131297154);
        p.g(paramList, "opLayout.findViewById<Vi…d.awesome_icon_container)");
        paramList.setEnabled(false);
        ((TextView)paramad.findViewById(2131298937)).setTextColor(paramInt1);
        ((WeImageView)paramad.findViewById(2131302490)).setIconColor(paramInt1);
        paramad = paramad.findViewById(2131298948);
        p.g(paramad, "opLayout.findViewById<Vi…d.comment_icon_container)");
        paramad.setEnabled(false);
        paramad = paramh.Mn(2131297153);
        p.g(paramad, "holder.getView<View>(R.id.awesome_ground_layout)");
        paramad.setVisibility(4);
        paramh = paramh.Mn(2131308992);
        p.g(paramh, "collapseTextLayout");
        paramh.setEnabled(false);
        AppMethodBeat.o(243003);
        return;
      }
    }
    AppMethodBeat.o(243003);
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(243001);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    paramh = (FinderMediaBanner)paramh.Mn(2131304549);
    paramh.setAdapter((RecyclerView.a)new FinderMediaBannerAdapter(this.tCD));
    paramh.setViewPool(this.tAi.dcf());
    paramh.setParentRecyclerView(paramRecyclerView);
    paramh.getIndicator().setShowOnlyOneIndicator(false);
    AppMethodBeat.o(243001);
  }
  
  public final int getLayoutId()
  {
    return 2131492881;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(t paramt, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$2"})
  static final class c
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    c(t paramt, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$3"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(t paramt, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isPause", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
  static final class e
    extends q
    implements m<Boolean, FinderVideoLayout.b, x>
  {
    e(ad paramad, com.tencent.mm.view.recyclerview.h paramh, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.t
 * JD-Core Version:    0.7.0.1
 */