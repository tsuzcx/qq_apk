import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class fbz
  implements Runnable
{
  public fbz(SplashActivity paramSplashActivity, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.runOnUiThread(new fca(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fbz
 * JD-Core Version:    0.7.0.1
 */