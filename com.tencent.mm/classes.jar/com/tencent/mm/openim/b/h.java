package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
  extends q
  implements m
{
  private i callback;
  private String jGZ;
  private String jHa;
  public cvw jHb;
  private int ret;
  private final d rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151199);
    d.a locala = new d.a();
    locala.iLN = new bro();
    locala.iLO = new brp();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.aXF();
    this.jGZ = paramString1;
    this.jHa = Util.nullAs(paramString2, "");
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.jHa, paramString3 });
    paramString2 = (bro)this.rr.iLK.iLR;
    paramString2.jGZ = paramString1;
    paramString2.dOe = this.jHa;
    paramString2.dHx = paramString3;
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
    Log.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.jGZ });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151201);
      return;
    }
    params = (brp)this.rr.iLL.iLR;
    this.jHb = params.LYS;
    this.ret = s.a(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */