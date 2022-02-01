import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class ick
  implements OverScrollViewListener
{
  public ick(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (DatingUserCenterActivity.e(this.a)[DatingUserCenterActivity.a(this.a)] != 0)
    {
      DatingUserCenterActivity.a(this.a).a();
      return;
    }
    DatingUserCenterActivity.a(this.a).c(DatingUserCenterActivity.a(this.a)[DatingUserCenterActivity.a(this.a)]);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (DatingUserCenterActivity.e(this.a)[DatingUserCenterActivity.a(this.a)] != 0) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dating", 2, "datingUserCenterActivity is refreshing");
      }
    }
    do
    {
      return true;
      DatingUserCenterActivity.a(this.a).a(DatingUserCenterActivity.a(this.a)[DatingUserCenterActivity.a(this.a)]);
      DatingUserCenterActivity.e(this.a)[DatingUserCenterActivity.a(this.a)] = 1;
      if (!NetworkUtil.e(this.a)) {
        break;
      }
      if (DatingUserCenterActivity.a(this.a) == 1)
      {
        paramInt = DatingUserCenterActivity.a(this.a, "server_stamp_of_joined");
        this.a.a(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(20), Integer.valueOf(4098) });
        return true;
      }
    } while (DatingUserCenterActivity.a(this.a) != 0);
    paramInt = DatingUserCenterActivity.a(this.a, "server_stamp_of_published");
    DatingUserCenterActivity.a(this.a).a(paramInt, 0, 20, 0, 4098);
    return true;
    paramView = DatingUserCenterActivity.a(this.a).obtainMessage(4097);
    DatingUserCenterActivity.a(this.a).sendMessageDelayed(paramView, 500L);
    DatingUserCenterActivity.e(this.a)[DatingUserCenterActivity.a(this.a)] = 0;
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (DatingUserCenterActivity.e(this.a)[DatingUserCenterActivity.a(this.a)] == 0) {
      DatingUserCenterActivity.a(this.a).b(DatingUserCenterActivity.a(this.a)[DatingUserCenterActivity.a(this.a)]);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ick
 * JD-Core Version:    0.7.0.1
 */