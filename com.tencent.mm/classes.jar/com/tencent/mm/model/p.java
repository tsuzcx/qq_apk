package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.webview.core.g.a;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dku;
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
import kotlin.d.h;
import kotlin.f;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil;", "", "()V", "Companion", "EnRecommendFeedsInfoSwitchOption", "GetRecommendFeedScene", "plugin-biz_release"})
public final class p
{
  private static final f iBW;
  private static List<z> iBX;
  private static final AtomicLong iBY;
  private static final String iBZ;
  public static final a iCa;
  
  static
  {
    AppMethodBeat.i(212398);
    iCa = new a((byte)0);
    iBW = kotlin.g.ah((kotlin.g.a.a)p.b.iCd);
    iBX = (List)new LinkedList();
    iBY = new AtomicLong(0L);
    StringBuilder localStringBuilder = new StringBuilder("FirstScreenData:");
    kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    iBZ = com.tencent.mm.kernel.a.ayV();
    AppMethodBeat.o(212398);
  }
  
  public static final int aTG()
  {
    AppMethodBeat.i(212399);
    int i = j.na(j.mZ(a.aTI().decodeInt("ProtectionTime", 1800), ab.gBc()), 86400);
    Log.i("Micromsg.BizTLRecFeedsDataUtil", "protectionTime = ".concat(String.valueOf(i)));
    AppMethodBeat.o(212399);
    return i;
  }
  
