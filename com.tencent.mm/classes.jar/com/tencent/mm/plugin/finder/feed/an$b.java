package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ab;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.ContactUninterestEventListener;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.x;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "selfFlag", "", "topicId", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;ZJ)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_CREATION_BY_SAME_TEMPLATE", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "MENU_ID_SET_CANCEL_STICKY", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SET_STICKY", "MENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SPEED_CTRL", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "quickMenuHelper", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "scene", "getSelfFlag", "()Z", "stickyComponent", "Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getTopicId", "()J", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "getCreateQuickMoreMenuListener", "getCreateSecondMoreMenuListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemLongSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "bottomSheet", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/app/Activity;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "source", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLikeLocalFeed", "isPrivate", "onUIPause", "onUIResume", "removeDataAt", "index", "reportDelete", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "isClick", "requestRefresh", "shareFeed", "shareFeedToSns", "updateBottomSheet", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an$b
  implements an.a, i, com.tencent.mm.plugin.finder.presenter.base.a<an.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final long ADo;
  private final l AJn;
  private final int AST;
  private final int ASU;
  private final int ASV;
  private final int ASW;
  private final int ASX;
  private final int ASY;
  private final int ASZ;
  private final int ATb;
  private final int ATc;
  private final int ATd;
  private final int ATe;
  private final int ATf;
  private final int ATi;
  private final int ATj;
  private final int ATk;
  private final int ATm;
  private final int ATn;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  private final com.tencent.mm.pluginsdk.q ATr;
  private final com.tencent.mm.plugin.finder.view.f ATy;
  private com.tencent.mm.plugin.finder.event.base.d AUT;
  private final boolean AXX;
  private final kotlin.j AXY;
  private an.c AXZ;
  private final kotlin.j AYa;
  private final com.tencent.mm.plugin.finder.feed.component.j AYb;
  private final int AYc;
  private final int AYd;
  private final int AYe;
  private final int AYf;
  private ContactUninterestEventListener AYg;
  private final FinderProfileTimelineContract.ProfileTimelinePresenter.feedExposeInfoChangeListener.1 AYh;
  private final FinderProfileTimelineContract.ProfileTimelinePresenter.feedProgressListener.1 AYi;
  private final int Auf;
  private final int Aug;
  private final com.tencent.mm.plugin.finder.feed.model.i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  private final String TAG;
  private boolean hHq;
  final MMActivity lzt;
  private final int pIs;
  private int scene;
  Dialog tipDialog;
  final String username;
  
  public an$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.f paramf, String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(363087);
    this.lzt = paramMMActivity;
    this.ATy = paramf;
    this.username = paramString;
    this.AXX = paramBoolean;
    this.ADo = paramLong;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.AXY = kotlin.k.cm((kotlin.g.a.a)r.AYn);
    this.ATq = new CopyOnWriteArraySet();
    this.AYa = kotlin.k.cm((kotlin.g.a.a)new b(this));
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    this.Ayf = ((ar)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).cq(ar.class)).eiJ();
    if ((this.username.equals(com.tencent.mm.model.z.bAW())) && (this.AXX))
    {
      paramBoolean = true;
      this.hHq = paramBoolean;
      if (!this.hHq) {
        break label439;
      }
    }
    for (;;)
    {
      this.scene = i;
      this.ATr = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
      this.AYb = new com.tencent.mm.plugin.finder.feed.component.j();
      this.AST = 99;
      this.ASU = 100;
      this.ASV = 101;
      this.Auf = 102;
      this.Aug = 103;
      this.ASW = 104;
      this.ASX = 105;
      this.ASY = 106;
      this.ASZ = 107;
      this.pIs = 108;
      this.AYc = 109;
      this.AYd = 110;
      this.AYe = 111;
      this.AYf = 112;
      this.ATb = 113;
      this.ATe = 114;
      this.ATc = 115;
      this.ATd = 116;
      this.ATf = 117;
      this.ATi = 118;
      this.ATj = 119;
      this.ATk = 120;
      this.ATm = 121;
      this.ATn = 200;
      this.AJn = new l();
      this.AYh = new FinderProfileTimelineContract.ProfileTimelinePresenter.feedExposeInfoChangeListener.1(this);
      this.AYi = new FinderProfileTimelineContract.ProfileTimelinePresenter.feedProgressListener.1(this, com.tencent.mm.app.f.hfK);
      AppMethodBeat.o(363087);
      return;
      paramBoolean = false;
      break;
      label439:
      i = 2;
    }
  }
  
  private static final void a(Activity paramActivity, BaseFinderFeed paramBaseFinderFeed, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(363298);
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    paramDialogInterface = ag.Ghl;
    ag.a((Context)paramActivity, paramBaseFinderFeed.feedObject, true);
    AppMethodBeat.o(363298);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(363131);
    kotlin.g.b.s.u(paramb, "this$0");
    AppMethodBeat.o(363131);
  }
  
  private static final void a(final b paramb, final BaseFinderFeed paramBaseFinderFeed, int paramInt, final com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(363160);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramf, "$sheet");
    Object localObject1;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    label199:
    label237:
    int i;
    label257:
    int j;
    label277:
    label308:
    label344:
    label360:
    Object localObject3;
    label459:
    label506:
    long l;
    if (!paramb.hHq)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject2 = com.tencent.mm.plugin.finder.utils.av.a((Context)paramb.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new c(params, paramBaseFinderFeed, paramb, paramf), 4);
      bool1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiW;
      bool2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiX;
      boolean bool3 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiY;
      paramf = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiZ;
      localObject1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).Gja;
      localObject2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).Gjb;
      params.a(paramb.Auf, (CharSequence)paramf, e.g.finder_icons_filled_share, paramb.lzt.getResources().getColor(e.b.Brand), bool1);
      params.a(paramb.Aug, (CharSequence)localObject1, e.g.bottomsheet_icon_moment, 0, bool2);
      paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (paramf == null)
      {
        paramf = null;
        paramf = (CharSequence)paramf;
        if ((paramf != null) && (paramf.length() != 0)) {
          break label906;
        }
        paramInt = 1;
        if (paramInt == 0)
        {
          paramf = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig();
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label911;
          }
          paramInt = 0;
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label954;
          }
          i = 0;
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label1000;
          }
          j = -1;
          if (paramf.ag(paramInt, i, j))
          {
            paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramf != null) {
              break label1028;
            }
            paramInt = 0;
            if (paramInt <= 0) {
              break label1073;
            }
            localObject1 = paramb.lzt;
            i = e.h.finder_share_use_same_template_with_count;
            if (paramInt <= 99999) {
              break label1050;
            }
            paramf = String.valueOf(paramb.lzt.getString(e.h.finder_hundred_thousand_ringtone));
            paramf = ((MMActivity)localObject1).getString(i, new Object[] { paramf });
            kotlin.g.b.s.s(paramf, "if (count > 0) context.g…_share_use_same_template)");
            params.a(paramb.ATm, (CharSequence)paramf, e.d.icons_filled_saneeffects, paramb.lzt.getResources().getColor(e.b.Brand), false);
            paramf = com.tencent.mm.ui.component.k.aeZF;
            localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
            paramf = bb.FuK;
            JSONObject localJSONObject = new JSONObject();
            paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramf != null) {
              break label1087;
            }
            paramf = Integer.valueOf(0);
            localJSONObject.put("templateId", paramf);
            paramf = ah.aiuX;
            bb.a((bui)localObject3, "shoot_same_video", false, localJSONObject);
          }
        }
        paramf = com.tencent.mm.plugin.finder.upload.action.c.GcH;
        if (com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {
          break label1126;
        }
        paramInt = 1;
        paramf = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
        {
          if (!bool3) {
            break label1131;
          }
          params.a(paramb.ATc, (CharSequence)localObject2, e.g.finder_icons_filled_star2, paramb.lzt.getResources().getColor(e.b.orange_100), true);
        }
        label562:
        paramf = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eWt().bmg()).intValue() == 1)
        {
          paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
          if (com.tencent.mm.plugin.finder.utils.av.F(paramBaseFinderFeed.feedObject.getFeedObject()))
          {
            paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.j((Context)paramb.lzt, paramBaseFinderFeed.bZA());
            params.a(paramb.ATf, (CharSequence)paramb.lzt.getString(e.h.finder_share_text_stauts_title), e.g.state_icon_main, paramb.lzt.getResources().getColor(e.b.Blue));
          }
        }
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.p(paramBaseFinderFeed))
        {
          i = 0;
          paramInt = i;
          if (paramBaseFinderFeed.feedObject != null)
          {
            paramInt = i;
            if (paramBaseFinderFeed.feedObject.field_finderObject != null) {
              paramInt = paramBaseFinderFeed.feedObject.field_finderObject.ringtone_count;
            }
          }
          if (paramInt == 0) {
            break label1242;
          }
          paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
          if (paramInt < com.tencent.mm.plugin.finder.utils.av.fgc()) {
            break label1242;
          }
          if (paramInt <= 99999) {
            break label1219;
          }
          paramf = String.valueOf(paramb.lzt.getString(e.h.finder_hundred_thousand_ringtone));
          label740:
          paramf = paramb.lzt.getString(e.h.finder_feed_has_been_set_ringtone, new Object[] { paramf });
          label759:
          kotlin.g.b.s.s(paramf, "if(count != 0 && count >…le)\n                    }");
          params.a(paramb.ATi, (CharSequence)paramf, e.g.icons_filled_ringtone, 0);
        }
        label784:
        paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
        l = paramBaseFinderFeed.bZA();
        paramf = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramf = as.a.hu((Context)paramb.lzt);
        if (paramf != null) {
          break label2303;
        }
      }
    }
    label906:
    label911:
    label954:
    label1000:
    label1131:
    label1394:
    label1528:
    label2303:
    for (paramInt = 0;; paramInt = paramf.AJo)
    {
      com.tencent.mm.plugin.finder.report.z.aa(l, paramInt);
      paramf = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramb = as.a.hu((Context)paramb.lzt);
      if (paramb != null)
      {
        paramb = ((bn)paramb).foy();
        if (paramb != null)
        {
          paramb = paramb.dYj();
          if (paramb != null)
          {
            paramb.nj(paramBaseFinderFeed.bZA());
            paramb = ah.aiuX;
          }
        }
      }
      AppMethodBeat.o(363160);
      return;
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        paramf = null;
        break;
      }
      paramf = paramf.id;
      break;
      paramInt = 0;
      break label199;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        paramInt = 0;
        break label237;
      }
      localObject1 = ((byy)localObject1).aahY;
      if (localObject1 == null)
      {
        paramInt = 0;
        break label237;
      }
      paramInt = ((fxe)localObject1).abME;
      break label237;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        i = 0;
        break label257;
      }
      localObject1 = ((byy)localObject1).aahY;
      if (localObject1 == null)
      {
        i = 0;
        break label257;
      }
      i = ((fxe)localObject1).abMF;
      break label257;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        j = -1;
        break label277;
      }
      j = ((byy)localObject1).type;
      break label277;
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        paramInt = 0;
        break label308;
      }
      paramInt = paramf.ZmT;
      break label308;
      if (paramInt > 9999)
      {
        paramf = com.tencent.mm.plugin.finder.utils.av.Ul(paramInt);
        break label344;
      }
      paramf = String.valueOf(paramInt);
      break label344;
      paramf = paramb.lzt.getString(e.h.finder_share_use_same_template);
      break label360;
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        paramf = Integer.valueOf(0);
        break label459;
      }
      localObject1 = paramf.id;
      paramf = (com.tencent.mm.ui.widget.a.f)localObject1;
      if (localObject1 != null) {
        break label459;
      }
      paramf = Integer.valueOf(0);
      break label459;
      paramInt = 0;
      break label506;
      if (paramInt != 0)
      {
        params.a(paramb.ATc, (CharSequence)paramb.lzt.getString(e.h.favorite), e.g.finder_icons_filled_star2, paramb.lzt.getResources().getColor(e.b.orange_100));
        break label562;
      }
      params.a(paramb.ATd, (CharSequence)paramb.lzt.getString(e.h.finder_cancel_fav_title), e.g.finder_icons_filled_unstar2, paramb.lzt.getResources().getColor(e.b.orange_100));
      break label562;
      if (paramInt > 9999)
      {
        paramf = com.tencent.mm.plugin.finder.utils.av.Ul(paramInt);
        break label740;
      }
      paramf = String.valueOf(paramInt);
      break label740;
      paramf = paramb.lzt.getString(e.h.finder_share_ringtone_title);
      break label759;
      if (!params.jmw()) {
        break label784;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject1 = com.tencent.mm.plugin.finder.utils.av.a((Context)paramb.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new d(params, paramBaseFinderFeed, paramb, paramf), 4);
      bool1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiW;
      bool2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiX;
      paramf = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiZ;
      localObject1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).Gja;
      params.a(paramb.Auf, (CharSequence)paramf, e.g.finder_icons_filled_share, MMApplicationContext.getContext().getResources().getColor(e.b.Brand), bool1);
      params.a(paramb.Aug, (CharSequence)localObject1, e.g.bottomsheet_icon_moment, 0, bool2);
      paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      int k;
      if (paramf == null)
      {
        paramf = null;
        paramf = (CharSequence)paramf;
        if ((paramf != null) && (paramf.length() != 0)) {
          break label2027;
        }
        i = 1;
        if (i == 0)
        {
          paramf = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig();
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label2033;
          }
          i = 0;
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label2079;
          }
          j = 0;
          localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (localObject1 != null) {
            break label2125;
          }
          k = -1;
          if (paramf.ag(i, j, k))
          {
            paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramf != null) {
              break label2153;
            }
            i = 0;
            if (i <= 0) {
              break label2203;
            }
            localObject1 = paramb.lzt;
            j = e.h.finder_share_use_same_template_with_count;
            if (i <= 99999) {
              break label2177;
            }
            paramf = String.valueOf(paramb.lzt.getString(e.h.finder_hundred_thousand_ringtone));
            paramf = ((MMActivity)localObject1).getString(j, new Object[] { paramf });
            kotlin.g.b.s.s(paramf, "if (count > 0) context.g…_share_use_same_template)");
            params.a(paramb.ATm, (CharSequence)paramf, e.d.icons_filled_saneeffects, paramb.lzt.getResources().getColor(e.b.Brand), false);
            paramf = com.tencent.mm.ui.component.k.aeZF;
            localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
            paramf = bb.FuK;
            localObject3 = new JSONObject();
            paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramf != null) {
              break label2217;
            }
            paramf = Integer.valueOf(0);
            ((JSONObject)localObject3).put("templateId", paramf);
            paramf = ah.aiuX;
            bb.a((bui)localObject2, "shoot_same_video", false, (JSONObject)localObject3);
          }
        }
        paramf = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eWt().bmg()).intValue() == 1)
        {
          paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
          if (com.tencent.mm.plugin.finder.utils.av.F(paramBaseFinderFeed.feedObject.getFeedObject()))
          {
            paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.j((Context)paramb.lzt, paramBaseFinderFeed.bZA());
            params.a(paramb.ATf, (CharSequence)paramb.lzt.getString(e.h.finder_share_text_stauts_title), e.g.state_icon_main, paramb.lzt.getResources().getColor(e.b.Blue));
          }
        }
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.p(paramBaseFinderFeed))
        {
          j = 0;
          i = j;
          if (paramBaseFinderFeed.feedObject != null)
          {
            i = j;
            if (paramBaseFinderFeed.feedObject.field_finderObject != null) {
              i = paramBaseFinderFeed.feedObject.field_finderObject.ringtone_count;
            }
          }
          if (i == 0) {
            break label2282;
          }
          paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
          if (i < com.tencent.mm.plugin.finder.utils.av.fgc()) {
            break label2282;
          }
          if (i <= 99999) {
            break label2256;
          }
          paramf = String.valueOf(paramb.lzt.getString(e.h.finder_hundred_thousand_ringtone));
          paramf = paramb.lzt.getString(e.h.finder_feed_has_been_set_ringtone, new Object[] { paramf });
          kotlin.g.b.s.s(paramf, "if(count != 0 && count >…                        }");
          params.a(paramb.ATi, (CharSequence)paramf, e.g.icons_filled_ringtone, 0);
        }
        paramf = com.tencent.mm.ui.component.k.aeZF;
        params = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
        a(params, "delete", false, paramInt);
        paramf = bb.FuK;
        if (paramInt != 1) {
          break label2296;
        }
      }
      for (paramf = "forward";; paramf = "tridot")
      {
        bb.a(params, paramf, true, (JSONObject)new com.tencent.mm.ad.i());
        break;
        paramf = paramf.video_tmpl_info;
        if (paramf == null)
        {
          paramf = null;
          break label1394;
        }
        paramf = paramf.id;
        break label1394;
        i = 0;
        break label1415;
        localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
        if (localObject1 == null)
        {
          i = 0;
          break label1455;
        }
        localObject1 = ((byy)localObject1).aahY;
        if (localObject1 == null)
        {
          i = 0;
          break label1455;
        }
        i = ((fxe)localObject1).abME;
        break label1455;
        localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
        if (localObject1 == null)
        {
          j = 0;
          break label1475;
        }
        localObject1 = ((byy)localObject1).aahY;
        if (localObject1 == null)
        {
          j = 0;
          break label1475;
        }
        j = ((fxe)localObject1).abMF;
        break label1475;
        localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
        if (localObject1 == null)
        {
          k = -1;
          break label1495;
        }
        k = ((byy)localObject1).type;
        break label1495;
        paramf = paramf.video_tmpl_info;
        if (paramf == null)
        {
          i = 0;
          break label1528;
        }
        i = paramf.ZmT;
        break label1528;
        if (i > 9999)
        {
          paramf = com.tencent.mm.plugin.finder.utils.av.Ul(i);
          break label1566;
        }
        paramf = String.valueOf(i);
        break label1566;
        paramf = paramb.lzt.getString(e.h.finder_share_use_same_template);
        break label1582;
        paramf = paramf.video_tmpl_info;
        if (paramf == null)
        {
          paramf = Integer.valueOf(0);
          break label1681;
        }
        localObject1 = paramf.id;
        paramf = (com.tencent.mm.ui.widget.a.f)localObject1;
        if (localObject1 != null) {
          break label1681;
        }
        paramf = Integer.valueOf(0);
        break label1681;
        if (i > 9999)
        {
          paramf = com.tencent.mm.plugin.finder.utils.av.Ul(i);
          break label1890;
        }
        paramf = String.valueOf(i);
        break label1890;
        paramf = paramb.lzt.getString(e.h.finder_share_ringtone_title);
        break label1909;
      }
    }
  }
  
  private static final void a(b paramb, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(363264);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)paramb, paramBaseFinderFeed.feedObject, true);
    AppMethodBeat.o(363264);
  }
  
  private static final void a(final b paramb, final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.view.recyclerview.j paramj, int paramInt1, final MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(363251);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramj, "$holder");
    paramInt2 = paramMenuItem.getItemId();
    if (paramInt2 == paramb.ATj)
    {
      paramj = paramb.AXZ;
      if (paramj != null)
      {
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        paramb = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(x.class);
        kotlin.g.b.s.s(paramb, "UICProvider.of(getActivi…tMiniViewUIC::class.java)");
        x.a((x)paramb, new ca(paramBaseFinderFeed.feedObject.getFeedObject()), paramj.getRecyclerView());
      }
      AppMethodBeat.o(363251);
      return;
    }
    if (paramInt2 == paramb.ATk)
    {
      if (paramb.AXZ != null)
      {
        paramMenuItem = (List)new ArrayList();
        paramBaseFinderFeed = paramj.UH(e.e.finder_feed_full_footer_layout);
        if (paramBaseFinderFeed != null) {
          paramMenuItem.add(paramBaseFinderFeed);
        }
        paramBaseFinderFeed = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
        if (paramBaseFinderFeed != null) {
          break label247;
        }
        paramBaseFinderFeed = null;
        if (!(paramBaseFinderFeed instanceof FinderThumbPlayerProxy)) {
          break label255;
        }
      }
      label247:
      label255:
      for (paramBaseFinderFeed = (FinderThumbPlayerProxy)paramBaseFinderFeed;; paramBaseFinderFeed = null)
      {
        if (paramBaseFinderFeed != null)
        {
          paramj = com.tencent.mm.ui.component.k.aeZF;
          paramb = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.av.class);
          kotlin.g.b.s.s(paramb, "UICProvider.of(getActivi…edControlUIC::class.java)");
          com.tencent.mm.plugin.finder.viewmodel.component.av.a((com.tencent.mm.plugin.finder.viewmodel.component.av)paramb, paramMenuItem, paramBaseFinderFeed, 0, false, null, 28);
        }
        AppMethodBeat.o(363251);
        return;
        paramBaseFinderFeed = paramBaseFinderFeed.getVideoView();
        break;
      }
    }
    Object localObject1 = paramb.ATr;
    if (paramMenuItem == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(363251);
      throw paramb;
    }
    ((com.tencent.mm.pluginsdk.q)localObject1).a((com.tencent.mm.ui.base.t)paramMenuItem, (kotlin.g.a.b)new e(paramb, paramMenuItem, paramBaseFinderFeed));
    label659:
    Object localObject2;
    label761:
    long l;
    if (!paramb.hHq)
    {
      Log.i(paramb.TAG, "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + " menuItem:" + paramMenuItem.getItemId());
      paramInt1 = paramMenuItem.getItemId();
      if (paramInt1 == paramb.AST)
      {
        paramInt1 = paramb.getFeedLoader().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
        if (paramInt1 >= 0)
        {
          paramj = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
          com.tencent.mm.plugin.finder.feed.logic.c.a((Context)paramb.lzt, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new f(paramb, paramBaseFinderFeed));
          AppMethodBeat.o(363251);
          return;
        }
        Log.i(paramb.TAG, kotlin.g.b.s.X("[UNINTEREST] pos error ", Integer.valueOf(paramInt1)));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt1 != paramb.ASU)
      {
        if (paramInt1 == paramb.Auf)
        {
          com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)paramb.lzt, paramBaseFinderFeed.feedObject, null, 3, 20);
          AppMethodBeat.o(363251);
          return;
        }
        if (paramInt1 == paramb.ATm)
        {
          paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramj == null)
          {
            paramj = null;
            if (paramj != null) {
              break label659;
            }
            aa.dc((Context)paramb.lzt, paramb.lzt.getString(e.h.finder_get_video_template_error));
            paramj = com.tencent.mm.ui.component.k.aeZF;
            paramj = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramb.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
            paramb = bb.FuK;
            paramMenuItem = new JSONObject();
            paramb = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramb != null) {
              break label761;
            }
            paramb = Integer.valueOf(0);
          }
          for (;;)
          {
            paramMenuItem.put("templateId", paramb);
            paramb = ah.aiuX;
            bb.a(paramj, "shoot_same_video", true, paramMenuItem);
            AppMethodBeat.o(363251);
            return;
            paramj = paramj.video_tmpl_info;
            break;
            paramMenuItem = new Intent();
            switch (paramj.type)
            {
            default: 
              paramInt1 = -1;
            }
            for (;;)
            {
              localObject1 = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
              localObject2 = (Activity)paramb.lzt;
              paramMenuItem.putExtra("key_maas_entrance", 5);
              ah localah = ah.aiuX;
              ((com.tencent.mm.mj_template.api.d)localObject1).creationBySameTemplate((Activity)localObject2, paramj, paramMenuItem, paramInt1);
              break;
              paramInt1 = 16;
              continue;
              paramInt1 = 13;
            }
            paramb = paramb.video_tmpl_info;
            if (paramb == null)
            {
              paramb = Integer.valueOf(0);
            }
            else
            {
              paramBaseFinderFeed = paramb.id;
              paramb = paramBaseFinderFeed;
              if (paramBaseFinderFeed == null) {
                paramb = Integer.valueOf(0);
              }
            }
          }
        }
        if (paramInt1 == paramb.Aug)
        {
          com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)paramb.lzt, paramBaseFinderFeed, 0, 0, 28);
          AppMethodBeat.o(363251);
          return;
        }
        if (paramInt1 == paramb.ASW)
        {
          paramj = n.Ggy;
          n.a(paramBaseFinderFeed, (Activity)paramb.lzt);
          AppMethodBeat.o(363251);
          return;
        }
        if (paramInt1 == paramb.ASV)
        {
          paramj = aw.Gjk;
          if (aw.s(paramBaseFinderFeed))
          {
            paramj = paramBaseFinderFeed.feedObject.getLiveInfo();
            if (paramj != null)
            {
              l = paramj.liveId;
              paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
              com.tencent.mm.plugin.finder.feed.logic.a.c((Context)paramb.lzt, l, paramBaseFinderFeed.feedObject.getUserName());
              AppMethodBeat.o(363251);
            }
          }
          else
          {
            paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
            com.tencent.mm.plugin.finder.feed.logic.a.a((Context)paramb.lzt, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 0, 28);
            AppMethodBeat.o(363251);
          }
        }
        else
        {
          if (paramInt1 == paramb.ASX)
          {
            paramMenuItem = new Intent();
            paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramj == null) {}
            for (paramj = null;; paramj = paramj.toByteArray())
            {
              paramMenuItem.putExtra("postRefMediaList", paramj);
              paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
              paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.av.o(paramBaseFinderFeed).toByteArray());
              paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
              paramMenuItem.putExtra("key_finder_post_from", 5);
              paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
              com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)paramb.lzt, paramMenuItem);
              AppMethodBeat.o(363251);
              return;
            }
          }
          if (paramInt1 == paramb.ASZ)
          {
            ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (ck)new g(paramb));
            AppMethodBeat.o(363251);
            return;
          }
          if (paramInt1 == paramb.ASY)
          {
            ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (ck)new h(paramb));
            AppMethodBeat.o(363251);
            return;
          }
          if (paramInt1 == paramb.ATb)
          {
            if (paramBaseFinderFeed.feedObject.isPostFinish())
            {
              paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
              paramj = as.a.hu((Context)paramb.lzt);
              if (paramj == null) {}
              for (paramInt1 = 0; paramInt1 == 52; paramInt1 = paramj.AJo)
              {
                if ((paramb.lzt instanceof FinderTopicTimelineUI)) {
                  ((FinderTopicTimelineUI)paramb.lzt).onBackPressed();
                }
                paramj = com.tencent.mm.plugin.finder.report.z.FrZ;
                com.tencent.mm.plugin.finder.report.z.a((Context)paramb.lzt, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
                AppMethodBeat.o(363251);
                return;
              }
              paramj = e.FMN;
              e.a.s(paramBaseFinderFeed.feedObject);
              paramj = com.tencent.mm.plugin.finder.utils.as.GiG;
              paramMenuItem = (Context)paramb.lzt;
              paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
              if (paramj == null) {}
              for (paramj = null;; paramj = paramj.feedBgmInfo)
              {
                com.tencent.mm.plugin.finder.utils.as.a(paramMenuItem, paramj, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
                break;
              }
            }
          }
          else
          {
            if (paramInt1 == paramb.ATf)
            {
              com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)paramb.lzt, paramBaseFinderFeed);
              AppMethodBeat.o(363251);
              return;
            }
            if (paramInt1 == paramb.ATi)
            {
              paramj = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
              paramj.fiH();
              paramMenuItem = al.GhB;
              al.a((AppCompatActivity)paramb.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new i(paramj, paramb));
              AppMethodBeat.o(363251);
              return;
            }
            if (paramInt1 == paramb.ATc)
            {
              paramj = bb.FuK;
              paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
              paramj = as.a.hu((Context)paramb.lzt);
              if (paramj == null)
              {
                paramj = null;
                bb.a(paramj, "fav_in_menu", false, paramBaseFinderFeed.bZA());
                paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
                  break label1591;
                }
              }
              label1591:
              for (paramj = paramb.lzt.getResources().getString(e.h.finder_has_fav_title);; paramj = paramb.lzt.getResources().getString(e.h.finder_has_fav_title2))
              {
                kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…e2)\n                    }");
                aa.a((Context)paramb.lzt, paramj, new an.b..ExternalSyntheticLambda3(paramb, paramBaseFinderFeed));
                AppMethodBeat.o(363251);
                return;
                paramj = paramj.fou();
                break;
              }
            }
            if (paramInt1 == paramb.ATd)
            {
              paramj = bb.FuK;
              paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
              paramj = as.a.hu((Context)paramb.lzt);
              if (paramj == null)
              {
                paramj = null;
                bb.a(paramj, "unfav_in_menu", false, paramBaseFinderFeed.bZA());
                paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
                if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
                  break label1728;
                }
              }
              label1728:
              for (paramj = paramb.lzt.getResources().getString(e.h.finder_has_cancel_fav_title);; paramj = paramb.lzt.getResources().getString(e.h.finder_has_cancel_fav_title2))
              {
                kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…e2)\n                    }");
                aa.a((Context)paramb.lzt, paramj, new an.b..ExternalSyntheticLambda4(paramb, paramBaseFinderFeed));
                AppMethodBeat.o(363251);
                return;
                paramj = paramj.fou();
                break;
              }
            }
            if (paramInt1 == paramb.ATn)
            {
              paramj = am.GhD;
              paramb = (Activity)paramb.lzt;
              paramj = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
              am.a(paramBaseFinderFeed, paramb, com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId()));
            }
          }
        }
      }
      AppMethodBeat.o(363251);
      return;
    }
    localObject1 = (Activity)paramb.lzt;
    paramInt2 = paramMenuItem.getItemId();
    if (paramInt2 == paramb.Auf)
    {
      com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)localObject1, paramBaseFinderFeed.feedObject, null, 3, 20);
      AppMethodBeat.o(363251);
      return;
    }
    if (paramInt2 == paramb.ATm)
    {
      paramb = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (paramb == null)
      {
        paramb = null;
        if (paramb != null) {
          break label1991;
        }
        aa.dc((Context)localObject1, ((Activity)localObject1).getString(e.h.finder_get_video_template_error));
        paramb = com.tencent.mm.ui.component.k.aeZF;
        paramj = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
        paramb = bb.FuK;
        paramMenuItem = new JSONObject();
        paramb = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramb != null) {
          break label2097;
        }
        paramb = Integer.valueOf(0);
      }
      for (;;)
      {
        paramMenuItem.put("templateId", paramb);
        paramb = ah.aiuX;
        bb.a(paramj, "shoot_same_video", true, paramMenuItem);
        AppMethodBeat.o(363251);
        return;
        paramb = paramb.video_tmpl_info;
        break;
        label1991:
        paramj = new Intent();
        switch (paramb.type)
        {
        default: 
          paramInt1 = -1;
        }
        for (;;)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.u.GgT;
          com.tencent.mm.plugin.finder.utils.u.a((Context)localObject1, paramj, 133, 13);
          paramMenuItem = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
          paramj.putExtra("key_maas_entrance", 5);
          localObject2 = ah.aiuX;
          paramMenuItem.creationBySameTemplate((Activity)localObject1, paramb, paramj, paramInt1);
          break;
          paramInt1 = 16;
          continue;
          paramInt1 = 13;
        }
        label2097:
        paramb = paramb.video_tmpl_info;
        if (paramb == null)
        {
          paramb = Integer.valueOf(0);
        }
        else
        {
          paramBaseFinderFeed = paramb.id;
          paramb = paramBaseFinderFeed;
          if (paramBaseFinderFeed == null) {
            paramb = Integer.valueOf(0);
          }
        }
      }
    }
    if (paramInt2 == paramb.Aug)
    {
      com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)localObject1, paramBaseFinderFeed, 0, 0, 28);
      AppMethodBeat.o(363251);
      return;
    }
    if (paramInt2 == paramb.pIs)
    {
      paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
      if ((com.tencent.mm.plugin.finder.utils.av.e(paramBaseFinderFeed)) && (paramBaseFinderFeed.feedObject.isPostFinish()))
      {
        paramj = com.tencent.mm.ui.component.k.aeZF;
        a(((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), "delete", true, paramInt1);
        paramj = com.tencent.mm.plugin.finder.utils.g.GfZ;
        if (com.tencent.mm.plugin.finder.utils.g.io(paramBaseFinderFeed.feedObject.getFeedObject().adFlag, 1)) {}
        for (paramInt1 = e.h.finder_confirm_delete_mutual_ad;; paramInt1 = e.h.finder_profile_confirm_del)
        {
          com.tencent.mm.ui.base.k.a((Context)localObject1, paramInt1, 0, new an.b..ExternalSyntheticLambda2(paramBaseFinderFeed, paramb, (Activity)localObject1), null);
          AppMethodBeat.o(363251);
          return;
        }
      }
    }
    else if (paramInt2 == paramb.AST)
    {
      if (paramb.h(paramBaseFinderFeed) >= 0)
      {
        paramj = paramb.AXZ;
        if (paramj == null) {}
        for (paramj = null;; paramj = paramj.getRecyclerView().getAdapter())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
          com.tencent.mm.plugin.finder.feed.logic.c.a((Context)localObject1, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new m(paramb, paramBaseFinderFeed, paramj));
          AppMethodBeat.o(363251);
          return;
        }
      }
    }
    else if (paramInt2 == paramb.ASV)
    {
      paramb = aw.Gjk;
      if (aw.s(paramBaseFinderFeed))
      {
        paramb = paramBaseFinderFeed.feedObject.getLiveInfo();
        if (paramb != null)
        {
          l = paramb.liveId;
          paramb = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
          com.tencent.mm.plugin.finder.feed.logic.a.c((Context)localObject1, l, paramBaseFinderFeed.feedObject.getUserName());
          AppMethodBeat.o(363251);
        }
      }
      else
      {
        paramb = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
        com.tencent.mm.plugin.finder.feed.logic.a.a((Context)localObject1, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 0, 28);
        AppMethodBeat.o(363251);
      }
    }
    else
    {
      if (paramInt2 == paramb.ATf)
      {
        com.tencent.mm.plugin.finder.utils.an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)localObject1, paramBaseFinderFeed);
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.ATi)
      {
        paramj = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
        paramj.fiH();
        paramMenuItem = al.GhB;
        al.a((AppCompatActivity)localObject1, paramBaseFinderFeed, (kotlin.g.a.b)new n(paramj, paramb));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.ASZ)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (ck)new o((Activity)localObject1));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.ASY)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (ck)new p((Activity)localObject1));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.AYd)
      {
        paramb = ag.Ghl;
        ag.a((Context)localObject1, paramBaseFinderFeed.feedObject, false);
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.AYc)
      {
        if (paramBaseFinderFeed.feedObject.getStickyTime() != 0)
        {
          aa.a((Context)localObject1, ((Activity)localObject1).getString(e.h.finder_private_feed_failed_reason1), an.b..ExternalSyntheticLambda5.INSTANCE);
          AppMethodBeat.o(363251);
          return;
        }
        paramb = com.tencent.mm.plugin.finder.utils.g.GfZ;
        if (com.tencent.mm.plugin.finder.utils.g.io(paramBaseFinderFeed.feedObject.getFeedObject().adFlag, 1))
        {
          com.tencent.mm.ui.base.k.a((Context)localObject1, e.h.finder_confirm_set_private_mutual_ad, 0, new an.b..ExternalSyntheticLambda1((Activity)localObject1, paramBaseFinderFeed), null);
          AppMethodBeat.o(363251);
          return;
        }
        paramb = ag.Ghl;
        ag.a((Context)localObject1, paramBaseFinderFeed.feedObject, true);
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.AYf)
      {
        paramb.AYb.a((Context)localObject1, paramBaseFinderFeed.feedObject.getId(), false, paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.m)new j((Activity)localObject1));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.AYe)
      {
        if (paramBaseFinderFeed.feedObject.getPrivate_flag() == 1)
        {
          aa.a(MMApplicationContext.getContext(), ((Activity)localObject1).getString(e.h.finder_sticky_feed_failed_reason1), an.b..ExternalSyntheticLambda6.INSTANCE);
          AppMethodBeat.o(363251);
          return;
        }
        paramb.AYb.a((Context)localObject1, paramBaseFinderFeed.feedObject.getId(), true, paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.m)new k((Activity)localObject1));
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.ASX)
      {
        paramj = new Intent();
        paramb = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramb == null) {}
        for (paramb = null;; paramb = paramb.toByteArray())
        {
          paramj.putExtra("postRefMediaList", paramb);
          paramb = com.tencent.mm.plugin.finder.utils.av.GiL;
          paramj.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.av.o(paramBaseFinderFeed).toByteArray());
          paramj.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          paramj.putExtra("key_finder_post_from", 5);
          paramb = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)localObject1, paramj);
          AppMethodBeat.o(363251);
          return;
        }
      }
      if (paramInt2 == paramb.ASW)
      {
        paramb = n.Ggy;
        n.a(paramBaseFinderFeed, (Activity)localObject1);
        AppMethodBeat.o(363251);
        return;
      }
      if (paramInt2 == paramb.ATb)
      {
        if (paramBaseFinderFeed.feedObject.isPostFinish())
        {
          paramb = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          paramb = as.a.hu((Context)localObject1);
          if (paramb == null) {}
          for (paramInt1 = 0; paramInt1 == 52; paramInt1 = paramb.AJo)
          {
            if ((localObject1 instanceof FinderTopicTimelineUI)) {
              ((FinderTopicTimelineUI)localObject1).onBackPressed();
            }
            paramb = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.a((Context)localObject1, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
            AppMethodBeat.o(363251);
            return;
          }
          paramb = e.FMN;
          e.a.s(paramBaseFinderFeed.feedObject);
          paramb = com.tencent.mm.plugin.finder.utils.as.GiG;
          paramj = (Context)localObject1;
          paramb = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramb == null) {}
          for (paramb = null;; paramb = paramb.feedBgmInfo)
          {
            com.tencent.mm.plugin.finder.utils.as.a(paramj, paramb, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
            break;
          }
        }
      }
      else
      {
        if (paramInt2 == paramb.ATe)
        {
          paramb = new Intent();
          paramb.putExtra("KEY_FROM_SCENE", 1);
          paramb.putExtra("KEY_USERNAME", com.tencent.mm.model.z.bAW());
          paramb.putExtra("KEY_FINDER_SELF_FLAG", true);
          paramb.putExtra("KEY_IS_FULLSCREEN", true);
          paramb.putExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", false);
          paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
          com.tencent.mm.plugin.finder.utils.av.a(0, kotlin.a.p.listOf(paramBaseFinderFeed), null, paramb);
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.S((Context)localObject1, paramb);
          AppMethodBeat.o(363251);
          return;
        }
        if (paramInt2 == paramb.ATn)
        {
          paramb = am.GhD;
          paramb = (Activity)localObject1;
          paramj = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
          am.a(paramBaseFinderFeed, paramb, com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId()));
        }
      }
    }
    AppMethodBeat.o(363251);
  }
  
  private static final void a(b paramb, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(363258);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    com.tencent.mm.pluginsdk.q localq = paramb.ATr;
    if (paramMenuItem == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(363258);
      throw paramb;
    }
    boolean bool = localq.a(paramf, (com.tencent.mm.ui.base.t)paramMenuItem);
    Log.i(paramb.TAG, kotlin.g.b.s.X("getMoreMenuItemLongSelectedListener :", Boolean.valueOf(bool)));
    AppMethodBeat.o(363258);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, final b paramb, final Activity paramActivity, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(363286);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramActivity, "$context");
    paramDialogInterface = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(paramDialogInterface, "getMyFinderUsername()");
    paramDialogInterface = new bt(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
    paramBaseFinderFeed = paramb.tipDialog;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = ah.aiuX)
    {
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = (Context)paramActivity;
        paramActivity.getString(e.h.app_tip);
        paramb.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramBaseFinderFeed, paramActivity.getString(e.h.app_waiting), false, an.b..ExternalSyntheticLambda0.INSTANCE));
      }
      com.tencent.mm.kernel.h.aZW().a(paramDialogInterface.getType(), (com.tencent.mm.am.h)new l(paramDialogInterface, paramb, paramActivity));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramDialogInterface, 0);
      AppMethodBeat.o(363286);
      return;
      paramBaseFinderFeed.show();
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, b paramb, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(363181);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    Object localObject1;
    Object localObject2;
    label204:
    int i;
    int j;
    label250:
    int k;
    if (paramBaseFinderFeed.feedObject.isLongVideo())
    {
      localObject1 = paramb.AXZ;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = paramb.lzt.getString(e.h.mega_video_play_speed_text);
          kotlin.g.b.s.s(localObject2, "context.getString(R.stri…ga_video_play_speed_text)");
        }
        params.a(paramb.ATk, (CharSequence)localObject2, e.g.icons_outlined_play_control_2);
      }
    }
    else
    {
      localObject1 = am.GhD;
      localObject1 = (Activity)paramb.lzt;
      kotlin.g.b.s.s(params, "menu");
      am.a((Activity)localObject1, paramBaseFinderFeed, params, paramf, paramb.ATn);
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if ((!com.tencent.mm.plugin.finder.utils.av.e(paramBaseFinderFeed)) || (!paramb.hHq)) {
        break label501;
      }
      params.bx(paramb.pIs, e.h.app_delete, e.g.icons_outlined_delete);
      if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
        break label438;
      }
      params.a(paramb.ASZ, (CharSequence)paramb.lzt.getString(e.h.finder_feed_open_comment), e.g.icons_outlined_comment);
      paramf = ag.Ghl;
      paramf = (Context)paramb.lzt;
      paramBaseFinderFeed.feedObject.getMediaType();
      i = paramb.AYd;
      j = paramb.AYc;
      if (paramBaseFinderFeed.feedObject.getPrivate_flag() != 1) {
        break label466;
      }
      bool1 = true;
      ag.a(params, paramf, i, j, bool1);
      paramf = (Context)paramb.lzt;
      j = paramb.AYf;
      k = paramb.AYe;
      if (paramBaseFinderFeed.feedObject.getStickyTime() == 0) {
        break label472;
      }
      i = 1;
      label294:
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramf, "context");
      if (i == 0) {
        break label478;
      }
      params.a(j, (CharSequence)paramf.getString(e.h.finder_cancel_sticky), e.g.icons_outlined_top_off);
    }
    for (;;)
    {
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (!com.tencent.mm.plugin.finder.utils.av.I(paramBaseFinderFeed.feedObject)) {
        break label599;
      }
      i = paramb.ATb;
      paramb = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramb = (CharSequence)com.tencent.mm.plugin.finder.utils.av.r(paramBaseFinderFeed);
      j = e.g.icons_outlined_bgm_play;
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        bool1 = bool2;
        if (!paramBaseFinderFeed.feedObject.isPostFailed()) {}
      }
      else
      {
        bool1 = true;
      }
      params.a(i, paramb, j, bool1);
      AppMethodBeat.o(363181);
      return;
      localObject1 = ((an.c)localObject1).getRecyclerView();
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.av.GUq;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.av.a.H((RecyclerView)localObject1);
      break;
      label438:
      params.a(paramb.ASY, (CharSequence)paramb.lzt.getString(e.h.finder_feed_close_comment), e.g.finder_feed_discomment);
      break label204;
      label466:
      bool1 = false;
      break label250;
      label472:
      i = 0;
      break label294;
      label478:
      params.a(k, (CharSequence)paramf.getString(e.h.finder_set_sticky), e.g.icons_outlined_top);
    }
    label501:
    paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
    if (!com.tencent.mm.plugin.finder.utils.av.e(paramBaseFinderFeed))
    {
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.I(paramBaseFinderFeed.feedObject))
      {
        i = paramb.ATb;
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        paramf = (CharSequence)com.tencent.mm.plugin.finder.utils.av.r(paramBaseFinderFeed);
        j = e.g.icons_outlined_bgm_play;
        if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
          bool1 = true;
        }
        params.a(i, paramf, j, bool1);
      }
      params.bx(paramb.ASV, e.h.more_menu_back, e.g.icons_outlined_report_problem);
    }
    label599:
    AppMethodBeat.o(363181);
  }
  
  private static void a(bui parambui, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(363097);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    if (paramInt == 1) {}
    for (Object localObject = "forward";; localObject = "tridot")
    {
      locali.m("ref_eid", localObject);
      localObject = bb.FuK;
      bb.a(parambui, paramString, paramBoolean, (JSONObject)locali);
      AppMethodBeat.o(363097);
      return;
    }
  }
  
  private static final void b(b paramb, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(363271);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)paramb, paramBaseFinderFeed.feedObject, false);
    AppMethodBeat.o(363271);
  }
  
  private static final void b(BaseFinderFeed paramBaseFinderFeed, b paramb, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(363189);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    if (!paramBaseFinderFeed.feedObject.isNotShareConversation())
    {
      paramBaseFinderFeed = paramb.ATr;
      Context localContext = (Context)paramb.lzt;
      kotlin.g.b.s.s(params, "it");
      paramBaseFinderFeed.a(localContext, params, paramf);
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.an.GhR;
      com.tencent.mm.plugin.finder.utils.an.a.TX(paramb.ATr.getItemCount());
    }
    AppMethodBeat.o(363189);
  }
  
  private static final void fA(View paramView)
  {
    AppMethodBeat.i(363292);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(363292);
  }
  
  private static final void fB(View paramView)
  {
    AppMethodBeat.i(363305);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(363305);
  }
  
  private static final void i(DialogInterface paramDialogInterface) {}
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf)
  {
    AppMethodBeat.i(363470);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new an.b..ExternalSyntheticLambda9(paramBaseFinderFeed, this, paramf);
    AppMethodBeat.o(363470);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(363455);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new an.b..ExternalSyntheticLambda7(this, paramBaseFinderFeed, paramInt, paramf);
    AppMethodBeat.o(363455);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363464);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new an.b..ExternalSyntheticLambda8(paramBaseFinderFeed, this, paramf);
    AppMethodBeat.o(363464);
    return paramBaseFinderFeed;
  }
  
  public final u.h a(com.tencent.mm.ui.widget.a.f paramf, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363480);
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramf = new an.b..ExternalSyntheticLambda10(this, paramf);
    AppMethodBeat.o(363480);
    return paramf;
  }
  
  public final u.i a(BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363473);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new an.b..ExternalSyntheticLambda11(this, paramBaseFinderFeed, paramj, paramInt);
    AppMethodBeat.o(363473);
    return paramBaseFinderFeed;
  }
  
  public final void a(an.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(165754);
    kotlin.g.b.s.u(paramc, "callback");
    this.AXZ = paramc;
    int i;
    label43:
    Object localObject3;
    Object localObject4;
    if (this.AXX)
    {
      i = 8;
      localObject1 = getFeedLoader();
      if (!(localObject1 instanceof FinderProfileFeedLoader)) {
        break label532;
      }
      if (localObject1 != null) {
        ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new s(this));
      }
      this.AYh.alive();
      this.AYi.alive();
      this.AYg = new ContactUninterestEventListener((BaseFinderFeedLoader)getFeedLoader());
      localObject1 = this.AYg;
      if (localObject1 != null) {
        ((ContactUninterestEventListener)localObject1).alive();
      }
      localObject1 = this.AJn;
      localObject3 = this.AXZ;
      kotlin.g.b.s.checkNotNull(localObject3);
      l.a((l)localObject1, (AppCompatActivity)((an.c)localObject3).lzt, (l.b)new q(this), 4);
      localObject1 = com.tencent.mm.plugin.finder.preload.f.EUC;
      if (com.tencent.mm.plugin.finder.preload.f.eHI())
      {
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = (com.tencent.mm.plugin.finder.viewmodel.component.c)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.c.class);
        localObject4 = getFeedLoader().getDataListJustForAdapter();
        l locall = this.AJn;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject1 = as.a.hu((Context)this.lzt);
        if (localObject1 != null) {
          break label537;
        }
        localObject1 = null;
        label218:
        ((com.tencent.mm.plugin.finder.viewmodel.component.c)localObject3).a((DataBuffer)localObject4, 0, locall, (com.tencent.mm.plugin.finder.event.base.c)localObject1, -1);
      }
      this.Aye.a(this.scene, i, (kotlin.g.a.b)new t(this));
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
        }
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      this.AUT = new ab(((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou()).AUT;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject4 = ((bn)localObject1).Vm(-1);
        if (localObject4 != null)
        {
          localObject3 = this.AUT;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("observerForExposeReport");
            localObject1 = null;
          }
          ((com.tencent.mm.plugin.finder.event.base.c)localObject4).a((com.tencent.mm.plugin.finder.event.base.d)localObject1);
        }
      }
      localObject3 = this.Ayf;
      localObject4 = (kotlin.g.a.m)new u(this);
      localObject1 = this.AXZ;
      if (localObject1 != null) {
        break label551;
      }
    }
    label532:
    label537:
    label551:
    for (Object localObject1 = localObject2;; localObject1 = ((an.c)localObject1).getRecyclerView())
    {
      ((com.tencent.mm.plugin.findersdk.a.as)localObject3).a((kotlin.g.a.m)localObject4, (RecyclerView)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null)
      {
        localObject1 = ((bn)localObject1).Vm(-1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a(this.Ayf.edV());
        }
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.t.class)).E(paramc.getRecyclerView());
      AppMethodBeat.o(165754);
      return;
      i = 1;
      break;
      localObject1 = null;
      break label43;
      localObject1 = ((bn)localObject1).Vm(-1);
      break label218;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(363495);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    Object localObject2 = com.tencent.mm.plugin.finder.model.an.ECX;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    aw localaw = aw.Gjk;
    com.tencent.mm.plugin.finder.model.an.a((bui)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, aw.n(paramBaseFinderFeed.contact));
    AppMethodBeat.o(363495);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(363484);
    kotlin.g.b.s.u(paramFinderItem, "feed");
    paramj = com.tencent.mm.plugin.finder.model.s.ECs;
    com.tencent.mm.plugin.finder.model.s.a((AppCompatActivity)this.lzt, paramFinderItem, paramBoolean, paramInt);
    AppMethodBeat.o(363484);
  }
  
  public final com.tencent.mm.plugin.finder.view.f ebA()
  {
    return this.ATy;
  }
  
  public final boolean ebw()
  {
    return this.hHq;
  }
  
  public final RecyclerView.m ebz()
  {
    AppMethodBeat.i(363504);
    RecyclerView.m localm = (RecyclerView.m)this.AXY.getValue();
    AppMethodBeat.o(363504);
    return localm;
  }
  
  public final ArrayList<cc> ecc()
  {
    AppMethodBeat.i(363440);
    ArrayList localArrayList = (ArrayList)getFeedLoader().getDataListJustForAdapter();
    AppMethodBeat.o(363440);
    return localArrayList;
  }
  
  public final void ecx()
  {
    AppMethodBeat.i(363452);
    BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)getFeedLoader(), false, 1, null);
    AppMethodBeat.o(363452);
  }
  
  public final void f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(363501);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    ak localak = ak.ECS;
    Context localContext = (Context)this.lzt;
    bh localbh = bh.ABm;
    ak.a(localak, localContext, (bui)localObject, paramBaseFinderFeed, bh.dVr(), paramBaseFinderFeed.isDeepEnjoy);
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {
      paramBaseFinderFeed = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.api.m.Axk;
      d.a.et(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.m.dUG());
      AppMethodBeat.o(363501);
      return;
      localObject = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject;
      if (localObject == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.lzt;
  }
  
  public final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(363412);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.AYa.getValue();
    AppMethodBeat.o(363412);
    return localFinderProfileFeedLoader;
  }
  
  public final l getVideoCore()
  {
    return this.AJn;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    int i = getFeedLoader().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    kotlin.g.b.s.u(parama, "p0");
    this.ATq.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.Aye.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    this.Ayf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(this.Ayf.edV());
      }
    }
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.event.base.c localc = ((bn)localObject).Vm(-1);
      if (localc != null)
      {
        com.tencent.mm.plugin.finder.event.base.d locald = this.AUT;
        localObject = locald;
        if (locald == null)
        {
          kotlin.g.b.s.bIx("observerForExposeReport");
          localObject = null;
        }
        localc.b((com.tencent.mm.plugin.finder.event.base.d)localObject);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.f.FMT.clearCache();
    localObject = ((Iterable)this.ATq).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.ATq.clear();
    this.AXZ = null;
    this.AYh.dead();
    this.AYi.dead();
    localObject = this.AYg;
    if (localObject != null) {
      ((ContactUninterestEventListener)localObject).dead();
    }
    AppMethodBeat.o(165757);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(363428);
    an.c localc = this.AXZ;
    if (localc != null) {
      localc.getRecyclerView().post(new an.b..ExternalSyntheticLambda12(this));
    }
    AppMethodBeat.o(363428);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(an.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(165729);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
        com.tencent.mm.plugin.finder.utils.av.eY(an.b.d(this.AYj), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(an.b.c(this.AYj), (i)this.AYj, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.q((i)this.AYj, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      }
      Object localObject = (com.tencent.mm.view.recyclerview.f)new r(an.b.c(this.AYj), (i)this.AYj, 0, 0, 28);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    b(an.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.u<? extends String, ? extends String, ? extends String>, ah>
  {
    c(com.tencent.mm.ui.base.s params, BaseFinderFeed paramBaseFinderFeed, an.b paramb, com.tencent.mm.ui.widget.a.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.u<? extends String, ? extends String, ? extends String>, ah>
  {
    d(com.tencent.mm.ui.base.s params, BaseFinderFeed paramBaseFinderFeed, an.b paramb, com.tencent.mm.ui.widget.a.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    e(an.b paramb, MenuItem paramMenuItem, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    f(an.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$5", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ck<bpu>
  {
    g(an.b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$6", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ck<bpu>
  {
    h(an.b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    i(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, an.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.m<bqb, aux, ah>
  {
    j(Activity paramActivity)
    {
      super();
    }
    
    private static final void invoke$lambda-0(View paramView)
    {
      AppMethodBeat.i(363288);
      ((WeImageView)paramView.findViewById(a.g.toast_img)).setImageResource(e.g.icons_filled_top_off);
      AppMethodBeat.o(363288);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.m<bqb, aux, ah>
  {
    k(Activity paramActivity)
    {
      super();
    }
    
    private static final void invoke$lambda-0(View paramView)
    {
      AppMethodBeat.i(363195);
      ((WeImageView)paramView.findViewById(a.g.toast_img)).setImageResource(e.g.icons_filled_top);
      AppMethodBeat.o(363195);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$3$3", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.am.h
  {
    l(bt parambt, an.b paramb, Activity paramActivity) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(363182);
      if (((paramp instanceof bt)) && (((bt)paramp).hKN == this.AVi.hKN)) {
        com.tencent.mm.kernel.h.aZW().b(this.AVi.getType(), (com.tencent.mm.am.h)this);
      }
      paramString = paramb.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        aa.makeText((Context)paramActivity, e.h.finder_profile_del_feed_failed, 0).show();
      }
      AppMethodBeat.o(363182);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    m(an.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    n(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, an.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$7", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements ck<bpu>
  {
    o(Activity paramActivity) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$8", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements ck<bpu>
  {
    p(Activity paramActivity) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements l.b
  {
    q(an.b paramb) {}
    
    public final RecyclerView ebB()
    {
      AppMethodBeat.i(363398);
      Object localObject = an.b.b(this.AYj);
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((an.c)localObject).getRecyclerView();
      AppMethodBeat.o(363398);
      return localObject;
    }
    
    public final boolean ebC()
    {
      return true;
    }
    
    public final boolean ebD()
    {
      return true;
    }
    
    public final DataBuffer<cc> ebE()
    {
      AppMethodBeat.i(363416);
      DataBuffer localDataBuffer = this.AYj.getFeedLoader().getDataList();
      AppMethodBeat.o(363416);
      return localDataBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<RecyclerView.m>
  {
    public static final r AYn;
    
    static
    {
      AppMethodBeat.i(165745);
      AYn = new r();
      AppMethodBeat.o(165745);
    }
    
    r()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    s(an.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, cc>
  {
    t(an.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Integer, Integer, LinkedList<cc>>
  {
    u(an.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.an.b
 * JD-Core Version:    0.7.0.1
 */