package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends q
  implements m
{
  private i callback;
  private final d iLF;
  
  public b(dns paramdns)
  {
    AppMethodBeat.i(9330);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dns();
    ((d.a)localObject).iLO = new dnt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((d.a)localObject).funcId = 809;
    this.iLF = ((d.a)localObject).aXF();
    localObject = (dns)this.iLF.iLK.iLR;
    ((dns)localObject).MQO = paramdns.MQO;
    ((dns)localObject).MQN = paramdns.MQN;
    ((dns)localObject).KTg = paramdns.KTg;
    ((dns)localObject).EmotionList.addAll(paramdns.EmotionList);
    ((dns)localObject).oUv = paramdns.oUv;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(9331);
    this.callback = parami;
    int i = dispatch(paramg, this.iLF, this);
    AppMethodBeat.o(9331);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9332);
    Log.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.b
 * JD-Core Version:    0.7.0.1
 */