package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactResponse;", "liveId", "", "objectId", "finderUserName", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "(JJLjava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactRequest;", "resp", "getResp", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class u
  extends an<avu>
{
  private final String TAG;
  private avt ttx;
  private avu tty;
  private a ttz;
  
  public u(long paramLong1, long paramLong2, String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(242245);
    this.TAG = "Finder.CgiFinderLiveGetContact";
    this.ttx = new avt();
    this.ttz = parama;
    this.ttx.liveId = paramLong1;
    this.ttx.hFK = paramLong2;
    this.ttx.username = paramString;
    paramString = this.ttx;
    parama = am.tuw;
    paramString.LAI = am.cXY();
    this.ttx.scene = 0;
    paramString = new d.a();
    paramString.c((a)this.ttx);
    parama = new avu();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/finderlivegetcontact");
    paramString.sG(6678);
    c(paramString.aXF());
    Log.i(this.TAG, "init " + this.ttx.liveId + ',' + this.ttx.username + ',' + this.ttx.scene);
    AppMethodBeat.o(242245);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveGetContact$CallBack;", "", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, avn paramavn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */