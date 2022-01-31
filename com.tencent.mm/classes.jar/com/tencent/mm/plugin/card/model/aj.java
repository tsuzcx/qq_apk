package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.sdk.platformtools.ab;

public final class aj
  extends m
  implements k
{
  private f callback;
  public boolean eRq;
  public com.tencent.mm.bv.b koK;
  public String koi;
  private final com.tencent.mm.ai.b rr;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bv.b paramb)
  {
    AppMethodBeat.i(87922);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new agc();
    ((b.a)localObject).fsY = new agd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).funcId = 664;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (agc)this.rr.fsV.fta;
    ((agc)localObject).app_id = paramString1;
    ((agc)localObject).kwG = paramInt1;
    ((agc)localObject).kwH = paramString2;
    ((agc)localObject).kwI = paramString3;
    ((agc)localObject).time_stamp = paramInt2;
    ((agc)localObject).kwJ = paramString4;
    ((agc)localObject).kml = paramString5;
    ((agc)localObject).kwK = paramString6;
    ((agc)localObject).koK = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((agc)localObject).wZe = 1;
      AppMethodBeat.o(87922);
      return;
    }
    ((agc)localObject).wZe = 0;
    AppMethodBeat.o(87922);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87923);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87923);
    return i;
  }
  
  public final int getType()
  {
    return 664;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87924);
    ab.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (agd)this.rr.fsW.fta;
      this.koi = paramq.koi;
      this.koK = paramq.koK;
      if (paramq.wZf == 0) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      this.eRq = bool;
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87924);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */