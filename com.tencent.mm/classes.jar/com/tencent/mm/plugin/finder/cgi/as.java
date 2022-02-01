package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dyt;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFoldedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "friendUsername", "", "feedId", "", "nonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFriendUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFoldedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "isFetchFeedCgi", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class as
  extends ap
{
  private final String KJD;
  private final String TAG;
  private g callback;
  private final long feedId;
  public int pullType;
  public com.tencent.mm.al.b rr;
  
  public as(String paramString1, long paramLong, String paramString2, com.tencent.mm.bx.b paramb, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197297);
    this.KJD = paramString1;
    this.feedId = paramLong;
    this.TAG = "Finder.NetSceneFinderGetFoldedList";
    paramString1 = new b.a();
    paramString1.nB(getType());
    dyt localdyt = new dyt();
    localdyt.KJD = this.KJD;
    localdyt.objectId = this.feedId;
    localdyt.lastBuffer = paramb;
    localdyt.objectNonceId = paramString2;
    paramb = am.KJy;
    localdyt.DlF = am.a(paramdzp);
    paramString1.c((a)localdyt);
    paramString1.d((a)new dyu());
    paramString1.wg("/cgi-bin/micromsg-bin/findergetfoldedlist");
    paramString1 = paramString1.atI();
    d.g.b.k.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    ad.i(this.TAG, "NetSceneFinderGetFoldedList friendUsername:" + this.KJD + " feedId:" + this.feedId + " nonceId:" + paramString2);
    AppMethodBeat.o(197297);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(197294);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197294);
    return i;
  }
  
  public final boolean fRR()
  {
    return true;
  }
  
  public final LinkedList<FinderObject> fRX()
  {
    AppMethodBeat.i(197296);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFoldedListResponse");
      AppMethodBeat.o(197296);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((dyu)localObject).object;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(197296);
    return localObject;
  }
  
  public final int getType()
  {
    return 3904;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197295);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 9L, 1L, false);
      paramq = this.TAG;
      paramArrayOfByte = new StringBuilder("friendUsername ").append(this.KJD).append("  feedId:").append(this.feedId).append(' ');
      i locali = i.qoK;
      ad.i(paramq, i.du((List)fRX()));
      paramq = fRX();
      if (paramq != null) {
        paramq = ((Iterable)paramq).iterator();
      }
    }
    else
    {
      while (paramq.hasNext())
      {
        k((FinderObject)paramq.next());
        continue;
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 10L, 1L, false);
      }
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(197295);
      return;
    }
    AppMethodBeat.o(197295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.as
 * JD-Core Version:    0.7.0.1
 */