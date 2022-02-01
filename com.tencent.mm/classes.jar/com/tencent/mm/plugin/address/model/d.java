package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private f callback;
  private b rr;
  public int status;
  
  public d(String paramString1, String paramString2, p paramp)
  {
    AppMethodBeat.i(20774);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cri();
    ((b.a)localObject).hQG = new crj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((b.a)localObject).funcId = 582;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!bu.isNullOrNil(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (bu.isNullOrNil(paramString2)) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ae.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.rr = ((b.a)localObject).aDS();
      localObject = (cri)this.rr.hQD.hQJ;
      ((cri)localObject).FRA = new SKBuiltinBuffer_t().setBuffer(bu.aSx(paramString1));
      ((cri)localObject).HCF = new SKBuiltinBuffer_t().setBuffer(bu.aSx(paramString2));
      ((cri)localObject).qq = paramp.intValue();
      AppMethodBeat.o(20774);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20776);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crj)((b)paramq).hQE.hQJ;
      this.status = paramq.HCG;
      ae.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((paramq.HCE.HCH != null) && (this.status == 0))
      {
        ae.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */