package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.a.cl;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/findersdk/api/INetSceneCreateLiveNotice;", "userName", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bs
  extends com.tencent.mm.plugin.findersdk.b.h
  implements cl
{
  public static final a ABI;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336420);
    ABI = new a((byte)0);
    AppMethodBeat.o(336420);
  }
  
  public bs(String paramString, bkk parambkk, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336415);
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/micromsg-bin/findercreatelivenotice";
    locala.funcId = getType();
    avx localavx = new avx();
    localavx.finderUsername = paramString;
    localavx.liveNoticeInfo = parambkk;
    localavx.hYl = paramInt;
    Object localObject = bi.ABn;
    localavx.ZEc = bi.a(parambui);
    localObject = localavx.ZEc;
    if (localObject != null) {
      if (parambui != null) {
        break label219;
      }
    }
    label219:
    for (int i = 0;; i = parambui.hLK)
    {
      ((atz)localObject).scene = i;
      parambui = new avy();
      locala.otE = ((a)localavx);
      locala.otF = ((a)parambui);
      parambui = locala.bEF();
      kotlin.g.b.s.s(parambui, "builder.buildInstance()");
      this.rr = parambui;
      Log.i("Finder.NetSceneCreateLiveNotice", "NetSceneCreateLiveNotice init userName:" + paramString + ", startTime:" + parambkk.startTime + " ,opType:" + paramInt + ' ');
      AppMethodBeat.o(336415);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336439);
    Log.i("Finder.NetSceneCreateLiveNotice", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336439);
  }
  
  public final avy dVD()
  {
    AppMethodBeat.i(336445);
    c localc = this.rr;
    Object localObject = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      localObject = null;
    }
    localObject = c.c.b(((c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateLiveNoticeResponse");
      AppMethodBeat.o(336445);
      throw ((Throwable)localObject);
    }
    localObject = (avy)localObject;
    AppMethodBeat.o(336445);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336425);
    this.callback = paramh;
    c localc = this.rr;
    paramh = localc;
    if (localc == null)
    {
      kotlin.g.b.s.bIx("rr");
      paramh = null;
    }
    int i = dispatch(paramg, (com.tencent.mm.network.s)paramh, (m)this);
    AppMethodBeat.o(336425);
    return i;
  }
  
  public final int getType()
  {
    return 6653;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bs
 * JD-Core Version:    0.7.0.1
 */