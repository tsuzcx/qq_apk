import android.content.Intent;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class duc
  extends CardObserver
{
  public duc(DetailProfileActivity paramDetailProfileActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null) && (this.a.app.a().equals(paramObject.uin)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DetailProfileActivity", 2, "on my card download");
        }
        this.a.a(paramObject);
      }
      return;
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetDetailInfo, isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramCard != null) && (this.a.app.a().equals(paramCard.uin))) {
      this.a.a(paramCard);
    }
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DetailProfileActivity", 2, "onGetLocationDescription, isSuccess = " + paramBoolean + ", card = ");
    }
    if ((paramBoolean) && (paramString.equals(this.a.app.a())) && (paramCard != null)) {
      this.a.a(paramCard);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    this.a.b();
    if ((!paramBoolean) || (paramInt != 0))
    {
      int i = 2131369647;
      if (paramInt == 36) {
        i = 2131369648;
      }
      this.a.a(i, 1);
      return;
    }
    DetailProfileActivity.a(this.a);
    paramCard = new Intent();
    paramCard.putExtra("changed", true);
    if (DetailProfileActivity.a(this.a)) {
      paramCard.putExtra("param_switches_changed", true);
    }
    this.a.setResult(-1, paramCard);
    this.a.finish();
    this.a.overridePendingTransition(0, 2130968584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     duc
 * JD-Core Version:    0.7.0.1
 */