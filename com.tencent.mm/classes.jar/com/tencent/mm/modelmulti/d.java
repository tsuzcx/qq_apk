package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private f callback;
  public final b hWL;
  
  public d(List<bpc> paramList, long paramLong, bpe parambpe)
  {
    AppMethodBeat.i(20540);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new axf();
    ((b.a)localObject).hNN = new axg();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
    ((b.a)localObject).funcId = 1708;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (axf)this.hWL.hNK.hNQ;
    ((axf)localObject).Gvo.addAll(paramList);
    ((axf)localObject).Gvr = paramLong;
    ((axf)localObject).Gvq = parambpe;
    ad.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[] { Integer.valueOf(((axf)localObject).Gvo.size()) });
    AppMethodBeat.o(20540);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20542);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
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
    Object localObject = (axf)this.hWL.hNK.hNQ;
    paramString = ((axf)localObject).Gvo;
    paramArrayOfByte = (bpc)paramString.get(0);
    localObject = ((axf)localObject).Gvq;
    paramq = (axg)((b)paramq).hNL.hNQ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      if (paramq.result != 0) {
        g.yhR.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bpe)localObject).latitude), String.valueOf(((bpe)localObject).longitude), Integer.valueOf(2), Integer.valueOf(paramq.result) });
      }
      ad.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
      AppMethodBeat.o(20541);
      return;
    }
    g.yhR.f(12659, new Object[] { Integer.valueOf(1), Integer.valueOf(paramString.size()), paramArrayOfByte.uuid, Integer.valueOf(paramArrayOfByte.major), Integer.valueOf(paramArrayOfByte.minor), String.valueOf(((bpe)localObject).latitude), String.valueOf(((bpe)localObject).longitude), Integer.valueOf(1), Integer.valueOf(paramq.result) });
    ad.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    AppMethodBeat.o(20541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */