package com.pay.paychannel.wx;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.ui.common.APActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.plugin.APPluginActivity;

public class APWechatActivity
  extends APActivity
{
  public String d = "请稍候...";
  public TextView e = null;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165235);
    paramBundle = (ProgressBar)findViewById(2131100038);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.4F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setRepeatMode(2);
    paramBundle.setAnimation(localAlphaAnimation);
    localAlphaAnimation.start();
    this.e = ((TextView)findViewById(2131099738));
    this.e.setText(this.d);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    finish();
    APUICommonMethod.a(this);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onRestart()
  {
    super.onRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.paychannel.wx.APWechatActivity
 * JD-Core Version:    0.7.0.1
 */