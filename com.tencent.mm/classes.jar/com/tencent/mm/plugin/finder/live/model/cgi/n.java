package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "username", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class n
  extends k<asm>
{
  private final String TAG;
  private a ukX;
  private asl ukY;
  
  public n(String paramString, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246324);
    this.TAG = "Finder.CgiFinderLiveGetLastObject";
    this.ukX = parama;
    this.ukY = new asl();
    this.ukY.LAN = paramString;
    paramString = this.ukY;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    paramString = new d.a();
    paramString.c((a)this.ukY);
    parama = new asm();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/findergetlatestliveobject");
    paramString.sG(6482);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderLiveGetLastObject init username:" + this.ukY.LAN);
    AppMethodBeat.o(246324);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(asm paramasm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.n
 * JD-Core Version:    0.7.0.1
 */