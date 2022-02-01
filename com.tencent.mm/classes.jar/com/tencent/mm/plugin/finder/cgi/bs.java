package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "displayOption", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getMentionTotalCount", "getRespLastBuffer", "getTotalCount", "", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bs
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private final String TAG;
  private i callback;
  public int pullType;
  public d rr;
  private final String username;
  
  public bs(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(291526);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new d.a();
    paramString.vD(getType());
    avi localavi = new avi();
    localavi.RLN = this.username;
    localavi.SDI = paramb;
    localavi.SHG = paramInt;
    ao localao = ao.xcj;
    localavi.RLM = ao.dnO();
    paramString.c((a)localavi);
    paramString.vD(getType());
    paramString.d((a)new avj());
    paramString.TW("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username + " lastBuffer:" + paramb);
    AppMethodBeat.o(291526);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(291523);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("friendUsername ").append(this.username).append(' ');
      am localam = am.xch;
      Log.i(params, am.dY(dor()));
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(291523);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(291522);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(291522);
    return i;
  }
  
  public final List<FinderObject> dor()
  {
    AppMethodBeat.i(291524);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(291524);
      throw ((Throwable)localObject);
    }
    localObject = ((avj)localObject).object;
    p.j(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(291524);
    return localObject;
  }
  
  public final int dos()
  {
    AppMethodBeat.i(291525);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(291525);
      throw ((Throwable)localObject);
    }
    int i = ((avj)localObject).SHH;
    AppMethodBeat.o(291525);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bs
 * JD-Core Version:    0.7.0.1
 */