package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.report.ag.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.action.j.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.MediaBanner.d;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isClickMusicTopic", "isClickSwitch", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "dealWithBgm", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "onMediaDoubleClick", "onViewRecycled", "plugin-finder_release"})
public class u
  extends l<com.tencent.mm.plugin.finder.model.u>
{
  private final i tAi;
  private boolean tCT;
  private boolean tCU;
  
  public u(i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165394);
    this.tAi = parami;
    AppMethodBeat.o(165394);
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(165392);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    super.a(paramRecyclerView, paramh, paramInt);
    Object localObject1 = (FinderMediaBanner)paramh.Mn(2131304549);
    ((FinderMediaBanner)localObject1).setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    ((FinderMediaBanner)localObject1).setViewPool(this.tAi.dcf());
    ((FinderMediaBanner)localObject1).setParentRecyclerView(paramRecyclerView);
    ((FinderMediaBanner)localObject1).getIndicator().setShowOnlyOneIndicator(true);
    if ((((FinderMediaBanner)localObject1).getIndicator().getView().getVisibility() == 0) && (((FinderMediaBanner)localObject1).getStyle() == MediaBanner.d.RjP)) {
      ((FinderMediaBanner)localObject1).getSpaceView().setVisibility(8);
    }
    ((FinderMediaBanner)localObject1).setPageChangeCallback((MediaBanner.c)new a(paramh));
    paramRecyclerView = (FinderImageBulletSubtitleLayout)paramh.Mn(2131302541);
    localObject1 = paramh.Mn(2131302540);
    paramRecyclerView.tOs.a(paramRecyclerView.tOr);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this, paramRecyclerView));
    if ((paramh.getContext() instanceof MMActivity))
    {
      Object localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject2 = paramh.getContext();
      if (localObject2 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(165392);
        throw paramRecyclerView;
      }
      localObject2 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject2).get(FinderReporterUIC.class)).MA(this.dLS);
      if (localObject2 != null)
      {
        ((c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new c(paramh, paramRecyclerView, (View)localObject1));
        AppMethodBeat.o(165392);
        return;
      }
    }
    AppMethodBeat.o(165392);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, View paramView)
  {
    AppMethodBeat.i(243020);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    paramh = (BaseFinderFeed)paramh.hgv();
    if (!paramh.feedObject.isPostFinish())
    {
      AppMethodBeat.o(243020);
      return;
    }
    j.a locala = j.vUw;
    if (!((Boolean)j.dBt().m(paramh.feedObject.getFeedObject()).first).booleanValue()) {
      com.tencent.mm.ui.base.u.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(2131759735), 0).show();
    }
    AppMethodBeat.o(243020);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.h paramh, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(243014);
    p.h(paramh, "holder");
    p.h(paramView, "view");
    p.h(paramFinderObject, "finderObj");
    long l = paramFinderObject.id;
    paramView = y.vXH;
    if (l != y.dCE())
    {
      AppMethodBeat.o(243014);
      return;
    }
    if (this.tCT)
    {
      this.tCT = false;
      AppMethodBeat.o(243014);
      return;
    }
    if (this.tCU)
    {
      this.tCU = false;
      AppMethodBeat.o(243014);
      return;
    }
    paramView = paramh.Mn(2131302540);
    paramFinderObject = paramh.Mn(2131302540);
    FinderImageBulletSubtitleLayout localFinderImageBulletSubtitleLayout = (FinderImageBulletSubtitleLayout)paramh.Mn(2131302541);
    Object localObject = g.af(ad.class);
    p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject).dxX())
    {
      p.g(localFinderImageBulletSubtitleLayout, "bulletSubtitleLayout");
      localFinderImageBulletSubtitleLayout.setVisibility(8);
      AppMethodBeat.o(243014);
      return;
    }
    p.g(paramView, "button");
    label217:
    label249:
    int i;
    if (paramView.getVisibility() == 0)
    {
      paramView.setVisibility(8);
      localFinderImageBulletSubtitleLayout.setBulletSubtitleAlpha(1.0F);
      paramView = ((com.tencent.mm.plugin.finder.model.u)paramh.hgv()).feedObject.getFeedObject().objectDesc;
      if (paramView == null) {
        break label410;
      }
      paramView = paramView.feedBgmInfo;
      if ((paramView != null) && (paramView.LJw != 0) && (paramView.musicInfo != null))
      {
        paramView = paramView.musicInfo;
        if (paramView == null) {
          break label415;
        }
        paramView = paramView.LJi;
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label420;
        }
        i = 1;
        label270:
        if (i == 0) {
          break label426;
        }
      }
      paramView = paramh.Mn(2131302588);
      p.g(paramView, "button");
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramView = y.vXH;
      paramh = y.X((RecyclerView.v)paramh);
      if (paramh == null) {
        break label555;
      }
      if (paramh.uPE) {
        break label449;
      }
      Log.i("Finder.FeedConvert", "[dealWithBgm] view:" + paramh.getId() + ", is no focused");
      AppMethodBeat.o(243014);
      return;
      p.g(paramFinderObject, "bulletSubtitleSwitch");
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      paramFinderObject.setSelected(((com.tencent.mm.kernel.e)localObject).azQ().getBoolean(ar.a.OmJ, true));
      paramView.setVisibility(0);
      localFinderImageBulletSubtitleLayout.setBulletSubtitleAlpha(0.3F);
      break;
      label410:
      paramView = null;
      break label217;
      label415:
      paramView = null;
      break label249;
      label420:
      i = 0;
      break label270;
      label426:
      paramView = paramh.Mn(2131302588);
      p.g(paramView, "holder.getView<View>(R.id.image_music_pause_tips)");
      paramView.setVisibility(0);
    }
    label449:
    if (!paramh.uPE)
    {
      Log.i("FinderImgFeedMusicTag", "[onViewClick] view:" + paramh.getId() + ", is no focused");
      AppMethodBeat.o(243014);
      return;
    }
    paramView = paramh.uPD;
    if (paramView != null)
    {
      if (paramView.isPlaying())
      {
        paramh.uPG = true;
        paramh.uPF = false;
        paramh.bdY();
        AppMethodBeat.o(243014);
        return;
      }
      paramh.uPG = false;
      paramh.dlf();
      AppMethodBeat.o(243014);
      return;
    }
    AppMethodBeat.o(243014);
    return;
    label555:
    AppMethodBeat.o(243014);
  }
  
  public void a(com.tencent.mm.view.recyclerview.h paramh, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243016);
    p.h(paramh, "holder");
    p.h(paramu, "item");
    super.a(paramh, (BaseFinderFeed)paramu, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramu.isPreview)
    {
      paramInt1 = com.tencent.mm.cb.a.n(paramh.getContext(), 2131100410);
      paramu = paramh.Mn(2131297134);
      p.g(paramu, "holder.getView<View>(R.id.avatar_iv)");
      paramu.setEnabled(false);
      paramu = paramh.Mn(2131305436);
      p.g(paramu, "holder.getView<View>(R.id.nickname)");
      paramu.setEnabled(false);
      a(false, paramh);
      paramu = paramh.Mn(2131306013);
      p.g(paramu, "holder.getView<TextView>(R.id.poi_name)");
      ((TextView)paramu).setEnabled(false);
      ((TextView)paramh.Mn(2131306013)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131306005)).setIconColor(paramInt1);
      ((TextView)paramh.Mn(2131300449)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131300448)).setIconColor(paramInt1);
      paramu = paramh.Mn(2131300490);
      p.g(paramu, "holder.getView<View>(R.id.fav_op_layout)");
      paramu.setEnabled(false);
      ((TextView)paramh.Mn(2131307827)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302494)).setIconColor(paramInt1);
      paramu = paramh.Mn(2131307809);
      p.g(paramu, "holder.getView<View>(R.id.share_icon_container)");
      paramu.setEnabled(false);
      ((TextView)paramh.Mn(2131300579)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302492)).setIconColor(paramInt1);
      paramu = paramh.Mn(2131297154);
      p.g(paramu, "holder.getView<View>(R.id.awesome_icon_container)");
      paramu.setEnabled(false);
      ((TextView)paramh.Mn(2131300558)).setTextColor(paramInt1);
      ((WeImageView)paramh.Mn(2131302490)).setIconColor(paramInt1);
      paramu = paramh.Mn(2131298948);
      p.g(paramu, "holder.getView<View>(R.id.comment_icon_container)");
      paramu.setEnabled(false);
      paramh = paramh.Mn(2131308992);
      p.g(paramh, "collapseTextLayout");
      paramh.setEnabled(false);
    }
    AppMethodBeat.o(243016);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(243019);
    p.h(paramh, "holder");
    super.b(paramh);
    y localy = y.vXH;
    paramh = y.X((RecyclerView.v)paramh);
    if (paramh != null)
    {
      Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + paramh.getId());
      paramh.dle();
      AppMethodBeat.o(243019);
      return;
    }
    AppMethodBeat.o(243019);
  }
  
  public final int getLayoutId()
  {
    return 2131492882;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class a
    implements MediaBanner.c
  {
    a(com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(243010);
      com.tencent.mm.plugin.finder.model.u localu = (com.tencent.mm.plugin.finder.model.u)this.qhp.hgv();
      if (paramInt < localu.feedObject.getMediaList().size())
      {
        Object localObject1 = localu.feedObject.getMediaList().get(paramInt);
        p.g(localObject1, "feed.feedObject.mediaList[position]");
        localObject1 = (cjl)localObject1;
        Object localObject2 = FinderReporterUIC.wzC;
        localObject2 = this.qhp.getContext();
        p.g(localObject2, "holder.context");
        localObject2 = FinderReporterUIC.a.fH((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new ag(FinderReporterUIC.a((FinderReporterUIC)localObject2)).doV();
          long l = localu.feedObject.getId();
          String str = localu.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localu.feedObject.getMediaList());
          p.g(localu, "feed");
          ((ag.a)localObject2).a(l, (cjl)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localu, paramBoolean2);
          AppMethodBeat.o(243010);
          return;
        }
      }
      AppMethodBeat.o(243010);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(u paramu, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243011);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      u.a(this.tCV);
      if (!paramRecyclerView.getFunctionSwitch()) {}
      for (boolean bool = true;; bool = false)
      {
        p.g(paramView, "it");
        paramView.setSelected(bool);
        paramView = g.aAh();
        p.g(paramView, "MMKernel.storage()");
        paramView.azQ().set(ar.a.OmJ, Boolean.valueOf(bool));
        paramRecyclerView.tOr.L(bool, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243011);
        return;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$3", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "resetBulletSubtitle", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    c(com.tencent.mm.view.recyclerview.h paramh, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout, View paramView) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(243012);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        FeedData localFeedData = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIF;
        if ((localFeedData != null) && (localFeedData.getMediaType() == 2))
        {
          if (this.qhp.lR() == ((com.tencent.mm.plugin.finder.event.base.h)paramb).tID)
          {
            if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)
            {
              paramRecyclerView.tOr.reset(false);
              AppMethodBeat.o(243012);
              return;
            }
            if (((((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 0) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 5) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 6)) || (!paramRecyclerView.getFunctionSwitch()) || (paramRecyclerView.tOr.tMF)) {
              break label235;
            }
            paramRecyclerView.tOs.bqe();
            paramRecyclerView.tOr.startLoop();
            paramb = this.tCX;
            p.g(paramb, "bulletSubtitleSwitch");
            if (paramb.getVisibility() == 0)
            {
              paramRecyclerView.setBulletSubtitleAlpha(0.3F);
              AppMethodBeat.o(243012);
              return;
            }
            paramRecyclerView.setBulletSubtitleAlpha(1.0F);
            AppMethodBeat.o(243012);
            return;
          }
          paramRecyclerView.tOr.reset(false);
          AppMethodBeat.o(243012);
          return;
        }
      }
      paramRecyclerView.tOr.reset(false);
      label235:
      AppMethodBeat.o(243012);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(243013);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)))
      {
        AppMethodBeat.o(243013);
        return true;
      }
      AppMethodBeat.o(243013);
      return false;
    }
    
    public final boolean cZD()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.u
 * JD-Core Version:    0.7.0.1
 */