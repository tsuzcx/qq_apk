import android.os.Bundle;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class jgh
  extends DownloadListener
{
  public jgh(ChatBackgroundManager paramChatBackgroundManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)paramDownloadTask.a().get("chatbgInfo");
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    int i = paramDownloadTask.a();
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, "endDownload  id=" + paramDownloadTask.b() + "result =" + i);
    }
    if (i == 3) {
      this.a.a(0, String.valueOf(paramDownloadTask.b()), l1 - l2);
    }
    for (i = 0;; i = 1)
    {
      if ((this.a.a != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
        this.a.a.onDone(paramDownloadTask.b(), i, paramDownloadTask.a());
      }
      return;
      this.a.a(1, String.valueOf(paramDownloadTask.b()), 0L);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, "startDownload  id=" + paramDownloadTask.b());
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgh
 * JD-Core Version:    0.7.0.1
 */