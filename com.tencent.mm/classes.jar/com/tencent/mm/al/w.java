package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Date;

public final class w
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private Object data;
  public b rr;
  
  public w(c paramc, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cio();
    ((b.a)localObject).hvu = new cip();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).funcId = 2805;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cio)this.rr.hvr.hvw;
    ((cio)localObject).FwD = 1;
    ((cio)localObject).FwE = paramc.field_wwCorpId;
    ((cio)localObject).EbQ = paramc.field_wwUserVid;
    com.tencent.mm.kernel.g.agP();
    ((cio)localObject).FwF = a.getUin();
    ((cio)localObject).scene = paramInt2;
    ((cio)localObject).cZu = paramInt1;
    ((cio)localObject).FwG = 0L;
    ((cio)localObject).FwH = new Date().getTime();
    ((cio)localObject).platform = 1;
    ((cio)localObject).FsI = i.aA(null, d.DIc);
    this.data = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(124125);
    this.callback = paramg;
    ac.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
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
    ac.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.w
 * JD-Core Version:    0.7.0.1
 */