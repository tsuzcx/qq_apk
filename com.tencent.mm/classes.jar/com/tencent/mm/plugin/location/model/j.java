package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public List<rd> vlT;
  
  public j()
  {
    AppMethodBeat.i(55697);
    b.a locala = new b.a();
    locala.hQF = new blz();
    locala.hQG = new bma();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweapplistbylocation";
    locala.funcId = 1913;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.vlT = new ArrayList(8);
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
    ae.i("MicroMsg.NetSceneGetWeappListByLocation", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bma)this.rr.hQE.hQJ;
    if (paramq.GZc != null)
    {
      paramInt1 = paramq.GZc.size();
      ae.i("MicroMsg.NetSceneGetWeappListByLocation", "weapp list size: %s.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 > 8) {
        break label126;
      }
      this.vlT.addAll(paramq.GZc);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55699);
      return;
      label126:
      this.vlT.addAll(paramq.GZc.subList(0, 8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */