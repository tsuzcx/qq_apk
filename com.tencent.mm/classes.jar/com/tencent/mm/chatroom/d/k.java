package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  public bik gsa;
  private final d rr;
  
  public k(String paramString)
  {
    AppMethodBeat.i(182082);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((d.a)localObject).funcId = 3553;
    ((d.a)localObject).iLN = new bij();
    ((d.a)localObject).iLO = new bik();
    this.rr = ((d.a)localObject).aXF();
    localObject = (bij)this.rr.iLK.iLR;
    ((bij)localObject).dOe = Util.nullAs(paramString, "");
    ((bij)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public k(String paramString, byte paramByte)
  {
    AppMethodBeat.i(194026);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((d.a)localObject).funcId = 3553;
    ((d.a)localObject).iLN = new bij();
    ((d.a)localObject).iLO = new bik();
    this.rr = ((d.a)localObject).aXF();
    localObject = (bij)this.rr.iLK.iLR;
    ((bij)localObject).dHx = Util.nullAs(paramString, "");
    ((bij)localObject).scene = 1;
    AppMethodBeat.o(194026);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182083);
    this.callback = parami;
    this.gsa = ((bik)this.rr.iLL.iLR);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.k
 * JD-Core Version:    0.7.0.1
 */