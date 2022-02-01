package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class z
  extends p
  implements m
{
  private h callback;
  public final c rr;
  
  public z(int paramInt)
  {
    AppMethodBeat.i(131102);
    c.a locala = new c.a();
    locala.otE = new dty();
    locala.otF = new dtz();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.otG = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.bEF();
    ((dty)c.b.b(this.rr.otB)).aaIA = paramInt;
    AppMethodBeat.o(131102);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131103);
    this.callback = paramh;
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
    params = (dtz)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + params.ILu.size() + " group:" + params.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < params.aaZx)
    {
      if (!paramArrayOfByte.contains(((duc)params.ILu.get(paramInt1)).UserName))
      {
        localLinkedList.add((duc)params.ILu.get(paramInt1));
        paramArrayOfByte.add(((duc)params.ILu.get(paramInt1)).UserName);
      }
      paramInt1 += 1;
    }
    params.ILu = localLinkedList;
    params.aaZx = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.z
 * JD-Core Version:    0.7.0.1
 */