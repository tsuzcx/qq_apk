import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceTextUpdateListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class jeq
  implements MagicfaceActionManager.MagicfaceTextUpdateListener
{
  public jeq(MagicfaceViewController paramMagicfaceViewController, int paramInt, TextView paramTextView) {}
  
  public void a(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new jer(this, paramString));
  }
  
  public void b(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new jes(this, paramString));
  }
  
  public void c(String paramString)
  {
    MagicfaceViewController.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController).post(new jet(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jeq
 * JD-Core Version:    0.7.0.1
 */