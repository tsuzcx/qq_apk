package com.tencent.device.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import java.net.URLDecoder;
import java.util.HashMap;

public class QQConnectPlugin
  extends WebViewPlugin
{
  private static final String a = "QQConnect";
  private static final String b = "goShare";
  private static final String c = "doReport";
  private static final String d = "goBind";
  
  private HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localHashMap;
      paramString = URLDecoder.decode(paramString).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length > 1) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_3
    //   3: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: ldc 11
    //   13: aload 4
    //   15: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +127 -> 145
    //   21: aload_0
    //   22: getfield 65	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   25: ldc 67
    //   27: invokestatic 72	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 74	org/json/JSONObject
    //   33: dup
    //   34: aload 5
    //   36: iconst_0
    //   37: aaload
    //   38: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc 79
    //   45: invokevirtual 82	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_0
    //   50: aload_2
    //   51: ldc 84
    //   53: invokevirtual 82	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 86	com/tencent/device/utils/QQConnectPlugin:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   59: ldc 88
    //   61: invokevirtual 92	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 42	java/lang/String
    //   67: astore_2
    //   68: new 94	android/content/Intent
    //   71: dup
    //   72: aload_0
    //   73: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   76: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   79: ldc 105
    //   81: invokespecial 108	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   84: astore_3
    //   85: aload_3
    //   86: ldc 110
    //   88: aload_1
    //   89: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   92: pop
    //   93: aload_3
    //   94: ldc 88
    //   96: aload_2
    //   97: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   100: pop
    //   101: aload_0
    //   102: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   105: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   108: aload_3
    //   109: invokevirtual 120	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   112: aload_0
    //   113: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   116: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   119: invokevirtual 123	android/app/Activity:finish	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: invokestatic 128	com/tencent/open/base/ToastUtil:a	()Lcom/tencent/open/base/ToastUtil;
    //   128: aload_0
    //   129: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   132: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   135: ldc 129
    //   137: invokevirtual 132	android/app/Activity:getString	(I)Ljava/lang/String;
    //   140: invokevirtual 134	com/tencent/open/base/ToastUtil:a	(Ljava/lang/String;)V
    //   143: iconst_1
    //   144: ireturn
    //   145: ldc 14
    //   147: aload 4
    //   149: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +54 -> 206
    //   155: aload_0
    //   156: getfield 65	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   159: ldc 14
    //   161: invokestatic 72	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: new 74	org/json/JSONObject
    //   167: dup
    //   168: aload 5
    //   170: iconst_0
    //   171: aaload
    //   172: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore_1
    //   176: aconst_null
    //   177: aload_1
    //   178: ldc 136
    //   180: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   183: aload_1
    //   184: ldc 141
    //   186: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   189: aload_1
    //   190: ldc 147
    //   192: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   195: aload_1
    //   196: ldc 149
    //   198: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   201: invokestatic 154	com/tencent/device/utils/SmartDeviceReport:a	(Lmqq/app/AppRuntime;Ljava/lang/String;III)V
    //   204: iconst_1
    //   205: ireturn
    //   206: ldc 17
    //   208: aload 4
    //   210: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq -204 -> 9
    //   216: aload_0
    //   217: getfield 65	com/tencent/device/utils/QQConnectPlugin:TAG	Ljava/lang/String;
    //   220: ldc 156
    //   222: invokestatic 72	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: new 74	org/json/JSONObject
    //   228: dup
    //   229: aload 5
    //   231: iconst_0
    //   232: aaload
    //   233: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   236: ldc 158
    //   238: invokevirtual 139	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore_1
    //   242: aload_1
    //   243: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: istore 6
    //   248: iload 6
    //   250: ifne +59 -> 309
    //   253: new 42	java/lang/String
    //   256: dup
    //   257: aload_1
    //   258: iconst_0
    //   259: invokestatic 163	com/tencent/mobileqq/utils/Base64Util:decode	(Ljava/lang/String;I)[B
    //   262: invokespecial 166	java/lang/String:<init>	([B)V
    //   265: astore_1
    //   266: aload_1
    //   267: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   270: ifne +39 -> 309
    //   273: new 94	android/content/Intent
    //   276: dup
    //   277: aload_0
    //   278: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   281: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   284: ldc 168
    //   286: invokespecial 108	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   289: astore_2
    //   290: aload_2
    //   291: ldc 170
    //   293: aload_1
    //   294: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   297: pop
    //   298: aload_0
    //   299: getfield 98	com/tencent/device/utils/QQConnectPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   302: invokevirtual 103	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   305: aload_2
    //   306: invokevirtual 120	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   309: iconst_1
    //   310: ireturn
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_1
    //   314: goto -48 -> 266
    //   317: astore_1
    //   318: iconst_0
    //   319: ireturn
    //   320: astore_1
    //   321: iconst_0
    //   322: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	QQConnectPlugin
    //   0	323	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	323	2	paramString1	String
    //   0	323	3	paramString2	String
    //   0	323	4	paramString3	String
    //   0	323	5	paramVarArgs	String[]
    //   246	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   30	68	124	org/json/JSONException
    //   253	266	311	java/lang/Exception
    //   216	248	317	org/json/JSONException
    //   253	266	317	org/json/JSONException
    //   266	309	317	org/json/JSONException
    //   155	204	320	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.utils.QQConnectPlugin
 * JD-Core Version:    0.7.0.1
 */