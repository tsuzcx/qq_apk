import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class eex
  implements Runnable
{
  public eex(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void run()
  {
    if (this.a.app != null)
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences("sp_personal_dressup_preload_" + this.a.app.a(), 0);
      int i = localSharedPreferences.getInt("key_count_enter_sub_item", 0);
      localSharedPreferences.edit().putInt("key_count_enter_sub_item", i + 1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eex
 * JD-Core Version:    0.7.0.1
 */