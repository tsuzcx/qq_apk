import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.util.VersionUtils;

public class jkr
  implements Runnable
{
  public jkr(TurnBrandActivity paramTurnBrandActivity) {}
  
  public void run()
  {
    if ((!this.a.app.getPreferences().getBoolean("nearpeople_turnbrand_guide" + this.a.app.a(), false)) && (VersionUtils.e()))
    {
      Message localMessage = this.a.a.obtainMessage(1184276);
      localMessage.arg1 = 1;
      this.a.a.sendMessageDelayed(localMessage, 500L);
      this.a.app.getPreferences().edit().putBoolean("nearpeople_turnbrand_guide" + this.a.app.a(), true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkr
 * JD-Core Version:    0.7.0.1
 */