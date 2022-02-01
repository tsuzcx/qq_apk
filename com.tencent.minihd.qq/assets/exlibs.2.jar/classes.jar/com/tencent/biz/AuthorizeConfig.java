package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import cac;
import cad;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizeConfig
{
  protected static final int a = 86400000;
  public static volatile long a = 0L;
  protected static AuthorizeConfig a;
  static final String jdField_a_of_type_JavaLangString = "AuthorizeConfig";
  static final boolean jdField_a_of_type_Boolean = false;
  public static volatile int b = 0;
  protected static final String b = "https://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json";
  protected static final String c = "domainCmdRight";
  protected static final String d = "cmdConfig";
  protected static final String e = "sid";
  protected static final String f = "lastUpdate";
  protected static final String g = "extra";
  protected static final String h = "jump";
  protected static final String i = "offlineHtml";
  protected static final String j = "skey";
  protected static final String k = "vkey";
  protected static final String l = "pskey";
  protected static final String m = "schemes";
  protected static final String n = "a1";
  protected static final String o = "*.qq.com";
  protected static final String p = "qq.com";
  protected static final String q = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}";
  protected static final String r = "[\"*.qq.com\",\"*.tenpay.com\"]";
  protected static final String s = "[{\"dev-m.mail.qq.com\":\"sid\"},{\"mail.qq.com\":\"3g_sid\"},{\"w.mail.qq.com\":\"3g_sid\"},{\"qqweb.qq.com\":\"sid\"},{\"web.p.qq.com\":\"sid\"},{\"vip.qq.com\":\"sid\"},{\"m.daoju.qq.com\":\"sid\"},{\"info.3g.qq.com\":\"sid\"},{\"infoapp.3g.qq.com\":\"sid\"},{\"gp.3g.qq.com\":\"sid\"},{\"live.3g.qq.com\":\"sid\"},{\"comment.3g.qq.com\":\"sid\"},{\"mobile.qzone.qq.com\":\"sid\"},{\"qzone.com\":\"sid\"},{\"www.qzone.com\":\"sid\"},{\"m.qzone.com\":\"sid\"},{\"www.qq.com\":\"sid\"},{\"qq.com\":\"sid\"},{\"z.qq.com\":\"sid\"},{\"f.qq.com\":\"sid\"},{\"3g.qq.com\":\"sid\"},{\"misc.3g.qq.com\":\"sid\"},{\"wap.3g.qq.com\":\"sid\"},{\"sy.qq.com\":\"sid\"},{\"s.p.qq.com\":\"sid\"},{\"qlife.qq.com\":\"sid\"},{\"gamecenter.qq.com\":\"sid\"},{\"youxi.vip.qq.com\":\"sid\"},{\"web.g.qq.com\":\"sid\"},{\"iyouxi.vip.qq.com\":\"sid\"},{\"imgcache.qq.com\":\"sid\"},{\"mc.vip.qq.com\":\"sid\"},{\"mo.vip.qq.com\":\"sid\"},{\"fun.svip.qq.com\":\"sid\"},{\"vipfunc.qq.com\":\"sid\"}]";
  protected static final String t = "[\"qq.com\"]";
  protected static final String u = "[\"game.qq.com\",\"id.qq.com\"]";
  protected static final String v = "{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}";
  protected static final String w = "{\"host\": [\"*.qq.com\"]}";
  static final String x = "lastMod";
  static final String y = "qqVersion";
  static final String z = "lastVersion";
  public Context a;
  public SharedPreferences a;
  public JSONArray a;
  public JSONObject a;
  public String[] a;
  protected JSONArray b;
  public JSONObject b;
  public String[] b;
  public JSONArray c;
  public JSONObject c;
  public String[] c;
  public JSONArray d;
  public JSONObject d;
  public JSONArray e;
  public JSONObject e;
  public JSONArray f;
  
  static
  {
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_Long = -1L;
  }
  
  private AuthorizeConfig(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
  }
  
  public static AuthorizeConfig a()
  {
    if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        jdField_a_of_type_ComTencentBizAuthorizeConfig = new AuthorizeConfig(BaseApplication.getContext());
      }
      jdField_a_of_type_ComTencentBizAuthorizeConfig.a();
      jdField_a_of_type_ComTencentBizAuthorizeConfig.b();
      return jdField_a_of_type_ComTencentBizAuthorizeConfig;
    }
    finally {}
  }
  
  private JSONArray a()
  {
    Object localObject1 = this.jdField_c_of_type_OrgJsonJSONArray;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("skey", null);
      if (localObject2 == null) {
        break label89;
      }
    }
    label89:
    label96:
    for (;;)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
        if (localObject1 != null) {
          break label96;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSkeyConfig error");
        }
      }
      try
      {
        localObject2 = new JSONArray("[\"*.qq.com\",\"*.tenpay.com\"]");
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        continue;
      }
      this.jdField_c_of_type_ArrayOfJavaLangString = null;
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
      this.jdField_c_of_type_OrgJsonJSONArray = ((JSONArray)localObject1);
      localObject2 = localObject1;
      return localObject2;
    }
  }
  
  private JSONObject a()
  {
    Object localObject3 = this.jdField_b_of_type_OrgJsonJSONObject;
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("offlineHtml", null);
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  /* Error */
  private JSONArray b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 192	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +59 -> 67
    //   11: aload_0
    //   12: getfield 130	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   15: ldc 46
    //   17: aconst_null
    //   18: invokeinterface 156 3 0
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +59 -> 84
    //   28: new 158	org/json/JSONArray
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +51 -> 91
    //   43: new 158	org/json/JSONArray
    //   46: dup
    //   47: ldc 73
    //   49: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 165	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 192	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   65: aload_1
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +11 -> 84
    //   76: ldc 14
    //   78: iconst_2
    //   79: ldc 194
    //   81: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: goto -45 -> 39
    //   87: astore_2
    //   88: goto -33 -> 55
    //   91: goto -36 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AuthorizeConfig
    //   4	62	1	localObject1	Object
    //   6	62	2	localObject2	Object
    //   69	1	2	localJSONException1	JSONException
    //   87	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   28	37	69	org/json/JSONException
    //   43	53	87	org/json/JSONException
  }
  
  private JSONObject b()
  {
    Object localObject3 = this.jdField_c_of_type_OrgJsonJSONObject;
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("extra", null);
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.jdField_c_of_type_OrgJsonJSONObject = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  /* Error */
  private JSONArray c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 225	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull +59 -> 67
    //   11: aload_0
    //   12: getfield 130	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   15: ldc 49
    //   17: aconst_null
    //   18: invokeinterface 156 3 0
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +59 -> 84
    //   28: new 158	org/json/JSONArray
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_1
    //   40: ifnonnull +51 -> 91
    //   43: new 158	org/json/JSONArray
    //   46: dup
    //   47: ldc 76
    //   49: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 227	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   60: aload_0
    //   61: aload_1
    //   62: putfield 225	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   65: aload_1
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +11 -> 84
    //   76: ldc 14
    //   78: iconst_2
    //   79: ldc 229
    //   81: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: goto -45 -> 39
    //   87: astore_2
    //   88: goto -33 -> 55
    //   91: goto -36 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AuthorizeConfig
    //   4	62	1	localObject1	Object
    //   6	62	2	localObject2	Object
    //   69	1	2	localJSONException1	JSONException
    //   87	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   28	37	69	org/json/JSONException
    //   43	53	87	org/json/JSONException
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return 0;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        int i1 = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return i1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public int a(String paramString, int paramInt)
  {
    return b().optInt(paramString, paramInt);
  }
  
  public Boolean a(String paramString, Boolean paramBoolean)
  {
    return Boolean.valueOf(b().optBoolean(paramString, paramBoolean.booleanValue()));
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 282	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 286	android/net/Uri:getScheme	()Ljava/lang/String;
    //   18: astore 5
    //   20: ldc_w 288
    //   23: aload 5
    //   25: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +8 -> 36
    //   31: iconst_1
    //   32: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: areturn
    //   36: ldc_w 290
    //   39: aload 5
    //   41: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   44: ifne +19 -> 63
    //   47: ldc_w 292
    //   50: aload 5
    //   52: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +8 -> 63
    //   58: iconst_0
    //   59: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: areturn
    //   63: aload_1
    //   64: invokevirtual 295	android/net/Uri:getHost	()Ljava/lang/String;
    //   67: astore 6
    //   69: aload_0
    //   70: getfield 297	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnonnull +242 -> 317
    //   78: aload_0
    //   79: getfield 130	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   82: ldc 37
    //   84: aconst_null
    //   85: invokeinterface 156 3 0
    //   90: astore 5
    //   92: aload 5
    //   94: ifnull +100 -> 194
    //   97: new 172	org/json/JSONObject
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 173	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: aload 5
    //   110: astore_1
    //   111: aload_1
    //   112: ifnonnull +202 -> 314
    //   115: new 172	org/json/JSONObject
    //   118: dup
    //   119: ldc 82
    //   121: invokespecial 173	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   124: astore 5
    //   126: aload 5
    //   128: astore_1
    //   129: aload_0
    //   130: aload_1
    //   131: putfield 297	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   134: aload_1
    //   135: ldc_w 299
    //   138: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 304	org/json/JSONArray:length	()I
    //   148: istore 4
    //   150: iconst_0
    //   151: istore_3
    //   152: iload_3
    //   153: iload 4
    //   155: if_icmpge +56 -> 211
    //   158: aload 5
    //   160: iload_3
    //   161: invokevirtual 307	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   164: aload 6
    //   166: invokestatic 309	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   169: ifeq +33 -> 202
    //   172: iconst_1
    //   173: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   176: areturn
    //   177: astore 5
    //   179: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +12 -> 194
    //   185: ldc 14
    //   187: iconst_2
    //   188: ldc_w 311
    //   191: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: goto -83 -> 111
    //   197: astore 5
    //   199: goto -70 -> 129
    //   202: iload_3
    //   203: iconst_1
    //   204: iadd
    //   205: istore_3
    //   206: goto -54 -> 152
    //   209: astore 5
    //   211: aload_1
    //   212: ldc_w 313
    //   215: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   218: astore 5
    //   220: aload 5
    //   222: invokevirtual 304	org/json/JSONArray:length	()I
    //   225: istore 4
    //   227: iconst_0
    //   228: istore_3
    //   229: iload_3
    //   230: iload 4
    //   232: if_icmpge +30 -> 262
    //   235: aload 5
    //   237: iload_3
    //   238: invokevirtual 307	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   241: aload_2
    //   242: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   245: ifeq +8 -> 253
    //   248: iconst_1
    //   249: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   252: areturn
    //   253: iload_3
    //   254: iconst_1
    //   255: iadd
    //   256: istore_3
    //   257: goto -28 -> 229
    //   260: astore 5
    //   262: aload_1
    //   263: ldc_w 315
    //   266: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 304	org/json/JSONArray:length	()I
    //   274: istore 4
    //   276: iconst_0
    //   277: istore_3
    //   278: iload_3
    //   279: iload 4
    //   281: if_icmpge +28 -> 309
    //   284: aload_1
    //   285: iload_3
    //   286: invokevirtual 307	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   289: aload_2
    //   290: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +8 -> 301
    //   296: iconst_1
    //   297: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   300: areturn
    //   301: iload_3
    //   302: iconst_1
    //   303: iadd
    //   304: istore_3
    //   305: goto -27 -> 278
    //   308: astore_1
    //   309: iconst_0
    //   310: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   313: areturn
    //   314: goto -185 -> 129
    //   317: goto -183 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	AuthorizeConfig
    //   0	320	1	paramString1	String
    //   0	320	2	paramString2	String
    //   151	154	3	i1	int
    //   148	134	4	i2	int
    //   18	141	5	localObject	Object
    //   177	1	5	localJSONException1	JSONException
    //   197	1	5	localJSONException2	JSONException
    //   209	1	5	localJSONException3	JSONException
    //   218	18	5	localJSONArray	JSONArray
    //   260	1	5	localJSONException4	JSONException
    //   67	98	6	str	String
    // Exception table:
    //   from	to	target	type
    //   97	108	177	org/json/JSONException
    //   115	126	197	org/json/JSONException
    //   134	150	209	org/json/JSONException
    //   158	172	209	org/json/JSONException
    //   211	227	260	org/json/JSONException
    //   235	248	260	org/json/JSONException
    //   262	276	308	org/json/JSONException
    //   284	296	308	org/json/JSONException
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 320	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   9: astore 8
    //   11: aload 8
    //   13: astore 7
    //   15: aload 8
    //   17: ifnonnull +61 -> 78
    //   20: aload_0
    //   21: getfield 130	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   24: ldc 28
    //   26: aconst_null
    //   27: invokeinterface 156 3 0
    //   32: astore 7
    //   34: aload 8
    //   36: astore 6
    //   38: aload 7
    //   40: ifnull +14 -> 54
    //   43: new 158	org/json/JSONArray
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   52: astore 6
    //   54: aload 6
    //   56: astore 7
    //   58: aload 6
    //   60: ifnonnull +12 -> 72
    //   63: new 158	org/json/JSONArray
    //   66: dup
    //   67: invokespecial 321	org/json/JSONArray:<init>	()V
    //   70: astore 7
    //   72: aload_0
    //   73: aload 7
    //   75: putfield 320	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   78: aload_1
    //   79: invokestatic 282	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   82: invokevirtual 295	android/net/Uri:getHost	()Ljava/lang/String;
    //   85: astore 8
    //   87: aload 7
    //   89: invokevirtual 304	org/json/JSONArray:length	()I
    //   92: istore 4
    //   94: iconst_0
    //   95: istore_2
    //   96: iload_2
    //   97: iload 4
    //   99: if_icmpge +91 -> 190
    //   102: aload 7
    //   104: iload_2
    //   105: invokevirtual 324	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 327	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   113: iconst_0
    //   114: invokevirtual 329	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   117: astore 6
    //   119: aload 6
    //   121: aload 8
    //   123: invokestatic 309	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   126: ifeq +57 -> 183
    //   129: aload_1
    //   130: aload 6
    //   132: invokevirtual 331	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   140: istore 5
    //   142: iload 5
    //   144: ifeq +35 -> 179
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: areturn
    //   151: astore 6
    //   153: aload 8
    //   155: astore 6
    //   157: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -106 -> 54
    //   163: ldc 14
    //   165: iconst_2
    //   166: ldc_w 333
    //   169: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 8
    //   174: astore 6
    //   176: goto -122 -> 54
    //   179: goto -30 -> 149
    //   182: astore_1
    //   183: iload_2
    //   184: iconst_1
    //   185: iadd
    //   186: istore_2
    //   187: goto -91 -> 96
    //   190: aload_0
    //   191: getfield 335	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   194: astore 7
    //   196: aload 7
    //   198: astore 6
    //   200: aload 7
    //   202: ifnonnull +35 -> 237
    //   205: new 158	org/json/JSONArray
    //   208: dup
    //   209: ldc 70
    //   211: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: aload_1
    //   216: astore 6
    //   218: aload_1
    //   219: ifnonnull +12 -> 231
    //   222: new 158	org/json/JSONArray
    //   225: dup
    //   226: invokespecial 321	org/json/JSONArray:<init>	()V
    //   229: astore 6
    //   231: aload_0
    //   232: aload 6
    //   234: putfield 335	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   237: aload 6
    //   239: invokevirtual 304	org/json/JSONArray:length	()I
    //   242: istore 4
    //   244: iload_3
    //   245: istore_2
    //   246: iload_2
    //   247: iload 4
    //   249: if_icmpge +89 -> 338
    //   252: aload 6
    //   254: iload_2
    //   255: invokevirtual 324	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 327	org/json/JSONObject:names	()Lorg/json/JSONArray;
    //   263: iconst_0
    //   264: invokevirtual 329	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   267: astore 7
    //   269: aload 7
    //   271: aload 8
    //   273: invokestatic 309	com/tencent/biz/AuthorizeConfig:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   276: ifeq +55 -> 331
    //   279: aload_1
    //   280: aload 7
    //   282: invokevirtual 331	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore 7
    //   287: aload 7
    //   289: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   292: istore 5
    //   294: aload 9
    //   296: astore_1
    //   297: iload 5
    //   299: ifne -150 -> 149
    //   302: aload 7
    //   304: areturn
    //   305: astore_1
    //   306: aload 7
    //   308: astore_1
    //   309: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -97 -> 215
    //   315: ldc 14
    //   317: iconst_2
    //   318: ldc_w 337
    //   321: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 7
    //   326: astore_1
    //   327: goto -112 -> 215
    //   330: astore_1
    //   331: iload_2
    //   332: iconst_1
    //   333: iadd
    //   334: istore_2
    //   335: goto -89 -> 246
    //   338: aload 9
    //   340: astore_1
    //   341: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -195 -> 149
    //   347: aload 9
    //   349: astore_1
    //   350: aload 8
    //   352: ifnull -203 -> 149
    //   355: aload 9
    //   357: astore_1
    //   358: aload 8
    //   360: ldc_w 339
    //   363: invokevirtual 220	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   366: ifeq -217 -> 149
    //   369: ldc 14
    //   371: iconst_2
    //   372: new 341	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 344
    //   382: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 8
    //   387: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 350
    //   393: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 355	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aconst_null
    //   403: areturn
    //   404: astore_1
    //   405: goto -74 -> 331
    //   408: astore_1
    //   409: goto -226 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	AuthorizeConfig
    //   0	412	1	paramString	String
    //   95	240	2	i1	int
    //   4	241	3	i2	int
    //   92	158	4	i3	int
    //   140	158	5	bool	boolean
    //   36	95	6	localObject1	Object
    //   151	1	6	localJSONException	JSONException
    //   155	98	6	localObject2	Object
    //   13	312	7	localObject3	Object
    //   9	377	8	localObject4	Object
    //   1	355	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	54	151	org/json/JSONException
    //   102	142	182	org/json/JSONException
    //   205	215	305	org/json/JSONException
    //   252	294	330	org/json/JSONException
    //   252	294	404	java/lang/NullPointerException
    //   102	142	408	java/lang/NullPointerException
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  protected void a()
  {
    ThreadManager.b(new cac(this));
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 8
    //   6: aload_0
    //   7: getfield 130	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   10: invokeinterface 374 1 0
    //   15: astore 9
    //   17: new 172	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 174	org/json/JSONObject:<init>	()V
    //   24: astore 10
    //   26: aload_1
    //   27: ldc_w 376
    //   30: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   33: astore 11
    //   35: aload 11
    //   37: invokevirtual 304	org/json/JSONArray:length	()I
    //   40: istore 6
    //   42: iconst_0
    //   43: istore 4
    //   45: iload 4
    //   47: iload 6
    //   49: if_icmpge +73 -> 122
    //   52: aload 11
    //   54: iload 4
    //   56: invokevirtual 324	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   59: astore 13
    //   61: aload 13
    //   63: ldc_w 378
    //   66: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   69: astore 12
    //   71: aload 13
    //   73: ldc_w 380
    //   76: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   79: astore 13
    //   81: iconst_0
    //   82: istore 5
    //   84: aload 13
    //   86: invokevirtual 304	org/json/JSONArray:length	()I
    //   89: istore 7
    //   91: iload 5
    //   93: iload 7
    //   95: if_icmpge +722 -> 817
    //   98: aload 10
    //   100: aload 13
    //   102: iload 5
    //   104: invokevirtual 329	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   107: aload 12
    //   109: invokevirtual 384	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   112: pop
    //   113: iload 5
    //   115: iconst_1
    //   116: iadd
    //   117: istore 5
    //   119: goto -28 -> 91
    //   122: aload_0
    //   123: aload 10
    //   125: putfield 386	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   128: aload 9
    //   130: ldc 25
    //   132: aload 10
    //   134: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   137: invokeinterface 393 3 0
    //   142: pop
    //   143: aload_1
    //   144: ldc 28
    //   146: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   149: astore 10
    //   151: aload_0
    //   152: aload 10
    //   154: putfield 320	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   157: aload 9
    //   159: ldc 28
    //   161: aload 10
    //   163: invokevirtual 394	org/json/JSONArray:toString	()Ljava/lang/String;
    //   166: invokeinterface 393 3 0
    //   171: pop
    //   172: aload_1
    //   173: ldc_w 396
    //   176: invokevirtual 245	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   179: astore 10
    //   181: aload_0
    //   182: aload 10
    //   184: putfield 170	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   187: aload 9
    //   189: ldc 40
    //   191: aload 10
    //   193: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: invokeinterface 393 3 0
    //   201: pop
    //   202: aload_1
    //   203: ldc_w 398
    //   206: invokevirtual 245	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   209: astore 10
    //   211: aload_0
    //   212: aload 10
    //   214: putfield 196	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   217: aload 9
    //   219: ldc 34
    //   221: aload 10
    //   223: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   226: invokeinterface 393 3 0
    //   231: pop
    //   232: aload_1
    //   233: ldc 37
    //   235: invokevirtual 245	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   238: astore 10
    //   240: aload_0
    //   241: aload 10
    //   243: putfield 297	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   246: aload 9
    //   248: ldc 37
    //   250: aload 10
    //   252: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   255: invokeinterface 393 3 0
    //   260: pop
    //   261: aload_1
    //   262: ldc 43
    //   264: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   267: astore 10
    //   269: aload_0
    //   270: aconst_null
    //   271: putfield 163	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 165	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   279: aload_0
    //   280: aload 10
    //   282: putfield 150	com/tencent/biz/AuthorizeConfig:jdField_c_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   285: aload 9
    //   287: ldc 43
    //   289: aload 10
    //   291: invokevirtual 394	org/json/JSONArray:toString	()Ljava/lang/String;
    //   294: invokeinterface 393 3 0
    //   299: pop
    //   300: aload_1
    //   301: ldc 46
    //   303: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   306: astore 10
    //   308: aload_0
    //   309: aconst_null
    //   310: putfield 165	com/tencent/biz/AuthorizeConfig:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   313: aload_0
    //   314: aload 10
    //   316: putfield 192	com/tencent/biz/AuthorizeConfig:jdField_d_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   319: aload 9
    //   321: ldc 46
    //   323: aload 10
    //   325: invokevirtual 394	org/json/JSONArray:toString	()Ljava/lang/String;
    //   328: invokeinterface 393 3 0
    //   333: pop
    //   334: aload_1
    //   335: ldc 49
    //   337: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   340: astore 10
    //   342: aload_0
    //   343: aconst_null
    //   344: putfield 227	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   347: aload_0
    //   348: aload 10
    //   350: putfield 225	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   353: aload 9
    //   355: ldc 49
    //   357: aload 10
    //   359: invokevirtual 394	org/json/JSONArray:toString	()Ljava/lang/String;
    //   362: invokeinterface 393 3 0
    //   367: pop
    //   368: new 172	org/json/JSONObject
    //   371: dup
    //   372: invokespecial 174	org/json/JSONObject:<init>	()V
    //   375: astore 10
    //   377: aload_1
    //   378: ldc 52
    //   380: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   383: astore 11
    //   385: aload 11
    //   387: invokevirtual 304	org/json/JSONArray:length	()I
    //   390: istore 6
    //   392: iconst_0
    //   393: istore 4
    //   395: iload 4
    //   397: iload 6
    //   399: if_icmpge +170 -> 569
    //   402: aload 11
    //   404: iload 4
    //   406: invokevirtual 324	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   409: astore 13
    //   411: aload 13
    //   413: ldc_w 313
    //   416: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   419: astore 12
    //   421: aload 13
    //   423: ldc_w 380
    //   426: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   429: astore 13
    //   431: iconst_0
    //   432: istore 5
    //   434: aload 13
    //   436: invokevirtual 304	org/json/JSONArray:length	()I
    //   439: istore 7
    //   441: iload 5
    //   443: iload 7
    //   445: if_icmpge +115 -> 560
    //   448: aload 10
    //   450: aload 13
    //   452: iload 5
    //   454: invokevirtual 329	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   457: aload 12
    //   459: invokevirtual 384	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   462: pop
    //   463: iload 5
    //   465: iconst_1
    //   466: iadd
    //   467: istore 5
    //   469: goto -28 -> 441
    //   472: astore 8
    //   474: iconst_0
    //   475: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   478: astore 8
    //   480: goto -337 -> 143
    //   483: astore 8
    //   485: iconst_0
    //   486: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   489: astore 8
    //   491: goto -319 -> 172
    //   494: astore 8
    //   496: iconst_0
    //   497: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   500: astore 8
    //   502: goto -300 -> 202
    //   505: astore 8
    //   507: iconst_0
    //   508: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   511: astore 8
    //   513: goto -281 -> 232
    //   516: astore 8
    //   518: iconst_0
    //   519: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   522: astore 8
    //   524: goto -263 -> 261
    //   527: astore 8
    //   529: iconst_0
    //   530: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   533: astore 8
    //   535: goto -235 -> 300
    //   538: astore 8
    //   540: iconst_0
    //   541: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   544: astore 8
    //   546: goto -212 -> 334
    //   549: astore 8
    //   551: iconst_0
    //   552: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   555: astore 8
    //   557: goto -189 -> 368
    //   560: iload 4
    //   562: iconst_1
    //   563: iadd
    //   564: istore 4
    //   566: goto -171 -> 395
    //   569: aload_0
    //   570: aload 10
    //   572: putfield 400	com/tencent/biz/AuthorizeConfig:jdField_e_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   575: aload 9
    //   577: ldc 52
    //   579: aload 10
    //   581: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   584: invokeinterface 393 3 0
    //   589: pop
    //   590: aload_1
    //   591: ldc 55
    //   593: invokevirtual 303	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   596: astore_1
    //   597: aload_0
    //   598: aload_1
    //   599: putfield 402	com/tencent/biz/AuthorizeConfig:f	Lorg/json/JSONArray;
    //   602: aload 9
    //   604: ldc 55
    //   606: aload_1
    //   607: invokevirtual 394	org/json/JSONArray:toString	()Ljava/lang/String;
    //   610: invokeinterface 393 3 0
    //   615: pop
    //   616: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   619: ifeq +30 -> 649
    //   622: ldc 14
    //   624: iconst_2
    //   625: new 341	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 404
    //   635: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 8
    //   640: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: aload 8
    //   651: invokevirtual 267	java/lang/Boolean:booleanValue	()Z
    //   654: ifeq +122 -> 776
    //   657: iconst_2
    //   658: putstatic 100	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   661: aload 9
    //   663: ldc 31
    //   665: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   668: invokeinterface 417 4 0
    //   673: pop
    //   674: aload 9
    //   676: ldc 88
    //   678: ldc_w 419
    //   681: invokeinterface 393 3 0
    //   686: pop
    //   687: aload 9
    //   689: aload_3
    //   690: aload_2
    //   691: invokeinterface 393 3 0
    //   696: pop
    //   697: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +12 -> 712
    //   703: ldc 14
    //   705: iconst_2
    //   706: ldc_w 421
    //   709: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aconst_null
    //   713: ldc_w 423
    //   716: ldc_w 425
    //   719: ldc_w 427
    //   722: ldc_w 429
    //   725: ldc_w 431
    //   728: iconst_0
    //   729: iconst_1
    //   730: iconst_0
    //   731: ldc_w 427
    //   734: ldc_w 427
    //   737: ldc_w 427
    //   740: ldc_w 427
    //   743: invokestatic 436	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload 9
    //   748: invokeinterface 439 1 0
    //   753: pop
    //   754: return
    //   755: astore 8
    //   757: iconst_0
    //   758: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   761: astore 8
    //   763: goto -173 -> 590
    //   766: astore_1
    //   767: iconst_0
    //   768: invokestatic 275	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   771: astore 8
    //   773: goto -157 -> 616
    //   776: iconst_0
    //   777: putstatic 100	com/tencent/biz/AuthorizeConfig:jdField_b_of_type_Int	I
    //   780: aconst_null
    //   781: ldc_w 423
    //   784: ldc_w 425
    //   787: ldc_w 427
    //   790: ldc_w 429
    //   793: ldc_w 441
    //   796: iconst_0
    //   797: iconst_1
    //   798: iconst_0
    //   799: ldc_w 427
    //   802: ldc_w 427
    //   805: ldc_w 427
    //   808: ldc_w 427
    //   811: invokestatic 436	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   814: goto -68 -> 746
    //   817: iload 4
    //   819: iconst_1
    //   820: iadd
    //   821: istore 4
    //   823: goto -778 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	826	0	this	AuthorizeConfig
    //   0	826	1	paramJSONObject	JSONObject
    //   0	826	2	paramString1	String
    //   0	826	3	paramString2	String
    //   43	779	4	i1	int
    //   82	386	5	i2	int
    //   40	360	6	i3	int
    //   89	357	7	i4	int
    //   4	1	8	localBoolean1	Boolean
    //   472	1	8	localException1	java.lang.Exception
    //   478	1	8	localBoolean2	Boolean
    //   483	1	8	localJSONException1	JSONException
    //   489	1	8	localBoolean3	Boolean
    //   494	1	8	localJSONException2	JSONException
    //   500	1	8	localBoolean4	Boolean
    //   505	1	8	localJSONException3	JSONException
    //   511	1	8	localBoolean5	Boolean
    //   516	1	8	localJSONException4	JSONException
    //   522	1	8	localBoolean6	Boolean
    //   527	1	8	localJSONException5	JSONException
    //   533	1	8	localBoolean7	Boolean
    //   538	1	8	localJSONException6	JSONException
    //   544	1	8	localBoolean8	Boolean
    //   549	1	8	localJSONException7	JSONException
    //   555	95	8	localBoolean9	Boolean
    //   755	1	8	localException2	java.lang.Exception
    //   761	11	8	localBoolean10	Boolean
    //   15	732	9	localEditor	android.content.SharedPreferences.Editor
    //   24	556	10	localObject1	Object
    //   33	370	11	localJSONArray1	JSONArray
    //   69	389	12	localJSONArray2	JSONArray
    //   59	392	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	42	472	java/lang/Exception
    //   52	81	472	java/lang/Exception
    //   84	91	472	java/lang/Exception
    //   98	113	472	java/lang/Exception
    //   122	143	472	java/lang/Exception
    //   143	172	483	org/json/JSONException
    //   172	202	494	org/json/JSONException
    //   202	232	505	org/json/JSONException
    //   232	261	516	org/json/JSONException
    //   261	300	527	org/json/JSONException
    //   300	334	538	org/json/JSONException
    //   334	368	549	org/json/JSONException
    //   368	392	755	java/lang/Exception
    //   402	431	755	java/lang/Exception
    //   434	441	755	java/lang/Exception
    //   448	463	755	java/lang/Exception
    //   569	590	755	java/lang/Exception
    //   590	616	766	org/json/JSONException
  }
  
  public boolean a(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {}
    for (;;)
    {
      return false;
      paramString = Uri.parse(paramString).getHost();
      localObject = a();
      int i2 = ((JSONArray)localObject).length();
      int i1 = 0;
      while (i1 < i2)
      {
        if (b(((JSONArray)localObject).optString(i1), paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    paramString1 = Uri.parse(paramString1);
    Object localObject1 = paramString1.getScheme();
    if ("file".equals(localObject1)) {
      return true;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    String str = paramString1.getHost();
    paramString1 = this.jdField_a_of_type_OrgJsonJSONObject;
    localObject1 = paramString1;
    if (paramString1 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("cmdConfig", null);
      if (localObject1 == null) {
        break label160;
      }
    }
    label160:
    label206:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramString1 = (String)localObject1;
        if (paramString1 != null) {
          break label264;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mCmdConfig error");
        }
      }
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"InputClickEvent.onClickInputCtrl\",\"HtmlViewer.showHTML\"]}");
        paramString1 = (String)localObject1;
      }
      catch (JSONException localJSONException2)
      {
        continue;
        int i3 = paramString1.length();
        int i1 = 0;
        if (i1 >= i3) {
          break label262;
        }
        Object localObject2 = paramString1.optString(i1);
        if (b((String)localObject2, str)) {
          break label206;
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = localJSONException2.optJSONArray((String)localObject2);
          if (localObject2 != null)
          {
            int i4 = ((JSONArray)localObject2).length();
            int i2 = 0;
            while (i2 < i4)
            {
              if (b(((JSONArray)localObject2).optString(i2), paramString2)) {
                return true;
              }
              i2 += 1;
            }
          }
        }
        return false;
      }
      this.jdField_a_of_type_OrgJsonJSONObject = paramString1;
      localObject1 = paramString1;
      paramString1 = ((JSONObject)localObject1).names();
      if (paramString1 == null) {
        return false;
      }
    }
  }
  
  public String[] a()
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashSet(16);
      localObject2 = a();
      if (((JSONArray)localObject2).length() != 0) {
        break label96;
      }
      ((Set)localObject1).add("qq.com");
      localObject2 = b();
      if (((JSONArray)localObject2).length() != 0) {
        break label139;
      }
      ((Set)localObject1).add("qq.com");
    }
    for (;;)
    {
      localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      return localObject1;
      label96:
      int i2 = ((JSONArray)localObject2).length();
      int i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject1).add(b(((JSONArray)localObject2).optString(i1, ""), "*."));
        i1 += 1;
      }
      break;
      label139:
      i2 = ((JSONArray)localObject2).length();
      i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject1).add(((JSONArray)localObject2).optString(i1, ""));
        i1 += 1;
      }
    }
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  protected void b()
  {
    int i1 = 0;
    if (jdField_b_of_type_Int == 1) {
      return;
    }
    boolean bool;
    if (jdField_b_of_type_Int == -1)
    {
      bool = "com.tencent.minihd.qq".equals(MobileQQ.getMobileQQ().getProcessName());
      jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis() - jdField_a_of_type_Long;
      if ((l1 < 0L) || (l1 >= 86400000L)) {
        i1 = 1;
      }
      if ((!bool) && (i1 == 0)) {
        break;
      }
      jdField_b_of_type_Int = 1;
      ThreadManager.a(new cad(this));
      return;
      bool = false;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    JSONArray localJSONArray;
    int i2;
    int i1;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0)
      {
        localJSONArray = c();
        i2 = localJSONArray.length();
        i1 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < i2)
      {
        String str = localJSONArray.optString(i1);
        if ((paramString.equalsIgnoreCase(str)) || (paramString.endsWith("." + str))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public String[] b()
  {
    Object localObject2 = this.jdField_b_of_type_ArrayOfJavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashSet(16);
      localObject2 = c();
      if (((JSONArray)localObject2).length() != 0)
      {
        int i2 = ((JSONArray)localObject2).length();
        int i1 = 0;
        while (i1 < i2)
        {
          ((Set)localObject1).add(((JSONArray)localObject2).optString(i1, ""));
          i1 += 1;
        }
      }
      localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
    }
    return localObject1;
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
    return null;
  }
  
  public boolean c(String paramString)
  {
    if ((paramString == null) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {}
    for (;;)
    {
      return false;
      paramString = Util.c(paramString);
      if (paramString.length() > 0)
      {
        JSONArray localJSONArray = b();
        int i2 = localJSONArray.length();
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramString.equalsIgnoreCase(localJSONArray.optString(i1))) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (paramString1 == null) {
      localObject1 = "https://localhost/";
    }
    paramString1 = Uri.parse((String)localObject1);
    localObject1 = paramString1.getScheme();
    if ("file".equals(localObject1)) {
      return true;
    }
    if ((!"http".equals(localObject1)) && (!"https".equals(localObject1))) {
      return false;
    }
    String str = paramString1.getHost();
    paramString1 = this.jdField_e_of_type_OrgJsonJSONObject;
    localObject1 = paramString1;
    if (paramString1 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("schemes", null);
      if (localObject1 == null) {
        break label167;
      }
    }
    label167:
    label213:
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        paramString1 = (String)localObject1;
        if (paramString1 != null) {
          break label271;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
      }
      try
      {
        localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\"]}");
        paramString1 = (String)localObject1;
      }
      catch (JSONException localJSONException2)
      {
        continue;
        int i3 = paramString1.length();
        int i1 = 0;
        if (i1 >= i3) {
          break label269;
        }
        Object localObject2 = paramString1.optString(i1);
        if (b((String)localObject2, str)) {
          break label213;
        }
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = localJSONException2.optJSONArray((String)localObject2);
          if (localObject2 != null)
          {
            int i4 = ((JSONArray)localObject2).length();
            int i2 = 0;
            while (i2 < i4)
            {
              if (b(((JSONArray)localObject2).optString(i2), paramString2)) {
                return true;
              }
              i2 += 1;
            }
          }
        }
        return false;
      }
      this.jdField_e_of_type_OrgJsonJSONObject = paramString1;
      localObject1 = paramString1;
      paramString1 = ((JSONObject)localObject1).names();
      if (paramString1 == null) {
        return false;
      }
    }
  }
  
  public String[] c()
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfJavaLangString;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashSet(16);
      localObject2 = a();
      if (((JSONArray)localObject2).length() != 0) {
        break label73;
      }
      ((Set)localObject1).add("qq.com");
    }
    for (;;)
    {
      localObject1 = (String[])((Set)localObject1).toArray(new String[((Set)localObject1).size()]);
      this.jdField_c_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      return localObject1;
      label73:
      int i2 = ((JSONArray)localObject2).length();
      int i1 = 0;
      while (i1 < i2)
      {
        ((Set)localObject1).add(b(((JSONArray)localObject2).optString(i1, ""), "*."));
        i1 += 1;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    String str1 = Uri.parse(paramString).getHost();
    localObject = this.f;
    paramString = (String)localObject;
    String str2;
    if (localObject == null)
    {
      str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("a1", null);
      paramString = (String)localObject;
      if (str2 == null) {}
    }
    try
    {
      paramString = new JSONArray(str2);
      localObject = paramString;
      if (paramString == null) {
        localObject = new JSONArray();
      }
      this.f = ((JSONArray)localObject);
      paramString = (String)localObject;
      int i2 = paramString.length();
      i1 = 0;
      if (i1 < i2) {
        if (b(paramString.optString(i1), str1)) {
          return true;
        }
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        int i1;
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mA1Config error");
          paramString = (String)localObject;
          continue;
          i1 += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig
 * JD-Core Version:    0.7.0.1
 */