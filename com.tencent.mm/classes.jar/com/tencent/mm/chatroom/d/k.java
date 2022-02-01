package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private String errMsg;
  public asm fsl;
  private final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(182082);
    ac.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { bs.bG(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).hvt = new asl();
    ((b.a)localObject).hvu = new asm();
    this.rr = ((b.a)localObject).aAz();
    localObject = (asl)this.rr.hvr.hvw;
    ((asl)localObject).djF = bs.bG(paramString, "");
    ((asl)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public k(String paramString, byte paramByte)
  {
    AppMethodBeat.i(197029);
    ac.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { bs.bG(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).hvt = new asl();
    ((b.a)localObject).hvu = new asm();
    this.rr = ((b.a)localObject).aAz();
    localObject = (asl)this.rr.hvr.hvw;
    ((asl)localObject).ddJ = bs.bG(paramString, "");
    ((asl)localObject).scene = 1;
    AppMethodBeat.o(197029);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182083);
    this.callback = paramg;
    this.fsl = ((asm)this.rr.hvs.hvw);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182083);
    return i;
  }
  
  public final int getType()
  {
    return 3553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182084);
    ac.d("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */