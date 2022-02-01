package com.tencent.mobileqq.app;

import QQService.TagInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.dataline.activities.LiteActivity;
import com.etrump.mixlayout.FontManager;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.recent.RecentCallHandler;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.activity.widget.WidgetController;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.NearbyBannerManager;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.data.TagArrayByType;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.equipmentlock.EquipLockWebImpl;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.PrivacyInfoUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransProxy;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.managers.DiscussionMemberManager;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler;
import com.tencent.mobileqq.pluginsdk.PluginManageHandler.IPluginManagerProvider;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZonePreDownloadManagerImp;
import com.tencent.mobileqq.startup.step.StartService.StartServiceState;
import com.tencent.mobileqq.statistics.QQHDStatisticReportHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportControllerImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUploadingManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PlistHandler;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import com.tencent.mobileqq.utils.sso.SsosvrrHandler;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.SecureModuleService;
import com.tencent.securemodule.service.CloudScanListener;
import com.tencent.securemodule.service.ISecureModuleService;
import com.tencent.securemodule.service.ProductInfo;
import com.tencent.util.BadgeUtils;
import com.tencent.util.MsgAutoMonitorUtil;
import com.weiyun.sdk.context.SdkContext;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginManagerV2;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlinkReliableReport;
import cooperation.qlink.QlinkServiceManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.weiyun.WeiyunHelper;
import hne;
import hnf;
import hng;
import hnh;
import hni;
import hnj;
import hnk;
import hnl;
import hnm;
import hnn;
import hno;
import hnp;
import hnq;
import hnu;
import hnv;
import hnw;
import hnx;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AccountManagerImpl;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.ServletContainer;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.manager.PushManager;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class QQAppInterface
  extends AppInterface
  implements PluginManageHandler.IPluginManagerProvider, IHttpCommunicatorFlowCount
{
  public static final int A = 25;
  private static final String A = "notification";
  public static final int B = 26;
  public static final int C = 27;
  public static final int D = 28;
  public static final int E = 29;
  public static final int F = 30;
  public static final int G = 31;
  public static final int H = 32;
  public static final int I = 33;
  public static final int J = 34;
  public static final int K = 35;
  public static final int L = 36;
  public static final int M = 37;
  public static final int N = 38;
  public static final int O = 39;
  public static final int P = 40;
  public static final int Q = 41;
  public static final int R = 42;
  public static final int S = 43;
  public static final int T = 44;
  public static final int U = 45;
  public static final int V = 46;
  public static final int W = 47;
  public static final int X = 48;
  public static final int Y = 49;
  public static final int Z = 50;
  public static final byte a = 1;
  public static final int a = 1;
  static final long jdField_a_of_type_Long = 2000L;
  private static final Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private static final int[] jdField_a_of_type_ArrayOfInt;
  public static final long[] a;
  public static final int aA = 77;
  public static final int aB = 78;
  public static final int aC = 79;
  public static final int aD = 80;
  public static final int aE = 81;
  public static final int aF = 82;
  public static final int aG = 83;
  public static final int aH = 84;
  public static final int aI = 85;
  public static final int aJ = 86;
  public static final int aK = 87;
  public static final int aM = 0;
  public static final int aN = 1;
  public static final int aP = 1;
  public static final int aQ = 2;
  public static final int aR = 3;
  public static final int aS = 0;
  public static final int aT = 1;
  public static final int aU = 2;
  public static final int aV = 3;
  public static final int aW = 4;
  public static final int aX = 5;
  public static final int aY = 6;
  public static final int aZ = 7;
  public static final int aa = 51;
  public static final int ab = 52;
  public static final int ac = 53;
  public static final int ad = 54;
  public static final int ae = 55;
  public static final int af = 56;
  public static final int ag = 57;
  public static final int ah = 58;
  public static final int ai = 59;
  public static final int aj = 60;
  public static final int ak = 61;
  public static final int al = 62;
  public static final int am = 63;
  public static final int an = 64;
  public static final int ao = 65;
  public static final int ap = 66;
  public static final int aq = 67;
  public static final int ar = 68;
  public static final int as = 69;
  public static final int at = 70;
  public static final int au = 71;
  public static final int av = 72;
  public static final int aw = 73;
  public static final int ax = 74;
  public static final int ay = 75;
  public static final int az = 76;
  public static final byte b = 2;
  public static final int b = 4;
  public static final String b;
  private static final long[] jdField_b_of_type_ArrayOfLong;
  public static final int bA = 34;
  public static final int bB = 35;
  public static final int bC = 36;
  public static final int bD = 37;
  public static final int bE = 38;
  public static final int bF = 39;
  public static final int bG = 40;
  public static final int bH = 41;
  public static final int bI = 42;
  public static final int bJ = 43;
  public static final int bK = 44;
  public static final int bL = 45;
  public static final int bM = 46;
  public static final int bN = 47;
  public static final int bO = 48;
  public static final int bP = 49;
  public static final int bQ = 50;
  public static final int bR = 51;
  public static final int bS = 52;
  public static final int bT = 53;
  public static final int bU = 54;
  public static final int bV = 55;
  public static final int bW = 56;
  public static final int bX = 57;
  public static final int bY = 58;
  public static final int bZ = 59;
  public static final int ba = 8;
  public static final int bb = 9;
  public static final int bc = 10;
  public static final int bd = 11;
  public static final int be = 12;
  public static final int bf = 13;
  public static final int bg = 14;
  public static final int bh = 15;
  public static final int bi = 16;
  public static final int bj = 17;
  public static final int bk = 18;
  public static final int bl = 19;
  public static final int bm = 20;
  public static final int bn = 21;
  public static final int bo = 22;
  public static final int bp = 23;
  public static final int bq = 24;
  public static final int br = 25;
  public static final int bs = 26;
  public static final int bt = 27;
  public static final int bu = 28;
  public static final int bv = 29;
  public static final int bw = 30;
  public static final int bx = 31;
  public static final int by = 32;
  public static final int bz = 33;
  public static final byte c = 3;
  public static final int c = 11;
  private static final long jdField_c_of_type_Long = 86400000L;
  public static final String c = "com.tencent.mobileqq.intent.logout";
  public static final int ca = 60;
  public static final int cb = 61;
  public static final int cc = 3000;
  public static final int cd = 3;
  public static int cg = 0;
  public static int ch = 0;
  public static final int ci = 3;
  public static final int cj = 2;
  public static final int ck = 1;
  private static final int cm = -56;
  private static final int cn = -55;
  private static final int co = 88;
  private static final int cp = 1;
  private static final int cs = 62;
  private static final int ct = 0;
  public static final byte d = 3;
  public static final int d = 100;
  public static final String d = "Q.qqhead.qaif";
  public static boolean d = false;
  public static final byte e = 1;
  public static final int e = 32;
  static final String jdField_e_of_type_JavaLangString = "clean_unread_feed_type";
  private static final byte jdField_f_of_type_Byte = 3;
  public static final int f = 101;
  public static final String f = "com.tencent.msg.newmessage";
  public static final int g = 102;
  private static final long g = 7200000L;
  public static final String g = "round";
  public static final int h = 103;
  public static final String h = "B1_QQ_Neighbor_android";
  public static final int i = 104;
  public static final String i = "NzVK_qGE";
  public static final int j = 8;
  static final String j = "security_scan";
  public static final int k = 9;
  private static final String k = "com.qzone.app.QZoneAppInterface";
  public static final int l = 10;
  private static final String l = "Q.qqhead.broadcast";
  public static final int m = 11;
  private static final String m = "com.tencent.qzone.cleanunreadcount";
  public static final int n = 12;
  private static final String n = "com.tencent.qqhead.getheadreq";
  public static final int o = 13;
  private static final String jdField_o_of_type_JavaLangString = "com.tencent.qqhead.getheadresp";
  public static final int p = 14;
  private static final String jdField_p_of_type_JavaLangString = "";
  public static final int q = 15;
  private static final String q = "";
  public static final int r = 16;
  private static final String r = "";
  public static final int s = 17;
  private static final String s = "";
  public static final int t = 18;
  private static final String t = "com.tencent.minihd.qq:video";
  public static final int u = 19;
  private static final String u = "";
  public static final int v = 20;
  private static final String v = "";
  public static final int w = 21;
  private static final String w = "";
  public static final int x = 22;
  private static final String x = "";
  public static final int y = 23;
  private static final String y = "";
  public static final int z = 24;
  private static final String z = "";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new hnn(this);
  public Intent a;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public Handler a;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  public FloatAioController a;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = null;
  private WidgetController jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetController;
  private CallTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = null;
  private CheckPttListener jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new hnp(this);
  public LebaHelper a;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = null;
  private QQGAudioMsgHandler jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  private CacheManager jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  public Automator a;
  volatile ConversationFacade jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  public volatile QQMessageFacade a;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  public AboutConfig a;
  private Config jdField_a_of_type_ComTencentMobileqqConfigConfig;
  private SigInfo jdField_a_of_type_ComTencentMobileqqDataSigInfo;
  private FileManagerEngine jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  private FileTransferHandler jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  private FileManagerDataCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  private FileManagerNotifyCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  private FileManagerRSCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  private OnlineFileSessionCenter jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  private PrivacyInfoUtil jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  private HwEngine jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private PicPreDownloader jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new hne(this);
  volatile QCallFacade jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  public MobileQQService a;
  private MessageCache jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
  private ReportController jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private ProtoReqManager jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = null;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private CloudScanListener jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener;
  private ISecureModuleService jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  private QQProxyForQlink jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  private QlinkServiceManager jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  Class jdField_a_of_type_JavaLangClass = null;
  Object jdField_a_of_type_JavaLangObject;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_a_of_type_JavaUtilList = new Vector();
  public Set a;
  public boolean a;
  private volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[2];
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[62];
  private Manager[] jdField_a_of_type_ArrayOfMqqManagerManager = new Manager[88];
  public int aL;
  public int aO = 0;
  public long b;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new hnq(this);
  private Intent jdField_b_of_type_AndroidContentIntent = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new hno(this, Looper.getMainLooper());
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  List jdField_b_of_type_JavaUtilList = new Vector();
  public boolean b;
  private BroadcastReceiver jdField_c_of_type_AndroidContentBroadcastReceiver = new hnh(this);
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  List jdField_c_of_type_JavaUtilList = new Vector();
  boolean jdField_c_of_type_Boolean = false;
  private volatile long[] jdField_c_of_type_ArrayOfLong = new long[2];
  public int ce;
  public int cf;
  public int cl = -1;
  private final int cq = 990;
  private final int cr = 991;
  private long jdField_d_of_type_Long = 31L;
  private BroadcastReceiver jdField_d_of_type_AndroidContentBroadcastReceiver = new hni(this);
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  private long jdField_e_of_type_Long = -1L;
  public boolean e;
  private long jdField_f_of_type_Long = 0L;
  public boolean f;
  public boolean g = false;
  boolean h;
  public boolean i = true;
  public volatile boolean j = false;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public boolean n = true;
  private boolean jdField_o_of_type_Boolean;
  private volatile boolean jdField_p_of_type_Boolean;
  
  static
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      String str = "sInjectResult:" + BaseApplicationImpl.sInjectResult;
      try
      {
        throw new IllegalAccessError("QQAppInterface escapes!");
      }
      catch (Throwable localThrowable)
      {
        BaseApplicationImpl.jdField_a_of_type_JavaLangString = str + "\n" + QLog.getStackTraceString(localThrowable);
        QLog.e("DexLoad", 1, "QQAppInterface escapes!");
      }
    }
    for (;;)
    {
      jdField_b_of_type_JavaLangString = QQAppInterface.class.getSimpleName();
      jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
      jdField_b_of_type_ArrayOfLong = new long[] { 100L, 200L, 200L, 100L };
      jdField_a_of_type_ArrayOfLong = new long[] { 100L, 400L, 100L, 400L, 100L, 400L };
      jdField_d_of_type_Boolean = false;
      jdField_a_of_type_ArrayOfInt = new int[] { 17, 18, 8, 19, 28, 27, 25, 26, 41, 47 };
      cg = 300000;
      ch = 30000;
      return;
      BaseApplicationImpl.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  public QQAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Boolean = false;
    this.o = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_e_of_type_Boolean = true;
    this.p = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new hng(this, Looper.getMainLooper());
  }
  
  private boolean A()
  {
    return d() != 0;
  }
  
  private void I()
  {
    SosoSrvAddrProvider.a().b();
  }
  
  private void J()
  {
    IPluginManager localIPluginManager = (IPluginManager)getManager(26);
    if (!localIPluginManager.isPlugininstalled("qzone_plugin.apk"))
    {
      localIPluginManager.a("qzone_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener.onInstallFinish("qzone_plugin.apk");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  private void K()
  {
    Method localMethod = a().getClass().getDeclaredMethod("onDestroy", new Class[0]);
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[0]);
  }
  
  private void L()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      int i1 = BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.size() * 3 / 4;
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.trimToSize(i1);
    }
  }
  
  private void M()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = new HttpCommunicator(this, 128);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a();
  }
  
  private void N()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    if (GuardManager.a != null) {
      GuardManager.a.a(false);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.b();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.e();
    for (;;)
    {
      Object localObject2;
      int i2;
      int i1;
      Object localObject5;
      synchronized (this.jdField_a_of_type_ArrayOfMqqManagerManager)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfMqqManagerManager;
        i2 = localObject2.length;
        i1 = 0;
        if (i1 < i2)
        {
          localObject5 = localObject2[i1];
          if (localObject5 == null) {
            break label271;
          }
          localObject5.onDestroy();
          break label271;
        }
      }
      synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler;
        i2 = localObject2.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject5 = localObject2[i1];
          if (localObject5 != null) {
            localObject5.e();
          }
          i1 += 1;
          continue;
          localObject3 = finally;
          throw localObject3;
        }
        if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener != null) {
          a().unregisterCloudScanListener(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getBaseContext(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
        }
        Q();
        if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
          this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
        }
        FaceDecodeTask.a();
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine.f();
        }
        WeiyunHelper.a();
        ThemeSwitchManager.release();
        SosoInterface.a();
        EquipLockWebImpl.a().a();
        PluginManageHandler.getInstance().setPluginManagerProvider(null, false);
        return;
      }
      label271:
      i1 += 1;
    }
  }
  
  private void O()
  {
    Object localObject = (SubAccountManager)getManager(59);
    if (localObject != null) {}
    for (localObject = ((SubAccountManager)localObject).a();; localObject = null)
    {
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
        return;
      }
      SubAccountControll.a(this, (byte)0, (ArrayList)localObject);
      return;
    }
  }
  
  private void P()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("");
    localIntentFilter.addAction("chatbgBroadcast");
    try
    {
      synchronized (this.jdField_b_of_type_AndroidContentBroadcastReceiver)
      {
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qav.permission.broadcast2", null);
        this.jdField_c_of_type_Boolean = true;
        label114:
        return;
      }
    }
    catch (Exception localException)
    {
      break label114;
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      synchronized (this.jdField_b_of_type_AndroidContentBroadcastReceiver)
      {
        if ((this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_c_of_type_Boolean = false;
        }
        return;
      }
    }
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig = new AboutConfig(this);
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a();
    }
  }
  
  private void S()
  {
    ReportController.a(this, false);
    a(new hnj(this));
    Object localObject = (GameCenterManagerImp)getManager(11);
    if (localObject != null) {
      ((GameCenterManagerImp)localObject).c();
    }
    localObject = (QZoneManager)getManager(9);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "onstart.test if get qzone unread.");
      }
      ((QZoneManager)localObject).b(1);
    }
    f(false);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "zsw subaccount onStart start get sub msg");
    }
    QWalletPushManager.a(this, false);
  }
  
  private void T()
  {
    ReportController.a(this);
  }
  
  private Intent a(Context paramContext, QQMessageFacade.Message paramMessage, int paramInt)
  {
    paramMessage = paramMessage.frienduin;
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    if (String.valueOf(AppConstants.af).equals(paramMessage))
    {
      paramContext = paramContext.getString(2131366652);
      localIntent.putExtra("target_activity", MsgBoxListActivity.class);
    }
    for (;;)
    {
      localIntent.putExtra("tab_index", 1);
      localIntent.addFlags(335544320);
      localIntent.putExtra("uinname", paramContext);
      return localIntent;
      if (String.valueOf(AppConstants.aj).equals(paramMessage))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", NewFriendActivity.class);
        localIntent.putExtra("_key_mode", 3);
      }
      else if (String.valueOf(AppConstants.ak).equals(paramMessage))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", TroopActivity.class);
        localIntent.putExtra("_key_mode", 0);
        localIntent.putExtra("key_tab_mode", 2);
      }
      else if (String.valueOf(AppConstants.ag).equals(paramMessage))
      {
        localIntent.putExtra("target_activity", QQBroadcastActivity.class);
        paramContext = paramContext.getString(2131367458);
      }
      else if (String.valueOf(AppConstants.ac).equals(paramMessage))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", VisitorsActivity.class);
        localIntent.putExtra("votersOnly", true);
        localIntent.putExtra("toUin", Long.valueOf(a()));
      }
      else
      {
        if (!String.valueOf(AppConstants.Y).equals(paramMessage)) {
          break;
        }
        localIntent.putExtra("target_activity", LiteActivity.class);
        paramContext = paramContext.getString(2131362046);
      }
    }
    localIntent.putExtra("target_activity", ChatActivity.class);
    String str;
    if (paramInt == 7000)
    {
      str = paramContext.getString(2131368649);
      localIntent.putExtra("target_activity", SubAccountMessageActivity.class);
      localIntent.putExtra("subAccount", paramMessage);
      paramContext = (SubAccountManager)getManager(59);
      if (paramContext == null) {
        break label565;
      }
    }
    label565:
    for (paramContext = paramContext.c(paramMessage);; paramContext = paramMessage)
    {
      localIntent.putExtra("subAccountLatestNick", paramContext);
      localIntent.putExtra("finishAIO", true);
      paramContext = str;
      for (;;)
      {
        localIntent.putExtra("uin", paramMessage);
        localIntent.putExtra("uintype", paramInt);
        localIntent.setAction("com.tencent.mobileqq.action.CHAT");
        break;
        if (paramInt == 1009)
        {
          paramContext = paramContext.getString(2131366665);
        }
        else if (String.valueOf(1787740092L).equals(paramMessage))
        {
          paramContext = paramContext.getString(2131368622);
        }
        else if (paramInt == 1024)
        {
          localIntent.putExtra("target_activity", ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
          paramContext = ContactUtils.b(this, paramMessage, paramInt);
        }
        else if (paramInt == 1010)
        {
          paramContext = paramContext.getString(2131369778);
          localIntent.putExtra("target_activity", MsgBoxListActivity.class);
        }
        else
        {
          paramContext = ContactUtils.b(this, paramMessage, paramInt);
        }
      }
    }
  }
  
  private Intent a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    if (String.valueOf(AppConstants.af).equals(paramString))
    {
      paramContext = paramContext.getString(2131366652);
      localIntent.putExtra("target_activity", MsgBoxListActivity.class);
      paramString = localIntent;
    }
    for (;;)
    {
      paramString.putExtra("uinname", paramContext);
      paramString.putExtra("tab_index", 1);
      paramString.setFlags(335544320);
      return paramString;
      if (String.valueOf(AppConstants.aj).equals(paramString))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", NewFriendActivity.class);
        localIntent.putExtra("_key_mode", 3);
        paramString = localIntent;
      }
      else if (String.valueOf(AppConstants.ak).equals(paramString))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", TroopActivity.class);
        localIntent.putExtra("_key_mode", 0);
        localIntent.putExtra("key_tab_mode", 2);
        paramString = localIntent;
      }
      else if (String.valueOf(AppConstants.ag).equals(paramString))
      {
        localIntent.putExtra("target_activity", QQBroadcastActivity.class);
        paramContext = paramContext.getString(2131367458);
        paramString = localIntent;
      }
      else if (String.valueOf(AppConstants.ac).equals(paramString))
      {
        paramContext = paramContext.getString(2131367460);
        localIntent.putExtra("target_activity", VisitorsActivity.class);
        localIntent.putExtra("votersOnly", true);
        localIntent.putExtra("toUin", Long.valueOf(a()));
        paramString = localIntent;
      }
      else
      {
        if (!String.valueOf(AppConstants.Y).equals(paramString)) {
          break;
        }
        localIntent.putExtra("target_activity", LiteActivity.class);
        paramContext = paramContext.getString(2131362046);
        paramString = localIntent;
      }
    }
    localIntent = new Intent(a(), SplashActivity.class);
    String str;
    if (paramInt == 7000)
    {
      str = paramContext.getString(2131368649);
      localIntent.putExtra("target_activity", SubAccountMessageActivity.class);
      localIntent.putExtra("subAccount", paramString);
      paramContext = (SubAccountManager)getManager(59);
      if (paramContext == null) {
        break label572;
      }
    }
    label572:
    for (paramContext = paramContext.c(paramString);; paramContext = paramString)
    {
      localIntent.putExtra("subAccountLatestNick", paramContext);
      localIntent.putExtra("finishAIO", true);
      paramContext = str;
      for (;;)
      {
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        paramString = localIntent;
        break;
        if (paramInt == 1009)
        {
          paramContext = paramContext.getString(2131366665);
        }
        else if (String.valueOf(1787740092L).equals(paramString))
        {
          paramContext = paramContext.getString(2131368622);
        }
        else if (paramInt == 1024)
        {
          localIntent.putExtra("target_activity", ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
          paramContext = ContactUtils.b(this, paramString, paramInt);
        }
        else if (paramInt == 1010)
        {
          paramContext = paramContext.getString(2131369778);
          localIntent.putExtra("target_activity", MsgBoxListActivity.class);
        }
        else
        {
          paramContext = ContactUtils.b(this, paramString, paramInt);
        }
      }
    }
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private Drawable a(String paramString, boolean paramBoolean, byte paramByte)
  {
    Object localObject = a(1, paramString, paramByte, true, 0);
    if ((localObject != null) && (paramBoolean)) {
      localObject = ImageUtil.a((Bitmap)localObject);
    }
    for (;;)
    {
      paramString = null;
      if (localObject != null) {
        paramString = new BitmapDrawable((Bitmap)localObject);
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = ImageUtil.b();
      }
      return localObject;
    }
  }
  
  private SQLiteOpenHelper a()
  {
    if (!a().equals("0")) {
      return a().build(a());
    }
    return null;
  }
  
  private SQLiteOpenHelper a(String paramString)
  {
    return a(paramString).build(paramString);
  }
  
  private Object a()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return this.jdField_a_of_type_JavaLangObject;
    }
    J();
    try
    {
      QLog.e("QZLog", 1, "---QZoneAppInterface newInstance");
      this.jdField_a_of_type_JavaLangClass = Class.forName("com.qzone.app.QZoneAppInterface");
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      QLog.e("QZLog", 1, "---QZoneAppInterface newInstance finished");
      return this.jdField_a_of_type_JavaLangObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QLog.e("QZLog", 1, "---QZoneAppInterface newInstance 2");
        ClassLoader localClassLoader = QzonePluginProxyActivity.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        this.jdField_a_of_type_JavaLangClass = localClassLoader.loadClass("com.qzone.app.QZoneAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
    }
  }
  
  private String a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020))
    {
      localObject1 = ContactUtils.c(this, paramMessage.frienduin, paramMessage.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(paramMessage.frienduin)) {}
      }
      else
      {
        localObject2 = ((FriendManager)getManager(8)).c(paramMessage.frienduin);
        if (localObject2 != null) {
          if (TextUtils.isEmpty(((Friends)localObject2).remark)) {
            break label264;
          }
        }
      }
    }
    label264:
    for (Object localObject1 = ((Friends)localObject2).remark;; localObject1 = ((Friends)localObject2).name)
    {
      localObject2 = localObject1;
      if (paramBoolean) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (!((String)localObject1).equals(paramMessage.frienduin)) {}
        }
        else
        {
          localObject2 = localObject1;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramMessage.frienduin))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramMessage.frienduin);
            localObject2 = (FriendListHandler)a(1);
            a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject2).b(paramMessage.frienduin);
            localObject2 = localObject1;
          }
        }
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = paramMessage.frienduin;
      }
      return localObject1;
      localObject1 = ContactUtils.b(this, paramMessage.senderuin, paramMessage.frienduin);
      break;
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.aZ);
    }
    for (;;)
    {
      String str = MD5.toMD5(paramString);
      str = MD5.toMD5(str + paramString);
      localStringBuilder.append(MD5.toMD5(str + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if ((paramInt == 1000) || (paramInt == 1020))
    {
      paramString2 = ContactUtils.c(this, paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!paramString2.equals(paramString1)) {}
      }
      else
      {
        localObject = ((FriendManager)getManager(8)).c(paramString1);
        if (localObject != null) {
          if (TextUtils.isEmpty(((Friends)localObject).remark)) {
            break label221;
          }
        }
      }
    }
    label221:
    for (paramString2 = ((Friends)localObject).remark;; paramString2 = ((Friends)localObject).name)
    {
      localObject = paramString2;
      if (paramBoolean) {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject = paramString2;
          if (!paramString2.equals(paramString1)) {}
        }
        else
        {
          localObject = paramString2;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString1))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramString1);
            localObject = (FriendListHandler)a(1);
            a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_b_of_type_JavaLangString + "_friendListObserver", 2, "addObserver");
            }
            ((FriendListHandler)localObject).b(paramString1);
            localObject = paramString2;
          }
        }
      }
      if ((localObject != null) && (!"".equals(localObject))) {
        break label230;
      }
      return paramString1;
      paramString2 = ContactUtils.b(this, paramString2, paramString1);
      break;
    }
    label230:
    return localObject;
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    label165:
    label203:
    label209:
    do
    {
      return;
      int i3 = paramIntent.getExtras().getInt("faceType", 1);
      Object localObject2 = paramIntent.getExtras().getStringArrayList("uinList");
      paramContext = new ArrayList();
      ??? = new ArrayList();
      paramIntent = new ArrayList();
      if (QLog.isColorLevel()) {
        QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, receive uinList: ", (ArrayList)localObject2);
      }
      int i1;
      String str;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        i1 = 0;
        if (i1 < ((ArrayList)localObject2).size())
        {
          str = (String)((ArrayList)localObject2).get(i1);
          int i2;
          if ((str != null) && (str.length() > 0))
          {
            Object localObject3 = new File(a(i3, str, 0));
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
              break label203;
            }
            i2 = 1;
            if (i2 == 0) {
              break label209;
            }
            localObject3 = a(i3, str, 0);
            paramContext.add(str);
            ((ArrayList)???).add(localObject3);
          }
          for (;;)
          {
            i1 += 1;
            break;
            i2 = 0;
            break label165;
            paramIntent.add(str);
          }
        }
      }
      if (paramContext.size() > 0)
      {
        localObject2 = new Intent("com.tencent.qqhead.getheadresp");
        ((Intent)localObject2).putExtra("faceType", i3);
        ((Intent)localObject2).putStringArrayListExtra("uinList", paramContext);
        ((Intent)localObject2).putStringArrayListExtra("headPathList", (ArrayList)???);
        a().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp2");
      }
      if (paramIntent.size() > 0)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = (FriendListHandler)a(1);
        i1 = 0;
        while (i1 < paramIntent.size())
        {
          str = (String)paramIntent.get(i1);
          if (i3 == 1) {
            ((FriendListHandler)localObject2).a(str, (byte)0, (byte)2);
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            do
            {
              this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
              i1 += 1;
              break;
            } while (i3 != 4);
            ((FriendListHandler)localObject2).d(str);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, response uinList: ", paramContext);
    QQUtils.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, getQQHead uinList: ", paramIntent);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "showNotification. cmd=" + paramString4 + ", ticker=" + Utils.a(paramString1) + ",msgShow:" + Utils.a(paramString3) + ", bitmap=" + paramBitmap);
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130838429);
    }
    if (localBitmap != null)
    {
      paramBitmap = new ToServiceMsg("mobileqq.service", a(), paramString4);
      paramBitmap.extraData.putStringArray("cmds", new String[] { paramString1, paramString2, paramString3 });
      paramBitmap.extraData.putParcelable("intent", paramIntent);
      paramBitmap.extraData.putParcelable("bitmap", localBitmap);
      a(paramBitmap);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    QLog.e("QZLog", 1, "---QZoneAppInterface onCreate");
    Method localMethod = a().getClass().getDeclaredMethod("onCreate", new Class[] { Bundle.class });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { paramBundle });
    QLog.e("QZLog", 1, "---QZoneAppInterface onCreate finished");
  }
  
  private void a(QQMessageFacade.Message paramMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "showMsgNotification: entryA message.frienduin=" + paramMessage.frienduin + ", message.senderuin=" + paramMessage.senderuin + ", needSoundVibrationsTip " + paramBoolean1 + " , isOnline " + paramBoolean2);
    }
    if (a(paramMessage)) {}
    label323:
    label328:
    for (;;)
    {
      return;
      int i2;
      if (f())
      {
        a(paramMessage, true);
        i2 = 0;
        i1 = i2;
        if (this.aO == 0)
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
        i2 = i1;
        if (paramMessage.istroop == 1001)
        {
          i2 = i1;
          if (paramMessage.msgtype == -3001) {
            i2 = 1;
          }
        }
        i1 = i2;
        if (paramMessage.istroop == 1008) {
          if ((paramMessage.extStr == null) || ((paramMessage.extLong & 0x1) != 0) || (!paramMessage.extStr.contains("lockDisplay")))
          {
            i1 = i2;
            if (paramMessage.extStr != null)
            {
              i1 = i2;
              if ((paramMessage.extLong & 0x1) == 1)
              {
                i1 = i2;
                if (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
              }
            }
          }
          else
          {
            i1 = i2;
            if (paramBoolean1) {
              i1 = 1;
            }
          }
        }
        i2 = i1;
        if (paramMessage.istroop == 1008)
        {
          i2 = i1;
          if (AppConstants.T.equals(paramMessage.senderuin)) {
            i2 = 1;
          }
        }
        if (paramMessage.istroop != 9002) {
          break label323;
        }
      }
      for (int i1 = i3;; i1 = i2)
      {
        if (i1 == 0) {
          break label328;
        }
        e(paramMessage, paramBoolean2);
        return;
        h(true);
        c(paramMessage, true);
        break;
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (f()) {
      b(paramMessageRecord, true);
    }
    for (;;)
    {
      int i2 = 0;
      int i1 = i2;
      if (this.aO == 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 1;
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1001)
      {
        i2 = i1;
        if (paramMessageRecord.msgtype == -3001) {
          i2 = 1;
        }
      }
      i1 = i2;
      if (paramMessageRecord.istroop == 1008) {
        if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
        {
          i1 = i2;
          if (paramMessageRecord.extStr != null)
          {
            i1 = i2;
            if ((paramMessageRecord.extLong & 0x1) == 1)
            {
              i1 = i2;
              if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
            }
          }
        }
        else
        {
          i1 = i2;
          if (paramBoolean1) {
            i1 = 1;
          }
        }
      }
      i2 = i1;
      if (paramMessageRecord.istroop == 1008)
      {
        i2 = i1;
        if (AppConstants.T.equals(paramMessageRecord.senderuin)) {
          i2 = 1;
        }
      }
      if (i2 != 0) {
        e(paramMessageRecord, paramBoolean2);
      }
      return;
      d(paramMessageRecord, true);
      c(paramMessageRecord, true);
    }
  }
  
  private void a(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = SAXParserFactory.newInstance().newSAXParser();
      Object localObject2 = new PlistHandler();
      ((SAXParser)localObject1).parse(paramInputStream, (DefaultHandler)localObject2);
      if ((((PlistHandler)localObject2).a() instanceof ArrayList))
      {
        paramInputStream = (ArrayList)((PlistHandler)localObject2).a();
        int i3 = paramInputStream.size();
        if (i3 >= 1)
        {
          this.aL = Integer.parseInt((String)paramInputStream.get(0));
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i1 = 1;
          while (i1 < i3)
          {
            ArrayList localArrayList1 = (ArrayList)paramInputStream.get(i1);
            localObject1 = (String)localArrayList1.get(0);
            localObject2 = (String)localArrayList1.get(1);
            localArrayList1 = (ArrayList)localArrayList1.get(2);
            ArrayList localArrayList2 = new ArrayList();
            int i2 = 0;
            while (i2 < localArrayList1.size())
            {
              TagInfo localTagInfo = new TagInfo();
              localTagInfo.bType = Byte.parseByte((String)((HashMap)localArrayList1.get(i2)).get("itemTagType"));
              localTagInfo.iTagId = new BigDecimal((String)((HashMap)localArrayList1.get(i2)).get("itemTagID")).longValue();
              localTagInfo.strContent = ((String)((HashMap)localArrayList1.get(i2)).get("itemTagString"));
              localArrayList2.add(localTagInfo);
              i2 += 1;
            }
            localObject1 = new TagArrayByType((String)localObject1, (String)localObject2, localArrayList2);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            i1 += 1;
          }
        }
      }
      return;
    }
    catch (ParserConfigurationException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (SAXException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  private void a(MobileQQ paramMobileQQ, MainService paramMainService, SimpleAccount paramSimpleAccount)
  {
    QLog.e("QZLog", 1, "QZoneAppInterface init");
    Method localMethod = a().getClass().getDeclaredMethod("init", new Class[] { MobileQQ.class, MainService.class, SimpleAccount.class });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { paramMobileQQ, paramMainService, paramSimpleAccount });
    QLog.e("QZLog", 1, "QZoneAppInterface init finished");
  }
  
  private Object[] a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = paramInt1;
    String str = paramString;
    if (paramInt1 != 101)
    {
      i1 = paramInt1;
      str = paramString;
      if (paramString != null)
      {
        Setting localSetting = (Setting)a(paramInt1, paramString, paramInt2).second;
        i1 = paramInt1;
        str = paramString;
        if (localSetting != null)
        {
          i1 = paramInt1;
          str = paramString;
          if (localSetting.bHeadType == 0)
          {
            str = String.valueOf(localSetting.systemHeadID);
            if (paramInt1 != 4) {
              break label99;
            }
          }
        }
      }
    }
    label99:
    for (i1 = -56;; i1 = -55) {
      return new Object[] { Integer.valueOf(i1), str };
    }
  }
  
  private Intent b(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("target_activity", ChatActivity.class);
    paramContext.putExtra("tab_index", 1);
    paramContext.addFlags(335544320);
    paramContext.putExtra("uin", paramMessage.frienduin);
    paramContext.putExtra("troop_uin", paramMessage.senderuin);
    paramContext.putExtra("uintype", paramMessage.istroop);
    paramContext.putExtra("uinname", a(paramMessage, paramBoolean));
    paramContext.setAction("com.tencent.mobileqq.action.CHAT");
    return paramContext;
  }
  
  private BusinessHandler b(int paramInt)
  {
    switch (paramInt)
    {
    case 41: 
    default: 
      return null;
    case 0: 
      MessageHandler localMessageHandler = new MessageHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = localMessageHandler;
      return localMessageHandler;
    case 1: 
      return new FriendListHandler(this);
    case 2: 
      return new CardHandler(this);
    case 3: 
      return new LBSHandler(this);
    case 4: 
      return new ConfigHandler(this);
    case 5: 
      return new ReportHandler(this);
    case 6: 
      return new DiscussionHandler(this);
    case 7: 
      return new QZoneNotifyHandler(this);
    case 8: 
      return new DataLineHandler_210(this);
    case 51: 
      return new DeviceMsgHandle(this);
    case 53: 
      return new SmartDeviceProxyMgr(this);
    case 52: 
      return new DeviceFileHandler(this);
    case 9: 
      return new RegisterProxySvcPackHandler(this);
    case 11: 
      return new EmosmHandler(this);
    case 12: 
      return new SVIPHandler(this);
    case 13: 
      return new ThemeHandler(this);
    case 14: 
      return new QvipSpecialCareHandler(this);
    case 15: 
      return new ClubContentUpdateHandler(this);
    case 10: 
      return new PublicAccountHandler(this);
    case 16: 
      return new SubAccountBindHandler(this);
    case 17: 
      return new ShieldListHandler(this);
    case 18: 
      return new SaveTrafficHandler(this);
    case 21: 
      return new BizTroopHandler(this);
    case 19: 
      return new TroopHandler(this);
    case 20: 
      return new EnterpriseQQHandler(this);
    case 22: 
      return new StartAppCheckHandler(this);
    case 23: 
      return new SecSigHandler(this);
    case 30: 
      return new TroopQZoneUploadAlbumHandler(this);
    case 24: 
      return new SafeCenterPushHandler(this);
    case 25: 
      return new PushSecSigHandler(this);
    case 26: 
      return new MQPIntChkHandler(this);
    case 27: 
      return new QPSafeCheckHandler(this);
    case 28: 
      return new StrangerHandler(this);
    case 29: 
      return new VipInfoHandler(this);
    case 31: 
      return new CardPayHandler(this);
    case 32: 
      return new QWalletOpenHandler(this);
    case 33: 
      return new RedTouchHandler(this);
    case 34: 
      return new QWalletHomeHandler(this);
    case 35: 
      return new NearFieldDiscussHandler(this);
    case 36: 
      return new SecSvcHandler(this);
    case 37: 
      return new HotChatHandler(this);
    case 38: 
      return new IndividualExpireInfoHandler(this);
    case 42: 
      return new SecMsgHandler(this);
    case 43: 
      return new SignatureHandler(this);
    case 39: 
      return new BmqqBusinessHandler(this);
    case 50: 
      return new RouterHandler(this);
    case 40: 
      return new DatingHandler(this);
    case 44: 
      return new QWalletAuthHandler(this);
    case 45: 
      return new TroopRedTouchHandler(this);
    case 46: 
      return new UniPayHandler(this);
    case 56: 
      return new ChatBackgroundAuthHandler(this);
    case 58: 
      return new PPCLoginAuthHandler(this);
    case 47: 
      return new RecentCallHandler(this);
    case 55: 
      return new SsosvrrHandler(this);
    case 48: 
      return new VipSetFunCallHandler(this);
    case 54: 
      return new LightalkSwitchHanlder(this);
    case 49: 
      return new QPayHandler(this);
    case 57: 
      return new NearFieldTroopHandler(this);
    case 59: 
      return new MessageRoamHandler(this);
    case 60: 
      return new WidgetController(this);
    }
    return new QzoneMsgHandler(this);
  }
  
  private void b(Bundle paramBundle)
  {
    QLog.e("QZLog", 1, "---QZoneAppInterface onRunningBackground");
    Method localMethod = a().getClass().getDeclaredMethod("onRunningBackground", new Class[] { Bundle.class });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { paramBundle });
    QLog.e("QZLog", 1, "---QZoneAppInterface onRunningBackground finished");
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramMessageRecord.istroop == 6000) || (paramMessageRecord.istroop == 1009) || (paramMessageRecord.frienduin.equals(AppConstants.ab))) {}
    QQLSRecentManager localQQLSRecentManager;
    do
    {
      do
      {
        return;
      } while (!QQUtils.a(a()));
      localQQLSRecentManager = (QQLSRecentManager)getManager(68);
    } while (!SettingCloneUtil.readValue(a(), a(), a().getString(2131367906), "qqsetting_lock_screen_whenexit_key", true));
    localQQLSRecentManager.a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, false);
  }
  
  private boolean c(String paramString)
  {
    return (String.valueOf(AppConstants.ae).equals(paramString)) || (String.valueOf(AppConstants.ag).equals(paramString)) || (String.valueOf(AppConstants.af).equals(paramString));
  }
  
  private void d(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((this.h) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Object localObject;
    int i1;
    Intent localIntent;
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QCallFacade)getManager(37);
        } while (localObject == null);
        i1 = ((QCallFacade)localObject).c();
      } while (i1 == 0);
      if (i1 != 1) {
        break label365;
      }
      if (((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008)) || (paramMessageRecord.istroop != 3000)) {
        break;
      }
      localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(a().getString(2131368297));
      i1 = ((QCallFacade)localObject).b();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(a().getString(2131368294));
      label169:
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      if (paramMessageRecord.msgtype != -2016) {
        break label436;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
      }
      if ((paramMessageRecord.istroop == 3000) && (QLog.isColorLevel())) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "AVNotify:UIN_TYPE_DISCUSSION");
      }
    }
    for (;;)
    {
      a(localIntent, (String)localObject, a().getResources().getString(2131368291), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
      {
        localIntent = new Intent(a(), SplashActivity.class);
        localIntent.putExtra("tab_index", 1);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
        break;
      }
      localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
      break;
      label365:
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.putExtra("tab_index", 1);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      break;
      localStringBuffer.append(i1).append(a().getString(2131368296));
      break label169;
      label436:
      if ((paramMessageRecord.msgtype == -2009) && (QLog.isColorLevel())) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
      }
    }
  }
  
  private void e(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    label124:
    boolean bool1;
    boolean bool4;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject1 = null;
      if (paramMessageRecord != null)
      {
        if (paramMessageRecord.msgtype == -2020) {
          localObject1 = paramMessageRecord.getBaseInfoString();
        }
      }
      else {
        QLog.d("notification", 2, "message is:" + (String)localObject1 + ",isOnline is:" + paramBoolean);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "previous vibrate time is:" + this.jdField_e_of_type_Long + ",curr time is:" + System.currentTimeMillis());
      }
      if (this.jdField_e_of_type_Long != -1L) {
        break label385;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      bool1 = h();
      bool4 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool4);
      }
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1008) || (!AppConstants.T.equals(paramMessageRecord.senderuin))) {
        break label509;
      }
      bool2 = false;
      bool3 = false;
      paramMessageRecord = RingtoneManager.getActualDefaultRingtoneUri(a(), 2);
      localObject1 = (Vibrator)a().getSystemService("vibrator");
      if ((!k()) || (!bool4)) {
        break label433;
      }
      paramBoolean = true;
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool1 + " uri: " + paramMessageRecord);
      }
      if ((paramBoolean) && (localObject1 != null)) {
        ((Vibrator)localObject1).vibrate(jdField_b_of_type_ArrayOfLong, -1);
      }
      if ((bool1) && (paramMessageRecord != null)) {
        AudioUtil.a(paramMessageRecord, false, false);
      }
    }
    label385:
    label433:
    label509:
    while ((bool1) || (!bool4)) {
      for (;;)
      {
        return;
        localObject1 = "not shake msg,uinSeq is:" + paramMessageRecord.uniseq;
        break;
        if (Math.abs(System.currentTimeMillis() - this.jdField_e_of_type_Long) > 2000L) {
          break label124;
        }
        if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -2020) && (paramBoolean))
        {
          if (a() == 11L) {
            break label124;
          }
          return;
          if ((i()) && (j()) && (bool4))
          {
            bool1 = true;
            paramBoolean = true;
          }
          else
          {
            paramBoolean = bool3;
            bool1 = bool2;
            if (i())
            {
              paramBoolean = bool3;
              bool1 = bool2;
              if (!j())
              {
                paramBoolean = bool3;
                bool1 = bool2;
                if (bool4)
                {
                  bool1 = true;
                  paramBoolean = bool3;
                }
              }
            }
          }
        }
      }
    }
    SharedPreferences localSharedPreferences = a().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    Object localObject4 = (Vibrator)a().getSystemService("vibrator");
    boolean bool3 = d();
    Object localObject3 = "";
    Object localObject1 = "";
    int i1;
    label654:
    int i2;
    if (paramMessageRecord != null)
    {
      if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004))
      {
        localObject1 = paramMessageRecord.frienduin;
        localObject3 = "special_sound_type" + a() + (String)localObject1;
      }
    }
    else
    {
      bool1 = A();
      bool2 = z();
      i1 = RoamSettingController.a(this);
      if (i1 != 0) {
        break label901;
      }
      if (d() != 1) {
        break label896;
      }
      i1 = 1;
      i2 = i1;
      if ((paramMessageRecord == null) || (paramMessageRecord.istroop != 1)) {
        break label1493;
      }
      if ((!bool1) || (!y())) {
        break label919;
      }
      bool1 = true;
      label684:
      if ((!bool2) || (!x())) {
        break label925;
      }
      bool2 = true;
    }
    label699:
    label1487:
    label1493:
    for (;;)
    {
      bool4 = m();
      boolean bool5 = w();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool2 + ",isVideoing is:" + bool3 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool2) && (bool4) && (!bool3) && (bool5))
      {
        if ((paramMessageRecord != null) && (paramBoolean) && (paramMessageRecord.msgtype == -2020) && (a() == 11L))
        {
          ((Vibrator)localObject4).vibrate(jdField_a_of_type_ArrayOfLong, -1);
          i1 = 2;
        }
        for (;;)
        {
          int i4 = this.jdField_d_of_type_JavaUtilList.size();
          int i3 = 0;
          while (i3 < i4)
          {
            ((VibrateListener)this.jdField_d_of_type_JavaUtilList.get(i3)).l(i1);
            i3 += 1;
          }
          localObject1 = paramMessageRecord.senderuin;
          break;
          i1 = 0;
          break label654;
          if (i1 == 1) {}
          for (i1 = 1;; i1 = 0)
          {
            i2 = i1;
            break;
          }
          bool1 = false;
          break label684;
          bool2 = false;
          break label699;
          if (localSharedPreferences.contains((String)localObject3))
          {
            ((Vibrator)localObject4).vibrate(1000L);
            i1 = 3;
          }
          else
          {
            ((Vibrator)localObject4).vibrate(jdField_b_of_type_ArrayOfLong, -1);
            i1 = 1;
          }
        }
      }
      if ((i2 != 0) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i1 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
        if (localSharedPreferences.contains((String)localObject3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "-->SpecialSound");
          }
          localObject4 = (FriendsManagerImp)getManager(8);
          if ((localObject4 != null) && (((FriendsManagerImp)localObject4).b((String)localObject1)))
          {
            i1 = localSharedPreferences.getInt((String)localObject3, i1);
            if (i1 != 1) {
              break label1319;
            }
            try
            {
              AudioUtil.a(2131165199, false);
              return;
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, localException.getMessage());
              }
            }
          }
        }
      }
      label1121:
      Object localObject2;
      if ((bool1) && (!bool3) && (!k()) && (!l()) && (bool4) && (bool5))
      {
        i2 = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, a(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
        if (QLog.isColorLevel())
        {
          localObject2 = (AudioManager)a().getSystemService("audio");
          localObject3 = new StringBuilder().append("StreamVolume=");
          if (localObject2 != null) {
            break label1440;
          }
        }
      }
      for (i1 = 0;; i1 = ((AudioManager)localObject2).getStreamVolume(2))
      {
        QLog.d("notification", 2, i1 + ",SoundRid=" + i2);
        if (i2 != SoundAndVibrateActivity.b) {
          break label1487;
        }
        localObject2 = ThemeUtil.getThemeVoiceRootPath();
        if (localObject2 == null) {
          break label1450;
        }
        localObject2 = new File((String)localObject2 + File.separatorChar + "message.mp3");
        if (!((File)localObject2).exists()) {
          break label1450;
        }
        AudioUtil.a(Uri.fromFile((File)localObject2), false, true);
        return;
        localObject2 = localSharedPreferences.getString("special_sound_url" + i1, "");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1121;
        }
        localObject3 = new File(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), (String)localObject2);
        if (((File)localObject3).exists())
        {
          AudioUtil.a(((File)localObject3).getAbsolutePath(), false);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
        }
        a(new hnu(this, (String)localObject2, (File)localObject3));
        break label1121;
        break;
      }
      for (i1 = 2131165186;; i1 = i2)
      {
        i2 = i1;
        if (paramMessageRecord != null)
        {
          i2 = i1;
          if (c(paramMessageRecord.frienduin)) {
            i2 = 2131165200;
          }
        }
        AudioUtil.a(i2, false);
        return;
      }
    }
  }
  
  private String f()
  {
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    return str;
  }
  
  /* Error */
  private String g()
  {
    // Byte code:
    //   0: ldc_w 1992
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 755	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 1996	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: astore_3
    //   13: aload 4
    //   15: astore_2
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 755	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 1999	com/tencent/common/app/BaseApplicationImpl:getPackageName	()Ljava/lang/String;
    //   24: iconst_0
    //   25: invokevirtual 2005	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: astore 5
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: ifnull +99 -> 134
    //   38: aload 4
    //   40: astore_2
    //   41: aload 4
    //   43: astore_3
    //   44: aload 5
    //   46: getfield 2010	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   49: ifnull +85 -> 134
    //   52: aload 4
    //   54: astore_2
    //   55: aload 5
    //   57: getfield 2010	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: ifnull +67 -> 134
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: ldc_w 2012
    //   78: invokevirtual 2016	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 5
    //   83: iconst_3
    //   84: istore_1
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: astore_3
    //   91: iload_1
    //   92: aload 5
    //   94: arraylength
    //   95: if_icmple +39 -> 134
    //   98: aload 4
    //   100: astore_2
    //   101: new 399	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   108: aload 4
    //   110: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 2018
    //   116: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 4
    //   124: iload_1
    //   125: iconst_1
    //   126: isub
    //   127: istore_1
    //   128: goto -43 -> 85
    //   131: astore_3
    //   132: aload_2
    //   133: astore_3
    //   134: aload_3
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	QQAppInterface
    //   84	44	1	i1	int
    //   15	118	2	str1	String
    //   12	79	3	localObject1	Object
    //   131	1	3	localException	Exception
    //   133	2	3	localObject2	Object
    //   3	120	4	str2	String
    //   28	65	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	30	131	java/lang/Exception
    //   44	52	131	java/lang/Exception
    //   55	62	131	java/lang/Exception
    //   73	83	131	java/lang/Exception
    //   91	98	131	java/lang/Exception
    //   101	124	131	java/lang/Exception
  }
  
  private void g(boolean paramBoolean)
  {
    QLog.e("QZLog", 1, "---QZoneAppInterface start");
    Method localMethod = a().getClass().getDeclaredMethod("start", new Class[] { Boolean.TYPE });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { Boolean.valueOf(paramBoolean) });
    QLog.e("QZLog", 1, "---QZoneAppInterface start finished");
  }
  
  private void h(boolean paramBoolean)
  {
    if ((this.h) || (!NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this))) {}
    Intent localIntent;
    StringBuffer localStringBuffer;
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
        break;
      }
      localIntent = a(a(), (QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(a().getString(2131368297));
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
    } while (i1 == 0);
    if (i1 > 1000)
    {
      localStringBuffer.append(a().getString(2131368292));
      label138:
      if (!paramBoolean) {
        break label237;
      }
    }
    label237:
    for (String str = localStringBuffer.toString();; str = null)
    {
      a(localIntent, str, a().getResources().getString(2131368291), localStringBuffer.toString(), null, "CMD_SHOW_NOTIFIYCATION");
      return;
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", 1);
      break;
      localStringBuffer.append(i1).append(a().getString(2131367186));
      break label138;
    }
  }
  
  private boolean w()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  private boolean x()
  {
    return c() != 0;
  }
  
  private boolean y()
  {
    return b() != 0;
  }
  
  private boolean z()
  {
    return e() != 0;
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener.a();
    }
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener.a();
    }
  }
  
  public void C()
  {
    long l2 = 0L;
    long l1;
    if ((!this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) && (this.m))
    {
      l1 = l2;
      if (this.jdField_b_of_type_Long != 0L)
      {
        l1 = cg - (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
        if (l1 >= 0L) {
          break label116;
        }
        l1 = l2;
      }
    }
    label116:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "onResume send msg " + l1);
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, new WeakReference(this));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l1);
      return;
    }
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.j();
    }
    Object localObject = (SubAccountManager)getManager(59);
    if (localObject != null) {
      ((SubAccountManager)localObject).c();
    }
    localObject = (ActivateFriendsManager)getManager(80);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).b();
    }
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    try
    {
      a(getApplication().getAssets().open("qqtags.xml"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void F()
  {
    int i1 = 2131368501;
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) && (isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Mobile ");
      }
      localObject1 = a();
      bool1 = ((TransFileController)localObject1).c();
      bool2 = ((TransFileController)localObject1).a();
      bool3 = ((TransFileController)localObject1).b();
      localObject2 = BaseActivity.sTopActivity;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      }
      if ((bool1) || (bool2) || (bool3))
      {
        localObject2 = new Intent((Context)localObject1, DialogActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).addFlags(131072);
        if (!bool2) {
          break label307;
        }
        if (!bool3) {
          break label296;
        }
      }
    }
    label296:
    label307:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      Object localObject2;
      i1 = 2131368500;
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllRawSendC2C:" + bool1);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoSend:" + bool2);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============pauseAllShortVideoReceive:" + bool3);
          QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile==============dialog message:" + ((Context)localObject1).getResources().getString(i1));
        }
        ((Intent)localObject2).putExtra("key_dialog_msg_id", i1);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
        if (!bool1)
        {
          i1 = 2131368497;
          continue;
          if (bool3)
          {
            if (!bool1) {
              i1 = 2131368498;
            }
          }
          else {
            i1 = 2131368499;
          }
        }
      }
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Mobile app = null,maybe not QQ process");
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "onX2Wifi ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onX2Wifi app = null,maybe not QQ process");
  }
  
  public void H()
  {
    boolean bool = false;
    if (this.cl != -1) {}
    do
    {
      return;
      localObject2 = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
      if ((localObject2 != null) && (((String)localObject2).length() <= "0111100".length())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_b_of_type_JavaLangString, 2, "isCallTabShow fullVal is null");
    return;
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "0111100".length()) {
      localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
    }
    Object localObject2 = ((String)localObject1).toCharArray();
    localObject1 = new StringBuilder((String)localObject1);
    char c1 = localObject2[5];
    char c3 = localObject2[6];
    char c4;
    if (c1 != c3)
    {
      ((StringBuilder)localObject1).setCharAt(6, c1);
      c3 = '\001';
      c4 = c1;
    }
    for (;;)
    {
      if (c4 == '0')
      {
        this.cl = 0;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "uin:" + a() + ",isCallTabShow mIsCallTabShow=" + this.cl);
        }
        if (this.cl != 0) {
          break label410;
        }
        label232:
        this.n = bool;
        SplashActivity.a(this.n);
        if (c3 == 0) {
          break;
        }
        ThreadManager.b(new hnk(this, (StringBuilder)localObject1));
        return;
      }
      if (localObject2[0] == '1')
      {
        c5 = localObject2[3];
        c1 = localObject2[4];
        if (c1 == '0')
        {
          c4 = '\000';
          label292:
          this.cl = c4;
          if (c5 == c1) {
            break label416;
          }
          ((StringBuilder)localObject1).setCharAt(3, c1);
          c3 = '\001';
        }
      }
      label410:
      label416:
      for (;;)
      {
        break;
        c4 = '\001';
        break label292;
        c1 = localObject2[1];
        c5 = localObject2[2];
        char c2 = localObject2[3];
        char c6 = localObject2[4];
        if (c1 == '0') {
          c4 = '\000';
        }
        for (;;)
        {
          this.cl = c4;
          if (c2 != c6)
          {
            ((StringBuilder)localObject1).setCharAt(4, c2);
            c3 = '\001';
          }
          if (c1 == c5) {
            break;
          }
          ((StringBuilder)localObject1).setCharAt(2, c1);
          c3 = '\001';
          break;
          if (c2 == '0') {
            c4 = '\000';
          } else {
            c4 = '\001';
          }
        }
        bool = true;
        break label232;
      }
      char c5 = '\000';
      c4 = c3;
      c3 = c5;
    }
  }
  
  public int a()
  {
    return AppSetting.a;
  }
  
  public int a(int paramInt)
  {
    int i2 = -1;
    int i1;
    if ((this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null) || (paramInt < 0) || (paramInt >= 7))
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "readCallTabStateVal wrong index," + paramInt);
        i1 = i2;
      }
    }
    do
    {
      String str;
      do
      {
        return i1;
        str = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
        if ((str != null) && (str.length() == 7)) {
          break;
        }
        i1 = i2;
      } while (!QLog.isColorLevel());
      QLog.e(jdField_b_of_type_JavaLangString, 2, "readCallTabStateVal val is null");
      return -1;
      i2 = str.charAt(paramInt) - '0';
      i1 = i2;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "uin:" + a() + ",readCallTabStateVal index=" + paramInt + ", resut=" + i2);
    return i2;
  }
  
  public int a(String paramString)
  {
    int i3 = 0;
    try
    {
      Class[] arrayOfClass = Class.forName("com.android.internal.R").getDeclaredClasses();
      int i4 = arrayOfClass.length;
      int i1 = 0;
      for (;;)
      {
        int i2 = i3;
        if (i1 < i4)
        {
          Class localClass = arrayOfClass[i1];
          if ("id".equals(localClass.getSimpleName())) {
            i2 = localClass.getDeclaredField(paramString).getInt(null);
          }
        }
        else
        {
          return i2;
        }
        i1 += 1;
      }
      return 0;
    }
    catch (Exception paramString) {}
  }
  
  public long a()
  {
    if ((getAccount() != null) && (isLogin()))
    {
      if (this.jdField_d_of_type_Long == 31L)
      {
        this.jdField_d_of_type_Long = a().getSharedPreferences("acc_info" + getAccount(), 0).getLong("getProfileStatusNew", 11L);
        if (this.jdField_d_of_type_Long == 31L)
        {
          this.jdField_d_of_type_Long = 11L;
          a(11L, false);
        }
      }
      return this.jdField_d_of_type_Long;
    }
    return -1L;
  }
  
  public Intent a()
  {
    return this.jdField_b_of_type_AndroidContentIntent;
  }
  
  public Intent a(Context paramContext, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    if ((paramMessage.istroop == 1000) || (paramMessage.istroop == 1020) || (paramMessage.istroop == 1004)) {
      return b(paramContext, paramMessage, paramBoolean);
    }
    return a(a(), paramMessage, paramMessage.istroop);
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte1, boolean paramBoolean, byte paramByte2, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramString != null) && ((paramString.equals(AppConstants.ag)) || (paramString.equals(AppConstants.af)) || (paramString.equals(AppConstants.ac)) || (paramString.equals(AppConstants.ae)))) {
      return ImageUtil.f();
    }
    if ((paramInt1 == 11) && (!StringUtil.e(paramString))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramInt1 == 101) {
      paramByte1 = 1;
    }
    String str1 = a(paramInt1, paramString, paramByte1, paramInt2);
    Object localObject2 = a(str1);
    int i2 = 0;
    Object localObject1;
    boolean bool1;
    String str2;
    BitmapManager.BitmapDecodeResult localBitmapDecodeResult;
    int i1;
    if (localObject2 == null) {
      if (paramBoolean)
      {
        localObject1 = a(paramInt1, paramString, paramInt2);
        if (localObject1 != null)
        {
          bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
          str2 = a(paramInt1, paramString, paramInt2);
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inPreferredConfig = jdField_a_of_type_AndroidGraphicsBitmap$Config;
          localBitmapDecodeResult = new BitmapManager.BitmapDecodeResult();
          i1 = 0;
          do
          {
            BitmapManager.a(str2, (BitmapFactory.Options)localObject1, localBitmapDecodeResult);
            if (localBitmapDecodeResult.e == 1) {
              L();
            }
            i1 += 1;
          } while ((i1 < 2) && (localBitmapDecodeResult.e == 1));
          if ((QLog.isColorLevel()) && (localBitmapDecodeResult.e != 0)) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decodeFile fail, faceType=" + paramInt1 + ", uin=" + paramString + ", result=" + localBitmapDecodeResult.e + ", facePath=" + str2);
          }
          if ((!bool1) && (localBitmapDecodeResult.e == 1)) {
            return null;
          }
          if (localBitmapDecodeResult.e != 2)
          {
            i1 = 1;
            label331:
            localObject1 = localBitmapDecodeResult.a;
            if ((localObject1 == null) && (localBitmapDecodeResult.e != 1) && (i1 != 0))
            {
              if (paramInt1 != 4) {
                break label1007;
              }
              localObject2 = "troop_" + paramString;
              label384:
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_JavaUtilHashMap == null) {
          this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
        }
        Integer localInteger = (Integer)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
        if (localInteger == null)
        {
          i2 = 0;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", nDecodeFailCount = " + i2);
          }
          if (i2 < 1)
          {
            this.jdField_b_of_type_JavaUtilHashMap.put(localObject2, Integer.valueOf(i2 + 1));
            FileUtils.d(str2);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap|file is damaged, key = " + (String)localObject2 + ", del the damaged file");
            }
          }
          if (localObject1 == null) {
            break label992;
          }
        }
        switch (paramByte1)
        {
        case 2: 
        default: 
          localObject1 = a((Bitmap)localObject1);
          if (localObject1 == null) {
            break label775;
          }
          a(str1, (Bitmap)localObject1, paramByte2);
          localObject2 = localObject1;
          i2 = i1;
          bool2 = bool1;
          if (((localObject2 == null) && (paramBoolean) && (i2 == 0)) || (bool2))
          {
            if (i2 == 0) {
              break label875;
            }
            paramByte1 = 1;
            localObject1 = (FriendListHandler)a(1);
          }
          switch (paramInt1)
          {
          default: 
            return localObject2;
            i1 = 0;
            break label331;
            i2 = localInteger.intValue();
          }
          break;
        }
      }
      continue;
      localObject1 = a((Bitmap)localObject1, 50, 50);
      continue;
      label775:
      boolean bool2 = bool1;
      i2 = i1;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        i2 = i1;
        localObject2 = localObject1;
        if (localBitmapDecodeResult.e == 0)
        {
          QLog.i("Q.qqhead.qaif", 2, "getFaceBitmap decode shape fail, faceType=" + paramInt1 + ", uin=" + paramString + ", shape=" + paramByte1);
          bool2 = bool1;
          i2 = i1;
          localObject2 = localObject1;
          continue;
          label875:
          paramByte1 = 2;
          continue;
          ((FriendListHandler)localObject1).b(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject1).a(paramString, paramByte1);
          continue;
          ((FriendListHandler)localObject1).a(paramString, (byte)0, paramByte1);
          continue;
          i1 = 3000;
          paramInt1 = i1;
          switch (paramInt2)
          {
          default: 
            paramInt1 = i1;
          }
          for (;;)
          {
            ((FriendListHandler)localObject1).a(paramString, paramInt1, (byte)1, paramByte1);
            break;
            paramInt1 = 3000;
            continue;
            paramInt1 = 3001;
            continue;
            paramInt1 = 3002;
          }
          label992:
          bool2 = bool1;
          i2 = i1;
          localObject2 = localObject1;
          continue;
          label1007:
          localObject2 = paramString;
          break label384;
          bool1 = false;
          break;
          bool2 = false;
        }
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, byte paramByte, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, paramByte, paramBoolean, (byte)1, paramInt2);
  }
  
  public Bitmap a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    return a(paramInt1, paramString, (byte)3, paramBoolean, paramInt2);
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return ImageUtil.a(paramBitmap, 50, 50);
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
    int i1 = paramBitmap.getWidth();
    float f1 = f2;
    if (i1 > 0)
    {
      f1 = f2;
      if (i1 < paramInt1 * f2) {
        f1 = i1 / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return ImageUtil.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      return (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    }
    return null;
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean)
  {
    return a(1, paramString, paramByte, paramBoolean, 0);
  }
  
  public Bitmap a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(4, paramString, paramByte, true, 0);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.d();
    }
    localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramBoolean1) {
        localObject = ImageUtil.a(paramString);
      }
    }
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (paramBoolean2) {
        paramString = b((Bitmap)localObject);
      }
    }
    return paramString;
  }
  
  public Bitmap a(String paramString, int paramInt)
  {
    int i1 = 200;
    if (paramInt == 3001) {
      i1 = 202;
    }
    for (;;)
    {
      return a(32, paramString, true, i1);
      if (paramInt == 3002) {
        i1 = 204;
      }
    }
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(1, paramString, (byte)3, paramBoolean, 0);
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), paramInt);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return a(localObject);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public Drawable a(Bitmap paramBitmap)
  {
    return new BitmapDrawable(a(paramBitmap));
  }
  
  public Drawable a(String paramString)
  {
    return a(paramString, (byte)3, false, false);
  }
  
  public Drawable a(String paramString, byte paramByte)
  {
    Bitmap localBitmap = a(11, paramString, paramByte, true, 0);
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = ImageUtil.a();
    }
    return new BitmapDrawable(paramString);
  }
  
  public Drawable a(String paramString, byte paramByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramString, paramByte, paramBoolean1, paramBoolean2);
    paramString = null;
    if (localObject != null) {
      paramString = new BitmapDrawable((Bitmap)localObject);
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = ImageUtil.c();
    }
    return localObject;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, (byte)3);
  }
  
  public Bundle a(int paramInt)
  {
    Object localObject = a().getClass().getDeclaredMethod("getWidgetInfo", new Class[] { Integer.TYPE });
    ((Method)localObject).setAccessible(true);
    localObject = ((Method)localObject).invoke(a(), new Object[] { Integer.valueOf(paramInt) });
    if (localObject == null) {
      return null;
    }
    return (Bundle)localObject;
  }
  
  public Pair a(int paramInt1, String paramString, int paramInt2)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    Setting localSetting1;
    for (;;)
    {
      Setting localSetting2 = (Setting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      localSetting1 = localSetting2;
      if (localSetting2 == null)
      {
        localSetting1 = localSetting2;
        if (!this.o)
        {
          localSetting1 = localSetting2;
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
          {
            localSetting1 = localSetting2;
            if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
            {
              localSetting1 = (Setting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, str);
              this.jdField_a_of_type_JavaUtilHashMap.put(str, localSetting1);
            }
          }
        }
      }
      if (localSetting1 != null) {
        break;
      }
      return Pair.create(Boolean.valueOf(true), null);
      if (paramInt1 == 32) {
        str = "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
      } else {
        str = paramString;
      }
    }
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.d("Q.qqhead.qaif", 2, "getQQHeadSetting. | uin=" + paramString + ", isNeedCheckQQHead=" + bool + ", accountStartTime=" + this.jdField_f_of_type_Long + ", updateTimestamp=" + localSetting1.updateTimestamp);
      }
      return new Pair(Boolean.valueOf(bool), localSetting1);
      if ((localSetting1 == null) || ((localSetting1.updateTimestamp < this.jdField_f_of_type_Long) && (System.currentTimeMillis() - localSetting1.updateTimestamp > 86400000L))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Pair a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    paramString = a(1, paramString, (byte)3, true, 0);
    if (paramString == null) {
      paramString = ImageUtil.a();
    }
    for (;;)
    {
      return Pair.create(Boolean.valueOf(bool), paramString);
      bool = true;
    }
  }
  
  public WidgetController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetController == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetController = ((WidgetController)a(60));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetController;
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public CheckPttListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener;
  }
  
  public LebaHelper a()
  {
    n();
    return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper;
  }
  
  public MessageHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = ((MessageHandler)a(0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  }
  
  public QQGAudioMsgHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler = new QQGAudioMsgHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQGAudioMsgHandler;
  }
  
  public SQLiteDatabase a()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.a();
    }
    return null;
  }
  
  public SQLiteDatabase a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public CacheManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)getManager(18));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager;
  }
  
  public ConversationFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)getManager(28));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade;
  }
  
  public MsgProxy a(int paramInt)
  {
    if (a() != null) {
      return a().a().a(paramInt);
    }
    return null;
  }
  
  public MultiMsgProxy a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a();
    }
    return null;
  }
  
  public QQMessageFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)getManager(19));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade;
  }
  
  public DataLineMsgProxy a()
  {
    return a().a();
  }
  
  public ProxyManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)getManager(17));
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  }
  
  public AboutConfig a()
  {
    R();
    return this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig;
  }
  
  public Config a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfigConfig = new Config(this, paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
      return paramString;
    }
    finally {}
  }
  
  public Setting a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localObject1 = (Setting)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
    }
    return localObject1;
  }
  
  public FileManagerEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine = new FileManagerEngine(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileManagerEngine;
  }
  
  public FileTransferHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler = new FileTransferHandler(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferHandler;
  }
  
  public FileManagerDataCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter = new FileManagerDataCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerDataCenter;
  }
  
  public FileManagerNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter = new FileManagerNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerNotifyCenter;
  }
  
  public FileManagerRSCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter = new FileManagerRSCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileManagerRSCenter;
  }
  
  public OnlineFileSessionCenter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter = new OnlineFileSessionCenter(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter;
  }
  
  public FileManagerProxy a()
  {
    ProxyManager localProxyManager = a();
    if (localProxyManager != null) {
      return localProxyManager.a();
    }
    return null;
  }
  
  public PrivacyInfoUtil a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil = new PrivacyInfoUtil();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilPrivacyInfoUtil;
  }
  
  public UniformDownloadBPTransProxy a()
  {
    return a().a();
  }
  
  public HwEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine = new HwEngine(getApplication(), a(), a(), this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = getAccount();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        localObject1 = new QQEntityManagerFactory((String)localObject1);
        ((QQEntityManagerFactory)localObject1).verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  @Deprecated
  public EntityManagerFactory a(String paramString)
  {
    if (!paramString.equals(getAccount())) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    return a();
  }
  
  public PicPreDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader = ((PicPreDownloader)getManager(38));
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader;
  }
  
  public QCallFacade a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade == null) {
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade = ((QCallFacade)getManager(37));
    }
    return this.jdField_a_of_type_ComTencentMobileqqQcallQCallFacade;
  }
  
  public QzoneContactsFeedManager a()
  {
    return (QzoneContactsFeedManager)getManager(85);
  }
  
  public MessageCache a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {}
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache == null) {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache = new MessageCache(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache;
    }
  }
  
  public ReportController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController;
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(20));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public ProtoReqManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = new ProtoReqManager(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager;
    }
    finally {}
  }
  
  public TransFileController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = new TransFileController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  }
  
  public HttpCommunicator a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator == null) {
      M();
    }
    return this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public ISecureModuleService a()
  {
    if (this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService == null) {
      this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService = SecureModuleService.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    }
    return this.jdField_a_of_type_ComTencentSecuremoduleServiceISecureModuleService;
  }
  
  public QQProxyForQlink a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQQProxyForQlink == null) {
      this.jdField_a_of_type_CooperationQlinkQQProxyForQlink = new QQProxyForQlink(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQQProxyForQlink;
  }
  
  public QlinkServiceManager a()
  {
    if (this.jdField_a_of_type_CooperationQlinkQlinkServiceManager == null) {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceManager = new QlinkServiceManager(this);
    }
    return this.jdField_a_of_type_CooperationQlinkQlinkServiceManager;
  }
  
  public Class a(String paramString)
  {
    QLog.e("QZLog", 1, "---getPluginClassLoader className: " + paramString);
    paramString = a().getClass().getClassLoader().loadClass(paramString);
    QLog.e("QZLog", 1, "---getPluginClassLoader finished");
    return paramString;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String a(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (paramInt1 == 4) {
      str = "troop_" + paramString;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramInt1 != 32);
    return "stranger_" + String.valueOf(paramInt2) + "_" + paramString;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    localObject = MD5.toMD5((String)localObject + paramString);
    paramString = MD5.toMD5((String)localObject + paramString);
    localObject = new StringBuilder(256);
    if (paramInt == 4) {
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.ba);
      }
    }
    for (;;)
    {
      if (paramInt == 101) {
        ((StringBuilder)localObject).append("discussion_");
      }
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".png");
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_thd/");
      continue;
      if (SystemUtil.a()) {
        ((StringBuilder)localObject).append(AppConstants.aZ);
      } else {
        ((StringBuilder)localObject).append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
      }
    }
  }
  
  public String a(int paramInt1, String paramString, byte paramByte, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    Object[] arrayOfObject = a(paramInt1, paramString, paramInt2);
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      if (paramByte > 0) {
        localStringBuilder.append("_").append(paramByte);
      }
      return localStringBuilder.toString();
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)arrayOfObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("sub_");
      localStringBuilder.append("stranger_").append(String.valueOf(paramInt2)).append("_");
    }
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    Object localObject;
    if (SystemUtil.a())
    {
      localStringBuilder.append(AppConstants.aZ);
      localObject = a(paramInt1, paramString, paramInt2);
      switch (((Integer)localObject[0]).intValue())
      {
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      localStringBuilder.append(MD5.toMD5((String)localObject + paramString));
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append(SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/");
      break;
      localStringBuilder.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("sys_");
      paramString = (String)localObject[1];
      continue;
      localStringBuilder.append("dis_e_");
      paramString = a() + paramString;
      continue;
      localStringBuilder.append("troop_");
      continue;
      localStringBuilder.append("stranger_").append(String.valueOf(paramInt2)).append("_");
    }
  }
  
  public String a(QQMessageFacade.Message paramMessage)
  {
    switch (paramMessage.bizType)
    {
    default: 
      return "";
    case 3: 
      return a().getString(2131365866);
    case 4: 
      return a().getString(2131363736);
    }
    return a().getString(2131363737);
  }
  
  public String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
    long l1 = System.currentTimeMillis();
    if ((this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramConfigType)) && (this.jdField_c_of_type_JavaUtilHashMap.containsKey(paramConfigType)) && (l1 - ((Long)this.jdField_c_of_type_JavaUtilHashMap.get(paramConfigType)).longValue() < 7200000L))
    {
      paramConfigType = (HashMap)this.jdField_b_of_type_JavaUtilHashtable.get(paramConfigType);
      if (paramConfigType.containsKey(paramString))
      {
        localStringBuilder.append((String)paramConfigType.get(paramString));
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
        }
        return (String)paramConfigType.get(paramString);
      }
      localStringBuilder.append("null");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return null;
    }
    if (getAccount() == null) {}
    for (Object localObject = "0";; localObject = getAccount())
    {
      localObject = ((ServerConfigManager)getManager(4)).getServerConfig((String)localObject, paramConfigType);
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break;
      }
      localStringBuilder.append("null, configText is null");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return null;
    }
    try
    {
      localObject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<ServerConfig>" + (String)localObject + "</ServerConfig>";
      XMLReader localXMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
      hnx localhnx = new hnx(this);
      localXMLReader.setContentHandler(localhnx);
      localXMLReader.parse(new InputSource(new ByteArrayInputStream(((String)localObject).getBytes("UTF-8"))));
      localObject = localhnx.a();
      this.jdField_b_of_type_JavaUtilHashtable.put(paramConfigType, localObject);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramConfigType, Long.valueOf(l1));
      localStringBuilder.append((String)((HashMap)localObject).get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      paramConfigType = (String)((HashMap)localObject).get(paramString);
      return paramConfigType;
    }
    catch (Exception paramConfigType)
    {
      localStringBuilder.append("null. Exception: ");
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, localStringBuilder.toString(), paramConfigType);
      }
    }
    return null;
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return a(4, paramString, 0);
    }
    return a(1, paramString, 0);
  }
  
  /* Error */
  public HashMap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 480	java/util/HashMap
    //   9: dup
    //   10: invokespecial 637	java/util/HashMap:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 755	com/tencent/mobileqq/app/QQAppInterface:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 2737	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   22: new 399	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 402	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2739
    //   32: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 969	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   39: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 412	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 2742	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   48: iconst_1
    //   49: anewarray 393	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc_w 2744
    //   57: aastore
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 2750	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +133 -> 203
    //   73: aload 4
    //   75: invokeinterface 2755 1 0
    //   80: ifle +123 -> 203
    //   83: aload 4
    //   85: ldc_w 2744
    //   88: invokeinterface 2758 2 0
    //   93: istore_2
    //   94: new 518	java/util/ArrayList
    //   97: dup
    //   98: invokespecial 519	java/util/ArrayList:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: astore_3
    //   106: aload 4
    //   108: invokeinterface 2761 1 0
    //   113: ifeq +92 -> 205
    //   116: aload 4
    //   118: iload_2
    //   119: invokeinterface 2762 2 0
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull -23 -> 103
    //   129: aload 5
    //   131: aload_3
    //   132: invokevirtual 1233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -33 -> 103
    //   139: astore_3
    //   140: aload 5
    //   142: astore_3
    //   143: aload_3
    //   144: astore 5
    //   146: aload 4
    //   148: ifnull +460 -> 608
    //   151: aload 4
    //   153: invokeinterface 2765 1 0
    //   158: iload_1
    //   159: bipush 254
    //   161: if_icmpne +77 -> 238
    //   164: aload_3
    //   165: ifnull +35 -> 200
    //   168: aload_3
    //   169: invokevirtual 818	java/util/ArrayList:size	()I
    //   172: ifle +28 -> 200
    //   175: aload 7
    //   177: bipush 254
    //   179: invokestatic 1511	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aload_3
    //   183: aload_3
    //   184: invokevirtual 818	java/util/ArrayList:size	()I
    //   187: anewarray 393	java/lang/String
    //   190: invokevirtual 2769	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   193: checkcast 2771	[Ljava/lang/String;
    //   196: invokevirtual 2311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload 7
    //   202: areturn
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore 5
    //   208: aload 4
    //   210: ifnull +398 -> 608
    //   213: aload 4
    //   215: invokeinterface 2765 1 0
    //   220: goto -62 -> 158
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 2765 1 0
    //   236: aload_3
    //   237: athrow
    //   238: aload_3
    //   239: ifnull +357 -> 596
    //   242: aload_0
    //   243: aload_3
    //   244: invokevirtual 2774	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/util/List;)Ljava/util/Map;
    //   247: astore 8
    //   249: aload 8
    //   251: ifnull +316 -> 567
    //   254: new 518	java/util/ArrayList
    //   257: dup
    //   258: invokespecial 519	java/util/ArrayList:<init>	()V
    //   261: astore 6
    //   263: new 518	java/util/ArrayList
    //   266: dup
    //   267: invokespecial 519	java/util/ArrayList:<init>	()V
    //   270: astore 4
    //   272: new 518	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 519	java/util/ArrayList:<init>	()V
    //   279: astore 5
    //   281: iconst_0
    //   282: istore_2
    //   283: iload_2
    //   284: aload_3
    //   285: invokevirtual 818	java/util/ArrayList:size	()I
    //   288: if_icmpge +130 -> 418
    //   291: aload_3
    //   292: iload_2
    //   293: invokevirtual 1217	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   296: checkcast 393	java/lang/String
    //   299: astore 9
    //   301: aload 8
    //   303: aload 9
    //   305: invokeinterface 2777 2 0
    //   310: checkcast 1424	java/lang/Integer
    //   313: invokevirtual 2324	java/lang/Integer:intValue	()I
    //   316: tableswitch	default:+32 -> 348, 1:+39->355, 2:+60->376, 3:+32->348, 4:+81->397
    //   349: iconst_1
    //   350: iadd
    //   351: istore_2
    //   352: goto -69 -> 283
    //   355: iload_1
    //   356: iconst_m1
    //   357: if_icmpeq +8 -> 365
    //   360: iload_1
    //   361: iconst_1
    //   362: if_icmpne -14 -> 348
    //   365: aload 6
    //   367: aload 9
    //   369: invokevirtual 1233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: goto -25 -> 348
    //   376: iload_1
    //   377: iconst_m1
    //   378: if_icmpeq +8 -> 386
    //   381: iload_1
    //   382: iconst_2
    //   383: if_icmpne -35 -> 348
    //   386: aload 4
    //   388: aload 9
    //   390: invokevirtual 1233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   393: pop
    //   394: goto -46 -> 348
    //   397: iload_1
    //   398: iconst_m1
    //   399: if_icmpeq +8 -> 407
    //   402: iload_1
    //   403: iconst_4
    //   404: if_icmpne -56 -> 348
    //   407: aload 5
    //   409: aload 9
    //   411: invokevirtual 1233	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   414: pop
    //   415: goto -67 -> 348
    //   418: aload 6
    //   420: astore_3
    //   421: aload_3
    //   422: ifnull +44 -> 466
    //   425: aload_3
    //   426: invokevirtual 818	java/util/ArrayList:size	()I
    //   429: ifle +37 -> 466
    //   432: iload_1
    //   433: iconst_m1
    //   434: if_icmpeq +8 -> 442
    //   437: iload_1
    //   438: iconst_1
    //   439: if_icmpne +27 -> 466
    //   442: aload 7
    //   444: iconst_1
    //   445: invokestatic 1511	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aload_3
    //   449: aload_3
    //   450: invokevirtual 818	java/util/ArrayList:size	()I
    //   453: anewarray 393	java/lang/String
    //   456: invokevirtual 2769	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   459: checkcast 2771	[Ljava/lang/String;
    //   462: invokevirtual 2311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload 4
    //   468: ifnull +47 -> 515
    //   471: aload 4
    //   473: invokevirtual 818	java/util/ArrayList:size	()I
    //   476: ifle +39 -> 515
    //   479: iload_1
    //   480: iconst_m1
    //   481: if_icmpeq +8 -> 489
    //   484: iload_1
    //   485: iconst_2
    //   486: if_icmpne +29 -> 515
    //   489: aload 7
    //   491: iconst_2
    //   492: invokestatic 1511	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   495: aload 4
    //   497: aload 4
    //   499: invokevirtual 818	java/util/ArrayList:size	()I
    //   502: anewarray 393	java/lang/String
    //   505: invokevirtual 2769	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   508: checkcast 2771	[Ljava/lang/String;
    //   511: invokevirtual 2311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 5
    //   517: ifnull +47 -> 564
    //   520: aload 5
    //   522: invokevirtual 818	java/util/ArrayList:size	()I
    //   525: ifle +39 -> 564
    //   528: iload_1
    //   529: iconst_m1
    //   530: if_icmpeq +8 -> 538
    //   533: iload_1
    //   534: iconst_4
    //   535: if_icmpne +29 -> 564
    //   538: aload 7
    //   540: iconst_4
    //   541: invokestatic 1511	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aload 5
    //   546: aload 5
    //   548: invokevirtual 818	java/util/ArrayList:size	()I
    //   551: anewarray 393	java/lang/String
    //   554: invokevirtual 2769	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   557: checkcast 2771	[Ljava/lang/String;
    //   560: invokevirtual 2311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: aload 7
    //   566: areturn
    //   567: aconst_null
    //   568: astore 4
    //   570: aload 6
    //   572: astore 5
    //   574: goto -153 -> 421
    //   577: astore_3
    //   578: goto -354 -> 224
    //   581: astore_3
    //   582: aconst_null
    //   583: astore 4
    //   585: aconst_null
    //   586: astore_3
    //   587: goto -444 -> 143
    //   590: astore_3
    //   591: aconst_null
    //   592: astore_3
    //   593: goto -450 -> 143
    //   596: aconst_null
    //   597: astore 4
    //   599: aconst_null
    //   600: astore_3
    //   601: aload 6
    //   603: astore 5
    //   605: goto -184 -> 421
    //   608: aload 5
    //   610: astore_3
    //   611: goto -453 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	614	0	this	QQAppInterface
    //   0	614	1	paramInt	int
    //   93	259	2	i1	int
    //   64	68	3	localObject1	Object
    //   139	1	3	localException1	Exception
    //   142	64	3	localObject2	Object
    //   223	69	3	localList	List
    //   420	30	3	localArrayList1	ArrayList
    //   577	1	3	localObject3	Object
    //   581	1	3	localException2	Exception
    //   586	1	3	localObject4	Object
    //   590	1	3	localException3	Exception
    //   592	19	3	localObject5	Object
    //   4	594	4	localObject6	Object
    //   101	508	5	localObject7	Object
    //   1	601	6	localArrayList2	ArrayList
    //   13	552	7	localHashMap	HashMap
    //   247	55	8	localMap	Map
    //   299	111	9	str	String
    // Exception table:
    //   from	to	target	type
    //   106	125	139	java/lang/Exception
    //   129	136	139	java/lang/Exception
    //   15	65	223	finally
    //   73	103	577	finally
    //   106	125	577	finally
    //   129	136	577	finally
    //   15	65	581	java/lang/Exception
    //   73	103	590	java/lang/Exception
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map a(List paramList)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.a(paramList, 1);
    }
    return null;
  }
  
  public ServletContainer a(Class paramClass)
  {
    QLog.e("QZLog", 1, "getServletContainer");
    Method localMethod = a().getClass().getDeclaredMethod("getServletContainer", new Class[] { paramClass.getClass() });
    localMethod.setAccessible(true);
    paramClass = (ServletContainer)localMethod.invoke(a(), new Object[] { paramClass });
    QLog.e("QZLog", 1, "getServletContainer finished");
    return paramClass;
  }
  
  public void a()
  {
    if (!this.g) {
      this.g = true;
    }
    while ((!isLogin()) || (!this.g)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "Wifi, tryReuploadQfavItems");
    }
    QfavHelper.a(this);
  }
  
  public void a(int paramInt)
  {
    try
    {
      ((ConfigHandler)a(4)).a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt, Handler paramHandler)
  {
    Method localMethod = a().getClass().getDeclaredMethod("refreshWidgetInfo", new Class[] { Integer.TYPE, Handler.class });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { Integer.valueOf(paramInt), paramHandler });
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    int i1 = 0;
    paramString = a(paramInt1, paramString, (byte)0, paramInt2);
    paramInt1 = i1;
    while (paramInt1 <= 3)
    {
      String str = paramString + "_" + paramInt1;
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(str);
      paramInt1 += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    Object localObject1;
    label173:
    Object localObject2;
    label782:
    label797:
    do
    {
      QQMessageFacade localQQMessageFacade;
      boolean bool;
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localQQMessageFacade = a();
                    } while (localQQMessageFacade == null);
                    localObject1 = localQQMessageFacade.a();
                  } while (localObject1 == null);
                  if ((1000 != ((QQMessageFacade.Message)localObject1).istroop) && (1020 != ((QQMessageFacade.Message)localObject1).istroop)) {
                    break;
                  }
                  if ((((QQMessageFacade.Message)localObject1).frienduin == null) || (!((QQMessageFacade.Message)localObject1).frienduin.equalsIgnoreCase(a()))) {
                    break label173;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
                return;
                if ((((QQMessageFacade.Message)localObject1).senderuin == null) || (!((QQMessageFacade.Message)localObject1).senderuin.equalsIgnoreCase(a()))) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("notification", 2, "receivedMsgNotification ,self message");
              return;
              if ((!b((QQMessageFacade.Message)localObject1)) || (((QQMessageFacade.Message)localObject1).needNotification())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("notification", 2, "receivedMsgNotification , isTroopMark");
            return;
          } while (((1008 == ((QQMessageFacade.Message)localObject1).istroop) || (1024 == ((QQMessageFacade.Message)localObject1).istroop)) && ((PubAccountAssistantManager.a().a(this, ((QQMessageFacade.Message)localObject1).senderuin)) || ((1008 == ((QQMessageFacade.Message)localObject1).istroop) && (TroopBarAssistantManager.a().a(this, ((QQMessageFacade.Message)localObject1).senderuin))) || (7100 == ((QQMessageFacade.Message)localObject1).istroop) || ((((QQMessageFacade.Message)localObject1).istroop == 1008) && ((((QQMessageFacade.Message)localObject1).extStr == null) || (((((QQMessageFacade.Message)localObject1).extLong & 0x1) == 0) && (!((QQMessageFacade.Message)localObject1).extStr.contains("lockDisplay"))) || (((QQMessageFacade.Message)localObject1).extStr == null) || (((((QQMessageFacade.Message)localObject1).extLong & 0x1) == 1) && (!((QQMessageFacade.Message)localObject1).getExtInfoFromExtStr("lockDisplay").equals("true")))))));
          if (!UserguideActivity.a(a(), a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
        return;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("receivedMsgNotification , isRunBackground :");
          if ((!this.isBackground_Pause) && (!this.isBackground_Stop)) {
            break;
          }
          bool = true;
          QLog.d("notification", 2, bool + ",userActiveStatus:" + this.aO + ",needSoundVibrationsTip:" + paramBoolean1 + ",baseInfo:" + ((QQMessageFacade.Message)localObject1).getBaseInfoString());
        }
        if (GuardManager.a != null) {
          GuardManager.a.b(0, null);
        }
        bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController.a((QQMessageFacade.Message)localObject1);
        if (((!this.isBackground_Stop) && (!bool)) || ((((QQMessageFacade.Message)localObject1).istroop != 6000) && (this.aO != 0) && ((((QQMessageFacade.Message)localObject1).istroop != 1001) || (((QQMessageFacade.Message)localObject1).msgtype != -3001)) && (((QQMessageFacade.Message)localObject1).istroop != 1008) && (((QQMessageFacade.Message)localObject1).istroop != 9002))) {
          break label797;
        }
        if (((QQMessageFacade.Message)localObject1).istroop != 9002) {
          break label782;
        }
        localObject2 = (ActivateFriendsManager)getManager(80);
      } while (!((ActivateFriendsManager)localObject2).a(((QQMessageFacade.Message)localObject1).msgData));
      if (((ActivateFriendsManager)localObject2).b(((QQMessageFacade.Message)localObject1).msgData)) {}
      for (((QQMessageFacade.Message)localObject1).counter += paramInt;; ((QQMessageFacade.Message)localObject1).counter += paramInt)
      {
        localQQMessageFacade.c((QQMessageFacade.Message)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "receivedMsgNotification , frienduin " + ((QQMessageFacade.Message)localObject1).frienduin + ",type " + ((QQMessageFacade.Message)localObject1).istroop + ",counter:" + ((QQMessageFacade.Message)localObject1).counter);
        }
        a((QQMessageFacade.Message)localObject1, paramBoolean1, paramBoolean2);
        localObject1 = a();
        paramInt = i1;
        if (localObject1 != null) {
          paramInt = ((QCallFacade)localObject1).a();
        }
        i1 = localQQMessageFacade.e();
        BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i1 + paramInt);
        return;
        bool = false;
        break;
      }
    } while ((((QQMessageFacade.Message)localObject1).msgtype == -1013) || (((QQMessageFacade.Message)localObject1).msgtype == -1019) || (((QQMessageFacade.Message)localObject1).msgtype == -1018));
    if ((((QQMessageFacade.Message)localObject1).istroop == 1008) && (AppConstants.T.equals(((QQMessageFacade.Message)localObject1).senderuin)))
    {
      e((MessageRecord)localObject1, paramBoolean2);
      return;
    }
    if ((paramBoolean1) && ((((QQMessageFacade.Message)localObject1).istroop == 6000) || (this.aO == 0) || ((((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001)) || (((QQMessageFacade.Message)localObject1).istroop == 1008) || (((QQMessageFacade.Message)localObject1).istroop == 9002)))
    {
      if (this.p) {
        break label1027;
      }
      e((MessageRecord)localObject1, paramBoolean2);
    }
    label1027:
    for (;;)
    {
      label943:
      if ((paramBoolean1) && ((((QQMessageFacade.Message)localObject1).istroop == 6000) || (this.aO == 0) || ((((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001))) && (((QQMessageFacade.Message)localObject1).istroop == 1001) && (((QQMessageFacade.Message)localObject1).msgtype == -3001))
      {
        OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), ((QQMessageFacade.Message)localObject1).action);
        break;
        if ((this.jdField_c_of_type_ArrayOfLong[0] == ((QQMessageFacade.Message)localObject1).uniseq) && (this.jdField_c_of_type_ArrayOfLong[1] == 1L))
        {
          e((MessageRecord)localObject1, paramBoolean2);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfByte[0] = 1;
          localObject2 = this.jdField_a_of_type_ArrayOfByte;
          if (!paramBoolean2) {
            break label1091;
          }
        }
      }
    }
    label1091:
    for (paramInt = 1;; paramInt = 0)
    {
      localObject2[1] = ((byte)paramInt);
      break label943;
      break;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "receivedMsgNotification , size is:" + paramInt + ",isOnline is:" + paramBoolean2);
    }
    if (paramInt == 0) {}
    label49:
    do
    {
      do
      {
        do
        {
          do
          {
            break label49;
            break label49;
            break label49;
            break label49;
            do
            {
              return;
            } while (paramMessageRecord == null);
            if ((1000 != paramMessageRecord.istroop) && (1020 != paramMessageRecord.istroop)) {
              break;
            }
            if ((paramMessageRecord.frienduin == null) || (!paramMessageRecord.frienduin.equalsIgnoreCase(a()))) {
              break label166;
            }
          } while (!QLog.isColorLevel());
          QLog.d("notification", 2, "receivedMsgNotification , stranger  self message");
          return;
          if ((paramMessageRecord.senderuin == null) || (!paramMessageRecord.senderuin.equalsIgnoreCase(a())) || (paramMessageRecord.msgtype == -4008)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("notification", 2, "receivedMsgNotification ,self message");
        return;
      } while (((1008 == paramMessageRecord.istroop) || (1024 == paramMessageRecord.istroop)) && ((PubAccountAssistantManager.a().a(this, paramMessageRecord.senderuin)) || ((1008 == paramMessageRecord.istroop) && (TroopBarAssistantManager.a().a(this, paramMessageRecord.senderuin))) || (7100 == paramMessageRecord.istroop) || ((paramMessageRecord.istroop == 1008) && ((paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) || (paramMessageRecord.extStr == null) || (((paramMessageRecord.extLong & 0x1) == 1) && (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")))))));
      if (!UserguideActivity.a(a(), a())) {
        break;
      }
    } while (!QLog.isColorLevel());
    label166:
    QLog.d("notification", 2, "receivedMsgNotification , showUserGuide");
    return;
    if (GuardManager.a != null) {
      GuardManager.a.b(0, null);
    }
    boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    Object localObject = ((ActivityManager)BaseApplicationImpl.a().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "locking activity:" + ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity"))) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      int i1 = i2;
      if (paramMessageRecord.msgtype == -2016)
      {
        i1 = i2;
        if (paramMessageRecord.istroop == 3000) {
          i1 = 1;
        }
      }
      if ((paramInt != 0) && (i1 != 0)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("notification", 2, "isBackground_Pause:" + this.isBackground_Pause);
        QLog.d("notification", 2, "isBackground_Stop:" + this.isBackground_Stop);
        QLog.d("notification", 2, "isScreenLocked:" + bool);
      }
      if (((!this.isBackground_Stop) && (!bool)) || ((paramMessageRecord.istroop != 6000) && (this.aO != 0) && ((paramMessageRecord.istroop != 1001) || (paramMessageRecord.msgtype != -3001)) && (paramMessageRecord.istroop != 1008))) {
        break;
      }
      a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (e())
    {
      a().getSharedPreferences("acc_info" + getAccount(), 0).edit().putLong("getProfileStatusNew", paramLong).commit();
      this.jdField_d_of_type_Long = paramLong;
      if (paramBoolean) {
        l();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    Method localMethod = a().getClass().getDeclaredMethod("jumpToVisitor", new Class[] { Context.class });
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[] { paramContext });
  }
  
  public void a(Context paramContext, Class paramClass)
  {
    if (!b()) {
      break label7;
    }
    label7:
    while (paramContext == null) {
      return;
    }
    Object localObject;
    if (paramClass == null) {
      if ((paramContext instanceof Activity))
      {
        paramClass = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramContext.getClass());
        localObject = ((Activity)paramContext).getIntent().getExtras();
        paramContext = paramClass;
        if (localObject != null)
        {
          ((Bundle)localObject).remove("single");
          ((Bundle)localObject).remove("selfuin");
          paramClass.putExtras((Bundle)localObject);
          paramContext = paramClass;
        }
      }
    }
    for (;;)
    {
      paramContext.putExtra("fromNotification", true);
      paramContext.addFlags(536870912).addFlags(67108864);
      if (!e()) {
        break;
      }
      String str = a();
      localObject = null;
      Friends localFriends = ((FriendManager)getManager(8)).c(str);
      paramClass = str;
      if (localFriends != null)
      {
        Bitmap localBitmap = SkinUtils.a(a(localFriends.uin, false));
        paramClass = str;
        localObject = localBitmap;
        if (localFriends.name != null)
        {
          paramClass = str;
          localObject = localBitmap;
          if (localFriends.name.length() > 0)
          {
            paramClass = localFriends.name;
            localObject = localBitmap;
          }
        }
      }
      a(paramContext, "", paramClass, this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131365727), (Bitmap)localObject, "CMD_IDLE_NOTIFIYCATION");
      return;
      paramContext = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), SplashActivity.class);
      continue;
      paramContext = new Intent(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramClass);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_b_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    a(paramBusinessObserver, false);
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
      }
    }
    while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(CallTabUnreadListener paramCallTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = paramCallTabUnreadListener;
  }
  
  public void a(CheckPttListener paramCheckPttListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener = paramCheckPttListener;
  }
  
  public void a(MsgTabUnreadListener paramMsgTabUnreadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = paramMsgTabUnreadListener;
  }
  
  public void a(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {}
    while (this.jdField_d_of_type_JavaUtilList.indexOf(paramVibrateListener) >= 0) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.add(paramVibrateListener);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage))
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
      if (paramMessage != null) {
        a(paramMessage, false, true);
      }
    }
    else
    {
      return;
    }
    k();
  }
  
  public void a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.h + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessage);
    }
    if ((this.h) || (!bool)) {
      return;
    }
    Object localObject3 = "";
    Object localObject4 = "";
    Bitmap localBitmap = null;
    Object localObject5 = null;
    if (ActionMsgUtil.d(paramMessage.msgtype)) {
      localObject3 = a().getString(2131368619);
    }
    for (;;)
    {
      label130:
      Object localObject6 = a(a(), paramMessage, true);
      ((Intent)localObject6).putExtra("entrance", 6);
      ((Intent)localObject6).putExtra("key_notification_click_action", true);
      Object localObject7 = ((Intent)localObject6).getStringExtra("uinname");
      if ((localObject7 == null) || ("".equals(localObject7))) {
        localObject7 = ((Intent)localObject6).getStringExtra("uin");
      }
      label303:
      label334:
      label733:
      label753:
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        Object localObject8;
        switch (paramMessage.istroop)
        {
        default: 
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() == 1)
          {
            if (AppConstants.aj.equals(paramMessage.frienduin)) {
              localObject5 = a(paramMessage.senderuin, true);
            }
          }
          else
          {
            localObject4 = (String)localObject7 + ": ";
            localObject1 = localObject3;
            localObject8 = localObject7;
          }
          break;
        }
        for (;;)
        {
          localObject7 = localObject1;
          if (ActionMsgUtil.a(paramMessage.msgtype))
          {
            if ((paramMessage.actMsgContentValue != null) && (!"".endsWith(paramMessage.actMsgContentValue)))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_b_of_type_JavaLangString, 2, "isShareAppActionMsg+ actionDetailMsg=" + paramMessage.actMsgContentValue);
              }
              localObject1 = paramMessage.actMsgContentValue;
              label410:
              localObject3 = localObject1;
              localObject7 = localObject1;
            }
          }
          else
          {
            if (paramMessage.istroop != 1008) {
              break label2255;
            }
            localObject1 = (String)localObject4 + (String)localObject7;
            label450:
            localObject3 = localObject7;
            localObject4 = localObject1;
            if (paramMessage.msgtype == -2016)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
              localObject4 = localObject3;
            }
            localObject1 = localObject8;
            if (paramMessage.counter > 1)
            {
              if (paramMessage.counter <= 100) {
                break label2294;
              }
              localObject1 = (String)localObject8 + " (" + a().getString(2131368293) + ")";
            }
            label550:
            if (!paramBoolean) {
              localObject4 = null;
            }
            if (paramMessage.istroop != 1008) {
              break label2392;
            }
            if ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) || (paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
              break;
            }
            ((Intent)localObject6).putExtra("need_report", true);
            ((Intent)localObject6).putExtra("incoming_msguid", paramMessage.msgUid);
            ((Intent)localObject6).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
            localObject7 = ((Intent)localObject6).getStringExtra("uin");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject7))) {
              break label2807;
            }
            localObject4 = ((String)localObject1).replace((CharSequence)localObject7, "");
            label703:
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label2346;
            }
            label711:
            if (!AppConstants.T.equals(localObject7)) {
              break label2377;
            }
            localObject5 = a(paramMessage.frienduin, true);
            localObject4 = localObject3;
            localObject7 = localObject1;
            localObject1 = localObject6;
            localObject6 = localObject4;
            localObject4 = localObject7;
            if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.ab))) {
              break label2724;
            }
            label790:
            a((Intent)localObject1, (String)localObject3, (String)localObject4, (String)localObject6, (Bitmap)localObject5, "CMD_SHOW_NOTIFIYCATION");
            return;
            if (paramMessage.msgtype == -2009)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(getApplication(), paramMessage, true);
              break label130;
            }
            if (paramMessage.msgtype == -2011)
            {
              try
              {
                localObject1 = StructMsgFactory.a(paramMessage.msgData);
                if (localObject1 == null)
                {
                  localObject1 = localObject3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                    localObject1 = localObject3;
                  }
                }
                else
                {
                  localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + localException.getMessage(), localException);
                }
                localObject3 = "";
              }
              break label130;
            }
            localObject2 = paramMessage.getMessageText();
            if ((localObject2 instanceof QQText))
            {
              localObject3 = ((QQText)localObject2).a();
              break label130;
            }
            if (localObject2 == null) {}
            for (localObject2 = "";; localObject2 = ((CharSequence)localObject2).toString())
            {
              localObject3 = new QQText((CharSequence)localObject2, 3).a();
              break;
            }
            if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
            {
              localObject4 = paramMessage.nickName + "(" + (String)localObject7 + "):";
              localObject2 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject3;
              label1107:
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                break label2854;
              }
              localObject5 = (DiscussionHandler)a(6);
              if (localObject5 == null) {
                break label2848;
              }
            }
          }
          label2848:
          for (localObject5 = ((DiscussionHandler)localObject5).a(paramMessage.frienduin, true);; localObject5 = null)
          {
            localObject8 = localObject7;
            break label334;
            localObject2 = ContactUtils.a(this, paramMessage.senderuin, 0);
            localObject4 = (String)localObject2 + "(" + (String)localObject7 + "):";
            localObject2 = a(paramMessage) + (String)localObject2 + ": " + (String)localObject3;
            break label1107;
            if (paramMessage.msgtype == -1013)
            {
              localObject4 = (String)localObject7 + ":";
              localObject2 = localObject3;
              localObject8 = localObject7;
              localObject5 = localBitmap;
              break label334;
            }
            if (AnonymousChatHelper.a(paramMessage))
            {
              localObject4 = AnonymousChatHelper.a(paramMessage).jdField_b_of_type_JavaLangString;
              localObject2 = a().getString(2131363837) + (String)localObject4 + "(" + (String)localObject7 + "):";
              localObject4 = a().getString(2131363837) + (String)localObject4 + ": " + (String)localObject3;
            }
            for (;;)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() == 1)
              {
                localBitmap = a(paramMessage.frienduin, (byte)3, false, false);
                localObject5 = localObject2;
                localObject2 = localObject4;
                localObject8 = localObject7;
                localObject4 = localObject5;
                localObject5 = localBitmap;
                break label334;
                if ((paramMessage.nickName != null) && (!"".equals(paramMessage.nickName)))
                {
                  localObject2 = a(paramMessage) + paramMessage.nickName + "(" + (String)localObject7 + "):";
                  localObject4 = a(paramMessage) + paramMessage.nickName + ": " + (String)localObject3;
                }
                else
                {
                  localObject4 = ContactUtils.e(this, paramMessage.frienduin, paramMessage.senderuin);
                  localObject2 = a(paramMessage) + (String)localObject4 + "(" + (String)localObject7 + "):";
                  localObject4 = a(paramMessage) + (String)localObject4 + ": " + (String)localObject3;
                  continue;
                  localObject4 = ((Intent)localObject6).getStringExtra("subAccountLatestNick");
                  if (localObject4 != null)
                  {
                    localObject2 = localObject4;
                    if (((String)localObject4).length() != 0) {}
                  }
                  else
                  {
                    localObject2 = paramMessage.senderuin;
                  }
                  localObject4 = (String)localObject7 + "-" + (String)localObject2 + ":" + (String)localObject3;
                  localObject2 = (String)localObject2 + ":" + (String)localObject3;
                  localObject5 = null;
                  localObject8 = localObject7;
                  break label334;
                  localObject4 = (String)localObject7 + ": ";
                  localObject2 = localObject3;
                  localObject8 = localObject7;
                  localObject5 = localBitmap;
                  break label334;
                  localObject2 = ContactUtils.m(this, paramMessage.frienduin);
                  String str1 = (String)localObject2 + "(" + (String)localObject7 + "):";
                  String str2 = a(paramMessage) + (String)localObject2 + ": " + (String)localObject3;
                  localObject2 = str2;
                  localObject8 = localObject7;
                  localObject4 = str1;
                  localObject5 = localBitmap;
                  if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() != 1) {
                    break label334;
                  }
                  localObject5 = a(paramMessage.frienduin, 3000);
                  localObject2 = str2;
                  localObject8 = localObject7;
                  localObject4 = str1;
                  break label334;
                  localObject5 = SkinUtils.a(a().getResources().getDrawable(2130838440));
                  localObject8 = XMLMessageUtils.a(paramMessage);
                  if ((localObject8 != null) && (!((PAMessage)localObject8).items.isEmpty()))
                  {
                    localObject2 = ((PAMessage.Item)((PAMessage)localObject8).items.get(0)).title;
                    if ((((PAMessage.Item)((PAMessage)localObject8).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject8).items.get(0)).digestList != null))
                    {
                      localObject7 = (String)((PAMessage.Item)((PAMessage)localObject8).items.get(0)).digestList.get(0);
                      localObject8 = localObject2;
                      localObject2 = localObject7;
                      break label334;
                    }
                    localObject8 = localObject7;
                    break label334;
                    localObject5 = SkinUtils.a(a().getResources().getDrawable(2130839803));
                    localObject4 = (String)localObject7 + ": ";
                    localObject2 = localObject3;
                    localObject8 = localObject7;
                    break label334;
                    if (paramMessage.istroop == 1001)
                    {
                      localObject5 = a(paramMessage.frienduin, 3000);
                      break label303;
                    }
                    localObject5 = a(paramMessage.frienduin, true);
                    break label303;
                    localObject2 = a().a(AppShareIDUtil.a(paramMessage.shareAppID));
                    if ((localObject2 == null) || (((AppShareID)localObject2).messagetail == null) || ("".equals(((AppShareID)localObject2).messagetail)))
                    {
                      localObject2 = a().getString(2131368378);
                      break label410;
                    }
                    localObject2 = a().getString(2131368376) + ((AppShareID)localObject2).messagetail + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getString(2131368377);
                    break label410;
                    label2255:
                    localObject2 = localObject4;
                    if (paramMessage.istroop == 7000) {
                      break label450;
                    }
                    localObject2 = (String)localObject4 + (String)localObject3;
                    break label450;
                    label2294:
                    localObject2 = (String)localObject8 + " (" + paramMessage.counter + a().getString(2131367186) + ")";
                    break label550;
                    label2346:
                    localObject3 = (String)localObject4 + " : " + (String)localObject3;
                    break label711;
                    label2377:
                    localObject2 = a().getString(2131367989);
                    break label733;
                    label2392:
                    if ((paramMessage.istroop == 1001) && (paramMessage.msgtype == -3001))
                    {
                      if (OpenAppClient.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), paramMessage.action, paramMessage.frienduin, paramMessage.istroop) == null) {
                        break;
                      }
                      localObject7 = localObject2;
                      localObject2 = localObject6;
                      localObject6 = localObject3;
                      localObject3 = localObject4;
                      localObject4 = localObject7;
                      break label753;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d() > 1)
                    {
                      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b();
                      localObject3 = new StringBuffer();
                      ((StringBuffer)localObject3).append(String.format(a().getString(2131368298), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.d()) }));
                      if (i1 == 0) {
                        break;
                      }
                      if (i1 > 1000) {
                        ((StringBuffer)localObject3).append(a().getString(2131368292));
                      }
                      for (;;)
                      {
                        localObject2 = new Intent(a(), SplashActivity.class);
                        ((Intent)localObject2).addFlags(335544320);
                        ((Intent)localObject2).putExtra("tab_index", 1);
                        localObject5 = a().getString(2131368291);
                        localObject6 = ((StringBuffer)localObject3).toString();
                        localObject7 = null;
                        localObject3 = localObject4;
                        localObject4 = localObject5;
                        localObject5 = localObject7;
                        break;
                        ((StringBuffer)localObject3).append(i1).append(a().getString(2131367186));
                      }
                    }
                    if (paramMessage.istroop == 0)
                    {
                      ((Intent)localObject6).putExtra("need_report", true);
                      ((Intent)localObject6).putExtra("incoming_msguid", paramMessage.msgUid);
                      ((Intent)localObject6).putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
                      ((Intent)localObject6).putExtra("KEY_FROM", "notifcation");
                    }
                    localObject7 = localObject2;
                    localObject2 = localObject6;
                    localObject6 = localObject3;
                    localObject3 = localObject4;
                    localObject4 = localObject7;
                    break label753;
                    label2724:
                    if (!QQUtils.a(a())) {
                      break label790;
                    }
                    localObject7 = (QQLSRecentManager)getManager(68);
                    if (!SettingCloneUtil.readValue(a(), a(), a().getString(2131367906), "qqsetting_lock_screen_whenexit_key", true)) {
                      break label790;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsg");
                    }
                    ((QQLSRecentManager)localObject7).a(this, paramMessage.frienduin, paramMessage.istroop, false);
                    break label790;
                    label2807:
                    localObject4 = localObject2;
                    break label703;
                  }
                  localObject2 = localObject3;
                  localObject8 = localObject7;
                  break label334;
                }
              }
            }
            localObject5 = localObject2;
            localObject2 = localObject4;
            localObject8 = localObject7;
            localObject4 = localObject5;
            localObject5 = localBitmap;
            break label334;
          }
          label2854:
          localObject8 = localObject7;
          localObject5 = localBitmap;
        }
      }
      localObject3 = localObject2;
    }
  }
  
  public void a(ResourcePluginListener paramResourcePluginListener)
  {
    n();
    this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a(paramResourcePluginListener);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject3;
    Bitmap localBitmap;
    QQMessageFacade.Message localMessage;
    Intent localIntent;
    if ((1010 == paramMessageRecord.istroop) || (1001 == paramMessageRecord.istroop))
    {
      boolean bool = ((KeyguardManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      localObject1 = "";
      localObject2 = "";
      localObject3 = "";
      localBitmap = null;
      localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
      if ((!this.isBackground_Stop) && (!bool)) {
        break label653;
      }
      localIntent = new Intent(a(), SplashActivity.class);
      localIntent.putExtra("target_activity", MsgBoxListActivity.class);
      localIntent.addFlags(335544320);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "OneWayMessageNotifyVibert mr.frienduin" + paramMessageRecord.frienduin + ", mr.istroop" + paramMessageRecord.istroop);
      }
      if (1010 != paramMessageRecord.istroop) {
        break label471;
      }
      localIntent.putExtra("uin", AppConstants.au);
      localIntent.putExtra("uintype", paramMessageRecord.istroop);
      localIntent.setAction("com.tencent.mobileqq.action.CHAT");
      localIntent.putExtra("uinname", "");
      localIntent.putExtra("entrance", 6);
      localIntent.putExtra("key_notification_click_action", true);
      if (paramMessageRecord.istroop != 1010) {
        break label509;
      }
      localBitmap = SkinUtils.a(a().getResources().getDrawable(2130840382));
      paramMessageRecord = BaseApplicationImpl.a().getString(2131370005);
      localObject2 = BaseApplicationImpl.a().getString(2131370006);
      localIntent.putExtra("key_notifycation_oneway_message", true);
      localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
      if (((String)localObject1).length() <= 0) {
        break label679;
      }
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length < 4) {
        break label679;
      }
      paramMessageRecord = localObject1[2];
      localObject2 = localObject1[3];
    }
    label653:
    label672:
    label679:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject3 = localObject2;
      localObject2 = paramMessageRecord;
      for (;;)
      {
        label367:
        a(localIntent, (String)localObject1, (String)localObject2, (String)localObject3, localBitmap, "CMD_SHOW_NOTIFIYCATION");
        if (QQUtils.a(a()))
        {
          paramMessageRecord = (QQLSRecentManager)getManager(68);
          if (SettingCloneUtil.readValue(a(), a(), a().getString(2131367906), "qqsetting_lock_screen_whenexit_key", true))
          {
            if (1001 != localMessage.istroop) {
              break label620;
            }
            paramMessageRecord.a(this, AppConstants.az, localMessage.istroop, false);
          }
        }
        label457:
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          e(localMessage, paramBoolean);
          return;
          label471:
          if (1001 != paramMessageRecord.istroop) {
            break;
          }
          localIntent.putExtra("uin", AppConstants.af);
          localIntent.putExtra("uintype", paramMessageRecord.istroop);
          break;
          label509:
          if (paramMessageRecord.istroop != 1001) {
            break label367;
          }
          localBitmap = SkinUtils.a(a().getResources().getDrawable(2130838438));
          localObject2 = BaseApplicationImpl.a().getString(2131370007);
          localObject3 = BaseApplicationImpl.a().getString(2131370008);
          localIntent.putExtra("key_notifycation_oneway_message", true);
          paramMessageRecord = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
          if (paramMessageRecord.length() <= 0) {
            break label672;
          }
          paramMessageRecord = paramMessageRecord.split("\\|");
          if (paramMessageRecord.length < 4) {
            break label672;
          }
          localObject2 = paramMessageRecord[2];
          localObject3 = paramMessageRecord[3];
          localObject1 = localObject3;
          break label367;
          label620:
          if (1010 != localMessage.istroop) {
            break label457;
          }
          paramMessageRecord.a(this, AppConstants.aA, localMessage.istroop, false);
          break label457;
        }
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          e(localMessage, paramBoolean);
          return;
        }
        localObject1 = localObject3;
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    paramSetting = paramSetting.clone();
    paramSetting.url = null;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramSetting.uin, paramSetting);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  public void a(String arg1, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashtable.containsKey(???)) {
      return;
    }
    Object localObject3;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashtable)
      {
        this.jdField_a_of_type_JavaUtilHashtable.remove(???);
        if (paramInt == 1)
        {
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(???);
          ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
          ???.what = 990;
          this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
          if (this.jdField_a_of_type_JavaUtilHashtable.size() <= 50) {
            break;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            long l1 = System.currentTimeMillis();
            ??? = new ArrayList();
            localObject3 = this.jdField_a_of_type_JavaUtilHashtable.keys();
            if (!((Enumeration)localObject3).hasMoreElements()) {
              break label268;
            }
            String str = (String)((Enumeration)localObject3).nextElement();
            if (Math.abs(l1 - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(str)).longValue()) <= 180000L) {
              continue;
            }
            ((ArrayList)???).add(str);
          }
        }
      }
      if (paramInt == 4)
      {
        if (this.jdField_c_of_type_JavaUtilArrayList == null) {
          this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
        }
        this.jdField_c_of_type_JavaUtilArrayList.add(???);
        ??? = this.jdField_b_of_type_AndroidOsHandler.obtainMessage();
        ???.what = 991;
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(???, 500L);
      }
    }
    label268:
    paramInt = 0;
    while (paramInt < localObject2.size())
    {
      localObject3 = (String)localObject2.get(paramInt);
      this.jdField_a_of_type_JavaUtilHashtable.remove(localObject3);
      paramInt += 1;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      return;
    }
    int i1;
    if (paramInt == 3000) {
      i1 = 200;
    }
    for (;;)
    {
      Object localObject = a(32, paramString, i1);
      if ((localObject == null) || (((Pair)localObject).second == null)) {
        break;
      }
      long l1 = ((Setting)((Pair)localObject).second).headImgTimestamp;
      if (l1 == paramLong) {
        break;
      }
      localObject = (FriendListHandler)a(1);
      if (localObject != null) {
        ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l1);
      return;
      if (paramInt == 3001)
      {
        i1 = 202;
      }
      else
      {
        if (paramInt != 3002) {
          break;
        }
        i1 = 204;
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramInt != 3000) && (paramInt != 3002) && (paramInt != 3001));
      if (paramBoolean)
      {
        int i1 = 202;
        if (paramInt == 3000) {
          i1 = 200;
        }
        a(32, paramString, i1);
        localObject = new File(a(32, paramString, i1));
        if ((localObject != null) && (((File)localObject).exists())) {
          ((File)localObject).delete();
        }
      }
      localObject = (FriendListHandler)a(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).a(paramString, paramInt, (byte)1, (byte)0);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      String str = RoamSettingController.a(paramString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "setTroopMsgFilterToServer, path=" + str + " value=" + paramInteger);
      }
      localRoamSettingController.a(str, paramInteger);
      TroopAssistantManager.a().a(this, paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    boolean bool1 = h();
    boolean bool2 = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "isRingerSilent is:" + bool1 + ",canDisturb is:" + bool2);
    }
    if ((!bool1) && (bool2))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a());
      Vibrator localVibrator = (Vibrator)a().getSystemService("vibrator");
      bool1 = d();
      bool2 = A();
      boolean bool3 = z();
      boolean bool4 = m();
      boolean bool5 = w();
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "canVibrator is:" + bool3 + ",isVideoing is:" + bool1 + ",isCallIdle is:" + bool4 + ",notRecordingPtt is:" + bool5);
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        localVibrator.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!k()) && (!l()) && (m()) && (w()))
      {
        int i1 = localSharedPreferences.getInt("sound_type" + a(), 2131165186);
        if (c(paramString)) {
          i1 = 2131165200;
        }
        AudioUtil.b(i1, false);
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    E();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i1 = 0;
    label14:
    TagInfo localTagInfo1;
    TagArrayByType localTagArrayByType;
    int i2;
    if (i1 < paramArrayList.size())
    {
      localTagInfo1 = (TagInfo)paramArrayList.get(i1);
      if ((localTagInfo1 != null) && ((localTagInfo1.strContent == null) || ("".equals(localTagInfo1.strContent.trim()))))
      {
        localTagArrayByType = null;
        i2 = 0;
        label67:
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localTagArrayByType = (TagArrayByType)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if (localTagInfo1.bType != ((TagInfo)localTagArrayByType.mTags.get(0)).bType) {
            break label234;
          }
        }
        i2 = 0;
      }
    }
    for (;;)
    {
      if (i2 < localTagArrayByType.mTags.size())
      {
        TagInfo localTagInfo2 = (TagInfo)localTagArrayByType.mTags.get(i2);
        if ((localTagInfo2 != null) && (localTagInfo2.iTagId == localTagInfo1.iTagId)) {
          localTagInfo1.strContent = localTagInfo2.strContent;
        }
      }
      else
      {
        if ((localTagInfo1 != null) && (QLog.isColorLevel())) {
          QLog.d("ProfileService.SetUserInfoReq", 2, "id = " + localTagInfo1.iTagId + ", strContent = " + localTagInfo1.strContent);
        }
        i1 += 1;
        break label14;
        break;
        label234:
        i2 += 1;
        break label67;
      }
      i2 += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 0;
    if (paramBoolean)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      int i3 = arrayOfInt.length;
      i1 = i2;
      while (i1 < i3)
      {
        getManager(arrayOfInt[i1]);
        i1 += 1;
      }
    }
    while (i1 < 88)
    {
      if (i1 != 23) {
        getManager(i1);
      }
      i1 += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(getAccount(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((CardHandler)a(2)).a(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131366276) + a(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo = new SigInfo();
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey, 0, paramArrayOfByte1.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature = new byte[paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte2, 0, this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature, 0, paramArrayOfByte2.length);
      this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.wSignatureLen = ((short)this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.signature.length);
    }
  }
  
  public void a(Integer[] paramArrayOfInteger)
  {
    boolean bool = false;
    Object localObject2 = SettingCloneUtil.readValue(getApplication(), a(), null, "qqsetting_calltab_show_key", "0111100");
    if ((localObject2 == null) || (((String)localObject2).length() > "0111100".length()) || (paramArrayOfInteger == null) || (paramArrayOfInteger.length != 7))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "writeCallTabStateVal valid val," + (String)localObject2 + "," + paramArrayOfInteger);
      }
      return;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).length() < "0111100".length()) {
      localObject1 = (String)localObject2 + "0111100".substring(((String)localObject2).length());
    }
    localObject1 = new StringBuilder((String)localObject1);
    int i1 = 0;
    label159:
    if (i1 < paramArrayOfInteger.length)
    {
      localObject2 = paramArrayOfInteger[i1];
      if (localObject2 == null) {}
      for (;;)
      {
        i1 += 1;
        break label159;
        if ((((Integer)localObject2).intValue() < 0) || (((Integer)localObject2).intValue() > 9))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e(jdField_b_of_type_JavaLangString, 2, "writeCallTabStateVal wrong index,," + localObject2);
          return;
        }
        ((StringBuilder)localObject1).setCharAt(i1, (char)(((Integer)localObject2).intValue() + 48));
      }
    }
    if (paramArrayOfInteger[0] != null)
    {
      if (((StringBuilder)localObject1).charAt(4) != '0') {
        break label382;
      }
      i1 = 0;
      this.cl = i1;
      if (this.cl != 0) {
        break label387;
      }
    }
    for (;;)
    {
      this.n = bool;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "uin:" + a() + ",writeCallTabStateVal vals=" + paramArrayOfInteger + ",mIsCallTabShow=" + this.cl + ",isCallTabShow=" + this.n);
      }
      SettingCloneUtil.writeValue(getApplication(), a(), null, "qqsetting_calltab_show_key", ((StringBuilder)localObject1).toString());
      return;
      label382:
      i1 = 1;
      break;
      label387:
      bool = true;
    }
  }
  
  public boolean a()
  {
    return isLogin();
  }
  
  public boolean a(int paramInt1, String paramString, int paramInt2)
  {
    byte b1 = 3;
    if (paramInt1 == 101) {
      b1 = 1;
    }
    String str = a(paramInt1, paramString, b1, paramInt2);
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str) != null) {}
    do
    {
      return true;
      paramString = new File(a(paramInt1, paramString, paramInt2));
    } while ((paramString.exists()) && (paramString.isFile()));
    return false;
  }
  
  public boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.processName.equals(paramContext)) && (localRunningAppProcessInfo.importance == 100)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(QQMessageFacade.Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController.a(paramMessage)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramMessage);
      return true;
    }
    return false;
  }
  
  @Deprecated
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences(a(), 0).getLong(a() + paramString, 1L) == 1L) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = b(paramString);
      if ((paramInt == 3) || (paramInt == 2) || (paramInt == 4)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "getAllGeneralSettings , needTroopSettings=" + paramBoolean);
      }
      localRoamSettingController.a(paramBoolean, null);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getAllGeneralSettings roamSettingController is null ");
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      i1 = this.ce;
      this.ce = (i1 + 1);
      if (i1 < 3) {}
    }
    do
    {
      return false;
      i1 = this.cf;
      this.cf = (i1 + 1);
    } while (i1 >= 3);
    ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
    return true;
  }
  
  public byte[] a()
  {
    if ((getAccount() != null) && (isLogin()) && (this.jdField_a_of_type_ComTencentMobileqqDataSigInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataSigInfo.sessionKey;
    }
    return null;
  }
  
  public String[] a()
  {
    Object localObject = a(-1);
    String[] arrayOfString1 = (String[])((HashMap)localObject).get(Integer.valueOf(1));
    String[] arrayOfString2 = (String[])((HashMap)localObject).get(Integer.valueOf(4));
    localObject = (String[])((HashMap)localObject).get(Integer.valueOf(2));
    if (arrayOfString1 != null) {}
    for (int i2 = arrayOfString1.length + 0;; i2 = 0)
    {
      int i1 = i2;
      if (arrayOfString2 != null) {
        i1 = i2 + arrayOfString2.length;
      }
      i2 = i1;
      if (localObject != null) {
        i2 = i1 + localObject.length;
      }
      String[] arrayOfString3;
      if (i2 > 0)
      {
        arrayOfString3 = new String[i2];
        if (arrayOfString1 == null) {
          break label153;
        }
        System.arraycopy(arrayOfString1, 0, arrayOfString3, 0, arrayOfString1.length);
      }
      label153:
      for (i1 = arrayOfString1.length;; i1 = 0)
      {
        if (arrayOfString2 != null)
        {
          System.arraycopy(arrayOfString2, 0, arrayOfString3, 0, arrayOfString2.length);
          i1 = arrayOfString2.length;
        }
        if (localObject != null) {
          System.arraycopy(localObject, 0, arrayOfString3, i1, localObject.length);
        }
        return arrayOfString3;
        return null;
      }
    }
  }
  
  public String[] a(int paramInt)
  {
    return (String[])a(paramInt).get(Integer.valueOf(paramInt));
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] != null) {
      return;
    }
    this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt] = paramManager;
  }
  
  public int b()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.ring", 0);
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = a((List)localObject);
    if (localObject != null)
    {
      paramString = (Integer)((Map)localObject).get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 1;
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), 2130841985);
      if (localBitmap != null) {
        new Canvas(paramBitmap).drawBitmap(localBitmap, paramBitmap.getWidth() - localBitmap.getWidth() - 1, paramBitmap.getHeight() - localBitmap.getHeight() - 1, new Paint());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        Object localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
  
  public Drawable b(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public Drawable b(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public SQLiteDatabase b()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = a();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.b();
    }
    return null;
  }
  
  public SQLiteDatabase b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b();
    }
    return null;
  }
  
  public Config b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigConfig == null) {
      a(paramString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigConfig;
  }
  
  /* Error */
  public Setting b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1058	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   4: invokevirtual 3501	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: aload_3
    //   11: ldc_w 1500
    //   14: aload_1
    //   15: invokevirtual 2412	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   18: checkcast 1500	com/tencent/mobileqq/data/Setting
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +7 -> 30
    //   26: aload_3
    //   27: invokevirtual 3502	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 2111	java/lang/Exception:printStackTrace	()V
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: invokevirtual 3502	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +7 -> 62
    //   58: aload_2
    //   59: invokevirtual 3502	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -11 -> 54
    //   68: astore_1
    //   69: goto -34 -> 35
    //   72: aconst_null
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QQAppInterface
    //   0	74	1	paramString	String
    //   9	50	2	localEntityManager1	EntityManager
    //   7	39	3	localEntityManager2	EntityManager
    // Exception table:
    //   from	to	target	type
    //   0	8	32	java/lang/Exception
    //   0	8	51	finally
    //   10	22	64	finally
    //   37	41	64	finally
    //   10	22	68	java/lang/Exception
  }
  
  public String b()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("mobileQQ", 0);
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (Object localObject2 = ((SharedPreferences)localObject1).getString("serverlist_wifi", null);; localObject2 = ((SharedPreferences)localObject1).getString("serverlist_2g3g", null))
    {
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).split(",");
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = localObject2[((int)(Math.random() * localObject2.length))];
        }
      }
      return localObject1;
    }
  }
  
  public String b(String paramString)
  {
    String str = getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString);
    if ((str == null) || (str.length() == 0)) {
      return paramString;
    }
    return str;
  }
  
  public List b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
    return null;
  }
  
  public void b()
  {
    int i1 = 0;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Setting.class, new Setting().getTableName(), false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      while (i1 < ((List)localObject).size())
      {
        Setting localSetting = (Setting)((List)localObject).get(i1);
        localSetting.url = null;
        this.jdField_a_of_type_JavaUtilHashMap.put(localSetting.uin, localSetting);
        i1 += 1;
      }
    }
    this.o = true;
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.qqhead.getheadreq");
    a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b(int paramInt)
  {
    a(new hnv(this, paramInt));
  }
  
  public void b(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (!this.jdField_c_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      this.jdField_c_of_type_JavaUtilList.add(paramBusinessObserver);
    }
  }
  
  public void b(VibrateListener paramVibrateListener)
  {
    if (paramVibrateListener == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramVibrateListener);
  }
  
  public void b(QQMessageFacade.Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showReadedMsgNotification msgFacade.getMessages().size()" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() + ",msgFacade.getCounter():" + this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b());
    }
    if ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b() == 0))
    {
      k();
      return;
    }
    if (f())
    {
      a(paramMessage, false);
      return;
    }
    h(false);
  }
  
  public void b(ResourcePluginListener paramResourcePluginListener)
  {
    R();
    this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.a(paramResourcePluginListener);
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool = NoDisturbUtil.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext(), this);
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showInComingMsg ,isFinished=" + this.h + ", isCanDisturb=" + bool + ", needTicker=" + paramBoolean + ", message=" + paramMessageRecord);
    }
    if ((this.h) || (!bool)) {}
    QCallFacade localQCallFacade;
    do
    {
      return;
      localQCallFacade = (QCallFacade)getManager(37);
    } while (localQCallFacade == null);
    Object localObject4 = paramMessageRecord.senderuin;
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) {
      localObject4 = localQCallFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop).senderUin;
    }
    label431:
    label582:
    label1614:
    for (;;)
    {
      int i1 = localQCallFacade.c();
      if (i1 == 0) {
        break;
      }
      Intent localIntent;
      if (i1 == 1) {
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000))
        {
          localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject1 = (DiscussionHandler)a(6);
          if (localObject1 == null) {
            break label1627;
          }
        }
      }
      label463:
      label1492:
      label1627:
      for (Object localObject1 = ((DiscussionHandler)localObject1).a(paramMessageRecord.frienduin, true);; localObject1 = null)
      {
        Object localObject3 = ContactUtils.a(this, (String)localObject4, 0);
        bool = true;
        Object localObject5;
        Object localObject2;
        Object localObject6;
        int i2;
        for (;;)
        {
          localIntent.putExtra("key_notification_click_action", true);
          localObject5 = localIntent.getStringExtra("uinname");
          if (localObject5 != null)
          {
            localObject2 = localObject5;
            if (!"".equals(localObject5)) {}
          }
          else
          {
            localObject2 = localIntent.getStringExtra("uin");
          }
          if (localObject3 != null)
          {
            localObject5 = localObject3;
            if (!"".equals(localObject3)) {}
          }
          else
          {
            localObject5 = localObject4;
          }
          localObject5 = localQCallFacade.a((String)localObject5, bool);
          switch (paramMessageRecord.istroop)
          {
          default: 
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            if (paramMessageRecord.istroop != 1008) {
              break label1403;
            }
            localObject6 = (String)localObject1 + (String)localObject3;
            if (!paramBoolean) {
              localObject6 = null;
            }
            i2 = localQCallFacade.b();
            localObject1 = localObject2;
            if (i2 > 1)
            {
              localObject1 = localObject2;
              if (i1 == 1)
              {
                if (i2 <= 100) {
                  break label1442;
                }
                localObject1 = (String)localObject2 + " (" + a().getString(2131368295) + ")";
              }
            }
            if ((paramBoolean) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 1009) && (!paramMessageRecord.frienduin.equals(AppConstants.ab))) {
              break label1492;
            }
            a(localIntent, (String)localObject6, (String)localObject1, (String)localObject3, (Bitmap)localObject4, "CMD_SHOW_NOTIFIYCATION");
            return;
            if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004))
            {
              localIntent = new Intent(a(), SplashActivity.class);
              localIntent.putExtra("tab_index", 1);
              localIntent.putExtra("conversation_index", 1);
              localIntent.setFlags(335544320);
              localIntent.putExtra("uinname", a(paramMessageRecord.frienduin, (String)localObject4, paramMessageRecord.istroop, true));
            }
            for (;;)
            {
              if (!AppConstants.aj.equals(paramMessageRecord.frienduin)) {
                break label753;
              }
              localObject1 = a((String)localObject4, true);
              bool = false;
              localObject3 = "";
              break;
              localIntent = a(a(), paramMessageRecord.frienduin, paramMessageRecord.istroop);
            }
            label753:
            if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010))
            {
              localObject1 = a(paramMessageRecord.frienduin, 3000);
              bool = false;
              localObject3 = "";
            }
            else
            {
              localObject1 = a(paramMessageRecord.frienduin, true);
              bool = false;
              localObject3 = "";
            }
            break;
          }
        }
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000)) {}
        for (bool = true;; bool = false)
        {
          localIntent = new Intent(a(), SplashActivity.class);
          localIntent.putExtra("tab_index", 1);
          localIntent.putExtra("conversation_index", 1);
          localIntent.setFlags(335544320);
          localIntent.putExtra("uinname", a().getString(2131368291));
          localObject1 = null;
          localObject3 = "";
          break;
          localObject3 = ContactUtils.a(this, (String)localObject4, 0);
          localObject6 = (String)localObject3 + "(" + (String)localObject2 + "):";
          localObject3 = localObject5;
          localObject4 = localObject1;
          localObject1 = localObject6;
          break label431;
          localObject3 = localIntent.getStringExtra("subAccountLatestNick");
          localObject1 = localObject4;
          if (localObject3 != null) {
            if (((String)localObject3).length() != 0) {
              break label1614;
            }
          }
          for (localObject1 = localObject4;; localObject1 = localObject3)
          {
            localObject4 = (String)localObject2 + "-" + (String)localObject1 + ":" + (String)localObject5;
            localObject3 = (String)localObject1 + ":" + (String)localObject5;
            localObject1 = localObject4;
            localObject4 = null;
            break;
            localObject6 = (String)localObject2 + ": ";
            localObject3 = localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            if (i1 > 1)
            {
              localObject6 = (String)localObject2 + ": ";
              localObject3 = localObject5;
              localObject4 = localObject1;
              localObject1 = localObject6;
              break;
            }
            localObject3 = ContactUtils.m(this, paramMessageRecord.frienduin);
            localObject6 = (String)localObject3 + "(" + (String)localObject2 + "):";
            localObject3 = (String)localObject3 + ": " + (String)localObject5;
            localObject4 = localObject1;
            localObject1 = localObject6;
            break;
            localObject3 = SkinUtils.a(a().getResources().getDrawable(2130838440));
            localObject4 = XMLMessageUtils.a(paramMessageRecord);
            if ((localObject4 != null) && (!((PAMessage)localObject4).items.isEmpty()))
            {
              localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
              if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
              {
                localObject4 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
              for (;;)
              {
                localObject4 = localObject3;
                localObject3 = localObject1;
                localObject1 = "";
                break;
              }
              label1403:
              localObject6 = localObject1;
              if (paramMessageRecord.istroop == 7000) {
                break label463;
              }
              localObject6 = (String)localObject1 + (String)localObject5;
              break label463;
              localObject1 = (String)localObject2 + " (" + i2 + a().getString(2131367187) + ")";
              break label545;
              if (!QQUtils.a(a())) {
                break label582;
              }
              localObject2 = (QQLSRecentManager)getManager(68);
              if (!SettingCloneUtil.readValue(a(), a(), a().getString(2131367906), "qqsetting_lock_screen_whenexit_key", true)) {
                break label582;
              }
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface  showInComingMsgForQAV");
              }
              if (bool)
              {
                ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, true);
                break label582;
              }
              ((QQLSRecentManager)localObject2).a(this, paramMessageRecord.frienduin, paramMessageRecord.istroop, false);
              break label582;
            }
            localObject1 = "";
            localObject4 = localObject3;
            localObject3 = localObject5;
            break;
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "checkIfNeedSignonNet onNetNeedSignon() called url:" + paramString);
    }
    Handler localHandler = a(Conversation.class);
    if (localHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramString;
      localMessage.arg1 = 2;
      localMessage.what = 1134024;
      localHandler.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt != 3000) && (paramInt != 3002) && (paramInt != 3001));
      int i1 = 202;
      if (paramInt == 3000) {
        i1 = 200;
      }
      a(32, paramString, i1);
      paramString = new File(a(32, paramString, i1));
    } while ((paramString == null) || (!paramString.exists()));
    paramString.delete();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("exit", 2, a() + " qq start to exit ");
    }
    O();
    N();
    if (isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value in exit........... kickpc = false");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        sendOnlineStatus(AppRuntime.Status.receiveofflinemsg, false, 0L);
        ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
      }
    }
    else
    {
      if (GuardManager.a != null) {
        GuardManager.a.a();
      }
      if (!paramBoolean) {
        break label207;
      }
      localMobileQQ = getApplication();
      if (isLogin()) {
        break label202;
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localMobileQQ.QQProcessExit(paramBoolean);
      j();
      SharedPreferencesProxyManager.getInstance().trySave();
      return;
      if (paramBoolean)
      {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L);
        break;
      }
      sendOnlineStatus(AppRuntime.Status.offline, true, 0L);
      break;
    }
    label207:
    MobileQQ localMobileQQ = getApplication();
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localMobileQQ.QQProcessExit(paramBoolean);
      break;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "setVisibilityForPeople| visible = " + paramBoolean1 + ", updateLocOrNet = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext().getSharedPreferences(a(), 0).edit().putLong("nearby_enter_time", System.currentTimeMillis() - 28800000L).commit();
    }
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131366272) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).a(paramBoolean1);
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      String str = a().getString(2131368414);
      if (str != null) {
        bool = SettingCloneUtil.readValue(a(), null, str, "qqsetting_notify_icon_key", false);
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public boolean b(QQMessageFacade.Message paramMessage)
  {
    return a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = a().k(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((CardHandler)a(2)).b();
    }
    return a().getBoolean(a().getString(2131366276) + a(), true);
  }
  
  public int c()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.group.vibrate", 0);
    }
    return 0;
  }
  
  public Drawable c(String paramString)
  {
    return a(paramString, false, (byte)3);
  }
  
  public String c()
  {
    FriendManager localFriendManager = (FriendManager)getManager(8);
    if (localFriendManager != null) {
      return localFriendManager.a(a());
    }
    return "";
  }
  
  public void c()
  {
    QLog.e("QZLog", 1, "---QZoneAppInterface onRunningForeground");
    Method localMethod = a().getClass().getDeclaredMethod("onRunningForeground", new Class[0]);
    localMethod.setAccessible(true);
    localMethod.invoke(a(), new Object[0]);
    QLog.e("QZLog", 1, "---QZoneAppInterface onRunningForeground finished");
  }
  
  public void c(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.ring", Integer.valueOf(paramInt));
    }
  }
  
  public void c(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_c_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void c(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.b(paramResourcePluginListener);
    }
  }
  
  public void c(String paramString)
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.d(paramString);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      a().edit().putBoolean(a().getString(2131366274) + a(), paramBoolean1).commit();
      return;
    }
    ((LBSHandler)a(3)).b(paramBoolean1);
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (!SettingCloneUtil.readValue(a(), a(), "login_accounts", "qqsetting_bothonline_key", true)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value........... kickpc = " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public final boolean c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).d();
    }
    return a().getBoolean(a().getString(2131369538) + a(), true);
  }
  
  protected boolean canAutoLogin(String paramString)
  {
    boolean bool = SharedPreUtils.a(getApplication().getApplicationContext(), paramString);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "CNR canAutoLogin autoLogin = " + bool);
    }
    return bool;
  }
  
  public int d()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.ring.switch", 1);
    }
    return 1;
  }
  
  public String d()
  {
    return ((TicketManager)getManager(2)).getVkey(getAccount());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onMessageConnect...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator == null) || (!e())) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c();
      }
      e();
      a().a();
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          Object localObject2 = BaseApplication.getContext().getSharedPreferences("pull_msf", 0);
          Object localObject1 = ((SharedPreferences)localObject2).getString("uin", " ");
          String str = ((SharedPreferences)localObject2).getString("time", "0");
          HashMap localHashMap;
          if ((!((String)localObject1).equals(" ")) && (!str.equals("0")))
          {
            localHashMap = new HashMap();
            localHashMap.put("uin", localObject1);
            localHashMap.put("time", str);
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReport", false, 0L, 0L, localHashMap, "");
            localObject2 = ((SharedPreferences)localObject2).edit();
            ((SharedPreferences.Editor)localObject2).clear();
            ((SharedPreferences.Editor)localObject2).commit();
          }
          localObject2 = BaseApplication.getContext().getSharedPreferences("pull_msf_succ", 0);
          ((SharedPreferences)localObject2).getString("uin", " ");
          ((SharedPreferences)localObject2).getString("time", "0");
          if ((!((String)localObject1).equals(" ")) && (!str.equals("0")))
          {
            localHashMap = new HashMap();
            localHashMap.put("uin", localObject1);
            localHashMap.put("time", str);
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(a(), "pullMsfReport_succ", false, 0L, 0L, localHashMap, "");
            localObject1 = ((SharedPreferences)localObject2).edit();
            ((SharedPreferences.Editor)localObject1).clear();
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d(jdField_b_of_type_JavaLangString, 1, "Failed to report pull Msf Event");
      }
    }
  }
  
  public void d(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.group.vibrate", Integer.valueOf(paramInt));
    }
  }
  
  public void d(ResourcePluginListener paramResourcePluginListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigAboutConfig.b(paramResourcePluginListener);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    FriendListHandler localFriendListHandler;
    do
    {
      return;
      localFriendListHandler = (FriendListHandler)a(1);
    } while (localFriendListHandler == null);
    if (paramString.startsWith("+"))
    {
      localFriendListHandler.e(paramString);
      return;
    }
    localFriendListHandler.c(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).d(paramBoolean1);
      return;
    }
    a().edit().putBoolean(a().getString(2131369538) + a(), paramBoolean1).commit();
  }
  
  public boolean d()
  {
    if (!this.l) {
      return false;
    }
    Object localObject = ((ActivityManager)a().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.minihd.qq:video")) {
          return true;
        }
      }
    }
    this.l = false;
    return false;
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(a(), 1);
    }
    return a().getBoolean(a().getString(2131369862) + a(), false);
  }
  
  public int e()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("message.vibrate.switch", 1);
    }
    return 1;
  }
  
  public String e()
  {
    String str = d();
    if (str != null) {
      try
      {
        str = HexUtil.a(str.getBytes("utf-8"));
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return null;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnOpenAndStartGetMsg");
    }
    LoadingStateManager.a().a(1);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void e(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.ring.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void e(boolean paramBoolean)
  {
    a().edit().putBoolean(a().getString(2131366271) + a(), paramBoolean).commit();
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.ce = 1;
    }
    for (;;)
    {
      ((CardHandler)a(2)).a(paramBoolean1, paramBoolean2);
      return;
      this.cf = 1;
    }
  }
  
  public boolean e()
  {
    return (getAccount() != null) && (isLogin());
  }
  
  public boolean e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((FriendListHandler)a(1)).a(a(), 2);
    }
    return a().getBoolean(a().getString(2131369863) + a(), false);
  }
  
  public int f()
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      return localRoamSettingController.b("sync.c2c_message", 1);
    }
    return 1;
  }
  
  public void f()
  {
    BaseApplicationImpl.jdField_a_of_type_AndroidOsHandler.post(new hnm(this));
  }
  
  public void f(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("message.vibrate.switch", Integer.valueOf(paramInt));
    }
  }
  
  public void f(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putBoolean(BaseApplication.getContext().getString(2131366229) + a(), paramBoolean);
    localEditor.commit();
  }
  
  public void f(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, a(), 1);
      return;
    }
    a().edit().putBoolean(a().getString(2131369862) + a(), paramBoolean1).commit();
  }
  
  public boolean f()
  {
    return SettingCloneUtil.readValue(a(), a(), a().getString(2131366821), "qqsetting_notify_showcontent_key", true);
  }
  
  public boolean f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() isFromPush=" + paramBoolean);
    }
    Object localObject1 = null;
    Object localObject2 = (SubAccountManager)getManager(59);
    if (localObject2 != null) {
      localObject1 = ((SubAccountManager)localObject2).a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((String)localObject2).length() > 4))
        {
          bool1 = true;
          SubAccountControll.a(this, (String)localObject2, paramBoolean);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() continue, subUin=" + (String)localObject2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() listSubUin==null");
    }
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "startAllSubMessageAccountMsg() result=" + bool2 + " forground=" + BaseActivity.mAppForground);
    }
    localObject1 = (SubAccountControll)getManager(60);
    if (localObject1 != null)
    {
      if (!bool2) {
        break label258;
      }
      if (BaseActivity.mAppForground) {
        ((SubAccountControll)localObject1).c(this);
      }
    }
    return bool2;
    label258:
    ((SubAccountControll)localObject1).d(this);
    return bool2;
  }
  
  protected void finalize()
  {
    super.finalize();
    EntityManagerFactory localEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    if (localEntityManagerFactory != null) {
      localEntityManagerFactory.close();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnClose");
    }
    this.jdField_f_of_type_Boolean = false;
    LoadingStateManager.a().a(1);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134014, null).sendToTarget();
    }
  }
  
  public void g(int paramInt)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a("sync.c2c_message", Integer.valueOf(paramInt));
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((FriendListHandler)a(1)).a(paramBoolean1, a(), 2);
      return;
    }
    a().edit().putBoolean(a().getString(2131369863) + a(), paramBoolean1).commit();
  }
  
  public boolean g()
  {
    if (A())
    {
      Object localObject = ThemeUtil.getUserCurrentThemeId(this);
      if ((localObject != null) && (!((String)localObject).equals("1000")))
      {
        localObject = ThemeUtil.getThemeInfo(getApplication(), (String)localObject);
        if ((localObject != null) && (((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager1 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
    if (localManager1 == null) {}
    for (;;)
    {
      Manager localManager2;
      synchronized (this.jdField_a_of_type_ArrayOfMqqManagerManager)
      {
        localManager2 = this.jdField_a_of_type_ArrayOfMqqManagerManager[paramInt];
        if ((localManager2 == null) && ((getAccount() != null) || (paramInt <= 7) || (paramInt == 26))) {
          break label1101;
        }
        return localManager2;
        if (localManager1 != null) {
          addManager(paramInt, localManager1);
        }
        return localManager1;
      }
      Object localObject2 = new ProxyIpManagerImpl(this);
      continue;
      localObject2 = new WtloginManagerImpl(this);
      continue;
      localObject2 = new TicketManagerImpl(this);
      continue;
      localObject2 = new AccountManagerImpl(this);
      continue;
      localObject2 = new FriendsManagerImp(this);
      continue;
      localObject2 = new TroopManager(this);
      continue;
      localObject2 = new TroopInfoManager(this);
      continue;
      localObject2 = new QZoneManagerImp(this);
      continue;
      localObject2 = new PhoneContactManagerImp(this);
      continue;
      localObject2 = new GameCenterManagerImp(this);
      continue;
      localObject2 = new WebProcessManager(this);
      continue;
      localObject2 = new EmoticonManagerImp(this);
      continue;
      localObject2 = new RoamSettingManager(this);
      continue;
      localObject2 = StatusManager.a(this);
      continue;
      localObject2 = new ShieldMsgManger(this);
      continue;
      localObject2 = new SttManager(this);
      continue;
      localObject2 = new ProxyManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = ((ProxyManager)localObject2);
      continue;
      localObject2 = new CacheManager(this);
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheManager = ((CacheManager)localObject2);
      continue;
      getManager(28);
      localObject2 = new QQMessageFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = ((QQMessageFacade)localObject2);
      continue;
      localObject2 = new ConversationFacade(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = ((ConversationFacade)localObject2);
      continue;
      localObject2 = new RecommendTroopManagerImp(this);
      continue;
      localObject2 = new NetEngineFactory();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)localObject2);
      continue;
      localObject2 = new FileTransferManager(this);
      continue;
      localObject2 = new MediaPlayerManager(this);
      continue;
      localObject2 = IPluginManager.a(this);
      continue;
      localObject2 = new SubAccountProtocManager(this);
      continue;
      localObject2 = new RoamSettingController(this);
      continue;
      localObject2 = new DiscussionMemberManager(this);
      continue;
      localObject2 = new NewFriendManager(this);
      continue;
      localObject2 = new CircleManager(this);
      continue;
      localObject2 = new TroopCreateLogic(this);
      continue;
      localObject2 = new RecentManagerFor3rdPart(this);
      continue;
      localObject2 = new RedTouchManager(this);
      continue;
      localObject2 = new QCallFacade(this);
      continue;
      localObject2 = new ContactSyncManager(this);
      continue;
      localObject2 = new PicPreDownloader(this);
      continue;
      localObject2 = new FontManager(this);
      continue;
      localObject2 = new BubbleManager(this);
      continue;
      localObject2 = new ColorRingManager(this);
      continue;
      localObject2 = new AvatarPendantManager(this);
      continue;
      localObject2 = new SignatureManager(this);
      continue;
      localObject2 = new EmojiManager(this);
      continue;
      localObject2 = new DownloaderFactory(this);
      continue;
      localObject2 = new TroopGagMgr(this);
      continue;
      localObject2 = new FriendsManager(this);
      continue;
      localObject2 = new DiscussionManager(this);
      continue;
      localObject2 = new ContactFacade(this);
      continue;
      localObject2 = new SearchHistoryManager(this);
      continue;
      localObject2 = new PublicAccountDataManager(this);
      continue;
      localObject2 = new MyBusinessManager(this);
      continue;
      localObject2 = new ConditionSearchManager(this);
      continue;
      localObject2 = new HotChatManager(this);
      continue;
      localObject2 = new ShortVideoTransManager(this);
      continue;
      localObject2 = new ChatBackgroundManager(this);
      continue;
      localObject2 = new SecMsgManager(this);
      continue;
      localObject2 = new LbsInfoMgr(this);
      continue;
      localObject2 = new SubAccountManager(this);
      continue;
      localObject2 = new SubAccountControll(this);
      continue;
      localObject2 = new DatingManager(this);
      continue;
      localObject2 = new QQLSRecentManager(this);
      continue;
      localObject2 = new DeviceProfileManager.AccountDpcManager(this);
      continue;
      localObject2 = new EqqDetailDataManager(this);
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.d("QZonePreDownload", 4, "initialize QZonePreDownloadManagerImp");
      }
      localObject2 = new QZonePreDownloadManagerImp(this);
      continue;
      localObject2 = new TroopTipsMsgMgr(this);
      continue;
      localObject2 = new TroopRedTouchManager(this);
      continue;
      localObject2 = new VipGiftManager(this);
      continue;
      localObject2 = new PicStatisticsManager(this);
      continue;
      localObject2 = new NearbyBannerManager(this);
      continue;
      localObject2 = new EarlyDownloadManager(this);
      continue;
      localObject2 = new AddContactTroopManage(this);
      continue;
      localObject2 = new PortalManager(this);
      continue;
      localObject2 = new LifeOnlineAccountInfoManager(this);
      continue;
      localObject2 = new WordMatchManager(this);
      continue;
      localObject2 = new PngFrameManager(this);
      continue;
      localObject2 = new VipFunCallManager(this);
      continue;
      localObject2 = new LightalkSwitchManager(this);
      continue;
      localObject2 = new ActivateFriendsManager(this);
      continue;
      localObject2 = new VipImageUploadManager(this);
      continue;
      localObject2 = new QzoneContactsFeedManager(this);
      continue;
      localObject2 = new EcShopAssistantManager(this);
      continue;
      localObject2 = new MessageRoamManager(this);
      continue;
      localObject2 = new QavStateManager(this);
      continue;
      return localObject2;
      label1101:
      localObject2 = localManager2;
      switch (paramInt)
      {
      }
      localObject2 = localManager2;
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush", "MessageSvc.PushGroupMsg", "MessageSvc.PushForceOffline", "MessageSvc.PushNotify", "MessageSvc.PushForceOffline", "MessageSvc.RequestPushStatus", "RegPrxySvc.PullDisGroupSeq", "MessageSvc.RequestBatchPushFStatus", "MessageSvc.PushFStatus", "AccostSvc.SvrMsg", "ADMsgSvc.PushMsg", "StreamSvr.PushStreamMsg", "friendlist.getOnlineFriend", "MessageSvc.WNSQzone", "RegPrxySvc.PbGetMsg", "RegPrxySvc.getOffMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.NoticeEnd", "account.ResponseNotifyForRecommendUpdate", "MessageSvc.PushReaded", "RegPrxySvc.infoLogin", "baseSdk.Msf.NotifyResp", "RegPrxySvc.PushParam", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "cmd_connAllFailed", "cmd_recvFirstResp", "MultiVideo.s2c", "MultiVideo.c2sack", "NearFieldTranFileSvr.NotifyList", "ProfileService.CheckUpdateReq", "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { TempServlet.class, CliNotifyPush.class, ContactBindServlet.class };
  }
  
  public Class getPluginClassLoader(String paramString)
  {
    if (paramString.contains("com.qzone")) {
      try
      {
        Class localClass = a(paramString);
        return localClass;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return super.getPluginClassLoader(paramString);
  }
  
  public ServletContainer getServletContainer(Class paramClass)
  {
    if (paramClass == null) {
      return super.getServletContainer(paramClass);
    }
    Object localObject = paramClass.getName();
    QLog.i("QZLog", 1, "---getServletContainer className: " + (String)localObject);
    if (((String)localObject).contains("com.qzone")) {
      try
      {
        localObject = a(paramClass);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return super.getServletContainer(paramClass);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onRecvFistResp");
    }
    this.jdField_f_of_type_Boolean = true;
    Handler localHandler = a(Conversation.class);
    if (!LoadingStateManager.a().d())
    {
      LoadingStateManager.a().a(2);
      if (localHandler != null) {
        localHandler.obtainMessage(1134012, null).sendToTarget();
      }
    }
    for (;;)
    {
      if (localHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.arg1 = 0;
        localMessage.what = 1134024;
        localHandler.sendMessage(localMessage);
      }
      return;
      if ((LoadingStateManager.a().b()) && (localHandler != null)) {
        localHandler.obtainMessage(1134015, null).sendToTarget();
      }
    }
  }
  
  public void h(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    if (localAudioManager != null) {}
    for (;;)
    {
      try
      {
        i1 = localAudioManager.getRingerMode();
        if (i1 == 0) {
          return true;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        i1 = 2;
        continue;
      }
      return false;
      int i1 = 2;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onConnAllFailed");
    }
    LoadingStateManager.a().a(4);
    Handler localHandler = a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134013, null).sendToTarget();
    }
  }
  
  public void i(boolean paramBoolean1, boolean paramBoolean2)
  {
    RoamSettingController localRoamSettingController = (RoamSettingController)getManager(30);
    if (localRoamSettingController != null) {
      localRoamSettingController.b(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean i()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 2);
  }
  
  public void init(MobileQQ paramMobileQQ, MainService paramMainService, SimpleAccount paramSimpleAccount)
  {
    super.init(paramMobileQQ, paramMainService, paramSimpleAccount);
    try
    {
      a(paramMobileQQ, paramMainService, paramSimpleAccount);
      return;
    }
    catch (Exception paramMobileQQ)
    {
      paramMobileQQ.printStackTrace();
    }
  }
  
  public void j()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      localNotificationManager.cancel(122);
      localNotificationManager.cancel(123);
      localNotificationManager.cancel(129);
      localNotificationManager.cancel(135);
      localNotificationManager.cancel(140);
      label58:
      a(new ToServiceMsg("mobileqq.service", a(), "CMD_STOP_NOTIFIYCATION"));
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public boolean j()
  {
    String str = Build.MANUFACTURER + Build.MODEL;
    if ((!TextUtils.isEmpty(str)) && (str.toLowerCase().contains("xiaomi"))) {
      if (Settings.System.getInt(a().getContentResolver(), "vibrate_in_normal", -1) != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (Build.VERSION.SDK_INT >= 11) {
            break;
          }
        } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) > 4);
        return false;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (Settings.System.getInt(a().getContentResolver(), "vibrate_on", -1) == 5);
      return false;
    } while (Settings.System.getInt(a().getContentResolver(), "vibrate_when_ringing", -1) == 1);
    return false;
  }
  
  public void k()
  {
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("notification");
      localNotificationManager.cancel(121);
      localNotificationManager.cancel(119);
      label25:
      b(a());
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public boolean k()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getRingerMode() == 1);
  }
  
  public void l()
  {
    AppRuntime.Status localStatus;
    if (isLogin()) {
      switch ((int)a())
      {
      default: 
        localStatus = AppRuntime.Status.offline;
      }
    }
    for (;;)
    {
      ((PushManager)getManager(5)).registProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video", "com.tencent.av.ui.VChatActivity", new String[] { "SharpSvr.c2sack", "SharpSvr.s2c" });
      QLog.d(jdField_b_of_type_JavaLangString, 1, "sendRegisterPush video push register end.");
      getManager(87);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC get value in sendRegisterPush........... kickpc = " + c());
      }
      sendOnlineStatus(localStatus, c(), a().getSharedPreferences(getAccount(), 0).getInt("GetFrdListReq_seq", 0));
      return;
      localStatus = AppRuntime.Status.online;
      continue;
      localStatus = AppRuntime.Status.away;
      continue;
      localStatus = AppRuntime.Status.invisiable;
    }
  }
  
  public boolean l()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public void logout(boolean paramBoolean)
  {
    if (paramBoolean) {
      O();
    }
    ((PushManager)getManager(5)).unregistProxyMessagePush(a(), this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName() + ":video");
    LoadingStateManager.a().a();
    N();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "kickPC in app  do logout");
    }
    String str = a();
    if (str != null) {
      SdkContext.cleanCokiee(a(), Long.parseLong(str));
    }
    super.logout(paramBoolean);
  }
  
  public void m() {}
  
  public boolean m()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)a().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper = new LebaHelper(this);
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.a();
    }
  }
  
  public final boolean n()
  {
    return a().getBoolean(a().getString(2131366271) + a(), false);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppLebaHelper.c();
    }
  }
  
  public boolean o()
  {
    return a().getBoolean(a().getString(2131366272) + a(), false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqStatisticsReportController = ReportControllerImpl.a(this);
    startServlet(new NewIntent(getApplication(), PushServlet.class));
    this.jdField_a_of_type_ComTencentMobileqqServiceMobileQQService = new MobileQQService(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController = new FloatAioController(this);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator = new Automator(this);
    if (e())
    {
      QCallFacade.a(this, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = a().createEntityManager();
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(StepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, "{{4,3,5,6},[11,12,14],17,20,21,54,55,22,40,41,[60,25,10,26,27,28,29,30,31,33,34,36,37,38,39,43,44,45,50,64,65,66,46,48,49,57,59,69,62],52,70}"));
      }
      if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
        ThemeUtil.initTheme(this);
      }
    }
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.qzone.cleanunreadcount");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    localIntentFilter = new IntentFilter("QZonePreDownload");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    P();
    if (StartService.StartServiceState.jdField_a_of_type_Boolean) {
      ProfileCardUtil.a();
    }
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
    this.jdField_e_of_type_Boolean = true;
    a().a();
    a().d();
    PluginManageHandler.getInstance().setPluginManagerProvider(this, false);
    try
    {
      a(paramBundle);
      paramBundle = a();
      if (!TextUtils.isEmpty(paramBundle)) {
        ThreadManager.b(new hnl(this, paramBundle));
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.jdField_b_of_type_Long = 0L;
    BaseApplicationImpl.jdField_a_of_type_Long = 0L;
    BaseApplicationImpl.c = 0L;
    N();
    ThemeUiPlugin.destroy(this);
    ChatBackgroundManager.a();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(a()).edit();
    localEditor.putString("LastScreenShotUri", "");
    localEditor.commit();
    localEditor = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
    localEditor.putString("no_auto_reply" + getAccount(), "");
    localEditor.commit();
    j();
    o();
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Unregist Cloud Scan Listener");
    }
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_c_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      try
      {
        label162:
        this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_d_of_type_AndroidContentBroadcastReceiver);
        label173:
        UniformDownloadMgr.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
          a().b();
        }
        Config.b();
        AppLaucherHelper.a();
        TroopFileUploadingManager.a(this);
        QWalletHelper.a(this);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter.e();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine != null) {
          this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine.closeEngine();
        }
        if (!TextUtils.isEmpty(a())) {
          QQOperateManager.a(this).a();
        }
        a().e();
        a().e();
        try
        {
          K();
          this.jdField_a_of_type_JavaLangObject = null;
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
      }
      catch (Exception localException2)
      {
        break label173;
      }
    }
    catch (Exception localException3)
    {
      break label162;
    }
  }
  
  public RemotePluginManager.Stub onGetPluginManager()
  {
    return (PluginManagerV2)getManager(26);
  }
  
  public void onProxyIpChanged()
  {
    Object localObject = BaseApplication.getContext();
    String str = a();
    localObject = ConfigManager.getInstance((Context)localObject, this, a(), str);
    if (localObject != null) {
      ((ConfigManager)localObject).onProxyIpChanged(this);
    }
  }
  
  public void onRunningBackground(Bundle paramBundle)
  {
    super.onRunningBackground(paramBundle);
    QQHDStatisticReportHelper.b(this);
    QQMessageFacade localQQMessageFacade = a();
    if (localQQMessageFacade != null)
    {
      QCallFacade localQCallFacade = a();
      int i1 = 0;
      if (localQCallFacade != null) {
        i1 = localQCallFacade.a();
      }
      int i2 = localQQMessageFacade.e();
      if (isLogin()) {
        BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i1 + i2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
      T();
    }
    try
    {
      b(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    QQHDStatisticReportHelper.a(this);
    ReportController.b(this, "CliOper", "", "", "0X8004014", "0X8004014", 0, 0, "", "", "", "");
    Object localObject = a();
    if ((localObject != null) && (((QQMessageFacade)localObject).e() > 1)) {
      ReportController.b(this, "CliOper", "", "", "0X8004015", "0X8004015", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioController.a();
    }
    ReportController.a(this, false);
    QlinkReliableReport.a();
    localObject = new Intent("com.tencent.intent.QZONE_PRE_DOWNLOAD_CANCEL");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator != null) && (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b())) {
      S();
    }
    localObject = (ActivateFriendsManager)getManager(80);
    if (localObject != null) {
      ((ActivateFriendsManager)localObject).a();
    }
    try
    {
      c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void p()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "trySoundAndVibrate is called,needSoundAndVibrations is:" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = ((QQMessageFacade)localObject).a();
      } while (localObject == null);
      this.jdField_c_of_type_ArrayOfLong[0] = ((QQMessageFacade.Message)localObject).uniseq;
      this.jdField_c_of_type_ArrayOfLong[1] = 1L;
    } while (this.jdField_a_of_type_ArrayOfByte[0] != 1);
    if (this.jdField_a_of_type_ArrayOfByte[1] == 1) {}
    for (;;)
    {
      e((MessageRecord)localObject, bool);
      this.jdField_a_of_type_ArrayOfByte[0] = 0;
      return;
      bool = false;
    }
  }
  
  public boolean p()
  {
    return a().getBoolean(a().getString(2131366274) + a(), false);
  }
  
  public void q()
  {
    e(null, false);
  }
  
  public boolean q()
  {
    Object localObject = a();
    localObject = ((FriendsManager)getManager(49)).a((String)localObject);
    if (localObject == null) {
      return false;
    }
    if (((Card)localObject).isShowZan()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void r()
  {
    ((LBSHandler)a(3)).b();
  }
  
  public boolean r()
  {
    return a().getBoolean(a().getString(2131366275) + a(), false);
  }
  
  public void s()
  {
    ((CardHandler)a(2)).a();
  }
  
  public boolean s()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener != null) && (this.jdField_a_of_type_ComTencentMobileqqAppCheckPttListener.e());
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "CNR setAutoLogin autoLogin = " + paramBoolean);
    }
    String str = "";
    if (!a().equals("0")) {
      str = a();
    }
    SharedPreUtils.a(getApplication().getApplicationContext(), str, paramBoolean);
  }
  
  public void start(boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseApplicationImpl.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null)) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), new hnw(this, null));
    super.start(paramBoolean);
    try
    {
      g(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void t()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      a().a(AppConstants.ae, 0);
      a().a().f();
      return;
    }
  }
  
  public boolean t()
  {
    boolean bool2 = false;
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    boolean bool3 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, null, "security_scan_key", "qqsetting_security_scan_key", false);
    boolean bool4 = ((SharedPreferences)localObject).getBoolean("security_scan_last_result", false);
    long l1 = ((SharedPreferences)localObject).getLong("security_scan_last_time", 0L);
    localObject = new Date(l1);
    Date localDate = new Date();
    ((Date)localObject).setHours(0);
    ((Date)localObject).setMinutes(0);
    ((Date)localObject).setSeconds(0);
    boolean bool1 = bool2;
    if (bool3) {
      if ((l1 != 0L) && (localDate.getTime() - ((Date)localObject).getTime() <= 604800000L))
      {
        bool1 = bool2;
        if (!bool4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void u()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      a().a(AppConstants.ae, 0);
      return;
    }
  }
  
  public boolean u()
  {
    String str1 = a();
    String str2 = ContactUtils.g(this, str1);
    Object localObject;
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2)))
    {
      localObject = (FriendManager)getManager(8);
      if (localObject == null)
      {
        localObject = null;
        if ((localObject != null) && (((Friends)localObject).name != null)) {
          break label138;
        }
        localObject = (FriendListHandler)a(1);
        if (localObject == null) {
          break label138;
        }
        ((FriendListHandler)localObject).b(str1);
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 4, "checkAndGetSelfNickName, [" + str2 + "," + bool + "]");
      }
      return bool;
      localObject = ((FriendManager)localObject).c(str1);
      break;
    }
  }
  
  protected void userLogoutReleaseData()
  {
    O();
    TroopFileManager.a();
    UpgradeController.a().a(true);
    SystemMsgController.a().c();
    FriendSystemMsgController.a().c();
    GroupSystemMsgController.a().c();
    MsgAutoMonitorUtil.a().a();
    ChatActivityUtils.b();
    BadgeUtils.a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, 0);
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a();
    }
  }
  
  public void v()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      a().a(AppConstants.ak, 0);
      a().a().f();
      return;
    }
  }
  
  public boolean v()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(BaseApplication.getContext().getString(2131366229) + a(), true);
  }
  
  public void w()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      a().a(AppConstants.ak, 0);
      return;
    }
  }
  
  public void x()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsg");
      }
      a().a(AppConstants.aj, 0);
      a().a().d();
      return;
    }
  }
  
  public void y()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("systemmsg", 2, "clearFriendSystemMsgHistory");
      }
      a().a(AppConstants.aj, 0);
      return;
    }
  }
  
  public void z()
  {
    ISecureModuleService localISecureModuleService = a();
    if (localISecureModuleService.register(new ProductInfo(6, g(), Integer.parseInt("3468"), 201, null, getAccount())) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("security_scan", 2, "Start Security Scan");
      }
      if (this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener == null) {
        this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener = new hnf(this);
      }
      localISecureModuleService.registerCloudScanListener(a(), this.jdField_a_of_type_ComTencentSecuremoduleServiceCloudScanListener);
      localISecureModuleService.cloudScan();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("security_scan", 2, "regist security service error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface
 * JD-Core Version:    0.7.0.1
 */