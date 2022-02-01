package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import com.tencent.e.e.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends d
{
  /* Error */
  private static String cR(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 26	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: ldc 28
    //   11: invokestatic 34	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   14: aconst_null
    //   15: aconst_null
    //   16: iconst_1
    //   17: anewarray 36	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: aconst_null
    //   25: invokevirtual 42	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +17 -> 47
    //   33: ldc 14
    //   35: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: ldc 47
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -15 -> 29
    //   47: aload_1
    //   48: invokeinterface 53 1 0
    //   53: ifeq +91 -> 144
    //   56: aload_1
    //   57: aload_1
    //   58: ldc 55
    //   60: invokeinterface 59 2 0
    //   65: invokeinterface 63 2 0
    //   70: astore_2
    //   71: aload_2
    //   72: astore_0
    //   73: aload_1
    //   74: ifnull +11 -> 85
    //   77: aload_1
    //   78: invokeinterface 66 1 0
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 14
    //   87: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_0
    //   91: areturn
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +50 -> 144
    //   97: aload_1
    //   98: invokeinterface 66 1 0
    //   103: ldc 47
    //   105: astore_0
    //   106: goto -21 -> 85
    //   109: astore_0
    //   110: ldc 47
    //   112: astore_0
    //   113: goto -28 -> 85
    //   116: astore_0
    //   117: aload_1
    //   118: ifnull +9 -> 127
    //   121: aload_1
    //   122: invokeinterface 66 1 0
    //   127: ldc 14
    //   129: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: aload_2
    //   136: astore_0
    //   137: goto -52 -> 85
    //   140: astore_1
    //   141: goto -14 -> 127
    //   144: ldc 47
    //   146: astore_0
    //   147: goto -62 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramContext	Context
    //   0	150	1	paramString	String
    //   70	66	2	str	String
    // Exception table:
    //   from	to	target	type
    //   5	29	41	java/lang/Throwable
    //   56	71	92	java/lang/Throwable
    //   97	103	109	java/lang/Throwable
    //   56	71	116	finally
    //   77	83	134	java/lang/Throwable
    //   121	127	140	java/lang/Throwable
  }
  
  public final boolean ef(Context paramContext)
  {
    AppMethodBeat.i(224044);
    boolean bool = "0".equals(cR(paramContext, "supported"));
    AppMethodBeat.o(224044);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */