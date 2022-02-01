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
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  Object data;
  public String iQz;
  public d rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new adr();
    ((d.a)localObject).iLO = new ads();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((d.a)localObject).funcId = 1315;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (adr)this.rr.iLK.iLR;
    ((adr)localObject).Lpg = paramString1;
    ((adr)localObject).Lpi = paramString2;
    ((adr)localObject).Lph = paramString3;
    this.data = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final ads baC()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (ads)this.rr.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124297);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124297);
    return i;
  }
  
  public final int getType()
  {
    return 1315;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124296);
    Log.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.a.n
 * JD-Core Version:    0.7.0.1
 */