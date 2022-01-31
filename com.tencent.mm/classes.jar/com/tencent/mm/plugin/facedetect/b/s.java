package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k, e
{
  private f callback;
  private boolean mhc;
  private b rr;
  
  public s(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(101);
    this.mhc = false;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cpv();
    ((b.a)localObject).fsY = new cpw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyface";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cpv)this.rr.fsV.fta;
    ((cpv)localObject).wZC = paramLong;
    ((cpv)localObject).xGH = paramString1;
    ((cpv)localObject).xGI = paramString2;
    AppMethodBeat.o(101);
  }
  
  public final boolean btY()
  {
    return true;
  }
  
  public final String btZ()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(102);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102);
    return i;
  }
  
  public final int getType()
  {
    return 797;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103);
    paramq = (cpw)((b)paramq).fsW.fta;
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      if (paramq.xGK == 0)
      {
        bool = true;
        this.mhc = bool;
        paramInt1 = paramq.xGK;
        ab.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[] { Boolean.valueOf(this.mhc) });
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      }
      AppMethodBeat.o(103);
      return;
      bool = false;
      break;
      paramInt1 = paramInt3;
      if (paramq != null)
      {
        paramInt1 = paramInt3;
        if (paramq.xGK != 0)
        {
          ab.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
          paramInt1 = paramq.xGK;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.s
 * JD-Core Version:    0.7.0.1
 */