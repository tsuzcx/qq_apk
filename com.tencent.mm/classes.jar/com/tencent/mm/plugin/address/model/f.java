package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public int juC;
  private b rr;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(20780);
    this.juC = 0;
    b.a locala = new b.a();
    locala.hQF = new cro();
    locala.hQG = new crp();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.funcId = 416;
    locala.hQH = 201;
    locala.respCmdId = 1000000201;
    this.rr = locala.aDS();
    this.juC = paramInt;
    ae.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(paramInt)));
    ((cro)this.rr.hQD.hQJ).id = paramInt;
    AppMethodBeat.o(20780);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(20782);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20782);
    return i;
  }
  
  public final int getType()
  {
    return 416;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20781);
    ae.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crp)((b)paramq).hQE.hQJ;
      if (paramq.HCE.HCH != null)
      {
        ae.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */