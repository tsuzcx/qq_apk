import com.tencent.mobileqq.activity.LoginActivity;

public class ehx
  implements Runnable
{
  public ehx(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      this.a.showDialog(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehx
 * JD-Core Version:    0.7.0.1
 */