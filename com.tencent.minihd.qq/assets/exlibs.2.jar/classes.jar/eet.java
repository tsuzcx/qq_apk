import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class eet
  implements Runnable
{
  public eet(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void run()
  {
    if (this.a.app != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("sp_personal_dressup_preload_" + this.a.app.a(), 0);
      int i = localSharedPreferences.getInt("key_count_preload", 0);
      localSharedPreferences.edit().putInt("key_count_preload", i + 1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eet
 * JD-Core Version:    0.7.0.1
 */