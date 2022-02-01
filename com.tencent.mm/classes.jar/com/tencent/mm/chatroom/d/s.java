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
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.dzy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class s
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dzu iWD;
  private final d rr;
  
  public s(String paramString, LinkedList<dzy> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    Log.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((d.a)localObject).funcId = 3546;
    ((d.a)localObject).lBU = new dzt();
    ((d.a)localObject).lBV = new dzu();
    this.rr = ((d.a)localObject).bgN();
    localObject = (dzt)d.b.b(this.rr.lBR);
    ((dzt)localObject).RIi = Util.nullAs(paramString, "");
    ((dzt)localObject).TcA = new dzq();
    ((dzt)localObject).TcA.Ufb = paramLinkedList.size();
    ((dzt)localObject).TcA.Ufc = paramLinkedList;
    AppMethodBeat.o(182088);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182089);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182089);
    return i;
  }
  
  public final int getType()
  {
    return 3546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182090);
    Log.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.iWD = ((dzu)d.c.b(((d)params).lBS));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */