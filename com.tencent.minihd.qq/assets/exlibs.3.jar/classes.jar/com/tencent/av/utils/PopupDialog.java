package com.tencent.av.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import bzv;
import bzw;
import bzx;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class PopupDialog
  extends BaseActivity
{
  public static bzx a;
  static final String jdField_a_of_type_JavaLangString = "PopupDialog";
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Bzx = new bzx();
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog2;
    try
    {
      if (paramContext != BaseApplicationImpl.a()) {
        localQQCustomDialog1 = DialogUtil.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      QQCustomDialog localQQCustomDialog1;
      localQQCustomDialog2 = null;
    }
    try
    {
      localQQCustomDialog1.show();
      return localQQCustomDialog1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localQQCustomDialog2;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "hideCustomDialog");
    }
    jdField_a_of_type_Bzx.jdField_a_of_type_Boolean = false;
    bzx localbzx = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localbzx = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      localbzx = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "showAgain");
    }
    Object localObject = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null) {
      return;
    }
    localObject = new Intent(paramContext, PopupDialog.class);
    ((Intent)localObject).putExtra("invoke_type", "reshow");
    ((Intent)localObject).addFlags(268435456);
    jdField_a_of_type_Bzx.jdField_a_of_type_Boolean = true;
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt1);
    localBundle.putString("titleText", paramString1);
    localBundle.putString("contentText", paramString2);
    localBundle.putInt("leftBtnText", paramInt2);
    localBundle.putInt("rightBtnText", paramInt3);
    if (paramOnClickListener2 != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("leftBtnVisiable", bool1);
      bool1 = bool2;
      if (paramOnClickListener1 != null) {
        bool1 = true;
      }
      localBundle.putBoolean("rightBtnVisiable", bool1);
      if ((paramOnClickListener1 != null) || (paramOnClickListener2 != null)) {
        localBundle.putParcelable("resultReceiver", new PopupDialog.1(new Handler(), paramOnClickListener2, paramOnClickListener1));
      }
      paramString1 = new Intent();
      paramString1.putExtra("public_fragment_window_feature", 1);
      paramString1.putExtra("request", localBundle);
      paramString1.addFlags(268435456);
      PublicFragmentActivity.Launcher.a(paramContext, paramString1, PublicTransFragmentActivity.class, PopupDialogQQSide.class);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "changeDialogText");
    }
    Object localObject = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramContext = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.a(paramString1, paramString2);
      return;
    }
    localObject = new Intent(paramContext, PopupDialog.class);
    ((Intent)localObject).putExtra("invoke_type", "changeText");
    ((Intent)localObject).addFlags(268435456);
    jdField_a_of_type_Bzx.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Bzx.jdField_b_of_type_JavaLangString = paramString2;
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Bzx.jdField_a_of_type_Boolean;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog2;
    try
    {
      if (paramContext != BaseApplicationImpl.a()) {
        localQQCustomDialog1 = DialogUtil.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      QQCustomDialog localQQCustomDialog1;
      localQQCustomDialog2 = null;
    }
    try
    {
      localQQCustomDialog1.show();
      return localQQCustomDialog1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localQQCustomDialog2;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "finishActivity");
    }
    bzx localbzx = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localbzx = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      localbzx = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    }
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    a();
    Intent localIntent = new Intent(paramContext, PopupDialog.class);
    localIntent.putExtra("invoke_type", "init");
    localIntent.addFlags(268435456);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "showCustomDialog");
    }
    jdField_a_of_type_Bzx.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Bzx.jdField_a_of_type_Int = paramInt1;
    jdField_a_of_type_Bzx.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Bzx.jdField_b_of_type_JavaLangString = paramString2;
    jdField_a_of_type_Bzx.jdField_b_of_type_Int = paramInt2;
    jdField_a_of_type_Bzx.c = paramInt3;
    jdField_a_of_type_Bzx.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener2;
    jdField_a_of_type_Bzx.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener1;
    paramContext.startActivity(localIntent);
  }
  
  void a(String paramString1, String paramString2)
  {
    jdField_a_of_type_Bzx.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Bzx.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  void c()
  {
    Object localObject1 = super.getIntent().getStringExtra("invoke_type");
    if ((TextUtils.equals((CharSequence)localObject1, "reshow")) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
    }
    do
    {
      return;
      if ((!TextUtils.equals((CharSequence)localObject1, "changeText")) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)) {
        break;
      }
      localObject1 = jdField_a_of_type_Bzx.jdField_a_of_type_JavaLangString;
      localObject2 = jdField_a_of_type_Bzx.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject2);
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    return;
    int k = jdField_a_of_type_Bzx.jdField_a_of_type_Int;
    String str1 = jdField_a_of_type_Bzx.jdField_a_of_type_JavaLangString;
    String str2 = jdField_a_of_type_Bzx.jdField_b_of_type_JavaLangString;
    int i = jdField_a_of_type_Bzx.jdField_b_of_type_Int;
    int j = jdField_a_of_type_Bzx.c;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localObject1 = new bzv(this);
    Object localObject2 = new bzw(this);
    if ((i == 0) || (jdField_a_of_type_Bzx.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null))
    {
      localObject1 = null;
      i = 2131362715;
    }
    if ((j == 0) || (jdField_a_of_type_Bzx.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null))
    {
      localObject2 = null;
      j = 2131362715;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, k, str1, str2, i, j, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onCreate");
    }
    getWindow().setBackgroundDrawableResource(2130842237);
    paramBundle = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramBundle = jdField_a_of_type_Bzx;
      if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramBundle = jdField_a_of_type_Bzx;
        bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramBundle = jdField_a_of_type_Bzx;
    bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    bzx localbzx = jdField_a_of_type_Bzx;
    bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onNewIntent");
    }
    paramIntent = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramIntent = jdField_a_of_type_Bzx;
      if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramIntent = jdField_a_of_type_Bzx;
        bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramIntent = jdField_a_of_type_Bzx;
    bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    c();
    bzx localbzx = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localbzx = jdField_a_of_type_Bzx;
      if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        localbzx = jdField_a_of_type_Bzx;
        bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    localbzx = jdField_a_of_type_Bzx;
    if (bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
    {
      localbzx = jdField_a_of_type_Bzx;
      bzx.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog
 * JD-Core Version:    0.7.0.1
 */