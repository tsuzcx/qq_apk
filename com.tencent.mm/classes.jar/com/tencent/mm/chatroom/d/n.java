package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  extends p
  implements m
{
  private h callback;
  private String errMsg;
  public cem lyo;
  private final c rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(182082);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((c.a)localObject).funcId = 3553;
    ((c.a)localObject).otE = new cel();
    ((c.a)localObject).otF = new cem();
    this.rr = ((c.a)localObject).bEF();
    localObject = (cel)c.b.b(this.rr.otB);
    ((cel)localObject).hMM = Util.nullAs(paramString, "");
    ((cel)localObject).scene = 0;
    AppMethodBeat.o(182082);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(241442);
    Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", new Object[] { Util.nullAs(paramString, "") });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
    ((c.a)localObject).funcId = 3553;
    ((c.a)localObject).otE = new cel();
    ((c.a)localObject).otF = new cem();
    this.rr = ((c.a)localObject).bEF();
    localObject = (cel)c.b.b(this.rr.otB);
    ((cel)localObject).hFb = Util.nullAs(paramString, "");
    ((cel)localObject).scene = 1;
    AppMethodBeat.o(241442);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(182083);
    this.callback = paramh;
    this.lyo = ((cem)c.c.b(this.rr.otC));
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
 * Qualified Name:     com.tencent.mm.chatroom.d.n
 * JD-Core Version:    0.7.0.1
 */