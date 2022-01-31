package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsApiChooseMultiMedia$a
  extends AppBrandProxyUIProcessTask
{
  private p ehb;
  int hQK;
  private DialogInterface.OnCancelListener hQL;
  JsApiChooseMultiMedia.ChooseRequest hRy;
  JsApiChooseMultiMedia.ChooseResult hRz;
  
  private JsApiChooseMultiMedia$a()
  {
    AppMethodBeat.i(131235);
    this.hRz = new JsApiChooseMultiMedia.ChooseResult();
    this.hQK = 7;
    AppMethodBeat.o(131235);
  }
  
  private static String Cn(String paramString)
  {
    AppMethodBeat.i(131248);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    if (i != 0) {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        Object localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
        if (localObject1 == null)
        {
          ab.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
          AppMethodBeat.o(131248);
          return paramString;
        }
        float f = i % 360;
        Bitmap localBitmap = d.b((Bitmap)localObject1, f);
        Object localObject2 = new StringBuilder().append(com.tencent.mm.compatible.util.e.esr).append("microMsg.tmp.").append(System.currentTimeMillis());
        if (c.b(localOptions))
        {
          localObject1 = ".jpg";
          localObject2 = (String)localObject1;
          if (!c.b(localOptions)) {
            break label164;
          }
        }
        for (localObject1 = Bitmap.CompressFormat.JPEG;; localObject1 = Bitmap.CompressFormat.PNG)
        {
          try
          {
            d.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
            if (c.b(localOptions)) {
              b.bZ(paramString, (String)localObject2);
            }
            AppMethodBeat.o(131248);
            return localObject2;
          }
          catch (Exception localException)
          {
            label164:
            ab.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", new Object[] { localException });
            com.tencent.mm.a.e.deleteFile((String)localObject2);
            AppMethodBeat.o(131248);
            return paramString;
          }
          localObject1 = ".png";
          break;
        }
        AppMethodBeat.o(131248);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        AppMethodBeat.o(131248);
        return paramString;
      }
      catch (NullPointerException localNullPointerException)
      {
        AppMethodBeat.o(131248);
        return paramString;
      }
    }
    return paramString;
  }
  
  private static String Co(String paramString)
  {
    AppMethodBeat.i(131247);
    String str = com.tencent.mm.compatible.util.e.esr + "microMsg." + System.currentTimeMillis() + ".jpg";
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(131247);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = d.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          Bitmap localBitmap3 = d.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        Object localObject4 = null;
      }
      long l = bo.aoy();
      boolean bool = c.cW(str, paramString);
      ab.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bo.aoy() - l), paramString, Long.valueOf(new File(paramString).length()), str, Long.valueOf(new File(str).length()) });
      if (bool)
      {
        AppMethodBeat.o(131247);
        return str;
      }
      AppMethodBeat.o(131247);
    }
    return paramString;
  }
  
  /* Error */
  private static String Cu(String paramString)
  {
    // Byte code:
    //   0: ldc 214
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: newarray int
    //   8: astore 13
    //   10: new 216	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 217	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore 12
    //   19: aload 12
    //   21: aload_0
    //   22: invokevirtual 220	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload 12
    //   27: bipush 18
    //   29: invokevirtual 224	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   32: iconst_0
    //   33: invokestatic 228	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   36: istore 6
    //   38: aload 12
    //   40: bipush 19
    //   42: invokevirtual 224	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   45: iconst_0
    //   46: invokestatic 228	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   49: istore 7
    //   51: aload 13
    //   53: iconst_0
    //   54: iload 6
    //   56: iastore
    //   57: aload 13
    //   59: iconst_1
    //   60: iload 7
    //   62: iastore
    //   63: invokestatic 234	com/tencent/mm/modelcontrol/d:afW	()Lcom/tencent/mm/modelcontrol/d;
    //   66: invokevirtual 238	com/tencent/mm/modelcontrol/d:agb	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   69: astore 14
    //   71: aload 14
    //   73: getfield 243	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   76: istore_3
    //   77: aload 14
    //   79: getfield 246	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   82: istore 4
    //   84: ldc 69
    //   86: new 85	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 248
    //   92: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: iload 6
    //   97: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc 254
    //   102: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload 7
    //   107: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc_w 256
    //   113: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_3
    //   117: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc_w 258
    //   123: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 4
    //   128: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc_w 260
    //   134: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 263	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: iload 6
    //   145: iload_3
    //   146: if_icmpgt +265 -> 411
    //   149: iload 7
    //   151: iload 4
    //   153: if_icmpgt +258 -> 411
    //   156: ldc 69
    //   158: ldc_w 265
    //   161: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aconst_null
    //   165: astore 11
    //   167: aload 11
    //   169: ifnull +21 -> 190
    //   172: aload 13
    //   174: iconst_0
    //   175: aload 11
    //   177: getfield 272	android/graphics/Point:x	I
    //   180: iastore
    //   181: aload 13
    //   183: iconst_1
    //   184: aload 11
    //   186: getfield 275	android/graphics/Point:y	I
    //   189: iastore
    //   190: ldc 69
    //   192: ldc_w 277
    //   195: bipush 6
    //   197: anewarray 141	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: iload 6
    //   204: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: iload 7
    //   212: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: dup
    //   217: iconst_2
    //   218: aload 14
    //   220: getfield 243	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   223: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: aastore
    //   227: dup
    //   228: iconst_3
    //   229: aload 14
    //   231: getfield 246	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   234: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_4
    //   240: aload 13
    //   242: iconst_0
    //   243: iaload
    //   244: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_5
    //   250: aload 13
    //   252: iconst_1
    //   253: iaload
    //   254: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload 12
    //   263: invokevirtual 287	android/media/MediaMetadataRetriever:release	()V
    //   266: aload 13
    //   268: iconst_0
    //   269: iaload
    //   270: istore_3
    //   271: aload 13
    //   273: iconst_1
    //   274: iaload
    //   275: istore 4
    //   277: new 85	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   284: getstatic 92	com/tencent/mm/compatible/util/e:esr	Ljava/lang/String;
    //   287: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 154
    //   292: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   298: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: ldc_w 289
    //   304: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: astore 11
    //   312: invokestatic 234	com/tencent/mm/modelcontrol/d:afW	()Lcom/tencent/mm/modelcontrol/d;
    //   315: invokevirtual 238	com/tencent/mm/modelcontrol/d:agb	()Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   318: astore 12
    //   320: ldc 69
    //   322: ldc_w 291
    //   325: iconst_1
    //   326: anewarray 141	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload 12
    //   333: getfield 294	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   336: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: invokestatic 284	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: new 296	java/util/concurrent/CountDownLatch
    //   346: dup
    //   347: iconst_1
    //   348: invokespecial 298	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   351: astore 13
    //   353: getstatic 304	com/tencent/mm/media/g/d:eWu	Lcom/tencent/mm/media/g/d$a;
    //   356: aload_0
    //   357: aload 11
    //   359: iload_3
    //   360: iload 4
    //   362: aload 12
    //   364: getfield 294	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   367: aload 12
    //   369: getfield 307	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   372: new 309	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5
    //   375: dup
    //   376: aload 13
    //   378: invokespecial 312	com/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseMultiMedia$a$5:<init>	(Ljava/util/concurrent/CountDownLatch;)V
    //   381: invokeinterface 317 8 0
    //   386: invokevirtual 320	com/tencent/mm/media/g/d:Va	()I
    //   389: pop
    //   390: ldc 69
    //   392: ldc_w 322
    //   395: invokestatic 263	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload 13
    //   400: invokevirtual 325	java/util/concurrent/CountDownLatch:await	()V
    //   403: ldc 214
    //   405: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload 11
    //   410: areturn
    //   411: iload 6
    //   413: iload 7
    //   415: invokestatic 331	java/lang/Math:max	(II)I
    //   418: istore 10
    //   420: iload 6
    //   422: iload 7
    //   424: invokestatic 334	java/lang/Math:min	(II)I
    //   427: istore 9
    //   429: iload_3
    //   430: iload 4
    //   432: invokestatic 331	java/lang/Math:max	(II)I
    //   435: istore 5
    //   437: iload_3
    //   438: iload 4
    //   440: invokestatic 334	java/lang/Math:min	(II)I
    //   443: istore 8
    //   445: iload 10
    //   447: bipush 16
    //   449: irem
    //   450: ifne +51 -> 501
    //   453: iload 10
    //   455: iload 5
    //   457: isub
    //   458: invokestatic 338	java/lang/Math:abs	(I)I
    //   461: bipush 16
    //   463: if_icmpge +38 -> 501
    //   466: iload 9
    //   468: bipush 16
    //   470: irem
    //   471: ifne +30 -> 501
    //   474: iload 9
    //   476: iload 8
    //   478: isub
    //   479: invokestatic 338	java/lang/Math:abs	(I)I
    //   482: bipush 16
    //   484: if_icmpge +17 -> 501
    //   487: ldc 69
    //   489: ldc_w 340
    //   492: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: aconst_null
    //   496: astore 11
    //   498: goto -331 -> 167
    //   501: iload 10
    //   503: iconst_2
    //   504: idiv
    //   505: istore 10
    //   507: iload 9
    //   509: iconst_2
    //   510: idiv
    //   511: istore 9
    //   513: iload 10
    //   515: bipush 16
    //   517: irem
    //   518: ifne +106 -> 624
    //   521: iload 10
    //   523: iload 5
    //   525: isub
    //   526: invokestatic 338	java/lang/Math:abs	(I)I
    //   529: bipush 16
    //   531: if_icmpge +93 -> 624
    //   534: iload 9
    //   536: bipush 16
    //   538: irem
    //   539: ifne +85 -> 624
    //   542: iload 9
    //   544: iload 8
    //   546: isub
    //   547: invokestatic 338	java/lang/Math:abs	(I)I
    //   550: bipush 16
    //   552: if_icmpge +72 -> 624
    //   555: ldc 69
    //   557: ldc_w 342
    //   560: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   577: ifeq +196 -> 773
    //   580: iload_3
    //   581: iconst_1
    //   582: iadd
    //   583: istore_3
    //   584: goto +189 -> 773
    //   587: new 269	android/graphics/Point
    //   590: dup
    //   591: iload_3
    //   592: iload 4
    //   594: invokespecial 345	android/graphics/Point:<init>	(II)V
    //   597: astore 11
    //   599: goto -432 -> 167
    //   602: astore_0
    //   603: aload 12
    //   605: astore 11
    //   607: aload 11
    //   609: ifnull +8 -> 617
    //   612: aload 11
    //   614: invokevirtual 287	android/media/MediaMetadataRetriever:release	()V
    //   617: ldc 214
    //   619: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: aload_0
    //   623: athrow
    //   624: new 269	android/graphics/Point
    //   627: dup
    //   628: invokespecial 346	android/graphics/Point:<init>	()V
    //   631: astore 11
    //   633: iload 6
    //   635: iload 7
    //   637: if_icmpge +75 -> 712
    //   640: iload_3
    //   641: iload 4
    //   643: invokestatic 334	java/lang/Math:min	(II)I
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
    //   664: goto +125 -> 789
    //   667: ldc 69
    //   669: ldc_w 348
    //   672: iconst_2
    //   673: anewarray 141	java/lang/Object
    //   676: dup
    //   677: iconst_0
    //   678: iload 4
    //   680: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: iload 5
    //   688: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   691: aastore
    //   692: invokestatic 210	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: aload 11
    //   697: iload 4
    //   699: putfield 272	android/graphics/Point:x	I
    //   702: aload 11
    //   704: iload 5
    //   706: putfield 275	android/graphics/Point:y	I
    //   709: goto -542 -> 167
    //   712: iload_3
    //   713: iload 4
    //   715: invokestatic 334	java/lang/Math:min	(II)I
    //   718: istore 4
    //   720: dconst_1
    //   721: iload 7
    //   723: i2d
    //   724: dmul
    //   725: iload 4
    //   727: i2d
    //   728: ddiv
    //   729: dstore_1
    //   730: iload 6
    //   732: i2d
    //   733: dload_1
    //   734: ddiv
    //   735: d2i
    //   736: istore_3
    //   737: goto +52 -> 789
    //   740: astore_0
    //   741: ldc 69
    //   743: ldc_w 350
    //   746: iconst_1
    //   747: anewarray 141	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: aload_0
    //   753: invokevirtual 353	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   756: aastore
    //   757: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   760: goto -357 -> 403
    //   763: astore_0
    //   764: aconst_null
    //   765: astore 11
    //   767: goto -160 -> 607
    //   770: goto -183 -> 587
    //   773: iload 4
    //   775: iconst_2
    //   776: irem
    //   777: ifeq -7 -> 770
    //   780: iload 4
    //   782: iconst_1
    //   783: iadd
    //   784: istore 4
    //   786: goto -199 -> 587
    //   789: iload 4
    //   791: istore 5
    //   793: iload 4
    //   795: iconst_2
    //   796: irem
    //   797: ifeq +9 -> 806
    //   800: iload 4
    //   802: iconst_1
    //   803: iadd
    //   804: istore 5
    //   806: iload_3
    //   807: istore 4
    //   809: iload_3
    //   810: iconst_2
    //   811: irem
    //   812: ifeq -145 -> 667
    //   815: iload_3
    //   816: iconst_1
    //   817: iadd
    //   818: istore 4
    //   820: goto -153 -> 667
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	paramString	String
    //   655	79	1	d	double
    //   76	742	3	i	int
    //   82	737	4	j	int
    //   435	370	5	k	int
    //   36	695	6	m	int
    //   49	673	7	n	int
    //   443	104	8	i1	int
    //   427	120	9	i2	int
    //   418	108	10	i3	int
    //   165	601	11	localObject1	Object
    //   17	587	12	localObject2	Object
    //   8	391	13	localObject3	Object
    //   69	161	14	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
    // Exception table:
    //   from	to	target	type
    //   19	51	602	finally
    //   63	143	602	finally
    //   156	164	602	finally
    //   172	190	602	finally
    //   190	261	602	finally
    //   411	445	602	finally
    //   453	466	602	finally
    //   474	495	602	finally
    //   501	513	602	finally
    //   521	534	602	finally
    //   542	574	602	finally
    //   587	599	602	finally
    //   624	633	602	finally
    //   640	664	602	finally
    //   667	709	602	finally
    //   712	720	602	finally
    //   390	403	740	java/lang/InterruptedException
    //   10	19	763	finally
  }
  
  private static String Cv(String paramString)
  {
    AppMethodBeat.i(131244);
    String str2 = "";
    String str1 = str2;
    if (!bo.isNullOrNil(paramString))
    {
      Object localObject = new File(paramString);
      str1 = str2;
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).getName();
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
          if ((com.tencent.mm.compatible.util.e.esr != null) && (com.tencent.mm.compatible.util.e.esr.endsWith("/"))) {
            str1 = com.tencent.mm.compatible.util.e.esr + str1 + System.currentTimeMillis() + ".jpeg";
          }
        }
        for (;;)
        {
          if (new File(str1).exists()) {
            break label342;
          }
          ab.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", new Object[] { str1 });
          paramString = ThumbnailUtils.createVideoThumbnail(paramString, 2);
          if (paramString != null) {
            break;
          }
          ab.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[] { str1 });
          AppMethodBeat.o(131244);
          return "";
          str1 = com.tencent.mm.compatible.util.e.esr + "/" + str1 + System.currentTimeMillis() + ".jpeg";
          continue;
          str1 = "microMsg_" + System.currentTimeMillis();
          str1 = com.tencent.mm.compatible.util.e.esr + str1 + ".jpeg";
        }
      }
    }
    for (;;)
    {
      try
      {
        d.a(paramString, 80, Bitmap.CompressFormat.JPEG, str1, true);
        AppMethodBeat.o(131244);
        return str1;
      }
      catch (IOException paramString)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + paramString.getMessage());
        continue;
      }
      label342:
      ab.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", new Object[] { str1 });
    }
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131246);
    ab.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
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
      AppMethodBeat.o(131246);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(131246);
    }
    return "";
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(131245);
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
      ab.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", new Object[] { paramString1 });
      AppMethodBeat.o(131245);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", paramString1, "", new Object[0]);
      AppMethodBeat.o(131245);
    }
    return "";
  }
  
  private void aDM()
  {
    AppMethodBeat.i(131240);
    this.hQL = new JsApiChooseMultiMedia.a.4(this);
    MMActivity localMMActivity = aBf();
    ah.getResources().getString(2131297087);
    this.ehb = h.b(localMMActivity, ah.getResources().getString(2131296595), true, this.hQL);
    AppMethodBeat.o(131240);
  }
  
  private Intent aDN()
  {
    AppMethodBeat.i(131237);
    Intent localIntent = new Intent();
    localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
    localIntent.putExtra("album_video_max_duration", this.hRy.gNT);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_distance", this.hRy.fOc);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hRy.latitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hRy.longitude);
    localIntent.putExtra("album_business_bubble_media_by_coordinate_posname", this.hRy.eSM);
    localIntent.putExtra("query_media_type", 3);
    localIntent.putExtra("send_btn_string", ah.getResources().getString(2131297013));
    AppMethodBeat.o(131237);
    return localIntent;
  }
  
  private static BackwardSupportUtil.ExifHelper.LatLongData aDO()
  {
    AppMethodBeat.i(131239);
    Object localObject = ah.getContext().getSharedPreferences(ah.dsP() + "_locCache", 0).getString("locStr", null);
    String[] arrayOfString;
    float f1;
    float f2;
    if (localObject != null)
    {
      arrayOfString = ((String)localObject).split(",");
      f1 = Integer.valueOf(arrayOfString[0]).intValue() / 1000000.0F;
      f2 = Integer.valueOf(arrayOfString[1]).intValue() / 1000000.0F;
      ab.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", new Object[] { localObject, Float.valueOf(f1), Float.valueOf(f2) });
      localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
    }
    for (;;)
    {
      AppMethodBeat.o(131239);
      return localObject;
      localObject = (String)g.RL().Ru().get(67591, null);
      if (localObject != null) {
        for (;;)
        {
          try
          {
            arrayOfString = ((String)localObject).split(",");
            int i = Integer.valueOf(arrayOfString[0]).intValue();
            if (1 != Integer.valueOf(arrayOfString[1]).intValue()) {
              break label301;
            }
            localObject = "network";
            f1 = Integer.valueOf(arrayOfString[2]).intValue() / 1000000.0F;
            f2 = Integer.valueOf(arrayOfString[3]).intValue() / 1000000.0F;
            ab.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", new Object[] { Integer.valueOf(i), localObject, Float.valueOf(f1), Float.valueOf(f2) });
            localObject = new BackwardSupportUtil.ExifHelper.LatLongData(f1, f2);
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", new Object[] { localException });
            str = null;
          }
          break;
          label301:
          str = "gps";
        }
      }
      ab.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
      ab.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
      String str = null;
    }
  }
  
  private AppBrandLocalVideoObject ak(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131243);
    String str1 = paramString;
    if (paramBoolean) {}
    String str2;
    int i;
    int j;
    int m;
    try
    {
      str1 = Cu(paramString);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramString = new MediaMetadataRetriever();
          paramString.setDataSource(str1);
          if (paramString != null) {
            break;
          }
          ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
          AppMethodBeat.o(131243);
          return null;
          localException = localException;
          ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", new Object[] { bo.l(localException) });
          str2 = paramString;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
          paramString = null;
        }
        i = bo.getInt(paramString.extractMetadata(18), 0);
        j = bo.getInt(paramString.extractMetadata(19), 0);
        m = bo.getInt(paramString.extractMetadata(9), 0);
        if (!"90".equals(paramString.extractMetadata(24))) {
          break label254;
        }
      }
    }
    if (i > j) {}
    for (;;)
    {
      paramString.release();
      paramString = AppBrandLocalMediaObjectManager.bv(this.hRy.appId, str2);
      if (paramString == null)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
        AppMethodBeat.o(131243);
        return null;
      }
      paramString.duration = ((m + 500) / 1000);
      paramString.width = j;
      paramString.height = i;
      paramString.size = com.tencent.mm.a.e.cM(str2);
      ab.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", new Object[] { paramString });
      AppMethodBeat.o(131243);
      return paramString;
      label254:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    int k = 3;
    int j = 0;
    AppMethodBeat.i(131236);
    this.hRy = ((JsApiChooseMultiMedia.ChooseRequest)paramProcessRequest);
    int i;
    boolean bool;
    if (bo.hg(aBf()) > 200L)
    {
      i = 1;
      if (i == 0) {
        t.makeText(aBf(), ah.getResources().getString(2131296593), 1).show();
      }
      aBf().mmSetOnActivityResultCallback(this);
      if (this.hRy.hRw != 1) {
        break label160;
      }
      bool = true;
      i = k;
    }
    for (;;)
    {
      if ((this.hRy.hQD) && (this.hRy.hQE))
      {
        paramProcessRequest = aDN();
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        n.a(aBf(), 1, this.hRy.count, this.hQK, paramProcessRequest);
        AppMethodBeat.o(131236);
        return;
        i = 0;
        break;
        label160:
        if (this.hRy.hRw == 2)
        {
          i = 1;
          bool = false;
          continue;
        }
        if (this.hRy.hRw != 3) {
          break label462;
        }
        i = 2;
        bool = false;
        continue;
      }
      if (this.hRy.hQE)
      {
        paramProcessRequest = aDN();
        paramProcessRequest.putExtra("show_header_view", false);
        paramProcessRequest.putExtra("query_media_type", i);
        paramProcessRequest.putExtra("key_can_select_video_and_pic", bool);
        n.a(aBf(), 1, this.hRy.count, this.hQK, paramProcessRequest);
        AppMethodBeat.o(131236);
        return;
      }
      if (this.hRy.hQD)
      {
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_latitude", this.hRy.latitude);
        paramProcessRequest.putExtra("album_business_bubble_media_by_coordinate_longitude", this.hRy.longitude);
        if ((this.hRy.hRu) && (!this.hRy.hRv)) {
          i = 1;
        }
        for (;;)
        {
          SightParams localSightParams = new SightParams(7, 1);
          localSightParams.mode = i;
          localSightParams.fcu.duration = this.hRy.gNT;
          paramProcessRequest.putExtra("KEY_SIGHT_PARAMS", localSightParams);
          n.a(aBf(), 2, paramProcessRequest, 7, i);
          AppMethodBeat.o(131236);
          return;
          i = j;
          if (this.hRy.hRv)
          {
            i = j;
            if (!this.hRy.hRu) {
              i = 2;
            }
          }
        }
      }
      ab.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
      this.hRz.bpE = -2;
      a(this.hRz);
      AppMethodBeat.o(131236);
      return;
      label462:
      bool = false;
      i = k;
    }
  }
  
  public final void aBl()
  {
    AppMethodBeat.i(131241);
    super.aBl();
    if (this.ehb != null)
    {
      this.ehb.dismiss();
      this.ehb = null;
    }
    AppMethodBeat.o(131241);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    double d1 = 91.0D;
    boolean bool1 = true;
    AppMethodBeat.i(131238);
    if (paramInt2 == 0)
    {
      this.hRz.bpE = 0;
      a(this.hRz);
      AppMethodBeat.o(131238);
      return;
    }
    if (paramIntent != null) {
      d1 = paramIntent.getDoubleExtra("longitude", 91.0D);
    }
    if (paramIntent != null) {}
    for (double d2 = paramIntent.getDoubleExtra("latitude", 181.0D);; d2 = 181.0D)
    {
      ab.d("MicroMsg.JsApiChooseMultiMedia", "longitude: %f, latitude: %f.", new Object[] { Double.valueOf(d1), Double.valueOf(d2) });
      ab.i("MicroMsg.JsApiChooseMultiMedia", "requestCode: %d.", new Object[] { Integer.valueOf(paramInt1) });
      switch (paramInt1)
      {
      default: 
        this.hRz.bpE = -2;
        a(this.hRz);
        AppMethodBeat.o(131238);
        return;
      }
    }
    ab.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_GALLERY");
    if (paramIntent == null)
    {
      this.hRz.bpE = 0;
      a(this.hRz);
      AppMethodBeat.o(131238);
      return;
    }
    Object localObject = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_select_video_list");
    boolean bool2 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
    aDM();
    if (!bool2) {
      if (!bo.es((List)localObject))
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
      m.aNS().ac(new JsApiChooseMultiMedia.a.1(this, (List)localObject, d2, d1, bool2, bool1, localArrayList));
      AppMethodBeat.o(131238);
      return;
      paramInt1 = 0;
      break;
      label336:
      bool1 = false;
    }
    ab.i("MicroMsg.JsApiChooseMultiMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
    if (paramIntent == null)
    {
      this.hRz.bpE = 0;
      a(this.hRz);
      AppMethodBeat.o(131238);
      return;
    }
    ab.i("MicroMsg.JsApiChooseMultiMedia", "data is valid!");
    localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (localObject == null)
    {
      ab.e("MicroMsg.JsApiChooseMultiMedia", "sight capture result is null!");
      this.hRz.bpE = -2;
      a(this.hRz);
      AppMethodBeat.o(131238);
      return;
    }
    if (((SightCaptureResult)localObject).oFG)
    {
      localObject = ((SightCaptureResult)localObject).oFO;
      if ((bo.isNullOrNil((String)localObject)) || (!new File((String)localObject).exists()))
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "picture_picturePath file is not exist! path:%s", new Object[] { localObject });
        this.hRz.bpE = -2;
        a(this.hRz);
        AppMethodBeat.o(131238);
        return;
      }
      ab.i("MicroMsg.JsApiChooseMultiMedia", "filePath:%s", new Object[] { localObject });
      bool1 = paramIntent.getBooleanExtra("CropImage_Compress_Img", false);
      aDM();
      m.aNS().ac(new JsApiChooseMultiMedia.a.2(this, bool1, (String)localObject, d2, d1));
      AppMethodBeat.o(131238);
      return;
    }
    paramIntent = ((SightCaptureResult)localObject).oFI;
    if (bo.isNullOrNil(paramIntent))
    {
      ab.e("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath is null");
      this.hRz.bpE = -2;
      a(this.hRz);
      AppMethodBeat.o(131238);
      return;
    }
    ab.i("MicroMsg.JsApiChooseMultiMedia", "mVideoFilePath:%s", new Object[] { paramIntent });
    aDM();
    m.aNS().ac(new JsApiChooseMultiMedia.a.3(this, paramIntent, d2, d1));
    AppMethodBeat.o(131238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a
 * JD-Core Version:    0.7.0.1
 */