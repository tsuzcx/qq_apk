package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import kgt;
import kgu;

public class TroopBarShareActivity
  extends QQBrowserActivity
{
  protected long a;
  protected Context a;
  protected Handler a;
  protected String a;
  public String b;
  
  public TroopBarShareActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a()
  {
    if (isFinishing()) {
      return;
    }
    ShareAioResultDialog localShareAioResultDialog = new ShareAioResultDialog(this);
    localShareAioResultDialog.a(getString(2131364108));
    Object localObject2 = getString(2131363684);
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaLangString != null) {
      localObject1 = (String)localObject2 + this.jdField_a_of_type_JavaLangString;
    }
    localObject2 = new kgu(this);
    String str = getString(2131364107);
    localShareAioResultDialog.a((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    localShareAioResultDialog.b(str, (DialogInterface.OnClickListener)localObject2);
    localShareAioResultDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = this;
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("share_app_name");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("share_app_id", 0L);
    this.b = paramBundle.getStringExtra("bid");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kgt(this), 300L);
    return true;
  }
  
  public void finish()
  {
    super.finish();
    TroopBarShareUtils.b(this, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarShareActivity
 * JD-Core Version:    0.7.0.1
 */