import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ixx
  implements View.OnClickListener
{
  public ixx(CanPreviewOfflineFileView paramCanPreviewOfflineFileView) {}
  
  public void onClick(View paramView)
  {
    CanPreviewOfflineFileView.a(this.a).b(1);
    if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
      FMToastUtil.a(CanPreviewOfflineFileView.a(this.a).getString(2131362551));
    }
    do
    {
      return;
      CanPreviewOfflineFileView.a(this.a).a(true);
      CanPreviewOfflineFileView.b(this.a).b(false);
    } while (CanPreviewOfflineFileView.b(this.a) == null);
    CanPreviewOfflineFileView.c(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ixx
 * JD-Core Version:    0.7.0.1
 */