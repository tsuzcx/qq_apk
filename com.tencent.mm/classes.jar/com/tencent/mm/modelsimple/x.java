package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import junit.framework.Assert;

public final class x
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private final q hwy;
  
  public x(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.hwy = new d();
    z.a locala = (z.a)this.hwy.getReqObj();
    locala.DJz.ncR = u.axw();
    cud localcud = locala.DJz;
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
    localcud.hkR = ((String)localObject);
    ac.d("MicroMsg.NetSceneSendCard", "content:" + locala.DJz.hkR);
    Assert.assertTrue("empty sendcard", true);
    locala.DJz.FmW = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.DJz.FFO = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public x(String paramString)
  {
    AppMethodBeat.i(150947);
    this.hwy = new d();
    z.a locala = (z.a)this.hwy.getReqObj();
    locala.DJz.ncR = u.axw();
    locala.DJz.hkR = paramString;
    ac.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.DJz.ESL = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.DJz.FmW = 128;
    AppMethodBeat.o(150947);
  }
  
  public x(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.hwy = new d();
    z.a locala = (z.a)this.hwy.getReqObj();
    locala.DJz.ncR = u.axw();
    locala.DJz.hkR = paramString;
    ac.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.DJz.ESL = bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66561, null));
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
      locala.DJz.FmW = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150949);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */