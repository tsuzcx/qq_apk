import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.AccountObserver;

public class hhc
  extends AccountObserver
{
  public hhc(CircleManager paramCircleManager) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3)
  {
    CircleManager.a(this.a).a(new hhd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hhc
 * JD-Core Version:    0.7.0.1
 */