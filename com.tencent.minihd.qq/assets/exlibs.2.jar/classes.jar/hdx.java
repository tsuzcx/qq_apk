import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.statistics.ReportController;

public class hdx
  extends BroadcastReceiver
{
  public hdx(QQMusicWidget paramQQMusicWidget) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if (paramIntent == null) {}
    int j;
    do
    {
      do
      {
        return;
      } while (!"com.tencent.mobileqq.activity.ForwardRecentActivity.ACTION_LIST_ITEM_ON_CLICK".equals(paramIntent.getAction()));
      j = paramIntent.getIntExtra("share_type", -1);
    } while (j == -1);
    if (j == 0) {
      i = 0;
    }
    for (;;)
    {
      ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006282", "0X8006282", i, 0, "", "", "", "");
      return;
      if (j != 3000) {
        if (j == 1) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdx
 * JD-Core Version:    0.7.0.1
 */