package com.tencent.mm.al;

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
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends q
  implements m
{
  public String brandUsername;
  private i callback;
  public d rr;
  
  public ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124135);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cfo();
    ((d.a)localObject).iLO = new cfp();
    ((d.a)localObject).uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
    ((d.a)localObject).funcId = 674;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cfo)this.rr.iLK.iLR;
    ((cfo)localObject).MlA = paramString1;
    ((cfo)localObject).MlB = paramString2;
    this.brandUsername = paramString1;
    AppMethodBeat.o(124135);
  }
  
  public final cfp bac()
  {
    if ((this.rr != null) && (this.rr.iLL.iLR != null)) {
      return (cfp)this.rr.iLL.iLR;
    }
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
 * Qualified Name:     com.tencent.mm.al.ab
 * JD-Core Version:    0.7.0.1
 */