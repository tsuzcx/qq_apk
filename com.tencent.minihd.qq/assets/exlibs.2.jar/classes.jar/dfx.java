import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dfx
  implements ActionSheet.OnButtonClickListener
{
  public dfx(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.a()).longValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.a.a(l, Long.valueOf(AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity)).longValue(), 1);
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131367328, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfx
 * JD-Core Version:    0.7.0.1
 */