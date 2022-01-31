package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  public String gfL;
  private final com.tencent.mm.ai.b rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78836);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cq();
    ((b.a)localObject).fsY = new cr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimcontact";
    ((b.a)localObject).funcId = 667;
    this.rr = ((b.a)localObject).ado();
    this.gfL = paramString1;
    localObject = (cq)this.rr.fsV.fta;
    ((cq)localObject).gfL = paramString1;
    ((cq)localObject).wpd = paramString2;
    ab.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78836);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78838);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78838);
    return i;
  }
  
  public final int getType()
  {
    return 667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78837);
    ab.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfL });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.b.b
 * JD-Core Version:    0.7.0.1
 */