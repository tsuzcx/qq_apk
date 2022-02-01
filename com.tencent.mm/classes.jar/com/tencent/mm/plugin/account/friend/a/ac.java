package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class ac
  extends n
  implements k
{
  private g callback;
  public final b rr;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(131102);
    b.a locala = new b.a();
    locala.gUU = new bsz();
    locala.gUV = new bta();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.reqCmdId = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.atI();
    ((bsz)this.rr.gUS.gUX).DFK = paramInt;
    AppMethodBeat.o(131102);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(131103);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131103);
    return i;
  }
  
  public final int getType()
  {
    return 135;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131104);
    paramq = (bta)this.rr.gUT.gUX;
    ad.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + paramq.sdt.size() + " group:" + paramq.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < paramq.DQa)
    {
      if (!paramArrayOfByte.contains(((btd)paramq.sdt.get(paramInt1)).mAQ))
      {
        localLinkedList.add(paramq.sdt.get(paramInt1));
        paramArrayOfByte.add(((btd)paramq.sdt.get(paramInt1)).mAQ);
      }
      paramInt1 += 1;
    }
    paramq.sdt = localLinkedList;
    paramq.DQa = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */