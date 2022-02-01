import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.qphone.base.util.QLog;

public class jgi
  implements Runnable
{
  public jgi(ChatBackgroundManager paramChatBackgroundManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatBackgroundManager.k = this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager.c(null);
    Message localMessage = ChatBackgroundManager.a.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface };
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + ChatBackgroundManager.k);
    }
    ChatBackgroundManager.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgi
 * JD-Core Version:    0.7.0.1
 */