package com.tencent.mm.plugin.ai.data.business.global;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.c.a;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private static e qmz;
  private final String TAG = "AiToolsAndMpData";
  private final String qmA = "CropImageNewUI;MiniQbCallBackUI;MiniQBReaderUI;NfcWebViewUI;WNNoteFavWebViewUI;WNNoteMsgWebViewUI;SnsAdNativeLandingPagesUI;VideoFullScreenActivity;EmojiCaptureUI;StickerPreviewUI;AppBrandNearbyWebViewUI;AppBrandSOSUI;ShortCutPermissionDetailUI;GameWebViewUI;GameTabWebUI;GameTabWebUI1;GameTabWebUI2;LuggageGameWebViewUI;TmplWebViewToolUI;DownloadDetailUI;WebViewUI;CustomSchemeEntryWebViewUI;WebViewTestUI;TransparentWebViewUI;ContactQZoneWebView;QRCodeIntroductionWebViewUI;GameChattingRoomWebViewUI;H5GameWebViewUI;EmojiStoreSearchWebViewUI;ToolsRecordUI;SightCaptureUITest;FaceDetectUI;ReadMailUI;MailWebViewUI;SightCaptureUI;SightSettingsUI;MMSightEditUI;MMNewPhotoEditUI;VideoSegmentUI;VideoCompressUI;";
  private final String qmB = "AppBrandSearchUI;LuggageGameUI;LuggageGameWebViewMpUI;LuggageGameHalfWebViewUI;GameWebTabUI;TmplWebViewTooLMpUI;WebviewMpUI;FTSWebViewUI;FTSSearchTabWebViewUI;FTSSOSHomeWebViewUI;FTSSOSMoreWebViewUI;SosWebViewUI;GameWebViewMpUI;";
  
  public static e can()
  {
    AppMethodBeat.i(267517);
    if (qmz == null) {
      qmz = new e();
    }
    e locale = qmz;
    AppMethodBeat.o(267517);
    return locale;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(267544);
    paramBundle = a.dMp().aaFj;
    if ((paramBundle == null) || (paramBundle.size() == 0))
    {
      AppMethodBeat.o(267544);
      return;
    }
    if (paramActivity.getClass().getName().endsWith(((czu)paramBundle.get(paramBundle.size() - 1)).hJW)) {
      paramBundle.remove(paramBundle.size() - 1);
    }
    if (paramBundle.size() != 0)
    {
      paramBundle = paramBundle.iterator();
      Object localObject;
      int i;
      for (;;)
      {
        if (paramBundle.hasNext())
        {
          localObject = (czu)paramBundle.next();
          if (localObject != null)
          {
            localObject = ((czu)localObject).hJW + ";";
            if ("CropImageNewUI;MiniQbCallBackUI;MiniQBReaderUI;NfcWebViewUI;WNNoteFavWebViewUI;WNNoteMsgWebViewUI;SnsAdNativeLandingPagesUI;VideoFullScreenActivity;EmojiCaptureUI;StickerPreviewUI;AppBrandNearbyWebViewUI;AppBrandSOSUI;ShortCutPermissionDetailUI;GameWebViewUI;GameTabWebUI;GameTabWebUI1;GameTabWebUI2;LuggageGameWebViewUI;TmplWebViewToolUI;DownloadDetailUI;WebViewUI;CustomSchemeEntryWebViewUI;WebViewTestUI;TransparentWebViewUI;ContactQZoneWebView;QRCodeIntroductionWebViewUI;GameChattingRoomWebViewUI;H5GameWebViewUI;EmojiStoreSearchWebViewUI;ToolsRecordUI;SightCaptureUITest;FaceDetectUI;ReadMailUI;MailWebViewUI;SightCaptureUI;SightSettingsUI;MMSightEditUI;MMNewPhotoEditUI;VideoSegmentUI;VideoCompressUI;".contains((CharSequence)localObject)) {
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          paramActivity = paramActivity.getClass().getName().split("\\.");
          if ((paramActivity == null) || (paramActivity.length == 0))
          {
            AppMethodBeat.o(267544);
            return;
            if (!"AppBrandSearchUI;LuggageGameUI;LuggageGameWebViewMpUI;LuggageGameHalfWebViewUI;GameWebTabUI;TmplWebViewTooLMpUI;WebviewMpUI;FTSWebViewUI;FTSSearchTabWebViewUI;FTSSOSHomeWebViewUI;FTSSOSMoreWebViewUI;SosWebViewUI;GameWebViewMpUI;".contains((CharSequence)localObject)) {
              break;
            }
            i = 1;
            continue;
            i = 0;
            continue;
          }
          paramActivity = paramActivity[(paramActivity.length - 1)] + ";";
          paramBundle = MultiProcessMMKV.getDefault().getString("ai_is_tools_or_mp_entry", ";BizTimeLineUI;BaseScanUI;ChattingUI;ReaderAppUI;FTSMainUI;MainUI;MallWalletUI;ImageGalleryUI;UIPageFragmentActivity;FavoriteIndexUI;AppAttachNewDownloadUI;MallIndexUIv2;SnsCommentDetailUI;FloatBall;WalletBalanceManagerUI;TopStoryHomeUI;ContactInfoUI;RecordMsgDetailUI;FindMoreFriendsUI;AppBrandUI;WalletLqtDetailUI;ExtDeviceWXLoginUI;SnsBrowseUI;WXBizEntryActivity;WalletBankcardManageUI;FavoriteTextDetailUI;FTSAddFriendUI;AddMoreFriendsUI;GameCenterUI;SoSoProxyUI;WebSearchImageLoadingUI;CardDetailUI;EnterpriseBizContactListUI;EnterpriseConversationUI;LoginPasswordUI;BrandServiceIndexUI;SingleChatInfoUI;AppBrandUI2;FTSBizDetailUI;WXCustomSchemeEntryActivity;RemittanceDetailUI;WalletPasswordSettingUI;AppBrandUI1;SnsGalleryUI;FavoriteImgDetailUI;PhoneRechargeUI;LoginUI;AppBrandLauncherUI;FavSearchUI;MobileInputUI;VideoActivity;AppBrandLaunchProxyUI;MediaHistoryListUI;AppBrandPluginUI;TextPreviewUI;MallIndexOSUI;AppBrandUI3;SnsUploadUI;FavImgGalleryUI;Settings$AppControlSettingsActivity;ProfileSettingUI;RegByMobileRegAIOUI;ChatroomInfoUI;FavoriteFileDetailUI;NetworkDiagnoseAllInOneUI;EmojiStoreV2UI;LuckyMoneyNotHookReceiveUI;RoomCardUI;RecordMsgFileUI;AppBrandServiceChattingUI;GameMsgCenterUI;RecordMsgImageUI;FavRecordDetailUI;SnsAdNativeLandingPagesPreviewUI;CreateOrJoinChatroomUI;LuckyMoneyPickEnvelopeUI;WebSearchSnsImageLoadingUI;UIEntryStub;AppBrandTaskProxyUI;SnsWsFoldDetailUI;LoginSmsUI;FavFilterUI;SnsSingleTextViewUI;AppAttachDownloadUI;FinderFollowTabFragment;SettingsAboutMicroMsgUI;AppBrandUI4;AppBrandPluginUI2;NewBizConversationUI;MusicMvMainUI;WalletSecuritySettingUI;i;BizTimeLineNewMsgUI;BizChatroomInfoUI;MultiTalkSelectContactUI;SDKOAuthUI;SelectConversationUI;RemittanceBusiResultUI;WebViewStubProxyUI;WXEntryActivity;WalletOfflineCoinPurseUI;GameChatTabUI;CustomSmileyPreviewUI;ShakeReportUI;AppBrandProfileUI;FinderProfileTimeLineUI;GestureGalleryUI;FavSelectUI;WalletLqtSaveFetchUI;FinderFinderSysMsgUI;LoginVoiceUI;WeCoinRechargeView;FinderShareFeedRelUI;WeChatSplashActivity;AddressUIFragment;SimpleLoginUI;AppBrandProcessProxyUI;FaceDetectConfirmUI;WalletBrandUI;FinderFriendTabFragment;MusicMainUI;PermissionActivity;DownloadMainUI;RemittanceUI;MoreTabUI;SettingsModifyAliasCheckUI;EmojiStoreDetailUI;AppBrandTaskProxyUI2;WalletOrderInfoNewUI;WalletBalanceFetchUI;FinderProfileUI;HoneyPayCardManagerUI;LuckyMoneyDetailUI;AppBrandPluginUI3;SettingsAccountInfoUI;WxaLiteAppLiteUI;ExdeviceRankInfoUI;SettingsMoreSafeUI;ShareImgUI;LuckyMoneyPrepareUI;TopStoryTabHomeUI;RequestFloatWindowPermissionDialog;FinderAccountManagent;FileSelectorUI;FinderLiveVisitorWithoutAffinityUI;TaskRedirectUI;HoneyPayMainUI;MainActivity;OrderHandlerUI;OccupyFinderUI8;FinderMachineTabFragment;WebviewScanImageActivity;BankRemitBankcardInputUI;FaceFlashUI;FMessageConversationUI;WalletPayUI;SettingsSwitchAccountUI;FaceAgreementUI;NoteEditorUI;MultiTalkMainUI;FTSEmojiDetailPageUI;LoginByMobileSendSmsUI;AppBrandPluginUI1;BizChatConversationUI;RemittanceOSUI;EmptyActivity;WalletMixOrderInfoUI;SelectContactUI;ContactMoreInfoUI;WebViewDownloadUI;MsgRetransmitUI;AccountExpiredUI;FavMediaGalleryUI;SettingsModifyAliasUI;AppBrandPreLoadingUI;ImagePreviewUI;AppBrandServiceConversationUI;FinderLikedFeedUI;SettingsChattingBackgroundUI;AppBrandTaskProxyUI3;AppBrandTaskProxyUI4;AppBrandTaskProxyUI1;SendAppMessageWrapperUI;MobileLoginOrForceReg;MediaHistoryGalleryUI;BackupChooseBackupModeUI;FingerprintWalletLockUI;MultiTalkAddMembersUI;WXPayEntryActivity;WelabMainUI;QQCallbackUI;FingerPrintAuthUI;FTSDetailUI;AlbumPreviewUI;WalletOpenViewProxyUI;RemittanceBusiUI;CardShopUI;SosSimilarUI;LuckyMoneyBusiDetailUI;WcPayRealnameVerifyIdInputUI;VoiceInputUI;FixToolsUI;BackupPcUI;OpenFileChooserUI;SDKOAuthOtherUI;WebViewStubTempUI;WebWXLogoutUI;FaceFlashActionUI;");
          if ((!paramBundle.contains(paramActivity)) && (!paramActivity.contains("LauncherUI")) && (!paramActivity.contains("SnsTimeLineUI")))
          {
            paramActivity = paramBundle + paramActivity;
            MultiProcessMMKV.getDefault().putString("ai_is_tools_or_mp_entry", paramActivity).commit();
          }
        }
      }
    }
    AppMethodBeat.o(267544);
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.e
 * JD-Core Version:    0.7.0.1
 */