import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;

class iyn
  implements FileManagerUtil.IGetVideoCallback
{
  iyn(iym paramiym) {}
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.e(this.a.a).runOnUiThread(new iyo(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyn
 * JD-Core Version:    0.7.0.1
 */