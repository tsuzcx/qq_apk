import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;

public class bzj
  implements Runnable
{
  public bzj(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean) {}
  
  public void run()
  {
    QavChatActivity localQavChatActivity = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (localQavChatActivity != null)
    {
      QavSession localQavSession = QavBussinessCtrl.a().a();
      if (localQavSession != null)
      {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, this.jdField_a_of_type_Boolean, localQavSession.h, localQavSession.d(), localQavSession.c);
        localQavChatActivity.a(this.jdField_a_of_type_Boolean, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzj
 * JD-Core Version:    0.7.0.1
 */