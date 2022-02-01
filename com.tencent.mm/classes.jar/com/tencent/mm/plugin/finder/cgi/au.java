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
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class au
  extends ax
  implements m
{
  public static final a tuN;
  private i callback;
  private d rr;
  
  static
  {
    AppMethodBeat.i(242349);
    tuN = new a((byte)0);
    AppMethodBeat.o(242349);
  }
  
  public au(String paramString, awt paramawt, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242348);
    d.a locala = new d.a();
    locala.MB("/cgi-bin/micromsg-bin/findercreatelivenotice");
    locala.sG(getType());
    apy localapy = new apy();
    localapy.finderUsername = paramString;
    localapy.liveNoticeInfo = paramawt;
    localapy.dYx = paramInt;
    Object localObject = am.tuw;
    localapy.LAI = am.a(parambbn);
    localObject = localapy.LAI;
    if (localObject != null) {
      if (parambbn == null) {
        break label223;
      }
    }
    label223:
    for (int i = parambbn.tyh;; i = 0)
    {
      ((aov)localObject).scene = i;
      parambbn = new apz();
      locala.c((a)localapy);
      locala.d((a)parambbn);
      parambbn = locala.aXF();
      p.g(parambbn, "builder.buildInstance()");
      this.rr = parambbn;
      Log.i("Finder.NetSceneCreateLiveNotice", "NetSceneCreateLiveNotice init userName:" + paramString + ", startTime:" + paramawt.dvv + " ,opType:" + paramInt + ' ');
      AppMethodBeat.o(242348);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242346);
    Log.i("Finder.NetSceneCreateLiveNotice", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242346);
      return;
    }
    AppMethodBeat.o(242346);
  }
  
  public final apz cYf()
  {
    AppMethodBeat.i(242347);
    Object localObject = this.rr;
    if (localObject == null) {
      p.btv("rr");
    }
    localObject = ((d)localObject).aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderCreateLiveNoticeResponse");
      AppMethodBeat.o(242347);
      throw ((Throwable)localObject);
    }
    localObject = (apz)localObject;
    AppMethodBeat.o(242347);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242345);
    this.callback = parami;
    parami = this.rr;
    if (parami == null) {
      p.btv("rr");
    }
    int i = dispatch(paramg, (s)parami, (m)this);
    AppMethodBeat.o(242345);
    return i;
  }
  
  public final int getType()
  {
    return 6653;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneCreateLiveNotice$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */