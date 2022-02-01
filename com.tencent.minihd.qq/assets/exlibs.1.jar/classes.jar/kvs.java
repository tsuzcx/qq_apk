import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloadTask.ReportInfo;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public final class kvs
  implements INetInfoHandler, DownloaderInterface
{
  public static final String a;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected AppInterface a;
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig;
  Runnable jdField_a_of_type_JavaLangRunnable = new kvt(this);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = kvs.class.getSimpleName();
  }
  
  public kvs(AppInterface paramAppInterface, DownloaderFactory.DownloadConfig paramDownloadConfig)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    DownloaderFactory.DownloadConfig localDownloadConfig = paramDownloadConfig;
    if (paramDownloadConfig == null) {
      localDownloadConfig = new DownloaderFactory.DownloadConfig();
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = localDownloadConfig;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext().getMainLooper());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig.jdField_a_of_type_Boolean) {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppInterface.getApplication(), this);
    }
  }
  
  private DownloadTask a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (!localDownloadTask.a())
          {
            localDownloadTask.a();
            return localDownloadTask;
          }
        }
      }
      return null;
    }
  }
  
  public int a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelTask stopAll=" + paramBoolean + ",key=" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label107;
      }
      if (!paramBoolean) {
        break label111;
      }
      paramString = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      if (paramString.hasNext()) {
        ((DownloadTask)paramString.next()).a(true);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    for (;;)
    {
      label107:
      return 0;
      label111:
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
        if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
        {
          if (!localDownloadTask.a())
          {
            localIterator.remove();
            this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
          }
          else
          {
            localDownloadTask.a(true);
          }
        }
        else if ((localDownloadTask.b()) && (!localDownloadTask.a()))
        {
          localIterator.remove();
          this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
        }
      }
    }
    return -1;
  }
  
  public DownloadTask a(String paramString)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramString != null) {}
    try
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (paramString.equals(localDownloadTask.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task find =" + localDownloadTask);
            }
            return localDownloadTask;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getTask | " + paramString + " task not find");
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      b();
    }
    a(true, null);
  }
  
  public void a(DownloadTask paramDownloadTask)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    if (paramDownloadTask != null) {}
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramDownloadTask)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "removeTask | task=" + paramDownloadTask);
        }
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramDownloadTask);
      }
      return;
    }
    finally {}
  }
  
  public void a(DownloadTask arg1, DownloadListener arg2, Bundle paramBundle)
  {
    if ((!DownloaderFactory.a(???)) || (a(???.jdField_a_of_type_JavaLangString) != null)) {
      return;
    }
    ???.a(???);
    ???.a(paramBundle);
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (???.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a < 0L)) {
      ???.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (a(???.jdField_a_of_type_JavaLangString) == null)
        {
          ???.c = ((int)(System.currentTimeMillis() / 1000L));
          if (???.b) {
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(???);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload | task=" + ???.jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_Boolean)) {}
        }
      }
      synchronized (this.jdField_a_of_type_AndroidOsHandler)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        }
        c();
        return;
        this.jdField_a_of_type_JavaUtilLinkedList.addLast(???);
        continue;
        ??? = finally;
        throw ???;
      }
    }
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: getstatic 27	kvs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11: iconst_2
    //   12: ldc_w 259
    //   15: invokestatic 262	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: getfield 55	kvs:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   22: invokevirtual 100	java/util/LinkedList:isEmpty	()Z
    //   25: ifne +182 -> 207
    //   28: invokestatic 235	java/lang/System:currentTimeMillis	()J
    //   31: ldc2_w 236
    //   34: ldiv
    //   35: l2i
    //   36: istore_1
    //   37: aload_0
    //   38: getfield 55	kvs:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   41: iconst_0
    //   42: aload_0
    //   43: getfield 55	kvs:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   46: invokevirtual 266	java/util/LinkedList:size	()I
    //   49: invokevirtual 270	java/util/LinkedList:subList	(II)Ljava/util/List;
    //   52: invokeinterface 273 1 0
    //   57: astore_2
    //   58: aload_2
    //   59: invokeinterface 109 1 0
    //   64: ifeq +143 -> 207
    //   67: aload_2
    //   68: invokeinterface 113 1 0
    //   73: checkcast 115	com/tencent/mobileqq/vip/DownloadTask
    //   76: astore_3
    //   77: aload_3
    //   78: invokevirtual 117	com/tencent/mobileqq/vip/DownloadTask:a	()Z
    //   81: ifne -23 -> 58
    //   84: aload_3
    //   85: getfield 275	com/tencent/mobileqq/vip/DownloadTask:d	J
    //   88: lconst_0
    //   89: lcmp
    //   90: ifle -32 -> 58
    //   93: iload_1
    //   94: i2l
    //   95: aload_3
    //   96: getfield 240	com/tencent/mobileqq/vip/DownloadTask:c	J
    //   99: aload_3
    //   100: getfield 275	com/tencent/mobileqq/vip/DownloadTask:d	J
    //   103: ladd
    //   104: lcmp
    //   105: ifle -47 -> 58
    //   108: aload_3
    //   109: invokevirtual 278	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   112: astore 4
    //   114: aload_3
    //   115: bipush 154
    //   117: putfield 282	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   120: aload_3
    //   121: iconst_m1
    //   122: invokevirtual 284	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   125: aload 4
    //   127: ifnull +9 -> 136
    //   130: aload 4
    //   132: aload_3
    //   133: invokevirtual 289	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   136: aload_0
    //   137: getfield 55	kvs:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   140: astore 4
    //   142: aload 4
    //   144: monitorenter
    //   145: aload_0
    //   146: getfield 55	kvs:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   149: aload_3
    //   150: invokevirtual 172	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   153: pop
    //   154: aload 4
    //   156: monitorexit
    //   157: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -102 -> 58
    //   163: getstatic 27	kvs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   166: iconst_2
    //   167: new 130	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 291
    //   177: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: getfield 161	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: goto -135 -> 58
    //   196: astore_2
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: aload 4
    //   204: monitorexit
    //   205: aload_2
    //   206: athrow
    //   207: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +13 -> 223
    //   213: getstatic 27	kvs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   216: iconst_2
    //   217: ldc_w 293
    //   220: invokestatic 262	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: monitorexit
    //   225: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	kvs
    //   36	58	1	i	int
    //   57	11	2	localIterator	Iterator
    //   196	4	2	localObject1	Object
    //   201	5	2	localObject2	Object
    //   76	105	3	localDownloadTask	DownloadTask
    // Exception table:
    //   from	to	target	type
    //   2	18	196	finally
    //   18	58	196	finally
    //   58	125	196	finally
    //   130	136	196	finally
    //   136	145	196	finally
    //   157	193	196	finally
    //   205	207	196	finally
    //   207	223	196	finally
    //   145	157	201	finally
    //   202	205	201	finally
  }
  
  void c()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if (localDownloadTask.b())
          {
            localIterator.remove();
            this.jdField_a_of_type_JavaUtilLinkedList.remove(localDownloadTask);
          }
        }
      }
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
        break label123;
      }
    }
    finally {}
    if (this.jdField_a_of_type_AndroidOsHandler != null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidOsHandler)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      label123:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doTask | downloadLimitCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ",maxDownloadCount=" + 5 + ",downloadQueue size=" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= 5)
      {
        ThreadManager.a(new kvu(this));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      }
    }
  }
  
  public void onNetMobile2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetMobile2None();
          }
        }
      }
    }
  }
  
  public void onNetMobile2Wifi() {}
  
  public void onNetNone2Mobile() {}
  
  public void onNetNone2Wifi() {}
  
  public void onNetWifi2Mobile()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetWifi2Mobile();
          }
        }
      }
    }
  }
  
  public void onNetWifi2None()
  {
    if ((this.jdField_a_of_type_JavaUtilLinkedList != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (localIterator.hasNext())
        {
          DownloadTask localDownloadTask = (DownloadTask)localIterator.next();
          if ((localDownloadTask.a() != null) && (localDownloadTask.a() == 2)) {
            localDownloadTask.a().onNetWifi2None();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvs
 * JD-Core Version:    0.7.0.1
 */