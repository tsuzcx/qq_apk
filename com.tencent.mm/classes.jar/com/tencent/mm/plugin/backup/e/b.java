package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  protected f callback;
  public com.tencent.mm.ak.b rr;
  
  public b(LinkedList<abj> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ic();
    ((b.a)localObject).hQG = new ie();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).funcId = 704;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ic)this.rr.hQD.hQJ;
    ((ic)localObject).FST = paramLinkedList.size();
    ((ic)localObject).FSU = paramLinkedList;
    ((ic)localObject).FSW = v.aAC();
    ((ic)localObject).FSV = com.tencent.mm.compatible.deviceinfo.q.aaK();
    ((ic)localObject).FSX = paramString;
    ((ic)localObject).nIX = 0L;
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
    ae.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21375);
      return;
    }
    paramq = (ie)this.rr.hQE.hQJ;
    ae.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.FTa });
    d.aB(paramq.FSl.getBuffer().zr);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */