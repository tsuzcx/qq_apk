package midas.x;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
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
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ub
  extends jb
{
  public final String a;
  public final e b;
  public ThreadLocal<Boolean> c = new a();
  public ThreadLocal<Boolean> d = new b();
  public ThreadLocal<Boolean> e = new c();
  
  public ub(String paramString, e parame)
  {
    this.a = paramString;
    this.b = parame;
  }
  
  public void a(fb paramfb)
  {
    if (paramfb == null) {
      return;
    }
    if (c(paramfb))
    {
      if (!paramfb.c("https.protocols", "TLSv1"))
      {
        paramfb.a("https.protocols", "TLSv1");
        this.c.set(Boolean.valueOf(true));
      }
      b(paramfb);
    }
  }
  
  public void a(fb paramfb, gb paramgb)
  {
    super.a(paramfb, paramgb);
    boolean bool = ((Boolean)this.c.get()).booleanValue();
    paramgb = Boolean.valueOf(false);
    if (bool)
    {
      this.c.set(paramgb);
      paramfb.d("https.protocols", "TLSv1");
    }
    if (((Boolean)this.d.get()).booleanValue())
    {
      this.d.set(paramgb);
      paramfb.a();
    }
    if (((Boolean)this.e.get()).booleanValue())
    {
      this.e.set(paramgb);
      paramfb.b();
    }
  }
  
  public final void b(fb paramfb)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1");
      if (paramfb.o())
      {
        g localg = new g(this.a);
        SecureRandom localSecureRandom = new SecureRandom();
        localSSLContext.init(null, new TrustManager[] { localg }, localSecureRandom);
        paramfb.a(new f(this.b, null));
        this.d.set(Boolean.valueOf(true));
      }
      else
      {
        localSSLContext.init(null, null, new SecureRandom());
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        paramfb.a(localSSLContext.getSocketFactory());
        this.e.set(Boolean.valueOf(true));
        return;
      }
      paramfb.a(new vb(localSSLContext.getSocketFactory()));
      this.e.set(Boolean.valueOf(true));
      return;
    }
    catch (Exception paramfb)
    {
      paramfb.printStackTrace();
    }
  }
  
  public final boolean c(fb paramfb)
  {
    boolean bool = false;
    if (paramfb == null) {
      return false;
    }
    if (!paramfb.m()) {
      return false;
    }
    if (!paramfb.o()) {
      return false;
    }
    if (!(paramfb instanceof qb)) {
      return false;
    }
    if (paramfb.d() != null) {
      return false;
    }
    if (paramfb.e() == null) {
      bool = true;
    }
    return bool;
  }
  
  public class a
    extends ThreadLocal<Boolean>
  {
    public a() {}
    
    public Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  }
  
  public class b
    extends ThreadLocal<Boolean>
  {
    public b() {}
    
    public Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  }
  
  public class c
    extends ThreadLocal<Boolean>
  {
    public c() {}
    
    public Boolean initialValue()
    {
      return Boolean.valueOf(false);
    }
  }
  
  public static class d
    extends SSLSocket
  {
    public final SSLSocket a;
    
    public d(SSLSocket paramSSLSocket)
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
  
  public static abstract interface e
  {
    public abstract boolean a(String paramString);
  }
  
  public static class f
    implements HostnameVerifier
  {
    public final ub.e a;
    
    public f(ub.e parame)
    {
      this.a = parame;
    }
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      paramSSLSession = this.a;
      if (paramSSLSession == null) {
        return false;
      }
      return paramSSLSession.a(paramString);
    }
  }
  
  public static class g
    implements X509TrustManager
  {
    public X509TrustManager a;
    
    public g(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ub
 * JD-Core Version:    0.7.0.1
 */