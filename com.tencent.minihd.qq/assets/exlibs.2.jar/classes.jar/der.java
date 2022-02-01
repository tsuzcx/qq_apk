import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class der
  implements Runnable
{
  public der(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a = true;
    AddFriendLogicActivity.a(this.a).hide();
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     der
 * JD-Core Version:    0.7.0.1
 */