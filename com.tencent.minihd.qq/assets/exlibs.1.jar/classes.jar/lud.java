import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.widget.pulltorefresh.library.PullToRefreshWebView;

public class lud
  extends WebChromeClient
{
  public lud(PullToRefreshWebView paramPullToRefreshWebView) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lud
 * JD-Core Version:    0.7.0.1
 */