package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends m
  implements k
{
  private f callback;
  public String gfL;
  public String gfU;
  public String gfV;
  private final b rr;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78881);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cpy();
    ((b.a)localObject).fsY = new cpz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((b.a)localObject).funcId = 853;
    this.rr = ((b.a)localObject).ado();
    this.gfL = paramString1;
    this.gfU = paramString2;
    localObject = (cpy)this.rr.fsV.fta;
    ((cpy)localObject).gfL = paramString1;
    ((cpy)localObject).gfU = paramString2;
    ab.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78881);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78883);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78883);
    return i;
  }
  
  public final int getType()
  {
    return 853;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78882);
    ab.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfL });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */