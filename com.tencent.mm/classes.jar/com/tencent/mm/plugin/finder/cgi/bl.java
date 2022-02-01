package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bl
  extends ax
{
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private static final int tvl = 1;
  private static final int tvm = 2;
  public static final a tvn;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(242426);
    tvn = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    tvl = 1;
    tvm = 2;
    AppMethodBeat.o(242426);
  }
  
  public bl(b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(242425);
    Object localObject2 = new d.a();
    ((d.a)localObject2).sG(getType());
    Object localObject1 = new asb();
    ((asb)localObject1).finderUsername = z.aUg();
    ((asb)localObject1).lastBuffer = paramb;
    ((asb)localObject1).hFK = paramLong;
    int i;
    if (paramBoolean)
    {
      i = tvm;
      ((asb)localObject1).scene = i;
      am localam = am.tuw;
      ((asb)localObject1).LAI = am.cXY();
      ((d.a)localObject2).c((a)localObject1);
      ((d.a)localObject2).d((a)new asc());
      ((d.a)localObject2).MB("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((d.a)localObject2).aXF();
      p.g(localObject2, "builder.buildInstance()");
      this.rr = ((d)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((asb)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(242425);
      return;
      i = tvl;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242419);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242419);
      return;
    }
    AppMethodBeat.o(242419);
  }
  
  public final b cYm()
  {
    AppMethodBeat.i(242421);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(242421);
      throw ((Throwable)localObject);
    }
    localObject = ((asc)localObject).lastBuffer;
    AppMethodBeat.o(242421);
    return localObject;
  }
  
  public final b cYn()
  {
    AppMethodBeat.i(242420);
    Object localObject = this.rr.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(242420);
      throw ((Throwable)localObject);
    }
    localObject = ((asb)localObject).lastBuffer;
    AppMethodBeat.o(242420);
    return localObject;
  }
  
  public final boolean cYp()
  {
    AppMethodBeat.i(242423);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(242423);
      throw ((Throwable)localObject);
    }
    if (((asc)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(242423);
      return true;
    }
    AppMethodBeat.o(242423);
    return false;
  }
  
  public final LinkedList<aul> cYw()
  {
    AppMethodBeat.i(242422);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(242422);
      throw ((Throwable)localObject);
    }
    localObject = ((asc)localObject).likeList;
    p.g(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(242422);
    return localObject;
  }
  
  public final asc cYx()
  {
    AppMethodBeat.i(242424);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(242424);
      throw ((Throwable)localObject);
    }
    localObject = (asc)localObject;
    AppMethodBeat.o(242424);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242418);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242418);
    return i;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bl
 * JD-Core Version:    0.7.0.1
 */