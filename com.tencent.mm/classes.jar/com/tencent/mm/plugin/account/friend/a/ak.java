package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.protocal.protobuf.dts;
import java.util.LinkedList;

public final class ak
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public ak(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131136);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dtr();
    ((d.a)localObject).iLO = new dts();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((d.a)localObject).funcId = 116;
    ((d.a)localObject).iLP = 41;
    ((d.a)localObject).respCmdId = 1000000041;
    this.rr = ((d.a)localObject).aXF();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((dtr)this.rr.iLK.iLR).MVF = ((LinkedList)localObject);
    ((dtr)this.rr.iLK.iLR).MVE = ((LinkedList)localObject).size();
    AppMethodBeat.o(131136);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131137);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131137);
    return i;
  }
  
  public final int getType()
  {
    return 116;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131138);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ak
 * JD-Core Version:    0.7.0.1
 */