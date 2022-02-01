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
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class s
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  private dpy gss;
  private final d rr;
  
  public s(String paramString, LinkedList<dqc> paramLinkedList)
  {
    AppMethodBeat.i(182088);
    Log.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
    ((d.a)localObject).funcId = 3546;
    ((d.a)localObject).iLN = new dpx();
    ((d.a)localObject).iLO = new dpy();
    this.rr = ((d.a)localObject).aXF();
    localObject = (dpx)this.rr.iLK.iLR;
    ((dpx)localObject).KGO = Util.nullAs(paramString, "");
    ((dpx)localObject).LTS = new dpu();
    ((dpx)localObject).LTS.MST = paramLinkedList.size();
    ((dpx)localObject).LTS.MSU = paramLinkedList;
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
    this.gss = ((dpy)((d)params).iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.s
 * JD-Core Version:    0.7.0.1
 */