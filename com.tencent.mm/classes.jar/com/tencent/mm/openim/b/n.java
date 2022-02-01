package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private String hNN;
  public cny hNO;
  public String hNP;
  private final b rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cnz();
    ((b.a)localObject).gUV = new coa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).funcId = 372;
    this.rr = ((b.a)localObject).atI();
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.hNN });
    localObject = (cnz)this.rr.gUS.gUX;
    ((cnz)localObject).Eig = "";
    ((cnz)localObject).dpO = paramString;
    ((cnz)localObject).Eih = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.hNN = paramString;
    b.a locala = new b.a();
    locala.gUU = new cnz();
    locala.gUV = new coa();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.atI();
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((cnz)this.rr.gUS.gUX).Eig = paramString;
    AppMethodBeat.o(151216);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151217);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151217);
    return i;
  }
  
  public final int getType()
  {
    return 372;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151218);
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.hNP = ((coa)this.rr.gUT.gUX).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.hNO = ((coa)this.rr.gUT.gUX).Eii;
    paramq = new i();
    paramq.username = this.hNO.mAQ;
    paramq.gUg = this.hNO.CVv;
    paramq.gUf = this.hNO.CVw;
    paramq.dtM = -1;
    ad.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.aux(), paramq.auy() });
    paramq.evo = 3;
    paramq.ee(true);
    p.auF().b(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */