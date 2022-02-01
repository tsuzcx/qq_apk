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

public class n2
  extends ob
{
  public static String a(String paramString1, String paramString2)
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
  
  public static void a(gb paramgb, String paramString)
  {
    if (paramgb == null) {}
    try
    {
      APLog.e("GetKeyAns", "Cannot handle get key success with null response!");
      return;
    }
    finally {}
    if (TextUtils.isEmpty(paramString))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success with null decode key!");
      return;
    }
    Object localObject3 = paramgb.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Handle get key success : ");
    ((StringBuilder)localObject1).append((String)localObject3);
    APLog.d("GetKeyAns", ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      APLog.e("GetKeyAns", "Handle get key success, but data is empty!");
      return;
    }
    Object localObject2 = paramgb.g();
    if (localObject2 == null)
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get request from response!");
      return;
    }
    if (!(localObject2 instanceof y1))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Request not instance of right type!");
      return;
    }
    localObject1 = ((y1)localObject2).x();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get open id from request!");
      return;
    }
    localObject2 = ((y1)localObject2).w();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      APLog.e("GetKeyAns", "Cannot handle get key success! Cannot get offer id from request!");
      return;
    }
    Context localContext = a.r().d;
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
      paramString = l6.a(str2, paramString);
      paramString = paramString.substring(0, Math.min(paramString.length(), Integer.valueOf(str1).intValue()));
      if (f(paramgb))
      {
        paramgb = a(paramString, "key");
        str1 = a(paramString, "cryptkey");
        paramString = a(paramString, "cryptkeytime");
        z1.d().c((String)localObject1, (String)localObject2, paramgb);
        z1.d().a((String)localObject1, (String)localObject2, str1);
        z1.d().b((String)localObject1, (String)localObject2, paramString);
        z1.d().c(localContext, (String)localObject1, (String)localObject2, paramgb, "1.7.9a");
        z1.d().a(localContext, (String)localObject1, (String)localObject2, str1, "1.7.9a");
        z1.d().b(localContext, (String)localObject1, (String)localObject2, paramString, "1.7.9a");
      }
      else if (e(paramgb))
      {
        paramgb = a(paramString, "key");
        paramString = a(paramString, "cryptkeytime");
        z1.d().a((String)localObject1, (String)localObject2, paramgb);
        z1.d().b((String)localObject1, (String)localObject2, paramString);
        z1.d().a(localContext, (String)localObject1, (String)localObject2, paramgb, "1.7.9a");
        z1.d().b(localContext, (String)localObject1, (String)localObject2, paramString, "1.7.9a");
      }
      a((JSONObject)localObject3);
    }
    catch (JSONException paramgb)
    {
      paramgb.printStackTrace();
      paramString = new StringBuilder();
      paramString.append("Handle get key success, but exception happen ");
      paramString.append(paramgb);
      APLog.e("GetKeyAns", paramString.toString());
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("common_config")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("comm_config");
        Object localObject1 = paramJSONObject.optString("log_write", "-1");
        Object localObject4 = paramJSONObject.optString("log_keep_size", "1");
        String str = paramJSONObject.optString("log_keep_time", "10");
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("catch log keep config: ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(" ");
          localStringBuilder.append(str);
          APLog.d("BaseBuyPageAns", localStringBuilder.toString());
          if (!((String)localObject1).equals("-1")) {
            APLog.getLogInfo().setLogParamFromServer((String)localObject1);
          }
          int i = i.b((String)localObject4);
          int j = i.b(str);
          localObject1 = new d6();
          ((d6)localObject1).a(a.r().d, "TencentUnipay", "log_keep_size", String.valueOf(i));
          ((d6)localObject1).a(a.r().d, "TencentUnipay", "log_keep_time", String.valueOf(j));
        }
        finally
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("configure log error: ");
          ((StringBuilder)localObject4).append(localObject2.getMessage());
          APLog.e("common_config", ((StringBuilder)localObject4).toString());
        }
        localObject4 = paramJSONObject.optString("log_date", "");
        str = paramJSONObject.optString("log_upload", "0");
        Object localObject3 = paramJSONObject.optString("log_file", "");
        p9.a = i.b(paramJSONObject.optString("log_upload_max", "3"));
        paramJSONObject = (JSONObject)localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(Environment.getExternalStorageDirectory().getPath());
          paramJSONObject.append("/");
          paramJSONObject.append((String)localObject3);
          paramJSONObject = paramJSONObject.toString();
        }
        try
        {
          if ("1".equals(str))
          {
            APLog.d("BaseBuyPageAns", String.format("catch upload log command, ready to upload: %s %s", new Object[] { localObject4, paramJSONObject }));
            p9.a(p4.p().e().b.openId, (String)localObject4, paramJSONObject);
            return;
          }
        }
        finally
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("upload log execute failed: ");
          ((StringBuilder)localObject3).append(paramJSONObject.getMessage());
          APLog.e("common_config", ((StringBuilder)localObject3).toString());
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
  
  public static boolean e(gb paramgb)
  {
    if (paramgb == null) {
      return false;
    }
    paramgb = paramgb.g();
    if (paramgb == null) {
      return false;
    }
    if (!(paramgb instanceof o2)) {
      return false;
    }
    return ((o2)paramgb).I();
  }
  
  public static boolean f(gb paramgb)
  {
    if (paramgb == null) {
      return false;
    }
    paramgb = paramgb.g();
    if (paramgb == null) {
      return false;
    }
    if (!(paramgb instanceof o2)) {
      return false;
    }
    return ((o2)paramgb).J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.n2
 * JD-Core Version:    0.7.0.1
 */