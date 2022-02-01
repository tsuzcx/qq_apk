import android.os.Bundle;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

public class jpm
  extends DownloadListener
{
  public jpm(QCallDetailActivity paramQCallDetailActivity, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.b()) {}
    while (paramDownloadTask.a() == -1) {
      return;
    }
    long l = paramDownloadTask.a().getLong("colorRingId", 0L);
    this.a.runOnUiThread(new jpn(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jpm
 * JD-Core Version:    0.7.0.1
 */