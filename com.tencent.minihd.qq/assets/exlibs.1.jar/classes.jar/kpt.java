import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.util.ImageCreator;
import com.tencent.mobileqq.util.ImageWorker;

public class kpt
  implements Runnable
{
  public kpt(ImageWorker paramImageWorker, kpw paramkpw, String paramString, ImageCreator paramImageCreator) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Kpw.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilImageCreator, Boolean.valueOf(true) });
    ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).post(new kpu(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpt
 * JD-Core Version:    0.7.0.1
 */