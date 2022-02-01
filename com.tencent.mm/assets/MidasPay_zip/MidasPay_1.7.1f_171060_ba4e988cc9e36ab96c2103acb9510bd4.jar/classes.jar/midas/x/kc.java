package midas.x;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class kc
  extends jr
{
  private final String a;
  private final c b;
  private ThreadLocal<Boolean> c = new ThreadLocal()
  {
    protected Boolean a()
    {
      return Boolean.valueOf(false);
    }
  };
  private ThreadLocal<Boolean> d = new ThreadLocal()
  {
    protected Boolean a()
    {
      return Boolean.valueOf(false);
    }
  };
  private ThreadLocal<Boolean> e = new ThreadLocal()
  {
    protected Boolean a()
    {
      return Boolean.valueOf(false);
    }
  };
  
  public kc(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
  }
  
  private boolean b(jn paramjn)
  {
    boolean bool = false;
    if (paramjn == null) {
      return false;
    }
    if (!paramjn.n()) {
      return false;
    }
    if (!paramjn.p()) {
      return false;
    }
    if (!(paramjn instanceof jy)) {
      return false;
    }
    if (paramjn.i() != null) {
      return false;
    }
    if (paramjn.j() == null) {
      bool = true;
    }
    return bool;
  }
  
  private void c(jn paramjn)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1");
      if (paramjn.p())
      {
        e locale = new e(this.a);
        SecureRandom localSecureRandom = new SecureRandom();
        localSSLContext.init(null, new TrustManager[] { locale }, localSecureRandom);
        paramjn.a(new d(this.b, null));
        this.d.set(Boolean.valueOf(true));
      }
      else
      {
        localSSLContext.init(null, null, new SecureRandom());
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        paramjn.a(localSSLContext.getSocketFactory());
        this.e.set(Boolean.valueOf(true));
        return;
      }
      paramjn.a(new kc.a.a(localSSLContext.getSocketFactory()));
      this.e.set(Boolean.valueOf(true));
      return;
    }
    catch (Exception paramjn)
    {
      paramjn.printStackTrace();
    }
  }
  
  public void a(jn paramjn)
  {
    if (paramjn == null) {
      return;
    }
    if (b(paramjn))
    {
      if (!paramjn.c("https.protocols", "TLSv1"))
      {
        paramjn.b("https.protocols", "TLSv1");
        this.c.set(Boolean.valueOf(true));
      }
      c(paramjn);
    }
  }
  
  public void a(jn paramjn, jo paramjo)
  {
    super.a(paramjn, paramjo);
    if (((Boolean)this.c.get()).booleanValue())
    {
      this.c.set(Boolean.valueOf(false));
      paramjn.d("https.protocols", "TLSv1");
    }
    if (((Boolean)this.d.get()).booleanValue())
    {
      this.d.set(Boolean.valueOf(false));
      paramjn.g();
    }
    if (((Boolean)this.e.get()).booleanValue())
    {
      this.e.set(Boolean.valueOf(false));
      paramjn.h();
    }
  }
  
  static class a
  {
    public static class a
      extends SSLSocketFactory
    {
      private final SSLSocketFactory a;
      
      public a(SSLSocketFactory paramSSLSocketFactory)
      {
        this.a = paramSSLSocketFactory;
      }
      
      private static Socket a(Socket paramSocket)
      {
        Object localObject = paramSocket;
        if ((paramSocket instanceof SSLSocket))
        {
          localObject = paramSocket;
          if (!(paramSocket instanceof kc.a.b))
          {
            localObject = new kc.a.b((SSLSocket)paramSocket, null);
            paramSocket = (SSLSocket)localObject;
            String[] arrayOfString = paramSocket.getSupportedProtocols();
            if (arrayOfString != null)
            {
              int j = 0;
              int i = 0;
              for (;;)
              {
                k = i;
                if (j >= arrayOfString.length) {
                  break;
                }
                if ("TLSv1.2".equals(arrayOfString[j])) {
                  i = 1;
                }
                j += 1;
              }
            }
            int k = 0;
            if (k != 0) {
              paramSocket.setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
            }
          }
        }
        return localObject;
      }
      
      public Socket createSocket(String paramString, int paramInt)
        throws IOException
      {
        return a(this.a.createSocket(paramString, paramInt));
      }
      
      public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
        throws IOException
      {
        return a(this.a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
      }
      
      public Socket createSocket(InetAddress paramInetAddress, int paramInt)
        throws IOException
      {
        return a(this.a.createSocket(paramInetAddress, paramInt));
      }
      
      public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
        throws IOException
      {
        return a(this.a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
      }
      
      public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
        throws IOException
      {
        return a(this.a.createSocket(paramSocket, paramString, paramInt, paramBoolean));
      }
      
      public String[] getDefaultCipherSuites()
      {
        return this.a.getDefaultCipherSuites();
      }
      
      public String[] getSupportedCipherSuites()
      {
        return this.a.getSupportedCipherSuites();
      }
    }
    
    static class b
      extends kc.b
    {
      private b(SSLSocket paramSSLSocket)
      {
        super();
        if (!paramSSLSocket.getClass().getCanonicalName().equals("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl")) {
          try
          {
            Method localMethod = paramSSLSocket.getClass().getMethod("setUseSessionTickets", new Class[] { Boolean.TYPE });
            if (localMethod != null)
            {
              localMethod.invoke(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
              return;
            }
          }
          catch (IllegalAccessException paramSSLSocket)
          {
            paramSSLSocket.printStackTrace();
            return;
          }
          catch (InvocationTargetException paramSSLSocket)
          {
            paramSSLSocket.printStackTrace();
            return;
          }
          catch (NoSuchMethodException paramSSLSocket)
          {
            paramSSLSocket.printStackTrace();
          }
        }
      }
      
      public void setEnabledProtocols(String[] paramArrayOfString)
      {
        if (paramArrayOfString != null)
        {
          i = 0;
          while (i < paramArrayOfString.length) {
            i += 1;
          }
        }
        int i = 0;
        while (i < this.a.getSupportedProtocols().length) {
          i += 1;
        }
        String[] arrayOfString = paramArrayOfString;
        if (paramArrayOfString != null)
        {
          arrayOfString = paramArrayOfString;
          if (paramArrayOfString.length == 1)
          {
            arrayOfString = paramArrayOfString;
            if ("SSLv3".equals(paramArrayOfString[0]))
            {
              paramArrayOfString = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
              if (paramArrayOfString.size() > 1) {
                paramArrayOfString.remove("SSLv3");
              }
              arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
            }
          }
        }
        super.setEnabledProtocols(arrayOfString);
      }
    }
  }
  
  static class b
    extends SSLSocket
  {
    protected final SSLSocket a;
    
    b(SSLSocket paramSSLSocket)
    {
      this.a = paramSSLSocket;
    }
    
    public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.a.addHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public void bind(SocketAddress paramSocketAddress)
      throws IOException
    {
      this.a.bind(paramSocketAddress);
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.a.close();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void connect(SocketAddress paramSocketAddress)
      throws IOException
    {
      this.a.connect(paramSocketAddress);
    }
    
    public void connect(SocketAddress paramSocketAddress, int paramInt)
      throws IOException
    {
      this.a.connect(paramSocketAddress, paramInt);
    }
    
    public boolean equals(Object paramObject)
    {
      return this.a.equals(paramObject);
    }
    
    public SocketChannel getChannel()
    {
      return this.a.getChannel();
    }
    
    public boolean getEnableSessionCreation()
    {
      return this.a.getEnableSessionCreation();
    }
    
    public String[] getEnabledCipherSuites()
    {
      return this.a.getEnabledCipherSuites();
    }
    
    public String[] getEnabledProtocols()
    {
      return this.a.getEnabledProtocols();
    }
    
    public InetAddress getInetAddress()
    {
      return this.a.getInetAddress();
    }
    
    public InputStream getInputStream()
      throws IOException
    {
      return this.a.getInputStream();
    }
    
    public boolean getKeepAlive()
      throws SocketException
    {
      return this.a.getKeepAlive();
    }
    
    public InetAddress getLocalAddress()
    {
      return this.a.getLocalAddress();
    }
    
    public int getLocalPort()
    {
      return this.a.getLocalPort();
    }
    
    public SocketAddress getLocalSocketAddress()
    {
      return this.a.getLocalSocketAddress();
    }
    
    public boolean getNeedClientAuth()
    {
      return this.a.getNeedClientAuth();
    }
    
    public boolean getOOBInline()
      throws SocketException
    {
      return this.a.getOOBInline();
    }
    
    public OutputStream getOutputStream()
      throws IOException
    {
      return this.a.getOutputStream();
    }
    
    public int getPort()
    {
      return this.a.getPort();
    }
    
    public int getReceiveBufferSize()
      throws SocketException
    {
      try
      {
        int i = this.a.getReceiveBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public SocketAddress getRemoteSocketAddress()
    {
      return this.a.getRemoteSocketAddress();
    }
    
    public boolean getReuseAddress()
      throws SocketException
    {
      return this.a.getReuseAddress();
    }
    
    public int getSendBufferSize()
      throws SocketException
    {
      try
      {
        int i = this.a.getSendBufferSize();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public SSLSession getSession()
    {
      return this.a.getSession();
    }
    
    public int getSoLinger()
      throws SocketException
    {
      return this.a.getSoLinger();
    }
    
    public int getSoTimeout()
      throws SocketException
    {
      try
      {
        int i = this.a.getSoTimeout();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public String[] getSupportedCipherSuites()
    {
      return this.a.getSupportedCipherSuites();
    }
    
    public String[] getSupportedProtocols()
    {
      return this.a.getSupportedProtocols();
    }
    
    public boolean getTcpNoDelay()
      throws SocketException
    {
      return this.a.getTcpNoDelay();
    }
    
    public int getTrafficClass()
      throws SocketException
    {
      return this.a.getTrafficClass();
    }
    
    public boolean getUseClientMode()
    {
      return this.a.getUseClientMode();
    }
    
    public boolean getWantClientAuth()
    {
      return this.a.getWantClientAuth();
    }
    
    public boolean isBound()
    {
      return this.a.isBound();
    }
    
    public boolean isClosed()
    {
      return this.a.isClosed();
    }
    
    public boolean isConnected()
    {
      return this.a.isConnected();
    }
    
    public boolean isInputShutdown()
    {
      return this.a.isInputShutdown();
    }
    
    public boolean isOutputShutdown()
    {
      return this.a.isOutputShutdown();
    }
    
    public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
    {
      this.a.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
    }
    
    public void sendUrgentData(int paramInt)
      throws IOException
    {
      this.a.sendUrgentData(paramInt);
    }
    
    public void setEnableSessionCreation(boolean paramBoolean)
    {
      this.a.setEnableSessionCreation(paramBoolean);
    }
    
    public void setEnabledCipherSuites(String[] paramArrayOfString)
    {
      this.a.setEnabledCipherSuites(paramArrayOfString);
    }
    
    public void setEnabledProtocols(String[] paramArrayOfString)
    {
      this.a.setEnabledProtocols(paramArrayOfString);
    }
    
    public void setKeepAlive(boolean paramBoolean)
      throws SocketException
    {
      this.a.setKeepAlive(paramBoolean);
    }
    
    public void setNeedClientAuth(boolean paramBoolean)
    {
      this.a.setNeedClientAuth(paramBoolean);
    }
    
    public void setOOBInline(boolean paramBoolean)
      throws SocketException
    {
      this.a.setOOBInline(paramBoolean);
    }
    
    public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
    }
    
    public void setReceiveBufferSize(int paramInt)
      throws SocketException
    {
      try
      {
        this.a.setReceiveBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setReuseAddress(boolean paramBoolean)
      throws SocketException
    {
      this.a.setReuseAddress(paramBoolean);
    }
    
    public void setSSLParameters(SSLParameters paramSSLParameters)
    {
      this.a.setSSLParameters(paramSSLParameters);
    }
    
    public void setSendBufferSize(int paramInt)
      throws SocketException
    {
      try
      {
        this.a.setSendBufferSize(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setSoLinger(boolean paramBoolean, int paramInt)
      throws SocketException
    {
      this.a.setSoLinger(paramBoolean, paramInt);
    }
    
    public void setSoTimeout(int paramInt)
      throws SocketException
    {
      try
      {
        this.a.setSoTimeout(paramInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setTcpNoDelay(boolean paramBoolean)
      throws SocketException
    {
      this.a.setTcpNoDelay(paramBoolean);
    }
    
    public void setTrafficClass(int paramInt)
      throws SocketException
    {
      this.a.setTrafficClass(paramInt);
    }
    
    public void setUseClientMode(boolean paramBoolean)
    {
      this.a.setUseClientMode(paramBoolean);
    }
    
    public void setWantClientAuth(boolean paramBoolean)
    {
      this.a.setWantClientAuth(paramBoolean);
    }
    
    public void shutdownInput()
      throws IOException
    {
      this.a.shutdownInput();
    }
    
    public void shutdownOutput()
      throws IOException
    {
      this.a.shutdownOutput();
    }
    
    public void startHandshake()
      throws IOException
    {
      this.a.startHandshake();
    }
    
    public String toString()
    {
      return this.a.toString();
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(String paramString);
  }
  
  static class d
    implements HostnameVerifier
  {
    private final kc.c a;
    
    private d(kc.c paramc)
    {
      this.a = paramc;
    }
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      if (this.a == null) {
        return false;
      }
      return this.a.a(paramString);
    }
  }
  
  static class e
    implements X509TrustManager
  {
    private X509TrustManager a;
    
    e(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        Object localObject = CertificateFactory.getInstance("X.509");
        paramString = new ByteArrayInputStream(paramString.getBytes());
        localObject = (X509Certificate)((CertificateFactory)localObject).generateCertificate(paramString);
        paramString.close();
        localObject = new KeyStore.TrustedCertificateEntry((Certificate)localObject);
        paramString = KeyStore.getInstance(KeyStore.getDefaultType());
        paramString.load(null, null);
        paramString.setEntry("ca_root", (KeyStore.Entry)localObject, null);
        localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        ((TrustManagerFactory)localObject).init(paramString);
        paramString = ((TrustManagerFactory)localObject).getTrustManagers();
        int i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i] instanceof X509TrustManager))
          {
            this.a = ((X509TrustManager)paramString[i]);
            return;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.kc
 * JD-Core Version:    0.7.0.1
 */