package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Date;

public final class x
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private Object data;
  public b rr;
  
  public x(d paramd, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new coi();
    ((b.a)localObject).hQG = new coj();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).funcId = 2805;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (coi)this.rr.hQD.hQJ;
    ((coi)localObject).HAj = 1;
    ((coi)localObject).HAk = paramd.field_wwCorpId;
    ((coi)localObject).FZY = paramd.field_wwUserVid;
    g.ajP();
    ((coi)localObject).HAl = a.getUin();
    ((coi)localObject).scene = paramInt2;
    ((coi)localObject).dlO = paramInt1;
    ((coi)localObject).xts = 0L;
    ((coi)localObject).HAm = new Date().getTime();
    ((coi)localObject).platform = 1;
    ((coi)localObject).Hwp = com.tencent.mm.sdk.platformtools.k.aD(null, com.tencent.mm.protocal.d.FFH);
    this.data = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124125);
    this.callback = paramf;
    ae.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
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
    ae.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.x
 * JD-Core Version:    0.7.0.1
 */