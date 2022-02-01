import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;

public class fix
  implements View.OnClickListener
{
  public fix(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    int j = ((Integer)paramView.getTag()).intValue();
    if ((!TroopMemberLbsHelper.a(this.a.i, this.a.app).booleanValue()) && (j >= 3)) {}
    for (int i = j + 1;; i = j)
    {
      if (this.a.y != i) {}
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        this.a.y = i;
        paramView = this.a.getResources().getStringArray(2131230775);
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow, paramView);
        if ((i == 0) || (i == 3))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
          this.a.a("Clk_def", this.a.q, "");
          if (i == 3) {
            this.a.a("Clk_distance", this.a.q, "");
          }
          this.a.g();
          if (!this.a.g)
          {
            this.a.g = true;
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          }
          if (j == 0) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
          }
        }
        else if (i == 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131365853);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131365854);
          paramView = "Clk_lastactivetime";
        }
        break;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
        this.a.a(paramView, "1", this.a.q);
        break;
        if (i == 2)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131365855);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131365856);
          paramView = "Clk_mberlevel";
        }
        else if (i == 4)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131365857);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131365858);
          paramView = "Clk_jointime";
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131493040));
          return;
          this.a.k();
          return;
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new fiy(this), 320L);
          return;
          this.a.b = true;
          this.a.r = "";
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          }
          paramView = this.a.q;
          this.a.a("Clk_del", paramView, "");
        }
        else
        {
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fix
 * JD-Core Version:    0.7.0.1
 */