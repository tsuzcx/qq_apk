package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "feedId", "", "encryptedFeedId", "maxId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "getEncryptedFeedId", "()Ljava/lang/String;", "getFeedId", "()J", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "()I", "setPullType", "(I)V", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAdFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getPrivateLock", "getResponseBuffer", "getType", "getWording", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class at
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcs;
  private com.tencent.mm.an.i callback;
  private final long feedId;
  public int pullType;
  public com.tencent.mm.an.d rr;
  public boolean xcp;
  private final String xcq;
  private final String xcr;
  
  static
  {
    AppMethodBeat.i(269646);
    xcs = new a((byte)0);
    AppMethodBeat.o(269646);
  }
  
  public at(String paramString1, long paramLong1, String paramString2, long paramLong2, b paramb, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(269645);
    this.xcq = paramString1;
    this.feedId = paramLong1;
    this.xcr = paramString2;
    this.xcp = true;
    paramString1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramString1 = com.tencent.mm.plugin.finder.api.d.a.aAK(this.xcq);
    if (paramString1 != null)
    {
      paramString1 = paramString1.field_firstPageMD5;
      if (paramString1 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2 = new com.tencent.mm.an.d.a();
      paramString2.TW("/cgi-bin/micromsg-bin/finderaduserpage");
      paramString2.vD(getType());
      apq localapq = new apq();
      localapq.username = this.xcq;
      localapq.JVf = paramLong2;
      localapq.firstPageMD5 = paramString1;
      Object localObject = ao.xcj;
      localapq.SCW = ao.dnP();
      localapq.RLN = z.bdh();
      localObject = ao.xcj;
      localapq.yjp = ao.a(parambid);
      localObject = localapq.yjp;
      if (localObject != null)
      {
        if (parambid != null)
        {
          i = parambid.fGo;
          ((aqe)localObject).scene = i;
        }
      }
      else
      {
        if (n.L(localapq.username, localapq.RLN, false)) {
          localapq.SCV = 1;
        }
        parambid = ao.xcj;
        parambid = localapq.yjp;
        localObject = localapq.yjp;
        if (localObject == null) {
          break label428;
        }
      }
      label428:
      for (int i = ((aqe)localObject).scene;; i = 0)
      {
        ao.a(parambid, j.listOf(new o(Integer.valueOf(i), Long.valueOf(this.feedId))));
        localapq.SCX = this.feedId;
        localapq.xxK = this.xcr;
        localapq.lastBuffer = paramb;
        paramb = new apr();
        paramString2.c((a)localapq);
        paramString2.d((a)paramb);
        paramString2 = paramString2.bgN();
        p.j(paramString2, "builder.buildInstance()");
        this.rr = paramString2;
        this.pullType = paramInt;
        Log.i("Finder.NetSceneAdFeedListval", "NetSceneFinderUserPage init maxId " + paramLong2 + " username " + this.xcq + " pullType " + paramInt + " fpMD5 " + paramString1);
        AppMethodBeat.o(269645);
        return;
        i = 0;
        break;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(269644);
    Log.i("Finder.NetSceneAdFeedListval", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderAdUserPageResponse");
        AppMethodBeat.o(269644);
        throw paramString;
      }
      if (((apr)params).continueFlag != 1) {
        break label157;
      }
    }
    label157:
    for (boolean bool = true;; bool = false)
    {
      this.xcp = bool;
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(269644);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(269643);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(269643);
    return i;
  }
  
  public final int getType()
  {
    return 6692;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneAdFeedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */