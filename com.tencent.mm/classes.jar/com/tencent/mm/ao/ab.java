package com.tencent.mm.ao;

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
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends q
  implements m
{
  private i callback;
  public String lFl;
  public d rr;
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new col();
    ((d.a)localObject).lBV = new com();
    ((d.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((d.a)localObject).funcId = 674;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (col)d.b.b(this.rr.lBR);
    ((col)localObject).Twt = paramString1;
    ((col)localObject).Twu = paramString2;
    this.lFl = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final com bjr()
  {
    AppMethodBeat.i(207736);
    if ((this.rr != null) && (d.c.b(this.rr.lBS) != null))
    {
      com localcom = (com)d.c.b(this.rr.lBS);
      AppMethodBeat.o(207736);
      return localcom;
    }
    AppMethodBeat.o(207736);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124137);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.ao.ab
 * JD-Core Version:    0.7.0.1
 */