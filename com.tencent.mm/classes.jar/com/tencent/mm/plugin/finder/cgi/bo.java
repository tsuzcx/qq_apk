package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "feedId", "", "isPosterView", "", "(Lcom/tencent/mm/protobuf/ByteString;JZ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFriendRecommedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "getRequestBuffer", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetFeedLikedListResp;", "getResponseBuffer", "getType", "hasContinue", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bo
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderGetFriendRecommendList";
  private static final int xcS = 1;
  private static final int xcT = 2;
  public static final a xcU;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(268507);
    xcU = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetFriendRecommendList";
    xcS = 1;
    xcT = 2;
    AppMethodBeat.o(268507);
  }
  
  public bo(b paramb, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(268506);
    Object localObject2 = new d.a();
    ((d.a)localObject2).vD(getType());
    Object localObject1 = new auc();
    ((auc)localObject1).finderUsername = z.bdh();
    ((auc)localObject1).lastBuffer = paramb;
    ((auc)localObject1).xbk = paramLong;
    int i;
    if (paramBoolean)
    {
      i = xcT;
      ((auc)localObject1).scene = i;
      ao localao = ao.xcj;
      ((auc)localObject1).SDi = ao.dnO();
      ((d.a)localObject2).c((a)localObject1);
      ((d.a)localObject2).d((a)new aud());
      ((d.a)localObject2).TW("/cgi-bin/micromsg-bin/findergetfeedlikedlist");
      localObject2 = ((d.a)localObject2).bgN();
      p.j(localObject2, "builder.buildInstance()");
      this.rr = ((d)localObject2);
      localObject2 = TAG;
      localObject1 = new StringBuilder("NetSceneFinderGetFriendRecommendList feedId:").append(paramLong).append(", scene: $").append(((auc)localObject1).scene).append(", lastBuff is Null? ");
      if (paramb != null) {
        break label212;
      }
    }
    label212:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i((String)localObject2, paramBoolean);
      AppMethodBeat.o(268506);
      return;
      i = xcS;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(268500);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(268500);
      return;
    }
    AppMethodBeat.o(268500);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(268499);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(268499);
    return i;
  }
  
  public final b doa()
  {
    AppMethodBeat.i(268502);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(268502);
      throw ((Throwable)localObject);
    }
    localObject = ((aud)localObject).lastBuffer;
    AppMethodBeat.o(268502);
    return localObject;
  }
  
  public final b dob()
  {
    AppMethodBeat.i(268501);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListReq");
      AppMethodBeat.o(268501);
      throw ((Throwable)localObject);
    }
    localObject = ((auc)localObject).lastBuffer;
    AppMethodBeat.o(268501);
    return localObject;
  }
  
  public final boolean dod()
  {
    AppMethodBeat.i(268504);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(268504);
      throw ((Throwable)localObject);
    }
    if (((aud)localObject).continueFlag != 0)
    {
      AppMethodBeat.o(268504);
      return true;
    }
    AppMethodBeat.o(268504);
    return false;
  }
  
  public final LinkedList<awr> dok()
  {
    AppMethodBeat.i(268503);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(268503);
      throw ((Throwable)localObject);
    }
    localObject = ((aud)localObject).likeList;
    p.j(localObject, "(rr.responseProtoBuf as …edLikedListResp).likeList");
    AppMethodBeat.o(268503);
    return localObject;
  }
  
  public final aud dol()
  {
    AppMethodBeat.i(268505);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFeedLikedListResp");
      AppMethodBeat.o(268505);
      throw ((Throwable)localObject);
    }
    localObject = (aud)localObject;
    AppMethodBeat.o(268505);
    return localObject;
  }
  
  public final int getType()
  {
    return 3593;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetFriendRecommendList$Companion;", "", "()V", "MMFinder_FeedLikedListAll", "", "MMFinder_FeedLikedListFriend", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bo
 * JD-Core Version:    0.7.0.1
 */