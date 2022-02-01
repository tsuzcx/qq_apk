package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20771);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new clm();
    ((b.a)localObject).hvu = new cln();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).funcId = 415;
    ((b.a)localObject).reqCmdId = 200;
    ((b.a)localObject).respCmdId = 1000000200;
    this.rr = ((b.a)localObject).aAz();
    localObject = (clm)this.rr.hvr.hvw;
    ((clm)localObject).FyY = new clr();
    ((clm)localObject).FyY.Fzf = new crm().aJV(bs.bG(paramb.iYS, ""));
    ((clm)localObject).FyY.Fzd = new crm().aJV(bs.bG(paramb.iYQ, ""));
    ((clm)localObject).FyY.Fzi = new crm().aJV(bs.bG(paramb.iYV, ""));
    ((clm)localObject).FyY.Fzg = new crm().aJV(bs.bG(paramb.iYT, ""));
    ((clm)localObject).FyY.Fzj = new crm().aJV(bs.bG(paramb.iYW, ""));
    ((clm)localObject).FyY.Fzk = new crm().aJV(bs.bG(paramb.iYX, ""));
    ((clm)localObject).FyY.Fze = new crm().aJV(bs.bG(paramb.iYR, ""));
    ((clm)localObject).FyY.Fzh = new crm().aJV(bs.bG(paramb.iYU, ""));
    ((clm)localObject).FyY.Fzl = new crm().aJV(bs.bG(paramb.iYY, ""));
    AppMethodBeat.o(20771);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20773);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20773);
    return i;
  }
  
  public final int getType()
  {
    return 415;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20772);
    ac.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cln)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      if (paramq.FyZ.Fzc != null)
      {
        ac.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.FyZ.Fzc.size());
        a.aRF();
        a.aRH().t(paramq.FyZ.Fzc);
        a.aRF();
        a.aRH().aRJ();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */