import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class eo
  extends DownloadListener
{
  public eo(FontManager paramFontManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    this.a.a("Font_download_cancel", paramDownloadTask.b(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onCancel|font id=" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", isCancel=" + paramDownloadTask.b());
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    int i = 0;
    super.onDone(paramDownloadTask);
    boolean bool;
    if (paramDownloadTask.a() == 3)
    {
      long l1 = paramDownloadTask.h;
      long l2 = paramDownloadTask.g;
      bool = this.a.a(paramDownloadTask.b(), (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.b));
      this.a.a("Font_download_succ", paramDownloadTask.b(), l1 - l2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FontManager", 2, "onDone| task:" + paramDownloadTask.b() + "status=" + paramDownloadTask.a() + ", iCancel=" + paramDownloadTask.b() + "succ=" + bool);
      }
      if (bool) {}
      for (;;)
      {
        if (paramDownloadTask.b()) {
          i = 2;
        }
        if ((this.a.a != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
          this.a.a.onDone(paramDownloadTask.b(), i, paramDownloadTask.a());
        }
        return;
        i = -1;
      }
      bool = false;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onProgress|fontId" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", isCancel=" + paramDownloadTask.b() + ", progress=" + paramDownloadTask.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "onStart| task:" + paramDownloadTask.b() + ", status=" + paramDownloadTask.a() + ", iCancel=" + paramDownloadTask.b());
    }
    if (!paramDownloadTask.a().containsKey("callbackId")) {
      this.a.a("AIO_Font_download", paramDownloadTask.b(), 0L);
    }
    for (;;)
    {
      super.onStart(paramDownloadTask);
      return true;
      this.a.a("Font_download", paramDownloadTask.b(), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eo
 * JD-Core Version:    0.7.0.1
 */