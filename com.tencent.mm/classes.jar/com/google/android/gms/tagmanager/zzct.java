package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaj.zzj;
import com.google.android.gms.internal.zzbjj;

class zzct
  implements Runnable
{
  private final Context mContext;
  private final String zzbEY;
  private volatile String zzbFw;
  private final zzbjj zzbHv;
  private final String zzbHw;
  private zzbn<zzaj.zzj> zzbHx;
  private volatile zzt zzbHy;
  private volatile String zzbHz;
  
  zzct(Context paramContext, String paramString, zzbjj paramzzbjj, zzt paramzzt)
  {
    this.mContext = paramContext;
    this.zzbHv = paramzzbjj;
    this.zzbEY = paramString;
    this.zzbHy = paramzzt;
    paramContext = String.valueOf("/r?id=");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramContext = paramContext.concat(paramString);; paramContext = new String(paramContext))
    {
      this.zzbHw = paramContext;
      this.zzbFw = this.zzbHw;
      this.zzbHz = null;
      return;
    }
  }
  
  public zzct(Context paramContext, String paramString, zzt paramzzt)
  {
    this(paramContext, paramString, new zzbjj(), paramzzt);
  }
  
  private boolean zzRg()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      zzbo.v("...no network connectivity");
      return false;
    }
    return true;
  }
  
  /* Error */
  private void zzRh()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 102	com/google/android/gms/tagmanager/zzct:zzRg	()Z
    //   4: ifne +16 -> 20
    //   7: aload_0
    //   8: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   11: getstatic 110	com/google/android/gms/tagmanager/zzbn$zza:zzbGM	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   14: invokeinterface 116 2 0
    //   19: return
    //   20: ldc 118
    //   22: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 122	com/google/android/gms/tagmanager/zzct:zzRi	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 29	com/google/android/gms/tagmanager/zzct:zzbHv	Lcom/google/android/gms/internal/zzbjj;
    //   35: invokevirtual 126	com/google/android/gms/internal/zzbjj:zzTE	()Lcom/google/android/gms/internal/zzbji;
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_3
    //   42: aload 4
    //   44: invokeinterface 132 2 0
    //   49: astore_1
    //   50: new 134	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: invokespecial 135	java/io/ByteArrayOutputStream:<init>	()V
    //   57: astore_2
    //   58: aload_1
    //   59: aload_2
    //   60: invokestatic 141	com/google/android/gms/internal/zzbjf:zzc	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   63: aload_2
    //   64: invokevirtual 145	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: invokestatic 151	com/google/android/gms/internal/zzaj$zzj:zzg	([B)Lcom/google/android/gms/internal/zzaj$zzj;
    //   70: astore_2
    //   71: aload_2
    //   72: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: astore_1
    //   76: new 153	java/lang/StringBuilder
    //   79: dup
    //   80: aload_1
    //   81: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   84: invokevirtual 45	java/lang/String:length	()I
    //   87: bipush 43
    //   89: iadd
    //   90: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   93: ldc 158
    //   95: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   108: aload_2
    //   109: getfield 169	com/google/android/gms/internal/zzaj$zzj:zzlr	Lcom/google/android/gms/internal/zzaj$zzf;
    //   112: ifnonnull +37 -> 149
    //   115: aload_2
    //   116: getfield 173	com/google/android/gms/internal/zzaj$zzj:zzlq	[Lcom/google/android/gms/internal/zzaj$zzi;
    //   119: arraylength
    //   120: ifne +29 -> 149
    //   123: aload_0
    //   124: getfield 31	com/google/android/gms/tagmanager/zzct:zzbEY	Ljava/lang/String;
    //   127: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 45	java/lang/String:length	()I
    //   135: ifeq +261 -> 396
    //   138: ldc 175
    //   140: aload_1
    //   141: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   153: aload_2
    //   154: invokeinterface 179 2 0
    //   159: aload_3
    //   160: invokeinterface 182 1 0
    //   165: ldc 184
    //   167: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   170: return
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 31	com/google/android/gms/tagmanager/zzct:zzbEY	Ljava/lang/String;
    //   176: astore_1
    //   177: new 153	java/lang/StringBuilder
    //   180: dup
    //   181: aload 4
    //   183: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 45	java/lang/String:length	()I
    //   189: bipush 79
    //   191: iadd
    //   192: aload_1
    //   193: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokevirtual 45	java/lang/String:length	()I
    //   199: iadd
    //   200: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   203: ldc 186
    //   205: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 188
    //   215: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 190
    //   224: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 193	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   237: getstatic 196	com/google/android/gms/tagmanager/zzbn$zza:zzbGO	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   240: invokeinterface 116 2 0
    //   245: aload_3
    //   246: invokeinterface 182 1 0
    //   251: return
    //   252: astore_1
    //   253: aload 4
    //   255: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 45	java/lang/String:length	()I
    //   263: ifeq +40 -> 303
    //   266: ldc 198
    //   268: aload_1
    //   269: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_1
    //   273: aload_1
    //   274: invokestatic 193	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   277: aload_0
    //   278: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   281: getstatic 201	com/google/android/gms/tagmanager/zzbn$zza:zzbGP	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   284: invokeinterface 116 2 0
    //   289: aload_2
    //   290: astore_1
    //   291: goto -241 -> 50
    //   294: astore_1
    //   295: aload_3
    //   296: invokeinterface 182 1 0
    //   301: aload_1
    //   302: athrow
    //   303: new 37	java/lang/String
    //   306: dup
    //   307: ldc 198
    //   309: invokespecial 58	java/lang/String:<init>	(Ljava/lang/String;)V
    //   312: astore_1
    //   313: goto -40 -> 273
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   321: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: astore_2
    //   325: new 153	java/lang/StringBuilder
    //   328: dup
    //   329: aload 4
    //   331: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   334: invokevirtual 45	java/lang/String:length	()I
    //   337: bipush 40
    //   339: iadd
    //   340: aload_2
    //   341: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   344: invokevirtual 45	java/lang/String:length	()I
    //   347: iadd
    //   348: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   351: ldc 206
    //   353: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 4
    //   358: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 208
    //   363: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_2
    //   367: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: aload_1
    //   374: invokestatic 211	com/google/android/gms/tagmanager/zzbo:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   377: aload_0
    //   378: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   381: getstatic 214	com/google/android/gms/tagmanager/zzbn$zza:zzbGN	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   384: invokeinterface 116 2 0
    //   389: aload_3
    //   390: invokeinterface 182 1 0
    //   395: return
    //   396: new 37	java/lang/String
    //   399: dup
    //   400: ldc 175
    //   402: invokespecial 58	java/lang/String:<init>	(Ljava/lang/String;)V
    //   405: astore_1
    //   406: goto -261 -> 145
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   414: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   417: astore_2
    //   418: new 153	java/lang/StringBuilder
    //   421: dup
    //   422: aload 4
    //   424: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   427: invokevirtual 45	java/lang/String:length	()I
    //   430: bipush 51
    //   432: iadd
    //   433: aload_2
    //   434: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   437: invokevirtual 45	java/lang/String:length	()I
    //   440: iadd
    //   441: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   444: ldc 216
    //   446: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload 4
    //   451: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 208
    //   456: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_2
    //   460: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: aload_1
    //   467: invokestatic 211	com/google/android/gms/tagmanager/zzbo:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload_0
    //   471: getfield 104	com/google/android/gms/tagmanager/zzct:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   474: getstatic 196	com/google/android/gms/tagmanager/zzbn$zza:zzbGO	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   477: invokeinterface 116 2 0
    //   482: aload_3
    //   483: invokeinterface 182 1 0
    //   488: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	zzct
    //   49	97	1	localObject1	Object
    //   171	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   176	43	1	str1	String
    //   252	1	1	localzzbjk	com.google.android.gms.internal.zzbjk
    //   258	33	1	localObject2	Object
    //   294	8	1	localObject3	Object
    //   312	1	1	str2	String
    //   316	58	1	localIOException1	java.io.IOException
    //   405	1	1	str3	String
    //   409	58	1	localIOException2	java.io.IOException
    //   40	420	2	localObject4	Object
    //   38	445	3	localzzbji	com.google.android.gms.internal.zzbji
    //   29	421	4	str4	String
    // Exception table:
    //   from	to	target	type
    //   41	50	171	java/io/FileNotFoundException
    //   41	50	252	com/google/android/gms/internal/zzbjk
    //   41	50	294	finally
    //   50	145	294	finally
    //   145	149	294	finally
    //   149	159	294	finally
    //   172	245	294	finally
    //   253	273	294	finally
    //   273	289	294	finally
    //   303	313	294	finally
    //   317	389	294	finally
    //   396	406	294	finally
    //   410	482	294	finally
    //   41	50	316	java/io/IOException
    //   50	145	409	java/io/IOException
    //   145	149	409	java/io/IOException
    //   149	159	409	java/io/IOException
    //   396	406	409	java/io/IOException
  }
  
  public void run()
  {
    if (this.zzbHx == null) {
      throw new IllegalStateException("callback must be set before execute");
    }
    zzRh();
  }
  
  String zzRi()
  {
    Object localObject1 = String.valueOf(this.zzbHy.zzQu());
    Object localObject2 = this.zzbFw;
    String str = String.valueOf("&v=a65833898");
    localObject2 = String.valueOf(localObject1).length() + String.valueOf(localObject2).length() + String.valueOf(str).length() + (String)localObject1 + (String)localObject2 + str;
    localObject1 = localObject2;
    if (this.zzbHz != null)
    {
      localObject1 = localObject2;
      if (!this.zzbHz.trim().equals(""))
      {
        localObject1 = String.valueOf(localObject2);
        localObject2 = String.valueOf("&pv=");
        str = this.zzbHz;
        localObject1 = String.valueOf(localObject1).length() + String.valueOf(localObject2).length() + String.valueOf(str).length() + (String)localObject1 + (String)localObject2 + str;
      }
    }
    localObject2 = localObject1;
    if (zzcj.zzRd().zzRe().equals(zzcj.zza.zzbHn))
    {
      localObject1 = String.valueOf(localObject1);
      localObject2 = String.valueOf("&gtm_debug=x");
      if (((String)localObject2).length() != 0) {
        localObject2 = ((String)localObject1).concat((String)localObject2);
      }
    }
    else
    {
      return localObject2;
    }
    return new String((String)localObject1);
  }
  
  void zza(zzbn<zzaj.zzj> paramzzbn)
  {
    this.zzbHx = paramzzbn;
  }
  
  void zzgZ(String paramString)
  {
    if (paramString == null)
    {
      this.zzbFw = this.zzbHw;
      return;
    }
    String str = String.valueOf(paramString);
    if (str.length() != 0) {}
    for (str = "Setting CTFE URL path: ".concat(str);; str = new String("Setting CTFE URL path: "))
    {
      zzbo.zzbf(str);
      this.zzbFw = paramString;
      return;
    }
  }
  
  void zzho(String paramString)
  {
    String str = String.valueOf(paramString);
    if (str.length() != 0) {}
    for (str = "Setting previous container version: ".concat(str);; str = new String("Setting previous container version: "))
    {
      zzbo.zzbf(str);
      this.zzbHz = paramString;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzct
 * JD-Core Version:    0.7.0.1
 */