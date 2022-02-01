package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.HashMap;
import java.util.Map;

public abstract class WxaCriticalDataProvider
  extends ContentProvider
{
  private static final UriMatcher exy;
  private static final SparseArray<String> exz;
  private volatile ISQLiteDatabase db;
  private final Map<Class<?>, Object> exA = new HashMap();
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    exz = localSparseArray;
    localSparseArray.put(1, "WxaAttributesTable");
    exz.put(2, "LaunchWxaAppPBTable");
    exz.put(4, "DevPkgLaunchExtInfo");
    exz.put(5, "AppBrandWxaPkgManifestRecord");
    exz.put(7, "PersistentWxaSyncInvalidContactCmd");
    exy = new UriMatcher(-1);
    int i = 0;
    while (i < exz.size())
    {
      exy.addURI(a.AUTHORITY, (String)exz.valueAt(i), exz.keyAt(i));
      i += 1;
    }
  }
  
  private <T> T ag(Class<T> paramClass)
  {
    return this.exA.get(paramClass);
  }
  
  private boolean ats()
  {
    if (this.db == null) {
      this.db = att();
    }
    return this.db != null;
  }
  
  protected static int i(Uri paramUri)
  {
    return exy.match(paramUri);
  }
  
  protected abstract ISQLiteDatabase att();
  
  protected final void atu()
  {
    try
    {
      if ((this.db instanceof ISQLiteDatabaseEx)) {
        ((ISQLiteDatabaseEx)this.db).close();
      }
      this.db = null;
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("Luggage.WxaCriticalDataProvider", localThrowable, "uninstallDatabase", new Object[0]);
      }
    }
  }
  
  protected final void c(Class<?> paramClass, Object paramObject)
  {
    this.exA.put(paramClass, paramObject);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!ats()) {}
    do
    {
      do
      {
        return -1;
        switch (exy.match(paramUri))
        {
        default: 
          return 0;
        }
      } while ((paramArrayOfString == null) || (paramArrayOfString.length <= 0));
      paramUri = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramUri));
    if (((l)ag(l.class)).VR(paramUri)) {
      return 1;
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
    //   1: invokespecial 126	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ats	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 44	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:exy	Landroid/content/UriMatcher;
    //   12: aload_1
    //   13: invokevirtual 98	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   16: tableswitch	default:+36 -> 52, 1:+38->54, 2:+313->329, 3:+36->52, 4:+379->395, 5:+445->461
    //   53: areturn
    //   54: aload_2
    //   55: ldc 148
    //   57: invokevirtual 153	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   60: ifeq +211 -> 271
    //   63: aload_2
    //   64: ldc 155
    //   66: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 6
    //   71: aload_2
    //   72: ldc 148
    //   74: invokevirtual 163	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   77: astore_1
    //   78: aload_0
    //   79: ldc 165
    //   81: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   84: checkcast 165	com/tencent/mm/plugin/appbrand/config/ac
    //   87: astore 7
    //   89: new 167	com/tencent/mm/protocal/protobuf/gkv
    //   92: dup
    //   93: invokespecial 168	com/tencent/mm/protocal/protobuf/gkv:<init>	()V
    //   96: aload_1
    //   97: invokevirtual 172	com/tencent/mm/protocal/protobuf/gkv:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   100: checkcast 167	com/tencent/mm/protocal/protobuf/gkv
    //   103: astore 8
    //   105: aload 6
    //   107: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   110: ifeq +107 -> 217
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifeq +1018 -> 1137
    //   122: aload 8
    //   124: getfield 181	com/tencent/mm/protocal/protobuf/gkv:YRu	Ljava/util/LinkedList;
    //   127: invokevirtual 187	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   130: astore_2
    //   131: aload_2
    //   132: invokeinterface 192 1 0
    //   137: ifeq +997 -> 1134
    //   140: aload_2
    //   141: invokeinterface 196 1 0
    //   146: checkcast 198	com/tencent/mm/protocal/protobuf/gku
    //   149: astore 9
    //   151: ldc 200
    //   153: aload 9
    //   155: getfield 203	com/tencent/mm/protocal/protobuf/gku:ILw	Ljava/lang/String;
    //   158: invokevirtual 206	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   161: ifeq -30 -> 131
    //   164: aload 9
    //   166: getfield 209	com/tencent/mm/protocal/protobuf/gku:OzQ	Ljava/lang/String;
    //   169: astore_1
    //   170: aload_1
    //   171: astore_2
    //   172: aload_1
    //   173: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifeq +75 -> 251
    //   179: ldc 211
    //   181: ldc 213
    //   183: iconst_1
    //   184: anewarray 110	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 6
    //   191: aastore
    //   192: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -143 -> 52
    //   198: astore_1
    //   199: ldc 106
    //   201: ldc 219
    //   203: iconst_1
    //   204: anewarray 110	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_1
    //   210: aastore
    //   211: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -162 -> 52
    //   217: aload 7
    //   219: aload 6
    //   221: iconst_1
    //   222: anewarray 60	java/lang/String
    //   225: dup
    //   226: iconst_0
    //   227: ldc 221
    //   229: aastore
    //   230: invokevirtual 224	com/tencent/mm/plugin/appbrand/config/ac:e	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   233: astore_1
    //   234: aload_1
    //   235: ifnonnull +8 -> 243
    //   238: aconst_null
    //   239: astore_1
    //   240: goto -125 -> 115
    //   243: aload_1
    //   244: getfield 229	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_username	Ljava/lang/String;
    //   247: astore_1
    //   248: goto -133 -> 115
    //   251: aload 7
    //   253: aload_2
    //   254: aload 8
    //   256: getfield 233	com/tencent/mm/protocal/protobuf/gkv:YRt	Lcom/tencent/mm/bx/b;
    //   259: aload 8
    //   261: getfield 181	com/tencent/mm/protocal/protobuf/gkv:YRu	Ljava/util/LinkedList;
    //   264: invokevirtual 237	com/tencent/mm/plugin/appbrand/config/ac:a	(Ljava/lang/String;Lcom/tencent/mm/bx/b;Ljava/util/List;)Z
    //   267: pop
    //   268: goto -216 -> 52
    //   271: aload_2
    //   272: ldc 239
    //   274: invokevirtual 153	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   277: ifeq -225 -> 52
    //   280: aload_2
    //   281: ldc 241
    //   283: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   286: iconst_0
    //   287: invokestatic 249	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   290: istore_3
    //   291: aload_2
    //   292: ldc 239
    //   294: invokevirtual 163	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   297: astore_1
    //   298: aload_0
    //   299: ldc 165
    //   301: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   304: checkcast 165	com/tencent/mm/plugin/appbrand/config/ac
    //   307: iload_3
    //   308: new 251	com/tencent/mm/protocal/protobuf/md
    //   311: dup
    //   312: invokespecial 252	com/tencent/mm/protocal/protobuf/md:<init>	()V
    //   315: aload_1
    //   316: invokevirtual 253	com/tencent/mm/protocal/protobuf/md:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   319: checkcast 251	com/tencent/mm/protocal/protobuf/md
    //   322: invokevirtual 256	com/tencent/mm/plugin/appbrand/config/ac:a	(ILcom/tencent/mm/protocal/protobuf/md;)Z
    //   325: pop
    //   326: goto -274 -> 52
    //   329: aload_2
    //   330: ldc 155
    //   332: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore_1
    //   336: aload_2
    //   337: ldc 148
    //   339: invokevirtual 163	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   342: astore_2
    //   343: aload_0
    //   344: ldc_w 258
    //   347: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   350: checkcast 258	com/tencent/mm/plugin/appbrand/launching/am
    //   353: aload_1
    //   354: new 260	com/tencent/mm/protocal/protobuf/dgu
    //   357: dup
    //   358: invokespecial 261	com/tencent/mm/protocal/protobuf/dgu:<init>	()V
    //   361: aload_2
    //   362: invokevirtual 262	com/tencent/mm/protocal/protobuf/dgu:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   365: checkcast 260	com/tencent/mm/protocal/protobuf/dgu
    //   368: invokevirtual 266	com/tencent/mm/plugin/appbrand/launching/am:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/dgu;)Z
    //   371: pop
    //   372: goto -320 -> 52
    //   375: astore_1
    //   376: ldc 106
    //   378: ldc_w 268
    //   381: iconst_1
    //   382: anewarray 110	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload_1
    //   388: aastore
    //   389: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: goto -340 -> 52
    //   395: aload_2
    //   396: ldc 155
    //   398: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore_1
    //   402: aload_2
    //   403: ldc_w 270
    //   406: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   409: invokevirtual 275	java/lang/Integer:intValue	()I
    //   412: istore_3
    //   413: aload_2
    //   414: ldc_w 277
    //   417: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore_2
    //   421: aload_0
    //   422: ldc_w 279
    //   425: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   428: checkcast 279	com/tencent/mm/plugin/appbrand/launching/t
    //   431: aload_1
    //   432: iload_3
    //   433: aload_2
    //   434: invokevirtual 283	com/tencent/mm/plugin/appbrand/launching/t:D	(Ljava/lang/String;ILjava/lang/String;)Z
    //   437: pop
    //   438: goto -386 -> 52
    //   441: astore_1
    //   442: ldc 106
    //   444: ldc_w 285
    //   447: iconst_1
    //   448: anewarray 110	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload_1
    //   454: aastore
    //   455: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: goto -406 -> 52
    //   461: aload_2
    //   462: ldc_w 287
    //   465: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore 6
    //   470: iconst_m1
    //   471: istore_3
    //   472: aload 6
    //   474: invokevirtual 290	java/lang/String:hashCode	()I
    //   477: lookupswitch	default:+59->536, -1297425212:+196->673, -946499957:+228->705, -214401522:+276->753, 396944:+244->721, 755152062:+260->737, 1067970480:+212->689
    //   537: tableswitch	default:+39 -> 576, 0:+42->579, 1:+238->775, 2:+339->876, 3:+410->947, 4:+438->975, 5:+524->1061
    //   577: <illegal opcode>
    //   578: <illegal opcode>
    //   579: aload_2
    //   580: ldc 155
    //   582: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   585: astore 6
    //   587: aload_2
    //   588: ldc_w 292
    //   591: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   594: invokevirtual 275	java/lang/Integer:intValue	()I
    //   597: istore_3
    //   598: aload_2
    //   599: ldc_w 294
    //   602: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 275	java/lang/Integer:intValue	()I
    //   608: istore 4
    //   610: aload_2
    //   611: ldc_w 296
    //   614: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore_1
    //   618: aload_1
    //   619: invokestatic 302	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:XX	(Ljava/lang/String;)Ljava/util/List;
    //   622: astore_1
    //   623: aload_1
    //   624: invokestatic 305	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   627: ifne -575 -> 52
    //   630: aload_0
    //   631: ldc_w 307
    //   634: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   637: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   640: aload 6
    //   642: iload_3
    //   643: iload 4
    //   645: aload_1
    //   646: invokevirtual 310	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;IILjava/util/List;)Z
    //   649: pop
    //   650: goto -598 -> 52
    //   653: astore_1
    //   654: ldc 106
    //   656: ldc_w 285
    //   659: iconst_1
    //   660: anewarray 110	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: aload_1
    //   666: aastore
    //   667: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   670: goto -618 -> 52
    //   673: aload 6
    //   675: ldc_w 312
    //   678: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   681: ifeq -145 -> 536
    //   684: iconst_0
    //   685: istore_3
    //   686: goto -150 -> 536
    //   689: aload 6
    //   691: ldc_w 318
    //   694: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   697: ifeq -161 -> 536
    //   700: iconst_1
    //   701: istore_3
    //   702: goto -166 -> 536
    //   705: aload 6
    //   707: ldc_w 320
    //   710: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   713: ifeq -177 -> 536
    //   716: iconst_2
    //   717: istore_3
    //   718: goto -182 -> 536
    //   721: aload 6
    //   723: ldc_w 322
    //   726: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   729: ifeq -193 -> 536
    //   732: iconst_3
    //   733: istore_3
    //   734: goto -198 -> 536
    //   737: aload 6
    //   739: ldc_w 324
    //   742: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   745: ifeq -209 -> 536
    //   748: iconst_4
    //   749: istore_3
    //   750: goto -214 -> 536
    //   753: aload 6
    //   755: ldc_w 326
    //   758: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifeq -225 -> 536
    //   764: iconst_5
    //   765: istore_3
    //   766: goto -230 -> 536
    //   769: astore_1
    //   770: aconst_null
    //   771: astore_1
    //   772: goto -149 -> 623
    //   775: aload_2
    //   776: ldc 155
    //   778: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: astore 6
    //   783: aload_2
    //   784: ldc_w 292
    //   787: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   790: invokevirtual 275	java/lang/Integer:intValue	()I
    //   793: istore_3
    //   794: aload_2
    //   795: ldc_w 328
    //   798: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   801: astore 7
    //   803: aload_2
    //   804: ldc_w 330
    //   807: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   810: astore_2
    //   811: aload_0
    //   812: ldc_w 307
    //   815: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   818: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   821: aload 6
    //   823: iload_3
    //   824: aload_2
    //   825: aload 7
    //   827: lconst_0
    //   828: invokestatic 336	java/lang/System:currentTimeMillis	()J
    //   831: invokevirtual 339	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   834: ifeq -782 -> 52
    //   837: aload_1
    //   838: getstatic 345	java/util/Locale:US	Ljava/util/Locale;
    //   841: ldc_w 347
    //   844: iconst_3
    //   845: anewarray 110	java/lang/Object
    //   848: dup
    //   849: iconst_0
    //   850: aload 6
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: iload_3
    //   856: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: aastore
    //   860: dup
    //   861: iconst_2
    //   862: aload 7
    //   864: aastore
    //   865: invokestatic 355	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   868: invokevirtual 290	java/lang/String:hashCode	()I
    //   871: i2l
    //   872: invokestatic 361	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   875: areturn
    //   876: aload_2
    //   877: ldc 155
    //   879: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   882: astore_1
    //   883: aload_2
    //   884: ldc_w 292
    //   887: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   890: invokevirtual 275	java/lang/Integer:intValue	()I
    //   893: istore_3
    //   894: aload_2
    //   895: ldc_w 294
    //   898: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   901: invokevirtual 275	java/lang/Integer:intValue	()I
    //   904: istore 4
    //   906: aload_2
    //   907: ldc_w 328
    //   910: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   913: astore 6
    //   915: aload_2
    //   916: ldc_w 330
    //   919: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   922: astore_2
    //   923: aload_0
    //   924: ldc_w 307
    //   927: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   930: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   933: aload_1
    //   934: iload_3
    //   935: iload 4
    //   937: aload 6
    //   939: aload_2
    //   940: invokevirtual 365	com/tencent/mm/plugin/appbrand/appcache/bm:d	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Z
    //   943: pop
    //   944: goto -892 -> 52
    //   947: aload_2
    //   948: ldc_w 367
    //   951: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   954: astore_1
    //   955: aload_0
    //   956: ldc_w 307
    //   959: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   962: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   965: aload_1
    //   966: invokestatic 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaPluginCodeInfo:dU	(Ljava/lang/Object;)Ljava/util/List;
    //   969: invokevirtual 377	com/tencent/mm/plugin/appbrand/appcache/bm:cK	(Ljava/util/List;)V
    //   972: goto -920 -> 52
    //   975: aload_2
    //   976: ldc 155
    //   978: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   981: astore_1
    //   982: aload_2
    //   983: ldc_w 379
    //   986: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   989: astore 6
    //   991: aload_2
    //   992: ldc_w 294
    //   995: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   998: invokevirtual 275	java/lang/Integer:intValue	()I
    //   1001: istore_3
    //   1002: aload_2
    //   1003: ldc_w 381
    //   1006: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1009: invokevirtual 275	java/lang/Integer:intValue	()I
    //   1012: istore 4
    //   1014: aload_2
    //   1015: ldc_w 328
    //   1018: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1021: astore 7
    //   1023: aload_2
    //   1024: ldc_w 292
    //   1027: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1030: invokevirtual 275	java/lang/Integer:intValue	()I
    //   1033: istore 5
    //   1035: aload_0
    //   1036: ldc_w 307
    //   1039: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1042: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   1045: aload_1
    //   1046: aload 6
    //   1048: iload_3
    //   1049: iload 4
    //   1051: aload 7
    //   1053: iload 5
    //   1055: invokevirtual 384	com/tencent/mm/plugin/appbrand/appcache/bm:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V
    //   1058: goto -1006 -> 52
    //   1061: aload_2
    //   1062: ldc 155
    //   1064: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1067: astore_1
    //   1068: aload_2
    //   1069: ldc_w 379
    //   1072: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: astore 6
    //   1077: aload_2
    //   1078: ldc_w 294
    //   1081: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1084: invokevirtual 275	java/lang/Integer:intValue	()I
    //   1087: istore_3
    //   1088: aload_2
    //   1089: ldc_w 381
    //   1092: invokevirtual 245	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1095: invokevirtual 275	java/lang/Integer:intValue	()I
    //   1098: istore 4
    //   1100: aload_2
    //   1101: ldc_w 386
    //   1104: invokevirtual 159	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   1107: astore_2
    //   1108: aload_0
    //   1109: ldc_w 307
    //   1112: invokespecial 136	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1115: checkcast 307	com/tencent/mm/plugin/appbrand/appcache/bm
    //   1118: aload_1
    //   1119: iload_3
    //   1120: iload 4
    //   1122: aload 6
    //   1124: aload_2
    //   1125: invokestatic 391	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:XY	(Ljava/lang/String;)Ljava/util/List;
    //   1128: invokevirtual 394	com/tencent/mm/plugin/appbrand/appcache/bm:a	(Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V
    //   1131: goto -1079 -> 52
    //   1134: goto -964 -> 170
    //   1137: aload_1
    //   1138: astore_2
    //   1139: goto -888 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	this	WxaCriticalDataProvider
    //   0	1142	1	paramUri	Uri
    //   0	1142	2	paramContentValues	ContentValues
    //   290	830	3	i	int
    //   608	513	4	j	int
    //   1033	21	5	k	int
    //   69	1054	6	str	String
    //   87	965	7	localObject	Object
    //   103	157	8	localgkv	com.tencent.mm.protocal.protobuf.gkv
    //   149	16	9	localgku	com.tencent.mm.protocal.protobuf.gku
    // Exception table:
    //   from	to	target	type
    //   54	113	198	java/lang/Exception
    //   115	131	198	java/lang/Exception
    //   131	170	198	java/lang/Exception
    //   172	195	198	java/lang/Exception
    //   217	234	198	java/lang/Exception
    //   243	248	198	java/lang/Exception
    //   251	268	198	java/lang/Exception
    //   271	326	198	java/lang/Exception
    //   329	372	375	java/lang/Exception
    //   395	438	441	java/lang/Exception
    //   579	618	653	java/lang/Exception
    //   623	650	653	java/lang/Exception
    //   618	623	769	java/lang/Exception
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!ats()) {}
    do
    {
      return null;
      paramUri = (String)exz.get(exy.match(paramUri));
    } while (TextUtils.isEmpty(paramUri));
    return this.db.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = -1;
    if (!ats()) {
      return -1;
    }
    switch (exy.match(paramUri))
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
    if (((bm)ag(bm.class)).K(paramUri, i, j)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */