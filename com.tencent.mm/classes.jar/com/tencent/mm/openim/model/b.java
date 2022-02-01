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
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends p
  implements m
{
  private h callback;
  public String psp;
  private final c rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151180);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ds();
    ((c.a)localObject).otF = new dt();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimcontact";
    ((c.a)localObject).funcId = 667;
    this.rr = ((c.a)localObject).bEF();
    this.psp = paramString1;
    localObject = (ds)c.b.b(this.rr.otB);
    ((ds)localObject).psp = paramString1;
    ((ds)localObject).YFT = paramString2;
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151180);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151182);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151182);
    return i;
  }
  
  public final int getType()
  {
    return 667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151181);
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.psp });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.b
 * JD-Core Version:    0.7.0.1
 */