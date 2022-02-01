package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kid;
import kie;

public class TroopLocationModifyActivity
  extends TroopCreateMapViewSupportActivity
{
  public static final int a = 41;
  public static final String a = "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit";
  long jdField_a_of_type_Long = 0L;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public Dialog b;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit");
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit");
    localIntent.putExtra("saveDirect", false);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    d(getString(2131368052));
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 5);
    localIntent.putExtra("troop_location", paramString);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 41);
  }
  
  private void g(String paramString)
  {
    Object localObject = paramString.split("\\|");
    String str = "";
    if (localObject.length == 4) {
      str = localObject[3];
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("location", str);
    ((Intent)localObject).putExtra("locationOriginal", paramString);
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  private void y()
  {
    if (this.b != null)
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      this.b = null;
    }
  }
  
  public void a()
  {
    y();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131368050);
    localActionSheet.a(2131368051, 3);
    localActionSheet.e(2131365736);
    localActionSheet.setOnDismissListener(new kid(this));
    localActionSheet.a(new kie(this));
    this.b = localActionSheet;
    this.b.show();
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      b(paramString);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, 2131365941, 0).b(getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      a();
      return;
    }
    f(paramString);
  }
  
  public void b(String paramString)
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, 2131365941, 0).b(getTitleBarHeight());
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    g(paramString);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    int i = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    int j = paramIntent.getIntExtra("lat", 0);
    int k = paramIntent.getIntExtra("lon", 0);
    if (i == 0)
    {
      if (bool) {
        QQToast.a(this, 2131368055, 0).b(getTitleBarHeight());
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("location", str);
        localIntent.putExtra("lat", j);
        localIntent.putExtra("lon", k);
        setResult(-1, localIntent);
        finish();
        break;
        QQToast.a(this, 2131368053, 0).b(getTitleBarHeight());
      }
    }
    if (i == 1002) {
      str = getString(2131368057);
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      break;
      if (bool) {
        str = getString(2131368056);
      } else {
        str = getString(2131368054);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    String str = paramBundle.getString("troopUin");
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBundle.getBoolean("saveDirect", true));
    this.jdField_a_of_type_Long = Long.parseLong(str);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity
 * JD-Core Version:    0.7.0.1
 */