import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.impl.f;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.a;
import org.apache.http.HttpRequest;

public final class cum
  implements DownloadPreprocessStrategy
{
  public cum(Downloader paramDownloader) {}
  
  public DownloadPreprocessStrategy.DownloadPool a(String paramString1, String paramString2)
  {
    if (f.a(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC1;
    }
    paramString1 = this.a.a();
    if ((paramString1 != null) && (paramString1.a(paramString2))) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC;
    }
    return DownloadPreprocessStrategy.DownloadPool.COMMON;
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest != null) && (paramString2 != null) && (f.b(paramString2))) {
      paramHttpRequest.addHeader("Cookie", "uin=o" + a.a() + ";");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cum
 * JD-Core Version:    0.7.0.1
 */