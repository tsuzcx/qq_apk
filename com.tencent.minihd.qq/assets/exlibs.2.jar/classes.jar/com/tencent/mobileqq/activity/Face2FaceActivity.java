package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.AddFriendScannerActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.qlink.QQProxyForQlink;
import dxt;

public class Face2FaceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String a = Face2FaceActivity.class.getSimpleName();
  
  private void a()
  {
    ((ImageView)findViewById(2131297630)).setOnClickListener(this);
    ((ImageView)findViewById(2131297631)).setOnClickListener(this);
    ((ImageView)findViewById(2131297632)).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131297348);
    localTextView.setText(getString(2131368590));
    localTextView.setContentDescription(getString(2131362031));
    localTextView = (TextView)findViewById(2131297357);
    localTextView.setVisibility(0);
    localTextView.setText(2131366374);
    localTextView.setContentDescription("返回，按钮");
    localTextView.setOnClickListener(new dxt(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903307);
    setContentBackgroundResource(2130837687);
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("fromFace2FaceActivity", true);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297630: 
      localIntent.setClass(this, AddFriendScannerActivity.class);
      startActivity(localIntent);
      ReportController.b(this.app, "CliOper", "", "", "0X80049F1", "0X80049F1", 0, 0, "", "", "", "");
      return;
    case 2131297631: 
      localIntent.setClass(this, CreateFaceToFaceDiscussionActivity.class);
      startActivity(localIntent);
      overridePendingTransition(2130968593, 2130968594);
      ReportController.b(this.app, "CliOper", "", "", "0X80049F0", "0X80049F0", 0, 0, "", "", "", "");
      return;
    }
    QQProxyForQlink.a(this, 8, null);
    ReportController.b(this.app, "CliOper", "", "", "0X80049F2", "0X80049F2", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Face2FaceActivity
 * JD-Core Version:    0.7.0.1
 */