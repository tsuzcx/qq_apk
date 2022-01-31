package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class aa
  extends m
  implements k
{
  private f callback;
  public final b rr;
  
  public aa(int paramInt)
  {
    AppMethodBeat.i(108441);
    b.a locala = new b.a();
    locala.fsX = new bfy();
    locala.fsY = new bfz();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.reqCmdId = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.ado();
    ((bfy)this.rr.fsV.fta).xmj = paramInt;
    AppMethodBeat.o(108441);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108442);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108442);
    return i;
  }
  
  public final int getType()
  {
    return 135;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108443);
    paramq = (bfz)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + paramq.ntS.size() + " group:" + paramq.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < paramq.xuP)
    {
      if (!paramArrayOfByte.contains(((bgc)paramq.ntS.get(paramInt1)).jJA))
      {
        localLinkedList.add(paramq.ntS.get(paramInt1));
        paramArrayOfByte.add(((bgc)paramq.ntS.get(paramInt1)).jJA);
      }
      paramInt1 += 1;
    }
    paramq.ntS = localLinkedList;
    paramq.xuP = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aa
 * JD-Core Version:    0.7.0.1
 */