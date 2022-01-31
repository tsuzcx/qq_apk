package com.tencent.d.e.a;

import android.util.SparseArray;
import com.tencent.d.e.a.a.c;
import java.util.List;

final class e$3
  extends c
{
  e$3(e parame, int paramInt1, int paramInt2, int paramInt3, SparseArray paramSparseArray, List paramList) {}
  
  /* Error */
  public final void cOQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/d/e/a/e$3:wNh	Lcom/tencent/d/e/a/e;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 25	com/tencent/d/e/a/e$3:wNi	I
    //   11: aload_0
    //   12: getfield 27	com/tencent/d/e/a/e$3:byD	I
    //   15: aload_0
    //   16: getfield 23	com/tencent/d/e/a/e$3:wNh	Lcom/tencent/d/e/a/e;
    //   19: invokestatic 46	com/tencent/d/e/a/e:a	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/d;
    //   22: getfield 52	com/tencent/d/e/a/d:context	Landroid/content/Context;
    //   25: aload_0
    //   26: getfield 29	com/tencent/d/e/a/e$3:rtD	I
    //   29: aload_0
    //   30: getfield 31	com/tencent/d/e/a/e$3:wNj	Landroid/util/SparseArray;
    //   33: aload_0
    //   34: getfield 33	com/tencent/d/e/a/e$3:wNk	Ljava/util/List;
    //   37: invokestatic 57	com/tencent/d/e/a/a/b:a	(IILandroid/content/Context;ILandroid/util/SparseArray;Ljava/util/List;)Lcom/tencent/d/e/a/b/a;
    //   40: astore 4
    //   42: aload_3
    //   43: monitorexit
    //   44: invokestatic 63	com/tencent/d/e/a/a/h:cOW	()Lcom/tencent/d/e/a/a/h;
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 25	com/tencent/d/e/a/e$3:wNi	I
    //   53: istore_1
    //   54: aload_0
    //   55: getfield 27	com/tencent/d/e/a/e$3:byD	I
    //   58: istore_2
    //   59: aload 4
    //   61: invokevirtual 69	com/tencent/d/e/a/b/a:toByteArray	()[B
    //   64: invokestatic 75	com/tencent/d/f/b:l	([B)[B
    //   67: invokestatic 80	com/tencent/d/f/c:cOZ	()[B
    //   70: invokestatic 84	com/tencent/d/f/c:j	([B[B)[B
    //   73: astore 6
    //   75: aload 6
    //   77: ifnull +89 -> 166
    //   80: aload 5
    //   82: getfield 87	com/tencent/d/e/a/a/h:mContext	Landroid/content/Context;
    //   85: ldc 89
    //   87: iconst_0
    //   88: invokevirtual 95	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   91: astore_3
    //   92: aload_3
    //   93: ifnonnull +101 -> 194
    //   96: ldc 97
    //   98: astore_3
    //   99: aload_3
    //   100: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +63 -> 166
    //   106: aconst_null
    //   107: astore 4
    //   109: new 105	java/io/BufferedOutputStream
    //   112: dup
    //   113: new 107	java/io/FileOutputStream
    //   116: dup
    //   117: aload_3
    //   118: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 113	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   124: astore_3
    //   125: aload_3
    //   126: aload 6
    //   128: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
    //   131: aload_3
    //   132: invokevirtual 120	java/io/BufferedOutputStream:flush	()V
    //   135: aload_3
    //   136: invokestatic 126	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   139: aload 5
    //   141: iload_1
    //   142: iload_2
    //   143: invokevirtual 130	com/tencent/d/e/a/a/h:gd	(II)Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   151: ifne +15 -> 166
    //   154: new 132	java/io/File
    //   157: dup
    //   158: aload_3
    //   159: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokevirtual 136	java/io/File:delete	()Z
    //   165: pop
    //   166: aload_0
    //   167: getfield 23	com/tencent/d/e/a/e$3:wNh	Lcom/tencent/d/e/a/e;
    //   170: invokestatic 140	com/tencent/d/e/a/e:h	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/b;
    //   173: ifnull +11 -> 184
    //   176: aload_0
    //   177: getfield 23	com/tencent/d/e/a/e$3:wNh	Lcom/tencent/d/e/a/e;
    //   180: invokestatic 140	com/tencent/d/e/a/e:h	(Lcom/tencent/d/e/a/e;)Lcom/tencent/d/e/a/b;
    //   183: pop
    //   184: return
    //   185: astore 4
    //   187: aload_3
    //   188: monitorexit
    //   189: aload 4
    //   191: athrow
    //   192: astore_3
    //   193: return
    //   194: new 142	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   201: aload_3
    //   202: invokevirtual 147	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: getstatic 155	java/io/File:separator	Ljava/lang/String;
    //   211: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_1
    //   215: iload_2
    //   216: invokestatic 158	com/tencent/d/e/a/a/h:ge	(II)Ljava/lang/String;
    //   219: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 160
    //   224: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   230: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore_3
    //   237: goto -138 -> 99
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: invokestatic 126	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   247: goto -108 -> 139
    //   250: astore_3
    //   251: aload 4
    //   253: invokestatic 126	com/tencent/d/f/f:closeQuietly	(Ljava/io/Closeable;)V
    //   256: aload_3
    //   257: athrow
    //   258: astore 5
    //   260: aload_3
    //   261: astore 4
    //   263: aload 5
    //   265: astore_3
    //   266: goto -15 -> 251
    //   269: astore 4
    //   271: goto -28 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	3
    //   53	162	1	i	int
    //   58	158	2	j	int
    //   4	184	3	localObject1	java.lang.Object
    //   192	10	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   236	1	3	str	java.lang.String
    //   240	1	3	localThrowable1	java.lang.Throwable
    //   242	2	3	localCloseable1	java.io.Closeable
    //   250	11	3	localObject2	java.lang.Object
    //   265	1	3	localObject3	java.lang.Object
    //   40	68	4	locala	com.tencent.d.e.a.b.a
    //   185	67	4	localCloseable2	java.io.Closeable
    //   261	1	4	localObject4	java.lang.Object
    //   269	1	4	localThrowable2	java.lang.Throwable
    //   47	93	5	localh	com.tencent.d.e.a.a.h
    //   258	6	5	localObject5	java.lang.Object
    //   73	54	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	44	185	finally
    //   187	189	185	finally
    //   0	7	192	java/lang/IllegalArgumentException
    //   189	192	192	java/lang/IllegalArgumentException
    //   109	125	240	java/lang/Throwable
    //   109	125	250	finally
    //   125	135	258	finally
    //   125	135	269	java/lang/Throwable
  }
  
  public final void cOR()
  {
    if (e.f(this.wNh) != null) {
      e.f(this.wNh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.a.e.3
 * JD-Core Version:    0.7.0.1
 */