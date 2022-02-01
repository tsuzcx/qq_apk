import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;

public class ibv
  implements Runnable
{
  public ibv(DatingManager paramDatingManager) {}
  
  public void run()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.a.a.a(40);
    this.a.a(localDatingHandler, 1, 1);
    this.a.a(localDatingHandler, 2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibv
 * JD-Core Version:    0.7.0.1
 */