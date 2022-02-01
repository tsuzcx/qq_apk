import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.IClickListener_Ver51;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.qphone.base.util.QLog;

public class iji
  implements View.OnClickListener
{
  public iji(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.h())
    {
      FMDataCache.b();
      this.a.e(false);
      if (this.a.c())
      {
        this.a.setResult(5);
        this.a.finish();
        return;
      }
      BaseFileAssistantActivity.a(this.a).setVisibility(0);
      BaseFileAssistantActivity.b(this.a).setText(2131362354);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(8);
      this.a.setTitle(this.a.b);
      this.a.b();
      this.a.a();
      if (this.a.jdField_a_of_type_Int == 1) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.a.b(false);
      return;
    }
    if (BaseFileAssistantActivity.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BaseFileAssistantActivity<FileAssistant>", 2, "onRightEditClick");
      }
      BaseFileAssistantActivity.a(this.a).g();
    }
    FMDataCache.b();
    this.a.e(true);
    BaseFileAssistantActivity.c(this.a).setVisibility(0);
    BaseFileAssistantActivity.d(this.a).setText(2131362387);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setVisibility(0);
    this.a.b();
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iji
 * JD-Core Version:    0.7.0.1
 */