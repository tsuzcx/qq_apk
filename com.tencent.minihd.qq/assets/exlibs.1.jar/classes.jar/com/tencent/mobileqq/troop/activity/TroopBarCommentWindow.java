package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import kfs;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class TroopBarCommentWindow
  extends PublicCommentWindow
{
  Context a;
  public boolean c = false;
  public String e;
  String f;
  String g;
  String h;
  public String i = "0";
  protected String j;
  
  public TroopBarCommentWindow(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity.getApplicationContext();
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.e = this.jdField_a_of_type_OrgJsonJSONObject.optString("bid");
    this.f = this.jdField_a_of_type_OrgJsonJSONObject.optString("pid");
    this.g = this.jdField_a_of_type_OrgJsonJSONObject.optString("cid");
    this.h = this.jdField_a_of_type_OrgJsonJSONObject.optString("rid");
    if ("detail".equals(this.jdField_a_of_type_OrgJsonJSONObject.optString("from"))) {}
    for (paramBundle = "0";; paramBundle = "1")
    {
      this.i = paramBundle;
      this.j = this.jdField_a_of_type_OrgJsonJSONObject.optString("extparam");
      this.b = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().getAccount() + "-" + this.e + "-" + this.f + "-" + this.g + "-" + this.h);
      TroopBarUtils.a("two_comment", "exp", this.e, this.i, "", "");
      return;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pid", this.f);
      localJSONObject.put("cid", this.g);
      localJSONObject.put("bid", Integer.parseInt(this.e));
      localJSONObject.put("target_rid", this.h);
      localJSONObject.put("comment", TroopBarPublishActivity.a(paramString, null, null, null, null));
      localJSONObject.put("extparam", this.j);
      paramString = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ProtoServlet.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.recomment");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramString.setObserver(new kfs(this));
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131363870, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.c = false;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if ((this.jdField_a_of_type_AndroidWidgetEditText != null) && (this.jdField_a_of_type_AndroidWidgetEditText.length() > 0)) {}
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("two_comment", "un", this.e, str, "", "");
      if (!this.jdField_a_of_type_Boolean) {
        a(this.d, null, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow
 * JD-Core Version:    0.7.0.1
 */