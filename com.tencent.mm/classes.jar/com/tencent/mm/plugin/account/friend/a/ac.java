package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxu;
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
    locala.hvt = new bxq();
    locala.hvu = new bxr();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.reqCmdId = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.aAz();
    ((bxq)this.rr.hvr.hvw).Fbe = paramInt;
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
    paramq = (bxr)this.rr.hvs.hvw;
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + paramq.tln.size() + " group:" + paramq.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < paramq.Fmr)
    {
      if (!paramArrayOfByte.contains(((bxu)paramq.tln.get(paramInt1)).ncR))
      {
        localLinkedList.add(paramq.tln.get(paramInt1));
        paramArrayOfByte.add(((bxu)paramq.tln.get(paramInt1)).ncR);
      }
      paramInt1 += 1;
    }
    paramq.tln = localLinkedList;
    paramq.Fmr = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */