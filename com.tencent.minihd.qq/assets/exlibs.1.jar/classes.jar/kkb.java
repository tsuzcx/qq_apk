import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;

public class kkb
  implements Runnable
{
  public kkb(TroopFeedsDataManager paramTroopFeedsDataManager) {}
  
  public void run()
  {
    Message localMessage = this.a.a.obtainMessage(2);
    localMessage.obj = this.a.a();
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kkb
 * JD-Core Version:    0.7.0.1
 */