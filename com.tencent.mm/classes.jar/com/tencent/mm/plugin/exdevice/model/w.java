package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ae;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.ak.f gCo;
  public com.tencent.mm.ak.b gux;
  String qjE;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.gux = null;
    this.gCo = null;
    ae.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.qjE = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dal();
    ((b.a)localObject).hQG = new dam();
    ((b.a)localObject).funcId = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (dal)this.gux.hQD.hQJ;
    bob localbob = new bob();
    localbob.FSh = paramString1;
    localbob.nIM = paramString2;
    ((dal)localObject).FVS = localbob;
    paramString1 = new bof();
    paramString1.Hbp = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.FTj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.nJA = paramInt;
    ((dal)localObject).HJR = paramString1;
    if (paramLong1 != 0L)
    {
      ((dal)localObject).Hbk = new SKBuiltinBuffer_t().setBuffer(u.cnk().u(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ad.cmJ().adA(paramString2);
    if (paramString1 != null) {
      ((dal)localObject).Hbk = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(23418);
    this.gCo = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(23418);
    return i;
  }
  
  public final int getType()
  {
    return 538;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23417);
    ae.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */