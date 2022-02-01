package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "liveId", "", "objectId", "username", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class q
  extends k<awc>
{
  private final String TAG;
  private a uld;
  private awb ule;
  
  public q(long paramLong1, long paramLong2, String paramString1, b paramb, int paramInt, String paramString2, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246330);
    this.TAG = "Finder.CgiFinderLiveGetShoppingList";
    this.uld = parama;
    this.ule = new awb();
    this.ule.liveId = paramLong1;
    this.ule.hFK = paramLong2;
    this.ule.finderUsername = paramString1;
    this.ule.scene = paramInt;
    this.ule.tVM = paramb;
    this.ule.LGw = paramString2;
    paramString1 = this.ule;
    paramb = am.tuw;
    paramString1.LAI = am.cXY();
    paramString1 = new d.a();
    paramString1.c((a)this.ule);
    paramb = new awc();
    paramb.setBaseResponse(new BaseResponse());
    paramb.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramb);
    paramString1.MB("/cgi-bin/micromsg-bin/finderlivegetshopwindowproduct");
    paramString1.sG(4254);
    c(paramString1.aXF());
    Log.i(this.TAG, "CgiFinderLiveGetShoppingList init " + this.ule.liveId + ',' + this.ule.finderUsername);
    AppMethodBeat.o(246330);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, awc paramawc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.q
 * JD-Core Version:    0.7.0.1
 */