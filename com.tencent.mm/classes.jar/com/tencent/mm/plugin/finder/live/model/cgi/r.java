package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "scene", "", "songIdList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "(J[BLjava/lang/String;JILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class r
  extends n<ayq>
{
  private final String TAG;
  private a yjm;
  private ayp yjn;
  
  public r(long paramLong1, byte[] paramArrayOfByte, String paramString, long paramLong2, int paramInt, LinkedList<Integer> paramLinkedList, a parama)
  {
    AppMethodBeat.i(278263);
    this.TAG = "Finder.CgiFinderLiveBatchGetMusicInfo";
    this.yjm = parama;
    this.yjn = new ayp();
    parama = this.yjn;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yjn.klE = paramLong1;
    this.yjn.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjn.RLN = paramString;
    this.yjn.object_id = paramLong2;
    this.yjn.scene = paramInt;
    this.yjn.SKz = paramLinkedList;
    paramArrayOfByte = new d.a();
    paramArrayOfByte.c((a)this.yjn);
    paramString = new ayq();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramArrayOfByte.d((a)paramString);
    paramArrayOfByte.TW("/cgi-bin/micromsg-bin/finderlivebatchgetmusicinfo");
    paramArrayOfByte.vD(6887);
    c(paramArrayOfByte.bgN());
    paramArrayOfByte = this.TAG;
    paramString = new StringBuilder("CgiFinderLiveBatchGetMusicInfo init ").append(this.yjn.klE).append(',').append(this.yjn.RLN).append(',').append(this.yjn.scene).append(",liveCookies is null:");
    if (this.yjn.RLO == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool);
      AppMethodBeat.o(278263);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, ayq paramayq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.r
 * JD-Core Version:    0.7.0.1
 */