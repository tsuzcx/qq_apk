package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  Object data;
  public String hzZ;
  public b rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new zh();
    ((b.a)localObject).hvu = new zi();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((b.a)localObject).funcId = 1315;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (zh)this.rr.hvr.hvw;
    ((zh)localObject).EtG = paramString1;
    ((zh)localObject).EtI = paramString2;
    ((zh)localObject).EtH = paramString3;
    this.data = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final zi aDq()
  {
    if ((this.rr != null) && (this.rr.hvs.hvw != null)) {
      return (zi)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124297);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124297);
    return i;
  }
  
  public final int getType()
  {
    return 1315;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124296);
    ac.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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