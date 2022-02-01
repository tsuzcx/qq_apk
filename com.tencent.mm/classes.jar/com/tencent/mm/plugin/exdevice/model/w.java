package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.czs;

public final class w
  extends n
  implements k
{
  public com.tencent.mm.al.b grW;
  private com.tencent.mm.al.f gzH;
  String qcZ;
  
  public w(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23416);
    this.grW = null;
    this.gzH = null;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[] { paramString1, paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    this.qcZ = paramString2;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new czr();
    ((b.a)localObject).hNN = new czs();
    ((b.a)localObject).funcId = 538;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (czr)this.grW.hNK.hNQ;
    bnj localbnj = new bnj();
    localbnj.FzJ = paramString1;
    localbnj.nDr = paramString2;
    ((czr)localObject).FDx = localbnj;
    paramString1 = new bnn();
    paramString1.GHN = paramLong2;
    paramString1.CreateTime = ((int)paramLong3);
    paramString1.FAN = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    paramString1.nEf = paramInt;
    ((czr)localObject).Hqp = paramString1;
    if (paramLong1 != 0L)
    {
      ((czr)localObject).GHI = new SKBuiltinBuffer_t().setBuffer(u.clU().u(paramLong1, 2));
      AppMethodBeat.o(23416);
      return;
    }
    paramString1 = ad.clt().acJ(paramString2);
    if (paramString1 != null) {
      ((czr)localObject).GHI = new SKBuiltinBuffer_t().setBuffer(paramString1.field_sessionBuf);
    }
    AppMethodBeat.o(23416);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(23418);
    this.gzH = paramf;
    int i = dispatch(parame, this.grW, this);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.w
 * JD-Core Version:    0.7.0.1
 */