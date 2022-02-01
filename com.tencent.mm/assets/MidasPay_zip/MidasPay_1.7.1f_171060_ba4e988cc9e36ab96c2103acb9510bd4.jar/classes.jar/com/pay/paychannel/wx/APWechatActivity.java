package com.pay.paychannel.wx;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;

public class APWechatActivity
  extends APActivity
{
  private String a = "请稍候...";
  private TextView b = null;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165234);
    paramBundle = (ProgressBar)findViewById(2131100038);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setRepeatMode(2);
    paramBundle.setAnimation(localAlphaAnimation);
    localAlphaAnimation.start();
    this.b = ((TextView)findViewById(2131099738));
    this.b.setText(this.a);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    finish();
    APUICommonMethod.b(this);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.wx.APWechatActivity
 * JD-Core Version:    0.7.0.1
 */