package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class s
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private clw fpd;
  private final b rr;
  
  public s(String paramString, LinkedList<cma> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    ad.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { bt.by(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((b.a)localObject).funcId = 3546;
    ((b.a)localObject).gUU = new clv();
    ((b.a)localObject).gUV = new clw();
    this.rr = ((b.a)localObject).atI();
    localObject = (clv)this.rr.gUS.gUX;
    ((clv)localObject).Cxb = bt.by(paramString, "");
    ((clv)localObject).Dsf = new cls();
    ((clv)localObject).Dsf.EgU = paramLinkedList.size();
    ((clv)localObject).Dsf.EgV = paramLinkedList;
    AppMethodBeat.o(182088);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182089);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182089);
    return i;
  }
  
  public final int getType()
  {
    return 3546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182090);
    ad.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fpd = ((clw)((b)paramq).gUT.gUX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */