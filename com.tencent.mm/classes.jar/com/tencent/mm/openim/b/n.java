package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private String jHf;
  public dsk jHg;
  public String jHh;
  private final d rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dsl();
    ((d.a)localObject).iLO = new dsm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((d.a)localObject).funcId = 372;
    this.rr = ((d.a)localObject).aXF();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.jHf });
    localObject = (dsl)this.rr.iLK.iLR;
    ((dsl)localObject).MUO = "";
    ((dsl)localObject).dSf = paramString;
    ((dsl)localObject).MUP = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.jHf = paramString;
    d.a locala = new d.a();
    locala.iLN = new dsl();
    locala.iLO = new dsm();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.aXF();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((dsl)this.rr.iLK.iLR).MUO = paramString;
    AppMethodBeat.o(151216);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
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
        this.jHh = ((dsm)this.rr.iLL.iLR).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.jHg = ((dsm)this.rr.iLL.iLR).MUQ;
    params = new com.tencent.mm.aj.i();
    params.username = this.jHg.UserName;
    params.iKX = this.jHg.Lir;
    params.iKW = this.jHg.Lis;
    params.cSx = -1;
    Log.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { params.getUsername(), params.aYt(), params.aYu() });
    params.fuz = 3;
    params.fv(true);
    p.aYB().b(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */