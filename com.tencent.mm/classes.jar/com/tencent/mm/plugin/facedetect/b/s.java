package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dum;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ad;

public final class s
  extends n
  implements k, e
{
  private f callback;
  private boolean rgp;
  private b rr;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103626);
    this.rgp = false;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dum();
    ((b.a)localObject).hNN = new dun();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dum)this.rr.hNK.hNQ;
    ((dum)localObject).Gvx = paramLong;
    ((dum)localObject).Hlc = paramString1;
    ((dum)localObject).Hld = paramString2;
    AppMethodBeat.o(103626);
  }
  
  public final boolean csE()
  {
    return true;
  }
  
  public final String csF()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103627);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103627);
    return i;
  }
  
  public final int getType()
  {
    return 797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103628);
    paramq = (dun)((b)paramq).hNL.hNQ;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.Hlf == 0)
      {
        bool = true;
        this.rgp = bool;
        paramInt1 = paramq.Hlf;
        ad.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.rgp) });
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      AppMethodBeat.o(103628);
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.Hlf != 0)
        {
          ad.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = paramq.Hlf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */