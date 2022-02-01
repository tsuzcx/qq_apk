package com.pay.tool;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

public class APMidasTools
{
  static long lastClickTime = 0L;
  
  public static String getCurrentThreadName(Thread paramThread)
  {
    AppMethodBeat.i(207602);
    paramThread = paramThread.getName();
    AppMethodBeat.o(207602);
    return paramThread;
  }
  
  public static int getErrorCodeFromException(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramIOException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramIOException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramIOException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramIOException instanceof EOFException)) {
      return -26;
    }
    if ((paramIOException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramIOException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramIOException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramIOException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramIOException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramIOException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramIOException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramIOException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramIOException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramIOException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramIOException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramIOException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramIOException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramIOException instanceof SSLHandshakeException)) {
      return -41;
    }
    if ((paramIOException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramIOException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramIOException instanceof BindException)) {
      return -45;
    }
    if ((paramIOException instanceof ConnectException)) {
      return -46;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramIOException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramIOException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramIOException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramIOException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramIOException instanceof ZipException)) {
      return -54;
    }
    return -2;
  }
  
  public static String getSysServerDomain()
  {
    AppMethodBeat.i(207590);
    String str = APMidasPayAPI.env;
    if (str.equals("dev"))
    {
      AppMethodBeat.o(207590);
      return "dev.api.unipay.qq.com";
    }
    if (str.equals("test"))
    {
      AppMethodBeat.o(207590);
      return "sandbox.api.unipay.qq.com";
    }
    AppMethodBeat.o(207590);
    return "api.unipay.qq.com";
  }
  
  public static long getTimeInterval(long paramLong1, long paramLong2)
  {
    return paramLong2 - paramLong1;
  }
  
  public static String getUUID()
  {
    AppMethodBeat.i(207596);
    Object localObject = "";
    try
    {
      String str = UUID.randomUUID().toString();
      localObject = str;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    AppMethodBeat.o(207596);
    return localObject;
  }
  
  public static String getUrlParamsValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207581);
    paramString1 = paramString1.split("[?]");
    int i;
    Object localObject;
    if ((paramString1.length > 1) && (paramString1[1] != null))
    {
      String[] arrayOfString = paramString1[1].split("[&]");
      int j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label129;
      }
      localObject = arrayOfString[i].split("[=]");
      if ((localObject.length <= 1) || (localObject[0] == null)) {
        break label142;
      }
    }
    label129:
    label142:
    for (paramString1 = localObject[0];; paramString1 = null)
    {
      if ((localObject.length > 1) && (localObject[1] != null)) {}
      for (localObject = localObject[1];; localObject = null)
      {
        if ((paramString1 != null) && (paramString1.compareToIgnoreCase(paramString2) == 0))
        {
          AppMethodBeat.o(207581);
          return localObject;
          AppMethodBeat.o(207581);
          return null;
        }
        i += 1;
        break;
        AppMethodBeat.o(207581);
        return null;
      }
    }
  }
  
  public static boolean isFastClick()
  {
    AppMethodBeat.i(207564);
    long l = System.currentTimeMillis();
    if (l - lastClickTime < 3000L)
    {
      AppMethodBeat.o(207564);
      return true;
    }
    lastClickTime = l;
    AppMethodBeat.o(207564);
    return false;
  }
  
  public static String map2UrlParams(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(207586);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)localEntry.getValue());
        localStringBuffer.append("&");
        continue;
        paramHashMap = localStringBuffer.toString();
      }
    }
    catch (Exception paramHashMap) {}
    for (;;)
    {
      AppMethodBeat.o(207586);
      return paramHashMap;
      if (!TextUtils.isEmpty(localStringBuffer)) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
  }
  
  public static String urlDecode(String paramString, int paramInt)
  {
    AppMethodBeat.i(207575);
    String str2 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(207575);
        return paramString;
      }
      int i = 0;
      String str1 = paramString;
      paramString = str2;
      for (;;)
      {
        str2 = paramString;
        if (i >= paramInt) {
          break label88;
        }
        try
        {
          str1 = URLDecoder.decode(str1, "utf-8");
          paramString = str1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            APLog.i("urlEncode", localException.toString());
          }
        }
        i += 1;
        str1 = paramString;
        str2 = paramString;
        paramString = str1;
        str1 = str2;
      }
    }
    APLog.w("", "解码内容为空");
    label88:
    AppMethodBeat.o(207575);
    return str2;
  }
  
  public static String urlEncode(String paramString, int paramInt)
  {
    AppMethodBeat.i(207569);
    String str2 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0)
      {
        AppMethodBeat.o(207569);
        return paramString;
      }
      int i = 0;
      String str1 = paramString;
      paramString = str2;
      for (;;)
      {
        str2 = paramString;
        if (i >= paramInt) {
          break label89;
        }
        try
        {
          str1 = URLEncoder.encode(str1, "utf-8");
          paramString = str1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            APLog.i("urlEncode", localException.toString());
          }
        }
        i += 1;
        str1 = paramString;
        str2 = paramString;
        paramString = str1;
        str1 = str2;
      }
    }
    APLog.i("urlEncode", "编码内容为空");
    label89:
    AppMethodBeat.o(207569);
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.pay.tool.APMidasTools
 * JD-Core Version:    0.7.0.1
 */