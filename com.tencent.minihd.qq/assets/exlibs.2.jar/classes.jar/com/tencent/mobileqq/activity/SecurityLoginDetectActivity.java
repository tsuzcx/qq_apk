package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class SecurityLoginDetectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  private void a()
  {
    if (SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841612);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.b.setText(2131368976);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368974);
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "show open login secure view", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841615);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.b.setText(2131368975);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131368973);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904397);
    setTitle(2131368950);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302078));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302075));
    this.b = ((TextView)findViewById(2131302077));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302076));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131302078)
    {
      SettingCloneUtil.writeValue(this, null, "security_scan_key", "qqsetting_security_scan_key", true);
      a();
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on open login secure", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityLoginDetectActivity
 * JD-Core Version:    0.7.0.1
 */