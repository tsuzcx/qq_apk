import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
import cooperation.qzone.QZoneVideoDownloadActivity;

public class mbf
  extends Handler
{
  public mbf(QZoneVideoDownloadActivity paramQZoneVideoDownloadActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.setContentView(2130904535);
      QZoneVideoDownloadActivity.a(this.a);
      return;
    } while ((QZoneVideoDownloadActivity.a(this.a) == null) || (QZoneVideoDownloadActivity.a(this.a) == null));
    int i = paramMessage.arg1;
    QZoneVideoDownloadActivity.a(this.a).setText("正在加载插件，已完成" + i + "%，请耐心等待");
    QZoneVideoDownloadActivity.a(this.a).setProgress(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbf
 * JD-Core Version:    0.7.0.1
 */