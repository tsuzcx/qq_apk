import android.os.Handler;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import java.util.List;

public class egi
  implements Runnable
{
  public egi(Leba paramLeba) {}
  
  public void run()
  {
    List localList = LebaShowListManager.a().a(this.a.getActivity(), this.a.app);
    this.a.a.post(new egj(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egi
 * JD-Core Version:    0.7.0.1
 */