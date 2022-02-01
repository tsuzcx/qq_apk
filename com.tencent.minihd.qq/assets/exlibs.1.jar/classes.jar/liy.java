import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.notification.QavNotification;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.thread.ThreadManager;

public class liy
  implements Runnable
{
  public liy(QavBussinessCtrl paramQavBussinessCtrl) {}
  
  public void run()
  {
    QavSession localQavSession = this.a.a();
    if (localQavSession != null)
    {
      long l = System.currentTimeMillis() - QavBussinessCtrl.a(this.a);
      localQavSession.b = l;
      QavBussinessCtrl.a(this.a, localQavSession);
      QavBussinessCtrl.a(this.a).a(l);
      ObserverDispatcher.instance().notifyObservers(QavBussinessObserver.class, 30, new Object[] { Long.valueOf(l) });
    }
    ThreadManager.executeOnSubThreadDelay(QavBussinessCtrl.a(this.a), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     liy
 * JD-Core Version:    0.7.0.1
 */