package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserList", "()Ljava/util/LinkedList;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRespContactTypeInfo", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeResInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class t
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "Finder.NetSceneBatchSetBlackList";
  public static final a qXN;
  private g callback;
  private final LinkedList<bvb> qXM;
  public b rr;
  
  static
  {
    AppMethodBeat.i(201159);
    qXN = new a((byte)0);
    TAG = "Finder.NetSceneBatchSetBlackList";
    AppMethodBeat.o(201159);
  }
  
  public t(LinkedList<bvb> paramLinkedList)
  {
    AppMethodBeat.i(201158);
    this.qXM = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.op(getType());
    Object localObject = new jw();
    ((jw)localObject).DXl = this.qXM;
    ((jw)localObject).DXk = this.qXM.size();
    ((jw)localObject).scene = 1;
    paramLinkedList.c((a)localObject);
    localObject = new jx();
    ((jx)localObject).setBaseResponse(new BaseResponse());
    paramLinkedList.d((a)localObject);
    paramLinkedList.Am("/cgi-bin/micromsg-bin/batchmodcontacttype");
    paramLinkedList = paramLinkedList.aAz();
    d.g.b.k.g(paramLinkedList, "builder.buildInstance()");
    this.rr = paramLinkedList;
    AppMethodBeat.o(201158);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(201156);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(201156);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(201157);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED))) {
      com.tencent.mm.ui.base.t.makeText(ai.getContext(), (CharSequence)("is debug info finder batch black list: " + paramInt2 + ' ' + paramInt3), 1).show();
    }
    if (this.callback != null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.fOy();
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    }
    AppMethodBeat.o(201157);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneBatchSetBlackList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */