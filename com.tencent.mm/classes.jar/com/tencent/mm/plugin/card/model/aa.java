package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends q
  implements m
{
  private i callback;
  public String pTY;
  private final d rr;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, eck parameck)
  {
    AppMethodBeat.i(112837);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bkj();
    ((d.a)localObject).iLO = new bkk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((d.a)localObject).funcId = 1057;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bkj)this.rr.iLK.iLR;
    ((bkj)localObject).eaO = paramString1;
    ((bkj)localObject).eaQ = paramInt1;
    ((bkj)localObject).pPy = paramString2;
    ((bkj)localObject).eaP = paramString3;
    ((bkj)localObject).KDg = paramString4;
    ((bkj)localObject).KDf = paramString5;
    ((bkj)localObject).KDh = paramInt2;
    ((bkj)localObject).LTz = paramString6;
    ((bkj)localObject).KDj = parameck;
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
      this.pTY = ((bkk)this.rr.iLL.iLR).pTY;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */