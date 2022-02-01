package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactResponse;", "liveId", "", "objectId", "finderUserName", "", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;", "(JJLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetContactRequest;", "resp", "getResp", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class h
  extends c<azm>
{
  private final String TAG;
  private azl xXY;
  private azm xXZ;
  private a xYa;
  
  public h(long paramLong1, long paramLong2, String paramString, a parama)
  {
    AppMethodBeat.i(268266);
    this.TAG = "Finder.CgiFinderLiveGetContact";
    this.xXY = new azl();
    this.xYa = parama;
    this.xXY.liveId = paramLong1;
    this.xXY.xbk = paramLong2;
    this.xXY.username = paramString;
    paramString = this.xXY;
    parama = ao.xcj;
    paramString.SDi = ao.dnO();
    this.xXY.scene = 0;
    paramString = new d.a();
    paramString.c((a)this.xXY);
    parama = new azm();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivegetcontact");
    paramString.vD(6678);
    c(paramString.bgN());
    Log.i(this.TAG, "init " + this.xXY.liveId + ',' + this.xXY.username + ',' + this.xXY.scene);
    AppMethodBeat.o(268266);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetContact$CallBack;", "", "onFinish", "", "success", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, aza paramaza);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.h
 * JD-Core Version:    0.7.0.1
 */