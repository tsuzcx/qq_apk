package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ThemeNoviceGuideActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private void a()
  {
    setLeftButton(2131367454, null);
    ((Button)findViewById(2131302304)).setOnClickListener(this);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    setContentView(2130904473);
    a();
    setTitle("主题装扮");
    return true;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    AlbumUtil.a(this, false, false);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131302304)
    {
      if (Utils.e())
      {
        finish();
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("FromWhere", "FromThemeNoviceGuide");
        VasWebviewUtil.a(this, "https://imgcache.qq.com/club/themes/mobile/theme/html/index.html?uin=[uin]&client=[client]&version=[version]&sid=[sid]&platformId=[platformId]&device=[device]&system=[system]&density=[density]&updateId=[updateId]&adTag=mvip.gongneng.android.theme.index_dynamic_tab&updateFlag=[updateFlag]&_bid=123&_wv=1027", 32L, paramView, false, -1);
        BusinessInfoCheckUpdateItem.a(this.app, "100005.100002", false);
      }
    }
    else {
      return;
    }
    Toast.makeText(this, getString(2131367289), 0).show();
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ThemeNoviceGuideActivity
 * JD-Core Version:    0.7.0.1
 */