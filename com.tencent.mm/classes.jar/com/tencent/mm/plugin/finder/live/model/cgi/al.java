package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "liveId", "", "finderUsername", "", "objectId", "pauseSecond", "", "pauseMode", "scene", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "(JLjava/lang/String;JIIILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends o<bse>
{
  private final a CKh;
  private bsd CKi;
  private final String TAG;
  
  public al(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(360270);
    this.CKh = parama;
    this.TAG = "Finder.CgiFinderLivePause";
    this.CKi = new bsd();
    this.CKi.mMJ = paramLong1;
    this.CKi.YIZ = paramString;
    this.CKi.object_id = paramLong2;
    this.CKi.aaab = 0;
    this.CKi.aaac = paramInt1;
    this.CKi.scene = paramInt2;
    paramString = new c.a();
    paramString.otE = ((a)this.CKi);
    parama = new bse();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)parama);
    paramString.uri = "/cgi-bin/micromsg-bin/finderpauselive";
    paramString.funcId = 4197;
    c(paramString.bEF());
    Log.i(this.TAG, "CgiFinderLivePause init " + this.CKi.mMJ + ',' + this.CKi.YIZ + ",pause_second:" + this.CKi.aaab + ",pause_mode:" + this.CKi.aaac);
    AppMethodBeat.o(360270);
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePause$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPauseLiveResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bse parambse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.al
 * JD-Core Version:    0.7.0.1
 */