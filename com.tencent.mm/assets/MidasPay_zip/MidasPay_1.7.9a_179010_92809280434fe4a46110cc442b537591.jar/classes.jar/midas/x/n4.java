package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n4
{
  public static int a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((!APAppDataInterface.singleton().h().equals("release")) && (!APAppDataInterface.singleton().F())) {
      try
      {
        int i = paramJSONObject.getInt(paramString1);
        return i;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return 0;
      }
    }
    paramJSONObject = c(paramJSONObject, paramString1, paramString2);
    if (paramJSONObject == null) {
      return 0;
    }
    if ((paramJSONObject instanceof Integer)) {
      return ((Integer)paramJSONObject).intValue();
    }
    if ((paramJSONObject instanceof Number)) {
      return ((Number)paramJSONObject).intValue();
    }
    if ((paramJSONObject instanceof String)) {}
    try
    {
      double d = Double.parseDouble((String)paramJSONObject);
      return (int)d;
    }
    catch (NumberFormatException paramJSONObject) {}
    return 0;
    return 0;
  }
  
  public static String a(String paramString, int paramInt)
    throws UnsupportedEncodingException
  {
    return a(paramString, paramInt, "UTF-8");
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
    throws UnsupportedEncodingException
  {
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (paramInt > 0)
      {
        int i = paramInt;
        if (paramInt > paramString1.getBytes(paramString2).length) {
          i = paramString1.getBytes(paramString2).length;
        }
        byte[] arrayOfByte1 = new byte[i];
        int j = 0;
        paramInt = 0;
        while (j < paramString1.length())
        {
          byte[] arrayOfByte2 = String.valueOf(paramString1.charAt(j)).getBytes(paramString2);
          if (arrayOfByte2.length > i - paramInt) {
            break;
          }
          int k = 0;
          while (k < arrayOfByte2.length)
          {
            arrayOfByte1[paramInt] = arrayOfByte2[k];
            paramInt += 1;
            k += 1;
          }
          j += 1;
        }
        return new String(arrayOfByte1, 0, paramInt, paramString2);
      }
      throw new ArrayIndexOutOfBoundsException("StringUtils: truncate(String s, int n), 参数n不能为负数!");
    }
    paramString1 = new NullPointerException("StringUtils: truncate(String s, int n), 参数s不能为空！");
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if ((!APAppDataInterface.singleton().h().equals("release")) && (!APAppDataInterface.singleton().F())) {
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("content:");
      ((StringBuilder)localObject).append(paramString1);
      APLog.i("APBaseHttpAns", ((StringBuilder)localObject).toString());
      int i = paramString1.indexOf("_");
      if (i == -1) {
        return null;
      }
      localObject = paramString1.substring(0, i);
      i = Integer.parseInt(paramString1.substring(i + 1, paramString1.length()));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (i <= 0) {
          return null;
        }
        paramString1 = a(l6.a((String)localObject, paramString2), i);
        return paramString1;
      }
      return null;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static JSONArray b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((!APAppDataInterface.singleton().h().equals("release")) && (!APAppDataInterface.singleton().F())) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString1);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localJSONArray;
      }
    }
    if (!paramJSONObject.has(paramString1)) {
      return localJSONArray;
    }
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString1);
      int i = paramJSONObject.indexOf("_");
      if (i == -1) {
        return localJSONArray;
      }
      paramString1 = paramJSONObject.substring(0, i);
      i = Integer.parseInt(paramJSONObject.substring(i + 1, paramJSONObject.length()));
      p4.p().d();
      p4.p().c();
      paramJSONObject = new JSONArray(a(l6.a(paramString1, paramString2), i));
      return paramJSONObject;
    }
    catch (UnsupportedEncodingException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localJSONArray;
    }
    catch (NumberFormatException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localJSONArray;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localJSONArray;
  }
  
  public static Object c(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.has("user_msg")) {
      return null;
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("user_msg");
      int i = paramJSONObject.indexOf("_");
      if (i == -1) {
        return null;
      }
      String str = paramJSONObject.substring(0, i);
      i = Integer.parseInt(paramJSONObject.substring(i + 1, paramJSONObject.length()));
      paramJSONObject = new JSONObject(a(l6.a(str, paramString2), i)).get(paramString1);
      return paramJSONObject;
    }
    catch (UnsupportedEncodingException paramJSONObject) {}catch (JSONException paramJSONObject)
    {
      break label93;
    }
    paramJSONObject.printStackTrace();
    return null;
    label93:
    paramJSONObject.printStackTrace();
    return null;
  }
  
  public static String d(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((!APAppDataInterface.singleton().h().equals("release")) && (!APAppDataInterface.singleton().F())) {
      try
      {
        paramJSONObject = paramJSONObject.getString(paramString1);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return "";
      }
    }
    paramJSONObject = c(paramJSONObject, paramString1, paramString2);
    if ((paramJSONObject instanceof String)) {
      return (String)paramJSONObject;
    }
    if (paramJSONObject != null) {
      return String.valueOf(paramJSONObject);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n4
 * JD-Core Version:    0.7.0.1
 */