package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  extends q
  implements m
{
  private i callback;
  private String fwe;
  private int scene;
  private d swF;
  private long swH;
  public ecf swI;
  
  public n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.fwe = paramString;
    this.swH = paramLong;
    this.scene = paramInt;
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5592);
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = parami;
    if (!Util.isNullOrNil(this.fwe))
    {
      parami = new d.a();
      parami.funcId = 1070;
      parami.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      parami.lBU = new ece();
      parami.lBV = new ecf();
      parami.lBW = 0;
      parami.respCmdId = 0;
      this.swF = parami.bgN();
      parami = (ece)d.b.b(this.swF.lBR);
      parami.TdI = this.fwe;
      parami.TwK = f.czn();
      parami.Sap = this.swH;
      parami.UgA = this.scene;
      Log.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.swH) });
      int i = dispatch(paramg, this.swF, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.swF != null)) {
      this.swI = ((ecf)d.c.b(this.swF.lBS));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.n
 * JD-Core Version:    0.7.0.1
 */