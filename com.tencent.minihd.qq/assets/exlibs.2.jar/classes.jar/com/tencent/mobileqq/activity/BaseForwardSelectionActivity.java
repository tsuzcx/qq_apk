package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;

public class BaseForwardSelectionActivity
  extends BaseActivity
{
  private Bundle a;
  protected ForwardOperations a;
  protected boolean a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 20001: 
      setResult(-1, paramIntent);
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a(paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("call_by_forward", false);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsBundle = paramBundle.getExtras();
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.app, getIntent(), this.jdField_a_of_type_AndroidOsBundle);
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968589, 2130968591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseForwardSelectionActivity
 * JD-Core Version:    0.7.0.1
 */