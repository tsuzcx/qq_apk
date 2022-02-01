package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private String fwe;
  private String jQi;
  private int offset;
  private int scene;
  private d swF;
  private ebr swG;
  private long swH;
  
  public m(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.fwe = paramString1;
    this.swH = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.jQi = paramString2;
    Log.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final rn czv()
  {
    if (this.swG == null) {
      return null;
    }
    return this.swG.UgC;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5589);
    this.callback = parami;
    if (!Util.isNullOrNil(this.fwe))
    {
      parami = new d.a();
      parami.funcId = 1071;
      parami.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      parami.lBU = new ebq();
      parami.lBV = new ebr();
      parami.lBW = 0;
      parami.respCmdId = 0;
      this.swF = parami.bgN();
      parami = (ebq)d.b.b(this.swF.lBR);
      parami.TwK = f.czn();
      parami.TdI = this.fwe;
      parami.Sap = this.swH;
      parami.Sat = this.offset;
      parami.UgA = this.scene;
      parami.Sas = this.jQi;
      int i = dispatch(paramg, this.swF, this);
      AppMethodBeat.o(5589);
      return i;
    }
    Log.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
    AppMethodBeat.o(5589);
    return -1;
  }
  
  public final int getType()
  {
    return 1071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5588);
    Log.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.swF != null)) {
      this.swG = ((ebr)d.c.b(this.swF.lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.m
 * JD-Core Version:    0.7.0.1
 */