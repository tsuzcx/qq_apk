package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncExtraInfoResponse;", "liveId", "", "objectId", "nonceId", "", "anchorUsername", "finderUsername", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "syncReqList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/SyncReq;", "uxInfo", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncExtraInfoRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncExtraInfoRequest;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends o<bnk>
{
  private a CKG;
  public final bnj CKH;
  private final String TAG;
  
  public av(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, b paramb, LinkedList<fky> paramLinkedList, String paramString4, a parama)
  {
    AppMethodBeat.i(360185);
    this.TAG = "Finder.CgiFinderLiveSyncExtraInfo";
    this.CKG = parama;
    this.CKH = new bnj();
    parama = this.CKH;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CKH.mMJ = paramLong1;
    this.CKH.object_id = paramLong2;
    this.CKH.ZQW = paramString2;
    this.CKH.YIZ = paramString3;
    this.CKH.YJa = paramb;
    this.CKH.ZVS = paramLinkedList;
    this.CKH.object_nonce_id = paramString1;
    paramString1 = (CharSequence)paramString4;
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.CKH.ZRd = b.bsj(paramString4);
      }
      paramString1 = new c.a();
      paramString1.otE = ((a)this.CKH);
      paramString2 = new bnk();
      paramString2.setBaseResponse(new kd());
      paramString2.getBaseResponse().akjO = new etl();
      paramString1.otF = ((a)paramString2);
      paramString1.uri = "/cgi-bin/micromsg-bin/finderlivesyncextrainfo";
      paramString1.funcId = 5971;
      c(paramString1.bEF());
      Log.i(this.TAG, "init " + this.CKH.mMJ + ",ux_info:" + this.CKH.ZRd);
      AppMethodBeat.o(360185);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo$CallBack;", "", "onCgiBack", "", "cgi", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo;", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncExtraInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(av paramav, int paramInt1, int paramInt2, String paramString, bnk parambnk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.av
 * JD-Core Version:    0.7.0.1
 */