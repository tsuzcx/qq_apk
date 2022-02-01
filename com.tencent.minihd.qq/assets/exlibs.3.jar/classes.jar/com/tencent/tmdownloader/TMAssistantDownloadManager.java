package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.a.k;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadManager
{
  protected static final String TAG = "TMAssistantDownloadManager";
  protected static TMAssistantDownloadManager mInstance = null;
  protected static ArrayList mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void closeAllService(Context paramContext)
  {
    for (;;)
    {
      try
      {
        k.c("TMAssistantDownloadManager", "enter");
        if (paramContext == null)
        {
          k.c("TMAssistantDownloadManager", "you must input an application or activity context!");
          k.c("TMAssistantDownloadManager", "exit");
          return;
        }
        if (mInstance == null)
        {
          k.c("TMAssistantDownloadManager", "manager minstance == null");
          k.c("TMAssistantDownloadManager", "exit");
          continue;
        }
        if (mSDKClientList == null) {
          break label126;
        }
      }
      finally {}
      if (mSDKClientList.size() > 0)
      {
        k.c("TMAssistantDownloadManager", "mSDKClientList != null && mSDKClientList.size() > 0");
        Iterator localIterator = mSDKClientList.iterator();
        while (localIterator.hasNext())
        {
          TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient != null) {
            localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
          }
        }
        mSDKClientList.clear();
      }
      label126:
      MobileQQCloseServiceReceiver.a().b(paramContext);
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      mInstance = null;
      k.c("TMAssistantDownloadManager", "exit");
    }
  }
  
  public static TMAssistantDownloadManager getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new TMAssistantDownloadManager(paramContext);
        MobileQQCloseServiceReceiver.a().a(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public TMAssistantDownloadClient getDownloadSDKClient(String paramString)
  {
    for (;;)
    {
      try
      {
        k.c("TMAssistantDownloadManager", "enter");
        if ((paramString == null) || (paramString.length() <= 0))
        {
          k.c("TMAssistantDownloadManager", "clientKey == null || clientKey.length() <= 0");
          k.c("TMAssistantDownloadManager", "exit");
          paramString = null;
          return paramString;
        }
        k.c("TMAssistantDownloadManager", "clientKey: " + paramString);
        Iterator localIterator = mSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient.mClientKey.equals(paramString) != true) {
            continue;
          }
          k.c("TMAssistantDownloadManager", "SDKClient exists");
          k.c("TMAssistantDownloadManager", "returnValue(clientItem): " + localTMAssistantDownloadClient);
          k.c("TMAssistantDownloadManager", "exit");
          paramString = localTMAssistantDownloadClient;
          continue;
        }
        paramString = new TMAssistantDownloadClient(this.mContext, paramString);
      }
      finally {}
      paramString.initTMAssistantDownloadSDK();
      mSDKClientList.add(paramString);
      k.c("TMAssistantDownloadManager", "add new SDKClient");
      k.c("TMAssistantDownloadManager", "returnValue(client): " + paramString);
      k.c("TMAssistantDownloadManager", "exit");
    }
  }
  
  public TMAssistantDownloadSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      k.c("TMAssistantDownloadManager", "enter");
      if (mSDKSettingClient == null)
      {
        k.c("TMAssistantDownloadManager", "mSDKSettingClient is null create a new for TMAssistantDownloadSettingClient");
        mSDKSettingClient = new TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient.initTMAssistantDownloadSDK();
      }
      k.c("TMAssistantDownloadManager", "returnValue(settingclient): " + mSDKSettingClient);
      k.c("TMAssistantDownloadManager", "exit");
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = mSDKSettingClient;
      return localTMAssistantDownloadSettingClient;
    }
    finally {}
  }
  
  /* Error */
  public boolean releaseDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: ldc 37
    //   6: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 8
    //   11: new 106	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   18: ldc 158
    //   20: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 27	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKClientList	Ljava/util/ArrayList;
    //   36: invokevirtual 59	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 65 1 0
    //   46: ifeq +87 -> 133
    //   49: aload_3
    //   50: invokeinterface 69 1 0
    //   55: checkcast 71	com/tencent/tmdownloader/TMAssistantDownloadClient
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull -22 -> 40
    //   65: aload 4
    //   67: getfield 120	com/tencent/tmdownloader/TMAssistantDownloadClient:mClientKey	Ljava/lang/String;
    //   70: aload_1
    //   71: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: iconst_1
    //   75: if_icmpne -35 -> 40
    //   78: aload 4
    //   80: invokevirtual 74	com/tencent/tmdownloader/TMAssistantDownloadClient:unInitTMAssistantDownloadSDK	()V
    //   83: aload_3
    //   84: invokeinterface 161 1 0
    //   89: ldc 8
    //   91: ldc 163
    //   93: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 8
    //   98: new 106	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   105: ldc 165
    //   107: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iconst_1
    //   111: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: ldc 8
    //   122: ldc 47
    //   124: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: iconst_1
    //   128: istore_2
    //   129: aload_0
    //   130: monitorexit
    //   131: iload_2
    //   132: ireturn
    //   133: getstatic 29	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   136: ifnull +70 -> 206
    //   139: getstatic 29	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   142: getfield 169	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:mClientKey	Ljava/lang/String;
    //   145: aload_1
    //   146: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: iconst_1
    //   150: if_icmpne +56 -> 206
    //   153: getstatic 29	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   156: invokevirtual 89	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:unInitTMAssistantDownloadSDK	()V
    //   159: aconst_null
    //   160: putstatic 29	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   163: ldc 8
    //   165: ldc 171
    //   167: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: ldc 8
    //   172: new 106	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   179: ldc 165
    //   181: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: iconst_1
    //   185: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   188: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: ldc 8
    //   196: ldc 47
    //   198: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: iconst_1
    //   202: istore_2
    //   203: goto -74 -> 129
    //   206: ldc 8
    //   208: new 106	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   215: ldc 173
    //   217: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: ldc 8
    //   232: new 106	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   239: ldc 165
    //   241: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iconst_0
    //   245: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   248: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: ldc 8
    //   256: ldc 47
    //   258: invokestatic 43	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: iconst_0
    //   262: istore_2
    //   263: goto -134 -> 129
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	TMAssistantDownloadManager
    //   0	271	1	paramString	String
    //   128	135	2	bool	boolean
    //   39	45	3	localIterator	Iterator
    //   58	21	4	localTMAssistantDownloadClient	TMAssistantDownloadClient
    // Exception table:
    //   from	to	target	type
    //   2	40	266	finally
    //   40	60	266	finally
    //   65	127	266	finally
    //   133	201	266	finally
    //   206	261	266	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadManager
 * JD-Core Version:    0.7.0.1
 */