package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseMultiMedia$a
  extends AppBrandProxyUIProcessTask
{
  private p fSP;
  JsApiChooseMultiMedia.ChooseRequest kXZ;
  int kXg;
  private DialogInterface.OnCancelListener kXk;
  JsApiChooseMultiMedia.ChooseResult kYa;
  
  private JsApiChooseMultiMedia$a()
  {
    AppMethodBeat.i(46511);
    this.kYa = new JsApiChooseMultiMedia.ChooseResult();
    this.kXg = 7;
    AppMethodBeat.o(46511);
  }
  
  /* Error */
  private static String QE(String paramString)
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: newarray int
    //   8: astore 13
    //   10: new 56	com/tencent/mm/compatible/h/d
    //   13: dup
    //   14: invokespecial 57	com/tencent/mm/compatible/h/d:<init>	()V
    //   17: astore 12
    //   19: aload 12
    //   21: aload_0
    //   22: invokevirtual 63	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 12
    //   27: bipush 18
    //   29: invokevirtual 67	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 73	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   36: istore 6
    //   38: aload 12
    //   40: bipush 19
    //   42: invokevirtual 67	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   45: iconst_0
    //   46: invokestatic 73	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   49: istore 7
    //   51: aload 13
    //   53: iconst_0
    //   54: iload 6
    //   56: iastore
    //   57: aload 13
    //   59: iconst_1
    //   60: iload 7
    //   62: iastore
    //   63: invokestatic 79	com/tencent/mm/modelcontrol/d:aHh	()Lcom/tencent/mm/modelcontrol/d;
    //   66: invokevirtual 83	com/tencent/mm/modelcontrol/d:aHo	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   69: astore 14
    //   71: aload 14
    //   73: getfield 88	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   76: istore_3
    //   77: aload 14
    //   79: getfield 91	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   82: istore 4
    //   84: ldc 93
    //   86: new 95	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 97
    //   92: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: iload 6
    //   97: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc 105
    //   102: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload 7
    //   107: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc 110
    //   112: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_3
    //   116: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc 112
    //   121: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 4
    //   126: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 114
    //   131: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: iload 6
    //   142: iload_3
    //   143: if_icmpgt +270 -> 413
    //   146: iload 7
    //   148: iload 4
    //   150: if_icmpgt +263 -> 413
    //   153: ldc 93
    //   155: ldc 126
    //   157: invokestatic 128	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: astore 11
    //   163: aload 11
    //   165: ifnull +21 -> 186
    //   168: aload 13
    //   170: iconst_0
    //   171: aload 11
    //   173: getfield 133	android/graphics/Point:x	I
    //   176: iastore
    //   177: aload 13
    //   179: iconst_1
    //   180: aload 11
    //   182: getfield 136	android/graphics/Point:y	I
    //   185: iastore
    //   186: ldc 93
    //   188: ldc 138
    //   190: bipush 6
    //   192: anewarray 140	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: iload 6
    //   199: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: iload 7
    //   207: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: dup
    //   212: iconst_2
    //   213: aload 14
    //   215: getfield 88	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   218: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: dup
    //   223: iconst_3
    //   224: aload 14
    //   226: getfield 91	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   229: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_4
    //   235: aload 13
    //   237: iconst_0
    //   238: iaload
    //   239: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aastore
    //   243: dup
    //   244: iconst_5
    //   245: aload 13
    //   247: iconst_1
    //   248: iaload
    //   249: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: invokestatic 149	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload 12
    //   258: invokevirtual 152	android/media/MediaMetadataRetriever:release	()V
    //   261: aload 13
    //   263: iconst_0
    //   264: iaload
    //   265: istore_3
    //   266: aload 13
    //   268: iconst_1
    //   269: iaload
    //   270: istore 4
    //   272: new 95	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   279: invokestatic 158	com/tencent/mm/loader/j/b:asv	()Ljava/lang/String;
    //   282: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 160
    //   287: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   293: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc 171
    //   298: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore 11
    //   306: invokestatic 79	com/tencent/mm/modelcontrol/d:aHh	()Lcom/tencent/mm/modelcontrol/d;
    //   309: invokevirtual 83	com/tencent/mm/modelcontrol/d:aHo	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   312: astore 12
    //   314: ldc 93
    //   316: ldc 173
    //   318: iconst_1
    //   319: anewarray 140	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload 12
    //   326: getfield 176	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   329: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aastore
    //   333: invokestatic 149	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: new 178	java/util/concurrent/CountDownLatch
    //   339: dup
    //   340: iconst_1
    //   341: invokespecial 180	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   344: astore 13
    //   346: getstatic 186	com/tencent/mm/media/i/d:hol	Lcom/tencent/mm/media/i/d$a;
    //   349: aload_0
    //   350: aload 11
    //   352: iload_3
    //   353: iload 4
    //   355: aload 12
    //   357: getfield 176	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   360: aload 12
    //   362: getfield 189	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   365: aload 12
    //   367: getfield 192	com/tencent/mm/modelcontrol/VideoTransPara:hkJ	I
    //   370: aload 12
    //   372: getfield 195	com/tencent/mm/modelcontrol/VideoTransPara:hkK	I
    //   375: new 17	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5
    //   378: dup
    //   379: aload 13
    //   381: invokespecial 198	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5:<init>	(Ljava/util/concurrent/CountDownLatch;)V
    //   384: invokeinterface 203 10 0
    //   389: invokevirtual 207	com/tencent/mm/media/i/d:aue	()I
    //   392: pop
    //   393: ldc 93
    //   395: ldc 209
    //   397: invokestatic 124	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 13
    //   402: invokevirtual 212	java/util/concurrent/CountDownLatch:await	()V
    //   405: ldc 54
    //   407: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: aload 11
    //   412: areturn
    //   413: iload 6
    //   415: iload 7
    //   417: invokestatic 218	java/lang/Math:max	(II)I
    //   420: istore 10
    //   422: iload 6
    //   424: iload 7
    //   426: invokestatic 221	java/lang/Math:min	(II)I
    //   429: istore 9
    //   431: iload_3
    //   432: iload 4
    //   434: invokestatic 218	java/lang/Math:max	(II)I
    //   437: istore 5
    //   439: iload_3
    //   440: iload 4
    //   442: invokestatic 221	java/lang/Math:min	(II)I
    //   445: istore 8
    //   447: iload 10
    //   449: bipush 16
    //   451: irem
    //   452: ifne +50 -> 502
    //   455: iload 10
    //   457: iload 5
    //   459: isub
    //   460: invokestatic 225	java/lang/Math:abs	(I)I
    //   463: bipush 16
    //   465: if_icmpge +37 -> 502
    //   468: iload 9
    //   470: bipush 16
    //   472: irem
    //   473: ifne +29 -> 502
    //   476: iload 9
    //   478: iload 8
    //   480: isub
    //   481: invokestatic 225	java/lang/Math:abs	(I)I
    //   484: bipush 16
    //   486: if_icmpge +16 -> 502
    //   489: ldc 93
    //   491: ldc 227
    //   493: invokestatic 128	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aconst_null
    //   497: astore 11
    //   499: goto -336 -> 163
    //   502: iload 10
    //   504: iconst_2
    //   505: idiv
    //   506: istore 10
    //   508: iload 9
    //   510: iconst_2
    //   511: idiv
    //   512: istore 9
    //   514: iload 10
    //   516: bipush 16
    //   518: irem
    //   519: ifne +105 -> 624
    //   522: iload 10
    //   524: iload 5
    //   526: isub
    //   527: invokestatic 225	java/lang/Math:abs	(I)I
    //   530: bipush 16
    //   532: if_icmpge +92 -> 624
    //   535: iload 9
    //   537: bipush 16
    //   539: irem
    //   540: ifne +84 -> 624
    //   543: iload 9
    //   545: iload 8
    //   547: isub
    //   548: invokestatic 225	java/lang/Math:abs	(I)I
    //   551: bipush 16
    //   553: if_icmpge +71 -> 624
    //   556: ldc 93
    //   558: ldc 229
    //   560: invokestatic 128	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: iload 6
    //   565: iconst_2
    //   566: idiv
    //   567: istore_3
    //   568: iload 7
    //   570: iconst_2
    //   571: idiv
    //   572: istore 4
    //   574: iload_3
    //   575: iconst_2
    //   576: irem
    //   577: ifeq +194 -> 771
    //   580: iload_3
    //   581: iconst_1
    //   582: iadd
    //   583: istore_3
    //   584: goto +187 -> 771
    //   587: new 130	android/graphics/Point
    //   590: dup
    //   591: iload_3
    //   592: iload 4
    //   594: invokespecial 232	android/graphics/Point:<init>	(II)V
    //   597: astore 11
    //   599: goto -436 -> 163
    //   602: astore_0
    //   603: aload 12
    //   605: astore 11
    //   607: aload 11
    //   609: ifnull +8 -> 617
    //   612: aload 11
    //   614: invokevirtual 152	android/media/MediaMetadataRetriever:release	()V
    //   617: ldc 54
    //   619: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: aload_0
    //   623: athrow
    //   624: new 130	android/graphics/Point
    //   627: dup
    //   628: invokespecial 233	android/graphics/Point:<init>	()V
    //   631: astore 11
    //   633: iload 6
    //   635: iload 7
    //   637: if_icmpge +74 -> 711
    //   640: iload_3
    //   641: iload 4
    //   643: invokestatic 221	java/lang/Math:min	(II)I
    //   646: istore_3
    //   647: dconst_1
    //   648: iload 6
    //   650: i2d
    //   651: dmul
    //   652: iload_3
    //   653: i2d
    //   654: ddiv
    //   655: dstore_1
    //   656: iload 7
    //   658: i2d
    //   659: dload_1
    //   660: ddiv
    //   661: d2i
    //   662: istore 4
    //   664: goto +123 -> 787
    //   667: ldc 93
    //   669: ldc 235
    //   671: iconst_2
    //   672: anewarray 140	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: iload 4
    //   679: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: iload 5
    //   687: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   690: aastore
    //   691: invokestatic 237	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   694: aload 11
    //   696: iload 4
    //   698: putfield 133	android/graphics/Point:x	I
    //   701: aload 11
    //   703: iload 5
    //   705: putfield 136	android/graphics/Point:y	I
    //   708: goto -545 -> 163
    //   711: iload_3
    //   712: iload 4
    //   714: invokestatic 221	java/lang/Math:min	(II)I
    //   717: istore 4
    //   719: dconst_1
    //   720: iload 7
    //   722: i2d
    //   723: dmul
    //   724: iload 4
    //   726: i2d
    //   727: ddiv
    //   728: dstore_1
    //   729: iload 6
    //   731: i2d
    //   732: dload_1
    //   733: ddiv
    //   734: d2i
    //   735: istore_3
    //   736: goto +51 -> 787
    //   739: astore_0
    //   740: ldc 93
    //   742: ldc 239
    //   744: iconst_1
    //   745: anewarray 140	java/lang/Object
    //   748: dup
    //   749: iconst_0
    //   750: aload_0
    //   751: invokevirtual 242	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   754: aastore
    //   755: invokestatic 245	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   758: goto -353 -> 405
    //   761: astore_0
    //   762: aconst_null
    //   763: astore 11
    //   765: goto -158 -> 607
    //   768: goto -181 -> 587
    //   771: iload 4
    //   773: iconst_2
    //   774: irem
    //   775: ifeq -7 -> 768
    //   778: iload 4
    //   780: iconst_1
    //   781: iadd
    //   782: istore 4
    //   784: goto -197 -> 587
    //   787: iload 4
    //   789: istore 5
    //   791: iload 4
    //   793: iconst_2
    //   794: irem
    //   795: ifeq +9 -> 804
    //   798: iload 4
    //   800: iconst_1
    //   801: iadd
    //   802: istore 5
    //   804: iload_3
    //   805: istore 4
    //   807: iload_3
    //   808: iconst_2
    //   809: irem
    //   810: ifeq -143 -> 667
    //   813: iload_3
    //   814: iconst_1
    //   815: iadd
    //   816: istore 4
    //   818: goto -151 -> 667
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramString	String
    //   655	78	1	d	double
    //   76	740	3	i	int
    //   82	735	4	j	int
    //   437	366	5	k	int
    //   36	694	6	m	int
    //   49	672	7	n	int
    //   445	103	8	i1	int
    //   429	119	9	i2	int
    //   420	107	10	i3	int
    //   161	603	11	localObject1	Object
    //   17	587	12	localObject2	Object
    //   8	393	13	localObject3	Object
    //   69	156	14	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
    // Exception table:
    //   from	to	target	type
    //   19	51	602	finally
    //   63	140	602	finally
    //   153	160	602	finally
    //   168	186	602	finally
    //   186	256	602	finally
    //   413	447	602	finally
    //   455	468	602	finally
    //   476	496	602	finally
    //   502	514	602	finally
    //   522	535	602	finally
    //   543	574	602	finally
    //   587	599	602	finally
    //   624	633	602	finally
    //   640	664	602	finally
    //   667	708	602	finally
    //   711	719	602	finally
    //   393	405	739	java/lang/InterruptedException
    //   10	19	761	finally
  }
  
  private static String QF(String paramString)
  {
    AppMethodBeat.i(46520);
    String str2 = "";
    String str1 = str2;
    if (!bu.isNullOrNil(paramString))
    {
      Object localObject = new k(paramString);
      str1 = str2;
      if (((k)localObject).exists())
      {
        localObject = ((k)localObject).getName();
        str2 = null;
        str1 = str2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          str1 = str2;
          if (((String)localObject).contains(".")) {
            str1 = ((String)localObject).substring(0, ((String)localObject).lastIndexOf("."));
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          if ((com.tencent.mm.loader.j.b.asv() != null) && (com.tencent.mm.loader.j.b.asv().endsWith("/"))) {
            str1 = com.tencent.mm.loader.j.b.asv() + str1 + System.currentTimeMillis() + ".jpeg";
          }
        }
        for (;;)
        {
          if (new k(str1).exists()) {
            break label338;
          }
          ae.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", new Object[] { str1 });
          paramString = com.tencent.mm.sdk.platformtools.h.createVideoThumbnail(paramString, 2);
          if (paramString != null) {
            break;
          }
          ae.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
          AppMethodBeat.o(46520);
          return "";
          str1 = com.tencent.mm.loader.j.b.asv() + "/" + str1 + System.currentTimeMillis() + ".jpeg";
          continue;
          str1 = "microMsg_" + System.currentTimeMillis();
          str1 = com.tencent.mm.loader.j.b.asv() + str1 + ".jpeg";
        }
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(paramString, 80, Bitmap.CompressFormat.JPEG, str1, true);
        AppMethodBeat.o(46520);
        return str1;
      }
      catch (IOException paramString)
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + paramString.getMessage());
        continue;
      }
      label338:
      ae.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", new Object[] { str1 });
    }
  }
  
  private static String QG(String paramString)
  {
    AppMethodBeat.i(46523);
    String str = o.k(com.tencent.mm.loader.j.b.asv() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(46523);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
          Object localObject2 = null;
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          Bitmap localBitmap3 = com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        Object localObject4 = null;
      }
      long l = bu.fpO();
      boolean bool = com.tencent.mm.plugin.appbrand.utils.d.ev(str, paramString);
      ae.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bu.fpO() - l), paramString, Long.valueOf(o.aZR(paramString)), str, Long.valueOf(o.aZR(str)) });
      if (bool)
      {
        AppMethodBeat.o(46523);
        return str;
      }
      AppMethodBeat.o(46523);
    }
    return paramString;
  }
  
  private static String QH(String paramString)
  {
    AppMethodBeat.i(46524);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
        if (localObject1 == null)
        {
          ae.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
          AppMethodBeat.o(46524);
          return paramString;
        }
        float f = i % 360;
        Bitmap localBitmap = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, f);
        Object localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.asv()).append("microMsg.tmp.").append(System.currentTimeMillis());
        if (com.tencent.mm.plugin.appbrand.utils.d.d(localOptions))
        {
          localObject1 = ".jpg";
          localObject2 = (String)localObject1;
          if (!com.tencent.mm.plugin.appbrand.utils.d.d(localOptions)) {
            break label172;
          }
        }
        for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.h.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
            if (com.tencent.mm.plugin.appbrand.utils.d.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.cV(paramString, (String)localObject2);
            }
            AppMethodBeat.o(46524);
            return localObject2;
          }
          catch (Exception localException)
          {
            label172:
            ae.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            o.deleteFile((String)localObject2);
            AppMethodBeat.o(46524);
            return paramString;
          }
          localObject1 = ".png";
          break;
        }
        AppMethodBeat.o(46524);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        AppMethodBeat.o(46524);
        return paramString;
      }
      catch (NullPointerException localNullPointerException)
      {
        AppMethodBeat.o(46524);
        return paramString;
      }
    }
    return paramString;
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46522);
    ae.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "video");
      localJSONObject.put("tempFilePath", paramString1);
      localJSONObject.put("size", paramLong);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      localJSONObject.put("duration", paramInt3);
      localJSONObject.put("thumbTempFilePath", paramString2);
      localJSONObject.put("mark", paramString3);
      localJSONObject.put("scene", "camera");
      localJSONArray.put(localJSONObject);
      paramString1 = localJSONArray.toString();
      AppMethodBeat.o(46522);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(46522);
    }
    return "";
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46521);
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "image");
      localJSONObject.put("tempFilePath", paramString1);
      localJSONObject.put("size", paramLong);
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      localJSONObject.put("orientation", paramString2);
      localJSONObject.put("mark", paramString3);
      localJSONObject.put("scene", "camera");
      localJSONArray.put(localJSONObject);
      paramString1 = localJSONArray.toString();
      ae.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(46521);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(46521);
    }
    return "";
  }
  
  private AppBrandLocalVideoObject aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46519);
    String str1 = paramString;
    if (paramBoolean) {}
    String str2;
    int i;
    int j;
    int m;
    try
    {
      str1 = QE(paramString);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new com.tencent.mm.compatible.h.d();
          paramString.setDataSource(str1);
          if (paramString != null) {
            break;
          }
          ae.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(46519);
          return null;
          localException = localException;
          ae.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bu.o(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ae.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        i = bu.getInt(paramString.extractMetadata(18), 0);
        j = bu.getInt(paramString.extractMetadata(19), 0);
        m = bu.getInt(paramString.extractMetadata(9), 0);
        if (!"90".equals(paramString.extractMetadata(24))) {
          break label254;
        }
      }
    }
    if (i > j) {}
    for (;;)
    {
      paramString.release();
      paramString = AppBrandLocalMediaObjectManager.cl(this.kXZ.appId, str2);
      if (paramString == null)
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
        AppMethodBeat.o(46519);
        return null;
      }
      paramString.duration = ((m + 500) / 1000);
      paramString.width = j;
      paramString.height = i;
      paramString.size = o.aZR(str2);
      ae.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", new Object[] { paramString });
      AppMethodBeat.o(46519);
      return paramString;
      label254:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  private Intent blV()
  {
    AppMethodBeat.i(46513);
    Intent localIntent = new Intent();
    localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
    localIntent.putExtra("album_video_max_duration", this.kXZ.jxK);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_distance", this.kXZ.inH);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.kXZ.latitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.kXZ.longitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_posname", this.kXZ.jGd);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("send_btn_string", ak.getResources().getString(2131755830));
    localIntent.putExtra("gallery_report_tag", 18);
    AppMethodBeat.o(46513);
    return localIntent;
  }
  
  private static BackwardSupportUtil.ExifHelper.LatLongData blW()
  {
    AppMethodBeat.i(46515);
    Object localObject = ak.getContext().getSharedPreferences(ak.fow() + "_locCache", 0).getString("locStr", null);
    String[] arrayOfString;
    float f1;
    float f2;
    if (localObject != null)
    {
      arrayOfString = ((String)localObject).split(",");
      f1 = bu.getInt(arrayOfString[0], 0) / 1000000.0F;
      f2 = bu.getInt(arrayOfString[1], 0) / 1000000.0F;
      ae.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", new Object[] { localObject, Float.valueOf(f1), Float.valueOf(f2) });
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
    }
    for (;;)
    {
      AppMethodBeat.o(46515);
      return localObject;
      localObject = (String)g.ajR().ajA().get(67591, null);
      if (localObject != null) {
        for (;;)
        {
          try
          {
            arrayOfString = ((String)localObject).split(",");
            int i = Integer.valueOf(arrayOfString[0]).intValue();
            if (1 != Integer.valueOf(arrayOfString[1]).intValue()) {
              break label297;
            }
            localObject = "network";
            f1 = Integer.valueOf(arrayOfString[2]).intValue() / 1000000.0F;
            f2 = Integer.valueOf(arrayOfString[3]).intValue() / 1000000.0F;
            ae.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", new Object[] { Integer.valueOf(i), localObject, Float.valueOf(f1), Float.valueOf(f2) });
            localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", new Object[] { localException });
            str = null;
          }
          break;
          label297:
          str = "gps";
        }
      }
      ae.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
      ae.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
      String str = null;
    }
  }
  
  private void blX()
  {
    AppMethodBeat.i(46516);
    this.kXk = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46509);
        ae.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
        JsApiChooseMultiMedia.a.this.kYa.bZU = 0;
        JsApiChooseMultiMedia.a.h(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
        AppMethodBeat.o(46509);
      }
    };
    MMActivity localMMActivity = bis();
    ak.getResources().getString(2131755906);
    this.fSP = com.tencent.mm.ui.base.h.b(localMMActivity, ak.getResources().getString(2131755360), true, this.kXk);
    AppMethodBeat.o(46516);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    int k = 3;
    int j = 0;
    AppMethodBeat.i(46512);
    this.kXZ = ((JsApiChooseMultiMedia.ChooseRequest)paramProcessRequest);
    int i;
    boolean bool;
    if (bu.jk(bis()) > 200L)
    {
      i = 1;
      if (i == 0) {
        t.makeText(bis(), ak.getResources().getString(2131755358), 1).show();
      }
      bis().mmSetOnActivityResultCallback(this);
      if (this.kXZ.kXW != 1) {
        break label160;
      }
      bool = true;
      i = k;
    }
    for (;;)
    {
      if ((this.kXZ.kWX) && (this.kXZ.kWY))
      {
        paramProcessRequest = blV();
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        q.a(bis(), 1, this.kXZ.count, this.kXg, paramProcessRequest);
        AppMethodBeat.o(46512);
        return;
        i = 0;
        break;
        label160:
        if (this.kXZ.kXW == 2)
        {
          i = 1;
          bool = false;
          continue;
        }
        if (this.kXZ.kXW != 3) {
          break label462;
        }
        i = 2;
        bool = false;
        continue;
      }
      if (this.kXZ.kWY)
      {
        paramProcessRequest = blV();
        paramProcessRequest.putExtra("show_header_view", false);
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        q.a(bis(), 1, this.kXZ.count, this.kXg, paramProcessRequest);
        AppMethodBeat.o(46512);
        return;
      }
      if (this.kXZ.kWX)
      {
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_latitude", this.kXZ.latitude);
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_longitude", this.kXZ.longitude);
        if ((this.kXZ.kXU) && (!this.kXZ.kXV)) {
          i = 1;
        }
        for (;;)
        {
          SightParams localSightParams = new SightParams(7, 1);
          localSightParams.mode = i;
          localSightParams.hxV.duration = this.kXZ.jxK;
          paramProcessRequest.putExtra("KEY_SIGHT_PARAMS", localSightParams);
          q.a(bis(), 2, paramProcessRequest, 7, i);
          AppMethodBeat.o(46512);
          return;
          i = j;
          if (this.kXZ.kXV)
          {
            i = j;
            if (!this.kXZ.kXU) {
              i = 2;
            }
          }
        }
      }
      ae.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
      this.kYa.bZU = -2;
      b(this.kYa);
      AppMethodBeat.o(46512);
      return;
      label462:
      bool = false;
      i = k;
    }
  }
  
  public final void biz()
  {
    AppMethodBeat.i(46517);
    super.biz();
    if (this.fSP != null)
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(46517);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    final double d2 = 91.0D;
    final boolean bool1 = true;
    AppMethodBeat.i(46514);
    if (paramInt2 == 0)
    {
      this.kYa.bZU = 0;
      b(this.kYa);
      AppMethodBeat.o(46514);
      return;
    }
    if (paramIntent != null) {}
    for (double d1 = paramIntent.getDoubleExtra("longitude", 181.0D);; d1 = 181.0D)
    {
      if (paramIntent != null) {
        d2 = paramIntent.getDoubleExtra("latitude", 91.0D);
      }
      ae.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
      ae.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        this.kYa.bZU = -2;
        b(this.kYa);
        AppMethodBeat.o(46514);
        return;
      }
    }
    ae.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
    if (paramIntent == null)
    {
      this.kYa.bZU = 0;
      b(this.kYa);
      AppMethodBeat.o(46514);
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
    final ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_select_video_list");
    final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
    blX();
    if (!bool2) {
      if (!bu.ht((List)localObject))
      {
        paramIntent = ((List)localObject).iterator();
        while (paramIntent.hasNext()) {
          if (Exif.fromFile((String)paramIntent.next()).getOrientationInDegree() != 0)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label336;
            }
          }
        }
      }
    }
    for (;;)
    {
      m.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46506);
          JSONArray localJSONArray = new JSONArray();
          Object localObject4;
          Object localObject3;
          long l2;
          long l1;
          label125:
          double d;
          Object localObject5;
          boolean bool;
          if ((this.kYb != null) && (this.kYb.size() > 0))
          {
            localObject4 = this.kYb.iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (String)((Iterator)localObject4).next();
                if ((!bu.isNullOrNil((String)localObject3)) && (new k((String)localObject3).exists()))
                {
                  ae.i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                  l2 = 0L;
                  l1 = l2;
                  try
                  {
                    if (!bu.isNullOrNil((String)localObject3)) {
                      break;
                    }
                    l1 = l2;
                    ae.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                    localObject1 = null;
                    l1 = l2;
                    if (localObject1 != null)
                    {
                      l1 = l2;
                      l2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject1).getTime() / 1000L;
                      l1 = l2;
                      ae.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", new Object[] { Long.valueOf(l2), localObject3 });
                      l1 = l2;
                    }
                  }
                  catch (Exception localException2)
                  {
                    for (;;)
                    {
                      Object localObject1;
                      ae.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", new Object[] { localObject3 });
                      continue;
                      ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", new Object[] { localObject3 });
                      continue;
                      ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", new Object[] { localObject3 });
                    }
                  }
                  d = -1.0D;
                  if ((a.m(d2)) && (a.l(bool2)))
                  {
                    localObject1 = BackwardSupportUtil.ExifHelper.aRx((String)localObject3);
                    if (localObject1 != null)
                    {
                      d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject1).iev, d2, bool2);
                      localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                      if (!localArrayList) {
                        break label564;
                      }
                      localObject1 = JsApiChooseMultiMedia.a.QI((String)localObject3);
                      bool = true;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            Object localObject6;
            for (;;)
            {
              localObject3 = JsApiChooseMultiMedia.QD((String)localObject1);
              localObject6 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.kXZ.appId, (String)localObject1, bool);
              if (localObject6 == null) {
                break label594;
              }
              try
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("type", "image");
                ((JSONObject)localObject1).put("tempFilePath", ((AppBrandLocalMediaObject)localObject6).dsN);
                ((JSONObject)localObject1).put("size", ((AppBrandLocalMediaObject)localObject6).iTe);
                ((JSONObject)localObject1).put("width", ((JsApiChooseMultiMedia.b)localObject3).width);
                ((JSONObject)localObject1).put("height", ((JsApiChooseMultiMedia.b)localObject3).height);
                ((JSONObject)localObject1).put("orientation", ((JsApiChooseMultiMedia.b)localObject3).cpm);
                ((JSONObject)localObject1).put("mark", localObject5);
                ((JSONObject)localObject1).put("scene", "album");
                localJSONArray.put(localObject1);
              }
              catch (Exception localException1)
              {
                ae.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException1, "", new Object[0]);
              }
            }
            break;
            l1 = l2;
            if (!o.fB((String)localObject3))
            {
              l1 = l2;
              ae.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { localObject3 });
              str1 = null;
              break label125;
            }
            l1 = l2;
            String str1 = Exif.fromFile((String)localObject3).dateTime;
            break label125;
            label564:
            if (this.kXp)
            {
              String str2 = JsApiChooseMultiMedia.a.QJ((String)localObject3);
              if (!str2.equals(localObject3))
              {
                bool = true;
                continue;
                label594:
                ae.e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", new Object[] { str2 });
                break;
                if ((this.kYc != null) && (this.kYc.size() > 0))
                {
                  localObject3 = this.kYc.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    str2 = (String)((Iterator)localObject3).next();
                    if ((!bu.isNullOrNil(str2)) && (new k(str2).exists()))
                    {
                      ae.i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
                      l2 = 0L;
                      l1 = l2;
                      try
                      {
                        localObject4 = BackwardSupportUtil.aRw(str2);
                        l1 = l2;
                        if (localObject4 != null)
                        {
                          l1 = l2;
                          long l3 = new SimpleDateFormat("yyyyMMdd'T'hhmmss.SSS'Z'").parse((String)localObject4).getTime();
                          l1 = l2;
                          localObject4 = Calendar.getInstance(TimeZone.getDefault());
                          l1 = l2;
                          int i = ((Calendar)localObject4).get(15);
                          l1 = l2;
                          int j = ((Calendar)localObject4).get(16);
                          l1 = l2;
                          localObject4 = Calendar.getInstance();
                          l1 = l2;
                          ((Calendar)localObject4).setTimeInMillis(l3);
                          l1 = l2;
                          ((Calendar)localObject4).add(14, i + j);
                          l1 = l2;
                          l2 = ((Calendar)localObject4).getTimeInMillis() / 1000L;
                          l1 = l2;
                          ae.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", new Object[] { Long.valueOf(l2), str2 });
                          l1 = l2;
                        }
                        d = -1.0D;
                        if ((a.m(d2)) && (a.l(bool2)))
                        {
                          localObject4 = BackwardSupportUtil.aRv(str2);
                          if (localObject4 != null)
                          {
                            d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject4).iev, d2, bool2);
                            localObject4 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                            localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str2, true);
                            if (localObject5 != null) {
                              break label1064;
                            }
                            ae.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", new Object[] { str2 });
                            JsApiChooseMultiMedia.a.this.kYa.bZU = -2;
                            JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
                            AppMethodBeat.o(46506);
                            return;
                          }
                        }
                      }
                      catch (Exception localException4)
                      {
                        for (;;)
                        {
                          ae.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", new Object[] { str2 });
                          continue;
                          ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", new Object[] { str2 });
                          continue;
                          ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", new Object[] { str2 });
                        }
                        localObject6 = JsApiChooseMultiMedia.a.QK(str2);
                        str2 = "";
                        if (!bu.isNullOrNil((String)localObject6)) {
                          str2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, (String)localObject6);
                        }
                        try
                        {
                          localObject6 = new JSONObject();
                          ((JSONObject)localObject6).put("type", "video");
                          ((JSONObject)localObject6).put("tempFilePath", ((AppBrandLocalVideoObject)localObject5).dsN);
                          ((JSONObject)localObject6).put("size", ((AppBrandLocalVideoObject)localObject5).size);
                          ((JSONObject)localObject6).put("width", ((AppBrandLocalVideoObject)localObject5).width);
                          ((JSONObject)localObject6).put("height", ((AppBrandLocalVideoObject)localObject5).height);
                          ((JSONObject)localObject6).put("duration", ((AppBrandLocalVideoObject)localObject5).duration);
                          ((JSONObject)localObject6).put("thumbTempFilePath", str2);
                          ((JSONObject)localObject6).put("mark", localException4);
                          ((JSONObject)localObject6).put("scene", "album");
                          localJSONArray.put(localObject6);
                        }
                        catch (Exception localException3)
                        {
                          ae.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException3, "", new Object[0]);
                        }
                      }
                    }
                  }
                }
                JsApiChooseMultiMedia.a.this.kYa.bZU = -1;
                JsApiChooseMultiMedia.a.this.kYa.kXY = localJSONArray.toString();
                JsApiChooseMultiMedia.a.b(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
                AppMethodBeat.o(46506);
                return;
              }
            }
            label1064:
            bool = false;
            Object localObject2 = localObject3;
          }
        }
      });
      AppMethodBeat.o(46514);
      return;
      paramInt1 = 0;
      break;
      label336:
      bool1 = false;
    }
    ae.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
    if (paramIntent == null)
    {
      this.kYa.bZU = 0;
      b(this.kYa);
      AppMethodBeat.o(46514);
      return;
    }
    ae.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
    localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (localObject == null)
    {
      ae.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
      this.kYa.bZU = -2;
      b(this.kYa);
      AppMethodBeat.o(46514);
      return;
    }
    if (((SightCaptureResult)localObject).vYw)
    {
      localObject = ((SightCaptureResult)localObject).vYE;
      if ((bu.isNullOrNil((String)localObject)) || (!o.fB((String)localObject)))
      {
        ae.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
        this.kYa.bZU = -2;
        b(this.kYa);
        AppMethodBeat.o(46514);
        return;
      }
      ae.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", new Object[] { localObject });
      bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      blX();
      m.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46507);
          Object localObject1;
          JsApiChooseMultiMedia.b localb;
          long l;
          double d;
          Object localObject2;
          if (bool1)
          {
            localObject1 = JsApiChooseMultiMedia.a.QI(this.val$filePath);
            localb = JsApiChooseMultiMedia.QD((String)localObject1);
            localObject1 = AppBrandLocalMediaObjectManager.h(JsApiChooseMultiMedia.a.this.kXZ.appId, (String)localObject1, bool1 | true);
            if (localObject1 == null) {
              break label265;
            }
            l = Calendar.getInstance().getTimeInMillis() / 1000L;
            d = -1.0D;
            if ((!a.m(d2)) || (!a.l(this.iaH))) {
              break label244;
            }
            localObject2 = JsApiChooseMultiMedia.a.blY();
            if (localObject2 == null) {
              break label223;
            }
            d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).iev, d2, this.iaH);
          }
          for (;;)
          {
            localObject2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
            ae.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
            JsApiChooseMultiMedia.a.this.kYa.bZU = -1;
            JsApiChooseMultiMedia.a.this.kYa.kXY = JsApiChooseMultiMedia.a.b(((AppBrandLocalMediaObject)localObject1).dsN, ((AppBrandLocalMediaObject)localObject1).iTe, localb.width, localb.height, localb.cpm, (String)localObject2);
            JsApiChooseMultiMedia.a.c(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
            AppMethodBeat.o(46507);
            return;
            localObject1 = this.val$filePath;
            break;
            label223:
            ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", new Object[] { this.val$filePath });
            continue;
            label244:
            ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", new Object[] { this.val$filePath });
          }
          label265:
          ae.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
          JsApiChooseMultiMedia.a.this.kYa.bZU = -2;
          JsApiChooseMultiMedia.a.d(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
          AppMethodBeat.o(46507);
        }
      });
      AppMethodBeat.o(46514);
      return;
    }
    paramIntent = ((SightCaptureResult)localObject).vYy;
    if (bu.isNullOrNil(paramIntent))
    {
      ae.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
      this.kYa.bZU = -2;
      b(this.kYa);
      AppMethodBeat.o(46514);
      return;
    }
    ae.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", new Object[] { paramIntent });
    blX();
    m.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46508);
        AppBrandLocalVideoObject localAppBrandLocalVideoObject;
        if (new k(paramIntent).exists())
        {
          ae.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
          JsApiChooseMultiMedia.a.this.kYa.bZU = -1;
          localAppBrandLocalVideoObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, paramIntent, false);
          if (localAppBrandLocalVideoObject == null)
          {
            ae.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { paramIntent });
            JsApiChooseMultiMedia.a.this.kYa.bZU = -2;
            JsApiChooseMultiMedia.a.e(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
            AppMethodBeat.o(46508);
            return;
          }
          str = JsApiChooseMultiMedia.a.QK(paramIntent);
          if (bu.isNullOrNil(str)) {
            break label371;
          }
        }
        label371:
        for (String str = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str);; str = "")
        {
          long l = Calendar.getInstance().getTimeInMillis() / 1000L;
          double d = -1.0D;
          Object localObject;
          if ((a.m(d2)) && (a.l(this.iaH)))
          {
            localObject = JsApiChooseMultiMedia.a.blY();
            if (localObject != null) {
              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dzE, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).iev, d2, this.iaH);
            }
          }
          for (;;)
          {
            localObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
            JsApiChooseMultiMedia.a.this.kYa.kXY = JsApiChooseMultiMedia.a.b(localAppBrandLocalVideoObject.dsN, localAppBrandLocalVideoObject.size, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.duration, str, (String)localObject);
            JsApiChooseMultiMedia.a.f(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
            AppMethodBeat.o(46508);
            return;
            ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", new Object[] { paramIntent });
            continue;
            ae.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", new Object[] { paramIntent });
          }
          ae.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { paramIntent });
          JsApiChooseMultiMedia.a.this.kYa.bZU = -2;
          JsApiChooseMultiMedia.a.g(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.kYa);
          AppMethodBeat.o(46508);
          return;
        }
      }
    });
    AppMethodBeat.o(46514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a
 * JD-Core Version:    0.7.0.1
 */