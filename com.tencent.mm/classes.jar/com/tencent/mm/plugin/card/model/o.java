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
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  public int tqa;
  public String tqb;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, eml parameml)
  {
    AppMethodBeat.i(112799);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ak();
    ((d.a)localObject).lBV = new al();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((d.a)localObject).funcId = 1037;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ak)d.b.b(this.rr.lBR);
    ((ak)localObject).fUL = paramString1;
    ((ak)localObject).from_username = paramString2;
    ((ak)localObject).fUN = paramInt1;
    ((ak)localObject).fUM = paramString3;
    ((ak)localObject).REx = paramString4;
    ((ak)localObject).REw = paramString5;
    ((ak)localObject).REy = paramInt2;
    ((ak)localObject).REz = paramInt3;
    ((ak)localObject).REA = parameml;
    AppMethodBeat.o(112799);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112800);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112800);
    return i;
  }
  
  public final int getType()
  {
    return 1037;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112801);
    Log.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (al)d.c.b(this.rr.lBS);
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
      AppMethodBeat.o(112801);
      return;
      params = (al)d.c.b(this.rr.lBS);
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
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */