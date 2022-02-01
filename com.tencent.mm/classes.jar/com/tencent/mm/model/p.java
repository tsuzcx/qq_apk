package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.f;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil;", "", "()V", "Companion", "EnRecommendFeedsInfoSwitchOption", "GetRecommendFeedScene", "GetRecommendFeedsIconType", "GetRecommendFeedsStyleFlag", "plugin-biz_release"})
public final class p
{
  private static final f lrB;
  private static final f lrC;
  private static List<z> lrD;
  private static final AtomicLong lrE;
  private static final String lrF;
  private static String lrG;
  public static final a lrH;
  
  static
  {
    AppMethodBeat.i(205438);
    lrH = new a((byte)0);
    lrB = kotlin.g.ar((kotlin.g.a.a)p.b.lrM);
    lrC = kotlin.g.ar((kotlin.g.a.a)p.c.lrN);
    lrD = (List)new LinkedList();
    lrE = new AtomicLong(0L);
    StringBuilder localStringBuilder = new StringBuilder("FirstScreenData:");
    kotlin.g.b.p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    lrF = com.tencent.mm.kernel.b.aGq();
    AppMethodBeat.o(205438);
  }
  
  public static final int bcH()
  {
    AppMethodBeat.i(205442);
    int i = i.ow(i.ov(a.bcJ().decodeInt("ProtectionTime", 1800), ab.hxm()), 86400);
    Log.i("Micromsg.BizTLRecFeedsDataUtil", "protectionTime = ".concat(String.valueOf(i)));
    AppMethodBeat.o(205442);
    return i;
  }
  
  public static final int bcI()
  {
    AppMethodBeat.i(205444);
    int i = a.bcI();
    AppMethodBeat.o(205444);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$Companion;", "", "()V", "DEFAULT_PRELOAD_INTERVAL", "", "DEFAULT_PROTECTION_TIME", "TAG", "", "firstScreenDataKey", "getFirstScreenDataKey", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "openGetRecFeedsOnClickBack", "", "getOpenGetRecFeedsOnClickBack", "()Z", "openGetRecFeedsOnClickBack$delegate", "orderFlag", "Ljava/util/concurrent/atomic/AtomicLong;", "getOrderFlag", "()Ljava/util/concurrent/atomic/AtomicLong;", "recList", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecList", "()Ljava/util/List;", "setRecList", "(Ljava/util/List;)V", "recReportData", "getRecReportData", "setRecReportData", "(Ljava/lang/String;)V", "filterRecommendFeed", "feed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "list", "getFirstScreen", "Lcom/tencent/mm/protocal/protobuf/GetRecommendFeedsResp;", "getLastSaveRecList", "getProtectionTime", "getRecommendFeeds", "getRecFeedScene", "Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "recommendFeedsContext", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsContext;", "(Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;Lcom/tencent/mm/protocal/protobuf/RecommendFeedsContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendFeedsWording", "getSubscribeMsgLimit", "isRecFeedSvrOpen", "onRemove", "", "info", "recommendCardFeedback", "negativeFeedbackReason", "Ljava/util/LinkedList;", "saveFirstScreen", "resp", "saveLastRecList", "setRecommendReportData", "reportData", "updateSvrSwitch", "recommendFeedsInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsInfo;", "getString", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsConfig;", "plugin-biz_release"})
  public static final class a
  {
    public static Object a(final p.e parame, final duk paramduk, kotlin.d.d<? super cbt> paramd)
    {
      AppMethodBeat.i(205512);
      kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.k(paramd));
      final kotlin.d.d locald = (kotlin.d.d)localh;
      Object localObject1 = new d.a();
      Object localObject2 = new cbs();
      ((cbs)localObject2).CPw = parame.scene;
      Object localObject3 = p.lrH;
      localObject3 = bcJ().decodeBytes("GetRecommendFeedsBuffer");
      if (localObject3 != null) {
        ((cbs)localObject2).Tkb = new com.tencent.mm.cd.b((byte[])localObject3);
      }
      ((cbs)localObject2).Tkc = paramduk;
      ((d.a)localObject1).c((com.tencent.mm.cd.a)localObject2);
      ((d.a)localObject1).d((com.tencent.mm.cd.a)new cbt());
      ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/timeline/getrecommendfeeds");
      ((d.a)localObject1).vD(4690);
      localObject1 = ((d.a)localObject1).bgN();
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds scene=" + parame.scene);
      long l1;
      if (p.e.lrT.scene == parame.scene)
      {
        l1 = System.currentTimeMillis();
        localObject2 = p.lrH;
        long l2 = bcJ().decodeLong("LastReqTime", 0L);
        localObject2 = p.lrH;
        int i = bcJ().decodeInt("NextReqTime", 600);
        if (Math.abs(l1 - l2) < i * 1000)
        {
          Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds delta < interval, return");
          parame = Result.Companion;
          locald.resumeWith(Result.constructor-impl(null));
        }
      }
      for (;;)
      {
        parame = localh.iBS();
        if (parame == kotlin.d.a.a.aaAA) {
          kotlin.g.b.p.k(paramd, "frame");
        }
        AppMethodBeat.o(205512);
        return parame;
        localObject2 = p.lrH;
        bcJ().encode("LastReqTime", l1);
        localObject2 = new kotlin.g.b.aa.a();
        ((kotlin.g.b.aa.a)localObject2).aaBx = false;
        aa.a((com.tencent.mm.an.d)localObject1, (com.tencent.mm.an.aa.a)new a((kotlin.g.b.aa.a)localObject2, locald, parame, paramduk));
      }
    }
    
