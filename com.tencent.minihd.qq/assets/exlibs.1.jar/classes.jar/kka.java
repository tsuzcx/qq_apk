import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class kka
  extends Handler
{
  public kka(TroopFeedsDataManager paramTroopFeedsDataManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.a = ((List)paramMessage.obj);
      this.a.b();
      return;
      this.a.a = ((List)paramMessage.obj);
      TroopFeedsDataManager.a(this.a);
      this.a.notifyObservers(Integer.valueOf(101));
    } while (!QLog.isColorLevel());
    QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kka
 * JD-Core Version:    0.7.0.1
 */