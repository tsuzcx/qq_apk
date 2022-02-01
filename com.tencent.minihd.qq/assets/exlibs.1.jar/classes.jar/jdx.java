import android.content.Context;
import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

public class jdx
  implements MagicfaceDecoder.MagicPlayListener
{
  public jdx(Action paramAction) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "fun startMagicPlay begins, sumPlayTimes:" + Action.a(this.a) + ",actionGlobalData.openSound:" + this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d);
    }
    if (Action.a(this.a) == 0)
    {
      Action.a(this.a);
      if ((Action.a(this.a).c != null) && (Action.a(this.a).c.length() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d))
      {
        if (Action.a(this.a).e > 0)
        {
          MagicfacePlayRes localMagicfacePlayRes = Action.a(this.a);
          localMagicfacePlayRes.e -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a).c, Action.a(this.a).e);
      }
      if (Action.a(this.a).a)
      {
        Action.a(this.a, (Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (Action.a(this.a).h != -1) {
          break label305;
        }
        Action.a(this.a).vibrate(new long[] { 0L, 1000L }, 0);
      }
    }
    for (;;)
    {
      Action.b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("Action", 2, "fun startMagicPlay ends, sumPlayTimes:" + Action.a(this.a));
      }
      return;
      label305:
      Action.a(this.a).vibrate(Action.a(this.a).h * 1000);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "func endMagicPlay begins, isStop:" + Action.a(this.a) + ",timeout:" + this.a.jdField_a_of_type_Int + ",playTimes:" + this.a.jdField_b_of_type_Int + ",sumPlayTimes:" + Action.a(this.a) + ",isTimeout:" + this.a.jdField_b_of_type_Boolean);
    }
    if (Action.a(this.a)) {
      Action.a(this.a).countDown();
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Int == -1)
      {
        if (this.a.jdField_b_of_type_Int == -1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
          return;
        }
        if (this.a.jdField_b_of_type_Int > Action.a(this.a))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
          return;
        }
        if (this.a.jdField_b_of_type_Int == Action.a(this.a))
        {
          Action.a(this.a).countDown();
          return;
        }
      }
    } while (this.a.jdField_b_of_type_Boolean);
    this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(Action.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jdx
 * JD-Core Version:    0.7.0.1
 */