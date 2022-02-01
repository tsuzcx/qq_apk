import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.flaotaio.FloatHbCircle.HbCircleCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.BasePadActivity;

public class gle
  implements FloatHbCircle.HbCircleCallBack
{
  public gle(FloatAioController paramFloatAioController) {}
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if ((FloatAioController.a(this.a).isBackground_Stop) || (BasePadActivity.getContaierViewId() == 2131301978) || (BasePadActivity.getContaierViewId() == 2131297932)) {
      FloatAioController.a(this.a, paramMessage, false);
    }
    for (;;)
    {
      ReportController.b(FloatAioController.a(this.a), "CliOper", "", "", "0X800628A", "0X800628A", 0, 0, "", "", "", "");
      return;
      this.a.a(FloatAioController.a(this.a).a(), paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gle
 * JD-Core Version:    0.7.0.1
 */