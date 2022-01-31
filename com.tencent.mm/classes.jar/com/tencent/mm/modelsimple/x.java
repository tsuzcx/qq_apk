package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import junit.framework.Assert;

public final class x
  extends m
  implements k
{
  private f callback;
  private final q ftU;
  
  public x(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public x(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78596);
    this.ftU = new d();
    x.a locala = (x.a)this.ftU.getReqObj();
    locala.wiV.jJA = r.Zn();
    byr localbyr = locala.wiV;
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
    localbyr.ntu = ((String)localObject);
    ab.d("MicroMsg.NetSceneSendCard", "content:" + locala.wiV.ntu);
    Assert.assertTrue("empty sendcard", true);
    locala.wiV.xvr = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.wiV.xLa = paramString2;
    }
    AppMethodBeat.o(78596);
  }
  
  public x(String paramString)
  {
    AppMethodBeat.i(78597);
    this.ftU = new d();
    x.a locala = (x.a)this.ftU.getReqObj();
    locala.wiV.jJA = r.Zn();
    locala.wiV.ntu = paramString;
    ab.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.wiV.xez = bo.g((Integer)g.RL().Ru().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.wiV.xvr = 128;
    AppMethodBeat.o(78597);
  }
  
  public x(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(78598);
    this.ftU = new d();
    x.a locala = (x.a)this.ftU.getReqObj();
    locala.wiV.jJA = r.Zn();
    locala.wiV.ntu = paramString;
    ab.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.wiV.xez = bo.g((Integer)g.RL().Ru().get(66561, null));
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
      locala.wiV.xvr = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(78598);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78599);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(78599);
    return i;
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78600);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramq.getRespObj().getErrMsg(), this);
    AppMethodBeat.o(78600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */