import android.webkit.WebView;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase;
import com.tencent.widget.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public final class luc
  implements PullToRefreshBase.OnRefreshListener
{
  public void a(PullToRefreshBase paramPullToRefreshBase)
  {
    ((WebView)paramPullToRefreshBase.a()).reload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     luc
 * JD-Core Version:    0.7.0.1
 */