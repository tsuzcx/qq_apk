package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dyr;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class at
  extends ap
{
  private static final int KJE = 1;
  private static final int KJF = 2;
  public static final a KJG;
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private g callback;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(197308);
    KJG = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    KJE = 1;
    KJF = 2;
    AppMethodBeat.o(197308);
  }
  
  public at(com.tencent.mm.bx.b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(197307);
    Object localObject2 = new b.a();
    ((b.a)localObject2).nB(getType());
    Object localObject1 = new dyr();
    ((dyr)localObject1).finderUsername = u.aqO();
    ((dyr)localObject1).lastBuffer = paramb;
    ((dyr)localObject1).objectId = paramLong;
    int i;
    if (paramBoolean)
    {
      i = KJF;
      ((dyr)localObject1).scene = i;
      am localam = am.KJy;
      ((dyr)localObject1).DlF = am.fRS();
      ((b.a)localObject2).c((a)localObject1);
      ((b.a)localObject2).d((a)new dys());
      ((b.a)localObject2).wg("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((b.a)localObject2).atI();
      d.g.b.k.g(localObject2, "builder.buildInstance()");
      this.rr = ((com.tencent.mm.al.b)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((dyr)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ad.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(197307);
      return;
      i = KJE;
      break;
    }
  }
  
  public final com.tencent.mm.bx.b ckJ()
  {
    AppMethodBeat.i(197303);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(197303);
      throw ((Throwable)localObject);
    }
    localObject = ((dys)localObject).lastBuffer;
    AppMethodBeat.o(197303);
    return localObject;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197300);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197300);
    return i;
  }
  
  public final boolean fRW()
  {
    AppMethodBeat.i(197305);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(197305);
      throw ((Throwable)localObject);
    }
    if (((dys)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(197305);
      return true;
    }
    AppMethodBeat.o(197305);
    return false;
  }
  
  public final com.tencent.mm.bx.b fRY()
  {
    AppMethodBeat.i(197302);
    Object localObject = this.rr.auL();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(197302);
      throw ((Throwable)localObject);
    }
    localObject = ((dyr)localObject).lastBuffer;
    AppMethodBeat.o(197302);
    return localObject;
  }
  
  public final LinkedList<dzd> fRZ()
  {
    AppMethodBeat.i(197304);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(197304);
      throw ((Throwable)localObject);
    }
    localObject = ((dys)localObject).likeList;
    d.g.b.k.g(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(197304);
    return localObject;
  }
  
  public final dys fSa()
  {
    AppMethodBeat.i(197306);
    Object localObject = this.rr.auM();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(197306);
      throw ((Throwable)localObject);
    }
    localObject = (dys)localObject;
    AppMethodBeat.o(197306);
    return localObject;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197301);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(197301);
      return;
    }
    AppMethodBeat.o(197301);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.at
 * JD-Core Version:    0.7.0.1
 */