  public static final int aTH()
  {
    AppMethodBeat.i(212400);
    int i = a.aTH();
    AppMethodBeat.o(212400);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$Companion;", "", "()V", "DEFAULT_PRELOAD_INTERVAL", "", "DEFAULT_PROTECTION_TIME", "TAG", "", "firstScreenDataKey", "getFirstScreenDataKey", "()Ljava/lang/String;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "orderFlag", "Ljava/util/concurrent/atomic/AtomicLong;", "getOrderFlag", "()Ljava/util/concurrent/atomic/AtomicLong;", "recList", "", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "getRecList", "()Ljava/util/List;", "setRecList", "(Ljava/util/List;)V", "filterRecommendFeed", "", "feed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "list", "getFirstScreen", "Lcom/tencent/mm/protocal/protobuf/GetRecommendFeedsResp;", "getLastSaveRecList", "getProtectionTime", "getRecommendFeeds", "getRecFeedScene", "Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "(Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendFeedsWording", "getSubscribeMsgLimit", "isRecFeedSvrOpen", "onRemove", "", "info", "recommendCardFeedback", "negativeFeedbackReason", "Ljava/util/LinkedList;", "saveFirstScreen", "resp", "saveLastRecList", "updateSvrSwitch", "recommendFeedsInfo", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsInfo;", "getString", "Lcom/tencent/mm/protocal/protobuf/RecommendFeedsConfig;", "plugin-biz_release"})
  public static final class a
  {
    public static Object a(final p.d paramd, kotlin.d.d<? super bub> paramd1)
    {
      AppMethodBeat.i(212386);
      h localh = new h(kotlin.d.a.b.e(paramd1));
      kotlin.d.d locald = (kotlin.d.d)localh;
      Object localObject1 = new d.a();
      Object localObject2 = new bua();
      ((bua)localObject2).Scene = paramd.scene;
      Object localObject3 = p.iCa;
      localObject3 = aTI().decodeBytes("GetRecommendFeedsBuffer");
      if (localObject3 != null) {
        ((bua)localObject2).Buffer = new com.tencent.mm.bw.b((byte[])localObject3);
      }
      ((d.a)localObject1).c((com.tencent.mm.bw.a)localObject2);
      ((d.a)localObject1).d((com.tencent.mm.bw.a)new bub());
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/timeline/getrecommendfeeds");
      ((d.a)localObject1).sG(4690);
      localObject1 = ((d.a)localObject1).aXF();
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds scene=" + paramd.scene);
      long l1;
      if (p.d.iCj.scene == paramd.scene)
      {
        l1 = System.currentTimeMillis();
        localObject2 = p.iCa;
        long l2 = aTI().decodeLong("LastReqTime", 0L);
        localObject2 = p.iCa;
        int i = aTI().decodeInt("NextReqTime", 600);
        if (Math.abs(l1 - l2) < i * 1000)
        {
          Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds delta < interval, return");
          paramd = Result.Companion;
          locald.resumeWith(Result.constructor-impl(null));
        }
      }
      for (;;)
      {
        paramd = localh.hxK();
        if (paramd == kotlin.d.a.a.SXO) {
          kotlin.g.b.p.h(paramd1, "frame");
        }
        AppMethodBeat.o(212386);
        return paramd;
        localObject2 = p.iCa;
        aTI().encode("LastReqTime", l1);
        aa.a((com.tencent.mm.ak.d)localObject1, (aa.a)new a(locald, paramd));
      }
    }
    
    public static void a(bub parambub)
    {
      AppMethodBeat.i(212388);
      kotlin.g.b.p.h(parambub, "resp");
      try
      {
        aTI().encode(p.aTF(), parambub.toByteArray());
        AppMethodBeat.o(212388);
        return;
      }
      catch (Exception parambub)
      {
        Log.printErrStackTrace("Micromsg.BizTLRecFeedsDataUtil", (Throwable)parambub, "saveFirstScreen", new Object[0]);
        AppMethodBeat.o(212388);
      }
    }
    
    public static boolean a(dkr paramdkr, List<z> paramList)
    {
      AppMethodBeat.i(212387);
      kotlin.g.b.p.h(paramdkr, "feed");
      kotlin.g.b.p.h(paramList, "list");
      if (!af.b(paramdkr))
      {
        AppMethodBeat.o(212387);
        return false;
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        z localz = (z)paramList.next();
        if ((localz.NQr != null) && (kotlin.g.b.p.j(paramdkr.KUk, localz.NQr.KUk)))
        {
          paramList = o.iBV;
          o.Aa(4L);
          Log.i("Micromsg.BizTLRecFeedsDataUtil", "filterRecommendFeed cardId repeat " + paramdkr.KUk);
          AppMethodBeat.o(212387);
          return false;
        }
      }
      AppMethodBeat.o(212387);
      return true;
    }
    
    public static int aTH()
    {
      AppMethodBeat.i(212390);
      int i = aTI().decodeInt("SubscribeMsgLimit", 0);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "subscribeMsgLimit = ".concat(String.valueOf(i)));
      if (i <= 0)
      {
        AppMethodBeat.o(212390);
        return 2000;
      }
      AppMethodBeat.o(212390);
      return i;
    }
    
    public static MultiProcessMMKV aTI()
    {
      AppMethodBeat.i(212385);
      Object localObject = p.aTC();
      a locala = p.iCa;
      localObject = (MultiProcessMMKV)((f)localObject).getValue();
      AppMethodBeat.o(212385);
      return localObject;
    }
    
    public static bub aTJ()
    {
      int j = 1;
      AppMethodBeat.i(212389);
      Object localObject1 = aTI();
      kotlin.g.b.p.g(localObject1, "mmkv");
      Object localObject3 = p.aTF();
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
          localObject3 = bub.class.newInstance();
          ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject3;
          localObject1 = (bub)localObject1;
          AppMethodBeat.o(212389);
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
    
    public static boolean aTK()
    {
      AppMethodBeat.i(212391);
      boolean bool = aTI().decodeBool("BizTLRecommendFeedsSvrOpen", false);
      Log.i("Micromsg.BizTLRecFeedsDataUtil", "BizTLRecommendFeedsSvrOpen = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(212391);
      return bool;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback", "com/tencent/mm/model/BizTLRecFeedsDataUtil$Companion$getRecommendFeeds$2$1"})
    static final class a
      implements aa.a
    {
      a(kotlin.d.d paramd, p.d paramd1) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
      {
        Object localObject = null;
        AppMethodBeat.i(212380);
        kotlin.g.b.p.h(paramd, "rr");
        kotlin.g.b.p.h(paramq, "<anonymous parameter 4>");
        Log.i("Micromsg.BizTLRecFeedsDataUtil", "getRecommendFeeds callback " + paramInt1 + ", " + paramInt2);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString = o.iBV;
          o.Aa(3L);
          paramString = this.iCb;
          paramd = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(null));
          AppMethodBeat.o(212380);
          return 0;
        }
        paramString = o.iBV;
        o.Aa(2L);
        paramd = paramd.aYK();
        paramString = paramd;
        if (!(paramd instanceof bub)) {
          paramString = null;
        }
        paramd = (bub)paramString;
        if (paramd == null)
        {
          AppMethodBeat.o(212380);
          return 0;
        }
        paramString = com.tencent.mm.plugin.webview.core.g.ILB;
        if (g.a.KB())
        {
          paramString = MultiProcessMMKV.getSingleMMKV("brandService");
          if ((paramString != null) && (paramString.decodeInt("BizTimeLineRecFeedStatus", 1) == 0))
          {
            paramString = paramd.MaI;
            if (paramString != null) {
              paramString.clear();
            }
          }
        }
        paramq = new StringBuilder("getRecommendFeeds card size=");
        paramString = paramd.MaI;
        if (paramString != null)
        {
          paramString = Integer.valueOf(paramString.size());
          paramq = paramq.append(paramString).append(' ');
          dku localdku = paramd.MaJ;
          paramString = localObject;
          if (localdku != null)
          {
            paramString = p.iCa;
            kotlin.g.b.p.h(localdku, "$this$getString");
            paramString = "NextReqTime=" + localdku.MON + " ProtectionTime=" + localdku.MOO + " SubscribeMsgLimit=" + localdku.MOP;
          }
          Log.i("Micromsg.BizTLRecFeedsDataUtil", paramString);
          if ((paramd.Buffer != null) && (paramd.Buffer.zy.length > 0))
          {
            paramString = p.iCa;
            p.a.aTI().encode("GetRecommendFeedsBuffer", paramd.Buffer.toByteArray());
          }
          if (p.d.iCk.scene == paramd.scene)
          {
            paramString = p.iCa;
            p.a.aTI().encode("RecommendFeedsWording", paramd.MaK);
            paramString = p.iCa;
            paramString = p.a.aTI();
            paramq = paramd.MaJ;
            if (paramq == null) {
              break label530;
            }
            paramInt1 = paramq.MON;
            label419:
            paramString.encode("NextReqTime", paramInt1);
            paramString = p.iCa;
            paramString = p.a.aTI();
            paramq = paramd.MaJ;
            if (paramq == null) {
              break label537;
            }
            paramInt1 = paramq.MOO;
            label453:
            paramString.encode("ProtectionTime", paramInt1);
            paramString = p.iCa;
            paramString = p.a.aTI();
            paramq = paramd.MaJ;
            if (paramq == null) {
              break label544;
            }
          }
        }
        label530:
        label537:
        label544:
        for (paramInt1 = paramq.MOP;; paramInt1 = 0)
        {
          paramString.encode("SubscribeMsgLimit", paramInt1);
          paramString = this.iCb;
          paramq = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramd));
          AppMethodBeat.o(212380);
          return 0;
          paramString = null;
          break;
          paramInt1 = 600;
          break label419;
          paramInt1 = 1800;
          break label453;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "GET_RECOMMEND_FEEDS_SCENE_PRELOAD", "GET_RECOMMEND_FEEDS_SCENE_ENTER", "GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", "plugin-biz_release"})
  public static enum d
  {
    final int scene;
    
    static
    {
      AppMethodBeat.i(212395);
      d locald1 = new d("GET_RECOMMEND_FEEDS_SCENE_PRELOAD", 0, 1);
      iCj = locald1;
      d locald2 = new d("GET_RECOMMEND_FEEDS_SCENE_ENTER", 1, 2);
      iCk = locald2;
      d locald3 = new d("GET_RECOMMEND_FEEDS_SCENE_LOAD_MORE", 2, 3);
      iCl = locald3;
      iCm = new d[] { locald1, locald2, locald3 };
      AppMethodBeat.o(212395);
    }
    
    private d(int paramInt)
    {
      this.scene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */