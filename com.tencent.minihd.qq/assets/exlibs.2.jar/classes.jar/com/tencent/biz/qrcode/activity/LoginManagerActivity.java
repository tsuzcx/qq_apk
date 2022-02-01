package com.tencent.biz.qrcode.activity;

import QQService.SvcReqKikOut;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import clt;
import clv;
import clw;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.NewIntent;

public class LoginManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected Button a;
  public ImageView a;
  protected TextView a;
  protected TextView b;
  
  public void a()
  {
    if (this.app.isLogin())
    {
      Object localObject2 = this.app.a();
      localObject1 = new UniPacket(true);
      ((UniPacket)localObject1).setEncodeName("utf-8");
      int i = MobileQQService.c;
      MobileQQService.c = i + 1;
      ((UniPacket)localObject1).setRequestId(i);
      SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut(Long.parseLong((String)localObject2), 1L, (byte)0, new byte[0]);
      ((UniPacket)localObject1).setServantName("StatSvc");
      ((UniPacket)localObject1).setFuncName("SvcReqKikOut");
      ((UniPacket)localObject1).put("req", localSvcReqKikOut);
      localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject2, "StatSvc.SvcReqKikOut");
      ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject1).encode());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      localObject1 = new NewIntent(this.app.getApplication(), TempServlet.class);
      ((NewIntent)localObject1).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject2);
      this.app.startServlet((NewIntent)localObject1);
    }
    QQToast.a(this, -1, 2131363573, 0).a();
    super.finish();
    Object localObject1 = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    ((Intent)localObject1).putExtra("status", "logout");
    super.sendBroadcast((Intent)localObject1);
  }
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this, 230);
    paramView.setMessage(2131363572);
    paramView.setPositiveButton(2131363599, new clv(this));
    paramView.setNegativeButton(2131365736, new clw(this));
    paramView.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903622);
    super.setTitle(2131363570);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298989));
    this.b = ((TextView)findViewById(2131298986));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298992));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298985));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramBundle = this.app.a();
    this.b.setText(ContactUtils.g(this.app, paramBundle));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131363567, new Object[] { getIntent().getStringExtra("loginInfo") }));
    new clt(this, paramBundle).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.LoginManagerActivity
 * JD-Core Version:    0.7.0.1
 */