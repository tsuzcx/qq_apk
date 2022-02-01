package com.tencent.component.network.module.common.a;

import com.tencent.component.network.module.base.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class e
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      paramString = str.toLowerCase();
      int i;
      if (paramString.startsWith("http://"))
      {
        i = str.indexOf("/", 8);
        if (i > 7) {
          return str.substring(7, i);
        }
        return str.substring(7);
      }
      if (paramString.startsWith("https://"))
      {
        i = str.indexOf("/", 9);
        if (i > 8) {
          return str.substring(8, i);
        }
        return str.substring(8);
      }
      paramString = str;
    } while (str.indexOf("/", 1) <= 1);
    return str.substring(0, str.indexOf("/", 1));
  }
  
  public static InetAddress[] a(String paramString, long paramLong)
  {
    paramString = a(paramString);
    if (b.b()) {
      b.b("DnsMain", "hostName:" + paramString + ",timeout:" + paramLong + "get better host for name:" + paramString);
    }
    if ((paramString == null) || (paramString.trim().length() <= 0)) {}
    do
    {
      return null;
      paramString = paramString.trim();
      if (0 == 0) {
        break;
      }
    } while (!b.b());
    b.b("DnsMain", "get ip from cache: " + paramString + " --- " + null);
    return null;
    try
    {
      InetAddress[] arrayOfInetAddress = new g("114.114.114.114").a(paramString, paramLong);
      if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        if (b.b()) {
          b.b("DnsMain", "get ip from Lookup: " + paramString + " --- " + arrayOfInetAddress);
        }
      }
      else
      {
        b.d("DnsMain", "114 - Address == null ? WTF ?!");
        return null;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      b.d("DnsMain", "UnknownHostException cause[" + paramString + "][114.114.114.114]." + localUnknownHostException.getMessage());
      return null;
    }
    catch (k localk)
    {
      b.d("DnsMain", "WireParseException cause[" + paramString + "][114.114.114.114]." + localk.getMessage());
      return null;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      b.d("DnsMain", "SocketTimeoutException cause[" + paramString + "][114.114.114.114]." + localSocketTimeoutException.getMessage());
      return null;
    }
    catch (IOException localIOException)
    {
      b.d("DnsMain", "IOException cause[" + paramString + "][114.114.114.114]." + localIOException.getMessage());
      return null;
    }
    catch (Exception localException)
    {
      b.d("DnsMain", "Exception cause[" + paramString + "][114.114.114.114]." + localException.getMessage());
      return null;
    }
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.e
 * JD-Core Version:    0.7.0.1
 */