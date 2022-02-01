package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c oDw;
  
  public i(List<daw> paramList, long paramLong, day paramday)
  {
    AppMethodBeat.i(20540);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cff();
    ((c.a)localObject).otF = new cfg();
    ((c.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((c.a)localObject).funcId = 1708;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (cff)c.b.b(this.oDw.otB);
    ((cff)localObject).aaoO.addAll(paramList);
    ((cff)localObject).aaoR = paramLong;
    ((cff)localObject).aaoQ = paramday;
    Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((cff)localObject).aaoO.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20542);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
    Object localObject = (cff)c.b.b(this.oDw.otB);
    paramString = ((cff)localObject).aaoO;
    paramArrayOfByte = (daw)paramString.get(0);
    localObject = ((cff)localObject).aaoQ;
    params = (cfg)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (params.result != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.rid), Integer.valueOf(paramArrayOfByte.rie), String.valueOf(((day)localObject).latitude), String.valueOf(((day)localObject).longitude), Integer.valueOf(2), Integer.valueOf(params.result) });
      }
      Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.rid), Integer.valueOf(paramArrayOfByte.rie), String.valueOf(((day)localObject).latitude), String.valueOf(((day)localObject).longitude), Integer.valueOf(1), Integer.valueOf(params.result) });
    Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */