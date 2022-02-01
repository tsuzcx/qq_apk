import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import java.util.List;

public class egr
  implements Runnable
{
  public egr(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaShowListManager.a().a(this.a, this.a.app);
    List localList = LebaShowListManager.a().a();
    this.a.runOnUiThread(new egs(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egr
 * JD-Core Version:    0.7.0.1
 */