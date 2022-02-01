package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "scene", "", "songIdList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "(J[BLjava/lang/String;JILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends o<bfr>
{
  private a CJt;
  private bfq CJu;
  private final String TAG;
  
  public t(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, a parama)
  {
    AppMethodBeat.i(360257);
    this.TAG = "Finder.CgiFinderLiveBatchGetMusicInfo";
    this.CJt = parama;
    this.CJu = new bfq();
    parama = this.CJu;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CJu.mMJ = paramLong1;
    this.CJu.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJu.YIZ = paramString;
    this.CJu.object_id = paramLong2;
    this.CJu.scene = paramInt;
    this.CJu.ZPo = paramLinkedList;
    paramArrayOfByte = new c.a();
    paramArrayOfByte.otE = ((a)this.CJu);
    paramString = new bfr();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramArrayOfByte.otF = ((a)paramString);
    paramArrayOfByte.uri = "/cgi-bin/micromsg-bin/finderlivebatchgetmusicinfo";
    paramArrayOfByte.funcId = 6887;
    c(paramArrayOfByte.bEF());
    paramArrayOfByte = this.TAG;
    paramString = new StringBuilder("CgiFinderLiveBatchGetMusicInfo init ").append(this.CJu.mMJ).append(',').append(this.CJu.YIZ).append(',').append(this.CJu.scene).append(",liveCookies is null:");
    if (this.CJu.YJa == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool);
      AppMethodBeat.o(360257);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bfr parambfr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.t
 * JD-Core Version:    0.7.0.1
 */