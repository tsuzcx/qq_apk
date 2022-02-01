package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k, e
{
  private f callback;
  private boolean rgp;
  private String rgs;
  private b rr;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.rgp = false;
    this.rgs = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new csu();
    ((b.a)localObject).hNN = new csv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (csu)this.rr.hNK.hNQ;
    ((csu)localObject).Gvx = paramLong;
    ((csu)localObject).Hlc = paramString1;
    ((csu)localObject).Hld = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean csE()
  {
    return true;
  }
  
  public final String csF()
  {
    return this.rgs;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103611);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103611);
    return i;
  }
  
  public final int getType()
  {
    return 918;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103612);
    paramq = (csv)((b)paramq).hNL.hNQ;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.Hlf == 0)
      {
        bool = true;
        this.rgp = bool;
        this.rgs = paramq.Hle;
        paramInt1 = paramq.Hlf;
        ad.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.rgp) });
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      AppMethodBeat.o(103612);
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.Hlf != 0)
        {
          ad.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = paramq.Hlf;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */