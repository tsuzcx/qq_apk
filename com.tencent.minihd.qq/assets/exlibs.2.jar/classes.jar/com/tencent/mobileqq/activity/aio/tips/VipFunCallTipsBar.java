package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.TipsBar;
import gdy;

public class VipFunCallTipsBar
  implements TipsBarTask
{
  private static final String a;
  public Activity a;
  public TipsManager a;
  public QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ColorRingTipsBar.class.getSimpleName();
  }
  
  public VipFunCallTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public int a()
  {
    return 10;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = new TipsBar(this.jdField_a_of_type_AndroidAppActivity);
    paramVarArgs.setTipsText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131366290));
    paramVarArgs.setTipsIcon(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840074));
    paramVarArgs.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131366290));
    paramVarArgs.setOnClickListener(new gdy(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 36;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar
 * JD-Core Version:    0.7.0.1
 */