package midas.x;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class kj
{
  public static String a(HashMap<String, String> paramHashMap)
  {
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
      }
      if (!TextUtils.isEmpty(localStringBuffer)) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
    catch (Exception paramHashMap)
    {
      label100:
      break label100;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if ((paramArrayOfByte[i] & 0xFF) < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean a(Handler paramHandler)
  {
    return Looper.myLooper() == paramHandler.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kj
 * JD-Core Version:    0.7.0.1
 */