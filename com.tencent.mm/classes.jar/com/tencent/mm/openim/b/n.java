package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.sdk.platformtools.ad;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private String iHG;
  public cyp iHH;
  public String iHI;
  private final b rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cyq();
    ((b.a)localObject).hNN = new cyr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).funcId = 372;
    this.rr = ((b.a)localObject).aDC();
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.iHG });
    localObject = (cyq)this.rr.hNK.hNQ;
    ((cyq)localObject).HpD = "";
    ((cyq)localObject).dzn = paramString;
    ((cyq)localObject).HpE = 1;
    AppMethodBeat.o(151215);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(151216);
    this.iHG = paramString;
    b.a locala = new b.a();
    locala.hNM = new cyq();
    locala.hNN = new cyr();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((cyq)this.rr.hNK.hNQ).HpD = paramString;
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
    ad.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.iHI = ((cyr)this.rr.hNL.hNQ).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.iHH = ((cyr)this.rr.hNL.hNQ).HpF;
    paramq = new i();
    paramq.username = this.iHH.nDo;
    paramq.hMX = this.iHH.FVo;
    paramq.hMW = this.iHH.FVp;
    paramq.dDp = -1;
    ad.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.aEq(), paramq.aEr() });
    paramq.ePj = 3;
    paramq.eB(true);
    p.aEx().b(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */