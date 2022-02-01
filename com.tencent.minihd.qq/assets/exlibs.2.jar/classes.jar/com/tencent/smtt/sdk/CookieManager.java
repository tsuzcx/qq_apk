package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager
{
  public static String LOGTAG = "CookieManager";
  private static CookieManager d;
  CopyOnWriteArrayList<b> a;
  String b;
  a c = a.a;
  private boolean e = false;
  private boolean f = false;
  
  public static CookieManager getInstance()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new CookieManager();
      }
      return d;
    }
    finally {}
  }
  
  public static int getROMCookieDBVersion(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0)) {
      return paramContext.getInt("db_version", -1);
    }
  }
  
  public static void setROMCookieDBVersion(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramContext = paramContext.getSharedPreferences("cookiedb_info", 4);; paramContext = paramContext.getSharedPreferences("cookiedb_info", 0))
    {
      paramContext = paramContext.edit();
      paramContext.putInt("db_version", paramInt);
      paramContext.commit();
      return;
    }
  }
  
  void a()
  {
    label26:
    label52:
    Object localObject3;
    for (;;)
    {
      try
      {
        this.f = true;
        if (this.a != null)
        {
          int i = this.a.size();
          if (i != 0) {}
        }
        else
        {
          return;
        }
        Object localObject1 = x.a();
        if ((localObject1 == null) || (!((x)localObject1).b())) {
          break;
        }
        localObject1 = this.a.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label292;
        }
        localObject3 = (b)((Iterator)localObject1).next();
        switch (((b)localObject3).a)
        {
        case 1: 
          setCookie(((b)localObject3).b, ((b)localObject3).c, ((b)localObject3).d);
          break;
        case 2: 
          setCookie(((b)localObject3).b, ((b)localObject3).c);
        }
      }
      finally {}
    }
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      Object localObject4;
      if (localIterator.hasNext()) {
        localObject4 = (b)localIterator.next();
      }
      switch (((b)localObject4).a)
      {
      case 1: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject3 = android.webkit.CookieManager.getInstance();
          String str1 = ((b)localObject4).b;
          String str2 = ((b)localObject4).c;
          localObject4 = ((b)localObject4).d;
          i.a(localObject3, "setCookie", new Class[] { String.class, String.class, android.webkit.ValueCallback.class }, new Object[] { str1, str2, localObject4 });
        }
        break;
      case 2: 
        android.webkit.CookieManager.getInstance().setCookie(((b)localObject4).b, ((b)localObject4).c);
        continue;
        label292:
        this.a.clear();
        break label26;
        break label52;
      }
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    int j = 0;
    for (;;)
    {
      boolean bool;
      long l2;
      long l1;
      label121:
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      label261:
      try
      {
        if ((this.c != a.a) && (paramContext != null) && (TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt")))
        {
          bool = this.e;
          if (!bool) {}
        }
        else
        {
          return;
        }
        l2 = System.currentTimeMillis();
        l1 = 0L;
        TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + paramBoolean1 + ",useX5:" + paramBoolean2);
        if ((!paramBoolean1) && (!QbSdk.getIsSysWebViewForcedByOuter()) && (!QbSdk.a)) {
          break label473;
        }
        if ((QbSdk.getIsSysWebViewForcedByOuter()) || (QbSdk.a)) {
          break label501;
        }
        bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "usex5.txt");
        TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + bool + ",useX5:" + paramBoolean2);
        TbsExtensionFunctionManager.getInstance().setFunctionEnable(paramContext, "usex5.txt", paramBoolean2);
        if (bool == paramBoolean2) {
          continue;
        }
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        if (TextUtils.isEmpty(this.b)) {
          break label459;
        }
        if ((p.a().j(paramContext) > 0) && (p.a().j(paramContext) < 36001)) {
          continue;
        }
        if (!bool) {
          break label344;
        }
        i = k.d(paramContext);
        j = i;
        if (i <= 0) {
          break label483;
        }
        j = getROMCookieDBVersion(paramContext);
        if (j > 0) {
          break label496;
        }
        paramBoolean1 = true;
      }
      finally {}
      localTbsLogInfo.setErrorCode(702);
      label269:
      localTbsLogInfo.setFailDetail("x5->sys:" + bool + " from:" + i + " to:" + j + ",timeused:" + l1);
      TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, localTbsLogInfo);
      continue;
      label344:
      int i = k.d(paramContext);
      j = i;
      if (i > 0)
      {
        String str = p.a().d(paramContext, "cookies_database_version");
        paramBoolean1 = TextUtils.isEmpty(str);
        j = i;
        if (!paramBoolean1) {
          try
          {
            j = Integer.parseInt(str);
            paramBoolean1 = false;
          }
          catch (Exception localException)
          {
            paramBoolean1 = false;
            j = k;
          }
        }
      }
      label459:
      label473:
      label483:
      label496:
      label501:
      do
      {
        do
        {
          if (j >= i)
          {
            localTbsLogInfo.setErrorCode(703);
            break label269;
          }
          k.a(paramContext, this.c, this.b, paramBoolean1, paramBoolean2);
          localTbsLogInfo.setErrorCode(704);
          l1 = System.currentTimeMillis() - l2;
          break label269;
          localTbsLogInfo.setErrorCode(701);
          i = 0;
          break label269;
          x.a().a(paramContext);
          break;
          i = j;
          paramBoolean1 = false;
          j = k;
          continue;
          paramBoolean1 = false;
          continue;
          paramBoolean2 = false;
          break label121;
        } while (paramBoolean1);
        if (i <= 0) {
          break label261;
        }
      } while (j > 0);
    }
  }
  
  public boolean acceptCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().d();
    }
    return android.webkit.CookieManager.getInstance().acceptCookie();
  }
  
  /* Error */
  public boolean acceptThirdPartyCookies(WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +72 -> 79
    //   10: aload_3
    //   11: invokevirtual 99	com/tencent/smtt/sdk/x:b	()Z
    //   14: ifeq +65 -> 79
    //   17: aload_3
    //   18: invokevirtual 293	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   21: invokevirtual 304	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: aload_1
    //   26: invokevirtual 310	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   29: astore_1
    //   30: aload_3
    //   31: ldc_w 312
    //   34: ldc_w 314
    //   37: iconst_1
    //   38: anewarray 136	java/lang/Class
    //   41: dup
    //   42: iconst_0
    //   43: ldc 4
    //   45: aastore
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_1
    //   53: aastore
    //   54: invokevirtual 320	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +15 -> 74
    //   62: aload_1
    //   63: checkcast 322	java/lang/Boolean
    //   66: invokevirtual 325	java/lang/Boolean:booleanValue	()Z
    //   69: istore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: iconst_1
    //   75: istore_2
    //   76: goto -6 -> 70
    //   79: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   82: bipush 21
    //   84: if_icmpge +8 -> 92
    //   87: iconst_1
    //   88: istore_2
    //   89: goto -19 -> 70
    //   92: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   95: astore_3
    //   96: aload_1
    //   97: invokevirtual 310	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   100: astore_1
    //   101: aload_3
    //   102: ldc_w 326
    //   105: iconst_1
    //   106: anewarray 136	java/lang/Class
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 328
    //   114: aastore
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: aastore
    //   123: invokestatic 145	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +14 -> 142
    //   131: aload_1
    //   132: checkcast 322	java/lang/Boolean
    //   135: invokevirtual 325	java/lang/Boolean:booleanValue	()Z
    //   138: istore_2
    //   139: goto -69 -> 70
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -74 -> 70
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	CookieManager
    //   0	152	1	paramWebView	WebView
    //   69	75	2	bool	boolean
    //   5	97	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	147	finally
    //   10	58	147	finally
    //   62	70	147	finally
    //   79	87	147	finally
    //   92	127	147	finally
    //   131	139	147	finally
  }
  
  public void flush()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
  }
  
  public String getCookie(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().a(paramString);
    }
    try
    {
      paramString = android.webkit.CookieManager.getInstance().getCookie(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean hasCookies()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return localx.c().h();
    }
    return android.webkit.CookieManager.getInstance().hasCookies();
  }
  
  @Deprecated
  public void removeAllCookie()
  {
    if (this.a != null) {
      this.a.clear();
    }
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().e();
      return;
    }
    android.webkit.CookieManager.getInstance().removeAllCookie();
  }
  
  public void removeAllCookies(ValueCallback<Boolean> paramValueCallback)
  {
    if (this.a != null) {
      this.a.clear();
    }
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  @Deprecated
  public void removeExpiredCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeExpiredCookie();
  }
  
  @Deprecated
  public void removeSessionCookie()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
      return;
    }
    android.webkit.CookieManager.getInstance().removeSessionCookie();
  }
  
  public void removeSessionCookies(ValueCallback<Boolean> paramValueCallback)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    i.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[] { android.webkit.ValueCallback.class }, new Object[] { paramValueCallback });
  }
  
  /* Error */
  public void setAcceptCookie(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +51 -> 58
    //   10: aload_2
    //   11: invokevirtual 99	com/tencent/smtt/sdk/x:b	()Z
    //   14: ifeq +44 -> 58
    //   17: aload_2
    //   18: invokevirtual 293	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   21: invokevirtual 304	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: ldc_w 312
    //   27: ldc_w 381
    //   30: iconst_1
    //   31: anewarray 136	java/lang/Class
    //   34: dup
    //   35: iconst_0
    //   36: getstatic 385	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   39: aastore
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_1
    //   47: invokestatic 389	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: aastore
    //   51: invokevirtual 320	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   61: iload_1
    //   62: invokevirtual 391	android/webkit/CookieManager:setAcceptCookie	(Z)V
    //   65: goto -10 -> 55
    //   68: astore_2
    //   69: aload_2
    //   70: invokevirtual 343	java/lang/Throwable:printStackTrace	()V
    //   73: goto -18 -> 55
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	CookieManager
    //   0	81	1	paramBoolean	boolean
    //   5	13	2	localx	x
    //   68	2	2	localThrowable	Throwable
    //   76	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   58	65	68	java/lang/Throwable
    //   2	6	76	finally
    //   10	55	76	finally
    //   58	65	76	finally
    //   69	73	76	finally
  }
  
  /* Error */
  public void setAcceptThirdPartyCookies(WebView paramWebView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   5: astore_3
    //   6: aload_3
    //   7: ifnull +71 -> 78
    //   10: aload_3
    //   11: invokevirtual 99	com/tencent/smtt/sdk/x:b	()Z
    //   14: ifeq +64 -> 78
    //   17: aload_3
    //   18: invokevirtual 293	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   21: invokevirtual 304	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   24: astore_3
    //   25: getstatic 385	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   28: astore 4
    //   30: aload_1
    //   31: invokevirtual 310	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   34: astore_1
    //   35: aload_3
    //   36: ldc_w 312
    //   39: ldc_w 395
    //   42: iconst_2
    //   43: anewarray 136	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: ldc 4
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload 4
    //   55: aastore
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: iload_2
    //   67: invokestatic 389	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: invokevirtual 320	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 21
    //   83: if_icmplt -8 -> 75
    //   86: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   89: astore_3
    //   90: getstatic 385	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   93: astore 4
    //   95: aload_1
    //   96: invokevirtual 310	com/tencent/smtt/sdk/WebView:getView	()Landroid/view/View;
    //   99: astore_1
    //   100: aload_3
    //   101: ldc_w 396
    //   104: iconst_2
    //   105: anewarray 136	java/lang/Class
    //   108: dup
    //   109: iconst_0
    //   110: ldc_w 328
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 4
    //   118: aastore
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: iload_2
    //   130: invokestatic 389	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   133: aastore
    //   134: invokestatic 145	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: goto -63 -> 75
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	CookieManager
    //   0	146	1	paramWebView	WebView
    //   0	146	2	paramBoolean	boolean
    //   5	96	3	localObject	Object
    //   28	89	4	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   2	6	141	finally
    //   10	75	141	finally
    //   78	138	141	finally
  }
  
  public void setCookie(String paramString1, String paramString2)
  {
    try
    {
      setCookie(paramString1, paramString2, false);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +67 -> 76
    //   12: aload 4
    //   14: invokevirtual 99	com/tencent/smtt/sdk/x:b	()Z
    //   17: ifeq +59 -> 76
    //   20: aload 4
    //   22: invokevirtual 293	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   25: invokevirtual 304	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc_w 312
    //   31: ldc_w 401
    //   34: iconst_3
    //   35: anewarray 136	java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc 138
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc 138
    //   47: aastore
    //   48: dup
    //   49: iconst_2
    //   50: ldc 140
    //   52: aastore
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: dup
    //   66: iconst_2
    //   67: aload_3
    //   68: aastore
    //   69: invokevirtual 320	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   79: invokevirtual 402	com/tencent/smtt/sdk/x:d	()Z
    //   82: ifne +65 -> 147
    //   85: new 9	com/tencent/smtt/sdk/CookieManager$b
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 405	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   93: astore 4
    //   95: aload 4
    //   97: iconst_1
    //   98: putfield 114	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   101: aload 4
    //   103: aload_1
    //   104: putfield 116	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   107: aload 4
    //   109: aload_2
    //   110: putfield 118	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   113: aload 4
    //   115: aload_3
    //   116: putfield 121	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   119: aload_0
    //   120: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   123: ifnonnull +14 -> 137
    //   126: aload_0
    //   127: new 88	java/util/concurrent/CopyOnWriteArrayList
    //   130: dup
    //   131: invokespecial 406	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   134: putfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   137: aload_0
    //   138: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   141: aload 4
    //   143: invokevirtual 410	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   146: pop
    //   147: aload_0
    //   148: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   151: ifeq -78 -> 73
    //   154: getstatic 52	android/os/Build$VERSION:SDK_INT	I
    //   157: bipush 21
    //   159: if_icmplt -86 -> 73
    //   162: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   165: ldc 134
    //   167: iconst_3
    //   168: anewarray 136	java/lang/Class
    //   171: dup
    //   172: iconst_0
    //   173: ldc 138
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: ldc 138
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: ldc 140
    //   185: aastore
    //   186: iconst_3
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: aastore
    //   194: dup
    //   195: iconst_1
    //   196: aload_2
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: aload_3
    //   201: aastore
    //   202: invokestatic 145	com/tencent/smtt/utils/i:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: goto -133 -> 73
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	CookieManager
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   0	214	3	paramValueCallback	ValueCallback<Boolean>
    //   5	137	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	209	finally
    //   12	73	209	finally
    //   76	137	209	finally
    //   137	147	209	finally
    //   147	206	209	finally
  }
  
  /* Error */
  public void setCookie(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +58 -> 67
    //   12: aload 4
    //   14: invokevirtual 99	com/tencent/smtt/sdk/x:b	()Z
    //   17: ifeq +50 -> 67
    //   20: aload 4
    //   22: invokevirtual 293	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   25: invokevirtual 304	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   28: ldc_w 312
    //   31: ldc_w 401
    //   34: iconst_2
    //   35: anewarray 136	java/lang/Class
    //   38: dup
    //   39: iconst_0
    //   40: ldc 138
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: ldc 138
    //   47: aastore
    //   48: iconst_2
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: invokevirtual 320	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 39	com/tencent/smtt/sdk/CookieManager:f	Z
    //   71: ifne +7 -> 78
    //   74: iload_3
    //   75: ifeq +11 -> 86
    //   78: invokestatic 133	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 146	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: invokestatic 97	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   89: invokevirtual 402	com/tencent/smtt/sdk/x:d	()Z
    //   92: ifne -28 -> 64
    //   95: new 9	com/tencent/smtt/sdk/CookieManager$b
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 405	com/tencent/smtt/sdk/CookieManager$b:<init>	(Lcom/tencent/smtt/sdk/CookieManager;)V
    //   103: astore 4
    //   105: aload 4
    //   107: iconst_2
    //   108: putfield 114	com/tencent/smtt/sdk/CookieManager$b:a	I
    //   111: aload 4
    //   113: aload_1
    //   114: putfield 116	com/tencent/smtt/sdk/CookieManager$b:b	Ljava/lang/String;
    //   117: aload 4
    //   119: aload_2
    //   120: putfield 118	com/tencent/smtt/sdk/CookieManager$b:c	Ljava/lang/String;
    //   123: aload 4
    //   125: aconst_null
    //   126: putfield 121	com/tencent/smtt/sdk/CookieManager$b:d	Lcom/tencent/smtt/sdk/ValueCallback;
    //   129: aload_0
    //   130: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   133: ifnonnull +14 -> 147
    //   136: aload_0
    //   137: new 88	java/util/concurrent/CopyOnWriteArrayList
    //   140: dup
    //   141: invokespecial 406	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   144: putfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   147: aload_0
    //   148: getfield 86	com/tencent/smtt/sdk/CookieManager:a	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   151: aload 4
    //   153: invokevirtual 410	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   156: pop
    //   157: goto -93 -> 64
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	CookieManager
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   0	165	3	paramBoolean	boolean
    //   5	147	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	160	finally
    //   12	64	160	finally
    //   67	74	160	finally
    //   78	86	160	finally
    //   86	147	160	finally
    //   147	157	160	finally
  }
  
  public boolean setCookieCompatialbeMode(Context paramContext, a parama, String paramString, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramContext == null) || (!TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "cookie_switch.txt"))) {
      return false;
    }
    this.c = parama;
    if (paramString != null) {
      this.b = paramString;
    }
    if ((this.c != a.a) && (paramBoolean) && (!x.a().d())) {
      x.a().a(paramContext);
    }
    return true;
  }
  
  public void setCookies(Map<String, String[]> paramMap)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {}
    for (boolean bool = ((x)localObject).c().a(paramMap);; bool = false)
    {
      if (!bool)
      {
        localObject = paramMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          String[] arrayOfString = (String[])paramMap.get(str);
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            setCookie(str, arrayOfString[i]);
            i += 1;
          }
        }
      }
      return;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  class b
  {
    int a;
    String b;
    String c;
    ValueCallback<Boolean> d;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieManager
 * JD-Core Version:    0.7.0.1
 */