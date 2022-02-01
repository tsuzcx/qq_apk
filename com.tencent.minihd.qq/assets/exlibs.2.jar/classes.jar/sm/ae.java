package sm;

import android.content.Context;
import android.net.Proxy;
import android.os.Environment;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;

public class ae
  extends ad
{
  private Context c;
  private HttpGet d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private int i = 0;
  private boolean j = false;
  private boolean k = false;
  private long l = 0L;
  
  public ae(Context paramContext)
  {
    this.c = paramContext;
    this.j = "mounted".equals(Environment.getExternalStorageState());
    if (this.j) {
      this.e = "/sdcard/qqsecure";
    }
    for (this.f = "/sdcard/qqsecure";; this.f = paramContext.getFilesDir().getAbsolutePath())
    {
      this.d = new HttpGet();
      if (af.c(paramContext) == af.a.b)
      {
        a(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        a(true);
      }
      return;
      this.e = paramContext.getCacheDir().getAbsolutePath();
    }
  }
  
  /* Error */
  private int a(org.apache.http.HttpEntity paramHttpEntity, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 23
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 25
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 21
    //   18: aconst_null
    //   19: astore 16
    //   21: aconst_null
    //   22: astore 17
    //   24: aconst_null
    //   25: astore 18
    //   27: aconst_null
    //   28: astore 19
    //   30: aconst_null
    //   31: astore 26
    //   33: aconst_null
    //   34: astore 20
    //   36: aconst_null
    //   37: astore 15
    //   39: sipush 8192
    //   42: newarray byte
    //   44: astore 27
    //   46: aload 26
    //   48: astore 13
    //   50: aload 12
    //   52: astore 14
    //   54: aload_1
    //   55: invokeinterface 123 1 0
    //   60: lstore 8
    //   62: aload 26
    //   64: astore 13
    //   66: aload 12
    //   68: astore 14
    //   70: aload_0
    //   71: getfield 43	sm/ae:l	J
    //   74: lload 8
    //   76: ladd
    //   77: lstore 8
    //   79: aload 26
    //   81: astore 13
    //   83: aload 12
    //   85: astore 14
    //   87: aload_0
    //   88: getfield 43	sm/ae:l	J
    //   91: ldc2_w 124
    //   94: lmul
    //   95: lload 8
    //   97: ldiv
    //   98: l2i
    //   99: istore 4
    //   101: aload 26
    //   103: astore 13
    //   105: aload 12
    //   107: astore 14
    //   109: aload_2
    //   110: ldc 127
    //   112: lload 8
    //   114: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   117: aload 26
    //   119: astore 13
    //   121: aload 12
    //   123: astore 14
    //   125: aload_2
    //   126: ldc 135
    //   128: aload_0
    //   129: getfield 43	sm/ae:l	J
    //   132: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   135: aload 26
    //   137: astore 13
    //   139: aload 12
    //   141: astore 14
    //   143: aload_2
    //   144: ldc 137
    //   146: iload 4
    //   148: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   151: aload 26
    //   153: astore 13
    //   155: aload 12
    //   157: astore 14
    //   159: new 99	java/io/File
    //   162: dup
    //   163: new 142	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   170: aload_0
    //   171: getfield 29	sm/ae:e	Ljava/lang/String;
    //   174: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   180: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 33	sm/ae:g	Ljava/lang/String;
    //   187: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: astore 28
    //   198: aload 26
    //   200: astore 13
    //   202: aload 12
    //   204: astore 14
    //   206: aload 28
    //   208: invokevirtual 160	java/io/File:exists	()Z
    //   211: ifne +34 -> 245
    //   214: aload 26
    //   216: astore 13
    //   218: aload 12
    //   220: astore 14
    //   222: aload 28
    //   224: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   227: invokevirtual 166	java/io/File:mkdirs	()Z
    //   230: pop
    //   231: aload 26
    //   233: astore 13
    //   235: aload 12
    //   237: astore 14
    //   239: aload 28
    //   241: invokevirtual 169	java/io/File:createNewFile	()Z
    //   244: pop
    //   245: aload 26
    //   247: astore 13
    //   249: aload 12
    //   251: astore 14
    //   253: new 171	java/io/FileOutputStream
    //   256: dup
    //   257: aload 28
    //   259: iconst_1
    //   260: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   263: astore 12
    //   265: iload_3
    //   266: ifeq +73 -> 339
    //   269: new 176	java/util/zip/InflaterInputStream
    //   272: dup
    //   273: aload_1
    //   274: invokeinterface 180 1 0
    //   279: invokespecial 183	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   282: astore 13
    //   284: iconst_0
    //   285: istore 5
    //   287: aload 13
    //   289: aload 27
    //   291: invokevirtual 189	java/io/InputStream:read	([B)I
    //   294: istore 7
    //   296: iload 7
    //   298: iconst_m1
    //   299: if_icmpeq +148 -> 447
    //   302: aload_0
    //   303: getfield 41	sm/ae:k	Z
    //   306: istore_3
    //   307: iload_3
    //   308: ifeq +58 -> 366
    //   311: aload 13
    //   313: ifnull +8 -> 321
    //   316: aload 13
    //   318: invokevirtual 192	java/io/InputStream:close	()V
    //   321: aload 12
    //   323: ifnull +8 -> 331
    //   326: aload 12
    //   328: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   331: sipush -5003
    //   334: istore 4
    //   336: iload 4
    //   338: ireturn
    //   339: aload_1
    //   340: invokeinterface 180 1 0
    //   345: astore 13
    //   347: goto -63 -> 284
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   355: goto -34 -> 321
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   363: goto -32 -> 331
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 43	sm/ae:l	J
    //   371: iload 7
    //   373: i2l
    //   374: ladd
    //   375: putfield 43	sm/ae:l	J
    //   378: aload_2
    //   379: ldc 135
    //   381: aload_0
    //   382: getfield 43	sm/ae:l	J
    //   385: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   388: aload_0
    //   389: getfield 43	sm/ae:l	J
    //   392: ldc2_w 124
    //   395: lmul
    //   396: lload 8
    //   398: ldiv
    //   399: l2i
    //   400: istore 6
    //   402: iload 6
    //   404: iload 4
    //   406: if_icmpeq +698 -> 1104
    //   409: aload_2
    //   410: ldc 137
    //   412: iload 6
    //   414: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   417: aload_0
    //   418: iconst_2
    //   419: aload_2
    //   420: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   423: iload 6
    //   425: istore 4
    //   427: aload 12
    //   429: aload 27
    //   431: iconst_0
    //   432: iload 7
    //   434: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   437: iload 5
    //   439: iload 7
    //   441: iadd
    //   442: istore 5
    //   444: goto -157 -> 287
    //   447: aload 12
    //   449: invokevirtual 206	java/io/FileOutputStream:flush	()V
    //   452: iload 5
    //   454: i2l
    //   455: lstore 8
    //   457: aload_1
    //   458: invokeinterface 123 1 0
    //   463: lstore 10
    //   465: lload 8
    //   467: lload 10
    //   469: lcmp
    //   470: ifne +50 -> 520
    //   473: iconst_0
    //   474: istore 4
    //   476: iload 4
    //   478: istore 5
    //   480: aload 13
    //   482: ifnull +55 -> 537
    //   485: aload 13
    //   487: invokevirtual 192	java/io/InputStream:close	()V
    //   490: iload 4
    //   492: istore 5
    //   494: iload 5
    //   496: istore 4
    //   498: aload 12
    //   500: ifnull -164 -> 336
    //   503: aload 12
    //   505: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   508: iload 5
    //   510: ireturn
    //   511: astore_1
    //   512: aload_1
    //   513: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   516: sipush -7000
    //   519: ireturn
    //   520: bipush 249
    //   522: istore 4
    //   524: goto -48 -> 476
    //   527: astore_1
    //   528: sipush -7000
    //   531: istore 5
    //   533: aload_1
    //   534: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   537: goto -43 -> 494
    //   540: astore_2
    //   541: aload 21
    //   543: astore_1
    //   544: aload 15
    //   546: astore 12
    //   548: aload 12
    //   550: astore 13
    //   552: aload_1
    //   553: astore 14
    //   555: aload_2
    //   556: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   559: aload 12
    //   561: ifnull +535 -> 1096
    //   564: aload 12
    //   566: invokevirtual 192	java/io/InputStream:close	()V
    //   569: sipush -7001
    //   572: istore 5
    //   574: iload 5
    //   576: istore 4
    //   578: aload_1
    //   579: ifnull -243 -> 336
    //   582: aload_1
    //   583: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   586: iload 5
    //   588: ireturn
    //   589: astore_1
    //   590: aload_1
    //   591: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   594: sipush -7000
    //   597: ireturn
    //   598: astore_2
    //   599: sipush -7000
    //   602: istore 5
    //   604: aload_2
    //   605: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   608: goto -34 -> 574
    //   611: astore_2
    //   612: aload 22
    //   614: astore_1
    //   615: aload 16
    //   617: astore 12
    //   619: aload 12
    //   621: astore 13
    //   623: aload_1
    //   624: astore 14
    //   626: aload_2
    //   627: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   630: aload 12
    //   632: ifnull +456 -> 1088
    //   635: aload 12
    //   637: invokevirtual 192	java/io/InputStream:close	()V
    //   640: sipush -5054
    //   643: istore 5
    //   645: iload 5
    //   647: istore 4
    //   649: aload_1
    //   650: ifnull -314 -> 336
    //   653: aload_1
    //   654: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   657: iload 5
    //   659: ireturn
    //   660: astore_1
    //   661: aload_1
    //   662: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   665: sipush -7000
    //   668: ireturn
    //   669: astore_2
    //   670: sipush -7000
    //   673: istore 5
    //   675: aload_2
    //   676: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   679: goto -34 -> 645
    //   682: astore_2
    //   683: aload 23
    //   685: astore_1
    //   686: aload 17
    //   688: astore 12
    //   690: aload 12
    //   692: astore 13
    //   694: aload_1
    //   695: astore 14
    //   697: aload_2
    //   698: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   701: aload 12
    //   703: ifnull +377 -> 1080
    //   706: aload 12
    //   708: invokevirtual 192	java/io/InputStream:close	()V
    //   711: sipush -5055
    //   714: istore 5
    //   716: iload 5
    //   718: istore 4
    //   720: aload_1
    //   721: ifnull -385 -> 336
    //   724: aload_1
    //   725: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   728: iload 5
    //   730: ireturn
    //   731: astore_1
    //   732: aload_1
    //   733: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   736: sipush -7000
    //   739: ireturn
    //   740: astore_2
    //   741: sipush -7000
    //   744: istore 5
    //   746: aload_2
    //   747: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   750: goto -34 -> 716
    //   753: astore_2
    //   754: aload 24
    //   756: astore_1
    //   757: aload 18
    //   759: astore 12
    //   761: aload 12
    //   763: astore 13
    //   765: aload_1
    //   766: astore 14
    //   768: aload_2
    //   769: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   772: aload 12
    //   774: ifnull +298 -> 1072
    //   777: aload 12
    //   779: invokevirtual 192	java/io/InputStream:close	()V
    //   782: sipush -5056
    //   785: istore 5
    //   787: iload 5
    //   789: istore 4
    //   791: aload_1
    //   792: ifnull -456 -> 336
    //   795: aload_1
    //   796: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   799: iload 5
    //   801: ireturn
    //   802: astore_1
    //   803: aload_1
    //   804: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   807: sipush -7000
    //   810: ireturn
    //   811: astore_2
    //   812: sipush -7000
    //   815: istore 5
    //   817: aload_2
    //   818: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   821: goto -34 -> 787
    //   824: astore_2
    //   825: aload 25
    //   827: astore_1
    //   828: aload 19
    //   830: astore 12
    //   832: aload 12
    //   834: astore 13
    //   836: aload_1
    //   837: astore 14
    //   839: aload_2
    //   840: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   843: aload 12
    //   845: ifnull +219 -> 1064
    //   848: aload 12
    //   850: invokevirtual 192	java/io/InputStream:close	()V
    //   853: sipush -5000
    //   856: istore 5
    //   858: iload 5
    //   860: istore 4
    //   862: aload_1
    //   863: ifnull -527 -> 336
    //   866: aload_1
    //   867: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   870: iload 5
    //   872: ireturn
    //   873: astore_1
    //   874: aload_1
    //   875: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   878: sipush -7000
    //   881: ireturn
    //   882: astore_2
    //   883: sipush -7000
    //   886: istore 5
    //   888: aload_2
    //   889: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   892: goto -34 -> 858
    //   895: astore_1
    //   896: aload 13
    //   898: ifnull +8 -> 906
    //   901: aload 13
    //   903: invokevirtual 192	java/io/InputStream:close	()V
    //   906: aload 14
    //   908: ifnull +8 -> 916
    //   911: aload 14
    //   913: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   916: aload_1
    //   917: athrow
    //   918: astore_2
    //   919: aload_2
    //   920: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   923: goto -17 -> 906
    //   926: astore_2
    //   927: aload_2
    //   928: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   931: goto -15 -> 916
    //   934: astore_1
    //   935: aload 20
    //   937: astore 13
    //   939: aload 12
    //   941: astore 14
    //   943: goto -47 -> 896
    //   946: astore_1
    //   947: aload 12
    //   949: astore 14
    //   951: goto -55 -> 896
    //   954: astore_2
    //   955: aload 12
    //   957: astore_1
    //   958: aload 19
    //   960: astore 12
    //   962: goto -130 -> 832
    //   965: astore_2
    //   966: aload 12
    //   968: astore_1
    //   969: aload 13
    //   971: astore 12
    //   973: goto -141 -> 832
    //   976: astore_2
    //   977: aload 12
    //   979: astore_1
    //   980: aload 18
    //   982: astore 12
    //   984: goto -223 -> 761
    //   987: astore_2
    //   988: aload 12
    //   990: astore_1
    //   991: aload 13
    //   993: astore 12
    //   995: goto -234 -> 761
    //   998: astore_2
    //   999: aload 12
    //   1001: astore_1
    //   1002: aload 17
    //   1004: astore 12
    //   1006: goto -316 -> 690
    //   1009: astore_2
    //   1010: aload 12
    //   1012: astore_1
    //   1013: aload 13
    //   1015: astore 12
    //   1017: goto -327 -> 690
    //   1020: astore_2
    //   1021: aload 12
    //   1023: astore_1
    //   1024: aload 16
    //   1026: astore 12
    //   1028: goto -409 -> 619
    //   1031: astore_2
    //   1032: aload 12
    //   1034: astore_1
    //   1035: aload 13
    //   1037: astore 12
    //   1039: goto -420 -> 619
    //   1042: astore_2
    //   1043: aload 12
    //   1045: astore_1
    //   1046: aload 15
    //   1048: astore 12
    //   1050: goto -502 -> 548
    //   1053: astore_2
    //   1054: aload 12
    //   1056: astore_1
    //   1057: aload 13
    //   1059: astore 12
    //   1061: goto -513 -> 548
    //   1064: sipush -5000
    //   1067: istore 5
    //   1069: goto -211 -> 858
    //   1072: sipush -5056
    //   1075: istore 5
    //   1077: goto -290 -> 787
    //   1080: sipush -5055
    //   1083: istore 5
    //   1085: goto -369 -> 716
    //   1088: sipush -5054
    //   1091: istore 5
    //   1093: goto -448 -> 645
    //   1096: sipush -7001
    //   1099: istore 5
    //   1101: goto -527 -> 574
    //   1104: goto -677 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1107	0	this	ae
    //   0	1107	1	paramHttpEntity	org.apache.http.HttpEntity
    //   0	1107	2	paramBundle	android.os.Bundle
    //   0	1107	3	paramBoolean	boolean
    //   99	762	4	m	int
    //   285	815	5	n	int
    //   400	24	6	i1	int
    //   294	148	7	i2	int
    //   60	406	8	l1	long
    //   463	5	10	l2	long
    //   13	1047	12	localObject1	Object
    //   48	1010	13	localObject2	Object
    //   52	898	14	localObject3	Object
    //   37	1010	15	localObject4	Object
    //   19	1006	16	localObject5	Object
    //   22	981	17	localObject6	Object
    //   25	956	18	localObject7	Object
    //   28	931	19	localObject8	Object
    //   34	902	20	localObject9	Object
    //   16	526	21	localObject10	Object
    //   1	612	22	localObject11	Object
    //   4	680	23	localObject12	Object
    //   7	748	24	localObject13	Object
    //   10	816	25	localObject14	Object
    //   31	215	26	localObject15	Object
    //   44	386	27	arrayOfByte	byte[]
    //   196	62	28	localFile	File
    // Exception table:
    //   from	to	target	type
    //   316	321	350	java/io/IOException
    //   326	331	358	java/io/IOException
    //   503	508	511	java/io/IOException
    //   485	490	527	java/io/IOException
    //   54	62	540	java/io/FileNotFoundException
    //   70	79	540	java/io/FileNotFoundException
    //   87	101	540	java/io/FileNotFoundException
    //   109	117	540	java/io/FileNotFoundException
    //   125	135	540	java/io/FileNotFoundException
    //   143	151	540	java/io/FileNotFoundException
    //   159	198	540	java/io/FileNotFoundException
    //   206	214	540	java/io/FileNotFoundException
    //   222	231	540	java/io/FileNotFoundException
    //   239	245	540	java/io/FileNotFoundException
    //   253	265	540	java/io/FileNotFoundException
    //   582	586	589	java/io/IOException
    //   564	569	598	java/io/IOException
    //   54	62	611	java/net/SocketException
    //   70	79	611	java/net/SocketException
    //   87	101	611	java/net/SocketException
    //   109	117	611	java/net/SocketException
    //   125	135	611	java/net/SocketException
    //   143	151	611	java/net/SocketException
    //   159	198	611	java/net/SocketException
    //   206	214	611	java/net/SocketException
    //   222	231	611	java/net/SocketException
    //   239	245	611	java/net/SocketException
    //   253	265	611	java/net/SocketException
    //   653	657	660	java/io/IOException
    //   635	640	669	java/io/IOException
    //   54	62	682	java/net/SocketTimeoutException
    //   70	79	682	java/net/SocketTimeoutException
    //   87	101	682	java/net/SocketTimeoutException
    //   109	117	682	java/net/SocketTimeoutException
    //   125	135	682	java/net/SocketTimeoutException
    //   143	151	682	java/net/SocketTimeoutException
    //   159	198	682	java/net/SocketTimeoutException
    //   206	214	682	java/net/SocketTimeoutException
    //   222	231	682	java/net/SocketTimeoutException
    //   239	245	682	java/net/SocketTimeoutException
    //   253	265	682	java/net/SocketTimeoutException
    //   724	728	731	java/io/IOException
    //   706	711	740	java/io/IOException
    //   54	62	753	java/io/IOException
    //   70	79	753	java/io/IOException
    //   87	101	753	java/io/IOException
    //   109	117	753	java/io/IOException
    //   125	135	753	java/io/IOException
    //   143	151	753	java/io/IOException
    //   159	198	753	java/io/IOException
    //   206	214	753	java/io/IOException
    //   222	231	753	java/io/IOException
    //   239	245	753	java/io/IOException
    //   253	265	753	java/io/IOException
    //   795	799	802	java/io/IOException
    //   777	782	811	java/io/IOException
    //   54	62	824	java/lang/Exception
    //   70	79	824	java/lang/Exception
    //   87	101	824	java/lang/Exception
    //   109	117	824	java/lang/Exception
    //   125	135	824	java/lang/Exception
    //   143	151	824	java/lang/Exception
    //   159	198	824	java/lang/Exception
    //   206	214	824	java/lang/Exception
    //   222	231	824	java/lang/Exception
    //   239	245	824	java/lang/Exception
    //   253	265	824	java/lang/Exception
    //   866	870	873	java/io/IOException
    //   848	853	882	java/io/IOException
    //   54	62	895	finally
    //   70	79	895	finally
    //   87	101	895	finally
    //   109	117	895	finally
    //   125	135	895	finally
    //   143	151	895	finally
    //   159	198	895	finally
    //   206	214	895	finally
    //   222	231	895	finally
    //   239	245	895	finally
    //   253	265	895	finally
    //   555	559	895	finally
    //   626	630	895	finally
    //   697	701	895	finally
    //   768	772	895	finally
    //   839	843	895	finally
    //   901	906	918	java/io/IOException
    //   911	916	926	java/io/IOException
    //   269	284	934	finally
    //   339	347	934	finally
    //   287	296	946	finally
    //   302	307	946	finally
    //   366	402	946	finally
    //   409	423	946	finally
    //   427	437	946	finally
    //   447	452	946	finally
    //   457	465	946	finally
    //   269	284	954	java/lang/Exception
    //   339	347	954	java/lang/Exception
    //   287	296	965	java/lang/Exception
    //   302	307	965	java/lang/Exception
    //   366	402	965	java/lang/Exception
    //   409	423	965	java/lang/Exception
    //   427	437	965	java/lang/Exception
    //   447	452	965	java/lang/Exception
    //   457	465	965	java/lang/Exception
    //   269	284	976	java/io/IOException
    //   339	347	976	java/io/IOException
    //   287	296	987	java/io/IOException
    //   302	307	987	java/io/IOException
    //   366	402	987	java/io/IOException
    //   409	423	987	java/io/IOException
    //   427	437	987	java/io/IOException
    //   447	452	987	java/io/IOException
    //   457	465	987	java/io/IOException
    //   269	284	998	java/net/SocketTimeoutException
    //   339	347	998	java/net/SocketTimeoutException
    //   287	296	1009	java/net/SocketTimeoutException
    //   302	307	1009	java/net/SocketTimeoutException
    //   366	402	1009	java/net/SocketTimeoutException
    //   409	423	1009	java/net/SocketTimeoutException
    //   427	437	1009	java/net/SocketTimeoutException
    //   447	452	1009	java/net/SocketTimeoutException
    //   457	465	1009	java/net/SocketTimeoutException
    //   269	284	1020	java/net/SocketException
    //   339	347	1020	java/net/SocketException
    //   287	296	1031	java/net/SocketException
    //   302	307	1031	java/net/SocketException
    //   366	402	1031	java/net/SocketException
    //   409	423	1031	java/net/SocketException
    //   427	437	1031	java/net/SocketException
    //   447	452	1031	java/net/SocketException
    //   457	465	1031	java/net/SocketException
    //   269	284	1042	java/io/FileNotFoundException
    //   339	347	1042	java/io/FileNotFoundException
    //   287	296	1053	java/io/FileNotFoundException
    //   302	307	1053	java/io/FileNotFoundException
    //   366	402	1053	java/io/FileNotFoundException
    //   409	423	1053	java/io/FileNotFoundException
    //   427	437	1053	java/io/FileNotFoundException
    //   447	452	1053	java/io/FileNotFoundException
    //   457	465	1053	java/io/FileNotFoundException
  }
  
  /* Error */
  private int b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 13
    //   5: aconst_null
    //   6: astore 14
    //   8: aconst_null
    //   9: astore 11
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 12
    //   17: sipush -7000
    //   20: istore_3
    //   21: new 99	java/io/File
    //   24: dup
    //   25: new 142	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: getfield 29	sm/ae:e	Ljava/lang/String;
    //   36: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 33	sm/ae:g	Ljava/lang/String;
    //   49: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 160	java/io/File:exists	()Z
    //   65: ifeq +340 -> 405
    //   68: aload_0
    //   69: getfield 39	sm/ae:j	Z
    //   72: ifne +161 -> 233
    //   75: aload_0
    //   76: getfield 37	sm/ae:i	I
    //   79: iconst_1
    //   80: if_icmpne +153 -> 233
    //   83: aload_0
    //   84: getfield 45	sm/ae:c	Landroid/content/Context;
    //   87: aload_0
    //   88: getfield 35	sm/ae:h	Ljava/lang/String;
    //   91: iconst_1
    //   92: invokevirtual 215	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   95: astore 6
    //   97: aload 7
    //   99: astore 10
    //   101: aload 8
    //   103: astore 11
    //   105: aload 6
    //   107: astore 9
    //   109: new 217	java/io/FileInputStream
    //   112: dup
    //   113: aload 7
    //   115: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: astore 8
    //   120: sipush 1024
    //   123: newarray byte
    //   125: astore 11
    //   127: aload 8
    //   129: aload 11
    //   131: invokevirtual 221	java/io/FileInputStream:read	([B)I
    //   134: istore 5
    //   136: iload_2
    //   137: istore 4
    //   139: aload 8
    //   141: astore 10
    //   143: aload 6
    //   145: astore 9
    //   147: iload 5
    //   149: iconst_m1
    //   150: if_icmpeq +266 -> 416
    //   153: aload 6
    //   155: aload 11
    //   157: iconst_0
    //   158: iload 5
    //   160: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   163: goto -36 -> 127
    //   166: astore 9
    //   168: aload 8
    //   170: astore 11
    //   172: aload 9
    //   174: astore 8
    //   176: aload 8
    //   178: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   181: aload 11
    //   183: ifnull +672 -> 855
    //   186: aload 11
    //   188: invokevirtual 222	java/io/FileInputStream:close	()V
    //   191: sipush -7001
    //   194: istore_2
    //   195: aload 6
    //   197: ifnull +653 -> 850
    //   200: aload 6
    //   202: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   205: iload_2
    //   206: istore_3
    //   207: iload_3
    //   208: istore_2
    //   209: iload_1
    //   210: ifeq +21 -> 231
    //   213: iload_3
    //   214: istore_2
    //   215: aload 7
    //   217: invokevirtual 160	java/io/File:exists	()Z
    //   220: ifeq +11 -> 231
    //   223: aload 7
    //   225: invokevirtual 225	java/io/File:delete	()Z
    //   228: pop
    //   229: iload_3
    //   230: istore_2
    //   231: iload_2
    //   232: ireturn
    //   233: new 99	java/io/File
    //   236: dup
    //   237: new 142	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 31	sm/ae:f	Ljava/lang/String;
    //   248: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   254: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 35	sm/ae:h	Ljava/lang/String;
    //   261: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: astore 6
    //   272: aload 6
    //   274: invokevirtual 160	java/io/File:exists	()Z
    //   277: ifeq +23 -> 300
    //   280: aload 6
    //   282: invokevirtual 225	java/io/File:delete	()Z
    //   285: pop
    //   286: new 171	java/io/FileOutputStream
    //   289: dup
    //   290: aload 6
    //   292: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   295: astore 6
    //   297: goto -200 -> 97
    //   300: aload 6
    //   302: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   305: invokevirtual 166	java/io/File:mkdirs	()Z
    //   308: pop
    //   309: aload 6
    //   311: invokevirtual 169	java/io/File:createNewFile	()Z
    //   314: pop
    //   315: new 171	java/io/FileOutputStream
    //   318: dup
    //   319: aload 6
    //   321: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   324: astore 6
    //   326: goto -229 -> 97
    //   329: astore 8
    //   331: aconst_null
    //   332: astore 6
    //   334: aload 13
    //   336: astore 12
    //   338: aload 7
    //   340: astore 10
    //   342: aload 12
    //   344: astore 11
    //   346: aload 6
    //   348: astore 9
    //   350: aload 8
    //   352: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   355: aload 12
    //   357: ifnull +486 -> 843
    //   360: aload 12
    //   362: invokevirtual 222	java/io/FileInputStream:close	()V
    //   365: sipush -7056
    //   368: istore_2
    //   369: aload 6
    //   371: ifnull +467 -> 838
    //   374: aload 6
    //   376: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   379: iload_2
    //   380: istore_3
    //   381: iload_3
    //   382: istore_2
    //   383: iload_1
    //   384: ifeq -153 -> 231
    //   387: iload_3
    //   388: istore_2
    //   389: aload 7
    //   391: invokevirtual 160	java/io/File:exists	()Z
    //   394: ifeq -163 -> 231
    //   397: aload 7
    //   399: invokevirtual 225	java/io/File:delete	()Z
    //   402: pop
    //   403: iload_3
    //   404: ireturn
    //   405: aconst_null
    //   406: astore 10
    //   408: aconst_null
    //   409: astore 9
    //   411: sipush -7001
    //   414: istore 4
    //   416: iload 4
    //   418: istore_2
    //   419: aload 10
    //   421: ifnull +11 -> 432
    //   424: aload 10
    //   426: invokevirtual 222	java/io/FileInputStream:close	()V
    //   429: iload 4
    //   431: istore_2
    //   432: aload 9
    //   434: ifnull +428 -> 862
    //   437: aload 9
    //   439: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   442: iload_2
    //   443: istore_3
    //   444: iload_3
    //   445: istore_2
    //   446: iload_1
    //   447: ifeq -216 -> 231
    //   450: iload_3
    //   451: istore_2
    //   452: aload 7
    //   454: invokevirtual 160	java/io/File:exists	()Z
    //   457: ifeq -226 -> 231
    //   460: aload 7
    //   462: invokevirtual 225	java/io/File:delete	()Z
    //   465: pop
    //   466: iload_3
    //   467: ireturn
    //   468: astore 6
    //   470: aload 6
    //   472: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   475: sipush -7000
    //   478: istore_2
    //   479: goto -47 -> 432
    //   482: astore 6
    //   484: aload 6
    //   486: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   489: goto -45 -> 444
    //   492: astore 8
    //   494: aload 8
    //   496: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   499: sipush -7000
    //   502: istore_2
    //   503: goto -308 -> 195
    //   506: astore 6
    //   508: aload 6
    //   510: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   513: goto -306 -> 207
    //   516: astore 8
    //   518: aload 8
    //   520: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   523: sipush -7000
    //   526: istore_2
    //   527: goto -158 -> 369
    //   530: astore 6
    //   532: aload 6
    //   534: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   537: goto -156 -> 381
    //   540: astore 8
    //   542: aconst_null
    //   543: astore 7
    //   545: aconst_null
    //   546: astore 6
    //   548: aload 14
    //   550: astore 12
    //   552: aload 7
    //   554: astore 10
    //   556: aload 12
    //   558: astore 11
    //   560: aload 6
    //   562: astore 9
    //   564: aload 8
    //   566: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   569: aload 12
    //   571: ifnull +8 -> 579
    //   574: aload 12
    //   576: invokevirtual 222	java/io/FileInputStream:close	()V
    //   579: aload 6
    //   581: ifnull +8 -> 589
    //   584: aload 6
    //   586: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   589: iload_3
    //   590: istore_2
    //   591: iload_1
    //   592: ifeq -361 -> 231
    //   595: iload_3
    //   596: istore_2
    //   597: aload 7
    //   599: invokevirtual 160	java/io/File:exists	()Z
    //   602: ifeq -371 -> 231
    //   605: aload 7
    //   607: invokevirtual 225	java/io/File:delete	()Z
    //   610: pop
    //   611: sipush -7000
    //   614: ireturn
    //   615: astore 8
    //   617: aload 8
    //   619: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   622: goto -43 -> 579
    //   625: astore 6
    //   627: aload 6
    //   629: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   632: goto -43 -> 589
    //   635: astore 8
    //   637: aconst_null
    //   638: astore 7
    //   640: aconst_null
    //   641: astore 6
    //   643: aload 11
    //   645: ifnull +8 -> 653
    //   648: aload 11
    //   650: invokevirtual 222	java/io/FileInputStream:close	()V
    //   653: aload 6
    //   655: ifnull +8 -> 663
    //   658: aload 6
    //   660: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   663: iload_1
    //   664: ifeq +17 -> 681
    //   667: aload 7
    //   669: invokevirtual 160	java/io/File:exists	()Z
    //   672: ifeq +9 -> 681
    //   675: aload 7
    //   677: invokevirtual 225	java/io/File:delete	()Z
    //   680: pop
    //   681: aload 8
    //   683: athrow
    //   684: astore 9
    //   686: aload 9
    //   688: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   691: goto -38 -> 653
    //   694: astore 6
    //   696: aload 6
    //   698: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   701: goto -38 -> 663
    //   704: astore 8
    //   706: aconst_null
    //   707: astore 6
    //   709: goto -66 -> 643
    //   712: astore 8
    //   714: aload 10
    //   716: astore 7
    //   718: aload 9
    //   720: astore 6
    //   722: goto -79 -> 643
    //   725: astore 9
    //   727: aload 8
    //   729: astore 11
    //   731: aload 9
    //   733: astore 8
    //   735: goto -92 -> 643
    //   738: astore 8
    //   740: goto -97 -> 643
    //   743: astore 8
    //   745: aconst_null
    //   746: astore 6
    //   748: aload 14
    //   750: astore 12
    //   752: goto -200 -> 552
    //   755: astore 8
    //   757: aload 14
    //   759: astore 12
    //   761: goto -209 -> 552
    //   764: astore 9
    //   766: aload 8
    //   768: astore 12
    //   770: aload 9
    //   772: astore 8
    //   774: goto -222 -> 552
    //   777: astore 8
    //   779: aconst_null
    //   780: astore 7
    //   782: aconst_null
    //   783: astore 6
    //   785: aload 13
    //   787: astore 12
    //   789: goto -451 -> 338
    //   792: astore 8
    //   794: aload 13
    //   796: astore 12
    //   798: goto -460 -> 338
    //   801: astore 9
    //   803: aload 8
    //   805: astore 12
    //   807: aload 9
    //   809: astore 8
    //   811: goto -473 -> 338
    //   814: astore 8
    //   816: aconst_null
    //   817: astore 7
    //   819: aconst_null
    //   820: astore 6
    //   822: aload 12
    //   824: astore 11
    //   826: goto -650 -> 176
    //   829: astore 8
    //   831: aload 12
    //   833: astore 11
    //   835: goto -659 -> 176
    //   838: iload_2
    //   839: istore_3
    //   840: goto -459 -> 381
    //   843: sipush -7056
    //   846: istore_2
    //   847: goto -478 -> 369
    //   850: iload_2
    //   851: istore_3
    //   852: goto -645 -> 207
    //   855: sipush -7001
    //   858: istore_2
    //   859: goto -664 -> 195
    //   862: iload_2
    //   863: istore_3
    //   864: goto -420 -> 444
    //   867: astore 8
    //   869: aconst_null
    //   870: astore 6
    //   872: aload 12
    //   874: astore 11
    //   876: goto -700 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	ae
    //   0	879	1	paramBoolean	boolean
    //   1	862	2	m	int
    //   20	844	3	n	int
    //   137	293	4	i1	int
    //   134	25	5	i2	int
    //   95	280	6	localObject1	Object
    //   468	3	6	localIOException1	java.io.IOException
    //   482	3	6	localIOException2	java.io.IOException
    //   506	3	6	localIOException3	java.io.IOException
    //   530	3	6	localIOException4	java.io.IOException
    //   546	39	6	localObject2	Object
    //   625	3	6	localIOException5	java.io.IOException
    //   641	18	6	localObject3	Object
    //   694	3	6	localIOException6	java.io.IOException
    //   707	164	6	localObject4	Object
    //   58	760	7	localObject5	Object
    //   12	165	8	localObject6	Object
    //   329	22	8	localIOException7	java.io.IOException
    //   492	3	8	localIOException8	java.io.IOException
    //   516	3	8	localIOException9	java.io.IOException
    //   540	25	8	localException1	java.lang.Exception
    //   615	3	8	localIOException10	java.io.IOException
    //   635	47	8	localObject7	Object
    //   704	1	8	localObject8	Object
    //   712	16	8	localObject9	Object
    //   733	1	8	localObject10	Object
    //   738	1	8	localObject11	Object
    //   743	1	8	localException2	java.lang.Exception
    //   755	12	8	localException3	java.lang.Exception
    //   772	1	8	localObject12	Object
    //   777	1	8	localIOException11	java.io.IOException
    //   792	12	8	localIOException12	java.io.IOException
    //   809	1	8	localObject13	Object
    //   814	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   829	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   867	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   107	39	9	localObject14	Object
    //   166	7	9	localFileNotFoundException4	java.io.FileNotFoundException
    //   348	215	9	localObject15	Object
    //   684	35	9	localIOException13	java.io.IOException
    //   725	7	9	localObject16	Object
    //   764	7	9	localException4	java.lang.Exception
    //   801	7	9	localIOException14	java.io.IOException
    //   99	616	10	localObject17	Object
    //   9	866	11	localObject18	Object
    //   15	858	12	localObject19	Object
    //   3	792	13	localObject20	Object
    //   6	752	14	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   120	127	166	java/io/FileNotFoundException
    //   127	136	166	java/io/FileNotFoundException
    //   153	163	166	java/io/FileNotFoundException
    //   60	97	329	java/io/IOException
    //   233	297	329	java/io/IOException
    //   300	326	329	java/io/IOException
    //   424	429	468	java/io/IOException
    //   437	442	482	java/io/IOException
    //   186	191	492	java/io/IOException
    //   200	205	506	java/io/IOException
    //   360	365	516	java/io/IOException
    //   374	379	530	java/io/IOException
    //   21	60	540	java/lang/Exception
    //   574	579	615	java/io/IOException
    //   584	589	625	java/io/IOException
    //   21	60	635	finally
    //   648	653	684	java/io/IOException
    //   658	663	694	java/io/IOException
    //   60	97	704	finally
    //   233	297	704	finally
    //   300	326	704	finally
    //   109	120	712	finally
    //   350	355	712	finally
    //   564	569	712	finally
    //   120	127	725	finally
    //   127	136	725	finally
    //   153	163	725	finally
    //   176	181	738	finally
    //   60	97	743	java/lang/Exception
    //   233	297	743	java/lang/Exception
    //   300	326	743	java/lang/Exception
    //   109	120	755	java/lang/Exception
    //   120	127	764	java/lang/Exception
    //   127	136	764	java/lang/Exception
    //   153	163	764	java/lang/Exception
    //   21	60	777	java/io/IOException
    //   109	120	792	java/io/IOException
    //   120	127	801	java/io/IOException
    //   127	136	801	java/io/IOException
    //   153	163	801	java/io/IOException
    //   21	60	814	java/io/FileNotFoundException
    //   109	120	829	java/io/FileNotFoundException
    //   60	97	867	java/io/FileNotFoundException
    //   233	297	867	java/io/FileNotFoundException
    //   300	326	867	java/io/FileNotFoundException
  }
  
  private int c(String paramString)
  {
    localObject = null;
    try
    {
      paramString = new URI(paramString);
      m = -1000;
    }
    catch (URISyntaxException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        int m = -1053;
        paramString = localObject;
      }
    }
    if (paramString != null)
    {
      this.d.setURI(paramString);
      m = 0;
    }
    return m;
  }
  
  /* Error */
  public int a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush -3000
    //   3: istore 4
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 10
    //   14: new 129	android/os/Bundle
    //   17: dup
    //   18: invokespecial 241	android/os/Bundle:<init>	()V
    //   21: astore 11
    //   23: aload 9
    //   25: astore 7
    //   27: iload 4
    //   29: istore_3
    //   30: aload_0
    //   31: invokevirtual 244	sm/ae:a	()Lorg/apache/http/client/HttpClient;
    //   34: astore 6
    //   36: aload 9
    //   38: astore 7
    //   40: aload 6
    //   42: astore 8
    //   44: iload 4
    //   46: istore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 246	sm/ae:c	(Ljava/lang/String;)I
    //   52: istore 4
    //   54: iload 4
    //   56: ifeq +58 -> 114
    //   59: iload 4
    //   61: istore_3
    //   62: aload 10
    //   64: astore_1
    //   65: aload 6
    //   67: ifnull +15 -> 82
    //   70: aload 6
    //   72: invokeinterface 252 1 0
    //   77: invokeinterface 257 1 0
    //   82: aload_1
    //   83: ifnull +3 -> 86
    //   86: iload_3
    //   87: ifeq +25 -> 112
    //   90: iload_3
    //   91: bipush 249
    //   93: if_icmpeq +19 -> 112
    //   96: aload 11
    //   98: ldc_w 259
    //   101: iload_3
    //   102: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   105: aload_0
    //   106: iconst_1
    //   107: aload 11
    //   109: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   112: iload_3
    //   113: ireturn
    //   114: aload 9
    //   116: astore 7
    //   118: aload 6
    //   120: astore 8
    //   122: iload 4
    //   124: istore_3
    //   125: aload_0
    //   126: getfield 41	sm/ae:k	Z
    //   129: ifeq +13 -> 142
    //   132: sipush -3003
    //   135: istore_3
    //   136: aload 10
    //   138: astore_1
    //   139: goto -74 -> 65
    //   142: aload 9
    //   144: astore 7
    //   146: aload 6
    //   148: astore 8
    //   150: iload 4
    //   152: istore_3
    //   153: aload_0
    //   154: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   157: invokevirtual 263	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   160: ifnonnull +13 -> 173
    //   163: sipush -3053
    //   166: istore_3
    //   167: aload 10
    //   169: astore_1
    //   170: goto -105 -> 65
    //   173: aload 9
    //   175: astore 7
    //   177: aload 6
    //   179: astore 8
    //   181: iload 4
    //   183: istore_3
    //   184: aload_1
    //   185: invokestatic 268	sm/az:c	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore_1
    //   189: aload 9
    //   191: astore 7
    //   193: aload 6
    //   195: astore 8
    //   197: iload 4
    //   199: istore_3
    //   200: aload_0
    //   201: new 142	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   208: aload_1
    //   209: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 270
    //   215: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: putfield 33	sm/ae:g	Ljava/lang/String;
    //   224: aload 9
    //   226: astore 7
    //   228: aload 6
    //   230: astore 8
    //   232: iload 4
    //   234: istore_3
    //   235: aload_0
    //   236: getfield 35	sm/ae:h	Ljava/lang/String;
    //   239: ifnonnull +19 -> 258
    //   242: aload 9
    //   244: astore 7
    //   246: aload 6
    //   248: astore 8
    //   250: iload 4
    //   252: istore_3
    //   253: aload_0
    //   254: aload_1
    //   255: putfield 35	sm/ae:h	Ljava/lang/String;
    //   258: aload 9
    //   260: astore 7
    //   262: aload 6
    //   264: astore 8
    //   266: iload 4
    //   268: istore_3
    //   269: new 99	java/io/File
    //   272: dup
    //   273: new 142	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   280: aload_0
    //   281: getfield 29	sm/ae:e	Ljava/lang/String;
    //   284: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   290: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 33	sm/ae:g	Ljava/lang/String;
    //   297: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: astore_1
    //   307: aload 9
    //   309: astore 7
    //   311: aload 6
    //   313: astore 8
    //   315: iload 4
    //   317: istore_3
    //   318: aload_1
    //   319: invokevirtual 160	java/io/File:exists	()Z
    //   322: ifeq +72 -> 394
    //   325: aload 9
    //   327: astore 7
    //   329: aload 6
    //   331: astore 8
    //   333: iload 4
    //   335: istore_3
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 273	java/io/File:length	()J
    //   341: putfield 43	sm/ae:l	J
    //   344: aload 9
    //   346: astore 7
    //   348: aload 6
    //   350: astore 8
    //   352: iload 4
    //   354: istore_3
    //   355: aload_0
    //   356: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   359: ldc_w 275
    //   362: new 142	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 277
    //   372: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: getfield 43	sm/ae:l	J
    //   379: invokevirtual 280	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   382: ldc_w 282
    //   385: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokevirtual 286	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 9
    //   396: astore 7
    //   398: aload 6
    //   400: astore 8
    //   402: iload 4
    //   404: istore_3
    //   405: aload 6
    //   407: aload_0
    //   408: getfield 27	sm/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   411: invokeinterface 290 2 0
    //   416: astore_1
    //   417: aload_1
    //   418: astore 7
    //   420: aload 6
    //   422: astore 8
    //   424: iload 4
    //   426: istore_3
    //   427: aload_1
    //   428: invokeinterface 296 1 0
    //   433: invokeinterface 301 1 0
    //   438: istore 5
    //   440: iload 5
    //   442: sipush 200
    //   445: if_icmpeq +21 -> 466
    //   448: iload 5
    //   450: sipush 206
    //   453: if_icmpeq +13 -> 466
    //   456: sipush -3000
    //   459: iload 5
    //   461: isub
    //   462: istore_3
    //   463: goto -398 -> 65
    //   466: aload_1
    //   467: astore 7
    //   469: aload 6
    //   471: astore 8
    //   473: iload 4
    //   475: istore_3
    //   476: aload_0
    //   477: getfield 41	sm/ae:k	Z
    //   480: ifeq +10 -> 490
    //   483: sipush -3003
    //   486: istore_3
    //   487: goto -422 -> 65
    //   490: aload_1
    //   491: astore 7
    //   493: aload 6
    //   495: astore 8
    //   497: iload 4
    //   499: istore_3
    //   500: aload_1
    //   501: invokeinterface 305 1 0
    //   506: astore 9
    //   508: aload 9
    //   510: ifnonnull +10 -> 520
    //   513: sipush -4000
    //   516: istore_3
    //   517: goto -452 -> 65
    //   520: aload_1
    //   521: astore 7
    //   523: aload 6
    //   525: astore 8
    //   527: iload 4
    //   529: istore_3
    //   530: aload_0
    //   531: aload 9
    //   533: aload 11
    //   535: iload_2
    //   536: invokespecial 307	sm/ae:a	(Lorg/apache/http/HttpEntity;Landroid/os/Bundle;Z)I
    //   539: istore 4
    //   541: iload 4
    //   543: ifeq +16 -> 559
    //   546: iload 4
    //   548: bipush 249
    //   550: if_icmpne +569 -> 1119
    //   553: iload 4
    //   555: istore_3
    //   556: goto -491 -> 65
    //   559: aload_1
    //   560: astore 7
    //   562: aload 6
    //   564: astore 8
    //   566: iload 4
    //   568: istore_3
    //   569: aload_0
    //   570: iconst_1
    //   571: invokespecial 309	sm/ae:b	(Z)I
    //   574: istore 4
    //   576: iload 4
    //   578: ifeq +9 -> 587
    //   581: iload 4
    //   583: istore_3
    //   584: goto -519 -> 65
    //   587: iconst_0
    //   588: istore_3
    //   589: goto -524 -> 65
    //   592: astore 9
    //   594: aconst_null
    //   595: astore 8
    //   597: aconst_null
    //   598: astore 7
    //   600: sipush -3051
    //   603: istore_3
    //   604: aload 7
    //   606: astore 6
    //   608: aload 8
    //   610: astore_1
    //   611: aload 9
    //   613: invokevirtual 310	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   616: aload 8
    //   618: ifnull +15 -> 633
    //   621: aload 8
    //   623: invokeinterface 252 1 0
    //   628: invokeinterface 257 1 0
    //   633: aload 7
    //   635: ifnull +3 -> 638
    //   638: aload 11
    //   640: ldc_w 259
    //   643: sipush -3051
    //   646: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   649: aload_0
    //   650: iconst_1
    //   651: aload 11
    //   653: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   656: sipush -3051
    //   659: ireturn
    //   660: astore 9
    //   662: aconst_null
    //   663: astore 8
    //   665: aconst_null
    //   666: astore 7
    //   668: sipush -3054
    //   671: istore_3
    //   672: aload 7
    //   674: astore 6
    //   676: aload 8
    //   678: astore_1
    //   679: aload 9
    //   681: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   684: aload 8
    //   686: ifnull +15 -> 701
    //   689: aload 8
    //   691: invokeinterface 252 1 0
    //   696: invokeinterface 257 1 0
    //   701: aload 7
    //   703: ifnull +3 -> 706
    //   706: aload 11
    //   708: ldc_w 259
    //   711: sipush -3054
    //   714: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   717: aload_0
    //   718: iconst_1
    //   719: aload 11
    //   721: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   724: sipush -3054
    //   727: ireturn
    //   728: astore 9
    //   730: aconst_null
    //   731: astore 8
    //   733: aconst_null
    //   734: astore 7
    //   736: sipush -3055
    //   739: istore_3
    //   740: aload 7
    //   742: astore 6
    //   744: aload 8
    //   746: astore_1
    //   747: aload 9
    //   749: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   752: aload 8
    //   754: ifnull +15 -> 769
    //   757: aload 8
    //   759: invokeinterface 252 1 0
    //   764: invokeinterface 257 1 0
    //   769: aload 7
    //   771: ifnull +3 -> 774
    //   774: aload 11
    //   776: ldc_w 259
    //   779: sipush -3055
    //   782: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   785: aload_0
    //   786: iconst_1
    //   787: aload 11
    //   789: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   792: sipush -3055
    //   795: ireturn
    //   796: astore 9
    //   798: aconst_null
    //   799: astore 8
    //   801: aconst_null
    //   802: astore 7
    //   804: sipush -3056
    //   807: istore_3
    //   808: aload 7
    //   810: astore 6
    //   812: aload 8
    //   814: astore_1
    //   815: aload 9
    //   817: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   820: aload 8
    //   822: ifnull +15 -> 837
    //   825: aload 8
    //   827: invokeinterface 252 1 0
    //   832: invokeinterface 257 1 0
    //   837: aload 7
    //   839: ifnull +3 -> 842
    //   842: aload 11
    //   844: ldc_w 259
    //   847: sipush -3056
    //   850: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   853: aload_0
    //   854: iconst_1
    //   855: aload 11
    //   857: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   860: sipush -3056
    //   863: ireturn
    //   864: astore 9
    //   866: aconst_null
    //   867: astore 8
    //   869: aconst_null
    //   870: astore 7
    //   872: sipush -3000
    //   875: istore_3
    //   876: aload 7
    //   878: astore 6
    //   880: aload 8
    //   882: astore_1
    //   883: aload 9
    //   885: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   888: aload 8
    //   890: ifnull +15 -> 905
    //   893: aload 8
    //   895: invokeinterface 252 1 0
    //   900: invokeinterface 257 1 0
    //   905: aload 7
    //   907: ifnull +3 -> 910
    //   910: aload 11
    //   912: ldc_w 259
    //   915: sipush -3000
    //   918: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   921: aload_0
    //   922: iconst_1
    //   923: aload 11
    //   925: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   928: sipush -3000
    //   931: ireturn
    //   932: astore 9
    //   934: aload 8
    //   936: astore_1
    //   937: aload 7
    //   939: astore 6
    //   941: aload 9
    //   943: astore 7
    //   945: aload_1
    //   946: ifnull +14 -> 960
    //   949: aload_1
    //   950: invokeinterface 252 1 0
    //   955: invokeinterface 257 1 0
    //   960: aload 6
    //   962: ifnull +3 -> 965
    //   965: iload_3
    //   966: ifeq +25 -> 991
    //   969: iload_3
    //   970: bipush 249
    //   972: if_icmpeq +19 -> 991
    //   975: aload 11
    //   977: ldc_w 259
    //   980: iload_3
    //   981: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   984: aload_0
    //   985: iconst_1
    //   986: aload 11
    //   988: invokevirtual 199	sm/ae:a	(ILandroid/os/Bundle;)V
    //   991: aload 7
    //   993: athrow
    //   994: astore 7
    //   996: goto -51 -> 945
    //   999: astore 9
    //   1001: aconst_null
    //   1002: astore 7
    //   1004: aload 6
    //   1006: astore 8
    //   1008: goto -136 -> 872
    //   1011: astore 9
    //   1013: aload_1
    //   1014: astore 7
    //   1016: aload 6
    //   1018: astore 8
    //   1020: goto -148 -> 872
    //   1023: astore 9
    //   1025: aconst_null
    //   1026: astore 7
    //   1028: aload 6
    //   1030: astore 8
    //   1032: goto -228 -> 804
    //   1035: astore 9
    //   1037: aload_1
    //   1038: astore 7
    //   1040: aload 6
    //   1042: astore 8
    //   1044: goto -240 -> 804
    //   1047: astore 9
    //   1049: aconst_null
    //   1050: astore 7
    //   1052: aload 6
    //   1054: astore 8
    //   1056: goto -320 -> 736
    //   1059: astore 9
    //   1061: aload_1
    //   1062: astore 7
    //   1064: aload 6
    //   1066: astore 8
    //   1068: goto -332 -> 736
    //   1071: astore 9
    //   1073: aconst_null
    //   1074: astore 7
    //   1076: aload 6
    //   1078: astore 8
    //   1080: goto -412 -> 668
    //   1083: astore 9
    //   1085: aload_1
    //   1086: astore 7
    //   1088: aload 6
    //   1090: astore 8
    //   1092: goto -424 -> 668
    //   1095: astore 9
    //   1097: aconst_null
    //   1098: astore 7
    //   1100: aload 6
    //   1102: astore 8
    //   1104: goto -504 -> 600
    //   1107: astore 9
    //   1109: aload_1
    //   1110: astore 7
    //   1112: aload 6
    //   1114: astore 8
    //   1116: goto -516 -> 600
    //   1119: iload 4
    //   1121: istore_3
    //   1122: goto -1057 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1125	0	this	ae
    //   0	1125	1	paramString	String
    //   0	1125	2	paramBoolean	boolean
    //   29	1093	3	m	int
    //   3	1117	4	n	int
    //   438	24	5	i1	int
    //   34	1079	6	localObject1	Object
    //   25	967	7	localObject2	Object
    //   994	1	7	localObject3	Object
    //   1002	109	7	str	String
    //   6	1109	8	localObject4	Object
    //   9	523	9	localHttpEntity	org.apache.http.HttpEntity
    //   592	20	9	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   660	20	9	localSocketException1	java.net.SocketException
    //   728	20	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   796	20	9	localIOException1	java.io.IOException
    //   864	20	9	localException1	java.lang.Exception
    //   932	10	9	localObject5	Object
    //   999	1	9	localException2	java.lang.Exception
    //   1011	1	9	localException3	java.lang.Exception
    //   1023	1	9	localIOException2	java.io.IOException
    //   1035	1	9	localIOException3	java.io.IOException
    //   1047	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1059	1	9	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1071	1	9	localSocketException2	java.net.SocketException
    //   1083	1	9	localSocketException3	java.net.SocketException
    //   1095	1	9	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    //   1107	1	9	localClientProtocolException3	org.apache.http.client.ClientProtocolException
    //   12	156	10	localObject6	Object
    //   21	966	11	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   30	36	592	org/apache/http/client/ClientProtocolException
    //   30	36	660	java/net/SocketException
    //   30	36	728	java/net/SocketTimeoutException
    //   30	36	796	java/io/IOException
    //   30	36	864	java/lang/Exception
    //   30	36	932	finally
    //   47	54	932	finally
    //   125	132	932	finally
    //   153	163	932	finally
    //   184	189	932	finally
    //   200	224	932	finally
    //   235	242	932	finally
    //   253	258	932	finally
    //   269	307	932	finally
    //   318	325	932	finally
    //   336	344	932	finally
    //   355	394	932	finally
    //   405	417	932	finally
    //   427	440	932	finally
    //   476	483	932	finally
    //   500	508	932	finally
    //   530	541	932	finally
    //   569	576	932	finally
    //   611	616	994	finally
    //   679	684	994	finally
    //   747	752	994	finally
    //   815	820	994	finally
    //   883	888	994	finally
    //   47	54	999	java/lang/Exception
    //   125	132	999	java/lang/Exception
    //   153	163	999	java/lang/Exception
    //   184	189	999	java/lang/Exception
    //   200	224	999	java/lang/Exception
    //   235	242	999	java/lang/Exception
    //   253	258	999	java/lang/Exception
    //   269	307	999	java/lang/Exception
    //   318	325	999	java/lang/Exception
    //   336	344	999	java/lang/Exception
    //   355	394	999	java/lang/Exception
    //   405	417	999	java/lang/Exception
    //   427	440	1011	java/lang/Exception
    //   476	483	1011	java/lang/Exception
    //   500	508	1011	java/lang/Exception
    //   530	541	1011	java/lang/Exception
    //   569	576	1011	java/lang/Exception
    //   47	54	1023	java/io/IOException
    //   125	132	1023	java/io/IOException
    //   153	163	1023	java/io/IOException
    //   184	189	1023	java/io/IOException
    //   200	224	1023	java/io/IOException
    //   235	242	1023	java/io/IOException
    //   253	258	1023	java/io/IOException
    //   269	307	1023	java/io/IOException
    //   318	325	1023	java/io/IOException
    //   336	344	1023	java/io/IOException
    //   355	394	1023	java/io/IOException
    //   405	417	1023	java/io/IOException
    //   427	440	1035	java/io/IOException
    //   476	483	1035	java/io/IOException
    //   500	508	1035	java/io/IOException
    //   530	541	1035	java/io/IOException
    //   569	576	1035	java/io/IOException
    //   47	54	1047	java/net/SocketTimeoutException
    //   125	132	1047	java/net/SocketTimeoutException
    //   153	163	1047	java/net/SocketTimeoutException
    //   184	189	1047	java/net/SocketTimeoutException
    //   200	224	1047	java/net/SocketTimeoutException
    //   235	242	1047	java/net/SocketTimeoutException
    //   253	258	1047	java/net/SocketTimeoutException
    //   269	307	1047	java/net/SocketTimeoutException
    //   318	325	1047	java/net/SocketTimeoutException
    //   336	344	1047	java/net/SocketTimeoutException
    //   355	394	1047	java/net/SocketTimeoutException
    //   405	417	1047	java/net/SocketTimeoutException
    //   427	440	1059	java/net/SocketTimeoutException
    //   476	483	1059	java/net/SocketTimeoutException
    //   500	508	1059	java/net/SocketTimeoutException
    //   530	541	1059	java/net/SocketTimeoutException
    //   569	576	1059	java/net/SocketTimeoutException
    //   47	54	1071	java/net/SocketException
    //   125	132	1071	java/net/SocketException
    //   153	163	1071	java/net/SocketException
    //   184	189	1071	java/net/SocketException
    //   200	224	1071	java/net/SocketException
    //   235	242	1071	java/net/SocketException
    //   253	258	1071	java/net/SocketException
    //   269	307	1071	java/net/SocketException
    //   318	325	1071	java/net/SocketException
    //   336	344	1071	java/net/SocketException
    //   355	394	1071	java/net/SocketException
    //   405	417	1071	java/net/SocketException
    //   427	440	1083	java/net/SocketException
    //   476	483	1083	java/net/SocketException
    //   500	508	1083	java/net/SocketException
    //   530	541	1083	java/net/SocketException
    //   569	576	1083	java/net/SocketException
    //   47	54	1095	org/apache/http/client/ClientProtocolException
    //   125	132	1095	org/apache/http/client/ClientProtocolException
    //   153	163	1095	org/apache/http/client/ClientProtocolException
    //   184	189	1095	org/apache/http/client/ClientProtocolException
    //   200	224	1095	org/apache/http/client/ClientProtocolException
    //   235	242	1095	org/apache/http/client/ClientProtocolException
    //   253	258	1095	org/apache/http/client/ClientProtocolException
    //   269	307	1095	org/apache/http/client/ClientProtocolException
    //   318	325	1095	org/apache/http/client/ClientProtocolException
    //   336	344	1095	org/apache/http/client/ClientProtocolException
    //   355	394	1095	org/apache/http/client/ClientProtocolException
    //   405	417	1095	org/apache/http/client/ClientProtocolException
    //   427	440	1107	org/apache/http/client/ClientProtocolException
    //   476	483	1107	org/apache/http/client/ClientProtocolException
    //   500	508	1107	org/apache/http/client/ClientProtocolException
    //   530	541	1107	org/apache/http/client/ClientProtocolException
    //   569	576	1107	org/apache/http/client/ClientProtocolException
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public String b()
  {
    return this.f + File.separator + this.h;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     sm.ae
 * JD-Core Version:    0.7.0.1
 */