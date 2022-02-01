package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserList", "()Ljava/util/LinkedList;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRespContactTypeInfo", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class z
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneBatchSetBlackList";
  public static final a rRl;
  private f callback;
  public final LinkedList<cak> rRk;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201521);
    rRl = new a((byte)0);
    TAG = "Finder.NetSceneBatchSetBlackList";
    AppMethodBeat.o(201521);
  }
  
  public z(LinkedList<cak> paramLinkedList)
  {
    AppMethodBeat.i(201520);
    this.rRk = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.oS(getType());
    Object localObject = new kf();
    ((kf)localObject).FVc = this.rRk;
    ((kf)localObject).FVb = this.rRk.size();
    ((kf)localObject).scene = 1;
    paramLinkedList.c((a)localObject);
    localObject = new kg();
    ((kg)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.DN("/cgi-bin/micromsg-bin/batchmodcontacttype");
    paramLinkedList = paramLinkedList.aDS();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(201520);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201518);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201518);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201519);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED))) {
      t.makeText(ak.getContext(), (CharSequence)("is debug info finder batch black list: " + paramInt2 + ' ' + paramInt3), 1).show();
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gkB();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201519);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */