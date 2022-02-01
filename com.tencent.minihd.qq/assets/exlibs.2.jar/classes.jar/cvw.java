import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.a.a;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class cvw
  implements ManagedClientConnection
{
  private volatile long jdField_a_of_type_Long;
  private volatile cvv jdField_a_of_type_Cvv;
  private final ClientConnectionManager jdField_a_of_type_OrgApacheHttpConnClientConnectionManager;
  private final ClientConnectionOperator jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public cvw(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, cvv paramcvv)
  {
    if (paramClientConnectionManager == null) {
      throw new IllegalArgumentException("Connection manager may not be null");
    }
    if (paramClientConnectionOperator == null) {
      throw new IllegalArgumentException("Connection operator may not be null");
    }
    if (paramcvv == null) {
      throw new IllegalArgumentException("HTTP pool entry may not be null");
    }
    this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager = paramClientConnectionManager;
    this.jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator = paramClientConnectionOperator;
    this.jdField_a_of_type_Cvv = paramcvv;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 9223372036854775807L;
  }
  
  private OperatedClientConnection a()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    if (localcvv == null) {
      return null;
    }
    return (OperatedClientConnection)localcvv.b();
  }
  
  private cvv b()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    if (localcvv == null) {
      throw new a();
    }
    return localcvv;
  }
  
  private OperatedClientConnection b()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    if (localcvv == null) {
      throw new a();
    }
    return (OperatedClientConnection)localcvv.b();
  }
  
  public cvv a()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    this.jdField_a_of_type_Cvv = null;
    return localcvv;
  }
  
  public ClientConnectionManager a()
  {
    return this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager;
  }
  
  /* Error */
  public void abortConnection()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	cvw:jdField_a_of_type_Cvv	Lcvv;
    //   6: ifnonnull +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 36	cvw:jdField_a_of_type_Boolean	Z
    //   17: aload_0
    //   18: getfield 34	cvw:jdField_a_of_type_Cvv	Lcvv;
    //   21: invokevirtual 48	cvv:b	()Ljava/lang/Object;
    //   24: checkcast 50	org/apache/http/conn/OperatedClientConnection
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 61 1 0
    //   34: aload_0
    //   35: getfield 30	cvw:jdField_a_of_type_OrgApacheHttpConnClientConnectionManager	Lorg/apache/http/conn/ClientConnectionManager;
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 40	cvw:jdField_a_of_type_Long	J
    //   43: getstatic 67	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   46: invokeinterface 73 5 0
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 34	cvw:jdField_a_of_type_Cvv	Lcvv;
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: goto -31 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	cvw
    //   27	2	1	localOperatedClientConnection	OperatedClientConnection
    //   59	4	1	localObject	Object
    //   64	1	1	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	59	finally
    //   12	28	59	finally
    //   28	34	59	finally
    //   34	58	59	finally
    //   60	62	59	finally
    //   28	34	64	java/io/IOException
  }
  
  public void close()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    if (localcvv != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localcvv.b();
      localcvv.b();
      localOperatedClientConnection.close();
    }
  }
  
  public void flush()
  {
    b().flush();
  }
  
  public InetAddress getLocalAddress()
  {
    return b().getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return b().getLocalPort();
  }
  
  public HttpConnectionMetrics getMetrics()
  {
    return b().getMetrics();
  }
  
  public InetAddress getRemoteAddress()
  {
    return b().getRemoteAddress();
  }
  
  public int getRemotePort()
  {
    return b().getRemotePort();
  }
  
  public HttpRoute getRoute()
  {
    return b().a();
  }
  
  public SSLSession getSSLSession()
  {
    Socket localSocket = b().getSocket();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  public int getSocketTimeout()
  {
    return b().getSocketTimeout();
  }
  
  public Object getState()
  {
    return b().c();
  }
  
  public boolean isMarkedReusable()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean isOpen()
  {
    OperatedClientConnection localOperatedClientConnection = a();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isOpen();
    }
    return false;
  }
  
  public boolean isResponseAvailable(int paramInt)
  {
    return b().isResponseAvailable(paramInt);
  }
  
  public boolean isSecure()
  {
    return b().isSecure();
  }
  
  public boolean isStale()
  {
    OperatedClientConnection localOperatedClientConnection = a();
    if (localOperatedClientConnection != null) {
      return localOperatedClientConnection.isStale();
    }
    return true;
  }
  
  public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new a();
      }
    }
    finally {}
    Object localObject = this.jdField_a_of_type_Cvv.a();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (!((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Protocol layering without a tunnel not supported");
    }
    if (((RouteTracker)localObject).isLayered()) {
      throw new IllegalStateException("Multiple protocol layering not supported");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.jdField_a_of_type_Cvv.b();
    this.jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator.updateSecureConnection(localOperatedClientConnection, (HttpHost)localObject, paramHttpContext, paramHttpParams);
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.jdField_a_of_type_Cvv.a().layerProtocol(localOperatedClientConnection.isSecure());
  }
  
  public void markReusable()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams)
  {
    if (paramHttpRoute == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new a();
      }
    }
    finally {}
    if (this.jdField_a_of_type_Cvv.a().isConnected()) {
      throw new IllegalStateException("Connection already open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.jdField_a_of_type_Cvv.b();
    if (b.b()) {
      b.b("http", "host:" + localOperatedClientConnection.getTargetHost() + "   " + localOperatedClientConnection.getLocalAddress() + ":" + localOperatedClientConnection.getLocalPort() + "   " + localOperatedClientConnection.getRemoteAddress() + ":" + localOperatedClientConnection.getRemotePort());
    }
    HttpHost localHttpHost2 = paramHttpRoute.getProxyHost();
    ClientConnectionOperator localClientConnectionOperator = this.jdField_a_of_type_OrgApacheHttpConnClientConnectionOperator;
    if (localHttpHost2 != null) {}
    for (HttpHost localHttpHost1 = localHttpHost2;; localHttpHost1 = paramHttpRoute.getTargetHost())
    {
      localClientConnectionOperator.openConnection(localOperatedClientConnection, localHttpHost1, paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
      try
      {
        if (this.jdField_a_of_type_Cvv != null) {
          break;
        }
        throw new InterruptedIOException();
      }
      finally {}
    }
    paramHttpRoute = this.jdField_a_of_type_Cvv.a();
    if (localHttpHost2 == null) {
      paramHttpRoute.connectTarget(localOperatedClientConnection.isSecure());
    }
    for (;;)
    {
      return;
      paramHttpRoute.connectProxy(localHttpHost2, localOperatedClientConnection.isSecure());
    }
  }
  
  public void receiveResponseEntity(HttpResponse paramHttpResponse)
  {
    b().receiveResponseEntity(paramHttpResponse);
  }
  
  public HttpResponse receiveResponseHeader()
  {
    return b().receiveResponseHeader();
  }
  
  public void releaseConnection()
  {
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        return;
      }
      this.jdField_a_of_type_OrgApacheHttpConnClientConnectionManager.releaseConnection(this, this.jdField_a_of_type_Long, TimeUnit.MILLISECONDS);
      this.jdField_a_of_type_Cvv = null;
      return;
    }
    finally {}
  }
  
  public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    b().sendRequestEntity(paramHttpEntityEnclosingRequest);
  }
  
  public void sendRequestHeader(HttpRequest paramHttpRequest)
  {
    b().sendRequestHeader(paramHttpRequest);
  }
  
  public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_Long = paramTimeUnit.toMillis(paramLong);
      return;
    }
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void setSocketTimeout(int paramInt)
  {
    b().setSocketTimeout(paramInt);
  }
  
  public void setState(Object paramObject)
  {
    b().a(paramObject);
  }
  
  public void shutdown()
  {
    cvv localcvv = this.jdField_a_of_type_Cvv;
    if (localcvv != null)
    {
      OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)localcvv.b();
      localcvv.b();
      localOperatedClientConnection.shutdown();
    }
  }
  
  public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpHost == null) {
      throw new IllegalArgumentException("Next proxy amy not be null");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new a();
      }
    }
    finally {}
    if (!this.jdField_a_of_type_Cvv.a().isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.jdField_a_of_type_Cvv.b();
    localOperatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.jdField_a_of_type_Cvv.a().tunnelProxy(paramHttpHost, paramBoolean);
  }
  
  public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams)
  {
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new a();
      }
    }
    finally {}
    Object localObject = this.jdField_a_of_type_Cvv.a();
    if (!((RouteTracker)localObject).isConnected()) {
      throw new IllegalStateException("Connection not open");
    }
    if (((RouteTracker)localObject).isTunnelled()) {
      throw new IllegalStateException("Connection is already tunnelled");
    }
    localObject = ((RouteTracker)localObject).getTargetHost();
    OperatedClientConnection localOperatedClientConnection = (OperatedClientConnection)this.jdField_a_of_type_Cvv.b();
    localOperatedClientConnection.update(null, (HttpHost)localObject, paramBoolean, paramHttpParams);
    try
    {
      if (this.jdField_a_of_type_Cvv == null) {
        throw new InterruptedIOException();
      }
    }
    finally {}
    this.jdField_a_of_type_Cvv.a().tunnelTarget(paramBoolean);
  }
  
  public void unmarkReusable()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cvw
 * JD-Core Version:    0.7.0.1
 */