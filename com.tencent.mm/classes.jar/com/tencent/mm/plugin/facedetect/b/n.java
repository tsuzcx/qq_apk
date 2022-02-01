package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k, e
{
  private g callback;
  private String qwC;
  private boolean qwz;
  private b rr;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.qwz = false;
    this.qwC = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cnr();
    ((b.a)localObject).hvu = new cns();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cnr)this.rr.hvr.hvw;
    ((cnr)localObject).EMt = paramLong;
    ((cnr)localObject).FAO = paramString1;
    ((cnr)localObject).FAP = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean cmZ()
  {
    return true;
  }
  
  public final String cna()
  {
    return this.qwC;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(103611);
    this.callback = paramg;
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
    paramq = (cns)((b)paramq).hvs.hvw;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.FAS == 0)
      {
        bool = true;
        this.qwz = bool;
        this.qwC = paramq.FAQ;
        paramInt1 = paramq.FAS;
        ac.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.qwz) });
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
        if (paramq.FAS != 0)
        {
          ac.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = paramq.FAS;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */