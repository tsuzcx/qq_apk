package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class h
  extends n
  implements k
{
  private f callback;
  public final com.tencent.mm.ak.b rr;
  private byte[] vlN;
  String vlO;
  
  public h(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(55691);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new beh();
    ((b.a)localObject).hQG = new bei();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlocimg";
    ((b.a)localObject).funcId = 648;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (beh)this.rr.hQD.hQJ;
    ((beh)localObject).qkN = paramString2;
    if (bu.jq(ak.getContext())) {}
    for (((beh)localObject).GTE = 1;; ((beh)localObject).GTE = 0)
    {
      ((beh)localObject).Gha = paramFloat1;
      ((beh)localObject).GgZ = paramFloat2;
      ((beh)localObject).GTF = paramInt1;
      ae.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      while (paramInt2 * paramInt3 > 270000)
      {
        paramInt2 = (int)(paramInt2 / 1.2D);
        paramInt3 = (int)(paramInt3 / 1.2D);
      }
    }
    ae.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), ((beh)localObject).qkN });
    ((beh)localObject).Height = paramInt3;
    ((beh)localObject).Width = paramInt2;
    this.vlO = paramString1;
    AppMethodBeat.o(55691);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55692);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55692);
    return i;
  }
  
  public final int getType()
  {
    return 648;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55693);
    ae.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramq = (bei)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    try
    {
      this.vlN = paramq.FNK.getBuffer().zr;
      o.f(this.vlO, this.vlN, this.vlN.length);
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(55693);
      return;
    }
    catch (Exception paramq)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneGetLocImg", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */