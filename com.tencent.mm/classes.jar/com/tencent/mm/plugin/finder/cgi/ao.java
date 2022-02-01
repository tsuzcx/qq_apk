package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.t;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserList", "()Ljava/util/LinkedList;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRespContactTypeInfo", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ao
  extends n
  implements com.tencent.mm.network.k
{
  public static final a KJz;
  private static final String TAG = "Finder.NetSceneBatchSetBlackList";
  private final LinkedList<bqk> Dly;
  private g callback;
  public b rr;
  
  static
  {
    AppMethodBeat.i(197282);
    KJz = new a((byte)0);
    TAG = "Finder.NetSceneBatchSetBlackList";
    AppMethodBeat.o(197282);
  }
  
  public ao(LinkedList<bqk> paramLinkedList)
  {
    AppMethodBeat.i(197281);
    this.Dly = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.nB(getType());
    Object localObject = new jq();
    ((jq)localObject).CEL = this.Dly;
    ((jq)localObject).CEK = this.Dly.size();
    ((jq)localObject).scene = 1;
    paramLinkedList.c((a)localObject);
    localObject = new jr();
    ((jr)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.wg("/cgi-bin/micromsg-bin/batchmodcontacttype");
    paramLinkedList = paramLinkedList.atI();
    d.g.b.k.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(197281);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(197279);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(197279);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197280);
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED))) {
      t.makeText(aj.getContext(), (CharSequence)("is debug info finder batch black list: " + paramInt2 + ' ' + paramInt3), 1).show();
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fvU();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(197280);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */