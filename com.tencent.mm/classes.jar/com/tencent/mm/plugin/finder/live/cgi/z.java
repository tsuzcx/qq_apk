package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.bny;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "targetUsername", "", "myUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getMyUsername", "()Ljava/lang/String;", "pullType", "", "getPullType", "()I", "setPullType", "(I)V", "getTargetUsername", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeeds", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a CvQ;
  public final String ACm;
  private final String CvR;
  private com.tencent.mm.am.h callback;
  public c oDw;
  public int pullType;
  
  static
  {
    AppMethodBeat.i(351159);
    CvQ = new a((byte)0);
    AppMethodBeat.o(351159);
  }
  
  public z(String paramString1, String paramString2, b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(351152);
    this.ACm = paramString1;
    this.CvR = paramString2;
    paramString2 = new c.a();
    paramString2.funcId = getType();
    paramString2.uri = "/cgi-bin/micromsg-bin/finderliveuserpage";
    paramString1 = new bnx();
    paramString1.YIZ = this.CvR;
    paramString1.username = this.ACm;
    paramString1.ZEQ = paramb;
    paramb = bi.ABn;
    paramString1.YIY = bi.a(parambui);
    paramString2.otE = ((com.tencent.mm.bx.a)paramString1);
    paramString2.otF = ((com.tencent.mm.bx.a)new bny());
    paramString2 = paramString2.bEF();
    kotlin.g.b.s.s(paramString2, "builder.buildInstance()");
    this.oDw = paramString2;
    paramString2 = new StringBuilder().append(paramString1.username).append(',').append(paramString1.YIZ).append(',');
    if (paramString1.ZEQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("NetSceneFinderLiveUserPage", bool);
      AppMethodBeat.o(351152);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(351173);
    params = new StringBuilder("onCgiEnd: errType=").append(paramInt2).append(", errCode=").append(paramInt3).append(", errMsg=").append(paramString).append(",resp list:");
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    Log.i("NetSceneFinderLiveUserPage", com.tencent.mm.plugin.finder.live.view.convert.a.gK(ehp()));
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(351173);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(351165);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.oDw, (m)this);
    AppMethodBeat.o(351165);
    return i;
  }
  
  public final List<FinderObject> ehp()
  {
    AppMethodBeat.i(351183);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveUserPageResponse");
      AppMethodBeat.o(351183);
      throw ((Throwable)localObject);
    }
    localObject = ((bny)localObject).object;
    kotlin.g.b.s.s(localObject, "commReqResp.responseProt…serPageResponse).`object`");
    localObject = (List)localObject;
    AppMethodBeat.o(351183);
    return localObject;
  }
  
  public final b getLastBuffer()
  {
    AppMethodBeat.i(351192);
    Object localObject = c.c.b(this.oDw.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveUserPageResponse");
      AppMethodBeat.o(351192);
      throw ((Throwable)localObject);
    }
    localObject = ((bny)localObject).ZEQ;
    AppMethodBeat.o(351192);
    return localObject;
  }
  
  public final int getType()
  {
    return 5870;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/NetSceneFinderLiveUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.z
 * JD-Core Version:    0.7.0.1
 */