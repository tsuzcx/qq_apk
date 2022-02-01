package com.tencent.mm.al.a;

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
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u
  extends q
  implements m
{
  private i callback;
  Object data;
  public String iQz;
  public d rr;
  
  public u(String paramString1, String paramString2, LinkedList<String> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124316);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cdd();
    ((d.a)localObject).iLO = new cde();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
    ((d.a)localObject).funcId = 1389;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cdd)this.rr.iLK.iLR;
    ((cdd)localObject).Lpg = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((cdd)localObject).MiU = paramString1;
    ((cdd)localObject).MiV = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124316);
  }
  
  public final cde baF()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (cde)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124318);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124318);
    return i;
  }
  
  public final int getType()
  {
    return 1389;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124317);
    Log.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.a.u
 * JD-Core Version:    0.7.0.1
 */