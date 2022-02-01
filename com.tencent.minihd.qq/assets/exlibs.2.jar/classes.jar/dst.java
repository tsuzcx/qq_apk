import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;

public class dst
  extends DataLineObserver
{
  public dst(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.Y, 6000);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    this.a.a(9, AppConstants.Y, 6000);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    this.a.a(8, AppConstants.Y, 6000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dst
 * JD-Core Version:    0.7.0.1
 */