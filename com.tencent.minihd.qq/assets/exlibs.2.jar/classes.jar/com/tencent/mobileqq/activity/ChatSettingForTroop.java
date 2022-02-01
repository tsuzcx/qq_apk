package com.tencent.mobileqq.activity;

import KQQ.BatchResponse;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.NearbyTroopsLocationActivity;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallView;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.troop.TroopProxyActivity;
import dpq;
import dpr;
import dps;
import dpt;
import dpu;
import dpv;
import dpw;
import dpx;
import dpy;
import dpz;
import dqa;
import dqb;
import dqc;
import dqd;
import dqe;
import dqf;
import dqg;
import dqh;
import dqi;
import dqj;
import dql;
import dqm;
import dqn;
import dqo;
import dqp;
import dqq;
import dqr;
import dqs;
import dqt;
import dqu;
import dqv;
import dqx;
import dqy;
import dra;
import drc;
import drd;
import dre;
import drf;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import oicq.wlogin_sdk.tools.MD5;
import qz_groupphoto.GetLastPicRsp;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class ChatSettingForTroop
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int A = 13;
  public static final int B = 14;
  public static final int C = 15;
  public static final int D = 16;
  public static final int E = 17;
  public static final int F = 1;
  public static final int G = 2;
  protected static final int J = 0;
  protected static final int K = 1;
  protected static final int L = 2;
  protected static final int M = 3;
  protected static final int N = 4;
  protected static final int O = 5;
  protected static final int P = 6;
  protected static final int Q = 7;
  protected static final int R = 8;
  protected static final int S = 9;
  protected static final int T = 10;
  protected static final int U = 11;
  protected static final int V = 12;
  protected static final int W = 13;
  protected static final int X = 14;
  protected static final int Y = 15;
  protected static final int Z = 16;
  public static final int a = 1;
  public static final String a = "Q.chatopttroop";
  protected static final int aC = 1;
  protected static final int aD = 1;
  protected static final int aE = 2;
  protected static final int aF = 3;
  protected static final int aG = 4;
  protected static final int aH = 5;
  protected static final int aI = 6;
  protected static final int aJ = 7;
  protected static final int aK = 8;
  protected static final int aL = 9;
  protected static final int aM = 10;
  public static final int aN = 11;
  protected static final int aO = 12;
  protected static final int aP = 13;
  public static final int aQ = 14;
  public static final int aR = 15;
  protected static final int aS = 16;
  protected static final int aT = 17;
  protected static final int aU = 12;
  private static final int aW = 0;
  public static final int aa = 17;
  protected static final int ab = 18;
  protected static final int ac = 19;
  protected static final int ad = 20;
  protected static final int ae = 21;
  protected static final int af = 22;
  protected static final int ag = 23;
  protected static final int ah = 24;
  protected static final int ai = 25;
  protected static final int aj = 26;
  protected static final int ak = 27;
  protected static final int al = 26;
  protected static final int am = 27;
  protected static final int an = 28;
  protected static final int ao = 29;
  protected static final int ap = 30;
  protected static final int aq = 31;
  protected static final int ar = 32;
  protected static final int as = 33;
  protected static final int at = 1101111755;
  public static final int aw = 6;
  public static final int b = 1;
  public static final String b = "https://xiaoqu.qq.com/cgi-bin/bar/jump?action=qun&from=card&gid=%s";
  public static final int c = 2;
  public static final String c = "https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&groupuin=%1$s&sid=%2$s&entersource=%3$d";
  public static final int d = 3;
  public static final String d = "https://qqweb.qq.com/cgi-bin/qqactivity/get_activity_group_card_list";
  public static final int e = 4;
  public static final String e = "https://qqweb.qq.com/cgi-bin/qqactivity/unset_red_point";
  public static final int f = 5;
  public static final String f = "selection";
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 0;
  public static final int l = 1;
  private static final String l = "_troop_community.nb";
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 5;
  public static final int t = 6;
  public static final int u = 7;
  public static final int v = 8;
  public static final int w = 9;
  public static final int x = 10;
  public static final int y = 11;
  public static final int z = 12;
  protected final int H = 1;
  protected final int I = 4;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dqx(this);
  protected View a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  protected LinearLayout a;
  public TextView a;
  private TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new drd(this);
  private TroopCardAppInfoHelper jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new dqi(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dqf(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dqd(this);
  public TroopInfo a;
  public TroopFileObserver a;
  public HttpWebCgiAsyncTask.Callback a;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  public AvatarWallAdapter a;
  protected AvatarWallView a;
  public TroopInfoData a;
  private TroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility;
  private IconPopupWindow jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public XListView a;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public LinkedHashMap a;
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new dqn(this);
  protected boolean a;
  public View[] a;
  protected int aA = -1;
  protected int aB = 0;
  private int aV = 6;
  private final int aX = 103;
  public int au;
  public int av = 1;
  protected int ax;
  public int ay;
  public int az = -1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout.LayoutParams jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams;
  TroopObserver jdField_b_of_type_ComTencentMobileqqAppTroopObserver = new dqe(this);
  private IconPopupWindow jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  public List b;
  public boolean b;
  ImageView c;
  public List c;
  public boolean c;
  ImageView d;
  protected boolean d;
  ImageView e;
  protected boolean e;
  ImageView f;
  protected boolean f;
  protected String g;
  private boolean g;
  public final String h;
  private boolean h;
  protected String i;
  private boolean i = false;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean = false;
  private String k;
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangString = "https://app.qun.qq.com/mobileapp/index.html?_bid=136";
    this.jdField_h_of_type_JavaLangString = "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new dqc(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = new dqm(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new dra(this);
  }
  
  private void A()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
    if (localTroopHandler != null)
    {
      if (this.av != 1) {
        break label61;
      }
      localTroopHandler.a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB);
      return;
      label61:
      localTroopHandler.a(a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), false);
    }
  }
  
  private void B()
  {
    Intent localIntent = new Intent(this, ChatHistory.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    startActivityForResult(localIntent, 7);
  }
  
  private void C()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("bg_replace_entrance", 62);
    PhotoUtils.a(this, localIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
  }
  
  private void D()
  {
    ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getString(2131368190, new Object[] { str }));
      int i1 = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app);
      localActionSheet.b(getString(2131368191, new Object[] { StringUtil.a(BaseApplication.getContext(), i1) }));
      localActionSheet.a(getString(2131363786), false);
      localActionSheet.a(getString(2131363787), false);
      localActionSheet.a(getString(2131363788), false);
      localActionSheet.a(getString(2131363789), false);
      i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      }
      for (;;)
      {
        localActionSheet.a(new dpt(this, i1, localActionSheet));
        localActionSheet.show();
        return;
        localActionSheet.f(0);
        continue;
        localActionSheet.f(1);
        continue;
        localActionSheet.f(2);
        continue;
        localActionSheet.f(3);
      }
    }
  }
  
  private void E()
  {
    if ((this.av == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    boolean bool;
    QZoneHelper.UserInfo localUserInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i != 0)
    {
      bool = true;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = 0;
        DBUtils.a(this.app.a(), "troop_photo_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        }
      }
      localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
      localUserInfo.jdField_b_of_type_JavaLangString = this.app.c();
      localUserInfo.jdField_c_of_type_JavaLangString = this.app.getSid();
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)) {
        localTroopHandler.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_Int <= 0) {
        break label224;
      }
      QZoneHelper.a(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool, 9);
    }
    for (;;)
    {
      a("Grp_Admin_data", "Clk_album", "");
      BnrReport.a(this.app, 66);
      return;
      bool = false;
      break;
      label224:
      QZoneHelper.b(this, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, bool, 9);
    }
  }
  
  private void F()
  {
    boolean bool = ((TroopManager)this.app.getManager(50)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    Switch localSwitch;
    if (localObject != null)
    {
      localSwitch = ((FormSwitchItem)localObject).a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      if (bool != true) {
        break label77;
      }
    }
    label77:
    for (localObject = getString(2131363974);; localObject = getString(2131363973))
    {
      localSwitch.setContentDescription((CharSequence)localObject);
      return;
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    startActivity(localIntent);
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a();
      if ((this.ax == 1) || (this.ax == 2)) {
        i1 = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_JavaLangString, setLastActivityName()));
        return;
      }
      startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.s, null, setLastActivityName()), 11);
      return;
    }
    b(2131366967, 1);
  }
  
  private void I()
  {
    if ((TroopInfoManager)this.app.getManager(36) != null)
    {
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[16].findViewById(2131297595);
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[3];
      if (localView != null)
      {
        localLinearLayout.removeView(localView);
        this.jdField_a_of_type_ArrayOfAndroidViewView[3] = null;
      }
    }
  }
  
  private View a()
  {
    return Utils.a(this);
  }
  
  private LinearLayout a()
  {
    return Utils.a(this);
  }
  
  private void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dpq(this, paramInt), 0L);
      return;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean1, int paramInt4, boolean paramBoolean2)
  {
    if (this.av == 2) {
      return;
    }
    Intent localIntent = new Intent(this, EditActivity.class);
    localIntent.putExtra("title", paramInt3);
    localIntent.putExtra("limit", paramInt2);
    localIntent.putExtra("current", paramString);
    localIntent.putExtra("canPostNull", paramBoolean1);
    localIntent.putExtra("multiLine", paramBoolean2);
    localIntent.putExtra("support_emotion", paramInt4);
    startActivityForResult(localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramActivity != null) {}
    try
    {
      Intent localIntent = new Intent(paramActivity, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt1);
      paramActivity.startActivityForResult(localIntent, paramInt2);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramActivity.toString());
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_title", paramActivity.getString(2131363742));
    if (!paramBoolean) {
      localIntent.putExtra("param_max", 10);
    }
    localIntent.putExtra("display_like_dialog", true);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, paramContext.toString());
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i2 = 0;
    if (paramIntent == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        boolean bool1 = paramIntent.getBooleanExtra("nickboolean", false);
        boolean bool2 = paramIntent.getBooleanExtra("sexboolean", false);
        boolean bool3 = paramIntent.getBooleanExtra("phoneboolean", false);
        boolean bool4 = paramIntent.getBooleanExtra("mailboolean", false);
        boolean bool5 = paramIntent.getBooleanExtra("remarkboolean", false);
        if (bool1) {
          i2 = 1;
        }
        int i1 = i2;
        if (bool2) {
          i1 = i2 | 0x2;
        }
        i2 = i1;
        if (bool3) {
          i2 = i1 | 0x4;
        }
        i1 = i2;
        if (bool4) {
          i1 = i2 | 0x8;
        }
        i2 = i1;
        if (bool5) {
          i2 = i1 | 0x10;
        }
      } while (i2 == 0);
      if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131367328, 1500);
        return;
      }
      this.au |= 0x1;
      localObject1 = paramIntent.getStringExtra("nick");
      localObject2 = paramIntent.getStringExtra("phone");
      byte b1 = paramIntent.getByteExtra("sex", (byte)-1);
      String str1 = paramIntent.getStringExtra("mail");
      String str2 = paramIntent.getStringExtra("remark");
      paramIntent = new TroopMemberCardInfo();
      paramIntent.email = str1;
      paramIntent.memberuin = this.app.a();
      paramIntent.memo = str2;
      paramIntent.name = ((String)localObject1);
      paramIntent.sex = b1;
      paramIntent.tel = ((String)localObject2);
      paramIntent.troopuin = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramIntent);
      paramIntent = new ArrayList();
      paramIntent.add(Integer.valueOf(i2));
      localObject2 = (TroopHandler)this.app.a(19);
    } while (localObject2 == null);
    ((TroopHandler)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (ArrayList)localObject1, paramIntent);
  }
  
  private void a(View paramView, List paramList)
  {
    if ((paramView == null) || (paramList == null)) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "updateTroopPhoto|urls: " + paramList);
      }
      localLinearLayout = (LinearLayout)paramView.findViewById(2131296744);
    } while ((localLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null));
    Object localObject1 = null;
    String str1 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    int i2 = paramList.size();
    int i1 = getResources().getDimensionPixelOffset(2131493164);
    int i3 = getResources().getDimensionPixelOffset(2131493165);
    int i4 = getResources().getDimensionPixelOffset(2131493168);
    i3 = (this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - i1 - i3 - 4 * i4 - Utils.a(this, 10.0F) * 2) / 4;
    i1 = 0;
    URLImageView localURLImageView;
    if (i1 < 4)
    {
      localURLImageView = (URLImageView)localLinearLayout.findViewById(2131300638 + i1);
      if (localURLImageView == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        String str2;
        if (i1 >= i2)
        {
          localURLImageView.setVisibility(4);
        }
        else
        {
          localObject2 = (String)paramList.get(i1);
          str2 = str1 + "_" + MD5.toMD5((String)localObject2);
          str2 = AppConstants.bV + str2;
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(getResources().getColor(2131427451));
          }
        }
        try
        {
          localObject2 = URLDrawable.getDrawable(new URL("troop_photo_qzone", (String)localObject2, str2), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
          localObject1 = localObject2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, localMalformedURLException.toString());
            }
            continue;
            if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
              localURLImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
            }
          }
        }
        if (localObject1 == null) {
          break label399;
        }
        localURLImageView.setImageDrawable(localObject1);
        Object localObject2 = localURLImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = i3;
        ((ViewGroup.LayoutParams)localObject2).width = i3;
        localURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localURLImageView.setVisibility(0);
      }
    }
    label399:
    if (i2 > 0) {}
    for (i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      if ((this.av != 2) || (i2 <= 0) || ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h()) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))) {
        break;
      }
      paramView.setVisibility(0);
      return;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, int paramInt, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    String str1 = paramBaseActivity.app.getAccount();
    String str2 = ((TicketManager)paramBaseActivity.app.getManager(2)).getSkey(str1);
    if (str2 != null)
    {
      localBundle = new Bundle();
      localBundle.putString("version", "5.9.3");
      localBundle.putString("platform", "android");
      localBundle.putString("mType", "qb_other");
      localBundle.putString("gc", paramString2);
      localBundle.putString("bkn", TroopNoticeJsHandler.a(str2));
      localBundle.putString("Cookie", "uin=o" + str1 + ";skey=" + str2);
      paramString2 = new HashMap();
      paramString2.put("BUNDLE", localBundle);
      paramString2.put("CONTEXT", paramBaseActivity.getApplicationContext());
      new HttpWebCgiAsyncTask2(paramString1, "", paramCallback, paramInt, null).a(paramString2);
    }
    while (!QLog.isColorLevel())
    {
      Bundle localBundle;
      return;
    }
    QLog.w("Q.chatopttroop", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  private void a(ArrayList paramArrayList)
  {
    View localView1 = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
    LinearLayout localLinearLayout = (LinearLayout)localView1.findViewById(2131297595);
    Object localObject1 = (TroopInfoManager)this.app.getManager(36);
    if ((localObject1 != null) && (paramArrayList.size() > 0))
    {
      Object localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131296551);
      int i2 = ((ImageView)localObject2).getHeight();
      int i1 = ((ImageView)localObject2).getWidth();
      if ((i2 == 0) && (i1 == 0))
      {
        i1 = ((TroopInfoManager)localObject1).a();
        i2 = ((TroopInfoManager)localObject1).b();
      }
      int i3;
      for (;;)
      {
        i3 = 0;
        for (;;)
        {
          if (i3 >= paramArrayList.size()) {
            break label540;
          }
          localObject2 = (TroopAppInfo)paramArrayList.get(i3);
          if (localObject2 != null) {
            break;
          }
          i3 += 1;
        }
        ((TroopInfoManager)localObject1).a(i1, i2);
      }
      if (i3 != 0) {
        localLinearLayout.addView(View.inflate(this, 2130903698, null), this.jdField_b_of_type_AndroidWidgetLinearLayout$LayoutParams);
      }
      View localView2 = View.inflate(this, 2130903696, null);
      localView2.setFocusable(true);
      localView2.setClickable(true);
      localObject1 = (TextView)localView2.findViewById(2131296582);
      ImageView localImageView = (ImageView)localView2.findViewById(2131296551);
      ((TextView)localObject1).setText(((TroopAppInfo)localObject2).appName);
      localObject1 = localImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = i2;
      ((ViewGroup.LayoutParams)localObject1).width = i1;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = ((TroopAppInfo)localObject2).appIcon + "_48.png";
      if (7L == ((TroopAppInfo)localObject2).appId)
      {
        Drawable localDrawable = getResources().getDrawable(2130839488);
        localObject1 = URLDrawable.getDrawable((String)localObject1, localDrawable, localDrawable);
        label311:
        ((URLDrawable)localObject1).setURLDrawableListener(new dqu(this, localImageView, (URLDrawable)localObject1));
        localImageView.setImageDrawable((Drawable)localObject1);
        localView2.setTag(Long.valueOf(((TroopAppInfo)localObject2).appId));
        localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localLinearLayout.addView(localView2, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
        if (DBUtils.a(this.app.a(), ((TroopAppInfo)localObject2).appId + "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString) <= 0) {
          break label534;
        }
      }
      label534:
      for (boolean bool = true;; bool = false)
      {
        a(localView2, 0, bool);
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(((TroopAppInfo)localObject2).appId), localView2);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Exp_data_appEntry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "" + ((TroopAppInfo)localObject2).appId);
        }
        localView2.setContentDescription(((TroopAppInfo)localObject2).appName);
        break;
        localObject1 = URLDrawable.getDrawable((String)localObject1, null);
        break label311;
      }
      label540:
      if (paramArrayList.size() >= 2) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dqv(this, localView1), 500L);
      }
      localView1.setContentDescription(getString(2131363841));
    }
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131366343);
      return;
    case 2: 
    case 4: 
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131366344);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_JavaLangString = getString(2131366345);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367622, new dqr(this));
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131363517, new dqs(this));
    }
    if (this.av == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131367052, new dqt(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 1);
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TroopInfoManager localTroopInfoManager = (TroopInfoManager)this.app.getManager(36);
      this.jdField_b_of_type_JavaUtilArrayList = localTroopInfoManager.a(localTroopInfoManager.a(paramString));
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        this.i = true;
      }
    }
    else
    {
      return;
    }
    this.i = false;
  }
  
  private void b(List paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(Long.valueOf(1L));
    ((List)localObject).add(Long.valueOf(2L));
    ((List)localObject).add(Long.valueOf(1101484419L));
    paramList = (TroopHandler)this.app.a(19);
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
      paramList.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (List)localObject);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = new Intent(getActivity(), TroopDisbandActivity.class);
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
      ((Intent)localObject1).putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("leftViewText", 2131367789);
      startActivityForResult((Intent)localObject1, 6);
      localObject2 = this.app;
      if (!paramBoolean) {
        break label305;
      }
    }
    label305:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "Grp", "Clk_quit_grp", 0, 0, (String)localObject1, "", "", "");
      return;
      localObject2 = getString(2131367054);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f == null) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f + "(" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + ")")
      {
        localObject1 = String.format(getString(2131367049), new Object[] { localObject1 });
        localObject1 = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject1);
        ((QQCustomDialog)localObject1).setPositiveButton(getString(2131366212), new dpr(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(getString(2131362006));
        ((QQCustomDialog)localObject1).setNegativeButton(getString(2131365736), new dps(this, (QQCustomDialog)localObject1));
        ((QQCustomDialog)localObject1).setNegativeButtonContentDescription(getString(2131362007));
        ((QQCustomDialog)localObject1).show();
        break;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (FriendManager)this.app.getManager(8);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean) {}
    for (Object localObject = "Clk_setcommgrp";; localObject = "Clk_uncommgrp")
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      if (NetworkUtil.a(this) != 0) {
        break;
      }
      QQToast.a(this, 2131363422, 0).b(getTitleBarHeight());
      o();
      return;
    }
    localObject = (BizTroopHandler)this.app.a(21);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (;;)
    {
      ((BizTroopHandler)localObject).a(str, i1);
      return;
      i1 = 1;
    }
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "saveTroopInfo| nModifyFlag = " + paramInt);
    }
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString, paramInt);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131363422, 0).b(getTitleBarHeight());
      p();
      return;
    }
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.app.a(21);
    if (!paramBoolean)
    {
      DialogUtil.a(this, 230).setTitle(getString(2131365995)).setMessage(getString(2131364012)).setNegativeButton(getString(2131364013), new dqp(this, localBizTroopHandler)).setPositiveButton(getString(2131364014), new dqo(this)).show();
      return;
    }
    localBizTroopHandler.d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, paramBoolean);
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "share_set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.a(this) == 0)
    {
      QQToast.a(this, 2131363976, 0).b(getTitleBarHeight());
      F();
      return;
    }
    ((TroopHandler)this.app.a(19)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramBoolean, false);
    if (paramBoolean)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
  }
  
  private void z()
  {
    if (this.i)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Long.valueOf(((TroopAppInfo)localIterator.next()).appId));
      }
      b(localArrayList);
    }
    A();
  }
  
  protected long a(String paramString)
  {
    try
    {
      long l1 = Long.valueOf(paramString).longValue();
      return l1;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  protected Drawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return getResources().getDrawable(2130839419);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {
      i1 = 0;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
    switch (i1)
    {
    default: 
      return getResources().getDrawable(2130839419);
    case 0: 
      return getResources().getDrawable(2130839419);
    case 1: 
      return getResources().getDrawable(2130839420);
    case 2: 
      return getResources().getDrawable(2130839421);
    case 3: 
      return getResources().getDrawable(2130839422);
    case 4: 
      return getResources().getDrawable(2130839423);
    }
    return getResources().getDrawable(2130839424);
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString)) {
      return getString(2131367201);
    }
    return "";
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  protected void a()
  {
    // Byte code:
    //   0: invokestatic 1409	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: ldc_w 1411
    //   9: invokevirtual 1415	com/tencent/mobileqq/activity/ChatSettingForTroop:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 1417	android/view/LayoutInflater
    //   15: astore 7
    //   17: aload_0
    //   18: ldc_w 1418
    //   21: aconst_null
    //   22: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   25: astore 8
    //   27: aload_0
    //   28: aload 8
    //   30: ldc_w 1419
    //   33: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   36: checkcast 1421	com/tencent/widget/XListView
    //   39: putfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   42: aload_0
    //   43: aload 8
    //   45: ldc_w 1424
    //   48: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   51: checkcast 1426	android/widget/EditText
    //   54: putfield 1428	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   57: aload_0
    //   58: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   61: iconst_0
    //   62: invokevirtual 1431	com/tencent/widget/XListView:setVerticalScrollBarEnabled	(Z)V
    //   65: aload_0
    //   66: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   69: aconst_null
    //   70: invokevirtual 1434	com/tencent/widget/XListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   73: aload_0
    //   74: bipush 27
    //   76: anewarray 605	android/view/View
    //   79: putfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   82: aload_0
    //   83: new 611	android/widget/LinearLayout
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 1435	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   91: putfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   94: new 1439	com/tencent/widget/AbsListView$LayoutParams
    //   97: dup
    //   98: iconst_m1
    //   99: bipush 254
    //   101: invokespecial 1441	com/tencent/widget/AbsListView$LayoutParams:<init>	(II)V
    //   104: astore 7
    //   106: aload_0
    //   107: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   110: aload 7
    //   112: invokevirtual 1442	android/widget/LinearLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   115: aload_0
    //   116: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   119: iconst_1
    //   120: invokevirtual 1445	android/widget/LinearLayout:setOrientation	(I)V
    //   123: new 1447	com/tencent/widget/XSimpleListAdapter
    //   126: dup
    //   127: aload_0
    //   128: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   131: invokespecial 1449	com/tencent/widget/XSimpleListAdapter:<init>	(Landroid/view/View;)V
    //   134: astore 7
    //   136: aload_0
    //   137: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   140: aload 7
    //   142: invokevirtual 1453	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   145: aload_0
    //   146: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   149: iconst_2
    //   150: if_icmpne +41 -> 191
    //   153: aload_0
    //   154: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   157: invokevirtual 1456	com/tencent/widget/XListView:getPaddingLeft	()I
    //   160: istore_1
    //   161: aload_0
    //   162: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   165: invokevirtual 1456	com/tencent/widget/XListView:getPaddingLeft	()I
    //   168: istore_2
    //   169: aload_0
    //   170: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   173: ldc_w 1457
    //   176: invokevirtual 856	android/content/res/Resources:getDimensionPixelOffset	(I)I
    //   179: istore_3
    //   180: aload_0
    //   181: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   184: iload_1
    //   185: iconst_0
    //   186: iload_2
    //   187: iload_3
    //   188: invokevirtual 1461	com/tencent/widget/XListView:setPadding	(IIII)V
    //   191: aload_0
    //   192: aload 8
    //   194: invokevirtual 1464	com/tencent/mobileqq/activity/ChatSettingForTroop:setContentView	(Landroid/view/View;)V
    //   197: aload_0
    //   198: aload_0
    //   199: ldc_w 1465
    //   202: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   205: invokevirtual 1467	com/tencent/mobileqq/activity/ChatSettingForTroop:setTitle	(Ljava/lang/CharSequence;)V
    //   208: aload_0
    //   209: ldc_w 1468
    //   212: invokevirtual 1471	com/tencent/mobileqq/activity/ChatSettingForTroop:setLeftViewName	(I)V
    //   215: aload_0
    //   216: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   219: astore 7
    //   221: aload_0
    //   222: invokestatic 1477	com/tencent/mobileqq/util/SizeMeasure:e	(Landroid/content/Context;)I
    //   225: aload_0
    //   226: ldc_w 1478
    //   229: invokestatic 1481	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   232: isub
    //   233: istore_1
    //   234: iload_1
    //   235: aload_0
    //   236: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   239: ldc_w 1482
    //   242: invokevirtual 1485	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   245: isub
    //   246: iconst_4
    //   247: idiv
    //   248: istore_2
    //   249: aload_0
    //   250: ldc_w 1486
    //   253: aconst_null
    //   254: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   257: astore 9
    //   259: aload_0
    //   260: aload 9
    //   262: ldc_w 1487
    //   265: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   268: checkcast 1489	com/tencent/mobileqq/troop/widget/AvatarWallView
    //   271: putfield 1491	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   274: aload_0
    //   275: getfield 1491	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   278: iload_2
    //   279: invokevirtual 1494	com/tencent/mobileqq/troop/widget/AvatarWallView:setColumnWidth	(I)V
    //   282: aload_0
    //   283: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   286: invokevirtual 1164	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   289: ifeq +2528 -> 2817
    //   292: aload_0
    //   293: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   296: iconst_1
    //   297: if_icmpne +2520 -> 2817
    //   300: iconst_1
    //   301: istore 6
    //   303: aload_0
    //   304: new 1496	com/tencent/mobileqq/troop/widget/AvatarWallAdapter
    //   307: dup
    //   308: new 1498	mqq/util/WeakReference
    //   311: dup
    //   312: aload_0
    //   313: invokespecial 1500	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   316: aload_0
    //   317: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   320: aload_0
    //   321: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   324: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   327: aload_0
    //   328: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   331: getfield 468	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   334: aload_0
    //   335: getfield 272	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   338: iload 6
    //   340: ldc_w 511
    //   343: invokespecial 1503	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:<init>	(Lmqq/util/WeakReference;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ZLandroid/os/Handler;ZLjava/lang/String;)V
    //   346: putfield 1505	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   349: aload_0
    //   350: getfield 1491	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   353: aload_0
    //   354: getfield 1505	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   357: invokevirtual 1506	com/tencent/mobileqq/troop/widget/AvatarWallView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   360: aload_0
    //   361: getfield 1491	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   364: iconst_4
    //   365: invokevirtual 1509	com/tencent/mobileqq/troop/widget/AvatarWallView:setNumColumns	(I)V
    //   368: aload_0
    //   369: getfield 1505	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   372: iload_2
    //   373: invokevirtual 1510	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:a	(I)V
    //   376: aload_0
    //   377: getfield 1505	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter	Lcom/tencent/mobileqq/troop/widget/AvatarWallAdapter;
    //   380: aload_0
    //   381: getfield 1491	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView	Lcom/tencent/mobileqq/troop/widget/AvatarWallView;
    //   384: invokevirtual 1513	com/tencent/mobileqq/troop/widget/AvatarWallAdapter:a	(Lcom/tencent/widget/GridView;)V
    //   387: aload 7
    //   389: aload 9
    //   391: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   394: aload_0
    //   395: ldc_w 1516
    //   398: aconst_null
    //   399: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   402: astore 9
    //   404: aload_0
    //   405: aload 9
    //   407: ldc_w 1517
    //   410: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   413: checkcast 1062	android/widget/TextView
    //   416: putfield 1519	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   419: aload 7
    //   421: aload 9
    //   423: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   426: iload 6
    //   428: ifne +10 -> 438
    //   431: aload 9
    //   433: bipush 8
    //   435: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   438: aload_0
    //   439: aload 9
    //   441: putfield 1521	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   444: aload 7
    //   446: aload_0
    //   447: invokespecial 1523	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/view/View;
    //   450: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   453: aload_0
    //   454: ldc_w 1524
    //   457: aconst_null
    //   458: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   461: astore 10
    //   463: aload 7
    //   465: aload 10
    //   467: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   470: aload_0
    //   471: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   474: bipush 15
    //   476: aload 10
    //   478: aastore
    //   479: aload 10
    //   481: ldc_w 1525
    //   484: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   487: checkcast 1027	android/widget/ImageView
    //   490: astore 11
    //   492: aload 10
    //   494: ldc_w 1526
    //   497: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   500: checkcast 1062	android/widget/TextView
    //   503: astore 12
    //   505: aload 10
    //   507: ldc_w 1527
    //   510: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   513: checkcast 1062	android/widget/TextView
    //   516: astore 13
    //   518: aload 10
    //   520: ldc_w 1528
    //   523: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   526: checkcast 1027	android/widget/ImageView
    //   529: astore 14
    //   531: aload 10
    //   533: ldc_w 1529
    //   536: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   539: astore 9
    //   541: aload 10
    //   543: ldc_w 1530
    //   546: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   549: astore 10
    //   551: aload_0
    //   552: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   555: iconst_4
    //   556: aload_0
    //   557: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   560: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   563: iconst_3
    //   564: iconst_0
    //   565: invokevirtual 1533	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   568: astore 15
    //   570: aload_0
    //   571: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: aload 15
    //   576: invokevirtual 1536	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   579: astore 15
    //   581: aload 15
    //   583: ifnull +15 -> 598
    //   586: aload 11
    //   588: aload 15
    //   590: invokevirtual 1540	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   593: aload_0
    //   594: iconst_1
    //   595: putfield 243	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_g_of_type_Boolean	Z
    //   598: aload 11
    //   600: bipush 33
    //   602: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: invokevirtual 1541	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   608: aload 11
    //   610: aload_0
    //   611: invokevirtual 1542	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   614: aload 11
    //   616: aload_0
    //   617: ldc_w 1543
    //   620: invokespecial 1544	com/tencent/mobileqq/app/IphoneTitleBarActivity:getString	(I)Ljava/lang/String;
    //   623: invokevirtual 1545	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   626: aload 13
    //   628: bipush 6
    //   630: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: invokevirtual 1546	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   636: aload 13
    //   638: aload_0
    //   639: invokevirtual 1550	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   642: aload 12
    //   644: bipush 6
    //   646: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   649: invokevirtual 1546	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   652: aload 12
    //   654: aload_0
    //   655: invokevirtual 1550	android/widget/TextView:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   658: aload 12
    //   660: aload_0
    //   661: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   664: getfield 395	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   667: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   670: aload 13
    //   672: aload_0
    //   673: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   676: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   679: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   682: aload 14
    //   684: aload_0
    //   685: invokevirtual 1552	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/graphics/drawable/Drawable;
    //   688: invokevirtual 1097	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   691: aload 14
    //   693: bipush 6
    //   695: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   698: invokevirtual 1541	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   701: aload 14
    //   703: aload_0
    //   704: invokevirtual 1542	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   707: aload 14
    //   709: aload_0
    //   710: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   713: ldc_w 1553
    //   716: invokevirtual 1554	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   719: iconst_1
    //   720: anewarray 411	java/lang/Object
    //   723: dup
    //   724: iconst_0
    //   725: iconst_0
    //   726: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   729: aastore
    //   730: invokestatic 1221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   733: invokevirtual 1545	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   736: aload_0
    //   737: aload_0
    //   738: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   741: invokestatic 1559	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)Ljava/lang/String;
    //   744: astore 11
    //   746: aload 10
    //   748: bipush 20
    //   750: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   753: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   756: aload 10
    //   758: aload_0
    //   759: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   762: aload 10
    //   764: ldc_w 1560
    //   767: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   770: checkcast 1062	android/widget/TextView
    //   773: astore 12
    //   775: aload_0
    //   776: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   779: ldc_w 1561
    //   782: invokevirtual 1084	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   785: astore 13
    //   787: aload 13
    //   789: iconst_0
    //   790: iconst_0
    //   791: aload 13
    //   793: invokevirtual 1566	android/graphics/drawable/Drawable:getMinimumWidth	()I
    //   796: aload 13
    //   798: invokevirtual 1569	android/graphics/drawable/Drawable:getMinimumHeight	()I
    //   801: invokevirtual 1572	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   804: aload 12
    //   806: aload 13
    //   808: aconst_null
    //   809: aconst_null
    //   810: aconst_null
    //   811: invokevirtual 1576	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   814: aload 12
    //   816: bipush 10
    //   818: invokevirtual 1579	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   821: aload 11
    //   823: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   826: ifeq +1997 -> 2823
    //   829: aload 10
    //   831: bipush 8
    //   833: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   836: aload 9
    //   838: bipush 14
    //   840: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   846: aload 9
    //   848: aload_0
    //   849: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   852: aload 9
    //   854: ldc_w 1560
    //   857: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   860: checkcast 1062	android/widget/TextView
    //   863: astore 10
    //   865: aload_0
    //   866: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   869: ldc_w 1580
    //   872: invokevirtual 1084	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   875: astore 11
    //   877: aload 11
    //   879: iconst_0
    //   880: iconst_0
    //   881: aload 11
    //   883: invokevirtual 1566	android/graphics/drawable/Drawable:getMinimumWidth	()I
    //   886: aload 11
    //   888: invokevirtual 1569	android/graphics/drawable/Drawable:getMinimumHeight	()I
    //   891: invokevirtual 1572	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   894: aload 10
    //   896: aload 11
    //   898: aconst_null
    //   899: aconst_null
    //   900: aconst_null
    //   901: invokevirtual 1576	android/widget/TextView:setCompoundDrawables	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   904: aload 10
    //   906: bipush 10
    //   908: invokevirtual 1579	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   911: aload_0
    //   912: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   915: getfield 1581	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   918: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   921: ifeq +1918 -> 2839
    //   924: aload 9
    //   926: bipush 8
    //   928: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   931: aload_0
    //   932: invokevirtual 1583	com/tencent/mobileqq/activity/ChatSettingForTroop:v	()V
    //   935: aload 7
    //   937: aload_0
    //   938: invokespecial 1523	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/view/View;
    //   941: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   944: aload_0
    //   945: iload_1
    //   946: aload_0
    //   947: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   950: ldc_w 1482
    //   953: invokevirtual 1485	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   956: isub
    //   957: aload_0
    //   958: fconst_1
    //   959: invokestatic 1481	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Landroid/content/Context;F)I
    //   962: iconst_3
    //   963: imul
    //   964: isub
    //   965: iconst_4
    //   966: idiv
    //   967: putfield 1585	com/tencent/mobileqq/activity/ChatSettingForTroop:ay	I
    //   970: aload_0
    //   971: ldc_w 1586
    //   974: aconst_null
    //   975: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   978: astore 9
    //   980: aload_0
    //   981: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   984: bipush 16
    //   986: aload 9
    //   988: aastore
    //   989: aload 7
    //   991: aload 9
    //   993: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   996: aload_0
    //   997: new 1588	android/widget/LinearLayout$LayoutParams
    //   1000: dup
    //   1001: aload_0
    //   1002: getfield 1585	com/tencent/mobileqq/activity/ChatSettingForTroop:ay	I
    //   1005: bipush 254
    //   1007: invokespecial 1589	android/widget/LinearLayout$LayoutParams:<init>	(II)V
    //   1010: putfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1013: aload_0
    //   1014: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1017: bipush 17
    //   1019: putfield 1592	android/widget/LinearLayout$LayoutParams:gravity	I
    //   1022: aload_0
    //   1023: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1026: fconst_1
    //   1027: putfield 1595	android/widget/LinearLayout$LayoutParams:weight	F
    //   1030: aload 9
    //   1032: ldc_w 603
    //   1035: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1038: checkcast 611	android/widget/LinearLayout
    //   1041: astore 9
    //   1043: aload_0
    //   1044: ldc_w 1053
    //   1047: aconst_null
    //   1048: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1051: astore 10
    //   1053: aload 10
    //   1055: iconst_1
    //   1056: invokevirtual 1056	android/view/View:setFocusable	(Z)V
    //   1059: aload 10
    //   1061: iconst_1
    //   1062: invokevirtual 1059	android/view/View:setClickable	(Z)V
    //   1065: aload 9
    //   1067: bipush 16
    //   1069: invokevirtual 1598	android/widget/LinearLayout:setGravity	(I)V
    //   1072: aload 10
    //   1074: ldc_w 1060
    //   1077: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1080: checkcast 1062	android/widget/TextView
    //   1083: astore 11
    //   1085: aload 10
    //   1087: ldc_w 1025
    //   1090: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1093: checkcast 1027	android/widget/ImageView
    //   1096: astore 12
    //   1098: aload 11
    //   1100: ldc_w 1599
    //   1103: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   1106: aload 12
    //   1108: ldc_w 1602
    //   1111: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   1114: aload 10
    //   1116: iconst_0
    //   1117: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1120: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1123: aload 10
    //   1125: aload_0
    //   1126: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1129: aload_0
    //   1130: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1133: iconst_0
    //   1134: aload 10
    //   1136: aastore
    //   1137: aload 9
    //   1139: aload 10
    //   1141: aload_0
    //   1142: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1145: invokevirtual 1052	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1148: aload_0
    //   1149: ldc_w 1053
    //   1152: aconst_null
    //   1153: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1156: astore 10
    //   1158: aload 10
    //   1160: iconst_1
    //   1161: invokevirtual 1056	android/view/View:setFocusable	(Z)V
    //   1164: aload 10
    //   1166: iconst_1
    //   1167: invokevirtual 1059	android/view/View:setClickable	(Z)V
    //   1170: aload 10
    //   1172: ldc_w 1060
    //   1175: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1178: checkcast 1062	android/widget/TextView
    //   1181: astore 11
    //   1183: aload 10
    //   1185: ldc_w 1025
    //   1188: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1191: checkcast 1027	android/widget/ImageView
    //   1194: astore 12
    //   1196: aload 11
    //   1198: ldc_w 1606
    //   1201: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   1204: aload 12
    //   1206: ldc_w 1607
    //   1209: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   1212: aload 10
    //   1214: iconst_2
    //   1215: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1218: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1221: aload 10
    //   1223: aload_0
    //   1224: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1227: aload_0
    //   1228: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1231: iconst_2
    //   1232: aload 10
    //   1234: aastore
    //   1235: aload 9
    //   1237: aload 10
    //   1239: aload_0
    //   1240: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1243: invokevirtual 1052	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1246: aload_0
    //   1247: ldc_w 1053
    //   1250: aconst_null
    //   1251: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1254: astore 10
    //   1256: aload 10
    //   1258: iconst_1
    //   1259: invokevirtual 1056	android/view/View:setFocusable	(Z)V
    //   1262: aload 10
    //   1264: iconst_1
    //   1265: invokevirtual 1059	android/view/View:setClickable	(Z)V
    //   1268: aload 10
    //   1270: ldc_w 1060
    //   1273: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1276: checkcast 1062	android/widget/TextView
    //   1279: astore 11
    //   1281: aload 10
    //   1283: ldc_w 1025
    //   1286: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1289: checkcast 1027	android/widget/ImageView
    //   1292: astore 12
    //   1294: aload 11
    //   1296: ldc_w 1608
    //   1299: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   1302: aload 12
    //   1304: ldc_w 1609
    //   1307: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   1310: aload 10
    //   1312: iconst_1
    //   1313: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1316: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1319: aload 10
    //   1321: aload_0
    //   1322: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1325: aload_0
    //   1326: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1329: ifnull +33 -> 1362
    //   1332: aload_0
    //   1333: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1336: getfield 480	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_Int	I
    //   1339: istore_1
    //   1340: aload_0
    //   1341: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1344: getfield 470	com/tencent/mobileqq/troopinfo/TroopInfoData:i	I
    //   1347: ifeq +1513 -> 2860
    //   1350: iconst_1
    //   1351: istore 6
    //   1353: aload_0
    //   1354: aload 10
    //   1356: iload_1
    //   1357: iload 6
    //   1359: invokevirtual 1121	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;IZ)V
    //   1362: aload_0
    //   1363: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1366: iconst_1
    //   1367: aload 10
    //   1369: aastore
    //   1370: aload 9
    //   1372: aload 10
    //   1374: aload_0
    //   1375: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   1378: invokevirtual 1052	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1381: aload_0
    //   1382: getfield 251	com/tencent/mobileqq/activity/ChatSettingForTroop:i	Z
    //   1385: ifeq +1481 -> 2866
    //   1388: aload_0
    //   1389: aload_0
    //   1390: getfield 1188	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1393: invokespecial 947	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/ArrayList;)V
    //   1396: aload_0
    //   1397: ldc_w 1610
    //   1400: aconst_null
    //   1401: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1404: astore 9
    //   1406: aload_0
    //   1407: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1410: bipush 19
    //   1412: aload 9
    //   1414: aastore
    //   1415: aload_0
    //   1416: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   1419: iconst_2
    //   1420: if_icmpne +1547 -> 2967
    //   1423: aload 9
    //   1425: bipush 8
    //   1427: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1430: aload 7
    //   1432: aload 9
    //   1434: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1437: aload_0
    //   1438: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   1441: iconst_1
    //   1442: if_icmpne +49 -> 1491
    //   1445: aload_0
    //   1446: ldc_w 1611
    //   1449: aconst_null
    //   1450: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1453: astore 9
    //   1455: aload_0
    //   1456: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1459: iconst_4
    //   1460: aload 9
    //   1462: aastore
    //   1463: aload 7
    //   1465: aload 9
    //   1467: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1470: aload_0
    //   1471: iconst_4
    //   1472: iconst_2
    //   1473: aload 9
    //   1475: aload_0
    //   1476: ldc_w 1612
    //   1479: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1482: ldc_w 378
    //   1485: iconst_1
    //   1486: iconst_0
    //   1487: iconst_0
    //   1488: invokevirtual 1615	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;ZIZ)V
    //   1491: aload_0
    //   1492: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1495: aload 7
    //   1497: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1500: aload_0
    //   1501: ldc_w 1616
    //   1504: aconst_null
    //   1505: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1508: astore 7
    //   1510: aload_0
    //   1511: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1514: aload 7
    //   1516: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1519: aload_0
    //   1520: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   1523: iconst_1
    //   1524: if_icmpne +1582 -> 3106
    //   1527: aload_0
    //   1528: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   1531: astore 7
    //   1533: aload_0
    //   1534: ldc_w 1617
    //   1537: aconst_null
    //   1538: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1541: astore 9
    //   1543: aload_0
    //   1544: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1547: bipush 9
    //   1549: aload 9
    //   1551: aastore
    //   1552: aload 7
    //   1554: aload 9
    //   1556: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1559: aload_0
    //   1560: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1563: getfield 1618	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1566: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1569: ifeq +1445 -> 3014
    //   1572: aload_0
    //   1573: bipush 9
    //   1575: iconst_1
    //   1576: aload 9
    //   1578: aload_0
    //   1579: ldc_w 1619
    //   1582: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1585: aload_0
    //   1586: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1589: invokevirtual 495	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   1592: iconst_1
    //   1593: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1596: aload_0
    //   1597: ldc_w 1623
    //   1600: aconst_null
    //   1601: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1604: astore 9
    //   1606: aload_0
    //   1607: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1610: iconst_5
    //   1611: aload 9
    //   1613: aastore
    //   1614: aload 7
    //   1616: aload 9
    //   1618: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1621: aload_0
    //   1622: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1625: invokevirtual 1164	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   1628: ifeq +1413 -> 3041
    //   1631: aload_0
    //   1632: iconst_5
    //   1633: iconst_2
    //   1634: aload 9
    //   1636: aload_0
    //   1637: ldc_w 1624
    //   1640: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1643: aload_0
    //   1644: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1647: getfield 1625	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1650: iconst_1
    //   1651: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1654: aload_0
    //   1655: aload 9
    //   1657: invokevirtual 1627	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;)V
    //   1660: aload_0
    //   1661: ldc_w 1628
    //   1664: aconst_null
    //   1665: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1668: astore 9
    //   1670: aload_0
    //   1671: bipush 8
    //   1673: iconst_0
    //   1674: aload 9
    //   1676: aload_0
    //   1677: ldc_w 1629
    //   1680: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1683: ldc_w 378
    //   1686: invokevirtual 1632	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1689: aload 9
    //   1691: ldc_w 1633
    //   1694: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1697: checkcast 1062	android/widget/TextView
    //   1700: ldc_w 1634
    //   1703: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   1706: aload_0
    //   1707: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1710: bipush 8
    //   1712: aload 9
    //   1714: aastore
    //   1715: aload 7
    //   1717: aload 9
    //   1719: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1722: aload_0
    //   1723: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1726: iconst_5
    //   1727: aaload
    //   1728: ldc_w 1635
    //   1731: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1734: astore 10
    //   1736: aload_0
    //   1737: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1740: invokevirtual 1164	com/tencent/mobileqq/troopinfo/TroopInfoData:e	()Z
    //   1743: ifeq +1324 -> 3067
    //   1746: aload 9
    //   1748: iconst_0
    //   1749: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1752: aload 10
    //   1754: iconst_0
    //   1755: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1758: aload_0
    //   1759: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1762: aload 7
    //   1764: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1767: aload_0
    //   1768: ldc_w 1616
    //   1771: aconst_null
    //   1772: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1775: astore 7
    //   1777: aload_0
    //   1778: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   1781: aload 7
    //   1783: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1786: aload_0
    //   1787: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   1790: astore 9
    //   1792: new 1637	com/tencent/mobileqq/widget/FormSimpleItem
    //   1795: dup
    //   1796: aload_0
    //   1797: invokespecial 1638	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;)V
    //   1800: astore 7
    //   1802: aload_0
    //   1803: bipush 23
    //   1805: iconst_3
    //   1806: aload 7
    //   1808: aload_0
    //   1809: ldc_w 1639
    //   1812: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1815: ldc_w 378
    //   1818: iconst_1
    //   1819: invokevirtual 1642	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1822: aload_0
    //   1823: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1826: bipush 23
    //   1828: aload 7
    //   1830: aastore
    //   1831: aload 9
    //   1833: aload 7
    //   1835: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1838: new 1637	com/tencent/mobileqq/widget/FormSimpleItem
    //   1841: dup
    //   1842: aload_0
    //   1843: invokespecial 1638	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;)V
    //   1846: astore 7
    //   1848: aload_0
    //   1849: bipush 28
    //   1851: iconst_3
    //   1852: aload 7
    //   1854: aload_0
    //   1855: ldc_w 1643
    //   1858: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1861: ldc_w 378
    //   1864: iconst_1
    //   1865: invokevirtual 1642	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILcom/tencent/mobileqq/widget/FormSimpleItem;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1868: aload 9
    //   1870: aload 7
    //   1872: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1875: aload_0
    //   1876: ldc_w 1628
    //   1879: aconst_null
    //   1880: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1883: astore 7
    //   1885: aload_0
    //   1886: bipush 27
    //   1888: iconst_2
    //   1889: aload 7
    //   1891: aload_0
    //   1892: ldc_w 1644
    //   1895: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1898: ldc_w 378
    //   1901: invokevirtual 1632	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   1904: aload_0
    //   1905: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1908: bipush 26
    //   1910: aload 7
    //   1912: aastore
    //   1913: aload 9
    //   1915: aload 7
    //   1917: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1920: aload 9
    //   1922: aload_0
    //   1923: invokespecial 1523	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/view/View;
    //   1926: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   1929: new 536	com/tencent/mobileqq/widget/FormSwitchItem
    //   1932: dup
    //   1933: aload_0
    //   1934: aconst_null
    //   1935: invokespecial 1647	com/tencent/mobileqq/widget/FormSwitchItem:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   1938: astore 7
    //   1940: aload 7
    //   1942: iconst_3
    //   1943: invokevirtual 1650	com/tencent/mobileqq/widget/FormSwitchItem:setBgType	(I)V
    //   1946: aload 7
    //   1948: aload_0
    //   1949: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   1952: ldc_w 1651
    //   1955: invokevirtual 1554	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1958: invokevirtual 1652	com/tencent/mobileqq/widget/FormSwitchItem:setText	(Ljava/lang/CharSequence;)V
    //   1961: aload 7
    //   1963: iconst_1
    //   1964: invokevirtual 1653	com/tencent/mobileqq/widget/FormSwitchItem:setFocusable	(Z)V
    //   1967: aload_0
    //   1968: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1971: bipush 17
    //   1973: aload 7
    //   1975: aastore
    //   1976: aload 7
    //   1978: invokevirtual 539	com/tencent/mobileqq/widget/FormSwitchItem:a	()Lcom/tencent/widget/Switch;
    //   1981: astore 10
    //   1983: aload 10
    //   1985: bipush 17
    //   1987: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1990: invokevirtual 1654	com/tencent/widget/Switch:setTag	(Ljava/lang/Object;)V
    //   1993: aload 10
    //   1995: aconst_null
    //   1996: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   1999: aload_0
    //   2000: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2003: bipush 36
    //   2005: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2008: checkcast 602	com/tencent/mobileqq/model/TroopInfoManager
    //   2011: aload_0
    //   2012: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2015: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2018: invokevirtual 1656	com/tencent/mobileqq/model/TroopInfoManager:c	(Ljava/lang/String;)Z
    //   2021: istore 6
    //   2023: aload 10
    //   2025: iload 6
    //   2027: invokevirtual 549	com/tencent/widget/Switch:setChecked	(Z)V
    //   2030: aload 10
    //   2032: aload_0
    //   2033: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   2036: aload 10
    //   2038: aload_0
    //   2039: ldc_w 1651
    //   2042: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2045: invokevirtual 553	com/tencent/widget/Switch:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2048: iload 6
    //   2050: ifeq +43 -> 2093
    //   2053: aload_0
    //   2054: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2057: ldc_w 387
    //   2060: ldc_w 1124
    //   2063: ldc_w 378
    //   2066: ldc_w 1126
    //   2069: ldc_w 1658
    //   2072: iconst_0
    //   2073: iconst_0
    //   2074: aload_0
    //   2075: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2078: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2081: ldc_w 378
    //   2084: ldc_w 378
    //   2087: ldc_w 378
    //   2090: invokestatic 385	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2093: aload 9
    //   2095: aload 7
    //   2097: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2100: new 536	com/tencent/mobileqq/widget/FormSwitchItem
    //   2103: dup
    //   2104: aload_0
    //   2105: aconst_null
    //   2106: invokespecial 1647	com/tencent/mobileqq/widget/FormSwitchItem:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   2109: astore 7
    //   2111: aload 7
    //   2113: iconst_3
    //   2114: invokevirtual 1650	com/tencent/mobileqq/widget/FormSwitchItem:setBgType	(I)V
    //   2117: aload 7
    //   2119: aload_0
    //   2120: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   2123: ldc_w 1659
    //   2126: invokevirtual 1554	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2129: invokevirtual 1652	com/tencent/mobileqq/widget/FormSwitchItem:setText	(Ljava/lang/CharSequence;)V
    //   2132: aload 7
    //   2134: iconst_1
    //   2135: invokevirtual 1653	com/tencent/mobileqq/widget/FormSwitchItem:setFocusable	(Z)V
    //   2138: aload_0
    //   2139: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2142: bipush 13
    //   2144: aload 7
    //   2146: aastore
    //   2147: aload 7
    //   2149: invokevirtual 539	com/tencent/mobileqq/widget/FormSwitchItem:a	()Lcom/tencent/widget/Switch;
    //   2152: astore 10
    //   2154: aload 10
    //   2156: bipush 13
    //   2158: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2161: invokevirtual 1654	com/tencent/widget/Switch:setTag	(Ljava/lang/Object;)V
    //   2164: aload_0
    //   2165: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2168: bipush 8
    //   2170: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2173: checkcast 1272	com/tencent/mobileqq/model/FriendManager
    //   2176: aload_0
    //   2177: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2180: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2183: invokeinterface 1661 2 0
    //   2188: istore 6
    //   2190: aload 10
    //   2192: aconst_null
    //   2193: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   2196: aload 10
    //   2198: iload 6
    //   2200: invokevirtual 549	com/tencent/widget/Switch:setChecked	(Z)V
    //   2203: aload 10
    //   2205: aload_0
    //   2206: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   2209: aload 10
    //   2211: aload_0
    //   2212: ldc_w 1662
    //   2215: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2218: invokevirtual 553	com/tencent/widget/Switch:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2221: aload 9
    //   2223: aload 7
    //   2225: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2228: new 536	com/tencent/mobileqq/widget/FormSwitchItem
    //   2231: dup
    //   2232: aload_0
    //   2233: aconst_null
    //   2234: invokespecial 1647	com/tencent/mobileqq/widget/FormSwitchItem:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   2237: astore 10
    //   2239: aload 10
    //   2241: iconst_3
    //   2242: invokevirtual 1650	com/tencent/mobileqq/widget/FormSwitchItem:setBgType	(I)V
    //   2245: aload 10
    //   2247: aload_0
    //   2248: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   2251: ldc_w 1663
    //   2254: invokevirtual 1554	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2257: invokevirtual 1652	com/tencent/mobileqq/widget/FormSwitchItem:setText	(Ljava/lang/CharSequence;)V
    //   2260: aload 10
    //   2262: iconst_1
    //   2263: invokevirtual 1653	com/tencent/mobileqq/widget/FormSwitchItem:setFocusable	(Z)V
    //   2266: aload_0
    //   2267: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2270: bipush 18
    //   2272: aload 10
    //   2274: aastore
    //   2275: aload 10
    //   2277: invokevirtual 539	com/tencent/mobileqq/widget/FormSwitchItem:a	()Lcom/tencent/widget/Switch;
    //   2280: astore 11
    //   2282: aload 11
    //   2284: bipush 18
    //   2286: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2289: invokevirtual 1654	com/tencent/widget/Switch:setTag	(Ljava/lang/Object;)V
    //   2292: aload_0
    //   2293: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2296: bipush 50
    //   2298: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2301: checkcast 529	com/tencent/mobileqq/app/TroopManager
    //   2304: aload_0
    //   2305: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2308: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2311: invokevirtual 532	com/tencent/mobileqq/app/TroopManager:d	(Ljava/lang/String;)Z
    //   2314: istore 6
    //   2316: aload 11
    //   2318: aconst_null
    //   2319: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   2322: aload 11
    //   2324: iload 6
    //   2326: invokevirtual 549	com/tencent/widget/Switch:setChecked	(Z)V
    //   2329: aload 11
    //   2331: aload_0
    //   2332: invokevirtual 545	com/tencent/widget/Switch:setOnCheckedChangeListener	(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V
    //   2335: iload 6
    //   2337: iconst_1
    //   2338: if_icmpne +746 -> 3084
    //   2341: aload_0
    //   2342: ldc_w 550
    //   2345: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2348: astore 7
    //   2350: aload 11
    //   2352: aload 7
    //   2354: invokevirtual 553	com/tencent/widget/Switch:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2357: aload 9
    //   2359: aload 10
    //   2361: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2364: aload_0
    //   2365: ldc_w 1628
    //   2368: aconst_null
    //   2369: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2372: astore 7
    //   2374: aload_0
    //   2375: bipush 10
    //   2377: iconst_0
    //   2378: aload 7
    //   2380: aload_0
    //   2381: ldc_w 1664
    //   2384: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2387: ldc_w 378
    //   2390: invokevirtual 1632	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;)V
    //   2393: aload_0
    //   2394: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2397: bipush 10
    //   2399: aload 7
    //   2401: aastore
    //   2402: aload 9
    //   2404: aload 7
    //   2406: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2409: aload_0
    //   2410: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2413: aload 9
    //   2415: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2418: aload_0
    //   2419: ldc_w 1616
    //   2422: aconst_null
    //   2423: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2426: astore 7
    //   2428: aload_0
    //   2429: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2432: aload 7
    //   2434: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2437: aload_0
    //   2438: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   2441: astore 7
    //   2443: aload_0
    //   2444: aload 7
    //   2446: iconst_1
    //   2447: invokestatic 1667	com/tencent/mobileqq/util/Utils:a	(Landroid/content/Context;Landroid/view/View;Z)V
    //   2450: aload_0
    //   2451: ldc_w 1668
    //   2454: aconst_null
    //   2455: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2458: astore 9
    //   2460: aload_0
    //   2461: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2464: bipush 21
    //   2466: aload 9
    //   2468: aastore
    //   2469: aload 7
    //   2471: aload 9
    //   2473: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2476: aload_0
    //   2477: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2480: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   2483: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2486: ifne +610 -> 3096
    //   2489: aload_0
    //   2490: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2493: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   2496: astore 10
    //   2498: aload_0
    //   2499: bipush 21
    //   2501: iconst_0
    //   2502: aload 9
    //   2504: aload_0
    //   2505: ldc_w 1669
    //   2508: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2511: aload 10
    //   2513: iconst_0
    //   2514: invokevirtual 1671	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   2517: aload_0
    //   2518: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2521: aload 7
    //   2523: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2526: aload_0
    //   2527: ldc_w 1616
    //   2530: aconst_null
    //   2531: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2534: astore 7
    //   2536: aload_0
    //   2537: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   2540: aload 7
    //   2542: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2545: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2548: ifeq +34 -> 2582
    //   2551: ldc 57
    //   2553: iconst_2
    //   2554: new 823	java/lang/StringBuilder
    //   2557: dup
    //   2558: invokespecial 824	java/lang/StringBuilder:<init>	()V
    //   2561: ldc_w 1673
    //   2564: invokevirtual 830	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: invokestatic 1409	java/lang/System:currentTimeMillis	()J
    //   2570: lload 4
    //   2572: lsub
    //   2573: invokevirtual 1115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2576: invokevirtual 834	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2579: invokestatic 688	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2582: aload_0
    //   2583: getfield 1676	com/tencent/mobileqq/activity/ChatSettingForTroop:rightViewImg	Landroid/widget/ImageView;
    //   2586: iconst_0
    //   2587: invokevirtual 1677	android/widget/ImageView:setVisibility	(I)V
    //   2590: aload_0
    //   2591: getfield 1676	com/tencent/mobileqq/activity/ChatSettingForTroop:rightViewImg	Landroid/widget/ImageView;
    //   2594: ldc_w 1678
    //   2597: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   2600: aload_0
    //   2601: getfield 1676	com/tencent/mobileqq/activity/ChatSettingForTroop:rightViewImg	Landroid/widget/ImageView;
    //   2604: aload_0
    //   2605: ldc_w 1679
    //   2608: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   2611: invokevirtual 1545	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   2614: aload_0
    //   2615: getfield 1676	com/tencent/mobileqq/activity/ChatSettingForTroop:rightViewImg	Landroid/widget/ImageView;
    //   2618: new 1681	dqz
    //   2621: dup
    //   2622: aload_0
    //   2623: invokespecial 1682	dqz:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   2626: invokevirtual 1542	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2629: aload_0
    //   2630: aload 8
    //   2632: ldc_w 1683
    //   2635: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   2638: putfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2641: aload_0
    //   2642: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   2645: iconst_2
    //   2646: if_icmpne +87 -> 2733
    //   2649: aload_0
    //   2650: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2653: ldc_w 1686
    //   2656: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   2659: checkcast 1027	android/widget/ImageView
    //   2662: astore 7
    //   2664: aload_0
    //   2665: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2668: ldc_w 1687
    //   2671: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   2674: checkcast 1062	android/widget/TextView
    //   2677: astore 8
    //   2679: aload_0
    //   2680: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2683: iconst_0
    //   2684: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   2687: aload_0
    //   2688: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2691: getfield 468	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   2694: ifeq +678 -> 3372
    //   2697: aload 7
    //   2699: ldc_w 1688
    //   2702: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   2705: aload 8
    //   2707: ldc_w 1689
    //   2710: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   2713: aload_0
    //   2714: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2717: bipush 31
    //   2719: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2722: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   2725: aload_0
    //   2726: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   2729: aload_0
    //   2730: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2733: aload_0
    //   2734: iconst_0
    //   2735: invokevirtual 1691	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Z)V
    //   2738: aload_0
    //   2739: getfield 1423	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   2742: invokevirtual 1695	com/tencent/widget/XListView:getViewTreeObserver	()Landroid/view/ViewTreeObserver;
    //   2745: new 1697	drb
    //   2748: dup
    //   2749: aload_0
    //   2750: invokespecial 1698	drb:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   2753: invokevirtual 1704	android/view/ViewTreeObserver:addOnGlobalLayoutListener	(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    //   2756: return
    //   2757: astore 7
    //   2759: aload_0
    //   2760: invokevirtual 568	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2763: aload 7
    //   2765: invokevirtual 1707	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2768: return
    //   2769: astore 7
    //   2771: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2774: ifeq +14 -> 2788
    //   2777: ldc 57
    //   2779: iconst_2
    //   2780: aload 7
    //   2782: invokevirtual 1710	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   2785: invokestatic 1355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2788: aload_0
    //   2789: invokevirtual 568	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2792: return
    //   2793: astore 7
    //   2795: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2798: ifeq +14 -> 2812
    //   2801: ldc 57
    //   2803: iconst_2
    //   2804: aload 7
    //   2806: invokevirtual 1711	android/view/InflateException:getMessage	()Ljava/lang/String;
    //   2809: invokestatic 1355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2812: aload_0
    //   2813: invokevirtual 568	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   2816: return
    //   2817: iconst_0
    //   2818: istore 6
    //   2820: goto -2517 -> 303
    //   2823: aload 10
    //   2825: iconst_0
    //   2826: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   2829: aload 12
    //   2831: aload 11
    //   2833: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2836: goto -2000 -> 836
    //   2839: aload 9
    //   2841: iconst_0
    //   2842: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   2845: aload 10
    //   2847: aload_0
    //   2848: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   2851: getfield 1581	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2854: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2857: goto -1926 -> 931
    //   2860: iconst_0
    //   2861: istore 6
    //   2863: goto -1510 -> 1353
    //   2866: aload_0
    //   2867: ldc_w 1053
    //   2870: aconst_null
    //   2871: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   2874: astore 10
    //   2876: aload 10
    //   2878: iconst_1
    //   2879: invokevirtual 1056	android/view/View:setFocusable	(Z)V
    //   2882: aload 10
    //   2884: iconst_1
    //   2885: invokevirtual 1059	android/view/View:setClickable	(Z)V
    //   2888: aload 10
    //   2890: ldc_w 1060
    //   2893: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   2896: checkcast 1062	android/widget/TextView
    //   2899: astore 11
    //   2901: aload 10
    //   2903: ldc_w 1025
    //   2906: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   2909: checkcast 1027	android/widget/ImageView
    //   2912: astore 12
    //   2914: aload 11
    //   2916: ldc_w 1712
    //   2919: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   2922: aload 12
    //   2924: ldc_w 1081
    //   2927: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   2930: aload 10
    //   2932: iconst_3
    //   2933: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2936: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   2939: aload 10
    //   2941: aload_0
    //   2942: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2945: aload_0
    //   2946: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   2949: iconst_3
    //   2950: aload 10
    //   2952: aastore
    //   2953: aload 9
    //   2955: aload 10
    //   2957: aload_0
    //   2958: getfield 1112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams	Landroid/widget/LinearLayout$LayoutParams;
    //   2961: invokevirtual 1052	android/widget/LinearLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   2964: goto -1568 -> 1396
    //   2967: aload 7
    //   2969: aload_0
    //   2970: invokespecial 1523	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/view/View;
    //   2973: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   2976: aload_0
    //   2977: aload 9
    //   2979: aconst_null
    //   2980: aconst_null
    //   2981: aconst_null
    //   2982: invokevirtual 1715	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   2985: aload 9
    //   2987: iconst_0
    //   2988: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   2991: aload 9
    //   2993: aload_0
    //   2994: ldc_w 1716
    //   2997: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3000: invokevirtual 1129	android/view/View:setContentDescription	(Ljava/lang/CharSequence;)V
    //   3003: aload_0
    //   3004: aload 9
    //   3006: iconst_0
    //   3007: iconst_0
    //   3008: invokevirtual 1121	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;IZ)V
    //   3011: goto -1581 -> 1430
    //   3014: aload_0
    //   3015: bipush 9
    //   3017: iconst_1
    //   3018: aload 9
    //   3020: aload_0
    //   3021: ldc_w 1619
    //   3024: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3027: aload_0
    //   3028: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3031: getfield 1618	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   3034: iconst_1
    //   3035: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3038: goto -1442 -> 1596
    //   3041: aload_0
    //   3042: iconst_5
    //   3043: iconst_3
    //   3044: aload 9
    //   3046: aload_0
    //   3047: ldc_w 1624
    //   3050: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3053: aload_0
    //   3054: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3057: getfield 1625	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3060: iconst_1
    //   3061: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3064: goto -1410 -> 1654
    //   3067: aload 9
    //   3069: bipush 8
    //   3071: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   3074: aload 10
    //   3076: bipush 8
    //   3078: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   3081: goto -1323 -> 1758
    //   3084: aload_0
    //   3085: ldc_w 554
    //   3088: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3091: astore 7
    //   3093: goto -743 -> 2350
    //   3096: aload 7
    //   3098: bipush 8
    //   3100: invokevirtual 933	android/widget/LinearLayout:setVisibility	(I)V
    //   3103: goto -586 -> 2517
    //   3106: aload_0
    //   3107: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   3110: iconst_2
    //   3111: if_icmpne -585 -> 2526
    //   3114: aload_0
    //   3115: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   3118: astore 9
    //   3120: aload_0
    //   3121: ldc_w 1623
    //   3124: aconst_null
    //   3125: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3128: astore 7
    //   3130: aload_0
    //   3131: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3134: bipush 22
    //   3136: aload 7
    //   3138: aastore
    //   3139: aload 9
    //   3141: aload 7
    //   3143: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3146: aload_0
    //   3147: bipush 22
    //   3149: iconst_1
    //   3150: aload 7
    //   3152: aload_0
    //   3153: ldc_w 1717
    //   3156: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3159: aload_0
    //   3160: ldc_w 1718
    //   3163: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3166: iconst_1
    //   3167: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3170: aload_0
    //   3171: aload 7
    //   3173: invokevirtual 1627	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Landroid/view/View;)V
    //   3176: aload_0
    //   3177: ldc_w 1719
    //   3180: aconst_null
    //   3181: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3184: astore 10
    //   3186: aload_0
    //   3187: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3190: bipush 25
    //   3192: aload 10
    //   3194: aastore
    //   3195: aload 9
    //   3197: aload 10
    //   3199: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3202: ldc_w 378
    //   3205: astore 7
    //   3207: aload_0
    //   3208: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3211: getfield 1625	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3214: ifnull +12 -> 3226
    //   3217: aload_0
    //   3218: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3221: getfield 1625	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   3224: astore 7
    //   3226: aload_0
    //   3227: bipush 25
    //   3229: iconst_3
    //   3230: aload 10
    //   3232: aload_0
    //   3233: ldc_w 1624
    //   3236: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3239: aload 7
    //   3241: iconst_1
    //   3242: invokevirtual 1622	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3245: aload_0
    //   3246: invokevirtual 1721	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   3249: aload_0
    //   3250: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3253: aload 9
    //   3255: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3258: aload_0
    //   3259: ldc_w 1616
    //   3262: aconst_null
    //   3263: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3266: astore 7
    //   3268: aload_0
    //   3269: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3272: aload 7
    //   3274: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3277: aload_0
    //   3278: invokespecial 1473	com/tencent/mobileqq/activity/ChatSettingForTroop:a	()Landroid/widget/LinearLayout;
    //   3281: astore 7
    //   3283: aload_0
    //   3284: ldc_w 1668
    //   3287: aconst_null
    //   3288: invokestatic 1046	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
    //   3291: astore 9
    //   3293: aload_0
    //   3294: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   3297: bipush 21
    //   3299: aload 9
    //   3301: aastore
    //   3302: aload 7
    //   3304: aload 9
    //   3306: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3309: aload_0
    //   3310: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3313: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   3316: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3319: ifne +43 -> 3362
    //   3322: aload_0
    //   3323: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3326: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   3329: astore 10
    //   3331: aload_0
    //   3332: bipush 21
    //   3334: iconst_0
    //   3335: aload 9
    //   3337: aload_0
    //   3338: ldc_w 1669
    //   3341: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   3344: aload 10
    //   3346: iconst_0
    //   3347: invokevirtual 1671	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   3350: aload_0
    //   3351: getfield 1437	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3354: aload 7
    //   3356: invokevirtual 1515	android/widget/LinearLayout:addView	(Landroid/view/View;)V
    //   3359: goto -833 -> 2526
    //   3362: aload 7
    //   3364: bipush 8
    //   3366: invokevirtual 933	android/widget/LinearLayout:setVisibility	(I)V
    //   3369: goto -19 -> 3350
    //   3372: aload_0
    //   3373: getfield 583	com/tencent/mobileqq/activity/ChatSettingForTroop:ax	I
    //   3376: iconst_2
    //   3377: if_icmpne +43 -> 3420
    //   3380: aload_0
    //   3381: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3384: ldc_w 387
    //   3387: ldc_w 1723
    //   3390: ldc_w 378
    //   3393: ldc_w 1725
    //   3396: ldc_w 1727
    //   3399: iconst_0
    //   3400: iconst_0
    //   3401: aload_0
    //   3402: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   3405: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3408: ldc_w 378
    //   3411: ldc_w 378
    //   3414: ldc_w 378
    //   3417: invokestatic 385	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3420: aload 7
    //   3422: ldc_w 1728
    //   3425: invokevirtual 1605	android/widget/ImageView:setImageResource	(I)V
    //   3428: aload 8
    //   3430: ldc_w 1729
    //   3433: invokevirtual 1601	android/widget/TextView:setText	(I)V
    //   3436: aload_0
    //   3437: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3440: bipush 32
    //   3442: invokestatic 815	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3445: invokevirtual 1106	android/view/View:setTag	(Ljava/lang/Object;)V
    //   3448: aload_0
    //   3449: getfield 1685	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3452: aload_0
    //   3453: invokevirtual 1110	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   3456: goto -723 -> 2733
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3459	0	this	ChatSettingForTroop
    //   160	1197	1	i1	int
    //   168	205	2	i2	int
    //   179	9	3	i3	int
    //   3	2568	4	l1	long
    //   301	2561	6	bool	boolean
    //   15	2683	7	localObject1	Object
    //   2757	7	7	localOutOfMemoryError1	OutOfMemoryError
    //   2769	12	7	localOutOfMemoryError2	OutOfMemoryError
    //   2793	175	7	localInflateException	InflateException
    //   3091	330	7	localObject2	Object
    //   25	3404	8	localObject3	Object
    //   257	3079	9	localObject4	Object
    //   461	2884	10	localObject5	Object
    //   490	2425	11	localObject6	Object
    //   503	2420	12	localObject7	Object
    //   516	291	13	localObject8	Object
    //   529	179	14	localImageView	ImageView
    //   568	21	15	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	2757	java/lang/OutOfMemoryError
    //   249	259	2769	java/lang/OutOfMemoryError
    //   249	259	2793	android/view/InflateException
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[25];
    if (localObject == null) {}
    String str;
    do
    {
      return;
      str = String.format(getString(2131367739), new Object[] { Integer.valueOf(paramInt1) });
      localObject = (TextView)((View)localObject).findViewById(2131297409);
    } while (localObject == null);
    ((TextView)localObject).setText(str);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence)
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)paramView.findViewById(2131300632);
    paramView.setTag(Integer.valueOf(paramInt1));
    paramView.setOnClickListener(this);
    localFormSimpleItem.a(true);
    localFormSimpleItem.setFocusable(false);
    localFormSimpleItem.setClickable(false);
    localFormSimpleItem.setBgType(paramInt2);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localFormSimpleItem.setLeftText(str);
    localFormSimpleItem.setLeftTextColor(0);
    localFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      localFormSimpleItem.setRightText(paramString);
      paramView.setBackgroundResource(2130838103);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131297409);
    paramString.setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean1);
    a(paramView, paramInt3, paramBoolean2);
    paramString = (TextView)paramView.findViewById(2131297409);
    paramString.setEditableFactory(QQTextBuilder.a);
    if (paramCharSequence == null) {}
    for (paramView = "";; paramView = new QQText(paramCharSequence, 11))
    {
      paramString.setText(paramView);
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    for (;;)
    {
      paramView.setBackgroundResource(2130838103);
      TextView localTextView = (TextView)paramView.findViewById(2131297001);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setText(str);
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      paramFormSimpleItem.setBgType(paramInt2);
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramFormSimpleItem.setLeftText(str);
      paramFormSimpleItem.setLeftTextColor(0);
      paramFormSimpleItem.b().setEditableFactory(QQTextBuilder.a);
      if (paramCharSequence != null) {
        break label105;
      }
    }
    label105:
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      paramFormSimpleItem.setBackgroundResource(2130838103);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("isNeedFinish", false))
      {
        finish();
        return;
      }
    } while (paramIntent.getExtras() == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString = paramIntent.getStringExtra("location");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramIntent.getIntExtra("lat", 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramIntent.getIntExtra("lon", 0);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramIntent.getStringExtra("name");
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = paramIntent.getLongExtra("class", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("intro");
    k();
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    while ((this.av != 2) || (21 != paramInt)) {
      return;
    }
  }
  
  public void a(int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateDefaultItemView(), tag = " + paramInt + ", info = " + paramCharSequence + ", bShowArrow = " + paramBoolean);
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length)) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];; localView = null)
    {
      TextView localTextView;
      if (localView != null)
      {
        localTextView = (TextView)localView.findViewById(2131297409);
        if (paramInt != 21) {
          break label163;
        }
        if (!TextUtils.isEmpty(paramCharSequence)) {
          break label139;
        }
        localView.setVisibility(8);
        if (!paramBoolean) {
          break label199;
        }
        localView.setTag(Integer.valueOf(paramInt));
        localView.setOnClickListener(this);
      }
      for (;;)
      {
        a(paramInt, localView, paramBoolean);
        return;
        label139:
        localView.setVisibility(0);
        localTextView.setText(new QQText(paramCharSequence, 11));
        break;
        label163:
        localView.setVisibility(0);
        if (paramCharSequence == null) {}
        for (paramCharSequence = "";; paramCharSequence = new QQText(paramCharSequence, 3))
        {
          localTextView.setText(paramCharSequence);
          break;
        }
        label199:
        localView.setTag(null);
        localView.setOnClickListener(null);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i2 = this.jdField_b_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ImageView localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i1);
        String str = (String)localImageView.getTag();
        try
        {
          long l1 = Long.valueOf(str).longValue();
          if (l1 == paramLong)
          {
            localImageView.setBackgroundDrawable(this.app.b(Long.toString(paramLong)));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i1 += 1;
        }
      }
    }
  }
  
  /* Error */
  public void a(BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 1839	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 1841	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 1842	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 1846	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 1847	[B
    //   30: invokevirtual 1851	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 1854	KQQ/BatchResponse:seq	I
    //   38: ifne +200 -> 238
    //   41: aload 10
    //   43: ifnull +195 -> 238
    //   46: aload 10
    //   48: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +184 -> 238
    //   57: aload 10
    //   59: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 1872	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 9
    //   70: new 1874	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 1875	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 8
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 1876	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 9
    //   90: aload 8
    //   92: getfield 1880	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +57 -> 159
    //   105: iconst_0
    //   106: istore_2
    //   107: goto +1550 -> 1657
    //   110: aload 9
    //   112: ifnonnull +126 -> 238
    //   115: iload_3
    //   116: iload_2
    //   117: if_icmpge +121 -> 238
    //   120: aload 11
    //   122: iload_3
    //   123: invokeinterface 880 2 0
    //   128: checkcast 1887	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   131: astore 12
    //   133: aload 12
    //   135: ifnonnull +35 -> 170
    //   138: aload 9
    //   140: astore 8
    //   142: iload_3
    //   143: iconst_1
    //   144: iadd
    //   145: istore_3
    //   146: aload 8
    //   148: astore 9
    //   150: goto -40 -> 110
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 1888	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   158: return
    //   159: aload 11
    //   161: invokeinterface 845 1 0
    //   166: istore_2
    //   167: goto +1490 -> 1657
    //   170: aload 12
    //   172: getfield 1892	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   175: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   178: istore 4
    //   180: iload 4
    //   182: bipush 72
    //   184: if_icmpne +447 -> 631
    //   187: iload_3
    //   188: ifne +443 -> 631
    //   191: aload_0
    //   192: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   195: iconst_1
    //   196: if_icmpne +404 -> 600
    //   199: aload_0
    //   200: ldc_w 1897
    //   203: iconst_1
    //   204: invokestatic 1295	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   207: invokevirtual 1900	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   210: pop
    //   211: aload 9
    //   213: astore 8
    //   215: goto -73 -> 142
    //   218: astore 8
    //   220: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +15 -> 238
    //   226: ldc_w 1902
    //   229: iconst_2
    //   230: aload 8
    //   232: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokestatic 688	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: getfield 1854	KQQ/BatchResponse:seq	I
    //   242: iconst_1
    //   243: if_icmpne +81 -> 324
    //   246: aload 10
    //   248: ifnull +76 -> 324
    //   251: aload 10
    //   253: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   259: ifeq +65 -> 324
    //   262: aload 10
    //   264: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   270: invokevirtual 1872	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   273: astore 8
    //   275: new 1904	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   278: dup
    //   279: invokespecial 1905	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: aload 8
    //   288: invokevirtual 1906	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   291: pop
    //   292: aload 9
    //   294: getfield 1909	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   297: ifnull +27 -> 324
    //   300: aload_0
    //   301: aload 9
    //   303: getfield 1909	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   306: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   309: invokevirtual 1911	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/util/List;)V
    //   312: aload_0
    //   313: aload 9
    //   315: getfield 1909	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   318: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   321: putfield 1913	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   324: aload_1
    //   325: getfield 1854	KQQ/BatchResponse:seq	I
    //   328: iconst_2
    //   329: if_icmpne -318 -> 11
    //   332: aload 10
    //   334: ifnull -323 -> 11
    //   337: aload 10
    //   339: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   342: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   345: ifeq -334 -> 11
    //   348: aload 10
    //   350: getfield 1858	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   353: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   356: invokevirtual 1872	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   359: astore 8
    //   361: new 1915	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   364: dup
    //   365: invokespecial 1916	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   368: astore_1
    //   369: aload_1
    //   370: aload 8
    //   372: invokevirtual 1917	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   375: pop
    //   376: aload_1
    //   377: getfield 1920	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   380: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   383: astore 8
    //   385: aload_1
    //   386: getfield 1923	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   389: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   392: astore 10
    //   394: aload_1
    //   395: getfield 1926	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   398: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   401: istore_2
    //   402: aload_0
    //   403: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: invokevirtual 1929	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   409: lstore 6
    //   411: iload_2
    //   412: ifeq -401 -> 11
    //   415: aload 8
    //   417: ifnull -406 -> 11
    //   420: aload 8
    //   422: invokeinterface 845 1 0
    //   427: ifle -416 -> 11
    //   430: aload 10
    //   432: ifnull -421 -> 11
    //   435: aload 10
    //   437: invokeinterface 845 1 0
    //   442: ifle -431 -> 11
    //   445: aload 10
    //   447: invokeinterface 845 1 0
    //   452: istore_3
    //   453: iconst_0
    //   454: istore_2
    //   455: iload_2
    //   456: iload_3
    //   457: if_icmpge -446 -> 11
    //   460: aload 10
    //   462: iload_2
    //   463: invokeinterface 880 2 0
    //   468: checkcast 1931	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   471: astore 9
    //   473: aload 9
    //   475: ifnull +1170 -> 1645
    //   478: lload 6
    //   480: aload 9
    //   482: getfield 1935	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   485: invokevirtual 1939	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   488: lcmp
    //   489: ifne +1156 -> 1645
    //   492: aload 9
    //   494: getfield 1942	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:bytes_special_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   497: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   500: ifeq +1152 -> 1652
    //   503: aload 9
    //   505: getfield 1942	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:bytes_special_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   508: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   511: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   514: astore_1
    //   515: aload 9
    //   517: getfield 1948	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   520: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   523: istore_3
    //   524: aload 8
    //   526: invokeinterface 845 1 0
    //   531: istore 4
    //   533: iconst_0
    //   534: istore_2
    //   535: iload_2
    //   536: iload 4
    //   538: if_icmpge -527 -> 11
    //   541: aload 8
    //   543: iload_2
    //   544: invokeinterface 880 2 0
    //   549: checkcast 1950	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName
    //   552: astore 9
    //   554: aload 9
    //   556: getfield 1951	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   559: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   562: iload_3
    //   563: if_icmpne +1075 -> 1638
    //   566: aload 9
    //   568: getfield 1954	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   571: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   574: ifeq +1064 -> 1638
    //   577: aload_0
    //   578: aload 9
    //   580: getfield 1954	tencent/im/oidb/cmd0x787/oidb_0x787$LevelName:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   583: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   586: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   589: aload_1
    //   590: invokevirtual 1956	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: return
    //   594: astore_1
    //   595: aload_1
    //   596: invokevirtual 1831	java/lang/Exception:printStackTrace	()V
    //   599: return
    //   600: aload 9
    //   602: astore 8
    //   604: aload_0
    //   605: getfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   608: iconst_2
    //   609: if_icmpne -467 -> 142
    //   612: aload_0
    //   613: ldc_w 1957
    //   616: iconst_1
    //   617: invokestatic 1295	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   620: invokevirtual 1900	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   623: pop
    //   624: aload 9
    //   626: astore 8
    //   628: goto -486 -> 142
    //   631: aload 9
    //   633: astore 8
    //   635: iload 4
    //   637: ifne -495 -> 142
    //   640: aload 9
    //   642: astore 8
    //   644: aload 12
    //   646: getfield 1961	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   649: invokevirtual 1964	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   652: ifeq -510 -> 142
    //   655: aload 12
    //   657: getfield 1961	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   660: invokevirtual 1967	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   663: checkcast 1963	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   666: astore 9
    //   668: aload 9
    //   670: astore 8
    //   672: aload 9
    //   674: ifnull -532 -> 142
    //   677: aload_0
    //   678: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   681: ifnull +605 -> 1286
    //   684: aload_0
    //   685: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   688: bipush 15
    //   690: aaload
    //   691: astore 12
    //   693: aload 9
    //   695: getfield 1970	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   698: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   701: ifeq +42 -> 743
    //   704: aload_0
    //   705: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   708: aload 9
    //   710: getfield 1970	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   713: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   716: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   719: putfield 395	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   722: aload 12
    //   724: ldc_w 1526
    //   727: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   730: checkcast 1062	android/widget/TextView
    //   733: aload_0
    //   734: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   737: getfield 395	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   740: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   743: aload_0
    //   744: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   747: aload 9
    //   749: getfield 1973	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_grade	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   752: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   755: putfield 1389	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   758: aload_0
    //   759: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   762: ifnull +17 -> 779
    //   765: aload_0
    //   766: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   769: aload_0
    //   770: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   773: getfield 1389	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   776: putfield 1976	com/tencent/mobileqq/data/TroopInfo:nTroopGrade	I
    //   779: aload_0
    //   780: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   783: aload 9
    //   785: getfield 1979	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:rpt_tag_record	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   788: invokevirtual 1885	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   791: invokestatic 1983	com/tencent/mobileqq/data/TroopInfo:setTags	(Ljava/util/List;)Ljava/lang/String;
    //   794: invokestatic 1987	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   797: putfield 1988	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   800: aload_0
    //   801: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   804: aload 9
    //   806: getfield 1991	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_active_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   809: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   812: putfield 1993	com/tencent/mobileqq/troopinfo/TroopInfoData:o	I
    //   815: aload_0
    //   816: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   819: aload 9
    //   821: getfield 1996	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   824: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   827: i2l
    //   828: putfield 1998	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   831: aload_0
    //   832: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   835: aload 9
    //   837: getfield 2001	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_certification_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   840: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   843: i2l
    //   844: putfield 2003	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   847: aload_0
    //   848: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   851: aload 9
    //   853: getfield 2006	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   856: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   859: i2l
    //   860: putfield 1320	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   863: aload_0
    //   864: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   867: aload 9
    //   869: getfield 2009	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   872: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   875: putfield 2011	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Int	I
    //   878: aload_0
    //   879: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   882: aload 9
    //   884: getfield 2014	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   887: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   890: putfield 2016	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_Int	I
    //   893: aload_0
    //   894: invokevirtual 2018	com/tencent/mobileqq/activity/ChatSettingForTroop:y	()V
    //   897: aload 9
    //   899: getfield 2021	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   902: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   905: ifeq +42 -> 947
    //   908: aload_0
    //   909: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   912: aload 9
    //   914: getfield 2021	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   917: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   920: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   923: putfield 2022	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   926: aload_0
    //   927: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   930: ifnull +17 -> 947
    //   933: aload_0
    //   934: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   937: aload_0
    //   938: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   941: getfield 2022	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   944: putfield 2025	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   947: aload_0
    //   948: aload_0
    //   949: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   952: invokestatic 1559	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)Ljava/lang/String;
    //   955: astore 8
    //   957: aload 12
    //   959: ldc_w 1530
    //   962: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   965: astore 12
    //   967: aload 8
    //   969: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifeq +539 -> 1511
    //   975: aload 12
    //   977: bipush 8
    //   979: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   982: aload 9
    //   984: getfield 2029	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   987: invokevirtual 2032	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   990: checkcast 2031	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   993: astore 8
    //   995: aload 8
    //   997: getfield 2035	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1000: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1003: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1006: astore 12
    //   1008: aload 8
    //   1010: getfield 2039	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1013: invokevirtual 2042	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1016: l2i
    //   1017: istore 4
    //   1019: aload 8
    //   1021: getfield 2045	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1024: invokevirtual 2042	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1027: l2i
    //   1028: istore 5
    //   1030: aload 12
    //   1032: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1035: ifne +12 -> 1047
    //   1038: aload_0
    //   1039: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1042: aload 12
    //   1044: putfield 1581	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1047: iload 4
    //   1049: ifeq +12 -> 1061
    //   1052: aload_0
    //   1053: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1056: iload 4
    //   1058: putfield 1790	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_Int	I
    //   1061: iload 5
    //   1063: ifeq +12 -> 1075
    //   1066: aload_0
    //   1067: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1070: iload 5
    //   1072: putfield 1794	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_e_of_type_Int	I
    //   1075: aload_0
    //   1076: invokevirtual 1805	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   1079: aload 9
    //   1081: getfield 2048	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1084: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1087: ifeq +449 -> 1536
    //   1090: aload_0
    //   1091: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1094: aload 9
    //   1096: getfield 2048	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1099: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1102: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1105: putfield 2050	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1108: aload 9
    //   1110: getfield 2053	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1113: invokevirtual 1863	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1116: ifeq +433 -> 1549
    //   1119: aload_0
    //   1120: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1123: aload 9
    //   1125: getfield 2053	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1128: invokevirtual 1866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1131: invokevirtual 1945	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1134: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1137: aload_0
    //   1138: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1141: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1144: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1147: ifeq +415 -> 1562
    //   1150: aload_0
    //   1151: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1154: aload_0
    //   1155: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1158: getfield 2050	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1161: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1164: aload_0
    //   1165: getfield 534	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   1168: bipush 21
    //   1170: aaload
    //   1171: astore 8
    //   1173: aload 8
    //   1175: ifnull +46 -> 1221
    //   1178: aload_0
    //   1179: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1182: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1185: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1188: ifne +411 -> 1599
    //   1191: aload 8
    //   1193: iconst_0
    //   1194: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1197: aload_0
    //   1198: bipush 21
    //   1200: iconst_0
    //   1201: aload 8
    //   1203: aload_0
    //   1204: ldc_w 1669
    //   1207: invokevirtual 444	com/tencent/mobileqq/activity/ChatSettingForTroop:getString	(I)Ljava/lang/String;
    //   1210: aload_0
    //   1211: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1214: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1217: iconst_0
    //   1218: invokevirtual 1671	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(IILandroid/view/View;Ljava/lang/String;Ljava/lang/CharSequence;Z)V
    //   1221: aload_0
    //   1222: invokevirtual 2055	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   1225: aload 9
    //   1227: getfield 1996	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 2056	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1233: ifeq +18 -> 1251
    //   1236: aload_0
    //   1237: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1240: aload 9
    //   1242: getfield 1996	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1245: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1248: putfield 2058	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_Int	I
    //   1251: aload_0
    //   1252: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1255: ifnull +31 -> 1286
    //   1258: aload_0
    //   1259: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1262: aload_0
    //   1263: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1266: getfield 2050	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1269: putfield 2061	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   1272: aload_0
    //   1273: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1276: aload_0
    //   1277: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1280: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1283: putfield 2064	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   1286: aload 9
    //   1288: getfield 2067	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1291: invokevirtual 2056	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1294: ifeq +93 -> 1387
    //   1297: aload 9
    //   1299: getfield 2067	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1302: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1305: ifle +82 -> 1387
    //   1308: aload 9
    //   1310: getfield 2009	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1313: invokevirtual 2056	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1316: ifeq +71 -> 1387
    //   1319: aload 9
    //   1321: getfield 2009	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1324: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1327: ifle +60 -> 1387
    //   1330: aload_0
    //   1331: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1334: ifnull +33 -> 1367
    //   1337: aload_0
    //   1338: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1341: aload 9
    //   1343: getfield 2067	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1346: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1349: putfield 2070	com/tencent/mobileqq/data/TroopInfo:wMemberMax	I
    //   1352: aload_0
    //   1353: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1356: aload 9
    //   1358: getfield 2009	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1361: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1364: putfield 2073	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1367: aload_0
    //   1368: aload 9
    //   1370: getfield 2009	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1373: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1376: aload 9
    //   1378: getfield 2067	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_max_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1381: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1384: invokevirtual 2074	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(II)V
    //   1387: aload_0
    //   1388: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1391: ifnull +34 -> 1425
    //   1394: aload_0
    //   1395: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1398: aload 9
    //   1400: getfield 1996	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1403: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1406: i2l
    //   1407: putfield 2077	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   1410: aload_0
    //   1411: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1414: aload 9
    //   1416: getfield 2014	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1419: invokevirtual 1896	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1422: putfield 2080	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   1425: aload_0
    //   1426: invokevirtual 1583	com/tencent/mobileqq/activity/ChatSettingForTroop:v	()V
    //   1429: aload 9
    //   1431: getfield 2083	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1434: invokevirtual 2084	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1437: ifeq +37 -> 1474
    //   1440: aload_0
    //   1441: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1444: new 823	java/lang/StringBuilder
    //   1447: dup
    //   1448: invokespecial 824	java/lang/StringBuilder:<init>	()V
    //   1451: ldc_w 378
    //   1454: invokevirtual 830	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: aload 9
    //   1459: getfield 2083	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1462: invokevirtual 1939	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1465: invokevirtual 1115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1468: invokevirtual 834	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: putfield 2086	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   1474: aload 9
    //   1476: astore 8
    //   1478: aload_0
    //   1479: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1482: ifnull -1340 -> 142
    //   1485: aload_0
    //   1486: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1489: bipush 50
    //   1491: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1494: checkcast 529	com/tencent/mobileqq/app/TroopManager
    //   1497: aload_0
    //   1498: getfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   1501: invokevirtual 2089	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1504: aload 9
    //   1506: astore 8
    //   1508: goto -1366 -> 142
    //   1511: aload 12
    //   1513: iconst_0
    //   1514: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1517: aload 12
    //   1519: ldc_w 1560
    //   1522: invokevirtual 609	android/view/View:findViewById	(I)Landroid/view/View;
    //   1525: checkcast 1062	android/widget/TextView
    //   1528: aload 8
    //   1530: invokevirtual 1068	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1533: goto -551 -> 982
    //   1536: aload_0
    //   1537: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1540: ldc_w 378
    //   1543: putfield 2050	com/tencent/mobileqq/troopinfo/TroopInfoData:l	Ljava/lang/String;
    //   1546: goto -438 -> 1108
    //   1549: aload_0
    //   1550: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1553: ldc_w 378
    //   1556: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1559: goto -422 -> 1137
    //   1562: aload_0
    //   1563: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1566: aload_0
    //   1567: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1570: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1573: invokestatic 2093	com/tencent/biz/common/util/HttpUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1576: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1579: aload_0
    //   1580: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1583: aload_0
    //   1584: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1587: getfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1590: invokestatic 2095	com/tencent/biz/common/util/HttpUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1593: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   1596: goto -432 -> 1164
    //   1599: aload 8
    //   1601: invokevirtual 2099	android/view/View:getParent	()Landroid/view/ViewParent;
    //   1604: checkcast 605	android/view/View
    //   1607: bipush 8
    //   1609: invokevirtual 936	android/view/View:setVisibility	(I)V
    //   1612: goto -391 -> 1221
    //   1615: astore 8
    //   1617: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1620: ifeq -1296 -> 324
    //   1623: ldc_w 1902
    //   1626: iconst_2
    //   1627: aload 8
    //   1629: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   1632: invokestatic 688	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1635: goto -1311 -> 324
    //   1638: iload_2
    //   1639: iconst_1
    //   1640: iadd
    //   1641: istore_2
    //   1642: goto -1107 -> 535
    //   1645: iload_2
    //   1646: iconst_1
    //   1647: iadd
    //   1648: istore_2
    //   1649: goto -1194 -> 455
    //   1652: aconst_null
    //   1653: astore_1
    //   1654: goto -1139 -> 515
    //   1657: iconst_0
    //   1658: istore_3
    //   1659: goto -1549 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1662	0	this	ChatSettingForTroop
    //   0	1662	1	paramBatchResponse	BatchResponse
    //   106	1543	2	i1	int
    //   115	1544	3	i2	int
    //   178	879	4	i3	int
    //   1028	43	5	i4	int
    //   409	70	6	l1	long
    //   77	137	8	localObject1	Object
    //   218	13	8	localException1	Exception
    //   273	1327	8	localObject2	Object
    //   1615	13	8	localException2	Exception
    //   68	1437	9	localObject3	Object
    //   19	442	10	localObject4	Object
    //   98	62	11	localList	List
    //   131	1387	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	153	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	218	java/lang/Exception
    //   90	100	218	java/lang/Exception
    //   120	133	218	java/lang/Exception
    //   159	167	218	java/lang/Exception
    //   170	180	218	java/lang/Exception
    //   191	211	218	java/lang/Exception
    //   604	624	218	java/lang/Exception
    //   644	668	218	java/lang/Exception
    //   677	743	218	java/lang/Exception
    //   743	779	218	java/lang/Exception
    //   779	947	218	java/lang/Exception
    //   947	982	218	java/lang/Exception
    //   982	1047	218	java/lang/Exception
    //   1052	1061	218	java/lang/Exception
    //   1066	1075	218	java/lang/Exception
    //   1075	1108	218	java/lang/Exception
    //   1108	1137	218	java/lang/Exception
    //   1137	1164	218	java/lang/Exception
    //   1164	1173	218	java/lang/Exception
    //   1178	1221	218	java/lang/Exception
    //   1221	1251	218	java/lang/Exception
    //   1251	1286	218	java/lang/Exception
    //   1286	1367	218	java/lang/Exception
    //   1367	1387	218	java/lang/Exception
    //   1387	1425	218	java/lang/Exception
    //   1425	1474	218	java/lang/Exception
    //   1478	1504	218	java/lang/Exception
    //   1511	1533	218	java/lang/Exception
    //   1536	1546	218	java/lang/Exception
    //   1549	1559	218	java/lang/Exception
    //   1562	1596	218	java/lang/Exception
    //   1599	1612	218	java/lang/Exception
    //   361	411	594	java/lang/Exception
    //   420	430	594	java/lang/Exception
    //   435	453	594	java/lang/Exception
    //   460	473	594	java/lang/Exception
    //   478	515	594	java/lang/Exception
    //   515	533	594	java/lang/Exception
    //   541	593	594	java/lang/Exception
    //   275	324	1615	java/lang/Exception
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298723));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298724));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298725));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298726));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298727));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300635));
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_c_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_e_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_f_of_type_AndroidWidgetImageView);
  }
  
  public void a(View paramView, int paramInt)
  {
    View localView = paramView.findViewById(2131299347);
    paramView = (TextView)paramView.findViewById(2131299348);
    if ((this.av == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
    {
      localView.setVisibility(8);
      if (paramInt > 99)
      {
        paramView.setVisibility(0);
        paramView.setText("99+");
      }
    }
    else
    {
      return;
    }
    if (paramInt > 0)
    {
      paramView.setVisibility(0);
      paramView.setText(paramInt + "");
      return;
    }
    paramView.setText("");
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299347);
    if (paramInt > 0)
    {
      localTextView.setVisibility(0);
      paramView = Integer.toString(paramInt);
      if (paramInt > 99) {
        paramView = "99+";
      }
      localTextView.setText(paramView);
      localTextView.setBackgroundResource(2130839517);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130841953, 0, 0, 0);
      return;
    }
    localTextView.setVisibility(4);
    localTextView.setText("");
    localTextView.setBackgroundResource(0);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramView = (LinearLayout)paramView.findViewById(2131296744);
    } while (paramView == null);
    paramView.setVisibility(0);
  }
  
  public void a(View paramView, String paramString1, CharSequence paramCharSequence, String paramString2)
  {
    a(19, 3, paramView, paramString1, true);
    paramView.setContentDescription(getString(2131363962, new Object[] { paramString2, paramString1, paramCharSequence }));
    TextView localTextView1 = (TextView)paramView.findViewById(2131297001);
    TextView localTextView2 = (TextView)paramView.findViewById(2131300627);
    paramView = (TextView)paramView.findViewById(2131297409);
    paramView.setEditableFactory(QQTextBuilder.a);
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    paramView.setFocusable(false);
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new dre(this, paramView));
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramView.setVisibility(8);
      if (!TextUtils.isEmpty(paramString1)) {
        break label173;
      }
      localTextView1.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localTextView2.setText(paramString2);
      }
      return;
      paramView.setVisibility(0);
      paramView.setText(new QQText(paramCharSequence, 11));
      break;
      label173:
      localTextView1.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return;
    }
    ((BizTroopHandler)this.app.a(21)).e(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      } while (localObject == null);
      localObject = (TextView)((View)localObject).findViewById(2131300629);
    } while (localObject == null);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankSysFlag != 1) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupRankUserFlag != 1))
    {
      ((TextView)localObject).setVisibility(8);
      return;
    }
    ((TextView)localObject).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.app.a()))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        ((TextView)localObject).setText(paramString2);
      }
      for (;;)
      {
        TroopMemberListActivity.a((TextView)localObject, 0);
        return;
        ((TextView)localObject).setText(2131365820);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(this.app.a()))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        ((TextView)localObject).setText(paramString2);
      }
      for (;;)
      {
        TroopMemberListActivity.a((TextView)localObject, 1);
        return;
        ((TextView)localObject).setText(2131365819);
      }
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      ((TextView)localObject).setText(paramString2);
      TroopMemberListActivity.a((TextView)localObject, 2);
      return;
    }
    ((TextView)localObject).setText(paramString1);
    TroopMemberListActivity.a((TextView)localObject, 3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramString3, "", "");
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    int i1 = getResources().getDimensionPixelOffset(2131493164);
    int i3 = getResources().getDimensionPixelOffset(2131493165);
    int i2 = getResources().getDimensionPixelOffset(2131493170);
    i3 = SizeMeasure.e(this) - i1 - i3 - Utils.a(this, 10.0F) * 2 - PublicAccountUtil.a(this, 64.0F);
    int i4 = getResources().getDimensionPixelOffset(2131493169);
    i1 = (int)Math.floor((i3 - i2 * 6) / i4);
    if (i1 > 6) {
      i1 = 6;
    }
    for (;;)
    {
      i4 += (i3 - i1 * i2 - i1 * i4) / i1;
      if (paramList != null)
      {
        i2 = paramList.size();
        i3 = 0;
        label137:
        if (i3 >= i1 - 1) {
          break label294;
        }
        localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i3);
        if (i3 >= i2) {
          break label284;
        }
        localObject = (oidb_0x899.memberlist)paramList.get(i3);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
          break label210;
        }
      }
      label210:
      long l1;
      for (;;)
      {
        i3 += 1;
        break label137;
        i2 = 0;
        break;
        l1 = ((oidb_0x899.memberlist)localObject).uint64_member_uin.get();
        localImageView.setVisibility(0);
        localImageView.setBackgroundDrawable(this.app.b(Long.toString(l1)));
        localImageView.setTag(Long.toString(l1));
        localObject = localImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i4;
        ((ViewGroup.LayoutParams)localObject).width = i4;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label284:
        localImageView.setVisibility(8);
      }
      label294:
      ImageView localImageView = (ImageView)this.jdField_b_of_type_JavaUtilList.get(i1 - 1);
      Object localObject = localImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i4;
      ((ViewGroup.LayoutParams)localObject).width = i4;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localImageView.setVisibility(0);
      if (this.av == 1)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mMemberInvitingFlag) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())) {
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          label387:
          if (i2 <= 0) {
            break label547;
          }
          if (this.av != 1) {
            break label549;
          }
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
          label406:
          if (paramList == null) {
            break label571;
          }
          paramList = (LinearLayout)paramList.findViewById(2131300634);
          if (paramList == null) {
            break;
          }
          paramList.setVisibility(0);
          return;
          localImageView.setBackgroundResource(2130839425);
          localImageView.setContentDescription(super.getString(2131364161));
          localImageView.setOnClickListener(new drf(this));
        }
      }
      if (i1 - 1 < i2) {}
      for (paramList = (oidb_0x899.memberlist)paramList.get(i1 - 1);; paramList = null)
      {
        if ((paramList != null) && (paramList.uint64_member_uin.has()))
        {
          l1 = paramList.uint64_member_uin.get();
          localImageView.setBackgroundDrawable(this.app.b(Long.toString(l1)));
          localImageView.setTag(Long.toString(l1));
          break label387;
        }
        localImageView.setVisibility(4);
        break label387;
        label547:
        break;
        label549:
        if (this.av == 2)
        {
          paramList = this.jdField_a_of_type_ArrayOfAndroidViewView[22];
          break label406;
        }
        paramList = null;
        break label406;
        label571:
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
    }
    label22:
    View localView;
    label117:
    label126:
    do
    {
      break label22;
      do
      {
        return;
      } while (this.av != 1);
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[16];
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
      if (localView != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a()) {
          break label117;
        }
        localView.setVisibility(0);
        localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
      }
      for (;;)
      {
        localView = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
        if (localView == null) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
          break label126;
        }
        if ((localView.isShown()) && (localView.getVisibility() != 8)) {
          break;
        }
        localView.setVisibility(0);
        return;
        localView.setVisibility(8);
      }
    } while ((!localView.isShown()) && (localView.getVisibility() != 0));
    localView.setVisibility(8);
  }
  
  /* Error */
  protected boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 57
    //   10: iconst_2
    //   11: ldc_w 2212
    //   14: invokestatic 688	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 218	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Boolean	Z
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 216	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Boolean	Z
    //   36: aload_0
    //   37: invokevirtual 2216	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   40: invokevirtual 1780	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   49: aload 4
    //   51: ldc_w 360
    //   54: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   64: aload 4
    //   66: ldc_w 1204
    //   69: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 1206	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload_0
    //   76: aload 4
    //   78: ldc_w 673
    //   81: iconst_1
    //   82: invokevirtual 2221	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   85: putfield 224	com/tencent/mobileqq/activity/ChatSettingForTroop:av	I
    //   88: aload_0
    //   89: aload 4
    //   91: ldc_w 2223
    //   94: invokevirtual 2225	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   97: putfield 583	com/tencent/mobileqq/activity/ChatSettingForTroop:ax	I
    //   100: aload_0
    //   101: aload 4
    //   103: ldc_w 2227
    //   106: iconst_m1
    //   107: invokevirtual 2221	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   110: putfield 265	com/tencent/mobileqq/activity/ChatSettingForTroop:aA	I
    //   113: aload_0
    //   114: aload 4
    //   116: ldc_w 2229
    //   119: iconst_0
    //   120: invokevirtual 2221	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   123: putfield 267	com/tencent/mobileqq/activity/ChatSettingForTroop:aB	I
    //   126: aload_0
    //   127: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   130: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   133: invokestatic 1318	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   136: lstore_2
    //   137: lload_2
    //   138: lconst_0
    //   139: lcmp
    //   140: ifle -116 -> 24
    //   143: aload_0
    //   144: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   147: aload 4
    //   149: ldc_w 2231
    //   152: invokevirtual 2225	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   155: putfield 556	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Int	I
    //   158: aload_0
    //   159: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   162: aload 4
    //   164: ldc_w 2233
    //   167: invokevirtual 2225	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   170: putfield 2235	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Int	I
    //   173: aload_0
    //   174: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   177: aload 4
    //   179: ldc_w 2237
    //   182: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 584	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload_0
    //   189: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   192: aload 4
    //   194: ldc_w 2239
    //   197: invokevirtual 2242	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   200: putfield 468	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   203: aload_0
    //   204: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   207: aload 4
    //   209: ldc_w 2244
    //   212: invokevirtual 2248	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   215: putfield 1322	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Short	S
    //   218: aload_0
    //   219: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   222: aload 4
    //   224: ldc_w 2250
    //   227: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: putfield 395	com/tencent/mobileqq/troopinfo/TroopInfoData:f	Ljava/lang/String;
    //   233: aload_0
    //   234: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   237: aload 4
    //   239: ldc_w 2252
    //   242: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 2086	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_p_of_type_JavaLangString	Ljava/lang/String;
    //   248: aload_0
    //   249: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   252: aload 4
    //   254: ldc_w 2254
    //   257: invokevirtual 2257	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   260: putfield 1320	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Long	J
    //   263: aload_0
    //   264: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   267: aload 4
    //   269: ldc_w 2259
    //   272: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   275: putfield 1581	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   282: aload 4
    //   284: ldc_w 2261
    //   287: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   290: putfield 1326	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_m_of_type_JavaLangString	Ljava/lang/String;
    //   293: aload_0
    //   294: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   297: aload 4
    //   299: ldc_w 2263
    //   302: invokevirtual 2267	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   305: i2s
    //   306: putfield 578	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Short	S
    //   309: aload_0
    //   310: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   313: aload_0
    //   314: aload_0
    //   315: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   318: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   321: invokestatic 2272	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 586	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_r_of_type_JavaLangString	Ljava/lang/String;
    //   327: aload_0
    //   328: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   331: aload 4
    //   333: ldc_w 2274
    //   336: invokevirtual 2225	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   339: invokestatic 2276	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   342: putfield 1625	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   345: aload_0
    //   346: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: aload 4
    //   351: ldc_w 2278
    //   354: invokevirtual 2225	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   357: putfield 1389	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_n_of_type_Int	I
    //   360: aload_0
    //   361: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   364: aload_0
    //   365: aload_0
    //   366: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   369: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   372: invokestatic 2280	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   375: putfield 588	com/tencent/mobileqq/troopinfo/TroopInfoData:s	Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: aload 4
    //   384: ldc_w 2282
    //   387: invokevirtual 2257	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   390: putfield 1998	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_b_of_type_Long	J
    //   393: aload_0
    //   394: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   397: aload 4
    //   399: ldc_w 2284
    //   402: invokevirtual 2257	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   405: putfield 2003	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_Long	J
    //   408: aload_0
    //   409: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   412: aload 4
    //   414: ldc_w 2286
    //   417: invokevirtual 2218	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: invokestatic 1987	com/tencent/mobileqq/data/TroopInfo:getTags	(Ljava/lang/String;)Ljava/util/List;
    //   423: putfield 1988	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   426: aload_0
    //   427: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   430: bipush 8
    //   432: invokevirtual 527	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   435: checkcast 1272	com/tencent/mobileqq/model/FriendManager
    //   438: astore 5
    //   440: aload 5
    //   442: ifnull +58 -> 500
    //   445: aload 5
    //   447: aload_0
    //   448: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   451: getfield 327	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   454: invokeinterface 1282 2 0
    //   459: astore 5
    //   461: aload 5
    //   463: ifnull +37 -> 500
    //   466: aload_0
    //   467: aload 5
    //   469: putfield 1270	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   472: aload_0
    //   473: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   476: iconst_1
    //   477: putfield 468	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_a_of_type_Boolean	Z
    //   480: aload_0
    //   481: getfield 214	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload 5
    //   486: aload_0
    //   487: invokevirtual 849	com/tencent/mobileqq/activity/ChatSettingForTroop:getResources	()Landroid/content/res/Resources;
    //   490: aload_0
    //   491: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   497: invokevirtual 2289	com/tencent/mobileqq/troopinfo/TroopInfoData:a	(Lcom/tencent/mobileqq/data/TroopInfo;Landroid/content/res/Resources;Ljava/lang/String;)V
    //   500: aload_0
    //   501: aload 4
    //   503: ldc 130
    //   505: iconst_m1
    //   506: invokevirtual 2221	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   509: putfield 249	com/tencent/mobileqq/activity/ChatSettingForTroop:az	I
    //   512: iconst_1
    //   513: ireturn
    //   514: astore 4
    //   516: invokestatic 682	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +14 -> 533
    //   522: ldc 57
    //   524: iconst_2
    //   525: aload 4
    //   527: invokevirtual 685	java/lang/Exception:toString	()Ljava/lang/String;
    //   530: invokestatic 688	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload_0
    //   534: getfield 318	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   537: bipush 69
    //   539: invokestatic 521	com/tencent/biz/common/report/BnrReport:a	(Lcom/tencent/common/app/AppInterface;I)V
    //   542: iload_1
    //   543: ireturn
    //   544: astore 4
    //   546: iconst_1
    //   547: istore_1
    //   548: goto -32 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	ChatSettingForTroop
    //   1	547	1	bool	boolean
    //   136	2	2	l1	long
    //   43	459	4	localBundle	Bundle
    //   514	12	4	localException1	Exception
    //   544	1	4	localException2	Exception
    //   438	47	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	137	514	java/lang/Exception
    //   143	440	544	java/lang/Exception
    //   445	461	544	java/lang/Exception
    //   466	500	544	java/lang/Exception
    //   500	512	544	java/lang/Exception
  }
  
  protected boolean a(View paramView)
  {
    if (paramView == null) {}
    while (paramView.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    super.doOnStart();
    if (!this.jdField_d_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_d_of_type_Boolean = true;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    TroopAvatarManger.jdField_a_of_type_Int = 0;
    c();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void b(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramView = (TextView)paramView.findViewById(2131297409);
    paramView.setEditableFactory(QQTextBuilder.a);
    paramView.setMovementMethod(LinkMovementMethod.getInstance());
    if (TextUtils.isEmpty(paramCharSequence)) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      paramView.setFocusable(false);
      return;
      paramView.setVisibility(0);
      paramView.setText(new QQText(paramCharSequence, 11));
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    startActivity(localIntent);
  }
  
  public void b(BatchResponse paramBatchResponse)
  {
    UniPacket localUniPacket;
    if (paramBatchResponse.seq == 3)
    {
      localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.setServantName("GroupPhoto");
      localUniPacket.setFuncName("GetLastPicReq");
    }
    try
    {
      localUniPacket.decode((byte[])paramBatchResponse.buffer);
      paramBatchResponse = (GetLastPicRsp)localUniPacket.getByClass("GetLastPicRsp", new GetLastPicRsp());
      if (paramBatchResponse != null)
      {
        if ((paramBatchResponse.vec_picurl != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.updateQZonePhotoUrls(paramBatchResponse.vec_picurl);
        }
        paramBatchResponse = (String)paramBatchResponse.exend.get("total_pic");
        if (TextUtils.isEmpty(paramBatchResponse)) {}
      }
    }
    catch (Throwable paramBatchResponse)
    {
      try
      {
        i1 = Integer.valueOf(paramBatchResponse).intValue();
        if (i1 > 0)
        {
          a(this.jdField_a_of_type_ArrayOfAndroidViewView[1], i1);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mQZonePhotoNum = i1;
          }
        }
        return;
        paramBatchResponse = paramBatchResponse;
        paramBatchResponse.printStackTrace();
      }
      catch (NumberFormatException paramBatchResponse)
      {
        for (;;)
        {
          paramBatchResponse.printStackTrace();
          int i1 = 0;
        }
      }
    }
  }
  
  protected void b(View paramView, int paramInt, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131299347);
    paramView = (TextView)paramView.findViewById(2131299348);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((this.av != 2) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)))
    {
      paramView.setVisibility(8);
      if (paramBoolean) {
        localImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localImageView.setVisibility(8);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    new dqj(this, paramString1, paramString2).start();
  }
  
  protected void broadcastRecieve(Intent paramIntent)
  {
    doOnNewIntent(paramIntent);
  }
  
  protected void c()
  {
    Object localObject = ((FriendsManagerImp)this.app.getManager(8)).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString));
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).mTroopPicList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          if (str != null)
          {
            localAvatarInfo.jdField_b_of_type_JavaLangString = str;
            if (localAvatarInfo.jdField_b_of_type_JavaLangString == "-5") {}
            for (localAvatarInfo.jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";; localAvatarInfo.jdField_c_of_type_JavaLangString = "AVATAR_URL_STR")
            {
              localArrayList.add(localAvatarInfo);
              break;
            }
          }
        }
      }
    }
    if (localArrayList.size() == 0)
    {
      localObject = new AvatarWallAdapter.AvatarInfo();
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString = "-5";
      ((AvatarWallAdapter.AvatarInfo)localObject).jdField_c_of_type_JavaLangString = "SYSTEM_PHOTO";
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList, 23, 0);
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("result");
    } while (Utils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString));
    if (NetworkUtil.e(getActivity()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString = paramIntent;
      d(16);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, getString(2131365730), 1000);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    ThreadManager.a(new drc(this));
    if (this.centerView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838130);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.centerView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131493201));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.app);
    z();
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    Object localObject;
    switch (paramInt1)
    {
    case 11: 
    default: 
    case 5: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          a(paramInt2, paramIntent);
        } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        ((TroopHandler)this.app.a(19)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        return;
        b(paramInt2, paramIntent);
        return;
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
        {
          paramIntent = new Intent();
          paramIntent.putExtra("isNeedFinish", true);
          setResult(-1, paramIntent);
          finish();
          return;
        }
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      } while (localObject == null);
      paramIntent = DBUtils.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a());
      if (paramIntent == null) {
        break;
      }
    }
    for (paramIntent = paramIntent.troopnick;; paramIntent = null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131297409);
      if ((!TextUtils.isEmpty(paramIntent)) && (!((TextView)localObject).getText().equals(paramIntent)))
      {
        ((TextView)localObject).setText(new QQText(paramIntent, 3));
        return;
      }
      if ((!TextUtils.isEmpty(paramIntent)) || (((TextView)localObject).getText().equals(paramIntent))) {
        break;
      }
      ((TextView)localObject).setText(new QQText(this.app.c(), 3));
      return;
      c(paramInt2, paramIntent);
      return;
      d(paramInt2, paramIntent);
      return;
      e(paramInt2, paramIntent);
      return;
      if (paramInt2 != -1) {
        break;
      }
      setResult(-1);
      this.jdField_j_of_type_Boolean = true;
      return;
      f(paramInt2, paramIntent);
      return;
      g(paramInt2, paramIntent);
      return;
      h(paramInt2, paramIntent);
      return;
      i(paramInt2, paramIntent);
      return;
      paramIntent = paramIntent.getStringExtra("result");
      if (TextUtils.equals(paramIntent, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {
        break;
      }
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString = paramIntent;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString;; paramIntent = getResources().getString(2131365797))
        {
          a(21, paramIntent, false);
          d(32);
          return;
        }
      }
      b(2131365730, 1);
      return;
      ((TroopHandler)this.app.a(19)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dqh(this, paramInt2, paramIntent), 100L);
      return;
      if ((paramInt2 != -1) || (AvatarWallAdapter.jdField_a_of_type_AndroidNetUri == null)) {
        break;
      }
      paramIntent = ImageUtil.c(this, AvatarWallAdapter.jdField_a_of_type_AndroidNetUri);
      paramInt1 = ProfileCardUtil.a(this);
      localObject = new Intent();
      ((Intent)localObject).putExtra("Business_Origin", 100);
      PhotoUtils.a((Intent)localObject, this, ChatSettingForTroop.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
      return;
      if ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1)) {
        break;
      }
      paramIntent = paramIntent.getExtras();
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString = paramIntent.getString("location");
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = paramIntent.getInt("lat", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = paramIntent.getInt("lon", 0);
      k();
      return;
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
    }
    int i1 = (SizeMeasure.e(this) - PublicAccountUtil.a(this, 128.0F) - getResources().getDimensionPixelSize(2131493199)) / 4;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setColumnWidth(i1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(i1);
    if (this.jdField_c_of_type_JavaUtilList != null) {
      a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        }
        a();
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
        }
        QZoneHelper.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        if (this.av != 1) {
          break label332;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
        {
          a("Grp_Admin_data", "Clk_data", "0");
          BnrReport.a(this.app, 65);
          return true;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
        }
        System.gc();
        finish();
        return false;
      }
      catch (InflateException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
        }
        System.gc();
        finish();
        return false;
      }
      a("Grp_Admin_data", "Clk_data", "1");
      continue;
      label332:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
        a("Grp_Visdata", "Clk_data", "0");
      } else {
        a("Grp_Visdata", "Clk_data", "1");
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver);
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          int i1 = 1;
          while (i1 < 12)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(i1);
            i1 += 1;
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label148;
        }
      }
      finally {}
      if (((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).isRunning()) {
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      }
      label148:
      this.jdField_a_of_type_AndroidOsHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
      this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = null;
      }
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      this.jdField_c_of_type_AndroidWidgetImageView = null;
      this.jdField_d_of_type_AndroidWidgetImageView = null;
      this.jdField_e_of_type_AndroidWidgetImageView = null;
      this.jdField_f_of_type_AndroidWidgetImageView = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
      }
      GroupCatalogTool.a(this).a();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper != null) {
        this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
        this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
        this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = null;
      }
      super.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onDestroy(), time = " + (System.currentTimeMillis() - l1));
      }
      return;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)
    {
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        str = (String)paramIntent.next();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(str);
        a("Grp_Admin_data", "upload_head", "");
      }
    }
    this.jdField_f_of_type_Boolean = true;
    paramIntent = (AccountManager)getAppRuntime().getManager(0);
    String str = TroopUtils.a(this.app);
    if (str == null)
    {
      paramIntent.updateSKey(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    new Thread(new dqb(this, str)).start();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = false;
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      TroopNotificationHelper.a(this.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      label62:
      b();
      TextView localTextView;
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[26] != null)
      {
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[26].findViewById(2131297125);
        if (localTextView != null) {
          if (!ChatBackground.a(this, this.app.getAccount(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString)) {
            break label165;
          }
        }
      }
      label165:
      for (int i1 = 2131370020;; i1 = 2131370018)
      {
        localTextView.setText(i1);
        if (!ChatBackground.a(this, this.app.getAccount(), false)) {
          ((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[26].findViewById(2131300632)).b();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public void doOnStop() {}
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i()) {
      i1 = 0;
    }
    for (;;)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131297662);
      localObject = (ImageView)((View)localObject).findViewById(2131299344);
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      ((ImageView)localObject).setImageDrawable(a());
      ((ImageView)localObject).setContentDescription(String.format(getResources().getString(2131366203), new Object[] { Integer.valueOf(i1) }));
      return;
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent, this.app.a());
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    if ((this.av == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter != null)) {
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) || (this.av != 1)) {
        break label95;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
      v();
      return;
      label95:
      bool = false;
    }
  }
  
  protected void f(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    paramIntent = new Intent(this, ChatActivity.class);
    paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    paramIntent.putExtra("uintype", 1);
    paramIntent.putExtra("isNeedUpdate", this.jdField_j_of_type_Boolean);
    paramIntent.setFlags(67108864);
    startActivity(paramIntent);
    finish();
  }
  
  public void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.a(), 0);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
      if (localTroopHandler != null) {
        localTroopHandler.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
    }
    ThreadManager.a(new dpu(this));
  }
  
  protected void g(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        l();
      }
    }
    new dqg(this).start();
  }
  
  protected void h()
  {
    Intent localIntent = new Intent(this, TroopMemberCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("troopCode", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("memberUin", this.app.a());
    localIntent.putExtra("fromFlag", 2);
    startActivityForResult(localIntent, 2);
    ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a(), "", "");
  }
  
  protected void h(int paramInt, Intent paramIntent)
  {
    TextView localTextView = null;
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
      }
    }
    label262:
    do
    {
      return;
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
      paramIntent = (FriendManager)this.app.getManager(8);
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString))
      {
        if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent.Administrator, paramIntent.wMemberNum, this.app.a(), getResources());
          a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_h_of_type_JavaLangString, true);
        }
        View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
        if (localView == null) {
          break;
        }
        TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.app.a());
        paramIntent = localTextView;
        if (localTroopMemberInfo != null) {
          paramIntent = localTroopMemberInfo.troopnick;
        }
        localTextView = (TextView)localView.findViewById(2131297409);
        if ((TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent))) {
          break label262;
        }
        localTextView.setText(new QQText(paramIntent, 3));
        return;
      }
    } while ((!TextUtils.isEmpty(paramIntent)) || (localTextView.getText().equals(paramIntent)));
    localTextView.setText(new QQText(this.app.c(), 3));
  }
  
  protected void i()
  {
    startActivityForResult(TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0), 10);
    String str = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {
        str = "0";
      }
      for (;;)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "0", str, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean) {
          str = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void i(int paramInt, Intent paramIntent)
  {
    paramIntent = (FriendManager)this.app.getManager(8);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      if (paramIntent != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramIntent;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramIntent, getResources(), this.app.a());
      }
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131298599);
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131297661);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131297662);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131299344);
    paramIntent = ((View)localObject1).findViewById(2131299345);
    localObject1 = ((View)localObject1).findViewById(2131299346);
    Object localObject3 = this.app.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)3, 0);
    localObject3 = this.app.a((String)localObject3);
    if (localObject3 != null)
    {
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      this.jdField_g_of_type_Boolean = true;
    }
    localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f);
    localTextView2.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    localImageView.setImageDrawable(a());
    localObject2 = TroopInfoActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    localTextView1 = (TextView)((View)localObject1).findViewById(2131297001);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((View)localObject1).setVisibility(8);
      localObject1 = (TextView)paramIntent.findViewById(2131297001);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) {
        break label362;
      }
      paramIntent.setVisibility(8);
    }
    for (;;)
    {
      v();
      paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[21];
      localObject1 = (View)paramIntent.getParent();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString)) {
        break label381;
      }
      ((View)localObject1).setVisibility(0);
      b(21, 0, paramIntent, getString(2131366186), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString, false);
      return;
      ((View)localObject1).setVisibility(0);
      localTextView1.setText((CharSequence)localObject2);
      break;
      label362:
      paramIntent.setVisibility(0);
      ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
    }
    label381:
    ((View)localObject1).setVisibility(8);
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 11)) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int != 0))
    {
      localIntent = new Intent(this, NearbyTroopsLocationActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
      localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
      localIntent.putExtra("location_name", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
      localIntent.putExtra("from", 11);
      localIntent.putExtra("mode", 1);
      localIntent.putExtra("is_show_mapentry", false);
      NearbyTroopsLocationActivity.a(this, this.app, localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
    {
      Intent localIntent;
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString, 16);
  }
  
  public void j(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("del_list");
      if (localArrayList1 != null)
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator = localArrayList1.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ((localObject != null) && (AvatarTroopUtil.b((String)localObject)))
          {
            paramInt = Integer.parseInt((String)localObject);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
            if ((localObject != null) && (((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString != null) && (AvatarTroopUtil.b(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString))) {
              localArrayList2.add(Integer.valueOf(Integer.parseInt(((AvatarWallAdapter.AvatarInfo)localObject).jdField_b_of_type_JavaLangString)));
            }
          }
        }
        if (localArrayList2.size() > 0)
        {
          a("Grp_Admin_data", "del_head", "");
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAvatarManger.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 2, localArrayList2);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(localArrayList1);
      }
      paramInt = paramIntent.getIntExtra("default_avator_index", -1);
      if (paramInt != -1)
      {
        if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount())) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(paramInt);
        }
        QQToast.a(this, getString(2131367510), 1).b(getTitleBarHeight());
      }
    }
  }
  
  public void k()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localView = localView.findViewById(2131299345);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131297001)).setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
  }
  
  public void l()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
    if (localTroopHandler == null) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((FriendManager)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, (byte)1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwTimeStamp, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.chatopttroop", 2, localException.toString());
    return;
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
  }
  
  protected void m()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if (localObject != null) {
      a((View)localObject, 0, false);
    }
    new dql(this).start();
    localObject = new Intent();
    ((Intent)localObject).putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    if ((this.jdField_j_of_type_JavaLangString != null) && (!"".equals(this.jdField_j_of_type_JavaLangString.trim())))
    {
      ((Intent)localObject).putExtra("request_params", this.jdField_j_of_type_JavaLangString);
      ((Intent)localObject).putExtra("from", "3");
    }
    TroopQQBrowserHelper.a(this, (Intent)localObject, this.app.a());
  }
  
  protected void n()
  {
    if ((this.av == 2) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int = 0;
        DBUtils.a(this.app.a(), "troop_file_new", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_Int <= 0) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra(TroopProxyActivity.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      TroopProxyActivity.a(this, (Intent)localObject, 103);
      localObject = (QQAppInterface)getAppRuntime();
      if (localObject == null) {
        break;
      }
      a("Grp", "Clk_grpinfo_files", "0");
      if (QLog.isDevelopLevel()) {
        QLog.d("Clk_grpinfo_files", 4, "troopUin :" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      }
      BnrReport.a((AppInterface)localObject, 67);
      return;
    }
  }
  
  public void o()
  {
    boolean bool = ((FriendManager)this.app.getManager(8)).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setContentDescription(getString(2131363423));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 103) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(3, 0, 1);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finally {}
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    case 14: 
    case 15: 
    case 16: 
    default: 
      return;
    case 13: 
      c(paramBoolean);
      return;
    case 18: 
      e(paramBoolean);
      return;
    }
    d(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      paramView = null;
      if (!(paramView instanceof Integer)) {}
    }
    Object localObject1;
    label1604:
    label1735:
    Object localObject2;
    Object localObject3;
    switch (((Integer)paramView).intValue())
    {
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 29: 
    case 30: 
    default: 
    case 0: 
    case 9: 
    case 5: 
    case 7: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 26: 
    case 10: 
    case 27: 
    case 28: 
    case 11: 
    case 12: 
    case 31: 
    case 25: 
    case 8: 
    case 32: 
    case 20: 
    case 21: 
    case 22: 
    case 14: 
    case 23: 
    case 24: 
    case 33: 
      label2050:
      label2085:
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
                  paramView = paramView.getTag();
                  break;
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
                  {
                    QQToast.a(this, 2131363838, 1).b(getTitleBarHeight());
                    return;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {
                    i1 = 0;
                  }
                  for (;;)
                  {
                    paramView = String.format("https://web.qun.qq.com/mannounce/index.html?_wv=1031&_bid=148#gc=%s&role=%d&actionIcon=1", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, Integer.valueOf(i1) });
                    localObject1 = new Intent(this, QQBrowserActivity.class);
                    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
                    ((Intent)localObject1).putExtra("url", paramView);
                    ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
                    startActivity((Intent)localObject1);
                    this.jdField_e_of_type_Boolean = true;
                    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "Grp_data", "Clk_grpbulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                    ThreadManager.b(new dpv(this));
                    a("Grp_Admin_data", "Clk_notice", "");
                    return;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean) {
                      i1 = 1;
                    } else {
                      i1 = 2;
                    }
                  }
                  h();
                  return;
                  i();
                  a("Grp_Admin_data", "Clk_mber", "");
                  return;
                  g();
                  return;
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
                  {
                    QQToast.a(this, 2131363838, 1).b(getTitleBarHeight());
                    return;
                  }
                  E();
                  return;
                  if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
                  {
                    QQToast.a(this, 2131363838, 1).b(getTitleBarHeight());
                    return;
                  }
                  n();
                  return;
                  paramView = new Intent(this, QQBrowserActivity.class);
                  paramView.putExtra("url", String.format("https://xiaoqu.qq.com/cgi-bin/bar/jump?action=qun&from=card&gid=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString }));
                  paramView.putExtra("webStyle", "noBottomBar");
                  paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
                  startActivity(paramView);
                  a("Grp_data", "Clk_tribe", "");
                  return;
                  m();
                  a("Grp_Admin_data", "Clk_forum", "");
                  return;
                } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int) {
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800000) != 8388608L) {}
                for (i1 = 0;; i1 = 1)
                {
                  paramView = new Intent(this, PublicAccountBrowser.class);
                  paramView.putExtra("hide_operation_bar", true);
                  paramView.putExtra("hideRightButton", true);
                  paramView.putExtra("isScreenOrientationPortrait", true);
                  paramView.putExtra("uin", this.app.a());
                  paramView.putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_n_of_type_Int + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.o + "&show_level=" + i1);
                  startActivity(paramView);
                  ReportController.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                  BnrReport.a(this.app, 72);
                  return;
                }
                removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppTroopObserver);
                paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
                TroopInfoActivity.a(getActivity(), paramView, 5);
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
                  a("Grp_moredata", "Clk_moredata", "0");
                }
                for (;;)
                {
                  BnrReport.a(this.app, 68);
                  return;
                  a("Grp_moredata", "Clk_moredata", "1");
                }
                D();
                return;
                ReportController.b(null, "CliOper", "", "", "0X8006279", "0X8006279", 0, 0, "3", "", "", "");
                paramView = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[26].findViewById(2131300632);
                paramView.c();
                ChatBackground.a(this, this.app.getAccount(), false);
                if (this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow == null)
                {
                  this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(this);
                  this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370018, new dpw(this));
                  this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(2131370019, new dpx(this));
                }
                this.jdField_b_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView.a(), 0, 12, 12);
                ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
                return;
                B();
                return;
                b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean);
                return;
                G();
              } while (this.ax != 2);
              ReportController.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              return;
              q();
              return;
              paramView = new Intent(this, TroopManageActivity.class);
              paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
              paramView.putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_k_of_type_JavaLangString);
              paramView.putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int);
              paramView.putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int);
              startActivityForResult(paramView, 17);
              ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
              return;
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 19) {
                ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "recom", "Clk_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
              }
              while (!NetworkUtil.e(this))
              {
                b(2131365941, 0);
                return;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 18)
                {
                  ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_join", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 24)
                {
                  ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "search", "Clk_joingrp", 0, 0, "", "", "", "");
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int == 17)
                {
                  ReportController.b(this.app, "CliOper", "", "", "Grp_recommend", "viewinfor_joingrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
                }
                else
                {
                  i1 = -1;
                  int i2;
                  switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Int)
                  {
                  default: 
                    i2 = i1;
                    if (i1 == -1)
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Int != 7) {
                        break label1735;
                      }
                      i2 = 3;
                    }
                    break;
                  }
                  for (;;)
                  {
                    ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_joingrp", i2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.aB + "", "", this.aA + "");
                    break;
                    i1 = 0;
                    break label1604;
                    i1 = 1;
                    break label1604;
                    i1 = 2;
                    break label1604;
                    i1 = 6;
                    break label1604;
                    i1 = 7;
                    break label1604;
                    i2 = i1;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Int == 8) {
                      i2 = 4;
                    }
                  }
                }
              }
              paramView = (TroopHandler)this.app.a(19);
            } while (paramView == null);
            try
            {
              long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
              r();
              paramView.a(l1, 8388736);
              return;
            }
            catch (Exception paramView) {}
          } while (!QLog.isColorLevel());
          QLog.i("Q.chatopttroop", 2, paramView.toString());
          return;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList;
          localObject1 = new Intent(this, TroopTagViewActivity.class);
          ((Intent)localObject1).putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("isAdmin", false);
          paramView = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long);
          localObject3 = GroupCatalogTool.a(this).a(this, paramView);
          i1 = 0;
          if ((localObject3 != null) && (!TextUtils.isEmpty(((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString)))
          {
            paramView = "";
            if ((!"其他".equals(((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString)) && (((GroupCatalogBean)localObject3).jdField_a_of_type_Int != 1)) {
              break label2050;
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_JavaLangString)) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_j_of_type_JavaLangString;
            }
          }
          for (i1 = 1;; i1 = 1)
          {
            if (i1 != 0) {
              ((Intent)localObject1).putExtra("subclass", paramView);
            }
            if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
              break label2085;
            }
            paramView = new StringBuffer();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              paramView.append((String)localObject3 + "\n");
            }
            paramView = ((GroupCatalogBean)localObject3).jdField_a_of_type_JavaLangString;
          }
          paramView.deleteCharAt(paramView.length() - 1);
          ((Intent)localObject1).putExtra("tags", paramView.toString());
          ((Intent)localObject1).putExtra("act_type", 1);
          ((Intent)localObject1).putExtra("uin", this.app.a());
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e()) {
            startActivityForResult((Intent)localObject1, 13);
          }
          for (;;)
          {
            a("Grp_Visdata", "nonmber_Clk_tag", "");
            BnrReport.a(this.app, 71);
            return;
            startActivity((Intent)localObject1);
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e());
        a(12, 900, 2131366186, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_JavaLangString, true, 1, true);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean)
        {
          a("Grp_Admin_data", "Clk_brief", "0");
          return;
        }
        a("Grp_Admin_data", "Clk_brief", "1");
        return;
        t();
        return;
        j();
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        a("Grp_Admin_data", "Clk_share", "");
        return;
        paramView = new Intent(this, Face2FaceAddFriendActivity.class);
        paramView.putExtra("activity_from_type", 1);
        paramView.putExtra("activity_troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        startActivity(paramView);
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "share_grp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "5.9.3", "", "");
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
      } while (paramView == null);
      localObject1 = new Intent();
      ((Intent)localObject1).setClass(this, TroopAvatarWallPreviewActivity.class);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("index", 0);
      localObject3 = new ArrayList();
      if (((paramView.jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (paramView.jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (paramView.jdField_a_of_type_JavaLangString == null)) {
        ((ArrayList)localObject3).add(paramView.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        ((Bundle)localObject2).putBoolean("IS_EDIT", false);
        ((Bundle)localObject2).putStringArrayList("seqNum", (ArrayList)localObject3);
        ((Bundle)localObject2).putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject2).putBoolean("troop_info_is_member", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        startActivityForResult((Intent)localObject1, 14);
        return;
        ((ArrayList)localObject3).add(paramView.jdField_a_of_type_JavaLangString);
      }
    }
    label2591:
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        localObject1 = "0";
        paramView = "Grp_Visdata";
        localObject2 = "";
        if (this.av == 1)
        {
          localObject3 = "Grp_Admin_data";
          if (!this.jdField_h_of_type_Boolean) {
            break label2822;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int != 0) {
            break label2815;
          }
          paramView = "2";
          localObject2 = paramView;
          paramView = (View)localObject3;
        }
        ReportController.b(this.app, "P_CliOper", "Grp_set", "", paramView, "Clk_ac", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (String)localObject1, (String)localObject2, "");
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int = 0;
        paramView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int == 0) {
          break label2829;
        }
        bool = true;
        label2662:
        a(paramView, 0, bool);
        DBUtils.a(this.app.a(), "group_activity_new_message", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_m_of_type_Int);
        ThreadManager.a(new dpy(this));
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;
        localObject2 = this.app.getSid();
        if (this.av != 1) {
          break label2835;
        }
      }
    }
    label2822:
    label2829:
    label2835:
    for (int i1 = 0;; i1 = 1)
    {
      paramView.putExtra("url", String.format("https://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&groupuin=%1$s&sid=%2$s&entersource=%3$d", new Object[] { localObject1, localObject2, Integer.valueOf(i1) }));
      startActivity(paramView);
      return;
      localObject1 = "1";
      break;
      localObject1 = "2";
      break;
      label2815:
      paramView = "1";
      break label2591;
      paramView = "0";
      break label2591;
      bool = false;
      break label2662;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      switch (((Integer)localObject).intValue())
      {
      }
    }
    for (;;)
    {
      return false;
      try
      {
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131302484, getString(2131367603));
        BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, new dpz(this), new dqa(this));
      }
      catch (WindowManager.BadTokenException paramView) {}
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, paramView.getMessage());
      }
    }
  }
  
  public void p()
  {
    boolean bool = ((TroopInfoManager)this.app.getManager(36)).c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[17];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setContentDescription(getString(2131364010));
    }
  }
  
  protected void q()
  {
    Intent localIntent = new Intent(this, PublicAccountBrowser.class);
    localIntent.putExtra("url", "https://web.qun.qq.com/statistics/index.html?_bid=149&_wv=3&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    super.startActivity(localIntent);
  }
  
  public void r()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131367583);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void s()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void t()
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = (oidb_0x899.memberlist)this.jdField_c_of_type_JavaUtilList.get(i1);
      if ((localObject == null) || (!((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {}
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList.add(String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()));
      }
    }
    Object localObject = new Intent(this, TroopAdminList.class);
    ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_p_of_type_JavaLangString);
    ((Intent)localObject).putStringArrayListExtra("troop_info_memo", localArrayList);
    startActivity((Intent)localObject);
  }
  
  public void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "updateTroopInfoToDB");
      }
      ThreadManager.b(new dqq(this));
    }
  }
  
  protected void v()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
    if ((localObject1 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131297661);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = " ";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Long & 0x800) != 0L)
      {
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 2L) {
          localObject1 = getResources().getDrawable(2130838652);
        }
        while (localObject1 != null)
        {
          int i1 = Util.a(this, 7.0F);
          ((Drawable)localObject1).setBounds(i1, 0, Util.a(this, 15.0F) + i1, Util.a(this, 15.0F));
          SpannableString localSpannableString = new SpannableString((String)localObject2 + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject1, 1), ((String)localObject2).length(), ((String)localObject2).length() + 1, 17);
          localTextView.setText(localSpannableString);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Long == 1L) {
            localObject1 = getResources().getDrawable(2130839096);
          }
        }
      }
    }
  }
  
  public void w()
  {
    GroupCatalogTool.a(this).a(new ChatSettingForTroop.GetClassChoiceCallBack(this), this);
  }
  
  public void x()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    for (;;)
    {
      return;
      ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[15].findViewById(2131298599);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(0);
      if (localObject1 != null)
      {
        label70:
        Object localObject3;
        if (((((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "AVATAR_URL_STR") || (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_c_of_type_JavaLangString == "SYSTEM_PHOTO")) && (((AvatarWallAdapter.AvatarInfo)localObject1).jdField_a_of_type_JavaLangString == null))
        {
          localObject1 = ((AvatarWallAdapter.AvatarInfo)localObject1).jdField_b_of_type_JavaLangString;
          localObject3 = localObject1;
          if (AvatarTroopUtil.b((String)localObject1))
          {
            if ((localObject1 == null) || (!((String)localObject1).equals("-5"))) {
              break label208;
            }
            localObject1 = AvatarTroopUtil.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 0);
            label106:
            localObject3 = AvatarTroopUtil.a((String)localObject1);
          }
        }
        label321:
        try
        {
          localObject1 = Uri.parse((String)localObject3);
          localObject1 = ((Uri)localObject1).getScheme();
          Object localObject2;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((!((String)localObject1).equals("http")) && (!((String)localObject1).equals("https"))))
          {
            try
            {
              localObject1 = BitmapFactory.decodeFile((String)localObject3);
              if ((localObject1 == null) || (this.app == null)) {
                continue;
              }
              localObject3 = this.app.a((Bitmap)localObject1, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
              if (!((Bitmap)localObject1).isRecycled()) {
                ((Bitmap)localObject1).recycle();
              }
              localImageView.setImageBitmap((Bitmap)localObject3);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              return;
            }
            localObject2 = localOutOfMemoryError1.jdField_a_of_type_JavaLangString;
            break label70;
            label208:
            localObject2 = AvatarTroopUtil.a((String)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 1);
            break label106;
          }
          try
          {
            localObject2 = new URL((String)localObject3);
            localObject2 = URLDrawable.getDrawable((URL)localObject2, URLDrawableHelper.d, null, true);
            if (((URLDrawable)localObject2).getStatus() != 1) {
              break label321;
            }
            try
            {
              localObject2 = ImageUtil.a((Drawable)localObject2);
              if ((localObject2 == null) || (this.app == null)) {
                continue;
              }
              localObject3 = this.app.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
              if (!((Bitmap)localObject2).isRecycled()) {
                ((Bitmap)localObject2).recycle();
              }
              localImageView.setImageBitmap((Bitmap)localObject3);
              return;
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              return;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (MalformedURLException localMalformedURLException) {}
          QLog.i("Q.chatopttroop", 2, localMalformedURLException.toString());
          return;
        }
        catch (NullPointerException localNullPointerException) {}
        localMalformedURLException.setURLDrawableListener(new dqy(this, localImageView));
        if (localMalformedURLException.getStatus() == 1) {
          try
          {
            Bitmap localBitmap = ImageUtil.a(localMalformedURLException);
            if (localBitmap != null)
            {
              localObject3 = this.app.a(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
              localBitmap.recycle();
              localImageView.setImageBitmap((Bitmap)localObject3);
              return;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[15];
      } while (localObject == null);
      localObject = (TextView)((View)localObject).findViewById(2131299343);
    } while (localObject == null);
    ((TextView)localObject).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 1)
    {
      ((TextView)localObject).setText(2131363427);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 0)
    {
      ((TextView)localObject).setText(2131363428);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 2)
    {
      ((TextView)localObject).setText(2131363429);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_r_of_type_Int == 4))
    {
      ((TextView)localObject).setText(2131363429);
      return;
    }
    ((TextView)localObject).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */