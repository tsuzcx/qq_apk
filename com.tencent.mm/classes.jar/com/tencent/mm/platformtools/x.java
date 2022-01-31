package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.e;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Vector;

public final class x
{
  private static LinkedList<x.a> eRG = new LinkedList();
  private static Vector<WeakReference<x.a>> ebv = new Vector();
  
  public static Bitmap a(v paramv)
  {
    if (!b(paramv)) {
      return null;
    }
    if (!g.DP().DC()) {
      return paramv.UT();
    }
    if (paramv.US()) {
      return x.b.a(x.b.eRH, paramv);
    }
    return x.b.b(x.b.eRH, paramv);
  }
  
  public static boolean a(x.a parama)
  {
    return ebv.add(new WeakReference(parama));
  }
  
  private static boolean b(v paramv)
  {
    return (paramv != null) && (!bk.bl(paramv.UP()));
  }
  
  public static boolean b(x.a parama)
  {
    eRG.remove(parama);
    return eRG.add(parama);
  }
  
  public static boolean c(x.a parama)
  {
    return eRG.remove(parama);
  }
  
  public static Bitmap o(String paramString, int paramInt1, int paramInt2)
  {
    return x.b.o(paramString, paramInt1, paramInt2);
  }
  
  public static Bitmap pg(String paramString)
  {
    return x.b.pg(paramString);
  }
  
  public static Bitmap ph(String paramString)
  {
    return x.b.ph(paramString);
  }
  
  private static final class b$a
    implements av.a
  {
    private int eRO = 0;
    private v eRP;
    private Bitmap ebo = null;
    
    public b$a(v paramv)
    {
      if (!x.c(paramv)) {
        throw new IllegalArgumentException("from net, picture strategy here must be validity");
      }
      this.eRP = paramv;
    }
    
    /* Error */
    public final boolean JS()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   4: ifnonnull +12 -> 16
      //   7: ldc 48
      //   9: ldc 50
      //   11: invokestatic 56	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   14: iconst_1
      //   15: ireturn
      //   16: aload_0
      //   17: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   20: invokeinterface 61 1 0
      //   25: new 63	java/io/File
      //   28: dup
      //   29: aload_0
      //   30: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   33: invokeinterface 67 1 0
      //   38: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
      //   41: astore 8
      //   43: new 70	java/io/FileOutputStream
      //   46: dup
      //   47: new 72	java/lang/StringBuilder
      //   50: dup
      //   51: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   54: aload 8
      //   56: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   59: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   62: ldc 82
      //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   70: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   73: astore 5
      //   75: aload_0
      //   76: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   79: invokeinterface 89 1 0
      //   84: aconst_null
      //   85: invokestatic 94	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
      //   88: astore_3
      //   89: invokestatic 99	com/tencent/mm/as/q:OQ	()Z
      //   92: ifeq +45 -> 137
      //   95: aload_0
      //   96: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   99: invokeinterface 89 1 0
      //   104: invokestatic 103	com/tencent/mm/as/q:mp	(Ljava/lang/String;)Z
      //   107: ifeq +30 -> 137
      //   110: getstatic 108	com/tencent/mm/protocal/d:spa	I
      //   113: invokestatic 112	com/tencent/mm/as/q:iQ	(I)Ljava/lang/String;
      //   116: astore_2
      //   117: ldc 48
      //   119: ldc 114
      //   121: iconst_1
      //   122: anewarray 4	java/lang/Object
      //   125: dup
      //   126: iconst_0
      //   127: aload_2
      //   128: aastore
      //   129: invokestatic 118	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   132: aload_3
      //   133: aload_2
      //   134: invokevirtual 123	com/tencent/mm/network/u:oM	(Ljava/lang/String;)V
      //   137: aload_3
      //   138: sipush 10000
      //   141: invokevirtual 127	com/tencent/mm/network/u:setConnectTimeout	(I)V
      //   144: aload_3
      //   145: sipush 20000
      //   148: invokevirtual 130	com/tencent/mm/network/u:setReadTimeout	(I)V
      //   151: aload_3
      //   152: ldc 132
      //   154: invokevirtual 135	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
      //   157: aload_3
      //   158: invokestatic 138	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/u;)I
      //   161: ifne +888 -> 1049
      //   164: aload_3
      //   165: invokevirtual 142	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
      //   168: astore_2
      //   169: aload_2
      //   170: astore 7
      //   172: aload 5
      //   174: astore 6
      //   176: aload_3
      //   177: getfield 146	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
      //   180: invokevirtual 151	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   183: astore 4
      //   185: aload_2
      //   186: astore 7
      //   188: aload 5
      //   190: astore 6
      //   192: ldc 48
      //   194: ldc 153
      //   196: iconst_1
      //   197: anewarray 4	java/lang/Object
      //   200: dup
      //   201: iconst_0
      //   202: aload 4
      //   204: aastore
      //   205: invokestatic 118	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   208: aload_2
      //   209: ifnonnull +110 -> 319
      //   212: aload_2
      //   213: astore 7
      //   215: aload 5
      //   217: astore 6
      //   219: ldc 48
      //   221: ldc 155
      //   223: iconst_1
      //   224: anewarray 4	java/lang/Object
      //   227: dup
      //   228: iconst_0
      //   229: aload_0
      //   230: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   233: invokeinterface 89 1 0
      //   238: aastore
      //   239: invokestatic 158	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   242: aload_2
      //   243: astore 7
      //   245: aload 5
      //   247: astore 6
      //   249: aload_0
      //   250: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   253: aload 4
      //   255: iconst_0
      //   256: invokeinterface 162 3 0
      //   261: aload_2
      //   262: ifnull +7 -> 269
      //   265: aload_2
      //   266: invokevirtual 167	java/io/InputStream:close	()V
      //   269: aload 5
      //   271: invokevirtual 168	java/io/FileOutputStream:close	()V
      //   274: iconst_1
      //   275: ireturn
      //   276: astore_2
      //   277: ldc 48
      //   279: ldc 170
      //   281: iconst_1
      //   282: anewarray 4	java/lang/Object
      //   285: dup
      //   286: iconst_0
      //   287: aload_2
      //   288: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   291: aastore
      //   292: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   295: iconst_1
      //   296: ireturn
      //   297: astore_2
      //   298: ldc 48
      //   300: ldc 170
      //   302: iconst_1
      //   303: anewarray 4	java/lang/Object
      //   306: dup
      //   307: iconst_0
      //   308: aload_2
      //   309: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   312: aastore
      //   313: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   316: goto -47 -> 269
      //   319: aload_2
      //   320: astore 7
      //   322: aload 5
      //   324: astore 6
      //   326: sipush 1024
      //   329: newarray byte
      //   331: astore_3
      //   332: aload_2
      //   333: astore 7
      //   335: aload 5
      //   337: astore 6
      //   339: aload_2
      //   340: aload_3
      //   341: invokevirtual 182	java/io/InputStream:read	([B)I
      //   344: istore_1
      //   345: iload_1
      //   346: iconst_m1
      //   347: if_icmpeq +154 -> 501
      //   350: aload_2
      //   351: astore 7
      //   353: aload 5
      //   355: astore 6
      //   357: aload_0
      //   358: aload_0
      //   359: getfield 22	com/tencent/mm/platformtools/x$b$a:eRO	I
      //   362: iload_1
      //   363: iadd
      //   364: putfield 22	com/tencent/mm/platformtools/x$b$a:eRO	I
      //   367: aload_2
      //   368: astore 7
      //   370: aload 5
      //   372: astore 6
      //   374: aload 5
      //   376: aload_3
      //   377: iconst_0
      //   378: iload_1
      //   379: invokevirtual 186	java/io/FileOutputStream:write	([BII)V
      //   382: goto -50 -> 332
      //   385: astore_3
      //   386: aload_2
      //   387: astore 7
      //   389: aload 5
      //   391: astore 6
      //   393: ldc 48
      //   395: ldc 170
      //   397: iconst_1
      //   398: anewarray 4	java/lang/Object
      //   401: dup
      //   402: iconst_0
      //   403: aload_3
      //   404: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   407: aastore
      //   408: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   411: aload_2
      //   412: astore 7
      //   414: aload 5
      //   416: astore 6
      //   418: ldc 48
      //   420: ldc 188
      //   422: iconst_1
      //   423: anewarray 4	java/lang/Object
      //   426: dup
      //   427: iconst_0
      //   428: aload_0
      //   429: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   432: invokeinterface 89 1 0
      //   437: aastore
      //   438: invokestatic 158	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   441: aload_2
      //   442: astore 7
      //   444: aload 5
      //   446: astore 6
      //   448: aload_0
      //   449: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   452: aload 4
      //   454: iconst_0
      //   455: invokeinterface 162 3 0
      //   460: aload_2
      //   461: ifnull +7 -> 468
      //   464: aload_2
      //   465: invokevirtual 167	java/io/InputStream:close	()V
      //   468: aload 5
      //   470: ifnull -456 -> 14
      //   473: aload 5
      //   475: invokevirtual 168	java/io/FileOutputStream:close	()V
      //   478: iconst_1
      //   479: ireturn
      //   480: astore_2
      //   481: ldc 48
      //   483: ldc 170
      //   485: iconst_1
      //   486: anewarray 4	java/lang/Object
      //   489: dup
      //   490: iconst_0
      //   491: aload_2
      //   492: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   495: aastore
      //   496: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   499: iconst_1
      //   500: ireturn
      //   501: aload_2
      //   502: astore 7
      //   504: aload 5
      //   506: astore 6
      //   508: ldc 48
      //   510: ldc 190
      //   512: iconst_2
      //   513: anewarray 4	java/lang/Object
      //   516: dup
      //   517: iconst_0
      //   518: aload_0
      //   519: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   522: invokeinterface 89 1 0
      //   527: aastore
      //   528: dup
      //   529: iconst_1
      //   530: aload_0
      //   531: getfield 22	com/tencent/mm/platformtools/x$b$a:eRO	I
      //   534: invokestatic 196	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   537: aastore
      //   538: invokestatic 199	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   541: aload_2
      //   542: astore 7
      //   544: aload 5
      //   546: astore 6
      //   548: aload_0
      //   549: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   552: aload 4
      //   554: iconst_1
      //   555: invokeinterface 162 3 0
      //   560: aload_2
      //   561: ifnull +7 -> 568
      //   564: aload_2
      //   565: invokevirtual 167	java/io/InputStream:close	()V
      //   568: aload 5
      //   570: invokevirtual 168	java/io/FileOutputStream:close	()V
      //   573: new 72	java/lang/StringBuilder
      //   576: dup
      //   577: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   580: aload 8
      //   582: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   585: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   588: ldc 82
      //   590: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   593: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   596: invokestatic 205	com/tencent/mm/a/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
      //   599: pop
      //   600: aload_0
      //   601: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   604: invokeinterface 209 1 0
      //   609: astore_2
      //   610: aload_2
      //   611: ifnull +299 -> 910
      //   614: aload_2
      //   615: new 72	java/lang/StringBuilder
      //   618: dup
      //   619: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   622: aload 8
      //   624: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   627: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: ldc 82
      //   632: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   635: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   638: invokeinterface 215 2 0
      //   643: astore_3
      //   644: aload_3
      //   645: ifnull +295 -> 940
      //   648: aload_0
      //   649: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   652: aload_3
      //   653: getstatic 221	com/tencent/mm/platformtools/v$a:eRD	Lcom/tencent/mm/platformtools/v$a;
      //   656: new 72	java/lang/StringBuilder
      //   659: dup
      //   660: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   663: aload 8
      //   665: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   668: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   671: ldc 82
      //   673: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   676: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   679: invokeinterface 224 4 0
      //   684: astore_2
      //   685: aload_2
      //   686: aload_3
      //   687: if_acmpeq +32 -> 719
      //   690: aload_3
      //   691: invokevirtual 229	android/graphics/Bitmap:isRecycled	()Z
      //   694: ifne +25 -> 719
      //   697: ldc 48
      //   699: ldc 231
      //   701: iconst_1
      //   702: anewarray 4	java/lang/Object
      //   705: dup
      //   706: iconst_0
      //   707: aload_3
      //   708: invokevirtual 232	java/lang/Object:toString	()Ljava/lang/String;
      //   711: aastore
      //   712: invokestatic 199	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   715: aload_3
      //   716: invokevirtual 235	android/graphics/Bitmap:recycle	()V
      //   719: getstatic 239	com/tencent/mm/platformtools/x$b:eRH	Lcom/tencent/mm/platformtools/x$b;
      //   722: aload_0
      //   723: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   726: aload_2
      //   727: invokestatic 242	com/tencent/mm/platformtools/x$b:a	(Lcom/tencent/mm/platformtools/x$b;Lcom/tencent/mm/platformtools/v;Landroid/graphics/Bitmap;)V
      //   730: new 63	java/io/File
      //   733: dup
      //   734: new 72	java/lang/StringBuilder
      //   737: dup
      //   738: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   741: aload 8
      //   743: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   746: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   749: ldc 82
      //   751: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   754: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   757: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
      //   760: invokevirtual 245	java/io/File:delete	()Z
      //   763: pop
      //   764: aload_0
      //   765: aload_2
      //   766: putfield 24	com/tencent/mm/platformtools/x$b$a:ebo	Landroid/graphics/Bitmap;
      //   769: iconst_1
      //   770: ireturn
      //   771: astore_2
      //   772: ldc 48
      //   774: ldc 170
      //   776: iconst_1
      //   777: anewarray 4	java/lang/Object
      //   780: dup
      //   781: iconst_0
      //   782: aload_2
      //   783: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   786: aastore
      //   787: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   790: goto -222 -> 568
      //   793: astore_2
      //   794: ldc 48
      //   796: ldc 170
      //   798: iconst_1
      //   799: anewarray 4	java/lang/Object
      //   802: dup
      //   803: iconst_0
      //   804: aload_2
      //   805: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   808: aastore
      //   809: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   812: goto -239 -> 573
      //   815: astore_2
      //   816: ldc 48
      //   818: ldc 170
      //   820: iconst_1
      //   821: anewarray 4	java/lang/Object
      //   824: dup
      //   825: iconst_0
      //   826: aload_2
      //   827: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   830: aastore
      //   831: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   834: goto -366 -> 468
      //   837: astore_2
      //   838: aconst_null
      //   839: astore 7
      //   841: aconst_null
      //   842: astore 5
      //   844: aload 7
      //   846: ifnull +8 -> 854
      //   849: aload 7
      //   851: invokevirtual 167	java/io/InputStream:close	()V
      //   854: aload 5
      //   856: ifnull +8 -> 864
      //   859: aload 5
      //   861: invokevirtual 168	java/io/FileOutputStream:close	()V
      //   864: aload_2
      //   865: athrow
      //   866: astore_3
      //   867: ldc 48
      //   869: ldc 170
      //   871: iconst_1
      //   872: anewarray 4	java/lang/Object
      //   875: dup
      //   876: iconst_0
      //   877: aload_3
      //   878: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   881: aastore
      //   882: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   885: goto -31 -> 854
      //   888: astore_3
      //   889: ldc 48
      //   891: ldc 170
      //   893: iconst_1
      //   894: anewarray 4	java/lang/Object
      //   897: dup
      //   898: iconst_0
      //   899: aload_3
      //   900: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   903: aastore
      //   904: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   907: goto -43 -> 864
      //   910: new 72	java/lang/StringBuilder
      //   913: dup
      //   914: invokespecial 73	java/lang/StringBuilder:<init>	()V
      //   917: aload 8
      //   919: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   922: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   925: ldc 82
      //   927: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   930: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   933: invokestatic 248	com/tencent/mm/platformtools/x$b:pg	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   936: astore_3
      //   937: goto -293 -> 644
      //   940: aload_0
      //   941: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   944: getstatic 221	com/tencent/mm/platformtools/v$a:eRD	Lcom/tencent/mm/platformtools/v$a;
      //   947: aload 4
      //   949: invokeinterface 251 3 0
      //   954: aconst_null
      //   955: astore_2
      //   956: goto -271 -> 685
      //   959: astore_2
      //   960: ldc 48
      //   962: ldc 253
      //   964: iconst_1
      //   965: anewarray 4	java/lang/Object
      //   968: dup
      //   969: iconst_0
      //   970: aload_0
      //   971: getfield 39	com/tencent/mm/platformtools/x$b$a:eRP	Lcom/tencent/mm/platformtools/v;
      //   974: invokeinterface 89 1 0
      //   979: aastore
      //   980: invokestatic 158	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   983: ldc 48
      //   985: ldc 170
      //   987: iconst_1
      //   988: anewarray 4	java/lang/Object
      //   991: dup
      //   992: iconst_0
      //   993: aload_2
      //   994: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   997: aastore
      //   998: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1001: aconst_null
      //   1002: astore_2
      //   1003: goto -239 -> 764
      //   1006: astore_2
      //   1007: aconst_null
      //   1008: astore 7
      //   1010: goto -166 -> 844
      //   1013: astore_2
      //   1014: aload 6
      //   1016: astore 5
      //   1018: goto -174 -> 844
      //   1021: astore_3
      //   1022: aconst_null
      //   1023: astore 4
      //   1025: aconst_null
      //   1026: astore_2
      //   1027: aconst_null
      //   1028: astore 5
      //   1030: goto -644 -> 386
      //   1033: astore_3
      //   1034: aconst_null
      //   1035: astore 4
      //   1037: aconst_null
      //   1038: astore_2
      //   1039: goto -653 -> 386
      //   1042: astore_3
      //   1043: aconst_null
      //   1044: astore 4
      //   1046: goto -660 -> 386
      //   1049: aconst_null
      //   1050: astore_2
      //   1051: goto -882 -> 169
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1054	0	this	a
      //   344	35	1	i	int
      //   116	150	2	localObject1	Object
      //   276	12	2	localIOException1	java.io.IOException
      //   297	168	2	localIOException2	java.io.IOException
      //   480	85	2	localIOException3	java.io.IOException
      //   609	157	2	localObject2	Object
      //   771	12	2	localIOException4	java.io.IOException
      //   793	12	2	localIOException5	java.io.IOException
      //   815	12	2	localIOException6	java.io.IOException
      //   837	28	2	localObject3	Object
      //   955	1	2	localObject4	Object
      //   959	35	2	localException1	Exception
      //   1002	1	2	localObject5	Object
      //   1006	1	2	localObject6	Object
      //   1013	1	2	localObject7	Object
      //   1026	25	2	localObject8	Object
      //   88	289	3	localObject9	Object
      //   385	19	3	localException2	Exception
      //   643	73	3	localBitmap1	Bitmap
      //   866	12	3	localIOException7	java.io.IOException
      //   888	12	3	localIOException8	java.io.IOException
      //   936	1	3	localBitmap2	Bitmap
      //   1021	1	3	localException3	Exception
      //   1033	1	3	localException4	Exception
      //   1042	1	3	localException5	Exception
      //   183	862	4	str	String
      //   73	956	5	localObject10	Object
      //   174	841	6	localObject11	Object
      //   170	839	7	localObject12	Object
      //   41	877	8	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   269	274	276	java/io/IOException
      //   265	269	297	java/io/IOException
      //   192	208	385	java/lang/Exception
      //   219	242	385	java/lang/Exception
      //   249	261	385	java/lang/Exception
      //   326	332	385	java/lang/Exception
      //   339	345	385	java/lang/Exception
      //   357	367	385	java/lang/Exception
      //   374	382	385	java/lang/Exception
      //   508	541	385	java/lang/Exception
      //   548	560	385	java/lang/Exception
      //   473	478	480	java/io/IOException
      //   564	568	771	java/io/IOException
      //   568	573	793	java/io/IOException
      //   464	468	815	java/io/IOException
      //   16	75	837	finally
      //   849	854	866	java/io/IOException
      //   859	864	888	java/io/IOException
      //   573	610	959	java/lang/Exception
      //   614	644	959	java/lang/Exception
      //   648	685	959	java/lang/Exception
      //   690	719	959	java/lang/Exception
      //   719	764	959	java/lang/Exception
      //   910	937	959	java/lang/Exception
      //   940	954	959	java/lang/Exception
      //   75	137	1006	finally
      //   137	169	1006	finally
      //   176	185	1013	finally
      //   192	208	1013	finally
      //   219	242	1013	finally
      //   249	261	1013	finally
      //   326	332	1013	finally
      //   339	345	1013	finally
      //   357	367	1013	finally
      //   374	382	1013	finally
      //   393	411	1013	finally
      //   418	441	1013	finally
      //   448	460	1013	finally
      //   508	541	1013	finally
      //   548	560	1013	finally
      //   16	75	1021	java/lang/Exception
      //   75	137	1033	java/lang/Exception
      //   137	169	1033	java/lang/Exception
      //   176	185	1042	java/lang/Exception
    }
    
