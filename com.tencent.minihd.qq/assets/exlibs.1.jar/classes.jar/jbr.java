import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jbr
  implements ActionSheet.OnButtonClickListener
{
  public jbr(QfileEditBottomBar paramQfileEditBottomBar, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.a.get(Integer.valueOf(paramInt).intValue())).intValue())
    {
    }
    for (;;)
    {
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).d(FMDataCache.c());
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).e(FMDataCache.b());
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).f(FMDataCache.e());
      FMDataCache.b();
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).e(false);
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).b();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).a().a(false);
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).h();
      continue;
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).a().a(true);
      QfileEditBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbr
 * JD-Core Version:    0.7.0.1
 */