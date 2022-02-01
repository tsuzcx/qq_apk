package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.ip;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.ak.q
  implements m
{
  protected i callback;
  public com.tencent.mm.ak.d rr;
  
  public b(LinkedList<adi> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ip();
    ((d.a)localObject).iLO = new ir();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((d.a)localObject).funcId = 704;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ip)this.rr.iLK.iLR;
    ((ip)localObject).KMC = paramLinkedList.size();
    ((ip)localObject).KMD = paramLinkedList;
    ((ip)localObject).KMF = z.aTY();
    ((ip)localObject).KME = com.tencent.mm.compatible.deviceinfo.q.aoJ();
    ((ip)localObject).KMG = paramString;
    ((ip)localObject).oTS = 0L;
    ((ip)localObject).Scene = 2;
    AppMethodBeat.o(21373);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21374);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(21374);
    return i;
  }
  
  public final int getType()
  {
    return 704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21375);
    Log.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(21375);
      return;
    }
    params = (ir)this.rr.iLL.iLR;
    Log.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { params.KMJ });
    com.tencent.mm.plugin.backup.b.d.aS(params.KLU.getBuffer().zy);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */