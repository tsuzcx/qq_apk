package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.a.f;
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
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.vlog.ui.VLogPreviewPluginLayout;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "", "()V", "TAG", "", "enterAtMyTimelineUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterAuthInfoWeApp", "appId", "enterPath", "enterCropAvatarUI", "Landroid/app/Activity;", "rc", "", "enterFavFeedUI", "enterFavTimelineUI", "enterFinderCommentUI", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "activity", "enterFinderContactSearchUI", "enterFinderCreateContactUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderMsgUI", "enterFinderFinderSysMsgUI", "enterFinderImagePreviewUI", "enterFinderMediaEditUI", "rawPath", "type", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderPostAlbumUI", "enterFinderPostRouterUI", "intent", "enterFinderPostUI", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderTimelineUI", "scene", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFriendBlackListUI", "enterFriendContactUI", "username", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "feedId", "", "totalCount", "isPosterView", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterModifyNameUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPostAtUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectCoverUI", "reqCode", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "fillPostFromRoute", "curIntent", "goDraft", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "routeFrom", "openImagePreviewGallery", "path", "args", "", "tryGoPlainTextPostUIIfDraftExist", "tryGoPostUIIfDraftExist", "plugin-finder_release"})
public final class a
{
  public static final a rOv;
  
  static
  {
    AppMethodBeat.i(167872);
    rOv = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167851);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.setClass(paramContext, FinderEditTextUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167851);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderShareFeedRelUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167852);
  }
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203560);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203560);
  }
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167853);
  }
  
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167854);
  }
  
  public static void F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167855);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderAlbumUI.class);
    b localb = b.rCU;
    if (!b.czf()) {
      paramIntent.putExtra("key_can_select_video_and_pic", true);
    }
    paramIntent.putExtra("is_hide_album_footer", true);
    paramIntent.putExtra("show_header_view", false);
    paramIntent.putExtra("max_select_count", 9);
    paramIntent.putExtra("query_source_type", 25);
    paramIntent.putExtra("query_media_type", 3);
    localb = b.rCU;
    paramIntent.putExtra("album_video_max_duration", b.cya());
    localb = b.rCU;
    paramIntent.putExtra("album_video_min_duration", b.cxZ().minDuration);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167855);
  }
  
  public static void G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    k.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167860);
  }
  
  public static void H(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderModifyNameUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167862);
  }
  
  public static void I(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167870);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderTopicFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167870);
  }
  
  public static void J(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderTopicTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167871);
  }
  
  public static void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203563);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFavFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203563);
  }
  
  public static void L(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203564);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFavTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203564);
  }
  
  public static void M(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203565);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203565);
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203567);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203567);
  }
  
  public static void O(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203568);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203568);
  }
  
  public static void P(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203569);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203569);
  }
  
  public static void Q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203570);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderFriendBlackListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203570);
  }
  
  public static void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203571);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFriendFoldedTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203571);
  }
  
  public static void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203572);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203572);
  }
  
  public static void T(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203574);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203574);
  }
  
  public static void U(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203580);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext = com.tencent.mm.plugin.finder.report.d.rxr;
    paramContext = new af();
    paramContext.cL(ce.azI());
    paramContext.gy(u.axE());
    paramContext.gz(((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit());
    paramContext.aHZ();
    com.tencent.mm.plugin.finder.report.d.a((com.tencent.mm.plugin.report.a)paramContext);
    AppMethodBeat.o(203580);
  }
  
  public static boolean W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(203552);
    k.h(paramContext, "context");
    boolean bool = a(paramContext, ah.a.GVk, paramInt);
    AppMethodBeat.o(203552);
    return bool;
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bqr parambqr, int paramInt)
  {
    AppMethodBeat.i(203573);
    k.h(paramActivity, "context");
    k.h(paramViewInfo, "viewInfo");
    k.h(parambqr, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", parambqr.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambqr.mediaList.size());
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(203573);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bqr parambqr, amq paramamq)
  {
    AppMethodBeat.i(167858);
    k.h(paramActivity, "context");
    k.h(paramViewInfo, "viewInfo");
    k.h(parambqr, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderMediaPreviewUI.class);
    localIntent.putExtra("media_list_", parambqr.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambqr.mediaList.size());
    if (paramamq != null) {}
    for (paramViewInfo = paramamq.toByteArray();; paramViewInfo = null)
    {
      localIntent.putExtra("ref_feed_info", paramViewInfo);
      paramViewInfo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramViewInfo.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramViewInfo.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(167858);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(203561);
    k.h(paramActivity, "context");
    k.h(paramString, "rawPath");
    k.h(paramMatrix, "matrix");
    k.h(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.YX();
    locala.YW();
    locala.cN(false);
    locala.YY();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if ((paramBoolean) || (paramInt == 2))
    {
      paramString = RecordConfigProvider.ak(paramString, "", "");
      paramString.scene = 11;
      paramString.wqu = locala.Za();
      paramRect = b.rCU;
      paramString.wqt = b.cxZ();
      paramString.remuxType = 2;
      paramString.wqw = 3;
      paramString.wqC = (paramString.wqt.duration * 1000);
      locala.cM(false);
      paramString.hSN = paramMatrix;
      if (paramBoolean)
      {
        paramString.D(3, VLogPreviewPluginLayout.class.getName());
        paramString.D(4, VLogPreviewPluginLayout.class.getName());
        paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
        com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 4, 0);
        AppMethodBeat.o(203561);
        return;
      }
      paramString.D(2, FinderVideoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 2, 0);
      AppMethodBeat.o(203561);
      return;
    }
    if (paramInt == 1)
    {
      locala.YV();
      paramString = RecordConfigProvider.iv(paramString, "");
      paramString.scene = 11;
      paramString.wqu = locala.Za();
      paramString.hSN = paramMatrix;
      paramString.D(1, FinderPhotoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.wqR;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 1, 1);
    }
    AppMethodBeat.o(203561);
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167836);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FROM_SCENE_KEY", paramInt);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    localIntent.setClass(paramContext, FinderHomeUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167836);
  }
  
  public static void a(Context paramContext, ajw paramajw, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.rBC;
    com.tencent.mm.plugin.finder.search.h.a(paramajw);
    e.wTc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramajw = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramajw.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramajw.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167847);
  }
  
  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(167842);
    k.h(paramIntent1, "intent");
    k.h(paramIntent2, "curIntent");
    paramIntent1.putExtra("key_finder_post_from", paramIntent2.getIntExtra("key_finder_post_from", -1));
    AppMethodBeat.o(167842);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(203557);
    k.h(paramMMActivity, "activity");
    k.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.rBC;
    com.tencent.mm.plugin.finder.search.h.a(null);
    e.wTc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(203557);
  }
  
  public static void a(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167869);
    k.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderSelectSexUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(167869);
  }
  
  /* Error */
  private static boolean a(Context paramContext, ah.a parama, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 661
    //   3: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 665	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 667
    //   14: invokestatic 670	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: invokevirtual 676	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   21: aload_1
    //   22: ldc_w 526
    //   25: invokevirtual 682	com/tencent/mm/storage/ae:get	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 685	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 691	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   36: ifne +159 -> 195
    //   39: aload_3
    //   40: invokestatic 697	com/tencent/d/f/e:aTn	(Ljava/lang/String;)[B
    //   43: astore_3
    //   44: invokestatic 703	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   47: astore 4
    //   49: aload 4
    //   51: aload_3
    //   52: iconst_0
    //   53: aload_3
    //   54: arraylength
    //   55: invokevirtual 707	android/os/Parcel:unmarshall	([BII)V
    //   58: aload 4
    //   60: iconst_0
    //   61: invokevirtual 710	android/os/Parcel:setDataPosition	(I)V
    //   64: getstatic 714	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   67: aload 4
    //   69: invokeinterface 720 2 0
    //   74: checkcast 152	android/content/Intent
    //   77: astore_3
    //   78: aload_3
    //   79: getstatic 725	com/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable:CREATOR	Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$a;
    //   82: invokevirtual 729	java/lang/Object:getClass	()Ljava/lang/Class;
    //   85: invokevirtual 733	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   88: invokevirtual 737	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   91: aload_3
    //   92: ldc_w 642
    //   95: iload_2
    //   96: invokevirtual 252	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   99: pop
    //   100: aload_3
    //   101: ldc_w 739
    //   104: invokevirtual 743	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 691	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   110: ifne +38 -> 148
    //   113: aload_0
    //   114: aload_3
    //   115: invokestatic 745	com/tencent/mm/plugin/finder/utils/a:A	(Landroid/content/Context;Landroid/content/Intent;)V
    //   118: invokestatic 665	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   121: astore_0
    //   122: aload_0
    //   123: ldc_w 667
    //   126: invokestatic 670	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload_0
    //   130: invokevirtual 676	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   133: aload_1
    //   134: ldc_w 526
    //   137: invokevirtual 749	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   140: ldc_w 661
    //   143: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: aload_0
    //   149: aload_3
    //   150: invokestatic 751	com/tencent/mm/plugin/finder/utils/a:enterFinderPostUI	(Landroid/content/Context;Landroid/content/Intent;)V
    //   153: goto -35 -> 118
    //   156: astore_0
    //   157: ldc_w 753
    //   160: ldc_w 755
    //   163: aload_0
    //   164: invokestatic 761	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 764	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokestatic 770	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: invokestatic 665	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   176: astore_0
    //   177: aload_0
    //   178: ldc_w 667
    //   181: invokestatic 670	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 676	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   188: aload_1
    //   189: ldc_w 526
    //   192: invokevirtual 749	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   195: ldc_w 661
    //   198: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: invokestatic 665	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   207: astore_3
    //   208: aload_3
    //   209: ldc_w 667
    //   212: invokestatic 670	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   215: aload_3
    //   216: invokevirtual 676	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   219: aload_1
    //   220: ldc_w 526
    //   223: invokevirtual 749	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   226: ldc_w 661
    //   229: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_0
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	parama	ah.a
    //   0	234	2	paramInt	int
    //   9	207	3	localObject	Object
    //   47	21	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   39	118	156	java/lang/Exception
    //   148	153	156	java/lang/Exception
    //   39	118	203	finally
    //   148	153	203	finally
    //   157	173	203	finally
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(203566);
    k.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    paramActivity.startActivityForResult(paramIntent, 501);
    AppMethodBeat.o(203566);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(167863);
    k.h(paramActivity, "context");
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
  
  public static void b(Context paramContext, ajw paramajw, Intent paramIntent)
  {
    AppMethodBeat.i(203558);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.rBC;
    com.tencent.mm.plugin.finder.search.h.a(paramajw);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramajw = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramajw.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramajw.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    e.wTc.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(203558);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(203577);
    k.h(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(203577);
      return;
    }
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(178455);
    k.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, OccupyFinderUI1.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(178455);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    k.h(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (bs.isNullOrNil(paramString))
    {
      paramString = paramActivity.getComponentName();
      k.g(paramString, "context.componentName");
      str = paramString.getClassName();
      paramString = ai.getPackageName() + ".plugin.finder";
      k.g(str, "fullActivityName");
      if (!d.n.n.nb(str, paramString)) {
        break label183;
      }
      paramString = str.substring(paramString.length());
      k.g(paramString, "(this as java.lang.String).substring(startIndex)");
    }
    for (;;)
    {
      ac.i("Finder.ActivityRouter", "fullActivity " + str + ", fromActivity " + paramString);
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
    AppMethodBeat.i(203578);
    k.h(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderCommentUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 500);
    paramMMActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(203578);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(203579);
    k.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(203579);
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    k.h(paramString, "username");
    k.h(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void eP(Context paramContext)
  {
    AppMethodBeat.i(167845);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setClass(paramContext, FinderSettingInfoUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167845);
  }
  
  public static void eQ(Context paramContext)
  {
    AppMethodBeat.i(167859);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    FinderReporterUIC.a locala = FinderReporterUIC.seQ;
    FinderReporterUIC.a.a(paramContext, (Intent)localObject, 0L, 0, false, 124);
    ((Intent)localObject).setClass(paramContext, FinderWxMsgUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167859);
  }
  
  public static void eR(Context paramContext)
  {
    AppMethodBeat.i(167861);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void eS(Context paramContext)
  {
    AppMethodBeat.i(167866);
    k.h(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
  }
  
  public static void eT(Context paramContext)
  {
    AppMethodBeat.i(203575);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setClass(paramContext, FinderFinderSysMsgUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203575);
  }
  
  public static void eU(Context paramContext)
  {
    AppMethodBeat.i(203576);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(paramContext, FinderFansListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203576);
  }
  
  public static void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167840);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.setClass(paramContext, FinderPostUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167840);
  }
  
  public static void enterFinderProfileUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167843);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderProfileUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167843);
  }
  
  public static void u(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderCreateContactUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167838);
  }
  
  public static void v(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167841);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderPostRouterUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(2130772108, 2130771986);
    }
    AppMethodBeat.o(167841);
  }
  
  public static void w(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167844);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderProfileTimeLineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167844);
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203555);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.setClass(paramContext, FinderSelfUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203555);
  }
  
  public static void y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203556);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    com.tencent.mm.plugin.finder.search.h localh = com.tencent.mm.plugin.finder.search.h.rBC;
    com.tencent.mm.plugin.finder.search.h.a(null);
    e.wTc.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203556);
  }
  
  public static void y(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "enterPath");
    f localf = new f();
    localf.username = paramString1;
    localf.jjf = bs.bG(paramString2, "");
    localf.scene = 1201;
    ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramContext, localf);
    AppMethodBeat.o(167868);
  }
  
  public static void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203559);
    k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.spam.a locala = com.tencent.mm.plugin.finder.spam.a.rBD;
    if (com.tencent.mm.plugin.finder.spam.a.aeb("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.spam.a.rBD;
      com.tencent.mm.ui.base.h.a(paramContext, com.tencent.mm.plugin.finder.spam.a.aec("search"), "", paramContext.getString(2131766205), null);
      AppMethodBeat.o(203559);
      return;
    }
    e.wTc.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(203559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */