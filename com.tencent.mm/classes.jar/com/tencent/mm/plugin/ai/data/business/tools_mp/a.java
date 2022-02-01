package com.tencent.mm.plugin.ai.data.business.tools_mp;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  public static a qmL;
  private boolean qmM;
  private boolean qmN;
  private IListener<sj> qmO;
  
  static
  {
    AppMethodBeat.i(267529);
    qmL = new a();
    AppMethodBeat.o(267529);
  }
  
  private a()
  {
    AppMethodBeat.i(267508);
    this.qmM = false;
    this.qmN = false;
    this.qmO = new PreloadManager.1(this, f.hfK);
    if (MMApplicationContext.isMainProcess())
    {
      ((Application)MMApplicationContext.getContext().getApplicationContext()).registerActivityLifecycleCallbacks(this);
      this.qmO.alive();
    }
    AppMethodBeat.o(267508);
  }
  
  public static a caq()
  {
    return qmL;
  }
  
  public static boolean car()
  {
    AppMethodBeat.i(267520);
    if (d.Yxk)
    {
      AppMethodBeat.o(267520);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yFX, 0) == 1)
    {
      AppMethodBeat.o(267520);
      return true;
    }
    AppMethodBeat.o(267520);
    return false;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(267553);
    if (car())
    {
      paramActivity = paramActivity.getClass().getName().split("\\.");
      if ((paramActivity == null) || (paramActivity.length == 0))
      {
        AppMethodBeat.o(267553);
        return;
      }
      paramActivity = ";" + paramActivity[(paramActivity.length - 1)] + ";";
      if (!MultiProcessMMKV.getDefault().getString("ai_is_tools_or_mp_entry", ";BizTimeLineUI;BaseScanUI;ChattingUI;ReaderAppUI;FTSMainUI;MainUI;MallWalletUI;ImageGalleryUI;UIPageFragmentActivity;FavoriteIndexUI;AppAttachNewDownloadUI;MallIndexUIv2;SnsCommentDetailUI;FloatBall;WalletBalanceManagerUI;TopStoryHomeUI;ContactInfoUI;RecordMsgDetailUI;FindMoreFriendsUI;AppBrandUI;WalletLqtDetailUI;ExtDeviceWXLoginUI;SnsBrowseUI;WXBizEntryActivity;WalletBankcardManageUI;FavoriteTextDetailUI;FTSAddFriendUI;AddMoreFriendsUI;GameCenterUI;SoSoProxyUI;WebSearchImageLoadingUI;CardDetailUI;EnterpriseBizContactListUI;EnterpriseConversationUI;LoginPasswordUI;BrandServiceIndexUI;SingleChatInfoUI;AppBrandUI2;FTSBizDetailUI;WXCustomSchemeEntryActivity;RemittanceDetailUI;WalletPasswordSettingUI;AppBrandUI1;SnsGalleryUI;FavoriteImgDetailUI;PhoneRechargeUI;LoginUI;AppBrandLauncherUI;FavSearchUI;MobileInputUI;VideoActivity;AppBrandLaunchProxyUI;MediaHistoryListUI;AppBrandPluginUI;TextPreviewUI;MallIndexOSUI;AppBrandUI3;SnsUploadUI;FavImgGalleryUI;Settings$AppControlSettingsActivity;ProfileSettingUI;RegByMobileRegAIOUI;ChatroomInfoUI;FavoriteFileDetailUI;NetworkDiagnoseAllInOneUI;EmojiStoreV2UI;LuckyMoneyNotHookReceiveUI;RoomCardUI;RecordMsgFileUI;AppBrandServiceChattingUI;GameMsgCenterUI;RecordMsgImageUI;FavRecordDetailUI;SnsAdNativeLandingPagesPreviewUI;CreateOrJoinChatroomUI;LuckyMoneyPickEnvelopeUI;WebSearchSnsImageLoadingUI;UIEntryStub;AppBrandTaskProxyUI;SnsWsFoldDetailUI;LoginSmsUI;FavFilterUI;SnsSingleTextViewUI;AppAttachDownloadUI;FinderFollowTabFragment;SettingsAboutMicroMsgUI;AppBrandUI4;AppBrandPluginUI2;NewBizConversationUI;MusicMvMainUI;WalletSecuritySettingUI;i;BizTimeLineNewMsgUI;BizChatroomInfoUI;MultiTalkSelectContactUI;SDKOAuthUI;SelectConversationUI;RemittanceBusiResultUI;WebViewStubProxyUI;WXEntryActivity;WalletOfflineCoinPurseUI;GameChatTabUI;CustomSmileyPreviewUI;ShakeReportUI;AppBrandProfileUI;FinderProfileTimeLineUI;GestureGalleryUI;FavSelectUI;WalletLqtSaveFetchUI;FinderFinderSysMsgUI;LoginVoiceUI;WeCoinRechargeView;FinderShareFeedRelUI;WeChatSplashActivity;AddressUIFragment;SimpleLoginUI;AppBrandProcessProxyUI;FaceDetectConfirmUI;WalletBrandUI;FinderFriendTabFragment;MusicMainUI;PermissionActivity;DownloadMainUI;RemittanceUI;MoreTabUI;SettingsModifyAliasCheckUI;EmojiStoreDetailUI;AppBrandTaskProxyUI2;WalletOrderInfoNewUI;WalletBalanceFetchUI;FinderProfileUI;HoneyPayCardManagerUI;LuckyMoneyDetailUI;AppBrandPluginUI3;SettingsAccountInfoUI;WxaLiteAppLiteUI;ExdeviceRankInfoUI;SettingsMoreSafeUI;ShareImgUI;LuckyMoneyPrepareUI;TopStoryTabHomeUI;RequestFloatWindowPermissionDialog;FinderAccountManagent;FileSelectorUI;FinderLiveVisitorWithoutAffinityUI;TaskRedirectUI;HoneyPayMainUI;MainActivity;OrderHandlerUI;OccupyFinderUI8;FinderMachineTabFragment;WebviewScanImageActivity;BankRemitBankcardInputUI;FaceFlashUI;FMessageConversationUI;WalletPayUI;SettingsSwitchAccountUI;FaceAgreementUI;NoteEditorUI;MultiTalkMainUI;FTSEmojiDetailPageUI;LoginByMobileSendSmsUI;AppBrandPluginUI1;BizChatConversationUI;RemittanceOSUI;EmptyActivity;WalletMixOrderInfoUI;SelectContactUI;ContactMoreInfoUI;WebViewDownloadUI;MsgRetransmitUI;AccountExpiredUI;FavMediaGalleryUI;SettingsModifyAliasUI;AppBrandPreLoadingUI;ImagePreviewUI;AppBrandServiceConversationUI;FinderLikedFeedUI;SettingsChattingBackgroundUI;AppBrandTaskProxyUI3;AppBrandTaskProxyUI4;AppBrandTaskProxyUI1;SendAppMessageWrapperUI;MobileLoginOrForceReg;MediaHistoryGalleryUI;BackupChooseBackupModeUI;FingerprintWalletLockUI;MultiTalkAddMembersUI;WXPayEntryActivity;WelabMainUI;QQCallbackUI;FingerPrintAuthUI;FTSDetailUI;AlbumPreviewUI;WalletOpenViewProxyUI;RemittanceBusiUI;CardShopUI;SosSimilarUI;LuckyMoneyBusiDetailUI;WcPayRealnameVerifyIdInputUI;VoiceInputUI;FixToolsUI;BackupPcUI;OpenFileChooserUI;SDKOAuthOtherUI;WebViewStubTempUI;WebWXLogoutUI;FaceFlashActionUI;").contains(paramActivity)) {
        break label98;
      }
    }
    label98:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.xwebutil.c.jQE();
      }
      AppMethodBeat.o(267553);
      return;
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.tools_mp.a
 * JD-Core Version:    0.7.0.1
 */