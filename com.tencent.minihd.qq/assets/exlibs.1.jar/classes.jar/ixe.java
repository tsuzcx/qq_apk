import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQProxyForQlink.WState;
import cooperation.qlink.QlinkSendTipsActivity;

public final class ixe
  implements View.OnClickListener
{
  public ixe(boolean paramBoolean, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 6);
    }
    for (;;)
    {
      if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
      {
        paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
        if (paramView.a.isShowing()) {
          paramView.a.dismiss();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.d();
      }
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      if (!((QQProxyForQlink.WState)localObject).jdField_a_of_type_Boolean)
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QlinkSendTipsActivity.class);
        ((Intent)localObject).putExtra("_FILE_PATH_", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("_SEND_FILE_SRC_", 6);
        ((Intent)localObject).putExtra("from_qlink_enter_recent", true);
        this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject, 108);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, new ixf(this, (QQProxyForQlink.WState)localObject), new ixg(this), new ixh(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixe
 * JD-Core Version:    0.7.0.1
 */