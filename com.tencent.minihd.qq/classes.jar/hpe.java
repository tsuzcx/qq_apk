import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;

public class hpe
  implements View.OnClickListener
{
  public hpe(ScreenShot paramScreenShot) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Hph.a(true);
    if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
      KapalaiAdapterUtil.a().b(this.a.jdField_a_of_type_AndroidViewWindow);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpe
 * JD-Core Version:    0.7.0.1
 */