    public final boolean JT()
    {
      try
      {
        am.a.dVz.bg(this.eRO, 0);
        x.b.a(x.b.eRH, this.eRP.UP(), this.eRP.UQ(), this.ebo);
        this.ebo = null;
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[] { bk.j(localException) });
        }
      }
    }
  }
  
  private static final class b$b
    implements av.a
  {
    private v eRP;
    public Bitmap ebo = null;
    
    public b$b(v paramv)
    {
      if (!x.c(paramv)) {
        throw new IllegalArgumentException("from sdcard, picture strategy here must be validity");
      }
      this.eRP = paramv;
    }
    
    public final boolean JS()
    {
      boolean bool = false;
      this.ebo = x.b.pg(this.eRP.UO());
      if (this.ebo != null) {
        this.ebo = x.b.eRH.a(this.eRP, this.ebo);
      }
      String str1 = this.eRP.UP();
      String str2 = this.eRP.UO();
      if (this.ebo != null) {
        bool = true;
      }
      y.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      return true;
    }
    
    public final boolean JT()
    {
      if (this.ebo == null)
      {
        y.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[] { this.eRP.UP() });
        if ((x.b.a(x.b.eRH) == null) || (x.b.a(x.b.eRH).crx())) {
          x.b.a(x.b.eRH, new av(1, "readerapp-pic-logic-download", 3));
        }
        x.b.a(x.b.eRH).c(new x.b.a(this.eRP));
        return false;
      }
      x.b.a(x.b.eRH, this.eRP.UP(), this.eRP.UQ(), this.ebo);
      this.ebo = null;
      return false;
    }
  }
  
  static final class b$c
  {
    boolean eRQ;
    int eRR;
    int eRS;
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail[").append(this.eRQ).append("],");
      localStringBuilder.append("tryTimes[").append(this.eRR).append("],");
      localStringBuilder.append("lastTS[").append(this.eRS).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.x
 * JD-Core Version:    0.7.0.1
 */