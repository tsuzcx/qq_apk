import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;

public class evl
  extends BroadcastReceiver
{
  public evl(QzoneWrapperActivity paramQzoneWrapperActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
      } while ((TextUtils.isEmpty(paramContext)) || (!"com.tencent.qzone.update.bubble.myfeed".equals(paramContext)));
      i = paramIntent.getIntExtra("com.tencent.qzone.update.bubble.myfeed", 0);
    } while (QzoneWrapperActivity.a(this.a) == null);
    QzoneWrapperActivity.a(this.a, QzoneWrapperActivity.a(this.a), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evl
 * JD-Core Version:    0.7.0.1
 */