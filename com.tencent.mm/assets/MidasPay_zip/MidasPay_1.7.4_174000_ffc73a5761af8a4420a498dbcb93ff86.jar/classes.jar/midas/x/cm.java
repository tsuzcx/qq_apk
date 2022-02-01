package midas.x;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class cm
  extends lh
{
  private static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("&");
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramString1.length)
    {
      String[] arrayOfString = paramString1[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      } else {
        localHashMap.put(arrayOfString[0], "");
      }
      i += 1;
    }
    return (String)localHashMap.get(paramString2);
  }
  
  public static void a(kz paramkz, String paramString)
  {
    if (paramkz == null) {
      try
      {
        APLog.e("GetKeyAns", "Cannot handle get key success with null response!");
        return;
      }
      finally
      {
        break label508;
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success with null decode key!");
      return;
    }
    Object localObject3 = paramkz.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Handle get key success : ");
    ((StringBuilder)localObject1).append((String)localObject3);
    APLog.d("GetKeyAns", ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      APLog.e("GetKeyAns", "Handle get key success, but data is empty!");
      return;
    }
    Object localObject2 = paramkz.a();
    if (localObject2 == null)
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get request from response!");
      return;
    }
    if (!(localObject2 instanceof bx))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Request not instance of right type!");
      return;
    }
    localObject1 = ((bx)localObject2).B();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get open id from request!");
      return;
    }
    localObject2 = ((bx)localObject2).C();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get offer id from request!");
      return;
    }
    Context localContext = a.a().d;
    try
    {
      localObject3 = new JSONObject((String)localObject3);
      if (!((JSONObject)localObject3).has("ret"))
      {
        APLog.e("GetKeyAns", "Get key success result no ret!");
        return;
      }
      if (Integer.parseInt(((JSONObject)localObject3).getString("ret")) != 0)
      {
        APLog.e("GetKeyAns", "Get key success result code not 0!");
        return;
      }
      String str2 = ((JSONObject)localObject3).getString("key_info");
      String str1 = ((JSONObject)localObject3).getString("key_info_len");
      paramString = gh.b(str2, paramString);
      paramString = paramString.substring(0, Math.min(paramString.length(), Integer.valueOf(str1).intValue()));
      if (d(paramkz))
      {
        paramkz = a(paramString, "key");
        str1 = a(paramString, "cryptkey");
        paramString = a(paramString, "cryptkeytime");
        by.a().b((String)localObject1, (String)localObject2, paramkz);
        by.a().a((String)localObject1, (String)localObject2, str1);
        by.a().c((String)localObject1, (String)localObject2, paramString);
        by.a().b(localContext, (String)localObject1, (String)localObject2, paramkz, "1.7.4");
        by.a().a(localContext, (String)localObject1, (String)localObject2, str1, "1.7.4");
        by.a().c(localContext, (String)localObject1, (String)localObject2, paramString, "1.7.4");
      }
      else if (e(paramkz))
      {
        paramkz = a(paramString, "key");
        paramString = a(paramString, "cryptkeytime");
        by.a().a((String)localObject1, (String)localObject2, paramkz);
        by.a().c((String)localObject1, (String)localObject2, paramString);
        by.a().a(localContext, (String)localObject1, (String)localObject2, paramkz, "1.7.4");
        by.a().c(localContext, (String)localObject1, (String)localObject2, paramString, "1.7.4");
      }
      a((JSONObject)localObject3);
    }
    catch (JSONException paramkz)
    {
      paramkz.printStackTrace();
      paramString = new StringBuilder();
      paramString.append("Handle get key success, but exception happen ");
      paramString.append(paramkz);
      APLog.e("GetKeyAns", paramString.toString());
    }
    return;
    label508:
    throw paramkz;
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("common_config")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("comm_config");
        Object localObject1 = paramJSONObject.optString("log_write", "-1");
        Object localObject3 = paramJSONObject.optString("log_keep_size", "1");
        String str = paramJSONObject.optString("log_keep_time", "10");
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("catch log keep config: ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(" ");
          localStringBuilder.append(str);
          APLog.d("BaseBuyPageAns", localStringBuilder.toString());
          if (!((String)localObject1).equals("-1")) {
            APLog.getLogInfo().setLogParamFromServer((String)localObject1);
          }
          int i = i.a((String)localObject3);
          int j = i.a(str);
          localObject1 = new fz();
          ((fz)localObject1).a(a.a().d, "TencentUnipay", "log_keep_size", String.valueOf(i));
          ((fz)localObject1).a(a.a().d, "TencentUnipay", "log_keep_time", String.valueOf(j));
        }
        catch (Throwable localThrowable)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("configure log error: ");
          ((StringBuilder)localObject3).append(localThrowable.getMessage());
          APLog.e("common_config", ((StringBuilder)localObject3).toString());
        }
        localObject3 = paramJSONObject.optString("log_date", "");
        str = paramJSONObject.optString("log_upload", "0");
        Object localObject2 = paramJSONObject.optString("log_file", "");
        jj.a = i.a(paramJSONObject.optString("log_upload_max", "3"));
        paramJSONObject = (JSONObject)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(Environment.getExternalStorageDirectory().getPath());
          paramJSONObject.append("/");
          paramJSONObject.append((String)localObject2);
          paramJSONObject = paramJSONObject.toString();
        }
        try
        {
          if ("1".equals(str))
          {
            APLog.d("BaseBuyPageAns", String.format("catch upload log command, ready to upload: %s %s", new Object[] { localObject3, paramJSONObject }));
            jj.a(em.b().n().a.openId, (String)localObject3, paramJSONObject);
            return;
          }
        }
        catch (Throwable paramJSONObject)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("upload log execute failed: ");
          ((StringBuilder)localObject2).append(paramJSONObject.getMessage());
          APLog.e("common_config", ((StringBuilder)localObject2).toString());
          return;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  private static boolean d(kz paramkz)
  {
    if (paramkz == null) {
      return false;
    }
    paramkz = paramkz.a();
    if (paramkz == null) {
      return false;
    }
    if (!(paramkz instanceof cn)) {
      return false;
    }
    return ((cn)paramkz).c();
  }
  
  private static boolean e(kz paramkz)
  {
    if (paramkz == null) {
      return false;
    }
    paramkz = paramkz.a();
    if (paramkz == null) {
      return false;
    }
    if (!(paramkz instanceof cn)) {
      return false;
    }
    return ((cn)paramkz).d();
  }
  
  protected boolean a(kz paramkz)
  {
    a(paramkz, X());
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cm
 * JD-Core Version:    0.7.0.1
 */