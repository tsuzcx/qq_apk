package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.widget.input.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wexnet.TensorCpuB;
import com.tencent.mm.wexnet.XnetDataKind;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ai/JsApiRunInferenceSession;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 1092;
  public static final String NAME = "runInferenceSession";
  public static final c.a rCk;
  private static final List<String> rCl;
  
  static
  {
    AppMethodBeat.i(325965);
    rCk = new c.a((byte)0);
    rCl = kotlin.a.p.listOf(new String[] { "uint8", "int8", "uint32", "int32", "float32" });
    AppMethodBeat.o(325965);
  }
  
  /* Error */
  private static final void a(f paramf, int paramInt1, c paramc, int paramInt2, Map paramMap1, com.tencent.mm.wexnet.SessionKeeper paramSessionKeeper, Map paramMap2)
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 94
    //   8: invokestatic 100	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload 4
    //   13: ldc 102
    //   15: invokestatic 100	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload 6
    //   20: ldc 104
    //   22: invokestatic 100	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   25: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   28: lstore 9
    //   30: getstatic 115	com/tencent/mm/wexnet/WeXNet:Companion	Lcom/tencent/mm/wexnet/WeXNet$a;
    //   33: astore 13
    //   35: aload 5
    //   37: aload 6
    //   39: aload 4
    //   41: invokestatic 121	com/tencent/mm/wexnet/WeXNet$a:tryRun	(Lcom/tencent/mm/wexnet/SessionKeeper;Ljava/util/Map;Ljava/util/Map;)Lcom/tencent/mm/wexnet/Result;
    //   44: astore 5
    //   46: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   49: lstore 11
    //   51: ldc 123
    //   53: new 125	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 127
    //   59: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: lload 11
    //   64: lload 9
    //   66: lsub
    //   67: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: bipush 93
    //   72: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: ldc 123
    //   83: new 125	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 148
    //   89: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: iload_3
    //   93: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc 153
    //   98: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 5
    //   103: invokevirtual 162	com/tencent/mm/wexnet/Result:getSuccess	()Z
    //   106: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: bipush 93
    //   111: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   114: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: invokevirtual 162	com/tencent/mm/wexnet/Result:getSuccess	()Z
    //   125: ifeq +487 -> 612
    //   128: new 167	java/util/HashMap
    //   131: dup
    //   132: invokespecial 168	java/util/HashMap:<init>	()V
    //   135: astore 14
    //   137: new 167	java/util/HashMap
    //   140: dup
    //   141: invokespecial 168	java/util/HashMap:<init>	()V
    //   144: astore 15
    //   146: aload 4
    //   148: invokeinterface 174 1 0
    //   153: checkcast 176	java/lang/Iterable
    //   156: invokeinterface 180 1 0
    //   161: astore 16
    //   163: aload 16
    //   165: invokeinterface 185 1 0
    //   170: ifeq +400 -> 570
    //   173: aload 16
    //   175: invokeinterface 189 1 0
    //   180: checkcast 67	java/lang/String
    //   183: astore 6
    //   185: aload 4
    //   187: aload 6
    //   189: invokeinterface 193 2 0
    //   194: checkcast 195	com/tencent/mm/wexnet/TensorCpuB
    //   197: astore 13
    //   199: aload 13
    //   201: ifnull -38 -> 163
    //   204: aload 15
    //   206: checkcast 170	java/util/Map
    //   209: astore 17
    //   211: new 167	java/util/HashMap
    //   214: dup
    //   215: invokespecial 168	java/util/HashMap:<init>	()V
    //   218: astore 18
    //   220: aload 13
    //   222: invokevirtual 199	com/tencent/mm/wexnet/TensorCpuB:getDateType	()I
    //   225: istore_3
    //   226: iload_3
    //   227: invokestatic 204	com/tencent/mm/wexnet/XnetDataKind:getStorageDataKindUInt8	()I
    //   230: if_icmpne +142 -> 372
    //   233: ldc 69
    //   235: astore 5
    //   237: aload 18
    //   239: ldc 206
    //   241: aload 5
    //   243: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: ldc 212
    //   249: aload 6
    //   251: invokestatic 216	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   254: astore 5
    //   256: aload 18
    //   258: ldc 217
    //   260: aload 5
    //   262: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: aload 18
    //   268: ldc 219
    //   270: aload 13
    //   272: invokevirtual 223	com/tencent/mm/wexnet/TensorCpuB:getDataShape	()[I
    //   275: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: aload 13
    //   281: invokevirtual 227	com/tencent/mm/wexnet/TensorCpuB:getData	()[B
    //   284: arraylength
    //   285: invokestatic 233	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   288: astore 19
    //   290: aload 19
    //   292: aload 13
    //   294: invokevirtual 227	com/tencent/mm/wexnet/TensorCpuB:getData	()[B
    //   297: invokevirtual 236	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   300: pop
    //   301: aload 14
    //   303: checkcast 170	java/util/Map
    //   306: astore 13
    //   308: aload 19
    //   310: ldc 238
    //   312: invokestatic 241	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   315: aload 13
    //   317: aload 5
    //   319: aload 19
    //   321: invokeinterface 242 3 0
    //   326: pop
    //   327: aload 19
    //   329: invokevirtual 246	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   332: pop
    //   333: aload 17
    //   335: aload 6
    //   337: aload 18
    //   339: invokeinterface 242 3 0
    //   344: pop
    //   345: goto -182 -> 163
    //   348: astore 4
    //   350: aload_0
    //   351: iload_1
    //   352: aload_2
    //   353: aconst_null
    //   354: getstatic 252	com/tencent/mm/plugin/appbrand/jsapi/g/a$a:rUB	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   357: aconst_null
    //   358: invokevirtual 257	com/tencent/mm/plugin/appbrand/jsapi/p:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;Lorg/json/JSONObject;)Ljava/lang/String;
    //   361: invokeinterface 263 3 0
    //   366: ldc 92
    //   368: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: return
    //   372: iload_3
    //   373: getstatic 267	com/tencent/mm/wexnet/XnetDataKind:INSTANCE	Lcom/tencent/mm/wexnet/XnetDataKind;
    //   376: invokevirtual 270	com/tencent/mm/wexnet/XnetDataKind:getStorageDataKindInt8	()I
    //   379: if_icmpne +10 -> 389
    //   382: ldc 71
    //   384: astore 5
    //   386: goto -149 -> 237
    //   389: iload_3
    //   390: getstatic 267	com/tencent/mm/wexnet/XnetDataKind:INSTANCE	Lcom/tencent/mm/wexnet/XnetDataKind;
    //   393: invokevirtual 273	com/tencent/mm/wexnet/XnetDataKind:getStorageDataKindUInt32	()I
    //   396: if_icmpne +10 -> 406
    //   399: ldc 73
    //   401: astore 5
    //   403: goto -166 -> 237
    //   406: iload_3
    //   407: getstatic 267	com/tencent/mm/wexnet/XnetDataKind:INSTANCE	Lcom/tencent/mm/wexnet/XnetDataKind;
    //   410: invokevirtual 276	com/tencent/mm/wexnet/XnetDataKind:getStorageDataKindInt32	()I
    //   413: if_icmpne +10 -> 423
    //   416: ldc 75
    //   418: astore 5
    //   420: goto -183 -> 237
    //   423: iload_3
    //   424: getstatic 267	com/tencent/mm/wexnet/XnetDataKind:INSTANCE	Lcom/tencent/mm/wexnet/XnetDataKind;
    //   427: invokevirtual 279	com/tencent/mm/wexnet/XnetDataKind:getStorageDataKindFloat32	()I
    //   430: if_icmpne +10 -> 440
    //   433: ldc 77
    //   435: astore 5
    //   437: goto -200 -> 237
    //   440: new 91	java/lang/RuntimeException
    //   443: dup
    //   444: ldc_w 281
    //   447: invokespecial 282	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   450: astore 4
    //   452: ldc 92
    //   454: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   457: aload 4
    //   459: athrow
    //   460: astore 4
    //   462: getstatic 285	com/tencent/mm/plugin/appbrand/jsapi/g/a$a:rUx	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   465: getfield 290	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:rVs	I
    //   468: istore_3
    //   469: getstatic 296	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   472: astore 4
    //   474: getstatic 285	com/tencent/mm/plugin/appbrand/jsapi/g/a$a:rUx	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   477: getfield 299	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:errMsg	Ljava/lang/String;
    //   480: astore 5
    //   482: aload 5
    //   484: astore 4
    //   486: aload 5
    //   488: ifnonnull +8 -> 496
    //   491: ldc_w 300
    //   494: astore 4
    //   496: aload 4
    //   498: iconst_2
    //   499: anewarray 302	java/lang/Object
    //   502: dup
    //   503: iconst_0
    //   504: ldc_w 300
    //   507: aload 13
    //   509: invokevirtual 199	com/tencent/mm/wexnet/TensorCpuB:getDateType	()I
    //   512: invokestatic 308	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: invokestatic 216	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   518: aastore
    //   519: dup
    //   520: iconst_1
    //   521: aload 6
    //   523: aastore
    //   524: iconst_2
    //   525: invokestatic 314	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   528: invokestatic 318	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   531: astore 4
    //   533: aload 4
    //   535: ldc_w 320
    //   538: invokestatic 241	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   541: aload_0
    //   542: iload_1
    //   543: aload_2
    //   544: aconst_null
    //   545: new 287	com/tencent/mm/plugin/appbrand/jsapi/g/a$d
    //   548: dup
    //   549: iload_3
    //   550: aload 4
    //   552: invokespecial 322	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:<init>	(ILjava/lang/String;)V
    //   555: aconst_null
    //   556: invokevirtual 257	com/tencent/mm/plugin/appbrand/jsapi/p:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;Lorg/json/JSONObject;)Ljava/lang/String;
    //   559: invokeinterface 263 3 0
    //   564: ldc 92
    //   566: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: return
    //   570: aload 14
    //   572: checkcast 170	java/util/Map
    //   575: ldc_w 324
    //   578: aload 15
    //   580: invokeinterface 242 3 0
    //   585: pop
    //   586: aload_0
    //   587: iload_1
    //   588: aload_2
    //   589: aload_0
    //   590: getstatic 329	com/tencent/mm/plugin/appbrand/jsapi/g/a$e:rVt	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   593: aload 14
    //   595: checkcast 170	java/util/Map
    //   598: invokevirtual 332	com/tencent/mm/plugin/appbrand/jsapi/a/c:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;Ljava/util/Map;)Ljava/lang/String;
    //   601: invokeinterface 263 3 0
    //   606: ldc 92
    //   608: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: return
    //   612: ldc_w 300
    //   615: astore 4
    //   617: aload 5
    //   619: invokevirtual 336	com/tencent/mm/wexnet/Result:getCodes	()[J
    //   622: astore 6
    //   624: iconst_0
    //   625: istore_3
    //   626: aload 6
    //   628: arraylength
    //   629: istore 8
    //   631: iconst_0
    //   632: istore 7
    //   634: iload 7
    //   636: iload 8
    //   638: if_icmpge +91 -> 729
    //   641: aload 6
    //   643: iload 7
    //   645: laload
    //   646: lstore 9
    //   648: new 125	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   655: aload 4
    //   657: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: lload 9
    //   662: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: bipush 58
    //   667: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   670: astore 13
    //   672: aload 5
    //   674: invokevirtual 341	com/tencent/mm/wexnet/Result:getDesc	()[Ljava/lang/String;
    //   677: arraylength
    //   678: iload_3
    //   679: if_icmple +42 -> 721
    //   682: aload 5
    //   684: invokevirtual 341	com/tencent/mm/wexnet/Result:getDesc	()[Ljava/lang/String;
    //   687: iload_3
    //   688: aaload
    //   689: astore 4
    //   691: aload 13
    //   693: aload 4
    //   695: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: bipush 10
    //   700: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   703: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: astore 4
    //   708: iload 7
    //   710: iconst_1
    //   711: iadd
    //   712: istore 7
    //   714: iload_3
    //   715: iconst_1
    //   716: iadd
    //   717: istore_3
    //   718: goto -84 -> 634
    //   721: ldc_w 300
    //   724: astore 4
    //   726: goto -35 -> 691
    //   729: getstatic 344	com/tencent/mm/plugin/appbrand/jsapi/g/a$a:rUA	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   732: getfield 290	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:rVs	I
    //   735: istore_3
    //   736: getstatic 296	kotlin/g/b/am:aixg	Lkotlin/g/b/am;
    //   739: astore 5
    //   741: getstatic 344	com/tencent/mm/plugin/appbrand/jsapi/g/a$a:rUA	Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;
    //   744: getfield 299	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:errMsg	Ljava/lang/String;
    //   747: astore 6
    //   749: aload 6
    //   751: astore 5
    //   753: aload 6
    //   755: ifnonnull +8 -> 763
    //   758: ldc_w 300
    //   761: astore 5
    //   763: aload 5
    //   765: iconst_1
    //   766: anewarray 302	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: aload 4
    //   773: aastore
    //   774: iconst_1
    //   775: invokestatic 314	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   778: invokestatic 318	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   781: astore 4
    //   783: aload 4
    //   785: ldc_w 320
    //   788: invokestatic 241	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   791: aload_0
    //   792: iload_1
    //   793: aload_2
    //   794: aconst_null
    //   795: new 287	com/tencent/mm/plugin/appbrand/jsapi/g/a$d
    //   798: dup
    //   799: iload_3
    //   800: aload 4
    //   802: invokespecial 322	com/tencent/mm/plugin/appbrand/jsapi/g/a$d:<init>	(ILjava/lang/String;)V
    //   805: aconst_null
    //   806: invokevirtual 257	com/tencent/mm/plugin/appbrand/jsapi/p:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/g/a$d;Lorg/json/JSONObject;)Ljava/lang/String;
    //   809: invokeinterface 263 3 0
    //   814: ldc 92
    //   816: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   819: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	820	0	paramf	f
    //   0	820	1	paramInt1	int
    //   0	820	2	paramc	c
    //   0	820	3	paramInt2	int
    //   0	820	4	paramMap1	Map
    //   0	820	5	paramSessionKeeper	com.tencent.mm.wexnet.SessionKeeper
    //   0	820	6	paramMap2	Map
    //   632	81	7	i	int
    //   629	10	8	j	int
    //   28	633	9	l1	long
    //   49	14	11	l2	long
    //   33	659	13	localObject	Object
    //   135	459	14	localHashMap1	HashMap
    //   144	435	15	localHashMap2	HashMap
    //   161	13	16	localIterator	Iterator
    //   209	125	17	localMap	Map
    //   218	120	18	localHashMap3	HashMap
    //   288	40	19	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   25	81	348	com/tencent/mm/wexnet/WeXNet$a$a
    //   220	233	460	java/lang/RuntimeException
    //   372	382	460	java/lang/RuntimeException
    //   389	399	460	java/lang/RuntimeException
    //   406	416	460	java/lang/RuntimeException
    //   423	433	460	java/lang/RuntimeException
    //   440	460	460	java/lang/RuntimeException
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(325975);
    if (paramf == null)
    {
      AppMethodBeat.o(325975);
      return;
    }
    Log.i("MicroMsg.JsApiRunInferenceSession", "[invoke] start");
    if (paramJSONObject == null) {}
    for (int j = -1; j == -1; j = paramJSONObject.optInt("sessionId", -1))
    {
      paramf.callback(paramInt, a(null, a.a.rUt, null));
      AppMethodBeat.o(325975);
      return;
    }
    if (paramJSONObject == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (!((JSONObject)localObject1).keys().hasNext()); localObject1 = paramJSONObject.optJSONObject("input"))
    {
      paramf.callback(paramInt, a(null, a.a.rUu, null));
      AppMethodBeat.o(325975);
      return;
    }
    Map localMap = (Map)new HashMap();
    Iterator localIterator = ((JSONObject)localObject1).keys();
    s.s(localIterator, "inputJSONObj.keys()");
    String str1;
    Object localObject2;
    String str2;
    int i;
    Object localObject3;
    List localList;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        localObject2 = ((JSONObject)localObject1).optJSONObject(str1);
        if (localObject2 != null)
        {
          str2 = ((JSONObject)localObject2).optString("type", "");
          if (!rCl.contains(str2))
          {
            i = a.a.rUv.rVs;
            paramJSONObject = am.aixg;
            localObject1 = a.a.rUv.errMsg;
            paramJSONObject = (JSONObject)localObject1;
            if (localObject1 == null) {
              paramJSONObject = "";
            }
            paramJSONObject = String.format(paramJSONObject, Arrays.copyOf(new Object[] { str2, str1 }, 2));
            s.s(paramJSONObject, "java.lang.String.format(format, *args)");
            paramf.callback(paramInt, a(null, new a.d(i, paramJSONObject), null));
            AppMethodBeat.o(325975);
            return;
          }
          localObject3 = ((JSONObject)localObject2).optJSONArray("shape");
          localList = (List)new ArrayList();
          if (localObject3 != null)
          {
            int k = ((JSONArray)localObject3).length();
            i = 0;
            while (i < k)
            {
              localList.add(Integer.valueOf(((JSONArray)localObject3).getInt(i)));
              i += 1;
            }
          }
          if (localList.size() == 0)
          {
            paramf.callback(paramInt, a(null, a.a.rUz, null));
            AppMethodBeat.o(325975);
            return;
          }
          localObject3 = ((JSONObject)localObject2).optString("data");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = paramJSONObject.opt((String)localObject2);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          if ((localObject2 instanceof ByteBuffer))
          {
            localObject3 = ByteBuffer.allocateDirect(((ByteBuffer)localObject2).capacity());
            ((ByteBuffer)localObject3).order(ByteOrder.nativeOrder());
            ((ByteBuffer)localObject3).put((ByteBuffer)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        s.s(str2, "type");
        s.u(str2, "type");
        switch (str2.hashCode())
        {
        case 100359822: 
          label572:
          paramJSONObject = new RuntimeException("runInferenceSession unsupported data type from xnet output tensor");
          AppMethodBeat.o(325975);
          throw paramJSONObject;
        }
      }
      catch (RuntimeException paramJSONObject)
      {
        i = a.a.rUv.rVs;
        paramJSONObject = am.aixg;
        localObject1 = a.a.rUv.errMsg;
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 == null) {
          paramJSONObject = "";
        }
        paramJSONObject = String.format(paramJSONObject, Arrays.copyOf(new Object[] { str2, str1 }, 2));
        s.s(paramJSONObject, "java.lang.String.format(format, *args)");
        paramf.callback(paramInt, a(null, new a.d(i, paramJSONObject), null));
        AppMethodBeat.o(325975);
        return;
      }
      if (str2.equals("int32"))
      {
        i = XnetDataKind.INSTANCE.getStorageDataKindUInt32();
        for (;;)
        {
          ((ByteBuffer)localObject3).clear();
          s.s(str1, "name");
          localObject2 = kotlin.a.p.I((Collection)localList);
          s.s(localObject3, "byteBuffer");
          localMap.put(str1, new TensorCpuB(i, (int[])localObject2, at.F((ByteBuffer)localObject3)));
          break;
          if (!str2.equals("int8")) {
            break label572;
          }
          i = XnetDataKind.INSTANCE.getStorageDataKindInt8();
          continue;
          if (!str2.equals("float32")) {
            break label572;
          }
          i = XnetDataKind.INSTANCE.getStorageDataKindFloat32();
          continue;
          if (!str2.equals("uint32")) {
            break label572;
          }
          i = XnetDataKind.INSTANCE.getStorageDataKindUInt32();
          continue;
          if (!str2.equals("uint8")) {
            break label572;
          }
          i = XnetDataKind.getStorageDataKindUInt8();
        }
        i = a.a.rUy.rVs;
        paramJSONObject = am.aixg;
        localObject1 = a.a.rUy.errMsg;
        paramJSONObject = (JSONObject)localObject1;
        if (localObject1 == null) {
          paramJSONObject = "";
        }
        paramJSONObject = String.format(paramJSONObject, Arrays.copyOf(new Object[] { str1 }, 1));
        s.s(paramJSONObject, "java.lang.String.format(format, *args)");
        paramf.callback(paramInt, a(null, new a.d(i, paramJSONObject), null));
        AppMethodBeat.o(325975);
        return;
        paramJSONObject = paramf.T(a.class);
        s.checkNotNull(paramJSONObject);
        paramJSONObject = ((a)paramJSONObject).zg(j);
        if (paramJSONObject == null)
        {
          paramf.callback(paramInt, a(null, a.a.rUw, null));
          AppMethodBeat.o(325975);
          return;
        }
        localObject1 = (Map)new HashMap();
        h.ahAA.j(new c..ExternalSyntheticLambda0(paramf, paramInt, this, j, (Map)localObject1, paramJSONObject, localMap), "JsApiRunInferenceSessionTask+" + paramf.getAppId() + '+' + j);
        AppMethodBeat.o(325975);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */