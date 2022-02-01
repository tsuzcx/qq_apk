package com.tencent.open.agent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lcg;
import lch;
import lci;
import lcj;
import lck;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class SmartHardwareActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, ImageLoader.ImageLoadListener
{
  public static final long a = 16L;
  protected static final String a = "SmartHardwareActivity";
  protected static final int g = 1300000607;
  protected static final String i = "ConnAuthSvr.sdk_auth_api";
  protected final int a;
  public Bundle a;
  private final Handler a;
  protected LayoutInflater a;
  public GridView a;
  public ImageView a;
  protected TextView a;
  protected DeviceInfo a;
  protected QQAppInterface a;
  public FormSimpleItem a;
  public QQProgressDialog a;
  public SmartHardwareActivity.FriendListAdapter a;
  public ArrayList a;
  protected WtloginManager a;
  protected SSOAccountObserver a;
  protected final int b;
  protected long b;
  protected TextView b;
  public String b;
  protected final int c;
  protected TextView c;
  public String c;
  protected final int d;
  protected TextView d;
  protected String d;
  protected final int e;
  protected TextView e;
  public String e;
  protected int f;
  protected TextView f;
  public String f;
  protected TextView g;
  protected String g;
  protected final int h = 0;
  protected String h;
  protected final int i = 1;
  
  public SmartHardwareActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 10000;
    this.jdField_e_of_type_Int = 10001;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new lcg(this);
    this.jdField_a_of_type_AndroidOsHandler = new lci(this);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = OpensdkPreference.a(paramContext, "uin_openid_store").edit();
    paramContext.putString(paramString1, paramString2);
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramContext.putString(paramString3 + ":" + paramString2, paramString1);
    paramContext.commit();
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("hopenid", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("encrytoken", paramString1);
    this.jdField_a_of_type_AndroidOsBundle.putString("keystr", paramString2);
    this.jdField_a_of_type_AndroidOsBundle.putString("keytype", "0x80");
    this.jdField_a_of_type_AndroidOsBundle.putString("pf", "openmobile_android");
    this.jdField_a_of_type_AndroidOsBundle.putString("sdkp", "a");
    this.jdField_a_of_type_AndroidOsBundle.putString("platform", "androidqz");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297357));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297358));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297360));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297348));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297507));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297508));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298910));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(getString(2131368108, new Object[] { this.jdField_c_of_type_JavaLangString }));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298911));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131298913));
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = getLayoutInflater();
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131296449));
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
    if (this.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity$FriendListAdapter == null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity$FriendListAdapter = new SmartHardwareActivity.FriendListAdapter(this);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity$FriendListAdapter);
    }
    ThreadManager.a(new lch(this));
  }
  
  private void e()
  {
    SdkAuthorize.AuthorizeRequest localAuthorizeRequest = new SdkAuthorize.AuthorizeRequest();
    localAuthorizeRequest.client_id.set(1300000607L);
    localAuthorizeRequest.need_pay.set(1);
    localAuthorizeRequest.openapi.add(Integer.valueOf(1001));
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject = "";; localObject = Build.VERSION.RELEASE)
    {
      localAuthorizeRequest.os.set((String)localObject);
      localAuthorizeRequest.qqv.set(DeviceInfoUtil.c());
      localAuthorizeRequest.pf.set("openmobile_android");
      localAuthorizeRequest.sdkp.set("android");
      localAuthorizeRequest.sdkv.set("1.5.9");
      localAuthorizeRequest.response_type.set("token");
      localAuthorizeRequest.skey.set(this.app.a());
      localObject = new NewIntent(getActivity().getApplicationContext(), OpensdkServlet.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("uin", this.app.a());
      ((NewIntent)localObject).putExtra("data", localAuthorizeRequest.toByteArray());
      ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.sdk_auth_api");
      ((NewIntent)localObject).setObserver(new lck(this));
      this.app.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public String a(String paramString)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    paramString = super.getSharedPreferences("accountList", 0);
    if (paramString.getString("accList", null) != null) {}
    for (paramString = paramString.getString("accList", null).split(",");; paramString = null)
    {
      if (paramString != null)
      {
        int k = paramString.length;
        while (j < k)
        {
          localArrayList.add(paramString[j]);
          j += 1;
        }
      }
      while (localArrayList.contains("")) {
        localArrayList.remove("");
      }
      return null;
    }
  }
  
  protected List a(Parcelable[] paramArrayOfParcelable)
  {
    if ((paramArrayOfParcelable == null) || (paramArrayOfParcelable.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfParcelable.length;
    int j = 0;
    while (j < k)
    {
      Friend localFriend = new Friend((Friend)paramArrayOfParcelable[j]);
      LogUtility.c("SmartHardwareActivity", "Friend nick name: " + localFriend.jdField_b_of_type_JavaLangString);
      localArrayList.add(localFriend);
      j += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str = getAppRuntime().getAccount();
    if (TextUtils.isEmpty(str))
    {
      ToastUtil.a().a(2131368105);
      if (QLog.isColorLevel())
      {
        QLog.d("SmartHardwareActivity", 2, "-->doLogin--no account to get Vkey");
        QLog.d("SDKQQAgentPref", 2, "FirstLaunch_AGENT:" + SystemClock.elapsedRealtime());
      }
      finish();
    }
    if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(str, 131072, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
    this.jdField_g_of_type_JavaLangString = ContactUtils.h(this.app, str);
    this.jdField_a_of_type_AndroidOsBundle.putString("nickname", this.jdField_g_of_type_JavaLangString);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(getResources().getString(2131368109, new Object[] { this.jdField_g_of_type_JavaLangString }));
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("SmartHardwareActivity", "-->onImageLoaded() url = " + paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new lcj(this, paramString, paramBitmap));
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this, DeviceShareFriendChooser.class);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_e_of_type_JavaLangString);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Friend)localIterator.next()).jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidOsBundle.putStringArrayList("RESULT_BUDDIES_SELECTED", localArrayList);
    }
    localIntent.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("key_action", "action_story");
    super.startActivityForResult(localIntent, 10000);
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_Share_AddDel", 1, 0, this.jdField_f_of_type_Int);
  }
  
  protected void c()
  {
    Intent localIntent = new Intent(this, DeviceDeleteFriendChooserActivity.class);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_AndroidOsBundle.putParcelableArrayList("RESULT_BUDDIES_SELECTED", this.jdField_a_of_type_JavaUtilArrayList);
    }
    localIntent.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("key_action", "action_story");
    super.startActivityForResult(localIntent, 10001);
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_Share_AddDel", 2, 0, this.jdField_f_of_type_Int);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    label147:
    Friend localFriend;
    Iterator localIterator;
    switch (paramInt1)
    {
    default: 
    case 10000: 
      for (;;)
      {
        return;
        if (paramInt2 == -1) {
          try
          {
            paramIntent = paramIntent.getExtras();
            if ((paramIntent != null) && (paramIntent.getInt("key_error_code", -6) == 0))
            {
              paramIntent = paramIntent.getParcelableArrayList("RESULT_BUDDIES_SELECTED");
              if (paramIntent == null)
              {
                LogUtility.e("SmartHardwareActivity", "onActivityResult  request code: " + String.valueOf(10000) + " error: mSelectedBuddies is null");
                return;
              }
            }
          }
          catch (Exception paramIntent)
          {
            LogUtility.c("SmartHardwareActivity", "onActivityResult error:" + paramIntent.getMessage(), paramIntent);
            super.setResult(0);
            super.finish();
            return;
          }
        }
      }
      paramIntent = paramIntent.iterator();
      if (paramIntent.hasNext())
      {
        localFriend = (Friend)paramIntent.next();
        paramInt1 = 1;
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      break;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        if (((Friend)localIterator.next()).jdField_a_of_type_JavaLangString.equals(localFriend.jdField_a_of_type_JavaLangString)) {
          paramInt1 = 0;
        }
      }
      else
      {
        if (paramInt1 == 0) {
          break label147;
        }
        localFriend.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_JavaUtilArrayList.add(localFriend);
        break label147;
        QQToast.a(this, 2131362247, 0).a(super.getTitleBarHeight()).show();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        return;
        if (paramInt2 != -1) {
          break;
        }
        try
        {
          paramIntent = paramIntent.getExtras();
          if ((paramIntent == null) || (paramIntent.getInt("key_error_code", -6) != 0))
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          LogUtility.c("SmartHardwareActivity", "onActivityResult error:" + paramIntent.getMessage(), paramIntent);
          super.setResult(0);
          super.finish();
          return;
        }
        paramIntent = paramIntent.getParcelableArrayList("result_buddies_undeleted");
        if (paramIntent == null)
        {
          LogUtility.e("SmartHardwareActivity", "onActivityResult  request code: " + String.valueOf(10001) + " error: mSelectedBuddies is null");
          return;
        }
        this.jdField_a_of_type_JavaUtilArrayList = paramIntent;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 100L);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297360: 
      super.finish();
      return;
    }
    c();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setTheme(2131559078);
    super.setContentView(2130903594);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131368098));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        ToastUtil.a().a(2131362251);
        return;
      }
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("device_id");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("device_name");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((SmartDeviceProxyMgr)this.app.a(53)).a(Long.parseLong(this.jdField_c_of_type_JavaLangString));
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("device_name", this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.name);
      this.jdField_a_of_type_AndroidOsBundle.putString("device_remark", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putString("productid", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId));
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
    }
    d();
    e();
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_Share_Page", 0, 0, this.jdField_f_of_type_Int);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) {
      b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367064);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131362629);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SmartHardwareActivity
 * JD-Core Version:    0.7.0.1
 */