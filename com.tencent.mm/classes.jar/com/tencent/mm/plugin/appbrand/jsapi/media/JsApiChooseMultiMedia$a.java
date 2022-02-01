package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.media.i.c.b;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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
  private w lKp;
  int sfB;
  private DialogInterface.OnCancelListener sfD;
  JsApiChooseMultiMedia.ChooseRequest sgt;
  JsApiChooseMultiMedia.ChooseResult sgu;
  
  private JsApiChooseMultiMedia$a()
  {
    AppMethodBeat.i(46511);
    this.sgu = new JsApiChooseMultiMedia.ChooseResult();
    this.sfB = 7;
    AppMethodBeat.o(46511);
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(46522);
    Log.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
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
      Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
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
      Log.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(46521);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(46521);
    }
    return "";
  }
  
  private AppBrandLocalVideoObject aF(String paramString, boolean paramBoolean)
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
      str1 = aaU(paramString);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new d();
          paramString.setDataSource(str1);
          if (paramString != null) {
            break;
          }
          Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(46519);
          return null;
          localException = localException;
          Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", new Object[] { Util.stackTraceToString(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        i = Util.getInt(paramString.extractMetadata(18), 0);
        j = Util.getInt(paramString.extractMetadata(19), 0);
        m = Util.getInt(paramString.extractMetadata(9), 0);
        if (!"90".equals(paramString.extractMetadata(24))) {
          break label254;
        }
      }
    }
    if (i > j) {}
    for (;;)
    {
      paramString.release();
      paramString = AppBrandLocalMediaObjectManager.cW(this.sgt.appId, str2);
      if (paramString == null)
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
        AppMethodBeat.o(46519);
        return null;
      }
      paramString.duration = ((m + 500) / 1000);
      paramString.width = j;
      paramString.height = i;
      paramString.size = y.bEl(str2);
      Log.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", new Object[] { paramString });
      AppMethodBeat.o(46519);
      return paramString;
      label254:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  /* Error */
  private static String aaU(String paramString)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_2
    //   7: newarray int
    //   9: astore 13
    //   11: new 297	com/tencent/mm/compatible/i/d
    //   14: dup
    //   15: invokespecial 298	com/tencent/mm/compatible/i/d:<init>	()V
    //   18: astore 12
    //   20: aload 12
    //   22: aload_0
    //   23: invokevirtual 304	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   26: aload 12
    //   28: bipush 18
    //   30: invokevirtual 320	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   33: iconst_0
    //   34: invokestatic 324	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   37: istore 6
    //   39: aload 12
    //   41: bipush 19
    //   43: invokevirtual 320	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   46: iconst_0
    //   47: invokestatic 324	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   50: istore 7
    //   52: aload 13
    //   54: iconst_0
    //   55: iload 6
    //   57: iastore
    //   58: aload 13
    //   60: iconst_1
    //   61: iload 7
    //   63: iastore
    //   64: invokestatic 367	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   67: invokevirtual 371	com/tencent/mm/modelcontrol/e:bIp	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   70: astore 14
    //   72: aload 14
    //   74: getfield 374	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   77: istore_3
    //   78: aload 14
    //   80: getfield 375	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   83: istore 4
    //   85: ldc 59
    //   87: new 89	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 377
    //   94: invokespecial 379	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: iload 6
    //   99: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 384
    //   105: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 7
    //   110: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc_w 386
    //   116: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_3
    //   120: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc_w 388
    //   126: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload 4
    //   131: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc_w 390
    //   137: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 392	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iload 6
    //   148: iload_3
    //   149: if_icmpgt +277 -> 426
    //   152: iload 7
    //   154: iload 4
    //   156: if_icmpgt +270 -> 426
    //   159: ldc 59
    //   161: ldc_w 394
    //   164: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aconst_null
    //   168: astore 11
    //   170: aload 11
    //   172: ifnull +21 -> 193
    //   175: aload 13
    //   177: iconst_0
    //   178: aload 11
    //   180: getfield 399	android/graphics/Point:x	I
    //   183: iastore
    //   184: aload 13
    //   186: iconst_1
    //   187: aload 11
    //   189: getfield 402	android/graphics/Point:y	I
    //   192: iastore
    //   193: ldc 59
    //   195: ldc_w 404
    //   198: bipush 6
    //   200: anewarray 63	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: iload 6
    //   207: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: iload 7
    //   215: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: dup
    //   220: iconst_2
    //   221: aload 14
    //   223: getfield 374	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   226: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_3
    //   232: aload 14
    //   234: getfield 375	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   237: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: dup
    //   242: iconst_4
    //   243: aload 13
    //   245: iconst_0
    //   246: iaload
    //   247: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: aastore
    //   251: dup
    //   252: iconst_5
    //   253: aload 13
    //   255: iconst_1
    //   256: iaload
    //   257: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload 12
    //   266: invokevirtual 333	android/media/MediaMetadataRetriever:release	()V
    //   269: aload 13
    //   271: iconst_0
    //   272: iaload
    //   273: istore_3
    //   274: aload 13
    //   276: iconst_1
    //   277: iaload
    //   278: istore 4
    //   280: new 89	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   287: invokestatic 414	com/tencent/mm/loader/i/b:bmL	()Ljava/lang/String;
    //   290: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 416
    //   296: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokestatic 422	java/lang/System:currentTimeMillis	()J
    //   302: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 424
    //   308: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 11
    //   316: invokestatic 367	com/tencent/mm/modelcontrol/e:bIg	()Lcom/tencent/mm/modelcontrol/e;
    //   319: invokevirtual 371	com/tencent/mm/modelcontrol/e:bIp	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   322: astore 12
    //   324: ldc 59
    //   326: ldc_w 426
    //   329: iconst_1
    //   330: anewarray 63	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload 12
    //   337: getfield 429	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   340: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: new 431	java/util/concurrent/CountDownLatch
    //   350: dup
    //   351: iconst_1
    //   352: invokespecial 433	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   355: astore 13
    //   357: getstatic 439	com/tencent/mm/media/i/c:nBL	Lcom/tencent/mm/media/i/c$a;
    //   360: aload_0
    //   361: aload 11
    //   363: iload_3
    //   364: iload 4
    //   366: aload 12
    //   368: getfield 429	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   371: aload 12
    //   373: getfield 442	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   376: aload 12
    //   378: getfield 445	com/tencent/mm/modelcontrol/VideoTransPara:nxU	I
    //   381: aload 12
    //   383: getfield 448	com/tencent/mm/modelcontrol/VideoTransPara:nxV	I
    //   386: new 17	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5
    //   389: dup
    //   390: aload 13
    //   392: invokespecial 451	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5:<init>	(Ljava/util/concurrent/CountDownLatch;)V
    //   395: invokeinterface 456 10 0
    //   400: invokevirtual 460	com/tencent/mm/media/i/c:bpE	()I
    //   403: pop
    //   404: ldc 59
    //   406: ldc_w 462
    //   409: invokestatic 392	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: aload 13
    //   414: invokevirtual 465	java/util/concurrent/CountDownLatch:await	()V
    //   417: ldc_w 361
    //   420: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload 11
    //   425: areturn
    //   426: iload 6
    //   428: iload 7
    //   430: invokestatic 471	java/lang/Math:max	(II)I
    //   433: istore 10
    //   435: iload 6
    //   437: iload 7
    //   439: invokestatic 474	java/lang/Math:min	(II)I
    //   442: istore 9
    //   444: iload_3
    //   445: iload 4
    //   447: invokestatic 471	java/lang/Math:max	(II)I
    //   450: istore 5
    //   452: iload_3
    //   453: iload 4
    //   455: invokestatic 474	java/lang/Math:min	(II)I
    //   458: istore 8
    //   460: iload 10
    //   462: bipush 16
    //   464: irem
    //   465: ifne +51 -> 516
    //   468: iload 10
    //   470: iload 5
    //   472: isub
    //   473: invokestatic 478	java/lang/Math:abs	(I)I
    //   476: bipush 16
    //   478: if_icmpge +38 -> 516
    //   481: iload 9
    //   483: bipush 16
    //   485: irem
    //   486: ifne +30 -> 516
    //   489: iload 9
    //   491: iload 8
    //   493: isub
    //   494: invokestatic 478	java/lang/Math:abs	(I)I
    //   497: bipush 16
    //   499: if_icmpge +17 -> 516
    //   502: ldc 59
    //   504: ldc_w 480
    //   507: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aconst_null
    //   511: astore 11
    //   513: goto -343 -> 170
    //   516: iload 10
    //   518: iconst_2
    //   519: idiv
    //   520: istore 10
    //   522: iload 9
    //   524: iconst_2
    //   525: idiv
    //   526: istore 9
    //   528: iload 10
    //   530: bipush 16
    //   532: irem
    //   533: ifne +107 -> 640
    //   536: iload 10
    //   538: iload 5
    //   540: isub
    //   541: invokestatic 478	java/lang/Math:abs	(I)I
    //   544: bipush 16
    //   546: if_icmpge +94 -> 640
    //   549: iload 9
    //   551: bipush 16
    //   553: irem
    //   554: ifne +86 -> 640
    //   557: iload 9
    //   559: iload 8
    //   561: isub
    //   562: invokestatic 478	java/lang/Math:abs	(I)I
    //   565: bipush 16
    //   567: if_icmpge +73 -> 640
    //   570: ldc 59
    //   572: ldc_w 482
    //   575: invokestatic 228	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: iload 6
    //   580: iconst_2
    //   581: idiv
    //   582: istore_3
    //   583: iload 7
    //   585: iconst_2
    //   586: idiv
    //   587: istore 4
    //   589: iload_3
    //   590: iconst_2
    //   591: irem
    //   592: ifeq +197 -> 789
    //   595: iload_3
    //   596: iconst_1
    //   597: iadd
    //   598: istore_3
    //   599: goto +190 -> 789
    //   602: new 396	android/graphics/Point
    //   605: dup
    //   606: iload_3
    //   607: iload 4
    //   609: invokespecial 485	android/graphics/Point:<init>	(II)V
    //   612: astore 11
    //   614: goto -444 -> 170
    //   617: astore_0
    //   618: aload 12
    //   620: astore 11
    //   622: aload 11
    //   624: ifnull +8 -> 632
    //   627: aload 11
    //   629: invokevirtual 333	android/media/MediaMetadataRetriever:release	()V
    //   632: ldc_w 361
    //   635: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: aload_0
    //   639: athrow
    //   640: new 396	android/graphics/Point
    //   643: dup
    //   644: invokespecial 486	android/graphics/Point:<init>	()V
    //   647: astore 11
    //   649: iload 6
    //   651: iload 7
    //   653: if_icmpge +75 -> 728
    //   656: iload_3
    //   657: iload 4
    //   659: invokestatic 474	java/lang/Math:min	(II)I
    //   662: istore_3
    //   663: dconst_1
    //   664: iload 6
    //   666: i2d
    //   667: dmul
    //   668: iload_3
    //   669: i2d
    //   670: ddiv
    //   671: dstore_1
    //   672: iload 7
    //   674: i2d
    //   675: dload_1
    //   676: ddiv
    //   677: d2i
    //   678: istore 4
    //   680: goto +125 -> 805
    //   683: ldc 59
    //   685: ldc_w 488
    //   688: iconst_2
    //   689: anewarray 63	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: iload 4
    //   696: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: iload 5
    //   704: invokestatic 409	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: aastore
    //   708: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   711: aload 11
    //   713: iload 4
    //   715: putfield 399	android/graphics/Point:x	I
    //   718: aload 11
    //   720: iload 5
    //   722: putfield 402	android/graphics/Point:y	I
    //   725: goto -555 -> 170
    //   728: iload_3
    //   729: iload 4
    //   731: invokestatic 474	java/lang/Math:min	(II)I
    //   734: istore 4
    //   736: dconst_1
    //   737: iload 7
    //   739: i2d
    //   740: dmul
    //   741: iload 4
    //   743: i2d
    //   744: ddiv
    //   745: dstore_1
    //   746: iload 6
    //   748: i2d
    //   749: dload_1
    //   750: ddiv
    //   751: d2i
    //   752: istore_3
    //   753: goto +52 -> 805
    //   756: astore_0
    //   757: ldc 59
    //   759: ldc_w 490
    //   762: iconst_1
    //   763: anewarray 63	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload_0
    //   769: invokevirtual 493	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   772: aastore
    //   773: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: goto -359 -> 417
    //   779: astore_0
    //   780: aconst_null
    //   781: astore 11
    //   783: goto -161 -> 622
    //   786: goto -184 -> 602
    //   789: iload 4
    //   791: iconst_2
    //   792: irem
    //   793: ifeq -7 -> 786
    //   796: iload 4
    //   798: iconst_1
    //   799: iadd
    //   800: istore 4
    //   802: goto -200 -> 602
    //   805: iload 4
    //   807: istore 5
    //   809: iload 4
    //   811: iconst_2
    //   812: irem
    //   813: ifeq +9 -> 822
    //   816: iload 4
    //   818: iconst_1
    //   819: iadd
    //   820: istore 5
    //   822: iload_3
    //   823: istore 4
    //   825: iload_3
    //   826: iconst_2
    //   827: irem
    //   828: ifeq -145 -> 683
    //   831: iload_3
    //   832: iconst_1
    //   833: iadd
    //   834: istore 4
    //   836: goto -153 -> 683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	839	0	paramString	String
    //   671	79	1	d	double
    //   77	757	3	i	int
    //   83	752	4	j	int
    //   450	371	5	k	int
    //   37	710	6	m	int
    //   50	688	7	n	int
    //   458	104	8	i1	int
    //   442	120	9	i2	int
    //   433	108	10	i3	int
    //   168	614	11	localObject1	Object
    //   18	601	12	localObject2	Object
    //   9	404	13	localObject3	Object
    //   70	163	14	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
    // Exception table:
    //   from	to	target	type
    //   20	52	617	finally
    //   64	146	617	finally
    //   159	167	617	finally
    //   175	193	617	finally
    //   193	264	617	finally
    //   426	460	617	finally
    //   468	481	617	finally
    //   489	510	617	finally
    //   516	528	617	finally
    //   536	549	617	finally
    //   557	589	617	finally
    //   602	614	617	finally
    //   640	649	617	finally
    //   656	680	617	finally
    //   683	725	617	finally
    //   728	736	617	finally
    //   404	417	756	java/lang/InterruptedException
    //   11	20	779	finally
  }
  
  private static String aaV(String paramString)
  {
    AppMethodBeat.i(46520);
    String str2 = "";
    String str1 = str2;
    if (!Util.isNullOrNil(paramString))
    {
      Object localObject = new u(paramString);
      str1 = str2;
      if (((u)localObject).jKS())
      {
        localObject = ((u)localObject).getName();
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
          if ((b.bmL() != null) && (b.bmL().endsWith("/"))) {
            str1 = b.bmL() + str1 + System.currentTimeMillis() + ".jpeg";
          }
        }
        for (;;)
        {
          if (new u(str1).jKS()) {
            break label341;
          }
          Log.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", new Object[] { str1 });
          paramString = BitmapUtil.createVideoThumbnail(paramString, 2);
          if (paramString != null) {
            break;
          }
          Log.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
          AppMethodBeat.o(46520);
          return "";
          str1 = b.bmL() + "/" + str1 + System.currentTimeMillis() + ".jpeg";
          continue;
          str1 = "microMsg_" + System.currentTimeMillis();
          str1 = b.bmL() + str1 + ".jpeg";
        }
      }
    }
    for (;;)
    {
      try
      {
        BitmapUtil.saveBitmapToImage(paramString, 80, Bitmap.CompressFormat.JPEG, str1, true);
        AppMethodBeat.o(46520);
        return str1;
      }
      catch (IOException paramString)
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + paramString.getMessage());
        continue;
      }
      label341:
      Log.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", new Object[] { str1 });
    }
  }
  
  private static String aaW(String paramString)
  {
    AppMethodBeat.i(46523);
    String str = y.n(b.bmL() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(46523);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = BitmapUtil.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          Bitmap localBitmap3 = BitmapUtil.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        Object localObject4 = null;
      }
      long l = Util.nowMilliSecond();
      boolean bool = i.fs(str, paramString);
      Log.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.nowMilliSecond() - l), paramString, Long.valueOf(y.bEl(paramString)), str, Long.valueOf(y.bEl(str)) });
      if (bool)
      {
        AppMethodBeat.o(46523);
        return str;
      }
      AppMethodBeat.o(46523);
    }
    return paramString;
  }
  
  private static String aaX(String paramString)
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
          Log.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
          AppMethodBeat.o(46524);
          return paramString;
        }
        float f = i % 360;
        Bitmap localBitmap = BitmapUtil.rotate((Bitmap)localObject1, f);
        Object localObject2 = new StringBuilder().append(b.bmL()).append("microMsg.tmp.").append(System.currentTimeMillis());
        if (i.a(localOptions))
        {
          localObject1 = ".jpg";
          localObject2 = (String)localObject1;
          if (!i.a(localOptions)) {
            break label172;
          }
        }
        for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
        {
          try
          {
            BitmapUtil.saveBitmapToImage(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
            if (i.a(localOptions)) {
              c.dM(paramString, (String)localObject2);
            }
            AppMethodBeat.o(46524);
            return localObject2;
          }
          catch (Exception localException)
          {
            label172:
            Log.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            y.deleteFile((String)localObject2);
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
  
  private Intent cti()
  {
    AppMethodBeat.i(46513);
    Intent localIntent = new Intent();
    localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
    localIntent.putExtra("album_video_max_duration", this.sgt.qqa);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_distance", this.sgt.sgn);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.sgt.latitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.sgt.longitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_posname", this.sgt.poiName);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("send_btn_string", getString(ba.i.app_nextstep));
    localIntent.putExtra("gallery_report_tag", 18);
    AppMethodBeat.o(46513);
    return localIntent;
  }
  
  private static BackwardSupportUtil.ExifHelper.LatLongData ctj()
  {
    AppMethodBeat.i(46515);
    Object localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).getString("locStr", null);
    String[] arrayOfString;
    float f1;
    float f2;
    if (localObject != null)
    {
      arrayOfString = ((String)localObject).split(",");
      f1 = Util.getInt(arrayOfString[0], 0) / 1000000.0F;
      f2 = Util.getInt(arrayOfString[1], 0) / 1000000.0F;
      Log.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", new Object[] { localObject, Float.valueOf(f1), Float.valueOf(f2) });
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
    }
    for (;;)
    {
      AppMethodBeat.o(46515);
      return localObject;
      localObject = (String)h.baE().ban().d(67591, null);
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
            Log.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", new Object[] { Integer.valueOf(i), localObject, Float.valueOf(f1), Float.valueOf(f2) });
            localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", new Object[] { localException });
            str = null;
          }
          break;
          label297:
          str = "gps";
        }
      }
      Log.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
      Log.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
      String str = null;
    }
  }
  
  private void ctk()
  {
    AppMethodBeat.i(46516);
    this.sfD = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(46509);
        Log.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
        JsApiChooseMultiMedia.a.this.sgu.resultCode = 0;
        JsApiChooseMultiMedia.a.h(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
        AppMethodBeat.o(46509);
      }
    };
    MMActivity localMMActivity = getActivityContext();
    getString(ba.i.app_tip);
    this.lKp = k.a(localMMActivity, getString(ba.i.app_brand_choose_media_video_processing), true, this.sfD);
    AppMethodBeat.o(46516);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    int k = 3;
    int j = 0;
    AppMethodBeat.i(46512);
    this.sgt = ((JsApiChooseMultiMedia.ChooseRequest)paramProcessRequest);
    int i;
    boolean bool;
    if (Util.getAvailableMemoryMB(getActivityContext()) > 200L)
    {
      i = 1;
      if (i == 0) {
        aa.makeText(getActivityContext(), getString(ba.i.app_brand_choose_media_memory_check_message), 1).show();
      }
      getActivityContext().mmSetOnActivityResultCallback(this);
      if (this.sgt.sgq != 1) {
        break label158;
      }
      bool = true;
      i = k;
    }
    for (;;)
    {
      if ((this.sgt.sft) && (this.sgt.sfu))
      {
        paramProcessRequest = cti();
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        t.a(getActivityContext(), 1, this.sgt.count, this.sfB, paramProcessRequest);
        AppMethodBeat.o(46512);
        return;
        i = 0;
        break;
        label158:
        if (this.sgt.sgq == 2)
        {
          i = 1;
          bool = false;
          continue;
        }
        if (this.sgt.sgq != 3) {
          break label460;
        }
        i = 2;
        bool = false;
        continue;
      }
      if (this.sgt.sfu)
      {
        paramProcessRequest = cti();
        paramProcessRequest.putExtra("show_header_view", false);
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        t.a(getActivityContext(), 1, this.sgt.count, this.sfB, paramProcessRequest);
        AppMethodBeat.o(46512);
        return;
      }
      if (this.sgt.sft)
      {
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_latitude", this.sgt.latitude);
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_longitude", this.sgt.longitude);
        if ((this.sgt.sgo) && (!this.sgt.sgp)) {
          i = 1;
        }
        for (;;)
        {
          SightParams localSightParams = new SightParams(7, 1);
          localSightParams.mode = i;
          localSightParams.nLH.duration = this.sgt.qqa;
          paramProcessRequest.putExtra("KEY_SIGHT_PARAMS", localSightParams);
          t.a(getActivityContext(), 2, paramProcessRequest, 7, i);
          AppMethodBeat.o(46512);
          return;
          i = j;
          if (this.sgt.sgp)
          {
            i = j;
            if (!this.sgt.sgo) {
              i = 2;
            }
          }
        }
      }
      Log.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
      this.sgu.resultCode = -2;
      finishProcess(this.sgu);
      AppMethodBeat.o(46512);
      return;
      label460:
      bool = false;
      i = k;
    }
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    final double d2 = 91.0D;
    final boolean bool1 = true;
    AppMethodBeat.i(46514);
    if (paramInt2 == 0)
    {
      this.sgu.resultCode = 0;
      finishProcess(this.sgu);
      AppMethodBeat.o(46514);
      return;
    }
    if (paramIntent != null) {}
    for (double d1 = paramIntent.getDoubleExtra("longitude", 181.0D);; d1 = 181.0D)
    {
      if (paramIntent != null) {
        d2 = paramIntent.getDoubleExtra("latitude", 91.0D);
      }
      Log.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
      Log.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        this.sgu.resultCode = -2;
        finishProcess(this.sgu);
        AppMethodBeat.o(46514);
        return;
      }
    }
    Log.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
    if (paramIntent == null)
    {
      this.sgu.resultCode = 0;
      finishProcess(this.sgu);
      AppMethodBeat.o(46514);
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
    final ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_select_video_list");
    final boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
    ctk();
    if (!bool2) {
      if (!Util.isNullOrNil((List)localObject))
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
      o.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46506);
          JSONArray localJSONArray = new JSONArray();
          Object localObject5;
          Object localObject1;
          long l2;
          long l1;
          double d;
          Object localObject6;
          boolean bool;
          if ((this.sgv != null) && (this.sgv.size() > 0))
          {
            localObject5 = this.sgv.iterator();
            for (;;)
            {
              if (((Iterator)localObject5).hasNext())
              {
                localObject1 = (String)((Iterator)localObject5).next();
                if ((!Util.isNullOrNil((String)localObject1)) && (new u((String)localObject1).jKS()))
                {
                  Log.i("MicroMsg.JsApiChooseMultiMedia", "local img file exist, success");
                  l2 = 0L;
                  l1 = l2;
                  try
                  {
                    localObject3 = BackwardSupportUtil.ExifHelper.getExifTime((String)localObject1);
                    l1 = l2;
                    if (localObject3 != null)
                    {
                      l1 = l2;
                      l2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse((String)localObject3).getTime() / 1000L;
                      l1 = l2;
                      Log.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, imgPath: %s.", new Object[] { Long.valueOf(l2), localObject1 });
                      l1 = l2;
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Object localObject3;
                      Log.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, imgPath: %s.", new Object[] { localException1 });
                      continue;
                      Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. imgPath: %s.", new Object[] { localException1 });
                      continue;
                      Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. imgPath: %s.", new Object[] { localException1 });
                    }
                  }
                  d = -1.0D;
                  if ((a.D(d2)) && (a.C(bool2)))
                  {
                    localObject3 = BackwardSupportUtil.ExifHelper.getExifLatLong((String)localObject1);
                    if (localObject3 != null)
                    {
                      d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject3).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject3).longtitude, d2, bool2);
                      localObject6 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                      if (!localArrayList) {
                        break label492;
                      }
                      localObject1 = JsApiChooseMultiMedia.a.aaY((String)localObject1);
                      bool = true;
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            Object localObject7;
            for (;;)
            {
              localObject3 = JsApiChooseMultiMedia.aaT((String)localObject1);
              localObject7 = AppBrandLocalMediaObjectManager.m(JsApiChooseMultiMedia.a.this.sgt.appId, (String)localObject1, bool);
              if (localObject7 == null) {
                break label526;
              }
              try
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("type", "image");
                ((JSONObject)localObject1).put("tempFilePath", ((AppBrandLocalMediaObject)localObject7).hHB);
                ((JSONObject)localObject1).put("size", ((AppBrandLocalMediaObject)localObject7).fileLength);
                ((JSONObject)localObject1).put("width", ((JsApiChooseMultiMedia.b)localObject3).width);
                ((JSONObject)localObject1).put("height", ((JsApiChooseMultiMedia.b)localObject3).height);
                ((JSONObject)localObject1).put("orientation", ((JsApiChooseMultiMedia.b)localObject3).euP);
                ((JSONObject)localObject1).put("mark", localObject6);
                ((JSONObject)localObject1).put("scene", "album");
                localJSONArray.put(localObject1);
              }
              catch (Exception localException1)
              {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException1, "", new Object[0]);
              }
            }
            break;
            label492:
            if (this.sfI)
            {
              Object localObject4 = JsApiChooseMultiMedia.a.aaZ(localException1);
              if (!((String)localObject4).equals(localException1))
              {
                bool = true;
                Object localObject2 = localObject4;
                continue;
                Log.e("MicroMsg.JsApiChooseMultiMedia", "handle chosen list from gallery, get null obj from path: %s", new Object[] { localObject2 });
                break;
                if ((this.sgw != null) && (this.sgw.size() > 0))
                {
                  localObject4 = this.sgw.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject2 = (String)((Iterator)localObject4).next();
                    if ((!Util.isNullOrNil((String)localObject2)) && (new u((String)localObject2).jKS()))
                    {
                      Log.i("MicroMsg.JsApiChooseMultiMedia", "local video file exist, success");
                      l2 = 0L;
                      l1 = l2;
                      try
                      {
                        localObject5 = BackwardSupportUtil.getVideoTakeTime((String)localObject2);
                        l1 = l2;
                        if (localObject5 != null)
                        {
                          l1 = l2;
                          long l3 = new SimpleDateFormat("yyyyMMdd'T'hhmmss.SSS'Z'").parse((String)localObject5).getTime();
                          l1 = l2;
                          localObject5 = Calendar.getInstance(TimeZone.getDefault());
                          l1 = l2;
                          int i = ((Calendar)localObject5).get(15);
                          l1 = l2;
                          int j = ((Calendar)localObject5).get(16);
                          l1 = l2;
                          localObject5 = Calendar.getInstance();
                          l1 = l2;
                          ((Calendar)localObject5).setTimeInMillis(l3);
                          l1 = l2;
                          ((Calendar)localObject5).add(14, i + j);
                          l1 = l2;
                          l2 = ((Calendar)localObject5).getTimeInMillis() / 1000L;
                          l1 = l2;
                          Log.d("MicroMsg.JsApiChooseMultiMedia", "parse result time: %d, videoPath: %s.", new Object[] { Long.valueOf(l2), localObject2 });
                          l1 = l2;
                        }
                        d = -1.0D;
                        if ((a.D(d2)) && (a.C(bool2)))
                        {
                          localObject5 = BackwardSupportUtil.getVideoLatLong((String)localObject2);
                          if (localObject5 != null)
                          {
                            d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject5).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject5).longtitude, d2, bool2);
                            localObject5 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l1, d);
                            localObject6 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, (String)localObject2, true);
                            if (localObject6 != null) {
                              break label996;
                            }
                            Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail, mVideoFilePath is %s", new Object[] { localObject2 });
                            JsApiChooseMultiMedia.a.this.sgu.resultCode = -2;
                            JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
                            AppMethodBeat.o(46506);
                            return;
                          }
                        }
                      }
                      catch (Exception localException4)
                      {
                        for (;;)
                        {
                          Log.e("MicroMsg.JsApiChooseMultiMedia", "parse from Date String error, videoPath: %s.", new Object[] { localObject2 });
                          continue;
                          Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. videoPath: %s.", new Object[] { localObject2 });
                          continue;
                          Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. videoPath: %s.", new Object[] { localObject2 });
                        }
                        localObject7 = JsApiChooseMultiMedia.a.aba((String)localObject2);
                        localObject2 = "";
                        if (!Util.isNullOrNil((String)localObject7)) {
                          localObject2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, (String)localObject7);
                        }
                        try
                        {
                          localObject7 = new JSONObject();
                          ((JSONObject)localObject7).put("type", "video");
                          ((JSONObject)localObject7).put("tempFilePath", ((AppBrandLocalVideoObject)localObject6).hHB);
                          ((JSONObject)localObject7).put("size", ((AppBrandLocalVideoObject)localObject6).size);
                          ((JSONObject)localObject7).put("width", ((AppBrandLocalVideoObject)localObject6).width);
                          ((JSONObject)localObject7).put("height", ((AppBrandLocalVideoObject)localObject6).height);
                          ((JSONObject)localObject7).put("duration", ((AppBrandLocalVideoObject)localObject6).duration);
                          ((JSONObject)localObject7).put("thumbTempFilePath", localObject2);
                          ((JSONObject)localObject7).put("mark", localException4);
                          ((JSONObject)localObject7).put("scene", "album");
                          localJSONArray.put(localObject7);
                        }
                        catch (Exception localException2)
                        {
                          Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", localException2, "", new Object[0]);
                        }
                      }
                    }
                  }
                }
                JsApiChooseMultiMedia.a.this.sgu.resultCode = -1;
                JsApiChooseMultiMedia.a.this.sgu.sgs = localJSONArray.toString();
                JsApiChooseMultiMedia.a.b(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
                AppMethodBeat.o(46506);
                return;
              }
            }
            label526:
            label996:
            bool = false;
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
    Log.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
    if (paramIntent == null)
    {
      this.sgu.resultCode = 0;
      finishProcess(this.sgu);
      AppMethodBeat.o(46514);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
    localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
      this.sgu.resultCode = -2;
      finishProcess(this.sgu);
      AppMethodBeat.o(46514);
      return;
    }
    if (((SightCaptureResult)localObject).KTL)
    {
      localObject = ((SightCaptureResult)localObject).KTT;
      if ((Util.isNullOrNil((String)localObject)) || (!y.ZC((String)localObject)))
      {
        Log.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
        this.sgu.resultCode = -2;
        finishProcess(this.sgu);
        AppMethodBeat.o(46514);
        return;
      }
      Log.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", new Object[] { localObject });
      bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      ctk();
      o.cNm().postToWorker(new Runnable()
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
            localObject1 = JsApiChooseMultiMedia.a.aaY(this.val$filePath);
            localb = JsApiChooseMultiMedia.aaT((String)localObject1);
            localObject1 = AppBrandLocalMediaObjectManager.m(JsApiChooseMultiMedia.a.this.sgt.appId, (String)localObject1, bool1 | true);
            if ((localObject1 == null) || (localb == null)) {
              break label270;
            }
            l = Calendar.getInstance().getTimeInMillis() / 1000L;
            d = -1.0D;
            if ((!a.D(d2)) || (!a.C(this.oEH))) {
              break label249;
            }
            localObject2 = JsApiChooseMultiMedia.a.ctl();
            if (localObject2 == null) {
              break label228;
            }
            d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).longtitude, d2, this.oEH);
          }
          for (;;)
          {
            localObject2 = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
            Log.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
            JsApiChooseMultiMedia.a.this.sgu.resultCode = -1;
            JsApiChooseMultiMedia.a.this.sgu.sgs = JsApiChooseMultiMedia.a.b(((AppBrandLocalMediaObject)localObject1).hHB, ((AppBrandLocalMediaObject)localObject1).fileLength, localb.width, localb.height, localb.euP, (String)localObject2);
            JsApiChooseMultiMedia.a.c(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
            AppMethodBeat.o(46507);
            return;
            localObject1 = this.val$filePath;
            break;
            label228:
            Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", new Object[] { this.val$filePath });
            continue;
            label249:
            Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", new Object[] { this.val$filePath });
          }
          label270:
          Log.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
          JsApiChooseMultiMedia.a.this.sgu.resultCode = -2;
          JsApiChooseMultiMedia.a.d(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
          AppMethodBeat.o(46507);
        }
      });
      AppMethodBeat.o(46514);
      return;
    }
    paramIntent = ((SightCaptureResult)localObject).KTN;
    if (Util.isNullOrNil(paramIntent))
    {
      Log.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
      this.sgu.resultCode = -2;
      finishProcess(this.sgu);
      AppMethodBeat.o(46514);
      return;
    }
    Log.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", new Object[] { paramIntent });
    ctk();
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46508);
        AppBrandLocalVideoObject localAppBrandLocalVideoObject;
        if (new u(paramIntent).jKS())
        {
          Log.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
          JsApiChooseMultiMedia.a.this.sgu.resultCode = -1;
          localAppBrandLocalVideoObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, paramIntent, false);
          if (localAppBrandLocalVideoObject == null)
          {
            Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { paramIntent });
            JsApiChooseMultiMedia.a.this.sgu.resultCode = -2;
            JsApiChooseMultiMedia.a.e(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
            AppMethodBeat.o(46508);
            return;
          }
          str = JsApiChooseMultiMedia.a.aba(paramIntent);
          if (Util.isNullOrNil(str)) {
            break label371;
          }
        }
        label371:
        for (String str = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, str);; str = "")
        {
          long l = Calendar.getInstance().getTimeInMillis() / 1000L;
          double d = -1.0D;
          Object localObject;
          if ((a.D(d2)) && (a.C(this.oEH)))
          {
            localObject = JsApiChooseMultiMedia.a.ctl();
            if (localObject != null) {
              d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude, d2, this.oEH);
            }
          }
          for (;;)
          {
            localObject = JsApiChooseMultiMedia.a.a(JsApiChooseMultiMedia.a.this, l, d);
            JsApiChooseMultiMedia.a.this.sgu.sgs = JsApiChooseMultiMedia.a.b(localAppBrandLocalVideoObject.hHB, localAppBrandLocalVideoObject.size, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.duration, str, (String)localObject);
            JsApiChooseMultiMedia.a.f(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
            AppMethodBeat.o(46508);
            return;
            Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", new Object[] { paramIntent });
            continue;
            Log.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", new Object[] { paramIntent });
          }
          Log.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { paramIntent });
          JsApiChooseMultiMedia.a.this.sgu.resultCode = -2;
          JsApiChooseMultiMedia.a.g(JsApiChooseMultiMedia.a.this, JsApiChooseMultiMedia.a.this.sgu);
          AppMethodBeat.o(46508);
          return;
        }
      }
    });
    AppMethodBeat.o(46514);
  }
  
  public final void onProcessInterrupted()
  {
    AppMethodBeat.i(46517);
    super.onProcessInterrupted();
    if (this.lKp != null)
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(46517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a
 * JD-Core Version:    0.7.0.1
 */