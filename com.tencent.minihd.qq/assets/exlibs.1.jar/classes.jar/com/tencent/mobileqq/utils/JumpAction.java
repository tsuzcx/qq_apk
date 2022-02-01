package com.tencent.mobileqq.utils;

import NearbyGroup.GroupInfo;
import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LocaleInfo;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.TenpayActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.msg.activities.DeviceQRAgentActivity;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthHandler;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingShareHelper;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.PortalConfig;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.troop.TroopProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import krp;
import krq;
import krr;
import krs;
import krt;
import kru;
import krv;
import krw;
import krx;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpAction
{
  public static final String A = "tribe";
  public static final String B = "qlink";
  public static final String C = "qqconnect";
  public static final String D = "crmivr";
  public static final String E = "qqwifi";
  public static final String F = "audiochat";
  public static final String G = "imchat";
  public static final String H = "tribe_native";
  public static final String I = "web";
  public static final String J = "url";
  public static final String K = "bid";
  public static final String L = "sourceUrl";
  public static final String M = "wpa";
  public static final String N = "openid_to_uin";
  public static final String O = "puzzle_verify_code";
  public static final String P = "PUZZLEVERIFYCODE";
  public static final String Q = "VERIFYCODE";
  public static final String R = "DEVLOCK_CODE";
  public static final String S = "chat";
  public static final String T = "pay";
  public static final String U = "openqqdataline";
  public static final String V = "dating_id";
  public static final String W = "dating";
  public static final String X = "detail";
  public static final String Y = "publish";
  public static final String Z = "feed";
  public static final int a = 3;
  public static final String a = "im";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.minihd.qq" };
  public static final String aA = "ft";
  public static final String aB = "nearby";
  public static final String aC = "create";
  public static final String aD = "emoji";
  public static final String aE = "emoji_detail";
  public static final String aF = "emoji_author";
  public static final String aG = "bubble";
  public static final String aH = "theme";
  public static final String aI = "font";
  public static final String aJ = "pendant";
  public static final String aK = "open";
  public static final String aL = "qlogin";
  public static final String aM = "groupalbum";
  public static final String aN = "request";
  public static final String aO = "request";
  public static final String aP = "to_qqdataline";
  public static final String aQ = "openqlink";
  public static final String aR = "outweb_start";
  public static final String aS = "version";
  public static final String aT = "channel_id";
  public static final String aU = "src_type";
  public static final String aV = "callback_type";
  public static final String aW = "callback_name";
  public static final String aX = "app_info";
  public static final String aY = "viewtype";
  public static final String aZ = "plugin_start_time";
  public static final String aa = "nearby_entry";
  public static final String ab = "nearby_feed";
  public static final String ac = "turn_brand";
  public static final String ad = "nearby_profile";
  public static final String ae = "hotchat_list";
  public static final String af = "hotchat_room";
  public static final String ag = "vip_map_roam";
  public static final String ah = "bind_group";
  public static final String ai = "show_nearby_fri";
  public static final String aj = "show_location";
  public static final String ak = "select_location";
  public static final String al = "open";
  public static final String am = "modify_pass";
  public static final String an = "to_publish_queue";
  public static final String ao = "show_pslcard";
  public static final String ap = "show_groupcard";
  public static final String aq = "photo";
  public static final String ar = "url";
  public static final String as = "to_fri";
  public static final String at = "to_qqfav";
  public static final String au = "to_qzone";
  public static final String av = "to_troopbar";
  public static final String aw = "add_friend";
  public static final String ax = "writemood";
  public static final String ay = "open_homepage";
  public static final String az = "qr";
  public static int b = 0;
  public static final String b = "lbs";
  public static final String bA = "i_actionData";
  public static final String bB = "action";
  public static final String bC = "appid";
  public static final String bD = "thirdAppDisplayName";
  public static final String bE = "paramencrypted_type";
  public static final String bF = "lon";
  public static final String bG = "lat";
  public static final String bH = "title";
  public static final String bI = "summary";
  public static final String bJ = "bus_type";
  public static final String bK = "url_prefix";
  public static final String bL = "style";
  public static final String bM = "plg_auth";
  public static final String bN = "plg_nld";
  public static final String bO = "plg_dev";
  public static final String bP = "plg_usr";
  public static final String bQ = "plg_vkey";
  public static final String bR = "file_type";
  public static final String bS = "file_data";
  public static final String bT = "title";
  public static final String bU = "description";
  public static final String bV = "previewimagedata";
  public static final String bW = "url";
  public static final String bX = "share_id";
  public static final String bY = "image_url";
  public static final String bZ = "app_name";
  public static final String ba = "click_start_time";
  public static final String bb = "is_from_leba";
  public static final String bc = "has_red_dot";
  public static final String bd = "chat_type";
  public static final String be = "uin";
  public static final String bf = "attach_content";
  public static final String bg = "group_info";
  public static final String bh = "discuss_info";
  public static final String bi = "sigt";
  public static final String bj = "sig";
  public static final String bk = "kfnick";
  public static final String bl = "params";
  public static final String bm = "url";
  public static final String bn = "picture";
  public static final String bo = "title";
  public static final String bp = "summary";
  public static final String bq = "gid";
  public static final String br = "brief";
  public static final String bs = "source";
  public static final String bt = "puin";
  public static final String bu = "price";
  public static final String bv = "prunit";
  public static final String bw = "layout";
  public static final String bx = "icon";
  public static final String by = "srcaction";
  public static final String bz = "a_actionData";
  private static final int jdField_c_of_type_Int = 0;
  public static final String c = "card";
  public static final String cA = "initgrouptype";
  public static final String cB = "DEFAULT";
  public static final String cC = "0";
  public static final String cD = "1";
  public static final String cE = "2";
  public static final String cF = "troopType";
  public static final String cG = "fromH5";
  public static final String cH = "aioorprofile";
  public static final String cQ = "wpaCount";
  public static final String cR = "webview";
  public static final String cS = "from_leba";
  public static final String cT = "config_res_plugin_item_name";
  public static final String cU = "source_scheme";
  public static final String cV = "redtouch_click_timestamp";
  private static final String cW = "share_qq_ext_str";
  private static final String cX = "cflag";
  private static final String cY = "open_id";
  private static final String cZ = "fopen_id";
  public static final String ca = "open_id";
  public static final String cb = "share_uin";
  public static final String cc = "jfrom";
  public static final String cd = "audioUrl";
  public static final String ce = "req_type";
  public static final String cf = "game_union_id";
  public static final String cg = "game_zone_id";
  public static final String ch = "signature";
  public static final String ci = "back_title";
  public static final String cj = "card_type";
  public static final String ck = "wSourceSubID";
  public static final String cl = "openid";
  public static final String cm = "appid";
  public static final String cn = "source";
  public static final String co = "wpa";
  public static final String cp = "url_app_info";
  public static final String cq = "hb_id";
  public static final String cr = "send_uin";
  public static final String cs = "hb_type";
  public static final String ct = "hb_summary";
  public static final String cu = "k_requestcode";
  public static final String cv = "fromSencondhandCommunity";
  public static final String cw = "from3rdApp";
  public static final String cx = "showFirstStructMsg";
  public static final String cy = "pakage_from_h5";
  public static final String cz = "creategroup";
  private static final int jdField_d_of_type_Int = 1;
  public static final String d = "upload";
  private static final String da = "app_id";
  private static final String db = "friend_label";
  private static final String dc = "add_msg";
  private static final String dd = "app_name";
  private static final String de = "troopbar_id";
  private static final String df = "troopbar_name";
  private static final String dg = "packageName";
  private static final String dh = "signareMode";
  private static final String di = "appid";
  private static final String dj = "timeStamp";
  private static final String dk = "resetWordMode";
  private static final String dl = "offerid";
  private static final String dm = "uin";
  private static final String dn = "txt";
  private static final String dq = "4eY#X@~g.+U)2%$<";
  private static final String dr = "Hf7K(s*js12LiskW";
  private static final String du = "JumpAction";
  private static final String dv = "com.qqreader.QRBridgeActivity";
  public static final String e = "forward";
  public static final String f = "share";
  public static final String g = "qzone";
  public static final String h = "mqq";
  public static final String i = "app";
  public static final String j = "qm";
  public static final String k = "gamesdk";
  public static final String l = "qqdataline";
  public static final String m = "qapp";
  public static final String n = "wallet";
  public static final String o = "gav";
  public static final String p = "videochat";
  public static final String q = "tenpay";
  public static final String r = "sendHongBao";
  public static final String s = "robHongBao";
  public static final String t = "structMsgHongBao";
  public static final String u = "dc";
  public static final String v = "group";
  public static final String w = "shop";
  public static final String x = "ptlogin";
  public static final String y = "readingcenter";
  public static final String z = "healthcenter";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private final HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private krw jdField_a_of_type_Krw = new krw(this, this);
  private krx jdField_a_of_type_Krx;
  public boolean a;
  private boolean b;
  private boolean jdField_c_of_type_Boolean;
  public String cI;
  public String cJ;
  public String cK;
  public String cL;
  public String cM;
  public String cN;
  public String cO;
  public String cP;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_do;
  private String dp;
  private String ds;
  private String dt;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public JumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean A()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if ((str != null) && ("group".equals(str))) {
      return D();
    }
    return C();
  }
  
  private boolean B()
  {
    Object localObject1;
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mode"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label110;
      }
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      label56:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label426;
      }
    }
    label270:
    label426:
    for (int i1 = Integer.valueOf((String)localObject1).intValue();; i1 = 1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        return true;
        localObject1 = "";
        break;
        label110:
        str = "";
        break label56;
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        Object localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("param_mode", i1);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        if ("10002".endsWith(str))
        {
          ((Intent)localObject2).putExtra("abp_flag", true);
          ((Intent)localObject2).addFlags(268435456);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        continue;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tinnyid"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tinnyid");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {
            break label304;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label312;
          }
        }
        label304:
        label312:
        for (long l1 = 0L;; l1 = Long.valueOf((String)localObject1).longValue())
        {
          if ((l1 != 0L) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
            break label324;
          }
          return false;
          localObject1 = "";
          break;
          localObject2 = "";
          break label270;
        }
        label324:
        localObject1 = new ProfileActivity.AllInOne((String)localObject2, 41);
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        ((Intent)localObject2).putExtra("AllInOne", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("param_mode", 3);
        ((Intent)localObject2).putExtra("param_tiny_id", l1);
        if ("10002".endsWith(str))
        {
          ((Intent)localObject2).putExtra("abp_flag", true);
          ((Intent)localObject2).addFlags(268435456);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      }
    }
  }
  
  private boolean C()
  {
    boolean bool = false;
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject1)))
    {
      localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof ScannerActivity)) {
        break label284;
      }
      localObject2 = new Intent("Common_BroadcastReceiver");
      ((Intent)localObject2).putExtra("param_all_in_one", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("open_profile_card_from_scanner", true);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject2);
      ((ScannerActivity)this.jdField_a_of_type_AndroidContentContext).finish();
      ((ScannerActivity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968649, 2130968649);
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
      } while (((String)localObject1).length() < 5);
      Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c((String)localObject1);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).h = localFriends.name;
        ((ProfileActivity.AllInOne)localObject1).i = localFriends.remark;
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 3);
        if ("1".equals(localObject2)) {}
        for (int i1 = 1;; i1 = 0)
        {
          ((ProfileActivity.AllInOne)localObject1).d = i1;
          break;
        }
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 19);
      break;
      label284:
      ProfileActivity.c(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1);
    }
  }
  
  private boolean D()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if ((str2 == null) || ("".equals(str2)) || (str2.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      localObject1 = TroopInfoActivity.a(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
          localObject1 = TroopInfoActivity.a(str2, 22);
        }
        try
        {
          int i1 = Integer.parseInt(str1);
          ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
          if (i1 == 33) {
            ((Bundle)localObject1).putInt("troop_info_from", 24);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              ChatSettingForTroop.a(this.jdField_a_of_type_AndroidContentContext, localObject2, 2);
            }
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof ScannerActivity))
        {
          localObject3 = new Intent("Common_BroadcastReceiver");
          ((Intent)localObject3).putExtras((Bundle)localObject1);
          ((Intent)localObject3).putExtra("open_troop_info_from_scanner", true);
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject3);
          ((ScannerActivity)this.jdField_a_of_type_AndroidContentContext).finish();
          ((ScannerActivity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130968649, 2130968649);
          return true;
          localObject1 = TroopInfoActivity.a(str2, 5);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private boolean E()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.cI;
    }
    localIntent.putExtra("url", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean F()
  {
    i1 = -1;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TenpayActivity.class);
    localIntent.putExtra("src_type", this.cN).putExtra("token_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("token_id")).putExtra("app_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).putExtra("version", this.cL).putExtra("app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_info")).putExtra("callback_type", this.cO).putExtra("callback_name", this.cP).putExtra("app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_info")).putExtra("url_app_info", (String)this.jdField_a_of_type_JavaUtilHashMap.get("url_app_info")).putExtra("params", (String)this.jdField_a_of_type_JavaUtilHashMap.get("params"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {}
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("k_requestcode");
      if ((str == null) || (str.length() <= 0)) {
        break label243;
      }
      int i2 = Integer.parseInt(str, 10);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        continue;
        i1 = -1;
      }
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, i1);
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean G()
  {
    if ("webview".equals(this.jdField_do))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.cN).putExtra("callback_type", this.cO).putExtra("callback_name", this.cP));
    }
    return true;
  }
  
  private boolean H()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localIntent.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label147:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label147;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean I()
  {
    System.currentTimeMillis();
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!Util.c((String)localObject2).equalsIgnoreCase("qq.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("wanggou.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("tencent.com")) && (!Util.c((String)localObject2).equalsIgnoreCase("bilibili.com")))) {
      return false;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject2);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      localObject2 = new Cryptor();
      if (!"1".equals(str2)) {
        break label1407;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
      localStringBuffer.append("sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
      localStringBuffer.append("&");
    }
    label1259:
    label1266:
    label1407:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject2).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject2).encrypt("黑".getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
        i2 = i1;
        if (localObject2 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject2).append("&");
          i2 = 1;
        }
      }
      if ((this.ds != null) && (this.ds.length() > 0)) {
        localStringBuffer.append(this.ds + "&");
      }
      if ("1".equals(localObject1))
      {
        localStringBuffer.append("plg_nld=1");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject1).putExtra("title", str1);
        }
        ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
        if (localStringBuffer.indexOf("?") >= localStringBuffer.length() - 1) {
          break;
        }
        if (localStringBuffer.indexOf("&") < 0)
        {
          localStringBuffer.append("&");
          break;
        }
        if (localStringBuffer.lastIndexOf("&") >= localStringBuffer.length() - 1) {
          break;
        }
        localStringBuffer.append("&");
        break;
      }
      if (i2 != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      if ((this.dp == null) || (!this.dp.trim().equalsIgnoreCase("com.tx.android.txnews.new")))
      {
        if ((this.dp != null) && (this.dp.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=5.9.3.3468");
          localStringBuffer.append("&appid=" + AppSetting.a);
          localStringBuffer.append("&QUA=" + QUA.a());
          localStringBuffer.append("&adtag=3468");
          if (localStringBuffer.indexOf("sid=") < 0) {
            localStringBuffer.append("&sid=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
          }
          localObject1 = Build.MODEL;
          if (localObject1 == null) {
            break label1259;
          }
          localObject1 = ((String)localObject1).replaceAll(" ", "_");
          localObject2 = Build.MANUFACTURER;
          if (localObject2 == null) {
            break label1266;
          }
        }
        for (localObject2 = ((String)localObject2).replaceAll(" ", "_");; localObject2 = "")
        {
          localStringBuffer.append("&model=").append((String)localObject1).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.b()).append("&cpurate=").append(DeviceInfoUtil.a()).append("&mem=").append(DeviceInfoUtil.c() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.f()).append("&h=").append(DeviceInfoUtil.g());
          i1 = localStringBuffer.lastIndexOf("&");
          if (i1 == localStringBuffer.length() - 1) {
            localStringBuffer.deleteCharAt(i1);
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject1).putExtra("title", str1);
          }
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
          ((Intent)localObject1).putExtra("is_from_leba", true);
          ((Intent)localObject1).putExtra("has_red_dot", this.d);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
          localObject1 = "";
          break;
        }
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((str1 != null) && (!str1.equals(""))) {
        ((Intent)localObject1).putExtra("title", str1);
      }
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject1).putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
      ((Intent)localObject1).putExtra("param_force_internal_browser", false);
      ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject1).putExtra("injectrecommend", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean J()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str12 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i1;
    long l1;
    Intent localIntent;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          Bundle localBundle = new Bundle();
          localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          if (l1 > 0L) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "gotoShareMsg appid = " + l1);
          }
          return false;
          localException1 = localException1;
          i1 = 0;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          l1 = 0L;
        }
        if ("news".equals(localObject)) {
          break label406;
        }
      }
    }
    if ("audio".equals(localObject))
    {
      label406:
      localException2.putString("title", str8);
      localException2.putString("desc", str9);
      localException2.putString("image_url", str7);
      localException2.putString("detail_url", str10);
      localException2.putInt("forward_type", 11);
      localException2.putLong("req_share_id", l1);
      localException2.putString("pkg_name", this.dp);
      localException2.putString("image_url_remote", str11);
      localException2.putString("app_name", str1);
      localException2.putString("open_id", str12);
      if (str8 != null) {
        break label746;
      }
      localObject = "";
      if (!TextUtils.isEmpty(str1)) {
        localObject = str1;
      }
      localException2.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131363662, new Object[] { localObject }));
    }
    for (;;)
    {
      localException2.putString("share_uin", str4);
      localException2.putString("jfrom", str5);
      localException2.putString("share_qq_ext_str", str6);
      localException2.putInt("cflag", i1);
      localException2.putInt("emoInputType", 2);
      int i3 = 1;
      try
      {
        i2 = Integer.valueOf(str3).intValue();
        if (i2 == 2) {
          localException2.putString("audio_url", str2);
        }
        localException2.putInt("req_type", i2);
        localException2.putBoolean("k_dataline", false);
        localException2.putBoolean("k_favorites", true);
        localException2.putBoolean("k_cancel_button", true);
        if (((i1 & 0x2) == 0) && (!"com.qzone".equals(this.dp)))
        {
          bool = true;
          localException2.putBoolean("k_qzone", bool);
          if ((!bool) || ((i1 & 0x1) == 0)) {
            break label807;
          }
          bool = true;
          localException2.putBoolean("k_send", bool);
          localIntent.putExtras(localException2);
          com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
          label746:
          localException2.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131363662, new Object[] { str8 }));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          boolean bool;
          int i2 = i3;
          if (QLog.isColorLevel())
          {
            QLog.d("QQShare", 2, "NumberFormatException req_type = 1");
            i2 = i3;
            continue;
            bool = false;
            continue;
            label807:
            bool = false;
          }
        }
      }
    }
  }
  
  private boolean K()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l1);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = 0L;
      }
      AddFriendLogicActivity.b = (String)localObject;
      localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3016, 0, str2, str3, null, "", str4);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    return true;
  }
  
  private boolean L()
  {
    Object localObject;
    String str2;
    QZoneHelper.UserInfo localUserInfo;
    String str1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))
    {
      localObject = (ChatActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localUserInfo = QZoneHelper.UserInfo.a();
        localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((ChatActivity)localObject).a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.a))) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).b(localSessionInfo.a, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label163;
        }
        QZoneHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label163:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((ChatActivity)localObject).a().a();
        str2 = b(str1);
        QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
      }
    }
  }
  
  private boolean M()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    for (;;)
    {
      Object localObject3;
      try
      {
        i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          localObject9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          i2 = (int)l1;
          if (TextUtils.isEmpty((CharSequence)localObject7))
          {
            localObject1 = "";
            if (!TextUtils.isEmpty(this.dp)) {
              continue;
            }
            localObject4 = "";
            QfavReport.a((AppRuntime)localObject9, "User_SdkShare", i2, 0, 0, 0, (String)localObject1, (String)localObject4);
            localObject9 = new Bundle();
            ((Bundle)localObject9).putString("title", (String)localObject6);
            ((Bundle)localObject9).putString("desc", (String)localObject8);
            ((Bundle)localObject9).putString("image_url", (String)localObject10);
            ((Bundle)localObject9).putString("detail_url", (String)localObject11);
            ((Bundle)localObject9).putLong("req_share_id", l1);
            ((Bundle)localObject9).putString("pkg_name", this.dp);
            ((Bundle)localObject9).putString("image_url_remote", str3);
            ((Bundle)localObject9).putString("app_name", (String)localObject7);
            ((Bundle)localObject9).putString("open_id", str4);
            ((Bundle)localObject9).putString("share_uin", str5);
            ((Bundle)localObject9).putString("jfrom", str6);
            ((Bundle)localObject9).putString("share_qq_ext_str", str7);
            ((Bundle)localObject9).putInt("cflag", i1);
            ((Bundle)localObject9).putInt("forward_type", 11);
            i3 = 1;
          }
        }
        catch (Exception localException2)
        {
          try
          {
            int i1;
            long l1;
            i2 = Integer.valueOf(str2).intValue();
            ((Bundle)localObject9).putInt("req_type", i2);
            if (2 == i2)
            {
              ((Bundle)localObject9).putString("audio_url", str1);
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131364736), new Object[] { localObject7 }));
                }
              }
              else
              {
                com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                ((Intent)localObject1).putExtra("toUin", AppConstants.ai);
                ((Intent)localObject1).putExtra("uinType", 0);
                if (1 != i1) {
                  break label1697;
                }
                ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                ((Intent)localObject1).putExtras((Bundle)localObject9);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
                localException1 = localException1;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                }
                i1 = 0;
                continue;
                localException2 = localException2;
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
                }
                l1 = 0L;
                continue;
                Object localObject2 = localObject7;
                continue;
                localObject4 = this.dp;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Object localObject9;
            Object localObject4;
            int i3;
            int i2 = i3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str2);
            i2 = i3;
            continue;
            ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131364737));
            continue;
            if (6 == i2)
            {
              ((Bundle)localObject9).putInt("forward_type", -1);
              localObject3 = "";
              if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                localObject3 = localObject6;
              }
              localObject4 = localObject3;
              if (!TextUtils.isEmpty((CharSequence)localObject8))
              {
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  localObject4 = localObject8;
                }
              }
              else
              {
                ((Bundle)localObject9).putString("forward_text", (String)localObject4);
                ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
                ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
                continue;
              }
              localObject4 = (String)localObject3 + "\n" + (String)localObject8;
              continue;
            }
            if (5 == i2)
            {
              ((Bundle)localObject9).putBoolean("qqfav_extra_pic_share", true);
              ((Bundle)localObject9).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject8));
              ((Bundle)localObject9).putString("qqfav_extra_richmedia_title", (String)localObject6);
              ((Bundle)localObject9).putString("qqfav_extra_mixed_msg", (String)localObject8);
              ((Bundle)localObject9).putString("desc", "");
              localObject7 = localObject6;
              if (TextUtils.isEmpty((CharSequence)localObject6))
              {
                localObject7 = localObject6;
                if (!TextUtils.isEmpty((CharSequence)localObject8))
                {
                  localObject7 = ((String)localObject8).replace("\024", "");
                  ((Bundle)localObject9).putString("title", (String)localObject7);
                }
              }
              localObject4 = null;
              localObject3 = null;
              localObject11 = new ArrayList();
              Object localObject5;
              if (!TextUtils.isEmpty((CharSequence)localObject10))
              {
                localObject10 = ((String)localObject10).split(";");
                i2 = 0;
                localObject6 = null;
                localObject8 = localObject6;
                localObject4 = localObject3;
                if (i2 < localObject10.length)
                {
                  localObject8 = "";
                  try
                  {
                    localObject4 = URLDecoder.decode(localObject10[i2], "UTF-8");
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if ((((String)localObject4).startsWith("/")) && (new File((String)localObject4).exists()))
                      {
                        ((ArrayList)localObject11).add(localObject4);
                        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                          continue;
                        }
                        i2 += 1;
                        localObject3 = localObject4;
                      }
                    }
                  }
                  catch (UnsupportedEncodingException localUnsupportedEncodingException)
                  {
                    localObject5 = localObject8;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject10[i2]);
                    localObject5 = localObject8;
                    continue;
                    if (localObject5.startsWith("http"))
                    {
                      ((ArrayList)localObject11).add(localObject5);
                      if (TextUtils.isEmpty((CharSequence)localObject6))
                      {
                        localObject6 = localObject5;
                        localObject5 = localObject3;
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject5);
                        }
                      }
                    }
                    localObject5 = localObject3;
                    continue;
                  }
                }
              }
              else
              {
                localObject8 = null;
              }
              if (((ArrayList)localObject11).isEmpty())
              {
                QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364730, 1);
                if (QLog.isColorLevel()) {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                }
                return false;
              }
              ((Bundle)localObject9).putString("image_url", localObject5);
              ((Bundle)localObject9).putString("image_url_remote", (String)localObject8);
              ((Bundle)localObject9).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject11);
              if (1 == ((ArrayList)localObject11).size())
              {
                if (TextUtils.isEmpty((CharSequence)localObject7))
                {
                  ((Bundle)localObject9).putInt("req_type", 5);
                  if ((!TextUtils.isEmpty(localObject5)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
                    continue;
                  }
                  ((Bundle)localObject9).putString("image_url", (String)localObject8);
                  continue;
                }
                ((Bundle)localObject9).putInt("req_type", 1);
                continue;
              }
              if (TextUtils.isEmpty((CharSequence)localObject7)) {
                ((Bundle)localObject9).putString("title", ((ArrayList)localObject11).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131364694));
              }
              ((Bundle)localObject9).putBoolean("qqfav_extra_multi_pic", true);
              ((Bundle)localObject9).putInt("req_type", 1);
              continue;
            }
            if (1 == i2)
            {
              if ((TextUtils.isEmpty((CharSequence)localObject6)) && (TextUtils.isEmpty((CharSequence)localObject8)))
              {
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((Bundle)localObject9).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131364736), new Object[] { localObject7 }));
                }
              }
              else
              {
                if ((!TextUtils.isEmpty((CharSequence)localObject11)) || (!QLog.isColorLevel())) {
                  continue;
                }
                QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                continue;
              }
              ((Bundle)localObject9).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131364737));
              continue;
            }
            QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131364730, 1);
            if (QLog.isColorLevel()) {
              QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
            }
            return false;
          }
        }
      }
      label1697:
      ((Intent)localObject3).putExtra("qqfav_extra_from_sdk_share", true);
    }
  }
  
  private boolean N()
  {
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    int i3 = 1;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        i2 = Integer.valueOf((String)localObject3).intValue();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          for (;;)
          {
            l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
            localObject3 = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break;
            }
            localObject2 = ((String)localObject2).split(";");
            i3 = 0;
            while (i3 < localObject2.length)
            {
              ((ArrayList)localObject3).add(URLDecoder.decode(localObject2[i3]));
              i3 += 1;
            }
            localNumberFormatException3 = localNumberFormatException3;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
              i1 = i2;
              continue;
              localNumberFormatException1 = localNumberFormatException1;
              i2 = i3;
              if (QLog.isColorLevel())
              {
                QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
                i2 = i3;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i1;
          long l1;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QzoneShare", 2, "NumberFormatException appID = 0");
            }
            l1 = 0L;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("title", (String)localObject1);
          ((Bundle)localObject2).putString("desc", str1);
          ((Bundle)localObject2).putString("app_name", str3);
          ((Bundle)localObject2).putLong("req_share_id", l1);
          ((Bundle)localObject2).putString("detail_url", str2);
          ((Bundle)localObject2).putStringArrayList("image_url", localNumberFormatException2);
          ((Bundle)localObject2).putString("pkg_name", this.dp);
          ((Bundle)localObject2).putString("open_id", str5);
          ((Bundle)localObject2).putString("share_uin", str6);
          ((Bundle)localObject2).putString("jfrom", str7);
          ((Bundle)localObject2).putString("share_qq_ext_str", str8);
          ((Bundle)localObject2).putInt("cflag", i1);
          if (i2 == 2) {
            ((Bundle)localObject2).putString("audio_url", str4);
          }
          ((Bundle)localObject2).putInt("req_type", i2);
          com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
          localObject1 = new krs(this);
          QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2, (DialogInterface.OnDismissListener)localObject1);
        }
      }
    }
    return true;
  }
  
  private boolean O()
  {
    return true;
  }
  
  private boolean P()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localUserInfo.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localUserInfo.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
      QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean Q()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    localObject = new Intent("com.tencent.sc.intent.tabactivity");
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify2");
    return true;
  }
  
  private boolean R()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinDiscussionActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("k"));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean S()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AgentActivity.class);
    Bundle localBundle = new Bundle();
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("p");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("schemacallback");
    localBundle.putString("retPath", str1);
    localBundle.putString("schemacallback", str2);
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    if ((localObject2 != null) && (((String)localObject2).equals("web")) && (str1 != null) && (str1.equals("1")) && (localObject1 != null) && (str2 != null))
    {
      if (str2.equals("discussgroup")) {
        if (((String)localObject1).equals("0"))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
          ((Intent)localObject1).putExtra("param_type", 3000);
          ((Intent)localObject1).putExtra("param_subtype", 0);
          ((Intent)localObject1).putExtra("param_from", 1003);
          ((Intent)localObject1).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131368583));
          ((Intent)localObject1).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131365737));
          ((Intent)localObject1).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131367559));
          ((Intent)localObject1).putExtra("param_entrance", 10);
          ((Intent)localObject1).putExtra("param_max", 49);
          ((Intent)localObject1).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 1);
        }
      }
      do
      {
        return true;
        localObject2 = new krt(this);
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject1, true, true, (Handler.Callback)localObject2);
        if (str2.equals("single"))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          ((Intent)localObject1).putExtra("forward_type", 13);
          ((Intent)localObject1).putExtra("fromWebXman", true);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject1, 2);
          return true;
        }
        if (!str2.equals("group")) {
          break;
        }
      } while (((String)localObject1).equals("0"));
      localObject2 = new kru(this);
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject1, true, true, (Handler.Callback)localObject2);
    }
    return false;
  }
  
  private boolean U()
  {
    return false;
  }
  
  private boolean V()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoIVRIMChat");
    }
    if (!CrmUtils.jdField_a_of_type_Boolean) {
      if (QLog.isDevelopLevel()) {
        QLog.d("JumpAction", 4, "Don't support sharp");
      }
    }
    Object localObject1;
    Object localObject2;
    String str1;
    do
    {
      return false;
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, String.format("gotoIVRVideoChat input params, requestType = %s, version = %s, uin = %s, from = %s", new Object[] { localObject1, localObject2, str1, str2 }));
      }
      localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    } while (localObject1 == null);
    int i1;
    if (((FriendManager)localObject1).b(str1))
    {
      localObject1 = ((FriendManager)localObject1).a(str1);
      i1 = 0;
      if (!ChatActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) {
        break label219;
      }
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, (String)localObject1);
    }
    for (;;)
    {
      return true;
      i1 = 1024;
      localObject1 = CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      break;
      label219:
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject2).putExtra("chat_subType", 1);
      ((Intent)localObject2).putExtra("uin", str1);
      ((Intent)localObject2).putExtra("uintype", i1);
      if (localObject1 != null) {
        ((Intent)localObject2).putExtra("uinname", (String)localObject1);
      }
      ((Intent)localObject2).putExtra("crm_ivr_aio_video_action_sheet", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, "", "");
    }
  }
  
  private boolean W()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", 1);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    if ((localObject3 != null) && (((String)localObject3).equals("web")) && (str2 != null) && (str2.equals("1"))) {}
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        i1 = Integer.valueOf(str3).intValue();
        if ((localObject2 == null) || (!((String)localObject2).equals("audio"))) {
          break label635;
        }
        bool1 = true;
        if (i1 == 1006)
        {
          localObject2 = localObject5;
          if (!((String)localObject5).startsWith("+")) {
            localObject2 = "+" + (String)localObject5;
          }
          localObject3 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c((String)localObject2);
          if (localObject3 != null)
          {
            localObject3 = ((PhoneContact)localObject3).name;
            localObject5 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject5 = localObject2;
            }
            bool2 = true;
            localObject1 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject5;
            localObject5 = new krv(this);
            return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, (Handler.Callback)localObject5, null, this.jdField_a_of_type_JavaUtilHashMap);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoVideoChat", localException);
        }
        i1 = 0;
        continue;
        localObject4 = localObject2;
        continue;
        if (i1 == 1011)
        {
          localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickName");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject2 = localObject4;
            if (!((String)localObject1).equals(localObject4)) {}
          }
          else
          {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363191);
          }
          bool2 = false;
          localObject4 = localObject2;
          bool1 = true;
          localObject2 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject5;
          continue;
        }
        i2 = ContactUtils.b(i1);
        if (i2 != -1) {}
      }
      for (Object localObject4 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);; localObject4 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label613;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        break;
      }
      return false;
      label613:
      boolean bool2 = true;
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label635:
      boolean bool1 = false;
    }
  }
  
  private boolean X()
  {
    boolean bool2 = true;
    String str2 = null;
    Object localObject9 = null;
    Intent localIntent2;
    Object localObject4;
    int i1;
    Object localObject3;
    Object localObject6;
    Object localObject8;
    int i2;
    for (;;)
    {
      try
      {
        localIntent2 = new Intent("android.intent.action.MAIN");
        a(localIntent2);
        Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
        localObject4 = "";
        if (!TextUtils.isEmpty(a("from_leba")))
        {
          localIntent2.putExtra("plugin_start_time", System.nanoTime());
          localIntent2.putExtra("click_start_time", System.currentTimeMillis());
          localIntent2.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent2.putExtra("is_from_leba", true);
          localIntent2.putExtra("has_red_dot", this.d);
        }
        Iterator localIterator = ((Set)localObject1).iterator();
        i1 = 0;
        localObject1 = null;
        localObject3 = null;
        if (localIterator.hasNext())
        {
          localObject6 = (Map.Entry)localIterator.next();
          localObject8 = (String)((Map.Entry)localObject6).getKey();
          localObject6 = (String)((Map.Entry)localObject6).getValue();
          if ((localObject8 != null) && (localObject6 != null))
          {
            if ("pkg".equals(localObject8))
            {
              localObject3 = localObject1;
              localObject1 = localObject4;
              localObject4 = localObject6;
              break label2221;
            }
            if ("cmp".equals(localObject8))
            {
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_account".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localIntent2.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_nickname".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
              localObject6 = localObject8;
              if (StringUtil.b((String)localObject8)) {
                localObject6 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
              }
              localIntent2.putExtra("nickname", (String)localObject6);
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_sid".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localIntent2.putExtra("sid", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_vkey".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localIntent2.putExtra("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_launchtime".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localIntent2.putExtra("launch_time", System.currentTimeMillis());
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_newflag".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localIntent2.putExtra("newflag", this.c);
              if (!QLog.isColorLevel()) {
                break label2240;
              }
              QLog.d("Jumpaction", 2, "handleAppForward.newflag=" + this.c);
              localObject6 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject4;
              localObject3 = localObject6;
              localObject4 = localObject8;
              break label2221;
            }
            if ("plg_type".equals(localObject8))
            {
              if (!"1".equals(localObject6)) {
                break label2240;
              }
              localObject6 = localObject4;
              i1 = 1;
              localObject4 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject6;
              break label2221;
            }
            if ("apk".equals(localObject8))
            {
              localObject4 = localObject1;
              localObject8 = localObject3;
              localObject1 = localObject6;
              localObject3 = localObject4;
              localObject4 = localObject8;
              break label2221;
            }
            localIntent2.putExtra((String)localObject8, (String)localObject6);
            break label2240;
          }
        }
        else
        {
          if ((localObject3 == null) || (localObject1 == null) || ("".equals(localObject3)) || ("".equals(localObject1))) {
            break label2263;
          }
          if ((this.jdField_a_of_type_Boolean) && (JumpFilterHelper.a().a(this.jdField_a_of_type_AndroidContentContext, (String)localObject3, (String)localObject1))) {
            return false;
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label2216;
          }
          localObject6 = jdField_a_of_type_ArrayOfJavaLangString;
          int i3 = localObject6.length;
          i2 = 0;
          if (i2 >= i3) {
            break label2216;
          }
          if (((String)localObject3).equals(localObject6[i2]))
          {
            i2 = 1;
            label857:
            if (i2 == 0)
            {
              localIntent2.putExtra("vkey", (String)null);
              localIntent2.putExtra("sid", (String)null);
              localIntent2.putExtra("nickname", (String)null);
              localIntent2.putExtra("account", (String)null);
            }
            if (((String)localObject1).startsWith("com.qzone")) {
              localIntent2.putExtra("refer", "mqqActiveTab");
            }
            if (i1 != 0) {
              break label2170;
            }
            if (!((String)localObject1).startsWith("com.qzone")) {
              break;
            }
            QzonePluginProxyActivity.a(localIntent2, (String)localObject1);
            localIntent2.addFlags(536870912);
            try
            {
              QZoneHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localIntent2, -1);
              return true;
            }
            catch (Exception localException1)
            {
              Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TranslucentActivity.class);
              localIntent1.addFlags(268435456);
              localIntent1.putExtras(localIntent2);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
              return true;
            }
          }
          i2 += 1;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        localActivityNotFoundException.printStackTrace();
        return false;
      }
    }
    if (localActivityNotFoundException.endsWith("OpenTroopInfoActivity"))
    {
      TroopProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2, null, 0);
      return true;
    }
    if (localActivityNotFoundException.endsWith("NearbyTroopsActivity"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_index");
      NearbyTroopsActivity.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 15, 0);
      if (!this.d) {
        break label2269;
      }
    }
    label2170:
    Object localObject2;
    label2206:
    label2216:
    label2221:
    label2240:
    label2263:
    label2269:
    for (String str1 = "0";; localObject2 = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_entry", "Clk_nearbygrp", 0, 0, "", "", "", str1);
      return true;
      boolean bool1 = str1.endsWith("PoiMapActivity");
      if (bool1) {
        try
        {
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).a().ac();
          localIntent2.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localObject6 = localIntent2.getStringExtra("lat");
          localObject4 = localIntent2.getStringExtra("lon");
          localObject3 = localIntent2.getStringExtra("loc");
          if ((localObject6 != null) && (localObject4 != null))
          {
            localObject6 = Double.valueOf((String)localObject6);
            localObject4 = Double.valueOf((String)localObject4);
            localIntent2.putExtra("url", "http://maps.google.com/maps?q=" + localObject6 + "," + localObject4 + "&iwloc=A&hl=zh-CN (" + (String)localObject3 + ")");
          }
          localIntent2.setClassName(this.jdField_a_of_type_AndroidContentContext.getPackageName(), str1);
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent2, 18);
          return true;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return true;
        }
      }
      if ((!TextUtils.isEmpty(localException2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localException2.equalsIgnoreCase("com.tencent.biz.coupon.CouponActivity")) && (((String)localObject3).equalsIgnoreCase("com.tencent.minihd.qq")))
      {
        localObject8 = new StringBuffer();
        if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.get() > 0) && (this.c))
        {
          ((StringBuffer)localObject8).append("isRedLight=1");
          if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.has()) {
            ((StringBuffer)localObject8).append("&redType=" + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.get());
          }
          bool1 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.has();
          if (!bool1) {}
        }
        for (;;)
        {
          try
          {
            localObject4 = URLEncoder.encode(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get(), "UTF-8");
            ((StringBuffer)localObject8).append("&couponBuffer=" + (String)localObject4);
            localObject6 = a("url");
            localObject4 = localObject6;
            if (!TextUtils.isEmpty((CharSequence)localObject6))
            {
              localObject4 = localObject6;
              if (QRUtils.d((String)localObject6)) {
                localObject4 = HtmlOffline.a((String)localObject6, ((StringBuffer)localObject8).toString());
              }
            }
            a((String)localObject4, (String)localObject3, localException2, localIntent2);
            f(localException2);
            return true;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localObject4 = localObject9;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("JumpAction", 2, localUnsupportedEncodingException.getMessage());
            localObject4 = localObject9;
            continue;
          }
          ((StringBuffer)localObject8).append("isRedLight=0");
        }
      }
      Object localObject7;
      if ((!TextUtils.isEmpty(localException2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localException2.equalsIgnoreCase("com.tencent.gamecenter.activities.GameCenterActivity")) && (((String)localObject3).equalsIgnoreCase("com.tencent.minihd.qq")))
      {
        localObject7 = a("url");
        localObject4 = localObject7;
        if (TextUtils.isEmpty((CharSequence)localObject7)) {
          localObject4 = "https://gamecenter.qq.com/gamecenter/index/index.html";
        }
        localObject8 = ((String)localObject4).trim();
        localObject4 = localObject8;
        if (!TextUtils.isEmpty((CharSequence)localObject8))
        {
          localObject4 = localObject8;
          if (QRUtils.d((String)localObject8))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              break label2206;
            }
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
            localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
        }
      }
      Object localObject5;
      for (;;)
      {
        str2 = "plat=qq&tt=1&sid=" + (String)localObject4 + "&qappid=" + AppSetting.a + "&osv=" + Build.VERSION.RELEASE + "&_bid=" + 278 + "&_wv=" + 5127;
        localObject4 = str2;
        if (!TextUtils.isEmpty((CharSequence)localObject7)) {
          localObject4 = str2 + "&uin=" + (String)localObject7;
        }
        localObject7 = localObject4;
        if (!TextUtils.isEmpty(this.dt)) {
          localObject7 = (String)localObject4 + "&" + this.dt;
        }
        localObject4 = HtmlOffline.a((String)localObject8, (String)localObject7 + "&st=" + System.currentTimeMillis());
        a((String)localObject4, (String)localObject3, localException2, localIntent2);
        f(localException2);
        return true;
        if (localException2.endsWith("NearbyTroopsActivity")) {
          localIntent2.putExtra("from", 15);
        }
        if (localException2.endsWith("JoinGroupTransitActivity")) {
          localIntent2.putExtra("source_scheme", this.cI);
        }
        bool1 = bool2;
        if (localObject3 == null) {
          break;
        }
        bool1 = ((String)localObject3).equals(BaseApplicationImpl.getContext().getPackageName());
        if (bool1) {
          try
          {
            bool1 = PluginProxyActivity.class.isAssignableFrom(BaseApplicationImpl.getContext().getClassLoader().loadClass(localException2));
            if (bool1) {
              return false;
            }
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              bool1 = false;
            }
            localIntent2.setClassName((String)localObject3, localException2);
            localIntent2.addCategory("android.intent.category.LAUNCHER");
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
            f(localException2);
            return true;
          }
        }
        localIntent2.setClassName(this.jdField_a_of_type_AndroidContentContext.getPackageName(), localException2);
        localIntent2.addCategory("android.intent.category.LAUNCHER");
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
        return true;
        bool1 = bool2;
        if (i1 != 1) {
          break;
        }
        bool1 = bool2;
        if (TextUtils.isEmpty(localException3)) {
          break;
        }
        bool1 = a(localIntent2, localException2, localException3);
        return bool1;
        localObject7 = null;
        localObject5 = str2;
      }
      i2 = 0;
      break label857;
      for (;;)
      {
        localObject7 = localObject5;
        localObject5 = localException2;
        localObject2 = localObject3;
        localObject3 = localObject7;
        break;
        localObject7 = localObject2;
        localObject8 = localObject3;
        localObject2 = localObject5;
        localObject3 = localObject7;
        localObject5 = localObject8;
      }
      bool1 = false;
      return bool1;
    }
  }
  
  private boolean Y()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    int i2 = 0;
    try
    {
      i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      l2 = 0L;
    }
    catch (Exception localException2)
    {
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        localBundle = new Bundle();
        localBundle.putString("title", (String)localObject2);
        localBundle.putString("desc", (String)localObject4);
        localBundle.putString("image_url", str1);
        localBundle.putString("detail_url", str2);
        localBundle.putLong("req_share_id", l1);
        localBundle.putString("pkg_name", this.dp);
        localBundle.putString("image_url_remote", str3);
        localBundle.putString("app_name", (String)localObject1);
        localBundle.putString("open_id", str4);
        localBundle.putString("share_uin", str5);
        localBundle.putString("jfrom", str6);
        localBundle.putString("share_qq_ext_str", str7);
        localBundle.putInt("cflag", i1);
        localBundle.putInt("forward_type", 11);
        i2 = 1;
      }
      catch (Exception localException2)
      {
        label904:
        label1192:
        label1202:
        try
        {
          long l2;
          do
          {
            for (;;)
            {
              Bundle localBundle;
              i1 = Integer.valueOf((String)localObject6).intValue();
              localBundle.putInt("req_type", i1);
              if (2 != i1) {
                break label826;
              }
              localBundle.putString("audio_url", (String)localObject5);
              if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break;
                }
                localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131364736), new Object[] { localObject1 }));
              }
              com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
              localBundle.putBoolean("MigSdkShareNotDone", true);
              ((Intent)localObject1).putExtras(localBundle);
              ((Intent)localObject1).addFlags(268435456);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
              localException1 = localException1;
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                i1 = i2;
              }
            }
            localException2 = localException2;
            l1 = l2;
          } while (!QLog.isColorLevel());
          QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
          long l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int i1;
          label826:
          do
          {
            for (;;)
            {
              i1 = i2;
              if (QLog.isColorLevel())
              {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + (String)localObject6);
                i1 = i2;
                continue;
                localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131364737));
                continue;
                if (6 == i1)
                {
                  localObject1 = "";
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = localObject2;
                  }
                  localObject2 = localObject1;
                  if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                      break label904;
                    }
                  }
                  for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                  {
                    localException2.putString("forward_text", (String)localObject2);
                    localException2.putInt("forward_type", -1);
                    localException2.putBoolean("isFromShare", true);
                    break;
                  }
                }
                if (5 != i1) {
                  break;
                }
                localObject2 = null;
                localObject1 = null;
                localObject6 = new ArrayList();
                Object localObject3;
                if (!TextUtils.isEmpty(str1))
                {
                  String[] arrayOfString = str1.split(";");
                  i1 = 0;
                  localObject4 = null;
                  for (;;)
                  {
                    localObject5 = localObject4;
                    localObject2 = localObject1;
                    if (i1 >= arrayOfString.length) {
                      break label1202;
                    }
                    localObject5 = "";
                    try
                    {
                      localObject2 = URLDecoder.decode(arrayOfString[i1], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                        if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                        {
                          ((ArrayList)localObject6).add(localObject2);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            break label1192;
                          }
                          i1 += 1;
                          localObject1 = localObject2;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      for (;;)
                      {
                        localObject3 = localObject5;
                        if (QLog.isColorLevel())
                        {
                          QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + arrayOfString[i1]);
                          localObject3 = localObject5;
                          continue;
                          if (localObject3.startsWith("http"))
                          {
                            ((ArrayList)localObject6).add(localObject3);
                            if (TextUtils.isEmpty((CharSequence)localObject4))
                            {
                              localObject4 = localObject3;
                              localObject3 = localObject1;
                              continue;
                              if (QLog.isColorLevel()) {
                                QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject3);
                              }
                            }
                          }
                          localObject3 = localObject1;
                        }
                      }
                    }
                  }
                }
                localObject5 = null;
                localException2.putString("image_url", localObject3);
                localException2.putString("image_url_remote", (String)localObject5);
                localException2.putString("title", null);
                localException2.putString("desc", null);
                if (1 == ((ArrayList)localObject6).size())
                {
                  localObject1 = localObject3;
                  if (TextUtils.isEmpty(localObject3))
                  {
                    localObject1 = localObject3;
                    if (!TextUtils.isEmpty((CharSequence)localObject5))
                    {
                      localException2.putString("image_url", (String)localObject5);
                      localObject1 = localObject5;
                    }
                  }
                  if (FileManagerUtil.a((String)localObject1) == 0)
                  {
                    localException2.putInt("req_type", 5);
                  }
                  else
                  {
                    localException2.putString("forward_text", "已选择" + FileManagerUtil.a((String)localObject1) + "。");
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putInt("forward_type", -1);
                    localException2.putInt("req_type", 6);
                  }
                }
                else if (FileManagerUtil.a(localObject3) == 0)
                {
                  localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131364694));
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qqfav_extra_multi_pic", true);
                  localException2.putInt("req_type", 1);
                }
                else
                {
                  localException2.putString("forward_text", "已选择" + FileManagerUtil.a(localObject3) + "等" + ((ArrayList)localObject6).size() + "个文件。");
                  localException2.putString("qqfav_extra_multi_pic_path_list", str1);
                  localException2.putBoolean("qdshare_file", true);
                  localException2.putBoolean("isFromShare", true);
                  localException2.putInt("forward_type", -1);
                  localException2.putInt("req_type", 6);
                }
              }
            }
          } while (1 == i1);
        }
      }
    }
    return false;
  }
  
  private boolean Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.cI + "  serverName:" + this.cJ + "  hostName:" + this.cK);
    }
    Object localObject1;
    if (this.cK.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!this.cK.equals("detail")) {
              break;
            }
          } while (TextUtils.isEmpty(this.cI));
          localObject1 = Common.i() + File.separator + "qapp_center_detail.htm";
          if (new File((String)localObject1).exists()) {}
          for (localObject1 = "file:///" + (String)localObject1;; localObject1 = Common.p() + File.separator + "qapp_center_detail.htm")
          {
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
            ((Intent)localObject2).addFlags(268435456);
            localObject3 = new Bundle();
            localObject4 = Uri.parse(this.cI).getQueryParameter("param");
            ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
            ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            return true;
          }
          if (!this.cK.equals("webview")) {
            break;
          }
        } while (TextUtils.isEmpty(this.cI));
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
        ((Intent)localObject1).addFlags(268435456);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.cI).getQueryParameter("url"));
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
      } while ((!this.cK.equals("local")) || (TextUtils.isEmpty(this.cI)));
      localObject2 = Uri.parse(this.cI);
      localObject1 = ((Uri)localObject2).getQueryParameter("title");
      localObject3 = Common.a(((Uri)localObject2).getQueryParameter("url"));
    } while (localObject3.length <= 1);
    Object localObject2 = localObject3[0];
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppWebViewActivity.class);
    ((Intent)localObject4).addFlags(268435456);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localBundle.putString("APP_PARAMS", (String)localObject3);
    }
    ((Intent)localObject4).putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
    return true;
  }
  
  private String a(byte[] paramArrayOfByte, Cryptor paramCryptor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("plg_nld=1");
    localStringBuffer.append("&");
    localStringBuffer.append("DEVICEINFO=");
    paramArrayOfByte = "2|" + HexUtil.bytes2HexStr(paramArrayOfByte);
    localStringBuffer.append(HexUtil.bytes2HexStr(paramCryptor.encrypt((paramArrayOfByte + "|" + b()).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.dt)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.dt);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type") == null)
    {
      i1 = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i1 != 1) {
        break label244;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = Base64Util.decode(new Cryptor().decrypt(HexUtil.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label298;
        }
        paramString = new JSONObject(new String(paramString));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        if (paramString != null)
        {
          paramString = ChatActivityUtils.a(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i1 == 1)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label244:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label298:
      paramString = null;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramString1);
    paramIntent.setClassName(paramString2, paramString3);
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   7: ifnull +341 -> 348
    //   10: aload_0
    //   11: getfield 672	com/tencent/mobileqq/utils/JumpAction:d	Z
    //   14: ifeq +334 -> 348
    //   17: aload_0
    //   18: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   21: getfield 2064	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   24: invokevirtual 1783	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   27: sipush 769
    //   30: if_icmpne +318 -> 348
    //   33: aload_0
    //   34: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   37: getfield 2067	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   40: invokevirtual 1783	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   43: istore 6
    //   45: aload_0
    //   46: getfield 693	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   49: ldc_w 433
    //   52: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 659	java/lang/String
    //   58: invokestatic 888	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: istore 4
    //   63: aload_0
    //   64: getfield 688	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 2070	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   70: ldc_w 2072
    //   73: iconst_0
    //   74: invokevirtual 2078	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   77: astore_3
    //   78: aload_3
    //   79: new 910	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 911	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 2080
    //   89: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 688	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   96: invokevirtual 738	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   99: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 920	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: invokeinterface 2085 3 0
    //   111: istore 7
    //   113: aload_3
    //   114: invokeinterface 2089 1 0
    //   119: new 910	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 911	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 2080
    //   129: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: getfield 688	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 738	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   139: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 920	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: iconst_0
    //   146: invokeinterface 2094 3 0
    //   151: invokeinterface 2097 1 0
    //   156: pop
    //   157: aload_0
    //   158: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   161: getfield 1794	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   164: invokevirtual 1797	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   167: ifeq +361 -> 528
    //   170: new 2036	org/json/JSONObject
    //   173: dup
    //   174: aload_0
    //   175: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   178: getfield 1794	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   181: invokevirtual 1799	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   184: invokespecial 2040	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   192: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   195: invokevirtual 2104	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   198: ifeq +330 -> 528
    //   201: aload_0
    //   202: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   205: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   208: invokevirtual 2105	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   211: ifne +317 -> 528
    //   214: ldc_w 400
    //   217: aload_3
    //   218: ldc_w 1944
    //   221: invokevirtual 2109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   224: aload_0
    //   225: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   231: iconst_0
    //   232: invokevirtual 2112	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   235: checkcast 659	java/lang/String
    //   238: invokevirtual 2109	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   241: ldc_w 2114
    //   244: invokevirtual 2044	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokevirtual 702	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: istore 8
    //   252: iload 8
    //   254: ifeq +274 -> 528
    //   257: aload_1
    //   258: ldc_w 2116
    //   261: iload 5
    //   263: invokevirtual 754	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   266: pop
    //   267: aload_1
    //   268: ldc_w 2118
    //   271: iload 6
    //   273: invokevirtual 754	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   276: pop
    //   277: aload_1
    //   278: ldc_w 2120
    //   281: iload 7
    //   283: invokevirtual 754	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   286: pop
    //   287: aload_1
    //   288: ldc_w 2122
    //   291: iload 4
    //   293: invokevirtual 754	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   296: pop
    //   297: aload_0
    //   298: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   301: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   304: invokevirtual 2104	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   307: ifeq +41 -> 348
    //   310: aload_0
    //   311: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   314: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   317: invokevirtual 2105	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   320: ifne +28 -> 348
    //   323: aload_1
    //   324: ldc_w 2124
    //   327: new 1366	java/util/ArrayList
    //   330: dup
    //   331: aload_0
    //   332: getfield 1773	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   335: getfield 2101	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   338: invokevirtual 2127	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   341: invokespecial 2130	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   344: invokevirtual 2134	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   347: pop
    //   348: aload_1
    //   349: ldc_w 2136
    //   352: aload_0
    //   353: getfield 688	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   356: invokevirtual 738	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   359: invokevirtual 935	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   362: pop
    //   363: aload_1
    //   364: ldc_w 2138
    //   367: iconst_1
    //   368: invokevirtual 770	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   371: pop
    //   372: aload_1
    //   373: ldc_w 2140
    //   376: iconst_1
    //   377: invokevirtual 770	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   380: pop
    //   381: aload_1
    //   382: ldc_w 2142
    //   385: aload_0
    //   386: getfield 688	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   389: invokevirtual 738	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   392: invokevirtual 935	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   395: pop
    //   396: aload_1
    //   397: ldc_w 2144
    //   400: ldc_w 2146
    //   403: invokevirtual 935	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   406: pop
    //   407: aload_0
    //   408: aload_1
    //   409: invokespecial 1633	com/tencent/mobileqq/utils/JumpAction:a	(Landroid/content/Intent;)V
    //   412: aload_1
    //   413: aload_0
    //   414: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   417: aload_2
    //   418: invokevirtual 2149	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   421: pop
    //   422: getstatic 2152	com/qqreader/QRBridgeActivity:jdField_a_of_type_Boolean	Z
    //   425: ifne +3 -> 428
    //   428: getstatic 2153	com/qqreader/QRBridgeActivity:jdField_b_of_type_Boolean	Z
    //   431: ifne +68 -> 499
    //   434: aload_0
    //   435: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   438: invokevirtual 1609	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   441: ldc_w 2154
    //   444: invokevirtual 2157	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   447: istore 4
    //   449: new 2159	com/tencent/mobileqq/widget/QQProgressDialog
    //   452: dup
    //   453: aload_0
    //   454: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   457: iload 4
    //   459: invokespecial 2162	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   462: astore_2
    //   463: aload_2
    //   464: ldc_w 2164
    //   467: invokevirtual 2166	com/tencent/mobileqq/widget/QQProgressDialog:a	(Ljava/lang/String;)V
    //   470: new 2168	com/tencent/mobileqq/pluginsdk/SplashDialogWrapper
    //   473: dup
    //   474: aload_0
    //   475: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_2
    //   479: ldc_w 2170
    //   482: ldc_w 2172
    //   485: iconst_1
    //   486: sipush 10000
    //   489: invokespecial 2175	com/tencent/mobileqq/pluginsdk/SplashDialogWrapper:<init>	(Landroid/content/Context;Landroid/app/Dialog;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   492: invokevirtual 2178	com/tencent/mobileqq/pluginsdk/SplashDialogWrapper:show	()V
    //   495: iconst_1
    //   496: putstatic 2153	com/qqreader/QRBridgeActivity:jdField_b_of_type_Boolean	Z
    //   499: aload_0
    //   500: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   503: aload_1
    //   504: invokevirtual 781	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   507: invokestatic 2182	cooperation/qwallet/plugin/QWalletHelper:a	()V
    //   510: iconst_1
    //   511: ireturn
    //   512: astore_3
    //   513: aload_3
    //   514: invokevirtual 903	java/lang/Exception:printStackTrace	()V
    //   517: iconst_0
    //   518: istore 4
    //   520: goto -457 -> 63
    //   523: astore_3
    //   524: aload_3
    //   525: invokevirtual 903	java/lang/Exception:printStackTrace	()V
    //   528: iconst_1
    //   529: istore 5
    //   531: goto -274 -> 257
    //   534: astore_1
    //   535: iconst_1
    //   536: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	JumpAction
    //   0	537	1	paramIntent	Intent
    //   0	537	2	paramString1	String
    //   0	537	3	paramString2	String
    //   61	458	4	i1	int
    //   1	529	5	i2	int
    //   43	229	6	i3	int
    //   111	171	7	i4	int
    //   250	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   45	63	512	java/lang/Exception
    //   170	252	523	java/lang/Exception
    //   422	428	534	java/lang/Exception
    //   428	499	534	java/lang/Exception
    //   499	510	534	java/lang/Exception
  }
  
  private boolean aa()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean ab()
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    try
    {
      localObject1 = URLDecoder.decode((String)localObject1, "UTF-8");
      str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
    }
    catch (Exception localException3)
    {
      try
      {
        l1 = Long.parseLong((String)localObject2);
        localObject2 = new JSONObject();
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            String str5;
            ((JSONObject)localObject2).put("share_from_app", true);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("share_img_list", localObject1);
            localJSONObject.put("share_title", str2);
            localJSONObject.put("share_content", str3);
            localJSONObject.put("share_app_name", str4);
            localJSONObject.put("share_app_id", l1);
            ((JSONObject)localObject2).put("share_info", localJSONObject);
            ((JSONObject)localObject2).put("bid", str5);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPublishActivity.class);
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).putExtra("options", ((JSONObject)localObject2).toString());
            com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
            return true;
            localException1 = localException1;
            String str1 = "";
          }
          localException3 = localException3;
          long l1 = 0L;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + localException2.toString());
            }
          }
        }
      }
    }
  }
  
  private boolean ac()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DeviceQRAgentActivity.class);
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.cI;
    }
    localIntent.putExtra("qrurl", str1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ad()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id") + ", send_uin=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin") + ", hong_bao_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type") + ", hong_bao_summary=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
    localIntent.putExtra("hb_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
    localIntent.putExtra("send_uin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
    localIntent.putExtra("hb_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
    localIntent.putExtra("forward_text", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    localIntent.putExtra("forward_type", 17);
    localIntent.putExtra("display_like_dialog", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ae()
  {
    Object localObject2 = null;
    Object localObject1 = (PortalManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(74);
    if (localObject1 != null) {
      localObject2 = ((PortalManager)localObject1).a(-1L);
    }
    if ((localObject2 == null) || (((PortalManager.PortalConfig)localObject2).hitWording == null) || (((PortalManager.PortalConfig)localObject2).actionUrl == null))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "对不起，当前没有抽奖活动！", 0).a();
      return false;
    }
    Object localObject3 = ((PortalManager.PortalConfig)localObject2).actionUrl;
    localObject1 = localObject3;
    if (!((String)localObject3).contains("fromaio=1")) {
      if (((String)localObject3).indexOf('?') == -1) {
        break label224;
      }
    }
    label224:
    for (localObject1 = (String)localObject3 + "&fromaio=1";; localObject1 = (String)localObject3 + "?fromaio=1")
    {
      localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(100).a(((PortalManager.PortalConfig)localObject2).title).d("QQ抢红包，快参加吧（本次活动仅支持最新版手机QQ）").e((String)localObject1).a(19).a();
      localObject3 = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject3).a(((PortalManager.PortalConfig)localObject2).logoUrl, ((PortalManager.PortalConfig)localObject2).title, ((PortalManager.PortalConfig)localObject2).summary);
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject3);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtra("forward_type", 19);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      return true;
    }
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject).getHeight();
    int i2 = ((Display)localObject).getWidth();
    localObject = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    return str1 + "|" + str2 + "||" + (String)localObject + "||" + i1 + "|";
  }
  
  private String b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("i="))) {
      return null;
    }
    int i3 = paramString.indexOf("i=");
    int i2 = paramString.substring(i3).indexOf('&');
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramString.length() - i3;
    }
    return paramString.substring("i=".length() + i3, i1 + i3);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131369853, 2131369852, 2131369854, 2131369855, new krq(this), new krr(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private String c()
  {
    return "mqqapi://" + this.cJ + "/" + this.cK + "?src_type=" + this.cN;
  }
  
  private String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void c()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label79:
    String str3;
    label107:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label329;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label336;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label343;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label351;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label135:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label359;
      }
    }
    label329:
    label336:
    label343:
    label351:
    label359:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((QWalletAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(44)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Krx = new krx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Krx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label79;
      str3 = "";
      break label107;
      str4 = "";
      break label135;
    }
  }
  
  private void d()
  {
    com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        a(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(1);
    }
  }
  
  private void e()
  {
    try
    {
      if ("head".equals(this.cK))
      {
        if (this.jdField_a_of_type_Krw == null) {
          this.jdField_a_of_type_Krw = new krw(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Krw);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.c(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("JumpAction", 2, "handleMQQService error " + localException.toString());
      }
    }
  }
  
  private void e(String paramString)
  {
    if ("app".equals(this.cN)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.cN))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.cN));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private boolean e()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    String str1;
    String str2;
    label68:
    String str3;
    label95:
    String str4;
    label123:
    String str5;
    label151:
    label296:
    label323:
    label351:
    label379:
    String str6;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url")) {
        break label536;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label543;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subject")) {
        break label550;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label558;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      localIntent.putExtra("fromWhere", str1);
      localIntent.putExtra("webUrl", str2);
      localIntent.putExtra("fromType", str5);
      localIntent.putExtra("subject", str4);
      localIntent.putExtra("is_from_web", true);
      if ("10002".equals(str3))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter")) {
        break label566;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
      label259:
      if ("1".equals(str1))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
          break label573;
        }
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
          break label580;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
          break label587;
        }
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
          break label595;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
          break label603;
        }
        str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
        label407:
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
          break label611;
        }
      }
    }
    label536:
    label543:
    label550:
    label558:
    label566:
    label573:
    label580:
    label587:
    label595:
    label603:
    label611:
    for (String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");; str7 = "")
    {
      localIntent.putExtra("filter", str1);
      localIntent.putExtra("filterGender", str2);
      localIntent.putExtra("filter_time", str3);
      localIntent.putExtra("filter_age", str4);
      localIntent.putExtra("filter_xingzuo", str5);
      localIntent.putExtra("filter_career", str6);
      localIntent.putExtra("filter_location", str7);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      str1 = "";
      break;
      str2 = "";
      break label68;
      str3 = "";
      break label95;
      str4 = "";
      break label123;
      str5 = "";
      break label151;
      str1 = "";
      break label259;
      str2 = "";
      break label296;
      str3 = "";
      break label323;
      str4 = "";
      break label351;
      str5 = "";
      break label379;
      str6 = "";
      break label407;
    }
  }
  
  private void f(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(IndividuationSetActivity.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.a();
    }
  }
  
  private boolean f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TurnBrandActivity.class);
    String str1;
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label180;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      label68:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label187;
      }
    }
    label180:
    label187:
    for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");; str3 = "")
    {
      localIntent.putExtra("src_type", str1);
      localIntent.putExtra("from_type", str2);
      localIntent.putExtra("is_from_web", true);
      localIntent.addFlags(67108864);
      if ("10002".equals(str3))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      str1 = "";
      break;
      str2 = "";
      break label68;
    }
  }
  
  private boolean g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HotChatListActivity.class);
    String str1;
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label180;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      label68:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label187;
      }
    }
    label180:
    label187:
    for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");; str3 = "")
    {
      localIntent.putExtra("src_type", str1);
      localIntent.putExtra("from_type", str2);
      localIntent.putExtra("is_from_web", true);
      localIntent.addFlags(67108864);
      if ("10002".equals(str3))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      str1 = "";
      break;
      str2 = "";
      break label68;
    }
  }
  
  private boolean h()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str1); str1 = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), "该热聊不存在，换个热聊试试吧。", 1).a();
      return false;
    }
    String str2;
    String str3;
    label109:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label187;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label194;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
        break label202;
      }
    }
    label187:
    label194:
    label202:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");; str5 = "")
    {
      NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, str4, str5, 1, str1);
      return true;
      str2 = "";
      break;
      str3 = "";
      break label109;
      str4 = "";
      break label137;
    }
  }
  
  private boolean i()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str3;
      label53:
      label79:
      Intent localIntent;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type"))
      {
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
          break label554;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label557;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, VipMapRoamActivity.class);
        if ("web".equals(str1)) {
          localIntent.putExtra("is_from_web", true);
        }
        if ("10002".equals(str3))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("lat")) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("lon"))) {}
      }
      try
      {
        int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lat"));
        int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lon"));
        localIntent.putExtra("lat", i1);
        localIntent.putExtra("lon", i2);
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
          if ("1".equals(str1))
          {
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
              break label593;
            }
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label601;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label609;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label617;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label625;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label633;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
            localIntent.putExtra("filter", str1);
            localIntent.putExtra("filterGender", str3);
            localIntent.putExtra("filter_time", str4);
            localIntent.putExtra("filter_age", str5);
            localIntent.putExtra("filter_xingzuo", str6);
            localIntent.putExtra("filter_career", str7);
            localIntent.putExtra("filter_location", str8);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
          str1 = "";
          continue;
          break label53;
          label554:
          break label79;
          label557:
          str3 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str4;
          String str5;
          String str6;
          String str7;
          String str8;
          if (QLog.isColorLevel())
          {
            QLog.i("JumpAction", 2, localException.toString());
            continue;
            String str2 = "";
            continue;
            label593:
            str3 = "";
            continue;
            label601:
            str4 = "";
            continue;
            label609:
            str5 = "";
            continue;
            label617:
            str6 = "";
            continue;
            label625:
            str7 = "";
            continue;
            label633:
            str8 = "";
          }
        }
      }
    }
  }
  
  private boolean j()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DatingFeedActivity.class);
    Object localObject2;
    label70:
    String str1;
    label146:
    label173:
    label200:
    String str2;
    label228:
    String str3;
    label256:
    DatingFilters localDatingFilters;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label746;
      }
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      localIntent.putExtra("is_from_web", true);
      if ("10002".equals(localObject2))
      {
        localIntent.putExtra("abp_flag", true);
        localIntent.addFlags(268435456);
      }
      if (((String)localObject1).equals("1"))
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
          break label753;
        }
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
          break label760;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_content")) {
          break label767;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_content");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
          break label774;
        }
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
          break label782;
        }
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
        localDatingFilters = new DatingFilters(this.jdField_a_of_type_AndroidContentContext);
        localDatingFilters.d = Integer.valueOf((String)localObject1).intValue();
        localDatingFilters.e = Integer.valueOf((String)localObject2).intValue();
        localDatingFilters.g = Integer.valueOf(str1).intValue();
        localDatingFilters.f = localDatingFilters.b(localDatingFilters.g);
        localDatingFilters.h = Integer.valueOf(str2).intValue();
        localDatingFilters.i = Integer.valueOf(str3).intValue();
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
          break label790;
        }
      }
    }
    label774:
    label782:
    label790:
    for (Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");; localObject1 = "")
    {
      localDatingFilters.a = null;
      if (!((String)localObject1).equals(""))
      {
        localDatingFilters.a = new appoint_define.LocaleInfo();
        localObject1 = ((String)localObject1).split("\\|", -1);
        if (!TextUtils.isEmpty(localObject1[0])) {
          localDatingFilters.a.str_country.set(localObject1[0]);
        }
        if (!TextUtils.isEmpty(localObject1[1])) {
          localDatingFilters.a.str_province.set(localObject1[1]);
        }
        if (!TextUtils.isEmpty(localObject1[2])) {
          localDatingFilters.a.str_city.set(localObject1[2]);
        }
        if (!TextUtils.isEmpty(localObject1[3])) {
          localDatingFilters.a.str_region.set(localObject1[3]);
        }
        if (!TextUtils.isEmpty(localObject1[4])) {
          localDatingFilters.a.str_poi.set(localObject1[4]);
        }
        if (!TextUtils.isEmpty(localObject1[5])) {
          localDatingFilters.a.str_name.set(localObject1[5]);
        }
        localObject2 = new appoint_define.GPS();
        if (!TextUtils.isEmpty(localObject1[6])) {
          ((appoint_define.GPS)localObject2).int32_type.set(Integer.valueOf(localObject1[6]).intValue());
        }
        if (!TextUtils.isEmpty(localObject1[7])) {
          ((appoint_define.GPS)localObject2).int32_lat.set(Integer.valueOf(localObject1[7]).intValue());
        }
        if (!TextUtils.isEmpty(localObject1[8])) {
          ((appoint_define.GPS)localObject2).int32_lon.set(Integer.valueOf(localObject1[8]).intValue());
        }
        if (!TextUtils.isEmpty(localObject1[9])) {
          ((appoint_define.GPS)localObject2).int32_alt.set(Integer.valueOf(localObject1[9]).intValue());
        }
        localDatingFilters.a.msg_gps.set((MessageMicro)localObject2);
        if ((localObject1.length > 10) && (!TextUtils.isEmpty(localObject1[10]))) {
          localDatingFilters.a.str_address.set(localObject1[10]);
        }
      }
      localIntent.putExtra("filter", localDatingFilters);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localObject1 = "";
      break;
      label746:
      localObject2 = "";
      break label70;
      label753:
      localObject1 = "0";
      break label146;
      label760:
      localObject2 = "0";
      break label173;
      label767:
      str1 = "0";
      break label200;
      str2 = "0";
      break label228;
      str3 = "0";
      break label256;
    }
  }
  
  private boolean k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicDatingActivity.class);
    String str1;
    String str2;
    label68:
    String str3;
    label96:
    String str4;
    label124:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url")) {
        break label274;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        break label281;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label289;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subject")) {
        break label297;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");
      if (TextUtils.isEmpty(str3)) {
        break label314;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.valueOf(str3).intValue();
        if (i1 == 10002)
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        localIntent.putExtra("fromWhere", str1);
        localIntent.putExtra("webUrl", str2);
        localIntent.putExtra("fromType", str4);
        localIntent.putExtra("subject", str5);
        localIntent.putExtra("is_from_web", true);
        localIntent.addFlags(67108864);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
        str1 = "";
        break;
        label274:
        str2 = "";
        break label68;
        label281:
        str3 = "";
        break label96;
        label289:
        str4 = "";
        break label124;
        label297:
        str5 = "";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i1 = 10001;
        continue;
      }
      label314:
      int i1 = 10001;
    }
  }
  
  private boolean l()
  {
    String str1;
    Object localObject;
    label51:
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("dating_id"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dating_id");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
        break label123;
      }
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
        break label131;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      label79:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subject")) {
        break label139;
      }
    }
    label131:
    label139:
    for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");; str3 = "")
    {
      if (!TextUtils.isEmpty(str1)) {
        break label147;
      }
      return false;
      str1 = "";
      break;
      label123:
      localObject = "";
      break label51;
      str2 = "";
      break label79;
    }
    label147:
    if (!TextUtils.isEmpty(str3)) {
      try
      {
        i1 = Integer.valueOf(str3).intValue();
        if (!DatingShareHelper.a(i1))
        {
          str1 = String.format("https://play.mobile.qq.com/play/mqqplay/appoint/appointtrans.jsp?bid=%s&_wv=1025&adtag=%s&subject=%s", new Object[] { str1, "web", str3 });
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", URLUtil.guessUrl(str1));
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i1 = 0;
        }
      }
    }
    if (("internal".equals(localObject)) && ("3".equals(str2))) {}
    label396:
    label403:
    for (int i1 = 1002;; i1 = 1001)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from"))
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label396;
        }
      }
      for (;;)
      {
        try
        {
          i2 = Integer.valueOf((String)localObject).intValue();
          if (i2 == 10002)
          {
            DatingDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, str1, 0, i1, null, true, true);
            return true;
            if ((!"internal".equals(localObject)) || (!"2".equals(str2))) {
              break label403;
            }
            i1 = 1009;
            break;
            localObject = "";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i2 = 10001;
          continue;
          DatingDetailActivity.a(this.jdField_a_of_type_AndroidContentContext, str1, 0, i1, null, false, true);
          return true;
        }
        int i2 = 10001;
      }
    }
  }
  
  private boolean m()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()); str = "")
    {
      b();
      return false;
    }
    c();
    return false;
  }
  
  private boolean n()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", "消息");
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", c((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean o()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean p()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", 1);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i1);
      localIntent.putExtra("source", this.cI);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Receive error appid number format");
      }
    }
    return false;
  }
  
  private boolean q()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((localObject2 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, (String)localObject2 + "");
    }
    Object localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    int i1;
    if ("c2c".equals(localObject5))
    {
      if ((str1 == null) || (str1.length() < 5)) {
        return false;
      }
      if (((FriendManager)localObject1).b(str1))
      {
        i1 = 0;
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      }
    }
    for (;;)
    {
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      ((Intent)localObject3).putExtra("uin", str1);
      ((Intent)localObject3).putExtra("uintype", i1);
      if (localObject1 != null) {
        ((Intent)localObject3).putExtra("uinname", (String)localObject1);
      }
      if (str2 != null) {
        ((Intent)localObject3).putExtra("input_text", str2);
      }
      if ((localObject2 == null) || ("".equals(localObject2))) {
        break label1385;
      }
      if ((str1 != null) && (!"".equals(str1))) {
        break label1125;
      }
      return false;
      return false;
      if ("discuss".equals(localObject5))
      {
        if ((str1 == null) || (str1.length() < 6)) {
          return false;
        }
        i1 = 3000;
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      }
      else if ("group".equals(localObject5))
      {
        if ((str1 == null) || (str1.length() < 6)) {
          return false;
        }
        localObject1 = ((FriendManager)localObject1).a(str1);
        if (localObject1 != null)
        {
          i1 = 1;
          localObject1 = ((TroopInfo)localObject1).troopname;
        }
        else
        {
          return false;
        }
      }
      else
      {
        if ("opengroup".equals(localObject5))
        {
          if ((str1 == null) || (str1.length() < 6)) {
            return false;
          }
          localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("group_info"));
          for (;;)
          {
            try
            {
              localObject4 = new JSONObject((String)localObject1);
              localObject1 = ((JSONObject)localObject4).optString("troopName");
              str2 = ((JSONObject)localObject4).optString("location");
              localObject2 = ((JSONObject)localObject4).optString("intro");
              localObject3 = ((JSONObject)localObject4).optString("groupCode");
              i1 = 0;
              i3 = 0;
            }
            catch (JSONException localJSONException)
            {
              int i3;
              int i2;
              int i4;
              String str3;
              continue;
            }
            try
            {
              i2 = Integer.parseInt(((JSONObject)localObject4).optString("memberCnt"));
              i1 = i2;
              i4 = Integer.parseInt(((JSONObject)localObject4).optString("distance"));
              i1 = i4;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              i2 = i1;
              i1 = i3;
            }
          }
          localObject4 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          new NearbyOpenTroop(str1, (String)localObject1, (Activity)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseActivity)localObject4).getTitleBarHeight()).a(true, new GroupInfo(Long.parseLong(str1), (String)localObject1, str2, i2, (String)localObject2, 0, false, i1, i2, 0L, 0, 0, 0L, 0L, 0L, false, 0L, 0L, null), (String)localObject3);
          return true;
        }
        if (!"robot".equals(localObject5)) {
          break;
        }
        if ((str1 == null) || ("".equals(str1))) {
          return false;
        }
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 1001;
      }
    }
    if ("wpa".equals(localObject5))
    {
      if (((FriendManager)localObject1).b(str1))
      {
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 0;
      }
      for (;;)
      {
        e(str1);
        break;
        i1 = 1005;
        localObject1 = null;
      }
    }
    if ("crm".equals(localObject5))
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      if (((FriendManager)localObject1).b(str1))
      {
        localObject1 = ((FriendManager)localObject1).a(str1);
        i1 = 0;
      }
      for (;;)
      {
        if (BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, str1))
        {
          ((Intent)localObject2).putExtra("isBack2Root", true);
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("kfnick")) && (!TextUtils.isEmpty(str1))) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfnick"));
          }
          localObject5 = new HashMap();
          ((HashMap)localObject5).put("a_actionData", this.jdField_a_of_type_JavaUtilHashMap.toString());
          ((HashMap)localObject5).put("uin", str1);
          ((HashMap)localObject5).put("uin_type", String.valueOf(i1));
          StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSwitchToCrmExt", true, -1L, -1L, (HashMap)localObject5, "", true);
        }
        ((Intent)localObject2).putExtra("uin", str1);
        ((Intent)localObject2).putExtra("uintype", i1);
        if (localObject1 != null) {
          ((Intent)localObject2).putExtra("uinname", (String)localObject1);
        }
        if (str2 != null) {
          ((Intent)localObject2).putExtra("input_text", str2);
        }
        if ((localNumberFormatException != null) && (str1 != null))
        {
          localObject1 = HexUtil.hexStr2Bytes(localNumberFormatException);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject1);
        }
        if (localObject3 != null) {
          ((Intent)localObject2).putExtra("sigt", HexUtil.hexStr2Bytes((String)localObject3));
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, "", "");
        return true;
        if (BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, str1))
        {
          localObject1 = null;
          i1 = 1025;
        }
        else
        {
          ((Intent)localObject2).putExtra("chat_subType", 1);
          localObject1 = null;
          i1 = 1024;
        }
      }
    }
    return false;
    label1125:
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
    str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
    str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    if ((localObject1 != null) && (!"".equals(localObject1))) {
      ((Intent)localObject3).putExtra("callback_type", (String)localObject1);
    }
    if ((str2 != null) && (!"".equals(str2))) {
      ((Intent)localObject3).putExtra("thirdAppDisplayName", str2);
    }
    if ((str3 != null) && (!"".equals(str3))) {
      ((Intent)localObject3).putExtra("appid", str3);
    }
    a((Intent)localObject3, (String)localObject2);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
    if ("webview".equals(this.jdField_do))
    {
      ((Intent)localObject3).putExtra("from", this.jdField_do);
      if (jdField_b_of_type_Int > 3)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "对话框打开数已达到上限", 1).a();
        return true;
      }
      jdField_b_of_type_Int += 1;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      label1385:
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
      return true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str1, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
    }
  }
  
  private boolean r()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null) {
      return false;
    }
    localObject = ((FriendManager)localObject).a(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).troopname;
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return D();
  }
  
  private boolean s()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str1 != null) && (str2 != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str1.trim());
        int i1 = Integer.parseInt(str2.trim());
        str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        if (str1 == null)
        {
          this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("filter", 0));
          return true;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class).putExtra("lat", i1).putExtra("lon", i2).putExtra("title", str1).putExtra("filter", 0));
        continue;
        i1 = 0;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i2 = 0;
    }
  }
  
  private boolean t()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((localObject != null) && (str != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(((String)localObject).trim());
        i2 = i1;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i1 = Integer.parseInt(str.trim());
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyTroopsActivity.class);
          ((Intent)localObject).putExtra("lat", i1);
          ((Intent)localObject).putExtra("lon", i2);
          ((Intent)localObject).putExtra("from", 4);
          ((Intent)localObject).putExtra("mode", 0);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return true;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            i1 = i2;
          }
        }
        localNumberFormatException1 = localNumberFormatException1;
        i1 = 0;
      }
      int i1 = 0;
      continue;
      i1 = 0;
      int i2 = 0;
    }
  }
  
  private boolean u()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {}
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a((Activity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean v()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopActivity.class);
    localIntent.putExtra("fromH5", true);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("initgrouptype");
    if (("1".equals(str)) || ("0".equals(str)) || ("2".equals(str))) {
      localIntent.putExtra("troopType", str);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent.putExtra("troopType", "DEFAULT");
    }
  }
  
  private boolean w()
  {
    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
    return true;
  }
  
  private boolean x()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    return a(localIntent, "com.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean y()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 693	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 260
    //   7: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 659	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 693	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 263
    //   22: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 659	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +140 -> 172
    //   35: aload 7
    //   37: ifnull +135 -> 172
    //   40: aload 6
    //   42: invokevirtual 1102	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 888	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2753
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 1102	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 888	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 2753
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 693	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: ldc_w 266
    //   80: invokevirtual 698	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 659	java/lang/String
    //   86: invokespecial 991	com/tencent/mobileqq/utils/JumpAction:c	(Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: new 910	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 911	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 1753
    //   100: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: dload_3
    //   104: invokevirtual 2757	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   107: ldc_w 1758
    //   110: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: dload_1
    //   114: invokevirtual 2757	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   117: ldc_w 2759
    //   120: invokevirtual 917	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 920	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 6
    //   128: new 743	android/content/Intent
    //   131: dup
    //   132: ldc_w 1987
    //   135: aload 6
    //   137: invokestatic 1942	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   140: invokespecial 2762	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   143: astore 7
    //   145: aload 7
    //   147: ldc_w 2764
    //   150: ldc_w 2766
    //   153: invokevirtual 1768	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload_0
    //   158: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   161: aload 7
    //   163: invokevirtual 781	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore 6
    //   170: iconst_0
    //   171: ireturn
    //   172: iconst_0
    //   173: ireturn
    //   174: astore 7
    //   176: aload_0
    //   177: getfield 686	com/tencent/mobileqq/utils/JumpAction:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   180: new 743	android/content/Intent
    //   183: dup
    //   184: ldc_w 1987
    //   187: aload 6
    //   189: invokestatic 1942	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   192: invokespecial 2762	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   195: invokevirtual 781	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   198: goto -32 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	JumpAction
    //   53	61	1	d1	double
    //   71	33	3	d2	double
    //   62	3	5	i1	int
    //   13	123	6	str	String
    //   168	20	6	localException	Exception
    //   28	134	7	localObject	Object
    //   174	1	7	localActivityNotFoundException	ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	168	java/lang/Exception
    //   157	166	174	android/content/ActivityNotFoundException
  }
  
  private boolean z()
  {
    if ("webview".equals(this.jdField_do))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.cN).putExtra("callback_type", this.cO).putExtra("callback_name", this.cP));
    }
    return true;
  }
  
  public String a()
  {
    return this.cJ;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_do = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.c);
    }
  }
  
  public boolean a()
  {
    new krp(this).start();
    return b();
  }
  
  public void b(String paramString)
  {
    this.dp = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean b()
  {
    this.cL = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.cM = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.cN = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.cO = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.cP = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    if (("wallet".equals(this.cJ)) && ("open".equals(this.cK)) && ("0".equals(localObject1)) && (!TextUtils.isEmpty(this.cN))) {
      return o();
    }
    if ((this.cJ.equals("wpa")) && (this.cK.equals("openid_to_uin"))) {
      return p();
    }
    if ((this.cJ.equals("im")) && (this.cK.equals("chat"))) {
      return q();
    }
    if ((this.cJ.equals("im")) && (this.cK.equals("aioorprofile"))) {
      return r();
    }
    if (this.cJ.equals("qapp")) {
      return Z();
    }
    if ((this.cJ.equals("lbs")) && (this.cK.equals("show_nearby_fri"))) {
      return s();
    }
    if ((this.cJ.equals("lbs")) && (this.cK.equals("show_location"))) {
      return y();
    }
    if ((this.cJ.equals("lbs")) && (this.cK.equals("select_location"))) {
      return z();
    }
    if ((this.cJ.equals("card")) && (this.cK.equals("show_pslcard"))) {
      return A();
    }
    if ((this.cJ.equals("upload")) && (this.cK.equals("photo"))) {
      return G();
    }
    if ((this.cJ.equals("forward")) && (this.cK.equals("url"))) {
      return I();
    }
    if ((this.cJ.equals("gamesdk")) && (this.cK.equals("bind_group"))) {
      return H();
    }
    if ((this.cJ.equals("share")) && (this.cK.equals("to_fri"))) {
      return J();
    }
    if ((this.cJ.equals("share")) && (this.cK.equals("to_qqdataline"))) {
      return Y();
    }
    if ((this.cJ.equals("gamesdk")) && (this.cK.equals("add_friend"))) {
      return K();
    }
    if ((this.cJ.equals("share")) && (this.cK.equals("to_qqfav"))) {
      return M();
    }
    if ((this.cJ.equals("share")) && (this.cK.equals("to_qzone"))) {
      return N();
    }
    if ((this.cJ.equals("qzone")) && (this.cK.equals("writemood"))) {
      return O();
    }
    if ((this.cJ.equals("qzone")) && (this.cK.equals("to_publish_queue"))) {
      return P();
    }
    if ((this.cJ.equals("qzone")) && (this.cK.equals("open_homepage"))) {
      return Q();
    }
    if ((this.cJ.equals("qzone")) && (this.cK.equals("groupalbum"))) {
      return L();
    }
    if (this.cJ.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      e();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (this.cJ.endsWith("app"))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "handleAppForward");
                }
                return X();
              }
              if ((this.cJ.equals("qm")) && (this.cK.equals("qr"))) {
                return E();
              }
              if ((this.cJ.equals("tenpay")) && (this.cK.equals("pay"))) {
                return F();
              }
              if ((this.cJ.equals("dc")) && (this.cK.equals("ft"))) {
                return R();
              }
              if ((this.cJ.equals("group")) && (this.cK.equals("nearby"))) {
                return t();
              }
              if ((this.cJ.equals("group")) && (this.cK.equals("create"))) {
                return u();
              }
              if ((this.cJ.equals("group")) && (this.cK.equals("creategroup"))) {
                return v();
              }
              if ((this.cJ.equals("shop")) && (this.cK.equals("emoji")))
              {
                EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                return true;
              }
              if ((this.cJ.equals("shop")) && (this.cK.equals("emoji_detail")))
              {
                EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, a("detailid"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                return true;
              }
              if ((this.cJ.equals("shop")) && (this.cK.equals("emoji_author")))
              {
                EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, a("authorid"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
                return true;
              }
              if ((this.cJ.equals("shop")) && (this.cK.equals("bubble")))
              {
                VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "https://imgcache.qq.com/club/themes/mobile/bubble/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&updateTime=[updateTime]&updateFlag=[updateFlag]&updateId=[updateId]&adTag=mvip.gongneng.android.bubble.index_dynamic_tab&_bid=122&_wv=1027", 64L, null, false, -1);
                return true;
              }
              if ((!this.cJ.equals("shop")) || (!this.cK.equals("theme"))) {
                break;
              }
            } while ((!BaseApplicationImpl.jdField_a_of_type_Boolean) || (!Utils.e()));
            VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, "https://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, null, false, -1);
            return true;
            if ((!this.cJ.equals("shop")) || (!this.cK.equals("font"))) {
              break;
            }
          } while ((!((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a()) || (!Utils.e()));
          VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, VasWebviewConstants.CHAT_FONT_MARKET_HOME_URL, 4096L, null, false, -1);
          return true;
          if ((this.cJ.equals("shop")) && (this.cK.equals("pendant")))
          {
            if (Utils.e()) {
              AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
            }
            return true;
          }
          if ((this.cJ.equals("readingcenter")) && (this.cK.equals("open"))) {
            return x();
          }
          String str;
          if ((this.cJ.equals("healthcenter")) && (this.cK.equals("open")))
          {
            str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
            if ((str == null) || ((!str.startsWith("http://")) && (!str.startsWith("https://"))) || ((!Util.c(str).equalsIgnoreCase("qq.com")) && (!Util.c(str).equalsIgnoreCase("myun.tenpay.com")) && (!Util.c(str).equalsIgnoreCase("tenpay.com")) && (!Util.c(str).equalsIgnoreCase("wanggou.com")))) {
              return false;
            }
            localObject1 = str;
            if (str.indexOf("?") <= 0) {
              localObject1 = str + "?";
            }
            localObject1 = new StringBuilder((String)localObject1);
            ((StringBuilder)localObject1).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append("&version=").append("5.9.3.3468").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&adtag=mvip.gongneng.anroid.health.nativet");
            VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, ((StringBuilder)localObject1).toString(), 65536L, null, false, -1);
            return true;
          }
          if ((this.cJ.equals("ptlogin")) && (this.cK.equals("qlogin"))) {
            return S();
          }
          if ((this.cJ.equals("gav")) && (this.cK.equals("request"))) {
            return T();
          }
          if ((this.cJ.equals("videochat")) && (this.cK.equals("request"))) {
            return W();
          }
          if (this.cJ.equals("tribe"))
          {
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
            str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
            Object localObject2;
            if (this.cK.equals("tribe_native"))
            {
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPageActivity.class).putExtra("bid", (String)localObject1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            for (;;)
            {
              if ((localObject1 != null) && (str != null)) {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, (String)localObject1, Util.b(str, new String[0]), "", "");
              }
              return true;
              if (this.cK.equals("web"))
              {
                localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
                try
                {
                  localObject2 = URLDecoder.decode((String)localObject2);
                  localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject2);
                  ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                  ((Intent)localObject2).putExtra("hide_operation_bar", true);
                  ((Intent)localObject2).putExtra("hideRightButton", true);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                }
                catch (Exception localException)
                {
                  if (QLog.isDevelopLevel()) {
                    QLog.e("JumpAction", 4, "URLDecoder.decode error");
                  }
                  return false;
                }
              }
            }
          }
          if ((this.cJ.equals("crmivr")) && (this.cK.equals("audiochat"))) {
            return U();
          }
          if ((this.cJ.equals("crmivr")) && (this.cK.equals("imchat"))) {
            return V();
          }
          if ((this.cJ.equals("qqdataline")) && (this.cK.equals("openqqdataline"))) {
            return n();
          }
          if ((this.cJ.equals("wallet")) && (this.cK.equals("modify_pass"))) {
            return m();
          }
          if (!this.cJ.equals("dating")) {
            break;
          }
          if (this.cK.equals("detail")) {
            return l();
          }
          if (this.cK.equals("publish")) {
            return k();
          }
        } while (!this.cK.equals("feed"));
        return j();
        if (!this.cJ.equals("nearby_entry")) {
          break;
        }
        if (this.cK.equals("nearby_feed")) {
          return e();
        }
        if (this.cK.equals("nearby_profile")) {
          return B();
        }
        if (this.cK.equals("turn_brand")) {
          return f();
        }
        if (this.cK.equals("hotchat_list")) {
          return g();
        }
        if (this.cK.equals("hotchat_room")) {
          return h();
        }
      } while (!this.cK.equals("vip_map_roam"));
      return i();
      if ((this.cJ.equals("qlink")) && (this.cK.equals("openqlink"))) {
        return aa();
      }
      if ((this.cJ.equals("share")) && (this.cK.equals("to_troopbar"))) {
        return ab();
      }
      if ((this.cJ.equals("qqconnect")) && (this.cK.equals("url"))) {
        return ac();
      }
      if (("tenpay".equals(this.cJ)) && ("sendHongBao".equals(this.cK))) {
        return ad();
      }
      if (("tenpay".equals(this.cJ)) && ("robHongBao".equals(this.cK))) {
        return ae();
      }
      if (("tenpay".equals(this.cJ)) && ("structMsgHongBao".equals(this.cK))) {
        return ae();
      }
    } while ((!"qqwifi".endsWith(this.cJ)) || (!"outweb_start".equals(this.cK)));
    return d();
  }
  
  public void c(String paramString)
  {
    this.ds = paramString;
  }
  
  public boolean c()
  {
    if ((this.cJ.equals("im")) && (this.cK.equals("aioorprofile"))) {}
    while ((this.cJ.equals("group")) && (this.cK.equals("creategroup"))) {
      return true;
    }
    return false;
  }
  
  public void d(String paramString)
  {
    this.dt = paramString;
  }
  
  public boolean d()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bssid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ssid");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "bssid=" + str1 + " ssid=" + str2);
    }
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQWiFiPluginInstallActivity.class);
    localIntent.putExtra("key_is_qqwifi", true);
    localIntent.putExtra("fromoutweb", true);
    localIntent.putExtra("bssid", str1);
    localIntent.putExtra("ssid", str2);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction
 * JD-Core Version:    0.7.0.1
 */