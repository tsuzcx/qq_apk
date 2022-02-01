import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouchManager;

public class jqd
  extends MessageObserver
{
  public jqd(RedTouchManager paramRedTouchManager) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 113) && (paramBoolean) && ((RedTouchManager.a(this.a) instanceof QQAppInterface))) {
      BusinessInfoCheckUpdateItem.a((QQAppInterface)RedTouchManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jqd
 * JD-Core Version:    0.7.0.1
 */