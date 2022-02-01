import android.view.View;
import com.dataline.activities.RouterAdvanceActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cq
  implements ActionSheet.OnButtonClickListener
{
  public cq(RouterAdvanceActivity paramRouterAdvanceActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      ((RouterHandler)this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity.app.a(50)).c();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComDatalineActivitiesRouterAdvanceActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cq
 * JD-Core Version:    0.7.0.1
 */