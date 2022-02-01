import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;

public class iyf
  implements FileManagerUtil.IGetVideoCallback
{
  public iyf(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.a(this.a).runOnUiThread(new iyg(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyf
 * JD-Core Version:    0.7.0.1
 */