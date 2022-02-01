package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Date;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private Object data;
  public b rr;
  
  public w(c paramc, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cdl();
    ((b.a)localObject).gUV = new cdm();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).funcId = 2805;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cdl)this.rr.gUS.gUX;
    ((cdl)localObject).DZI = 1;
    ((cdl)localObject).DZJ = paramc.field_wwCorpId;
    ((cdl)localObject).CJo = paramc.field_wwUserVid;
    com.tencent.mm.kernel.g.afz();
    ((cdl)localObject).DZK = a.getUin();
    ((cdl)localObject).scene = paramInt2;
    ((cdl)localObject).dbV = paramInt1;
    ((cdl)localObject).DZL = 0L;
    ((cdl)localObject).DZM = new Date().getTime();
    ((cdl)localObject).platform = 1;
    ((cdl)localObject).DVU = i.au(null, d.CpK);
    this.data = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(124125);
    this.callback = paramg;
    ad.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124125);
    return i;
  }
  
  public final int getType()
  {
    return 2805;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124124);
    ad.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.w
 * JD-Core Version:    0.7.0.1
 */