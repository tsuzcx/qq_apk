package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionedFeed;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "username", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRespLastBuffer", "getTotalCount", "", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class bp
  extends ax
{
  private final String TAG;
  private i callback;
  public int pullType;
  public d rr;
  private final String username;
  
  public bp(String paramString, b paramb)
  {
    AppMethodBeat.i(242443);
    this.username = paramString;
    this.TAG = "Finder.NetSceneFinderGetMentionedFeed";
    paramString = new d.a();
    paramString.sG(getType());
    atf localatf = new atf();
    localatf.LAt = this.username;
    localatf.LDs = paramb;
    paramb = am.tuw;
    localatf.LBM = am.cXY();
    paramString.c((a)localatf);
    paramString.sG(getType());
    paramString.d((a)new atg());
    paramString.MB("/cgi-bin/micromsg-bin/findergetmentionedlist");
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    Log.i(this.TAG, "NetSceneFinderGetMentionedFeed init: " + this.username);
    AppMethodBeat.o(242443);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242441);
    Log.i(this.TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("friendUsername ").append(this.username).append(' ');
      al localal = al.tuv;
      Log.i(params, al.dQ(cYD()));
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242441);
  }
  
  public final List<FinderObject> cYD()
  {
    AppMethodBeat.i(242442);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionedListResponse");
      AppMethodBeat.o(242442);
      throw ((Throwable)localObject);
    }
    localObject = ((atg)localObject).object;
    p.g(localObject, "(rr.responseProtoBuf as …nedListResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(242442);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242440);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242440);
    return i;
  }
  
  public final int getType()
  {
    return 3810;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bp
 * JD-Core Version:    0.7.0.1
 */