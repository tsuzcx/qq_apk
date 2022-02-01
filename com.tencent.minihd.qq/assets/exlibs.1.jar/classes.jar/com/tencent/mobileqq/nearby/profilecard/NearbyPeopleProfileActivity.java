package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import jhn;
import jho;
import jhp;
import jhq;
import jhr;
import jht;
import jhz;
import jia;
import jib;
import jic;
import jid;
import jie;
import jif;
import jig;
import jii;
import jij;
import jik;
import jil;
import jim;
import jin;
import jio;

public class NearbyPeopleProfileActivity
  extends BaseActivity
  implements ViewStub.OnInflateListener
{
  public static final int a = 1;
  public static final String a = "Q.nearby_people_card.";
  public static final int b = 2;
  static final long jdField_b_of_type_Long = 20000L;
  public static final String b = "param_mode";
  public static final int c = 3;
  public static final String c = "param_tiny_id";
  public static final int d = 4;
  public static final String d = "AllInOne";
  public static final int e = 5;
  public static final String e = "param_dating_id";
  public static final int f = 8;
  public static final String f = "param_dating_subject";
  public static final int g = 6;
  public static final String g = "param_dating_pub";
  public static final int h = 7;
  public static final String h = "param_no_miss";
  public static final int i = 1;
  public static final String i = "param_xuan_yan";
  public static final int j = 2;
  public static final String j = "param_nickname";
  public static final int k = 3;
  public static final String k = "param_gender";
  public static final int l = -1;
  public static final String l = "param_age";
  public static final int m = 12;
  public static final String m = "param_career";
  public static final int n = 640;
  public static final String n = "param_constellation";
  public static final String o = "param_marital_status";
  public static final String p = "param_photo_count";
  public static final String q = "is_change_head";
  public static final String r = "140";
  public static final int s = 1;
  public static final String s = "250";
  static final int u = 1000;
  static final int v = 1001;
  public static final String v = "abp_flag";
  private static final int w = 100;
  public static final String w = "is_from_web";
  private static final int x = 101;
  public static final String x = "frome_where";
  private static final int y = 1000;
  private static final int jdField_z_of_type_Int = 102;
  static final String jdField_z_of_type_JavaLangString = "plus";
  private int A;
  float jdField_a_of_type_Float;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  public Handler a;
  public View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public ProfileActivity.AllInOne a;
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new jht(this);
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new jii(this);
  public ConditionSearchManager a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new jhr(this);
  protected TroopObserver a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new jhz(this);
  public NearbyPeopleProfileActivity.PicInfo a;
  private NearbyProfileDisplayPanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel;
  private NearbyProfileEditPanel jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel;
  StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ArrayList a;
  public boolean a;
  private Dialog jdField_b_of_type_AndroidAppDialog = null;
  private View jdField_b_of_type_AndroidViewView;
  private ConditionSearchManager.IConfigListener jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new jia(this);
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  public boolean b;
  public boolean c;
  public boolean d = false;
  public boolean e = true;
  boolean f = false;
  public boolean g = false;
  public boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  public int o;
  public int p;
  public int q;
  public int r = 0;
  public int t;
  String t;
  public String u;
  public String y;
  
  public NearbyPeopleProfileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new jij(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new jib(this);
  }
  
  public static void a(Context paramContext, ProfileActivity.AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
      localIntent.putExtra("AllInOne", paramAllInOne);
      localIntent.putExtras(paramBundle);
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
  
  private void e()
  {
    this.o = 2;
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(300L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(300L);
    localAlphaAnimation1.setAnimationListener(new jhp(this));
    localAlphaAnimation2.setAnimationListener(new jhq(this));
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation2);
  }
  
  private void f()
  {
    g();
    ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if ((getIntent() != null) && (getIntent().getBooleanExtra("param_no_miss", false))) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
    Intent localIntent = new Intent(this, NearbyActivity.class);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    overridePendingTransition(2130968589, 2130968591);
    finish();
  }
  
  private void g()
  {
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
    localNearPeopleFilters.i = -1;
    NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a(), localNearPeopleFilters);
    this.r = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  private void h()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 0, paramInt, 2131369842, 2131369843, new jik(this), new jil(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(long paramLong)
  {
    this.o = 1;
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(paramLong);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(paramLong);
    localAlphaAnimation1.setAnimationListener(new jio(this));
    localAlphaAnimation2.setAnimationListener(new jho(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation1);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel = new NearbyProfileEditPanel(this, this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation2);
    h();
  }
  
  void a(NearbyPeopleProfileActivity.PicInfo paramPicInfo)
  {
    if (paramPicInfo == null) {
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    localUserInfo.b = this.app.c();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString))
    {
      localPhotoInfo.c = paramPicInfo.jdField_a_of_type_JavaLangString;
      localArrayList.add(localPhotoInfo);
    }
    localBundle.putSerializable("picturelist", localArrayList);
    localBundle.putInt("curindex", 0);
    localBundle.putInt("mode", 6);
    QZoneHelper.b(this, localUserInfo, localBundle, 6);
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    ThreadManager.a(new jif(this, paramString2, paramInt, paramString1, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.c(2131365396);
    localActionSheet.c(2131365397);
    localActionSheet.e(2131365736);
    localActionSheet.a(new jid(this, paramBoolean, localActionSheet));
    localActionSheet.show();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b = paramArrayOfByte;
    runOnUiThread(new jic(this));
  }
  
  boolean a(String paramString)
  {
    Setting localSetting = (Setting)this.app.a().createEntityManager().a(Setting.class, paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      if ((localSetting.bFaceFlags & 0x20) != 0) {
        this.t = 0;
      }
      for (;;)
      {
        this.y = localSetting.url;
        if ((this.t == 640) && (!TextUtils.isEmpty(this.y))) {
          a(paramString, this.t, this.y, false);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "get setting info from db, headWidth is: " + this.t + " getHeadUrl is: " + this.y);
        }
        return true;
        if ((localSetting.bFaceFlags & 0x10) != 0) {
          this.t = 640;
        } else if ((localSetting.bFaceFlags & 0x8) != 0) {
          this.t = 140;
        } else if ((localSetting.bFaceFlags & 0x4) != 0) {
          this.t = 100;
        } else {
          this.t = 40;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "get setting info from db null, to get setting info from server.");
    }
    this.app.d(paramString);
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 2131369845, 2131369846, 2131365736, 2131369847, new jim(this), new jin(this));
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!isFinishing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void b(int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.a();
    localUserInfo.b = this.app.c();
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        PhotoInfo localPhotoInfo = new PhotoInfo();
        if (localPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)
        {
          if (StringUtil.b(localPicInfo.jdField_a_of_type_JavaLangString)) {
            break label141;
          }
          localPhotoInfo.c = localPicInfo.jdField_a_of_type_JavaLangString;
          localArrayList.add(localPhotoInfo);
        }
        for (;;)
        {
          i1 += 1;
          break;
          label141:
          if (!StringUtil.b(localPicInfo.c))
          {
            localPhotoInfo.c = localPicInfo.c;
            localArrayList.add(localPhotoInfo);
          }
        }
      }
      localBundle.putSerializable("picturelist", localArrayList);
      localBundle.putInt("curindex", paramInt);
      localBundle.putInt("mode", 6);
      QZoneHelper.b(this, localUserInfo, localBundle, 6);
    }
  }
  
  public void b(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.A);
  }
  
  public void c()
  {
    if (getIntent() == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if (getIntent().getIntExtra("param_mode", 0) == 1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.i = false;
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(new ArrayList());
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      f();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      if ((getIntent().getIntExtra("param_mode", 0) == 2) && (this.o == 1)) {
        e();
      }
    }
  }
  
  void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (this.k)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "refreshStangerFace.");
    }
    this.k = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new jig(this), 100L);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.o == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if ((!this.app.isLogin()) || (getIntent() == null))
    {
      finish();
      return false;
    }
    setContentView(2130903960);
    getWindow().setBackgroundDrawable(null);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.A = getTitleBarHeight();
    this.p = ((int)(this.jdField_a_of_type_Float * 70.0F + 0.5D));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(57));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "passed allinone is null!!");
        }
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "getIntent() exception:" + paramBundle.getMessage());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo = new NearbyPeopleProfileActivity.PicInfo();
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo.jdField_a_of_type_JavaLangString = "plus";
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo.b = "plus";
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo.c = "plus";
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
      this.o = getIntent().getIntExtra("param_mode", 0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131300207);
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131299331));
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
      if (this.o != 1) {
        break label608;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel = new NearbyProfileEditPanel(this, this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.h();
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.a, 2131365941, 0).b(this.A);
    }
    for (;;)
    {
      this.r = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.g = getIntent().getBooleanExtra("abp_flag", false);
      this.h = getIntent().getBooleanExtra("is_from_web", false);
      if ((this.h) && (!this.g)) {}
      paramBundle = (DatingManager)this.app.getManager(67);
      if ((paramBundle != null) && (paramBundle.a().a() > 0)) {
        paramBundle.a().b();
      }
      if (getIntent().getIntExtra("frome_where", 0) == 1)
      {
        String str = getIntent().getStringExtra("PUSH_CONTENT");
        paramBundle = str;
        if (str == null) {
          paramBundle = "";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, paramBundle, "", "", "");
      }
      return true;
      label608:
      paramBundle = getIntent();
      this.jdField_a_of_type_Long = paramBundle.getLongExtra("param_tiny_id", 0L);
      this.u = paramBundle.getStringExtra("param_dating_id");
      this.q = paramBundle.getIntExtra("param_dating_subject", 0);
      this.c = paramBundle.getBooleanExtra("param_dating_pub", false);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel = new NearbyProfileDisplayPanel(this, this.jdField_a_of_type_AndroidViewView);
      ThreadManager.a().post(new jhn(this));
      break;
      a("正在加载...");
      if (this.o == 3)
      {
        if (this.jdField_a_of_type_Long > 0L) {
          NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, this.jdField_a_of_type_Long, null);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 75) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b != null) || (TextUtils.isEmpty(this.u))) {
            break label831;
          }
          this.app.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
          ThreadManager.a().post(new jie(this));
          break;
          if (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
            NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, 0L, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
      }
      else
      {
        label831:
        NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler, this.app, 0L, this.app.a());
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_b_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a();
    }
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = (NearbyPeoplePhotoUploadProcessor)this.app.a().a(null, 0L);
    if (localNearbyPeoplePhotoUploadProcessor != null) {
      localNearbyPeoplePhotoUploadProcessor.r();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    for (;;)
    {
      return;
      if (this.o == 1)
      {
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        boolean bool = paramIntent.getBooleanExtra("is_change_head", false);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "doOnNewIntent isChangeHead: " + bool);
        }
        if ((localArrayList == null) || (localArrayList.size() <= 0)) {
          break;
        }
        if (bool)
        {
          paramIntent = new NearbyPeopleProfileActivity.PicInfo();
          paramIntent.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(0));
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramIntent);
          return;
        }
        int i1 = 0;
        while (i1 < localArrayList.size())
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() < 13)
          {
            paramIntent = new NearbyPeopleProfileActivity.PicInfo();
            paramIntent.jdField_a_of_type_JavaLangString = ((String)localArrayList.get(i1));
            if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a(paramIntent)) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 1000L);
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((this.o == 2) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.b())) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileDisplayPanel.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.g) {
      overridePendingTransition(2130968589, 2130968591);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    int i1 = 0;
    if (getIntent() != null) {
      i1 = getIntent().getIntExtra("param_mode", 0);
    }
    if (i1 == 1)
    {
      a(2131369840);
      return true;
    }
    if ((i1 == 2) && (this.o == 1))
    {
      if (this.r == 0)
      {
        a(2131369840);
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a() > 0) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a()) || (this.jdField_b_of_type_Boolean))
      {
        a(2131369841);
        return true;
      }
      c();
      return true;
    }
    if (this.g)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.g);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */