package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  public czj iKA;
  public String iKB;
  private String iKz;
  private final b rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new czk();
    ((b.a)localObject).hQG = new czl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).funcId = 372;
    this.rr = ((b.a)localObject).aDS();
    ae.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.iKz });
    localObject = (czk)this.rr.hQD.hQJ;
    ((czk)localObject).HJf = "";
    ((czk)localObject).dAs = paramString;
    ((czk)localObject).HJg = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.iKz = paramString;
    b.a locala = new b.a();
    locala.hQF = new czk();
    locala.hQG = new czl();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((czk)this.rr.hQD.hQJ).HJf = paramString;
    AppMethodBeat.o(151216);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151217);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.iKB = ((czl)this.rr.hQE.hQJ).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.iKA = ((czl)this.rr.hQE.hQJ).HJh;
    paramq = new i();
    paramq.username = this.iKA.nIJ;
    paramq.hPQ = this.iKA.GnN;
    paramq.hPP = this.iKA.GnO;
    paramq.dEu = -1;
    ae.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.aEG(), paramq.aEH() });
    paramq.eQU = 3;
    paramq.eD(true);
    p.aEN().b(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */