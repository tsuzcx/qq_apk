package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.HashMap;
import java.util.Map;

public abstract class WxaCriticalDataProvider
  extends ContentProvider
{
  private static final UriMatcher cEn;
  private static final SparseArray<String> cEo;
  private final Map<Class<?>, Object> cEp = new HashMap();
  private volatile ISQLiteDatabase db;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    cEo = localSparseArray;
    localSparseArray.put(1, "WxaAttributesTable");
    cEo.put(2, "LaunchWxaAppPBTable");
    cEo.put(4, "DevPkgLaunchExtInfo");
    cEo.put(5, "AppBrandWxaPkgManifestRecord");
    cEn = new UriMatcher(-1);
    int i = 0;
    while (i < cEo.size())
    {
      cEn.addURI(a.AUTHORITY, (String)cEo.valueAt(i), cEo.keyAt(i));
      i += 1;
    }
  }
  
  private boolean SN()
  {
    if (this.db == null) {
      this.db = SO();
    }
    return this.db != null;
  }
  
  private <T> T W(Class<T> paramClass)
  {
    return this.cEp.get(paramClass);
  }
  
  protected static int g(Uri paramUri)
  {
    return cEn.match(paramUri);
  }
  
  protected abstract ISQLiteDatabase SO();
  
  protected final void SP()
  {
    try
    {
      if ((this.db instanceof ISQLiteDatabaseEx)) {
        ((ISQLiteDatabaseEx)this.db).close();
      }
      this.db = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.WxaCriticalDataProvider", localThrowable, "uninstallDatabase", new Object[0]);
      }
    }
  }
  
  protected final void c(Class<?> paramClass, Object paramObject)
  {
    this.cEp.put(paramClass, paramObject);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!SN()) {
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
    //   1: invokespecial 126	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:SN	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 42	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:cEn	Landroid/content/UriMatcher;
    //   12: aload_1
    //   13: invokevirtual 96	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   16: tableswitch	default:+36 -> 52, 1:+38->54, 2:+320->336, 3:+36->52, 4:+388->404, 5:+454->470
    //   53: areturn
    //   54: aload_2
    //   55: ldc 134
    //   57: invokevirtual 140	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   60: ifeq +214 -> 274
    //   63: aload_2
    //   64: ldc 142
    //   66: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 6
    //   71: aload_2
    //   72: ldc 134
    //   74: invokevirtual 150	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   77: astore_1
    //   78: aload_0
    //   79: ldc 152
    //   81: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   84: checkcast 152	com/tencent/mm/plugin/appbrand/config/x
    //   87: astore 7
    //   89: new 156	com/tencent/mm/protocal/protobuf/fnw
    //   92: dup
    //   93: invokespecial 157	com/tencent/mm/protocal/protobuf/fnw:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 161	com/tencent/mm/protocal/protobuf/fnw:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   100: checkcast 156	com/tencent/mm/protocal/protobuf/fnw
    //   103: checkcast 156	com/tencent/mm/protocal/protobuf/fnw
    //   106: astore 8
    //   108: aload 6
    //   110: invokestatic 166	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   113: ifeq +107 -> 220
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifeq +1023 -> 1145
    //   125: aload 8
    //   127: getfield 176	com/tencent/mm/protocal/protobuf/fnw:RTU	Ljava/util/LinkedList;
    //   130: invokevirtual 182	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   133: astore_2
    //   134: aload_2
    //   135: invokeinterface 187 1 0
    //   140: ifeq +1002 -> 1142
    //   143: aload_2
    //   144: invokeinterface 191 1 0
    //   149: checkcast 193	com/tencent/mm/protocal/protobuf/fnv
    //   152: astore 9
    //   154: ldc 195
    //   156: aload 9
    //   158: getfield 198	com/tencent/mm/protocal/protobuf/fnv:CRg	Ljava/lang/String;
    //   161: invokevirtual 201	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   164: ifeq -30 -> 134
    //   167: aload 9
    //   169: getfield 204	com/tencent/mm/protocal/protobuf/fnv:Izj	Ljava/lang/String;
    //   172: astore_1
    //   173: aload_1
    //   174: astore_2
    //   175: aload_1
    //   176: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +75 -> 254
    //   182: ldc 206
    //   184: ldc 208
    //   186: iconst_1
    //   187: anewarray 110	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload 6
    //   194: aastore
    //   195: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -146 -> 52
    //   201: astore_1
    //   202: ldc 106
    //   204: ldc 214
    //   206: iconst_1
    //   207: anewarray 110	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload_1
    //   213: aastore
    //   214: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: goto -165 -> 52
    //   220: aload 7
    //   222: aload 6
    //   224: iconst_1
    //   225: anewarray 58	java/lang/String
    //   228: dup
    //   229: iconst_0
    //   230: ldc 216
    //   232: aastore
    //   233: invokevirtual 220	com/tencent/mm/plugin/appbrand/config/x:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   236: astore_1
    //   237: aload_1
    //   238: ifnonnull +8 -> 246
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -125 -> 118
    //   246: aload_1
    //   247: getfield 225	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_username	Ljava/lang/String;
    //   250: astore_1
    //   251: goto -133 -> 118
    //   254: aload 7
    //   256: aload_2
    //   257: aload 8
    //   259: getfield 229	com/tencent/mm/protocal/protobuf/fnw:RTT	Lcom/tencent/mm/cd/b;
    //   262: aload 8
    //   264: getfield 176	com/tencent/mm/protocal/protobuf/fnw:RTU	Ljava/util/LinkedList;
    //   267: invokevirtual 233	com/tencent/mm/plugin/appbrand/config/x:a	(Ljava/lang/String;Lcom/tencent/mm/cd/b;Ljava/util/List;)Z
    //   270: pop
    //   271: goto -219 -> 52
    //   274: aload_2
    //   275: ldc 235
    //   277: invokevirtual 140	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   280: ifeq -228 -> 52
    //   283: aload_2
    //   284: ldc 237
    //   286: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   289: iconst_0
    //   290: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   293: istore_3
    //   294: aload_2
    //   295: ldc 235
    //   297: invokevirtual 150	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   300: astore_1
    //   301: aload_0
    //   302: ldc 152
    //   304: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   307: checkcast 152	com/tencent/mm/plugin/appbrand/config/x
    //   310: iload_3
    //   311: new 247	com/tencent/mm/protocal/protobuf/lc
    //   314: dup
    //   315: invokespecial 248	com/tencent/mm/protocal/protobuf/lc:<init>	()V
    //   318: aload_1
    //   319: invokevirtual 249	com/tencent/mm/protocal/protobuf/lc:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   322: checkcast 247	com/tencent/mm/protocal/protobuf/lc
    //   325: checkcast 247	com/tencent/mm/protocal/protobuf/lc
    //   328: aconst_null
    //   329: invokevirtual 252	com/tencent/mm/plugin/appbrand/config/x:a	(ILcom/tencent/mm/protocal/protobuf/lc;Ljava/util/List;)Z
    //   332: pop
    //   333: goto -281 -> 52
    //   336: aload_2
    //   337: ldc 142
    //   339: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: astore_1
    //   343: aload_2
    //   344: ldc 134
    //   346: invokevirtual 150	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   349: astore_2
    //   350: aload_0
    //   351: ldc 254
    //   353: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   356: checkcast 254	com/tencent/mm/plugin/appbrand/launching/al
    //   359: aload_1
    //   360: new 256	com/tencent/mm/protocal/protobuf/cqa
    //   363: dup
    //   364: invokespecial 257	com/tencent/mm/protocal/protobuf/cqa:<init>	()V
    //   367: aload_2
    //   368: invokevirtual 258	com/tencent/mm/protocal/protobuf/cqa:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   371: checkcast 256	com/tencent/mm/protocal/protobuf/cqa
    //   374: checkcast 256	com/tencent/mm/protocal/protobuf/cqa
    //   377: invokevirtual 262	com/tencent/mm/plugin/appbrand/launching/al:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/cqa;)Z
    //   380: pop
    //   381: goto -329 -> 52
    //   384: astore_1
    //   385: ldc 106
    //   387: ldc_w 264
    //   390: iconst_1
    //   391: anewarray 110	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_1
    //   397: aastore
    //   398: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: goto -349 -> 52
    //   404: aload_2
    //   405: ldc 142
    //   407: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore_1
    //   411: aload_2
    //   412: ldc_w 266
    //   415: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   418: invokevirtual 271	java/lang/Integer:intValue	()I
    //   421: istore_3
    //   422: aload_2
    //   423: ldc_w 273
    //   426: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   429: astore_2
    //   430: aload_0
    //   431: ldc_w 275
    //   434: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   437: checkcast 275	com/tencent/mm/plugin/appbrand/launching/s
    //   440: aload_1
    //   441: iload_3
    //   442: aload_2
    //   443: invokevirtual 279	com/tencent/mm/plugin/appbrand/launching/s:B	(Ljava/lang/String;ILjava/lang/String;)Z
    //   446: pop
    //   447: goto -395 -> 52
    //   450: astore_1
    //   451: ldc 106
    //   453: ldc_w 281
    //   456: iconst_1
    //   457: anewarray 110	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: aload_1
    //   463: aastore
    //   464: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   467: goto -415 -> 52
    //   470: aload_2
    //   471: ldc_w 283
    //   474: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   477: astore 6
    //   479: iconst_m1
    //   480: istore_3
    //   481: aload 6
    //   483: invokevirtual 286	java/lang/String:hashCode	()I
    //   486: lookupswitch	default:+58->544, -1297425212:+195->681, -946499957:+227->713, -214401522:+275->761, 396944:+243->729, 755152062:+259->745, 1067970480:+211->697
    //   545: tableswitch	default:+39 -> 584, 0:+42->587, 1:+238->783, 2:+339->884, 3:+410->955, 4:+438->983, 5:+524->1069
    //   585: <illegal opcode>
    //   586: <illegal opcode>
    //   587: aload_2
    //   588: ldc 142
    //   590: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   593: astore 6
    //   595: aload_2
    //   596: ldc_w 288
    //   599: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   602: invokevirtual 271	java/lang/Integer:intValue	()I
    //   605: istore_3
    //   606: aload_2
    //   607: ldc_w 290
    //   610: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   613: invokevirtual 271	java/lang/Integer:intValue	()I
    //   616: istore 4
    //   618: aload_2
    //   619: ldc_w 292
    //   622: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   625: astore_1
    //   626: aload_1
    //   627: invokestatic 298	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:afw	(Ljava/lang/String;)Ljava/util/List;
    //   630: astore_1
    //   631: aload_1
    //   632: invokestatic 301	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   635: ifne -583 -> 52
    //   638: aload_0
    //   639: ldc_w 303
    //   642: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   645: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   648: aload 6
    //   650: iload_3
    //   651: iload 4
    //   653: aload_1
    //   654: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;IILjava/util/List;)Z
    //   657: pop
    //   658: goto -606 -> 52
    //   661: astore_1
    //   662: ldc 106
    //   664: ldc_w 281
    //   667: iconst_1
    //   668: anewarray 110	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: aload_1
    //   674: aastore
    //   675: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   678: goto -626 -> 52
    //   681: aload 6
    //   683: ldc_w 308
    //   686: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   689: ifeq -145 -> 544
    //   692: iconst_0
    //   693: istore_3
    //   694: goto -150 -> 544
    //   697: aload 6
    //   699: ldc_w 314
    //   702: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   705: ifeq -161 -> 544
    //   708: iconst_1
    //   709: istore_3
    //   710: goto -166 -> 544
    //   713: aload 6
    //   715: ldc_w 316
    //   718: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   721: ifeq -177 -> 544
    //   724: iconst_2
    //   725: istore_3
    //   726: goto -182 -> 544
    //   729: aload 6
    //   731: ldc_w 318
    //   734: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   737: ifeq -193 -> 544
    //   740: iconst_3
    //   741: istore_3
    //   742: goto -198 -> 544
    //   745: aload 6
    //   747: ldc_w 320
    //   750: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   753: ifeq -209 -> 544
    //   756: iconst_4
    //   757: istore_3
    //   758: goto -214 -> 544
    //   761: aload 6
    //   763: ldc_w 322
    //   766: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   769: ifeq -225 -> 544
    //   772: iconst_5
    //   773: istore_3
    //   774: goto -230 -> 544
    //   777: astore_1
    //   778: aconst_null
    //   779: astore_1
    //   780: goto -149 -> 631
    //   783: aload_2
    //   784: ldc 142
    //   786: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   789: astore 6
    //   791: aload_2
    //   792: ldc_w 288
    //   795: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   798: invokevirtual 271	java/lang/Integer:intValue	()I
    //   801: istore_3
    //   802: aload_2
    //   803: ldc_w 324
    //   806: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 7
    //   811: aload_2
    //   812: ldc_w 326
    //   815: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   818: astore_2
    //   819: aload_0
    //   820: ldc_w 303
    //   823: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   826: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   829: aload 6
    //   831: iload_3
    //   832: aload_2
    //   833: aload 7
    //   835: lconst_0
    //   836: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   839: invokevirtual 335	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   842: ifeq -790 -> 52
    //   845: aload_1
    //   846: getstatic 341	java/util/Locale:US	Ljava/util/Locale;
    //   849: ldc_w 343
    //   852: iconst_3
    //   853: anewarray 110	java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: aload 6
    //   860: aastore
    //   861: dup
    //   862: iconst_1
    //   863: iload_3
    //   864: invokestatic 347	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: aastore
    //   868: dup
    //   869: iconst_2
    //   870: aload 7
    //   872: aastore
    //   873: invokestatic 351	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   876: invokevirtual 286	java/lang/String:hashCode	()I
    //   879: i2l
    //   880: invokestatic 357	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   883: areturn
    //   884: aload_2
    //   885: ldc 142
    //   887: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   890: astore_1
    //   891: aload_2
    //   892: ldc_w 288
    //   895: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   898: invokevirtual 271	java/lang/Integer:intValue	()I
    //   901: istore_3
    //   902: aload_2
    //   903: ldc_w 290
    //   906: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   909: invokevirtual 271	java/lang/Integer:intValue	()I
    //   912: istore 4
    //   914: aload_2
    //   915: ldc_w 324
    //   918: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   921: astore 6
    //   923: aload_2
    //   924: ldc_w 326
    //   927: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   930: astore_2
    //   931: aload_0
    //   932: ldc_w 303
    //   935: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   938: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   941: aload_1
    //   942: iload_3
    //   943: iload 4
    //   945: aload 6
    //   947: aload_2
    //   948: invokevirtual 360	com/tencent/mm/plugin/appbrand/appcache/bm:d	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Z
    //   951: pop
    //   952: goto -900 -> 52
    //   955: aload_2
    //   956: ldc_w 362
    //   959: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   962: astore_1
    //   963: aload_0
    //   964: ldc_w 303
    //   967: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   970: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   973: aload_1
    //   974: invokestatic 368	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo:cz	(Ljava/lang/Object;)Ljava/util/List;
    //   977: invokevirtual 372	com/tencent/mm/plugin/appbrand/appcache/bm:bc	(Ljava/util/List;)V
    //   980: goto -928 -> 52
    //   983: aload_2
    //   984: ldc 142
    //   986: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   989: astore_1
    //   990: aload_2
    //   991: ldc_w 374
    //   994: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   997: astore 6
    //   999: aload_2
    //   1000: ldc_w 290
    //   1003: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1006: invokevirtual 271	java/lang/Integer:intValue	()I
    //   1009: istore_3
    //   1010: aload_2
    //   1011: ldc_w 376
    //   1014: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1017: invokevirtual 271	java/lang/Integer:intValue	()I
    //   1020: istore 4
    //   1022: aload_2
    //   1023: ldc_w 324
    //   1026: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1029: astore 7
    //   1031: aload_2
    //   1032: ldc_w 288
    //   1035: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1038: invokevirtual 271	java/lang/Integer:intValue	()I
    //   1041: istore 5
    //   1043: aload_0
    //   1044: ldc_w 303
    //   1047: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1050: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   1053: aload_1
    //   1054: aload 6
    //   1056: iload_3
    //   1057: iload 4
    //   1059: aload 7
    //   1061: iload 5
    //   1063: invokevirtual 379	com/tencent/mm/plugin/appbrand/appcache/bm:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V
    //   1066: goto -1014 -> 52
    //   1069: aload_2
    //   1070: ldc 142
    //   1072: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: astore_1
    //   1076: aload_2
    //   1077: ldc_w 374
    //   1080: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1083: astore 6
    //   1085: aload_2
    //   1086: ldc_w 290
    //   1089: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1092: invokevirtual 271	java/lang/Integer:intValue	()I
    //   1095: istore_3
    //   1096: aload_2
    //   1097: ldc_w 376
    //   1100: invokevirtual 241	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1103: invokevirtual 271	java/lang/Integer:intValue	()I
    //   1106: istore 4
    //   1108: aload_2
    //   1109: ldc_w 381
    //   1112: invokevirtual 146	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1115: astore_2
    //   1116: aload_0
    //   1117: ldc_w 303
    //   1120: invokespecial 154	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1123: checkcast 303	com/tencent/mm/plugin/appbrand/appcache/bm
    //   1126: aload_1
    //   1127: iload_3
    //   1128: iload 4
    //   1130: aload 6
    //   1132: aload_2
    //   1133: invokestatic 386	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:afx	(Ljava/lang/String;)Ljava/util/List;
    //   1136: invokevirtual 389	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V
    //   1139: goto -1087 -> 52
    //   1142: goto -969 -> 173
    //   1145: aload_1
    //   1146: astore_2
    //   1147: goto -893 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1150	0	this	WxaCriticalDataProvider
    //   0	1150	1	paramUri	Uri
    //   0	1150	2	paramContentValues	ContentValues
    //   293	835	3	i	int
    //   616	513	4	j	int
    //   1041	21	5	k	int
    //   69	1062	6	str	String
    //   87	973	7	localObject	Object
    //   106	157	8	localfnw	com.tencent.mm.protocal.protobuf.fnw
    //   152	16	9	localfnv	com.tencent.mm.protocal.protobuf.fnv
    // Exception table:
    //   from	to	target	type
    //   54	116	201	java/lang/Exception
    //   118	134	201	java/lang/Exception
    //   134	173	201	java/lang/Exception
    //   175	198	201	java/lang/Exception
    //   220	237	201	java/lang/Exception
    //   246	251	201	java/lang/Exception
    //   254	271	201	java/lang/Exception
    //   274	333	201	java/lang/Exception
    //   336	381	384	java/lang/Exception
    //   404	447	450	java/lang/Exception
    //   587	626	661	java/lang/Exception
    //   631	658	661	java/lang/Exception
    //   626	631	777	java/lang/Exception
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!SN()) {}
    do
    {
      return null;
      paramUri = (String)cEo.get(cEn.match(paramUri));
    } while (TextUtils.isEmpty(paramUri));
    return this.db.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    if (!SN()) {
      return -1;
    }
    switch (cEn.match(paramUri))
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
    if (((bm)W(bm.class)).G(paramUri, i, j)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */