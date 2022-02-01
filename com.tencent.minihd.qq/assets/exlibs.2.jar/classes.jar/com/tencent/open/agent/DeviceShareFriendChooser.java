package com.tencent.open.agent;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.StaticAnalyz;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import lbl;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareFriendChooser
  extends FriendChooser
  implements OpenSdkFriendService.GetFriendInfoListener, HttpCgiAsyncTask.Callback
{
  protected static final int a = 70;
  protected static final String a;
  protected static final int b = 12;
  protected static final String b = "recImg";
  protected static final int c = 70;
  protected static final String c = "recImgDec";
  protected static final int d = 20;
  protected static final String d = "sendImg";
  protected static final int e = 10001;
  protected static final String e = "invitedopenids";
  protected static final int f = 10002;
  protected String A;
  protected String B;
  protected String C;
  public Bundle a;
  protected Handler a;
  protected QQProgressDialog a;
  public HttpCgiAsyncTask a;
  protected ArrayList a;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  protected String z;
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceShareFriendChooser.class.getName();
  }
  
  public DeviceShareFriendChooser()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = new lbl(this);
  }
  
  protected int a()
  {
    return 2130903432;
  }
  
  public String a()
  {
    return this.f;
  }
  
  protected void a()
  {
    if ("action_story".equals(this.jdField_k_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362675);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      HttpCgiAsyncTask localHttpCgiAsyncTask = new HttpCgiAsyncTask("https://fusion.qq.com/cgi-bin/qzapps/op_bindlist", "GET", new DeviceShareFriendChooser.SendBindListCallBack(this));
      Bundle localBundle = new Bundle();
      localBundle.putString("din", this.h);
      localBundle.putString("appid", this.f);
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = this.c.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(((Friend)this.c.get(i1)).jdField_a_of_type_JavaLangString);
        if (i1 != i2 - 1) {
          localStringBuilder.append(",");
        }
        i1 += 1;
      }
      localBundle.putString("bindlist", localStringBuilder.toString());
      localBundle.putString("vkey", this.r);
      localBundle.putString("openid", this.g);
      localBundle.putString("devicename", this.m);
      localBundle.putString("device_head_url", DeviceHeadMgr.a(this.n));
      localBundle.putString("args", "uin=" + this.app.a());
      localHttpCgiAsyncTask.a(localBundle);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void a(Friend paramFriend)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramFriend.jdField_a_of_type_JavaLangString))
    {
      int i1 = 0;
      if (this.b != null) {
        i1 = this.b.size();
      }
      if (i1 + this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= 21)
      {
        ToastUtil.a().a(2131362250);
        return;
      }
    }
    super.a(paramFriend);
  }
  
  public void a(FriendResponseInfo paramFriendResponseInfo)
  {
    for (;;)
    {
      try
      {
        d();
        if (("action_gift".equals(this.jdField_k_of_type_JavaLangString)) || ("action_ask".equals(this.jdField_k_of_type_JavaLangString)) || ("action_invite".equals(this.jdField_k_of_type_JavaLangString)) || ("action_reactive".equals(this.jdField_k_of_type_JavaLangString)) || ("action_story".equals(this.jdField_k_of_type_JavaLangString)))
        {
          if (paramFriendResponseInfo.e != -1)
          {
            if (paramFriendResponseInfo.e - paramFriendResponseInfo.f == 0)
            {
              this.jdField_j_of_type_Int = 0;
              this.jdField_k_of_type_Int = paramFriendResponseInfo.e;
            }
          }
          else
          {
            if (this.jdField_j_of_type_Int == 0) {
              Toast.makeText(this, super.getString(2131362665, new Object[] { Integer.valueOf(paramFriendResponseInfo.e) }), 0).show();
            }
            FriendDataManager localFriendDataManager = FriendDataManager.a();
            localFriendDataManager.a(paramFriendResponseInfo.jdField_a_of_type_JavaUtilArrayList, paramFriendResponseInfo.h, paramFriendResponseInfo.i);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break;
            }
            paramFriendResponseInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!paramFriendResponseInfo.hasNext()) {
              break;
            }
            Friend localFriend = (Friend)paramFriendResponseInfo.next();
            localFriendDataManager.a(localFriend.jdField_a_of_type_JavaLangString);
            this.c.add(localFriendDataManager.a(localFriend.jdField_a_of_type_JavaLangString));
            continue;
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramFriendResponseInfo)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "GetBuddyList exception." + paramFriendResponseInfo.getMessage(), paramFriendResponseInfo);
        paramFriendResponseInfo = new Intent();
        paramFriendResponseInfo.putExtra("key_error_code", -6);
        paramFriendResponseInfo.putExtra("key_error_msg", "未知错误!");
        b(paramFriendResponseInfo);
      }
      if (paramFriendResponseInfo.e - paramFriendResponseInfo.f < this.jdField_j_of_type_Int) {
        this.jdField_j_of_type_Int = (paramFriendResponseInfo.e - paramFriendResponseInfo.f);
      }
    }
    b(true);
    ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 5000L);
  }
  
  public void a(Exception paramException)
  {
    d();
    LogUtility.c(jdField_a_of_type_JavaLangString, "SendAppInvitation exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      c(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", "网络连接超时!");
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", "未知错误!");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i1 = 2131362646;
    try
    {
      d();
      int i2 = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i2 == 0)
      {
        if (!"action_invite".equals(this.jdField_k_of_type_JavaLangString)) {
          break label113;
        }
        StaticAnalyz.a("400", "ANDROIDQQ.INVITE.ASSISTANT", this.f);
      }
      for (;;)
      {
        Toast.makeText(this, i1, 0).show();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_error_code", i2);
        localIntent.putExtra("key_error_msg", str);
        localIntent.putExtra("key_response", paramJSONObject.toString());
        c(localIntent);
        return;
        label113:
        if ("action_ask".equals(this.jdField_k_of_type_JavaLangString))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.f);
          i1 = 2131362670;
        }
        else if ("action_gift".equals(this.jdField_k_of_type_JavaLangString))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.f);
          i1 = 2131362671;
        }
        else if ("action_reactive".equals(this.jdField_k_of_type_JavaLangString))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.f);
          i1 = 2131362672;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "SendAppInvitation exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", "服务器返回数据格式有误!");
      c(paramJSONObject);
    }
  }
  
  protected boolean a()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
        this.jdField_k_of_type_JavaLangString = super.getIntent().getStringExtra("key_action");
        LogUtility.c(jdField_a_of_type_JavaLangString, "-->action = " + this.jdField_k_of_type_JavaLangString + " -- mParms = " + this.jdField_a_of_type_AndroidOsBundle);
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
        {
          this.h = this.jdField_a_of_type_AndroidOsBundle.getString("device_id");
          this.i = this.jdField_a_of_type_AndroidOsBundle.getString("device_remark");
          this.g = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.f = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
          this.o = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.l = this.jdField_a_of_type_AndroidOsBundle.getString("nickname");
          this.m = this.jdField_a_of_type_AndroidOsBundle.getString("device_name");
          this.n = this.jdField_a_of_type_AndroidOsBundle.getString("productid");
          this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
          this.p = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
          this.q = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
          this.s = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
          this.r = this.jdField_a_of_type_AndroidOsBundle.getString("vkey");
          if (("".equals(this.f.trim())) || ("".equals(this.o.trim())) || ("".equals(this.jdField_j_of_type_JavaLangString.trim())) || ("".equals(this.q.trim())) || ("".equals(this.p.trim())) || ("".equals(this.r.trim())))
          {
            b();
            return false;
          }
          if (("action_gift".equals(this.jdField_k_of_type_JavaLangString)) || ("action_ask".equals(this.jdField_k_of_type_JavaLangString)) || ("action_reactive".equals(this.jdField_k_of_type_JavaLangString)))
          {
            this.u = this.jdField_a_of_type_AndroidOsBundle.getString("type");
            this.x = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 12, true, false);
            this.w = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("msg"), 70, true, false);
            if (!"action_ask".equals(this.jdField_k_of_type_JavaLangString)) {
              break label938;
            }
            String str1 = "50";
            this.v = str1;
            if (("".equals(this.u.trim())) || ("".equals(this.x.trim())) || ("".equals(this.w.trim())))
            {
              b();
              return false;
            }
            if ("action_reactive".equals(this.jdField_k_of_type_JavaLangString))
            {
              this.v = "51";
              if ((!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImg")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImgDec")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("sendImg")))
              {
                b();
                return false;
              }
              this.A = this.jdField_a_of_type_AndroidOsBundle.getString("recImg");
              this.B = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("recImgDec"), 20, true, false);
              this.C = this.jdField_a_of_type_AndroidOsBundle.getString("sendImg");
              if (("".equals(this.A)) || ("".equals(this.B)) || ("".equals(this.C)))
              {
                b();
                return false;
              }
            }
            LogUtility.c(jdField_a_of_type_JavaLangString, "-->typeid = " + this.v);
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
            this.t = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) {
            this.y = this.jdField_a_of_type_AndroidOsBundle.getString("img");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
            this.z = this.jdField_a_of_type_AndroidOsBundle.getString("source");
          }
          OpenSdkFriendService.a().a(this.f, this.o);
          this.b = this.jdField_a_of_type_AndroidOsBundle.getStringArrayList("RESULT_BUDDIES_SELECTED");
          return true;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "initParams exception." + localException.getMessage(), localException);
        b();
        return false;
      }
      b();
      return false;
      label938:
      String str2 = "1";
    }
  }
  
  protected void b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    LogUtility.e(jdField_a_of_type_JavaLangString, "initParams:error code:-5; error msg:传入参数有误!");
    Bundle localBundle = super.getIntent().getBundleExtra("key_params");
    if (localBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + localBundle.get(str).toString() + " ");
      }
      LogUtility.e(jdField_a_of_type_JavaLangString, "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void b(Intent paramIntent)
  {
    d();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(CommonDataAdapter.a().a(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0) {
      LogUtility.e(jdField_a_of_type_JavaLangString, "onGetBuddyListError{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362658);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.f);
    localBundle.putString("hopenid", this.o);
    localBundle.putString("keystr", this.jdField_j_of_type_JavaLangString);
    localBundle.putString("keytype", this.p);
    localBundle.putString("platform", this.q);
    localBundle.putString("encrytoken", this.s);
    if (this.t != null) {
      localBundle.putString("pf", this.t);
    }
    localBundle.putString("appid_for_getting_config", this.f);
    if (("action_gift".equals(this.jdField_k_of_type_JavaLangString)) || ("action_ask".equals(this.jdField_k_of_type_JavaLangString)) || ("action_reactive".equals(this.jdField_k_of_type_JavaLangString))) {
      localBundle.putString("typeid", this.v);
    }
    localBundle.putString("agentversion", CommonDataAdapter.a().d());
    localBundle.putString("appid_for_getting_config", this.f);
    OpenSdkFriendService.a().a(localBundle, this, this.jdField_k_of_type_JavaLangString);
  }
  
  protected void c(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      LogUtility.e(jdField_a_of_type_JavaLangString, "onSendAppInvitationComplete{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void e()
  {
    String str = null;
    if (this.jdField_j_of_type_Int == 0) {
      if ("action_invite".equals(this.jdField_k_of_type_JavaLangString)) {
        str = super.getString(2131362665, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
      }
    }
    for (;;)
    {
      ToastUtil.a().a(str, 0);
      return;
      if ("action_ask".equals(this.jdField_k_of_type_JavaLangString))
      {
        str = super.getString(2131362666, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
      }
      else if ("action_gift".equals(this.jdField_k_of_type_JavaLangString))
      {
        str = super.getString(2131362667, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
        continue;
        str = super.getString(2131362653, new Object[] { Integer.valueOf(this.jdField_j_of_type_Int) });
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      k();
      return true;
    }
    super.superFinish();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
    if (!a()) {
      return;
    }
    c();
    this.e.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10001);
    OpenSdkFriendService.a().a();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.DeviceShareFriendChooser
 * JD-Core Version:    0.7.0.1
 */