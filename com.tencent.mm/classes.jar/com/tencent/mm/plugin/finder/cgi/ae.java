package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ae
  extends w
{
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private static final int qXZ = 1;
  private static final int qYa = 2;
  public static final ae.a qYb;
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(201186);
    qYb = new ae.a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    qXZ = 1;
    qYa = 2;
    AppMethodBeat.o(201186);
  }
  
  public ae(com.tencent.mm.bw.b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(201185);
    Object localObject2 = new b.a();
    ((b.a)localObject2).op(getType());
    Object localObject1 = new akn();
    ((akn)localObject1).rfC = u.axE();
    ((akn)localObject1).lastBuffer = paramb;
    ((akn)localObject1).qXP = paramLong;
    int i;
    if (paramBoolean)
    {
      i = qYa;
      ((akn)localObject1).scene = i;
      q localq = q.qXH;
      ((akn)localObject1).EDu = q.csi();
      ((b.a)localObject2).c((a)localObject1);
      ((b.a)localObject2).d((a)new ako());
      ((b.a)localObject2).Am("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((b.a)localObject2).aAz();
      d.g.b.k.g(localObject2, "builder.buildInstance()");
      this.rr = ((com.tencent.mm.ak.b)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((akn)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ac.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(201185);
      return;
      i = qXZ;
      break;
    }
  }
  
  public final com.tencent.mm.bw.b csq()
  {
    AppMethodBeat.i(201181);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201181);
      throw ((Throwable)localObject);
    }
    localObject = ((ako)localObject).lastBuffer;
    AppMethodBeat.o(201181);
    return localObject;
  }
  
  public final boolean css()
  {
    AppMethodBeat.i(201183);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201183);
      throw ((Throwable)localObject);
    }
    if (((ako)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(201183);
      return true;
    }
    AppMethodBeat.o(201183);
    return false;
  }
  
  public final com.tencent.mm.bw.b csv()
  {
    AppMethodBeat.i(201180);
    Object localObject = this.rr.aBC();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(201180);
      throw ((Throwable)localObject);
    }
    localObject = ((akn)localObject).lastBuffer;
    AppMethodBeat.o(201180);
    return localObject;
  }
  
  public final LinkedList<alo> csw()
  {
    AppMethodBeat.i(201182);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201182);
      throw ((Throwable)localObject);
    }
    localObject = ((ako)localObject).likeList;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(201182);
    return localObject;
  }
  
  public final ako csx()
  {
    AppMethodBeat.i(201184);
    Object localObject = this.rr.aBD();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(201184);
      throw ((Throwable)localObject);
    }
    localObject = (ako)localObject;
    AppMethodBeat.o(201184);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201178);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201178);
    return i;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201179);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(201179);
      return;
    }
    AppMethodBeat.o(201179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */