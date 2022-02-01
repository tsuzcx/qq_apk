package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Date;

public final class x
  extends q
  implements m
{
  private i callback;
  private Object data;
  public com.tencent.mm.ak.d rr;
  
  public x(d paramd, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgh();
    ((d.a)localObject).iLO = new dgi();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((d.a)localObject).funcId = 2805;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dgh)this.rr.iLK.iLR;
    ((dgh)localObject).MKU = 1;
    ((dgh)localObject).MKV = paramd.field_wwCorpId;
    ((dgh)localObject).KTS = paramd.field_wwUserVid;
    com.tencent.mm.kernel.g.aAf();
    ((dgh)localObject).MKW = a.getUin();
    ((dgh)localObject).scene = paramInt2;
    ((dgh)localObject).dDe = paramInt1;
    ((dgh)localObject).Btv = 0L;
    ((dgh)localObject).MKX = new Date().getTime();
    ((dgh)localObject).platform = 1;
    ((dgh)localObject).MFo = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.KyO);
    this.data = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.x
 * JD-Core Version:    0.7.0.1
 */