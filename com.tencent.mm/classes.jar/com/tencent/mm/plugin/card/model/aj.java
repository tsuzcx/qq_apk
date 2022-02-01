package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.sdk.platformtools.Log;

public final class aj
  extends q
  implements m
{
  private i callback;
  public boolean kSa;
  private final d rr;
  public String tpZ;
  public b tqA;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, b paramb)
  {
    AppMethodBeat.i(112864);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpw();
    ((d.a)localObject).lBV = new bpx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((d.a)localObject).funcId = 1059;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bpw)d.b.b(this.rr.lBR);
    ((bpw)localObject).app_id = paramString1;
    ((bpw)localObject).tyG = paramInt1;
    ((bpw)localObject).tyH = paramString2;
    ((bpw)localObject).tyI = paramString3;
    ((bpw)localObject).time_stamp = paramInt2;
    ((bpw)localObject).tyJ = paramString4;
    ((bpw)localObject).tnX = paramString5;
    ((bpw)localObject).tyK = paramString6;
    ((bpw)localObject).tqA = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((bpw)localObject).Tbo = 1;
      AppMethodBeat.o(112864);
      return;
    }
    ((bpw)localObject).Tbo = 0;
    AppMethodBeat.o(112864);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112865);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112865);
    return i;
  }
  
  public final int getType()
  {
    return 1059;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112866);
    Log.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bpx)d.c.b(this.rr.lBS);
      this.tpZ = params.tpZ;
      this.tqA = params.tqA;
      if (params.Tbp == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.kSa = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */