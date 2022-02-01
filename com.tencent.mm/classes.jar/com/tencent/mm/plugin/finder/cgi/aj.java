package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class aj
  extends ac
{
  private final String TAG;
  private f callback;
  private final long dtq;
  public int pullType;
  private final String rJk;
  public com.tencent.mm.al.b rr;
  
  public aj(String paramString1, long paramLong, String paramString2, com.tencent.mm.bx.b paramb, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201123);
    this.rJk = paramString1;
    this.dtq = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new b.a();
    paramString1.oP(getType());
    anq localanq = new anq();
    localanq.rJk = this.rJk;
    localanq.rIZ = this.dtq;
    localanq.lastBuffer = paramb;
    localanq.objectNonceId = paramString2;
    paramb = v.rIR;
    localanq.Gle = v.a(paramaqy);
    paramString1.c((a)localanq);
    paramString1.d((a)new anr());
    paramString1.Dl("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.aDC();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.rJk + " feedId:" + this.dtq + " nonceId:" + paramString2);
    AppMethodBeat.o(201123);
  }
  
  public final boolean cxU()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> cyk()
  {
    AppMethodBeat.i(201122);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(201122);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((anr)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201122);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201120);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201120);
    return i;
  }
  
  public final int getType()
  {
    return 3904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201121);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 9L, 1L, false);
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.rJk).append("  feedId:").append(this.dtq).append(' ');
      u localu = u.rIQ;
      ad.i(paramq, u.dy((List)cyk()));
      paramq = cyk();
      if (paramq != null) {
        paramq = ((Iterable)paramq).iterator();
      }
    }
    else
    {
      while (paramq.hasNext())
      {
        d((FinderObject)paramq.next());
        continue;
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201121);
      return;
    }
    AppMethodBeat.o(201121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */