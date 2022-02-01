import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;

public class efa
  extends CardObserver
{
  public efa(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (paramBoolean)
    {
      if ((this.a.app.a().equals(paramString)) && (paramCard != null) && (-1 != paramCard.switch_interest) && (-1 != paramCard.switch_music) && (-1 != paramCard.switch_recent_activity) && (-1 != paramCard.switch_star) && (-1 != paramCard.switch_joined_troop) && (-1 != paramCard.switch_ktv) && (-1 != paramCard.switch_eat))
      {
        InterestSwitchEditActivity.a(this.a, paramCard);
        InterestSwitchEditActivity.a(this.a);
      }
      return;
    }
    QQToast.a(this.a, "拉取开关信息失败", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     efa
 * JD-Core Version:    0.7.0.1
 */