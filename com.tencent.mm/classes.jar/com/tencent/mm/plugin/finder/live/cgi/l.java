package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "tabType", "", "lng", "", "lat", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream$CallBack;", "(Lcom/tencent/mm/protobuf/ByteString;IFFLcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream$CallBack;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class l
  extends c<bcu>
{
  private final String TAG;
  private a xYf;
  private bct xYg;
  
  public l(b paramb, int paramInt, float paramFloat1, float paramFloat2, a parama)
  {
    AppMethodBeat.i(285684);
    this.TAG = "Finder.CgiFinderLiveStream";
    this.xYf = parama;
    this.xYg = new bct();
    this.xYg.lastBuffer = paramb;
    this.xYg.SNY = paramInt;
    this.xYg.longitude = paramFloat1;
    this.xYg.latitude = paramFloat2;
    paramb = new d.a();
    paramb.c((a)this.xYg);
    parama = new bcu();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramb.d((a)parama);
    paramb.TW("/cgi-bin/micromsg-bin/finderlivestream");
    paramb.vD(4151);
    c(paramb.bgN());
    Log.i(this.TAG, "CgiFinderLiveStream init " + this.xYg.SNY + ',' + this.xYg.lastBuffer);
    AppMethodBeat.o(285684);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveStream$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bcu parambcu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.l
 * JD-Core Version:    0.7.0.1
 */