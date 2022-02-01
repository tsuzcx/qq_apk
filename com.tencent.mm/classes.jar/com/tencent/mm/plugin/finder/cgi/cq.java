package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "displayOption", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMentionTotalCount", "getRespLastBuffer", "getTotalCount", "", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cq
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String TAG;
  private com.tencent.mm.am.h callback;
  public int pullType;
  public c rr;
  private final String username;
  
  public cq(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(336642);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new c.a();
    paramString.funcId = getType();
    bag localbag = new bag();
    localbag.YIZ = this.username;
    localbag.ZEQ = paramb;
    localbag.ZLe = paramInt;
    bi localbi = bi.ABn;
    localbag.YIY = bi.dVu();
    paramString.otE = ((a)localbag);
    paramString.funcId = getType();
    paramString.otF = ((a)new bah());
    paramString.uri = "/cgi-bin/micromsg-bin/findergetmentionedlist";
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username + " lastBuffer:" + paramb);
    AppMethodBeat.o(336642);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336683);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("friendUsername ").append(this.username).append(' ');
      bg localbg = bg.ABl;
      Log.i(params, bg.fV(dWd()));
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336683);
  }
  
  public final List<FinderObject> dWd()
  {
    AppMethodBeat.i(336692);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(336692);
      throw ((Throwable)localObject);
    }
    localObject = ((bah)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(336692);
    return localObject;
  }
  
  public final int dWe()
  {
    AppMethodBeat.i(336700);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(336700);
      throw ((Throwable)localObject);
    }
    int i = ((bah)localObject).ZLf;
    AppMethodBeat.o(336700);
    return i;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336669);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336669);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cq
 * JD-Core Version:    0.7.0.1
 */