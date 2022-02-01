import android.app.Activity;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class izm
  implements FileWebView.TitilebarEventInterface
{
  long jdField_a_of_type_Long = 0L;
  
  public izm(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void a()
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, true);
    if (PreviewingOfflineFileViewBase.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
  }
  
  public void a(boolean paramBoolean)
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false);
    if (PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
  }
  
  public void b()
  {
    if (PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase))
    {
      if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, (LinearLayout)PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).findViewById(2131299556));
      }
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
      PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, true);
      if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null)
      {
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).l = "3";
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).e = System.currentTimeMillis();
      }
      if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
      {
        PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false, 2L, "no network");
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 5000);
        PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false);
        return;
      }
      PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
    } while (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null);
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase.a().f();
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).loadUrl(str);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 1, localException.toString());
    }
  }
  
  public void c()
  {
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 200);
  }
  
  public void d()
  {
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).postDelayed(new izn(this), 3000L);
  }
  
  public void e()
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).runOnUiThread(new izo(this));
  }
  
  public void f()
  {
    PreviewingOfflineFileViewBase localPreviewingOfflineFileViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase;
    if (!PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase)) {}
    for (boolean bool = true;; bool = false)
    {
      PreviewingOfflineFileViewBase.b(localPreviewingOfflineFileViewBase, bool);
      if (PreviewingOfflineFileViewBase.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
        PreviewingOfflineFileViewBase.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
      }
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
      return;
    }
  }
  
  public void g()
  {
    if (PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase))
    {
      if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, (LinearLayout)PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).findViewById(2131299556));
      }
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
      PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, true);
    } while (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null);
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase.a().f();
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).loadUrl(str);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izm
 * JD-Core Version:    0.7.0.1
 */