import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class ixa
  implements View.OnClickListener
{
  public ixa(QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0, false);
    String str = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
    FMToastUtil.b(FileManagerUtil.d(str) + this.jdField_a_of_type_AndroidAppActivity.getString(2131362432));
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixa
 * JD-Core Version:    0.7.0.1
 */