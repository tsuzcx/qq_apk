import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;

public final class fon
  implements Runnable
{
  public fon(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.a.edit().putInt("open_times", AIOInputTypeHelper.b).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fon
 * JD-Core Version:    0.7.0.1
 */