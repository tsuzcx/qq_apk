package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

class zztf
  extends zzsa
{
  private static final byte[] zzagz = "\n".getBytes();
  private final String zzIA = zza("GoogleAnalytics", zzsb.VERSION, Build.VERSION.RELEASE, zztm.zza(Locale.getDefault()), Build.MODEL, Build.ID);
  private final zztj zzagy;
  
  zztf(zzsc paramzzsc)
  {
    super(paramzzsc);
    this.zzagy = new zztj(paramzzsc.zznR());
  }
  
  /* Error */
  private int zza(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 88	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 88	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: ldc 90
    //   13: aload_2
    //   14: arraylength
    //   15: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: aload_1
    //   19: invokevirtual 100	com/google/android/gms/internal/zztf:zzb	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   22: aload_0
    //   23: invokevirtual 104	com/google/android/gms/internal/zztf:zzkI	()Z
    //   26: ifeq +17 -> 43
    //   29: aload_0
    //   30: ldc 106
    //   32: new 19	java/lang/String
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 109	java/lang/String:<init>	([B)V
    //   40: invokevirtual 112	com/google/android/gms/internal/zztf:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: invokevirtual 116	com/google/android/gms/internal/zztf:getContext	()Landroid/content/Context;
    //   47: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   50: pop
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 126	com/google/android/gms/internal/zztf:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   56: astore_1
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   62: aload_1
    //   63: aload_2
    //   64: arraylength
    //   65: invokevirtual 136	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   68: aload_1
    //   69: invokevirtual 139	java/net/HttpURLConnection:connect	()V
    //   72: aload_1
    //   73: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   76: astore 7
    //   78: aload 7
    //   80: astore 5
    //   82: aload_1
    //   83: astore 4
    //   85: aload 7
    //   87: aload_2
    //   88: invokevirtual 148	java/io/OutputStream:write	([B)V
    //   91: aload 7
    //   93: astore 5
    //   95: aload_1
    //   96: astore 4
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 151	com/google/android/gms/internal/zztf:zzb	(Ljava/net/HttpURLConnection;)V
    //   103: aload 7
    //   105: astore 5
    //   107: aload_1
    //   108: astore 4
    //   110: aload_1
    //   111: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   114: istore_3
    //   115: iload_3
    //   116: sipush 200
    //   119: if_icmpne +17 -> 136
    //   122: aload 7
    //   124: astore 5
    //   126: aload_1
    //   127: astore 4
    //   129: aload_0
    //   130: invokevirtual 159	com/google/android/gms/internal/zztf:zzmA	()Lcom/google/android/gms/internal/zzry;
    //   133: invokevirtual 164	com/google/android/gms/internal/zzry:zznP	()V
    //   136: aload 7
    //   138: astore 5
    //   140: aload_1
    //   141: astore 4
    //   143: aload_0
    //   144: ldc 166
    //   146: iload_3
    //   147: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: invokevirtual 168	com/google/android/gms/internal/zztf:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   153: aload 7
    //   155: ifnull +8 -> 163
    //   158: aload 7
    //   160: invokevirtual 171	java/io/OutputStream:close	()V
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   171: iload_3
    //   172: ireturn
    //   173: astore_2
    //   174: aload_0
    //   175: ldc 176
    //   177: aload_2
    //   178: invokevirtual 179	com/google/android/gms/internal/zztf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   181: goto -18 -> 163
    //   184: astore 6
    //   186: aconst_null
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_1
    //   190: aload_2
    //   191: astore 5
    //   193: aload_1
    //   194: astore 4
    //   196: aload_0
    //   197: ldc 181
    //   199: aload 6
    //   201: invokevirtual 184	com/google/android/gms/internal/zztf:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 171	java/io/OutputStream:close	()V
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_2
    //   223: aload_0
    //   224: ldc 176
    //   226: aload_2
    //   227: invokevirtual 179	com/google/android/gms/internal/zztf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   230: goto -18 -> 212
    //   233: astore_2
    //   234: aconst_null
    //   235: astore 5
    //   237: aconst_null
    //   238: astore_1
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 171	java/io/OutputStream:close	()V
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   257: aload_2
    //   258: athrow
    //   259: astore 4
    //   261: aload_0
    //   262: ldc 176
    //   264: aload 4
    //   266: invokevirtual 179	com/google/android/gms/internal/zztf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   269: goto -20 -> 249
    //   272: astore_2
    //   273: aconst_null
    //   274: astore 5
    //   276: goto -37 -> 239
    //   279: astore_2
    //   280: aload 4
    //   282: astore_1
    //   283: goto -44 -> 239
    //   286: astore 6
    //   288: aconst_null
    //   289: astore_2
    //   290: goto -100 -> 190
    //   293: astore 6
    //   295: aload 7
    //   297: astore_2
    //   298: goto -108 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	zztf
    //   0	301	1	paramURL	URL
    //   0	301	2	paramArrayOfByte	byte[]
    //   114	58	3	i	int
    //   83	112	4	localURL	URL
    //   259	22	4	localIOException1	IOException
    //   80	195	5	localObject	Object
    //   184	16	6	localIOException2	IOException
    //   286	1	6	localIOException3	IOException
    //   293	1	6	localIOException4	IOException
    //   76	220	7	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   158	163	173	java/io/IOException
    //   43	57	184	java/io/IOException
    //   208	212	222	java/io/IOException
    //   43	57	233	finally
    //   244	249	259	java/io/IOException
    //   57	78	272	finally
    //   85	91	279	finally
    //   98	103	279	finally
    //   110	115	279	finally
    //   129	136	279	finally
    //   143	153	279	finally
    //   196	204	279	finally
    //   57	78	286	java/io/IOException
    //   85	91	293	java/io/IOException
    //   98	103	293	java/io/IOException
    //   110	115	293	java/io/IOException
    //   129	136	293	java/io/IOException
    //   143	153	293	java/io/IOException
  }
  
  private static String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append('&');
    }
    paramStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
    paramStringBuilder.append('=');
    paramStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
  }
  
  private int zzb(URL paramURL)
  {
    zzac.zzw(paramURL);
    zzb("GET request", paramURL);
    Object localObject = null;
    URL localURL = null;
    try
    {
      paramURL = zzc(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      paramURL.connect();
      localURL = paramURL;
      localObject = paramURL;
      zzb(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      int i = paramURL.getResponseCode();
      if (i == 200)
      {
        localURL = paramURL;
        localObject = paramURL;
        zzmA().zznP();
      }
      localURL = paramURL;
      localObject = paramURL;
      zzb("GET status", Integer.valueOf(i));
      if (paramURL != null) {
        paramURL.disconnect();
      }
      return i;
    }
    catch (IOException paramURL)
    {
      localObject = localURL;
      zzd("Network GET connection error", paramURL);
      if (localURL != null) {
        localURL.disconnect();
      }
      return 0;
    }
    finally
    {
      if (localObject != null) {
        ((HttpURLConnection)localObject).disconnect();
      }
    }
  }
  
  /* Error */
  private int zzb(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 88	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 88	com/google/android/gms/common/internal/zzac:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 116	com/google/android/gms/internal/zztf:getContext	()Landroid/content/Context;
    //   14: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   17: pop
    //   18: aload_2
    //   19: invokestatic 224	com/google/android/gms/internal/zztf:zzk	([B)[B
    //   22: astore 6
    //   24: aload_0
    //   25: ldc 226
    //   27: aload 6
    //   29: arraylength
    //   30: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: ldc2_w 227
    //   36: aload 6
    //   38: arraylength
    //   39: i2l
    //   40: lmul
    //   41: aload_2
    //   42: arraylength
    //   43: i2l
    //   44: ldiv
    //   45: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aload_1
    //   49: invokevirtual 236	com/google/android/gms/internal/zztf:zza	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   52: aload 6
    //   54: arraylength
    //   55: aload_2
    //   56: arraylength
    //   57: if_icmple +20 -> 77
    //   60: aload_0
    //   61: ldc 238
    //   63: aload 6
    //   65: arraylength
    //   66: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aload_2
    //   70: arraylength
    //   71: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokevirtual 240	com/google/android/gms/internal/zztf:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   77: aload_0
    //   78: invokevirtual 104	com/google/android/gms/internal/zztf:zzkI	()Z
    //   81: ifeq +36 -> 117
    //   84: new 19	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 109	java/lang/String:<init>	([B)V
    //   92: invokestatic 243	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual 244	java/lang/String:length	()I
    //   100: ifeq +118 -> 218
    //   103: ldc 17
    //   105: aload_2
    //   106: invokevirtual 248	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_2
    //   110: aload_0
    //   111: ldc 250
    //   113: aload_2
    //   114: invokevirtual 112	com/google/android/gms/internal/zztf:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   117: aload_0
    //   118: aload_1
    //   119: invokevirtual 126	com/google/android/gms/internal/zztf:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   122: astore_1
    //   123: aload_1
    //   124: iconst_1
    //   125: invokevirtual 132	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   128: aload_1
    //   129: ldc 252
    //   131: ldc 254
    //   133: invokevirtual 258	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: aload 6
    //   139: arraylength
    //   140: invokevirtual 136	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   143: aload_1
    //   144: invokevirtual 139	java/net/HttpURLConnection:connect	()V
    //   147: aload_1
    //   148: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   151: astore_2
    //   152: aload_2
    //   153: astore 5
    //   155: aload_1
    //   156: astore 4
    //   158: aload_2
    //   159: aload 6
    //   161: invokevirtual 148	java/io/OutputStream:write	([B)V
    //   164: aload_2
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload_2
    //   171: invokevirtual 171	java/io/OutputStream:close	()V
    //   174: aload_0
    //   175: aload_1
    //   176: invokespecial 151	com/google/android/gms/internal/zztf:zzb	(Ljava/net/HttpURLConnection;)V
    //   179: aload_1
    //   180: invokevirtual 155	java/net/HttpURLConnection:getResponseCode	()I
    //   183: istore_3
    //   184: iload_3
    //   185: sipush 200
    //   188: if_icmpne +10 -> 198
    //   191: aload_0
    //   192: invokevirtual 159	com/google/android/gms/internal/zztf:zzmA	()Lcom/google/android/gms/internal/zzry;
    //   195: invokevirtual 164	com/google/android/gms/internal/zzry:zznP	()V
    //   198: aload_0
    //   199: ldc 166
    //   201: iload_3
    //   202: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: invokevirtual 168	com/google/android/gms/internal/zztf:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   216: iload_3
    //   217: ireturn
    //   218: new 19	java/lang/String
    //   221: dup
    //   222: ldc 17
    //   224: invokespecial 261	java/lang/String:<init>	(Ljava/lang/String;)V
    //   227: astore_2
    //   228: goto -118 -> 110
    //   231: astore 6
    //   233: aconst_null
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_1
    //   237: aload_2
    //   238: astore 5
    //   240: aload_1
    //   241: astore 4
    //   243: aload_0
    //   244: ldc_w 263
    //   247: aload 6
    //   249: invokevirtual 184	com/google/android/gms/internal/zztf:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 171	java/io/OutputStream:close	()V
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_2
    //   271: aload_0
    //   272: ldc_w 265
    //   275: aload_2
    //   276: invokevirtual 179	com/google/android/gms/internal/zztf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   279: goto -19 -> 260
    //   282: astore_2
    //   283: aconst_null
    //   284: astore 5
    //   286: aconst_null
    //   287: astore_1
    //   288: aload 5
    //   290: ifnull +8 -> 298
    //   293: aload 5
    //   295: invokevirtual 171	java/io/OutputStream:close	()V
    //   298: aload_1
    //   299: ifnull +7 -> 306
    //   302: aload_1
    //   303: invokevirtual 174	java/net/HttpURLConnection:disconnect	()V
    //   306: aload_2
    //   307: athrow
    //   308: astore 4
    //   310: aload_0
    //   311: ldc_w 265
    //   314: aload 4
    //   316: invokevirtual 179	com/google/android/gms/internal/zztf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   319: goto -21 -> 298
    //   322: astore_2
    //   323: aconst_null
    //   324: astore 5
    //   326: goto -38 -> 288
    //   329: astore_2
    //   330: aload 4
    //   332: astore_1
    //   333: goto -45 -> 288
    //   336: astore 6
    //   338: aconst_null
    //   339: astore_2
    //   340: goto -103 -> 237
    //   343: astore 6
    //   345: goto -108 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	zztf
    //   0	348	1	paramURL	URL
    //   0	348	2	paramArrayOfByte	byte[]
    //   183	34	3	i	int
    //   156	86	4	localURL	URL
    //   308	23	4	localIOException1	IOException
    //   153	172	5	arrayOfByte1	byte[]
    //   22	138	6	arrayOfByte2	byte[]
    //   231	17	6	localIOException2	IOException
    //   336	1	6	localIOException3	IOException
    //   343	1	6	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   10	77	231	java/io/IOException
    //   77	110	231	java/io/IOException
    //   110	117	231	java/io/IOException
    //   117	123	231	java/io/IOException
    //   218	228	231	java/io/IOException
    //   256	260	270	java/io/IOException
    //   10	77	282	finally
    //   77	110	282	finally
    //   110	117	282	finally
    //   117	123	282	finally
    //   218	228	282	finally
    //   293	298	308	java/io/IOException
    //   123	152	322	finally
    //   174	184	322	finally
    //   191	198	322	finally
    //   198	208	322	finally
    //   158	164	329	finally
    //   170	174	329	finally
    //   243	252	329	finally
    //   123	152	336	java/io/IOException
    //   174	184	336	java/io/IOException
    //   191	198	336	java/io/IOException
    //   198	208	336	java/io/IOException
    //   158	164	343	java/io/IOException
    //   170	174	343	java/io/IOException
  }
  
  private URL zzb(zzsz paramzzsz, String paramString)
  {
    String str;
    if (paramzzsz.zzpS())
    {
      paramzzsz = String.valueOf(zznT().zzpj());
      str = String.valueOf(zznT().zzpl());
    }
    for (paramzzsz = String.valueOf(paramzzsz).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString).length() + paramzzsz + str + "?" + paramString;; paramzzsz = String.valueOf(paramzzsz).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString).length() + paramzzsz + str + "?" + paramString)
    {
      try
      {
        paramzzsz = new URL(paramzzsz);
        return paramzzsz;
      }
      catch (MalformedURLException paramzzsz)
      {
        zze("Error trying to parse the hardcoded host url", paramzzsz);
      }
      paramzzsz = String.valueOf(zznT().zzpk());
      str = String.valueOf(zznT().zzpl());
    }
    return null;
  }
  
  private void zzb(HttpURLConnection paramHttpURLConnection)
  {
    localHttpURLConnection = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localHttpURLConnection = paramHttpURLConnection;
      byte[] arrayOfByte = new byte[1024];
      int i;
      do
      {
        localHttpURLConnection = paramHttpURLConnection;
        i = paramHttpURLConnection.read(arrayOfByte);
      } while (i > 0);
      if (paramHttpURLConnection != null) {}
      try
      {
        paramHttpURLConnection.close();
        return;
      }
      catch (IOException paramHttpURLConnection)
      {
        zze("Error closing http connection input stream", paramHttpURLConnection);
        return;
      }
      try
      {
        localHttpURLConnection.close();
        throw paramHttpURLConnection;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          zze("Error closing http connection input stream", localIOException);
        }
      }
    }
    finally
    {
      if (localHttpURLConnection == null) {}
    }
  }
  
  private boolean zzg(zzsz paramzzsz)
  {
    zzac.zzw(paramzzsz);
    boolean bool;
    Object localObject;
    if (!paramzzsz.zzpS())
    {
      bool = true;
      localObject = zza(paramzzsz, bool);
      if (localObject != null) {
        break label43;
      }
      zznS().zza(paramzzsz, "Error formatting hit for upload");
    }
    label43:
    label90:
    do
    {
      do
      {
        return true;
        bool = false;
        break;
        if (((String)localObject).length() > zznT().zzoY()) {
          break label90;
        }
        paramzzsz = zzb(paramzzsz, (String)localObject);
        if (paramzzsz == null)
        {
          zzbT("Failed to build collect GET endpoint url");
          return false;
        }
      } while (zzb(paramzzsz) == 200);
      return false;
      localObject = zza(paramzzsz, false);
      if (localObject == null)
      {
        zznS().zza(paramzzsz, "Error formatting hit for POST upload");
        return true;
      }
      localObject = ((String)localObject).getBytes();
      if (localObject.length > zznT().zzpa())
      {
        zznS().zza(paramzzsz, "Hit payload exceeds size limit");
        return true;
      }
      paramzzsz = zzh(paramzzsz);
      if (paramzzsz == null)
      {
        zzbT("Failed to build collect POST endpoint url");
        return false;
      }
    } while (zza(paramzzsz, (byte[])localObject) == 200);
    return false;
  }
  
  private URL zzh(zzsz paramzzsz)
  {
    String str;
    if (paramzzsz.zzpS())
    {
      paramzzsz = String.valueOf(zznT().zzpj());
      str = String.valueOf(zznT().zzpl());
      if (str.length() != 0) {}
      for (paramzzsz = paramzzsz.concat(str);; paramzzsz = new String(paramzzsz)) {
        try
        {
          paramzzsz = new URL(paramzzsz);
          return paramzzsz;
        }
        catch (MalformedURLException paramzzsz)
        {
          zze("Error trying to parse the hardcoded host url", paramzzsz);
        }
      }
    }
    else
    {
      paramzzsz = String.valueOf(zznT().zzpk());
      str = String.valueOf(zznT().zzpl());
      if (str.length() != 0) {}
      for (paramzzsz = paramzzsz.concat(str);; paramzzsz = new String(paramzzsz)) {
        break;
      }
    }
    return null;
  }
  
  private String zzi(zzsz paramzzsz)
  {
    return String.valueOf(paramzzsz.zzpP());
  }
  
  private static byte[] zzk(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.close();
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private URL zzqb()
  {
    Object localObject = String.valueOf(zznT().zzpj());
    String str = String.valueOf(zznT().zzpm());
    if (str.length() != 0) {}
    for (localObject = ((String)localObject).concat(str);; localObject = new String((String)localObject)) {
      try
      {
        localObject = new URL((String)localObject);
        return localObject;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        zze("Error trying to parse the hardcoded host url", localMalformedURLException);
      }
    }
    return null;
  }
  
  String zza(zzsz paramzzsz, boolean paramBoolean)
  {
    zzac.zzw(paramzzsz);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramzzsz.zzfE().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if ((!"ht".equals(str)) && (!"qt".equals(str)) && (!"AppUID".equals(str)) && (!"z".equals(str)) && (!"_gmsv".equals(str))) {
          zza(localStringBuilder, str, (String)localEntry.getValue());
        }
      }
      zza(localStringBuilder, "ht", String.valueOf(paramzzsz.zzpQ()));
    }
    catch (UnsupportedEncodingException paramzzsz)
    {
      zze("Failed to encode name or value", paramzzsz);
      return null;
    }
    zza(localStringBuilder, "qt", String.valueOf(zznR().currentTimeMillis() - paramzzsz.zzpQ()));
    long l;
    if (paramBoolean)
    {
      l = paramzzsz.zzpT();
      if (l == 0L) {
        break label229;
      }
    }
    label229:
    for (paramzzsz = String.valueOf(l);; paramzzsz = zzi(paramzzsz))
    {
      zza(localStringBuilder, "z", paramzzsz);
      return localStringBuilder.toString();
    }
  }
  
  List<Long> zza(List<zzsz> paramList, boolean paramBoolean)
  {
    if (!paramList.isEmpty()) {}
    zza localzza;
    ArrayList localArrayList;
    for (boolean bool = true;; bool = false)
    {
      zzac.zzax(bool);
      zza("Uploading batched hits. compression, count", Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()));
      localzza = new zza();
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        zzsz localzzsz = (zzsz)paramList.next();
        if (!localzza.zzj(localzzsz)) {
          break;
        }
        localArrayList.add(Long.valueOf(localzzsz.zzpP()));
      }
    }
    if (localzza.zzqd() == 0) {
      return localArrayList;
    }
    paramList = zzqb();
    if (paramList == null)
    {
      zzbT("Failed to build batching endpoint url");
      return Collections.emptyList();
    }
    if (paramBoolean) {}
    for (int i = zzb(paramList, localzza.getPayload()); 200 == i; i = zza(paramList, localzza.getPayload()))
    {
      zza("Batched upload completed. Hits batched", Integer.valueOf(localzza.zzqd()));
      return localArrayList;
    }
    zza("Network error uploading hits. status code", Integer.valueOf(i));
    if (zznT().zzpp().contains(Integer.valueOf(i)))
    {
      zzbS("Server instructed the client to stop batching");
      this.zzagy.start();
    }
    return Collections.emptyList();
  }
  
  HttpURLConnection zzc(URL paramURL)
  {
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection)) {
      throw new IOException("Failed to obtain http connection");
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout(zznT().zzpw());
    paramURL.setReadTimeout(zznT().zzpx());
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setRequestProperty("User-Agent", this.zzIA);
    paramURL.setDoInput(true);
    return paramURL;
  }
  
  protected void zzmS()
  {
    zza("Network initialized. User agent", this.zzIA);
  }
  
  public boolean zzqa()
  {
    zzmR();
    zzob();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected()))
      {
        zzbP("No network connectivity");
        return false;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return true;
  }
  
  public List<Long> zzt(List<zzsz> paramList)
  {
    boolean bool = true;
    zzmR();
    zzob();
    zzac.zzw(paramList);
    int j;
    int i;
    if ((zznT().zzpp().isEmpty()) || (!this.zzagy.zzA(zznT().zzpi() * 1000L)))
    {
      j = 0;
      bool = false;
      i = j;
      label59:
      if (i != 0) {
        return zza(paramList, bool);
      }
    }
    else
    {
      if (zznT().zzpn() != zzsj.zzaeL) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (zznT().zzpo() != zzsm.zzaeW) {
          break;
        }
        break label59;
      }
    }
    return zzu(paramList);
  }
  
  List<Long> zzu(List<zzsz> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      zzsz localzzsz = (zzsz)paramList.next();
      if (!zzg(localzzsz)) {
        break;
      }
      localArrayList.add(Long.valueOf(localzzsz.zzpP()));
    } while (localArrayList.size() < zznT().zzpg());
    return localArrayList;
  }
  
  private class zza
  {
    private int zzagA;
    private ByteArrayOutputStream zzagB = new ByteArrayOutputStream();
    
    public zza() {}
    
    public byte[] getPayload()
    {
      return this.zzagB.toByteArray();
    }
    
    public boolean zzj(zzsz paramzzsz)
    {
      zzac.zzw(paramzzsz);
      if (this.zzagA + 1 > zztf.this.zznT().zzph()) {
        return false;
      }
      Object localObject = zztf.this.zza(paramzzsz, false);
      if (localObject == null)
      {
        zztf.this.zznS().zza(paramzzsz, "Error formatting hit");
        return true;
      }
      localObject = ((String)localObject).getBytes();
      int j = localObject.length;
      if (j > zztf.this.zznT().zzoZ())
      {
        zztf.this.zznS().zza(paramzzsz, "Hit size exceeds the maximum size limit");
        return true;
      }
      int i = j;
      if (this.zzagB.size() > 0) {
        i = j + 1;
      }
      if (i + this.zzagB.size() > zztf.this.zznT().zzpb()) {
        return false;
      }
      try
      {
        if (this.zzagB.size() > 0) {
          this.zzagB.write(zztf.zzqc());
        }
        this.zzagB.write((byte[])localObject);
        this.zzagA += 1;
        return true;
      }
      catch (IOException paramzzsz)
      {
        zztf.this.zze("Failed to write payload when batching hits", paramzzsz);
      }
      return true;
    }
    
    public int zzqd()
    {
      return this.zzagA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zztf
 * JD-Core Version:    0.7.0.1
 */