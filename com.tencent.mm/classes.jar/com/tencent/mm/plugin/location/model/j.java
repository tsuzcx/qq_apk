package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public List<pw> tWZ;
  
  public j()
  {
    AppMethodBeat.i(55697);
    b.a locala = new b.a();
    locala.hvt = new bgz();
    locala.hvu = new bha();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getweapplistbylocation";
    locala.funcId = 1913;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tWZ = new ArrayList(8);
    AppMethodBeat.o(55697);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55698);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetWeappListByLocation", "onGYNetEnd errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bha)this.rr.hvs.hvw;
    if (paramq.EWd != null)
    {
      paramInt1 = paramq.EWd.size();
      ac.i("MicroMsg.NetSceneGetWeappListByLocation", "weapp list size: %s.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 > 8) {
        break label126;
      }
      this.tWZ.addAll(paramq.EWd);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(55699);
      return;
      label126:
      this.tWZ.addAll(paramq.EWd.subList(0, 8));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.j
 * JD-Core Version:    0.7.0.1
 */