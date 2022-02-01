package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.edy;
import com.tencent.mm.protocal.protobuf.edz;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  private String myd;
  private final d rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(194923);
    this.myd = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new edy();
    ((d.a)localObject).lBV = new edz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((d.a)localObject).funcId = 243;
    this.rr = ((d.a)localObject).bgN();
    localObject = (edy)d.b.b(this.rr.lBR);
    ((edy)localObject).myd = paramString1;
    ((edy)localObject).UhZ = paramString2;
    ((edy)localObject).RIS = paramString3;
    ((edy)localObject).RIT = paramInt;
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(194923);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151220);
    this.callback = parami;
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
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.myd });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.o
 * JD-Core Version:    0.7.0.1
 */