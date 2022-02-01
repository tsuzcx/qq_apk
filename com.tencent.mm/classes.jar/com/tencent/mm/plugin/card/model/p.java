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
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class p
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public int pTZ;
  public String pUa;
  private final d rr;
  
  public p(LinkedList<um> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(112802);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ao();
    ((d.a)localObject).iLO = new ap();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((d.a)localObject).funcId = 1049;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ao)this.rr.iLK.iLR;
    ((ao)localObject).KDk = paramLinkedList;
    ((ao)localObject).eaQ = paramInt1;
    ((ao)localObject).KDg = paramString1;
    ((ao)localObject).KDf = paramString2;
    ((ao)localObject).KDh = paramInt2;
    AppMethodBeat.o(112802);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112803);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112803);
    return i;
  }
  
  public final int getType()
  {
    return 1049;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112804);
    Log.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ap)this.rr.iLL.iLR;
      this.pTY = params.pTY;
      this.pTZ = params.pTZ;
      this.pUa = params.pUa;
      Log.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.pTZ + " ret_msg = " + this.pUa);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */