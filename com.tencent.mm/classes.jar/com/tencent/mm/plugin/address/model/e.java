package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private g callback;
  public boolean iYz;
  public String nickname;
  private b rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cls();
    ((b.a)localObject).hvu = new clt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).funcId = 417;
    ((b.a)localObject).reqCmdId = 202;
    ((b.a)localObject).respCmdId = 1000000202;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cls)this.rr.hvr.hvw;
    ((cls)localObject).oxC = 0;
    ((cls)localObject).Fzm = paramString1;
    ((cls)localObject).djj = paramString2;
    ((cls)localObject).scene = paramInt;
    AppMethodBeat.o(20777);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(20779);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20779);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(20778);
    ac.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (clt)((b)paramq).hvs.hvw;
      this.username = paramq.pIw;
      this.nickname = paramq.Fzp;
      if (paramq.Fzo != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.iYz = bool;
      if (paramq.FyZ.Fzc != null)
      {
        ac.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.FyZ.Fzc.size());
        a.aRF();
        a.aRH().t(paramq.FyZ.Fzc);
        a.aRF();
        a.aRH().aRJ();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20778);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */