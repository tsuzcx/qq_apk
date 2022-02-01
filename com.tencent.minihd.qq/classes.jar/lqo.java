import android.annotation.TargetApi;
import android.view.VelocityTracker;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.OverScroller;

class lqo
  implements Runnable
{
  lqo(lqn paramlqn) {}
  
  @TargetApi(8)
  public void run()
  {
    int i = AbsListView.c(this.a.a);
    VelocityTracker localVelocityTracker = AbsListView.a(this.a.a);
    OverScroller localOverScroller = lqn.a(this.a);
    if ((localVelocityTracker == null) || (i == -1)) {
      return;
    }
    localVelocityTracker.computeCurrentVelocity(1000, AbsListView.d(this.a.a));
    if (VersionUtils.b()) {}
    for (float f = -localVelocityTracker.getYVelocity(i); (Math.abs(f) >= AbsListView.e(this.a.a)) && (localOverScroller.a(0.0F, f)); f = -localVelocityTracker.getYVelocity())
    {
      this.a.a.postDelayed(this, 40L);
      return;
    }
    this.a.a();
    this.a.a.ab = 3;
    this.a.a.c(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lqo
 * JD-Core Version:    0.7.0.1
 */