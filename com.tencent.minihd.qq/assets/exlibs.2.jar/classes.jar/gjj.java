import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.widget.AbsListView;

public class gjj
  implements SlideDetectListView.OnScrollToTopListener
{
  public gjj(NotificationView paramNotificationView) {}
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((NotificationView.a(this.a) != null) && (paramInt == 0) && (NotificationView.a(this.a) == NotificationView.a(this.a).getCount())) {
      NotificationView.b(this.a);
    }
    NotificationView.a(this.a, paramInt);
    if (paramInt != 0)
    {
      NotificationView.a(this.a).c();
      NotificationView.a(this.a).a();
    }
    while (!NotificationView.a(this.a).a()) {
      return;
    }
    NotificationView.a(this.a).b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    NotificationView.b(this.a, paramInt1 + paramInt2 - 1);
    if (paramInt1 > 1) {
      GroupSystemMsgController.a().a();
    }
    while (!this.a.b) {
      return;
    }
    GroupSystemMsgController.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjj
 * JD-Core Version:    0.7.0.1
 */