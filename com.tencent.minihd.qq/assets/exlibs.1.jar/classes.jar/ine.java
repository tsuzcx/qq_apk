import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class ine
  implements Runnable
{
  ine(ind paramind) {}
  
  public void run()
  {
    long l = 0L;
    for (;;)
    {
      try
      {
        localObject = new URL("https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject;
        int i;
        localMalformedURLException.printStackTrace();
        continue;
      }
      try
      {
        i = ((URL)localObject).openConnection().getContentLength();
        l = i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putLong("_filesize_from_dlg", l);
    ((Bundle)localObject).putString("_filename_from_dlg", this.a.a.getString(2131367616));
    UniformDownloadMgr.a().b("https://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435", (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ine
 * JD-Core Version:    0.7.0.1
 */