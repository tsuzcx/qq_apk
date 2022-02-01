package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  public int dYx;
  public String ixZ;
  public String rCB;
  private d rr;
  
  public m(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23534);
    this.callback = null;
    this.rr = null;
    this.rCB = paramString3;
    this.ixZ = paramString2;
    this.dYx = paramInt;
    this.rCB = paramString3;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cic();
    ((d.a)localObject).iLO = new cid();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((d.a)localObject).funcId = 1041;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cic)this.rr.iLK.iLR;
    ((cic)localObject).rJH = paramString2;
    ((cic)localObject).username = paramString1;
    ((cic)localObject).dYx = paramInt;
    ((cic)localObject).ixr = paramString3;
    AppMethodBeat.o(23534);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23535);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23535);
    return i;
  }
  
  public final int getType()
  {
    return 1041;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23536);
    Log.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.m
 * JD-Core Version:    0.7.0.1
 */