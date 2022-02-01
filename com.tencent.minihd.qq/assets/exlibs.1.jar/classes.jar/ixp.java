import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseQfileActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

public class ixp
  implements View.OnClickListener
{
  public ixp(BaseQfileActionBar paramBaseQfileActionBar) {}
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    paramView = localObject;
    switch (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType)
    {
    default: 
      paramView = localObject;
    }
    for (;;)
    {
      if (paramView != null) {
        FileManagerReporter.a(paramView);
      }
      this.a.c();
      this.a.e();
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
      {
        paramView = "0X8004BB7";
      }
      else
      {
        paramView = "0X8004BCD";
        continue;
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())
        {
          paramView = "0X8004BB8";
        }
        else
        {
          paramView = "0X8004BCE";
          continue;
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()) {
            paramView = "0X8004BB9";
          } else {
            paramView = "0X8004BCF";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixp
 * JD-Core Version:    0.7.0.1
 */