import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import java.util.List;

public class ktz
  implements Runnable
{
  public ktz(SendMessageHandler paramSendMessageHandler, long paramLong, String paramString) {}
  
  public void run()
  {
    if (SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler) >= SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler).size()) {
      return;
    }
    int i = SendMessageHandler.b(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler);
    SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler).get(i);
    localSendMessageRunnable.jdField_a_of_type_Int = i;
    localSendMessageRunnable.g = System.currentTimeMillis();
    localSendMessageRunnable.c = this.jdField_a_of_type_Long;
    localSendMessageRunnable.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSendMessageRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ktz
 * JD-Core Version:    0.7.0.1
 */