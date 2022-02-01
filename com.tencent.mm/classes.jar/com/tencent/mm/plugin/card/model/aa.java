package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.platformtools.ad;

public final class aa
  extends n
  implements k
{
  private f callback;
  public String ozQ;
  private final b rr;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, did paramdid)
  {
    AppMethodBeat.i(112837);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ayj();
    ((b.a)localObject).hNN = new ayk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((b.a)localObject).funcId = 1057;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ayj)this.rr.hNK.hNQ;
    ((ayj)localObject).dHX = paramString1;
    ((ayj)localObject).dHZ = paramInt1;
    ((ayj)localObject).ovl = paramString2;
    ((ayj)localObject).dHY = paramString3;
    ((ayj)localObject).Frq = paramString4;
    ((ayj)localObject).Frp = paramString5;
    ((ayj)localObject).Frr = paramInt2;
    ((ayj)localObject).GvU = paramString6;
    ((ayj)localObject).Frt = paramdid;
    AppMethodBeat.o(112837);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112838);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112838);
    return i;
  }
  
  public final int getType()
  {
    return 1057;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112839);
    ad.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ozQ = ((ayk)this.rr.hNL.hNQ).ozQ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */