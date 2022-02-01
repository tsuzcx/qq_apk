import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

class iyo
  implements Runnable
{
  iyo(iyn paramiyn, Bitmap paramBitmap) {}
  
  @TargetApi(16)
  public void run()
  {
    if ((LocalVideoFileView.a(this.jdField_a_of_type_Iyn.a.a) != null) && (LocalVideoFileView.a(this.jdField_a_of_type_Iyn.a.a) != null) && (!LocalVideoFileView.a(this.jdField_a_of_type_Iyn.a.a).a()))
    {
      if (Build.VERSION.SDK_INT > 18) {
        LocalVideoFileView.a(this.jdField_a_of_type_Iyn.a.a).setBackground(new BitmapDrawable(LocalVideoFileView.d(this.jdField_a_of_type_Iyn.a.a).getApplicationContext().getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      }
    }
    else {
      return;
    }
    LocalVideoFileView.a(this.jdField_a_of_type_Iyn.a.a).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iyo
 * JD-Core Version:    0.7.0.1
 */