import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;

public class gdo
  implements Runnable
{
  public gdo(LightalkBlueTipsBar paramLightalkBlueTipsBar) {}
  
  public void run()
  {
    Object localObject = LightalkBlueTipsBar.a(this.a).getPreferences();
    if (((SharedPreferences)localObject).getInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).a(), 5) != 5)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).a(), 5);
      ((SharedPreferences.Editor)localObject).commit();
      LightalkBlueTipsBar.a = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdo
 * JD-Core Version:    0.7.0.1
 */