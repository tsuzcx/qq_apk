import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.session.QavSession;

public class bzk
  implements Runnable
{
  public bzk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean) {}
  
  public void run()
  {
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession != null) {
      DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI, localQavSession.f, this.jdField_a_of_type_Boolean, localQavSession.d(), localQavSession.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzk
 * JD-Core Version:    0.7.0.1
 */