    public static void a(cbt paramcbt)
    {
      AppMethodBeat.i(205514);
      kotlin.g.b.p.k(paramcbt, "resp");
      try
      {
        bcJ().encode(p.bcF(), paramcbt.toByteArray());
        AppMethodBeat.o(205514);
        return;
      }
      catch (Exception paramcbt)
      {
        Log.printErrStackTrace("Micromsg.BizTLRecFeedsDataUtil", (Throwable)paramcbt, "saveFirstScreen", new Object[0]);
        AppMethodBeat.o(205514);
      }
    }
    
    public static boolean a(dug paramdug, List<z> paramList)
    {
      AppMethodBeat.i(205513);
      kotlin.g.b.p.k(paramdug, "feed");
      if (paramList == null)
      {
        AppMethodBeat.o(205513);
        return false;
      }
      if (!af.c(paramdug))
      {
        AppMethodBeat.o(205513);
        return false;
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        z localz = (z)paramList.next();
        if ((localz.Ven != null) && (kotlin.g.b.p.h(paramdug.RVi, localz.Ven.RVi)))
        {
          paramList = o.lrA;
          o.Gh(4L);
          Log.i("Micromsg.BizTLRecFeedsDataUtil", "filterRecommendFeed cardId repeat " + paramdug.RVi);
          AppMethodBeat.o(205513);
          return false;
        }
      }
      AppMethodBeat.o(205513);
      return true;
    }
    
