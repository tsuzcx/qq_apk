import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class cbs
  implements BusinessObserver
{
  public cbs(TroopRedTouchHandler paramTroopRedTouchHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label73;
      }
      TroopRedTouchHandler.a(this.a.a, paramBundle);
      this.a.a(105, true, null);
    }
    label73:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cbs
 * JD-Core Version:    0.7.0.1
 */