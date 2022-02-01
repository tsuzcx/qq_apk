import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

public class ivy
  implements View.OnClickListener
{
  public ivy(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a()))
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131362551);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a("'" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "'" + BaseApplication.getContext().getResources().getString(2131362117));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L) && (((RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(9)).a() == 0))
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131362155);
      return;
    }
    BaseActionBarDataLineFile.a(this.a, true);
    BaseActionBarDataLineFile.e(this.a);
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    BaseActionBarDataLineFile.c(this.a);
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ivy
 * JD-Core Version:    0.7.0.1
 */