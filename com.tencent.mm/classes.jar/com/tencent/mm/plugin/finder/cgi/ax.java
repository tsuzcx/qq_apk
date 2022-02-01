package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ax
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xcw;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(271717);
    xcw = new a((byte)0);
    AppMethodBeat.o(271717);
  }
  
  public ax(String paramString, bbh parambbh, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(271716);
    d.a locala = new d.a();
    locala.TW("/cgi-bin/micromsg-bin/findercreatelivenotice");
    locala.vD(getType());
    aro localaro = new aro();
    localaro.finderUsername = paramString;
    localaro.liveNoticeInfo = parambbh;
    localaro.fSo = paramInt;
    Object localObject = ao.xcj;
    localaro.SDi = ao.a(parambid);
    localObject = localaro.SDi;
    if (localObject != null) {
      if (parambid == null) {
        break label223;
      }
    }
    label223:
    for (int i = parambid.fGo;; i = 0)
    {
      ((aqe)localObject).scene = i;
      parambid = new arp();
      locala.c((a)localaro);
      locala.d((a)parambid);
      parambid = locala.bgN();
      p.j(parambid, "builder.buildInstance()");
      this.rr = parambid;
      Log.i("Finder.NetSceneCreateLiveNotice", "NetSceneCreateLiveNotice init userName:" + paramString + ", startTime:" + parambbh.fod + " ,opType:" + paramInt + ' ');
      AppMethodBeat.o(271716);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(271714);
    Log.i("Finder.NetSceneCreateLiveNotice", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(271714);
      return;
    }
    AppMethodBeat.o(271714);
  }
  
  public final arp dnW()
  {
    AppMethodBeat.i(271715);
    Object localObject = this.rr;
    if (localObject == null) {
      p.bGy("rr");
    }
    localObject = ((d)localObject).bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateLiveNoticeResponse");
      AppMethodBeat.o(271715);
      throw ((Throwable)localObject);
    }
    localObject = (arp)localObject;
    AppMethodBeat.o(271715);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(271713);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.bGy("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(271713);
    return i;
  }
  
  public final int getType()
  {
    return 6653;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */