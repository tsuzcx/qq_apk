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
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esz;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class v
  extends p
  implements m
{
  private h callback;
  private String errMsg;
  private eta lyH;
  private final c rr;
  
  public v(String paramString, LinkedList<ete> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    Log.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((c.a)localObject).funcId = 3546;
    ((c.a)localObject).otE = new esz();
    ((c.a)localObject).otF = new eta();
    this.rr = ((c.a)localObject).bEF();
    localObject = (esz)c.b.b(this.rr.otB);
    ((esz)localObject).YFk = Util.nullAs(paramString, "");
    ((esz)localObject).aapP = new esw();
    ((esz)localObject).aapP.abwo = paramLinkedList.size();
    ((esz)localObject).aapP.abwp = paramLinkedList;
    AppMethodBeat.o(182088);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(182089);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182089);
    return i;
  }
  
  public final int getType()
  {
    return 3546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182090);
    Log.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.lyH = ((eta)c.c.b(((c)params).otC));
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.v
 * JD-Core Version:    0.7.0.1
 */