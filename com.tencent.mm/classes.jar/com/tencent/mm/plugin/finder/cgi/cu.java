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
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "videoId", "", "username", "", "videoNonceId", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getVideoId", "()J", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFinderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cu
  extends cr
  implements m
{
  public static final a twK;
  private i callback;
  private d rr;
  public final long twJ;
  
  static
  {
    AppMethodBeat.i(242561);
    twK = new a((byte)0);
    AppMethodBeat.o(242561);
  }
  
  public cu(long paramLong, String paramString1, String paramString2, int paramInt, bbn parambbn)
  {
    AppMethodBeat.i(242560);
    this.twJ = paramLong;
    cnm localcnm = new cnm();
    ap localap = ap.tuF;
    localcnm.MtV = ap.b(parambbn);
    localcnm.twJ = this.twJ;
    localcnm.username = paramString1;
    localcnm.LOd = paramString2;
    localcnm.scene = paramInt;
    paramString2 = new d.a();
    paramString2.MB("/cgi-bin/micromsg-bin/megavideodetail");
    paramString2.sG(getType());
    paramString2.c((a)localcnm);
    paramString2.d((a)new cnn());
    paramString2 = paramString2.aXF();
    p.g(paramString2, "builder.buildInstance()");
    this.rr = paramString2;
    Log.i("NetSceneMegaVideoGetDetail", "NetSceneMegaVideoGetDetail videoId " + this.twJ + " username " + paramString1);
    AppMethodBeat.o(242560);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242558);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242558);
      return;
    }
    AppMethodBeat.o(242558);
  }
  
  public final ayj cZr()
  {
    AppMethodBeat.i(242559);
    Object localObject = new ayj();
    a locala = this.rr.aYK();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoDetailResponse");
      AppMethodBeat.o(242559);
      throw ((Throwable)localObject);
    }
    ((ayj)localObject).LIA = ((cnn)locala).LIA;
    locala = this.rr.aYK();
    if (locala == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MegaVideoDetailResponse");
      AppMethodBeat.o(242559);
      throw ((Throwable)localObject);
    }
    ((ayj)localObject).contact = ((cnn)locala).contact;
    AppMethodBeat.o(242559);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242557);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242557);
    return i;
  }
  
  public final int getType()
  {
    return 4195;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetDetail$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cu
 * JD-Core Version:    0.7.0.1
 */