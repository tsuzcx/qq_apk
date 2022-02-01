package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class s
  extends n
  implements k
{
  private g callback;
  private String errMsg;
  private crd fsD;
  private final b rr;
  
  public s(String paramString, LinkedList<crh> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    ac.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { bs.bG(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((b.a)localObject).funcId = 3546;
    ((b.a)localObject).hvt = new crc();
    ((b.a)localObject).hvu = new crd();
    this.rr = ((b.a)localObject).aAz();
    localObject = (crc)this.rr.hvr.hvw;
    ((crc)localObject).DPx = bs.bG(paramString, "");
    ((crc)localObject).ENh = new cqz();
    ((crc)localObject).ENh.FDT = paramLinkedList.size();
    ((crc)localObject).ENh.FDU = paramLinkedList;
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
    ac.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fsD = ((crd)((b)paramq).hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */