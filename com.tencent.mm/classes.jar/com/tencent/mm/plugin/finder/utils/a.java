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
import com.tencent.mm.bs.d;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.b.a.hi;
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
import com.tencent.mm.plugin.finder.search.i;
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
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/ActivityRouter;", "", "()V", "TAG", "", "enterAtMyTimelineUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterAuthInfoWeApp", "appId", "enterPath", "enterCropAvatarUI", "Landroid/app/Activity;", "rc", "", "enterFavFeedUI", "enterFavTimelineUI", "enterFinderCommentUI", "Lcom/tencent/mm/ui/MMActivity;", "requestCode", "enterFinderContactSearchIncludeFollowUI", "finderDataCache", "Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;", "enterFinderContactSearchIncludeFollowUIForResult", "activity", "enterFinderContactSearchUI", "enterFinderCreateContactUI", "enterFinderEditTextUI", "enterFinderFansListUI", "enterFinderFeedLbsUI", "enterFinderFeedRelUI", "enterFinderFeedSearchUI", "enterFinderFinderMsgUI", "enterFinderFinderSysMsgUI", "enterFinderImagePreviewUI", "enterFinderMediaEditUI", "rawPath", "type", "matrix", "Landroid/graphics/Matrix;", "cropRect", "Landroid/graphics/Rect;", "offset", "", "isVlogMode", "", "enterFinderMediaPreviewUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "enterFinderMixSearchUI", "enterFinderMsgFeedDetailUI", "enterFinderPostAlbumUI", "enterFinderPostRouterUI", "intent", "enterFinderPostUI", "enterFinderProfileTimelineUI", "enterFinderProfileUI", "enterFinderRetransmitSourceUI", "enterFinderSelfUI", "enterFinderSettingInfoUI", "enterFinderShareFeedDetailUI", "enterFinderShareFeedDetailUI2", "enterFinderTimelineUI", "scene", "enterFinderWxMsgUI", "enterFinderWxSettingUI", "enterFriendBlackListUI", "enterFriendContactUI", "username", "enterFriendFoldedTimelineUI", "enterFriendLikeFeedUI", "enterFriendLikeTimelineUI", "enterFriendRecommendUI", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "feedId", "", "totalCount", "isPosterView", "enterLbsStreamFeedUI", "enterLbsStreamListUI", "enterModifyNameUI", "enterOriginalRequestUI", "enterOriginalUI", "enterPostAtUI", "enterRealnameVerifyUI", "fromActivity", "enterRelatedFeedUI", "enterRelatedTimelineUI", "enterSelectCoverUI", "reqCode", "enterSelectDistrictUI", "enterSelectSexUI", "enterSelfQRCodeUI", "enterTopicFeedUI", "enterTopicTimelineUI", "enterUnOpenUI", "fillPostFromRoute", "curIntent", "goDraft", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "routeFrom", "openImagePreviewGallery", "path", "args", "", "tryGoPlainTextPostUIIfDraftExist", "tryGoPostUIIfDraftExist", "plugin-finder_release"})
public final class a
{
  public static final a qSb;
  
  static
  {
    AppMethodBeat.i(167872);
    qSb = new a();
    AppMethodBeat.o(167872);
  }
  
  public static void A(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167853);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRetransmitSourceUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderRetransmitSourceUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167853);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167854);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderMsgFeedDetailUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMsgFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167854);
  }
  
  public static void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167855);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderAlbumUI.class);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUf()) {
      paramIntent.putExtra("key_can_select_video_and_pic", true);
    }
    paramIntent.putExtra("is_hide_album_footer", true);
    paramIntent.putExtra("show_header_view", false);
    paramIntent.putExtra("max_select_count", 9);
    paramIntent.putExtra("query_source_type", 25);
    paramIntent.putExtra("query_media_type", 3);
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    paramIntent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.b.coD());
    localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    paramIntent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.b.coC().minDuration);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167855);
  }
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167860);
    k.h(paramContext, "context");
    paramIntent.setClass(paramContext, FinderImagePreviewUI.class);
    paramIntent.addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderImagePreviewUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167860);
  }
  
  public static void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167862);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderModifyNameUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterModifyNameUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167862);
  }
  
  public static void F(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167870);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderTopicFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167870);
  }
  
  public static void G(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167871);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderTopicTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterTopicTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167871);
  }
  
  public static void Y(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199580);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    i locali = i.qIB;
    i.a(null);
    e.vIY.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchIncludeFollowUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchIncludeFollowUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199580);
  }
  
  public static void Z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199583);
    k.h(paramContext, "context");
    com.tencent.mm.plugin.finder.spam.a locala = com.tencent.mm.plugin.finder.spam.a.qIC;
    if (com.tencent.mm.plugin.finder.spam.a.Zt("search") != 0)
    {
      paramIntent = com.tencent.mm.plugin.finder.spam.a.qIC;
      h.a(paramContext, com.tencent.mm.plugin.finder.spam.a.Zu("search"), "", paramContext.getString(2131766205), null);
      AppMethodBeat.o(199583);
      return;
    }
    e.vIY.idkeyStat(1265L, 0L, 1L, false);
    paramIntent.setClass(paramContext, FinderMixSearchUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMixSearchUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199583);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bmc parambmc, int paramInt)
  {
    AppMethodBeat.i(199597);
    k.h(paramActivity, "context");
    k.h(paramViewInfo, "viewInfo");
    k.h(parambmc, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", parambmc.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambmc.mediaList.size());
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(199597);
  }
  
  public static void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, bmc parambmc, akf paramakf)
  {
    AppMethodBeat.i(167858);
    k.h(paramActivity, "context");
    k.h(paramViewInfo, "viewInfo");
    k.h(parambmc, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderMediaPreviewUI.class);
    localIntent.putExtra("media_list_", parambmc.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", parambmc.mediaList.size());
    if (paramakf != null) {}
    for (paramViewInfo = paramakf.toByteArray();; paramViewInfo = null)
    {
      localIntent.putExtra("ref_feed_info", paramViewInfo);
      paramViewInfo = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramViewInfo.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramViewInfo.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderMediaPreviewUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(167858);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Matrix paramMatrix, Rect paramRect, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(199585);
    k.h(paramActivity, "context");
    k.h(paramString, "rawPath");
    k.h(paramMatrix, "matrix");
    k.h(paramRect, "cropRect");
    UICustomParam.a locala = new UICustomParam.a();
    locala.Ya();
    locala.XZ();
    locala.cO(false);
    locala.Yb();
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    paramMatrix = new Bundle();
    paramMatrix.putParcelable("cropRect", (Parcelable)paramRect);
    paramMatrix.putFloatArray("matrix", arrayOfFloat);
    paramMatrix.putFloatArray("offset", paramArrayOfFloat);
    if ((paramBoolean) || (paramInt == 2))
    {
      paramString = RecordConfigProvider.aj(paramString, "", "");
      paramString.scene = 11;
      paramString.vhI = locala.Yd();
      paramRect = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramString.vhH = com.tencent.mm.plugin.finder.storage.b.coC();
      paramString.vhB = 2;
      paramString.vhK = 3;
      paramString.vhQ = (paramString.vhH.duration * 1000);
      locala.cN(false);
      paramString.hsl = paramMatrix;
      if (paramBoolean)
      {
        paramString.bx(3, VLogPreviewPluginLayout.class.getName());
        paramString.bx(4, VLogPreviewPluginLayout.class.getName());
        paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
        com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 4, 0);
        AppMethodBeat.o(199585);
        return;
      }
      paramString.bx(2, FinderVideoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 2, 0);
      AppMethodBeat.o(199585);
      return;
    }
    if (paramInt == 1)
    {
      locala.XY();
      paramString = RecordConfigProvider.ic(paramString, "");
      paramString.scene = 11;
      paramString.vhI = locala.Yd();
      paramString.hsl = paramMatrix;
      paramString.bx(1, FinderPhotoEditPluginLayout.class.getName());
      paramMatrix = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)paramActivity, 1, 2130771986, 2130771986, paramString, 1, 1);
    }
    AppMethodBeat.o(199585);
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167836);
  }
  
  public static void a(Context paramContext, aik paramaik, Intent paramIntent)
  {
    AppMethodBeat.i(167847);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    i locali = i.qIB;
    i.a(paramaik);
    e.vIY.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass(paramContext, FinderContactSearchUI.class);
    paramaik = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramaik.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderContactSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaik.lS(0));
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
    AppMethodBeat.i(199581);
    k.h(paramMMActivity, "activity");
    k.h(paramIntent, "i");
    i locali = i.qIB;
    i.a(null);
    e.vIY.idkeyStat(1265L, 2L, 1L, false);
    paramIntent.setClass((Context)paramMMActivity, FinderContactSearchIncludeFollowUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 20000);
    AppMethodBeat.o(199581);
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
  private static boolean a(Context paramContext, ae.a parama, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 555
    //   3: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 561	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 563
    //   14: invokestatic 566	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: invokevirtual 572	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   21: aload_1
    //   22: ldc_w 330
    //   25: invokevirtual 578	com/tencent/mm/storage/ab:get	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 581	java/lang/Object:toString	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: invokestatic 587	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   36: ifne +159 -> 195
    //   39: aload_3
    //   40: invokestatic 593	com/tencent/d/f/e:aNK	(Ljava/lang/String;)[B
    //   43: astore_3
    //   44: invokestatic 599	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   47: astore 4
    //   49: aload 4
    //   51: aload_3
    //   52: iconst_0
    //   53: aload_3
    //   54: arraylength
    //   55: invokevirtual 603	android/os/Parcel:unmarshall	([BII)V
    //   58: aload 4
    //   60: iconst_0
    //   61: invokevirtual 606	android/os/Parcel:setDataPosition	(I)V
    //   64: getstatic 610	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   67: aload 4
    //   69: invokeinterface 616 2 0
    //   74: checkcast 153	android/content/Intent
    //   77: astore_3
    //   78: aload_3
    //   79: getstatic 621	com/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable:CREATOR	Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$a;
    //   82: invokevirtual 625	java/lang/Object:getClass	()Ljava/lang/Class;
    //   85: invokevirtual 629	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   88: invokevirtual 633	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   91: aload_3
    //   92: ldc_w 537
    //   95: iload_2
    //   96: invokevirtual 236	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   99: pop
    //   100: aload_3
    //   101: ldc_w 635
    //   104: invokevirtual 638	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 587	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   110: ifne +38 -> 148
    //   113: aload_0
    //   114: aload_3
    //   115: invokestatic 641	com/tencent/mm/plugin/finder/utils/a:y	(Landroid/content/Context;Landroid/content/Intent;)V
    //   118: invokestatic 561	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   121: astore_0
    //   122: aload_0
    //   123: ldc_w 563
    //   126: invokestatic 566	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   129: aload_0
    //   130: invokevirtual 572	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   133: aload_1
    //   134: ldc_w 330
    //   137: invokevirtual 645	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   140: ldc_w 555
    //   143: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: aload_0
    //   149: aload_3
    //   150: invokestatic 647	com/tencent/mm/plugin/finder/utils/a:enterFinderPostUI	(Landroid/content/Context;Landroid/content/Intent;)V
    //   153: goto -35 -> 118
    //   156: astore_0
    //   157: ldc_w 649
    //   160: ldc_w 651
    //   163: aload_0
    //   164: invokestatic 657	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 660	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokestatic 666	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: invokestatic 561	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   176: astore_0
    //   177: aload_0
    //   178: ldc_w 563
    //   181: invokestatic 566	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   184: aload_0
    //   185: invokevirtual 572	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   188: aload_1
    //   189: ldc_w 330
    //   192: invokevirtual 645	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   195: ldc_w 555
    //   198: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: invokestatic 561	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   207: astore_3
    //   208: aload_3
    //   209: ldc_w 563
    //   212: invokestatic 566	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   215: aload_3
    //   216: invokevirtual 572	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   219: aload_1
    //   220: ldc_w 330
    //   223: invokevirtual 645	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   226: ldc_w 555
    //   229: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_0
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	parama	ae.a
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
  
  public static boolean aT(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(199576);
    k.h(paramContext, "context");
    boolean bool = a(paramContext, ae.a.FwU, paramInt);
    AppMethodBeat.o(199576);
    return bool;
  }
  
  public static void aa(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199584);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderShareFeedDetailUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI2", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199584);
  }
  
  public static void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199587);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFavFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199587);
  }
  
  public static void ac(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199588);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFavTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFavTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199588);
  }
  
  public static void ad(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199589);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderLbsStreamListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterLbsStreamListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199589);
  }
  
  public static void ae(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199591);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRelatedFeedUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedFeedUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199591);
  }
  
  public static void af(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199592);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderRelatedTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterRelatedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199592);
  }
  
  public static void ag(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199593);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFriendLikeTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendLikeTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199593);
  }
  
  public static void ah(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199594);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderFriendBlackListUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendBlackListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199594);
  }
  
  public static void ai(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199595);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFriendFoldedTimelineUI.class);
    FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a(paramContext, paramIntent, 0L, 0, false, 124);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFriendFoldedTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199595);
  }
  
  public static void aj(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199596);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderFeedRelTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedRelUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199596);
  }
  
  public static void ak(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199598);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderFinderMsgUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199598);
  }
  
  public static void al(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199604);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.setClass(paramContext, FinderAtTimelineUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterAtMyTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext = com.tencent.mm.plugin.finder.report.b.qFq;
    paramContext = new hi();
    paramContext.xZ(ce.asR());
    paramContext.VM(u.aqO());
    paramContext.Wa(((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk());
    paramContext.aBj();
    com.tencent.mm.plugin.finder.report.b.a((com.tencent.mm.plugin.report.a)paramContext);
    AppMethodBeat.o(199604);
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
  
  public static void b(Context paramContext, aik paramaik, Intent paramIntent)
  {
    AppMethodBeat.i(199582);
    k.h(paramContext, "context");
    k.h(paramIntent, "i");
    i locali = i.qIB;
    i.a(paramaik);
    paramIntent.setClass(paramContext, FinderFeedSearchUI.class);
    paramaik = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramaik.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramaik.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFeedSearchUI", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderFeedSearchObj;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    e.vIY.idkeyStat(1265L, 1L, 1L, false);
    AppMethodBeat.o(199582);
  }
  
  public static void b(MMActivity paramMMActivity, Intent paramIntent)
  {
    AppMethodBeat.i(199601);
    k.h(paramMMActivity, "context");
    if (!(paramMMActivity instanceof Activity)) {}
    for (Intent localIntent = paramIntent;; localIntent = null)
    {
      if (localIntent != null) {
        localIntent.addFlags(268435456);
      }
      paramIntent.setClass((Context)paramMMActivity, FinderTimelineLbsUI.class);
      paramMMActivity.startActivityForResult(paramIntent, 19999);
      AppMethodBeat.o(199601);
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
  
  public static void c(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(199590);
    k.h(paramActivity, "context");
    paramIntent.setClass((Context)paramActivity, FinderLbsStreamListUI.class);
    paramActivity.startActivityForResult(paramIntent, 501);
    AppMethodBeat.o(199590);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(167864);
    k.h(paramActivity, "context");
    Bundle localBundle = new Bundle();
    String str;
    if (bt.isNullOrNil(paramString))
    {
      paramString = paramActivity.getComponentName();
      k.g(paramString, "context.componentName");
      str = paramString.getClassName();
      paramString = aj.getPackageName() + ".plugin.finder";
      k.g(str, "fullActivityName");
      if (!d.n.n.mA(str, paramString)) {
        break label183;
      }
      paramString = str.substring(paramString.length());
      k.g(paramString, "(this as java.lang.String).substring(startIndex)");
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
    AppMethodBeat.i(199602);
    k.h(paramMMActivity, "context");
    paramIntent.setClass((Context)paramMMActivity, FinderCommentUI.class);
    paramMMActivity.startActivityForResult(paramIntent, 500);
    paramMMActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(199602);
  }
  
  public static void c(MMActivity paramMMActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(199603);
    k.h(paramMMActivity, "activity");
    paramIntent.setClass((Context)paramMMActivity, FinderPostAtUI.class);
    paramMMActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(199603);
  }
  
  public static void d(String paramString, Context paramContext)
  {
    AppMethodBeat.i(167867);
    k.h(paramString, "username");
    k.h(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramString);
    d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(167867);
  }
  
  public static void eF(Context paramContext)
  {
    AppMethodBeat.i(167845);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setClass(paramContext, FinderSettingInfoUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSettingInfoUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167845);
  }
  
  public static void eI(Context paramContext)
  {
    AppMethodBeat.i(167859);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
    FinderReporterUIC.a.a(paramContext, (Intent)localObject, 0L, 0, false, 124);
    ((Intent)localObject).setClass(paramContext, FinderWxMsgUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderWxMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167859);
  }
  
  public static void eJ(Context paramContext)
  {
    AppMethodBeat.i(167861);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(paramContext, FinderSelfQRCodeUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterSelfQRCodeUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167861);
  }
  
  public static void eK(Context paramContext)
  {
    AppMethodBeat.i(167866);
    k.h(paramContext, "context");
    Object localObject = new Intent(paramContext, FinderUnOpenUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterUnOpenUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167866);
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167843);
  }
  
  public static void lA(Context paramContext)
  {
    AppMethodBeat.i(199600);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(paramContext, FinderFansListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFansListUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199600);
  }
  
  public static void lz(Context paramContext)
  {
    AppMethodBeat.i(199599);
    k.h(paramContext, "context");
    Object localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).setClass(paramContext, FinderFinderSysMsgUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderFinderSysMsgUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199599);
  }
  
  public static void u(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167838);
    k.h(paramContext, "context");
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    paramIntent.setClass(paramContext, FinderCreateContactUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderCreateContactUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderProfileTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167844);
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199579);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.setClass(paramContext, FinderSelfUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderSelfUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199579);
  }
  
  public static void y(Context paramContext, Intent paramIntent)
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
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderEditTextUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167851);
  }
  
  public static void z(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(167852);
    k.h(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, FinderShareFeedRelUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/utils/ActivityRouter", "enterFinderShareFeedDetailUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(167852);
  }
  
  public static void z(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(167868);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "enterPath");
    f localf = new f();
    localf.username = paramString1;
    localf.iJb = bt.by(paramString2, "");
    localf.scene = 1201;
    ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(paramContext, localf);
    AppMethodBeat.o(167868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.a
 * JD-Core Version:    0.7.0.1
 */