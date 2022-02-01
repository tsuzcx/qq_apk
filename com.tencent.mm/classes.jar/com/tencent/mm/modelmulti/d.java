package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private g callback;
  public final b hdD;
  
  public d(List<bha> paramList, long paramLong, bhc parambhc)
  {
    AppMethodBeat.i(20540);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aqd();
    ((b.a)localObject).gUV = new aqe();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).funcId = 1708;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hdD = ((b.a)localObject).atI();
    localObject = (aqd)this.hdD.gUS.gUX;
    ((aqd)localObject).Dri.addAll(paramList);
    ((aqd)localObject).Drl = paramLong;
    ((aqd)localObject).Drk = parambhc;
    ad.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((aqd)localObject).Dri.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20542);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Object localObject = (aqd)this.hdD.gUS.gUX;
    paramString = ((aqd)localObject).Dri;
    paramArrayOfByte = (bha)paramString.get(0);
    localObject = ((aqd)localObject).Drk;
    paramq = (aqe)((b)paramq).gUT.gUX;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq.result != 0) {
        h.vKh.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bhc)localObject).latitude), String.valueOf(((bhc)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramq.result) });
      }
      ad.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    h.vKh.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bhc)localObject).latitude), String.valueOf(((bhc)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramq.result) });
    ad.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */