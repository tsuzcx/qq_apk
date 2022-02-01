package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private String ioj;
  public ctf iok;
  public String iol;
  private final b rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ctg();
    ((b.a)localObject).hvu = new cth();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).funcId = 372;
    this.rr = ((b.a)localObject).aAz();
    ac.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.ioj });
    localObject = (ctg)this.rr.hvr.hvw;
    ((ctg)localObject).FFe = "";
    ((ctg)localObject).dnz = paramString;
    ((ctg)localObject).FFf = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.ioj = paramString;
    b.a locala = new b.a();
    locala.hvt = new ctg();
    locala.hvu = new cth();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((ctg)this.rr.hvr.hvw).FFe = paramString;
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
    ac.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.iol = ((cth)this.rr.hvs.hvw).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.iok = ((cth)this.rr.hvs.hvw).FFg;
    paramq = new i();
    paramq.username = this.iok.ncR;
    paramq.huF = this.iok.Eof;
    paramq.huE = this.iok.Eog;
    paramq.drx = -1;
    ac.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.aBo(), paramq.aBp() });
    paramq.exK = 3;
    paramq.ez(true);
    p.aBw().b(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */