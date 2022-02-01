import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QzoneWrapperActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class evm
  extends BroadcastReceiver
{
  public evm(QzoneWrapperActivity paramQzoneWrapperActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ("com.tencent.qzone.wrapper.selected.clear".equals(paramIntent.getAction()))
          {
            QzoneWrapperActivity.a(this.a);
            return;
          }
          paramContext = paramIntent.getStringExtra("uin");
        } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(this.a.app.a())));
        paramContext = paramIntent.getAction();
      } while (TextUtils.isEmpty(paramContext));
      paramContext = paramContext.split("_");
    } while ((paramContext == null) || (paramContext.length <= 1));
    int i = Integer.parseInt(paramContext[(paramContext.length - 1)]);
    paramContext = this.a.findViewById(i);
    QzoneWrapperActivity.a(this.a);
    paramContext.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evm
 * JD-Core Version:    0.7.0.1
 */