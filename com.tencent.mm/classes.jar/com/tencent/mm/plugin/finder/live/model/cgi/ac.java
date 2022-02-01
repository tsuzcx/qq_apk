package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "liveId", "", "objectId", "audienceUsername", "", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ac
  extends n<bbc>
{
  private final String TAG;
  private a yjM;
  private bbb yjN;
  
  public ac(long paramLong1, long paramLong2, String paramString, aqt paramaqt, a parama)
  {
    AppMethodBeat.i(271271);
    this.TAG = "Finder.CgiFinderLiveModifyShopShelf";
    this.yjM = parama;
    this.yjN = new bbb();
    this.yjN.klE = paramLong1;
    this.yjN.object_id = paramLong2;
    this.yjN.RLN = paramString;
    paramString = this.yjN;
    parama = ao.xcj;
    paramString.RLM = ao.dnO();
    this.yjN.SML = paramaqt;
    paramString = new d.a();
    paramString.c((a)this.yjN);
    paramaqt = new bbc();
    paramaqt.setBaseResponse(new jh());
    paramaqt.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramaqt);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivemodshopshelf");
    paramString.vD(6675);
    c(paramString.bgN());
    paramaqt = this.TAG;
    parama = new StringBuilder("init ").append(this.yjN.klE).append(',');
    paramString = this.yjN.SML;
    if (paramString != null) {}
    for (paramString = Integer.valueOf(paramString.cmdId);; paramString = null)
    {
      Log.i(paramaqt, paramString + ',' + this.yjN.RLN);
      AppMethodBeat.o(271271);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bbc parambbc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ac
 * JD-Core Version:    0.7.0.1
 */