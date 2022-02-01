package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
  extends n
  implements k
{
  private f callback;
  private String iHA;
  private String iHB;
  public cev iHC;
  private int ret;
  private final b rr;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(151199);
    b.a locala = new b.a();
    locala.hNM = new bfc();
    locala.hNN = new bfd();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.funcId = 881;
    this.rr = locala.aDC();
    this.iHA = paramString1;
    this.iHB = bt.bI(paramString2, "");
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.iHB, paramString3 });
    paramString2 = (bfc)this.rr.hNK.hNQ;
    paramString2.iHA = paramString1;
    paramString2.dvs = this.iHB;
    paramString2.dpf = paramString3;
    AppMethodBeat.o(151199);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151200);
    this.callback = paramf;
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
    ad.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iHA });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151201);
      return;
    }
    paramq = (bfd)this.rr.hNL.hNQ;
    this.iHC = paramq.GBa;
    this.ret = s.a(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */