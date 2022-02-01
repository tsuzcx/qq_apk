import android.text.TextUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.qphone.base.util.QLog;

public class iae
  implements Runnable
{
  public iae(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(49)).b(this.a.app.a());
    DatingDestinationActivity.a(this.a, localCard.strCity);
    DatingDestinationActivity.b(this.a, localCard.strHometownCodes);
    int i;
    if (!TextUtils.isEmpty(localCard.strHometownCodes))
    {
      i = DatingDestinationActivity.a(this.a).a();
      if (!DatingDestinationActivity.a(this.a, localCard.strHometownCodes)) {
        break label96;
      }
      DatingDestinationActivity.a(this.a);
    }
    label96:
    int j;
    do
    {
      return;
      if (i == 0)
      {
        DatingDestinationActivity.b(this.a);
        return;
      }
      j = DatingDestinationActivity.a(this.a).a(i);
    } while (!QLog.isColorLevel());
    QLog.d("DatingDestinationActivity", 2, "ConditionSearchManager result:" + i + " updateResult:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iae
 * JD-Core Version:    0.7.0.1
 */