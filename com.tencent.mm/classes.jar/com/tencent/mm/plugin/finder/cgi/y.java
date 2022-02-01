package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserList", "()Ljava/util/LinkedList;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRespContactTypeInfo", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class y
  extends n
  implements k
{
  private static final String TAG = "Finder.NetSceneBatchSetBlackList";
  public static final a rIX;
  private f callback;
  public final LinkedList<bzq> rIW;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201099);
    rIX = new a((byte)0);
    TAG = "Finder.NetSceneBatchSetBlackList";
    AppMethodBeat.o(201099);
  }
  
  public y(LinkedList<bzq> paramLinkedList)
  {
    AppMethodBeat.i(201098);
    this.rIW = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.oP(getType());
    Object localObject = new kf();
    ((kf)localObject).FCH = this.rIW;
    ((kf)localObject).FCG = this.rIW.size();
    ((kf)localObject).scene = 1;
    paramLinkedList.c((a)localObject);
    localObject = new kg();
    ((kg)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.Dl("/cgi-bin/micromsg-bin/batchmodcontacttype");
    paramLinkedList = paramLinkedList.aDC();
    p.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(201098);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(201096);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(201096);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201097);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((i.IS_FLAVOR_PURPLE) || (i.IS_FLAVOR_RED))) {
      t.makeText(aj.getContext(), (CharSequence)("is debug info finder batch black list: " + paramInt2 + ' ' + paramInt3), 1).show();
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.gfZ();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201097);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */