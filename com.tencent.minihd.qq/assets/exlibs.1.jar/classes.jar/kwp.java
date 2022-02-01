import com.tencent.mobileqq.webprocess.WebProcessManager;

public class kwp
  implements Runnable
{
  public kwp(WebProcessManager paramWebProcessManager) {}
  
  public void run()
  {
    if (this.a.d())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kwp
 * JD-Core Version:    0.7.0.1
 */