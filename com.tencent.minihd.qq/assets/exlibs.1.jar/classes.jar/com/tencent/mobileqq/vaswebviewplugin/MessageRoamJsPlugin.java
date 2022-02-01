package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRoamJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String ACTION = "action";
  public static final int COMMON = 1;
  public static final String DATA = "data";
  public static final String ERROEMESSAGE = "errorMessage";
  public static final String ISSETPASSWORD = "isSetPassword";
  public static final int ISSETPASSWORD_NO = 0;
  public static final int ISSETPASSWORD_YES = 1;
  public static final int NOT_VERIFY_PASSWORD = 3000;
  public static final int OTHER = -1;
  public static final String PKGNAME = "msgRoam";
  public static final String RESULT = "result";
  public static final int RESULT_CODE = 2000;
  public static final int SVIP = 3;
  private static final String TAG = MessageRoamJsPlugin.class.getSimpleName();
  public static final String TYPE = "type";
  public static final String USERTYPE = "userType";
  public static final int VIP = 2;
  public static final int YEAR_SVIP = 5;
  public static final int YEAR_VIP = 4;
  public static final String listenPswEventUrl = "https://clientui.3g.qq.com/mqqapi/im/roam";
  public static final String setPasswordUrl = "https://mapp.3g.qq.com/touch/psw/verify.jsp";
  Activity browserActivity = null;
  BrowserAppInterface browserAppInterface = null;
  Context context = null;
  public String listenCallback = null;
  
  private boolean handleAddListenPswEvent(String paramString)
  {
    this.listenCallback = paramString;
    return true;
  }
  
  private boolean handleGetRoam(String paramString)
  {
    sendRemoteReq(DataFactory.makeIPCRequestPacket("getRoam", paramString, this.mOnRemoteResp.key, new Bundle()), false, false);
    return true;
  }
  
  private boolean handleRemoveListenPswEvent(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("result", "0");
        localJSONObject.put("errorMessage", "success");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return true;
      }
      catch (JSONException localJSONException1) {}
      try
      {
        localJSONObject.put("result", "-1");
        localJSONObject.put("errorMessage", "handleRemoveListenPswEvent , JSONException,encode json is error");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  private boolean handleSetRoam(int paramInt, String paramString)
  {
    int i = -1;
    String str = "success";
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4))
    {
      localObject = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
      if (localObject != null)
      {
        ((SharedPreferences)localObject).edit().putInt("message_roam_flag" + this.browserAppInterface.a(), paramInt).commit();
        paramInt = 0;
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramInt);
      ((JSONObject)localObject).put("errorMessage", str);
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return true;
      log("SharedPreferences is null");
      str = "SharedPreferences is null";
      paramInt = i;
      continue;
      log("messageRoamType is error , = " + paramInt);
      str = "messageRoamType is error";
      paramInt = i;
    }
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(TAG, 2, paramString);
    }
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    if (paramInt == 9)
    {
      if (((Integer)paramMap.get("resultCode")).intValue() == 2000)
      {
        paramString = (Intent)paramMap.get("data");
        if (paramString != null)
        {
          paramString = paramString.getCharSequenceExtra("result").toString();
          log("listenCallback = " + this.listenCallback + "result = " + paramString);
          callJs(this.listenCallback, new String[] { paramString.trim() });
          return true;
        }
      }
    }
    else if ((paramInt == 12) && ((paramString.startsWith("https://mapp.3g.qq.com/touch/psw/verify.jsp?type=history&sid=")) || (paramString.startsWith("https://mapp.3g.qq.com/touch/psw/create.jsp?sid="))))
    {
      this.browserActivity.setResult(3000);
      this.browserActivity.finish();
      return true;
    }
    return false;
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +12 -> 13
    //   4: aload_3
    //   5: ldc 30
    //   7: invokevirtual 263	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10: ifne +29 -> 39
    //   13: aload_0
    //   14: new 160	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 265
    //   24: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 192	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:log	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: new 117	org/json/JSONObject
    //   42: dup
    //   43: aload 5
    //   45: iconst_0
    //   46: aaload
    //   47: invokespecial 267	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull -15 -> 37
    //   55: aload_1
    //   56: ldc_w 269
    //   59: invokevirtual 273	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_2
    //   63: aload_0
    //   64: new 160	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 275
    //   74: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 277
    //   85: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 279
    //   95: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 131	org/json/JSONObject:toString	()Ljava/lang/String;
    //   102: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokespecial 192	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:log	(Ljava/lang/String;)V
    //   111: aload 4
    //   113: ldc_w 281
    //   116: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: ifeq +53 -> 172
    //   122: aload_0
    //   123: aload_1
    //   124: ldc 41
    //   126: invokevirtual 289	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: aload_2
    //   130: invokespecial 291	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:handleSetRoam	(ILjava/lang/String;)Z
    //   133: istore 6
    //   135: iload 6
    //   137: ireturn
    //   138: astore_1
    //   139: aload_0
    //   140: new 160	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 293
    //   150: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aconst_null
    //   154: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokespecial 192	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:log	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 142	org/json/JSONException:printStackTrace	()V
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -118 -> 51
    //   172: aload 4
    //   174: ldc 90
    //   176: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: aload_2
    //   184: invokespecial 298	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:handleGetRoam	(Ljava/lang/String;)Z
    //   187: pop
    //   188: goto +130 -> 318
    //   191: aload 4
    //   193: ldc_w 300
    //   196: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +93 -> 292
    //   202: aload_0
    //   203: aload_2
    //   204: invokespecial 302	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:handleAddListenPswEvent	(Ljava/lang/String;)Z
    //   207: pop
    //   208: goto +110 -> 318
    //   211: astore_1
    //   212: aload_0
    //   213: new 160	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 304
    //   223: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 305	java/lang/Exception:toString	()Ljava/lang/String;
    //   230: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 192	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:log	(Ljava/lang/String;)V
    //   239: new 117	org/json/JSONObject
    //   242: dup
    //   243: invokespecial 118	org/json/JSONObject:<init>	()V
    //   246: astore_1
    //   247: aload_1
    //   248: ldc 33
    //   250: iconst_m1
    //   251: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   254: pop
    //   255: aload_1
    //   256: ldc 17
    //   258: ldc_w 307
    //   261: invokevirtual 124	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_0
    //   266: aload_2
    //   267: iconst_1
    //   268: anewarray 128	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload_1
    //   274: invokevirtual 131	org/json/JSONObject:toString	()Ljava/lang/String;
    //   277: aastore
    //   278: invokevirtual 135	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   281: goto +37 -> 318
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 308	java/lang/Exception:printStackTrace	()V
    //   289: goto +29 -> 318
    //   292: aload 4
    //   294: ldc_w 310
    //   297: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq -263 -> 37
    //   303: aload_0
    //   304: aload_2
    //   305: invokespecial 312	com/tencent/mobileqq/vaswebviewplugin/MessageRoamJsPlugin:handleRemoveListenPswEvent	(Ljava/lang/String;)Z
    //   308: pop
    //   309: goto +9 -> 318
    //   312: astore_1
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -103 -> 212
    //   318: iconst_1
    //   319: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	MessageRoamJsPlugin
    //   0	320	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	320	2	paramString1	String
    //   0	320	3	paramString2	String
    //   0	320	4	paramString3	String
    //   0	320	5	paramVarArgs	String[]
    //   133	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	51	138	org/json/JSONException
    //   63	135	211	java/lang/Exception
    //   172	188	211	java/lang/Exception
    //   191	208	211	java/lang/Exception
    //   292	309	211	java/lang/Exception
    //   239	281	284	java/lang/Exception
    //   55	63	312	java/lang/Exception
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    paramString2 = null;
    if (!paramString1.startsWith("https://clientui.3g.qq.com/mqqapi/im/roam")) {}
    Object localObject1;
    do
    {
      return false;
      try
      {
        Object localObject3 = Uri.parse(paramString1);
        localObject2 = ((Uri)localObject3).getQueryParameter("src_type");
        localObject1 = ((Uri)localObject3).getQueryParameter("version");
        paramString1 = ((Uri)localObject3).getQueryParameter("action");
        localObject3 = ((Uri)localObject3).getQueryParameter("pwd");
        paramString2 = (String)localObject3;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject2).put("action", paramString1);
            ((JSONObject)localObject1).putOpt("data", localObject2);
            ((JSONObject)localObject1).put("result", i);
            ((JSONObject)localObject1).put("errorMessage", paramString2);
            paramString1 = new Intent();
            paramString1.putExtra("result", ((JSONObject)localObject1).toString());
            this.browserActivity.setResult(2000, paramString1);
            this.browserActivity.finish();
            return true;
          }
          catch (JSONException paramString1) {}
          paramString1 = paramString1;
          paramString1.printStackTrace();
          paramString1 = null;
          localObject1 = null;
          Object localObject2 = null;
          continue;
          int i = -1;
          paramString2 = "action is not open,reset,close";
          log("action is not open,reset,close");
        }
      }
      log("srcType = " + (String)localObject2 + " , version = " + (String)localObject1 + " , action = " + paramString1);
    } while ((localObject2 == null) || (localObject1 == null) || (paramString1 == null));
    if ((paramString1.equals("open")) || (paramString1.equals("reset")) || (paramString1.equals("close")) || (paramString1.equals("history")))
    {
      notifyGetMsgRoam(paramString2);
      paramString2 = "success";
      i = 0;
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject1).put("result", "-1");
      ((JSONObject)localObject1).put("errorMessage", "JSONException,encode json is error");
      paramString1.printStackTrace();
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void notifyGetMsgRoam(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pwd", paramString);
    sendRemoteReq(DataFactory.makeIPCRequestPacket("notifyGetMsgRoam", "notifyGetMsgRoam", this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.browserAppInterface = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.browserActivity = this.mRuntime.a();
    this.context = this.mRuntime.a().getApplicationContext();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.context = null;
    this.browserActivity = null;
    this.browserAppInterface = null;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
        {
          Object localObject = paramBundle.getString("cmd");
          String str = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          log("onResponse,callback=" + str + ",cmd=" + (String)localObject + ",respbundle=" + paramBundle);
          if ((localObject != null) && ("getRoam".equals(localObject)))
          {
            localObject = new JSONObject();
            JSONObject localJSONObject = new JSONObject();
            if (paramBundle == null)
            {
              ((JSONObject)localObject).put("result", -1);
              ((JSONObject)localObject).put("errorMessage", "invalid data, response data is null");
            }
            for (;;)
            {
              callJs(str, new String[] { ((JSONObject)localObject).toString() });
              return;
              localJSONObject.put("type", paramBundle.getInt("type"));
              localJSONObject.put("userType", paramBundle.getInt("userType"));
              localJSONObject.put("isSetPassword", paramBundle.getInt("isSetPassword"));
              ((JSONObject)localObject).putOpt("data", localJSONObject);
              ((JSONObject)localObject).put("result", paramBundle.getInt("result"));
              ((JSONObject)localObject).put("errorMessage", paramBundle.getString("errorMessage"));
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin
 * JD-Core Version:    0.7.0.1
 */