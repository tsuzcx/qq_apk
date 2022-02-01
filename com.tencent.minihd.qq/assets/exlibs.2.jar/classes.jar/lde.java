import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.open.appcenter.QZoneAppWebViewActivity;
import com.tencent.open.base.LogUtility;

public class lde
  implements View.OnLongClickListener
{
  public lde(QZoneAppWebViewActivity paramQZoneAppWebViewActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c(this.a.c, "webView onLongClick");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lde
 * JD-Core Version:    0.7.0.1
 */