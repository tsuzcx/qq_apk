package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
  extends m
  implements k
{
  private f callback;
  public bof nPb;
  public bog nPc;
  private b rr;
  
  public i(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21860);
    this.rr = null;
    this.nPb = null;
    this.nPc = null;
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bof();
    ((b.a)localObject).fsY = new bog();
    ((b.a)localObject).funcId = 991;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pstninvite";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    long l = System.currentTimeMillis();
    int i = c.bKK();
    localObject = (bof)this.rr.fsV.fta;
    ((bof)localObject).num = r.Zn();
    ((bof)localObject).xCl = paramString2;
    ((bof)localObject).nul = paramString1;
    ((bof)localObject).xCk = paramInt1;
    ((bof)localObject).wLO = i;
    ((bof)localObject).xCt = 1;
    ((bof)localObject).xCj = l;
    ((bof)localObject).xCs = paramInt2;
    ((bof)localObject).xCu = paramInt3;
    this.nPb = ((bof)localObject);
    ab.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(21860);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21861);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21861);
    return i;
  }
  
  public final int getType()
  {
    return 991;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21862);
    ab.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPc = ((bog)((b)paramq).fsW.fta);
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(21862);
      return;
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.i
 * JD-Core Version:    0.7.0.1
 */