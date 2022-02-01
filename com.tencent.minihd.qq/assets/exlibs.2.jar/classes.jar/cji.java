import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class cji
  implements View.OnClickListener
{
  public cji(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof PublicAccountBrowser.ActionSheetItem))) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "Item clicked but tag not found");
      }
    }
    int i;
    do
    {
      return;
      i = ((PublicAccountBrowser.ActionSheetItem)paramView.getTag()).m;
      if (i == 7)
      {
        PublicAccountBrowser.a(this.a);
        return;
      }
      if (i == 8)
      {
        PublicAccountBrowser.a(this.a, this.a.s);
        return;
      }
      if ((this.a instanceof QQBrowserActivity)) {
        this.a.b.onClick(paramView);
      }
      if ((i == 2) || (i == 3))
      {
        ReportController.b(null, "CliOper", "", this.a.a.a(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 6);
    ReportController.b(null, "CliOper", "", this.a.a.a(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cji
 * JD-Core Version:    0.7.0.1
 */