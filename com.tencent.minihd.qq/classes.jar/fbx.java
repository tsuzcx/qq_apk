import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class fbx
  implements Runnable
{
  public fbx(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
    localIntent.addFlags(268435456);
    localIntent.putExtra("uin", this.a.app.getAccount());
    BaseApplicationImpl.a().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fbx
 * JD-Core Version:    0.7.0.1
 */