import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewReport;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.List;

public class ixu
  implements IFileViewListener
{
  public ixu(FileBrowserActivity paramFileBrowserActivity) {}
  
  public int a()
  {
    return this.a.b().getHeight();
  }
  
  public void a()
  {
    this.a.e();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.a.b) {
      return;
    }
    this.a.b = paramInt;
    this.a.e();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!this.a.c()) {
      return;
    }
    Object localObject = this.a;
    ((FileBrowserActivity)localObject).b -= 1;
    localObject = this.a.a();
    ((IFileViewerAdapter)localObject).d(paramBoolean);
    if (this.a.b > 0)
    {
      paramBoolean = true;
      if (this.a.b >= this.a.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label143;
      }
    }
    for (;;)
    {
      ((IFileViewerAdapter)localObject).e(paramBoolean);
      ((IFileViewerAdapter)localObject).f(bool);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a(this.a.a());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b();
      this.a.e();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      return;
      paramBoolean = false;
      break;
      label143:
      bool = false;
    }
  }
  
  public void b()
  {
    this.a.a(true);
  }
  
  public void b(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!this.a.d()) {
      return;
    }
    Object localObject = this.a;
    ((FileBrowserActivity)localObject).b += 1;
    localObject = this.a.a();
    boolean bool1;
    if (this.a.b > 0)
    {
      bool1 = true;
      if (this.a.b >= this.a.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label145;
      }
    }
    for (;;)
    {
      ((IFileViewerAdapter)localObject).e(bool1);
      ((IFileViewerAdapter)localObject).f(bool2);
      ((IFileViewerAdapter)localObject).d(paramBoolean);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.a((IFileViewerAdapter)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewBase.b();
      this.a.e();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.c();
      return;
      bool1 = false;
      break;
      label145:
      bool2 = false;
    }
  }
  
  public void c()
  {
    FileViewMusicService.a().a(this.a.jdField_a_of_type_JavaUtilList, this.a.b);
    Handler localHandler = this.a.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.obtainMessage(1134026, null).sendToTarget();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    View localView = this.a.findViewById(2131299582);
    if (!this.a.jdField_a_of_type_Boolean) {
      localView.setVisibility(0);
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager == null)
    {
      return;
      localView.setVisibility(8);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.b();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarManager.a();
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.a.findViewById(2131297348);
    if (paramBoolean)
    {
      FileManagerUtil.a(this.a, localTextView);
      return;
    }
    FileManagerUtil.a(localTextView);
  }
  
  public void e()
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixu
 * JD-Core Version:    0.7.0.1
 */