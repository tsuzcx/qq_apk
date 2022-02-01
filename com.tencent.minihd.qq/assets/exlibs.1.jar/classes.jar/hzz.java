import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class hzz
  implements AbsListView.OnScrollListener
{
  public hzz(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.t() == paramAbsListView.b() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("DatingDestinationActivity", 4, "onScrollStateChanged");
      }
      if (!DatingDestinationActivity.a(this.a)) {
        DatingDestinationActivity.a(this.a, DatingDestinationActivity.b(this.a), DatingDestinationActivity.a(this.a));
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzz
 * JD-Core Version:    0.7.0.1
 */