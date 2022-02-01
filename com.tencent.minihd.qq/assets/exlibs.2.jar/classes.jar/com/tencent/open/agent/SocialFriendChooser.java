package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.InnerFrameManager;
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
import com.tencent.open.settings.ServerSetting;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lcl;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialFriendChooser
  extends FriendChooser
  implements OpenSdkFriendService.GetFriendInfoListener, HttpCgiAsyncTask.Callback
{
  protected static final int a = 70;
  protected static final String a = "SocialFriendChooser";
  protected static final int b = 12;
  protected static final String b = "recImg";
  protected static final int c = 70;
  protected static final String c = "recImgDec";
  protected static final int d = 20;
  protected static final String d = "sendImg";
  protected static final int e = 10001;
  protected static final String e = "invitedopenids";
  protected static final int f = 10002;
  protected ProgressDialog a;
  public Bundle a;
  protected Handler a;
  public HttpCgiAsyncTask a;
  protected String[] a;
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
  
  public SocialFriendChooser()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = new lcl(this);
  }
  
  protected int a()
  {
    return 2130903441;
  }
  
  public String a()
  {
    return this.f;
  }
  
  protected void a()
  {
    if (("action_invite".equals(this.h)) || ("action_gift".equals(this.h)) || ("action_ask".equals(this.h)) || ("action_reactive".equals(this.h))) {
      b();
    }
    while (!"action_story".equals(this.h)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Friend[] arrayOfFriend = (Friend[])this.c.toArray(new Friend[this.c.size()]);
    localBundle.putInt("key_error_code", 0);
    localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
    localIntent.putExtras(localBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      LogUtility.e("SocialFriendChooser", "onSendAppInvitationComplete{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(FriendResponseInfo paramFriendResponseInfo)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        l();
        if (("action_gift".equals(this.h)) || ("action_ask".equals(this.h)) || ("action_invite".equals(this.h)) || ("action_reactive".equals(this.h)) || ("action_story".equals(this.h)))
        {
          this.jdField_j_of_type_Int = paramFriendResponseInfo.g;
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
            localFriendDataManager.a(paramFriendResponseInfo.a, paramFriendResponseInfo.h, paramFriendResponseInfo.i);
            if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
              break label358;
            }
            paramFriendResponseInfo = this.jdField_a_of_type_ArrayOfJavaLangString;
            int i2 = paramFriendResponseInfo.length;
            if (i1 >= i2) {
              break label358;
            }
            String str = paramFriendResponseInfo[i1];
            localFriendDataManager.a(str);
            this.c.add(localFriendDataManager.a(str));
            i1 += 1;
            continue;
          }
          if (paramFriendResponseInfo.e - paramFriendResponseInfo.f >= this.jdField_j_of_type_Int) {
            continue;
          }
          this.jdField_j_of_type_Int = (paramFriendResponseInfo.e - paramFriendResponseInfo.f);
          continue;
        }
        b(true);
      }
      catch (Exception paramFriendResponseInfo)
      {
        LogUtility.c("SocialFriendChooser", "GetBuddyList exception." + paramFriendResponseInfo.getMessage(), paramFriendResponseInfo);
        paramFriendResponseInfo = new Intent();
        paramFriendResponseInfo.putExtra("key_error_code", -6);
        paramFriendResponseInfo.putExtra("key_error_msg", "未知错误!");
        b(paramFriendResponseInfo);
        if (QLog.isColorLevel())
        {
          if (!"action_story".equals(this.h)) {
            break;
          }
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchEnd:" + SystemClock.elapsedRealtime());
        }
        return;
      }
      label358:
      ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 5000L);
    }
    QLog.d("SDKQQAgentPref", 2, "GetInviteFriendSwitch_AGENT:" + SystemClock.elapsedRealtime());
  }
  
  public void a(Exception paramException)
  {
    l();
    LogUtility.c("SocialFriendChooser", "SendAppInvitation exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      a(localIntent);
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
      l();
      int i2 = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i2 == 0)
      {
        if (!"action_invite".equals(this.h)) {
          break label111;
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
        a(localIntent);
        return;
        label111:
        if ("action_ask".equals(this.h))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.f);
          i1 = 2131362670;
        }
        else if ("action_gift".equals(this.h))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.f);
          i1 = 2131362671;
        }
        else if ("action_reactive".equals(this.h))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.f);
          i1 = 2131362672;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtility.c("SocialFriendChooser", "SendAppInvitation exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", "服务器返回数据格式有误!");
      a(paramJSONObject);
    }
  }
  
  protected boolean a()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
        this.h = super.getIntent().getStringExtra("key_action");
        LogUtility.c("SocialFriendChooser", "-->action = " + this.h + " -- mParms = " + this.jdField_a_of_type_AndroidOsBundle);
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
        {
          this.f = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
          this.g = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
          this.i = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
          this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
          this.l = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
          if (("".equals(this.f.trim())) || ("".equals(this.i.trim())) || ("".equals(this.g.trim())) || ("".equals(this.jdField_k_of_type_JavaLangString.trim())) || ("".equals(this.jdField_j_of_type_JavaLangString.trim())) || ("".equals(this.l.trim())))
          {
            c();
            return false;
          }
          if (("action_gift".equals(this.h)) || ("action_ask".equals(this.h)) || ("action_reactive".equals(this.h)))
          {
            this.n = this.jdField_a_of_type_AndroidOsBundle.getString("type");
            this.q = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 12, true, false);
            this.p = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("msg"), 70, true, false);
            if (!"action_ask".equals(this.h)) {
              break label840;
            }
            String str1 = "50";
            this.o = str1;
            if (("".equals(this.n.trim())) || ("".equals(this.q.trim())) || ("".equals(this.p.trim())))
            {
              c();
              return false;
            }
            if ("action_reactive".equals(this.h))
            {
              this.o = "51";
              if ((!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImg")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImgDec")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("sendImg")))
              {
                c();
                return false;
              }
              this.t = this.jdField_a_of_type_AndroidOsBundle.getString("recImg");
              this.u = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("recImgDec"), 20, true, false);
              this.v = this.jdField_a_of_type_AndroidOsBundle.getString("sendImg");
              if (("".equals(this.t)) || ("".equals(this.u)) || ("".equals(this.v)))
              {
                c();
                return false;
              }
            }
            LogUtility.c("SocialFriendChooser", "-->typeid = " + this.o);
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
            this.m = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) {
            this.r = this.jdField_a_of_type_AndroidOsBundle.getString("img");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
            this.s = this.jdField_a_of_type_AndroidOsBundle.getString("source");
          }
          OpenSdkFriendService.a().a(this.f, this.i);
          this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("BuddiesSelected");
          return true;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("SocialFriendChooser", "initParams exception." + localException.getMessage(), localException);
        c();
        return false;
      }
      c();
      return false;
      label840:
      String str2 = "1";
    }
  }
  
  protected void b()
  {
    String str1 = null;
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131362642), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.f);
    localBundle.putString("hopenid", this.i);
    localBundle.putString("keystr", this.g);
    localBundle.putString("keytype", this.jdField_j_of_type_JavaLangString);
    localBundle.putString("platform", this.jdField_k_of_type_JavaLangString);
    localBundle.putString("encrytoken", this.l);
    localBundle.putString("agentversion", CommonDataAdapter.a().d());
    localBundle.putString("appid_for_getting_config", this.f);
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("desc")) {
      localBundle.putString("desc", StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("desc"), 70, true, false));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("picurl")) {
      localBundle.putString("picurl", this.jdField_a_of_type_AndroidOsBundle.getString("picurl"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
      localBundle.putString("source", this.jdField_a_of_type_AndroidOsBundle.getString("source"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
      localBundle.putString("pf", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkv")) {
      localBundle.putString("sdkv", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkp")) {
      localBundle.putString("sdkp", this.jdField_a_of_type_AndroidOsBundle.getString("sdkp"));
    }
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(str2);
      if (localFriend.b == -1) {
        ((StringBuilder)localObject).append(str2).append(",");
      } else {
        localStringBuilder.append(str2).append("_").append(localFriend.b).append(",");
      }
    }
    int i1 = ((StringBuilder)localObject).lastIndexOf(",");
    if (i1 != -1) {
      ((StringBuilder)localObject).deleteCharAt(i1);
    }
    i1 = localStringBuilder.lastIndexOf(",");
    if (i1 != -1) {
      localStringBuilder.deleteCharAt(i1);
    }
    localBundle.putString("app_rid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c));
    localBundle.putString("app_tid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.d));
    localBundle.putString("recom_openids", localStringBuilder.toString());
    if ("action_invite".equals(this.h))
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject).toString());
      str1 = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject = "GET";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask = new HttpCgiAsyncTask(str1, (String)localObject, this);
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a(localBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, 45000L);
      return;
      if (("action_gift".equals(this.h)) || ("action_ask".equals(this.h)) || ("action_reactive".equals(this.h)))
      {
        if ("action_reactive".equals(this.h)) {
          localBundle.putString("imgurl", this.v);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.q)) {
            localBundle.putString("title", this.q);
          }
          if (!TextUtils.isEmpty(this.p)) {
            localBundle.putString("sendmsg", this.p);
          }
          localBundle.putString("receiver", ((StringBuilder)localObject).toString());
          localBundle.putString("typeid", this.o);
          str1 = ServerSetting.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
          localObject = "POST";
          break;
          if (!TextUtils.isEmpty(this.r)) {
            localBundle.putString("imgurl", this.r);
          }
        }
      }
      localObject = null;
    }
  }
  
  public void b(Intent paramIntent)
  {
    l();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(CommonDataAdapter.a().a(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0) {
      LogUtility.e("SocialFriendChooser", "onGetBuddyListError{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  protected void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    LogUtility.e("SocialFriendChooser", "initParams:error code:-5; error msg:传入参数有误!");
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
      LogUtility.e("SocialFriendChooser", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", getResources().getString(2131362658), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.f);
    localBundle.putString("hopenid", this.i);
    localBundle.putString("keystr", this.g);
    localBundle.putString("keytype", this.jdField_j_of_type_JavaLangString);
    localBundle.putString("platform", this.jdField_k_of_type_JavaLangString);
    localBundle.putString("encrytoken", this.l);
    if (this.m != null) {
      localBundle.putString("pf", this.m);
    }
    localBundle.putString("appid_for_getting_config", this.f);
    if (("action_gift".equals(this.h)) || ("action_ask".equals(this.h)) || ("action_reactive".equals(this.h))) {
      localBundle.putString("typeid", this.o);
    }
    localBundle.putString("agentversion", CommonDataAdapter.a().d());
    localBundle.putString("appid_for_getting_config", this.f);
    OpenSdkFriendService.a().a(localBundle, this, this.h);
  }
  
  public void e()
  {
    String str = null;
    if (this.jdField_j_of_type_Int == 0) {
      if ("action_invite".equals(this.h)) {
        str = super.getString(2131362665, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
      }
    }
    for (;;)
    {
      ToastUtil.a().a(str, 0);
      return;
      if ("action_ask".equals(this.h))
      {
        str = super.getString(2131362666, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
      }
      else if ("action_gift".equals(this.h))
      {
        str = super.getString(2131362667, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
      }
      else if ("action_reactive".equals(this.h))
      {
        str = super.getString(2131362665, new Object[] { Integer.valueOf(this.jdField_k_of_type_Int) });
        continue;
        str = super.getString(2131362653, new Object[] { Integer.valueOf(this.jdField_j_of_type_Int) });
      }
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(0);
    a();
    d();
    if (this.h.equals("action_invite"))
    {
      paramBundle = super.getString(2131362673);
      ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
    }
    do
    {
      while ("action_invite".equals(this.h))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.INVITE.FS", this.f);
        return;
        if ((this.h.equals("action_reactive")) || (this.h.equals("action_gift")) || (this.h.equals("action_ask")))
        {
          paramBundle = super.getString(2131362674);
          ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
        }
      }
      if ("action_ask".equals(this.h))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.REQUEST.FS", this.f);
        return;
      }
      if ("action_gift".equals(this.h))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.FREEGIFT.FS", this.f);
        return;
      }
    } while (!"action_reactive".equals(this.h));
    StaticAnalyz.a("100", "ANDROIDQQ.REACTIVE.FS", this.f);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10001);
    OpenSdkFriendService.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */