package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class w
  extends n
  implements k
{
  private g callback;
  public String dlX;
  private String errMsg;
  public dgu fpf;
  private final b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(196567);
    ad.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { bt.by(paramString1, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((b.a)localObject).funcId = 3927;
    ((b.a)localObject).gUU = new dgt();
    ((b.a)localObject).gUV = new dgu();
    this.rr = ((b.a)localObject).atI();
    this.dlX = paramString1;
    localObject = (dgt)this.rr.gUS.gUX;
    ((dgt)localObject).dlX = paramString1;
    ((dgt)localObject).dgo = paramString2;
    ((dgt)localObject).scene = paramInt;
    AppMethodBeat.o(196567);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182095);
    this.callback = paramg;
    this.fpf = ((dgu)this.rr.gUT.gUX);
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(182095);
    return i;
  }
  
  public final int getType()
  {
    return 3927;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182096);
    ad.d("MicroMsg.NetSceneUpgradeAssociateChatRoom", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */