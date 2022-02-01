package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends q
  implements m
{
  private i callback;
  private String jGZ;
  private final d rr;
  
  public o(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(223645);
    this.jGZ = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dtw();
    ((d.a)localObject).iLO = new dtx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((d.a)localObject).funcId = 243;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dtw)this.rr.iLK.iLR;
    ((dtw)localObject).jGZ = paramString1;
    ((dtw)localObject).MVG = paramString2;
    ((dtw)localObject).KHz = paramString3;
    ((dtw)localObject).KHA = paramInt;
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(223645);
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
    Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.jGZ });
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