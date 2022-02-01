package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFontJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BUSINESS_NAME = "font";
  private static final String TAG = "ChatFontJsPlugin";
  private BrowserAppInterface browserApp;
  private boolean isUseFont;
  private HashMap mFontSize;
  private Bundle mReqBundle;
  
  private void setFontSwitch(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setFontSwitch:" + paramJSONObject);
    }
    try
    {
      int i = paramJSONObject.getInt("action");
      this.mReqBundle.clear();
      this.mReqBundle.putInt("action", i);
      super.sendRemoteReq(DataFactory.makeIPCRequestPacket("setFontSwtich", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"font".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    int i = paramString1.indexOf("=");
    if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
      return false;
    }
    paramString1 = paramString1.substring(i + 1);
    if (paramString1 == null) {
      return false;
    }
    try
    {
      paramJsBridgeListener = URLDecoder.decode(paramString1, "UTF-8");
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (UnsupportedEncodingException paramJsBridgeListener)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatFontJsPlugin", 2, "Failed to decode json str, josn=" + paramString1);
        }
        paramJsBridgeListener = null;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ChatFontJsPlugin", 2, "Failed to parse json str,json=" + null);
          }
          paramJsBridgeListener = null;
        }
      }
    }
    try
    {
      if (paramJsBridgeListener.has("id")) {
        i = paramJsBridgeListener.getInt("id");
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        try
        {
          paramString1 = paramJsBridgeListener.getString("callback");
          if (paramString1 != null) {
            continue;
          }
          return false;
        }
        catch (JSONException paramString1)
        {
          continue;
        }
        paramString1 = paramString1;
        i = 0;
        if (QLog.isColorLevel()) {
          QLog.i("ChatFontJsPlugin", 2, "Failed to parse callbackid,json=" + paramJsBridgeListener);
        }
        paramString1 = null;
        continue;
        if ("queryLocal".equals(paramString3))
        {
          queryLocal(paramJsBridgeListener, paramString1);
          return true;
        }
        if ("setSize".equals(paramString3))
        {
          setSize(paramJsBridgeListener, paramString1);
          return true;
        }
        if ((!"queryInfo".equals(paramString3)) || (i == 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject();
          paramString2 = new JSONObject();
          paramString2.put("status", 3);
          paramString2.put("progress", 100);
          paramJsBridgeListener.put("result", 0);
          paramJsBridgeListener.put("message", "本地已存在");
          super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          paramJsBridgeListener = "queryFontInfo";
          this.mReqBundle.clear();
          this.mReqBundle.putInt("id", i);
          super.sendRemoteReq(DataFactory.makeIPCRequestPacket(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          return true;
          if ("setup".equals(paramString3))
          {
            paramJsBridgeListener = "setupChatFont";
            continue;
          }
          if ("startDownload".equals(paramString3))
          {
            paramJsBridgeListener = "font_startDownLoad";
            continue;
          }
          if ("stopDownload".equals(paramString3))
          {
            paramJsBridgeListener = "font_StopDownLoad";
            continue;
          }
          if ("showBlackMsgBox".equals(paramString3))
          {
            paramString2 = new JSONObject();
            try
            {
              paramJsBridgeListener = paramJsBridgeListener.getString("msg");
              QQToast.a(this.mRuntime.a(), paramJsBridgeListener, 0).b(((QQBrowserActivity)this.mRuntime.a()).getTitleBarHeight());
              super.callJs(paramString1, new String[] { paramString2.toString() });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("ChatFontJsPlugin", 2, "showBlackMsgBox failed: " + paramJsBridgeListener.getMessage());
              continue;
            }
          }
          if ("isUseFont".equals(paramString3))
          {
            isUseFont(paramString1);
            return true;
          }
          if ("setFontSwitch".equals(paramString3))
          {
            setFontSwitch(paramJsBridgeListener, paramString1);
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.w("ChatFontJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
          }
          return false;
        }
        catch (JSONException paramJsBridgeListener)
        {
          continue;
        }
        i = 0;
      }
    }
  }
  
  public void isUseFont(String paramString)
  {
    boolean bool1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mRuntime.a().getAccount(), false);
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    if ((bool1) || (bool2)) {}
    JSONObject localJSONObject;
    for (bool1 = true;; bool1 = false)
    {
      this.isUseFont = bool1;
      localJSONObject = new JSONObject();
      if (this.isUseFont) {
        break;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(2131365995)).setMessage(this.mRuntime.a().getString(2131366300)).setPositiveButton(this.mRuntime.a().getString(2131366301), new ChatFontJsPlugin.2(this, localJSONObject, paramString)).setNegativeButton(this.mRuntime.a().getString(2131366302), new ChatFontJsPlugin.1(this, localJSONObject, paramString));
      localQQCustomDialog.show();
      localQQCustomDialog.setOnCancelListener(new ChatFontJsPlugin.3(this, localJSONObject, paramString));
      return;
    }
    try
    {
      localJSONObject.put("isUse", 1);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJs(paramString, new String[] { localJSONException.getMessage() });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      this.mReqBundle = new Bundle();
      this.mFontSize = new HashMap(4);
      this.mFontSize.put("small", Integer.valueOf(0));
      this.mFontSize.put("middle", Integer.valueOf(1));
      this.mFontSize.put("big", Integer.valueOf(2));
      this.mFontSize.put("bigger", Integer.valueOf(3));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
      }
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if ((i != 0) && (i == 2))
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label98:
      super.callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label98;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject = new JSONObject();
          if (!"setupChatFont".equals(str1)) {
            break;
          }
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("message", paramBundle.getString("message"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatFontJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      if ("queryFontInfo".equals(str1))
      {
        super.callJs(str2, new String[] { paramBundle.getString("result") });
        return;
      }
      if ("font_StopDownLoad".equals(str1))
      {
        localJSONObject.put("result", 0);
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
    } while (!"setFontSwtich".equals(str1));
    localJSONObject.put("result", 0);
    super.callJs(str2, new String[] { localJSONObject.toString() });
  }
  
  /* Error */
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 11
    //   11: iconst_2
    //   12: new 36	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 421
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 58	org/json/JSONObject
    //   38: dup
    //   39: invokespecial 181	org/json/JSONObject:<init>	()V
    //   42: astore 8
    //   44: aload_0
    //   45: getfield 357	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   48: aconst_null
    //   49: invokevirtual 424	com/tencent/mobileqq/app/BrowserAppInterface:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   52: invokevirtual 430	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   55: astore_1
    //   56: aload_1
    //   57: ldc_w 432
    //   60: aload_0
    //   61: getfield 357	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   64: invokevirtual 433	com/tencent/mobileqq/app/BrowserAppInterface:getAccount	()Ljava/lang/String;
    //   67: invokevirtual 438	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   70: checkcast 432	com/tencent/mobileqq/data/ExtensionInfo
    //   73: astore 6
    //   75: aload_1
    //   76: invokevirtual 440	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   79: aload 8
    //   81: ldc 191
    //   83: iconst_0
    //   84: invokevirtual 187	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload 6
    //   90: ifnonnull +98 -> 188
    //   93: aload 8
    //   95: ldc_w 442
    //   98: lconst_0
    //   99: invokevirtual 445	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   102: pop
    //   103: invokestatic 451	mqq/app/MobileQQ:getContext	()Landroid/content/Context;
    //   106: ldc_w 453
    //   109: iconst_4
    //   110: invokevirtual 456	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   113: ldc_w 458
    //   116: iconst_0
    //   117: invokeinterface 459 3 0
    //   122: istore_3
    //   123: ldc_w 367
    //   126: astore_1
    //   127: aload_0
    //   128: getfield 365	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mFontSize	Ljava/util/HashMap;
    //   131: invokevirtual 463	java/util/HashMap:keySet	()Ljava/util/Set;
    //   134: invokeinterface 469 1 0
    //   139: astore 9
    //   141: aload 9
    //   143: invokeinterface 474 1 0
    //   148: ifeq +110 -> 258
    //   151: aload 9
    //   153: invokeinterface 478 1 0
    //   158: checkcast 100	java/lang/String
    //   161: astore 6
    //   163: aload_0
    //   164: getfield 365	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mFontSize	Ljava/util/HashMap;
    //   167: aload 6
    //   169: invokevirtual 482	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast 369	java/lang/Integer
    //   175: invokevirtual 485	java/lang/Integer:intValue	()I
    //   178: iload_3
    //   179: if_icmpne +569 -> 748
    //   182: aload 6
    //   184: astore_1
    //   185: goto +563 -> 748
    //   188: aload 8
    //   190: ldc_w 442
    //   193: aload 6
    //   195: getfield 489	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   198: invokevirtual 445	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   201: pop
    //   202: goto -99 -> 103
    //   205: astore_1
    //   206: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +32 -> 241
    //   212: ldc 11
    //   214: iconst_2
    //   215: new 36	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 491
    //   225: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 103	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   232: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload_0
    //   242: aload_2
    //   243: iconst_1
    //   244: anewarray 100	java/lang/String
    //   247: dup
    //   248: iconst_0
    //   249: aload_1
    //   250: invokevirtual 103	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   253: aastore
    //   254: invokespecial 107	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   257: return
    //   258: aload 8
    //   260: ldc_w 493
    //   263: aload_1
    //   264: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_0
    //   269: getfield 221	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   272: invokevirtual 227	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   275: ldc_w 261
    //   278: iconst_4
    //   279: invokevirtual 267	android/app/Activity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   282: new 36	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 269
    //   292: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: getfield 221	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   299: invokevirtual 272	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   302: invokevirtual 277	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   305: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: iconst_0
    //   312: invokeinterface 283 3 0
    //   317: istore 4
    //   319: invokestatic 288	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   322: getstatic 294	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:chat_font	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   325: invokevirtual 297	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   328: invokevirtual 299	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Z
    //   331: istore 5
    //   333: iload 4
    //   335: ifne +416 -> 751
    //   338: iload 5
    //   340: ifne +411 -> 751
    //   343: getstatic 497	com/etrump/mixlayout/FontManager:jdField_b_of_type_Boolean	Z
    //   346: ifeq +413 -> 759
    //   349: goto +402 -> 751
    //   352: iload_3
    //   353: ifeq +237 -> 590
    //   356: aload 8
    //   358: ldc_w 499
    //   361: iconst_1
    //   362: invokevirtual 187	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   365: pop
    //   366: new 501	java/io/File
    //   369: dup
    //   370: getstatic 503	com/etrump/mixlayout/FontManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   373: ldc_w 505
    //   376: invokespecial 508	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: astore 9
    //   381: aload 9
    //   383: invokevirtual 511	java/io/File:exists	()Z
    //   386: istore 4
    //   388: iload 4
    //   390: ifeq +353 -> 743
    //   393: new 513	java/io/FileReader
    //   396: dup
    //   397: aload 9
    //   399: invokevirtual 516	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   402: invokespecial 517	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   405: astore 6
    //   407: aload 6
    //   409: astore_1
    //   410: sipush 4096
    //   413: newarray char
    //   415: astore 10
    //   417: aload 6
    //   419: astore_1
    //   420: new 36	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   427: astore 11
    //   429: aload 6
    //   431: astore_1
    //   432: aload 6
    //   434: aload 10
    //   436: invokevirtual 521	java/io/FileReader:read	([C)I
    //   439: istore_3
    //   440: iload_3
    //   441: ifle +162 -> 603
    //   444: aload 6
    //   446: astore_1
    //   447: aload 11
    //   449: aload 10
    //   451: iconst_0
    //   452: iload_3
    //   453: invokevirtual 524	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: goto -28 -> 429
    //   460: astore 7
    //   462: aload 6
    //   464: astore_1
    //   465: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +17 -> 485
    //   471: aload 6
    //   473: astore_1
    //   474: ldc 11
    //   476: iconst_2
    //   477: aload 7
    //   479: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   482: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload 6
    //   487: ifnull +8 -> 495
    //   490: aload 6
    //   492: invokevirtual 527	java/io/FileReader:close	()V
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnonnull +242 -> 740
    //   501: new 529	org/json/JSONArray
    //   504: dup
    //   505: invokespecial 530	org/json/JSONArray:<init>	()V
    //   508: astore_1
    //   509: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq +244 -> 756
    //   515: ldc 11
    //   517: iconst_2
    //   518: new 36	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   525: aload 9
    //   527: invokevirtual 516	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   530: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc_w 532
    //   536: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: goto +211 -> 756
    //   548: new 529	org/json/JSONArray
    //   551: dup
    //   552: invokespecial 530	org/json/JSONArray:<init>	()V
    //   555: astore 6
    //   557: iconst_0
    //   558: istore_3
    //   559: iload_3
    //   560: aload_1
    //   561: invokevirtual 533	org/json/JSONArray:length	()I
    //   564: if_icmpge +113 -> 677
    //   567: aload 6
    //   569: aload_1
    //   570: iload_3
    //   571: invokevirtual 537	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   574: ldc 158
    //   576: invokevirtual 62	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   579: invokevirtual 540	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   582: pop
    //   583: iload_3
    //   584: iconst_1
    //   585: iadd
    //   586: istore_3
    //   587: goto -28 -> 559
    //   590: aload 8
    //   592: ldc_w 499
    //   595: iconst_0
    //   596: invokevirtual 187	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   599: pop
    //   600: goto -234 -> 366
    //   603: aload 6
    //   605: astore_1
    //   606: aload 11
    //   608: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: astore 10
    //   613: aload 7
    //   615: astore_1
    //   616: aload 10
    //   618: ifnull +20 -> 638
    //   621: aload 6
    //   623: astore_1
    //   624: new 529	org/json/JSONArray
    //   627: dup
    //   628: aload 10
    //   630: invokespecial 541	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   633: astore 7
    //   635: aload 7
    //   637: astore_1
    //   638: aload 6
    //   640: ifnull +8 -> 648
    //   643: aload 6
    //   645: invokevirtual 527	java/io/FileReader:close	()V
    //   648: goto -151 -> 497
    //   651: astore 6
    //   653: goto -156 -> 497
    //   656: astore_1
    //   657: aconst_null
    //   658: astore_1
    //   659: goto -162 -> 497
    //   662: astore 6
    //   664: aconst_null
    //   665: astore_1
    //   666: aload_1
    //   667: ifnull +7 -> 674
    //   670: aload_1
    //   671: invokevirtual 527	java/io/FileReader:close	()V
    //   674: aload 6
    //   676: athrow
    //   677: aload 8
    //   679: ldc_w 543
    //   682: aload 6
    //   684: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   687: pop
    //   688: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +14 -> 705
    //   694: ldc 11
    //   696: iconst_2
    //   697: aload 8
    //   699: invokevirtual 199	org/json/JSONObject:toString	()Ljava/lang/String;
    //   702: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: aload_0
    //   706: aload_2
    //   707: iconst_1
    //   708: anewarray 100	java/lang/String
    //   711: dup
    //   712: iconst_0
    //   713: aload 8
    //   715: invokevirtual 199	org/json/JSONObject:toString	()Ljava/lang/String;
    //   718: aastore
    //   719: invokespecial 107	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   722: return
    //   723: astore_1
    //   724: goto -50 -> 674
    //   727: astore 6
    //   729: goto -63 -> 666
    //   732: astore 7
    //   734: aconst_null
    //   735: astore 6
    //   737: goto -275 -> 462
    //   740: goto -192 -> 548
    //   743: aconst_null
    //   744: astore_1
    //   745: goto -248 -> 497
    //   748: goto -607 -> 141
    //   751: iconst_1
    //   752: istore_3
    //   753: goto -401 -> 352
    //   756: goto -208 -> 548
    //   759: iconst_0
    //   760: istore_3
    //   761: goto -409 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	ChatFontJsPlugin
    //   0	764	1	paramJSONObject	JSONObject
    //   0	764	2	paramString	String
    //   122	639	3	i	int
    //   317	72	4	bool1	boolean
    //   331	8	5	bool2	boolean
    //   73	571	6	localObject1	java.lang.Object
    //   651	1	6	localIOException	java.io.IOException
    //   662	21	6	localObject2	java.lang.Object
    //   727	1	6	localObject3	java.lang.Object
    //   735	1	6	localObject4	java.lang.Object
    //   1	1	7	localObject5	java.lang.Object
    //   460	154	7	localException1	Exception
    //   633	3	7	localJSONArray	org.json.JSONArray
    //   732	1	7	localException2	Exception
    //   42	672	8	localJSONObject	JSONObject
    //   139	387	9	localObject6	java.lang.Object
    //   415	214	10	localObject7	java.lang.Object
    //   427	180	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   35	88	205	org/json/JSONException
    //   93	103	205	org/json/JSONException
    //   103	123	205	org/json/JSONException
    //   127	141	205	org/json/JSONException
    //   141	182	205	org/json/JSONException
    //   188	202	205	org/json/JSONException
    //   258	333	205	org/json/JSONException
    //   343	349	205	org/json/JSONException
    //   356	366	205	org/json/JSONException
    //   366	388	205	org/json/JSONException
    //   490	495	205	org/json/JSONException
    //   501	545	205	org/json/JSONException
    //   548	557	205	org/json/JSONException
    //   559	583	205	org/json/JSONException
    //   590	600	205	org/json/JSONException
    //   643	648	205	org/json/JSONException
    //   670	674	205	org/json/JSONException
    //   674	677	205	org/json/JSONException
    //   677	705	205	org/json/JSONException
    //   705	722	205	org/json/JSONException
    //   410	417	460	java/lang/Exception
    //   420	429	460	java/lang/Exception
    //   432	440	460	java/lang/Exception
    //   447	457	460	java/lang/Exception
    //   606	613	460	java/lang/Exception
    //   624	635	460	java/lang/Exception
    //   643	648	651	java/io/IOException
    //   490	495	656	java/io/IOException
    //   393	407	662	finally
    //   670	674	723	java/io/IOException
    //   410	417	727	finally
    //   420	429	727	finally
    //   432	440	727	finally
    //   447	457	727	finally
    //   465	471	727	finally
    //   474	485	727	finally
    //   606	613	727	finally
    //   624	635	727	finally
    //   393	407	732	java/lang/Exception
  }
  
  public void setSize(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setSize:" + paramJSONObject);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = paramJSONObject.getString("size");
      ReportController.a(null, "CliOper", "", "", "Font_Mall", "change_" + paramJSONObject, 0, 0, "", "", "", "");
      int i;
      if (this.mFontSize.containsKey(paramJSONObject))
      {
        i = ((Integer)this.mFontSize.get(paramJSONObject)).intValue();
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        paramJSONObject = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).edit();
        paramJSONObject.putInt("chat_text_size_type", i);
        paramJSONObject.commit();
        localJSONObject.put("message", "success");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "size illege");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        i = 0;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin
 * JD-Core Version:    0.7.0.1
 */