    public static int bcI()
    {
      AppMethodBeat.i(205517);
      int i = bcJ().decodeInt("SubscribeMsgLimit", 0);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "subscribeMsgLimit = ".concat(String.valueOf(i)));
      if (i <= 0)
      {
        AppMethodBeat.o(205517);
        return 2000;
      }
      AppMethodBeat.o(205517);
      return i;
    }
    
    public static MultiProcessMMKV bcJ()
    {
      AppMethodBeat.i(205511);
      Object localObject = p.bcB();
      a locala = p.lrH;
      localObject = (MultiProcessMMKV)((f)localObject).getValue();
      AppMethodBeat.o(205511);
      return localObject;
    }
    
    public static cbt bcK()
    {
      int j = 1;
      AppMethodBeat.i(205516);
      Object localObject1 = bcJ();
      kotlin.g.b.p.j(localObject1, "mmkv");
      Object localObject3 = p.bcF();
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
          localObject3 = cbt.class.newInstance();
          ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.cd.a)localObject3;
          localObject1 = (cbt)localObject1;
          AppMethodBeat.o(205516);
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
    
    public static boolean bcL()
    {
      AppMethodBeat.i(205518);
      boolean bool = bcJ().decodeBool("BizTLRecommendFeedsSvrOpen", false);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "BizTLRecommendFeedsSvrOpen = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(205518);
      return bool;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback", "com/tencent/mm/model/BizTLRecFeedsDataUtil$Companion$getRecommendFeeds$2$1"})
    static final class a
      implements com.tencent.mm.an.aa.a
    {
      a(kotlin.g.b.aa.a parama, kotlin.d.d paramd, p.e parame, duk paramduk) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, q paramq)
      {
        Object localObject = null;
        AppMethodBeat.i(207286);
        kotlin.g.b.p.k(paramd, "rr");
        kotlin.g.b.p.k(paramq, "<anonymous parameter 4>");
        Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds callback " + paramInt1 + ", " + paramInt2);
        if (this.lrI.aaBx)
        {
          paramString = o.lrA;
          o.Gh(6L);
          AppMethodBeat.o(207286);
          return 0;
        }
        this.lrI.aaBx = true;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          try
          {
            paramString = o.lrA;
            o.Gh(3L);
            paramString = locald;
            paramd = Result.Companion;
            paramString.resumeWith(Result.constructor-impl(null));
            AppMethodBeat.o(207286);
            return 0;
          }
          catch (Exception paramString)
          {
            paramd = o.lrA;
            o.Gh(7L);
            Log.e("Micromsg.BizTLRecFeedsDataUtil", "callback ex " + paramString.getMessage());
          }
          AppMethodBeat.o(207286);
          return 0;
        }
        paramString = o.lrA;
        o.Gh(2L);
        if (!(paramd.bhY() instanceof cbt))
        {
          paramString = locald;
          paramd = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(null));
          AppMethodBeat.o(207286);
          return 0;
        }
        paramString = paramd.bhY();
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetRecommendFeedsResp");
          AppMethodBeat.o(207286);
          throw paramString;
        }
        paramd = (cbt)paramString;
        paramString = com.tencent.mm.plugin.webview.core.g.PHD;
        if (g.a.No())
        {
          paramString = MultiProcessMMKV.getSingleMMKV("brandService");
          if ((paramString != null) && (paramString.decodeInt("BizTimeLineRecFeedStatus", 1) == 0))
          {
            paramString = paramd.Tkd;
            if (paramString != null) {
              paramString.clear();
            }
          }
        }
        paramq = new StringBuilder("getRecommendFeeds card size=");
        paramString = paramd.Tkd;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.size());
          label329:
          paramq = paramq.append(paramString).append(' ');
          duj localduj = paramd.Tke;
          paramString = localObject;
          if (localduj != null)
          {
            paramString = p.lrH;
            kotlin.g.b.p.k(localduj, "$this$getString");
            paramString = "NextReqTime=" + localduj.UaK + " ProtectionTime=" + localduj.UaL;
          }
          Log.i("Micromsg.BizTLRecFeedsDataUtil", paramString);
          if ((paramd.Tkb != null) && (paramd.Tkb.UH.length > 0))
          {
            paramString = p.lrH;
            p.a.bcJ().encode("GetRecommendFeedsBuffer", paramd.Tkb.toByteArray());
          }
          if (p.e.lrU.scene == parame.scene)
          {
            paramString = p.lrH;
            p.a.bcJ().encode("RecommendFeedsWording", paramd.Tkf);
            paramString = p.lrH;
            paramString = p.a.bcJ();
            paramq = paramd.Tke;
            if (paramq == null) {
              break label591;
            }
            paramInt1 = paramq.UaK;
            label518:
            paramString.encode("NextReqTime", paramInt1);
            paramString = p.lrH;
            paramString = p.a.bcJ();
            paramq = paramd.Tke;
            if (paramq == null) {
              break label598;
            }
          }
        }
        label591:
        label598:
        for (paramInt1 = paramq.UaL;; paramInt1 = 1800)
        {
          paramString.encode("ProtectionTime", paramInt1);
          paramString = locald;
          paramq = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramd));
          break;
          paramString = null;
          break label329;
          paramInt1 = 600;
          break label518;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "GET_RECOMMEND_FEEDS_SCENE_PRELOAD", "GET_RECOMMEND_FEEDS_SCENE_ENTER", "GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", "GET_RECOMMEND_FEEDS_SCENE_REPLACE", "GET_RECOMMEND_FEEDS_SCENE_SUPPLEMENT", "plugin-biz_release"})
  public static enum e
  {
    final int scene;
    
    static
    {
      AppMethodBeat.i(206419);
      e locale1 = new e("GET_RECOMMEND_FEEDS_SCENE_PRELOAD", 0, 1);
      lrT = locale1;
      e locale2 = new e("GET_RECOMMEND_FEEDS_SCENE_ENTER", 1, 2);
      lrU = locale2;
      e locale3 = new e("GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", 2, 3);
      lrV = locale3;
      e locale4 = new e("GET_RECOMMEND_FEEDS_SCENE_REPLACE", 3, 4);
      lrW = locale4;
      e locale5 = new e("GET_RECOMMEND_FEEDS_SCENE_SUPPLEMENT", 4, 5);
      lrX = locale5;
      lrY = new e[] { locale1, locale2, locale3, locale4, locale5 };
      AppMethodBeat.o(206419);
    }
    
    private e(int paramInt)
    {
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */