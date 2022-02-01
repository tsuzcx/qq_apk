package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exp;
import com.tencent.mm.protocal.protobuf.exq;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private h callback;
  private String psp;
  private final c rr;
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(235815);
    this.psp = paramString1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new exp();
    ((c.a)localObject).otF = new exq();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((c.a)localObject).funcId = 243;
    this.rr = ((c.a)localObject).bEF();
    localObject = (exp)c.b.b(this.rr.otB);
    ((exp)localObject).psp = paramString1;
    ((exp)localObject).abzp = paramString2;
    ((exp)localObject).YFT = paramString3;
    ((exp)localObject).YFU = paramInt;
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(235815);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151220);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151220);
    return i;
  }
  
  public final int getType()
  {
    return 243;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151221);
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.psp });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.r
 * JD-Core Version:    0.7.0.1
 */