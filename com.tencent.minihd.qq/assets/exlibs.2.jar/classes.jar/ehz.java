import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

class ehz
  implements Runnable
{
  ehz(ehy paramehy, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      LoginActivity.b(this.jdField_a_of_type_Ehy.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Ehy.a.a.setDuration(500L);
      LoginActivity.b(this.jdField_a_of_type_Ehy.a).startAnimation(this.jdField_a_of_type_Ehy.a.a);
      return;
    }
    LoginActivity.b(this.jdField_a_of_type_Ehy.a).setImageResource(2130838535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehz
 * JD-Core Version:    0.7.0.1
 */