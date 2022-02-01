import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;

public class dim
  implements Runnable
{
  public dim(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.a.a.setSelectionFromBottom(this.a.a.b() - 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dim
 * JD-Core Version:    0.7.0.1
 */