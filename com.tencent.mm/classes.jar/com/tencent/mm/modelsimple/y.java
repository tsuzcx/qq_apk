package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import junit.framework.Assert;

public final class y
  extends q
  implements m
{
  private i callback;
  private final s lCW;
  
  public y(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.lCW = new e();
    z.a locala = (z.a)this.lCW.getReqObj();
    locala.RCf.UserName = z.bcZ();
    edk localedk = locala.RCf;
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
    localedk.lpy = ((String)localObject);
    Log.d("MicroMsg.NetSceneSendCard", "content:" + locala.RCf.lpy);
    Assert.assertTrue("empty sendcard", true);
    locala.RCf.TKm = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.RCf.UhP = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public y(String paramString)
  {
    AppMethodBeat.i(150947);
    this.lCW = new e();
    z.a locala = (z.a)this.lCW.getReqObj();
    locala.RCf.UserName = z.bcZ();
    locala.RCf.lpy = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.RCf.RVf = Util.nullAsNil((Integer)h.aHG().aHp().b(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.RCf.TKm = 128;
    AppMethodBeat.o(150947);
  }
  
  public y(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.lCW = new e();
    z.a locala = (z.a)this.lCW.getReqObj();
    locala.RCf.UserName = z.bcZ();
    locala.RCf.lpy = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.RCf.RVf = Util.nullAsNil((Integer)h.aHG().aHp().b(66561, null));
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
      locala.RCf.TKm = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150949);
    this.callback = parami;
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(150949);
    return i;
  }
  
  public final int getType()
  {
    return 26;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150950);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, params.getRespObj().getErrMsg(), this);
    AppMethodBeat.o(150950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */