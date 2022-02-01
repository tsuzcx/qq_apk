package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class a
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(109742);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new mu();
    ((c.a)localObject).otF = new mv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (mu)c.b.b(this.rr.otB);
    ((mu)localObject).YKH = 1;
    ((mu)localObject).beD = paramInt;
    ((mu)localObject).YNT = paramString1;
    ((mu)localObject).YNU = paramString2;
    ((mu)localObject).YNV = paramString3;
    ((mu)localObject).YNW = paramString4;
    ((mu)localObject).YNX = paramString5;
    ((mu)localObject).YNY = paramString6;
    ((mu)localObject).YNZ = paramString7;
    AppMethodBeat.o(109742);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(109743);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(109743);
    return i;
  }
  
  public final int getType()
  {
    return 549;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109744);
    Log.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (mu)c.b.b(this.rr.otB);
    c.c.b(this.rr.otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().B(286722, params.YNU);
      com.tencent.mm.kernel.h.baE().ban().B(286721, params.YNT);
      com.tencent.mm.kernel.h.baE().ban().B(286723, params.YNV);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(109744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */