import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.qphone.base.util.QLog;

public class izw
  implements Runnable
{
  public izw(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase, int paramInt) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(false);
    if (PreviewingOfflineFileViewBase.j(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.k(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).d(false);
    }
    if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, (LinearLayout)PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).findViewById(2131299556));
    }
    if (PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null) {
      PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, new FilePreviewAnimQueue(PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase)));
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 2, "hideGetMore(" + this.jdField_a_of_type_Int + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     izw
 * JD-Core Version:    0.7.0.1
 */