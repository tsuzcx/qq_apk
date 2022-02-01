import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class gdp
  implements Runnable
{
  public gdp(QQOperateTips paramQQOperateTips) {}
  
  public void run()
  {
    Object localObject1 = QQOperateTips.a(this.a).a().a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, false);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (QQOperateTips.a(this.a).jdField_a_of_type_Int != 0) {
          break label329;
        }
        QQOperateTips.a(this.a, ((ChatMessage)localObject2).time);
        QQOperateTips.b(this.a, ((ChatMessage)localObject2).uniseq);
      }
      if (QQOperateTips.a(this.a).a().a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int) <= 0) {
        break label361;
      }
      i = 1;
      label146:
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i - 1);
        if ((localObject2 == null) || (!((ChatMessage)localObject2).isread)) {}
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + QQOperateTips.a(this.a));
        }
        localObject2 = QQOperateManager.a(QQOperateTips.a(this.a));
        localObject1 = ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, QQOperateTips.a(this.a), (List)localObject1, true, QQOperateTips.a(this.a));
        if (((QQOperationRequestInfo)localObject1).jdField_a_of_type_Boolean)
        {
          localObject1 = ((QQOperationRequestInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
          ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, (ArrayList)localObject1, QQOperateTips.a(this.a));
        }
        QQOperateTips.a(this.a, -1);
        return;
        label329:
        if (QQOperateTips.a(this.a).jdField_a_of_type_Int != 3000) {
          break;
        }
        QQOperateTips.a(this.a, ((ChatMessage)localObject2).shmsgseq);
        break;
        label361:
        i = 0;
        break label146;
      }
      QQOperateTips.a(this.a, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdp
 * JD-Core Version:    0.7.0.1
 */