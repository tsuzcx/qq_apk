import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class dsq
  extends DiscussionObserver
{
  public dsq(Conversation paramConversation) {}
  
  protected void a()
  {
    this.a.a(9, null, -2147483648);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onDelDiscussion");
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, ArrayList paramArrayList)
  {
    this.a.a(8, Long.toString(paramLong), 3000);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onQuitDiscussion");
      }
      this.a.a(8, paramString, 3000);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.runOnUiThread(new dsr(this, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((paramBoolean) && (bool))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_updateDiscussionInfo");
      }
      this.a.a(0L);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onChangeDiscussionName");
      }
      this.a.a(8, paramString, 3000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsq
 * JD-Core Version:    0.7.0.1
 */