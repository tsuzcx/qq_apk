package com.tencent.mm.mj_template.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.mj_template.album_template.b;
import com.tencent.mm.mj_template.api.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/plugin/SnsMaasConfigImpl;", "Lcom/tencent/mm/mj_template/api/ISnsMaasConfig;", "()V", "MMKV_KEY", "", "TAG", "TEMPLATE_LIST_KEY", "getDefaultCfg", "", "key", "Lcom/tencent/mm/util/ConstantsRepairer$ItemInfoKey;", "dynKey", "defaultOpen", "getDefaultTemplateIdList", "", "getDefaultTemplateList", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCutSameEntry", "versionMin", "", "showPostMainEntry", "showSpringOfflineStrategy", "showSpringStrategy", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements e
{
  private static final String odA;
  private static final String odB;
  public static final d odz;
  
  static
  {
    AppMethodBeat.i(239640);
    odz = new d();
    odA = "maas_sns_template_config";
    odB = "maas_sns_default_template_list_key";
    AppMethodBeat.o(239640);
  }
  
  public static boolean a(b.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(239636);
    i locali = i.agtt;
    parama = Integer.valueOf(i.a(parama, -1));
    if (((Number)parama).intValue() != -1)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      label36:
      if (parama != null) {
        break label94;
      }
      parama = ((a)com.tencent.mm.kernel.h.ax(a.class)).aRC();
      if (!paramBoolean) {
        break label89;
      }
      i = 1;
    }
    label60:
    label84:
    label89:
    label94:
    for (int i = parama.getInt(paramString, i);; i = parama.intValue())
    {
      if (i != 1) {
        break label102;
      }
      AppMethodBeat.o(239636);
      return true;
      i = 0;
      break;
      parama = null;
      break label36;
      i = 0;
      break label60;
    }
    label102:
    AppMethodBeat.o(239636);
    return false;
  }
  
  public static List<String> bZd()
  {
    AppMethodBeat.i(369577);
    com.tencent.e.f.h.jXD();
    Object localObject4 = ((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("SnsVideoDefaultTemplate");
    Object localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = "";
    }
    s.X("getDefaultTemplateIdList: ", localObject1);
    com.tencent.e.f.h.jXD();
    try
    {
      localObject4 = Result.Companion;
      localObject1 = Result.constructor-impl(new JSONObject((String)localObject1));
      localObject4 = localObject1;
      if (Result.isFailure-impl(localObject1)) {
        localObject4 = null;
      }
      localObject4 = (JSONObject)localObject4;
      if (localObject4 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label240;
        }
        localObject1 = (List)ab.aivy;
        AppMethodBeat.o(369577);
        return localObject1;
      }
    }
    finally
    {
      for (;;)
      {
        localObject4 = Result.Companion;
        Object localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable1));
        continue;
        try
        {
          localObject2 = Result.Companion;
          localObject2 = (List)new ArrayList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("tpls");
          int j = ((JSONArray)localObject4).length();
          int i = 0;
          while (i < j)
          {
            String str = ((JSONArray)localObject4).optJSONObject(i).getString("id");
            s.s(str, "it.getString(\"id\")");
            ((List)localObject2).add(str);
            i += 1;
          }
          localObject2 = Result.constructor-impl(localObject2);
        }
        finally
        {
          for (;;)
          {
            localObject4 = Result.Companion;
            localObject3 = Result.constructor-impl(ResultKt.createFailure(localThrowable2));
          }
        }
        localObject4 = localObject2;
        if (Result.isFailure-impl(localObject2)) {
          localObject4 = null;
        }
        localObject4 = (List)localObject4;
        localObject2 = localObject4;
        if (localObject4 == null) {
          localObject2 = (List)ab.aivy;
        }
      }
      Object localObject3;
      label240:
      AppMethodBeat.o(369577);
      return localObject3;
    }
  }
  
  /* Error */
  public final Object L(kotlin.d.d<? super List<? extends com.tencent.mm.protocal.protobuf.fxr>> paramd)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: instanceof 8
    //   9: ifeq +92 -> 101
    //   12: aload_1
    //   13: checkcast 8	com/tencent/mm/mj_template/plugin/d$a
    //   16: astore 4
    //   18: aload 4
    //   20: getfield 213	com/tencent/mm/mj_template/plugin/d$a:label	I
    //   23: ldc 214
    //   25: iand
    //   26: ifeq +75 -> 101
    //   29: aload 4
    //   31: aload 4
    //   33: getfield 213	com/tencent/mm/mj_template/plugin/d$a:label	I
    //   36: ldc 214
    //   38: iadd
    //   39: putfield 213	com/tencent/mm/mj_template/plugin/d$a:label	I
    //   42: aload 4
    //   44: astore_1
    //   45: aload_1
    //   46: getfield 218	com/tencent/mm/mj_template/plugin/d$a:result	Ljava/lang/Object;
    //   49: astore 10
    //   51: getstatic 224	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   54: astore 14
    //   56: aload_1
    //   57: getfield 213	com/tencent/mm/mj_template/plugin/d$a:label	I
    //   60: tableswitch	default:+24 -> 84, 0:+54->114, 1:+820->880
    //   85: nop
    //   86: <illegal opcode>
    //   87: dup
    //   88: ldc 228
    //   90: invokespecial 229	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: ldc 209
    //   96: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    //   101: new 8	com/tencent/mm/mj_template/plugin/d$a
    //   104: dup
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial 232	com/tencent/mm/mj_template/plugin/d$a:<init>	(Lcom/tencent/mm/mj_template/plugin/d;Lkotlin/d/d;)V
    //   110: astore_1
    //   111: goto -66 -> 45
    //   114: aload 10
    //   116: invokestatic 236	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   119: invokestatic 122	com/tencent/e/f/h:jXD	()V
    //   122: ldc 97
    //   124: invokestatic 103	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   127: checkcast 97	com/tencent/mm/plugin/zero/b/a
    //   130: invokeinterface 107 1 0
    //   135: ldc 124
    //   137: invokevirtual 128	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 5
    //   142: aload 5
    //   144: astore 4
    //   146: aload 5
    //   148: ifnonnull +7 -> 155
    //   151: ldc 129
    //   153: astore 4
    //   155: ldc 238
    //   157: aload 4
    //   159: invokestatic 137	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   162: pop
    //   163: invokestatic 122	com/tencent/e/f/h:jXD	()V
    //   166: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   169: astore 5
    //   171: new 145	org/json/JSONObject
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 148	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: astore 4
    //   185: aload 4
    //   187: astore 5
    //   189: aload 4
    //   191: invokestatic 156	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   194: ifeq +6 -> 200
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: checkcast 145	org/json/JSONObject
    //   205: astore 5
    //   207: aload 5
    //   209: ifnonnull +43 -> 252
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: ifnonnull +918 -> 1133
    //   218: getstatic 162	kotlin/a/ab:aivy	Lkotlin/a/ab;
    //   221: checkcast 164	java/util/List
    //   224: astore_1
    //   225: ldc 209
    //   227: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_1
    //   231: areturn
    //   232: astore 4
    //   234: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   237: astore 5
    //   239: aload 4
    //   241: invokestatic 170	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   244: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   247: astore 4
    //   249: goto -64 -> 185
    //   252: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   255: astore 4
    //   257: new 172	java/util/ArrayList
    //   260: dup
    //   261: invokespecial 173	java/util/ArrayList:<init>	()V
    //   264: checkcast 164	java/util/List
    //   267: astore 4
    //   269: aload 5
    //   271: ldc 175
    //   273: invokevirtual 179	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   276: astore 5
    //   278: aload 5
    //   280: invokevirtual 184	org/json/JSONArray:length	()I
    //   283: istore_3
    //   284: iconst_0
    //   285: istore_2
    //   286: iload_2
    //   287: iload_3
    //   288: if_icmpge +50 -> 338
    //   291: aload 5
    //   293: iload_2
    //   294: invokevirtual 188	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   297: astore 6
    //   299: aload 4
    //   301: new 240	kotlin/r
    //   304: dup
    //   305: aload 6
    //   307: ldc 190
    //   309: invokevirtual 193	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   312: aload 6
    //   314: ldc 242
    //   316: invokevirtual 246	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   319: invokestatic 252	kotlin/d/b/a/b:BF	(J)Ljava/lang/Long;
    //   322: invokespecial 255	kotlin/r:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   325: invokeinterface 202 2 0
    //   330: pop
    //   331: iload_2
    //   332: iconst_1
    //   333: iadd
    //   334: istore_2
    //   335: goto -49 -> 286
    //   338: aload 4
    //   340: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   343: astore 4
    //   345: aload 4
    //   347: astore 5
    //   349: aload 4
    //   351: invokestatic 156	kotlin/Result:isFailure-impl	(Ljava/lang/Object;)Z
    //   354: ifeq +6 -> 360
    //   357: aconst_null
    //   358: astore 5
    //   360: aload 5
    //   362: checkcast 164	java/util/List
    //   365: astore 5
    //   367: aload 5
    //   369: ifnonnull +441 -> 810
    //   372: getstatic 162	kotlin/a/ab:aivy	Lkotlin/a/ab;
    //   375: checkcast 164	java/util/List
    //   378: astore 5
    //   380: getstatic 62	com/tencent/mm/mj_template/plugin/d:odA	Ljava/lang/String;
    //   383: invokestatic 261	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   386: astore 7
    //   388: aload 7
    //   390: ldc_w 263
    //   393: invokestatic 199	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   396: getstatic 66	com/tencent/mm/mj_template/plugin/d:odB	Ljava/lang/String;
    //   399: astore 4
    //   401: aload 7
    //   403: aload 4
    //   405: invokevirtual 267	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:containsKey	(Ljava/lang/String;)Z
    //   408: ifeq +435 -> 843
    //   411: aload 7
    //   413: aload 4
    //   415: invokevirtual 271	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBytes	(Ljava/lang/String;)[B
    //   418: astore 4
    //   420: aload 4
    //   422: ifnull +421 -> 843
    //   425: aload 4
    //   427: arraylength
    //   428: ifne +385 -> 813
    //   431: iconst_1
    //   432: istore_2
    //   433: iload_2
    //   434: ifne +384 -> 818
    //   437: iconst_1
    //   438: istore_2
    //   439: iload_2
    //   440: ifeq +403 -> 843
    //   443: ldc_w 273
    //   446: invokevirtual 279	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   449: astore 6
    //   451: aload 6
    //   453: checkcast 281	com/tencent/mm/bx/a
    //   456: aload 4
    //   458: invokevirtual 285	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   461: pop
    //   462: aload 6
    //   464: checkcast 281	com/tencent/mm/bx/a
    //   467: astore 4
    //   469: aload 4
    //   471: checkcast 273	com/tencent/mm/protocal/protobuf/fxu
    //   474: astore 4
    //   476: aload 4
    //   478: ifnonnull +371 -> 849
    //   481: aconst_null
    //   482: astore 4
    //   484: aload 4
    //   486: ifnonnull +373 -> 859
    //   489: getstatic 162	kotlin/a/ab:aivy	Lkotlin/a/ab;
    //   492: checkcast 164	java/util/List
    //   495: astore 4
    //   497: new 287	kotlin/g/b/ah$a
    //   500: dup
    //   501: invokespecial 288	kotlin/g/b/ah$a:<init>	()V
    //   504: astore 6
    //   506: aload 5
    //   508: checkcast 290	java/lang/Iterable
    //   511: astore 5
    //   513: new 172	java/util/ArrayList
    //   516: dup
    //   517: aload 5
    //   519: bipush 10
    //   521: invokestatic 295	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   524: invokespecial 297	java/util/ArrayList:<init>	(I)V
    //   527: checkcast 299	java/util/Collection
    //   530: astore 8
    //   532: aload 5
    //   534: invokeinterface 303 1 0
    //   539: astore 5
    //   541: aload 4
    //   543: astore 9
    //   545: aload 7
    //   547: astore 4
    //   549: aload_1
    //   550: astore 7
    //   552: aload 8
    //   554: astore_1
    //   555: aload 9
    //   557: astore 8
    //   559: aload 5
    //   561: invokeinterface 309 1 0
    //   566: ifeq +465 -> 1031
    //   569: aload 5
    //   571: invokeinterface 312 1 0
    //   576: checkcast 240	kotlin/r
    //   579: astore 11
    //   581: aload 8
    //   583: checkcast 290	java/lang/Iterable
    //   586: invokeinterface 303 1 0
    //   591: astore 10
    //   593: aload 10
    //   595: invokeinterface 309 1 0
    //   600: ifeq +274 -> 874
    //   603: aload 10
    //   605: invokeinterface 312 1 0
    //   610: astore 9
    //   612: aload 9
    //   614: checkcast 314	com/tencent/mm/protocal/protobuf/fxr
    //   617: astore 12
    //   619: aload 11
    //   621: getfield 317	kotlin/r:bsC	Ljava/lang/Object;
    //   624: aload 12
    //   626: getfield 319	com/tencent/mm/protocal/protobuf/fxr:id	Ljava/lang/String;
    //   629: invokestatic 323	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   632: ifeq +237 -> 869
    //   635: aload 11
    //   637: getfield 326	kotlin/r:bsD	Ljava/lang/Object;
    //   640: checkcast 91	java/lang/Number
    //   643: invokevirtual 330	java/lang/Number:longValue	()J
    //   646: aload 12
    //   648: getfield 334	com/tencent/mm/protocal/protobuf/fxr:abVq	Lcom/tencent/mm/protocal/protobuf/aex;
    //   651: getfield 339	com/tencent/mm/protocal/protobuf/aex:ZmY	I
    //   654: i2l
    //   655: lcmp
    //   656: ifgt +213 -> 869
    //   659: iconst_1
    //   660: istore_2
    //   661: iload_2
    //   662: ifeq -69 -> 593
    //   665: aload 9
    //   667: checkcast 314	com/tencent/mm/protocal/protobuf/fxr
    //   670: astore 10
    //   672: aload 10
    //   674: ifnonnull +333 -> 1007
    //   677: ldc_w 341
    //   680: aload 11
    //   682: invokestatic 137	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   685: pop
    //   686: invokestatic 122	com/tencent/e/f/h:jXD	()V
    //   689: aload 6
    //   691: iconst_1
    //   692: putfield 345	kotlin/g/b/ah$a:aiwY	Z
    //   695: invokestatic 351	kotlinx/coroutines/bg:kCi	()Lkotlinx/coroutines/al;
    //   698: checkcast 353	kotlin/d/f
    //   701: astore 9
    //   703: new 355	com/tencent/mm/mj_template/plugin/d$b
    //   706: dup
    //   707: aload 11
    //   709: aconst_null
    //   710: invokespecial 358	com/tencent/mm/mj_template/plugin/d$b:<init>	(Lkotlin/r;Lkotlin/d/d;)V
    //   713: checkcast 360	kotlin/g/a/m
    //   716: astore 10
    //   718: aload 7
    //   720: aload 8
    //   722: putfield 363	com/tencent/mm/mj_template/plugin/d$a:L$0	Ljava/lang/Object;
    //   725: aload 7
    //   727: aload 6
    //   729: putfield 366	com/tencent/mm/mj_template/plugin/d$a:Uf	Ljava/lang/Object;
    //   732: aload 7
    //   734: aload_1
    //   735: putfield 369	com/tencent/mm/mj_template/plugin/d$a:VC	Ljava/lang/Object;
    //   738: aload 7
    //   740: aload 5
    //   742: putfield 372	com/tencent/mm/mj_template/plugin/d$a:VD	Ljava/lang/Object;
    //   745: aload 7
    //   747: aload 4
    //   749: putfield 375	com/tencent/mm/mj_template/plugin/d$a:Ze	Ljava/lang/Object;
    //   752: aload 7
    //   754: aload_1
    //   755: putfield 378	com/tencent/mm/mj_template/plugin/d$a:aqc	Ljava/lang/Object;
    //   758: aload 7
    //   760: iconst_1
    //   761: putfield 213	com/tencent/mm/mj_template/plugin/d$a:label	I
    //   764: aload 9
    //   766: aload 10
    //   768: aload 7
    //   770: invokestatic 383	kotlinx/coroutines/l:a	(Lkotlin/d/f;Lkotlin/g/a/m;Lkotlin/d/d;)Ljava/lang/Object;
    //   773: astore 10
    //   775: aload 10
    //   777: aload 14
    //   779: if_acmpne +361 -> 1140
    //   782: ldc 209
    //   784: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   787: aload 14
    //   789: areturn
    //   790: astore 4
    //   792: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   795: astore 5
    //   797: aload 4
    //   799: invokestatic 170	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   802: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   805: astore 4
    //   807: goto -462 -> 345
    //   810: goto -430 -> 380
    //   813: iconst_0
    //   814: istore_2
    //   815: goto -382 -> 433
    //   818: iconst_0
    //   819: istore_2
    //   820: goto -381 -> 439
    //   823: astore 4
    //   825: ldc_w 385
    //   828: aload 4
    //   830: checkcast 387	java/lang/Throwable
    //   833: ldc_w 389
    //   836: iconst_0
    //   837: anewarray 4	java/lang/Object
    //   840: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: aconst_null
    //   844: astore 4
    //   846: goto -377 -> 469
    //   849: aload 4
    //   851: getfield 399	com/tencent/mm/protocal/protobuf/fxu:abVw	Ljava/util/LinkedList;
    //   854: astore 4
    //   856: goto -372 -> 484
    //   859: aload 4
    //   861: checkcast 164	java/util/List
    //   864: astore 4
    //   866: goto -369 -> 497
    //   869: iconst_0
    //   870: istore_2
    //   871: goto -210 -> 661
    //   874: aconst_null
    //   875: astore 9
    //   877: goto -212 -> 665
    //   880: aload_1
    //   881: getfield 378	com/tencent/mm/mj_template/plugin/d$a:aqc	Ljava/lang/Object;
    //   884: checkcast 299	java/util/Collection
    //   887: astore 4
    //   889: aload_1
    //   890: getfield 375	com/tencent/mm/mj_template/plugin/d$a:Ze	Ljava/lang/Object;
    //   893: checkcast 257	com/tencent/mm/sdk/platformtools/MultiProcessMMKV
    //   896: astore 9
    //   898: aload_1
    //   899: getfield 372	com/tencent/mm/mj_template/plugin/d$a:VD	Ljava/lang/Object;
    //   902: checkcast 305	java/util/Iterator
    //   905: astore 7
    //   907: aload_1
    //   908: getfield 369	com/tencent/mm/mj_template/plugin/d$a:VC	Ljava/lang/Object;
    //   911: checkcast 299	java/util/Collection
    //   914: astore 8
    //   916: aload_1
    //   917: getfield 366	com/tencent/mm/mj_template/plugin/d$a:Uf	Ljava/lang/Object;
    //   920: checkcast 287	kotlin/g/b/ah$a
    //   923: astore 6
    //   925: aload_1
    //   926: getfield 363	com/tencent/mm/mj_template/plugin/d$a:L$0	Ljava/lang/Object;
    //   929: checkcast 164	java/util/List
    //   932: astore 5
    //   934: aload 10
    //   936: invokestatic 236	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   939: aload 10
    //   941: checkcast 314	com/tencent/mm/protocal/protobuf/fxr
    //   944: astore 13
    //   946: aload 7
    //   948: astore 12
    //   950: aload 5
    //   952: astore 10
    //   954: aload 4
    //   956: astore 11
    //   958: aload_1
    //   959: astore 7
    //   961: aload 12
    //   963: astore_1
    //   964: aload 8
    //   966: astore 4
    //   968: aload 9
    //   970: astore 5
    //   972: aload 10
    //   974: astore 8
    //   976: aload 13
    //   978: astore 10
    //   980: aload 11
    //   982: aload 10
    //   984: invokeinterface 400 2 0
    //   989: pop
    //   990: aload_1
    //   991: astore 9
    //   993: aload 4
    //   995: astore_1
    //   996: aload 5
    //   998: astore 4
    //   1000: aload 9
    //   1002: astore 5
    //   1004: goto -445 -> 559
    //   1007: aload_1
    //   1008: astore 9
    //   1010: aload 5
    //   1012: astore 11
    //   1014: aload 4
    //   1016: astore 5
    //   1018: aload_1
    //   1019: astore 4
    //   1021: aload 11
    //   1023: astore_1
    //   1024: aload 9
    //   1026: astore 11
    //   1028: goto -48 -> 980
    //   1031: aload_1
    //   1032: checkcast 164	java/util/List
    //   1035: astore_1
    //   1036: aload 6
    //   1038: getfield 345	kotlin/g/b/ah$a:aiwY	Z
    //   1041: ifeq +62 -> 1103
    //   1044: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   1047: astore 5
    //   1049: getstatic 66	com/tencent/mm/mj_template/plugin/d:odB	Ljava/lang/String;
    //   1052: astore 5
    //   1054: new 273	com/tencent/mm/protocal/protobuf/fxu
    //   1057: dup
    //   1058: invokespecial 401	com/tencent/mm/protocal/protobuf/fxu:<init>	()V
    //   1061: astore 6
    //   1063: aload 6
    //   1065: new 403	java/util/LinkedList
    //   1068: dup
    //   1069: aload_1
    //   1070: checkcast 299	java/util/Collection
    //   1073: invokespecial 406	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   1076: putfield 399	com/tencent/mm/protocal/protobuf/fxu:abVw	Ljava/util/LinkedList;
    //   1079: getstatic 412	kotlin/ah:aiuX	Lkotlin/ah;
    //   1082: astore 7
    //   1084: aload 4
    //   1086: aload 5
    //   1088: aload 6
    //   1090: invokevirtual 416	com/tencent/mm/protocal/protobuf/fxu:toByteArray	()[B
    //   1093: invokevirtual 420	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;[B)Z
    //   1096: invokestatic 425	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1099: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1102: pop
    //   1103: aload_1
    //   1104: checkcast 290	java/lang/Iterable
    //   1107: invokestatic 429	kotlin/a/p:l	(Ljava/lang/Iterable;)Ljava/util/List;
    //   1110: astore_1
    //   1111: goto -897 -> 214
    //   1114: astore 4
    //   1116: getstatic 143	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   1119: astore 5
    //   1121: aload 4
    //   1123: invokestatic 170	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   1126: invokestatic 152	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1129: pop
    //   1130: goto -27 -> 1103
    //   1133: ldc 209
    //   1135: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1138: aload_1
    //   1139: areturn
    //   1140: aload_1
    //   1141: astore 11
    //   1143: aload_1
    //   1144: astore 12
    //   1146: aload 8
    //   1148: astore 13
    //   1150: aload 7
    //   1152: astore_1
    //   1153: aload 4
    //   1155: astore 9
    //   1157: aload 5
    //   1159: astore 7
    //   1161: aload 11
    //   1163: astore 4
    //   1165: aload 12
    //   1167: astore 8
    //   1169: aload 13
    //   1171: astore 5
    //   1173: goto -234 -> 939
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1176	0	this	d
    //   0	1176	1	paramd	kotlin.d.d<? super List<? extends com.tencent.mm.protocal.protobuf.fxr>>
    //   285	586	2	i	int
    //   283	6	3	j	int
    //   16	174	4	localObject1	Object
    //   232	8	4	localThrowable1	Throwable
    //   247	501	4	localObject2	Object
    //   790	8	4	localThrowable2	Throwable
    //   805	1	4	localObject3	Object
    //   823	6	4	localException	java.lang.Exception
    //   844	241	4	localObject4	Object
    //   1114	40	4	localThrowable3	Throwable
    //   1163	1	4	localObject5	Object
    //   140	1032	5	localObject6	Object
    //   297	792	6	localObject7	Object
    //   386	774	7	localObject8	Object
    //   530	638	8	localObject9	Object
    //   543	613	9	localObject10	Object
    //   49	934	10	localObject11	Object
    //   579	583	11	localObject12	Object
    //   617	549	12	localObject13	Object
    //   944	226	13	localObject14	Object
    //   54	734	14	locala	kotlin.d.a.a
    // Exception table:
    //   from	to	target	type
    //   166	185	232	finally
    //   252	284	790	finally
    //   291	331	790	finally
    //   338	345	790	finally
    //   443	469	823	java/lang/Exception
    //   1044	1103	1114	finally
  }
  
  public final boolean bxi()
  {
    AppMethodBeat.i(239647);
    if (a(b.a.agsl, "SnsVideoTemplateEnabled", false))
    {
      b localb = b.nWa;
      if (b.bwC())
      {
        AppMethodBeat.o(239647);
        return true;
      }
    }
    AppMethodBeat.o(239647);
    return false;
  }
  
  public final boolean ip(long paramLong)
  {
    AppMethodBeat.i(239653);
    if (paramLong > 1001000L)
    {
      new StringBuilder("showCutSameEntry: templateMin is ").append(paramLong).append(", sdk is 1001000");
      com.tencent.e.f.h.jXD();
      AppMethodBeat.o(239653);
      return false;
    }
    if ((bxi()) && (a(b.a.agsm, "SnsVideoTemplateUseSameTemplateEnabled", false)))
    {
      AppMethodBeat.o(239653);
      return true;
    }
    AppMethodBeat.o(239653);
    return false;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239627);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.odC.L((kotlin.d.d)this);
      AppMethodBeat.o(239627);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.plugin.d
 * JD-Core Version:    0.7.0.1
 */