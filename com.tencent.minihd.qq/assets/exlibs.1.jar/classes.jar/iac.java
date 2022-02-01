import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.qphone.base.util.QLog;

public class iac
  extends CardObserver
{
  public iac(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.app.a().equals(paramCard.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatingDestinationActivity", 2, "load card info success");
      }
      DatingDestinationActivity.a(this.a, paramCard.strCity);
      if ((DatingDestinationActivity.c(this.a) == null) || (!DatingDestinationActivity.c(this.a).equals(paramCard.strHometownCodes))) {
        break label82;
      }
    }
    label82:
    do
    {
      return;
      DatingDestinationActivity.b(this.a, paramCard.strHometownCodes);
      if (DatingDestinationActivity.a(this.a).a() == 0)
      {
        DatingDestinationActivity.b(this.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatingDestinationActivity", 2, "wait csm.update() finish and update UI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iac
 * JD-Core Version:    0.7.0.1
 */