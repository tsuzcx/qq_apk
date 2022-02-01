import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jhc
  extends BroadcastReceiver
{
  public jhc(MusicGeneQQBrowserActivity paramMusicGeneQQBrowserActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
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
    if (j == 0) {}
    for (;;)
    {
      try
      {
        ReportController.b(null, "CliOper", "", "", "0X800627D", "0X800627D", i, 0, "", "", "", "");
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      if (j == 3000) {
        i = 1;
      } else if (j == 1) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jhc
 * JD-Core Version:    0.7.0.1
 */