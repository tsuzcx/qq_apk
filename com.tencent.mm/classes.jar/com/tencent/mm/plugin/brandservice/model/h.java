package com.tencent.mm.plugin.brandservice.model;

import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.an.r;
import com.tencent.mm.an.t;
import com.tencent.mm.autogen.a.aa;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.message.o;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "defaultRefreshIntervalSec", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final String TAG;
  public static final h vCa;
  private static final ConcurrentHashMap<String, Integer> vCb;
  private static final r vCc;
  public static long vCd;
  public static Queue<List<Object>> vCe;
  
  static
  {
    AppMethodBeat.i(6512);
    vCa = new h();
    TAG = "MicroMsg.MPDataLogic";
    vCb = new ConcurrentHashMap();
    vCc = new r();
    vCe = (Queue)new LinkedList();
    AppMethodBeat.o(6512);
  }
  
  private static final void a(of paramof, int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(303483);
    s.u(paramof, "$req");
    Log.i(TAG, "getAppMsgRelatedInfo errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramString = paramof.YRo;
    s.s(paramString, "req.UrlInfo");
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext())
    {
      go localgo = (go)paramString.next();
      vCb.remove(localgo.nUv);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      AppMethodBeat.o(303483);
      return;
    }
    paramString = c.c.b(paramc.otC);
    if (paramString == null)
    {
      paramof = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
      AppMethodBeat.o(303483);
      throw paramof;
    }
    paramString = (og)paramString;
    paramc = MultiProcessMMKV.getMMKV(TAG);
    paramc.encode("BizAppMsgRelatedInfoRefreshIntervalSec", paramString.YRq);
    com.tencent.mm.plugin.brandservice.ui.b.b.vYz = paramString.YRq;
    paramc.encode("BizAppMsgRelatedInfoMaxUrlCount", paramString.YRr);
    if (Util.isNullOrNil((List)paramString.YRp))
    {
      Log.w(TAG, "getAppMsgRelatedInfo RelatedInfo is empty");
      AppMethodBeat.o(303483);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new h..ExternalSyntheticLambda1(paramString, paramof, paramInt1), "getAppMsgRelatedInfo");
    AppMethodBeat.o(303483);
  }
  
  private static final void a(og paramog, of paramof, int paramInt)
  {
    AppMethodBeat.i(303479);
    s.u(paramog, "$response");
    s.u(paramof, "$req");
    paramog = paramog.YRp;
    s.s(paramog, "response.RelatedInfo");
    paramof = paramof.YRo;
    s.s(paramof, "req.UrlInfo");
    Log.i(TAG, s.X("getAppMsgRelatedInfo RelatedInfo size=", Integer.valueOf(paramog.size())));
    Iterator localIterator = ((Iterable)paramog).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject1 = (com.tencent.mm.message.p)localIterator.next();
      if (Util.isNullOrNil(((com.tencent.mm.message.p)localObject1).Url)) {
        break label464;
      }
      Object localObject2 = ((Iterable)paramof).iterator();
      Object localObject3;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramog = ((Iterator)localObject2).next();
        localObject3 = (go)paramog;
      } while (!Util.isEqual(((com.tencent.mm.message.p)localObject1).nUv, ((go)localObject3).nUv));
      for (;;)
      {
        paramog = (go)paramog;
        if (paramog == null) {
          break label464;
        }
        localObject2 = paramog.Url;
        s.s(localObject2, "urlInfo.Url");
        if (aiR((String)localObject2))
        {
          localObject2 = paramog.Url;
          s.s(localObject2, "urlInfo.Url");
          localObject3 = ((com.tencent.mm.message.p)localObject1).Url;
          s.s(localObject3, "relatedInfo.Url");
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.fP((String)localObject2, (String)localObject3);
        }
        localObject2 = paramog.Url;
        s.s(localObject2, "urlInfo.Url");
        ((com.tencent.mm.message.p)localObject1).nUv = aiQ((String)localObject2);
        localObject2 = vCc;
        localObject3 = ((com.tencent.mm.message.p)localObject1).nUv;
        s.s(localObject3, "relatedInfo.ClientId");
        ((r)localObject2).add((String)localObject3);
        localObject2 = a.vCf;
        if (com.tencent.mm.plugin.brandservice.ui.b.d.b((com.tencent.mm.bx.a)a.aiS(paramog.Url), (com.tencent.mm.bx.a)localObject1)) {
          break label464;
        }
        localObject2 = a.vCf;
        a.a((com.tencent.mm.message.p)localObject1);
        if (((com.tencent.mm.message.p)localObject1).nUw == null) {
          break label425;
        }
        if (((com.tencent.mm.message.p)localObject1).nUw.nUt != 1) {
          break label372;
        }
        localObject1 = b.vBC;
        localObject2 = paramog.Url;
        s.s(localObject2, "urlInfo.Url");
        ((b)localObject1).dB((String)localObject2, paramog.nUA);
        i = 1;
        break;
        paramog = null;
      }
      label372:
      localObject1 = b.vBC;
      if (b.aiP(paramog.Url))
      {
        Log.d(TAG, s.X("url pay status: not pay url=", paramog.Url));
        localObject1 = b.vBC;
        paramog = paramog.Url;
        s.s(paramog, "urlInfo.Url");
        b.aV(paramog, false);
      }
      label425:
      i = 1;
    }
    label464:
    for (;;)
    {
      break;
      if (i != 0)
      {
        paramog = new aa();
        paramog.hzQ.scene = paramInt;
        paramog.asyncPublish(Looper.getMainLooper());
      }
      AppMethodBeat.o(303479);
      return;
    }
  }
  
  public static String aiQ(String paramString)
  {
    AppMethodBeat.i(6506);
    s.u(paramString, "url");
    paramString = s.X("_mpdata_", com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajr(paramString));
    AppMethodBeat.o(6506);
    return paramString;
  }
  
  public static boolean aiR(String paramString)
  {
    AppMethodBeat.i(6507);
    s.u(paramString, "url");
    int i = 0;
    while (i < 3)
    {
      if (UrlExKt.getUrlParam(paramString, new String[] { "__biz", "mid", "idx" }[i]) == null)
      {
        AppMethodBeat.o(6507);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(6507);
    return false;
  }
  
  public static String am(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(6508);
    Object localObject1 = "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + '/';
    String str1 = "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + '/';
    Object localObject2;
    Charset localCharset;
    try
    {
      localObject2 = String.valueOf(paramInt1);
      localCharset = kotlin.n.d.UTF_8;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(6508);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException) {}
    for (;;)
    {
      AppMethodBeat.o(6508);
      return str1;
      localObject2 = ((String)localObject2).getBytes(localCharset);
      s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject2 = Base64.encodeToString((byte[])localObject2, 2);
      s.s(localObject2, "encodeToString(\"$bizUin\"…eArray(), Base64.NO_WRAP)");
      String str2 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(localException, "__biz", (String)localObject2), "mid", String.valueOf(paramInt2)), "idx", String.valueOf(paramInt3));
      str1 = str2;
    }
  }
  
  public static void b(LinkedList<go> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(6510);
    s.u(paramLinkedList, "items");
    if (Util.isNullOrNil((List)paramLinkedList))
    {
      AppMethodBeat.o(6510);
      return;
    }
    of localof = new of();
    int i = dci();
    vCc.duration = (i * 1000);
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (go)localObject2;
      if (!vCb.contains(((go)localObject3).nUv)) {
        paramLinkedList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label233:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = ((go)localObject2).nUv;
      r localr = vCc;
      s.s(localObject3, "id");
      if (localr.contains((String)localObject3)) {}
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label233;
        }
        paramLinkedList.add(localObject2);
        break;
      }
    }
    paramLinkedList = (Iterable)paramLinkedList;
    i = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
    Log.v(TAG, s.X("maxUrlCount = ", Integer.valueOf(i)));
    paramLinkedList = kotlin.a.p.c(paramLinkedList, Math.max(i, 2));
    localof.YRo.addAll((Collection)paramLinkedList);
    if (Util.isNullOrNil((List)localof.YRo))
    {
      AppMethodBeat.o(6510);
      return;
    }
    Log.i(TAG, s.X("getAppMsgRelatedInfo size=", Integer.valueOf(localof.YRo.size())));
    localof.IJG = paramInt;
    paramLinkedList = localof.YRo;
    s.s(paramLinkedList, "req.UrlInfo");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (go)paramLinkedList.next();
      vCb.put(((go)localObject1).nUv, Integer.valueOf(1));
      localObject2 = vCc;
      localObject3 = ((go)localObject1).nUv;
      s.s(localObject3, "info.ClientId");
      ((r)localObject2).add((String)localObject3);
      if (Log.getLogLevel() == 0) {
        Log.v(TAG, "getAppMsgRelatedInfo url=" + ((go)localObject1).Url + ", clientId=" + ((go)localObject1).nUv);
      }
    }
    paramLinkedList = new c.a();
    paramLinkedList.otE = ((com.tencent.mm.bx.a)localof);
    paramLinkedList.otF = ((com.tencent.mm.bx.a)new og());
    paramLinkedList.uri = "/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo";
    paramLinkedList.funcId = 2864;
    paramLinkedList.otG = 0;
    paramLinkedList.respCmdId = 0;
    IPCRunCgi.a(paramLinkedList.bEF(), new h..ExternalSyntheticLambda0(localof, paramInt));
    AppMethodBeat.o(6510);
  }
  
  public static int dci()
  {
    int i = 300;
    AppMethodBeat.i(6511);
    int j = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
    Log.v(TAG, s.X("refreshIntervalSec = ", Integer.valueOf(j)));
    j = Math.min(j, 86400);
    if (j <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(6511);
      return i;
      i = j;
    }
  }
  
  public static void l(String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(6509);
    s.u(paramString, "url");
    long l = System.currentTimeMillis();
    j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new b(l, paramString, paramInt1, paramInt3, paramInt2, 2, null), 2);
    AppMethodBeat.o(6509);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a vCf;
    
    static
    {
      AppMethodBeat.i(6500);
      vCf = new a();
      AppMethodBeat.o(6500);
    }
    
    public static void a(com.tencent.mm.message.p paramp)
    {
      AppMethodBeat.i(6499);
      s.u(paramp, "relatedInfo");
      try
      {
        gi localgi = new gi();
        localgi.YHZ = paramp;
        localgi.lastUpdateTime = System.currentTimeMillis();
        paramp = localgi.toByteArray();
        ((MultiProcessMMKV)t.owL.getSlotForWrite()).encode(localgi.YHZ.nUv, paramp);
        AppMethodBeat.o(6499);
        return;
      }
      catch (Exception paramp)
      {
        Log.e(h.aUw(), s.X("save ex ", paramp.getMessage()));
        AppMethodBeat.o(6499);
      }
    }
    
    public static com.tencent.mm.message.p aiS(String paramString)
    {
      AppMethodBeat.i(6498);
      if (paramString == null)
      {
        AppMethodBeat.o(6498);
        return null;
      }
      Object localObject1 = h.vCa;
      localObject1 = h.aiQ(paramString);
      Object localObject2 = (MultiProcessMMKV)t.owL.findSlot((String)localObject1);
      if (localObject2 != null)
      {
        gi localgi = new gi();
        localObject2 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject1);
        if (Util.isNullOrNil((byte[])localObject2))
        {
          AppMethodBeat.o(6498);
          return null;
        }
        try
        {
          localgi.parseFrom((byte[])localObject2);
          localObject2 = localgi.YHZ;
          if (localObject2 != null) {
            ((com.tencent.mm.message.p)localObject2).Url = paramString;
          }
          if (Log.getLogLevel() == 0) {
            Log.v(h.aUw(), "found:" + (String)localObject1 + " last modify:" + Long.valueOf(localgi.lastUpdateTime));
          }
          paramString = localgi.YHZ;
          AppMethodBeat.o(6498);
          return paramString;
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace(h.aUw(), (Throwable)paramString, s.X("get:", localObject1), new Object[0]);
        }
      }
      AppMethodBeat.o(6498);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(6502);
      paramObject = (kotlin.d.d)new b(this.pmr, paramInt1, paramInt3, paramInt2, this.vCi, this.vCj, paramd);
      AppMethodBeat.o(6502);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6501);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject5;
      int i;
      int j;
      Object localObject6;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6501);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = h.dcj();
        l = this.pmr;
        localObject5 = paramInt1;
        i = paramInt3;
        j = paramInt2;
        try
        {
          localObject6 = h.vCa;
          h.kh(l);
          h.dcj().add(kotlin.a.p.al(new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(j) }));
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (bb.e(1000L, paramObject) == locala)
          {
            AppMethodBeat.o(6501);
            return locala;
          }
        }
        finally
        {
          AppMethodBeat.o(6501);
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = h.dcj();
      long l = this.pmr;
      for (;;)
      {
        try
        {
          if (h.dck() == l)
          {
            localObject2 = (Collection)h.dcj();
            if (localObject2 == null) {
              break label806;
            }
            if (((Collection)localObject2).isEmpty()) {
              break label806;
            }
          }
          else
          {
            localObject2 = ah.aiuX;
            return localObject2;
          }
          i = 0;
        }
        finally
        {
          Object localObject2;
          AppMethodBeat.o(6501);
        }
        localObject2 = new ArrayList((Collection)h.dcj());
        h.dcj().clear();
        Log.v(h.aUw(), s.X("getAppMsgRelatedInfo size:", Integer.valueOf(((ArrayList)localObject2).size())));
        localObject2 = (Iterable)kotlin.a.p.m((Iterable)localObject2);
        paramObject = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = ((Iterator)localObject2).next();
          localObject6 = (List)localObject5;
          if ((localObject6 != null) && ((((List)localObject6).get(0) instanceof String)))
          {
            i = 1;
            if (i != 0) {
              paramObject.add(localObject5);
            }
          }
          else
          {
            i = 0;
            continue;
          }
        }
        else
        {
          localObject5 = (Iterable)paramObject;
          paramObject = new HashSet();
          Object localObject4 = new ArrayList();
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = ((Iterator)localObject5).next();
            if (paramObject.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ajo((String)((List)localObject6).get(0)))) {
              ((ArrayList)localObject4).add(localObject6);
            }
          }
          localObject4 = (List)localObject4;
          i = this.vCi;
          j = this.vCj;
          if (!((List)localObject4).isEmpty())
          {
            paramObject = new LinkedList();
            localObject5 = (Iterable)localObject4;
            localObject4 = (Collection)new ArrayList();
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = ((Iterator)localObject5).next();
              if (UrlExKt.isMpArticleUrl((String)((List)localObject6).get(0))) {
                ((Collection)localObject4).add(localObject6);
              }
            }
            localObject4 = ((Iterable)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (List)((Iterator)localObject4).next();
              localObject6 = new go();
              ((go)localObject6).Url = ((String)((List)localObject5).get(0));
              Object localObject7 = h.vCa;
              localObject7 = ((go)localObject6).Url;
              s.s(localObject7, "appMsgUrlInfo.Url");
              ((go)localObject6).nUv = h.aiQ((String)localObject7);
              ((go)localObject6).nUA = ((Integer)((List)localObject5).get(1)).intValue();
              ((go)localObject6).nUz = 1;
              if ((((List)localObject5).size() > j) && (((Integer)((List)localObject5).get(j)).intValue() > 0)) {
                ((go)localObject6).nUz = ((Integer)((List)localObject5).get(j)).intValue();
              }
              paramObject.add(localObject6);
            }
            localObject4 = h.vCa;
            h.b(paramObject, i);
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(6501);
          return paramObject;
          label806:
          i = 1;
          if (i == 0) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.h
 * JD-Core Version:    0.7.0.1
 */