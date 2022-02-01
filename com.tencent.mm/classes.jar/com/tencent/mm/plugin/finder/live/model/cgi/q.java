package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "usernameList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "(JJLjava/lang/String;[BILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class q
  extends n<ayo>
{
  private final String TAG;
  private ayn yjk;
  private final a yjl;
  
  public q(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(265352);
    this.yjl = parama;
    this.TAG = "Finder.CgiFinderLiveBatchGetMicContact";
    this.yjk = new ayn();
    this.yjk.klE = paramLong1;
    parama = this.yjk;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yjk.object_id = paramLong2;
    this.yjk.object_nonce_id = paramString;
    this.yjk.RLO = b.cU(paramArrayOfByte);
    this.yjk.RLN = z.bdh();
    this.yjk.scene = 1;
    this.yjk.SKE = paramLinkedList;
    paramString = new d.a();
    paramString.c((a)this.yjk);
    paramArrayOfByte = new ayo();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivebatchgetmiccontact");
    paramString.vD(4224);
    c(paramString.bgN());
    AppMethodBeat.o(265352);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, ayo paramayo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.q
 * JD-Core Version:    0.7.0.1
 */