import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.nearpeople.TurnBrandView;
import com.tencent.util.VersionUtils;

public class jla
  implements Runnable
{
  public jla(TurnBrandView paramTurnBrandView) {}
  
  public void run()
  {
    boolean bool = TurnBrandView.a(this.a).getPreferences().getBoolean("nearpeople_turnbrand_swipe" + TurnBrandView.a(this.a).a(), false);
    if ((TurnBrandView.c(this.a) >= 3) && (!bool) && (VersionUtils.e()))
    {
      Handler localHandler = ((TurnBrandActivity)TurnBrandView.a(this.a)).a;
      Message localMessage = localHandler.obtainMessage(1184276);
      localMessage.arg1 = 2;
      localHandler.sendMessage(localMessage);
      TurnBrandView.a(this.a).getPreferences().edit().putBoolean("nearpeople_turnbrand_swipe" + TurnBrandView.a(this.a).a(), true).commit();
      TurnBrandView.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jla
 * JD-Core Version:    0.7.0.1
 */