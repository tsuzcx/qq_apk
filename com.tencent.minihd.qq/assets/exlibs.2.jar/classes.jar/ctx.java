import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.handler.a;
import com.tencent.component.network.utils.f;
import org.apache.http.HttpResponse;

public class ctx
  implements a
{
  public ctx(DownloaderFactory paramDownloaderFactory) {}
  
  public boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    paramDownloadResult = paramDownloadResult.a().a;
    if (TextUtils.isEmpty(paramDownloadResult)) {}
    while (!f.a(paramDownloadResult, "image")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ctx
 * JD-Core Version:    0.7.0.1
 */