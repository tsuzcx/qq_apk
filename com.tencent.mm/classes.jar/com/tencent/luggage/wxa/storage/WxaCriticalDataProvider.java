package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public abstract class WxaCriticalDataProvider
  extends ContentProvider
{
  private static final UriMatcher cgv;
  private static final SparseArray<String> cgw;
  private final Map<Class<?>, Object> cgx = new HashMap();
  private volatile e db;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    cgw = localSparseArray;
    localSparseArray.put(1, "WxaAttributesTable");
    cgw.put(2, "LaunchWxaAppPBTable");
    cgw.put(3, "WxaAppPackageModelTable");
    cgw.put(4, "DevPkgLaunchExtInfo");
    cgw.put(5, "AppBrandWxaPkgManifestRecord");
    cgv = new UriMatcher(-1);
    int i = 0;
    while (i < cgw.size())
    {
      cgv.addURI(a.AUTHORITY, (String)cgw.valueAt(i), cgw.keyAt(i));
      i += 1;
    }
  }
  
  private boolean Ea()
  {
    if (this.db == null) {
      this.db = Eb();
    }
    return this.db != null;
  }
  
  private <T> T T(Class<T> paramClass)
  {
    return this.cgx.get(paramClass);
  }
  
  protected static int p(Uri paramUri)
  {
    return cgv.match(paramUri);
  }
  
  protected abstract e Eb();
  
  protected final void Ec()
  {
    try
    {
      if ((this.db instanceof f)) {
        ((f)this.db).close();
      }
      this.db = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.printErrStackTrace("Luggage.WxaCriticalDataProvider", localThrowable, "uninstallDatabase", new Object[0]);
      }
    }
  }
  
  protected final void c(Class<?> paramClass, Object paramObject)
  {
    this.cgx.put(paramClass, paramObject);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!Ea()) {
      return -1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  /* Error */
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 128	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:Ea	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 44	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:cgv	Landroid/content/UriMatcher;
    //   12: aload_1
    //   13: invokevirtual 98	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   16: tableswitch	default:+36 -> 52, 1:+38->54, 2:+307->323, 3:+36->52, 4:+374->390, 5:+440->456
    //   53: areturn
    //   54: aload_2
    //   55: ldc 136
    //   57: invokevirtual 142	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   60: ifeq +214 -> 274
    //   63: aload_2
    //   64: ldc 144
    //   66: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 6
    //   71: aload_2
    //   72: ldc 136
    //   74: invokevirtual 152	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   77: astore_1
    //   78: aload_0
    //   79: ldc 154
    //   81: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   84: checkcast 154	com/tencent/mm/plugin/appbrand/config/t
    //   87: astore 7
    //   89: new 158	com/tencent/mm/protocal/protobuf/eai
    //   92: dup
    //   93: invokespecial 159	com/tencent/mm/protocal/protobuf/eai:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 163	com/tencent/mm/protocal/protobuf/eai:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   100: checkcast 158	com/tencent/mm/protocal/protobuf/eai
    //   103: checkcast 158	com/tencent/mm/protocal/protobuf/eai
    //   106: astore 8
    //   108: aload 6
    //   110: invokestatic 168	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   113: ifeq +107 -> 220
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +1011 -> 1133
    //   125: aload 8
    //   127: getfield 178	com/tencent/mm/protocal/protobuf/eai:EaX	Ljava/util/LinkedList;
    //   130: invokevirtual 184	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   133: astore_2
    //   134: aload_2
    //   135: invokeinterface 189 1 0
    //   140: ifeq +990 -> 1130
    //   143: aload_2
    //   144: invokeinterface 193 1 0
    //   149: checkcast 195	com/tencent/mm/protocal/protobuf/eah
    //   152: astore 9
    //   154: ldc 197
    //   156: aload 9
    //   158: getfield 200	com/tencent/mm/protocal/protobuf/eah:tlp	Ljava/lang/String;
    //   161: invokevirtual 203	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   164: ifeq -30 -> 134
    //   167: aload 9
    //   169: getfield 206	com/tencent/mm/protocal/protobuf/eah:wTM	Ljava/lang/String;
    //   172: astore_1
    //   173: aload_1
    //   174: astore_2
    //   175: aload_1
    //   176: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +75 -> 254
    //   182: ldc 208
    //   184: ldc 210
    //   186: iconst_1
    //   187: anewarray 112	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload 6
    //   194: aastore
    //   195: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -146 -> 52
    //   201: astore_1
    //   202: ldc 108
    //   204: ldc 216
    //   206: iconst_1
    //   207: anewarray 112	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_1
    //   213: aastore
    //   214: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: goto -165 -> 52
    //   220: aload 7
    //   222: aload 6
    //   224: iconst_1
    //   225: anewarray 60	java/lang/String
    //   228: dup
    //   229: iconst_0
    //   230: ldc 218
    //   232: aastore
    //   233: invokevirtual 221	com/tencent/mm/plugin/appbrand/config/t:e	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   236: astore_1
    //   237: aload_1
    //   238: ifnonnull +8 -> 246
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -125 -> 118
    //   246: aload_1
    //   247: getfield 226	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_username	Ljava/lang/String;
    //   250: astore_1
    //   251: goto -133 -> 118
    //   254: aload 7
    //   256: aload_2
    //   257: aload 8
    //   259: getfield 230	com/tencent/mm/protocal/protobuf/eai:EaW	Lcom/tencent/mm/bw/b;
    //   262: aload 8
    //   264: getfield 178	com/tencent/mm/protocal/protobuf/eai:EaX	Ljava/util/LinkedList;
    //   267: invokevirtual 234	com/tencent/mm/plugin/appbrand/config/t:a	(Ljava/lang/String;Lcom/tencent/mm/bw/b;Ljava/util/List;)Z
    //   270: pop
    //   271: goto -219 -> 52
    //   274: aload_2
    //   275: ldc 236
    //   277: invokevirtual 142	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   280: ifeq -228 -> 52
    //   283: aload_2
    //   284: ldc 236
    //   286: invokevirtual 152	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   289: astore_1
    //   290: aload_0
    //   291: ldc 154
    //   293: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   296: checkcast 154	com/tencent/mm/plugin/appbrand/config/t
    //   299: new 238	com/tencent/mm/protocal/protobuf/km
    //   302: dup
    //   303: invokespecial 239	com/tencent/mm/protocal/protobuf/km:<init>	()V
    //   306: aload_1
    //   307: invokevirtual 240	com/tencent/mm/protocal/protobuf/km:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   310: checkcast 238	com/tencent/mm/protocal/protobuf/km
    //   313: checkcast 238	com/tencent/mm/protocal/protobuf/km
    //   316: invokevirtual 243	com/tencent/mm/plugin/appbrand/config/t:a	(Lcom/tencent/mm/protocal/protobuf/km;)Z
    //   319: pop
    //   320: goto -268 -> 52
    //   323: aload_2
    //   324: ldc 144
    //   326: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore_1
    //   330: aload_2
    //   331: ldc 136
    //   333: invokevirtual 152	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   336: astore_2
    //   337: aload_0
    //   338: ldc 245
    //   340: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   343: checkcast 245	com/tencent/mm/plugin/appbrand/launching/aw
    //   346: aload_1
    //   347: new 247	com/tencent/mm/protocal/protobuf/bot
    //   350: dup
    //   351: invokespecial 248	com/tencent/mm/protocal/protobuf/bot:<init>	()V
    //   354: aload_2
    //   355: invokevirtual 249	com/tencent/mm/protocal/protobuf/bot:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   358: checkcast 247	com/tencent/mm/protocal/protobuf/bot
    //   361: checkcast 247	com/tencent/mm/protocal/protobuf/bot
    //   364: invokevirtual 253	com/tencent/mm/plugin/appbrand/launching/aw:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/bot;)Z
    //   367: pop
    //   368: goto -316 -> 52
    //   371: astore_1
    //   372: ldc 108
    //   374: ldc 255
    //   376: iconst_1
    //   377: anewarray 112	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload_1
    //   383: aastore
    //   384: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: goto -335 -> 52
    //   390: aload_2
    //   391: ldc 144
    //   393: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: astore_1
    //   397: aload_2
    //   398: ldc_w 257
    //   401: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   404: invokevirtual 266	java/lang/Integer:intValue	()I
    //   407: istore_3
    //   408: aload_2
    //   409: ldc_w 268
    //   412: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   415: astore_2
    //   416: aload_0
    //   417: ldc_w 270
    //   420: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   423: checkcast 270	com/tencent/mm/plugin/appbrand/launching/t
    //   426: aload_1
    //   427: iload_3
    //   428: aload_2
    //   429: invokevirtual 274	com/tencent/mm/plugin/appbrand/launching/t:s	(Ljava/lang/String;ILjava/lang/String;)Z
    //   432: pop
    //   433: goto -381 -> 52
    //   436: astore_1
    //   437: ldc 108
    //   439: ldc_w 276
    //   442: iconst_1
    //   443: anewarray 112	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload_1
    //   449: aastore
    //   450: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: goto -401 -> 52
    //   456: aload_2
    //   457: ldc_w 278
    //   460: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   463: astore 6
    //   465: iconst_m1
    //   466: istore_3
    //   467: aload 6
    //   469: invokevirtual 281	java/lang/String:hashCode	()I
    //   472: lookupswitch	default:+60->532, -1297425212:+197->669, -946499957:+229->701, -214401522:+277->749, 396944:+245->717, 755152062:+261->733, 1067970480:+213->685
    //   533: tableswitch	default:+39 -> 572, 0:+42->575, 1:+238->771, 2:+339->872, 3:+410->943, 4:+438->971, 5:+524->1057
    //   573: <illegal opcode>
    //   574: <illegal opcode>
    //   575: aload_2
    //   576: ldc 144
    //   578: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: astore 6
    //   583: aload_2
    //   584: ldc_w 283
    //   587: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   590: invokevirtual 266	java/lang/Integer:intValue	()I
    //   593: istore_3
    //   594: aload_2
    //   595: ldc_w 285
    //   598: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   601: invokevirtual 266	java/lang/Integer:intValue	()I
    //   604: istore 4
    //   606: aload_2
    //   607: ldc_w 287
    //   610: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: astore_1
    //   614: aload_1
    //   615: invokestatic 293	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:Kz	(Ljava/lang/String;)Ljava/util/List;
    //   618: astore_1
    //   619: aload_1
    //   620: invokestatic 297	com/tencent/mm/sdk/platformtools/bs:gY	(Ljava/util/List;)Z
    //   623: ifne -571 -> 52
    //   626: aload_0
    //   627: ldc_w 299
    //   630: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   633: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   636: aload 6
    //   638: iload_3
    //   639: iload 4
    //   641: aload_1
    //   642: invokevirtual 302	com/tencent/mm/plugin/appbrand/appcache/bf:a	(Ljava/lang/String;IILjava/util/List;)Z
    //   645: pop
    //   646: goto -594 -> 52
    //   649: astore_1
    //   650: ldc 108
    //   652: ldc_w 276
    //   655: iconst_1
    //   656: anewarray 112	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: aload_1
    //   662: aastore
    //   663: invokestatic 214	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   666: goto -614 -> 52
    //   669: aload 6
    //   671: ldc_w 304
    //   674: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   677: ifeq -145 -> 532
    //   680: iconst_0
    //   681: istore_3
    //   682: goto -150 -> 532
    //   685: aload 6
    //   687: ldc_w 310
    //   690: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   693: ifeq -161 -> 532
    //   696: iconst_1
    //   697: istore_3
    //   698: goto -166 -> 532
    //   701: aload 6
    //   703: ldc_w 312
    //   706: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   709: ifeq -177 -> 532
    //   712: iconst_2
    //   713: istore_3
    //   714: goto -182 -> 532
    //   717: aload 6
    //   719: ldc_w 314
    //   722: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   725: ifeq -193 -> 532
    //   728: iconst_3
    //   729: istore_3
    //   730: goto -198 -> 532
    //   733: aload 6
    //   735: ldc_w 316
    //   738: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifeq -209 -> 532
    //   744: iconst_4
    //   745: istore_3
    //   746: goto -214 -> 532
    //   749: aload 6
    //   751: ldc_w 318
    //   754: invokevirtual 308	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   757: ifeq -225 -> 532
    //   760: iconst_5
    //   761: istore_3
    //   762: goto -230 -> 532
    //   765: astore_1
    //   766: aconst_null
    //   767: astore_1
    //   768: goto -149 -> 619
    //   771: aload_2
    //   772: ldc 144
    //   774: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   777: astore 6
    //   779: aload_2
    //   780: ldc_w 283
    //   783: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   786: invokevirtual 266	java/lang/Integer:intValue	()I
    //   789: istore_3
    //   790: aload_2
    //   791: ldc_w 320
    //   794: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   797: astore 7
    //   799: aload_2
    //   800: ldc_w 322
    //   803: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   806: astore_2
    //   807: aload_0
    //   808: ldc_w 299
    //   811: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   814: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   817: aload 6
    //   819: iload_3
    //   820: aload_2
    //   821: aload 7
    //   823: lconst_0
    //   824: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   827: invokevirtual 331	com/tencent/mm/plugin/appbrand/appcache/bf:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   830: ifeq -778 -> 52
    //   833: aload_1
    //   834: getstatic 337	java/util/Locale:US	Ljava/util/Locale;
    //   837: ldc_w 339
    //   840: iconst_3
    //   841: anewarray 112	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: aload 6
    //   848: aastore
    //   849: dup
    //   850: iconst_1
    //   851: iload_3
    //   852: invokestatic 343	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   855: aastore
    //   856: dup
    //   857: iconst_2
    //   858: aload 7
    //   860: aastore
    //   861: invokestatic 347	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   864: invokevirtual 281	java/lang/String:hashCode	()I
    //   867: i2l
    //   868: invokestatic 353	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   871: areturn
    //   872: aload_2
    //   873: ldc 144
    //   875: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   878: astore_1
    //   879: aload_2
    //   880: ldc_w 283
    //   883: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   886: invokevirtual 266	java/lang/Integer:intValue	()I
    //   889: istore_3
    //   890: aload_2
    //   891: ldc_w 285
    //   894: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   897: invokevirtual 266	java/lang/Integer:intValue	()I
    //   900: istore 4
    //   902: aload_2
    //   903: ldc_w 320
    //   906: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   909: astore 6
    //   911: aload_2
    //   912: ldc_w 322
    //   915: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   918: astore_2
    //   919: aload_0
    //   920: ldc_w 299
    //   923: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   926: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   929: aload_1
    //   930: iload_3
    //   931: iload 4
    //   933: aload 6
    //   935: aload_2
    //   936: invokevirtual 357	com/tencent/mm/plugin/appbrand/appcache/bf:d	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Z
    //   939: pop
    //   940: goto -888 -> 52
    //   943: aload_2
    //   944: ldc_w 359
    //   947: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   950: astore_1
    //   951: aload_0
    //   952: ldc_w 299
    //   955: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   958: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   961: aload_1
    //   962: invokestatic 364	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo:Kx	(Ljava/lang/String;)Ljava/util/List;
    //   965: invokevirtual 368	com/tencent/mm/plugin/appbrand/appcache/bf:aT	(Ljava/util/List;)V
    //   968: goto -916 -> 52
    //   971: aload_2
    //   972: ldc 144
    //   974: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   977: astore_1
    //   978: aload_2
    //   979: ldc_w 370
    //   982: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   985: astore 6
    //   987: aload_2
    //   988: ldc_w 285
    //   991: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   994: invokevirtual 266	java/lang/Integer:intValue	()I
    //   997: istore_3
    //   998: aload_2
    //   999: ldc_w 372
    //   1002: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1005: invokevirtual 266	java/lang/Integer:intValue	()I
    //   1008: istore 4
    //   1010: aload_2
    //   1011: ldc_w 320
    //   1014: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1017: astore 7
    //   1019: aload_2
    //   1020: ldc_w 283
    //   1023: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1026: invokevirtual 266	java/lang/Integer:intValue	()I
    //   1029: istore 5
    //   1031: aload_0
    //   1032: ldc_w 299
    //   1035: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1038: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   1041: aload_1
    //   1042: aload 6
    //   1044: iload_3
    //   1045: iload 4
    //   1047: aload 7
    //   1049: iload 5
    //   1051: invokevirtual 375	com/tencent/mm/plugin/appbrand/appcache/bf:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V
    //   1054: goto -1002 -> 52
    //   1057: aload_2
    //   1058: ldc 144
    //   1060: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1063: astore_1
    //   1064: aload_2
    //   1065: ldc_w 370
    //   1068: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1071: astore 6
    //   1073: aload_2
    //   1074: ldc_w 285
    //   1077: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1080: invokevirtual 266	java/lang/Integer:intValue	()I
    //   1083: istore_3
    //   1084: aload_2
    //   1085: ldc_w 372
    //   1088: invokevirtual 261	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1091: invokevirtual 266	java/lang/Integer:intValue	()I
    //   1094: istore 4
    //   1096: aload_2
    //   1097: ldc_w 377
    //   1100: invokevirtual 148	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1103: astore_2
    //   1104: aload_0
    //   1105: ldc_w 299
    //   1108: invokespecial 156	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1111: checkcast 299	com/tencent/mm/plugin/appbrand/appcache/bf
    //   1114: aload_1
    //   1115: iload_3
    //   1116: iload 4
    //   1118: aload 6
    //   1120: aload_2
    //   1121: invokestatic 382	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:KA	(Ljava/lang/String;)Ljava/util/List;
    //   1124: invokevirtual 385	com/tencent/mm/plugin/appbrand/appcache/bf:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V
    //   1127: goto -1075 -> 52
    //   1130: goto -957 -> 173
    //   1133: aload_1
    //   1134: astore_2
    //   1135: goto -881 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1138	0	this	WxaCriticalDataProvider
    //   0	1138	1	paramUri	Uri
    //   0	1138	2	paramContentValues	ContentValues
    //   407	709	3	i	int
    //   604	513	4	j	int
    //   1029	21	5	k	int
    //   69	1050	6	str	String
    //   87	961	7	localObject	Object
    //   106	157	8	localeai	com.tencent.mm.protocal.protobuf.eai
    //   152	16	9	localeah	com.tencent.mm.protocal.protobuf.eah
    // Exception table:
    //   from	to	target	type
    //   54	116	201	java/lang/Exception
    //   118	134	201	java/lang/Exception
    //   134	173	201	java/lang/Exception
    //   175	198	201	java/lang/Exception
    //   220	237	201	java/lang/Exception
    //   246	251	201	java/lang/Exception
    //   254	271	201	java/lang/Exception
    //   274	320	201	java/lang/Exception
    //   323	368	371	java/lang/Exception
    //   390	433	436	java/lang/Exception
    //   575	614	649	java/lang/Exception
    //   619	646	649	java/lang/Exception
    //   614	619	765	java/lang/Exception
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!Ea()) {}
    do
    {
      return null;
      paramUri = (String)cgw.get(cgv.match(paramUri));
    } while (TextUtils.isEmpty(paramUri));
    return this.db.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    if (!Ea()) {
      return -1;
    }
    switch (cgv.match(paramUri))
    {
    default: 
      return 0;
    }
    paramUri = paramContentValues.getAsString("CONTENT_KEY_ACTION");
    switch (paramUri.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0;
        if (paramUri.equals("ACTION_DELETE_MODULE_LIST")) {
          i = 0;
        }
        break;
      }
    }
    paramUri = paramContentValues.getAsString("CONTENT_KEY_APPID");
    i = paramContentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue();
    int j = paramContentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue();
    if (((bf)T(bf.class)).C(paramUri, i, j)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */