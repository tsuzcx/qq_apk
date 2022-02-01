package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class w
  extends n
  implements k
{
  private g callback;
  public String djF;
  private String errMsg;
  public dmj fsF;
  private final b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(197033);
    ac.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { bs.bG(paramString1, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((b.a)localObject).funcId = 3927;
    ((b.a)localObject).hvt = new dmi();
    ((b.a)localObject).hvu = new dmj();
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString1;
    localObject = (dmi)this.rr.hvr.hvw;
    ((dmi)localObject).djF = paramString1;
    ((dmi)localObject).ddJ = paramString2;
    ((dmi)localObject).scene = paramInt;
    AppMethodBeat.o(197033);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(182095);
    this.callback = paramg;
    this.fsF = ((dmj)this.rr.hvs.hvw);
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
    ac.d("MicroMsg.NetSceneUpgradeAssociateChatRoom", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */