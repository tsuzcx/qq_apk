package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import junit.framework.Assert;

public final class y
  extends n
  implements k
{
  private f callback;
  private final q hRG;
  
  public y(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.hRG = new e();
    z.a locala = (z.a)this.hRG.getReqObj();
    locala.FHe.nIJ = v.aAC();
    dah localdah = locala.FHe;
    Object localObject = new StringBuilder();
    int i = paramInt;
    if (paramInt == 0) {
      i = 64;
    }
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append(i).append(";");
    localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localdah.hFS = ((String)localObject);
    ae.d("MicroMsg.NetSceneSendCard", "content:" + locala.FHe.hFS);
    Assert.assertTrue("empty sendcard", true);
    locala.FHe.Hqf = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.FHe.HJP = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public y(String paramString)
  {
    AppMethodBeat.i(150947);
    this.hRG = new e();
    z.a locala = (z.a)this.hRG.getReqObj();
    locala.FHe.nIJ = v.aAC();
    locala.FHe.hFS = paramString;
    ae.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.FHe.Gan = bu.o((Integer)g.ajR().ajA().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.FHe.Hqf = 128;
    AppMethodBeat.o(150947);
  }
  
  public y(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.hRG = new e();
    z.a locala = (z.a)this.hRG.getReqObj();
    locala.FHe.nIJ = v.aAC();
    locala.FHe.hFS = paramString;
    ae.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.FHe.Gan = bu.o((Integer)g.ajR().ajA().get(66561, null));
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label146;
      }
    }
    label146:
    for (int j = 4;; j = 0)
    {
      Assert.assertTrue("empty sendcard", true);
      locala.FHe.Hqf = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150949);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(150949);
    return i;
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150950);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramq.getRespObj().getErrMsg(), this);
    AppMethodBeat.o(150950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */