import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public final class fqm
  implements PopupWindow.OnDismissListener
{
  public fqm(QQAppInterface paramQQAppInterface) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a, "CliOper", "", "", "0X8004864", "0X8004864", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fqm
 * JD-Core Version:    0.7.0.1
 */