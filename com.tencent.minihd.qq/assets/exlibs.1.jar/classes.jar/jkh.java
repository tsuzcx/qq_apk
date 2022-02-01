import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.FlingBrandListener;

public class jkh
  implements Runnable
{
  public jkh(FlingBrandListener paramFlingBrandListener) {}
  
  public void run()
  {
    FlingBrandListener.a(this.a).getPreferences().edit().putBoolean("nearpeople_turnbrand_swipe" + FlingBrandListener.a(this.a).a(), true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkh
 * JD-Core Version:    0.7.0.1
 */