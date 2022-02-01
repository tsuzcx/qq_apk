package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends q
  implements m
{
  private i callback;
  private String myd;
  private String mye;
  public dfg myf;
  private int ret;
  private final d rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151199);
    d.a locala = new d.a();
    locala.lBU = new bzk();
    locala.lBV = new bzl();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.bgN();
    this.myd = paramString1;
    this.mye = Util.nullAs(paramString2, "");
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.mye, paramString3 });
    paramString2 = (bzk)d.b.b(this.rr.lBR);
    paramString2.myd = paramString1;
    paramString2.fHp = this.mye;
    paramString2.fAo = paramString3;
    AppMethodBeat.o(151199);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151200);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151200);
    return i;
  }
  
  public final int getType()
  {
    return 881;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151201);
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.myd });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151201);
      return;
    }
    params = (bzl)d.c.b(this.rr.lBS);
    this.myf = params.Tim;
    this.ret = s.a(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */