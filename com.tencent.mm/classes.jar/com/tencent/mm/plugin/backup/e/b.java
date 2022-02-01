package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class b
  extends n
  implements k
{
  protected g callback;
  public com.tencent.mm.ak.b rr;
  
  public b(LinkedList<za> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new hv();
    ((b.a)localObject).hvu = new hx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).funcId = 704;
    this.rr = ((b.a)localObject).aAz();
    localObject = (hv)this.rr.hvr.hvw;
    ((hv)localObject).DVc = paramLinkedList.size();
    ((hv)localObject).DVd = paramLinkedList;
    ((hv)localObject).DVf = u.axw();
    ((hv)localObject).DVe = com.tencent.mm.compatible.deviceinfo.q.Ya();
    ((hv)localObject).DVg = paramString;
    ((hv)localObject).ndf = 0L;
    ((hv)localObject).Scene = 2;
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
    ac.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21375);
      return;
    }
    paramq = (hx)this.rr.hvs.hvw;
    ac.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.DVj });
    d.aB(paramq.DUt.getBuffer().xy);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */