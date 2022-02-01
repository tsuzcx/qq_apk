package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ak
  extends ad
{
  private final String TAG;
  private f callback;
  private final long duw;
  public int pullType;
  private final String rRy;
  public com.tencent.mm.ak.b rr;
  
  public ak(String paramString1, long paramLong, String paramString2, com.tencent.mm.bw.b paramb, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201545);
    this.rRy = paramString1;
    this.duw = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new b.a();
    paramString1.oS(getType());
    aod localaod = new aod();
    localaod.rRy = this.rRy;
    localaod.rRn = this.duw;
    localaod.lastBuffer = paramb;
    localaod.objectNonceId = paramString2;
    paramb = v.rRb;
    localaod.GEg = v.a(paramarn);
    paramString1.c((a)localaod);
    paramString1.d((a)new aoe());
    paramString1.DN("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.aDS();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ae.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.rRy + " feedId:" + this.duw + " nonceId:" + paramString2);
    AppMethodBeat.o(201545);
  }
  
  public final LinkedList<FinderObject> czL()
  {
    AppMethodBeat.i(201544);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(201544);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((aoe)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201544);
    return localObject;
  }
  
  public final boolean czv()
  {
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(201542);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201542);
    return i;
  }
  
  public final int getType()
  {
    return 3904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201543);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 9L, 1L, false);
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.rRy).append("  feedId:").append(this.duw).append(' ');
      u localu = u.rRa;
      ae.i(paramq, u.dB((List)czL()));
      paramq = czL();
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
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201543);
      return;
    }
    AppMethodBeat.o(201543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */