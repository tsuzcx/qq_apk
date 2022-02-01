import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader;
import com.tencent.qphone.base.util.QLog;

public class jkn
  implements Runnable
{
  public jkn(TurnBrandActivity paramTurnBrandActivity) {}
  
  public void run()
  {
    TurnBrandActivity.a(this.a).c();
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "local dir has been cleared!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkn
 * JD-Core Version:    0.7.0.1
 */