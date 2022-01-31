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
    AppMethodBeat.i(71905);
    TAG = AppEventStore.class.getName();
    AppMethodBeat.o(71905);
  }
  
  /* Error */
  public static void persistEvents(AccessTokenAppIdPair paramAccessTokenAppIdPair, SessionEventsState paramSessionEventsState)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 38
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 43	com/facebook/appevents/internal/AppEventUtility:assertIsNotMainThread	()V
    //   11: invokestatic 47	com/facebook/appevents/AppEventStore:readAndClearStore	()Lcom/facebook/appevents/PersistedEvents;
    //   14: astore_2
    //   15: aload_2
    //   16: aload_0
    //   17: invokevirtual 53	com/facebook/appevents/PersistedEvents:containsKey	(Lcom/facebook/appevents/AccessTokenAppIdPair;)Z
    //   20: ifeq +31 -> 51
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 57	com/facebook/appevents/PersistedEvents:get	(Lcom/facebook/appevents/AccessTokenAppIdPair;)Ljava/util/List;
    //   28: aload_1
    //   29: invokevirtual 63	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   32: invokeinterface 69 2 0
    //   37: pop
    //   38: aload_2
    //   39: invokestatic 73	com/facebook/appevents/AppEventStore:saveEventsToDisk	(Lcom/facebook/appevents/PersistedEvents;)V
    //   42: ldc 38
    //   44: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: return
    //   51: aload_2
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 63	com/facebook/appevents/SessionEventsState:getEventsToPersist	()Ljava/util/List;
    //   57: invokevirtual 77	com/facebook/appevents/PersistedEvents:addEvents	(Lcom/facebook/appevents/AccessTokenAppIdPair;Ljava/util/List;)V
    //   60: goto -22 -> 38
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramAccessTokenAppIdPair	AccessTokenAppIdPair
    //   0	69	1	paramSessionEventsState	SessionEventsState
    //   14	38	2	localPersistedEvents	PersistedEvents
    // Exception table:
    //   from	to	target	type
    //   3	38	63	finally
    //   38	47	63	finally
    //   51	60	63	finally
  }
  
  public static void persistEvents(AppEventCollection paramAppEventCollection)
  {
    try
    {
      AppMethodBeat.i(71902);
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
    AppMethodBeat.o(71902);
  }
  
  /* Error */
  public static PersistedEvents readAndClearStore()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 111
    //   7: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 43	com/facebook/appevents/internal/AppEventUtility:assertIsNotMainThread	()V
    //   13: invokestatic 117	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   16: astore_3
    //   17: new 6	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream
    //   20: dup
    //   21: new 119	java/io/BufferedInputStream
    //   24: dup
    //   25: aload_3
    //   26: ldc 10
    //   28: invokevirtual 125	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   31: invokespecial 128	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 129	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 132	com/facebook/appevents/AppEventStore$MovedClassObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: checkcast 49	com/facebook/appevents/PersistedEvents
    //   45: astore_1
    //   46: aload_0
    //   47: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   50: aload_3
    //   51: ldc 10
    //   53: invokevirtual 142	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   56: invokevirtual 147	java/io/File:delete	()Z
    //   59: pop
    //   60: aload_1
    //   61: astore_0
    //   62: aload_0
    //   63: astore_1
    //   64: aload_0
    //   65: ifnonnull +11 -> 76
    //   68: new 49	com/facebook/appevents/PersistedEvents
    //   71: dup
    //   72: invokespecial 148	com/facebook/appevents/PersistedEvents:<init>	()V
    //   75: astore_1
    //   76: ldc 111
    //   78: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_1
    //   85: areturn
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   93: aload_3
    //   94: ldc 10
    //   96: invokevirtual 142	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   99: invokevirtual 147	java/io/File:delete	()Z
    //   102: pop
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -43 -> 62
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -49 -> 62
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   121: aload_3
    //   122: ldc 10
    //   124: invokevirtual 142	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   127: invokevirtual 147	java/io/File:delete	()Z
    //   130: pop
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -71 -> 62
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_0
    //   139: goto -77 -> 62
    //   142: astore_0
    //   143: aload_1
    //   144: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   147: aload_3
    //   148: ldc 10
    //   150: invokevirtual 142	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   153: invokevirtual 147	java/io/File:delete	()Z
    //   156: pop
    //   157: ldc 111
    //   159: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_0
    //   163: athrow
    //   164: astore_0
    //   165: ldc 2
    //   167: monitorexit
    //   168: aload_0
    //   169: athrow
    //   170: astore_1
    //   171: goto -14 -> 157
    //   174: astore_2
    //   175: aload_0
    //   176: astore_1
    //   177: aload_2
    //   178: astore_0
    //   179: goto -36 -> 143
    //   182: astore_1
    //   183: goto -66 -> 117
    //   186: astore_1
    //   187: goto -98 -> 89
    //   190: astore_0
    //   191: aload_1
    //   192: astore_0
    //   193: goto -131 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	28	0	localObject1	Object
    //   86	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   88	17	0	localCloseable1	java.io.Closeable
    //   108	1	0	localException1	java.lang.Exception
    //   110	1	0	localObject2	Object
    //   114	1	0	localException2	java.lang.Exception
    //   116	17	0	localCloseable2	java.io.Closeable
    //   136	1	0	localException3	java.lang.Exception
    //   138	1	0	localObject3	Object
    //   142	21	0	localObject4	Object
    //   164	12	0	localObject5	Object
    //   178	1	0	localObject6	Object
    //   190	1	0	localException4	java.lang.Exception
    //   192	1	0	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	143	1	localObject7	Object
    //   170	1	1	localException5	java.lang.Exception
    //   176	1	1	localObject8	Object
    //   182	1	1	localException6	java.lang.Exception
    //   186	6	1	localFileNotFoundException3	java.io.FileNotFoundException
    //   174	4	2	localObject9	Object
    //   16	132	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   17	38	86	java/io/FileNotFoundException
    //   93	103	108	java/lang/Exception
    //   17	38	114	java/lang/Exception
    //   121	131	136	java/lang/Exception
    //   17	38	142	finally
    //   5	17	164	finally
    //   46	50	164	finally
    //   50	60	164	finally
    //   68	76	164	finally
    //   76	81	164	finally
    //   89	93	164	finally
    //   93	103	164	finally
    //   117	121	164	finally
    //   121	131	164	finally
    //   143	147	164	finally
    //   147	157	164	finally
    //   157	164	164	finally
    //   147	157	170	java/lang/Exception
    //   38	46	174	finally
    //   38	46	182	java/lang/Exception
    //   38	46	186	java/io/FileNotFoundException
    //   50	60	190	java/lang/Exception
  }
  
  /* Error */
  private static void saveEventsToDisk(PersistedEvents paramPersistedEvents)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 117	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   8: astore_3
    //   9: new 151	java/io/ObjectOutputStream
    //   12: dup
    //   13: new 153	java/io/BufferedOutputStream
    //   16: dup
    //   17: aload_3
    //   18: ldc 10
    //   20: iconst_0
    //   21: invokevirtual 157	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 161	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aload_0
    //   35: invokevirtual 165	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_2
    //   39: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   42: ldc 149
    //   44: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_0
    //   51: aload_0
    //   52: astore_1
    //   53: aload_3
    //   54: ldc 10
    //   56: invokevirtual 142	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   59: invokevirtual 147	java/io/File:delete	()Z
    //   62: pop
    //   63: aload_0
    //   64: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   67: ldc 149
    //   69: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: invokestatic 138	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   80: ldc 149
    //   82: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: goto -12 -> 76
    //   91: astore_1
    //   92: goto -29 -> 63
    //   95: astore_0
    //   96: aload_2
    //   97: astore_0
    //   98: goto -47 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramPersistedEvents	PersistedEvents
    //   32	45	1	localObject	Object
    //   91	1	1	localException	java.lang.Exception
    //   30	67	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   8	46	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   9	31	48	java/lang/Exception
    //   9	31	73	finally
    //   33	38	87	finally
    //   53	63	87	finally
    //   53	63	91	java/lang/Exception
    //   33	38	95	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.appevents.AppEventStore
 * JD-Core Version:    0.7.0.1
 */