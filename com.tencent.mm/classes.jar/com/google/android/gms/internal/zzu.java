package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzu
  implements zzg
{
  protected static final boolean DEBUG = zzt.DEBUG;
  private static int zzan = 3000;
  private static int zzao = 4096;
  protected final zzz zzap;
  protected final zzv zzaq;
  
  public zzu(zzz paramzzz)
  {
    this(paramzzz, new zzv(zzao));
  }
  
  public zzu(zzz paramzzz, zzv paramzzv)
  {
    this.zzap = paramzzz;
    this.zzaq = paramzzv;
  }
  
  protected static Map<String, String> zza(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private void zza(long paramLong, zzl<?> paramzzl, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > zzan)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      zzt.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramzzl, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramzzl.zzq().zzd()) });
      return;
    }
  }
  
  private static void zza(String paramString, zzl<?> paramzzl, zzs paramzzs)
  {
    zzp localzzp = paramzzl.zzq();
    int i = paramzzl.zzp();
    try
    {
      localzzp.zza(paramzzs);
      paramzzl.zzc(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (zzs paramzzs)
    {
      paramzzl.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramzzs;
    }
  }
  
  private void zza(Map<String, String> paramMap, zzb.zza paramzza)
  {
    if (paramzza == null) {}
    do
    {
      return;
      if (paramzza.zza != null) {
        paramMap.put("If-None-Match", paramzza.zza);
      }
    } while (paramzza.zzc <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramzza.zzc)));
  }
  
  private byte[] zza(HttpEntity paramHttpEntity)
  {
    zzab localzzab = new zzab(this.zzaq, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new zzq();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.zzaq.zza((byte[])localObject1);
      localzzab.close();
      throw localObject3;
      localObject1 = localObject3;
      byte[] arrayOfByte = this.zzaq.zzb(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localzzab.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localzzab.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.zzaq.zza(arrayOfByte);
        localzzab.close();
        return localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          zzt.zza("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        zzt.zza("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public zzj zza(zzl<?> paramzzl)
  {
    // Byte code:
    //   0: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: invokestatic 227	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 7
    //   12: new 229	java/util/HashMap
    //   15: dup
    //   16: invokespecial 230	java/util/HashMap:<init>	()V
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: aload_1
    //   25: invokevirtual 234	com/google/android/gms/internal/zzl:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   28: invokespecial 236	com/google/android/gms/internal/zzu:zza	(Ljava/util/Map;Lcom/google/android/gms/internal/zzb$zza;)V
    //   31: aload_0
    //   32: getfield 41	com/google/android/gms/internal/zzu:zzap	Lcom/google/android/gms/internal/zzz;
    //   35: aload_1
    //   36: aload 5
    //   38: invokeinterface 241 3 0
    //   43: astore 6
    //   45: aload 7
    //   47: astore 5
    //   49: aload 6
    //   51: invokeinterface 247 1 0
    //   56: astore 8
    //   58: aload 7
    //   60: astore 5
    //   62: aload 8
    //   64: invokeinterface 93 1 0
    //   69: istore_2
    //   70: aload 7
    //   72: astore 5
    //   74: aload 6
    //   76: invokeinterface 251 1 0
    //   81: invokestatic 253	com/google/android/gms/internal/zzu:zza	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   84: astore 9
    //   86: iload_2
    //   87: sipush 304
    //   90: if_icmpne +89 -> 179
    //   93: aload 9
    //   95: astore 5
    //   97: aload_1
    //   98: invokevirtual 234	com/google/android/gms/internal/zzl:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnonnull +27 -> 132
    //   108: aload 9
    //   110: astore 5
    //   112: new 255	com/google/android/gms/internal/zzj
    //   115: dup
    //   116: sipush 304
    //   119: aconst_null
    //   120: aload 9
    //   122: iconst_1
    //   123: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   126: lload_3
    //   127: lsub
    //   128: invokespecial 258	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   131: areturn
    //   132: aload 9
    //   134: astore 5
    //   136: aload 7
    //   138: getfield 262	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   141: aload 9
    //   143: invokeinterface 266 2 0
    //   148: aload 9
    //   150: astore 5
    //   152: new 255	com/google/android/gms/internal/zzj
    //   155: dup
    //   156: sipush 304
    //   159: aload 7
    //   161: getfield 270	com/google/android/gms/internal/zzb$zza:data	[B
    //   164: aload 7
    //   166: getfield 262	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   169: iconst_1
    //   170: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   173: lload_3
    //   174: lsub
    //   175: invokespecial 258	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   178: areturn
    //   179: aload 9
    //   181: astore 5
    //   183: aload 6
    //   185: invokeinterface 274 1 0
    //   190: ifnull +79 -> 269
    //   193: aload 9
    //   195: astore 5
    //   197: aload_0
    //   198: aload 6
    //   200: invokeinterface 274 1 0
    //   205: invokespecial 276	com/google/android/gms/internal/zzu:zza	(Lorg/apache/http/HttpEntity;)[B
    //   208: astore 7
    //   210: aload 7
    //   212: astore 5
    //   214: aload_0
    //   215: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   218: lload_3
    //   219: lsub
    //   220: aload_1
    //   221: aload 5
    //   223: aload 8
    //   225: invokespecial 278	com/google/android/gms/internal/zzu:zza	(JLcom/google/android/gms/internal/zzl;[BLorg/apache/http/StatusLine;)V
    //   228: iload_2
    //   229: sipush 200
    //   232: if_icmplt +10 -> 242
    //   235: iload_2
    //   236: sipush 299
    //   239: if_icmple +46 -> 285
    //   242: new 161	java/io/IOException
    //   245: dup
    //   246: invokespecial 279	java/io/IOException:<init>	()V
    //   249: athrow
    //   250: astore 5
    //   252: ldc_w 281
    //   255: aload_1
    //   256: new 283	com/google/android/gms/internal/zzr
    //   259: dup
    //   260: invokespecial 284	com/google/android/gms/internal/zzr:<init>	()V
    //   263: invokestatic 286	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   266: goto -262 -> 4
    //   269: aload 9
    //   271: astore 5
    //   273: iconst_0
    //   274: newarray byte
    //   276: astore 7
    //   278: aload 7
    //   280: astore 5
    //   282: goto -68 -> 214
    //   285: new 255	com/google/android/gms/internal/zzj
    //   288: dup
    //   289: iload_2
    //   290: aload 5
    //   292: aload 9
    //   294: iconst_0
    //   295: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   298: lload_3
    //   299: lsub
    //   300: invokespecial 258	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   303: astore 7
    //   305: aload 7
    //   307: areturn
    //   308: astore 5
    //   310: ldc_w 288
    //   313: aload_1
    //   314: new 283	com/google/android/gms/internal/zzr
    //   317: dup
    //   318: invokespecial 284	com/google/android/gms/internal/zzr:<init>	()V
    //   321: invokestatic 286	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   324: goto -320 -> 4
    //   327: astore 5
    //   329: new 290	java/lang/RuntimeException
    //   332: dup
    //   333: new 292	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 294
    //   340: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: aload_1
    //   344: invokevirtual 299	com/google/android/gms/internal/zzl:getUrl	()Ljava/lang/String;
    //   347: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: aload 5
    //   355: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: athrow
    //   359: astore 6
    //   361: aconst_null
    //   362: astore 8
    //   364: aload 7
    //   366: astore 5
    //   368: aload 9
    //   370: astore 7
    //   372: aload 7
    //   374: ifnull +98 -> 472
    //   377: aload 7
    //   379: invokeinterface 247 1 0
    //   384: invokeinterface 93 1 0
    //   389: istore_2
    //   390: ldc_w 311
    //   393: iconst_2
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: iload_2
    //   400: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: aload_1
    //   407: invokevirtual 299	com/google/android/gms/internal/zzl:getUrl	()Ljava/lang/String;
    //   410: aastore
    //   411: invokestatic 313	com/google/android/gms/internal/zzt:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload 8
    //   416: ifnull +124 -> 540
    //   419: new 255	com/google/android/gms/internal/zzj
    //   422: dup
    //   423: iload_2
    //   424: aload 8
    //   426: aload 5
    //   428: iconst_0
    //   429: invokestatic 221	android/os/SystemClock:elapsedRealtime	()J
    //   432: lload_3
    //   433: lsub
    //   434: invokespecial 258	com/google/android/gms/internal/zzj:<init>	(I[BLjava/util/Map;ZJ)V
    //   437: astore 5
    //   439: iload_2
    //   440: sipush 401
    //   443: if_icmpeq +10 -> 453
    //   446: iload_2
    //   447: sipush 403
    //   450: if_icmpne +32 -> 482
    //   453: ldc_w 315
    //   456: aload_1
    //   457: new 317	com/google/android/gms/internal/zza
    //   460: dup
    //   461: aload 5
    //   463: invokespecial 320	com/google/android/gms/internal/zza:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   466: invokestatic 286	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   469: goto -465 -> 4
    //   472: new 322	com/google/android/gms/internal/zzk
    //   475: dup
    //   476: aload 6
    //   478: invokespecial 325	com/google/android/gms/internal/zzk:<init>	(Ljava/lang/Throwable;)V
    //   481: athrow
    //   482: iload_2
    //   483: sipush 400
    //   486: if_icmplt +20 -> 506
    //   489: iload_2
    //   490: sipush 499
    //   493: if_icmpgt +13 -> 506
    //   496: new 327	com/google/android/gms/internal/zzd
    //   499: dup
    //   500: aload 5
    //   502: invokespecial 328	com/google/android/gms/internal/zzd:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   505: athrow
    //   506: iload_2
    //   507: sipush 500
    //   510: if_icmplt +20 -> 530
    //   513: iload_2
    //   514: sipush 599
    //   517: if_icmpgt +13 -> 530
    //   520: new 178	com/google/android/gms/internal/zzq
    //   523: dup
    //   524: aload 5
    //   526: invokespecial 329	com/google/android/gms/internal/zzq:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   529: athrow
    //   530: new 178	com/google/android/gms/internal/zzq
    //   533: dup
    //   534: aload 5
    //   536: invokespecial 329	com/google/android/gms/internal/zzq:<init>	(Lcom/google/android/gms/internal/zzj;)V
    //   539: athrow
    //   540: ldc_w 331
    //   543: aload_1
    //   544: new 333	com/google/android/gms/internal/zzi
    //   547: dup
    //   548: invokespecial 334	com/google/android/gms/internal/zzi:<init>	()V
    //   551: invokestatic 286	com/google/android/gms/internal/zzu:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzl;Lcom/google/android/gms/internal/zzs;)V
    //   554: goto -550 -> 4
    //   557: astore 9
    //   559: aconst_null
    //   560: astore 8
    //   562: aload 6
    //   564: astore 7
    //   566: aload 9
    //   568: astore 6
    //   570: goto -198 -> 372
    //   573: astore 8
    //   575: aload 6
    //   577: astore 7
    //   579: aload 8
    //   581: astore 6
    //   583: aload 5
    //   585: astore 8
    //   587: aload 9
    //   589: astore 5
    //   591: goto -219 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	zzu
    //   0	594	1	paramzzl	zzl<?>
    //   69	449	2	i	int
    //   3	430	3	l	long
    //   19	203	5	localObject1	Object
    //   250	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   271	20	5	localObject2	Object
    //   308	1	5	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   327	27	5	localMalformedURLException	java.net.MalformedURLException
    //   366	224	5	localObject3	Object
    //   43	156	6	localHttpResponse	org.apache.http.HttpResponse
    //   359	204	6	localIOException1	IOException
    //   568	14	6	localObject4	Object
    //   10	568	7	localObject5	Object
    //   56	505	8	localStatusLine	StatusLine
    //   573	7	8	localIOException2	IOException
    //   585	1	8	localObject6	Object
    //   5	364	9	localMap	Map
    //   557	31	9	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   12	45	250	java/net/SocketTimeoutException
    //   49	58	250	java/net/SocketTimeoutException
    //   62	70	250	java/net/SocketTimeoutException
    //   74	86	250	java/net/SocketTimeoutException
    //   97	103	250	java/net/SocketTimeoutException
    //   112	132	250	java/net/SocketTimeoutException
    //   136	148	250	java/net/SocketTimeoutException
    //   152	179	250	java/net/SocketTimeoutException
    //   183	193	250	java/net/SocketTimeoutException
    //   197	210	250	java/net/SocketTimeoutException
    //   214	228	250	java/net/SocketTimeoutException
    //   242	250	250	java/net/SocketTimeoutException
    //   273	278	250	java/net/SocketTimeoutException
    //   285	305	250	java/net/SocketTimeoutException
    //   12	45	308	org/apache/http/conn/ConnectTimeoutException
    //   49	58	308	org/apache/http/conn/ConnectTimeoutException
    //   62	70	308	org/apache/http/conn/ConnectTimeoutException
    //   74	86	308	org/apache/http/conn/ConnectTimeoutException
    //   97	103	308	org/apache/http/conn/ConnectTimeoutException
    //   112	132	308	org/apache/http/conn/ConnectTimeoutException
    //   136	148	308	org/apache/http/conn/ConnectTimeoutException
    //   152	179	308	org/apache/http/conn/ConnectTimeoutException
    //   183	193	308	org/apache/http/conn/ConnectTimeoutException
    //   197	210	308	org/apache/http/conn/ConnectTimeoutException
    //   214	228	308	org/apache/http/conn/ConnectTimeoutException
    //   242	250	308	org/apache/http/conn/ConnectTimeoutException
    //   273	278	308	org/apache/http/conn/ConnectTimeoutException
    //   285	305	308	org/apache/http/conn/ConnectTimeoutException
    //   12	45	327	java/net/MalformedURLException
    //   49	58	327	java/net/MalformedURLException
    //   62	70	327	java/net/MalformedURLException
    //   74	86	327	java/net/MalformedURLException
    //   97	103	327	java/net/MalformedURLException
    //   112	132	327	java/net/MalformedURLException
    //   136	148	327	java/net/MalformedURLException
    //   152	179	327	java/net/MalformedURLException
    //   183	193	327	java/net/MalformedURLException
    //   197	210	327	java/net/MalformedURLException
    //   214	228	327	java/net/MalformedURLException
    //   242	250	327	java/net/MalformedURLException
    //   273	278	327	java/net/MalformedURLException
    //   285	305	327	java/net/MalformedURLException
    //   12	45	359	java/io/IOException
    //   49	58	557	java/io/IOException
    //   62	70	557	java/io/IOException
    //   74	86	557	java/io/IOException
    //   97	103	557	java/io/IOException
    //   112	132	557	java/io/IOException
    //   136	148	557	java/io/IOException
    //   152	179	557	java/io/IOException
    //   183	193	557	java/io/IOException
    //   197	210	557	java/io/IOException
    //   273	278	557	java/io/IOException
    //   214	228	573	java/io/IOException
    //   242	250	573	java/io/IOException
    //   285	305	573	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzu
 * JD-Core Version:    0.7.0.1
 */