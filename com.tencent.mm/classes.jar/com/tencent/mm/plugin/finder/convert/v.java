package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout;
import com.tencent.mm.plugin.finder.feed.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.l.a;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner.c;
import com.tencent.mm.view.MediaBanner.d;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isClickMusicTopic", "isClickSwitch", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "dealWithBgm", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "onMediaDoubleClick", "onViewRecycled", "plugin-finder_release"})
public class v
  extends m<u>
{
  private final com.tencent.mm.plugin.finder.feed.i xhU;
  private boolean xlp;
  private boolean xlq;
  
  public v(com.tencent.mm.plugin.finder.feed.i parami, boolean paramBoolean, int paramInt)
  {
    super(parami, paramBoolean, paramInt);
    AppMethodBeat.i(165394);
    this.xhU = parami;
    AppMethodBeat.o(165394);
  }
  
  public final void a(final RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(243241);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    super.a(paramRecyclerView, parami, paramInt);
    Object localObject1 = (FinderMediaBanner)parami.RD(b.f.media_banner);
    ((FinderMediaBanner)localObject1).setAdapter((RecyclerView.a)new FinderMediaBannerAdapter());
    ((FinderMediaBanner)localObject1).setViewPool(this.xhU.dsv());
    ((FinderMediaBanner)localObject1).setParentRecyclerView(paramRecyclerView);
    ((FinderMediaBanner)localObject1).getIndicator().setShowOnlyOneIndicator(true);
    if ((((FinderMediaBanner)localObject1).getIndicator().getView().getVisibility() == 0) && (((FinderMediaBanner)localObject1).getStyle() == MediaBanner.d.YLw)) {
      ((FinderMediaBanner)localObject1).getSpaceView().setVisibility(8);
    }
    ((FinderMediaBanner)localObject1).setPageChangeCallback((MediaBanner.c)new b(parami));
    paramRecyclerView = (FinderImageBulletSubtitleLayout)parami.RD(b.f.image_bullet_subtitle_layout);
    localObject1 = parami.RD(b.f.image_bullet_subtitle_button);
    paramRecyclerView.xyS.a(paramRecyclerView.xyR);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramRecyclerView));
    if ((parami.getContext() instanceof MMActivity))
    {
      Object localObject2 = g.Xox;
      localObject2 = parami.getContext();
      if (localObject2 == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243241);
        throw paramRecyclerView;
      }
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)localObject2).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).RU(this.fEH);
      if (localObject2 != null)
      {
        ((c)localObject2).a((com.tencent.mm.plugin.finder.event.base.d)new d(parami, paramRecyclerView, (View)localObject1));
        AppMethodBeat.o(243241);
        return;
      }
    }
    AppMethodBeat.o(243241);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView)
  {
    AppMethodBeat.i(243250);
    p.k(parami, "holder");
    p.k(paramView, "view");
    parami = (BaseFinderFeed)parami.ihX();
    if (!parami.feedObject.isPostFinish())
    {
      AppMethodBeat.o(243250);
      return;
    }
    l.a locala = com.tencent.mm.plugin.finder.upload.action.l.ACj;
    if (!((Boolean)com.tencent.mm.plugin.finder.upload.action.l.ecG().r(parami.feedObject.getFeedObject()).Mx).booleanValue()) {
      w.makeText(paramView.getContext(), (CharSequence)paramView.getContext().getString(b.j.finder_feed_liked_closed_warning), 0).show();
    }
    AppMethodBeat.o(243250);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.i parami, View paramView, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(243244);
    p.k(parami, "holder");
    p.k(paramView, "view");
    p.k(paramFinderObject, "finderObj");
    long l = paramFinderObject.id;
    paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (l != com.tencent.mm.plugin.finder.utils.aj.eeb())
    {
      AppMethodBeat.o(243244);
      return;
    }
    if (this.xlp)
    {
      this.xlp = false;
      AppMethodBeat.o(243244);
      return;
    }
    if (this.xlq)
    {
      this.xlq = false;
      AppMethodBeat.o(243244);
      return;
    }
    paramView = parami.RD(b.f.image_bullet_subtitle_button);
    paramFinderObject = parami.RD(b.f.image_bullet_subtitle_button);
    FinderImageBulletSubtitleLayout localFinderImageBulletSubtitleLayout = (FinderImageBulletSubtitleLayout)parami.RD(b.f.image_bullet_subtitle_layout);
    Object localObject = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject).dYT())
    {
      p.j(localFinderImageBulletSubtitleLayout, "bulletSubtitleLayout");
      localFinderImageBulletSubtitleLayout.setVisibility(8);
      AppMethodBeat.o(243244);
      return;
    }
    p.j(paramView, "button");
    label221:
    label253:
    int i;
    if (paramView.getVisibility() == 0)
    {
      paramView.setVisibility(8);
      localFinderImageBulletSubtitleLayout.setBulletSubtitleAlpha(1.0F);
      paramView = ((u)parami.ihX()).feedObject.getFeedObject().objectDesc;
      if (paramView == null) {
        break label414;
      }
      paramView = paramView.feedBgmInfo;
      if ((paramView != null) && (paramView.SQv != 0) && (paramView.musicInfo != null))
      {
        paramView = paramView.musicInfo;
        if (paramView == null) {
          break label419;
        }
        paramView = paramView.SPV;
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label424;
        }
        i = 1;
        label274:
        if (i == 0) {
          break label430;
        }
      }
      paramView = parami.RD(b.f.image_music_pause_tips);
      p.j(paramView, "button");
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      parami = com.tencent.mm.plugin.finder.utils.aj.Y((RecyclerView.v)parami);
      if (parami == null) {
        break label559;
      }
      if (parami.zBZ) {
        break label453;
      }
      Log.i("Finder.FeedConvert", "[dealWithBgm] view:" + parami.getId() + ", is no focused");
      AppMethodBeat.o(243244);
      return;
      p.j(paramFinderObject, "bulletSubtitleSwitch");
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      paramFinderObject.setSelected(((f)localObject).aHp().getBoolean(ar.a.VBI, true));
      paramView.setVisibility(0);
      localFinderImageBulletSubtitleLayout.setBulletSubtitleAlpha(0.3F);
      break;
      label414:
      paramView = null;
      break label221;
      label419:
      paramView = null;
      break label253;
      label424:
      i = 0;
      break label274;
      label430:
      paramView = parami.RD(b.f.image_music_pause_tips);
      p.j(paramView, "holder.getView<View>(R.id.image_music_pause_tips)");
      paramView.setVisibility(0);
    }
    label453:
    if (!parami.zBZ)
    {
      Log.i("FinderImgFeedMusicTag", "[onViewClick] view:" + parami.getId() + ", is no focused");
      AppMethodBeat.o(243244);
      return;
    }
    paramView = parami.zBY;
    if (paramView != null)
    {
      if (paramView.isPlaying())
      {
        parami.zCb = true;
        parami.zCa = false;
        parami.bnt();
        AppMethodBeat.o(243244);
        return;
      }
      parami.zCb = false;
      parami.dLf();
      AppMethodBeat.o(243244);
      return;
    }
    AppMethodBeat.o(243244);
    return;
    label559:
    AppMethodBeat.o(243244);
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(243246);
    p.k(parami, "holder");
    p.k(paramu, "item");
    super.a(parami, (BaseFinderFeed)paramu, paramInt1, paramInt2, paramBoolean, paramList);
    if (paramu.isPreview)
    {
      paramInt1 = com.tencent.mm.ci.a.w(parami.getContext(), b.c.finder_btn_disable_color);
      paramu = parami.RD(b.f.avatar_iv);
      p.j(paramu, "holder.getView<View>(R.id.avatar_iv)");
      paramu.setEnabled(false);
      paramu = parami.RD(b.f.nickname);
      p.j(paramu, "holder.getView<View>(R.id.nickname)");
      paramu.setEnabled(false);
      a(false, parami);
      paramu = parami.RD(b.f.poi_name);
      p.j(paramu, "holder.getView<TextView>(R.id.poi_name)");
      ((TextView)paramu).setEnabled(false);
      ((TextView)parami.RD(b.f.poi_name)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.poi_icon)).setIconColor(paramInt1);
      ((TextView)parami.RD(b.f.fav_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.fav_count_iv)).setIconColor(paramInt1);
      paramu = parami.RD(b.f.fav_op_layout);
      p.j(paramu, "holder.getView<View>(R.id.fav_op_layout)");
      paramu.setEnabled(false);
      ((TextView)parami.RD(b.f.share_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_share)).setIconColor(paramInt1);
      paramu = parami.RD(b.f.share_icon_container);
      p.j(paramu, "holder.getView<View>(R.id.share_icon_container)");
      paramu.setEnabled(false);
      ((TextView)parami.RD(b.f.feed_like_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_like)).setIconColor(paramInt1);
      paramu = parami.RD(b.f.awesome_icon_container);
      p.j(paramu, "holder.getView<View>(R.id.awesome_icon_container)");
      paramu.setEnabled(false);
      ((TextView)parami.RD(b.f.feed_comment_count_tv)).setTextColor(paramInt1);
      ((WeImageView)parami.RD(b.f.icon_feed_comment)).setIconColor(paramInt1);
      paramu = parami.RD(b.f.comment_icon_container);
      p.j(paramu, "holder.getView<View>(R.id.comment_icon_container)");
      paramu.setEnabled(false);
      parami = parami.RD(b.f.text_content);
      p.j(parami, "collapseTextLayout");
      parami.setEnabled(false);
    }
    AppMethodBeat.o(243246);
  }
  
  public final void b(com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(243249);
    p.k(parami, "holder");
    super.b(parami);
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    parami = com.tencent.mm.plugin.finder.utils.aj.Y((RecyclerView.v)parami);
    if (parami != null)
    {
      Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + parami.getId());
      parami.dLe();
      AppMethodBeat.o(243249);
      return;
    }
    AppMethodBeat.o(243249);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_image_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$convertMedia$4$1"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(v paramv, com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
  public static final class b
    implements MediaBanner.c
  {
    b(com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(274477);
      u localu = (u)this.tDl.ihX();
      if (paramInt < localu.feedObject.getMediaList().size())
      {
        Object localObject1 = localu.feedObject.getMediaList().get(paramInt);
        p.j(localObject1, "feed.feedObject.mediaList[position]");
        localObject1 = (csg)localObject1;
        Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject2 = this.tDl.getContext();
        p.j(localObject2, "holder.context");
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)localObject2);
        if (localObject2 != null)
        {
          localObject2 = new com.tencent.mm.plugin.finder.report.aj(com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject2)).dQy();
          long l = localu.feedObject.getId();
          String str = localu.feedObject.getObjectNonceId();
          LinkedList localLinkedList = new LinkedList((Collection)localu.feedObject.getMediaList());
          p.j(localu, "feed");
          ((com.tencent.mm.plugin.finder.report.aj.a)localObject2).a(l, (csg)localObject1, str, paramInt, localLinkedList, (BaseFinderFeed)localu, paramBoolean2);
          AppMethodBeat.o(274477);
          return;
        }
      }
      AppMethodBeat.o(274477);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(v paramv, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274313);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      v.a(this.xlr);
      if (!paramRecyclerView.getFunctionSwitch()) {}
      for (boolean bool = true;; bool = false)
      {
        p.j(paramView, "it");
        paramView.setSelected(bool);
        paramView = com.tencent.mm.kernel.h.aHG();
        p.j(paramView, "MMKernel.storage()");
        paramView.aHp().set(ar.a.VBI, Boolean.valueOf(bool));
        paramRecyclerView.xyR.Q(bool, true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274313);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$3", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "resetBulletSubtitle", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    d(com.tencent.mm.view.recyclerview.i parami, FinderImageBulletSubtitleLayout paramFinderImageBulletSubtitleLayout, View paramView) {}
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(288850);
      p.k(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        FeedData localFeedData = ((com.tencent.mm.plugin.finder.event.base.h)paramb).xro;
        if ((localFeedData != null) && (localFeedData.getMediaType() == 2))
        {
          if (this.tDl.md() == ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrm)
          {
            if (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)
            {
              paramRecyclerView.xyR.reset(false);
              AppMethodBeat.o(288850);
              return;
            }
            if (((((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 0) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 5) && (((com.tencent.mm.plugin.finder.event.base.h)paramb).type != 6)) || (!paramRecyclerView.getFunctionSwitch()) || (paramRecyclerView.xyR.xww)) {
              break label235;
            }
            paramRecyclerView.xyS.dlN();
            paramRecyclerView.xyR.startLoop();
            paramb = this.xlt;
            p.j(paramb, "bulletSubtitleSwitch");
            if (paramb.getVisibility() == 0)
            {
              paramRecyclerView.setBulletSubtitleAlpha(0.3F);
              AppMethodBeat.o(288850);
              return;
            }
            paramRecyclerView.setBulletSubtitleAlpha(1.0F);
            AppMethodBeat.o(288850);
            return;
          }
          paramRecyclerView.xyR.reset(false);
          AppMethodBeat.o(288850);
          return;
        }
      }
      paramRecyclerView.xyR.reset(false);
      label235:
      AppMethodBeat.o(288850);
    }
    
    public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(288851);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 3) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 6) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 7)))
      {
        AppMethodBeat.o(288851);
        return true;
      }
      AppMethodBeat.o(288851);
      return false;
    }
    
    public final boolean dpw()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.v
 * JD-Core Version:    0.7.0.1
 */