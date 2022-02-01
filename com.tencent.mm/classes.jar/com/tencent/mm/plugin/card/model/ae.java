package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ae
  extends q
  implements m
{
  private i callback;
  public dgv pUr;
  private final d rr;
  
  public ae(LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(112849);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bmn();
    ((d.a)localObject).iLO = new bmo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
    ((d.a)localObject).funcId = 1382;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bmn)this.rr.iLK.iLR;
    ((bmn)localObject).LVo = paramLinkedList;
    ((bmn)localObject).scene = paramInt;
    AppMethodBeat.o(112849);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112851);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112851);
    return i;
  }
  
  public final int getType()
  {
    return 1382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112850);
    Log.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.pUr = ((bmo)this.rr.iLL.iLR).LVp;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ae
 * JD-Core Version:    0.7.0.1
 */