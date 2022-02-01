package com.tencent.mm.modelsimple;

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
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ac(String paramString, int paramInt, LinkedList<eg> paramLinkedList)
  {
    AppMethodBeat.i(150960);
    Log.i("MicroMsg.NetSceneTranslateLink", "ticket link = " + paramString + "; scene = " + paramInt);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ekp();
    ((d.a)localObject).iLO = new ekq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((d.a)localObject).funcId = 1200;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ekp)this.rr.iLK.iLR;
    ((ekp)localObject).link = paramString;
    ((ekp)localObject).scene = paramInt;
    ((ekp)localObject).NjP = paramLinkedList;
    AppMethodBeat.o(150960);
  }
  
  public final String bfC()
  {
    ekq localekq = (ekq)this.rr.iLL.iLR;
    if (localekq == null) {
      return null;
    }
    return localekq.NjQ;
  }
  
  public final ekq bfD()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (ekq)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150961);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150961);
    return i;
  }
  
  public final int getType()
  {
    return 1200;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150962);
    Log.d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */