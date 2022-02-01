package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    ((b.a)localObject).hNM = new cqo();
    ((b.a)localObject).hNN = new cqp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
    ((b.a)localObject).funcId = 582;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    StringBuilder localStringBuilder = new StringBuilder("a2key is ");
    if (!bt.isNullOrNil(paramString1))
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", newa2key is ");
      if (bt.isNullOrNil(paramString2)) {
        break label218;
      }
    }
    label218:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ad.d("MicroMsg.NetSceneRcptInfoImportYiXun", bool1);
      this.rr = ((b.a)localObject).aDC();
      localObject = (cqo)this.rr.hNK.hNQ;
      ((cqo)localObject).Fzc = new SKBuiltinBuffer_t().setBuffer(bt.aRa(paramString1));
      ((cqo)localObject).Hjf = new SKBuiltinBuffer_t().setBuffer(bt.aRa(paramString2));
      ((cqo)localObject).qq = paramp.intValue();
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
    ad.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cqp)((b)paramq).hNL.hNQ;
      this.status = paramq.Hjg;
      ad.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
      if ((paramq.Hje.Hjh != null) && (this.status == 0))
      {
        ad.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Hje.Hjh.size());
        a.aUR();
        a.aUT().t(paramq.Hje.Hjh);
        a.aUR();
        a.aUT().aUV();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.d
 * JD-Core Version:    0.7.0.1
 */