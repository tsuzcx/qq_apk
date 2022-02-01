package cooperation.qlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import lye;
import lyf;

public class QlinkSendTipsActivity
  extends BaseActivity
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if (paramBoolean)
      {
        this.app.a().a("0X8004851", 1);
        return;
      }
      this.app.a().a("0X8004850", 1);
      return;
    case 2: 
      if (paramBoolean)
      {
        this.app.a().a("0X800485D", 1);
        return;
      }
      this.app.a().a("0X800485C", 1);
      return;
    case 3: 
      if (paramBoolean)
      {
        this.app.a().a("0X8004860", 1);
        return;
      }
      this.app.a().a("0X800485F", 1);
      return;
    case 4: 
      if (paramBoolean)
      {
        this.app.a().a("0X800485A", 1);
        return;
      }
      this.app.a().a("0X8004859", 1);
      return;
    }
    if (paramBoolean)
    {
      this.app.a().a("0X8004853", 1);
      return;
    }
    this.app.a().a("0X8004852", 1);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903806);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("_FILE_PATH_");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("_SEND_FILE_SRC_", -1);
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_qlink_enter_recent", false);
    paramBundle = (TextView)findViewById(2131299679);
    TextView localTextView = (TextView)findViewById(2131299680);
    paramBundle.setOnClickListener(new lye(this));
    localTextView.setOnClickListener(new lyf(this));
    a(false);
    return true;
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkSendTipsActivity
 * JD-Core Version:    0.7.0.1
 */