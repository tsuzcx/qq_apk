package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private f callback;
  public boolean gKN;
  public String nickname;
  private b rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(16734);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new brq();
    ((b.a)localObject).fsY = new brr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).funcId = 417;
    ((b.a)localObject).reqCmdId = 202;
    ((b.a)localObject).respCmdId = 1000000202;
    this.rr = ((b.a)localObject).ado();
    localObject = (brq)this.rr.fsV.fta;
    ((brq)localObject).timestamp = 0;
    ((brq)localObject).xFs = paramString1;
    ((brq)localObject).cwc = paramString2;
    ((brq)localObject).scene = paramInt;
    AppMethodBeat.o(16734);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(16736);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16736);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(16735);
    ab.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (brr)((b)paramq).fsW.fta;
      this.username = paramq.lOy;
      this.nickname = paramq.xFv;
      if (paramq.xFu != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.gKN = bool;
      if (paramq.xFf.xFi != null)
      {
        ab.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.xFf.xFi.size());
        a.asl();
        a.asn().s(paramq.xFf.xFi);
        a.asl();
        a.asn().asp();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(16735);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */