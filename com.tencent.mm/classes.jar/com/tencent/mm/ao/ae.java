package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public d rr;
  
  public ae(nw paramnw, Object paramObject)
  {
    AppMethodBeat.i(124146);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new efy();
    ((d.a)localObject).lBV = new efz();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((d.a)localObject).funcId = 1228;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (efy)d.b.b(this.rr.lBR);
    ((efy)localObject).TbW = paramnw;
    ((efy)localObject).mask = 17;
    ((efy)localObject).TbU = 1;
    this.bnW = paramObject;
    AppMethodBeat.o(124146);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(206123);
    h.aHF().kcd.a(1228, parami);
    AppMethodBeat.o(206123);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124148);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124148);
    return i;
  }
  
  public final int getType()
  {
    return 1228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124147);
    Log.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.ae
 * JD-Core Version:    0.7.0.1
 */