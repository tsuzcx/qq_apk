import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class egd
  extends GameCenterObserver
{
  public egd(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!paramBoolean1) || (paramInt == 2)) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      LebaUtil.a(localArrayList, LebaShowListManager.a().b());
      this.a.runOnUiThread(new ege(this, localArrayList));
    } while (!QLog.isColorLevel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egd
 * JD-Core Version:    0.7.0.1
 */