package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "liveId", "", "objectId", "status", "", "finderUserName", "", "liveStatus", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "(JJILjava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;)V", "TAG", "anchorStatus", "request", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class s
  extends an<bce>
{
  private final String TAG;
  private a tts;
  private bcd ttt;
  private int ttu;
  
  public s(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, a parama)
  {
    AppMethodBeat.i(242241);
    this.TAG = "Finder.CgiFinderLiveAnchorStatus";
    this.tts = parama;
    this.ttt = new bcd();
    this.ttu = paramInt1;
    this.ttt.liveId = paramLong1;
    this.ttt.hFK = paramLong2;
    this.ttt.finderUsername = paramString;
    paramString = this.ttt;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    this.ttt.liveStatus = paramInt2;
    paramString = new ciq();
    paramString.MnE = paramInt1;
    paramString.MnD = cl.aWz();
    this.ttt.LGq = b.cD(paramString.toByteArray());
    paramString = new d.a();
    paramString.c((a)this.ttt);
    parama = new bce();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/findersetanchorstatus");
    paramString.sG(6443);
    c(paramString.aXF());
    Log.i(this.TAG, "init " + this.ttt.liveId + ',' + this.ttt.finderUsername + ',' + this.ttu);
    AppMethodBeat.o(242241);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2, String paramString, int paramInt3);
    
    public abstract void onSuccess(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */