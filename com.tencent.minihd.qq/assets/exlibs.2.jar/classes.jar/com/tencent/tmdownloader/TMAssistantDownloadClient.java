package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistant.common.b;
import com.tencent.tmassistant.common.c;
import com.tencent.tmassistantbase.a.k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TMAssistantDownloadClient
  extends b
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue mListenerReferenceQueue;
  protected ArrayList mWeakListenerArrayList;
  
  public TMAssistantDownloadClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
    k.c("TMAssistantDownloadSDKClient", "enter");
    k.c("TMAssistantDownloadSDKClient", "context: " + paramContext + "; clientKey: " + paramString);
    this.mListenerReferenceQueue = new ReferenceQueue();
    this.mWeakListenerArrayList = new ArrayList();
    this.mServiceCallback = new a(this);
    k.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      k.c("TMAssistantDownloadSDKClient", "enter");
      k.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        k.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.c(this.mClientKey, paramString);
      k.c("TMAssistantDownloadSDKClient", "cancelDownloadTask");
    }
    for (;;)
    {
      k.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      k.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      k.c("TMAssistantDownloadSDKClient", "enter");
      k.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        k.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      paramString = locald.a(this.mClientKey, paramString);
      k.c("TMAssistantDownloadSDKClient", "returnValue(taskInfo): " + paramString);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      k.c("TMAssistantDownloadSDKClient", "returnValue: null");
      k.c("TMAssistantDownloadSDKClient", "exit");
      paramString = null;
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    k.c("TMAssistantDownloadSDKClient", "enter");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)((WeakReference)localIterator.next()).get();
      c.a().a(this, localITMAssistantDownloadClientListener);
    }
    k.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      k.c("TMAssistantDownloadSDKClient", "enter");
      k.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        k.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.b(this.mClientKey, paramString);
      k.c("TMAssistantDownloadSDKClient", "pauseDownloadTask");
    }
    for (;;)
    {
      k.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      k.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        k.c("TMAssistantDownloadSDKClient", "enter");
        if (paramITMAssistantDownloadClientListener == null)
        {
          k.c("TMAssistantDownloadSDKClient", "listener == null");
          k.c("TMAssistantDownloadSDKClient", "returnValue: false");
          k.c("TMAssistantDownloadSDKClient", "exit");
          bool = false;
          return bool;
        }
        localObject = this.mListenerReferenceQueue.poll();
        if (localObject != null)
        {
          k.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
          continue;
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadClientListener)
          {
            k.c("TMAssistantDownloadSDKClient", "returnValue: true");
            k.c("TMAssistantDownloadSDKClient", "exit");
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadClientListener = new WeakReference(paramITMAssistantDownloadClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadClientListener);
      k.c("TMAssistantDownloadSDKClient", "returnValue: true");
      k.c("TMAssistantDownloadSDKClient", "exit");
      boolean bool = true;
    }
  }
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, int paramInt, String paramString2, String paramString3, Map paramMap)
  {
    for (;;)
    {
      try
      {
        k.c("TMAssistantDownloadSDKClient", "enter");
        k.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString1 + "; priority: " + paramInt + "; contentType: " + paramString2 + "; fileName = " + paramString3);
        if (paramMap != null)
        {
          k.c("TMAssistantDownloadSDKClient", "params.size: " + paramMap.size());
          if (paramString1 != null) {
            break;
          }
          k.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
          throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
      }
      finally {}
      k.c("TMAssistantDownloadSDKClient", "params: null");
    }
    if ((paramString2.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString3)))
    {
      k.e("TMAssistantDownloadSDKClient", "exception: if contentType is others, filename shouldn't be null!");
      throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
    }
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      k.c("TMAssistantDownloadSDKClient", "startDownloadTask");
      paramInt = locald.a(this.mClientKey, paramString1, 0, paramString2, paramString3, paramMap);
      k.c("TMAssistantDownloadSDKClient", "returnValue: " + paramInt);
      k.c("TMAssistantDownloadSDKClient", "exit");
    }
    for (;;)
    {
      return paramInt;
      super.initTMAssistantDownloadSDK();
      k.c("TMAssistantDownloadSDKClient", "super.initTMAssistantDownloadSDK");
      k.c("TMAssistantDownloadSDKClient", "returnValue: 0");
      k.c("TMAssistantDownloadSDKClient", "exit");
      paramInt = 0;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      k.c("TMAssistantDownloadSDKClient", "enter");
      k.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2);
      int i = startDownloadTask(paramString1, 0, paramString2, null, null);
      k.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      k.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      k.c("TMAssistantDownloadSDKClient", "enter");
      k.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2 + "; fileName: " + paramString3);
      int i = startDownloadTask(paramString1, 0, paramString2, paramString3, null);
      k.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      k.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public int startDownloadTask(String paramString1, String paramString2, Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 22
    //   6: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 11
    //   11: new 30	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   18: ldc 255
    //   20: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 213
    //   29: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_3
    //   43: ifnull +80 -> 123
    //   46: ldc 11
    //   48: new 30	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   55: ldc 217
    //   57: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokeinterface 223 1 0
    //   66: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: aload_1
    //   77: iconst_0
    //   78: aload_2
    //   79: aconst_null
    //   80: aload_3
    //   81: invokevirtual 257	com/tencent/tmdownloader/TMAssistantDownloadClient:startDownloadTask	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)I
    //   84: istore 4
    //   86: ldc 11
    //   88: new 30	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   95: ldc 248
    //   97: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 4
    //   102: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 11
    //   113: ldc 69
    //   115: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: monitorexit
    //   120: iload 4
    //   122: ireturn
    //   123: ldc 11
    //   125: ldc 225
    //   127: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -55 -> 75
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	TMAssistantDownloadClient
    //   0	138	1	paramString1	String
    //   0	138	2	paramString2	String
    //   0	138	3	paramMap	Map
    //   84	37	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	42	133	finally
    //   46	75	133	finally
    //   75	118	133	finally
    //   123	130	133	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  /* Error */
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 22
    //   6: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnonnull +30 -> 40
    //   13: ldc 11
    //   15: ldc 175
    //   17: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: ldc 11
    //   22: ldc 177
    //   24: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: ldc 11
    //   29: ldc 69
    //   31: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iconst_0
    //   35: istore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 58	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   44: invokevirtual 142	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 147 1 0
    //   54: ifeq +55 -> 109
    //   57: aload_3
    //   58: invokeinterface 151 1 0
    //   63: checkcast 153	java/lang/ref/WeakReference
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   73: checkcast 158	com/tencent/tmdownloader/ITMAssistantDownloadClientListener
    //   76: aload_1
    //   77: if_acmpne -29 -> 48
    //   80: aload_0
    //   81: getfield 58	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   84: aload 4
    //   86: invokevirtual 187	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: ldc 11
    //   92: ldc 189
    //   94: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc 11
    //   99: ldc 69
    //   101: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: iconst_1
    //   105: istore_2
    //   106: goto -70 -> 36
    //   109: ldc 11
    //   111: ldc 177
    //   113: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: ldc 11
    //   118: ldc 69
    //   120: invokestatic 28	com/tencent/tmassistantbase/a/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -89 -> 36
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	TMAssistantDownloadClient
    //   0	133	1	paramITMAssistantDownloadClientListener	ITMAssistantDownloadClientListener
    //   35	90	2	bool	boolean
    //   47	11	3	localIterator	Iterator
    //   66	19	4	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   2	9	128	finally
    //   13	34	128	finally
    //   40	48	128	finally
    //   48	104	128	finally
    //   109	123	128	finally
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadClient
 * JD-Core Version:    0.7.0.1
 */