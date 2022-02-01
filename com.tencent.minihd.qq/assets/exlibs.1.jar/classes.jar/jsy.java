import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class jsy
  implements View.OnClickListener
{
  public jsy(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    boolean bool;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof Integer)))
    {
      if (!NetworkUtil.e(this.a)) {
        QQToast.a(this.a, this.a.getString(2131365730), 0).b(this.a.getTitleBarHeight());
      }
      int j;
      do
      {
        return;
        j = ((Integer)paramView.getTag()).intValue();
      } while ((StatusHistoryActivity.a(this.a) == null) || (j < 0) || (j >= StatusHistoryActivity.a(this.a).size()));
      StatusHistoryActivity.a(this.a, (RichStatus)StatusHistoryActivity.a(this.a).get(j));
      paramView = this.a;
      if (j != 0) {
        break label305;
      }
      bool = true;
      label135:
      StatusHistoryActivity.b(paramView, bool);
      StatusHistoryActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
      StatusHistoryActivity.a(this.a).a("正在删除");
      StatusHistoryActivity.a(this.a).show();
      if ((!StatusHistoryActivity.a(this.a)) || (StatusHistoryActivity.a(this.a).size() != 1)) {
        break label311;
      }
      if (this.a.app != null)
      {
        paramView = new NewIntent(this.a.app.a(), StatusServlet.class);
        paramView.putExtra("k_cmd", 8);
        this.a.app.startServlet(paramView);
      }
    }
    label305:
    label311:
    while ((StatusHistoryActivity.a(this.a) == null) || (this.a.app == null) || (StatusHistoryActivity.a(this.a).a == null))
    {
      this.a.a.a(StatusHistoryActivity.a(this.a).f);
      if (StatusHistoryActivity.a(this.a) == null) {
        break;
      }
      StatusHistoryActivity.a(this.a).d();
      return;
      bool = false;
      break label135;
    }
    paramView = new NewIntent(this.a.app.a(), StatusServlet.class);
    paramView.putExtra("k_cmd", 5);
    paramView.putExtra("k_status_key", StatusHistoryActivity.a(this.a).a);
    if (StatusHistoryActivity.b(this.a)) {}
    for (;;)
    {
      paramView.putExtra("k_status_flag", i);
      this.a.app.startServlet(paramView);
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsy
 * JD-Core Version:    0.7.0.1
 */