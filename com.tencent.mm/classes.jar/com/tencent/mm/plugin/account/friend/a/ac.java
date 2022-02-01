package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class ac
  extends q
  implements m
{
  private i callback;
  public final d rr;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(131102);
    d.a locala = new d.a();
    locala.lBU = new dcg();
    locala.lBV = new dch();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.lBW = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.bgN();
    ((dcg)d.b.b(this.rr.lBR)).TtY = paramInt;
    AppMethodBeat.o(131102);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131103);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131103);
    return i;
  }
  
  public final int getType()
  {
    return 135;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131104);
    params = (dch)d.c.b(this.rr.lBS);
    Log.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + params.CRe.size() + " group:" + params.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < params.TJI)
    {
      if (!paramArrayOfByte.contains(((dck)params.CRe.get(paramInt1)).UserName))
      {
        localLinkedList.add(params.CRe.get(paramInt1));
        paramArrayOfByte.add(((dck)params.CRe.get(paramInt1)).UserName);
      }
      paramInt1 += 1;
    }
    params.CRe = localLinkedList;
    params.TJI = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */