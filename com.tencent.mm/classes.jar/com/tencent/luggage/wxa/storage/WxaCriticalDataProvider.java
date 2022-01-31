package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.g.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import java.util.HashMap;
import java.util.Map;

public abstract class WxaCriticalDataProvider
  extends ContentProvider
{
  private static final UriMatcher bFP;
  private static final SparseArray<String> bFQ;
  private final Map<Class<?>, Object> bFR = new HashMap();
  private volatile e db;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    bFQ = localSparseArray;
    localSparseArray.put(1, "WxaAttributesTable");
    bFQ.put(2, "LaunchWxaAppPBTable");
    bFQ.put(3, "WxaAppPackageModelTable");
    bFQ.put(4, "DevPkgLaunchExtInfo");
    bFQ.put(5, "AppBrandWxaPkgManifestRecord");
    bFP = new UriMatcher(-1);
    int i = 0;
    while (i < bFQ.size())
    {
      bFP.addURI(a.AUTHORITY, (String)bFQ.valueAt(i), bFQ.keyAt(i));
      i += 1;
    }
  }
  
  protected static int h(Uri paramUri)
  {
    return bFP.match(paramUri);
  }
  
  private <T> T w(Class<T> paramClass)
  {
    return this.bFR.get(paramClass);
  }
  
  private boolean xg()
  {
    if (this.db == null) {
      this.db = xh();
    }
    return this.db != null;
  }
  
  protected final void c(Class<?> paramClass, Object paramObject)
  {
    this.bFR.put(paramClass, paramObject);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!xg()) {
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
    //   1: invokespecial 108	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:xg	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: getstatic 44	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:bFP	Landroid/content/UriMatcher;
    //   12: aload_1
    //   13: invokevirtual 80	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   16: tableswitch	default:+36 -> 52, 1:+38->54, 2:+249->265, 3:+36->52, 4:+316->332, 5:+378->394
    //   53: areturn
    //   54: aload_2
    //   55: ldc 116
    //   57: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 6
    //   62: aload_2
    //   63: ldc 124
    //   65: invokevirtual 128	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   68: astore_1
    //   69: aload_0
    //   70: ldc 130
    //   72: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   75: checkcast 130	com/tencent/mm/plugin/appbrand/config/p
    //   78: astore 7
    //   80: new 134	com/tencent/mm/protocal/protobuf/dab
    //   83: dup
    //   84: invokespecial 135	com/tencent/mm/protocal/protobuf/dab:<init>	()V
    //   87: aload_1
    //   88: invokevirtual 139	com/tencent/mm/protocal/protobuf/dab:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   91: checkcast 134	com/tencent/mm/protocal/protobuf/dab
    //   94: checkcast 134	com/tencent/mm/protocal/protobuf/dab
    //   97: astore 8
    //   99: aload 6
    //   101: invokestatic 145	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   104: ifeq +107 -> 211
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +854 -> 967
    //   116: aload 8
    //   118: getfield 155	com/tencent/mm/protocal/protobuf/dab:wxO	Ljava/util/LinkedList;
    //   121: invokevirtual 161	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   124: astore_2
    //   125: aload_2
    //   126: invokeinterface 166 1 0
    //   131: ifeq +833 -> 964
    //   134: aload_2
    //   135: invokeinterface 170 1 0
    //   140: checkcast 172	com/tencent/mm/protocal/protobuf/daa
    //   143: astore 9
    //   145: ldc 174
    //   147: aload 9
    //   149: getfield 177	com/tencent/mm/protocal/protobuf/daa:wxP	Ljava/lang/String;
    //   152: invokevirtual 180	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   155: ifeq -30 -> 125
    //   158: aload 9
    //   160: getfield 183	com/tencent/mm/protocal/protobuf/daa:qsu	Ljava/lang/String;
    //   163: astore_1
    //   164: aload_1
    //   165: astore_2
    //   166: aload_1
    //   167: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifeq +75 -> 245
    //   173: ldc 185
    //   175: ldc 187
    //   177: iconst_1
    //   178: anewarray 189	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload 6
    //   185: aastore
    //   186: invokestatic 195	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -137 -> 52
    //   192: astore_1
    //   193: ldc 197
    //   195: ldc 199
    //   197: iconst_1
    //   198: anewarray 189	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_1
    //   204: aastore
    //   205: invokestatic 202	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -156 -> 52
    //   211: aload 7
    //   213: aload 6
    //   215: iconst_1
    //   216: anewarray 60	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: ldc 204
    //   223: aastore
    //   224: invokevirtual 207	com/tencent/mm/plugin/appbrand/config/p:e	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   227: astore_1
    //   228: aload_1
    //   229: ifnonnull +8 -> 237
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -125 -> 109
    //   237: aload_1
    //   238: getfield 212	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_username	Ljava/lang/String;
    //   241: astore_1
    //   242: goto -133 -> 109
    //   245: aload 7
    //   247: aload_2
    //   248: aload 8
    //   250: getfield 216	com/tencent/mm/protocal/protobuf/dab:wxN	Lcom/tencent/mm/bv/b;
    //   253: aload 8
    //   255: getfield 155	com/tencent/mm/protocal/protobuf/dab:wxO	Ljava/util/LinkedList;
    //   258: invokevirtual 220	com/tencent/mm/plugin/appbrand/config/p:a	(Ljava/lang/String;Lcom/tencent/mm/bv/b;Ljava/util/List;)Z
    //   261: pop
    //   262: goto -210 -> 52
    //   265: aload_2
    //   266: ldc 116
    //   268: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   271: astore_1
    //   272: aload_2
    //   273: ldc 124
    //   275: invokevirtual 128	android/content/ContentValues:getAsByteArray	(Ljava/lang/String;)[B
    //   278: astore_2
    //   279: aload_0
    //   280: ldc 222
    //   282: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   285: checkcast 222	com/tencent/mm/plugin/appbrand/launching/ad
    //   288: aload_1
    //   289: new 224	com/tencent/mm/protocal/protobuf/azn
    //   292: dup
    //   293: invokespecial 225	com/tencent/mm/protocal/protobuf/azn:<init>	()V
    //   296: aload_2
    //   297: invokevirtual 226	com/tencent/mm/protocal/protobuf/azn:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   300: checkcast 224	com/tencent/mm/protocal/protobuf/azn
    //   303: checkcast 224	com/tencent/mm/protocal/protobuf/azn
    //   306: invokevirtual 230	com/tencent/mm/plugin/appbrand/launching/ad:b	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/azn;)Z
    //   309: pop
    //   310: goto -258 -> 52
    //   313: astore_1
    //   314: ldc 197
    //   316: ldc 232
    //   318: iconst_1
    //   319: anewarray 189	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload_1
    //   325: aastore
    //   326: invokestatic 202	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: goto -277 -> 52
    //   332: aload_2
    //   333: ldc 116
    //   335: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore_1
    //   339: aload_2
    //   340: ldc 234
    //   342: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   345: invokevirtual 243	java/lang/Integer:intValue	()I
    //   348: istore_3
    //   349: aload_2
    //   350: ldc 245
    //   352: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   355: astore_2
    //   356: aload_0
    //   357: ldc 247
    //   359: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   362: checkcast 247	com/tencent/mm/plugin/appbrand/launching/m
    //   365: aload_1
    //   366: iload_3
    //   367: aload_2
    //   368: invokevirtual 251	com/tencent/mm/plugin/appbrand/launching/m:n	(Ljava/lang/String;ILjava/lang/String;)Z
    //   371: pop
    //   372: goto -320 -> 52
    //   375: astore_1
    //   376: ldc 197
    //   378: ldc 253
    //   380: iconst_1
    //   381: anewarray 189	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload_1
    //   387: aastore
    //   388: invokestatic 202	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   391: goto -339 -> 52
    //   394: aload_2
    //   395: ldc 255
    //   397: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   400: astore 6
    //   402: iconst_m1
    //   403: istore_3
    //   404: aload 6
    //   406: invokevirtual 258	java/lang/String:hashCode	()I
    //   409: lookupswitch	default:+51->460, -1297425212:+183->592, -1264406702:+231->640, -946499957:+215->624, 922736132:+247->656, 1067970480:+199->608
    //   461: tableswitch	default:+35 -> 496, 0:+38->499, 1:+217->678, 2:+318->779, 3:+389->850, 4:+417->878
    //   497: impdep1
    //   498: fstore_1
    //   499: aload_2
    //   500: ldc 116
    //   502: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 6
    //   507: aload_2
    //   508: ldc_w 260
    //   511: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   514: invokevirtual 243	java/lang/Integer:intValue	()I
    //   517: istore_3
    //   518: aload_2
    //   519: ldc_w 262
    //   522: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   525: invokevirtual 243	java/lang/Integer:intValue	()I
    //   528: istore 4
    //   530: aload_2
    //   531: ldc_w 264
    //   534: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   537: astore_1
    //   538: aload_1
    //   539: invokestatic 270	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:AE	(Ljava/lang/String;)Ljava/util/List;
    //   542: astore_1
    //   543: aload_1
    //   544: invokestatic 274	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   547: ifne -495 -> 52
    //   550: aload_0
    //   551: ldc_w 276
    //   554: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   557: checkcast 276	com/tencent/mm/plugin/appbrand/appcache/ay
    //   560: aload 6
    //   562: iload_3
    //   563: iload 4
    //   565: aload_1
    //   566: invokevirtual 279	com/tencent/mm/plugin/appbrand/appcache/ay:b	(Ljava/lang/String;IILjava/util/List;)Z
    //   569: pop
    //   570: goto -518 -> 52
    //   573: astore_1
    //   574: ldc 197
    //   576: ldc 253
    //   578: iconst_1
    //   579: anewarray 189	java/lang/Object
    //   582: dup
    //   583: iconst_0
    //   584: aload_1
    //   585: aastore
    //   586: invokestatic 202	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   589: goto -537 -> 52
    //   592: aload 6
    //   594: ldc_w 281
    //   597: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   600: ifeq -140 -> 460
    //   603: iconst_0
    //   604: istore_3
    //   605: goto -145 -> 460
    //   608: aload 6
    //   610: ldc_w 287
    //   613: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   616: ifeq -156 -> 460
    //   619: iconst_1
    //   620: istore_3
    //   621: goto -161 -> 460
    //   624: aload 6
    //   626: ldc_w 289
    //   629: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   632: ifeq -172 -> 460
    //   635: iconst_2
    //   636: istore_3
    //   637: goto -177 -> 460
    //   640: aload 6
    //   642: ldc_w 291
    //   645: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq -188 -> 460
    //   651: iconst_3
    //   652: istore_3
    //   653: goto -193 -> 460
    //   656: aload 6
    //   658: ldc_w 293
    //   661: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq -204 -> 460
    //   667: iconst_4
    //   668: istore_3
    //   669: goto -209 -> 460
    //   672: astore_1
    //   673: aconst_null
    //   674: astore_1
    //   675: goto -132 -> 543
    //   678: aload_2
    //   679: ldc 116
    //   681: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   684: astore 6
    //   686: aload_2
    //   687: ldc_w 260
    //   690: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   693: invokevirtual 243	java/lang/Integer:intValue	()I
    //   696: istore_3
    //   697: aload_2
    //   698: ldc_w 295
    //   701: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   704: astore 7
    //   706: aload_2
    //   707: ldc_w 297
    //   710: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   713: astore_2
    //   714: aload_0
    //   715: ldc_w 276
    //   718: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   721: checkcast 276	com/tencent/mm/plugin/appbrand/appcache/ay
    //   724: aload 6
    //   726: iload_3
    //   727: aload_2
    //   728: aload 7
    //   730: lconst_0
    //   731: invokestatic 303	java/lang/System:currentTimeMillis	()J
    //   734: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/ay:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   737: ifeq -685 -> 52
    //   740: aload_1
    //   741: getstatic 312	java/util/Locale:US	Ljava/util/Locale;
    //   744: ldc_w 314
    //   747: iconst_3
    //   748: anewarray 189	java/lang/Object
    //   751: dup
    //   752: iconst_0
    //   753: aload 6
    //   755: aastore
    //   756: dup
    //   757: iconst_1
    //   758: iload_3
    //   759: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: aastore
    //   763: dup
    //   764: iconst_2
    //   765: aload 7
    //   767: aastore
    //   768: invokestatic 322	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   771: invokevirtual 258	java/lang/String:hashCode	()I
    //   774: i2l
    //   775: invokestatic 328	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   778: areturn
    //   779: aload_2
    //   780: ldc 116
    //   782: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   785: astore_1
    //   786: aload_2
    //   787: ldc_w 260
    //   790: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   793: invokevirtual 243	java/lang/Integer:intValue	()I
    //   796: istore_3
    //   797: aload_2
    //   798: ldc_w 262
    //   801: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   804: invokevirtual 243	java/lang/Integer:intValue	()I
    //   807: istore 4
    //   809: aload_2
    //   810: ldc_w 295
    //   813: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   816: astore 6
    //   818: aload_2
    //   819: ldc_w 297
    //   822: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   825: astore_2
    //   826: aload_0
    //   827: ldc_w 276
    //   830: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   833: checkcast 276	com/tencent/mm/plugin/appbrand/appcache/ay
    //   836: aload_1
    //   837: iload_3
    //   838: iload 4
    //   840: aload 6
    //   842: aload_2
    //   843: invokevirtual 331	com/tencent/mm/plugin/appbrand/appcache/ay:a	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Z
    //   846: pop
    //   847: goto -795 -> 52
    //   850: aload_2
    //   851: ldc_w 333
    //   854: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   857: astore_1
    //   858: aload_0
    //   859: ldc_w 276
    //   862: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   865: checkcast 276	com/tencent/mm/plugin/appbrand/appcache/ay
    //   868: aload_1
    //   869: invokestatic 338	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaCodeLibInfo:AC	(Ljava/lang/String;)Ljava/util/List;
    //   872: invokevirtual 342	com/tencent/mm/plugin/appbrand/appcache/ay:ax	(Ljava/util/List;)V
    //   875: goto -823 -> 52
    //   878: aload_2
    //   879: ldc 116
    //   881: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   884: astore_1
    //   885: aload_2
    //   886: ldc_w 344
    //   889: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   892: astore 6
    //   894: aload_2
    //   895: ldc_w 262
    //   898: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   901: invokevirtual 243	java/lang/Integer:intValue	()I
    //   904: istore_3
    //   905: aload_2
    //   906: ldc_w 346
    //   909: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   912: invokevirtual 243	java/lang/Integer:intValue	()I
    //   915: istore 4
    //   917: aload_2
    //   918: ldc_w 295
    //   921: invokevirtual 122	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   924: astore 7
    //   926: aload_2
    //   927: ldc_w 260
    //   930: invokevirtual 238	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   933: invokevirtual 243	java/lang/Integer:intValue	()I
    //   936: istore 5
    //   938: aload_0
    //   939: ldc_w 276
    //   942: invokespecial 132	com/tencent/luggage/wxa/storage/WxaCriticalDataProvider:w	(Ljava/lang/Class;)Ljava/lang/Object;
    //   945: checkcast 276	com/tencent/mm/plugin/appbrand/appcache/ay
    //   948: aload_1
    //   949: aload 6
    //   951: iload_3
    //   952: iload 4
    //   954: aload 7
    //   956: iload 5
    //   958: invokevirtual 349	com/tencent/mm/plugin/appbrand/appcache/ay:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V
    //   961: goto -909 -> 52
    //   964: goto -800 -> 164
    //   967: aload_1
    //   968: astore_2
    //   969: goto -724 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	972	0	this	WxaCriticalDataProvider
    //   0	972	1	paramUri	Uri
    //   0	972	2	paramContentValues	ContentValues
    //   348	604	3	i	int
    //   528	425	4	j	int
    //   936	21	5	k	int
    //   60	890	6	str	String
    //   78	877	7	localObject	Object
    //   97	157	8	localdab	com.tencent.mm.protocal.protobuf.dab
    //   143	16	9	localdaa	com.tencent.mm.protocal.protobuf.daa
    // Exception table:
    //   from	to	target	type
    //   54	107	192	java/lang/Exception
    //   109	125	192	java/lang/Exception
    //   125	164	192	java/lang/Exception
    //   166	189	192	java/lang/Exception
    //   211	228	192	java/lang/Exception
    //   237	242	192	java/lang/Exception
    //   245	262	192	java/lang/Exception
    //   265	310	313	java/lang/Exception
    //   332	372	375	java/lang/Exception
    //   499	538	573	java/lang/Exception
    //   543	570	573	java/lang/Exception
    //   538	543	672	java/lang/Exception
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!xg()) {}
    do
    {
      return null;
      paramUri = (String)bFQ.get(bFP.match(paramUri));
    } while (TextUtils.isEmpty(paramUri));
    return this.db.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!xg()) {
      return -1;
    }
    return 0;
  }
  
  protected abstract e xh();
  
  protected final void xi()
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
        d.printErrStackTrace("Luggage.WxaCriticalDataProvider", localThrowable, "uninstallDatabase", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.wxa.storage.WxaCriticalDataProvider
 * JD-Core Version:    0.7.0.1
 */