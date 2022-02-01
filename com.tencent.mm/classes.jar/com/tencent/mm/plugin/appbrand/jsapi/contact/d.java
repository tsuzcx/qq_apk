package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import d.g.b.q;
import d.l;
import d.z;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  @Deprecated
  public static final a kJS;
  
  static
  {
    AppMethodBeat.i(138160);
    kJS = new a((byte)0);
    AppMethodBeat.o(138160);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(138159);
    if (paramc == null)
    {
      AppMethodBeat.o(138159);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(138159);
      return;
    }
    paramJSONObject = com.tencent.mm.sdk.f.a.jq(paramc.getContext());
    if (paramJSONObject == null)
    {
      ((d.g.a.a)new b(paramc, paramInt)).invoke();
      AppMethodBeat.o(138159);
      return;
    }
    paramJSONObject = e.aA((Context)paramJSONObject);
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("vnd.android.cursor.dir/phone_v2");
    paramJSONObject.a(localIntent, (e.b)new c(this, paramc, paramInt));
    AppMethodBeat.o(138159);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-default-impl_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "resultCode", "", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements e.b
  {
    c(d paramd, c paramc, int paramInt) {}
    
    /* Error */
    public final void a(int paramInt, Intent paramIntent)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore_3
      //   5: ldc 53
      //   7: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: invokestatic 63	com/tencent/mm/plugin/appbrand/jsapi/contact/d:bkc	()Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d$a;
      //   13: pop
      //   14: ldc 65
      //   16: new 67	java/lang/StringBuilder
      //   19: dup
      //   20: ldc 69
      //   22: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   25: aload_0
      //   26: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   29: invokeinterface 78 1 0
      //   34: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 84
      //   39: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: iload_1
      //   43: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   46: bipush 93
      //   48: invokevirtual 90	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   51: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   54: invokestatic 98	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   57: iload_1
      //   58: tableswitch	default:+26 -> 84, -1:+82->140, 0:+54->112, 1:+54->112
      //   85: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   88: aload_0
      //   89: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:krv	I
      //   92: aload_0
      //   93: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kJT	Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d;
      //   96: ldc 100
      //   98: invokevirtual 104	com/tencent/mm/plugin/appbrand/jsapi/contact/d:Pg	(Ljava/lang/String;)Ljava/lang/String;
      //   101: invokeinterface 108 3 0
      //   106: ldc 53
      //   108: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: return
      //   112: aload_0
      //   113: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   116: aload_0
      //   117: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:krv	I
      //   120: aload_0
      //   121: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kJT	Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d;
      //   124: ldc 113
      //   126: invokevirtual 104	com/tencent/mm/plugin/appbrand/jsapi/contact/d:Pg	(Ljava/lang/String;)Ljava/lang/String;
      //   129: invokeinterface 108 3 0
      //   134: ldc 53
      //   136: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: return
      //   140: aload_2
      //   141: ifnull +37 -> 178
      //   144: aload_2
      //   145: invokevirtual 119	android/content/Intent:getData	()Landroid/net/Uri;
      //   148: astore 4
      //   150: aload 4
      //   152: ifnonnull +32 -> 184
      //   155: new 13	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$1
      //   158: dup
      //   159: aload_0
      //   160: invokespecial 122	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d$c;)V
      //   163: checkcast 124	d/g/a/a
      //   166: invokeinterface 128 1 0
      //   171: pop
      //   172: ldc 53
      //   174: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: return
      //   178: aconst_null
      //   179: astore 4
      //   181: goto -31 -> 150
      //   184: aload_0
      //   185: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   188: invokeinterface 132 1 0
      //   193: astore_2
      //   194: aload_2
      //   195: ldc 134
      //   197: invokestatic 140	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   200: aload_2
      //   201: invokevirtual 146	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   204: astore 7
      //   206: aload 7
      //   208: ifnonnull +26 -> 234
      //   211: new 15	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$2
      //   214: dup
      //   215: aload_0
      //   216: invokespecial 147	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$2:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d$c;)V
      //   219: checkcast 124	d/g/a/a
      //   222: invokeinterface 128 1 0
      //   227: pop
      //   228: ldc 53
      //   230: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   233: return
      //   234: aload 7
      //   236: aload 4
      //   238: iconst_1
      //   239: anewarray 149	java/lang/String
      //   242: dup
      //   243: iconst_0
      //   244: ldc 151
      //   246: aastore
      //   247: aconst_null
      //   248: aconst_null
      //   249: aconst_null
      //   250: invokevirtual 157	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   253: astore_2
      //   254: aload_2
      //   255: ifnull +353 -> 608
      //   258: aload_2
      //   259: checkcast 159	java/io/Closeable
      //   262: astore 6
      //   264: aload 6
      //   266: checkcast 161	android/database/Cursor
      //   269: astore 8
      //   271: aload 8
      //   273: invokeinterface 165 1 0
      //   278: ifeq +267 -> 545
      //   281: aload 8
      //   283: iconst_0
      //   284: invokeinterface 169 2 0
      //   289: invokestatic 174	com/tencent/mm/plugin/appbrand/jsapi/contact/c:JV	(Ljava/lang/String;)Ljava/lang/String;
      //   292: astore_2
      //   293: aload_2
      //   294: checkcast 176	java/lang/CharSequence
      //   297: astore 9
      //   299: aload 9
      //   301: ifnull +407 -> 708
      //   304: aload 9
      //   306: invokeinterface 180 1 0
      //   311: ifne +216 -> 527
      //   314: goto +394 -> 708
      //   317: iload_1
      //   318: ifne +214 -> 532
      //   321: aload_2
      //   322: invokestatic 186	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
      //   325: ifeq +207 -> 532
      //   328: aload_2
      //   329: ifnonnull +6 -> 335
      //   332: invokestatic 189	d/g/b/p:gfZ	()V
      //   335: aload_2
      //   336: invokevirtual 190	java/lang/String:length	()I
      //   339: istore_1
      //   340: iload_1
      //   341: bipush 11
      //   343: if_icmpne +189 -> 532
      //   346: aload 6
      //   348: aconst_null
      //   349: invokestatic 195	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   352: aload_2
      //   353: astore_3
      //   354: aload 7
      //   356: aload 4
      //   358: iconst_1
      //   359: anewarray 149	java/lang/String
      //   362: dup
      //   363: iconst_0
      //   364: ldc 197
      //   366: aastore
      //   367: aconst_null
      //   368: aconst_null
      //   369: aconst_null
      //   370: invokevirtual 157	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   373: astore_2
      //   374: aload_2
      //   375: ifnull +42 -> 417
      //   378: aload_2
      //   379: checkcast 159	java/io/Closeable
      //   382: astore 4
      //   384: aload 4
      //   386: checkcast 161	android/database/Cursor
      //   389: astore_2
      //   390: aload_2
      //   391: invokeinterface 165 1 0
      //   396: ifeq +217 -> 613
      //   399: aload_2
      //   400: iconst_0
      //   401: invokeinterface 169 2 0
      //   406: astore_2
      //   407: aload 4
      //   409: aconst_null
      //   410: invokestatic 195	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   413: aload_2
      //   414: ifnonnull +291 -> 705
      //   417: ldc 198
      //   419: astore_2
      //   420: aload_3
      //   421: checkcast 176	java/lang/CharSequence
      //   424: astore 4
      //   426: aload 4
      //   428: ifnull +13 -> 441
      //   431: aload 4
      //   433: invokeinterface 180 1 0
      //   438: ifne +203 -> 641
      //   441: iconst_1
      //   442: istore_1
      //   443: iload_1
      //   444: ifne +202 -> 646
      //   447: aload_0
      //   448: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   451: astore 4
      //   453: aload_0
      //   454: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:krv	I
      //   457: istore_1
      //   458: aload_0
      //   459: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kJT	Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d;
      //   462: astore 5
      //   464: new 200	java/util/HashMap
      //   467: dup
      //   468: invokespecial 201	java/util/HashMap:<init>	()V
      //   471: astore 6
      //   473: aload 6
      //   475: checkcast 203	java/util/Map
      //   478: ldc 205
      //   480: aload_3
      //   481: invokeinterface 209 3 0
      //   486: pop
      //   487: aload 6
      //   489: checkcast 203	java/util/Map
      //   492: ldc 211
      //   494: aload_2
      //   495: invokeinterface 209 3 0
      //   500: pop
      //   501: aload 4
      //   503: iload_1
      //   504: aload 5
      //   506: ldc 213
      //   508: aload 6
      //   510: checkcast 203	java/util/Map
      //   513: invokevirtual 217	com/tencent/mm/plugin/appbrand/jsapi/contact/d:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
      //   516: invokeinterface 108 3 0
      //   521: ldc 53
      //   523: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   526: return
      //   527: iconst_0
      //   528: istore_1
      //   529: goto -212 -> 317
      //   532: aload 8
      //   534: invokeinterface 220 1 0
      //   539: ifne -258 -> 281
      //   542: goto +171 -> 713
      //   545: invokestatic 63	com/tencent/mm/plugin/appbrand/jsapi/contact/d:bkc	()Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d$a;
      //   548: pop
      //   549: ldc 65
      //   551: new 67	java/lang/StringBuilder
      //   554: dup
      //   555: ldc 69
      //   557: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   560: aload_0
      //   561: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   564: invokeinterface 78 1 0
      //   569: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   572: ldc 222
      //   574: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   577: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   580: invokestatic 225	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   583: goto +130 -> 713
      //   586: astore_3
      //   587: ldc 53
      //   589: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   592: aload_3
      //   593: athrow
      //   594: astore_2
      //   595: aload 6
      //   597: aload_3
      //   598: invokestatic 195	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   601: ldc 53
      //   603: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   606: aload_2
      //   607: athrow
      //   608: aconst_null
      //   609: astore_3
      //   610: goto -256 -> 354
      //   613: ldc 198
      //   615: astore_2
      //   616: goto -209 -> 407
      //   619: astore_3
      //   620: ldc 53
      //   622: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   625: aload_3
      //   626: athrow
      //   627: astore_2
      //   628: aload 4
      //   630: aload_3
      //   631: invokestatic 195	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   634: ldc 53
      //   636: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   639: aload_2
      //   640: athrow
      //   641: iconst_0
      //   642: istore_1
      //   643: goto -200 -> 443
      //   646: aload_0
      //   647: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   650: aload_0
      //   651: getfield 45	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:krv	I
      //   654: aload_0
      //   655: getfield 41	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kJT	Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d;
      //   658: ldc 227
      //   660: invokevirtual 104	com/tencent/mm/plugin/appbrand/jsapi/contact/d:Pg	(Ljava/lang/String;)Ljava/lang/String;
      //   663: invokeinterface 108 3 0
      //   668: aload_0
      //   669: getfield 43	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c:kru	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   672: new 17	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$3
      //   675: dup
      //   676: aload_0
      //   677: invokespecial 228	com/tencent/mm/plugin/appbrand/jsapi/contact/d$c$3:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/contact/d$c;)V
      //   680: checkcast 230	java/lang/Runnable
      //   683: invokeinterface 234 2 0
      //   688: ldc 53
      //   690: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   693: return
      //   694: astore_2
      //   695: aload 5
      //   697: astore_3
      //   698: goto -70 -> 628
      //   701: astore_2
      //   702: goto -107 -> 595
      //   705: goto -285 -> 420
      //   708: iconst_1
      //   709: istore_1
      //   710: goto -393 -> 317
      //   713: aconst_null
      //   714: astore_2
      //   715: goto -369 -> 346
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	718	0	this	c
      //   0	718	1	paramInt	int
      //   0	718	2	paramIntent	Intent
      //   4	477	3	localIntent	Intent
      //   586	12	3	localThrowable1	java.lang.Throwable
      //   609	1	3	localObject1	Object
      //   619	12	3	localThrowable2	java.lang.Throwable
      //   697	1	3	locald1	d
      //   148	481	4	localObject2	Object
      //   1	695	5	locald2	d
      //   262	334	6	localObject3	Object
      //   204	151	7	localContentResolver	android.content.ContentResolver
      //   269	264	8	localCursor	android.database.Cursor
      //   297	8	9	localCharSequence	java.lang.CharSequence
      // Exception table:
      //   from	to	target	type
      //   264	281	586	java/lang/Throwable
      //   281	299	586	java/lang/Throwable
      //   304	314	586	java/lang/Throwable
      //   321	328	586	java/lang/Throwable
      //   332	335	586	java/lang/Throwable
      //   335	340	586	java/lang/Throwable
      //   532	542	586	java/lang/Throwable
      //   545	583	586	java/lang/Throwable
      //   587	594	594	finally
      //   384	407	619	java/lang/Throwable
      //   620	627	627	finally
      //   384	407	694	finally
      //   264	281	701	finally
      //   281	299	701	finally
      //   304	314	701	finally
      //   321	328	701	finally
      //   332	335	701	finally
      //   335	340	701	finally
      //   532	542	701	finally
      //   545	583	701	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.d
 * JD-Core Version:    0.7.0.1
 */