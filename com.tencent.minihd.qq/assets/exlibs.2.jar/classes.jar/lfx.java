import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class lfx
  implements Runnable
{
  public lfx(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    if (!this.a.a)
    {
      if (!MyAppApi.a().b()) {
        this.a.a(true);
      }
      this.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lfx
 * JD-Core Version:    0.7.0.1
 */