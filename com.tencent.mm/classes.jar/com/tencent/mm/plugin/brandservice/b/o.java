package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class o
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public o(String paramString, LinkedList<cla> paramLinkedList)
  {
    AppMethodBeat.i(5596);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cld();
    ((d.a)localObject).iLO = new cle();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
    ((d.a)localObject).funcId = 1030;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cld)this.rr.iLK.iLR;
    ((cld)localObject).Mis = paramString;
    ((cld)localObject).MqA = paramLinkedList;
    AppMethodBeat.o(5596);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5598);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5598);
    return i;
  }
  
  public final int getType()
  {
    return 1030;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5597);
    Log.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.o
 * JD-Core Version:    0.7.0.1
 */