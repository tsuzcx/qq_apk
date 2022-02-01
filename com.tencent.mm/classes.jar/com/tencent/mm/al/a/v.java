package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124319);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dip();
    ((d.a)localObject).iLO = new diq();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
    ((d.a)localObject).funcId = 1358;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dip)this.rr.iLK.iLR;
    ((dip)localObject).KTt = paramString1;
    ((dip)localObject).KTl = paramString2;
    AppMethodBeat.o(124319);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124321);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124321);
    return i;
  }
  
  public final int getType()
  {
    return 1358;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124320);
    Log.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.a.v
 * JD-Core Version:    0.7.0.1
 */