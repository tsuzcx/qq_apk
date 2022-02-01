package midas.x;

import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class lc
  implements cb
{
  public final ArrayList<wa> a = new ArrayList();
  public final mc b;
  
  public lc(mc parammc)
  {
    this.b = parammc;
  }
  
  public static void c(HttpURLConnection paramHttpURLConnection, fb paramfb)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    if (paramfb == null) {
      return;
    }
    if (!paramfb.m()) {
      return;
    }
    if (!(paramHttpURLConnection instanceof HttpsURLConnection)) {
      return;
    }
    paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
    HostnameVerifier localHostnameVerifier = paramfb.d();
    if (localHostnameVerifier != null) {
      paramHttpURLConnection.setHostnameVerifier(localHostnameVerifier);
    }
    paramfb = paramfb.e();
    if (paramfb != null) {
      paramHttpURLConnection.setSSLSocketFactory(paramfb);
    }
  }
  
  public gb a(fb paramfb, gb paramgb)
  {
    if (paramfb == null) {
      return paramgb;
    }
    return b(paramfb);
  }
  
  public final void a(DataOutputStream paramDataOutputStream, nc paramnc)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encode file length: ");
      ((StringBuilder)localObject).append(paramnc.t().length());
      ya.a("HTTP-UPLOAD", ((StringBuilder)localObject).toString());
      paramnc = new FileInputStream(paramnc.t());
      localObject = new byte[4096];
      for (;;)
      {
        int i = paramnc.read((byte[])localObject);
        if (i == -1) {
          break;
        }
        paramDataOutputStream.write((byte[])localObject, 0, i);
      }
      paramDataOutputStream.flush();
      return;
    }
    catch (Exception paramDataOutputStream)
    {
      paramDataOutputStream.printStackTrace();
      paramnc = new StringBuilder();
      paramnc.append("write http out failed: ");
      paramnc.append(Arrays.toString(paramDataOutputStream.getStackTrace()));
      ya.b("HTTP-UPLOAD", paramnc.toString());
    }
  }
  
  public final void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.flush();
        paramOutputStream.close();
        return;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  public final void a(HttpURLConnection paramHttpURLConnection, fb paramfb)
  {
    if (paramfb == null) {
      return;
    }
    paramfb = paramfb.h();
    if (paramfb == null) {
      return;
    }
    if (paramfb.size() <= 0) {
      return;
    }
    paramfb = paramfb.entrySet().iterator();
    while (paramfb.hasNext())
    {
      Object localObject = (Map.Entry)paramfb.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!TextUtils.isEmpty(str)) {
        paramHttpURLConnection.setRequestProperty(str, (String)localObject);
      }
    }
  }
  
  public final void a(fb paramfb)
  {
    if (this.a.size() == 0) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((wa)localIterator.next()).a(paramfb);
    }
  }
  
  /* Error */
  public final gb b(fb paramfb)
  {
    // Byte code:
    //   0: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 206	midas/x/gb
    //   8: dup
    //   9: invokespecial 207	midas/x/gb:<init>	()V
    //   12: astore 16
    //   14: aload_1
    //   15: ifnonnull +6 -> 21
    //   18: aload 16
    //   20: areturn
    //   21: aload 16
    //   23: aload_1
    //   24: invokevirtual 208	midas/x/gb:a	(Lmidas/x/fb;)V
    //   27: aload_1
    //   28: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   31: putfield 211	midas/x/fb:a	J
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 212	midas/x/lc:a	(Lmidas/x/fb;)V
    //   39: aload_1
    //   40: invokevirtual 215	midas/x/fb:r	()V
    //   43: aload_1
    //   44: invokevirtual 218	midas/x/fb:f	()Ljava/lang/String;
    //   47: astore 9
    //   49: new 59	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   56: astore 10
    //   58: aload 10
    //   60: ldc 220
    //   62: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 10
    //   68: aload 9
    //   70: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 83
    //   76: aload 10
    //   78: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload 9
    //   86: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: istore 8
    //   91: iload 8
    //   93: ifeq +82 -> 175
    //   96: aload_0
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   102: aload_1
    //   103: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   106: aload_1
    //   107: getfield 224	midas/x/fb:b	J
    //   110: lsub
    //   111: putfield 226	midas/x/fb:c	J
    //   114: aload 16
    //   116: getfield 229	midas/x/gb:a	I
    //   119: sipush 200
    //   122: if_icmpeq +8 -> 130
    //   125: aload_1
    //   126: iconst_1
    //   127: putfield 233	midas/x/fb:g	Z
    //   130: aload_0
    //   131: aload_1
    //   132: aload 16
    //   134: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   137: new 59	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   144: astore_1
    //   145: aload_1
    //   146: ldc 238
    //   148: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   156: lload 4
    //   158: lsub
    //   159: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 240
    //   165: aload_1
    //   166: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 16
    //   174: areturn
    //   175: new 242	java/net/URL
    //   178: dup
    //   179: aload 9
    //   181: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   184: invokevirtual 249	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   187: astore 9
    //   189: aload 9
    //   191: ifnonnull +55 -> 246
    //   194: aload_0
    //   195: aconst_null
    //   196: aconst_null
    //   197: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   200: aload_1
    //   201: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   204: aload_1
    //   205: getfield 224	midas/x/fb:b	J
    //   208: lsub
    //   209: putfield 226	midas/x/fb:c	J
    //   212: aload 16
    //   214: getfield 229	midas/x/gb:a	I
    //   217: sipush 200
    //   220: if_icmpeq +8 -> 228
    //   223: aload_1
    //   224: iconst_1
    //   225: putfield 233	midas/x/fb:g	Z
    //   228: aload_0
    //   229: aload_1
    //   230: aload 16
    //   232: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   235: new 59	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   242: astore_1
    //   243: goto -98 -> 145
    //   246: aload 9
    //   248: instanceof 183
    //   251: istore 8
    //   253: iload 8
    //   255: ifne +55 -> 310
    //   258: aload_0
    //   259: aconst_null
    //   260: aconst_null
    //   261: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   264: aload_1
    //   265: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   268: aload_1
    //   269: getfield 224	midas/x/fb:b	J
    //   272: lsub
    //   273: putfield 226	midas/x/fb:c	J
    //   276: aload 16
    //   278: getfield 229	midas/x/gb:a	I
    //   281: sipush 200
    //   284: if_icmpeq +8 -> 292
    //   287: aload_1
    //   288: iconst_1
    //   289: putfield 233	midas/x/fb:g	Z
    //   292: aload_0
    //   293: aload_1
    //   294: aload 16
    //   296: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   299: new 59	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   306: astore_1
    //   307: goto -162 -> 145
    //   310: aload 9
    //   312: checkcast 183	java/net/HttpURLConnection
    //   315: astore 11
    //   317: new 59	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   324: astore 9
    //   326: aload 9
    //   328: ldc 251
    //   330: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 9
    //   336: aload 11
    //   338: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 83
    //   344: aload 9
    //   346: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload 11
    //   354: iconst_0
    //   355: invokevirtual 258	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   358: aload 11
    //   360: iconst_0
    //   361: invokevirtual 261	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   364: aload_0
    //   365: aload 11
    //   367: aload_1
    //   368: invokevirtual 263	midas/x/lc:b	(Ljava/net/HttpURLConnection;Lmidas/x/fb;)V
    //   371: aload 11
    //   373: aload_1
    //   374: invokestatic 265	midas/x/lc:c	(Ljava/net/HttpURLConnection;Lmidas/x/fb;)V
    //   377: aload_0
    //   378: aload 11
    //   380: aload_1
    //   381: invokevirtual 267	midas/x/lc:a	(Ljava/net/HttpURLConnection;Lmidas/x/fb;)V
    //   384: aload 11
    //   386: iconst_1
    //   387: invokevirtual 270	java/net/HttpURLConnection:setDoInput	(Z)V
    //   390: aload 11
    //   392: ldc_w 272
    //   395: invokevirtual 275	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   398: aload 11
    //   400: iconst_1
    //   401: invokevirtual 278	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   404: aload_1
    //   405: invokevirtual 281	midas/x/fb:k	()Z
    //   408: istore 8
    //   410: iload 8
    //   412: ifeq +224 -> 636
    //   415: aload_1
    //   416: invokevirtual 283	midas/x/fb:c	()Ljava/lang/String;
    //   419: astore 9
    //   421: new 59	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   428: astore 10
    //   430: aload 10
    //   432: ldc_w 285
    //   435: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 10
    //   441: aload 9
    //   443: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: ldc 83
    //   449: aload 10
    //   451: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload 9
    //   459: ldc_w 287
    //   462: invokevirtual 291	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   465: astore 9
    //   467: aload 9
    //   469: arraylength
    //   470: istore_3
    //   471: iload_3
    //   472: istore_2
    //   473: aload_1
    //   474: instanceof 68
    //   477: ifeq +18 -> 495
    //   480: iload_3
    //   481: i2l
    //   482: aload_1
    //   483: checkcast 68	midas/x/nc
    //   486: invokevirtual 72	midas/x/nc:t	()Ljava/io/File;
    //   489: invokevirtual 78	java/io/File:length	()J
    //   492: ladd
    //   493: l2i
    //   494: istore_2
    //   495: aload 11
    //   497: ldc_w 293
    //   500: iload_2
    //   501: invokestatic 297	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   504: invokevirtual 186	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload 11
    //   509: iload_2
    //   510: invokevirtual 301	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   513: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   516: lstore 6
    //   518: new 103	java/io/DataOutputStream
    //   521: dup
    //   522: aload 11
    //   524: invokevirtual 305	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   527: invokespecial 308	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   530: astore 10
    //   532: aload 10
    //   534: aload 9
    //   536: invokevirtual 311	java/io/DataOutputStream:write	([B)V
    //   539: aload 10
    //   541: invokevirtual 110	java/io/DataOutputStream:flush	()V
    //   544: ldc 83
    //   546: ldc_w 313
    //   549: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload_1
    //   553: instanceof 68
    //   556: ifeq +21 -> 577
    //   559: ldc 83
    //   561: ldc_w 315
    //   564: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: aload_0
    //   568: aload 10
    //   570: aload_1
    //   571: checkcast 68	midas/x/nc
    //   574: invokevirtual 317	midas/x/lc:a	(Ljava/io/DataOutputStream;Lmidas/x/nc;)V
    //   577: aload_1
    //   578: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   581: lload 6
    //   583: lsub
    //   584: putfield 319	midas/x/fb:d	J
    //   587: aload 10
    //   589: invokevirtual 320	java/io/DataOutputStream:close	()V
    //   592: goto +44 -> 636
    //   595: astore 9
    //   597: new 59	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   604: astore 10
    //   606: aload 10
    //   608: ldc_w 322
    //   611: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 10
    //   617: aload 9
    //   619: invokevirtual 325	java/io/IOException:getMessage	()Ljava/lang/String;
    //   622: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: ldc 83
    //   628: aload 10
    //   630: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 126	midas/x/ya:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload 11
    //   638: invokevirtual 328	java/net/HttpURLConnection:getResponseCode	()I
    //   641: istore_2
    //   642: new 59	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   649: astore 9
    //   651: aload 9
    //   653: ldc_w 330
    //   656: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 9
    //   662: iload_2
    //   663: invokevirtual 333	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: ldc 83
    //   669: aload 9
    //   671: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 16
    //   679: iload_2
    //   680: putfield 229	midas/x/gb:a	I
    //   683: iload_2
    //   684: sipush 200
    //   687: if_icmpne +244 -> 931
    //   690: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   693: lstore 6
    //   695: aload 11
    //   697: invokevirtual 337	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   700: astore 9
    //   702: aload_1
    //   703: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   706: lload 6
    //   708: lsub
    //   709: putfield 339	midas/x/fb:e	J
    //   712: new 341	java/io/ByteArrayOutputStream
    //   715: dup
    //   716: invokespecial 342	java/io/ByteArrayOutputStream:<init>	()V
    //   719: astore 10
    //   721: sipush 1024
    //   724: newarray byte
    //   726: astore 12
    //   728: aload 9
    //   730: aload 12
    //   732: invokevirtual 343	java/io/InputStream:read	([B)I
    //   735: istore_2
    //   736: iload_2
    //   737: ifle +15 -> 752
    //   740: aload 10
    //   742: aload 12
    //   744: iconst_0
    //   745: iload_2
    //   746: invokevirtual 344	java/io/ByteArrayOutputStream:write	([BII)V
    //   749: goto -21 -> 728
    //   752: aload 16
    //   754: new 172	java/lang/String
    //   757: dup
    //   758: aload 10
    //   760: invokevirtual 348	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   763: ldc_w 287
    //   766: invokespecial 351	java/lang/String:<init>	([BLjava/lang/String;)V
    //   769: putfield 354	midas/x/gb:b	Ljava/lang/String;
    //   772: new 59	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   779: astore 12
    //   781: aload 12
    //   783: ldc_w 356
    //   786: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 12
    //   792: aload 16
    //   794: getfield 354	midas/x/gb:b	Ljava/lang/String;
    //   797: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: ldc 83
    //   803: aload 12
    //   805: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: goto +126 -> 937
    //   814: astore 12
    //   816: goto +755 -> 1571
    //   819: astore 14
    //   821: aload 9
    //   823: astore 12
    //   825: aload 10
    //   827: astore 13
    //   829: aload 11
    //   831: astore 15
    //   833: goto +264 -> 1097
    //   836: astore 14
    //   838: aload 9
    //   840: astore 12
    //   842: aload 10
    //   844: astore 13
    //   846: aload 11
    //   848: astore 15
    //   850: goto +358 -> 1208
    //   853: astore 14
    //   855: aload 9
    //   857: astore 12
    //   859: aload 10
    //   861: astore 13
    //   863: aload 11
    //   865: astore 15
    //   867: goto +452 -> 1319
    //   870: astore 14
    //   872: aload 9
    //   874: astore 12
    //   876: aload 10
    //   878: astore 13
    //   880: aload 11
    //   882: astore 15
    //   884: goto +546 -> 1430
    //   887: astore 12
    //   889: aconst_null
    //   890: astore 10
    //   892: goto +679 -> 1571
    //   895: astore 14
    //   897: aload 9
    //   899: astore 12
    //   901: goto +116 -> 1017
    //   904: astore 14
    //   906: aload 9
    //   908: astore 12
    //   910: goto +122 -> 1032
    //   913: astore 14
    //   915: aload 9
    //   917: astore 12
    //   919: goto +128 -> 1047
    //   922: astore 14
    //   924: aload 9
    //   926: astore 12
    //   928: goto +134 -> 1062
    //   931: aconst_null
    //   932: astore 10
    //   934: aconst_null
    //   935: astore 9
    //   937: aload_0
    //   938: aload 9
    //   940: aload 10
    //   942: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   945: aload 11
    //   947: ifnull +8 -> 955
    //   950: aload 11
    //   952: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   955: aload_1
    //   956: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   959: aload_1
    //   960: getfield 224	midas/x/fb:b	J
    //   963: lsub
    //   964: putfield 226	midas/x/fb:c	J
    //   967: aload 16
    //   969: getfield 229	midas/x/gb:a	I
    //   972: sipush 200
    //   975: if_icmpeq +8 -> 983
    //   978: aload_1
    //   979: iconst_1
    //   980: putfield 233	midas/x/fb:g	Z
    //   983: aload_0
    //   984: aload_1
    //   985: aload 16
    //   987: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   990: new 59	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   997: astore_1
    //   998: goto +529 -> 1527
    //   1001: astore 12
    //   1003: aconst_null
    //   1004: astore 10
    //   1006: aconst_null
    //   1007: astore 9
    //   1009: goto +562 -> 1571
    //   1012: astore 14
    //   1014: aconst_null
    //   1015: astore 12
    //   1017: aconst_null
    //   1018: astore 13
    //   1020: aload 11
    //   1022: astore 15
    //   1024: goto +73 -> 1097
    //   1027: astore 14
    //   1029: aconst_null
    //   1030: astore 12
    //   1032: aconst_null
    //   1033: astore 13
    //   1035: aload 11
    //   1037: astore 15
    //   1039: goto +169 -> 1208
    //   1042: astore 14
    //   1044: aconst_null
    //   1045: astore 12
    //   1047: aconst_null
    //   1048: astore 13
    //   1050: aload 11
    //   1052: astore 15
    //   1054: goto +265 -> 1319
    //   1057: astore 14
    //   1059: aconst_null
    //   1060: astore 12
    //   1062: aconst_null
    //   1063: astore 13
    //   1065: aload 11
    //   1067: astore 15
    //   1069: goto +361 -> 1430
    //   1072: astore 12
    //   1074: aconst_null
    //   1075: astore 10
    //   1077: aconst_null
    //   1078: astore 9
    //   1080: aconst_null
    //   1081: astore 11
    //   1083: goto +488 -> 1571
    //   1086: astore 14
    //   1088: aconst_null
    //   1089: astore 12
    //   1091: aconst_null
    //   1092: astore 13
    //   1094: aconst_null
    //   1095: astore 15
    //   1097: aload 12
    //   1099: astore 11
    //   1101: aload 13
    //   1103: astore 10
    //   1105: aload 15
    //   1107: astore 9
    //   1109: aload 14
    //   1111: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   1114: aload 12
    //   1116: astore 11
    //   1118: aload 13
    //   1120: astore 10
    //   1122: aload 15
    //   1124: astore 9
    //   1126: aload 16
    //   1128: aload 14
    //   1130: putfield 362	midas/x/gb:c	Ljava/lang/Exception;
    //   1133: aload_0
    //   1134: aload 12
    //   1136: aload 13
    //   1138: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1141: aload 15
    //   1143: ifnull +8 -> 1151
    //   1146: aload 15
    //   1148: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1151: aload_1
    //   1152: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1155: aload_1
    //   1156: getfield 224	midas/x/fb:b	J
    //   1159: lsub
    //   1160: putfield 226	midas/x/fb:c	J
    //   1163: aload 16
    //   1165: getfield 229	midas/x/gb:a	I
    //   1168: sipush 200
    //   1171: if_icmpeq +8 -> 1179
    //   1174: aload_1
    //   1175: iconst_1
    //   1176: putfield 233	midas/x/fb:g	Z
    //   1179: aload_0
    //   1180: aload_1
    //   1181: aload 16
    //   1183: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   1186: new 59	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1193: astore_1
    //   1194: goto +333 -> 1527
    //   1197: astore 14
    //   1199: aconst_null
    //   1200: astore 12
    //   1202: aconst_null
    //   1203: astore 13
    //   1205: aconst_null
    //   1206: astore 15
    //   1208: aload 12
    //   1210: astore 11
    //   1212: aload 13
    //   1214: astore 10
    //   1216: aload 15
    //   1218: astore 9
    //   1220: aload 14
    //   1222: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   1225: aload 12
    //   1227: astore 11
    //   1229: aload 13
    //   1231: astore 10
    //   1233: aload 15
    //   1235: astore 9
    //   1237: aload 16
    //   1239: aload 14
    //   1241: putfield 362	midas/x/gb:c	Ljava/lang/Exception;
    //   1244: aload_0
    //   1245: aload 12
    //   1247: aload 13
    //   1249: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1252: aload 15
    //   1254: ifnull +8 -> 1262
    //   1257: aload 15
    //   1259: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1262: aload_1
    //   1263: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1266: aload_1
    //   1267: getfield 224	midas/x/fb:b	J
    //   1270: lsub
    //   1271: putfield 226	midas/x/fb:c	J
    //   1274: aload 16
    //   1276: getfield 229	midas/x/gb:a	I
    //   1279: sipush 200
    //   1282: if_icmpeq +8 -> 1290
    //   1285: aload_1
    //   1286: iconst_1
    //   1287: putfield 233	midas/x/fb:g	Z
    //   1290: aload_0
    //   1291: aload_1
    //   1292: aload 16
    //   1294: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   1297: new 59	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1304: astore_1
    //   1305: goto +222 -> 1527
    //   1308: astore 14
    //   1310: aconst_null
    //   1311: astore 12
    //   1313: aconst_null
    //   1314: astore 13
    //   1316: aconst_null
    //   1317: astore 15
    //   1319: aload 12
    //   1321: astore 11
    //   1323: aload 13
    //   1325: astore 10
    //   1327: aload 15
    //   1329: astore 9
    //   1331: aload 14
    //   1333: invokevirtual 364	java/net/SocketTimeoutException:printStackTrace	()V
    //   1336: aload 12
    //   1338: astore 11
    //   1340: aload 13
    //   1342: astore 10
    //   1344: aload 15
    //   1346: astore 9
    //   1348: aload 16
    //   1350: aload 14
    //   1352: putfield 362	midas/x/gb:c	Ljava/lang/Exception;
    //   1355: aload_0
    //   1356: aload 12
    //   1358: aload 13
    //   1360: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1363: aload 15
    //   1365: ifnull +8 -> 1373
    //   1368: aload 15
    //   1370: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1373: aload_1
    //   1374: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1377: aload_1
    //   1378: getfield 224	midas/x/fb:b	J
    //   1381: lsub
    //   1382: putfield 226	midas/x/fb:c	J
    //   1385: aload 16
    //   1387: getfield 229	midas/x/gb:a	I
    //   1390: sipush 200
    //   1393: if_icmpeq +8 -> 1401
    //   1396: aload_1
    //   1397: iconst_1
    //   1398: putfield 233	midas/x/fb:g	Z
    //   1401: aload_0
    //   1402: aload_1
    //   1403: aload 16
    //   1405: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   1408: new 59	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1415: astore_1
    //   1416: goto +111 -> 1527
    //   1419: astore 14
    //   1421: aconst_null
    //   1422: astore 12
    //   1424: aconst_null
    //   1425: astore 13
    //   1427: aconst_null
    //   1428: astore 15
    //   1430: aload 12
    //   1432: astore 11
    //   1434: aload 13
    //   1436: astore 10
    //   1438: aload 15
    //   1440: astore 9
    //   1442: aload 14
    //   1444: invokevirtual 365	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   1447: aload 12
    //   1449: astore 11
    //   1451: aload 13
    //   1453: astore 10
    //   1455: aload 15
    //   1457: astore 9
    //   1459: aload 16
    //   1461: aload 14
    //   1463: putfield 362	midas/x/gb:c	Ljava/lang/Exception;
    //   1466: aload_0
    //   1467: aload 12
    //   1469: aload 13
    //   1471: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1474: aload 15
    //   1476: ifnull +8 -> 1484
    //   1479: aload 15
    //   1481: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1484: aload_1
    //   1485: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1488: aload_1
    //   1489: getfield 224	midas/x/fb:b	J
    //   1492: lsub
    //   1493: putfield 226	midas/x/fb:c	J
    //   1496: aload 16
    //   1498: getfield 229	midas/x/gb:a	I
    //   1501: sipush 200
    //   1504: if_icmpeq +8 -> 1512
    //   1507: aload_1
    //   1508: iconst_1
    //   1509: putfield 233	midas/x/fb:g	Z
    //   1512: aload_0
    //   1513: aload_1
    //   1514: aload 16
    //   1516: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   1519: new 59	java/lang/StringBuilder
    //   1522: dup
    //   1523: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1526: astore_1
    //   1527: aload_1
    //   1528: ldc 238
    //   1530: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload_1
    //   1535: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1538: lload 4
    //   1540: lsub
    //   1541: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: ldc 240
    //   1547: aload_1
    //   1548: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload 16
    //   1556: areturn
    //   1557: astore 12
    //   1559: aload 11
    //   1561: astore 13
    //   1563: aload 9
    //   1565: astore 11
    //   1567: aload 13
    //   1569: astore 9
    //   1571: aload_0
    //   1572: aload 9
    //   1574: aload 10
    //   1576: invokevirtual 222	midas/x/lc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1579: aload 11
    //   1581: ifnull +8 -> 1589
    //   1584: aload 11
    //   1586: invokevirtual 359	java/net/HttpURLConnection:disconnect	()V
    //   1589: aload_1
    //   1590: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1593: aload_1
    //   1594: getfield 224	midas/x/fb:b	J
    //   1597: lsub
    //   1598: putfield 226	midas/x/fb:c	J
    //   1601: aload 16
    //   1603: getfield 229	midas/x/gb:a	I
    //   1606: sipush 200
    //   1609: if_icmpeq +8 -> 1617
    //   1612: aload_1
    //   1613: iconst_1
    //   1614: putfield 233	midas/x/fb:g	Z
    //   1617: aload_0
    //   1618: aload_1
    //   1619: aload 16
    //   1621: invokevirtual 236	midas/x/lc:b	(Lmidas/x/fb;Lmidas/x/gb;)V
    //   1624: new 59	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1631: astore_1
    //   1632: aload_1
    //   1633: ldc 238
    //   1635: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload_1
    //   1640: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1643: lload 4
    //   1645: lsub
    //   1646: invokevirtual 81	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: ldc 240
    //   1652: aload_1
    //   1653: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1656: invokestatic 92	midas/x/ya:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1659: goto +6 -> 1665
    //   1662: aload 12
    //   1664: athrow
    //   1665: goto -3 -> 1662
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1668	0	this	lc
    //   0	1668	1	paramfb	fb
    //   472	274	2	i	int
    //   470	11	3	j	int
    //   3	1641	4	l1	long
    //   516	191	6	l2	long
    //   89	322	8	bool	boolean
    //   47	488	9	localObject1	Object
    //   595	23	9	localIOException1	java.io.IOException
    //   649	924	9	localObject2	Object
    //   56	1519	10	localObject3	Object
    //   315	1270	11	localObject4	Object
    //   726	78	12	localObject5	Object
    //   814	1	12	localObject6	Object
    //   823	52	12	localObject7	Object
    //   887	1	12	localObject8	Object
    //   899	28	12	localObject9	Object
    //   1001	1	12	localObject10	Object
    //   1015	46	12	localObject11	Object
    //   1072	1	12	localObject12	Object
    //   1089	379	12	localInputStream	InputStream
    //   1557	106	12	localObject13	Object
    //   827	741	13	localObject14	Object
    //   819	1	14	localException1	Exception
    //   836	1	14	localIOException2	java.io.IOException
    //   853	1	14	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   870	1	14	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   895	1	14	localException2	Exception
    //   904	1	14	localIOException3	java.io.IOException
    //   913	1	14	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   922	1	14	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   1012	1	14	localException3	Exception
    //   1027	1	14	localIOException4	java.io.IOException
    //   1042	1	14	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1057	1	14	localConnectTimeoutException3	org.apache.http.conn.ConnectTimeoutException
    //   1086	43	14	localException4	Exception
    //   1197	43	14	localIOException5	java.io.IOException
    //   1308	43	14	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   1419	43	14	localConnectTimeoutException4	org.apache.http.conn.ConnectTimeoutException
    //   831	649	15	localObject15	Object
    //   12	1608	16	localgb	gb
    // Exception table:
    //   from	to	target	type
    //   587	592	595	java/io/IOException
    //   721	728	814	finally
    //   728	736	814	finally
    //   740	749	814	finally
    //   752	811	814	finally
    //   721	728	819	java/lang/Exception
    //   728	736	819	java/lang/Exception
    //   740	749	819	java/lang/Exception
    //   752	811	819	java/lang/Exception
    //   721	728	836	java/io/IOException
    //   728	736	836	java/io/IOException
    //   740	749	836	java/io/IOException
    //   752	811	836	java/io/IOException
    //   721	728	853	java/net/SocketTimeoutException
    //   728	736	853	java/net/SocketTimeoutException
    //   740	749	853	java/net/SocketTimeoutException
    //   752	811	853	java/net/SocketTimeoutException
    //   721	728	870	org/apache/http/conn/ConnectTimeoutException
    //   728	736	870	org/apache/http/conn/ConnectTimeoutException
    //   740	749	870	org/apache/http/conn/ConnectTimeoutException
    //   752	811	870	org/apache/http/conn/ConnectTimeoutException
    //   702	721	887	finally
    //   702	721	895	java/lang/Exception
    //   702	721	904	java/io/IOException
    //   702	721	913	java/net/SocketTimeoutException
    //   702	721	922	org/apache/http/conn/ConnectTimeoutException
    //   317	410	1001	finally
    //   415	471	1001	finally
    //   473	495	1001	finally
    //   495	577	1001	finally
    //   577	587	1001	finally
    //   587	592	1001	finally
    //   597	636	1001	finally
    //   636	683	1001	finally
    //   690	702	1001	finally
    //   317	410	1012	java/lang/Exception
    //   415	471	1012	java/lang/Exception
    //   473	495	1012	java/lang/Exception
    //   495	577	1012	java/lang/Exception
    //   577	587	1012	java/lang/Exception
    //   587	592	1012	java/lang/Exception
    //   597	636	1012	java/lang/Exception
    //   636	683	1012	java/lang/Exception
    //   690	702	1012	java/lang/Exception
    //   317	410	1027	java/io/IOException
    //   415	471	1027	java/io/IOException
    //   473	495	1027	java/io/IOException
    //   495	577	1027	java/io/IOException
    //   577	587	1027	java/io/IOException
    //   597	636	1027	java/io/IOException
    //   636	683	1027	java/io/IOException
    //   690	702	1027	java/io/IOException
    //   317	410	1042	java/net/SocketTimeoutException
    //   415	471	1042	java/net/SocketTimeoutException
    //   473	495	1042	java/net/SocketTimeoutException
    //   495	577	1042	java/net/SocketTimeoutException
    //   577	587	1042	java/net/SocketTimeoutException
    //   597	636	1042	java/net/SocketTimeoutException
    //   636	683	1042	java/net/SocketTimeoutException
    //   690	702	1042	java/net/SocketTimeoutException
    //   317	410	1057	org/apache/http/conn/ConnectTimeoutException
    //   415	471	1057	org/apache/http/conn/ConnectTimeoutException
    //   473	495	1057	org/apache/http/conn/ConnectTimeoutException
    //   495	577	1057	org/apache/http/conn/ConnectTimeoutException
    //   577	587	1057	org/apache/http/conn/ConnectTimeoutException
    //   597	636	1057	org/apache/http/conn/ConnectTimeoutException
    //   636	683	1057	org/apache/http/conn/ConnectTimeoutException
    //   690	702	1057	org/apache/http/conn/ConnectTimeoutException
    //   39	91	1072	finally
    //   175	189	1072	finally
    //   246	253	1072	finally
    //   310	317	1072	finally
    //   39	91	1086	java/lang/Exception
    //   175	189	1086	java/lang/Exception
    //   246	253	1086	java/lang/Exception
    //   310	317	1086	java/lang/Exception
    //   39	91	1197	java/io/IOException
    //   175	189	1197	java/io/IOException
    //   246	253	1197	java/io/IOException
    //   310	317	1197	java/io/IOException
    //   39	91	1308	java/net/SocketTimeoutException
    //   175	189	1308	java/net/SocketTimeoutException
    //   246	253	1308	java/net/SocketTimeoutException
    //   310	317	1308	java/net/SocketTimeoutException
    //   39	91	1419	org/apache/http/conn/ConnectTimeoutException
    //   175	189	1419	org/apache/http/conn/ConnectTimeoutException
    //   246	253	1419	org/apache/http/conn/ConnectTimeoutException
    //   310	317	1419	org/apache/http/conn/ConnectTimeoutException
    //   1109	1114	1557	finally
    //   1126	1133	1557	finally
    //   1220	1225	1557	finally
    //   1237	1244	1557	finally
    //   1331	1336	1557	finally
    //   1348	1355	1557	finally
    //   1442	1447	1557	finally
    //   1459	1466	1557	finally
  }
  
  public final void b(HttpURLConnection paramHttpURLConnection, fb paramfb)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    mc localmc = this.b;
    if (localmc != null)
    {
      k = localmc.d;
      j = localmc.e;
    }
    else
    {
      j = 15000;
      k = 15000;
    }
    int i = k;
    if (paramfb != null)
    {
      m = paramfb.o;
      i = k;
      if (m > 0) {
        i = m;
      }
    }
    if (paramfb != null)
    {
      k = paramfb.p;
      if (k > 0) {
        j = k;
      }
    }
    int k = i;
    if (i > 20000) {
      k = 20000;
    }
    int m = k;
    if (k <= 0) {
      m = 15000;
    }
    i = j;
    if (j > 20000) {
      i = 15000;
    }
    int j = i;
    if (i <= 0) {
      j = 15000;
    }
    paramHttpURLConnection.setConnectTimeout(m);
    paramHttpURLConnection.setReadTimeout(j);
  }
  
  public final void b(fb paramfb, gb paramgb)
  {
    if (this.a.size() == 0) {
      return;
    }
    int i = this.a.size();
    ListIterator localListIterator = this.a.listIterator(i);
    while (localListIterator.hasPrevious()) {
      ((wa)localListIterator.previous()).a(paramfb, paramgb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.lc
 * JD-Core Version:    0.7.0.1
 */