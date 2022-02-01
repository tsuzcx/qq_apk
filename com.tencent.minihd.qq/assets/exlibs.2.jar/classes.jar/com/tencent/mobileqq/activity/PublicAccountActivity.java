package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;

public class PublicAccountActivity
  extends PublicAccountBrowser
{
  public static final String a = "PublicAccountActivity";
  private static final String b = "https://find.qq.com/m/new/index.html?_wv=1026&_bid=320";
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, PublicAccountActivity.class);
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).a());
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "https://find.qq.com/m/new/index.html?_wv=1026&_bid=320");
    localIntent.putExtra("new_task_show_right_belong_tab", Utils.b(paramActivity));
    localIntent.addFlags(268435456);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString) {}
  
  protected void b()
  {
    super.b();
    this.leftView.setText(getString(2131369875));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountActivity
 * JD-Core Version:    0.7.0.1
 */