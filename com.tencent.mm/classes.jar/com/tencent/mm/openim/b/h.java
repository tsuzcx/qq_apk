package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
  extends n
  implements k
{
  private g callback;
  private String iod;
  private String ioe;
  public cae iof;
  private int ret;
  private final b rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151199);
    b.a locala = new b.a();
    locala.hvt = new bay();
    locala.hvu = new baz();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.aAz();
    this.iod = paramString1;
    this.ioe = bs.bG(paramString2, "");
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.ioe, paramString3 });
    paramString2 = (bay)this.rr.hvr.hvw;
    paramString2.iod = paramString1;
    paramString2.djF = this.ioe;
    paramString2.ddJ = paramString3;
    AppMethodBeat.o(151199);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151200);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151200);
    return i;
  }
  
  public final int getType()
  {
    return 881;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151201);
    ac.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iod });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151201);
      return;
    }
    paramq = (baz)this.rr.hvs.hvw;
    this.iof = paramq.ERI;
    this.ret = s.a(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */