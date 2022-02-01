package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.finder.edit.FinderPhotoEditPluginLayout;
import com.tencent.mm.plugin.finder.edit.FinderVideoEditPluginLayout;
import com.tencent.mm.plugin.finder.feed.ui.FinderAtTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendFoldedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB;
import com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileTimeLineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRelatedTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderRetransmitSourceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI1;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.search.FinderContactSearchUI;
import com.tencent.mm.plugin.finder.search.FinderFeedSearchUI;
import com.tencent.mm.plugin.finder.search.FinderMixSearchUI;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderEditTextUI;
import com.tencent.mm.plugin.finder.ui.FinderFansListUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.FinderImagePreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI;
import com.tencent.mm.plugin.finder.ui.FinderMediaPreviewUI;
import com.tencent.mm.plugin.finder.ui.FinderModifyNameUI;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectSexUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.FinderSettingInfoUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.ui.FinderUnOpenUI;
import com.tencent.mm.plugin.finder.ui.FinderWxMsgUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.p.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.n.n;
import d.z;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "", "()V", "TAG", "", "enterAtMyTimelineUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterAuthInfoWeApp", "appId", "enterPath", "enterChattingUIFromComment", "sessionId", "username", "feedId", "", "commentId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "enterChattingUIFromFans", "fansId", "enterChattingUIFromProfile", "scene", "", "enterCropAvatarUI", "Landroid/app/Activity;", "rc", "enterFavFeedUI", "Lcom/tencent/mm/ui/MMActivity;", "reqCode", "enterFavTimelineUI", "requestCode", "enterFeedReletedTimelineUI", "enterFinderBlackConversationUI", "convType", "enterFinderCommentUI", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "activity", "enterFinderContactSearchUI", "enterFinderConversationUI", "enterFinderCreateContactUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderMsgUI", "enterFinderFinderSysMsgUI", "enterFinderHelloConversationUI", "enterFinderImagePreviewUI", "enterFinderLikedFeedUI", "enterFinderMediaEditUI", "rawPath", "type", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderNewUIC", "enterFinderPostAlbumUI", "enterFinderPostRouterUI", "intent", "enterFinderPostUI", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderTimelineUI", "enterFinderWxConversationUI", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFriendBlackListUI", "enterFriendContactUI", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "totalCount", "isPosterView", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterModifyNameUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPostAtUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectCoverUI", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "fillPostFromRoute", "curIntent", "goDraft", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "routeFrom", "openImagePreviewGallery", "path", "args", "", "tryGoPlainTextPostUIIfDraftExist", "tryGoPostUIIfDraftExist", "plugin-finder_release"})
public final class a
{
  public static final a sKD;
  
