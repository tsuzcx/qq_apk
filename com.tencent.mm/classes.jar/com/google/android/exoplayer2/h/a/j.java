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
  private q bFY;
  private final boolean bGA;
  boolean bGB;
  final HashMap<String, i> bGv;
  final SparseArray<String> bGw;
  final b bGx;
  private final Cipher bGy;
  private final SecretKeySpec bGz;
  
  public j(File paramFile)
  {
    AppMethodBeat.i(92981);
    this.bGA = false;
    this.bGy = null;
    this.bGz = null;
    this.bGv = new HashMap();
    this.bGw = new SparseArray();
    this.bGx = new b(new File(paramFile, "cached_content_index.exi"));
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
    this.bGv.put(parami.key, parami);
    this.bGw.put(parami.id, parami.key);
    AppMethodBeat.o(92989);
  }
  
  private void b(i parami)
  {
    AppMethodBeat.i(92990);
    a(parami);
    this.bGB = true;
    AppMethodBeat.o(92990);
  }
  
  public final i bq(String paramString)
  {
    AppMethodBeat.i(92983);
    i locali2 = (i)this.bGv.get(paramString);
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = h(paramString, -1L);
    }
    AppMethodBeat.o(92983);
    return locali1;
  }
  
  public final i br(String paramString)
  {
    AppMethodBeat.i(92984);
    paramString = (i)this.bGv.get(paramString);
    AppMethodBeat.o(92984);
    return paramString;
  }
  
  public final int bs(String paramString)
  {
    AppMethodBeat.i(92985);
    int i = bq(paramString).id;
    AppMethodBeat.o(92985);
    return i;
  }
  
  public final void bt(String paramString)
  {
    AppMethodBeat.i(92986);
    paramString = (i)this.bGv.remove(paramString);
    if (paramString != null)
    {
      a.checkState(paramString.bGu.isEmpty());
      this.bGw.remove(paramString.id);
      this.bGB = true;
    }
    AppMethodBeat.o(92986);
  }
  
  final i h(String paramString, long paramLong)
  {
    AppMethodBeat.i(92991);
    paramString = new i(a(this.bGw), paramString, paramLong);
    b(paramString);
    AppMethodBeat.o(92991);
    return paramString;
  }
  
  /* Error */
  public final void wU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: ldc 164
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 104	com/google/android/exoplayer2/h/a/j:bGB	Z
    //   13: ifne +9 -> 22
    //   16: ldc 164
    //   18: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: getfield 62	com/google/android/exoplayer2/h/a/j:bGx	Lcom/google/android/exoplayer2/i/b;
    //   26: invokevirtual 168	com/google/android/exoplayer2/i/b:wY	()Ljava/io/OutputStream;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 170	com/google/android/exoplayer2/h/a/j:bFY	Lcom/google/android/exoplayer2/i/q;
    //   35: ifnonnull +296 -> 331
    //   38: aload_0
    //   39: new 172	com/google/android/exoplayer2/i/q
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 175	com/google/android/exoplayer2/i/q:<init>	(Ljava/io/OutputStream;)V
    //   48: putfield 170	com/google/android/exoplayer2/h/a/j:bFY	Lcom/google/android/exoplayer2/i/q;
    //   51: new 177	java/io/DataOutputStream
    //   54: dup
    //   55: aload_0
    //   56: getfield 170	com/google/android/exoplayer2/h/a/j:bFY	Lcom/google/android/exoplayer2/i/q;
    //   59: invokespecial 178	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore 5
    //   64: aload 5
    //   66: astore 4
    //   68: aload 5
    //   70: iconst_1
    //   71: invokevirtual 181	java/io/DataOutputStream:writeInt	(I)V
    //   74: aload 5
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 35	com/google/android/exoplayer2/h/a/j:bGA	Z
    //   82: ifeq +302 -> 384
    //   85: aload 5
    //   87: astore 4
    //   89: aload_0
    //   90: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   93: ifnull +291 -> 384
    //   96: iconst_1
    //   97: istore_1
    //   98: goto +404 -> 502
    //   101: aload 5
    //   103: astore 4
    //   105: aload 5
    //   107: iload_2
    //   108: invokevirtual 181	java/io/DataOutputStream:writeInt	(I)V
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
    //   131: new 183	java/util/Random
    //   134: dup
    //   135: invokespecial 184	java/util/Random:<init>	()V
    //   138: aload_3
    //   139: invokevirtual 188	java/util/Random:nextBytes	([B)V
    //   142: aload 5
    //   144: astore 4
    //   146: aload 5
    //   148: aload_3
    //   149: invokevirtual 191	java/io/DataOutputStream:write	([B)V
    //   152: aload 5
    //   154: astore 4
    //   156: new 193	javax/crypto/spec/IvParameterSpec
    //   159: dup
    //   160: aload_3
    //   161: invokespecial 195	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   164: astore_3
    //   165: aload 5
    //   167: astore 4
    //   169: aload_0
    //   170: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   173: iconst_1
    //   174: aload_0
    //   175: getfield 39	com/google/android/exoplayer2/h/a/j:bGz	Ljavax/crypto/spec/SecretKeySpec;
    //   178: aload_3
    //   179: invokevirtual 201	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   182: aload 5
    //   184: astore 4
    //   186: aload 5
    //   188: invokevirtual 204	java/io/DataOutputStream:flush	()V
    //   191: aload 5
    //   193: astore 4
    //   195: new 177	java/io/DataOutputStream
    //   198: dup
    //   199: new 206	javax/crypto/CipherOutputStream
    //   202: dup
    //   203: aload_0
    //   204: getfield 170	com/google/android/exoplayer2/h/a/j:bFY	Lcom/google/android/exoplayer2/i/q;
    //   207: aload_0
    //   208: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   211: invokespecial 209	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   214: invokespecial 178	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   217: astore_3
    //   218: aload_3
    //   219: astore 4
    //   221: aload_3
    //   222: aload_0
    //   223: getfield 44	com/google/android/exoplayer2/h/a/j:bGv	Ljava/util/HashMap;
    //   226: invokevirtual 210	java/util/HashMap:size	()I
    //   229: invokevirtual 181	java/io/DataOutputStream:writeInt	(I)V
    //   232: aload_3
    //   233: astore 4
    //   235: aload_0
    //   236: getfield 44	com/google/android/exoplayer2/h/a/j:bGv	Ljava/util/HashMap;
    //   239: invokevirtual 214	java/util/HashMap:values	()Ljava/util/Collection;
    //   242: invokeinterface 220 1 0
    //   247: astore 5
    //   249: iconst_0
    //   250: istore_1
    //   251: aload_3
    //   252: astore 4
    //   254: aload 5
    //   256: invokeinterface 225 1 0
    //   261: ifeq +170 -> 431
    //   264: aload_3
    //   265: astore 4
    //   267: aload 5
    //   269: invokeinterface 229 1 0
    //   274: checkcast 83	com/google/android/exoplayer2/h/a/i
    //   277: astore 6
    //   279: aload_3
    //   280: astore 4
    //   282: aload_3
    //   283: aload 6
    //   285: getfield 95	com/google/android/exoplayer2/h/a/i:id	I
    //   288: invokevirtual 181	java/io/DataOutputStream:writeInt	(I)V
    //   291: aload_3
    //   292: astore 4
    //   294: aload_3
    //   295: aload 6
    //   297: getfield 87	com/google/android/exoplayer2/h/a/i:key	Ljava/lang/String;
    //   300: invokevirtual 232	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   303: aload_3
    //   304: astore 4
    //   306: aload_3
    //   307: aload 6
    //   309: getfield 236	com/google/android/exoplayer2/h/a/i:length	J
    //   312: invokevirtual 240	java/io/DataOutputStream:writeLong	(J)V
    //   315: aload_3
    //   316: astore 4
    //   318: aload 6
    //   320: invokevirtual 243	com/google/android/exoplayer2/h/a/i:wT	()I
    //   323: istore_2
    //   324: iload_2
    //   325: iload_1
    //   326: iadd
    //   327: istore_1
    //   328: goto -77 -> 251
    //   331: aload_0
    //   332: getfield 170	com/google/android/exoplayer2/h/a/j:bFY	Lcom/google/android/exoplayer2/i/q;
    //   335: aload 4
    //   337: invokevirtual 245	com/google/android/exoplayer2/i/q:a	(Ljava/io/OutputStream;)V
    //   340: goto -289 -> 51
    //   343: astore 4
    //   345: new 247	com/google/android/exoplayer2/h/a/a$a
    //   348: dup
    //   349: aload 4
    //   351: invokespecial 250	com/google/android/exoplayer2/h/a/a$a:<init>	(Ljava/io/IOException;)V
    //   354: astore 4
    //   356: ldc 164
    //   358: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload 4
    //   363: athrow
    //   364: astore 5
    //   366: aload_3
    //   367: astore 4
    //   369: aload 5
    //   371: astore_3
    //   372: aload 4
    //   374: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   377: ldc 164
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
    //   399: new 258	java/lang/IllegalStateException
    //   402: dup
    //   403: aload_3
    //   404: invokespecial 261	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   407: astore_3
    //   408: aload 5
    //   410: astore 4
    //   412: ldc 164
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
    //   436: invokevirtual 181	java/io/DataOutputStream:writeInt	(I)V
    //   439: aload_3
    //   440: astore 4
    //   442: aload_0
    //   443: getfield 62	com/google/android/exoplayer2/h/a/j:bGx	Lcom/google/android/exoplayer2/i/b;
    //   446: astore 5
    //   448: aload_3
    //   449: astore 4
    //   451: aload_3
    //   452: invokevirtual 266	java/io/OutputStream:close	()V
    //   455: aload_3
    //   456: astore 4
    //   458: aload 5
    //   460: getfield 270	com/google/android/exoplayer2/i/b:bGQ	Ljava/io/File;
    //   463: invokevirtual 273	java/io/File:delete	()Z
    //   466: pop
    //   467: aconst_null
    //   468: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   471: aload_0
    //   472: iconst_0
    //   473: putfield 104	com/google/android/exoplayer2/h/a/j:bGB	Z
    //   476: ldc 164
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
  
  public final void wV()
  {
    AppMethodBeat.i(92987);
    Object localObject = new LinkedList();
    Iterator localIterator = this.bGv.values().iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.bGu.isEmpty()) {
        ((LinkedList)localObject).add(locali.key);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      bt((String)((Iterator)localObject).next());
    }
    AppMethodBeat.o(92987);
  }
  
  /* Error */
  final boolean wW()
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 5
    //   14: astore 6
    //   16: aload 8
    //   18: astore 7
    //   20: aload_0
    //   21: getfield 62	com/google/android/exoplayer2/h/a/j:bGx	Lcom/google/android/exoplayer2/i/b;
    //   24: astore 9
    //   26: aload 5
    //   28: astore 6
    //   30: aload 8
    //   32: astore 7
    //   34: aload 9
    //   36: getfield 270	com/google/android/exoplayer2/i/b:bGQ	Ljava/io/File;
    //   39: invokevirtual 294	java/io/File:exists	()Z
    //   42: ifeq +42 -> 84
    //   45: aload 5
    //   47: astore 6
    //   49: aload 8
    //   51: astore 7
    //   53: aload 9
    //   55: getfield 297	com/google/android/exoplayer2/i/b:bGP	Ljava/io/File;
    //   58: invokevirtual 273	java/io/File:delete	()Z
    //   61: pop
    //   62: aload 5
    //   64: astore 6
    //   66: aload 8
    //   68: astore 7
    //   70: aload 9
    //   72: getfield 270	com/google/android/exoplayer2/i/b:bGQ	Ljava/io/File;
    //   75: aload 9
    //   77: getfield 297	com/google/android/exoplayer2/i/b:bGP	Ljava/io/File;
    //   80: invokevirtual 301	java/io/File:renameTo	(Ljava/io/File;)Z
    //   83: pop
    //   84: aload 5
    //   86: astore 6
    //   88: aload 8
    //   90: astore 7
    //   92: new 303	java/io/BufferedInputStream
    //   95: dup
    //   96: new 305	java/io/FileInputStream
    //   99: dup
    //   100: aload 9
    //   102: getfield 297	com/google/android/exoplayer2/i/b:bGP	Ljava/io/File;
    //   105: invokespecial 306	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: invokespecial 309	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   111: astore 9
    //   113: aload 5
    //   115: astore 6
    //   117: aload 8
    //   119: astore 7
    //   121: new 311	java/io/DataInputStream
    //   124: dup
    //   125: aload 9
    //   127: invokespecial 312	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   130: astore 5
    //   132: aload 5
    //   134: invokevirtual 315	java/io/DataInputStream:readInt	()I
    //   137: istore_1
    //   138: iload_1
    //   139: iconst_1
    //   140: if_icmpeq +16 -> 156
    //   143: aload 5
    //   145: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   148: ldc_w 291
    //   151: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: aload 5
    //   158: invokevirtual 315	java/io/DataInputStream:readInt	()I
    //   161: iconst_1
    //   162: iand
    //   163: ifeq +216 -> 379
    //   166: aload_0
    //   167: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   170: astore 6
    //   172: aload 6
    //   174: ifnonnull +16 -> 190
    //   177: aload 5
    //   179: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   182: ldc_w 291
    //   185: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: iconst_0
    //   189: ireturn
    //   190: bipush 16
    //   192: newarray byte
    //   194: astore 6
    //   196: aload 5
    //   198: aload 6
    //   200: invokevirtual 318	java/io/DataInputStream:readFully	([B)V
    //   203: new 193	javax/crypto/spec/IvParameterSpec
    //   206: dup
    //   207: aload 6
    //   209: invokespecial 195	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   212: astore 6
    //   214: aload_0
    //   215: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   218: iconst_2
    //   219: aload_0
    //   220: getfield 39	com/google/android/exoplayer2/h/a/j:bGz	Ljavax/crypto/spec/SecretKeySpec;
    //   223: aload 6
    //   225: invokevirtual 201	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   228: new 311	java/io/DataInputStream
    //   231: dup
    //   232: new 320	javax/crypto/CipherInputStream
    //   235: dup
    //   236: aload 9
    //   238: aload_0
    //   239: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   242: invokespecial 323	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   245: invokespecial 312	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   248: astore 6
    //   250: aload 6
    //   252: astore 5
    //   254: aload 5
    //   256: astore 6
    //   258: aload 5
    //   260: astore 7
    //   262: aload 5
    //   264: invokevirtual 315	java/io/DataInputStream:readInt	()I
    //   267: istore_3
    //   268: iconst_0
    //   269: istore_1
    //   270: iconst_0
    //   271: istore_2
    //   272: iload_2
    //   273: iload_3
    //   274: if_icmpge +120 -> 394
    //   277: aload 5
    //   279: astore 6
    //   281: aload 5
    //   283: astore 7
    //   285: new 83	com/google/android/exoplayer2/h/a/i
    //   288: dup
    //   289: aload 5
    //   291: invokespecial 326	com/google/android/exoplayer2/h/a/i:<init>	(Ljava/io/DataInputStream;)V
    //   294: astore 8
    //   296: aload 5
    //   298: astore 6
    //   300: aload 5
    //   302: astore 7
    //   304: aload_0
    //   305: aload 8
    //   307: invokespecial 102	com/google/android/exoplayer2/h/a/j:a	(Lcom/google/android/exoplayer2/h/a/i;)V
    //   310: aload 5
    //   312: astore 6
    //   314: aload 5
    //   316: astore 7
    //   318: aload 8
    //   320: invokevirtual 243	com/google/android/exoplayer2/h/a/i:wT	()I
    //   323: istore 4
    //   325: iload_1
    //   326: iload 4
    //   328: iadd
    //   329: istore_1
    //   330: iload_2
    //   331: iconst_1
    //   332: iadd
    //   333: istore_2
    //   334: goto -62 -> 272
    //   337: astore 6
    //   339: new 258	java/lang/IllegalStateException
    //   342: dup
    //   343: aload 6
    //   345: invokespecial 261	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   348: astore 6
    //   350: ldc_w 291
    //   353: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload 6
    //   358: athrow
    //   359: astore 6
    //   361: aload 5
    //   363: ifnull +8 -> 371
    //   366: aload 5
    //   368: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   371: ldc_w 291
    //   374: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: iconst_0
    //   378: ireturn
    //   379: aload_0
    //   380: getfield 37	com/google/android/exoplayer2/h/a/j:bGy	Ljavax/crypto/Cipher;
    //   383: ifnull +8 -> 391
    //   386: aload_0
    //   387: iconst_1
    //   388: putfield 104	com/google/android/exoplayer2/h/a/j:bGB	Z
    //   391: goto -137 -> 254
    //   394: aload 5
    //   396: astore 6
    //   398: aload 5
    //   400: astore 7
    //   402: aload 5
    //   404: invokevirtual 315	java/io/DataInputStream:readInt	()I
    //   407: istore_2
    //   408: iload_2
    //   409: iload_1
    //   410: if_icmpeq +16 -> 426
    //   413: aload 5
    //   415: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   418: ldc_w 291
    //   421: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: iconst_0
    //   425: ireturn
    //   426: aload 5
    //   428: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   431: ldc_w 291
    //   434: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: iconst_1
    //   438: ireturn
    //   439: astore 5
    //   441: aload 6
    //   443: ifnull +8 -> 451
    //   446: aload 6
    //   448: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   451: ldc_w 291
    //   454: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   457: iconst_0
    //   458: ireturn
    //   459: astore 5
    //   461: aload 7
    //   463: ifnull +8 -> 471
    //   466: aload 7
    //   468: invokestatic 256	com/google/android/exoplayer2/i/x:closeQuietly	(Ljava/io/Closeable;)V
    //   471: ldc_w 291
    //   474: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: aload 5
    //   479: athrow
    //   480: astore 6
    //   482: aload 5
    //   484: astore 7
    //   486: aload 6
    //   488: astore 5
    //   490: goto -29 -> 461
    //   493: astore 6
    //   495: aload 5
    //   497: astore 6
    //   499: goto -58 -> 441
    //   502: astore 5
    //   504: aconst_null
    //   505: astore 5
    //   507: goto -146 -> 361
    //   510: astore 6
    //   512: goto -151 -> 361
    //   515: astore 6
    //   517: goto -178 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	this	j
    //   137	274	1	i	int
    //   271	140	2	j	int
    //   267	8	3	k	int
    //   323	6	4	m	int
    //   10	417	5	localObject1	Object
    //   439	1	5	localIOException1	java.io.IOException
    //   459	24	5	localObject2	Object
    //   488	8	5	localObject3	Object
    //   502	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   505	1	5	localObject4	Object
    //   14	299	6	localObject5	Object
    //   337	7	6	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   348	9	6	localIllegalStateException	java.lang.IllegalStateException
    //   359	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   396	51	6	localObject6	Object
    //   480	7	6	localObject7	Object
    //   493	1	6	localIOException2	java.io.IOException
    //   497	1	6	localObject8	Object
    //   510	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   515	1	6	localInvalidKeyException	java.security.InvalidKeyException
    //   18	467	7	localObject9	Object
    //   7	312	8	locali	i
    //   24	213	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   214	228	337	java/security/InvalidAlgorithmParameterException
    //   132	138	359	java/io/FileNotFoundException
    //   156	172	359	java/io/FileNotFoundException
    //   190	214	359	java/io/FileNotFoundException
    //   214	228	359	java/io/FileNotFoundException
    //   228	250	359	java/io/FileNotFoundException
    //   339	359	359	java/io/FileNotFoundException
    //   379	391	359	java/io/FileNotFoundException
    //   20	26	439	java/io/IOException
    //   34	45	439	java/io/IOException
    //   53	62	439	java/io/IOException
    //   70	84	439	java/io/IOException
    //   92	113	439	java/io/IOException
    //   121	132	439	java/io/IOException
    //   262	268	439	java/io/IOException
    //   285	296	439	java/io/IOException
    //   304	310	439	java/io/IOException
    //   318	325	439	java/io/IOException
    //   402	408	439	java/io/IOException
    //   20	26	459	finally
    //   34	45	459	finally
    //   53	62	459	finally
    //   70	84	459	finally
    //   92	113	459	finally
    //   121	132	459	finally
    //   262	268	459	finally
    //   285	296	459	finally
    //   304	310	459	finally
    //   318	325	459	finally
    //   402	408	459	finally
    //   132	138	480	finally
    //   156	172	480	finally
    //   190	214	480	finally
    //   214	228	480	finally
    //   228	250	480	finally
    //   339	359	480	finally
    //   379	391	480	finally
    //   132	138	493	java/io/IOException
    //   156	172	493	java/io/IOException
    //   190	214	493	java/io/IOException
    //   214	228	493	java/io/IOException
    //   228	250	493	java/io/IOException
    //   339	359	493	java/io/IOException
    //   379	391	493	java/io/IOException
    //   20	26	502	java/io/FileNotFoundException
    //   34	45	502	java/io/FileNotFoundException
    //   53	62	502	java/io/FileNotFoundException
    //   70	84	502	java/io/FileNotFoundException
    //   92	113	502	java/io/FileNotFoundException
    //   121	132	502	java/io/FileNotFoundException
    //   262	268	510	java/io/FileNotFoundException
    //   285	296	510	java/io/FileNotFoundException
    //   304	310	510	java/io/FileNotFoundException
    //   318	325	510	java/io/FileNotFoundException
    //   402	408	510	java/io/FileNotFoundException
    //   214	228	515	java/security/InvalidKeyException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.j
 * JD-Core Version:    0.7.0.1
 */