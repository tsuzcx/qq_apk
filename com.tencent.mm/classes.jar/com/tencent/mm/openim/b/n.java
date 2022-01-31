package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.sdk.platformtools.ab;

public final class n
  extends m
  implements k
{
  private f callback;
  private String gfR;
  public bxw gfS;
  public String gfT;
  private final b rr;
  
  public n(String paramString)
  {
    AppMethodBeat.i(78871);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bxx();
    ((b.a)localObject).fsY = new bxy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).funcId = 372;
    this.rr = ((b.a)localObject).ado();
    ab.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.gfR });
    localObject = (bxx)this.rr.fsV.fta;
    ((bxx)localObject).xKw = "";
    ((bxx)localObject).czF = paramString;
    ((bxx)localObject).xKx = 1;
    AppMethodBeat.o(78871);
  }
  
  public n(String paramString, byte paramByte)
  {
    AppMethodBeat.i(78872);
    this.gfR = paramString;
    b.a locala = new b.a();
    locala.fsX = new bxx();
    locala.fsY = new bxy();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.funcId = 372;
    this.rr = locala.ado();
    ab.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((bxx)this.rr.fsV.fta).xKw = paramString;
    AppMethodBeat.o(78872);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78873);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78873);
    return i;
  }
  
  public final int getType()
  {
    return 372;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78874);
    ab.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.gfT = ((bxy)this.rr.fsW.fta).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78874);
      return;
    }
    this.gfS = ((bxy)this.rr.fsW.fta).xKy;
    paramq = new h();
    paramq.username = this.gfS.jJA;
    paramq.fsl = this.gfS.wJq;
    paramq.fsk = this.gfS.wJr;
    paramq.bsY = -1;
    ab.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.acX(), paramq.acY() });
    paramq.dqB = 3;
    paramq.cM(true);
    o.adg().b(paramq);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */