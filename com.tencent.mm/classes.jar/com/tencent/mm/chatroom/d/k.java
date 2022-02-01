package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  public bpv iWl;
  private final d rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(182082);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((d.a)localObject).funcId = 3553;
    ((d.a)localObject).lBU = new bpu();
    ((d.a)localObject).lBV = new bpv();
    this.rr = ((d.a)localObject).bgN();
    localObject = (bpu)d.b.b(this.rr.lBR);
    ((bpu)localObject).fHp = Util.nullAs(paramString, "");
    ((bpu)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public k(String paramString, byte paramByte)
  {
    AppMethodBeat.i(193819);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((d.a)localObject).funcId = 3553;
    ((d.a)localObject).lBU = new bpu();
    ((d.a)localObject).lBV = new bpv();
    this.rr = ((d.a)localObject).bgN();
    localObject = (bpu)d.b.b(this.rr.lBR);
    ((bpu)localObject).fAo = Util.nullAs(paramString, "");
    ((bpu)localObject).scene = 1;
    AppMethodBeat.o(193819);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182083);
    this.callback = parami;
    this.iWl = ((bpv)d.c.b(this.rr.lBS));
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182083);
    return i;
  }
  
  public final int getType()
  {
    return 3553;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182084);
    Log.d("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */