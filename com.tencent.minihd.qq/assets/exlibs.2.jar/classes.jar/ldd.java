import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.open.appcenter.QZoneAppCenterActivity;
import com.tencent.open.base.LogUtility;

public class ldd
  implements View.OnLongClickListener
{
  public ldd(QZoneAppCenterActivity paramQZoneAppCenterActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c(QZoneAppCenterActivity.c, "webView onLongClick");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldd
 * JD-Core Version:    0.7.0.1
 */