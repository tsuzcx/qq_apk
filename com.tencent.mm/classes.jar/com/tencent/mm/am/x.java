package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Date;

public final class x
  extends n
  implements k
{
  private f callback;
  private Object data;
  public b rr;
  
  public x(d paramd, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(124123);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cno();
    ((b.a)localObject).hNN = new cnp();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
    ((b.a)localObject).funcId = 2805;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cno)this.rr.hNK.hNQ;
    ((cno)localObject).HgJ = 1;
    ((cno)localObject).HgK = paramd.field_wwCorpId;
    ((cno)localObject).FHC = paramd.field_wwUserVid;
    g.ajA();
    ((cno)localObject).HgL = a.getUin();
    ((cno)localObject).scene = paramInt2;
    ((cno)localObject).dkM = paramInt1;
    ((cno)localObject).xdB = 0L;
    ((cno)localObject).HgM = new Date().getTime();
    ((cno)localObject).platform = 1;
    ((cno)localObject).HcP = j.aD(null, com.tencent.mm.protocal.d.Fnj);
    this.data = paramObject;
    AppMethodBeat.o(124123);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124125);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.x
 * JD-Core Version:    0.7.0.1
 */