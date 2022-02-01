package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dsy;
import com.tencent.mm.protocal.protobuf.dsz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;

public final class x
  extends n
  implements k
{
  private f callback;
  public String chatroomName;
  public String fMT;
  public String fNk;
  public int fNl;
  public int maxCount;
  private final b rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(12498);
    this.callback = null;
    this.chatroomName = null;
    this.fMT = null;
    this.fNk = null;
    this.maxCount = 0;
    this.fNl = 0;
    b.a locala = new b.a();
    locala.hQF = new dsy();
    locala.hQG = new dsz();
    locala.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
    locala.funcId = 482;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.chatroomName = paramString;
    ((dsy)this.rr.hQD.hQJ).FNj = paramString;
    AppMethodBeat.o(12498);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12499);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12499);
    return i;
  }
  
  public final int getType()
  {
    return 482;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12500);
    dsz localdsz = (dsz)this.rr.hQE.hQJ;
    ae.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.fNk = localdsz.HnR;
    if (!bu.isNullOrNil(this.fNk))
    {
      paramArrayOfByte = ((c)g.ab(c.class)).azP().Bx(this.chatroomName);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = new ac();
      }
      paramq.mc(v.aAC(), this.fNk);
      r.a(paramq);
    }
    this.fMT = localdsz.GPY;
    this.maxCount = localdsz.GPX;
    this.fNl = localdsz.GPZ;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */