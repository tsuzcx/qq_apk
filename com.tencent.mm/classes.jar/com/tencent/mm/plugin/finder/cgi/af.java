package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMarkRead;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "sendMarkReadList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "(Ljava/util/LinkedList;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSendMarkReadList", "()Ljava/util/LinkedList;", "setSendMarkReadList", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class af
  extends n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private g callback;
  public LinkedList<bow> qpM;
  private b rr;
  
  public af(LinkedList<bow> paramLinkedList)
  {
    AppMethodBeat.i(178091);
    this.qpM = paramLinkedList;
    this.TAG = "Finder.NetSceneMarkRead";
    paramLinkedList = new b.a();
    paramLinkedList.nB(getType());
    Object localObject = new ajr();
    ((ajr)localObject).DlG = this.qpM;
    am localam = am.KJy;
    ((ajr)localObject).DlF = am.fRS();
    paramLinkedList.c((a)localObject);
    localObject = new ajs();
    ((ajs)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.wg("/cgi-bin/micromsg-bin/findermarkread");
    paramLinkedList = paramLinkedList.atI();
    d.g.b.k.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(178091);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(178090);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(178090);
    return i;
  }
  
  public final int getType()
  {
    return 3520;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(178089);
    ad.i(this.TAG, "onGYNetEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramString);
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(178089);
      return;
    }
    AppMethodBeat.o(178089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.af
 * JD-Core Version:    0.7.0.1
 */