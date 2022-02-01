package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "usernameList", "Ljava/util/LinkedList;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "(JJLjava/lang/String;[BILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends o<bfp>
{
  private final a CJr;
  private bfo CJs;
  private final String TAG;
  
  public s(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, LinkedList<String> paramLinkedList, a parama)
  {
    AppMethodBeat.i(360252);
    this.CJr = parama;
    this.TAG = "Finder.CgiFinderLiveBatchGetMicContact";
    this.CJs = new bfo();
    this.CJs.mMJ = paramLong1;
    parama = this.CJs;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CJs.object_id = paramLong2;
    this.CJs.object_nonce_id = paramString;
    this.CJs.YJa = b.cX(paramArrayOfByte);
    this.CJs.YIZ = z.bAW();
    this.CJs.scene = 1;
    this.CJs.ZPx = paramLinkedList;
    paramString = new c.a();
    paramString.otE = ((a)this.CJs);
    paramArrayOfByte = new bfp();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivebatchgetmiccontact";
    paramString.funcId = 4224;
    c(paramString.bEF());
    AppMethodBeat.o(360252);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMicContact$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMicContactResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, bfp parambfp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.s
 * JD-Core Version:    0.7.0.1
 */