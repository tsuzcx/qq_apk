package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;

public class TroopAioBlueTipsView
  extends TroopAioAgent
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private AIOTipsController jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
  private String jdField_a_of_type_JavaLangString;
  private Context jdField_b_of_type_AndroidContentContext;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(Context paramContext, AIOTipsController paramAIOTipsController, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130903834, null);
    paramContext = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299782);
    if ((paramString2 != null) && (!StringUtil.b(paramString2))) {
      paramContext.setText(paramString2);
    }
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (paramAIOTipsController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = paramAIOTipsController;
      paramAIOTipsController.a(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramString1;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
    }
  }
  
  public void onClick(View paramView)
  {
    if (!StringUtil.b(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
      return;
    }
    setChanged();
    notifyObservers(TroopAioAgent.Message.b(2131299779));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioBlueTipsView
 * JD-Core Version:    0.7.0.1
 */