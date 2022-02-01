import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class gdl
  implements Runnable
{
  public gdl(HongbaoKeywordGrayTips paramHongbaoKeywordGrayTips) {}
  
  public void run()
  {
    Object localObject = HongbaoKeywordGrayTips.a(this.a).a().a(HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_JavaLangString, HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int, false);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int != 0) {
        break label131;
      }
      HongbaoKeywordGrayTips.a(this.a, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + HongbaoKeywordGrayTips.a(this.a));
      }
      return;
      label131:
      if ((HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int == 3000) || (HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int == 1)) {
        HongbaoKeywordGrayTips.a(this.a, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdl
 * JD-Core Version:    0.7.0.1
 */