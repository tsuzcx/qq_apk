package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class am
  extends ad
{
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private static final int rRA = 2;
  public static final a rRB;
  private static final int rRz = 1;
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(201556);
    rRB = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    rRz = 1;
    rRA = 2;
    AppMethodBeat.o(201556);
  }
  
  public am(com.tencent.mm.bw.b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(201555);
    Object localObject2 = new b.a();
    ((b.a)localObject2).oS(getType());
    Object localObject1 = new aob();
    ((aob)localObject1).sbR = com.tencent.mm.model.v.aAK();
    ((aob)localObject1).lastBuffer = paramb;
    ((aob)localObject1).rRn = paramLong;
    int i;
    if (paramBoolean)
    {
      i = rRA;
      ((aob)localObject1).scene = i;
      v localv = v.rRb;
      ((aob)localObject1).GEg = v.czz();
      ((b.a)localObject2).c((a)localObject1);
      ((b.a)localObject2).d((a)new aoc());
      ((b.a)localObject2).DN("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((b.a)localObject2).aDS();
      p.g(localObject2, "builder.buildInstance()");
      this.rr = ((com.tencent.mm.ak.b)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((aob)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ae.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(201555);
      return;
      i = rRz;
      break;
    }
  }
  
  public final com.tencent.mm.bw.b czI()
  {
    AppMethodBeat.i(201551);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201551);
      throw ((Throwable)localObject);
    }
    localObject = ((aoc)localObject).lastBuffer;
    AppMethodBeat.o(201551);
    return localObject;
  }
  
  public final boolean czK()
  {
    AppMethodBeat.i(201553);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201553);
      throw ((Throwable)localObject);
    }
    if (((aoc)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201553);
      return true;
    }
    AppMethodBeat.o(201553);
    return false;
  }
  
  public final com.tencent.mm.bw.b czN()
  {
    AppMethodBeat.i(201550);
    Object localObject = this.rr.aEU();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(201550);
      throw ((Throwable)localObject);
    }
    localObject = ((aob)localObject).lastBuffer;
    AppMethodBeat.o(201550);
    return localObject;
  }
  
  public final LinkedList<apg> czO()
  {
    AppMethodBeat.i(201552);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201552);
      throw ((Throwable)localObject);
    }
    localObject = ((aoc)localObject).likeList;
    p.g(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(201552);
    return localObject;
  }
  
  public final aoc czP()
  {
    AppMethodBeat.i(201554);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201554);
      throw ((Throwable)localObject);
    }
    localObject = (aoc)localObject;
    AppMethodBeat.o(201554);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201548);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201548);
    return i;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201549);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201549);
      return;
    }
    AppMethodBeat.o(201549);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */