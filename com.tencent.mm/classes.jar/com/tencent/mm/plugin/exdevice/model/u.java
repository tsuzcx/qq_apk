package com.tencent.mm.plugin.exdevice.model;

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
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public u(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(23407);
    this.callback = null;
    this.rr = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ebh();
    ((d.a)localObject).lBV = new ebi();
    ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
    ((d.a)localObject).funcId = 1706;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ebh)d.b.b(this.rr.lBR);
    ((ebh)localObject).mac = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((ebh)localObject).userName = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    ((ebh)localObject).idV = paramString1;
    AppMethodBeat.o(23407);
  }
  
  public final ebi cZt()
  {
    AppMethodBeat.i(225256);
    ebi localebi = (ebi)d.c.b(this.rr.lBS);
    AppMethodBeat.o(225256);
    return localebi;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23409);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23409);
    return i;
  }
  
  public final int getType()
  {
    return 1706;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23408);
    Log.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */