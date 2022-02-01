package com.tencent.mm.bf;

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
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  String jil;
  private final d rr;
  
  public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(150874);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new duq();
    ((d.a)localObject).iLO = new dur();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/sensewhere";
    ((d.a)localObject).funcId = 752;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = new chk();
    ((chk)localObject).LuV = paramString2;
    ((chk)localObject).LuW = paramInt2;
    ((chk)localObject).LbD = paramFloat2;
    ((chk)localObject).LbC = paramFloat1;
    ((chk)localObject).LuU = paramString1;
    ((chk)localObject).LuT = paramInt1;
    paramString1 = (duq)this.rr.iLK.iLR;
    paramString1.LpL = ((chk)localObject);
    paramString1.MVW = paramInt3;
    paramString1.Scene = paramInt4;
    paramString1.iAc = paramString3;
    AppMethodBeat.o(150874);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150876);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150876);
    return i;
  }
  
  public final int getType()
  {
    return 752;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150875);
    Log.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.jil = ((dur)((d)params).iLL.iLR).iAc;
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150875);
      return;
      Log.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */