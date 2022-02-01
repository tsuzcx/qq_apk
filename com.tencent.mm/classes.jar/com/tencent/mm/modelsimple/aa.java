package com.tencent.mm.modelsimple;

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
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.protocal.protobuf.fac;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa
  extends p
  implements m
{
  private h callback;
  public final c oDw;
  
  public aa(int paramInt, epi paramepi)
  {
    AppMethodBeat.i(20647);
    Log.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), paramepi.abtx, Integer.valueOf(paramepi.crm), Integer.valueOf(paramepi.vhJ), Integer.valueOf(paramepi.abmA) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fab();
    ((c.a)localObject).otF = new fac();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((c.a)localObject).funcId = 525;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (fab)c.b.b(this.oDw.otB);
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((fab)localObject).muC = i;
    ((fab)localObject).abAD = paramepi;
    AppMethodBeat.o(20647);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20648);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(20648);
    return i;
  }
  
  public final int getType()
  {
    return 525;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20649);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((fac)c.c.b(this.oDw.otC)).abtx });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20649);
      return;
      Log.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */