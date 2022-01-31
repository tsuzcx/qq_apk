package com.tencent.mm.plugin.appbrand.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Locale;

public final class b
  extends m
  implements k
{
  private f eGj;
  private com.tencent.mm.ai.b fpW;
  private cwc isj;
  
  public b()
  {
    AppMethodBeat.i(132309);
    b.a locala = new b.a();
    locala.fsX = new cwb();
    locala.fsY = new cwc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fpW = locala.ado();
    AppMethodBeat.o(132309);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(132310);
    ab.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(132310);
    return i;
  }
  
  public final int getType()
  {
    return 1170;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132311);
    ab.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.isj = ((cwc)this.fpW.fsW.fta);
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.isj.yes == null)
    {
      AppMethodBeat.o(132311);
      return;
    }
    paramString = g.RL().Ru();
    paramString.set(ac.a.yEU, Locale.getDefault().getLanguage());
    paramString.set(ac.a.yEV, this.isj.yes.nQe);
    paramString.set(ac.a.yEW, this.isj.yes.yer);
    paramString.set(ac.a.yEX, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(132311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.b
 * JD-Core Version:    0.7.0.1
 */