import com.tencent.mobileqq.activity.LoginActivity;

public class eid
  implements Runnable
{
  public eid(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    LoginActivity.e(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eid
 * JD-Core Version:    0.7.0.1
 */