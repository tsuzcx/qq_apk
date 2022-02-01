package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class GroupAreaWrapper$ActivityInfo
  extends GroupAreaWrapper.BaseInfo
{
  public GroupAreaWrapper$ActivityInfo(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.isShowZeroDistance = false;
  }
  
  protected void initUI(View paramView)
  {
    ((NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag()).a.setTextColor(paramView.getContext().getResources().getColor(2131427706));
    paramView.findViewById(2131298669).setBackgroundResource(2130839136);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131298663) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "ac", "Clk_list", 0, 0, "", "", "", "");
    }
    while (i != 2131298667) {
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "ac", "Clk_detail", 0, 0, "", "", "", "");
  }
  
  protected void setNumberText(TextView paramTextView)
  {
    paramTextView.setText("" + this.number + "人报名");
    paramTextView.setCompoundDrawablePadding(8);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130839243, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */