package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private String dDv;
  private d pnF;
  private long pnH;
  public dsj pnI;
  private int scene;
  
  public m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.dDv = paramString;
    this.pnH = paramLong;
    this.scene = paramInt;
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5592);
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = parami;
    if (!Util.isNullOrNil(this.dDv))
    {
      parami = new d.a();
      parami.funcId = 1070;
      parami.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      parami.iLN = new dsi();
      parami.iLO = new dsj();
      parami.iLP = 0;
      parami.respCmdId = 0;
      this.pnF = parami.aXF();
      parami = (dsi)this.pnF.iLK.iLR;
      parami.LUZ = this.dDv;
      parami.MlQ = e.clJ();
      parami.KZg = this.pnH;
      parami.MUr = this.scene;
      Log.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.pnH) });
      int i = dispatch(paramg, this.pnF, this);
      AppMethodBeat.o(5592);
      return i;
    }
    Log.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
    AppMethodBeat.o(5592);
    return -1;
  }
  
  public final int getType()
  {
    return 1070;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5591);
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.pnF != null)) {
      this.pnI = ((dsj)this.pnF.iLL.iLR);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.m
 * JD-Core Version:    0.7.0.1
 */