import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class djf
  implements Runnable
{
  djf(djd paramdjd, RichStatus.SigZanInfo paramSigZanInfo) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, RichStatItemBuilder.a);
    Object localObject;
    Message localMessage;
    if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForRichState)))
    {
      localObject = new HashMap();
      ((Map)localObject).put("chatMessage", localMessageRecord);
      ((Map)localObject).put("sigZanInfo", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo);
      this.jdField_a_of_type_Djd.a.jdField_a_of_type_AndroidOsHandler.removeMessages(267387138);
      localMessage = this.jdField_a_of_type_Djd.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(267387138);
      localMessage.obj = localObject;
    }
    try
    {
      localObject = new JSONObject(localMessageRecord.msg);
      ((JSONObject)localObject).put("count", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo.b);
      ((JSONObject)localObject).put("zanfalg", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus$SigZanInfo.c);
      this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Djd.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageRecord.uniseq, ((JSONObject)localObject).toString());
      label214:
      this.jdField_a_of_type_Djd.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label214;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djf
 * JD-Core Version:    0.7.0.1
 */