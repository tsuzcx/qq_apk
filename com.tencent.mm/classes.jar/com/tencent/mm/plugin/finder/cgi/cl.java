package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cl
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACi;
  private static final int ACj;
  private static final int ACk;
  private static final String TAG;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336664);
    ACi = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    ACj = 1;
    ACk = 2;
    AppMethodBeat.o(336664);
  }
  
  public cl(b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(336660);
    Object localObject2 = new c.a();
    ((c.a)localObject2).funcId = getType();
    Object localObject1 = new ayu();
    ((ayu)localObject1).finderUsername = z.bAW();
    ((ayu)localObject1).lastBuffer = paramb;
    ((ayu)localObject1).hKN = paramLong;
    int i;
    if (paramBoolean)
    {
      i = ACk;
      ((ayu)localObject1).scene = i;
      bi localbi = bi.ABn;
      ((ayu)localObject1).ZEc = bi.dVu();
      ((c.a)localObject2).otE = ((a)localObject1);
      ((c.a)localObject2).otF = ((a)new ayv());
      ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/findergetfeedlikedlist";
      localObject2 = ((c.a)localObject2).bEF();
      kotlin.g.b.s.s(localObject2, "builder.buildInstance()");
      this.rr = ((c)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((ayu)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(336660);
      return;
      i = ACj;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336682);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336682);
  }
  
  public final b dVJ()
  {
    AppMethodBeat.i(336694);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(336694);
      throw ((Throwable)localObject);
    }
    localObject = ((ayv)localObject).lastBuffer;
    AppMethodBeat.o(336694);
    return localObject;
  }
  
  public final b dVL()
  {
    AppMethodBeat.i(336688);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(336688);
      throw ((Throwable)localObject);
    }
    localObject = ((ayu)localObject).lastBuffer;
    AppMethodBeat.o(336688);
    return localObject;
  }
  
  public final boolean dVN()
  {
    AppMethodBeat.i(336702);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(336702);
      throw ((Throwable)localObject);
    }
    if (((ayv)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(336702);
      return true;
    }
    AppMethodBeat.o(336702);
    return false;
  }
  
  public final LinkedList<bco> dVU()
  {
    AppMethodBeat.i(336699);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(336699);
      throw ((Throwable)localObject);
    }
    localObject = ((ayv)localObject).likeList;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…edLikedListResp).likeList");
    AppMethodBeat.o(336699);
    return localObject;
  }
  
  public final ayv dVV()
  {
    AppMethodBeat.i(336705);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(336705);
      throw ((Throwable)localObject);
    }
    localObject = (ayv)localObject;
    AppMethodBeat.o(336705);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336676);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336676);
    return i;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cl
 * JD-Core Version:    0.7.0.1
 */