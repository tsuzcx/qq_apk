import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class ghl
  implements BaseNewFriendView.INewFriendContext
{
  public ghl(ContactRecommendActivity paramContactRecommendActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return (View)this.a.findViewById(2131297347).getParent().getParent();
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public void a()
  {
    ContactRecommendActivity.b(this.a);
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if (this.a.isResume()) {
      QQToast.a(a(), paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public View b()
  {
    return (View)this.a.findViewById(2131297347).getParent();
  }
  
  public void b()
  {
    ContactRecommendActivity.a(this.a);
  }
  
  public View c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghl
 * JD-Core Version:    0.7.0.1
 */