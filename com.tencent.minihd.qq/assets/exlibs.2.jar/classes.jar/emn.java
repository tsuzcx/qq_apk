import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.qphone.base.util.QLog;

class emn
  implements Runnable
{
  emn(emi paramemi) {}
  
  public void run()
  {
    Message localMessage = NearbyActivity.a(this.a.a).obtainMessage(3);
    if (DatingUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "onUpdateGetEncounter.lbsinfo is null and permission is denied");
      }
      localMessage.arg1 = 1;
    }
    NearbyActivity.a(this.a.a).sendMessageDelayed(localMessage, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emn
 * JD-Core Version:    0.7.0.1
 */