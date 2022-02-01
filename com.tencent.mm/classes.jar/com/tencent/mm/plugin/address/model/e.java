package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private g callback;
  public boolean iyw;
  public String nickname;
  private b rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cgp();
    ((b.a)localObject).gUV = new cgq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).funcId = 417;
    ((b.a)localObject).reqCmdId = 202;
    ((b.a)localObject).respCmdId = 1000000202;
    this.rr = ((b.a)localObject).atI();
    localObject = (cgp)this.rr.gUS.gUX;
    ((cgp)localObject).nUh = 0;
    ((cgp)localObject).Ecr = paramString1;
    ((cgp)localObject).dlB = paramString2;
    ((cgp)localObject).scene = paramInt;
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
    ad.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cgq)((b)paramq).gUT.gUX;
      this.username = paramq.pfl;
      this.nickname = paramq.Ecu;
      if (paramq.Ect != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.iyw = bool;
      if (paramq.Ece.Ech != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Ece.Ech.size());
        a.aKO();
        a.aKQ().t(paramq.Ece.Ech);
        a.aKO();
        a.aKQ().aKS();
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