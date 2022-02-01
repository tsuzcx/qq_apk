import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class eqc
  implements Runnable
{
  public eqc(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = ProfileCardMoreActivity.a(this.a, this.a.a.a);
      ProfileCardMoreActivity.a(this.a, false);
      this.a.app.runOnUiThread(new eqd(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqc
 * JD-Core Version:    0.7.0.1
 */