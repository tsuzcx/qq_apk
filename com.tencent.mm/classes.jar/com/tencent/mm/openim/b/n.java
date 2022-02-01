package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private String myj;
  public ecg myk;
  public String myl;
  private final d rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ech();
    ((d.a)localObject).lBV = new eci();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((d.a)localObject).funcId = 372;
    this.rr = ((d.a)localObject).bgN();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.myj });
    localObject = (ech)d.b.b(this.rr.lBR);
    ((ech)localObject).UgY = "";
    ((ech)localObject).fLC = paramString;
    ((ech)localObject).UgZ = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.myj = paramString;
    d.a locala = new d.a();
    locala.lBU = new ech();
    locala.lBV = new eci();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.bgN();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((ech)d.b.b(this.rr.lBR)).UgY = paramString;
    AppMethodBeat.o(151216);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151217);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151217);
    return i;
  }
  
  public final int getType()
  {
    return 372;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151218);
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.myl = ((eci)d.c.b(this.rr.lBS)).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.myk = ((eci)d.c.b(this.rr.lBS)).Uha;
    params = new j();
    params.username = this.myk.UserName;
    params.lBe = this.myk.SjI;
    params.lBd = this.myk.SjJ;
    params.cUP = -1;
    Log.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { params.getUsername(), params.bhH(), params.bhI() });
    params.hDc = 3;
    params.gg(true);
    com.tencent.mm.am.q.bhP().b(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */