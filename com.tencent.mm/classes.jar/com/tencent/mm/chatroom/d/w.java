package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.dsa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class w
  extends n
  implements k
{
  private f callback;
  public String dvs;
  private String errMsg;
  public dsa fLf;
  private final b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213405);
    ad.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { bt.bI(paramString1, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((b.a)localObject).funcId = 3927;
    ((b.a)localObject).hNM = new drz();
    ((b.a)localObject).hNN = new dsa();
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString1;
    localObject = (drz)this.rr.hNK.hNQ;
    ((drz)localObject).dvs = paramString1;
    ((drz)localObject).dpf = paramString2;
    ((drz)localObject).scene = paramInt;
    AppMethodBeat.o(213405);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182095);
    this.callback = paramf;
    this.fLf = ((dsa)this.rr.hNL.hNQ);
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