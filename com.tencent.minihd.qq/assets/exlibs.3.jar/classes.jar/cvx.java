import com.tencent.component.network.utils.a.g;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ManagedClientConnection;

public class cvx
  implements ClientConnectionRequest
{
  public cvx(g paramg, Future paramFuture) {}
  
  public void abortRequest()
  {
    this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  public ManagedClientConnection getConnection(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkUtilsAG.a(this.jdField_a_of_type_JavaUtilConcurrentFuture, paramLong, paramTimeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvx
 * JD-Core Version:    0.7.0.1
 */