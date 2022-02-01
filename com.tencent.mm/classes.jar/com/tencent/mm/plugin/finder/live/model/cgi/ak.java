package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "liveId", "", "objectId", "audienceUsername", "", "finderCmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends o<bkd>
{
  private a CKf;
  private bkc CKg;
  private final String TAG;
  
  public ak(long paramLong1, long paramLong2, String paramString, auw paramauw, a parama)
  {
    AppMethodBeat.i(360264);
    this.TAG = "Finder.CgiFinderLiveModifyShopShelf";
    this.CKf = parama;
    this.CKg = new bkc();
    this.CKg.mMJ = paramLong1;
    this.CKg.object_id = paramLong2;
    this.CKg.YIZ = z.bAW();
    paramString = this.CKg;
    parama = bi.ABn;
    paramString.YIY = bi.dVu();
    this.CKg.ZTn = paramauw;
    paramString = new c.a();
    paramString.otE = ((a)this.CKg);
    paramauw = new bkd();
    paramauw.setBaseResponse(new kd());
    paramauw.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramauw);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivemodshopshelf";
    paramString.funcId = 6675;
    c(paramString.bEF());
    paramauw = this.TAG;
    parama = new StringBuilder("init ").append(this.CKg.mMJ).append(',');
    paramString = this.CKg.ZTn;
    if (paramString == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramString.cmdId))
    {
      Log.i(paramauw, paramString + ',' + this.CKg.YIZ);
      AppMethodBeat.o(360264);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bkd parambkd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ak
 * JD-Core Version:    0.7.0.1
 */