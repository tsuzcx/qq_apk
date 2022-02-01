import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

class iyg
  implements Runnable
{
  iyg(iyf paramiyf, Bitmap paramBitmap) {}
  
  @TargetApi(16)
  public void run()
  {
    if ((LocalVideoFileView.a(this.jdField_a_of_type_Iyf.a) == null) || (LocalVideoFileView.a(this.jdField_a_of_type_Iyf.a) == null) || (LocalVideoFileView.a(this.jdField_a_of_type_Iyf.a).a()) || (Build.VERSION.SDK_INT > 17)) {
      return;
    }
    LocalVideoFileView.a(this.jdField_a_of_type_Iyf.a).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyg
 * JD-Core Version:    0.7.0.1
 */