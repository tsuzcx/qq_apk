package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private Object data;
  public d rr;
  
  public m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(124292);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ny();
    ((d.a)localObject).iLO = new nz();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
    ((d.a)localObject).funcId = 1364;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ny)this.rr.iLK.iLR;
    ((ny)localObject).KTt = paramString1;
    ((ny)localObject).dDv = paramString2;
    ((ny)localObject).offset = paramInt;
    this.data = null;
    AppMethodBeat.o(124292);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124294);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124294);
    return i;
  }
  
  public final int getType()
  {
    return 1364;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124293);
    Log.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.m
 * JD-Core Version:    0.7.0.1
 */