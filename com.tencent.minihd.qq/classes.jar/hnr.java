import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;

class hnr
  implements Runnable
{
  hnr(hnq paramhnq, int paramInt, String paramString1, String paramString2, String paramString3, Context paramContext, String paramString4) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localSessionInfo.d = this.jdField_a_of_type_JavaLangString;
    Object localObject;
    if (this.jdField_a_of_type_Int == 1006)
    {
      localSessionInfo.jdField_a_of_type_JavaLangString = this.b;
      localObject = ((PhoneContactManager)this.jdField_a_of_type_Hnq.a.getManager(10)).a();
      if (localObject != null) {
        localSessionInfo.e = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
      }
    }
    for (;;)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_Hnq.a, this.jdField_a_of_type_AndroidContentContext, localSessionInfo, this.d);
      return;
      if (this.jdField_a_of_type_Int == 1000)
      {
        localObject = ((FriendManager)this.jdField_a_of_type_Hnq.a.getManager(8)).a(this.b);
        localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
        localSessionInfo.b = ((TroopInfo)localObject).troopcode;
        localSessionInfo.c = ((TroopInfo)localObject).troopuin;
      }
      else if (this.jdField_a_of_type_Int == 1004)
      {
        localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
        localSessionInfo.b = this.b;
      }
      else
      {
        localSessionInfo.jdField_a_of_type_JavaLangString = this.c;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnr
 * JD-Core Version:    0.7.0.1
 */