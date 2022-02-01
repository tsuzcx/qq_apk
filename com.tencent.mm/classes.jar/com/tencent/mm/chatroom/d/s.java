package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class s
  extends n
  implements k
{
  private f callback;
  private String errMsg;
  private cxe fNh;
  private final b rr;
  
  public s(String paramString, LinkedList<cxi> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    ae.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { bu.bI(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((b.a)localObject).funcId = 3546;
    ((b.a)localObject).hQF = new cxd();
    ((b.a)localObject).hQG = new cxe();
    this.rr = ((b.a)localObject).aDS();
    localObject = (cxd)this.rr.hQD.hQJ;
    ((cxd)localObject).FNj = bu.bI(paramString, "");
    ((cxd)localObject).GPK = new cxa();
    ((cxd)localObject).GPK.HHI = paramLinkedList.size();
    ((cxd)localObject).GPK.HHJ = paramLinkedList;
    AppMethodBeat.o(182088);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182089);
    this.callback = paramf;
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
    ae.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fNh = ((cxe)((b)paramq).hQE.hQJ);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */