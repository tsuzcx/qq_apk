package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import eeb;
import eec;
import eed;
import eee;
import eef;
import eeg;
import eeh;
import eej;
import eek;
import eel;
import eem;
import eeo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatListActivity
  extends DatingBaseActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, OverScrollViewListener
{
  public static final String a = "HotChatListActivity";
  private static final String jdField_b_of_type_JavaLangString = "https://mma.qq.com/feedback/hottalk.html";
  private final int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Context a;
  public Handler a;
  public View.OnClickListener a;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new eee(this);
  public PullRefreshHeader a;
  public QQProgressDialog a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public XListView a;
  eeo jdField_a_of_type_Eeo;
  public List a;
  public Common.WifiPOIInfo a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressNotifier jdField_b_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  public boolean b;
  TextView c;
  public boolean c;
  TextView d;
  TextView e;
  private boolean g = false;
  private boolean h = false;
  
  public HotChatListActivity()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new eef(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new eeh(this);
  }
  
  public static void a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      localBaseActivity.startActivity(new Intent(localBaseActivity, HotChatListActivity.class));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.putExtra("uinname", paramString3);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo)
  {
    if (NetworkUtil.e(this))
    {
      HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(58);
      if (QLog.isColorLevel()) {
        QLog.d("HotChatListActivity", 2, "enter poi hotchat start aio, join hot chat");
      }
      a(2131369502);
      this.app.a(new eej(this, paramWifiPOIInfo));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131369501), 0).b(getTitleBarHeight());
  }
  
  private void a(Common.WifiPOIInfo paramWifiPOIInfo, List paramList)
  {
    if (paramWifiPOIInfo != null)
    {
      this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo = paramWifiPOIInfo;
      if (QLog.isColorLevel()) {
        QLog.i("HotChatListActivity", 2, "name : " + paramWifiPOIInfo.bytes_name.get().toStringUtf8() + " | sig : " + paramWifiPOIInfo.bytes_sig.get().toStringUtf8() + " | faceid : " + paramWifiPOIInfo.uint32_face_id.get() + " | group_code : " + paramWifiPOIInfo.uint32_group_code.get() + " | group_uin : " + paramWifiPOIInfo.uint32_group_uin.get() + " | is_member : " + paramWifiPOIInfo.uint32_is_member.get() + " | visitor_num : " + paramWifiPOIInfo.uint32_visitor_num.get() + " | wifi_poi_type : " + paramWifiPOIInfo.uint32_wifi_poi_type.get() + " | uid : " + paramWifiPOIInfo.bytes_uid.get().toStringUtf8() + " | theme_type : " + paramWifiPOIInfo.hot_theme_group_flag.get());
      }
    }
    h();
    paramWifiPOIInfo = new ArrayList();
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_b_of_type_Boolean = false;
      localIterator = paramList.iterator();
    }
    while (localIterator.hasNext())
    {
      Common.WifiPOIInfo localWifiPOIInfo = (Common.WifiPOIInfo)localIterator.next();
      paramWifiPOIInfo.add(localWifiPOIInfo);
      if (QLog.isColorLevel())
      {
        QLog.i("HotChatListActivity", 2, "name : " + localWifiPOIInfo.bytes_name.get().toStringUtf8() + " | sig : " + localWifiPOIInfo.bytes_sig.get().toStringUtf8() + " | faceid : " + localWifiPOIInfo.uint32_face_id.get() + " | group_code : " + localWifiPOIInfo.uint32_group_code.get() + " | group_uin : " + localWifiPOIInfo.uint32_group_uin.get() + " | is_member : " + localWifiPOIInfo.uint32_is_member.get() + " | visitor_num : " + localWifiPOIInfo.uint32_visitor_num.get() + " | wifi_poi_type : " + localWifiPOIInfo.uint32_wifi_poi_type.get() + " | uid : " + localWifiPOIInfo.bytes_uid.get().toStringUtf8());
        continue;
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramWifiPOIInfo);
    this.jdField_a_of_type_Eeo.notifyDataSetChanged();
    if (this.jdField_b_of_type_Boolean)
    {
      this.d.setText(getString(2131369498, new Object[] { "" }));
      this.d.setContentDescription(getString(2131369498, new Object[] { "" }));
      return;
    }
    this.d.setText(getString(2131369498, new Object[] { " (" + paramList.size() + ")" }));
    this.d.setContentDescription(getString(2131369498, new Object[] { ",共" + paramList.size() + "个" }));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo == null) || (NetworkUtil.b(getApplicationContext()) != 1))
    {
      localObject2 = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(16908308);
      if (NetworkUtil.g(this))
      {
        localObject2 = HotChatManager.a(((WifiManager)localObject2).getConnectionInfo());
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131369497, new Object[] { localObject2 }));
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369497, new Object[] { localObject2 }));
        ((TextView)localObject1).setText(2131369517);
      }
    }
    while (this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo == null)
    {
      Object localObject2;
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131369497, new Object[] { "暂无连接" }));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369497, new Object[] { "暂无连接" }));
      ((TextView)localObject1).setText(2131369519);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    Object localObject1 = "";
    if (this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_name.has())
    {
      localObject1 = this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_name.get().toStringUtf8();
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131369497, new Object[] { localObject1 }));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369497, new Object[] { localObject1 }));
    }
    int i = this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.uint32_visitor_num.get();
    if (i > 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("(" + i + ")");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription((String)localObject1 + "热聊," + i + "位成员");
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void i()
  {
    if (NetworkUtil.e(this))
    {
      this.app.a(new eeg(this));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 800L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
  }
  
  private void j()
  {
    setContentView(2130903586);
    getWindow().setBackgroundDrawable(null);
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838415);
    this.rightViewImg.setOnClickListener(this);
    if (this.e) {
      setLeftViewName(2131367588);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298888));
    this.jdField_a_of_type_Eeo = new eeo(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903585, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Eeo);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298887));
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2130903418, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837687);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298884));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297301));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298889));
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296551)).setImageResource(2130839232);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(16908308));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298883));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298881));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298885));
  }
  
  private void k()
  {
    Boolean localBoolean = Boolean.valueOf(HotChatManager.b(this.app));
    ActionSheet localActionSheet = ActionSheet.c(this);
    localActionSheet.a(2131369526);
    localActionSheet.a(getString(2131369527), localBoolean.booleanValue());
    localActionSheet.e(2131365736);
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.a(this);
    localActionSheet.a(this);
    localActionSheet.a = localBoolean;
    try
    {
      localActionSheet.show();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = localActionSheet;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatListActivity", 2, "OnClick:" + paramInt);
    }
    boolean bool;
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetActionSheet != null))
    {
      if (((Boolean)this.jdField_a_of_type_ComTencentWidgetActionSheet.a).booleanValue()) {
        break label158;
      }
      bool = true;
    }
    for (;;)
    {
      paramView = this.app;
      if (bool)
      {
        paramInt = i;
        ReportController.b(paramView, "CliOper", "", "", "0X8004B1C", "0X8004B1C", paramInt, 0, "", "", "", "");
        HotChatManager.a(this.app);
        HotChatManager.b(this.app, bool);
        if (!bool) {
          ((HotChatManager)this.app.getManager(58)).d();
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        label152:
        this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
        return;
        label158:
        bool = false;
        continue;
        paramInt = 2;
      }
      catch (Exception paramView)
      {
        break label152;
      }
    }
  }
  
  protected Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = getResources().getString(paramInt1);
    Object localObject1 = getResources().getString(paramInt2);
    String str2 = getResources().getString(paramInt3);
    String str1 = getResources().getString(paramInt4);
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)localObject2);
      localTextView.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = (TextView)localDialog.findViewById(2131296606);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131297370);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
    }
    paramOnClickListener1 = (TextView)localDialog.findViewById(2131297371);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setContentDescription(str1);
      paramOnClickListener1.setOnClickListener(paramOnClickListener2);
    }
    return localDialog;
  }
  
  protected View a()
  {
    return getLayoutInflater().inflate(2130903584, this.jdField_a_of_type_ComTencentWidgetXListView, false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.h) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = a(2131369522, 2131369521, 2131365736, 2131365737, new eeb(this), new eec(this, paramRunnable));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new eed(this));
    this.h = true;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    i();
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  protected void c()
  {
    setTitle(getString(2131369492), getString(2131369492));
    startTitleProgress();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = a(2131369508, 2131369507, 2131365736, 2131365737, new eel(this), new eem(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    g();
    j();
    c();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    if (NetworkUtil.e(this))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
      i();
      this.g = true;
    }
    for (;;)
    {
      h();
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      return true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Eeo.jdField_a_of_type_AndroidViewView = a();
      this.jdField_a_of_type_Eeo.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 800L);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected boolean onBackEvent()
  {
    if (this.e)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.e);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout) {
      if (!NetworkUtil.e(this)) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131369501), 0).b(getTitleBarHeight());
      }
    }
    while (paramView.getId() != 2131297361)
    {
      return;
      paramView = this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_name.get().toStringUtf8();
      String str = HotChatManager.a();
      if ((str == null) || (!TextUtils.equals(paramView, str)))
      {
        QQToast.a(this, "已离开当前wifi，不能加入该热聊。", 0).b(getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("HotChatListActivity", 2, "进入wifi热聊");
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004411", "0X8004411", 1, 0, "", "", "", "");
      paramView = ((HotChatManager)this.app.getManager(58)).b();
      if ((paramView != null) && (!TextUtils.equals(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_uid.get().toStringUtf8(), paramView.uuid)))
      {
        paramView = HotChatInfo.createWifiPOIInfo(paramView);
        if (QLog.isColorLevel()) {
          QLog.i("HotChatListActivity", 2, "消息tab name : " + paramView.bytes_name.get().toStringUtf8() + " | sig : " + paramView.bytes_sig.get().toStringUtf8() + " | faceid : " + paramView.uint32_face_id.get() + " | group_code : " + paramView.uint32_group_code.get() + " | group_uin : " + paramView.uint32_group_uin.get() + " | is_member : " + paramView.uint32_is_member.get() + " | visitor_num : " + paramView.uint32_visitor_num.get() + " | wifi_poi_type : " + paramView.uint32_wifi_poi_type.get() + " | uid : " + paramView.bytes_uid.get().toStringUtf8() + " | themeType : " + paramView.hot_theme_group_flag.get());
        }
        d();
        return;
      }
      if (this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.uint32_is_member.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotChatListActivity", 2, "enter wifi hotchat start aio, is member");
        }
        long l = Utils.a(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.uint32_group_uin.get());
        a(String.valueOf(Utils.a(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.uint32_group_code.get())), String.valueOf(l), String.valueOf(this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_name.get().toStringUtf8()));
      }
      if ((paramView != null) && (this.jdField_a_of_type_TencentImOidbHotchatCommon$WifiPOIInfo.bytes_uid.get().toStringUtf8().equals(paramView.uuid)) && (paramView.troopUin != null) && (paramView.troopUin.length() > 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotChatListActivity", 2, "enter wifi hotchat start aio, has joined");
        }
        a(paramView.troopUin, paramView.troopCode, paramView.name);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatListActivity", 2, "enter wifi hotchat start aio, join hot chat");
      }
      a(2131369502);
      this.app.a(new eek(this));
      return;
    }
    k();
  }
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatListActivity
 * JD-Core Version:    0.7.0.1
 */