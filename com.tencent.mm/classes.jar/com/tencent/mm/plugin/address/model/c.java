package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public c(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(16728);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new brk();
    ((b.a)localObject).fsY = new brl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
    ((b.a)localObject).funcId = 415;
    ((b.a)localObject).reqCmdId = 200;
    ((b.a)localObject).respCmdId = 1000000200;
    this.rr = ((b.a)localObject).ado();
    localObject = (brk)this.rr.fsV.fta;
    ((brk)localObject).xFe = new brp();
    ((brk)localObject).xFe.xFl = new bwc().aoF(bo.bf(paramb.gLf, ""));
    ((brk)localObject).xFe.xFj = new bwc().aoF(bo.bf(paramb.gLd, ""));
    ((brk)localObject).xFe.xFo = new bwc().aoF(bo.bf(paramb.gLi, ""));
    ((brk)localObject).xFe.xFm = new bwc().aoF(bo.bf(paramb.gLg, ""));
    ((brk)localObject).xFe.xFp = new bwc().aoF(bo.bf(paramb.gLj, ""));
    ((brk)localObject).xFe.xFq = new bwc().aoF(bo.bf(paramb.gLk, ""));
    ((brk)localObject).xFe.xFk = new bwc().aoF(bo.bf(paramb.gLe, ""));
    ((brk)localObject).xFe.xFn = new bwc().aoF(bo.bf(paramb.gLh, ""));
    ((brk)localObject).xFe.xFr = new bwc().aoF(bo.bf(paramb.gLl, ""));
    AppMethodBeat.o(16728);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16730);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16730);
    return i;
  }
  
  public final int getType()
  {
    return 415;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16729);
    ab.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (brl)((com.tencent.mm.ai.b)paramq).fsW.fta;
      if (paramq.xFf.xFi != null)
      {
        ab.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.xFf.xFi.size());
        a.asl();
        a.asn().s(paramq.xFf.xFi);
        a.asl();
        a.asn().asp();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.c
 * JD-Core Version:    0.7.0.1
 */