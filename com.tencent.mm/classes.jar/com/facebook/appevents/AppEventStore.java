package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

class AppEventStore
{
  private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(17341);
    TAG = AppEventStore.class.getName();
    AppMethodBeat.o(17341);
  }
  
  /* Error */
  public static void persistEvents(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 17337
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 41	com/facebook/appevents/internal/AppEventUtility:assertIsNotMainThread	()V
    //   12: invokestatic 45	com/facebook/appevents/AppEventStore:readAndClearStore	()Lcom/facebook/appevents/PersistedEvents;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 51	com/facebook/appevents/PersistedEvents:containsKey	(Lcom/facebook/appevents/AccessTokenAppIdPair;)Z
    //   21: ifeq +32 -> 53
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 55	com/facebook/appevents/PersistedEvents:get	(Lcom/facebook/appevents/AccessTokenAppIdPair;)Ljava/util/List;
    //   29: aload_1
    //   30: invokevirtual 61	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   33: invokeinterface 67 2 0
    //   38: pop
    //   39: aload_2
    //   40: invokestatic 71	com/facebook/appevents/AppEventStore:saveEventsToDisk	(Lcom/facebook/appevents/PersistedEvents;)V
    //   43: sipush 17337
    //   46: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: aload_2
    //   54: aload_0
    //   55: aload_1
    //   56: invokevirtual 61	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   59: invokevirtual 75	com/facebook/appevents/PersistedEvents:addEvents	(Lcom/facebook/appevents/AccessTokenAppIdPair;Ljava/util/List;)V
    //   62: goto -23 -> 39
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramAccessTokenAppIdPair	AccessTokenAppIdPair
    //   0	71	1	paramSessionEventsState	SessionEventsState
    //   15	39	2	localPersistedEvents	PersistedEvents
    // Exception table:
    //   from	to	target	type
    //   3	39	65	finally
    //   39	49	65	finally
    //   53	62	65	finally
  }
  
  public static void persistEvents(AppEventCollection paramAppEventCollection)
  {
    try
    {
      AppMethodBeat.i(17338);
      AppEventUtility.assertIsNotMainThread();
      PersistedEvents localPersistedEvents = readAndClearStore();
      Iterator localIterator = paramAppEventCollection.keySet().iterator();
      while (localIterator.hasNext())
      {
        AccessTokenAppIdPair localAccessTokenAppIdPair = (AccessTokenAppIdPair)localIterator.next();
        localPersistedEvents.addEvents(localAccessTokenAppIdPair, paramAppEventCollection.get(localAccessTokenAppIdPair).getEventsToPersist());
      }
      saveEventsToDisk(localPersistedEvents);
    }
    finally {}
    AppMethodBeat.o(17338);
  }
  
  /* Error */
  public static PersistedEvents readAndClearStore()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: sipush 17339
    //   8: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: invokestatic 41	com/facebook/appevents/internal/AppEventUtility:assertIsNotMainThread	()V
    //   14: invokestatic 113	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   17: astore_3
    //   18: new 6	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream
    //   21: dup
    //   22: new 115	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_3
    //   27: ldc 10
    //   29: invokevirtual 121	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   32: invokespecial 124	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: invokespecial 125	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 128	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: checkcast 47	com/facebook/appevents/PersistedEvents
    //   46: astore_1
    //   47: aload_0
    //   48: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   51: aload_3
    //   52: ldc 10
    //   54: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   57: invokevirtual 143	java/io/File:delete	()Z
    //   60: pop
    //   61: aload_1
    //   62: astore_0
    //   63: aload_0
    //   64: astore_1
    //   65: aload_0
    //   66: ifnonnull +11 -> 77
    //   69: new 47	com/facebook/appevents/PersistedEvents
    //   72: dup
    //   73: invokespecial 144	com/facebook/appevents/PersistedEvents:<init>	()V
    //   76: astore_1
    //   77: sipush 17339
    //   80: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   95: aload_3
    //   96: ldc 10
    //   98: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   101: invokevirtual 143	java/io/File:delete	()Z
    //   104: pop
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -44 -> 63
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -50 -> 63
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload_3
    //   124: ldc 10
    //   126: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   129: invokevirtual 143	java/io/File:delete	()Z
    //   132: pop
    //   133: aconst_null
    //   134: astore_0
    //   135: goto -72 -> 63
    //   138: astore_0
    //   139: aconst_null
    //   140: astore_0
    //   141: goto -78 -> 63
    //   144: astore_0
    //   145: aload_1
    //   146: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   149: aload_3
    //   150: ldc 10
    //   152: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   155: invokevirtual 143	java/io/File:delete	()Z
    //   158: pop
    //   159: sipush 17339
    //   162: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    //   173: astore_1
    //   174: goto -15 -> 159
    //   177: astore_2
    //   178: aload_0
    //   179: astore_1
    //   180: aload_2
    //   181: astore_0
    //   182: goto -37 -> 145
    //   185: astore_1
    //   186: goto -67 -> 119
    //   189: astore_1
    //   190: goto -99 -> 91
    //   193: astore_0
    //   194: aload_1
    //   195: astore_0
    //   196: goto -133 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	28	0	localObject1	Object
    //   88	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   90	17	0	localCloseable1	java.io.Closeable
    //   110	1	0	localException1	java.lang.Exception
    //   112	1	0	localObject2	Object
    //   116	1	0	localException2	java.lang.Exception
    //   118	17	0	localCloseable2	java.io.Closeable
    //   138	1	0	localException3	java.lang.Exception
    //   140	1	0	localObject3	Object
    //   144	22	0	localObject4	Object
    //   167	12	0	localObject5	Object
    //   181	1	0	localObject6	Object
    //   193	1	0	localException4	java.lang.Exception
    //   195	1	0	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	145	1	localObject7	Object
    //   173	1	1	localException5	java.lang.Exception
    //   179	1	1	localObject8	Object
    //   185	1	1	localException6	java.lang.Exception
    //   189	6	1	localFileNotFoundException3	java.io.FileNotFoundException
    //   177	4	2	localObject9	Object
    //   17	133	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   18	39	88	java/io/FileNotFoundException
    //   95	105	110	java/lang/Exception
    //   18	39	116	java/lang/Exception
    //   123	133	138	java/lang/Exception
    //   18	39	144	finally
    //   5	18	167	finally
    //   47	51	167	finally
    //   51	61	167	finally
    //   69	77	167	finally
    //   77	83	167	finally
    //   91	95	167	finally
    //   95	105	167	finally
    //   119	123	167	finally
    //   123	133	167	finally
    //   145	149	167	finally
    //   149	159	167	finally
    //   159	167	167	finally
    //   149	159	173	java/lang/Exception
    //   39	47	177	finally
    //   39	47	185	java/lang/Exception
    //   39	47	189	java/io/FileNotFoundException
    //   51	61	193	java/lang/Exception
  }
  
  /* Error */
  private static void saveEventsToDisk(PersistedEvents paramPersistedEvents)
  {
    // Byte code:
    //   0: sipush 17340
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 113	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   9: astore_3
    //   10: new 146	java/io/ObjectOutputStream
    //   13: dup
    //   14: new 148	java/io/BufferedOutputStream
    //   17: dup
    //   18: aload_3
    //   19: ldc 10
    //   21: iconst_0
    //   22: invokevirtual 152	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   25: invokespecial 155	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: invokespecial 156	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: aload_2
    //   33: astore_1
    //   34: aload_2
    //   35: aload_0
    //   36: invokevirtual 160	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   39: aload_2
    //   40: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   43: sipush 17340
    //   46: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_3
    //   56: ldc 10
    //   58: invokevirtual 138	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   61: invokevirtual 143	java/io/File:delete	()Z
    //   64: pop
    //   65: aload_0
    //   66: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   69: sipush 17340
    //   72: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: return
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 134	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   83: sipush 17340
    //   86: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: goto -13 -> 79
    //   95: astore_1
    //   96: goto -31 -> 65
    //   99: astore_0
    //   100: aload_2
    //   101: astore_0
    //   102: goto -49 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramPersistedEvents	PersistedEvents
    //   33	47	1	localObject	Object
    //   95	1	1	localException	java.lang.Exception
    //   31	70	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   9	47	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   10	32	50	java/lang/Exception
    //   10	32	76	finally
    //   34	39	91	finally
    //   55	65	91	finally
    //   55	65	95	java/lang/Exception
    //   34	39	99	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.AppEventStore
 * JD-Core Version:    0.7.0.1
 */