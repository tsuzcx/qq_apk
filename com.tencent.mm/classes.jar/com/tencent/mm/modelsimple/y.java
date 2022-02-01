package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.dtl;
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
  private final s iMO;
  
  public y(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.iMO = new e();
    z.a locala = (z.a)this.iMO.getReqObj();
    locala.KAp.UserName = z.aTY();
    dtl localdtl = locala.KAp;
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
    localdtl.iAc = ((String)localObject);
    Log.d("MicroMsg.NetSceneSendCard", "content:" + locala.KAp.iAc);
    Assert.assertTrue("empty sendcard", true);
    locala.KAp.MyL = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.KAp.MVB = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public y(String paramString)
  {
    AppMethodBeat.i(150947);
    this.iMO = new e();
    z.a locala = (z.a)this.iMO.getReqObj();
    locala.KAp.UserName = z.aTY();
    locala.KAp.iAc = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.KAp.KUh = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.KAp.MyL = 128;
    AppMethodBeat.o(150947);
  }
  
  public y(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.iMO = new e();
    z.a locala = (z.a)this.iMO.getReqObj();
    locala.KAp.UserName = z.aTY();
    locala.KAp.iAc = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.KAp.KUh = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(66561, null));
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
      locala.KAp.MyL = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150949);
    this.callback = parami;
    int i = dispatch(paramg, this.iMO, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */