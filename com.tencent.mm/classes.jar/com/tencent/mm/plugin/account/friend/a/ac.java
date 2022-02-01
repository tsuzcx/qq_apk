package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctl;
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
    locala.iLN = new cth();
    locala.iLO = new cti();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.funcId = 135;
    locala.iLP = 23;
    locala.respCmdId = 1000000023;
    this.rr = locala.aXF();
    ((cth)this.rr.iLK.iLR).Mjk = paramInt;
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
    params = (cti)this.rr.iLL.iLR;
    Log.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + params.xMV.size() + " group:" + params.GroupList.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < params.Myh)
    {
      if (!paramArrayOfByte.contains(((ctl)params.xMV.get(paramInt1)).UserName))
      {
        localLinkedList.add(params.xMV.get(paramInt1));
        paramArrayOfByte.add(((ctl)params.xMV.get(paramInt1)).UserName);
      }
      paramInt1 += 1;
    }
    params.xMV = localLinkedList;
    params.Myh = localLinkedList.size();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */