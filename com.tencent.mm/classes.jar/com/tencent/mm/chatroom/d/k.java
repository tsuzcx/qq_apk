package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private String errMsg;
  public axa fMO;
  private final b rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(182082);
    ae.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { bu.bI(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).hQF = new awz();
    ((b.a)localObject).hQG = new axa();
    this.rr = ((b.a)localObject).aDS();
    localObject = (awz)this.rr.hQD.hQJ;
    ((awz)localObject).dwx = bu.bI(paramString, "");
    ((awz)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public k(String paramString, byte paramByte)
  {
    AppMethodBeat.i(217112);
    ae.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { bu.bI(paramString, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((b.a)localObject).funcId = 3553;
    ((b.a)localObject).hQF = new awz();
    ((b.a)localObject).hQG = new axa();
    this.rr = ((b.a)localObject).aDS();
    localObject = (awz)this.rr.hQD.hQJ;
    ((awz)localObject).dqk = bu.bI(paramString, "");
    ((awz)localObject).scene = 1;
    AppMethodBeat.o(217112);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182083);
    this.callback = paramf;
    this.fMO = ((axa)this.rr.hQE.hQJ);
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
    ae.d("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */