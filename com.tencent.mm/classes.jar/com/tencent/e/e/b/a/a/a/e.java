package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import com.tencent.e.e.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends d
{
  /* Error */
  private static String dl(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 24	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: ldc 26
    //   11: invokestatic 32	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   14: aconst_null
    //   15: aconst_null
    //   16: iconst_1
    //   17: anewarray 34	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: aconst_null
    //   25: invokevirtual 40	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +17 -> 47
    //   33: ldc 12
    //   35: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: ldc 45
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -15 -> 29
    //   47: aload_1
    //   48: invokeinterface 51 1 0
    //   53: ifeq +69 -> 122
    //   56: aload_1
    //   57: aload_1
    //   58: ldc 53
    //   60: invokeinterface 57 2 0
    //   65: invokeinterface 61 2 0
    //   70: astore_2
    //   71: aload_2
    //   72: astore_0
    //   73: aload_1
    //   74: ifnull +11 -> 85
    //   77: aload_1
    //   78: invokeinterface 64 1 0
    //   83: aload_2
    //   84: astore_0
    //   85: ldc 12
    //   87: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_0
    //   91: areturn
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +28 -> 122
    //   97: aload_1
    //   98: invokeinterface 64 1 0
    //   103: ldc 45
    //   105: astore_0
    //   106: goto -21 -> 85
    //   109: astore_0
    //   110: ldc 45
    //   112: astore_0
    //   113: goto -28 -> 85
    //   116: astore_0
    //   117: aload_2
    //   118: astore_0
    //   119: goto -34 -> 85
    //   122: ldc 45
    //   124: astore_0
    //   125: goto -40 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   70	48	2	str	String
    // Exception table:
    //   from	to	target	type
    //   5	29	41	finally
    //   56	71	92	finally
    //   97	103	109	finally
    //   77	83	116	finally
  }
  
  public final boolean eY(Context paramContext)
  {
    AppMethodBeat.i(218435);
    boolean bool = "0".equals(dl(paramContext, "supported"));
    AppMethodBeat.o(218435);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */