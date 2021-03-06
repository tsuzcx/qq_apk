package com.tencent.mobileqq.webviewplugin;

import com.tencent.biz.coupon.CouponInterface;
import com.tencent.biz.eqq.EqqWebviewPlugin;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.webviewplugin.AccountReleasePlugin;
import com.tencent.biz.webviewplugin.AdWebviewPlugin;
import com.tencent.biz.webviewplugin.HbEventPlugin;
import com.tencent.biz.webviewplugin.NearbyTroopsPlugin;
import com.tencent.biz.webviewplugin.OpenAppDetailPlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI;
import com.tencent.device.utils.QQConnectPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.remind.RemindJavascriptInterface;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubPageUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWiFiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletOpenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.vipgift.VipGiftPlugin;
import cooperation.qwallet.virtual.JsCallBackInterface;
import cooperation.qzone.coverstore.QZoneCoverStorePlugin;
import cooperation.qzone.coverstore.QZonePersonalizePlugin;
import cooperation.qzone.famous.QZoneFamousUserHomePlugin;
import cooperation.qzone.mood.QzoneSelectMoodPictureJsPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import java.util.HashMap;
import java.util.Map;

public class WebViewPluginConfig
{
  public static final String a = "insertPluginsArray";
  public static final Map a;
  public static final WebViewPluginConfig.PluginInfo[] a;
  
  static
  {
    int i = 0;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo = new WebViewPluginConfig.PluginInfo[] { new WebViewPluginConfig.PluginInfo(QzonePlugin.class, "QQ????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VasWebReport.class, "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(QWalletPayJsPlugin.class, "QQ????????????", "1.0"), new WebViewPluginConfig.PluginInfo(MusicGeneWebViewPlugin.class, "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QWalletOpenJsPlugin.class, "???Q????????????", "1.0"), new WebViewPluginConfig.PluginInfo(EventApiPlugin.class, "mqq.event.* API", "1.0"), new WebViewPluginConfig.PluginInfo(UiApiPlugin.class, "mqq.ui.* API", "1.0"), new WebViewPluginConfig.PluginInfo(OpenCenterPlugin.class, "??????API", "1.0"), new WebViewPluginConfig.PluginInfo(MQPSecJsPlugin.class, "???Q??????/JS", "1.0"), new WebViewPluginConfig.PluginInfo(QZonePersonalizePlugin.class, "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneFamousUserHomePlugin.class, "????????????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneWebViewPlugin.class, "Qzone", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneCoverStorePlugin.class, "QzCover", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QzoneWebMusicJsPlugin.class, "QzMusic", "Qzone????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QZoneTihSettingWebPlugin.class, "qztodayinhistory", "Qzone??????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(PubAccountMailJsPlugin.class, "mail", "????????????Mail/JS", "1.0"), new WebViewPluginConfig.PluginInfo(JsCallBackInterface.class, "mqBridge", "QQ????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VipTroopUpgradePlugin.class, "Troop", "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(AccountReleasePlugin.class, "QQ?????????", "1.0"), new WebViewPluginConfig.PluginInfo(SSOWebviewPlugin.class, "sso", "sso??????", "1.0"), new WebViewPluginConfig.PluginInfo(QQWiFiJsPlugin.class, "qw_qqwifi", "QQWiFi?????????", "1.0"), new WebViewPluginConfig.PluginInfo(PublicAccountJavascriptInterface.class, "publicAccount", "??????????????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(SensorAPIJavaScript.class, "qbizApi", "????????? API", "1.0"), new WebViewPluginConfig.PluginInfo(CouponInterface.class, "coupon", "QQ?????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(MediaApiPlugin.class, "media", "mqq.media.* API", "1.0"), new WebViewPluginConfig.PluginInfo(QQApiPlugin.class, "QQApi", "QQApi?????????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopWebviewPlugin.class, "Troop", "troop api", "1.0"), new WebViewPluginConfig.PluginInfo(TroopNoticeJsHandler.class, "troopNotice", "?????????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopAssistantFeedsJsHandler.class, "troopAssistantFeeds", "?????????", "1.0"), new WebViewPluginConfig.PluginInfo(AdWebviewPlugin.class, "app", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(RemindJavascriptInterface.class, "REMIND", "??????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(EqqWebviewPlugin.class, "eqq", "??????QQ??????", "1.0"), new WebViewPluginConfig.PluginInfo(PayJsPlugin.class, "pay", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(OpenAppDetailPlugin.class, "openToAppDetail", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberLevelJSAPI.class, "troop_member_level_JS_API", "???????????????", "1.0"), new WebViewPluginConfig.PluginInfo(DataApiPlugin.class, "data", "mqq.data.* API", "1.0"), new WebViewPluginConfig.PluginInfo(TroopMemberApiPlugin.class, "TroopMemberApiPlugin", "???????????????JS API", "1.0"), new WebViewPluginConfig.PluginInfo(NearbyTroopsPlugin.class, "NearbyTroopsPlugin", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(MyBusinessWebViewPlugin.class, "mybusiness", "???Q????????????", "1.0"), new WebViewPluginConfig.PluginInfo(RedTouchWebviewHandler.class, "redpoint", "??????", "1.0"), new WebViewPluginConfig.PluginInfo(GameCenterAPIJavaScript.class, "GCApi", "????????????API", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontJsPlugin.class, "font", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ChatBackgroundJsPlugin.class, "chatBg", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(BubbleJsPlugin.class, "bubble", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(StarJsPlugin.class, "starclub", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantJsPlugin.class, "faceAddon", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiJsPlugin.class, "emoji", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeJsPlugin.class, "theme", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ColorRingJsPlugin.class, "colorRing", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeAndBubbleCommonJsPlugin.class, "common", "????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VipGiftPlugin.class, "gift", "??????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(ProfileCardWebviewPlugin.class, "card", "???????????????????????????", "1.0", false), new WebViewPluginConfig.PluginInfo(QQConnectPlugin.class, "QQConnect", "QQ??????", "1.0"), new WebViewPluginConfig.PluginInfo(VasCommonJsPlugin.class, "qw_data", "????????????", "1.0", false), new WebViewPluginConfig.PluginInfo(VasCommonJsPlugin.class, "qw_debug", "????????????", "1.0", false), new WebViewPluginConfig.PluginInfo(QWalletGetContactJsPlugin.class, "qw_charge", "QQ????????????web???", "1.0"), new WebViewPluginConfig.PluginInfo(IndividuationPlugin.class, "individuation", "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(DeviceApiPlugin.class, "device", "????????????/JS", "1.0"), new WebViewPluginConfig.PluginInfo(VipSpecialSoundWebViewPlugin.class, "specialRing", "????????????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(MessageRoamJsPlugin.class, "??????????????????", "1.0"), new WebViewPluginConfig.PluginInfo(QQWIFIPlugin.class, "qqwifi", "QQWIFI", "1.0"), new WebViewPluginConfig.PluginInfo(QzoneSelectMoodPictureJsPlugin.class, "QzMoodSelectPicture", "Qzone????????????", "1.0"), new WebViewPluginConfig.PluginInfo(VipFunCallJsPlugin.class, "funCall", "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(VipFunctionJsPlugin.class, "QQVIPFunction", "????????????JS", "1.0"), new WebViewPluginConfig.PluginInfo(ThemeUiPlugin.class, String.valueOf(32L), "??????-??????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(BubbleUiPlugin.class, String.valueOf(64L), "??????-??????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiHomeUiPlugin.class, String.valueOf(2L), "??????-??????-??????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiSubHomeUiPlugin.class, String.valueOf(4L), "??????-?????????-??????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(EmojiSubPageUiPlugin.class, String.valueOf(8L), "??????-?????????-??????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(AvatarPendantUiPlugin.class, String.valueOf(512L), "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(IndividuationUIPlugin.class, String.valueOf(1048576L), "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(ChatFontUiPlugin.class, String.valueOf(4096L), "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(SuitUIPlugin.class, String.valueOf(262144L), "????????????UI", "1.0"), new WebViewPluginConfig.PluginInfo(HealthUiPlugin.class, String.valueOf(65536L), "????????????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(ColorRingUIPlugin.class, String.valueOf(4194304L), "????????????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(ChatBackgroundUiPlugin.class, String.valueOf(33554432L), "????????????/UI", "1.0"), new WebViewPluginConfig.PluginInfo(HbEventPlugin.class, "??????????????????", "1.0") };
    int j = jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo.length;
    while (i < j)
    {
      WebViewPluginConfig.PluginInfo localPluginInfo = jdField_a_of_type_ArrayOfComTencentMobileqqWebviewpluginWebViewPluginConfig$PluginInfo[i];
      localPluginInfo.jdField_a_of_type_Int = (i + 1);
      if ((localPluginInfo.jdField_a_of_type_Boolean) && (localPluginInfo.c != null) && (localPluginInfo.c.length() > 0)) {
        jdField_a_of_type_JavaUtilMap.put(localPluginInfo.c, localPluginInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewPluginConfig
 * JD-Core Version:    0.7.0.1
 */