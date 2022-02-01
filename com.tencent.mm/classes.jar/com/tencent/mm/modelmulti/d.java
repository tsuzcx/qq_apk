package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private f callback;
  public final b hZD;
  
  public d(List<bpu> paramList, long paramLong, bpw parambpw)
  {
    AppMethodBeat.i(20540);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axv();
    ((b.a)localObject).hQG = new axw();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).funcId = 1708;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (axv)this.hZD.hQD.hQJ;
    ((axv)localObject).GON.addAll(paramList);
    ((axv)localObject).GOQ = paramLong;
    ((axv)localObject).GOP = parambpw;
    ae.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((axv)localObject).GON.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20542);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(20542);
    return i;
  }
  
  public final int getType()
  {
    return 1708;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20541);
    ae.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Object localObject = (axv)this.hZD.hQD.hQJ;
    paramString = ((axv)localObject).GON;
    paramArrayOfByte = (bpu)paramString.get(0);
    localObject = ((axv)localObject).GOP;
    paramq = (axw)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq.result != 0) {
        g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bpw)localObject).latitude), String.valueOf(((bpw)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramq.result) });
      }
      ae.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    g.yxI.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bpw)localObject).latitude), String.valueOf(((bpw)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramq.result) });
    ae.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */