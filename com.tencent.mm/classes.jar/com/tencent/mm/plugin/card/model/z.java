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
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends q
  implements m
{
  private i callback;
  public CardGiftInfo pUb;
  private final d rr;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(112834);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bkh();
    ((d.a)localObject).iLO = new bki();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((d.a)localObject).funcId = 1165;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bkh)this.rr.iLK.iLR;
    ((bkh)localObject).KDl = paramInt;
    ((bkh)localObject).KDm = paramString;
    AppMethodBeat.o(112834);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112836);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112836);
    return i;
  }
  
  public final int getType()
  {
    return 1165;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112835);
    Log.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.pUb = CardGiftInfo.a((bki)this.rr.iLL.iLR);
      Log.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.pUb.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */