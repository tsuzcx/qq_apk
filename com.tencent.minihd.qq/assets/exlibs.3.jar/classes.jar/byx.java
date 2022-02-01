import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qav.app.QavAppInterface;

public class byx
  extends BroadcastReceiver
{
  public byx(SmallScreenDialogActivity paramSmallScreenDialogActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.video.v2q.SmallScreenState"))
    {
      paramIntent.getIntExtra("SmallScreenState", -1);
      SeqUtil.a(paramIntent);
      if (SmallScreenUtils.a(this.a.a.a())) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     byx
 * JD-Core Version:    0.7.0.1
 */