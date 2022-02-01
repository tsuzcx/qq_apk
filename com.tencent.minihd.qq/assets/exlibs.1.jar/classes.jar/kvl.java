import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class kvl
  extends DownloadListener
{
  public kvl(PendantInfo paramPendantInfo, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onCancel| task:" + paramDownloadTask);
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.b()) {}
    long l1;
    int i;
    long l2;
    do
    {
      do
      {
        return;
        Bundle localBundle = paramDownloadTask.a();
        localObject = localBundle.getString("name");
        l1 = localBundle.getLong("id");
        localBundle.getLong("targetId");
        i = localBundle.getInt("pendantResType");
        l2 = paramDownloadTask.h - paramDownloadTask.g;
        if (paramDownloadTask.a() == -1)
        {
          this.a.a(1, i, l2);
          return;
        }
        paramDownloadTask = AvatarPendantUtil.a(l1, i);
      } while (localObject == null);
      if (2 != i) {
        break;
      }
      paramDownloadTask = new File(paramDownloadTask);
    } while (((String)localObject).lastIndexOf(".zip") < 0);
    Object localObject = new File(AvatarPendantUtil.a(l1, 8));
    if (DownloaderFactory.a(paramDownloadTask, (File)localObject))
    {
      this.a.a();
      paramDownloadTask = new Message();
      paramDownloadTask.what = 20;
      this.a.a.sendMessage(paramDownloadTask);
    }
    for (;;)
    {
      this.a.a(0, i, l2);
      return;
      if ((paramDownloadTask != null) && (paramDownloadTask.exists())) {
        paramDownloadTask.delete();
      }
      if ((localObject != null) && (((File)localObject).exists()))
      {
        ((File)localObject).delete();
        continue;
        paramDownloadTask = new Message();
        paramDownloadTask.what = 19;
        this.a.a.sendMessage(paramDownloadTask);
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "pendantDownloadListener.onStart| task:" + paramDownloadTask);
    }
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvl
 * JD-Core Version:    0.7.0.1
 */