  static
  {
    AppMethodBeat.i(167872);
    sKD = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204414);
    d.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.finder.spam.a locala = com.tencent.mm.plugin.finder.spam.a.suA;
    if (com.tencent.mm.plugin.finder.spam.a.ain("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.spam.a.suA;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.finder.spam.a.aio("search"), "", paramContext.getString(2131766205), null);
      AppMethodBeat.o(204414);
      return;
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(204414);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167851);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderEditTextUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167851);
      return;
    }
  }
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderShareFeedRelUI.class);
      paramIntent = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.cDs();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167852);
      return;
    }
  }
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204415);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204415);
      return;
    }
  }
  
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167853);
      return;
    }
  }
  
  public static void F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167854);
      return;
    }
  }
  
  public static void G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167855);
    d.g.b.p.h(paramContext, "context");
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderAlbumUI.class);
    b localb = b.sxa;
    if (!b.cGa()) {
      paramIntent.putExtra("key_can_select_video_and_pic", true);
    }
    paramIntent.putExtra("is_hide_album_footer", true);
    paramIntent.putExtra("show_header_view", false);
    paramIntent.putExtra("max_select_count", 9);
    paramIntent.putExtra("query_source_type", 25);
    paramIntent.putExtra("query_media_type", 3);
    localb = b.sxa;
    paramIntent.putExtra("album_video_max_duration", b.cEZ());
    localb = b.sxa;
    paramIntent.putExtra("album_video_min_duration", b.cEY().minDuration);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167855);
  }
  
  public static void H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    d.g.b.p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167860);
      return;
    }
  }
  
  public static void I(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    d.g.b.p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderModifyNameUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167862);
  }
  
  public static void J(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167870);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderTopicFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167870);
      return;
    }
  }
  
  public static void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderTopicTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167871);
      return;
    }
  }
  
  public static void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204420);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204420);
      return;
    }
  }
  
  public static void M(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204422);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204422);
      return;
    }
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204423);
    d.g.b.p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, 501);
      AppMethodBeat.o(204423);
      return;
    }
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(204423);
  }
  
  public static void O(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204424);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204424);
      return;
    }
  }
  
  public static void P(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204425);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderLikedFeedUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderLikedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204425);
      return;
    }
  }
  
  public static void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204426);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderFriendBlackListUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204426);
      return;
    }
  }
  
  public static void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204427);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = paramIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFriendFoldedTimelineUI.class);
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204427);
      return;
    }
  }
  
  public static void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204428);
    d.g.b.p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderNewUIB.class);
    FinderReporterUIC.a locala = FinderReporterUIC.tcM;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedReletedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFeedReletedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(204428);
  }
  
  public static void T(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204429);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204429);
      return;
    }
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204431);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204431);
      return;
    }
  }
  
  public static void V(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204437);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.finder.report.h.soM;
      paramContext = new an();
      paramContext.dg(cf.aCL());
      paramContext.hI(u.aAu());
      paramContext.hJ(((com.tencent.mm.plugin.expt.b.c)g.ab(com.tencent.mm.plugin.expt.b.c.class)).cnc());
      paramContext.aLk();
      com.tencent.mm.plugin.finder.report.h.a((com.tencent.mm.plugin.report.a)paramContext);
      AppMethodBeat.o(204437);
      return;
    }
  }
  
  public static void W(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204444);
    d.g.b.p.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderNewUIC.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNewUIC", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderNewUIC", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(204444);
  }
  
  public static boolean X(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(204407);
    d.g.b.p.h(paramContext, "context");
    boolean bool = a(paramContext, al.a.IHS, paramInt);
    AppMethodBeat.o(204407);
    return bool;
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bve parambve, int paramInt)
  {
    AppMethodBeat.i(204430);
    d.g.b.p.h(paramActivity, "context");
    d.g.b.p.h(paramViewInfo, "viewInfo");
    d.g.b.p.h(parambve, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", parambve.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambve.mediaList.size());
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(204430);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bve parambve, aqb paramaqb)
  {
    AppMethodBeat.i(167858);
    d.g.b.p.h(paramActivity, "context");
    d.g.b.p.h(paramViewInfo, "viewInfo");
    d.g.b.p.h(parambve, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderMediaPreviewUI.class);
    localIntent.putExtra("media_list_", parambve.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambve.mediaList.size());
    if (paramaqb != null) {}
    for (paramViewInfo = paramaqb.toByteArray();; paramViewInfo = null)
    {
      localIntent.putExtra("ref_feed_info", paramViewInfo);
      paramViewInfo = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramViewInfo.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramViewInfo.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(167858);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(204416);
    d.g.b.p.h(paramActivity, "context");
    d.g.b.p.h(paramString, "rawPath");
    d.g.b.p.h(paramMatrix, "matrix");
    d.g.b.p.h(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.aby();
    locala.abx();
    locala.cP(false);
    locala.abz();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if (paramInt == 2)
    {
      paramString = RecordConfigProvider.as(paramString, "", "");
      paramString.scene = 11;
      paramString.xyk = locala.abA();
      paramRect = b.sxa;
      paramString.xyj = b.cEY();
      paramString.remuxType = 2;
      paramString.xym = 3;
      paramString.xyt = (paramString.xyj.duration * 1000);
      locala.cO(false);
      paramString.ime = paramMatrix;
      paramString.D(2, FinderVideoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 2, 0);
      AppMethodBeat.o(204416);
      return;
    }
    if (paramInt == 1)
    {
      locala.abw();
      paramString = RecordConfigProvider.iI(paramString, "");
      paramString.scene = 11;
      paramString.xyk = locala.abA();
      paramString.ime = paramMatrix;
      paramString.D(1, FinderPhotoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 1, 1);
    }
    AppMethodBeat.o(204416);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167836);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FROM_SCENE_KEY", paramInt);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    localIntent.setClass(paramContext, FinderHomeUI.class);
    paramIntent = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.cDs();
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167836);
  }
  
  public static void a(Context paramContext, amu paramamu, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.stT;
    com.tencent.mm.plugin.finder.search.h.a(paramamu);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramamu = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramamu.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramamu.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167847);
  }
  
  public static void a(final Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, final aqy paramaqy)
  {
    AppMethodBeat.i(204443);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString1, "sessionId");
    d.g.b.p.h(paramString2, "username");
    final y.f localf = new y.f();
    localf.MLV = null;
    com.tencent.e.i.d locald = com.tencent.e.h.LTJ.q((Runnable)new b(localf, paramContext), 1500L);
    ((com.tencent.mm.plugin.i.a.p)g.ab(com.tencent.mm.plugin.i.a.p.class)).a(paramString1, paramString2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), (p.a)new a(locald, localf, paramContext, paramaqy));
    AppMethodBeat.o(204443);
  }
  
  public static void a(final Context paramContext, String paramString1, String paramString2, final aqy paramaqy)
  {
    AppMethodBeat.i(204442);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString1, "sessionId");
    d.g.b.p.h(paramString2, "fansId");
    final y.f localf = new y.f();
    localf.MLV = null;
    com.tencent.e.i.d locald = com.tencent.e.h.LTJ.q((Runnable)new d(localf, paramContext), 1500L);
    ((com.tencent.mm.plugin.i.a.p)g.ab(com.tencent.mm.plugin.i.a.p.class)).a(paramString1, paramString2, (p.a)new c(locald, localf, paramContext, paramaqy));
    AppMethodBeat.o(204442);
  }
  
  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(167842);
    d.g.b.p.h(paramIntent1, "intent");
    d.g.b.p.h(paramIntent2, "curIntent");
    paramIntent1.putExtra("key_finder_post_from", paramIntent2.getIntExtra("key_finder_post_from", -1));
    AppMethodBeat.o(167842);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204412);
    d.g.b.p.h(paramMMActivity, "activity");
    d.g.b.p.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.stT;
    com.tencent.mm.plugin.finder.search.h.a(null);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(204412);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167869);
    d.g.b.p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectSexUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(167869);
  }
  
  /* Error */
  private static boolean a(Context paramContext, al.a parama, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 798
    //   3: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 802	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 804
    //   14: invokestatic 807	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: invokevirtual 813	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   21: aload_1
    //   22: ldc 207
    //   24: invokevirtual 819	com/tencent/mm/storage/ai:get	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: invokevirtual 822	java/lang/Object:toString	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: invokestatic 828	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   35: ifne +157 -> 192
    //   38: aload_3
    //   39: invokestatic 834	com/tencent/d/f/e:aZn	(Ljava/lang/String;)[B
    //   42: astore_3
    //   43: invokestatic 840	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   46: astore 4
    //   48: aload 4
    //   50: aload_3
    //   51: iconst_0
    //   52: aload_3
    //   53: arraylength
    //   54: invokevirtual 844	android/os/Parcel:unmarshall	([BII)V
    //   57: aload 4
    //   59: iconst_0
    //   60: invokevirtual 847	android/os/Parcel:setDataPosition	(I)V
    //   63: getstatic 851	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   66: aload 4
    //   68: invokeinterface 857 2 0
    //   73: checkcast 236	android/content/Intent
    //   76: astore_3
    //   77: aload_3
    //   78: getstatic 862	com/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable:CREATOR	Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$a;
    //   81: invokevirtual 866	java/lang/Object:getClass	()Ljava/lang/Class;
    //   84: invokevirtual 870	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   87: invokevirtual 874	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   90: aload_3
    //   91: ldc_w 779
    //   94: iload_2
    //   95: invokevirtual 347	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   98: pop
    //   99: aload_3
    //   100: ldc_w 876
    //   103: invokevirtual 879	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 828	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   109: ifne +37 -> 146
    //   112: aload_0
    //   113: aload_3
    //   114: invokestatic 881	com/tencent/mm/plugin/finder/utils/a:B	(Landroid/content/Context;Landroid/content/Intent;)V
    //   117: invokestatic 802	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   120: astore_0
    //   121: aload_0
    //   122: ldc_w 804
    //   125: invokestatic 807	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   128: aload_0
    //   129: invokevirtual 813	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   132: aload_1
    //   133: ldc 207
    //   135: invokevirtual 885	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   138: ldc_w 798
    //   141: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_1
    //   145: ireturn
    //   146: aload_0
    //   147: aload_3
    //   148: invokestatic 887	com/tencent/mm/plugin/finder/utils/a:enterFinderPostUI	(Landroid/content/Context;Landroid/content/Intent;)V
    //   151: goto -34 -> 117
    //   154: astore_0
    //   155: ldc_w 889
    //   158: ldc_w 891
    //   161: aload_0
    //   162: invokestatic 896	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokevirtual 899	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokestatic 905	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: invokestatic 802	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   174: astore_0
    //   175: aload_0
    //   176: ldc_w 804
    //   179: invokestatic 807	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   182: aload_0
    //   183: invokevirtual 813	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   186: aload_1
    //   187: ldc 207
    //   189: invokevirtual 885	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   192: ldc_w 798
    //   195: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: invokestatic 802	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
    //   204: astore_3
    //   205: aload_3
    //   206: ldc_w 804
    //   209: invokestatic 807	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   212: aload_3
    //   213: invokevirtual 813	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
    //   216: aload_1
    //   217: ldc 207
    //   219: invokevirtual 885	com/tencent/mm/storage/ai:set	(Lcom/tencent/mm/storage/al$a;Ljava/lang/Object;)V
    //   222: ldc_w 798
    //   225: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_0
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramContext	Context
    //   0	230	1	parama	al.a
    //   0	230	2	paramInt	int
    //   9	204	3	localObject	Object
    //   46	21	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   38	117	154	java/lang/Exception
    //   146	151	154	java/lang/Exception
    //   38	117	200	finally
    //   146	151	200	finally
    //   155	171	200	finally
  }
  
  public static void aq(final Context paramContext, String paramString)
  {
    AppMethodBeat.i(204441);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "username");
    ad.i("Finder.ActivityRouter", "[startChattingUI] username=" + paramString + " scene=2");
    final y.f localf = new y.f();
    localf.MLV = null;
    final com.tencent.e.i.d locald = com.tencent.e.h.LTJ.q((Runnable)new f(localf, paramContext), 1500L);
    ((com.tencent.mm.plugin.i.a.p)g.ab(com.tencent.mm.plugin.i.a.p.class)).a(paramString, (p.a)new e(paramString, locald, localf, paramContext));
    AppMethodBeat.o(204441);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204419);
    d.g.b.p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderFavTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.tcM;
    FinderReporterUIC.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
    paramActivity.startActivityForResult(paramIntent, 10001);
    AppMethodBeat.o(204419);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167863);
    d.g.b.p.h(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    localIntent.putExtra("key_result_file_name", "finder_avatar.tmp");
    localIntent.putExtra("key_crop_source", 1);
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(167863);
  }
  
  public static void b(Context paramContext, amu paramamu, Intent paramIntent)
  {
    AppMethodBeat.i(204413);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.stT;
    com.tencent.mm.plugin.finder.search.h.a(paramamu);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramamu = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramamu.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramamu.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(204413);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204434);
    d.g.b.p.h(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(204434);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(178455);
    d.g.b.p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, OccupyFinderUI1.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(178455);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204421);
    d.g.b.p.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    paramActivity.startActivityForResult(paramIntent, 501);
    AppMethodBeat.o(204421);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    d.g.b.p.h(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (bt.isNullOrNil(paramString))
    {
      paramString = paramActivity.getComponentName();
      d.g.b.p.g(paramString, "context.componentName");
      str = paramString.getClassName();
      paramString = aj.getPackageName() + ".plugin.finder";
      d.g.b.p.g(str, "fullActivityName");
      if (!n.nz(str, paramString)) {
        break label183;
      }
      paramString = str.substring(paramString.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      ad.i("Finder.ActivityRouter", "fullActivity " + str + ", fromActivity " + paramString);
      localBundle.putString("realname_verify_process_jump_activity", paramString);
      for (;;)
      {
        localBundle.putString("realname_verify_process_jump_plugin", "finder");
        ((com.tencent.mm.plugin.wxpaysdk.api.c)g.ab(com.tencent.mm.plugin.wxpaysdk.api.c.class)).g(paramActivity, localBundle);
        AppMethodBeat.o(167864);
        return;
        localBundle.putString("realname_verify_process_jump_activity", paramString);
      }
      label183:
      paramString = str;
    }
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(204435);
    d.g.b.p.h(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderCommentUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 500);
    paramMMActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(204435);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(204418);
    d.g.b.p.h(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderFavFeedUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(204418);
  }
  
  public static void d(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(204436);
    d.g.b.p.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(204436);
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    d.g.b.p.h(paramString, "username");
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void eP(Context paramContext)
  {
    AppMethodBeat.i(167845);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderSettingInfoUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167845);
      return;
    }
  }
  
  public static void eQ(Context paramContext)
  {
    AppMethodBeat.i(167859);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localObject = FinderReporterUIC.tcM;
      FinderReporterUIC.a.a(paramContext, localIntent, 0L, 0, false, 124);
      localIntent.setClass(paramContext, FinderWxMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167859);
      return;
    }
  }
  
  public static void eR(Context paramContext)
  {
    AppMethodBeat.i(167861);
    d.g.b.p.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void eS(Context paramContext)
  {
    AppMethodBeat.i(167866);
    d.g.b.p.h(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
  }
  
  public static void eT(Context paramContext)
  {
    AppMethodBeat.i(204432);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderFinderSysMsgUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204432);
      return;
    }
  }
  
  public static void eU(Context paramContext)
  {
    AppMethodBeat.i(204433);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {}
    for (Object localObject = localIntent;; localObject = null)
    {
      if (localObject != null) {
        ((Intent)localObject).addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderFansListUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204433);
      return;
    }
  }
  
  public static void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167841);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderPostRouterUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772108, 2130771986);
      }
      AppMethodBeat.o(167841);
      return;
    }
  }
  
  public static void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167840);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderPostUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167840);
      return;
    }
  }
  
  public static void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167843);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderProfileUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167843);
      return;
    }
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.addFlags(67108864);
      paramIntent.setClass(paramContext, FinderCreateContactUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167838);
      return;
    }
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167844);
    d.g.b.p.h(paramContext, "context");
    if (!(paramContext instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass(paramContext, FinderProfileTimeLineUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(167844);
      return;
    }
  }
  
  public static void y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204410);
    d.g.b.p.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderSelfUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(204410);
      return;
    }
  }
  
  public static void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204411);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.stT;
    com.tencent.mm.plugin.finder.search.h.a(null);
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(204411);
  }
  
  public static void z(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString1, "appId");
    d.g.b.p.h(paramString2, "enterPath");
    f localf = new f();
    localf.username = paramString1;
    localf.jCN = bt.bI(paramString2, "");
    localf.scene = 1201;
    ((o)g.ab(o.class)).a(paramContext, localf);
    AppMethodBeat.o(167868);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class a
    implements p.a
  {
    a(com.tencent.e.i.d paramd, y.f paramf, Context paramContext, aqy paramaqy) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(204396);
      com.tencent.mm.ad.c.g((d.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(204396);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y.f paramf, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(204398);
      this.sKF.MLV = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), false, 0, (DialogInterface.OnCancelListener)1.sKJ);
      AppMethodBeat.o(204398);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class c
    implements p.a
  {
    c(com.tencent.e.i.d paramd, y.f paramf, Context paramContext, aqy paramaqy) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(204400);
      com.tencent.mm.ad.c.g((d.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(204400);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(y.f paramf, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(204402);
      this.sKF.MLV = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), false, 0, (DialogInterface.OnCancelListener)1.sKL);
      AppMethodBeat.o(204402);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "sessionId", "", "kotlin.jvm.PlatformType", "errType", "", "errCode", "errMsg", "onDone"})
  static final class e
    implements p.a
  {
    e(String paramString, com.tencent.e.i.d paramd, y.f paramf, Context paramContext) {}
    
    public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
    {
      AppMethodBeat.i(204404);
      ad.i("Finder.ActivityRouter", "[enterChattingUI] ]username=" + this.gRf + " sessionId=" + paramString1);
      com.tencent.mm.ad.c.g((d.g.a.a)new q(paramInt1) {});
      AppMethodBeat.o(204404);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(y.f paramf, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(204406);
      this.sKF.MLV = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), false, 0, (DialogInterface.OnCancelListener)1.sKN);
      AppMethodBeat.o(204406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */