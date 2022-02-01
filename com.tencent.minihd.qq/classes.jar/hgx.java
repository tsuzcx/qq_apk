import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.statistics.UnifiedMonitor;

public class hgx
  implements Runnable
{
  public hgx(BusinessHandler paramBusinessHandler, BusinessObserver paramBusinessObserver, int paramInt, Handler paramHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().b(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_AndroidOsHandler == BusinessHandler.a()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().b(1)) && (this.jdField_a_of_type_AndroidOsHandler == BusinessHandler.a()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (BusinessHandler.b() == -1) {
        BusinessHandler.a(UnifiedMonitor.a().a(2, 1, 100));
      }
      if (l1 > BusinessHandler.b())
      {
        if (UnifiedMonitor.a().a(1)) {
          UnifiedMonitor.a().a(1, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.getClass().getName(), (int)l1, BusinessHandler.c());
        }
        BusinessHandler.b(0);
      }
    }
    else
    {
      return;
    }
    BusinessHandler.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgx
 * JD-Core Version:    0.7.0.1
 */