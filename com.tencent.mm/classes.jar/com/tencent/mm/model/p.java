package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.z;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.end;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil;", "", "()V", "Companion", "EnRecommendFeedsInfoSwitchOption", "GetRecommendFeedScene", "GetRecommendFeedsIconType", "GetRecommendFeedsStyleFlag", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  private static final j<MultiProcessMMKV> exj;
  public static final a ojc;
  private static final j<Boolean> ojd;
  private static final j<Boolean> oje;
  private static List<ab> ojf;
  private static final AtomicLong ojg;
  private static final String ojh;
  private static String oji;
  
  static
  {
    AppMethodBeat.i(241909);
    ojc = new a((byte)0);
    exj = kotlin.k.cm((kotlin.g.a.a)p.b.ojm);
    ojd = kotlin.k.cm((kotlin.g.a.a)p.c.ojn);
    oje = kotlin.k.cm((kotlin.g.a.a)p.d.ojo);
    ojf = (List)new LinkedList();
    ojg = new AtomicLong(0L);
    h.baC();
    ojh = s.X("FirstScreenData:", b.aZs());
    AppMethodBeat.o(241909);
  }
  
  public static final int bAq()
  {
    AppMethodBeat.i(241873);
    int i = kotlin.k.k.qv(kotlin.k.k.qu(a.atj().decodeInt("ProtectionTime", 1800), ad.iYR()), 86400);
    Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("protectionTime = ", Integer.valueOf(i)));
    AppMethodBeat.o(241873);
    return i;
  }
  
  public static final int bAr()
  {
    AppMethodBeat.i(241877);
    int i = a.bAr();
    AppMethodBeat.o(241877);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$Companion;", "", "()V", "DEFAULT_PRELOAD_INTERVAL", "", "DEFAULT_PROTECTION_TIME", "TAG", "", "firstScreenDataKey", "getFirstScreenDataKey", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "openGetRecFeedsOnClickBack", "", "getOpenGetRecFeedsOnClickBack", "()Z", "openGetRecFeedsOnClickBack$delegate", "openGetRecFeedsOnClickBizBack", "getOpenGetRecFeedsOnClickBizBack", "openGetRecFeedsOnClickBizBack$delegate", "orderFlag", "Ljava/util/concurrent/atomic/AtomicLong;", "getOrderFlag", "()Ljava/util/concurrent/atomic/AtomicLong;", "recList", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecList", "()Ljava/util/List;", "setRecList", "(Ljava/util/List;)V", "recReportData", "getRecReportData", "setRecReportData", "(Ljava/lang/String;)V", "filterRecommendFeed", "feed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "list", "getBizmsgContextCnt", "getFirstScreen", "Lcom/tencent/mm/protocal/protobuf/GetRecommendFeedsResp;", "getLastSaveRecList", "getNextReqTime", "getRecFeedScene", "Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "getProtectionTime", "getRecommendFeeds", "recommendFeedsContext", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsContext;", "bizMsgReSortContext", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "(Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;Lcom/tencent/mm/protocal/protobuf/RecommendFeedsContext;Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendFeedsWording", "getRefreshFreq", "getSubscribeMsgLimit", "isRecFeedSvrOpen", "onRemove", "", "info", "recommendCardFeedback", "negativeFeedbackReason", "Ljava/util/LinkedList;", "saveFirstScreen", "resp", "saveLastRecList", "setRecommendReportData", "reportData", "updateRecommendFeedsInfo", "recommendFeedsInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsInfo;", "getString", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsConfig;", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final int a(int paramInt1, int paramInt2, String paramString, c paramc, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(242101);
      s.u(paramc, "rr");
      s.u(paramp, "$noName_4");
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "recommendCardFeedback callback " + paramInt1 + ", " + paramInt2);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(242101);
        return 0;
      }
      AppMethodBeat.o(242101);
      return 0;
    }
    
    public static int a(p.f paramf)
    {
      AppMethodBeat.i(242073);
      s.u(paramf, "getRecFeedScene");
      int i = atj().decodeInt(s.X("NextReqTime-", Integer.valueOf(paramf.scene)), 600);
      AppMethodBeat.o(242073);
      return i * 1000;
    }
    
    public static void a(cra paramcra)
    {
      AppMethodBeat.i(242086);
      s.u(paramcra, "resp");
      try
      {
        atj().encode(p.bAx(), paramcra.toByteArray());
        AppMethodBeat.o(242086);
        return;
      }
      catch (Exception paramcra)
      {
        Log.printErrStackTrace("Micromsg.BizTLRecFeedsDataUtil", (Throwable)paramcra, "saveFirstScreen", new Object[0]);
        AppMethodBeat.o(242086);
      }
    }
    
    public static void a(ab paramab)
    {
      AppMethodBeat.i(242092);
      s.u(paramab, "info");
      if (paramab.acFJ == null)
      {
        AppMethodBeat.o(242092);
        return;
      }
      cra localcra = bAz();
      if (localcra != null)
      {
        Object localObject1 = localcra.aaxG;
        s.s(localObject1, "it.RecommendCard");
        Iterator localIterator = ((Iterable)localObject1).iterator();
        localObject1 = null;
        label129:
        while (localIterator.hasNext())
        {
          ene localene = (ene)localIterator.next();
          String str = localene.YSF;
          Object localObject2 = paramab.acFJ;
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((ene)localObject2).YSF)
          {
            if (!s.p(str, localObject2)) {
              break label129;
            }
            Log.i("Micromsg.BizTLRecFeedsDataUtil", "onRemove first screen data");
            localObject1 = localene;
            break;
          }
        }
        if (localObject1 != null)
        {
          localcra.aaxG.remove(localObject1);
          paramab = p.ojc;
          a(localcra);
        }
      }
      AppMethodBeat.o(242092);
    }
    
    public static void a(ab paramab, LinkedList<String> paramLinkedList)
    {
      AppMethodBeat.i(242079);
      s.u(paramab, "info");
      s.u(paramLinkedList, "negativeFeedbackReason");
      c.a locala = new c.a();
      enj localenj = new enj();
      localenj.aaxG = new LinkedList();
      LinkedList localLinkedList = localenj.aaxG;
      end localend = new end();
      localend.YVA = paramLinkedList;
      localend.YVK = paramab.acFJ.YVK;
      localend.abrB = paramab.field_orderFlag;
      localenj.abrU = ad.getSessionId();
      paramab = kotlin.ah.aiuX;
      localLinkedList.add(localend);
      paramab = kotlin.ah.aiuX;
      locala.otE = ((com.tencent.mm.bx.a)localenj);
      locala.otF = ((com.tencent.mm.bx.a)new cra());
      locala.uri = "/cgi-bin/mmbiz-bin/timeline/recommendfeedsfeedback";
      locala.funcId = 5198;
      z.a(locala.bEF(), p.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(242079);
    }
    
    public static boolean a(ene paramene, List<ab> paramList)
    {
      AppMethodBeat.i(242084);
      s.u(paramene, "feed");
      if (paramList == null)
      {
        AppMethodBeat.o(242084);
        return false;
      }
      if (!com.tencent.mm.storage.ah.c(paramene))
      {
        AppMethodBeat.o(242084);
        return false;
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        ab localab = (ab)paramList.next();
        if ((localab.acFJ != null) && (s.p(paramene.YSF, localab.acFJ.YSF)))
        {
          paramList = o.ojb;
          o.ir(4L);
          Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("filterRecommendFeed cardId repeat ", paramene.YSF));
          AppMethodBeat.o(242084);
          return false;
        }
      }
      AppMethodBeat.o(242084);
      return true;
    }
    
    public static MultiProcessMMKV atj()
    {
      AppMethodBeat.i(242056);
      MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)p.bAs().getValue();
      AppMethodBeat.o(242056);
      return localMultiProcessMMKV;
    }
    
    public static boolean bAA()
    {
      AppMethodBeat.i(242098);
      boolean bool = atj().decodeBool("BizTLRecommendFeedsSvrOpen", false);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("BizTLRecommendFeedsSvrOpen = ", Boolean.valueOf(bool)));
      AppMethodBeat.o(242098);
      return bool;
    }
    
    public static int bAr()
    {
      AppMethodBeat.i(242096);
      int i = atj().decodeInt("SubscribeMsgLimit", 0);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("subscribeMsgLimit = ", Integer.valueOf(i)));
      if (i <= 0)
      {
        AppMethodBeat.o(242096);
        return 2000;
      }
      AppMethodBeat.o(242096);
      return i;
    }
    
    public static cra bAz()
    {
      int j = 1;
      AppMethodBeat.i(242088);
      Object localObject1 = atj();
      s.s(localObject1, "mmkv");
      Object localObject3 = p.bAx();
      int i;
      if (((MultiProcessMMKV)localObject1).containsKey((String)localObject3))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes((String)localObject3);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label96;
            }
            i = j;
            label54:
            if (i == 0) {
              break label119;
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = cra.class.newInstance();
          ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bx.a)localObject3;
          localObject1 = (cra)localObject1;
          AppMethodBeat.o(242088);
          return localObject1;
        }
        catch (Exception localException)
        {
          label96:
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break;
        i = 0;
        break label54;
        label119:
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */