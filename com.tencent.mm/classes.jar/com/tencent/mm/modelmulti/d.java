package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private g callback;
  public final b hEg;
  
  public d(List<bks> paramList, long paramLong, bku parambku)
  {
    AppMethodBeat.i(20540);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ath();
    ((b.a)localObject).hvu = new ati();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).funcId = 1708;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (ath)this.hEg.hvr.hvw;
    ((ath)localObject).EMk.addAll(paramList);
    ((ath)localObject).EMn = paramLong;
    ((ath)localObject).EMm = parambku;
    ac.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((ath)localObject).EMk.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20542);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    Object localObject = (ath)this.hEg.hvr.hvw;
    paramString = ((ath)localObject).EMk;
    paramArrayOfByte = (bks)paramString.get(0);
    localObject = ((ath)localObject).EMm;
    paramq = (ati)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq.result != 0) {
        h.wUl.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bku)localObject).latitude), String.valueOf(((bku)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramq.result) });
      }
      ac.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    h.wUl.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bku)localObject).latitude), String.valueOf(((bku)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramq.result) });
    ac.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */