package com.tencent.upload.network.route;

import android.content.Context;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.common.UploadLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RecentRouteSetStorage
{
  private static final String TAG = "RouteSetStorage";
  private static String sFileName = "upload_recent_route";
  private HashMap<String, RecentRouteSet> mRecentRouteSetMap;
  private final int mServerCategory;
  
  public RecentRouteSetStorage(int paramInt)
  {
    this.mServerCategory = paramInt;
    this.mRecentRouteSetMap = new HashMap();
    load();
  }
  
  public static void clear(int paramInt)
  {
    Context localContext = UploadGlobalConfig.getContext();
    if (localContext == null)
    {
      UploadLog.e("RouteSetStorage", "clear() UploadGlobalConfig.getContext() == null");
      return;
    }
    try
    {
      localContext.deleteFile(getRecentRouteSetFilePath(paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      UploadLog.e("RouteSetStorage", "clear() deleteFile " + localException);
    }
  }
  
  private static String getRecentRouteSetFilePath(int paramInt)
  {
    return sFileName + "_" + paramInt;
  }
  
  /* Error */
  private boolean load()
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 98
    //   4: invokestatic 101	com/tencent/upload/common/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore_2
    //   9: invokestatic 45	com/tencent/upload/common/UploadGlobalConfig:getContext	()Landroid/content/Context;
    //   12: astore 4
    //   14: aload 4
    //   16: ifnonnull +12 -> 28
    //   19: ldc 8
    //   21: ldc 103
    //   23: invokestatic 53	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload 4
    //   30: aload_0
    //   31: getfield 27	com/tencent/upload/network/route/RecentRouteSetStorage:mServerCategory	I
    //   34: invokestatic 57	com/tencent/upload/network/route/RecentRouteSetStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   37: invokevirtual 107	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   40: astore_1
    //   41: new 109	java/io/ObjectInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 112	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 116	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   54: astore_2
    //   55: aload_2
    //   56: instanceof 29
    //   59: ifeq +11 -> 70
    //   62: aload_0
    //   63: aload_2
    //   64: checkcast 29	java/util/HashMap
    //   67: putfield 32	com/tencent/upload/network/route/RecentRouteSetStorage:mRecentRouteSetMap	Ljava/util/HashMap;
    //   70: aload_0
    //   71: getfield 32	com/tencent/upload/network/route/RecentRouteSetStorage:mRecentRouteSetMap	Ljava/util/HashMap;
    //   74: ifnonnull +113 -> 187
    //   77: aload_0
    //   78: new 29	java/util/HashMap
    //   81: dup
    //   82: invokespecial 30	java/util/HashMap:<init>	()V
    //   85: putfield 32	com/tencent/upload/network/route/RecentRouteSetStorage:mRecentRouteSetMap	Ljava/util/HashMap;
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 119	java/io/ObjectInputStream:close	()V
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_1
    //   99: ldc 8
    //   101: new 68	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 121
    //   107: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 27	com/tencent/upload/network/route/RecentRouteSetStorage:mServerCategory	I
    //   114: invokestatic 57	com/tencent/upload/network/route/RecentRouteSetStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   117: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 124	com/tencent/upload/common/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore_2
    //   129: ldc 8
    //   131: ldc 126
    //   133: aload_2
    //   134: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: goto -41 -> 96
    //   140: astore_3
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: astore_1
    //   145: ldc 8
    //   147: ldc 131
    //   149: aload_1
    //   150: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload 4
    //   155: aload_0
    //   156: getfield 27	com/tencent/upload/network/route/RecentRouteSetStorage:mServerCategory	I
    //   159: invokestatic 57	com/tencent/upload/network/route/RecentRouteSetStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   162: invokevirtual 63	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   165: pop
    //   166: aload_2
    //   167: ifnull -141 -> 26
    //   170: aload_2
    //   171: invokevirtual 119	java/io/ObjectInputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_1
    //   177: ldc 8
    //   179: ldc 126
    //   181: aload_1
    //   182: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_0
    //   188: invokespecial 134	com/tencent/upload/network/route/RecentRouteSetStorage:print	()V
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 119	java/io/ObjectInputStream:close	()V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_1
    //   202: ldc 8
    //   204: ldc 126
    //   206: aload_1
    //   207: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -11 -> 199
    //   213: astore_1
    //   214: goto -69 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	RecentRouteSetStorage
    //   40	53	1	localObject1	Object
    //   98	44	1	localFileNotFoundException	java.io.FileNotFoundException
    //   144	6	1	localObject2	Object
    //   176	20	1	localException1	Exception
    //   201	6	1	localException2	Exception
    //   213	1	1	localException3	Exception
    //   8	56	2	localObject3	Object
    //   128	6	2	localException4	Exception
    //   142	29	2	localObject4	Object
    //   140	4	3	localException5	Exception
    //   12	142	4	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   28	41	98	java/io/FileNotFoundException
    //   92	96	128	java/lang/Exception
    //   50	70	140	java/lang/Exception
    //   70	88	140	java/lang/Exception
    //   129	137	140	java/lang/Exception
    //   187	191	140	java/lang/Exception
    //   170	174	176	java/lang/Exception
    //   195	199	201	java/lang/Exception
    //   41	50	213	java/lang/Exception
  }
  
  private void print()
  {
    Iterator localIterator = this.mRecentRouteSetMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      RecentRouteSet localRecentRouteSet = (RecentRouteSet)this.mRecentRouteSetMap.get(str);
      if (localRecentRouteSet != null) {
        UploadLog.d("RouteSetStorage", "mRecentRouteSetMap key=" + str + ",value=" + localRecentRouteSet);
      }
    }
  }
  
  private void removeExpired()
  {
    if (this.mRecentRouteSetMap == null) {}
    for (;;)
    {
      return;
      Object localObject = this.mRecentRouteSetMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          RecentRouteSet localRecentRouteSet = (RecentRouteSet)this.mRecentRouteSetMap.get(str);
          if (localRecentRouteSet != null)
          {
            long l = localRecentRouteSet.getTimeStamp();
            if ((l != 0L) && (System.currentTimeMillis() > UploadConfiguration.getRecentRouteExpire() + l))
            {
              ((Iterator)localObject).remove();
              UploadLog.d("RouteSetStorage", "removeExpired key:" + str + " contains:" + this.mRecentRouteSetMap.containsKey(str));
            }
          }
        }
      }
    }
  }
  
  /* Error */
  private boolean save()
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 196
    //   4: invokestatic 101	com/tencent/upload/common/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore_1
    //   9: aconst_null
    //   10: astore_3
    //   11: invokestatic 45	com/tencent/upload/common/UploadGlobalConfig:getContext	()Landroid/content/Context;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull +12 -> 28
    //   19: ldc 8
    //   21: ldc 198
    //   23: invokestatic 53	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: invokespecial 200	com/tencent/upload/network/route/RecentRouteSetStorage:removeExpired	()V
    //   32: new 202	java/io/ObjectOutputStream
    //   35: dup
    //   36: new 204	java/io/BufferedOutputStream
    //   39: dup
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 27	com/tencent/upload/network/route/RecentRouteSetStorage:mServerCategory	I
    //   45: invokestatic 57	com/tencent/upload/network/route/RecentRouteSetStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   48: iconst_0
    //   49: invokevirtual 208	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   52: invokespecial 211	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: invokespecial 212	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: astore_2
    //   59: aload_2
    //   60: aload_0
    //   61: getfield 32	com/tencent/upload/network/route/RecentRouteSetStorage:mRecentRouteSetMap	Ljava/util/HashMap;
    //   64: invokevirtual 216	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   67: aload_0
    //   68: invokespecial 134	com/tencent/upload/network/route/RecentRouteSetStorage:print	()V
    //   71: aload_2
    //   72: ifnull +79 -> 151
    //   75: aload_2
    //   76: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_1
    //   82: aload_3
    //   83: astore_2
    //   84: aload_1
    //   85: astore_3
    //   86: aload_2
    //   87: astore_1
    //   88: ldc 8
    //   90: ldc 219
    //   92: aload_3
    //   93: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_2
    //   97: ifnull -18 -> 79
    //   100: aload_2
    //   101: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   104: goto -25 -> 79
    //   107: astore_1
    //   108: ldc 8
    //   110: ldc 221
    //   112: aload_1
    //   113: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: goto -37 -> 79
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 217	java/io/ObjectOutputStream:close	()V
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: ldc 8
    //   133: ldc 221
    //   135: aload_1
    //   136: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -11 -> 128
    //   142: astore_1
    //   143: ldc 8
    //   145: ldc 221
    //   147: aload_1
    //   148: invokestatic 129	com/tencent/upload/common/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: goto -72 -> 79
    //   154: astore_3
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: goto -39 -> 120
    //   162: astore_3
    //   163: goto -77 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	RecentRouteSetStorage
    //   8	1	1	localObject1	Object
    //   81	4	1	localException1	Exception
    //   87	1	1	localObject2	Object
    //   107	18	1	localException2	Exception
    //   130	6	1	localException3	Exception
    //   142	6	1	localException4	Exception
    //   156	1	1	localObject3	Object
    //   14	87	2	localObject4	Object
    //   119	37	2	localObject5	Object
    //   158	1	2	localObject6	Object
    //   10	83	3	localException5	Exception
    //   154	4	3	localObject7	Object
    //   162	1	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   32	59	81	java/lang/Exception
    //   100	104	107	java/lang/Exception
    //   32	59	119	finally
    //   88	96	119	finally
    //   124	128	130	java/lang/Exception
    //   75	79	142	java/lang/Exception
    //   59	71	154	finally
    //   59	71	162	java/lang/Exception
  }
  
  public RecentRouteSet getData(String paramString)
  {
    return (RecentRouteSet)this.mRecentRouteSetMap.get(paramString);
  }
  
  public void setData(String paramString, RecentRouteSet paramRecentRouteSet)
  {
    this.mRecentRouteSetMap.put(paramString, paramRecentRouteSet);
    save();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.upload.network.route.RecentRouteSetStorage
 * JD-Core Version:    0.7.0.1
 */