import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

public class jqb
  implements Runnable
{
  public jqb(RedTouch paramRedTouch, String paramString, File paramFile, int paramInt, ImageView paramImageView) {}
  
  public void run()
  {
    if (HttpDownloadUtil.a(null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile))
    {
      Bitmap localBitmap1 = RedTouch.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_JavaIoFile);
      if (localBitmap1 != null)
      {
        Bitmap localBitmap2 = ImageUtil.a(localBitmap1, localBitmap1.getWidth(), localBitmap1.getWidth(), localBitmap1.getHeight());
        RedTouch.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch).post(new jqc(this, localBitmap2, localBitmap1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jqb
 * JD-Core Version:    0.7.0.1
 */