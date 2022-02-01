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
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  Object bnW;
  private i callback;
  public d rr;
  
  public y(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(124126);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bra();
    ((d.a)localObject).lBV = new brb();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((d.a)localObject).funcId = 1343;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bra)d.b.b(this.rr.lBR);
    ((bra)localObject).RUp = paramString;
    ((bra)localObject).TbU = paramInt;
    if (LocaleUtil.getApplicationLanguage().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((bra)localObject).TbV = paramInt;
      this.bnW = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(205896);
    h.aHF().kcd.a(1343, parami);
    AppMethodBeat.o(205896);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124128);
    this.callback = parami;
    Log.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124128);
    return i;
  }
  
  public final int getType()
  {
    return 1343;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124127);
    Log.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.y
 * JD-Core Version:    0.7.0.1
 */