package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evv;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n
  extends p
  implements m
{
  private h callback;
  private String hAB;
  private int scene;
  private c vCm;
  private long vCo;
  public evw vCp;
  
  public n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.hAB = paramString;
    this.vCo = paramLong;
    this.scene = paramInt;
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5592);
    Log.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramh;
    if (!Util.isNullOrNil(this.hAB))
    {
      paramh = new c.a();
      paramh.funcId = 1070;
      paramh.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramh.otE = new evv();
      paramh.otF = new evw();
      paramh.otG = 0;
      paramh.respCmdId = 0;
      this.vCm = paramh.bEF();
      paramh = (evv)c.b.b(this.vCm.otB);
      paramh.aaqW = this.hAB;
      paramh.aaLr = f.dch();
      paramh.YYo = this.vCo;
      paramh.abyb = this.scene;
      Log.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.vCo) });
      int i = dispatch(paramg, this.vCm, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.vCm != null)) {
      this.vCp = ((evw)c.c.b(this.vCm.otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.n
 * JD-Core Version:    0.7.0.1
 */