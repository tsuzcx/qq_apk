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
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.ak.b rr;
  
  public h(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(20786);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cly();
    ((b.a)localObject).hvu = new clz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((b.a)localObject).funcId = 418;
    ((b.a)localObject).reqCmdId = 203;
    ((b.a)localObject).respCmdId = 1000000203;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cly)this.rr.hvr.hvw;
    ((cly)localObject).FyY = new clr();
    ((cly)localObject).FyY.id = paramb.id;
    ((cly)localObject).FyY.Fzf = new crm().aJV(bs.bG(paramb.iYS, ""));
    ((cly)localObject).FyY.Fzd = new crm().aJV(bs.bG(paramb.iYQ, ""));
    ((cly)localObject).FyY.Fzi = new crm().aJV(bs.bG(paramb.iYV, ""));
    ((cly)localObject).FyY.Fzg = new crm().aJV(bs.bG(paramb.iYT, ""));
    ((cly)localObject).FyY.Fzj = new crm().aJV(bs.bG(paramb.iYW, ""));
    ((cly)localObject).FyY.Fzk = new crm().aJV(bs.bG(paramb.iYX, ""));
    ((cly)localObject).FyY.Fze = new crm().aJV(bs.bG(paramb.iYR, ""));
    ((cly)localObject).FyY.Fzh = new crm().aJV(bs.bG(paramb.iYU, ""));
    ((cly)localObject).FyY.Fzl = new crm().aJV(bs.bG(paramb.iYY, ""));
    AppMethodBeat.o(20786);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20788);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20788);
    return i;
  }
  
  public final int getType()
  {
    return 418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20787);
    ac.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (clz)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      if (paramq.FyZ.Fzc != null)
      {
        ac.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.FyZ.Fzc.size());
        a.aRF();
        a.aRH().t(paramq.FyZ.Fzc);
        a.aRF();
        a.aRH().aRJ();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */