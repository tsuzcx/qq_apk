import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.dating.DatingUserCenterAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class icm
  implements AbsListView.OnScrollListener
{
  public icm(DatingUserCenterActivity paramDatingUserCenterActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (DatingUserCenterActivity.a(this.a) == 1)
    {
      if (paramInt != 2) {
        break label37;
      }
      DatingUserCenterActivity.a(this.a).c();
      DatingUserCenterActivity.a(this.a).a();
    }
    label37:
    do
    {
      return;
      if (DatingUserCenterActivity.a(this.a).a()) {
        DatingUserCenterActivity.a(this.a).b();
      }
    } while ((paramInt != 0) || (DatingUserCenterActivity.a(this.a) == null));
    DatingUserCenterActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icm
 * JD-Core Version:    0.7.0.1
 */