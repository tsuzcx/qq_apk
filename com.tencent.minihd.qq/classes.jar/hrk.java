import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;

public class hrk
  extends HotChatObserver
{
  private hrk(GetJoinedHotChatListStep paramGetJoinedHotChatListStep) {}
  
  protected void a(int paramInt)
  {
    if (GetJoinedHotChatListStep.a(this.a) != null)
    {
      GetJoinedHotChatListStep.a(this.a).a.c(GetJoinedHotChatListStep.a(this.a));
      GetJoinedHotChatListStep.a(this.a, null);
    }
    if (paramInt == 0)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hrk
 * JD-Core Version:    0.7.0.1
 */