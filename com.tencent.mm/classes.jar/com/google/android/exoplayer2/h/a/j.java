package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.b;
import com.google.android.exoplayer2.i.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class j
{
  private q bxK;
  final HashMap<String, i> byh;
  final SparseArray<String> byi;
  final b byj;
  private final Cipher byk;
  private final SecretKeySpec byl;
  private final boolean bym;
  boolean byn;
  
  public j(File paramFile)
  {
    AppMethodBeat.i(92981);
    this.bym = false;
    this.byk = null;
    this.byl = null;
    this.byh = new HashMap();
    this.byi = new SparseArray();
    this.byj = new b(new File(paramFile, "cached_content_index.exi"));
    AppMethodBeat.o(92981);
  }
  
  private static int a(SparseArray<String> paramSparseArray)
  {
    AppMethodBeat.i(92992);
    int k = paramSparseArray.size();
    if (k == 0) {}
    int j;
    for (int i = 0;; i = paramSparseArray.keyAt(k - 1) + 1)
    {
      j = i;
      if (i >= 0) {
        break;
      }
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        j = i;
        if (i != paramSparseArray.keyAt(i)) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(92992);
    return j;
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(92989);
    this.byh.put(parami.key, parami);
    this.byi.put(parami.id, parami.key);
    AppMethodBeat.o(92989);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(92990);
    a(parami);
    this.byn = true;
    AppMethodBeat.o(92990);
  }
  
  public final i aC(String paramString)
  {
    AppMethodBeat.i(92983);
    i locali2 = (i)this.byh.get(paramString);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = g(paramString, -1L);
    }
    AppMethodBeat.o(92983);
    return locali1;
  }
  
  public final i aD(String paramString)
  {
    AppMethodBeat.i(92984);
    paramString = (i)this.byh.get(paramString);
    AppMethodBeat.o(92984);
    return paramString;
  }
  
  public final int aE(String paramString)
  {
    AppMethodBeat.i(92985);
    int i = aC(paramString).id;
    AppMethodBeat.o(92985);
    return i;
  }
  
  public final void aF(String paramString)
  {
    AppMethodBeat.i(92986);
    paramString = (i)this.byh.remove(paramString);
    if (paramString != null)
    {
      a.checkState(paramString.byg.isEmpty());
      this.byi.remove(paramString.id);
      this.byn = true;
    }
    AppMethodBeat.o(92986);
  }
  
  final i g(String paramString, long paramLong)
  {
    AppMethodBeat.i(92991);
    paramString = new i(a(this.byi), paramString, paramLong);
    b(paramString);
    AppMethodBeat.o(92991);
    return paramString;
  }
  
  /* Error */
  final boolean vA()
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 5
    //   11: aload 5
    //   13: astore 6
    //   15: aload 8
    //   17: astore 7
    //   19: aload_0
    //   20: getfield 62	com/google/android/exoplayer2/h/a/j:byj	Lcom/google/android/exoplayer2/i/b;
    //   23: astore 9
    //   25: aload 5
    //   27: astore 6
    //   29: aload 8
    //   31: astore 7
    //   33: aload 9
    //   35: getfield 170	com/google/android/exoplayer2/i/b:byD	Ljava/io/File;
    //   38: invokevirtual 173	java/io/File:exists	()Z
    //   41: ifeq +42 -> 83
    //   44: aload 5
    //   46: astore 6
    //   48: aload 8
    //   50: astore 7
    //   52: aload 9
    //   54: getfield 176	com/google/android/exoplayer2/i/b:byC	Ljava/io/File;
    //   57: invokevirtual 179	java/io/File:delete	()Z
    //   60: pop
    //   61: aload 5
    //   63: astore 6
    //   65: aload 8
    //   67: astore 7
    //   69: aload 9
    //   71: getfield 170	com/google/android/exoplayer2/i/b:byD	Ljava/io/File;
    //   74: aload 9
    //   76: getfield 176	com/google/android/exoplayer2/i/b:byC	Ljava/io/File;
    //   79: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   82: pop
    //   83: aload 5
    //   85: astore 6
    //   87: aload 8
    //   89: astore 7
    //   91: new 185	java/io/BufferedInputStream
    //   94: dup
    //   95: new 187	java/io/FileInputStream
    //   98: dup
    //   99: aload 9
    //   101: getfield 176	com/google/android/exoplayer2/i/b:byC	Ljava/io/File;
    //   104: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   107: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore 9
    //   112: aload 5
    //   114: astore 6
    //   116: aload 8
    //   118: astore 7
    //   120: new 193	java/io/DataInputStream
    //   123: dup
    //   124: aload 9
    //   126: invokespecial 194	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: astore 5
    //   131: aload 5
    //   133: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   136: istore_1
    //   137: iload_1
    //   138: iconst_1
    //   139: if_icmpeq +15 -> 154
    //   142: aload 5
    //   144: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   147: ldc 166
    //   149: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iconst_0
    //   153: ireturn
    //   154: aload 5
    //   156: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   159: iconst_1
    //   160: iand
    //   161: ifeq +213 -> 374
    //   164: aload_0
    //   165: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   168: astore 6
    //   170: aload 6
    //   172: ifnonnull +15 -> 187
    //   175: aload 5
    //   177: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   180: ldc 166
    //   182: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iconst_0
    //   186: ireturn
    //   187: bipush 16
    //   189: newarray byte
    //   191: astore 6
    //   193: aload 5
    //   195: aload 6
    //   197: invokevirtual 207	java/io/DataInputStream:readFully	([B)V
    //   200: new 209	javax/crypto/spec/IvParameterSpec
    //   203: dup
    //   204: aload 6
    //   206: invokespecial 211	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   209: astore 6
    //   211: aload_0
    //   212: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   215: iconst_2
    //   216: aload_0
    //   217: getfield 39	com/google/android/exoplayer2/h/a/j:byl	Ljavax/crypto/spec/SecretKeySpec;
    //   220: aload 6
    //   222: invokevirtual 217	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   225: new 193	java/io/DataInputStream
    //   228: dup
    //   229: new 219	javax/crypto/CipherInputStream
    //   232: dup
    //   233: aload 9
    //   235: aload_0
    //   236: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   239: invokespecial 222	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   242: invokespecial 194	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   245: astore 6
    //   247: aload 6
    //   249: astore 5
    //   251: aload 5
    //   253: astore 6
    //   255: aload 5
    //   257: astore 7
    //   259: aload 5
    //   261: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   264: istore_3
    //   265: iconst_0
    //   266: istore_1
    //   267: iconst_0
    //   268: istore_2
    //   269: iload_2
    //   270: iload_3
    //   271: if_icmpge +118 -> 389
    //   274: aload 5
    //   276: astore 6
    //   278: aload 5
    //   280: astore 7
    //   282: new 83	com/google/android/exoplayer2/h/a/i
    //   285: dup
    //   286: aload 5
    //   288: invokespecial 225	com/google/android/exoplayer2/h/a/i:<init>	(Ljava/io/DataInputStream;)V
    //   291: astore 8
    //   293: aload 5
    //   295: astore 6
    //   297: aload 5
    //   299: astore 7
    //   301: aload_0
    //   302: aload 8
    //   304: invokespecial 102	com/google/android/exoplayer2/h/a/j:a	(Lcom/google/android/exoplayer2/h/a/i;)V
    //   307: aload 5
    //   309: astore 6
    //   311: aload 5
    //   313: astore 7
    //   315: aload 8
    //   317: invokevirtual 228	com/google/android/exoplayer2/h/a/i:vx	()I
    //   320: istore 4
    //   322: iload_1
    //   323: iload 4
    //   325: iadd
    //   326: istore_1
    //   327: iload_2
    //   328: iconst_1
    //   329: iadd
    //   330: istore_2
    //   331: goto -62 -> 269
    //   334: astore 6
    //   336: new 230	java/lang/IllegalStateException
    //   339: dup
    //   340: aload 6
    //   342: invokespecial 233	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   345: astore 6
    //   347: ldc 166
    //   349: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload 6
    //   354: athrow
    //   355: astore 6
    //   357: aload 5
    //   359: ifnull +8 -> 367
    //   362: aload 5
    //   364: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   367: ldc 166
    //   369: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: iconst_0
    //   373: ireturn
    //   374: aload_0
    //   375: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   378: ifnull +8 -> 386
    //   381: aload_0
    //   382: iconst_1
    //   383: putfield 104	com/google/android/exoplayer2/h/a/j:byn	Z
    //   386: goto -135 -> 251
    //   389: aload 5
    //   391: astore 6
    //   393: aload 5
    //   395: astore 7
    //   397: aload 5
    //   399: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   402: istore_2
    //   403: iload_2
    //   404: iload_1
    //   405: if_icmpeq +15 -> 420
    //   408: aload 5
    //   410: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   413: ldc 166
    //   415: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: iconst_0
    //   419: ireturn
    //   420: aload 5
    //   422: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   425: ldc 166
    //   427: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: iconst_1
    //   431: ireturn
    //   432: astore 5
    //   434: aload 6
    //   436: ifnull +8 -> 444
    //   439: aload 6
    //   441: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   444: ldc 166
    //   446: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_0
    //   450: ireturn
    //   451: astore 5
    //   453: aload 7
    //   455: ifnull +8 -> 463
    //   458: aload 7
    //   460: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   463: ldc 166
    //   465: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: aload 5
    //   470: athrow
    //   471: astore 6
    //   473: aload 5
    //   475: astore 7
    //   477: aload 6
    //   479: astore 5
    //   481: goto -28 -> 453
    //   484: astore 6
    //   486: aload 5
    //   488: astore 6
    //   490: goto -56 -> 434
    //   493: astore 5
    //   495: aconst_null
    //   496: astore 5
    //   498: goto -141 -> 357
    //   501: astore 6
    //   503: goto -146 -> 357
    //   506: astore 6
    //   508: goto -172 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	j
    //   136	270	1	i	int
    //   268	138	2	j	int
    //   264	8	3	k	int
    //   320	6	4	m	int
    //   9	412	5	localObject1	Object
    //   432	1	5	localIOException1	java.io.IOException
    //   451	23	5	localObject2	Object
    //   479	8	5	localObject3	Object
    //   493	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   496	1	5	localObject4	Object
    //   13	297	6	localObject5	Object
    //   334	7	6	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   345	8	6	localIllegalStateException	java.lang.IllegalStateException
    //   355	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   391	49	6	localObject6	Object
    //   471	7	6	localObject7	Object
    //   484	1	6	localIOException2	java.io.IOException
    //   488	1	6	localObject8	Object
    //   501	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   506	1	6	localInvalidKeyException	java.security.InvalidKeyException
    //   17	459	7	localObject9	Object
    //   6	310	8	locali	i
    //   23	211	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   211	225	334	java/security/InvalidAlgorithmParameterException
    //   131	137	355	java/io/FileNotFoundException
    //   154	170	355	java/io/FileNotFoundException
    //   187	211	355	java/io/FileNotFoundException
    //   211	225	355	java/io/FileNotFoundException
    //   225	247	355	java/io/FileNotFoundException
    //   336	355	355	java/io/FileNotFoundException
    //   374	386	355	java/io/FileNotFoundException
    //   19	25	432	java/io/IOException
    //   33	44	432	java/io/IOException
    //   52	61	432	java/io/IOException
    //   69	83	432	java/io/IOException
    //   91	112	432	java/io/IOException
    //   120	131	432	java/io/IOException
    //   259	265	432	java/io/IOException
    //   282	293	432	java/io/IOException
    //   301	307	432	java/io/IOException
    //   315	322	432	java/io/IOException
    //   397	403	432	java/io/IOException
    //   19	25	451	finally
    //   33	44	451	finally
    //   52	61	451	finally
    //   69	83	451	finally
    //   91	112	451	finally
    //   120	131	451	finally
    //   259	265	451	finally
    //   282	293	451	finally
    //   301	307	451	finally
    //   315	322	451	finally
    //   397	403	451	finally
    //   131	137	471	finally
    //   154	170	471	finally
    //   187	211	471	finally
    //   211	225	471	finally
    //   225	247	471	finally
    //   336	355	471	finally
    //   374	386	471	finally
    //   131	137	484	java/io/IOException
    //   154	170	484	java/io/IOException
    //   187	211	484	java/io/IOException
    //   211	225	484	java/io/IOException
    //   225	247	484	java/io/IOException
    //   336	355	484	java/io/IOException
    //   374	386	484	java/io/IOException
    //   19	25	493	java/io/FileNotFoundException
    //   33	44	493	java/io/FileNotFoundException
    //   52	61	493	java/io/FileNotFoundException
    //   69	83	493	java/io/FileNotFoundException
    //   91	112	493	java/io/FileNotFoundException
    //   120	131	493	java/io/FileNotFoundException
    //   259	265	501	java/io/FileNotFoundException
    //   282	293	501	java/io/FileNotFoundException
    //   301	307	501	java/io/FileNotFoundException
    //   315	322	501	java/io/FileNotFoundException
    //   397	403	501	java/io/FileNotFoundException
    //   211	225	506	java/security/InvalidKeyException
  }
  
  /* Error */
  public final void vy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc 235
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 104	com/google/android/exoplayer2/h/a/j:byn	Z
    //   13: ifne +9 -> 22
    //   16: ldc 235
    //   18: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: getfield 62	com/google/android/exoplayer2/h/a/j:byj	Lcom/google/android/exoplayer2/i/b;
    //   26: invokevirtual 239	com/google/android/exoplayer2/i/b:vC	()Ljava/io/OutputStream;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 241	com/google/android/exoplayer2/h/a/j:bxK	Lcom/google/android/exoplayer2/i/q;
    //   35: ifnonnull +296 -> 331
    //   38: aload_0
    //   39: new 243	com/google/android/exoplayer2/i/q
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 246	com/google/android/exoplayer2/i/q:<init>	(Ljava/io/OutputStream;)V
    //   48: putfield 241	com/google/android/exoplayer2/h/a/j:bxK	Lcom/google/android/exoplayer2/i/q;
    //   51: new 248	java/io/DataOutputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 241	com/google/android/exoplayer2/h/a/j:bxK	Lcom/google/android/exoplayer2/i/q;
    //   59: invokespecial 249	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore 5
    //   64: aload 5
    //   66: astore 4
    //   68: aload 5
    //   70: iconst_1
    //   71: invokevirtual 252	java/io/DataOutputStream:writeInt	(I)V
    //   74: aload 5
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 35	com/google/android/exoplayer2/h/a/j:bym	Z
    //   82: ifeq +302 -> 384
    //   85: aload 5
    //   87: astore 4
    //   89: aload_0
    //   90: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   93: ifnull +291 -> 384
    //   96: iconst_1
    //   97: istore_1
    //   98: goto +404 -> 502
    //   101: aload 5
    //   103: astore 4
    //   105: aload 5
    //   107: iload_2
    //   108: invokevirtual 252	java/io/DataOutputStream:writeInt	(I)V
    //   111: aload 5
    //   113: astore_3
    //   114: iload_1
    //   115: ifeq +103 -> 218
    //   118: aload 5
    //   120: astore 4
    //   122: bipush 16
    //   124: newarray byte
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: new 254	java/util/Random
    //   134: dup
    //   135: invokespecial 255	java/util/Random:<init>	()V
    //   138: aload_3
    //   139: invokevirtual 258	java/util/Random:nextBytes	([B)V
    //   142: aload 5
    //   144: astore 4
    //   146: aload 5
    //   148: aload_3
    //   149: invokevirtual 261	java/io/DataOutputStream:write	([B)V
    //   152: aload 5
    //   154: astore 4
    //   156: new 209	javax/crypto/spec/IvParameterSpec
    //   159: dup
    //   160: aload_3
    //   161: invokespecial 211	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   164: astore_3
    //   165: aload 5
    //   167: astore 4
    //   169: aload_0
    //   170: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   173: iconst_1
    //   174: aload_0
    //   175: getfield 39	com/google/android/exoplayer2/h/a/j:byl	Ljavax/crypto/spec/SecretKeySpec;
    //   178: aload_3
    //   179: invokevirtual 217	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   182: aload 5
    //   184: astore 4
    //   186: aload 5
    //   188: invokevirtual 264	java/io/DataOutputStream:flush	()V
    //   191: aload 5
    //   193: astore 4
    //   195: new 248	java/io/DataOutputStream
    //   198: dup
    //   199: new 266	javax/crypto/CipherOutputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 241	com/google/android/exoplayer2/h/a/j:bxK	Lcom/google/android/exoplayer2/i/q;
    //   207: aload_0
    //   208: getfield 37	com/google/android/exoplayer2/h/a/j:byk	Ljavax/crypto/Cipher;
    //   211: invokespecial 269	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   214: invokespecial 249	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   217: astore_3
    //   218: aload_3
    //   219: astore 4
    //   221: aload_3
    //   222: aload_0
    //   223: getfield 44	com/google/android/exoplayer2/h/a/j:byh	Ljava/util/HashMap;
    //   226: invokevirtual 270	java/util/HashMap:size	()I
    //   229: invokevirtual 252	java/io/DataOutputStream:writeInt	(I)V
    //   232: aload_3
    //   233: astore 4
    //   235: aload_0
    //   236: getfield 44	com/google/android/exoplayer2/h/a/j:byh	Ljava/util/HashMap;
    //   239: invokevirtual 274	java/util/HashMap:values	()Ljava/util/Collection;
    //   242: invokeinterface 280 1 0
    //   247: astore 5
    //   249: iconst_0
    //   250: istore_1
    //   251: aload_3
    //   252: astore 4
    //   254: aload 5
    //   256: invokeinterface 285 1 0
    //   261: ifeq +170 -> 431
    //   264: aload_3
    //   265: astore 4
    //   267: aload 5
    //   269: invokeinterface 289 1 0
    //   274: checkcast 83	com/google/android/exoplayer2/h/a/i
    //   277: astore 6
    //   279: aload_3
    //   280: astore 4
    //   282: aload_3
    //   283: aload 6
    //   285: getfield 95	com/google/android/exoplayer2/h/a/i:id	I
    //   288: invokevirtual 252	java/io/DataOutputStream:writeInt	(I)V
    //   291: aload_3
    //   292: astore 4
    //   294: aload_3
    //   295: aload 6
    //   297: getfield 87	com/google/android/exoplayer2/h/a/i:key	Ljava/lang/String;
    //   300: invokevirtual 292	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   303: aload_3
    //   304: astore 4
    //   306: aload_3
    //   307: aload 6
    //   309: getfield 296	com/google/android/exoplayer2/h/a/i:length	J
    //   312: invokevirtual 300	java/io/DataOutputStream:writeLong	(J)V
    //   315: aload_3
    //   316: astore 4
    //   318: aload 6
    //   320: invokevirtual 228	com/google/android/exoplayer2/h/a/i:vx	()I
    //   323: istore_2
    //   324: iload_2
    //   325: iload_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -77 -> 251
    //   331: aload_0
    //   332: getfield 241	com/google/android/exoplayer2/h/a/j:bxK	Lcom/google/android/exoplayer2/i/q;
    //   335: aload 4
    //   337: invokevirtual 302	com/google/android/exoplayer2/i/q:a	(Ljava/io/OutputStream;)V
    //   340: goto -289 -> 51
    //   343: astore 4
    //   345: new 304	com/google/android/exoplayer2/h/a/a$a
    //   348: dup
    //   349: aload 4
    //   351: invokespecial 307	com/google/android/exoplayer2/h/a/a$a:<init>	(Ljava/io/IOException;)V
    //   354: astore 4
    //   356: ldc 235
    //   358: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload 4
    //   363: athrow
    //   364: astore 5
    //   366: aload_3
    //   367: astore 4
    //   369: aload 5
    //   371: astore_3
    //   372: aload 4
    //   374: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   377: ldc 235
    //   379: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload_3
    //   383: athrow
    //   384: iconst_0
    //   385: istore_1
    //   386: goto +116 -> 502
    //   389: iconst_0
    //   390: istore_2
    //   391: goto -290 -> 101
    //   394: astore_3
    //   395: aload 5
    //   397: astore 4
    //   399: new 230	java/lang/IllegalStateException
    //   402: dup
    //   403: aload_3
    //   404: invokespecial 233	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   407: astore_3
    //   408: aload 5
    //   410: astore 4
    //   412: ldc 235
    //   414: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload 5
    //   419: astore 4
    //   421: aload_3
    //   422: athrow
    //   423: astore 4
    //   425: aload 5
    //   427: astore_3
    //   428: goto -83 -> 345
    //   431: aload_3
    //   432: astore 4
    //   434: aload_3
    //   435: iload_1
    //   436: invokevirtual 252	java/io/DataOutputStream:writeInt	(I)V
    //   439: aload_3
    //   440: astore 4
    //   442: aload_0
    //   443: getfield 62	com/google/android/exoplayer2/h/a/j:byj	Lcom/google/android/exoplayer2/i/b;
    //   446: astore 5
    //   448: aload_3
    //   449: astore 4
    //   451: aload_3
    //   452: invokevirtual 312	java/io/OutputStream:close	()V
    //   455: aload_3
    //   456: astore 4
    //   458: aload 5
    //   460: getfield 170	com/google/android/exoplayer2/i/b:byD	Ljava/io/File;
    //   463: invokevirtual 179	java/io/File:delete	()Z
    //   466: pop
    //   467: aconst_null
    //   468: invokestatic 203	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   471: aload_0
    //   472: iconst_0
    //   473: putfield 104	com/google/android/exoplayer2/h/a/j:byn	Z
    //   476: ldc 235
    //   478: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: return
    //   482: astore_3
    //   483: aconst_null
    //   484: astore 4
    //   486: goto -114 -> 372
    //   489: astore_3
    //   490: goto -118 -> 372
    //   493: astore 4
    //   495: goto -150 -> 345
    //   498: astore_3
    //   499: goto -104 -> 395
    //   502: iload_1
    //   503: ifeq -114 -> 389
    //   506: goto -405 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	j
    //   97	406	1	i	int
    //   3	388	2	j	int
    //   1	382	3	localObject1	Object
    //   394	10	3	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   407	49	3	localObject2	Object
    //   482	1	3	localObject3	Object
    //   489	1	3	localObject4	Object
    //   498	1	3	localInvalidKeyException	java.security.InvalidKeyException
    //   29	307	4	localObject5	Object
    //   343	7	4	localIOException1	java.io.IOException
    //   354	66	4	localObject6	Object
    //   423	1	4	localIOException2	java.io.IOException
    //   432	53	4	localObject7	Object
    //   493	1	4	localIOException3	java.io.IOException
    //   62	206	5	localObject8	Object
    //   364	62	5	localObject9	Object
    //   446	13	5	localb	b
    //   277	42	6	locali	i
    // Exception table:
    //   from	to	target	type
    //   22	51	343	java/io/IOException
    //   51	64	343	java/io/IOException
    //   331	340	343	java/io/IOException
    //   345	364	364	finally
    //   169	182	394	java/security/InvalidAlgorithmParameterException
    //   68	74	423	java/io/IOException
    //   78	85	423	java/io/IOException
    //   89	96	423	java/io/IOException
    //   105	111	423	java/io/IOException
    //   122	127	423	java/io/IOException
    //   131	142	423	java/io/IOException
    //   146	152	423	java/io/IOException
    //   156	165	423	java/io/IOException
    //   169	182	423	java/io/IOException
    //   186	191	423	java/io/IOException
    //   195	218	423	java/io/IOException
    //   399	408	423	java/io/IOException
    //   412	417	423	java/io/IOException
    //   421	423	423	java/io/IOException
    //   22	51	482	finally
    //   51	64	482	finally
    //   331	340	482	finally
    //   68	74	489	finally
    //   78	85	489	finally
    //   89	96	489	finally
    //   105	111	489	finally
    //   122	127	489	finally
    //   131	142	489	finally
    //   146	152	489	finally
    //   156	165	489	finally
    //   169	182	489	finally
    //   186	191	489	finally
    //   195	218	489	finally
    //   221	232	489	finally
    //   235	249	489	finally
    //   254	264	489	finally
    //   267	279	489	finally
    //   282	291	489	finally
    //   294	303	489	finally
    //   306	315	489	finally
    //   318	324	489	finally
    //   399	408	489	finally
    //   412	417	489	finally
    //   421	423	489	finally
    //   434	439	489	finally
    //   442	448	489	finally
    //   451	455	489	finally
    //   458	467	489	finally
    //   221	232	493	java/io/IOException
    //   235	249	493	java/io/IOException
    //   254	264	493	java/io/IOException
    //   267	279	493	java/io/IOException
    //   282	291	493	java/io/IOException
    //   294	303	493	java/io/IOException
    //   306	315	493	java/io/IOException
    //   318	324	493	java/io/IOException
    //   434	439	493	java/io/IOException
    //   442	448	493	java/io/IOException
    //   451	455	493	java/io/IOException
    //   458	467	493	java/io/IOException
    //   169	182	498	java/security/InvalidKeyException
  }
  
  public final void vz()
  {
    AppMethodBeat.i(92987);
    Object localObject = new LinkedList();
    Iterator localIterator = this.byh.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.byg.isEmpty()) {
        ((LinkedList)localObject).add(locali.key);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      aF((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(92987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.j
 * JD-Core Version:    0.7.0.1
 */