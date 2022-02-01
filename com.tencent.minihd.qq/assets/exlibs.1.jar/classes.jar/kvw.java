import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;

public class kvw
  extends DownloadListener
{
  public kvw(VipFunCallManager paramVipFunCallManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    int j = paramDownloadTask.a().getInt("id");
    int i;
    if (paramDownloadTask.a() == 3)
    {
      i = 1;
      if (i != 0)
      {
        if (FileUtils.b(VipFunCallManager.a(j, VipFunCallManager.c) + ".tmp", VipFunCallManager.a(j, VipFunCallManager.c))) {
          break label87;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mFuncallthumbnailDownloadListener", 2, "rename failure.");
        }
      }
    }
    label87:
    while (this.a.a == null)
    {
      return;
      i = 0;
      break;
    }
    this.a.a.sendEmptyMessage(VipFunCallManager.m);
  }
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvw
 * JD-Core Version:    0.7.0.1
 */