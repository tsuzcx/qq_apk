package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ab;

public final class aa
  extends m
  implements k
{
  private f callback;
  public String koi;
  private final b rr;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, cgd paramcgd)
  {
    AppMethodBeat.i(87895);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aia();
    ((b.a)localObject).fsY = new aib();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((b.a)localObject).funcId = 645;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aia)this.rr.fsV.fta;
    ((aia)localObject).cHn = paramString1;
    ((aia)localObject).cHp = paramInt1;
    ((aia)localObject).knu = paramString2;
    ((aia)localObject).cHo = paramString3;
    ((aia)localObject).wlG = paramString4;
    ((aia)localObject).wlF = paramString5;
    ((aia)localObject).wlH = paramInt2;
    ((aia)localObject).wZY = paramString6;
    ((aia)localObject).wlJ = paramcgd;
    AppMethodBeat.o(87895);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87896);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87896);
    return i;
  }
  
  public final int getType()
  {
    return 645;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87897);
    ab.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.koi = ((aib)this.rr.fsW.fta).koi;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */