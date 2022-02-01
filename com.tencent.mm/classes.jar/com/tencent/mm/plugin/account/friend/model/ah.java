package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exk;
import com.tencent.mm.protocal.protobuf.exl;
import java.util.LinkedList;

public final class ah
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public ah(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131136);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new exk();
    ((c.a)localObject).otF = new exl();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((c.a)localObject).funcId = 116;
    ((c.a)localObject).otG = 41;
    ((c.a)localObject).respCmdId = 1000000041;
    this.rr = ((c.a)localObject).bEF();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((exk)c.b.b(this.rr.otB)).abzo = ((LinkedList)localObject);
    ((exk)c.b.b(this.rr.otB)).abzn = ((LinkedList)localObject).size();
    AppMethodBeat.o(131136);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131137);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ah
 * JD-Core Version:    0.7.0.1
 */