package com.tencent.e.e.a;

import android.util.SparseArray;
import com.tencent.e.e.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class e$3
  extends c
{
  e$3(e parame, int paramInt1, int paramInt2, int paramInt3, SparseArray paramSparseArray, List paramList) {}
  
  /* Error */
  public final void dUF()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 23	com/tencent/e/e/a/e$3:BkG	Lcom/tencent/e/e/a/e;
    //   9: astore_3
    //   10: aload_3
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 25	com/tencent/e/e/a/e$3:BkH	I
    //   16: aload_0
    //   17: getfield 27	com/tencent/e/e/a/e$3:caF	I
    //   20: aload_0
    //   21: getfield 23	com/tencent/e/e/a/e$3:BkG	Lcom/tencent/e/e/a/e;
    //   24: invokestatic 53	com/tencent/e/e/a/e:a	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/d;
    //   27: getfield 59	com/tencent/e/e/a/d:context	Landroid/content/Context;
    //   30: aload_0
    //   31: getfield 29	com/tencent/e/e/a/e$3:vjJ	I
    //   34: aload_0
    //   35: getfield 31	com/tencent/e/e/a/e$3:BkI	Landroid/util/SparseArray;
    //   38: aload_0
    //   39: getfield 33	com/tencent/e/e/a/e$3:BkJ	Ljava/util/List;
    //   42: invokestatic 64	com/tencent/e/e/a/a/b:a	(IILandroid/content/Context;ILandroid/util/SparseArray;Ljava/util/List;)Lcom/tencent/e/e/a/b/a;
    //   45: astore 4
    //   47: aload_3
    //   48: monitorexit
    //   49: invokestatic 70	com/tencent/e/e/a/a/h:dUM	()Lcom/tencent/e/e/a/a/h;
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 25	com/tencent/e/e/a/e$3:BkH	I
    //   58: istore_1
    //   59: aload_0
    //   60: getfield 27	com/tencent/e/e/a/e$3:caF	I
    //   63: istore_2
    //   64: aload 4
    //   66: invokevirtual 76	com/tencent/e/e/a/b/a:toByteArray	()[B
    //   69: invokestatic 82	com/tencent/e/f/b:compress	([B)[B
    //   72: invokestatic 87	com/tencent/e/f/c:dUP	()[B
    //   75: invokestatic 91	com/tencent/e/f/c:m	([B[B)[B
    //   78: astore 6
    //   80: aload 6
    //   82: ifnull +89 -> 171
    //   85: aload 5
    //   87: getfield 94	com/tencent/e/e/a/a/h:mContext	Landroid/content/Context;
    //   90: ldc 96
    //   92: iconst_0
    //   93: invokevirtual 102	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   96: astore_3
    //   97: aload_3
    //   98: ifnonnull +116 -> 214
    //   101: ldc 104
    //   103: astore_3
    //   104: aload_3
    //   105: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +63 -> 171
    //   111: aconst_null
    //   112: astore 4
    //   114: new 112	java/io/BufferedOutputStream
    //   117: dup
    //   118: new 114	java/io/FileOutputStream
    //   121: dup
    //   122: aload_3
    //   123: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: invokespecial 120	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: astore_3
    //   130: aload_3
    //   131: aload 6
    //   133: invokevirtual 124	java/io/BufferedOutputStream:write	([B)V
    //   136: aload_3
    //   137: invokevirtual 127	java/io/BufferedOutputStream:flush	()V
    //   140: aload_3
    //   141: invokestatic 133	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   144: aload 5
    //   146: iload_1
    //   147: iload_2
    //   148: invokevirtual 137	com/tencent/e/e/a/a/h:il	(II)Ljava/lang/String;
    //   151: astore_3
    //   152: aload_3
    //   153: invokestatic 110	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +15 -> 171
    //   159: new 139	java/io/File
    //   162: dup
    //   163: aload_3
    //   164: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokevirtual 143	java/io/File:delete	()Z
    //   170: pop
    //   171: aload_0
    //   172: getfield 23	com/tencent/e/e/a/e$3:BkG	Lcom/tencent/e/e/a/e;
    //   175: invokestatic 147	com/tencent/e/e/a/e:h	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/b;
    //   178: ifnull +11 -> 189
    //   181: aload_0
    //   182: getfield 23	com/tencent/e/e/a/e$3:BkG	Lcom/tencent/e/e/a/e;
    //   185: invokestatic 147	com/tencent/e/e/a/e:h	(Lcom/tencent/e/e/a/e;)Lcom/tencent/e/e/a/b;
    //   188: pop
    //   189: ldc 43
    //   191: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: return
    //   195: astore 4
    //   197: aload_3
    //   198: monitorexit
    //   199: ldc 43
    //   201: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload 4
    //   206: athrow
    //   207: astore_3
    //   208: ldc 43
    //   210: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: return
    //   214: new 152	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   221: aload_3
    //   222: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   225: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: getstatic 165	java/io/File:separator	Ljava/lang/String;
    //   231: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_1
    //   235: iload_2
    //   236: invokestatic 168	com/tencent/e/e/a/a/h:im	(II)Ljava/lang/String;
    //   239: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 170
    //   244: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   250: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: astore_3
    //   257: goto -153 -> 104
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_3
    //   263: aload_3
    //   264: invokestatic 133	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   267: goto -123 -> 144
    //   270: astore_3
    //   271: aload 4
    //   273: invokestatic 133	com/tencent/e/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   276: ldc 43
    //   278: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_3
    //   282: athrow
    //   283: astore 5
    //   285: aload_3
    //   286: astore 4
    //   288: aload 5
    //   290: astore_3
    //   291: goto -20 -> 271
    //   294: astore 4
    //   296: goto -33 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	3
    //   58	177	1	i	int
    //   63	173	2	j	int
    //   9	189	3	localObject1	java.lang.Object
    //   207	15	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   256	1	3	str	java.lang.String
    //   260	1	3	localThrowable1	java.lang.Throwable
    //   262	2	3	localCloseable1	java.io.Closeable
    //   270	16	3	localObject2	java.lang.Object
    //   290	1	3	localObject3	java.lang.Object
    //   45	68	4	locala	com.tencent.e.e.a.b.a
    //   195	77	4	localCloseable2	java.io.Closeable
    //   286	1	4	localObject4	java.lang.Object
    //   294	1	4	localThrowable2	java.lang.Throwable
    //   52	93	5	localh	com.tencent.e.e.a.a.h
    //   283	6	5	localObject5	java.lang.Object
    //   78	54	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	49	195	finally
    //   197	199	195	finally
    //   5	12	207	java/lang/IllegalArgumentException
    //   199	207	207	java/lang/IllegalArgumentException
    //   114	130	260	java/lang/Throwable
    //   114	130	270	finally
    //   130	140	283	finally
    //   130	140	294	java/lang/Throwable
  }
  
  public final void dUG()
  {
    AppMethodBeat.i(114539);
    if (e.f(this.BkG) != null) {
      e.f(this.BkG);
    }
    AppMethodBeat.o(114539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.e.3
 * JD-Core Version:    0.7.0.1
 */