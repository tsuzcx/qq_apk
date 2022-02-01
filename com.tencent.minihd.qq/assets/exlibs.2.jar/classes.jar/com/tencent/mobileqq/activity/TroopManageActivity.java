package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.CommUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import fhs;
import fht;
import fhv;
import fhw;
import fhx;
import java.util.ArrayList;
import java.util.List;

public class TroopManageActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final long jdField_a_of_type_Long = 1073741824L;
  public static final String a = "Q.troopmanage";
  public static final int b = 2;
  public static final int c = 4;
  public static final String c = "key_is_need_update_Group_info";
  protected static final int d = 0;
  protected static final int e = 1;
  protected static final int f = 2;
  protected static final int g = 3;
  protected static final int h = 4;
  protected static final int i = 5;
  protected static final int j = 6;
  protected static final int k = 7;
  protected static final int l = 8;
  protected static final int m = 9;
  protected static final int n = 10;
  protected static final int o = 11;
  private View jdField_a_of_type_AndroidViewView;
  protected LinearLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new fhv(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new fht(this);
  public TroopInfo a;
  public TroopInfoData a;
  public QQProgressNotifier a;
  public List a;
  public boolean a;
  public View[] a;
  private View b;
  public String b;
  private View c;
  private String d;
  private String e;
  private String f = "https://qinfo.clt.qq.com/qinfo_mobile/in.html?_wv=2098183&_bid=2033&groupuin=%1$s&from=grpmanage";
  private final String g = "https://pub.idqqimg.com/pc/misc/admin/group/menu/admin_grp_stat_menu";
  private final String h = "GoupStatisticsUrl";
  private final String i = "GoupStatisticsTitle";
  public int p = 0;
  public int q = 0;
  
  public TroopManageActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaLangString = "199";
    this.jdField_e_of_type_JavaLangString = ("https://imgcache.qq.com/club/client/group/release/index.html?_bid=" + this.jdField_d_of_type_JavaLangString + "&pvsrc=troopManage&sid=%1$s&groupId=%2$s&_wv=5123");
    this.jdField_a_of_type_Boolean = false;
  }
  
  private int a()
  {
    int i1 = 0;
    int i3 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator)) {
      return i3;
    }
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.split("\\|");
    int i4 = arrayOfString.length;
    int i2 = 0;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      i3 = i1;
      if (!TextUtils.isEmpty(arrayOfString[i2])) {
        i3 = i1 + 1;
      }
      i2 += 1;
      i1 = i3;
    }
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131366343);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131366344);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n = getString(2131366345);
    }
  }
  
  private void a(int paramInt, View paramView, String paramString, CharSequence paramCharSequence)
  {
    paramView.setBackgroundResource(2130838103);
    TextView localTextView = (TextView)paramView.findViewById(2131297001);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localTextView.setText(str);
    paramString = (TextView)paramView.findViewById(2131297409);
    paramView = paramCharSequence;
    if (paramCharSequence == null) {
      paramView = "";
    }
    paramString.setText(paramView);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131297409);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2130904056, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      LinearLayout localLinearLayout = Utils.a(this);
      Utils.a(this, localLinearLayout, true);
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130904047, null);
      localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localLinearLayout);
    }
    this.jdField_a_of_type_AndroidViewView.setTag(paramString2);
    a(0, this.jdField_a_of_type_AndroidViewView, paramString1, "");
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new fhx(this));
    if (this.c == null)
    {
      this.c = View.inflate(this, 2130904056, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
    }
  }
  
  private void b()
  {
    if ((3 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r) || (4 == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131364175);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void b(int paramInt)
  {
    if ((paramInt & 0x3F) > 0) {}
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.app.a(19);
      if (localTroopHandler != null)
      {
        localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m, paramInt);
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
      QLog.i("Q.troopmanage", 2, localException.toString());
    }
  }
  
  private void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = getString(2131366343);
    arrayOfString[1] = getString(2131366344);
    arrayOfString[2] = getString(2131366345);
    localActionSheet.a(arrayOfString[0], false);
    localActionSheet.a(arrayOfString[1], false);
    localActionSheet.a(arrayOfString[2], false);
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Short)
    {
    }
    for (;;)
    {
      localActionSheet.a(new fhs(this, localActionSheet));
      localActionSheet.e(2131365736);
      localActionSheet.show();
      return;
      localActionSheet.f(0);
      continue;
      localActionSheet.f(1);
      continue;
      localActionSheet.f(2);
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
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void d()
  {
    CommUtils.a("https://pub.idqqimg.com/pc/misc/admin/group/menu/admin_grp_stat_menu", new fhw(this));
  }
  
  private void e()
  {
    String str1 = SharePreferenceUtils.a(this, this.app.a() + "_" + "GoupStatisticsTitle");
    String str2 = SharePreferenceUtils.a(this, this.app.a() + "_" + "GoupStatisticsUrl");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      a(str1, str2);
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)this.jdField_a_of_type_AndroidViewView.getParent());
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (this.c != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.c);
      this.c = null;
    }
  }
  
  protected void a()
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
    QLog.i("Q.troopmanage", 2, localException.toString());
    return;
    localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, (byte)1, 0L, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a());
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence)
  {
    paramView.setTag(Integer.valueOf(paramInt1));
    paramView.setOnClickListener(this);
    a(paramInt2, paramView, paramString, paramCharSequence);
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    TextView localTextView = null;
    Object localObject = localTextView;
    if (paramInt >= 0)
    {
      localObject = localTextView;
      if (paramInt < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt];
      }
    }
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      localTextView = (TextView)((View)localObject).findViewById(2131297409);
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    i1 = 1;
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("troop_uin");
    localObject1 = getIntent().getStringExtra("forward_location");
    i2 = getIntent().getIntExtra("forward_latitude", 0);
    i3 = getIntent().getIntExtra("forward_longitude", 0);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      i1 = 0;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        i1 = 0;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramBundle.a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
        {
          i1 = 0;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.app.a());
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int = i2;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int = i3;
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt;
          continue;
          paramBundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903353, null);
          localObject1 = (XListView)paramBundle.findViewById(2131297158);
          ((XListView)localObject1).setVerticalScrollBarEnabled(false);
          ((XListView)localObject1).setDivider(null);
          ((XListView)localObject1).setFocusable(false);
          this.jdField_a_of_type_ArrayOfAndroidViewView = new View[11];
          this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
          Object localObject2 = new AbsListView.LayoutParams(-1, -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
          ((XListView)localObject1).setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout));
          setContentView(paramBundle);
          setTitle(getString(2131367862));
          paramBundle = new View(this);
          localObject1 = new LinearLayout.LayoutParams(-1, Utils.a(this, 16.0F));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
          paramBundle = Utils.a(this);
          Utils.a(this, paramBundle, true);
          localObject1 = View.inflate(this, 2130904047, null);
          paramBundle.addView((View)localObject1);
          a(5, 0, (View)localObject1, getString(2131366367), "");
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131297409));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          paramBundle = View.inflate(this, 2130904056, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
          paramBundle = Utils.a(this);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
          {
            localObject1 = View.inflate(this, 2130904047, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject1;
            paramBundle.addView((View)localObject1);
            a(1, 1, (View)localObject1, getString(2131367864), "" + a());
            paramBundle.addView(Utils.a(this));
          }
          localObject1 = View.inflate(this, 2130904047, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[3] = localObject1;
          paramBundle.addView((View)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
          {
            a(3, 2, (View)localObject1, getString(2131367866), "");
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Boolean))
            {
              paramBundle.addView(Utils.a(this));
              localObject1 = View.inflate(this, 2130904047, null);
              this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject1;
              paramBundle.addView((View)localObject1);
              a(2, 3, (View)localObject1, getString(2131367865), "");
              localObject1 = (TextView)((View)localObject1).findViewById(2131297409);
              if (((((TroopManager)this.app.getManager(50)).a() & 0x1) == 0) && ("5.5.0".equals("5.9.3")))
              {
                ((TextView)localObject1).setText(2131364007);
                ((TextView)localObject1).setTextSize(12.0F);
                ((TextView)localObject1).setTextColor(getResources().getColor(2131427966));
                ((TextView)localObject1).setBackgroundResource(2130841956);
                ((TextView)localObject1).setVisibility(0);
                ((TextView)localObject1).setContentDescription(getResources().getString(2131364008));
              }
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            paramBundle = View.inflate(this, 2130904056, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)) {
              break label1310;
            }
            i1 = 1;
            paramBundle = Utils.a(this);
            localObject1 = View.inflate(this, 2130904047, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
            paramBundle.addView((View)localObject1);
            if (i1 == 0) {
              break label1315;
            }
            i2 = 1;
            a(4, i2, (View)localObject1, getString(2131367868), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.n);
            if (i1 != 0)
            {
              paramBundle.addView(Utils.a(this));
              localObject1 = View.inflate(this, 2130904047, null);
              this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
              paramBundle.addView((View)localObject1);
              a(7, 3, (View)localObject1, getString(2131367869), "");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r != 2)
            {
              paramBundle.addView(Utils.a(this));
              localObject1 = View.inflate(this, 2130904047, null);
              this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
              paramBundle.addView((View)localObject1);
              a(10, 3, (View)localObject1, getString(2131367871), "");
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            paramBundle = View.inflate(this, 2130904056, null);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            paramBundle = Utils.a(this);
            Utils.a(this, paramBundle, true);
            localObject1 = View.inflate(this, 2130904051, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
            localObject2 = (FormSwitchItem)((View)localObject1).findViewById(2131300632);
            ((FormSwitchItem)localObject2).setText(getResources().getString(2131363834));
            ((FormSwitchItem)localObject2).setContentDescription(getResources().getString(2131363835));
            ((FormSwitchItem)localObject2).setBgType(0);
            localObject2 = ((FormSwitchItem)localObject2).a();
            ((Switch)localObject2).setTag(Integer.valueOf(8));
            ((Switch)localObject2).setOnCheckedChangeListener(null);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt & 0x40000000) == 0L) {
              break label1320;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((Switch)localObject2).setChecked(bool);
            ((Switch)localObject2).setOnCheckedChangeListener(this);
            localObject2 = (TextView)((View)localObject1).findViewById(2131300633);
            ((TextView)localObject2).setText(getResources().getString(2131363835));
            ((TextView)localObject2).setFocusable(false);
            paramBundle.addView((View)localObject1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramBundle);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
            addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
            paramBundle = (TroopHandler)this.app.a(19);
            if (paramBundle != null) {
              paramBundle.b(this.jdField_b_of_type_JavaLangString);
            }
            if (getIntent().getBooleanExtra("key_is_need_update_Group_info", false)) {
              a();
            }
            e();
            d();
            return true;
            a(3, 1, (View)localObject1, getString(2131367866), "");
            break;
            i1 = 0;
            break label845;
            i2 = 0;
            break label879;
          }
        }
      }
    }
    if (l1 <= 0L)
    {
      i1 = 0;
      paramBundle = null;
      if (this.app != null) {
        paramBundle = (FriendManager)this.app.getManager(8);
      }
      if (paramBundle == null)
      {
        i1 = 0;
        if (i1 != 0) {
          break label250;
        }
        finish();
        return true;
      }
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    TroopInfo localTroopInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
    if (localTroopInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r = localTroopInfo.troopTypeExt;
      b();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        FriendManager localFriendManager;
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              return;
            case 1: 
              if ((paramIntent != null) && (paramIntent.getExtras() != null))
              {
                if (paramIntent.getExtras().getBoolean("isNeedFinish"))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("isNeedFinish", true);
                  setResult(-1, paramIntent);
                  finish();
                  return;
                }
                if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
                {
                  paramIntent = new Intent();
                  paramIntent.putExtra("finish_chat_setting", true);
                  setResult(-1, paramIntent);
                  finish();
                  return;
                }
              }
              paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[0];
            }
          } while (paramIntent == null);
          localFriendManager = (FriendManager)this.app.getManager(8);
        } while (localFriendManager == null);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localFriendManager.a(this.jdField_b_of_type_JavaLangString);
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
      ((TextView)paramIntent.findViewById(2131297409)).setText(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum + "/" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberMax);
      return;
      paramIntent = this.jdField_a_of_type_ArrayOfAndroidViewView[1];
    } while (paramIntent == null);
    ((TextView)paramIntent.findViewById(2131297409)).setText(a() + "/" + this.p);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    }
    ((BizTroopHandler)this.app.a(21)).b(this.jdField_b_of_type_JavaLangString, paramBoolean);
    if (paramBoolean)
    {
      ReportController.a(null, "P_CliOper", "Grp_anon", "", "manage_grp", "Clk_open", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      return;
    }
    ReportController.a(null, "P_CliOper", "Grp_anon", "", "manage_grp", "Clk_close", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    case 6: 
    case 8: 
    default: 
      return;
    case 0: 
      paramView = new Intent(this, PublicAccountBrowser.class);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("isScreenOrientationPortrait", true);
      paramView.putExtra("hideRightButton", true);
      paramView.putExtra("url", "https://web.p.qq.com/qqmpmobile/group/groupmembers/index.html?_bid=153&guin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString + "&gcode=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_JavaLangString + "&admin=1&num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_Int);
      startActivityForResult(paramView, 1);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrpmber", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 1: 
      paramView = new Intent(this, SetTroopAdminsActivity.class);
      paramView.putExtra("troop_uin", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode);
      paramView.putExtra("maxAdminNum", this.p);
      startActivityForResult(paramView, 2);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "Grp", "Clk_setting_admin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      return;
    case 2: 
      ReportController.b(this.app, "CliOper", "", "", "Grp", "Clk_mberlevel", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, "", "", "");
      paramView = new Intent(this, PublicAccountBrowser.class);
      paramView.putExtra("reqType", 5);
      paramView.putExtra("hide_more_button", true);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("url", "https://qinfo.clt.qq.com/qlevel/setting.html?_bid=125#gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      paramView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131297409);
      localObject = (TroopManager)this.app.getManager(50);
      int i1 = ((TroopManager)localObject).a();
      if (((i1 & 0x1) == 0) && ("5.5.0".equals("5.9.3")))
      {
        ((TroopManager)localObject).a(i1 | 0x1);
        paramView.setVisibility(8);
      }
      localObject = this.app;
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean) {}
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_setmberlevel", 0, 0, str, paramView, "1", "");
        return;
      }
    case 3: 
      paramView = (TroopGagMgr)this.app.getManager(47);
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString), "", "");
      paramView = new Intent(this, TroopGagActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      return;
    case 7: 
      ReportController.b(this.app, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_up", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
      localObject = this.jdField_e_of_type_JavaLangString;
      str = this.app.getSid();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {}
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; paramView = Integer.valueOf(0))
      {
        this.jdField_e_of_type_JavaLangString = String.format((String)localObject, new Object[] { str, paramView });
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("uin", this.app.a());
        paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
        paramView.putExtra("business", 2147614720L);
        startActivity(paramView);
        return;
      }
    case 4: 
      c();
      return;
    case 5: 
      paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k);
      paramView.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r);
      TroopInfoActivity.a(this, paramView, 4);
      return;
    case 9: 
      paramView = new Intent(this, TroopPrivilegeActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString);
      startActivity(paramView);
      return;
    }
    Object localObject = this.app;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_b_of_type_Boolean)
    {
      paramView = "0";
      ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_local", 0, 0, str, paramView, "", "");
      localObject = this.f;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break label1107;
      }
    }
    label1107:
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_c_of_type_JavaLangString;; paramView = Integer.valueOf(0))
    {
      this.f = String.format((String)localObject, new Object[] { paramView });
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("uin", this.app.a());
      paramView.putExtra("url", this.f);
      paramView.putExtra("business", 2147614720L);
      startActivity(paramView);
      return;
      paramView = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopManageActivity
 * JD-Core Version:    0.7.0.1
 */