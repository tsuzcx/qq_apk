package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cmx;
import cmy;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.net.URLDecoder;
import mqq.app.NewIntent;

public class QRJumpActivity
  extends BaseActivity
{
  protected QQProgressDialog a;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent().getStringExtra("url");
    if (TextUtils.isEmpty(paramBundle))
    {
      finish();
      return false;
    }
    this.a = new QQProgressDialog(this, super.getTitleBarHeight());
    this.a.b(2131363600);
    this.a.setOnCancelListener(new cmx(this));
    this.a.show();
    paramBundle = URLDecoder.decode(paramBundle);
    cmy localcmy = new cmy(this, this, paramBundle);
    NewIntent localNewIntent = new NewIntent(this, QRCodeServlet.class);
    localNewIntent.putExtra("d", paramBundle);
    localNewIntent.putExtra("cmd", "QRCodeSvc.decode");
    localNewIntent.putExtra("bqq", "1");
    localNewIntent.setObserver(localcmy);
    this.app.startServlet(localNewIntent);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRJumpActivity
 * JD-Core Version:    0.7.0.1
 */