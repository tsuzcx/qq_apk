package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public t(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23407);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxw();
    ((b.a)localObject).hNN = new cxx();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
    ((b.a)localObject).funcId = 1706;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxw)this.rr.hNK.hNQ;
    ((cxw)localObject).mac = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((cxw)localObject).userName = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    ((cxw)localObject).category = paramString1;
    AppMethodBeat.o(23407);
  }
  
  public final cxx clp()
  {
    return (cxx)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23409);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23409);
    return i;
  }
  
  public final int getType()
  {
    return 1706;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23408);
    ad.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.t
 * JD-Core Version:    0.7.0.1
 */