import android.content.Intent;
import android.net.Uri;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.DownloadListener;

public class lel
  implements DownloadListener
{
  public lel(WebAppActivity paramWebAppActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    LogUtility.c("WebAppActivity", "url= " + paramString1);
    LogUtility.c("WebAppActivity", "minetype= " + paramString4);
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    try
    {
      this.a.startActivity(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      LogUtility.c("WebAppActivity", "no activity handle Intent.ACTION_VIEW ", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lel
 * JD-Core Version:    0.7.0.1
 */