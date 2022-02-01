import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;

public class deg
  extends FriendListObserver
{
  public deg(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (paramBoolean)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     deg
 * JD-Core Version:    0.7.0.1
 */