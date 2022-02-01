import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.statistics.ReportController;

class ewp
  implements View.OnTouchListener
{
  ewp(ewn paramewn) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      RecommendedGatherListActivity.a(this.a.a, paramView);
      ((Integer)paramView.getTag()).intValue();
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X8004F49", "0X8004F49", 0, 0, "", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewp
 * JD-Core Version:    0.7.0.1
 */