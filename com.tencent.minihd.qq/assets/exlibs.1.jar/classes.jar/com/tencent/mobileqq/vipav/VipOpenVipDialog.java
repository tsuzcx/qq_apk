package com.tencent.mobileqq.vipav;

import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kwh;
import kwi;
import kwj;
import kwk;

public class VipOpenVipDialog
{
  public static int a;
  protected static DialogInterface.OnClickListener a;
  public static BaseActivity a;
  protected static QQCustomDialog a;
  public static String a;
  public static kwk a;
  public static int b;
  protected static DialogInterface.OnClickListener b;
  protected static QQCustomDialog b;
  public static kwk b;
  protected static DialogInterface.OnClickListener c = new kwj();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    jdField_a_of_type_Kwk = null;
    jdField_b_of_type_Kwk = null;
    jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new kwh();
    jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new kwi();
  }
  
  public static void a()
  {
    if (jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramBaseActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramString3 = "取消";
      label15:
      if (!TextUtils.isEmpty(paramString4)) {
        break label72;
      }
      paramString4 = "确定";
    }
    label72:
    for (;;)
    {
      a();
      jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramBaseActivity, 0, paramString1, paramString2, paramString3, paramString4, jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      if ((jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (paramBaseActivity.isFinishing())) {
        break;
      }
      jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      break label15;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, kwk paramkwk1, kwk paramkwk2)
  {
    if (paramBaseActivity == null) {
      return;
    }
    b();
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    jdField_a_of_type_Int = paramInt1;
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "mvip.gongneng.mobileqq.tongyong.open.android";
    }
    jdField_a_of_type_JavaLangString = str;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    jdField_b_of_type_Int = paramInt1;
    jdField_a_of_type_Kwk = paramkwk1;
    jdField_b_of_type_Kwk = paramkwk2;
    if (TextUtils.isEmpty(paramString3))
    {
      paramString3 = "取消";
      label75:
      if (!TextUtils.isEmpty(paramString4)) {
        break label131;
      }
      paramString4 = "立即开通";
    }
    label131:
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, paramString1, paramString2, paramString3, paramString4, jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, c);
      if ((jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (paramBaseActivity.isFinishing())) {
        break;
      }
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      break label75;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    jdField_a_of_type_Kwk = null;
    jdField_b_of_type_Kwk = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipOpenVipDialog
 * JD-Core Version:    0.7.0.1
 */