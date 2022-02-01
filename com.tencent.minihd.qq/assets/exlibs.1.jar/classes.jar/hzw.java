import android.view.View;
import android.widget.Adapter;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class hzw
  implements AdapterView.OnItemClickListener
{
  public hzw(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.a().getItem(paramInt);
    if (paramAdapterView != null)
    {
      if ((paramAdapterView instanceof String)) {
        DatingDestinationActivity.a(this.a, (String)paramAdapterView);
      }
    }
    else {
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004F32", "0X8004F32", 0, 0, "", "", "", "");
    DatingDestinationActivity.a(this.a, (appoint_define.LocaleInfo)paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzw
 * JD-Core Version:    0.7.0.1
 */