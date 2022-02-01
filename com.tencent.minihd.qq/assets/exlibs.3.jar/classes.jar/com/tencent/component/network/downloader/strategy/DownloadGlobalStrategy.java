package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.Base64;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadGlobalStrategy
{
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final DownloadGlobalStrategy.StrategyInfo a;
  private static volatile DownloadGlobalStrategy jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy = null;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final DownloadGlobalStrategy.StrategyInfo b;
  private static ArrayList b;
  public static final DownloadGlobalStrategy.StrategyInfo c;
  private static ArrayList c;
  public static final DownloadGlobalStrategy.StrategyInfo d;
  public static final DownloadGlobalStrategy.StrategyInfo e;
  private volatile int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private PortConfigStrategy jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(1, false, false, false);
    jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(2, true, false, false);
    jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(3, true, true, false);
    d = new DownloadGlobalStrategy.StrategyInfo(4, false, false, true);
    e = new DownloadGlobalStrategy.StrategyInfo(5, false, false, false, true);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = DownloaderFactory.a(paramContext).a();
    jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(e);
    jdField_b_of_type_JavaUtilArrayList.add(e);
    jdField_b_of_type_JavaUtilArrayList.add(d);
    jdField_b_of_type_JavaUtilArrayList.add(d);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(e);
    jdField_c_of_type_JavaUtilArrayList.add(e);
    jdField_c_of_type_JavaUtilArrayList.add(d);
    jdField_c_of_type_JavaUtilArrayList.add(d);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_AndroidContentContext = paramContext;
    if (jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("downloa_stragegy", 0);
    }
    b();
  }
  
  public static long a()
  {
    return 259200L;
  }
  
  public static DownloadGlobalStrategy a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy == null) {
        jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy = new DownloadGlobalStrategy(paramContext);
      }
      return jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = "";
    if ("wifi".equals(paramString2))
    {
      str = NetworkManager.b();
      if (!TextUtils.isEmpty(str)) {
        break label54;
      }
    }
    label54:
    for (str = "";; str = "_" + str) {
      return paramString1 + "_" + paramString2 + str;
    }
  }
  
  private boolean a(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramStrategyInfo != null;
  }
  
  private void b()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      Object localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("download_best_strategy", null);
      if (localObject4 == null) {
        continue;
      }
      try
      {
        localObject4 = com.tencent.component.network.downloader.common.a.a(Base64.a((String)localObject4, 0));
        localObject1 = localObject4;
        localObject3 = localObject4;
        ((Parcel)localObject4).readMap(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, jdField_a_of_type_AndroidContentContext.getClassLoader());
        if (localObject4 == null) {
          continue;
        }
        ((Parcel)localObject4).recycle();
        return;
      }
      catch (Throwable localThrowable)
      {
        localObject3 = localObject1;
        b.c("DownloadGlobalStrategy", "loadStrategy", localThrowable);
        return;
      }
      finally
      {
        if (localObject3 != null) {
          localObject3.recycle();
        }
      }
    }
  }
  
  public DownloadGlobalStrategy.StrategyInfo a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = null;
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return paramString2;
      paramString1 = a(paramString2, NetworkManager.a());
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      paramString1 = localStrategyInfo;
      if (localStrategyInfo != null)
      {
        paramString1 = localStrategyInfo;
        if (!localStrategyInfo.a())
        {
          if (b.b()) {
            b.b("DownloadGlobalStrategy", "best strategy invalid! domain:" + paramString2 + " threadId:" + Thread.currentThread().getId());
          }
          paramString1 = null;
        }
      }
      bool1 = com.tencent.component.network.module.a.a.a().a();
      bool2 = com.tencent.component.network.module.a.a.a().b();
      paramString2 = paramString1;
    } while (a(paramString1, bool1, bool2));
    return new DownloadGlobalStrategy.StrategyInfo(bool1, bool2, false);
  }
  
  public DownloadGlobalStrategy.StrategyLib a(String paramString1, String paramString2)
  {
    int j = 80;
    DownloadGlobalStrategy.StrategyLib localStrategyLib = new DownloadGlobalStrategy.StrategyLib(this);
    DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, a(paramString1, paramString2));
    int i;
    if (!NetworkManager.a())
    {
      DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, jdField_c_of_type_JavaUtilArrayList);
      i = j;
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(paramString2))
        {
          i = j;
          if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib) != null)
          {
            i = j;
            if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a() != null)
            {
              i = j;
              if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a())
              {
                i = DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_Int;
                if (com.tencent.component.network.downloader.common.a.a(i)) {
                  break label299;
                }
                i = j;
              }
            }
          }
        }
      }
    }
    label299:
    for (;;)
    {
      localStrategyLib.a(i);
      if ((DownloadGlobalStrategy.StrategyLib.a(localStrategyLib) != null) && (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a() != null) && (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a()) && (!TextUtils.isEmpty(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString)))
      {
        if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int != d.jdField_a_of_type_Int) {
          break label227;
        }
        localStrategyLib.c(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
      }
      label227:
      do
      {
        return localStrategyLib;
        DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, jdField_a_of_type_JavaUtilArrayList);
        break;
        if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int == e.jdField_a_of_type_Int)
        {
          localStrategyLib.b(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
          return localStrategyLib;
        }
      } while (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int != jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int);
      localStrategyLib.a(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
      return localStrategyLib;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Int	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 275	com/tencent/component/network/downloader/impl/a:a	()I
    //   24: ifle +11 -> 35
    //   27: aload_0
    //   28: getfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Int	I
    //   31: iconst_5
    //   32: if_icmplt -14 -> 18
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Int	I
    //   40: invokestatic 276	com/tencent/component/network/module/base/b:a	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc 170
    //   48: ldc_w 278
    //   51: invokestatic 280	com/tencent/component/network/module/base/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aconst_null
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: invokestatic 284	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 4
    //   63: aload 4
    //   65: astore_2
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: aload_0
    //   72: getfield 61	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: invokevirtual 288	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: new 105	java/lang/String
    //   87: dup
    //   88: aload 4
    //   90: invokevirtual 292	android/os/Parcel:marshall	()[B
    //   93: iconst_0
    //   94: invokestatic 295	com/tencent/component/network/utils/Base64:b	([BI)[B
    //   97: invokespecial 298	java/lang/String:<init>	([B)V
    //   100: astore 5
    //   102: aload 4
    //   104: astore_2
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 89	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   112: invokeinterface 302 1 0
    //   117: ldc 140
    //   119: aload 5
    //   121: invokeinterface 308 3 0
    //   126: invokeinterface 311 1 0
    //   131: pop
    //   132: aload 4
    //   134: ifnull -116 -> 18
    //   137: aload 4
    //   139: invokevirtual 168	android/os/Parcel:recycle	()V
    //   142: goto -124 -> 18
    //   145: astore_2
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore 4
    //   152: aload_2
    //   153: astore_3
    //   154: ldc 170
    //   156: ldc_w 313
    //   159: aload 4
    //   161: invokestatic 177	com/tencent/component/network/module/base/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: ifnull -147 -> 18
    //   168: aload_2
    //   169: invokevirtual 168	android/os/Parcel:recycle	()V
    //   172: goto -154 -> 18
    //   175: astore_2
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 168	android/os/Parcel:recycle	()V
    //   184: aload_2
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	DownloadGlobalStrategy
    //   13	2	1	i	int
    //   57	48	2	localObject1	Object
    //   145	24	2	localObject2	Object
    //   175	10	2	localObject3	Object
    //   55	126	3	localObject4	Object
    //   61	77	4	localParcel	Parcel
    //   150	10	4	localException	java.lang.Exception
    //   100	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	145	finally
    //   21	35	145	finally
    //   35	54	145	finally
    //   137	142	145	finally
    //   168	172	145	finally
    //   180	184	145	finally
    //   184	186	145	finally
    //   58	63	150	java/lang/Exception
    //   69	78	150	java/lang/Exception
    //   84	102	150	java/lang/Exception
    //   108	132	150	java/lang/Exception
    //   58	63	175	finally
    //   69	78	175	finally
    //   84	102	175	finally
    //   108	132	175	finally
    //   154	164	175	finally
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramStrategyInfo == null)) {
      return;
    }
    paramString1 = NetworkManager.a();
    if (paramString2 != null)
    {
      paramString1 = a(paramString2, paramString1);
      paramString2 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (!paramBoolean) {
        break label141;
      }
      if (!paramStrategyInfo.equals(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramStrategyInfo);
        this.jdField_a_of_type_Int += 1;
        a();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int > 0) {
        a();
      }
      if ((!paramBoolean) || ((paramStrategyInfo.jdField_a_of_type_Int != jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) && (paramStrategyInfo.jdField_a_of_type_Int != jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int))) {
        break;
      }
      com.tencent.component.network.module.a.a.a().a(paramContext, paramStrategyInfo.jdField_a_of_type_Boolean, paramStrategyInfo.b);
      return;
      label141:
      if (paramStrategyInfo.equals(paramString2))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
        this.jdField_a_of_type_Int += 1;
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */