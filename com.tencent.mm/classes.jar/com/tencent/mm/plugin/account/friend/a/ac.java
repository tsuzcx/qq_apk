package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class ac
  extends n
  implements k
{
  private f callback;
  public final b rr;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(131102);
    b.a locala = new b.a();
    locala.hQF = new cdb();
    locala.hQG = new cdc();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.hQH = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.aDS();
    ((cdb)this.rr.hQD.hQJ).Hee = paramInt;
    AppMethodBeat.o(131102);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131103);
    this.callback = paramf;
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
    paramq = (cdc)this.rr.hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + paramq.uuU.size() + " group:" + paramq.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < paramq.HpA)
    {
      if (!paramArrayOfByte.contains(((cdf)paramq.uuU.get(paramInt1)).nIJ))
      {
        localLinkedList.add(paramq.uuU.get(paramInt1));
        paramArrayOfByte.add(((cdf)paramq.uuU.get(paramInt1)).nIJ);
      }
      paramInt1 += 1;
    }
    paramq.uuU = localLinkedList;
    paramq.HpA = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */