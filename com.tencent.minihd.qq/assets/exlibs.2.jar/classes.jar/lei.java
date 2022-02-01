import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.LogUtility;

public class lei
  implements View.OnLongClickListener
{
  public lei(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c("IphoneTitleBarActivity", "webView onLongClick");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lei
 * JD-Core Version:    0.7.0.1
 */