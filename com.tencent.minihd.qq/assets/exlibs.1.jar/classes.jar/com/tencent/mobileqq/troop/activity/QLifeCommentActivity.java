package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import kfd;
import kfe;
import kff;
import kfg;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QLifeCommentActivity
  extends TroopBarPublishActivity
{
  private static final int af = 1001;
  private static final int ag = 1002;
  protected static final String ag = "QLifeCommentActivity";
  private static final String aj = "https://cgi.qlife.qq.com/cgi-bin/social/binary_upload.fcg?";
  private static final String ak = "https://cgi.qlife.qq.com/cgi-bin/social/comment.fcg?";
  private static final String al = "https://cgi.qlife.qq.com/cgi-bin/shop/shop_list.fcg?";
  private static final String am = "shopID";
  private static final String an = "couponID";
  private static final String ao = "sp";
  private static final String ap = "idType";
  private static final String aq = "source";
  private static final String ar = "stype";
  private static final String as = "selectHint";
  private static final String at = "selectWarning";
  private double a;
  protected kfg a;
  private String aA;
  private String aB;
  private String aC;
  private String aD;
  private String au;
  private String av;
  private String aw;
  private String ax;
  private String ay;
  private String az;
  private double b;
  protected View d;
  public TextView d;
  public TextView e;
  private boolean o = false;
  
  private void a(double paramDouble1, double paramDouble2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", new Bundle());
    localHashMap.put("CONTEXT", getApplicationContext());
    new HttpWebCgiAsyncTask2("https://cgi.qlife.qq.com/cgi-bin/shop/shop_list.fcg?cid=" + this.ax + "&maplat=" + paramDouble1 + "&maplng=" + paramDouble2 + "&coordinate=1", "", this, 1002, null).a(localHashMap);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.aw = paramJSONObject.optString("shopID");
    this.ax = paramJSONObject.optString("couponID");
    this.ay = paramJSONObject.optString("sp");
    this.az = paramJSONObject.optString("idType");
    this.aA = paramJSONObject.optString("source");
    this.aB = paramJSONObject.optString("stype");
    boolean bool2 = this.jdField_e_of_type_Boolean;
    if (!this.f) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = (bool1 & bool2);
      this.aC = paramJSONObject.optString("selectHint");
      this.aD = paramJSONObject.optString("selectWarning");
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (isFinishing()) {}
    label7:
    do
    {
      do
      {
        return;
      } while (paramJSONObject == null);
      switch (paramInt)
      {
      default: 
        return;
      case 1001: 
        paramInt = paramJSONObject.optInt("ret", -1);
        if (paramInt == 0)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("result", paramJSONObject.toString());
          setResult(-1, paramBundle);
          finish();
          QQToast.a(this, 2, 2131363933, 1).b(getTitleBarHeight());
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "success", 0, 0, paramJSONObject.optString("comment_id"), this.ay, this.jdField_b_of_type_JavaUtilArrayList.size() + "", this.aB);
        }
        for (;;)
        {
          this.o = false;
          return;
          paramBundle = paramJSONObject.optString("msg");
          paramJSONObject = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            paramJSONObject = getString(2131363871, new Object[] { Integer.valueOf(paramInt) });
          }
          QQToast.a(this, 1, paramJSONObject, 0).b(getTitleBarHeight());
          b(false);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
          this.rightViewText.setEnabled(true);
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "fail", 0, 0, "", this.ay, this.jdField_b_of_type_JavaUtilArrayList.size() + "", this.aB);
        }
      }
    } while (paramJSONObject.optInt("retcode", -1) != 0);
    for (;;)
    {
      try
      {
        paramBundle = paramJSONObject.optJSONObject("result");
        if (paramBundle == null) {
          break label7;
        }
        paramJSONObject = paramBundle.optString("biz_name");
        paramBundle = paramBundle.optJSONArray("shops");
        if ((paramBundle == null) || (paramBundle.length() <= 0)) {
          break label7;
        }
        paramBundle = paramBundle.getJSONObject(0);
        this.az = "1";
        this.ay = paramBundle.optString("source_id");
        if (!this.ay.equals("1")) {
          break label522;
        }
        this.aw = paramBundle.optString("shop_id");
        if ((TextUtils.isEmpty(this.aw)) || (TextUtils.isEmpty(paramJSONObject))) {
          break label7;
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        this.S = ("https://cgi.qlife.qq.com/cgi-bin/social/binary_upload.fcg?sid=" + this.au + "&sp=" + this.ay + "&shopid=" + this.aw);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QLifeCommentActivity", 2, "get nearest shop, JSONException :" + paramJSONObject);
      return;
      label522:
      this.aw = paramBundle.optString("sp_id");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle == null) {}
    do
    {
      return false;
      this.au = paramBundle.getSid(this.app.getAccount());
      this.av = paramBundle.getSkey(this.app.getAccount());
    } while ((TextUtils.isEmpty(this.au)) && (TextUtils.isEmpty(this.av)));
    this.S = ("https://cgi.qlife.qq.com/cgi-bin/social/binary_upload.fcg?sid=" + this.au + "&sp=" + this.ay + "&shopid=" + this.aw);
    this.jdField_a_of_type_Kfg = new kfg(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    registerReceiver(this.jdField_a_of_type_Kfg, paramBundle, "com.tencent.msg.permission.pushnotify2", null);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "write", 0, 0, "", "", "", this.aB);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    unregisterReceiver(this.jdField_a_of_type_Kfg);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_d_of_type_AndroidViewView = findViewById(2131298818);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298819));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298820));
    if (TextUtils.isEmpty(this.aC)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setHint(2131363847);
    }
    for (;;)
    {
      if (!this.f) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
      if (!TextUtils.isEmpty(this.jdField_U_of_type_JavaLangString)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_U_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.V)) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.V);
      }
      this.rightViewText.setEnabled(false);
      if ((!TextUtils.isEmpty(this.ax)) && (this.f)) {
        SosoInterface.a(new kfd(this, 0, true, 0L, false, false, "QLifeCommentActivity"));
      }
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setHint(this.aC);
    }
  }
  
  public void k()
  {
    int j = 0;
    try
    {
      InputMethodUtil.b(this.jdField_b_of_type_AndroidWidgetEditText);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.a = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = null;
      }
      if (!HttpUtil.a(this)) {
        QQToast.a(this, 2131365807, 0).b(getTitleBarHeight());
      }
      do
      {
        return;
        if (TextUtils.isEmpty(this.aw))
        {
          if (TextUtils.isEmpty(this.aD)) {
            QQToast.a(this, 2131363849, 1).b(getTitleBarHeight());
          }
          for (;;)
          {
            s();
            return;
            QQToast.a(this, this.aD, 1).b(getTitleBarHeight());
          }
        }
        localObject1 = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = ((String)localObject1).trim();
        i = ((String)localObject1).length();
        if (i < this.P)
        {
          QQToast.a(this, getString(2131363897, new Object[] { Integer.valueOf(this.P) }), 0).b(getTitleBarHeight());
          return;
        }
        if (i > this.Q)
        {
          QQToast.a(this, getString(2131363898, new Object[] { Integer.valueOf(this.Q) }), 0).b(getTitleBarHeight());
          return;
        }
      } while (!a(this.jdField_U_of_type_Int, this.l));
      b(true);
      this.rightViewText.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(false);
      this.o = true;
      i = 0;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(localObject2) == null)
        {
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          return;
        }
        i += 1;
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("cmd", "100");
      ((Bundle)localObject2).putString("sp", this.ay);
      ((Bundle)localObject2).putString("shop_id", this.aw);
      ((Bundle)localObject2).putString("id_type", this.az);
      ((Bundle)localObject2).putString("source", this.aA);
      ((Bundle)localObject2).putString("text", (String)localObject1);
      ((Bundle)localObject2).putString("time", System.currentTimeMillis() + "");
      Object localObject1 = new StringBuilder();
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList);
        i = j;
        while (i < localArrayList.size())
        {
          Object localObject3 = (String)localArrayList.get(i);
          localObject3 = (TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(localObject3);
          if (localObject3 != null) {
            ((StringBuilder)localObject1).append(((TroopBarPostContentEntity.Pic_list)localObject3).url).append(",");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      ((Bundle)localObject2).putString("spic", ((StringBuilder)localObject1).toString());
      ((Bundle)localObject2).putString("version", "5.9.3");
      ((Bundle)localObject2).putString("platform", "android");
      ((Bundle)localObject2).putString("Origin", "https://qlife.qq.com");
      ((Bundle)localObject2).putString("Cookie", "skey=" + this.av);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localObject2);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      new HttpWebCgiAsyncTask2("https://cgi.qlife.qq.com/cgi-bin/social/comment.fcg?sid=" + this.au, "", this, 1001, null).a((HashMap)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        int i = 0;
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.o)
    {
      a(this);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", this.aB);
      return true;
    }
    Object localObject = getString(2131367300);
    String str = getString(2131363848);
    localObject = DialogUtil.a(this, 230).setTitle((String)localObject).setMessage(str);
    ((QQCustomDialog)localObject).setPositiveButton(getString(2131365732), new kfe(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setNegativeButton(getString(2131365733), new kff(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setPositiveButtonContentDescription(getString(2131365732));
    ((QQCustomDialog)localObject).setNegativeButtonContentDescription(getString(2131365732));
    ((QQCustomDialog)localObject).show();
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0)
    {
      this.rightViewText.setEnabled(false);
      return;
    }
    this.rightViewText.setEnabled(true);
  }
  
  protected void s()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder().append(this.W).append("&coordinate=1&maplat=");
    if (this.jdField_a_of_type_Double == 0.0D)
    {
      localObject = "0";
      localStringBuilder = localStringBuilder.append(localObject).append("&maplng=");
      if (this.jdField_b_of_type_Double != 0.0D) {
        break label103;
      }
    }
    label103:
    for (Object localObject = "0";; localObject = Double.valueOf(this.jdField_b_of_type_Double))
    {
      localIntent.putExtra("url", localObject);
      startActivity(localIntent);
      return;
      localObject = Double.valueOf(this.jdField_a_of_type_Double);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.QLifeCommentActivity
 * JD-Core Version:    0.7.0.1
 */