package com.tencent.mm.an;

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
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends p
  implements m
{
  private h callback;
  public String owR;
  public c rr;
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dff();
    ((c.a)localObject).otF = new dfg();
    ((c.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((c.a)localObject).funcId = 674;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dff)c.b.b(this.rr.otB);
    ((dff)localObject).aaLa = paramString1;
    ((dff)localObject).aaLb = paramString2;
    this.owR = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final dfg bHb()
  {
    AppMethodBeat.i(239446);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      dfg localdfg = (dfg)c.c.b(this.rr.otC);
      AppMethodBeat.o(239446);
      return localdfg;
    }
    AppMethodBeat.o(239446);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124137);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneKFGetBindList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124137);
    return i;
  }
  
  public final int getType()
  {
    return 674;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124136);
    Log.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.ab
 * JD-Core Version:    0.7.0.1
 */