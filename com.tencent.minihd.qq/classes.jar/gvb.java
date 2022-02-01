import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class gvb
  implements Runnable
{
  public gvb(RecentCallHelper paramRecentCallHelper) {}
  
  public void run()
  {
    int i = SharedPreUtils.a(this.a.a.a()).getInt("show_tab_lightalk_tips", 0);
    SharedPreUtils.a(this.a.a.a()).edit().putInt("show_tab_lightalk_tips", i + 1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvb
 * JD-Core Version:    0.7.0.1
 */