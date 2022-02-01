package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ezr;
import com.tencent.mm.protocal.protobuf.ezs;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  Object cpt;
  public com.tencent.mm.am.c rr;
  
  public ae(pc parampc, Object paramObject)
  {
    AppMethodBeat.i(124146);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ezr();
    ((c.a)localObject).otF = new ezs();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
    ((c.a)localObject).funcId = 1228;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ezr)c.b.b(this.rr.otB);
    ((ezr)localObject).aapi = parampc;
    ((ezr)localObject).mask = 17;
    ((ezr)localObject).aapg = 1;
    this.cpt = paramObject;
    AppMethodBeat.o(124146);
  }
  
  public static void a(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(239428);
    com.tencent.mm.kernel.h.baD().mCm.a(1228, paramh);
    AppMethodBeat.o(239428);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124148);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124148);
    return i;
  }
  
  public final int getType()
  {
    return 1228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124147);
    Log.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.ae
 * JD-Core Version:    0.7.0.1
 */