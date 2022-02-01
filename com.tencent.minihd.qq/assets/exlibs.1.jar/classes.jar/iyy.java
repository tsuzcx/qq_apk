import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class iyy
  implements AdapterView.OnItemSelectedListener
{
  public iyy(PhotoFileViewBase paramPhotoFileViewBase) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void b(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PhotoFileViewBase.a(this.a, paramInt);
    if (PhotoFileViewBase.a(this.a) != null) {
      PhotoFileViewBase.b(this.a).a(paramInt);
    }
    paramAdapterView = (IFileViewerAdapter)PhotoFileViewBase.a(this.a).getItem(paramInt);
    if ((FileManagerUtil.a(paramAdapterView.a())) && (1 == paramAdapterView.a().cloudType)) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131362483));
    }
    this.a.a().a(paramAdapterView);
    if (paramAdapterView.h() == null) {
      paramAdapterView.a(1);
    }
    PhotoFileViewBase.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyy
 * JD-Core Version:    0.7.0.1
 */