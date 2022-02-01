package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "eventName", "eventDesc", "coverUrl", "endTime", "", "scene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEventDesc", "()Ljava/lang/String;", "getEventName", "eventTopicId", "preCreateEventRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPreCreateEventRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getEventTopicId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dh
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADc;
  private final String ADd;
  private bsy ADe;
  private com.tencent.mm.am.h callback;
  private final String coverUrl;
  private final String eventName;
  public long ocD;
  private c rr;
  private final String userName;
  
  static
  {
    AppMethodBeat.i(336582);
    ADc = new a((byte)0);
    AppMethodBeat.o(336582);
  }
  
  private dh(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    AppMethodBeat.i(336569);
    this.userName = paramString1;
    this.eventName = paramString2;
    this.ADd = paramString3;
    this.coverUrl = paramString4;
    paramString1 = new c.a();
    paramString1.uri = "/cgi-bin/micromsg-bin/finderprecreateevent";
    paramString1.funcId = getType();
    paramString2 = new bsy();
    paramString2.username = this.userName;
    paramString2.aaaG = this.eventName;
    paramString2.aaaH = this.ADd;
    paramString2.aaaI = this.coverUrl;
    paramString3 = bi.ABn;
    paramString2.ZHY = bi.dVu();
    paramString2.GOo = paramLong;
    paramString2.scene = paramInt;
    paramString3 = ah.aiuX;
    this.ADe = paramString2;
    paramString1.otE = ((a)this.ADe);
    paramString1.otF = ((a)new bsz());
    Log.i("Finder.LogPost.NetSceneFinderPreCreate", "post userName:" + this.userName + " eventName:" + this.eventName + " eventDesc:" + this.ADd + " scene:" + paramInt);
    paramString1 = paramString1.bEF();
    kotlin.g.b.s.s(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    AppMethodBeat.o(336569);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336599);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPreCreateEventResponse");
        AppMethodBeat.o(336599);
        throw paramString;
      }
      this.ocD = ((bsz)params).ZXX;
    }
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336599);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336585);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336585);
    return i;
  }
  
  public final int getType()
  {
    return 4050;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dh
 * JD-Core Version:    0.7.0.1
 */