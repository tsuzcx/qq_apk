package com.tencent.d.e.b.a.a.a;

import com.tencent.d.e.b.a.a.a;
import com.tencent.d.e.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class f
  implements a
{
  private long IgX = -1L;
  private c LOn;
  private String LOv = "";
  private int mErrorCode = -1;
  
  private static boolean cPP()
  {
    AppMethodBeat.i(138446);
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      Method localMethod = localClass.getMethod("get", new Class[] { String.class, String.class });
      localMethod.setAccessible(true);
      boolean bool = "1".equals((String)localMethod.invoke(localClass, new Object[] { "persist.sys.identifierid.supported", "0" }));
      AppMethodBeat.o(138446);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138446);
    }
    return false;
  }
  
  /* Error */
  public final c kS(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 82
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 84	com/tencent/d/e/b/a/a/a/f:cPP	()Z
    //   10: ifne +27 -> 37
    //   13: aload_0
    //   14: sipush -205
    //   17: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   20: aload_0
    //   21: getfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   24: invokestatic 90	com/tencent/d/e/b/a/a/c:agG	(I)Lcom/tencent/d/e/b/a/a/c;
    //   27: astore_1
    //   28: ldc 82
    //   30: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_0
    //   38: getfield 92	com/tencent/d/e/b/a/a/a/f:LOn	Lcom/tencent/d/e/b/a/a/c;
    //   41: ifnull +31 -> 72
    //   44: aload_0
    //   45: getfield 92	com/tencent/d/e/b/a/a/a/f:LOn	Lcom/tencent/d/e/b/a/a/c;
    //   48: getfield 95	com/tencent/d/e/b/a/a/c:errorCode	I
    //   51: ifne +21 -> 72
    //   54: aload_0
    //   55: getfield 92	com/tencent/d/e/b/a/a/a/f:LOn	Lcom/tencent/d/e/b/a/a/c;
    //   58: astore_1
    //   59: ldc 82
    //   61: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -31 -> 33
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   75: lstore_2
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   81: ldc 103
    //   83: invokestatic 109	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   86: astore 5
    //   88: aload_1
    //   89: invokevirtual 115	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   92: aload 5
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual 121	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore_1
    //   102: aload_1
    //   103: ifnonnull +50 -> 153
    //   106: aload_0
    //   107: sipush -201
    //   110: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   113: aload_0
    //   114: getfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   117: invokestatic 90	com/tencent/d/e/b/a/a/c:agG	(I)Lcom/tencent/d/e/b/a/a/c;
    //   120: astore_1
    //   121: ldc 82
    //   123: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: goto -93 -> 33
    //   129: astore_1
    //   130: aload_0
    //   131: sipush -200
    //   134: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   137: aload_0
    //   138: getfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   141: invokestatic 90	com/tencent/d/e/b/a/a/c:agG	(I)Lcom/tencent/d/e/b/a/a/c;
    //   144: astore_1
    //   145: ldc 82
    //   147: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -117 -> 33
    //   153: aload_1
    //   154: invokeinterface 126 1 0
    //   159: istore 4
    //   161: iload 4
    //   163: ifeq +98 -> 261
    //   166: aload_0
    //   167: aload_1
    //   168: aload_1
    //   169: ldc 128
    //   171: invokeinterface 132 2 0
    //   176: invokeinterface 136 2 0
    //   181: putfield 28	com/tencent/d/e/b/a/a/a/f:LOv	Ljava/lang/String;
    //   184: aload_1
    //   185: invokeinterface 139 1 0
    //   190: aload_0
    //   191: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   194: lload_2
    //   195: lsub
    //   196: putfield 24	com/tencent/d/e/b/a/a/a/f:IgX	J
    //   199: new 86	com/tencent/d/e/b/a/a/c
    //   202: dup
    //   203: aload_0
    //   204: getfield 28	com/tencent/d/e/b/a/a/a/f:LOv	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   211: invokespecial 142	com/tencent/d/e/b/a/a/c:<init>	(Ljava/lang/String;I)V
    //   214: astore_1
    //   215: ldc 82
    //   217: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: goto -187 -> 33
    //   223: astore 5
    //   225: aload_0
    //   226: sipush -203
    //   229: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   232: aload_1
    //   233: invokeinterface 139 1 0
    //   238: goto -48 -> 190
    //   241: astore_1
    //   242: goto -52 -> 190
    //   245: astore 5
    //   247: aload_1
    //   248: invokeinterface 139 1 0
    //   253: ldc 82
    //   255: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload 5
    //   260: athrow
    //   261: aload_0
    //   262: sipush -202
    //   265: putfield 20	com/tencent/d/e/b/a/a/a/f:mErrorCode	I
    //   268: goto -78 -> 190
    //   271: astore_1
    //   272: goto -82 -> 190
    //   275: astore_1
    //   276: goto -23 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	f
    //   0	279	1	paramContext	android.content.Context
    //   75	120	2	l	long
    //   159	3	4	bool	boolean
    //   86	7	5	localUri	android.net.Uri
    //   223	1	5	localThrowable	Throwable
    //   245	14	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	67	finally
    //   37	64	67	finally
    //   72	88	67	finally
    //   88	102	67	finally
    //   106	126	67	finally
    //   130	150	67	finally
    //   153	161	67	finally
    //   184	190	67	finally
    //   190	220	67	finally
    //   232	238	67	finally
    //   247	253	67	finally
    //   253	261	67	finally
    //   261	268	67	finally
    //   88	102	129	java/lang/Throwable
    //   166	184	223	java/lang/Throwable
    //   232	238	241	java/lang/Throwable
    //   166	184	245	finally
    //   225	232	245	finally
    //   184	190	271	java/lang/Throwable
    //   247	253	275	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */