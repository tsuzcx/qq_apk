import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class evc
  extends CardObserver
{
  public evc(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.app.a().equals(((Card)paramObject).uin))) {
      QQSettingSettingActivity.a(this.a, (Card)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evc
 * JD-Core Version:    0.7.0.1
 */