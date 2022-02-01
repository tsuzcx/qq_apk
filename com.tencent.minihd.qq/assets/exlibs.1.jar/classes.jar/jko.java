import android.os.Handler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.nearpeople.TurnBrandView;
import com.tencent.mobileqq.nearpeople.TurnBrandView.onFlingListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jko
  implements TurnBrandView.onFlingListener
{
  public jko(TurnBrandActivity paramTurnBrandActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "removeFirstObjectInAdapter!");
    }
    if (!TurnBrandActivity.a(this.a).a())
    {
      TurnBrandActivity.a(this.a).a();
      TurnBrandActivity.a(this.a);
    }
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onLeftCardExit!");
    }
    TurnBrandActivity.b(this.a);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onAdapterEmpty!");
    }
    this.a.b(2002, null);
    if ((NetworkUtil.f(BaseApplication.getContext())) && (TurnBrandActivity.a(this.a).size() > 0))
    {
      TurnBrandActivity.a(this.a).a(TurnBrandActivity.a(this.a));
      TurnBrandActivity.a(this.a, System.currentTimeMillis());
      TurnBrandActivity.a(this.a).clear();
    }
    this.a.a.sendEmptyMessageDelayed(1184275, 3000L);
  }
  
  public void b(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TurnBrandActivity", 2, "onRightCardExit!");
    }
    TurnBrandActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jko
 * JD-Core Version:    0.7.0.1
 */