package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class ad
  extends m
  implements k
{
  f callback;
  public final q ftU;
  
  public ad(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(108457);
    this.callback = null;
    this.ftU = new ad.a();
    t.a locala = (t.a)this.ftU.getReqObj();
    locala.gxK.xfF = paramString1;
    locala.gxK.xfG = paramString2;
    locala.gxK.jKG = paramString3;
    locala.gxK.xfH = paramString4;
    locala.gxK.xfI = paramString5;
    locala.gxK.xfJ = paramString6;
    locala.gxK.xfK = paramInt;
    locala.gxK.lGH = com.tencent.mm.sdk.platformtools.aa.dsG();
    paramString1 = locala.gxK;
    g.RJ();
    paramString1.wsp = a.QX();
    AppMethodBeat.o(108457);
  }
  
  public final String ajG()
  {
    AppMethodBeat.i(108461);
    String str = ((t.b)this.ftU.getRespObj()).gxL.xfI;
    AppMethodBeat.o(108461);
    return str;
  }
  
  public final byte[] ajH()
  {
    AppMethodBeat.i(108460);
    byte[] arrayOfByte = com.tencent.mm.platformtools.aa.a(((t.b)this.ftU.getRespObj()).gxL.xfL, new byte[0]);
    AppMethodBeat.o(108460);
    return arrayOfByte;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108458);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(108458);
    return i;
  }
  
  public final int getType()
  {
    return 429;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108459);
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ab.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      g.RO().ac(new ad.1(this, paramInt1));
      AppMethodBeat.o(108459);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108459);
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad
 * JD-Core Version:    0.7.0.1
 */