package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Date;

public final class x
  extends q
  implements m
{
  private Object bnW;
  private i callback;
  public com.tencent.mm.an.d rr;
  
  public x(d paramd, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dqb();
    ((d.a)localObject).lBV = new dqc();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((d.a)localObject).funcId = 2805;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dqb)d.b.b(this.rr.lBR);
    ((dqb)localObject).TWP = 1;
    ((dqb)localObject).TWQ = paramd.field_wwCorpId;
    ((dqb)localObject).RUQ = paramd.field_wwUserVid;
    h.aHE();
    ((dqb)localObject).TWR = b.getUin();
    ((dqb)localObject).scene = paramInt2;
    ((dqb)localObject).fvK = paramInt1;
    ((dqb)localObject).HnP = 0L;
    ((dqb)localObject).TWS = new Date().getTime();
    ((dqb)localObject).platform = 1;
    ((dqb)localObject).TRa = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.RAD);
    this.bnW = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124125);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124125);
    return i;
  }
  
  public final int getType()
  {
    return 2805;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124124);
    Log.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.x
 * JD-Core Version:    0.7.0.1
 */