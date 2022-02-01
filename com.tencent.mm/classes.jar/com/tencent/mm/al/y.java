package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  private i callback;
  Object data;
  public d rr;
  
  public y(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(124126);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjr();
    ((d.a)localObject).iLO = new bjs();
    ((d.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
    ((d.a)localObject).funcId = 1343;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bjr)this.rr.iLK.iLR;
    ((bjr)localObject).KTt = paramString;
    ((bjr)localObject).LTj = paramInt;
    if (LocaleUtil.getApplicationLanguage().equals("zh_CN")) {}
    for (paramInt = 2;; paramInt = 1)
    {
      ((bjr)localObject).LTk = paramInt;
      this.data = paramObject;
      AppMethodBeat.o(124126);
      return;
    }
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
 * Qualified Name:     com.tencent.mm.al.y
 * JD-Core Version:    0.7.0.1
 */