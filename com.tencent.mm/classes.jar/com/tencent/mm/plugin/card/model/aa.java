package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.ad;

public final class aa
  extends n
  implements k
{
  private g callback;
  public String ntw;
  private final b rr;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, cxe paramcxe)
  {
    AppMethodBeat.i(112837);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new arh();
    ((b.a)localObject).gUV = new ari();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((b.a)localObject).funcId = 1057;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (arh)this.rr.gUS.gUX;
    ((arh)localObject).dyc = paramString1;
    ((arh)localObject).dye = paramInt1;
    ((arh)localObject).nsI = paramString2;
    ((arh)localObject).dyd = paramString3;
    ((arh)localObject).CtU = paramString4;
    ((arh)localObject).CtT = paramString5;
    ((arh)localObject).CtV = paramInt2;
    ((arh)localObject).DrO = paramString6;
    ((arh)localObject).CtX = paramcxe;
    AppMethodBeat.o(112837);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112838);
    this.callback = paramg;
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
      this.ntw = ((ari)this.rr.gUT.gUX).ntw;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */