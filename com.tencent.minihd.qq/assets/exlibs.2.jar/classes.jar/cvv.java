import com.tencent.component.network.utils.a.b.f;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;

public class cvv
  extends f
{
  HttpRoute jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute;
  private RouteTracker jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker;
  
  public cvv(Log paramLog, String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
    this.jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute = paramHttpRoute;
    this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker = new RouteTracker(paramHttpRoute);
  }
  
  HttpRoute a()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker.toRoute();
  }
  
  RouteTracker a()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker;
  }
  
  public void a()
  {
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)b();
    try
    {
      localOperatedClientConnection.close();
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public boolean a()
  {
    return !((OperatedClientConnection)b()).isOpen();
  }
  
  public boolean a(long paramLong)
  {
    return super.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_OrgApacheHttpConnRoutingRouteTracker = new RouteTracker(this.jdField_a_of_type_OrgApacheHttpConnRoutingHttpRoute);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cvv
 * JD-Core Version:    0.7.0.1
 */