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
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "finderUserName", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFinderUserName", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "setPullType", "(I)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getObjectList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getResponseLastBuffer", "getType", "hasMore", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cf
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACf;
  private com.tencent.mm.am.h callback;
  private final b lastBuffer;
  public c oDw;
  public int pullType;
  private final String zDJ;
  
  static
  {
    AppMethodBeat.i(336312);
    ACf = new a((byte)0);
    AppMethodBeat.o(336312);
  }
  
  public cf(String paramString, b paramb, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336305);
    this.zDJ = paramString;
    this.lastBuffer = paramb;
    paramString = new c.a();
    paramString.funcId = getType();
    paramString.uri = "/cgi-bin/micromsg-bin/findergetdraft";
    paramb = new ayo();
    paramb.username = this.zDJ;
    paramb.objectType = 0;
    paramb.lastBuffer = this.lastBuffer;
    bi localbi = bi.ABn;
    paramb.YIY = bi.a(parambui);
    paramString.otE = ((a)paramb);
    paramString.otF = ((a)new ayp());
    paramString = paramString.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.oDw = paramString;
    this.pullType = paramInt;
    Log.i("Finder.NetSceneFinderGetDraft", "NetSceneFinderGetDraft init finderUserName " + this.zDJ + " lastBuffer:" + this.lastBuffer);
    AppMethodBeat.o(336305);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336327);
    Log.i("Finder.NetSceneFinderGetDraft", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0) && (c.c.b(this.oDw.otC) == null))
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
      AppMethodBeat.o(336327);
      throw paramString;
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336327);
  }
  
  public final List<FinderObject> dVK()
  {
    AppMethodBeat.i(336335);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetDraftResponse");
      AppMethodBeat.o(336335);
      throw ((Throwable)localObject);
    }
    localObject = ((ayp)localObject).object;
    kotlin.g.b.s.s(localObject, "commReqResp.responseProt…etDraftResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(336335);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336319);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(336319);
    return i;
  }
  
  public final int getType()
  {
    return 5801;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetDraft$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cf
 * JD-Core Version:    0.7.0.1
 */