package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  protected g callback;
  public com.tencent.mm.al.b rr;
  
  public b(LinkedList<yf> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new hr();
    ((b.a)localObject).gUV = new ht();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).funcId = 704;
    this.rr = ((b.a)localObject).atI();
    localObject = (hr)this.rr.gUS.gUX;
    ((hr)localObject).CCF = paramLinkedList.size();
    ((hr)localObject).CCG = paramLinkedList;
    ((hr)localObject).CCI = u.aqG();
    ((hr)localObject).CCH = com.tencent.mm.compatible.deviceinfo.q.Xd();
    ((hr)localObject).CCJ = paramString;
    ((hr)localObject).mBe = 0L;
    ((hr)localObject).Scene = 2;
    AppMethodBeat.o(21373);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(21374);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21374);
    return i;
  }
  
  public final int getType()
  {
    return 704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21375);
    ad.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21375);
      return;
    }
    paramq = (ht)this.rr.gUT.gUX;
    ad.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.CCM });
    d.aC(paramq.CBW.getBuffer().wA);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */