package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends q
  implements m
{
  private i callback;
  public final com.tencent.mm.ak.d iUB;
  
  public d(List<ccm> paramList, long paramLong, cco paramcco)
  {
    AppMethodBeat.i(20540);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjf();
    ((d.a)localObject).iLO = new bjg();
    ((d.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((d.a)localObject).funcId = 1708;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (bjf)this.iUB.iLK.iLR;
    ((bjf)localObject).LSR.addAll(paramList);
    ((bjf)localObject).LSU = paramLong;
    ((bjf)localObject).LST = paramcco;
    Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((bjf)localObject).LSR.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20542);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(20542);
    return i;
  }
  
  public final int getType()
  {
    return 1708;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20541);
    Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Object localObject = (bjf)this.iUB.iLK.iLR;
    paramString = ((bjf)localObject).LSR;
    paramArrayOfByte = (ccm)paramString.get(0);
    localObject = ((bjf)localObject).LST;
    params = (bjg)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params.result != 0) {
        h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((cco)localObject).latitude), String.valueOf(((cco)localObject).longitude), Integer.valueOf(2), Integer.valueOf(params.result) });
      }
      Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    h.CyF.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((cco)localObject).latitude), String.valueOf(((cco)localObject).longitude), Integer.valueOf(1), Integer.valueOf(params.result) });
    Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */