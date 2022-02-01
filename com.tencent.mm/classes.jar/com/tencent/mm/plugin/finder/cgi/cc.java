package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "eventName", "eventDesc", "coverUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEventDesc", "()Ljava/lang/String;", "getEventName", "eventTopicId", "", "preCreateEventRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPreCreateEventRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getEventTopicId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cc
  extends ax
  implements m
{
  public static final a twg;
  private i callback;
  private final String coverUrl;
  private final String eventName;
  private d rr;
  public long twd;
  private bas twe;
  private final String twf;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(242498);
    twg = new a((byte)0);
    AppMethodBeat.o(242498);
  }
  
  public cc(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(242497);
    this.userName = paramString1;
    this.eventName = paramString2;
    this.twf = paramString3;
    this.coverUrl = paramString4;
    paramString1 = new d.a();
    paramString1.MB("/cgi-bin/micromsg-bin/finderprecreateevent");
    paramString1.sG(getType());
    paramString2 = new bas();
    paramString2.username = this.userName;
    paramString2.LKn = this.eventName;
    paramString2.LKo = this.twf;
    paramString2.LKp = this.coverUrl;
    paramString3 = am.tuw;
    paramString2.LCA = am.cXY();
    this.twe = paramString2;
    paramString1.c((a)this.twe);
    paramString1.d((a)new bat());
    Log.i("Finder.LogPost.NetSceneFinderPost", "post userName:" + this.userName + " eventName:" + this.eventName + " eventDesc:" + this.twf);
    paramString1 = paramString1.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    AppMethodBeat.o(242497);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242496);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPreCreateEventResponse");
        AppMethodBeat.o(242496);
        throw paramString;
      }
      this.twd = ((bat)params).LIT;
    }
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242496);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242495);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242495);
    return i;
  }
  
  public final int getType()
  {
    return 4050;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cc
 * JD-Core Version:    0.7.0.1
 */