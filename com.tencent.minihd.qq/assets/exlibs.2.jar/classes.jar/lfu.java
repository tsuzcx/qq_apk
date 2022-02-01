import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;

public final class lfu
  implements Runnable
{
  public lfu(DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    DownloadManager.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lfu
 * JD-Core Version:    0.7.0.1
 */