import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;

public class hnh
  extends BroadcastReceiver
{
  public hnh(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if (paramIntent.getAction().equals("com.tencent.qzone.cleanunreadcount"))
    {
      i = paramIntent.getIntExtra("clean_unread_feed_type", -1);
      paramContext = (QZoneManagerImp)this.a.getManager(9);
      if (paramContext != null)
      {
        if (i != 0) {
          break label58;
        }
        if (paramContext.a(0) > 0) {
          paramContext.a(0, 0, 0L, null);
        }
      }
    }
    label58:
    do
    {
      do
      {
        return;
        if (i != 1) {
          break;
        }
      } while (paramContext.a(1) <= 0);
      paramContext.a(1, 0, 0L, null);
      return;
    } while ((i != 5) || (paramContext.a(5) <= 0));
    paramContext.a(5, 0, 0L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnh
 * JD-Core Version:    0.7.0.1
 */