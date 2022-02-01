package com.tencent.mobileqq.utils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static final String A = "QQRt_ReportController";
  public static final String B = "QQRt_entityManagerFactory_create";
  public static final String C = "QQRt_entityManagerFactory_verify";
  public static final String D = "QQRt_entityManagerFactory_veri_1";
  public static final String E = "QQRt_entityManagerFactory_veri_2";
  public static final String F = "QQRt_entityManagerFactory_veri_3";
  public static final String G = "AIO_Start_cost";
  public static final String H = "AIO_Click_cost";
  public static final String I = "AIO_Super_doOnCreate";
  public static final String J = "AIO_Super_doOnNewIntent";
  public static final String K = "AIO_Super_doOnStart";
  public static final String L = "AIO_Super_doOnResume";
  public static final String M = "AIO_Super_doOnPause";
  public static final String N = "AIO_Super_doOnStop";
  public static final String O = "AIO_Super_doOnDestroy";
  public static final String P = "AIO_doOnCreate";
  public static final String Q = "AIO_doOnNewIntent";
  public static final String R = "AIO_doOnStart";
  public static final String S = "AIO_doOnResume";
  public static final String T = "AIO_doOnPause";
  public static final String U = "AIO_doOnStop";
  public static final String V = "AIO_doOnDestroy";
  public static final String W = "AIO_doOnCreate_initUI";
  public static final String X = "AIO_doOnCreate_initData";
  public static final String Y = "AIO_doOnCreate_handleRequest";
  public static final String Z = "AIO_doOnCreate_BeforeEnterCost";
  public static final String a = "AutoMonitor";
  private static ConcurrentHashMap a = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aA = "AIO_EmoticonPanel_EnterSecond";
  public static final String aB = "AIO_EmoticonPanel_EnterFirst";
  public static final String aC = "AIO_EmoticonPanel_PageScroll";
  public static final String aD = "AIO_EmoticonPanel_TabClick";
  public static final String aE = "AIO_emosmDetailActivity_onCreate";
  public static final String aF = "AIO_emosmDetailActivity_onResume";
  public static final String aG = "AIO_bubble_craete_bubble_info";
  public static final String aH = "Web_qqbrowser_dooncreate";
  public static final String aI = "Web_qqbrowser_doonresume";
  public static final String aJ = "Web_uiplugin_onActivityCreate";
  public static final String aK = "Web_uiplugin_step_";
  public static final String aL = "Recent_clk_enterchat";
  public static final String aM = "Recent_clk_enterchat_troop";
  public static final String aN = "Recent_clk_enterchat_cmr";
  public static final String aO = "Recent_clk_enterchat_pub";
  public static final String aP = "Main_ui_create_super_create";
  public static final String aQ = "Main_ui_create_set_content";
  public static final String aR = "Main_ui_create_tab0";
  public static final String aS = "Main_ui_create_tab123";
  public static final String aT = "Main_ui_create_base_create";
  public static final String aU = "Main_ui_create_base_init_calltab";
  public static final String aV = "Main_ui_create_register_observers";
  public static final String aW = "Main_ui_create_noti_manager";
  public static final String aX = "Recent_LoadData_query_recent_list";
  public static final String aY = "Recent_LoadData_getManagers";
  public static final String aZ = "Recent_LoadData_preloadData";
  public static final String aa = "AIO_doOnCreate_uiCost";
  public static final String ab = "AIO_doOnCreate_getPieCost";
  public static final String ac = "AIO_doOnCreate_otherCost";
  public static final String ad = "AIO_doOnResume_updateUI";
  public static final String ae = "AIO_doOnNewIntent_updateUI";
  public static final String af = "AIO_doOnNewIntent_updateData";
  public static final String ag = "AIO_onDrawView";
  public static final String ah = "AIO_onShow";
  public static final String ai = "AIO_onShow_updateUI";
  public static final String aj = "AIO_onShow_videoStatus";
  public static final String ak = "AIO_onShow_setReaded";
  public static final String al = "AIO_onShow_otherThings";
  public static final String am = "AIO_onShow_report";
  public static final String an = "AIO_onShow_emotion";
  public static final String ao = "AIO_onShow_business";
  public static final String ap = "AIO_updateSession";
  public static final String aq = "AIO_updateSession_initIntentData";
  public static final String ar = "AIO_updateSession_updateUI";
  public static final String as = "AIO_updateSession_business";
  public static final String at = "AIO_updateSession_forwardType";
  public static final String au = "AIO_updateSession_otherThings";
  public static final String av = "AIO_ChatAdapter_getView";
  public static final String aw = "AIO_onWindowFocusChanged";
  public static final String ax = "AIO_SysMsgCost";
  public static final String ay = "AIO_EmoticonPanel_OpenDuration";
  public static final String az = "AIO_EmoticonPanel_OnResume";
  public static final String b = "Main_Start";
  public static final String ba = "Recent_LoadData_convert";
  public static final String bb = "Recent_LoadData_conv_uin_record";
  public static final String bc = "Recent_LoadMoreData_getFaceDrawable";
  public static final String bd = "Recent_LoadData_build_item";
  public static final String be = "Recent_LoadData_update";
  private static final String bf = "STATE_";
  public static final String c = "Main_OnCreat";
  public static final String d = "Main_OnStart";
  public static final String e = "Main_OnPostCreat";
  public static final String f = "Main_OnResume";
  public static final String g = "Main_Resume_Sound";
  public static final String h = "Main_Resume_PCActive";
  public static final String i = "Recent_Start";
  public static final String j = "Recent_CreateView";
  public static final String k = "Recent_OnCreate";
  public static final String l = "Recent_OnResume";
  public static final String m = "Recent_OnLayout";
  public static final String n = "Recent_Draw";
  public static final String o = "QQRt_onCreate";
  public static final String p = "QQRt_superOnCreate";
  public static final String q = "QQRt_PushServlet";
  public static final String r = "QQRt_QQInitHandler";
  public static final String s = "QQRt_netHandler";
  public static final String t = "QQRt_MobileQQService";
  public static final String u = "QQRt_initTheme";
  public static final String v = "QQRt_initFaceIconCache";
  public static final String w = "QQRt_MemoryManager";
  public static final String x = "QQRt_startCoreService";
  public static final String y = "QQRt_videoMsgReceiver";
  public static final String z = "QQRt_initAvatarUploadState";
  
  public static final void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */