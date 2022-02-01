import android.view.View;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyUserBehaviorReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class eln
  implements OverScrollViewListener
{
  public eln(NearbyActivity paramNearbyActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    NearbyActivity.a(this.a).c(NearbyActivity.b(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    NearbyActivity.a(this.a).a(NearbyActivity.b(this.a));
    if (NetworkUtil.e(this.a)) {
      this.a.a(true, true);
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.b(10);
      }
      return true;
      paramView = NearbyActivity.a(this.a).obtainMessage(1, 1, 0);
      NearbyActivity.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    NearbyActivity.a(this.a).b(NearbyActivity.b(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eln
 * JD-Core Version:    0.7.0.1
 */