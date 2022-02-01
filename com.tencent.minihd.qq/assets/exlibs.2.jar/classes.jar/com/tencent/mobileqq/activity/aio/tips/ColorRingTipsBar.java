package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ColorRingTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = ColorRingTipsBar.class.getSimpleName();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  
  public ColorRingTipsBar(TipsManager paramTipsManager, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public int a()
  {
    return 8;
  }
  
  public View a(Object... paramVarArgs)
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity, this);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 37;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    String str = VasWebviewConstants.PERSONALITY_QQ_COLOR_RING_URL + "&type=" + "colorring";
    VasWebviewUtil.a(this.jdField_a_of_type_AndroidAppActivity, str, 4194304L, paramView, true, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ColorRingTipsBar
 * JD-Core Version:    0.7.0.1
 */