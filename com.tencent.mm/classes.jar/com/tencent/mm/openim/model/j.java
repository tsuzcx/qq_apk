package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends p
  implements m
{
  private h callback;
  private String psp;
  private String pss;
  public dxi pst;
  private int ret;
  private final c rr;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151199);
    c.a locala = new c.a();
    locala.otE = new cop();
    locala.otF = new coq();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.bEF();
    this.psp = paramString1;
    this.pss = Util.nullAs(paramString2, "");
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.pss, paramString3 });
    paramString2 = (cop)c.b.b(this.rr.otB);
    paramString2.psp = paramString1;
    paramString2.hMM = this.pss;
    paramString2.hFb = paramString3;
    AppMethodBeat.o(151199);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151200);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151200);
    return i;
  }
  
  public final int getType()
  {
    return 881;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151201);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.psp });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151201);
      return;
    }
    params = (coq)c.c.b(this.rr.otC);
    this.pst = params.aavF;
    this.ret = v.a(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.j
 * JD-Core Version:    0.7.0.1
 */