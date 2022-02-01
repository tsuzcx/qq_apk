package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends q
  implements m
{
  private i callback;
  public final com.tencent.mm.an.d lKU;
  
  public d(List<ckp> paramList, long paramLong, ckr paramckr)
  {
    AppMethodBeat.i(20540);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bqo();
    ((d.a)localObject).lBV = new bqp();
    ((d.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((d.a)localObject).funcId = 1708;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.lKU = ((d.a)localObject).bgN();
    localObject = (bqo)d.b.b(this.lKU.lBR);
    ((bqo)localObject).TbC.addAll(paramList);
    ((bqo)localObject).TbF = paramLong;
    ((bqo)localObject).TbE = paramckr;
    Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((bqo)localObject).TbC.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20542);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
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
    Object localObject = (bqo)d.b.b(this.lKU.lBR);
    paramString = ((bqo)localObject).TbC;
    paramArrayOfByte = (ckp)paramString.get(0);
    localObject = ((bqo)localObject).TbE;
    params = (bqp)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params.result != 0) {
        h.IzE.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.oey), Integer.valueOf(paramArrayOfByte.oez), String.valueOf(((ckr)localObject).latitude), String.valueOf(((ckr)localObject).longitude), Integer.valueOf(2), Integer.valueOf(params.result) });
      }
      Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    h.IzE.a(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.oey), Integer.valueOf(paramArrayOfByte.oez), String.valueOf(((ckr)localObject).latitude), String.valueOf(((ckr)localObject).longitude), Integer.valueOf(1), Integer.valueOf(params.result) });
    Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */