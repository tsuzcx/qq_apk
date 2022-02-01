package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class l
  extends n
  implements k
{
  private f callback;
  private String dmf;
  private String kid;
  private b ocI;
  private cyy ocJ;
  private long ocK;
  private int offset;
  private int scene;
  
  public l(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.dmf = paramString1;
    this.ocK = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.kid = paramString2;
    ae.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final qt bOL()
  {
    if (this.ocJ == null) {
      return null;
    }
    return this.ocJ.HIY;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5589);
    this.callback = paramf;
    if (!bu.isNullOrNil(this.dmf))
    {
      paramf = new b.a();
      paramf.funcId = 1071;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramf.hQF = new cyx();
      paramf.hQG = new cyy();
      paramf.hQH = 0;
      paramf.respCmdId = 0;
      this.ocI = paramf.aDS();
      paramf = (cyx)this.ocI.hQD.hQJ;
      paramf.HkU = e.bOD();
      paramf.GQJ = this.dmf;
      paramf.GeP = this.ocK;
      paramf.GeT = this.offset;
      paramf.HIW = this.scene;
      paramf.GeS = this.kid;
      int i = dispatch(parame, this.ocI, this);
      AppMethodBeat.o(5589);
      return i;
    }
    ae.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
    AppMethodBeat.o(5589);
    return -1;
  }
  
  public final int getType()
  {
    return 1071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5588);
    ae.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.ocI != null)) {
      this.ocJ = ((cyy)this.ocI.hQE.hQJ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */