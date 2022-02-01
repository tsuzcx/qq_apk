package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bli;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public List<rb> uZI;
  
  public j()
  {
    AppMethodBeat.i(55697);
    b.a locala = new b.a();
    locala.hNM = new blh();
    locala.hNN = new bli();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweapplistbylocation";
    locala.funcId = 1913;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uZI = new ArrayList(8);
    AppMethodBeat.o(55697);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55698);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55698);
    return i;
  }
  
  public final int getType()
  {
    return 1913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55699);
    ad.i("MicroMsg.NetSceneGetWeappListByLocation", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bli)this.rr.hNL.hNQ;
    if (paramq.GFA != null)
    {
      paramInt1 = paramq.GFA.size();
      ad.i("MicroMsg.NetSceneGetWeappListByLocation", "weapp list size: %s.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 > 8) {
        break label126;
      }
      this.uZI.addAll(paramq.GFA);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55699);
      return;
      label126:
      this.uZI.addAll(paramq.GFA.subList(0, 8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */