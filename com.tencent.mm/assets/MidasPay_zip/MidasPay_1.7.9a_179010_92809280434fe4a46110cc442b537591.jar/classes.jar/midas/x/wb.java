package midas.x;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public class wb
  extends ub.d
{
  public wb(SSLSocket paramSSLSocket)
  {
    super(paramSSLSocket);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.wb
 * JD-Core Version:    0.7.0.1
 */