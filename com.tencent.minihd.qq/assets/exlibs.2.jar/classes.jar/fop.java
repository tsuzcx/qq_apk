import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class fop
  implements Runnable
{
  public fop(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.a.edit().putBoolean("input_type_changed", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fop
 * JD-Core Version:    0.7.0.1
 */