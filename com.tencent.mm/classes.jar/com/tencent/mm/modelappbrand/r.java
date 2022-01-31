package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  private f eGj;
  private com.tencent.mm.ai.b fpW;
  private cwa fpZ;
  
  public r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93740);
    this.DK = paramString;
    this.mScene = paramInt1;
    this.uIB = paramInt2;
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.NetSceneWeAppSuggest", "Constructors: query = %s", new Object[] { paramString });
      Object localObject = new b.a();
      ((b.a)localObject).funcId = getType();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchsuggestion";
      ((b.a)localObject).fsX = new cvz();
      ((b.a)localObject).fsY = new cwa();
      this.fpW = ((b.a)localObject).ado();
      localObject = (cvz)this.fpW.fsV.fta;
      ((cvz)localObject).query = paramString;
      paramString = new ih();
      a.ymk.l(paramString);
      ((cvz)localObject).xpF = paramString.cxG.cxH;
      paramString = g.RL().Ru().get(ac.a.yEW, null);
      if ((paramString != null) && ((paramString instanceof String))) {
        ((cvz)localObject).yer = ((String)paramString);
      }
      ((cvz)localObject).xpJ = b.fpQ;
      ((cvz)localObject).yem = b.fpR;
      AppMethodBeat.o(93740);
      return;
    }
    ab.e("MicroMsg.NetSceneWeAppSuggest", "keyword is unavailable");
    AppMethodBeat.o(93740);
  }
  
  public final String act()
  {
    if (this.fpZ != null) {
      return this.fpZ.wAa;
    }
    return "";
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(93742);
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(93742);
    return i;
  }
  
  public final int getType()
  {
    return 1173;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93741);
    ab.i("MicroMsg.NetSceneWeAppSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(93741);
      return;
    }
    this.fpZ = ((cwa)this.fpW.fsW.fta);
    if (this.fpZ != null) {
      ab.v("MicroMsg.NetSceneWeAppSuggest", "return data\n%s", new Object[] { this.fpZ.wAa });
    }
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(93741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */