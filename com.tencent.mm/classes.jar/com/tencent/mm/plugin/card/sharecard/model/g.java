package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  public int tqa;
  public String tqb;
  
  public g(int paramInt1, LinkedList<ehh> paramLinkedList, String paramString1, String paramString2, ehz paramehz, int paramInt2, eml parameml)
  {
    AppMethodBeat.i(112972);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ehf();
    ((d.a)localObject).lBV = new ehg();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((d.a)localObject).funcId = 902;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ehf)d.b.b(this.rr.lBR);
    ((ehf)localObject).UjE = paramInt1;
    ((ehf)localObject).lpz = paramLinkedList;
    ((ehf)localObject).jEx = paramString1;
    ((ehf)localObject).Tcj = paramString2;
    Log.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((ehf)localObject).UjF = paramehz;
    ((ehf)localObject).fUN = paramInt2;
    ((ehf)localObject).REA = parameml;
    AppMethodBeat.o(112972);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112974);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112974);
    return i;
  }
  
  public final int getType()
  {
    return 902;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112973);
    Log.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      params = (ehg)d.c.b(this.rr.lBS);
      if (params != null)
      {
        this.tpZ = params.tpZ;
        this.tqa = params.tqa;
        this.tqb = params.tqb;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112973);
      return;
      params = (ehg)d.c.b(this.rr.lBS);
      if (params != null)
      {
        this.tpZ = params.tpZ;
        this.tqa = params.tqa;
        this.tqb = params.tqb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */