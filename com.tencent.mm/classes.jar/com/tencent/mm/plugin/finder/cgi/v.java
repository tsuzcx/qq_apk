package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "tabType", "", "lng", "", "lat", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream$CallBack;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class v
  extends an<axi>
{
  private final String TAG;
  private a ttA;
  private axh ttB;
  
  public v(b paramb, int paramInt, float paramFloat1, float paramFloat2, a parama)
  {
    AppMethodBeat.i(242247);
    this.TAG = "Finder.CgiFinderLiveStream";
    this.ttA = parama;
    this.ttB = new axh();
    this.ttB.lastBuffer = paramb;
    this.ttB.LHP = paramInt;
    this.ttB.dTj = paramFloat1;
    this.ttB.latitude = paramFloat2;
    paramb = new d.a();
    paramb.c((a)this.ttB);
    parama = new axi();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramb.d((a)parama);
    paramb.MB("/cgi-bin/micromsg-bin/finderlivestream");
    paramb.sG(4151);
    c(paramb.aXF());
    Log.i(this.TAG, "CgiFinderLiveStream init " + this.ttB.LHP + ',' + this.ttB.lastBuffer);
    AppMethodBeat.o(242247);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveStream$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, axi paramaxi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.v
 * JD-Core Version:    0.7.0.1
 */