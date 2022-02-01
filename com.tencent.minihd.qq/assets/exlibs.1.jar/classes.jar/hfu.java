import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class hfu
  implements View.OnClickListener
{
  public hfu(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).c();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof TroopInfo)) {
      return;
    }
    localObject = (TroopInfo)paramView;
    boolean bool = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).h(((TroopInfo)localObject).troopuin);
    if (bool) {}
    for (paramView = "Clk_uncommgrp";; paramView = "Clk_setcommgrp")
    {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", paramView, 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
      if ((NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext) != 0) || (!(this.a.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))) {
        break;
      }
      paramView = (BaseActivity)this.a.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramView, 2131363422, 0).b(paramView.getTitleBarHeight());
      return;
    }
    paramView = (BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (bool) {
      i = 1;
    }
    paramView.a(((TroopInfo)localObject).troopcode, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hfu
 * JD-Core Version:    0.7.0.1
 */