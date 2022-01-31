package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

class zzde
  implements zzad
{
  private final Context mContext;
  private final String zzIA;
  private final zzde.zzb zzbIt;
  private final zzde.zza zzbIu;
  
  zzde(Context paramContext, zzde.zza paramzza)
  {
    this(new zzde.zzb()
    {
      public HttpURLConnection zzd(URL paramAnonymousURL)
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    }, paramContext, paramzza);
  }
  
  zzde(zzde.zzb paramzzb, Context paramContext, zzde.zza paramzza)
  {
    this.zzbIt = paramzzb;
    this.mContext = paramContext.getApplicationContext();
    this.zzbIu = paramzza;
    this.zzIA = zza("GoogleTagManager", "4.00", Build.VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
  }
  
  static String zzc(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while ((paramLocale.getLanguage() == null) || (paramLocale.getLanguage().length() == 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public void zzP(java.util.List<zzas> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 112 1 0
    //   6: bipush 40
    //   8: invokestatic 118	java/lang/Math:min	(II)I
    //   11: istore 6
    //   13: iconst_1
    //   14: istore_2
    //   15: iconst_0
    //   16: istore 5
    //   18: iload 5
    //   20: iload 6
    //   22: if_icmpge +342 -> 364
    //   25: aload_1
    //   26: iload 5
    //   28: invokeinterface 122 2 0
    //   33: checkcast 124	com/google/android/gms/tagmanager/zzas
    //   36: astore 9
    //   38: aload_0
    //   39: aload 9
    //   41: invokevirtual 128	com/google/android/gms/tagmanager/zzde:zzd	(Lcom/google/android/gms/tagmanager/zzas;)Ljava/net/URL;
    //   44: astore 7
    //   46: aload 7
    //   48: ifnonnull +28 -> 76
    //   51: ldc 130
    //   53: invokestatic 136	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 42	com/google/android/gms/tagmanager/zzde:zzbIu	Lcom/google/android/gms/tagmanager/zzde$zza;
    //   60: aload 9
    //   62: invokeinterface 140 2 0
    //   67: iload 5
    //   69: iconst_1
    //   70: iadd
    //   71: istore 5
    //   73: goto -55 -> 18
    //   76: aconst_null
    //   77: astore 8
    //   79: iload_2
    //   80: istore 4
    //   82: aload_0
    //   83: getfield 32	com/google/android/gms/tagmanager/zzde:zzbIt	Lcom/google/android/gms/tagmanager/zzde$zzb;
    //   86: aload 7
    //   88: invokeinterface 143 2 0
    //   93: astore 10
    //   95: iload_2
    //   96: istore_3
    //   97: iload_2
    //   98: ifeq +16 -> 114
    //   101: aload 8
    //   103: astore 7
    //   105: aload_0
    //   106: getfield 40	com/google/android/gms/tagmanager/zzde:mContext	Landroid/content/Context;
    //   109: invokestatic 149	com/google/android/gms/tagmanager/zzbt:zzcc	(Landroid/content/Context;)V
    //   112: iconst_0
    //   113: istore_3
    //   114: iload_3
    //   115: istore_2
    //   116: aload 8
    //   118: astore 7
    //   120: aload 10
    //   122: ldc 151
    //   124: aload_0
    //   125: getfield 75	com/google/android/gms/tagmanager/zzde:zzIA	Ljava/lang/String;
    //   128: invokevirtual 157	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: iload_3
    //   132: istore_2
    //   133: aload 8
    //   135: astore 7
    //   137: aload 10
    //   139: invokevirtual 160	java/net/HttpURLConnection:getResponseCode	()I
    //   142: istore 4
    //   144: iload_3
    //   145: istore_2
    //   146: aload 8
    //   148: astore 7
    //   150: aload 10
    //   152: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   155: astore 8
    //   157: iload 4
    //   159: sipush 200
    //   162: if_icmpeq +77 -> 239
    //   165: iload_3
    //   166: istore_2
    //   167: aload 8
    //   169: astore 7
    //   171: new 87	java/lang/StringBuilder
    //   174: dup
    //   175: bipush 25
    //   177: invokespecial 167	java/lang/StringBuilder:<init>	(I)V
    //   180: ldc 169
    //   182: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload 4
    //   187: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 136	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   196: iload_3
    //   197: istore_2
    //   198: aload 8
    //   200: astore 7
    //   202: aload_0
    //   203: getfield 42	com/google/android/gms/tagmanager/zzde:zzbIu	Lcom/google/android/gms/tagmanager/zzde$zza;
    //   206: aload 9
    //   208: invokeinterface 174 2 0
    //   213: aload 8
    //   215: ifnull +11 -> 226
    //   218: iload_3
    //   219: istore 4
    //   221: aload 8
    //   223: invokevirtual 179	java/io/InputStream:close	()V
    //   226: iload_3
    //   227: istore 4
    //   229: aload 10
    //   231: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   234: iload_3
    //   235: istore_2
    //   236: goto -169 -> 67
    //   239: iload_3
    //   240: istore_2
    //   241: aload 8
    //   243: astore 7
    //   245: aload_0
    //   246: getfield 42	com/google/android/gms/tagmanager/zzde:zzbIu	Lcom/google/android/gms/tagmanager/zzde$zza;
    //   249: aload 9
    //   251: invokeinterface 184 2 0
    //   256: goto -43 -> 213
    //   259: astore 8
    //   261: aload 7
    //   263: ifnull +11 -> 274
    //   266: iload_2
    //   267: istore 4
    //   269: aload 7
    //   271: invokevirtual 179	java/io/InputStream:close	()V
    //   274: iload_2
    //   275: istore 4
    //   277: aload 10
    //   279: invokevirtual 182	java/net/HttpURLConnection:disconnect	()V
    //   282: iload_2
    //   283: istore 4
    //   285: aload 8
    //   287: athrow
    //   288: astore 8
    //   290: aload 8
    //   292: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
    //   295: invokevirtual 193	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   298: invokestatic 197	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   301: astore 7
    //   303: aload 7
    //   305: invokevirtual 85	java/lang/String:length	()I
    //   308: ifeq +42 -> 350
    //   311: ldc 199
    //   313: aload 7
    //   315: invokevirtual 203	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 7
    //   320: aload 7
    //   322: invokestatic 136	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   325: aload 8
    //   327: invokevirtual 206	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokestatic 136	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   333: aload_0
    //   334: getfield 42	com/google/android/gms/tagmanager/zzde:zzbIu	Lcom/google/android/gms/tagmanager/zzde$zza;
    //   337: aload 9
    //   339: invokeinterface 174 2 0
    //   344: iload 4
    //   346: istore_2
    //   347: goto -280 -> 67
    //   350: new 81	java/lang/String
    //   353: dup
    //   354: ldc 199
    //   356: invokespecial 208	java/lang/String:<init>	(Ljava/lang/String;)V
    //   359: astore 7
    //   361: goto -41 -> 320
    //   364: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	zzde
    //   0	365	1	paramList	java.util.List<zzas>
    //   14	333	2	i	int
    //   96	144	3	j	int
    //   80	265	4	k	int
    //   16	56	5	m	int
    //   11	12	6	n	int
    //   44	316	7	localObject1	Object
    //   77	165	8	localInputStream	java.io.InputStream
    //   259	27	8	localObject2	Object
    //   288	38	8	localIOException	java.io.IOException
    //   36	302	9	localzzas	zzas
    //   93	185	10	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   105	112	259	finally
    //   120	131	259	finally
    //   137	144	259	finally
    //   150	157	259	finally
    //   171	196	259	finally
    //   202	213	259	finally
    //   245	256	259	finally
    //   82	95	288	java/io/IOException
    //   221	226	288	java/io/IOException
    //   229	234	288	java/io/IOException
    //   269	274	288	java/io/IOException
    //   277	282	288	java/io/IOException
    //   285	288	288	java/io/IOException
  }
  
  public boolean zzQE()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      zzbo.v("...no network connectivity");
      return false;
    }
    return true;
  }
  
  String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  URL zzd(zzas paramzzas)
  {
    paramzzas = paramzzas.zzQO();
    try
    {
      paramzzas = new URL(paramzzas);
      return paramzzas;
    }
    catch (MalformedURLException paramzzas)
    {
      zzbo.e("Error trying to parse the GTM url.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzde
 * JD-Core Version:    0.7.0.1
 */