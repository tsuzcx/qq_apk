import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class eqy
  implements Runnable
{
  public eqy(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.edit();
    localEditor.putInt("webview_add_fav_guide_show_count", 3);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqy
 * JD-Core Version:    0.7.0.1
 */