package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public String lGP;
  public d rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ady();
    ((d.a)localObject).lBV = new adz();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((d.a)localObject).funcId = 1315;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ady)d.b.b(this.rr.lBR);
    ((ady)localObject).SqC = paramString1;
    ((ady)localObject).SqE = paramString2;
    ((ady)localObject).SqD = paramString3;
    this.bnW = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final adz bjR()
  {
    AppMethodBeat.i(205849);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      adz localadz = (adz)d.c.b(this.rr.lBS);
      AppMethodBeat.o(205849);
      return localadz;
    }
    AppMethodBeat.o(205849);
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
 * Qualified Name:     com.tencent.mm.ao.a.n
 * JD-Core Version:    0.7.0.1
 */