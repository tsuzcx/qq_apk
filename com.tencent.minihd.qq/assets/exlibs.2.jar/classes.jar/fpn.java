import android.view.View;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fpn
  implements ActionSheet.OnButtonClickListener
{
  public fpn(PlusPanel paramPlusPanel, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        PlusPanelUtils.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a());
        if (PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel) != null) {
          PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a().setCanLock(false);
        }
      }
    }
    if (!NetworkUtil.e(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a()))
    {
      QQToast.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a(), 2131365730, 0).b(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a().getTitleBarHeight());
      return;
    }
    paramView = ((TroopManager)PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).getManager(50)).e(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a);
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      TroopMemberLbsHelper.a(paramView, bool, PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getContext());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpn
 * JD-Core Version:    0.7.0.1
 */