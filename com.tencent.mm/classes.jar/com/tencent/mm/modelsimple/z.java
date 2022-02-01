package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.exb;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import junit.framework.Assert;

public final class z
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final s ouH;
  
  public z(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public z(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(150946);
    this.ouH = new g();
    z.a locala = (z.a)this.ouH.getReqObj();
    locala.YyH.UserName = com.tencent.mm.model.z.bAM();
    exb localexb = locala.YyH;
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
    localexb.nUB = ((String)localObject);
    Log.d("MicroMsg.NetSceneSendCard", "content:" + locala.YyH.nUB);
    Assert.assertTrue("empty sendcard", true);
    locala.YyH.abab = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.YyH.abzf = paramString2;
    }
    AppMethodBeat.o(150946);
  }
  
  public z(String paramString)
  {
    AppMethodBeat.i(150947);
    this.ouH = new g();
    z.a locala = (z.a)this.ouH.getReqObj();
    locala.YyH.UserName = com.tencent.mm.model.z.bAM();
    locala.YyH.nUB = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.YyH.bcb = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.YyH.abab = 128;
    AppMethodBeat.o(150947);
  }
  
  public z(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150948);
    this.ouH = new g();
    z.a locala = (z.a)this.ouH.getReqObj();
    locala.YyH.UserName = com.tencent.mm.model.z.bAM();
    locala.YyH.nUB = paramString;
    Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(paramString)));
    locala.YyH.bcb = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(66561, null));
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
      locala.YyH.abab = (j | i | 0x0 | 0x0 | 0x8);
      AppMethodBeat.o(150948);
      return;
      i = 0;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150949);
    this.callback = paramh;
    int i = dispatch(paramg, this.ouH, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */