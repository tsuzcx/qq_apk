package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class ProfileActivity
  extends BaseActivity
  implements AppConstants
{
  public static final int A = 2;
  protected static final String A = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
  public static final int B = 3;
  protected static final String B = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
  public static final int C = 4;
  protected static final String C = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
  public static final int D = 5;
  protected static final String D = "https://sqq.3g.qq.com/html5/andr_mq2/index.jsp&sid=%s&g_f=20184&rm=6005";
  public static final int E = 19;
  protected static final String E = "https://sqq.3g.qq.com/html5/andr_mq/index.jsp?qq=%s&sid=%s&from=android&g_f=20183&rm=6005";
  public static final int F = 20;
  public static final String F = "com.tencent.mobileqq.action.template_setup";
  public static final int G = 21;
  public static final String G = "AllInOne";
  public static final int H = 22;
  public static final String H = "source_to_profile";
  public static final int I = 25;
  public static final int J = 26;
  public static final int K = 27;
  public static final int L = 30;
  public static final int M = 31;
  public static final int N = 32;
  public static final int O = 33;
  public static final int P = 34;
  public static final int Q = 35;
  public static final int R = 36;
  public static final int S = 37;
  public static final int T = 40;
  public static final int U = 41;
  public static final int V = 42;
  public static final int W = 45;
  public static final int X = 46;
  public static final int Y = 47;
  public static final int Z = 50;
  private static final int a = 22578;
  public static final int[][] a = { { 2130842027, 2131427438 }, { 2130842030, 2131427439 }, { 2130842033, 2131427440 } };
  public static final int aA = 4;
  public static final int aB = 1;
  public static final int aC = 57;
  public static final int aD = 59;
  public static final int aE = 60;
  public static final int aF = 61;
  public static final int aG = 64;
  public static final int aH = 65;
  public static final int aI = 66;
  public static final int aJ = 67;
  public static final int aK = 68;
  public static final int aL = 84;
  public static final int aM = 87;
  public static final int aN = 88;
  public static final int aO = 4;
  public static final int aP = 5;
  public static final int aQ = 6;
  public static final int aR = 7;
  public static final int aS = 8;
  public static final int aT = 9;
  public static final int aU = 10;
  public static final int aV = 11;
  public static final int aW = 12;
  public static final int aX = 13;
  public static final int aY = 14;
  public static final int aZ = 15;
  public static final int aa = 51;
  public static final int ab = 52;
  public static final int ac = 55;
  public static final int ad = 56;
  public static final int ae = 57;
  public static final int af = 58;
  public static final int ag = 60;
  public static final int ah = 61;
  public static final int ai = 70;
  public static final int aj = 71;
  public static final int ak = 72;
  public static final int al = 73;
  public static final int am = 74;
  public static final int an = 75;
  public static final int ao = 75;
  public static final int ap = 76;
  public static final int aq = 77;
  public static final int ar = 7;
  public static final int as = 800;
  public static final int at = 803;
  public static final int au = 804;
  public static final int av = 880;
  public static final int aw = 881;
  public static final int ax = 1;
  public static final int ay = 2;
  public static final int az = 3;
  public static final int ba = 16;
  public static final int bb = 17;
  public static final int bc = 18;
  public static final int bd = 19;
  public static final int be = 30;
  public static final int bf = 999;
  public static final int bg = 1;
  public static final int bh = 2;
  public static final int bi = 3;
  public static final int bj = 4;
  public static final int bk = 5;
  public static final int bl = 6;
  public static final int bm = 100;
  public static final int bn = 101;
  public static final int bo = 102;
  public static final int bp = 103;
  protected static final String d = "https://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=tmsglist";
  protected static final String e = "https://m.3g.qq.com/forward.html?sid=%s&fr=1&tuin=%s&page=account";
  protected static final String f = "https://fwd.z.qq.com:8080/forward.jsp?bid=255&g_f=5471&3g_sid=%s";
  public static final String g = "https://ti.qq.com/qcard/index.html?sid=%s&qq=%s&appid=%s&version=%s&main_qq=%s&_wv=1027";
  public static final String h = "https://activeqq.3g.qq.com/activeQQ/mqq/modify_qqinfo_wap2.jsp?sid=%s&qq=%s&appid=%s&version=%s&g_f=10160";
  public static final String i = "https://fwd.3g.qq.com:8080/forward.jsp?bid=590&sid=%s";
  public static final int j = 1000;
  public static final String j = "https://xiangji.qq.com/downloading.php?chid=0041&sid=%s";
  public static final int k = 1001;
  protected static final String k = "https://m.qzone.com/l?sid=%s&g_f=22578&g=41&B_UID=%s";
  public static final int l = 1002;
  protected static final String l = "https://m.qzone.com/l?g=119&sid=%s&res_uin=%s&g_f=2000000082";
  public static final int m = 1003;
  protected static final String m = "https://mapp.3g.qq.com/touch/album/index.jsp";
  public static final int n = 1004;
  protected static final String n = "https://mapp.3g.qq.com/touch/album/index.jsp?B_UID=%s&sid=%s";
  public static final int o = 1005;
  protected static final String o = "https://sqq.3g.qq.com/html5/andr_mq/index.jsp?sid=%s&from=android&qq=%s&g_f=20183&rm=6005";
  public static final int p = 1006;
  protected static final String p = "https://m.vip.qq.com/redirect/index.php?go=androidzhanghao&sid=%s&qq=%s&aid=%s&_wv=5123";
  public static final int q = 1007;
  protected static final String q = "https://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromziliaoka";
  public static final int r = 1008;
  protected static final String r = "https://m.vip.qq.com/redirect/?go=androidqlevel&qq=%s&sid=%s&aid=mvip.pingtai.mobileqq.androidziliaoka.fromkerentaiQQlevelicon";
  public static final int s = 1009;
  protected static final String s = "https://ti.qq.com/xman/self.html?_wv=1027&adtag=setting&_bid=297";
  public static final int t = 1010;
  public static final String t = "https://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297";
  public static final int u = 1011;
  protected static final String u = "https://ti.qq.com/xman/view.html?_wv=1027&uin=%s&_bid=297";
  public static final int v = 1012;
  protected static final String v = "https://ptlogin2.qq.com/mlevel?clientuin=%s&clientkey=%s&keyindex=%s&sid=%s&ADTAG=LEVEL.MLEVEL.master_page.fromshezhi";
  public static final int w = 1013;
  public static final String w = "https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017";
  public static final int x = 1014;
  public static final String x = "https://ti.qq.com/lightalk/info.html?_wv=1027&uin=%s&nick=%s";
  public static final int y = 0;
  protected static final String y = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
  public static final int z = 1;
  protected static final String z = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 57) {
      return 57;
    }
    if (paramInt == 59) {
      return 59;
    }
    if (paramInt == 60) {
      return 60;
    }
    if (paramInt == 61) {
      return 61;
    }
    if (paramInt == 64) {
      return 64;
    }
    if (paramInt == 65) {
      return 65;
    }
    if (paramInt == 66) {
      return 66;
    }
    if (paramInt == 67) {
      return 67;
    }
    if (paramInt == 68) {
      return 68;
    }
    if (paramInt == 84) {
      return 84;
    }
    if (paramInt == 87) {
      return 87;
    }
    if (paramInt == 88) {
      return 88;
    }
    return 999;
  }
  
  public static int a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 0) {
      return 2;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {
      return 0;
    }
    return 1;
  }
  
  public static long a(ProfileActivity.AllInOne paramAllInOne)
  {
    long l1 = 0L;
    if (ProfileActivity.AllInOne.a(paramAllInOne)) {
      l1 = 0L | 1L;
    }
    long l2 = l1 | 0x4;
    l1 = l2;
    if (ProfileActivity.AllInOne.f(paramAllInOne)) {
      l1 = l2 | 0x8;
    }
    return l1 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800;
  }
  
  public static Intent a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramAllInOne != null) && (BmqqSegmentUtil.a(paramContext, paramAllInOne.jdField_a_of_type_JavaLangString))) {
      return new Intent(paramContext, BmqqProfileCardActivity.class);
    }
    if (((paramContext instanceof BaseActivity)) && (CrmUtils.c(((BaseActivity)paramContext).app, paramAllInOne.jdField_a_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent(paramContext, EnterpriseDetailActivity.class);
      localIntent.putExtra("uin", paramAllInOne.jdField_a_of_type_JavaLangString);
      if ((paramContext instanceof ChatActivity))
      {
        localIntent.putExtra("need_finish", true);
        return localIntent;
      }
      localIntent.putExtra("need_finish", false);
      return localIntent;
    }
    return new Intent(paramContext, FriendProfileCardActivity.class);
  }
  
  public static Uri a(Activity paramActivity, int paramInt)
  {
    Object localObject1 = new File(AppConstants.aG + "photo/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = AppConstants.aG + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    BaseActivity.sNotShowLockScreen = true;
    try
    {
      paramActivity.startActivityForResult((Intent)localObject1, paramInt);
      return localObject2;
    }
    catch (Exception paramActivity)
    {
      BaseActivity.sNotShowLockScreen = false;
    }
    return localObject2;
  }
  
  public static void a(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(paramInt);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1500L;
  }
  
  public static void b(Activity paramActivity, ProfileActivity.AllInOne paramAllInOne, int paramInt)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = a(paramActivity, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("open_fragment_no_anim_once", true);
      localIntent.putExtra("fouce_close", true);
      localIntent.addFlags(536870912);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
    }
  }
  
  public static void b(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.addFlags(536870912);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
  
  public static void c(Context paramContext, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = a(paramContext, paramAllInOne);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.addFlags(67108864);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileActivity
 * JD-Core Version:    0.7.0.1
 */