import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import java.util.ArrayList;

public class fcq
  implements Runnable
{
  public fcq(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void run()
  {
    StrangerHandler localStrangerHandler = (StrangerHandler)this.a.app.a(28);
    if (this.a.b.isEmpty()) {
      return;
    }
    localStrangerHandler.a(this.a.b);
    this.a.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcq
 * JD-Core Version:    0.7.0.1
 */