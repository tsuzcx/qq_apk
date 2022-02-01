package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k, e
{
  private f callback;
  private boolean ros;
  private String rov;
  private b rr;
  
  public n(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(103610);
    this.ros = false;
    this.rov = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cto();
    ((b.a)localObject).hQG = new ctp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registerface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cto)this.rr.hQD.hQJ;
    ((cto)localObject).GOW = paramLong;
    ((cto)localObject).HEC = paramString1;
    ((cto)localObject).HED = paramString2;
    AppMethodBeat.o(103610);
  }
  
  public final boolean cuf()
  {
    return true;
  }
  
  public final String cug()
  {
    return this.rov;
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
    paramq = (ctp)((b)paramq).hQE.hQJ;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.HEF == 0)
      {
        bool = true;
        this.ros = bool;
        this.rov = paramq.HEE;
        paramInt1 = paramq.HEF;
        ae.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.ros) });
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
        if (paramq.HEF != 0)
        {
          ae.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
          paramInt1 = paramq.HEF;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.n
 * JD-Core Version:    0.7.0.1
 */