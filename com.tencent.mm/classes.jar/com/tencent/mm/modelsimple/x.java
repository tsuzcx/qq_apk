package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import junit.framework.Assert;

public final class x
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private final q gVZ;
  
  public x(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.gVZ = new d();
    z.a locala = (z.a)this.gVZ.getReqObj();
    locala.Crh.mAQ = u.aqG();
    cow localcow = locala.Crh;
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
    localcow.gKr = ((String)localObject);
    ad.d("MicroMsg.NetSceneSendCard", "content:" + locala.Crh.gKr);
    Assert.assertTrue("empty sendcard", true);
    locala.Crh.DQE = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.Crh.EiQ = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public x(String paramString)
  {
    AppMethodBeat.i(150947);
    this.gVZ = new d();
    z.a locala = (z.a)this.gVZ.getReqObj();
    locala.Crh.mAQ = u.aqG();
    locala.Crh.gKr = paramString;
    ad.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.Crh.Dxp = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.Crh.DQE = 128;
    AppMethodBeat.o(150947);
  }
  
  public x(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.gVZ = new d();
    z.a locala = (z.a)this.gVZ.getReqObj();
    locala.Crh.mAQ = u.aqG();
    locala.Crh.gKr = paramString;
    ad.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.Crh.Dxp = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(66561, null));
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
      locala.Crh.DQE = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150949);
    this.callback = paramg;
    int i = dispatch(parame, this.gVZ, this);
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
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */