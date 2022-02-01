package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, eml parameml)
  {
    AppMethodBeat.i(112837);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new brs();
    ((d.a)localObject).lBV = new brt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((d.a)localObject).funcId = 1057;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (brs)d.b.b(this.rr.lBR);
    ((brs)localObject).fUL = paramString1;
    ((brs)localObject).fUN = paramInt1;
    ((brs)localObject).from_username = paramString2;
    ((brs)localObject).fUM = paramString3;
    ((brs)localObject).REx = paramString4;
    ((brs)localObject).REw = paramString5;
    ((brs)localObject).REy = paramInt2;
    ((brs)localObject).Tcj = paramString6;
    ((brs)localObject).REA = parameml;
    AppMethodBeat.o(112837);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112838);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112838);
    return i;
  }
  
  public final int getType()
  {
    return 1057;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112839);
    Log.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tpZ = ((brt)d.c.b(this.rr.lBS)).tpZ;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */