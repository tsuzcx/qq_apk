package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private final String gfK;
  private final b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78868);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bvs();
    ((b.a)localObject).fsY = new bvt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((b.a)localObject).funcId = 772;
    this.rr = ((b.a)localObject).ado();
    this.gfK = paramString1;
    localObject = (bvs)this.rr.fsV.fta;
    ((bvs)localObject).gfK = paramString1;
    ((bvs)localObject).cAV = paramString2;
    ab.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78868);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78870);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78870);
    return i;
  }
  
  public final int getType()
  {
    return 772;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78869);
    ab.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.m
 * JD-Core Version:    0.7.0.1
 */