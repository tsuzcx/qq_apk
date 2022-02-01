package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  public int status;
  
  public d(String paramString1, String paramString2, p paramp)
  {
    AppMethodBeat.i(20774);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new clo();
    ((b.a)localObject).hvu = new clp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((b.a)localObject).funcId = 582;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!bs.isNullOrNil(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (bs.isNullOrNil(paramString2)) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ac.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.rr = ((b.a)localObject).aAz();
      localObject = (clo)this.rr.hvr.hvw;
      ((clo)localObject).DTI = new SKBuiltinBuffer_t().setBuffer(bs.aLu(paramString1));
      ((clo)localObject).Fza = new SKBuiltinBuffer_t().setBuffer(bs.aLu(paramString2));
      ((clo)localObject).qq = paramp.intValue();
      AppMethodBeat.o(20774);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(20776);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20776);
    return i;
  }
  
  public final int getType()
  {
    return 582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20775);
    ac.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (clp)((b)paramq).hvs.hvw;
      this.status = paramq.Fzb;
      ac.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((paramq.FyZ.Fzc != null) && (this.status == 0))
      {
        ac.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.FyZ.Fzc.size());
        a.aRF();
        a.aRH().t(paramq.FyZ.Fzc);
        a.aRF();
        a.aRH().aRJ();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */