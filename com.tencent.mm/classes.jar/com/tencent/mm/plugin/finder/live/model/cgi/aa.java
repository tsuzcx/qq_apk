package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "liveId", "", "objectId", "anchorUsername", "", "liveCookies", "", "scene", "", "username", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class aa
  extends n<azy>
{
  private final String TAG;
  private a yjI;
  private azx yjJ;
  
  public aa(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(291646);
    this.TAG = "Finder.CgiFinderLiveGetShoppingShelf";
    this.yjI = parama;
    this.yjJ = new azx();
    this.yjJ.klE = paramLong1;
    this.yjJ.object_id = paramLong2;
    this.yjJ.SLv = paramString1;
    this.yjJ.scene = paramInt;
    this.yjJ.RLN = paramString2;
    this.yjJ.RLO = b.cU(paramArrayOfByte);
    paramString1 = this.yjJ;
    paramArrayOfByte = ao.xcj;
    paramString1.RLM = ao.dnO();
    this.yjJ.SLt = paramString3;
    paramString1 = new d.a();
    paramString1.c((a)this.yjJ);
    paramArrayOfByte = new azy();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderlivegetshopshelf");
    paramString1.vD(4049);
    c(paramString1.bgN());
    Log.i(this.TAG, "init " + this.yjJ.klE + ", " + this.yjJ.scene + ", " + this.yjJ.SLv + ",requestId:" + this.yjJ.SLt);
    AppMethodBeat.o(291646);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetShoppingShelf$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, azy paramazy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aa
 * JD-Core Version:    0.7.0.1
 */