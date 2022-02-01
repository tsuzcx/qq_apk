package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopBarPostContentEntity.Pic_list;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.data.VideoInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Hashtable;
import kgs;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class TroopBarReplyActivity
  extends AbsReplyActivity
{
  public static final String a;
  public static final String b = "bid";
  public static final String c = "pid";
  public String d = null;
  protected String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopBarReplyActivity.class.getName();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.af = paramJSONObject.optString("bid", "");
    this.d = paramJSONObject.optString("pid", "");
    this.aa = (this.app.a() + "-" + this.af + "-" + this.d);
    this.e = paramJSONObject.optString("extparam");
    this.ad = "Grp_tribe";
    this.ae = "reply_page";
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    TroopBarUtils.a("reply_page", "choose_place", this.af, "2", "", "");
  }
  
  protected void e()
  {
    super.e();
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.U & 0x1) == 1) {
      localStringBuffer.append("0");
    }
    if ((this.U & 0x2) == 2) {
      localStringBuffer.append("1");
    }
    if ((this.U & 0x4) == 4) {
      localStringBuffer.append("2");
    }
    if ((this.U & 0x8) == 8) {
      localStringBuffer.append("3");
    }
    TroopBarUtils.a("reply_page", "choose_place", this.af, "0", localStringBuffer.toString(), "");
    TroopBarUtils.a("reply_page", "exp", String.valueOf(this.af), "", "", "");
  }
  
  public void finish()
  {
    super.finish();
    if (((this.jdField_b_of_type_AndroidWidgetEditText != null) && (this.jdField_b_of_type_AndroidWidgetEditText.length() > 0)) || ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))) {}
    for (String str = "0";; str = "1")
    {
      TroopBarUtils.a("reply_page", "un", this.af, str, "", "");
      return;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity$PreUploadTask = null;
    }
    Object localObject1 = TroopBarUtils.a(this.jdField_b_of_type_AndroidWidgetEditText);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = ((String)localObject1).trim();
    }
    for (int i = ((String)localObject1).length();; i = 0)
    {
      if ((!this.j) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (i == 0)
        {
          QQToast.a(this, 2131363900, 0).b(getTitleBarHeight());
          TroopBarUtils.a("reply_page", "fail", this.af, "2", "", "");
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i < this.P)
        {
          QQToast.a(this, getString(2131363901, new Object[] { Integer.valueOf(this.P) }), 0).b(getTitleBarHeight());
          TroopBarUtils.a("reply_page", "fail", this.af, "2", "", "");
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        if (i > this.Q)
        {
          QQToast.a(this, getString(2131363902, new Object[] { Integer.valueOf(this.Q) }), 0).b(getTitleBarHeight());
          TroopBarUtils.a("reply_page", "fail", this.af, "4", "", "");
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      if (!a(this.U, this.l))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      if (!HttpUtil.a(this))
      {
        QQToast.a(this, 2131365807, 0).b(getTitleBarHeight());
        TroopBarUtils.a("reply_page", "fail", this.af, "7", "", "");
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      b(true);
      i = 0;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject2 = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if ((TroopBarPostContentEntity.Pic_list)TroopBarUtils.a.get(localObject2) == null)
        {
          this.jdField_a_of_type_Boolean = false;
          a(1, this.jdField_a_of_type_AndroidOsHandler);
          TroopBarUtils.a("reply_page", "fail", this.af, "10", "", "");
          return;
        }
        i += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.url == null))
      {
        this.jdField_a_of_type_Boolean = false;
        a(2, this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.e == null))
      {
        this.jdField_a_of_type_Boolean = false;
        a(3, this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      Object localObject2 = a((String)localObject1, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo);
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("pid", this.d);
        ((JSONObject)localObject1).put("bid", Integer.parseInt(this.af));
        ((JSONObject)localObject1).put("comment", localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
        {
          ((JSONObject)localObject1).put("uid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.h);
          ((JSONObject)localObject1).put("lat", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.b));
          ((JSONObject)localObject1).put("lon", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a));
        }
        ((JSONObject)localObject1).put("extparam", this.e);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localObject2 = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
        ((NewIntent)localObject2).putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.comment");
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.type.set(0);
        localWebSsoRequestBody.data.set(((JSONObject)localObject1).toString());
        ((NewIntent)localObject2).putExtra("data", localWebSsoRequestBody.toByteArray());
        ((NewIntent)localObject2).setObserver(new kgs(this));
        this.app.startServlet((NewIntent)localObject2);
        return;
      }
      catch (Exception localException)
      {
        QQToast.a(this, 1, 2131363870, 0).b(getTitleBarHeight());
        b(false);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298814: 
      String str = this.af;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {}
      for (paramView = "0";; paramView = "1")
      {
        TroopBarUtils.a("reply_page", "Clk_place", str, paramView, "", "");
        return;
      }
    case 2131298842: 
      TroopBarUtils.a("reply_page", "del_photo", this.af, "", "", "");
      return;
    }
    TroopBarUtils.a("pub_page", "choose_photo", this.af, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarReplyActivity
 * JD-Core Version:    0.7.0.1
 */