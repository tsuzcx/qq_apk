package com.tencent.mm.plugin.address.model;

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
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private g callback;
  public int iYA;
  private b rr;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(20780);
    this.iYA = 0;
    b.a locala = new b.a();
    locala.hvt = new clu();
    locala.hvu = new clv();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
    locala.funcId = 416;
    locala.reqCmdId = 201;
    locala.respCmdId = 1000000201;
    this.rr = locala.aAz();
    this.iYA = paramInt;
    ac.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(paramInt)));
    ((clu)this.rr.hvr.hvw).id = paramInt;
    AppMethodBeat.o(20780);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20782);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (clv)((b)paramq).hvs.hvw;
      if (paramq.FyZ.Fzc != null)
      {
        ac.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.FyZ.Fzc.size());
        a.aRF();
        a.aRH().t(paramq.FyZ.Fzc);
        a.aRF();
        a.aRH().aRJ();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.f
 * JD-Core Version:    0.7.0.1
 */