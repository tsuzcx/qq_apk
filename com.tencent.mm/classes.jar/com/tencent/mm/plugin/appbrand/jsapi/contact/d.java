package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.content.a;
import com.tencent.luggage.l.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "invokeOnGranted", "activity", "Landroid/app/Activity;", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<f>
{
  @Deprecated
  public static final int CTRL_INDEX = 72;
  @Deprecated
  public static final String NAME = "chooseContact";
  private static final a rSu;
  
  static
  {
    AppMethodBeat.i(138160);
    rSu = new a((byte)0);
    AppMethodBeat.o(138160);
  }
  
  private static final void a(d paramd, f paramf, Activity paramActivity, JSONObject paramJSONObject, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(327794);
    s.u(paramd, "this$0");
    if (paramArrayOfInt != null)
    {
      paramJSONObject = k.ab(paramArrayOfInt);
      if (paramJSONObject != null) {
        break label48;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label61;
      }
      paramd.a(paramf, paramActivity, paramInt);
      AppMethodBeat.o(327794);
      return;
      label48:
      if (paramJSONObject.intValue() != 0) {
        break;
      }
    }
    label61:
    paramf.callback(paramInt, paramd.ZP("fail:system permission denied"));
    AppMethodBeat.o(327794);
  }
  
  /* Error */
  private static final void a(f paramf, int paramInt1, d paramd, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 112
    //   8: invokestatic 82	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 76
    //   14: invokestatic 82	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: ldc 114
    //   19: new 116	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 118
    //   25: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokeinterface 125 1 0
    //   34: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 131
    //   39: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_3
    //   43: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: bipush 93
    //   48: invokevirtual 140	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   51: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iload_3
    //   58: tableswitch	default:+26 -> 84, -1:+64->122, 0:+45->103, 1:+45->103
    //   85: iload_1
    //   86: aload_2
    //   87: ldc 150
    //   89: invokevirtual 103	com/tencent/mm/plugin/appbrand/jsapi/contact/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokeinterface 109 3 0
    //   97: ldc 110
    //   99: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: aload_0
    //   104: iload_1
    //   105: aload_2
    //   106: ldc 152
    //   108: invokevirtual 103	com/tencent/mm/plugin/appbrand/jsapi/contact/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokeinterface 109 3 0
    //   116: ldc 110
    //   118: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: aload 4
    //   124: ifnonnull +54 -> 178
    //   127: aconst_null
    //   128: astore 5
    //   130: aload 5
    //   132: ifnonnull +56 -> 188
    //   135: aload_0
    //   136: ldc 112
    //   138: invokestatic 82	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   141: ldc 114
    //   143: new 116	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 118
    //   149: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokeinterface 125 1 0
    //   158: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   161: ldc 154
    //   163: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: ldc 110
    //   174: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: aload 4
    //   180: invokevirtual 163	android/content/Intent:getData	()Landroid/net/Uri;
    //   183: astore 5
    //   185: goto -55 -> 130
    //   188: aload_0
    //   189: invokeinterface 167 1 0
    //   194: invokevirtual 173	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   197: astore 7
    //   199: aload 7
    //   201: ifnonnull +65 -> 266
    //   204: aload_0
    //   205: ldc 112
    //   207: invokestatic 82	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   210: aload_2
    //   211: ldc 76
    //   213: invokestatic 82	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   216: ldc 114
    //   218: new 116	java/lang/StringBuilder
    //   221: dup
    //   222: ldc 118
    //   224: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_0
    //   228: invokeinterface 125 1 0
    //   233: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: ldc 175
    //   238: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_0
    //   248: iload_1
    //   249: aload_2
    //   250: ldc 177
    //   252: invokevirtual 103	com/tencent/mm/plugin/appbrand/jsapi/contact/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokeinterface 109 3 0
    //   260: ldc 110
    //   262: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: return
    //   266: aload 7
    //   268: aload 5
    //   270: iconst_1
    //   271: anewarray 179	java/lang/String
    //   274: dup
    //   275: iconst_0
    //   276: ldc 181
    //   278: aastore
    //   279: aconst_null
    //   280: aconst_null
    //   281: aconst_null
    //   282: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   285: astore 4
    //   287: aload 4
    //   289: ifnonnull +132 -> 421
    //   292: aconst_null
    //   293: astore 6
    //   295: aload 7
    //   297: aload 5
    //   299: iconst_1
    //   300: anewarray 179	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: ldc 189
    //   307: aastore
    //   308: aconst_null
    //   309: aconst_null
    //   310: aconst_null
    //   311: invokevirtual 187	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   314: astore 4
    //   316: aload 4
    //   318: ifnonnull +319 -> 637
    //   321: ldc 190
    //   323: astore 4
    //   325: aload 6
    //   327: checkcast 192	java/lang/CharSequence
    //   330: astore 5
    //   332: aload 5
    //   334: ifnull +13 -> 347
    //   337: aload 5
    //   339: invokeinterface 195 1 0
    //   344: ifne +377 -> 721
    //   347: iconst_1
    //   348: istore_3
    //   349: iload_3
    //   350: ifne +376 -> 726
    //   353: new 197	java/util/HashMap
    //   356: dup
    //   357: invokespecial 198	java/util/HashMap:<init>	()V
    //   360: astore 5
    //   362: aload 5
    //   364: checkcast 200	java/util/Map
    //   367: ldc 202
    //   369: aload 6
    //   371: invokeinterface 206 3 0
    //   376: pop
    //   377: aload 5
    //   379: checkcast 200	java/util/Map
    //   382: ldc 208
    //   384: aload 4
    //   386: invokeinterface 206 3 0
    //   391: pop
    //   392: getstatic 214	kotlin/ah:aiuX	Lkotlin/ah;
    //   395: astore 4
    //   397: aload_0
    //   398: iload_1
    //   399: aload_2
    //   400: ldc 216
    //   402: aload 5
    //   404: checkcast 200	java/util/Map
    //   407: invokevirtual 220	com/tencent/mm/plugin/appbrand/jsapi/contact/d:m	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   410: invokeinterface 109 3 0
    //   415: ldc 110
    //   417: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: return
    //   421: aload 4
    //   423: checkcast 222	java/io/Closeable
    //   426: astore 8
    //   428: aload 8
    //   430: checkcast 224	android/database/Cursor
    //   433: astore 9
    //   435: aload 9
    //   437: invokeinterface 228 1 0
    //   442: ifeq +138 -> 580
    //   445: aload 9
    //   447: iconst_0
    //   448: invokeinterface 232 2 0
    //   453: astore 4
    //   455: aload 4
    //   457: ifnonnull +73 -> 530
    //   460: aconst_null
    //   461: astore 4
    //   463: aload 4
    //   465: checkcast 192	java/lang/CharSequence
    //   468: astore 6
    //   470: aload 6
    //   472: ifnull +274 -> 746
    //   475: aload 6
    //   477: invokeinterface 195 1 0
    //   482: ifne +272 -> 754
    //   485: goto +261 -> 746
    //   488: iload_3
    //   489: ifne +78 -> 567
    //   492: aload 4
    //   494: invokestatic 238	android/telephony/PhoneNumberUtils:isGlobalPhoneNumber	(Ljava/lang/String;)Z
    //   497: ifeq +70 -> 567
    //   500: aload 4
    //   502: invokestatic 242	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   505: aload 4
    //   507: invokevirtual 243	java/lang/String:length	()I
    //   510: istore_3
    //   511: iload_3
    //   512: bipush 11
    //   514: if_icmpne +53 -> 567
    //   517: aload 8
    //   519: aconst_null
    //   520: invokestatic 248	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   523: aload 4
    //   525: astore 6
    //   527: goto -232 -> 295
    //   530: aload 4
    //   532: ldc 250
    //   534: ldc 190
    //   536: invokevirtual 254	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 6
    //   541: aload 6
    //   543: astore 4
    //   545: aload 6
    //   547: ldc_w 256
    //   550: invokevirtual 259	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   553: ifeq +198 -> 751
    //   556: aload 6
    //   558: iconst_2
    //   559: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   562: astore 4
    //   564: goto +187 -> 751
    //   567: aload 9
    //   569: invokeinterface 265 1 0
    //   574: ifne -129 -> 445
    //   577: goto +182 -> 759
    //   580: ldc 114
    //   582: new 116	java/lang/StringBuilder
    //   585: dup
    //   586: ldc 118
    //   588: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   591: aload_0
    //   592: invokeinterface 125 1 0
    //   597: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   600: ldc_w 267
    //   603: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   612: goto +147 -> 759
    //   615: astore_0
    //   616: ldc 110
    //   618: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   621: aload_0
    //   622: athrow
    //   623: astore_2
    //   624: aload 8
    //   626: aload_0
    //   627: invokestatic 248	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   630: ldc 110
    //   632: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: aload_2
    //   636: athrow
    //   637: aload 4
    //   639: checkcast 222	java/io/Closeable
    //   642: astore 5
    //   644: aload 5
    //   646: checkcast 224	android/database/Cursor
    //   649: astore 4
    //   651: aload 4
    //   653: invokeinterface 228 1 0
    //   658: ifeq +31 -> 689
    //   661: aload 4
    //   663: iconst_0
    //   664: invokeinterface 232 2 0
    //   669: astore 4
    //   671: aload 5
    //   673: aconst_null
    //   674: invokestatic 248	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   677: aload 4
    //   679: ifnonnull +39 -> 718
    //   682: ldc 190
    //   684: astore 4
    //   686: goto -361 -> 325
    //   689: ldc 190
    //   691: astore 4
    //   693: goto -22 -> 671
    //   696: astore_0
    //   697: ldc 110
    //   699: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: aload_0
    //   703: athrow
    //   704: astore_2
    //   705: aload 5
    //   707: aload_0
    //   708: invokestatic 248	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   711: ldc 110
    //   713: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: aload_2
    //   717: athrow
    //   718: goto -393 -> 325
    //   721: iconst_0
    //   722: istore_3
    //   723: goto -374 -> 349
    //   726: aload_0
    //   727: iload_1
    //   728: aload_2
    //   729: ldc_w 269
    //   732: invokevirtual 103	com/tencent/mm/plugin/appbrand/jsapi/contact/d:ZP	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokeinterface 109 3 0
    //   740: ldc 110
    //   742: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   745: return
    //   746: iconst_1
    //   747: istore_3
    //   748: goto -260 -> 488
    //   751: goto -288 -> 463
    //   754: iconst_0
    //   755: istore_3
    //   756: goto -268 -> 488
    //   759: aconst_null
    //   760: astore 4
    //   762: goto -245 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	765	0	paramf	f
    //   0	765	1	paramInt1	int
    //   0	765	2	paramd	d
    //   0	765	3	paramInt2	int
    //   0	765	4	paramIntent	Intent
    //   128	578	5	localObject1	Object
    //   293	264	6	localObject2	Object
    //   197	99	7	localContentResolver	android.content.ContentResolver
    //   426	199	8	localCloseable	java.io.Closeable
    //   433	135	9	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   428	445	615	finally
    //   445	455	615	finally
    //   463	470	615	finally
    //   475	485	615	finally
    //   492	511	615	finally
    //   530	541	615	finally
    //   545	564	615	finally
    //   567	577	615	finally
    //   580	612	615	finally
    //   616	623	623	finally
    //   644	671	696	finally
    //   697	704	704	finally
  }
  
  private final void a(f paramf, Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(327791);
    paramActivity = e.bt((Context)paramActivity);
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("vnd.android.cursor.dir/phone_v2");
    ah localah = ah.aiuX;
    paramActivity.a(localIntent, new d..ExternalSyntheticLambda0(paramf, paramInt, this));
    AppMethodBeat.o(327791);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(138159);
    if (paramf == null)
    {
      AppMethodBeat.o(138159);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(138159);
      return;
    }
    Activity localActivity = AndroidContextUtil.castActivityOrNull(paramf.getContext());
    if (localActivity == null)
    {
      paramf.callback(paramInt, "fail:internal error invalid android context");
      AppMethodBeat.o(138159);
      return;
    }
    if ((Build.VERSION.SDK_INT >= 30) && (a.checkSelfPermission((Context)localActivity, "android.permission.READ_CONTACTS") != 0))
    {
      e.bt((Context)localActivity).a(paramf, "android.permission.READ_CONTACTS", new d..ExternalSyntheticLambda1(this, paramf, localActivity, paramJSONObject, paramInt));
      AppMethodBeat.o(138159);
      return;
    }
    a(paramf, localActivity, paramInt);
    AppMethodBeat.o(138159);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.d
 * JD-Core Version:    0.7.0.1
 */