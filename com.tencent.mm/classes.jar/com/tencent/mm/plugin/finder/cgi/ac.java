package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.anm;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class ac
  extends w
{
  private final String TAG;
  private g callback;
  private final long dig;
  public int pullType;
  private final String qXY;
  public com.tencent.mm.ak.b rr;
  
  public ac(String paramString1, long paramLong, String paramString2, com.tencent.mm.bw.b paramb, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201175);
    this.qXY = paramString1;
    this.dig = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new b.a();
    paramString1.op(getType());
    akp localakp = new akp();
    localakp.qXY = this.qXY;
    localakp.qXP = this.dig;
    localakp.lastBuffer = paramb;
    localakp.objectNonceId = paramString2;
    paramb = q.qXH;
    localakp.EDu = q.a(paramanm);
    paramString1.c((a)localakp);
    paramString1.d((a)new akq());
    paramString1.Am("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.aAz();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.qXY + " feedId:" + this.dig + " nonceId:" + paramString2);
    AppMethodBeat.o(201175);
  }
  
  public final boolean csf()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> cst()
  {
    AppMethodBeat.i(201174);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(201174);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((akq)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(201174);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(201172);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201172);
    return i;
  }
  
  public final int getType()
  {
    return 3904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201173);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    com.tencent.mm.sdk.platformtools.ac.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 9L, 1L, false);
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.qXY).append("  feedId:").append(this.dig).append(' ');
      p localp = p.qXG;
      com.tencent.mm.sdk.platformtools.ac.i(paramq, p.dw((List)cst()));
      paramq = cst();
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
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201173);
      return;
    }
    AppMethodBeat.o(201173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */