import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.CircleObserver;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.service.circle.ISwitchObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class hhl
  extends CircleObserver
{
  public hhl(CircleManager paramCircleManager) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    CircleManager.a(this.a, false);
    label82:
    IGroupObserver localIGroupObserver;
    if ((paramBoolean) && (paramInt == 0))
    {
      CircleManager.a(this.a, System.currentTimeMillis());
      CircleManager.a(this.a).edit().putLong("circle_data_update_stamp", CircleManager.a(this.a)).commit();
      if (this.a.b == null) {
        break label177;
      }
      Iterator localIterator = this.a.b.iterator();
      if (!localIterator.hasNext()) {
        break label177;
      }
      localIGroupObserver = (IGroupObserver)localIterator.next();
      if ((!paramBoolean) || (paramInt != 0)) {
        break label172;
      }
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      localIGroupObserver.a(bool, 2);
      break label82;
      if ((!paramBoolean) || (paramInt != 67)) {
        break;
      }
      CircleManager.b(this.a);
      if (CircleManager.b(this.a) >= 1) {
        break;
      }
      CircleManager.c(this.a);
      CircleManager.c(this.a);
      break;
    }
    label177:
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$onGetCircle | cost = " + (System.currentTimeMillis() - CircleManager.b(this.a)) + " | isSuccess = " + paramBoolean + " | errorCode = " + paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a(paramBoolean2, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$onSetSwitches | isSearchable = " + paramBoolean2);
      }
      if (this.a.a == null) {
        break;
      }
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ISwitchObserver)localIterator.next()).a(paramBoolean1, paramBoolean2);
      }
      paramBoolean2 = this.a.a(false);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a(paramBoolean2, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$onGetSwitches | isSearchable = " + paramBoolean2);
      }
      if (this.a.a == null) {
        break;
      }
      Iterator localIterator = this.a.a.iterator();
      while (localIterator.hasNext()) {
        ((ISwitchObserver)localIterator.next()).b(paramBoolean1, paramBoolean2);
      }
      paramBoolean2 = this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hhl
 * JD-Core Version:    0.7.0.1
 */