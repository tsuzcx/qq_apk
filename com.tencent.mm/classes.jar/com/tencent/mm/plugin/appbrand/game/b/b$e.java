package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.magicbrush.a.a.a;
import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.game.c.d.a;
import com.tencent.mm.plugin.appbrand.game.e.a.3;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b$e
  implements com.github.henryye.nativeiv.a.a, a.a
{
  private final int gaT = 2048;
  private final int gaU = 2048;
  
  private static void a(String paramString1, d.a parama, String paramString2)
  {
    int j = 0;
    d locald = d.agy();
    paramString1 = paramString1 + ": " + paramString2;
    if ((parama == null) || (bk.bl(paramString1)))
    {
      y.e("MicroMsg.GameInspector", "hy: not valid console!");
      return;
    }
    int i = j;
    switch (com.tencent.mm.plugin.appbrand.game.c.d.3.gbo[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      locald.E(i, paramString1);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private static void kS(int paramInt)
  {
    h.nFQ.h(807L, paramInt, 1L);
  }
  
  /* Error */
  public final com.github.henryye.nativeiv.bitmap.IBitmap<com.github.henryye.nativeiv.bitmap.NativeBitmapStruct> a(String paramString, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +26 -> 27
    //   4: aload_1
    //   5: getstatic 102	com/tencent/mm/plugin/appbrand/game/c/d$a:gbs	Lcom/tencent/mm/plugin/appbrand/game/c/d$a;
    //   8: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   11: getstatic 113	com/tencent/mm/plugin/appbrand/y$j:appbrand_game_image_load_error	I
    //   14: invokevirtual 119	android/content/Context:getString	(I)Ljava/lang/String;
    //   17: invokestatic 121	com/tencent/mm/plugin/appbrand/game/b/b$e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/game/c/d$a;Ljava/lang/String;)V
    //   20: bipush 7
    //   22: invokestatic 123	com/tencent/mm/plugin/appbrand/game/b/b$e:kS	(I)V
    //   25: aconst_null
    //   26: areturn
    //   27: new 125	com/github/henryye/nativeiv/b
    //   30: dup
    //   31: invokespecial 126	com/github/henryye/nativeiv/b:<init>	()V
    //   34: astore 9
    //   36: aload 9
    //   38: new 2	com/tencent/mm/plugin/appbrand/game/b/b$e
    //   41: dup
    //   42: invokespecial 25	com/tencent/mm/plugin/appbrand/game/b/b$e:<init>	()V
    //   45: putfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   48: aload 9
    //   50: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   53: ifnull +13 -> 66
    //   56: aload 9
    //   58: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   61: invokeinterface 139 1 0
    //   66: aload_2
    //   67: ifnull +36 -> 103
    //   70: aload_2
    //   71: invokestatic 145	com/github/henryye/nativeiv/b/c:d	(Ljava/io/InputStream;)Lcom/github/henryye/nativeiv/bitmap/c;
    //   74: astore 7
    //   76: aload 7
    //   78: ifnonnull +31 -> 109
    //   81: aload_1
    //   82: getstatic 102	com/tencent/mm/plugin/appbrand/game/c/d$a:gbs	Lcom/tencent/mm/plugin/appbrand/game/c/d$a;
    //   85: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   88: getstatic 148	com/tencent/mm/plugin/appbrand/y$j:appbrand_game_image_precheck_failed	I
    //   91: invokevirtual 119	android/content/Context:getString	(I)Ljava/lang/String;
    //   94: invokestatic 121	com/tencent/mm/plugin/appbrand/game/b/b$e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/game/c/d$a;Ljava/lang/String;)V
    //   97: iconst_5
    //   98: invokestatic 123	com/tencent/mm/plugin/appbrand/game/b/b$e:kS	(I)V
    //   101: aconst_null
    //   102: areturn
    //   103: aconst_null
    //   104: astore 7
    //   106: goto -30 -> 76
    //   109: aload 7
    //   111: getfield 154	com/github/henryye/nativeiv/bitmap/c:asA	Lcom/github/henryye/nativeiv/bitmap/b;
    //   114: getstatic 159	com/github/henryye/nativeiv/bitmap/b:asy	Lcom/github/henryye/nativeiv/bitmap/b;
    //   117: if_acmpne +25 -> 142
    //   120: aload_1
    //   121: getstatic 102	com/tencent/mm/plugin/appbrand/game/c/d$a:gbs	Lcom/tencent/mm/plugin/appbrand/game/c/d$a;
    //   124: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   127: getstatic 162	com/tencent/mm/plugin/appbrand/y$j:appbrand_game_image_decode_resource_error_format	I
    //   130: invokevirtual 119	android/content/Context:getString	(I)Ljava/lang/String;
    //   133: invokestatic 121	com/tencent/mm/plugin/appbrand/game/b/b$e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/game/c/d$a;Ljava/lang/String;)V
    //   136: iconst_0
    //   137: invokestatic 123	com/tencent/mm/plugin/appbrand/game/b/b$e:kS	(I)V
    //   140: aconst_null
    //   141: areturn
    //   142: aload 7
    //   144: getfield 166	com/github/henryye/nativeiv/bitmap/c:asB	J
    //   147: ldc2_w 167
    //   150: lcmp
    //   151: ifgt +15 -> 166
    //   154: aload 7
    //   156: getfield 171	com/github/henryye/nativeiv/bitmap/c:asC	J
    //   159: ldc2_w 167
    //   162: lcmp
    //   163: ifle +72 -> 235
    //   166: aload_1
    //   167: getstatic 102	com/tencent/mm/plugin/appbrand/game/c/d$a:gbs	Lcom/tencent/mm/plugin/appbrand/game/c/d$a;
    //   170: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   173: getstatic 174	com/tencent/mm/plugin/appbrand/y$j:appbrand_game_image_size_exceed	I
    //   176: invokevirtual 119	android/content/Context:getString	(I)Ljava/lang/String;
    //   179: iconst_4
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: sipush 2048
    //   188: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: sipush 2048
    //   197: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: aload 7
    //   205: getfield 166	com/github/henryye/nativeiv/bitmap/c:asB	J
    //   208: invokestatic 185	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   211: aastore
    //   212: dup
    //   213: iconst_3
    //   214: aload 7
    //   216: getfield 171	com/github/henryye/nativeiv/bitmap/c:asC	J
    //   219: invokestatic 185	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   222: aastore
    //   223: invokestatic 191	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   226: invokestatic 121	com/tencent/mm/plugin/appbrand/game/b/b$e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/game/c/d$a;Ljava/lang/String;)V
    //   229: iconst_3
    //   230: invokestatic 123	com/tencent/mm/plugin/appbrand/game/b/b$e:kS	(I)V
    //   233: aconst_null
    //   234: areturn
    //   235: aload_1
    //   236: ifnull +314 -> 550
    //   239: aload_1
    //   240: ldc 193
    //   242: invokevirtual 196	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   245: ifne +12 -> 257
    //   248: aload_1
    //   249: ldc 198
    //   251: invokevirtual 196	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: ifeq +296 -> 550
    //   257: ldc 200
    //   259: ldc 202
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_1
    //   268: aastore
    //   269: invokestatic 206	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: getstatic 212	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   275: astore 10
    //   277: aload 7
    //   279: getfield 154	com/github/henryye/nativeiv/bitmap/c:asA	Lcom/github/henryye/nativeiv/bitmap/b;
    //   282: astore 11
    //   284: aload_2
    //   285: ifnull +259 -> 544
    //   288: aload 9
    //   290: getfield 216	com/github/henryye/nativeiv/b:asl	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   293: ifnull +322 -> 615
    //   296: getstatic 222	com/github/henryye/nativeiv/a:asf	Lcom/github/henryye/nativeiv/a;
    //   299: astore 7
    //   301: aload 9
    //   303: invokevirtual 225	java/lang/Object:hashCode	()I
    //   306: istore_3
    //   307: aload 9
    //   309: getfield 216	com/github/henryye/nativeiv/b:asl	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   312: astore 8
    //   314: aload 7
    //   316: getfield 229	com/github/henryye/nativeiv/a:ash	Landroid/util/SparseArray;
    //   319: iload_3
    //   320: invokevirtual 235	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   323: checkcast 237	java/util/Map
    //   326: astore 11
    //   328: aload 11
    //   330: ifnull +239 -> 569
    //   333: aload 11
    //   335: aload 8
    //   337: invokeinterface 240 2 0
    //   342: ifnull +227 -> 569
    //   345: aload 11
    //   347: aload 8
    //   349: invokeinterface 240 2 0
    //   354: checkcast 242	com/github/henryye/nativeiv/bitmap/a
    //   357: invokeinterface 246 1 0
    //   362: astore 7
    //   364: aload 9
    //   366: aload 7
    //   368: putfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   371: aload 9
    //   373: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   376: aload_2
    //   377: aload 10
    //   379: invokeinterface 249 3 0
    //   384: aload 9
    //   386: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   389: invokeinterface 253 1 0
    //   394: astore 7
    //   396: aload 7
    //   398: ifnull +287 -> 685
    //   401: iconst_1
    //   402: istore_3
    //   403: lconst_0
    //   404: lstore 5
    //   406: aload_2
    //   407: invokevirtual 258	java/io/InputStream:available	()I
    //   410: istore 4
    //   412: iload 4
    //   414: i2l
    //   415: lstore 5
    //   417: iload_3
    //   418: ifne +72 -> 490
    //   421: aload 9
    //   423: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   426: invokeinterface 262 1 0
    //   431: getstatic 267	com/github/henryye/nativeiv/bitmap/BitmapType:Native	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   434: if_acmpne +56 -> 490
    //   437: ldc_w 269
    //   440: ldc_w 271
    //   443: iconst_0
    //   444: anewarray 4	java/lang/Object
    //   447: invokestatic 274	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: aload 9
    //   452: getstatic 222	com/github/henryye/nativeiv/a:asf	Lcom/github/henryye/nativeiv/a;
    //   455: getfield 278	com/github/henryye/nativeiv/a:asg	Ljava/util/Map;
    //   458: getstatic 281	com/github/henryye/nativeiv/bitmap/BitmapType:Legacy	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   461: invokeinterface 240 2 0
    //   466: checkcast 242	com/github/henryye/nativeiv/bitmap/a
    //   469: invokeinterface 246 1 0
    //   474: putfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   477: aload 9
    //   479: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   482: aload_2
    //   483: aload 10
    //   485: invokeinterface 249 3 0
    //   490: aload 9
    //   492: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   495: lload 5
    //   497: aload 9
    //   499: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   502: invokeinterface 285 1 0
    //   507: invokeinterface 288 5 0
    //   512: aload 9
    //   514: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   517: invokeinterface 262 1 0
    //   522: getstatic 281	com/github/henryye/nativeiv/bitmap/BitmapType:Legacy	Lcom/github/henryye/nativeiv/bitmap/BitmapType;
    //   525: if_acmpne +15 -> 540
    //   528: aload 9
    //   530: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   533: aload_1
    //   534: iconst_4
    //   535: invokeinterface 291 3 0
    //   540: aload_2
    //   541: invokevirtual 294	java/io/InputStream:close	()V
    //   544: aload 9
    //   546: getfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   549: areturn
    //   550: ldc 200
    //   552: ldc_w 296
    //   555: iconst_1
    //   556: anewarray 4	java/lang/Object
    //   559: dup
    //   560: iconst_0
    //   561: aload_1
    //   562: aastore
    //   563: invokestatic 206	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: goto -294 -> 272
    //   569: aload 7
    //   571: getfield 278	com/github/henryye/nativeiv/a:asg	Ljava/util/Map;
    //   574: aload 8
    //   576: invokeinterface 240 2 0
    //   581: ifnull +28 -> 609
    //   584: aload 7
    //   586: getfield 278	com/github/henryye/nativeiv/a:asg	Ljava/util/Map;
    //   589: aload 8
    //   591: invokeinterface 240 2 0
    //   596: checkcast 242	com/github/henryye/nativeiv/bitmap/a
    //   599: invokeinterface 246 1 0
    //   604: astore 7
    //   606: goto -242 -> 364
    //   609: aconst_null
    //   610: astore 7
    //   612: goto -248 -> 364
    //   615: getstatic 222	com/github/henryye/nativeiv/a:asf	Lcom/github/henryye/nativeiv/a;
    //   618: astore 12
    //   620: aload 9
    //   622: invokevirtual 225	java/lang/Object:hashCode	()I
    //   625: istore_3
    //   626: aload 12
    //   628: getfield 229	com/github/henryye/nativeiv/a:ash	Landroid/util/SparseArray;
    //   631: iload_3
    //   632: invokevirtual 235	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   635: checkcast 237	java/util/Map
    //   638: astore 7
    //   640: aload 7
    //   642: ifnull +284 -> 926
    //   645: aload 11
    //   647: aload 7
    //   649: invokestatic 299	com/github/henryye/nativeiv/a:a	(Lcom/github/henryye/nativeiv/bitmap/b;Ljava/util/Map;)Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   652: astore 7
    //   654: aload 7
    //   656: astore 8
    //   658: aload 7
    //   660: ifnonnull +15 -> 675
    //   663: aload 11
    //   665: aload 12
    //   667: getfield 278	com/github/henryye/nativeiv/a:asg	Ljava/util/Map;
    //   670: invokestatic 299	com/github/henryye/nativeiv/a:a	(Lcom/github/henryye/nativeiv/bitmap/b;Ljava/util/Map;)Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   673: astore 8
    //   675: aload 9
    //   677: aload 8
    //   679: putfield 134	com/github/henryye/nativeiv/b:asm	Lcom/github/henryye/nativeiv/bitmap/IBitmap;
    //   682: goto -311 -> 371
    //   685: iconst_0
    //   686: istore_3
    //   687: goto -284 -> 403
    //   690: astore 7
    //   692: ldc_w 269
    //   695: aload 7
    //   697: ldc_w 301
    //   700: iconst_0
    //   701: anewarray 4	java/lang/Object
    //   704: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   707: aload 9
    //   709: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   712: aload_1
    //   713: iconst_1
    //   714: invokeinterface 291 3 0
    //   719: iconst_0
    //   720: istore_3
    //   721: goto -318 -> 403
    //   724: astore 7
    //   726: ldc_w 269
    //   729: aload 7
    //   731: ldc_w 301
    //   734: iconst_0
    //   735: anewarray 4	java/lang/Object
    //   738: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   741: aload 9
    //   743: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   746: aload_1
    //   747: iconst_2
    //   748: invokeinterface 291 3 0
    //   753: iconst_0
    //   754: istore_3
    //   755: goto -352 -> 403
    //   758: astore 7
    //   760: ldc_w 269
    //   763: aload 7
    //   765: ldc_w 306
    //   768: iconst_0
    //   769: anewarray 4	java/lang/Object
    //   772: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   775: aload 9
    //   777: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   780: aload_1
    //   781: iconst_3
    //   782: invokeinterface 291 3 0
    //   787: iconst_0
    //   788: istore_3
    //   789: goto -386 -> 403
    //   792: astore 7
    //   794: ldc_w 269
    //   797: aload 7
    //   799: ldc_w 308
    //   802: iconst_0
    //   803: anewarray 4	java/lang/Object
    //   806: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   809: goto -392 -> 417
    //   812: astore 7
    //   814: ldc_w 269
    //   817: aload 7
    //   819: ldc_w 310
    //   822: iconst_0
    //   823: anewarray 4	java/lang/Object
    //   826: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   829: aload 9
    //   831: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   834: aload_1
    //   835: iconst_1
    //   836: invokeinterface 291 3 0
    //   841: goto -351 -> 490
    //   844: astore 7
    //   846: ldc_w 269
    //   849: aload 7
    //   851: ldc_w 301
    //   854: iconst_0
    //   855: anewarray 4	java/lang/Object
    //   858: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   861: aload 9
    //   863: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   866: aload_1
    //   867: iconst_2
    //   868: invokeinterface 291 3 0
    //   873: goto -383 -> 490
    //   876: astore 7
    //   878: ldc_w 269
    //   881: aload 7
    //   883: ldc_w 306
    //   886: iconst_0
    //   887: anewarray 4	java/lang/Object
    //   890: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: aload 9
    //   895: getfield 130	com/github/henryye/nativeiv/b:asn	Lcom/github/henryye/nativeiv/a/a;
    //   898: aload_1
    //   899: iconst_3
    //   900: invokeinterface 291 3 0
    //   905: goto -415 -> 490
    //   908: astore_1
    //   909: ldc_w 269
    //   912: aload_1
    //   913: ldc_w 312
    //   916: iconst_0
    //   917: anewarray 4	java/lang/Object
    //   920: invokestatic 304	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   923: goto -379 -> 544
    //   926: aconst_null
    //   927: astore 7
    //   929: goto -275 -> 654
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	932	0	this	e
    //   0	932	1	paramString	String
    //   0	932	2	paramInputStream	java.io.InputStream
    //   306	483	3	i	int
    //   410	3	4	j	int
    //   404	92	5	l	long
    //   74	585	7	localObject1	Object
    //   690	6	7	localIOException1	java.io.IOException
    //   724	6	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   758	6	7	localThrowable1	java.lang.Throwable
    //   792	6	7	localIOException2	java.io.IOException
    //   812	6	7	localIOException3	java.io.IOException
    //   844	6	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   876	6	7	localThrowable2	java.lang.Throwable
    //   927	1	7	localObject2	Object
    //   312	366	8	localObject3	Object
    //   34	860	9	localb	com.github.henryye.nativeiv.b
    //   275	209	10	localConfig	android.graphics.Bitmap.Config
    //   282	382	11	localObject4	Object
    //   618	48	12	locala	com.github.henryye.nativeiv.a
    // Exception table:
    //   from	to	target	type
    //   371	396	690	java/io/IOException
    //   371	396	724	java/lang/OutOfMemoryError
    //   371	396	758	java/lang/Throwable
    //   406	412	792	java/io/IOException
    //   477	490	812	java/io/IOException
    //   477	490	844	java/lang/OutOfMemoryError
    //   477	490	876	java/lang/Throwable
    //   540	544	908	java/io/IOException
  }
  
  public final void d(long paramLong1, long paramLong2)
  {
    com.tencent.mm.plugin.appbrand.game.e.a locala = com.tencent.mm.plugin.appbrand.game.e.a.ahj();
    y.i("MicroMsg.MBNiReporter", "hy: size:%d,cost:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    com.tencent.mm.cg.a.post(new a.3(locala, paramLong1));
    locala.gcX.add(Long.valueOf(paramLong2));
    if (paramLong2 >= 1000L) {
      kS(11);
    }
  }
  
  public final void i(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      y.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
      a(paramString, d.a.gbs, ae.getContext().getString(y.j.appbrand_game_image_decode_resource_error_io));
      kS(4);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        y.e("MicroMsg.MBImageHandlerRegistry", "OUTOFMEMORY path:%s", new Object[] { paramString });
        a(paramString, d.a.gbs, ae.getContext().getString(y.j.appbrand_game_image_decode_resource_error_out_of_memory));
        kS(1);
        return;
      }
      if (paramInt == 3)
      {
        y.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, d.a.gbs, ae.getContext().getString(y.j.appbrand_game_image_decode_internal_error));
        kS(5);
        return;
      }
    } while (paramInt != 4);
    y.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
    kS(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.b.e
 * JD-Core Version:    0.7.0.1
 */