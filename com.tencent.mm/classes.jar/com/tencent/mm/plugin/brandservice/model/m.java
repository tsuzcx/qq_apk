package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evh;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private String hAB;
  private String mpa;
  private int offset;
  private int scene;
  private c vCm;
  private evi vCn;
  private long vCo;
  
  public m(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.hAB = paramString1;
    this.vCo = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.mpa = paramString2;
    Log.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final sy dcn()
  {
    if (this.vCn == null) {
      return null;
    }
    return this.vCn.abyd;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5589);
    this.callback = paramh;
    if (!Util.isNullOrNil(this.hAB))
    {
      paramh = new c.a();
      paramh.funcId = 1071;
      paramh.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramh.otE = new evh();
      paramh.otF = new evi();
      paramh.otG = 0;
      paramh.respCmdId = 0;
      this.vCm = paramh.bEF();
      paramh = (evh)c.b.b(this.vCm.otB);
      paramh.aaLr = f.dch();
      paramh.aaqW = this.hAB;
      paramh.YYo = this.vCo;
      paramh.YYs = this.offset;
      paramh.abyb = this.scene;
      paramh.YYr = this.mpa;
      int i = dispatch(paramg, this.vCm, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.vCm != null)) {
      this.vCn = ((evi)c.c.b(this.vCm.otC));
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.m
 * JD-Core Version:    0.7.0.1
 */