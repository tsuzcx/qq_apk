package midas.x;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class vb
  extends SSLSocketFactory
{
  public final SSLSocketFactory a;
  
  public vb(SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramSSLSocketFactory;
  }
  
  public static Socket a(Socket paramSocket)
  {
    Object localObject = paramSocket;
    if ((paramSocket instanceof SSLSocket))
    {
      localObject = paramSocket;
      if (!(paramSocket instanceof wb))
      {
        localObject = new wb((SSLSocket)paramSocket, null);
        paramSocket = ((ub.d)localObject).getSupportedProtocols();
        if (paramSocket != null)
        {
          int j = 0;
          int i = 0;
          for (;;)
          {
            k = i;
            if (j >= paramSocket.length) {
              break;
            }
            if ("TLSv1.2".equals(paramSocket[j])) {
              i = 1;
            }
            j += 1;
          }
        }
        int k = 0;
        if (k != 0) {
          ((wb)localObject).setEnabledProtocols(new String[] { "TLSv1.1", "TLSv1.2" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.vb
 * JD-Core Version:    0.7.0.1
 */