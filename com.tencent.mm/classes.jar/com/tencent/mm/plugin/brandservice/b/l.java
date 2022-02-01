package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l
  extends q
  implements m
{
  private i callback;
  private String dDv;
  private String hes;
  private int offset;
  private d pnF;
  private drv pnG;
  private long pnH;
  private int scene;
  
  public l(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.dDv = paramString1;
    this.pnH = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.hes = paramString2;
    Log.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final ru clR()
  {
    if (this.pnG == null) {
      return null;
    }
    return this.pnG.MUt;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5589);
    this.callback = parami;
    if (!Util.isNullOrNil(this.dDv))
    {
      parami = new d.a();
      parami.funcId = 1071;
      parami.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      parami.iLN = new dru();
      parami.iLO = new drv();
      parami.iLP = 0;
      parami.respCmdId = 0;
      this.pnF = parami.aXF();
      parami = (dru)this.pnF.iLK.iLR;
      parami.MlQ = e.clJ();
      parami.LUZ = this.dDv;
      parami.KZg = this.pnH;
      parami.KZk = this.offset;
      parami.MUr = this.scene;
      parami.KZj = this.hes;
      int i = dispatch(paramg, this.pnF, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.pnF != null)) {
      this.pnG = ((drv)this.pnF.iLL.iLR);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */