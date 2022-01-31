package com.facebook.appevents;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AppEventsLogger$PersistedAppSessionInfo
{
  private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
  private static final Runnable appSessionInfoFlushRunnable;
  private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
  private static boolean hasChanges;
  private static boolean isLoaded;
  private static final Object staticLock;
  
  static
  {
    AppMethodBeat.i(71921);
    staticLock = new Object();
    hasChanges = false;
    isLoaded = false;
    appSessionInfoFlushRunnable = new AppEventsLogger.PersistedAppSessionInfo.1();
    AppMethodBeat.o(71921);
  }
  
  private static FacebookTimeSpentData getTimeSpentData(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair)
  {
    AppMethodBeat.i(71919);
    restoreAppSessionInformation(paramContext);
    FacebookTimeSpentData localFacebookTimeSpentData = (FacebookTimeSpentData)appSessionInfoMap.get(paramAccessTokenAppIdPair);
    paramContext = localFacebookTimeSpentData;
    if (localFacebookTimeSpentData == null)
    {
      paramContext = new FacebookTimeSpentData();
      appSessionInfoMap.put(paramAccessTokenAppIdPair, paramContext);
    }
    AppMethodBeat.o(71919);
    return paramContext;
  }
  
  static void onResume(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
  {
    AppMethodBeat.i(71917);
    synchronized (staticLock)
    {
      getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onResume(paramAppEventsLogger, paramLong, paramString);
      onTimeSpentDataUpdate();
      AppMethodBeat.o(71917);
      return;
    }
  }
  
  static void onSuspend(Context paramContext, AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    AppMethodBeat.i(71918);
    synchronized (staticLock)
    {
      getTimeSpentData(paramContext, paramAccessTokenAppIdPair).onSuspend(paramAppEventsLogger, paramLong);
      onTimeSpentDataUpdate();
      AppMethodBeat.o(71918);
      return;
    }
  }
  
  private static void onTimeSpentDataUpdate()
  {
    AppMethodBeat.i(71920);
    if (!hasChanges)
    {
      hasChanges = true;
      AppEventsLogger.access$300().schedule(appSessionInfoFlushRunnable, 30L, TimeUnit.SECONDS);
    }
    AppMethodBeat.o(71920);
  }
  
  /* Error */
  private static void restoreAppSessionInformation(Context paramContext)
  {
    // Byte code:
    //   0: ldc 111
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 35	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
    //   10: astore 4
    //   12: aload 4
    //   14: monitorenter
    //   15: getstatic 39	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifne +72 -> 92
    //   23: new 113	java/io/ObjectInputStream
    //   26: dup
    //   27: aload_0
    //   28: ldc 11
    //   30: invokevirtual 119	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   33: invokespecial 122	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 126	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   41: checkcast 128	java/util/HashMap
    //   44: putstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   47: getstatic 134	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
    //   50: ldc 136
    //   52: ldc 138
    //   54: invokestatic 144	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_2
    //   58: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   61: aload_0
    //   62: ldc 11
    //   64: invokevirtual 154	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   67: pop
    //   68: getstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   71: ifnonnull +13 -> 84
    //   74: new 128	java/util/HashMap
    //   77: dup
    //   78: invokespecial 155	java/util/HashMap:<init>	()V
    //   81: putstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   84: iconst_1
    //   85: putstatic 39	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   88: iconst_0
    //   89: putstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   92: aload 4
    //   94: monitorexit
    //   95: ldc 111
    //   97: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_2
    //   102: aload_3
    //   103: astore_2
    //   104: aload_2
    //   105: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   108: aload_0
    //   109: ldc 11
    //   111: invokevirtual 154	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   114: pop
    //   115: getstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   118: ifnonnull +13 -> 131
    //   121: new 128	java/util/HashMap
    //   124: dup
    //   125: invokespecial 155	java/util/HashMap:<init>	()V
    //   128: putstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   131: iconst_1
    //   132: putstatic 39	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   135: iconst_0
    //   136: putstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   139: goto -47 -> 92
    //   142: astore_0
    //   143: aload 4
    //   145: monitorexit
    //   146: ldc 111
    //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_0
    //   152: athrow
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: invokestatic 159	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
    //   159: pop
    //   160: new 161	java/lang/StringBuilder
    //   163: dup
    //   164: ldc 163
    //   166: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload_3
    //   170: invokevirtual 169	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   181: aload_0
    //   182: ldc 11
    //   184: invokevirtual 154	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   187: pop
    //   188: getstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   191: ifnonnull +13 -> 204
    //   194: new 128	java/util/HashMap
    //   197: dup
    //   198: invokespecial 155	java/util/HashMap:<init>	()V
    //   201: putstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   204: iconst_1
    //   205: putstatic 39	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   208: iconst_0
    //   209: putstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   212: goto -120 -> 92
    //   215: aload_2
    //   216: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   219: aload_0
    //   220: ldc 11
    //   222: invokevirtual 154	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   225: pop
    //   226: getstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   229: ifnonnull +13 -> 242
    //   232: new 128	java/util/HashMap
    //   235: dup
    //   236: invokespecial 155	java/util/HashMap:<init>	()V
    //   239: putstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   242: iconst_1
    //   243: putstatic 39	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:isLoaded	Z
    //   246: iconst_0
    //   247: putstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   250: ldc 111
    //   252: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload_3
    //   256: athrow
    //   257: astore_3
    //   258: goto -43 -> 215
    //   261: astore_3
    //   262: goto -47 -> 215
    //   265: astore_3
    //   266: goto -110 -> 156
    //   269: astore_3
    //   270: goto -166 -> 104
    //   273: astore_3
    //   274: aconst_null
    //   275: astore_2
    //   276: goto -61 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   18	2	1	bool	boolean
    //   36	22	2	localObjectInputStream	java.io.ObjectInputStream
    //   101	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   103	173	2	localObject1	Object
    //   6	97	3	localObject2	Object
    //   153	103	3	localException1	java.lang.Exception
    //   257	1	3	localObject3	Object
    //   261	1	3	localObject4	Object
    //   265	1	3	localException2	java.lang.Exception
    //   269	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   273	1	3	localObject5	Object
    //   10	134	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	101	java/io/FileNotFoundException
    //   15	19	142	finally
    //   57	84	142	finally
    //   84	92	142	finally
    //   92	95	142	finally
    //   104	131	142	finally
    //   131	139	142	finally
    //   143	146	142	finally
    //   177	204	142	finally
    //   204	212	142	finally
    //   215	242	142	finally
    //   242	257	142	finally
    //   23	37	153	java/lang/Exception
    //   37	57	257	finally
    //   156	177	261	finally
    //   37	57	265	java/lang/Exception
    //   37	57	269	java/io/FileNotFoundException
    //   23	37	273	finally
  }
  
  /* Error */
  static void saveAppSessionInformation(Context paramContext)
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 35	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:staticLock	Ljava/lang/Object;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: getstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +56 -> 74
    //   21: new 177	java/io/ObjectOutputStream
    //   24: dup
    //   25: new 179	java/io/BufferedOutputStream
    //   28: dup
    //   29: aload_0
    //   30: ldc 11
    //   32: iconst_0
    //   33: invokevirtual 183	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: invokespecial 186	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: invokespecial 187	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   42: astore_2
    //   43: aload_2
    //   44: astore_0
    //   45: aload_2
    //   46: getstatic 57	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:appSessionInfoMap	Ljava/util/Map;
    //   49: invokevirtual 191	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   52: aload_2
    //   53: astore_0
    //   54: iconst_0
    //   55: putstatic 37	com/facebook/appevents/AppEventsLogger$PersistedAppSessionInfo:hasChanges	Z
    //   58: aload_2
    //   59: astore_0
    //   60: getstatic 134	com/facebook/LoggingBehavior:APP_EVENTS	Lcom/facebook/LoggingBehavior;
    //   63: ldc 136
    //   65: ldc 193
    //   67: invokestatic 144	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   74: aload 4
    //   76: monitorexit
    //   77: ldc 175
    //   79: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: return
    //   83: astore_3
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 159	com/facebook/appevents/AppEventsLogger:access$200	()Ljava/lang/String;
    //   91: pop
    //   92: aload_2
    //   93: astore_0
    //   94: new 161	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 195
    //   100: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_3
    //   104: invokevirtual 169	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   115: goto -41 -> 74
    //   118: astore_0
    //   119: aload 4
    //   121: monitorexit
    //   122: ldc 175
    //   124: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: invokestatic 150	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   136: ldc 175
    //   138: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_2
    //   142: athrow
    //   143: astore_2
    //   144: goto -12 -> 132
    //   147: astore_3
    //   148: goto -62 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   16	2	1	bool	boolean
    //   42	70	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   129	13	2	localObject1	Object
    //   143	1	2	localObject2	Object
    //   83	21	3	localException1	java.lang.Exception
    //   147	1	3	localException2	java.lang.Exception
    //   8	112	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	43	83	java/lang/Exception
    //   13	17	118	finally
    //   70	74	118	finally
    //   74	77	118	finally
    //   111	115	118	finally
    //   119	122	118	finally
    //   132	143	118	finally
    //   21	43	129	finally
    //   45	52	143	finally
    //   54	58	143	finally
    //   60	70	143	finally
    //   88	92	143	finally
    //   94	111	143	finally
    //   45	52	147	java/lang/Exception
    //   54	58	147	java/lang/Exception
    //   60	70	147	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo
 * JD-Core Version:    0.7.0.1
 */