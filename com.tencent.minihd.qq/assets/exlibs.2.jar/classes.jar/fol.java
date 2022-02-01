import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;

public class fol
  implements Runnable
{
  public fol(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      this.a.setResult(-1);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fol
 * JD-Core Version:    0.7.0.1
 */