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
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class h
  extends m
  implements k
{
  private f callback;
  private com.tencent.mm.ai.b rr;
  
  public h(com.tencent.mm.plugin.address.d.b paramb)
  {
    AppMethodBeat.i(16743);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new brw();
    ((b.a)localObject).fsY = new brx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
    ((b.a)localObject).funcId = 418;
    ((b.a)localObject).reqCmdId = 203;
    ((b.a)localObject).respCmdId = 1000000203;
    this.rr = ((b.a)localObject).ado();
    localObject = (brw)this.rr.fsV.fta;
    ((brw)localObject).xFe = new brp();
    ((brw)localObject).xFe.id = paramb.id;
    ((brw)localObject).xFe.xFl = new bwc().aoF(bo.bf(paramb.gLf, ""));
    ((brw)localObject).xFe.xFj = new bwc().aoF(bo.bf(paramb.gLd, ""));
    ((brw)localObject).xFe.xFo = new bwc().aoF(bo.bf(paramb.gLi, ""));
    ((brw)localObject).xFe.xFm = new bwc().aoF(bo.bf(paramb.gLg, ""));
    ((brw)localObject).xFe.xFp = new bwc().aoF(bo.bf(paramb.gLj, ""));
    ((brw)localObject).xFe.xFq = new bwc().aoF(bo.bf(paramb.gLk, ""));
    ((brw)localObject).xFe.xFk = new bwc().aoF(bo.bf(paramb.gLe, ""));
    ((brw)localObject).xFe.xFn = new bwc().aoF(bo.bf(paramb.gLh, ""));
    ((brw)localObject).xFe.xFr = new bwc().aoF(bo.bf(paramb.gLl, ""));
    AppMethodBeat.o(16743);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16745);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16745);
    return i;
  }
  
  public final int getType()
  {
    return 418;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16744);
    ab.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (brx)((com.tencent.mm.ai.b)paramq).fsW.fta;
      if (paramq.xFf.xFi != null)
      {
        ab.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.xFf.xFi.size());
        a.asl();
        a.asn().s(paramq.xFf.xFi);
        a.asl();
        a.asn().asp();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.h
 * JD-Core Version:    0.7.0.1
 */