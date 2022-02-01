import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.statistics.ReportController;

public class cgv
  implements View.OnClickListener
{
  public cgv(SearchActivity paramSearchActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      paramView = (String)paramView.getTag();
      this.a.a(paramView);
      SearchProtocol.a(this.a.app, this.a, SearchActivity.a(this.a), paramView, SearchActivity.a(this.a));
      this.a.c(paramView);
      this.a.a(true);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800516F", "0X800516F", 0, 0, null, null, null, null);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "3", null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgv
 * JD-Core Version:    0.7.0.1
 */