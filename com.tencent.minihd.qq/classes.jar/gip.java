import android.view.View;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.widget.AbsListView;

public class gip
  implements SlideDetectListView.OnScrollToTopListener
{
  public gip(SystemMsgListView paramSystemMsgListView) {}
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((SystemMsgListView.a(this.a) != null) && (paramInt == 0) && (SystemMsgListView.a(this.a) == SystemMsgListView.a(this.a).getCount())) {
      SystemMsgListView.b(this.a);
    }
    SystemMsgListView.a(this.a, paramInt);
    if (paramInt != 0)
    {
      SystemMsgListView.a(this.a).c();
      SystemMsgListView.a(this.a).a();
    }
    for (;;)
    {
      return;
      if (SystemMsgListView.a(this.a).a()) {
        SystemMsgListView.a(this.a).b();
      }
      int i = SystemMsgListView.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramAbsListView = (SystemMsgListAdapter.ViewHolder)SystemMsgListView.a(this.a).getChildAt(paramInt).getTag();
        SystemMsgListView.a(this.a, paramAbsListView);
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.b(this.a, paramInt1 + paramInt2 - 1 - SystemMsgListView.a(this.a).m());
    if (paramInt1 > 1) {
      FriendSystemMsgController.a().a();
    }
    while (!SystemMsgListView.c(this.a)) {
      return;
    }
    FriendSystemMsgController.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gip
 * JD-Core Version:    0.7.0.1
 */