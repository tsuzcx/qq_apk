package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  protected f callback;
  public com.tencent.mm.al.b rr;
  
  public b(LinkedList<aba> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ic();
    ((b.a)localObject).hNN = new ie();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).funcId = 704;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ic)this.rr.hNK.hNQ;
    ((ic)localObject).FAx = paramLinkedList.size();
    ((ic)localObject).FAy = paramLinkedList;
    ((ic)localObject).FAA = u.aAm();
    ((ic)localObject).FAz = com.tencent.mm.compatible.deviceinfo.q.aaB();
    ((ic)localObject).FAB = paramString;
    ((ic)localObject).nDC = 0L;
    ((ic)localObject).Scene = 2;
    AppMethodBeat.o(21373);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21374);
    this.callback = paramf;
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
    paramq = (ie)this.rr.hNL.hNQ;
    ad.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.FAE });
    d.aB(paramq.FzN.getBuffer().zr);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */