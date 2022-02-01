package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  Object cpt;
  public com.tencent.mm.am.c rr;
  
  public y(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(124126);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfr();
    ((c.a)localObject).otF = new cfs();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((c.a)localObject).funcId = 1343;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cfr)c.b.b(this.rr.otB);
    ((cfr)localObject).YRQ = paramString;
    ((cfr)localObject).aapg = paramInt;
    if (LocaleUtil.getApplicationLanguage().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((cfr)localObject).aaph = paramInt;
      this.cpt = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
  }
  
  public static void a(com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(239436);
    com.tencent.mm.kernel.h.baD().mCm.a(1343, paramh);
    AppMethodBeat.o(239436);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(124128);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124128);
    return i;
  }
  
  public final int getType()
  {
    return 1343;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124127);
    Log.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.y
 * JD-Core Version:    0.7.0.1
 */