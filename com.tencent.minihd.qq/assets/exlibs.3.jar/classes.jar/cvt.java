import com.tencent.component.network.utils.a.b.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;

public class cvt
  extends a
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong();
  private final long jdField_a_of_type_Long;
  private final TimeUnit jdField_a_of_type_JavaUtilConcurrentTimeUnit;
  private final Log jdField_a_of_type_OrgApacheCommonsLoggingLog;
  
  public cvt(Log paramLog, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit)
  {
    super(new cvu(), paramInt1, paramInt2);
    this.jdField_a_of_type_OrgApacheCommonsLoggingLog = paramLog;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilConcurrentTimeUnit = paramTimeUnit;
  }
  
  protected cvv a(HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection)
  {
    String str = Long.toString(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement());
    return new cvv(this.jdField_a_of_type_OrgApacheCommonsLoggingLog, str, paramHttpRoute, paramOperatedClientConnection, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilConcurrentTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvt
 * JD-Core Version:    0.7.0.1
 */