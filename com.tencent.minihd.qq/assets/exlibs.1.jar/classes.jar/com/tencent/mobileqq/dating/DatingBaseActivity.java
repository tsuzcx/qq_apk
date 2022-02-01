package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import hzr;
import hzs;
import hzt;
import hzu;
import hzv;

public class DatingBaseActivity
  extends IphoneTitleBarActivity
{
  public static final boolean d = true;
  public static final String f = "abp_flag";
  public static final String g = "is_from_web";
  public static final int u = 4097;
  private Dialog a;
  protected QQProgressNotifier a;
  public boolean e = false;
  public boolean f = false;
  protected int v;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface, paramString, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramString1, paramString2, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.b(new hzr(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, PublicDatingActivity.class);
    localIntent.putExtra("fromWhere", paramString);
    paramActivity.startActivityForResult(localIntent, paramInt);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("userCenter"))) {
      a(paramQQAppInterface, "0X800493D", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.v);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramOnDismissListener == null) {}
    do
    {
      return;
      b("0X800500D");
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131369828, 0, 2131365737, null, new hzv(this));
      }
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(paramOnDismissListener);
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    Object localObject = (DatingManager)paramQQAppInterface.getManager(67);
    if (((DatingManager)localObject).a())
    {
      if (localObject == null)
      {
        localObject = null;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label103;
        }
      }
      label103:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label109;
        }
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(paramActivity, 2131369735, 2131365736, 2131365737, new hzs(this), new hzt(this, paramQQAppInterface, paramActivity, paramInt, paramString));
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
        localObject = ((DatingManager)localObject).d();
        break;
      }
      label109:
      b(paramQQAppInterface, paramActivity, paramInt, paramString);
      return;
    }
    f();
  }
  
  public void a(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.v);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(this.app, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void b(int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), getString(paramInt), 0).b(this.v);
  }
  
  public void b(String paramString)
  {
    a(paramString, "", "", "", "");
  }
  
  public void b(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean) {
      if (!this.rightViewText.isEnabled())
      {
        localDrawable = this.rightViewText.getBackground();
        if (localDrawable != null) {
          localDrawable.setAlpha(255);
        }
        this.rightViewText.setEnabled(true);
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.rightViewText.isEnabled());
      this.rightViewText.setEnabled(false);
      localDrawable = this.rightViewText.getBackground();
    } while (localDrawable == null);
    localDrawable.setAlpha(102);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.v = getTitleBarHeight();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.e = getIntent().getBooleanExtra("abp_flag", false);
    this.f = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.f) && (!this.e)) {
      setLeftViewName(2131365114);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  protected void f()
  {
    a(new hzu(this));
  }
  
  public void finish()
  {
    super.finish();
    if (this.e) {
      overridePendingTransition(2130968589, 2130968591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */