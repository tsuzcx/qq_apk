package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class w
  extends n
  implements k
{
  private f callback;
  public String dwx;
  private String errMsg;
  public dsx fNj;
  private final b rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(217118);
    ae.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { bu.bI(paramString1, "") });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((b.a)localObject).funcId = 3927;
    ((b.a)localObject).hQF = new dsw();
    ((b.a)localObject).hQG = new dsx();
    this.rr = ((b.a)localObject).aDS();
    this.dwx = paramString1;
    localObject = (dsw)this.rr.hQD.hQJ;
    ((dsw)localObject).dwx = paramString1;
    ((dsw)localObject).dqk = paramString2;
    ((dsw)localObject).scene = paramInt;
    AppMethodBeat.o(217118);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(182095);
    this.callback = paramf;
    this.fNj = ((dsx)this.rr.hQE.hQJ);
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
    ae.d("MicroMsg.NetSceneUpgradeAssociateChatRoom", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */