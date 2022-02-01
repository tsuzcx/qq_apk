package com.tencent.biz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class TenpayActivity
  extends BaseActivity
{
  private static final String i = "TenpayActivity";
  private static final String j = "app";
  private static final String k = "qrcode";
  private static final String l = "web";
  private static final String m = "schema";
  protected int a;
  protected QWalletPayProgressDialog a;
  protected String a;
  protected String b = null;
  protected String c = null;
  protected String d = null;
  protected String e = null;
  protected String f = null;
  protected String g = null;
  protected String h = null;
  
  public TenpayActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    PayBridgeActivity.a(this, this.h, 9, str, this.g);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TenpayActivity", 2, "setResultAndFinish activityResult=" + paramInt1 + ",errorCode=" + paramInt2 + ",msg=" + paramString1 + ",response=" + paramString2);
    }
    Object localObject;
    if ("app".equals(this.b))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_error_code", paramInt2);
      ((Intent)localObject).putExtra("key_error_msg", paramString1);
      ((Intent)localObject).putExtra("key_error_detail", "");
      ((Intent)localObject).putExtra("key_response", paramString2);
      super.setResult(paramInt1, (Intent)localObject);
    }
    label538:
    label567:
    do
    {
      do
      {
        super.finish();
        return;
        if ("schema".equals(this.b))
        {
          localObject = new Bundle();
          if (paramInt1 == 0) {
            ((Bundle)localObject).putString("result", "cancel");
          }
          for (;;)
          {
            paramString1 = "tencent" + this.c + "://connect.qq.com/?#action=payByQQ&" + HttpUtil.a((Bundle)localObject);
            paramString2 = new Intent("android.intent.action.VIEW");
            paramString2.setData(Uri.parse(paramString1));
            super.startActivity(paramString2);
            break;
            if (paramInt2 == 0)
            {
              ((Bundle)localObject).putString("result", "complete");
              ((Bundle)localObject).putString("response", paramString2);
            }
            else
            {
              ((Bundle)localObject).putString("result", "error");
              ((Bundle)localObject).putInt("errorCode", paramInt2);
              ((Bundle)localObject).putString("response", paramString1);
            }
          }
        }
      } while (!"web".equals(this.b));
      if (("javascript".equals(this.d)) && (!"".equals(this.e))) {
        for (;;)
        {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramString1 = "";
            paramInt1 = paramString2.optInt("ret");
            paramString2 = paramString2.optJSONObject("data");
            if (paramString2 != null)
            {
              paramString1 = paramString2.optString("callback_url", "");
              localObject = paramString2.optString("sp_data", "");
              paramString2 = URLDecoder.decode(paramString1, "UTF-8");
              localObject = URLDecoder.decode((String)localObject, "UTF-8");
              if ((paramString2 == null) || (paramString2.length() <= 0)) {
                break label567;
              }
              paramString1 = paramString2;
              if (localObject != null)
              {
                paramString1 = paramString2;
                if (((String)localObject).length() > 0)
                {
                  if (paramString2.indexOf("?") != -1) {
                    break label538;
                  }
                  paramString1 = paramString2 + "?" + (String)localObject;
                }
              }
            }
            paramString1 = paramInt1 + ",'" + paramString1 + "'";
            setResult(-1, new Intent().putExtra("callback_type", this.d).putExtra("callback_name", this.e).putExtra("callback_data", paramString1));
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
          }
          break;
          paramString1 = paramString2 + "&" + (String)localObject;
          continue;
          paramString1 = "";
        }
      }
    } while (!"url".equals(this.d));
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONObject("data");
        paramString1 = paramString2.optString("callback_url", "");
        paramString2 = paramString2.optString("sp_data", "");
        if ("".equals(paramString1)) {
          break;
        }
        paramString1 = URLDecoder.decode(paramString1, "UTF-8");
        if (paramString1.indexOf("?") != -1) {
          break label731;
        }
        paramString1 = paramString1 + "?";
        paramString1 = paramString1 + URLDecoder.decode(paramString2, "UTF-8");
        setResult(-1, new Intent().putExtra("callback_type", this.d).putExtra("callback_url", paramString1));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      break;
      label731:
      paramString1 = paramString1 + "&";
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog != null) {
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TenpayActivity", 2, "onActivityResult request=" + paramInt1 + " result=" + paramInt2);
    }
    String str;
    if (paramInt1 == 9)
    {
      str = null;
      if (paramIntent != null) {
        str = paramIntent.getStringExtra("result");
      }
      if (TextUtils.isEmpty(str)) {
        a(-1, 0, "", "{ret: -100, data: " + "{'resultCode':-100,'retmsg':'pay result unknow exception'}" + "}");
      }
    }
    else
    {
      return;
    }
    try
    {
      paramInt1 = new JSONObject(str).getInt("resultCode");
      a(-1, 0, "", "{ret: " + paramInt1 + ", data: " + str + "}");
      return;
    }
    catch (JSONException paramIntent)
    {
      a(-1, 0, "", "{ret: -100, data: " + "{'resultCode':-100,'retmsg':'pay result json exception'}" + "}");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getIntent().getExtras();
    if (paramBundle == null)
    {
      a(-1, -5, "传入参数有误!", "");
      return;
    }
    Object localObject;
    if (paramBundle.containsKey("key_action"))
    {
      if ("action_pay_by_qq".equals(paramBundle.getString("key_action")))
      {
        localObject = paramBundle.getBundle("key_params");
        this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("token_id");
        if (this.jdField_a_of_type_JavaLangString == null) {
          this.jdField_a_of_type_JavaLangString = "";
        }
        this.b = ((Bundle)localObject).getString("src_type");
        if (this.b == null) {
          this.b = "";
        }
        this.c = paramBundle.getString("app_id");
        if (this.c == null) {
          this.c = "";
        }
        this.f = paramBundle.getString("app_info");
        if (this.f == null) {
          this.f = "";
        }
        this.g = paramBundle.getString("url_app_info");
        if (this.g == null) {
          this.g = "";
        }
        this.jdField_a_of_type_Int = 4;
        this.h = null;
        localObject = paramBundle.getString("params");
        for (;;)
        {
          try
          {
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
            paramBundle = new JSONObject(URLDecoder.decode((String)localObject));
            paramBundle.put("appInfo", this.f);
            paramBundle.put("tokenId", this.jdField_a_of_type_JavaLangString);
            paramBundle.put("comeForm", this.jdField_a_of_type_Int);
            this.h = paramBundle.toString();
          }
          catch (JSONException paramBundle)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("TenpayActivity", 2, "invalid json params:" + (String)localObject);
            continue;
            a(true);
            a();
            return;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.h))) {
            continue;
          }
          a(-1, -5, "传入参数有误!", "");
          return;
          paramBundle = new JSONObject();
        }
      }
      a(-1, -5, "传入参数有误!", "");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("token_id");
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    this.b = paramBundle.getString("src_type");
    if (this.b == null) {
      this.b = "";
    }
    this.c = paramBundle.getString("app_id");
    if (this.c == null) {
      this.c = "";
    }
    this.d = paramBundle.getString("callback_type");
    if (this.d == null) {
      this.d = "";
    }
    this.e = paramBundle.getString("callback_name");
    if (this.e == null) {
      this.e = "";
    }
    this.f = paramBundle.getString("app_info");
    if (this.f == null) {
      this.f = "";
    }
    this.g = paramBundle.getString("url_app_info");
    if (this.g == null) {
      this.g = "";
    }
    if ("qrcode".equals(this.b))
    {
      this.jdField_a_of_type_Int = 3;
      this.h = null;
      localObject = paramBundle.getString("params");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramBundle = new JSONObject(URLDecoder.decode((String)localObject));
        paramBundle.put("appInfo", this.f);
        paramBundle.put("tokenId", this.jdField_a_of_type_JavaLangString);
        paramBundle.put("comeForm", this.jdField_a_of_type_Int);
        this.h = paramBundle.toString();
      }
      catch (JSONException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TenpayActivity", 2, "invalid json params:" + (String)localObject);
        continue;
        a(-1, -5, "传入参数有误!", "");
      }
      if ((TextUtils.isEmpty(this.h)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((!"qrcode".equals(this.b)) && (!"web".equals(this.b)) && (!"schema".equals(this.b)))) {
        continue;
      }
      a(true);
      a();
      return;
      if ("web".equals(this.b))
      {
        this.jdField_a_of_type_Int = 1;
        break;
      }
      if (!"schema".equals(this.b)) {
        break;
      }
      this.jdField_a_of_type_Int = 4;
      break;
      paramBundle = new JSONObject();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.TenpayActivity
 * JD-Core Version:    0.7.0.1
 */