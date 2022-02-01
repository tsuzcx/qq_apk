package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class al
  extends ac
{
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private static final int rJl = 1;
  private static final int rJm = 2;
  public static final a rJn;
  private f callback;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(201134);
    rJn = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    rJl = 1;
    rJm = 2;
    AppMethodBeat.o(201134);
  }
  
  public al(com.tencent.mm.bx.b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(201133);
    Object localObject2 = new b.a();
    ((b.a)localObject2).oP(getType());
    Object localObject1 = new ano();
    ((ano)localObject1).rTn = u.aAu();
    ((ano)localObject1).lastBuffer = paramb;
    ((ano)localObject1).rIZ = paramLong;
    int i;
    if (paramBoolean)
    {
      i = rJm;
      ((ano)localObject1).scene = i;
      v localv = v.rIR;
      ((ano)localObject1).Gle = v.cxY();
      ((b.a)localObject2).c((a)localObject1);
      ((b.a)localObject2).d((a)new anp());
      ((b.a)localObject2).Dl("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((b.a)localObject2).aDC();
      p.g(localObject2, "builder.buildInstance()");
      this.rr = ((com.tencent.mm.al.b)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((ano)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ad.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(201133);
      return;
      i = rJl;
      break;
    }
  }
  
  public final com.tencent.mm.bx.b cyh()
  {
    AppMethodBeat.i(201129);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201129);
      throw ((Throwable)localObject);
    }
    localObject = ((anp)localObject).lastBuffer;
    AppMethodBeat.o(201129);
    return localObject;
  }
  
  public final boolean cyj()
  {
    AppMethodBeat.i(201131);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201131);
      throw ((Throwable)localObject);
    }
    if (((anp)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201131);
      return true;
    }
    AppMethodBeat.o(201131);
    return false;
  }
  
  public final com.tencent.mm.bx.b cym()
  {
    AppMethodBeat.i(201128);
    Object localObject = this.rr.aEE();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(201128);
      throw ((Throwable)localObject);
    }
    localObject = ((ano)localObject).lastBuffer;
    AppMethodBeat.o(201128);
    return localObject;
  }
  
  public final LinkedList<aot> cyn()
  {
    AppMethodBeat.i(201130);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201130);
      throw ((Throwable)localObject);
    }
    localObject = ((anp)localObject).likeList;
    p.g(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(201130);
    return localObject;
  }
  
  public final anp cyo()
  {
    AppMethodBeat.i(201132);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201132);
      throw ((Throwable)localObject);
    }
    localObject = (anp)localObject;
    AppMethodBeat.o(201132);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201126);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201126);
    return i;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201127);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201127);
      return;
    }
    AppMethodBeat.o(201127);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */