import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.FriendFloatChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.SendMessageHandler;

public class gmu
  extends MessageObserver
{
  public gmu(FriendFloatChatPie paramFriendFloatChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.a.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.a.jdField_a_of_type_Int)) {
      return;
    }
    this.a.a(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.a(131072);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmu
 * JD-Core Version:    0.7.0.1
 */