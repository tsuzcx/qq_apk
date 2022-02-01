package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.an.q
  implements m
{
  protected i callback;
  public com.tencent.mm.an.d rr;
  
  public b(LinkedList<adp> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ie();
    ((d.a)localObject).lBV = new ig();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((d.a)localObject).funcId = 704;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ie)d.b.b(this.rr.lBR);
    ((ie)localObject).RNw = paramLinkedList.size();
    ((ie)localObject).RNx = paramLinkedList;
    ((ie)localObject).RNz = z.bcZ();
    ((ie)localObject).RNy = com.tencent.mm.compatible.deviceinfo.q.auP();
    ((ie)localObject).RNA = paramString;
    ((ie)localObject).rVQ = 0L;
    ((ie)localObject).CPw = 2;
    AppMethodBeat.o(21373);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(21374);
    this.callback = parami;
    d.b.b(this.rr.lBR);
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
    params = (ig)d.c.b(this.rr.lBS);
    Log.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { params.RND });
    com.tencent.mm.plugin.backup.b.d.bf(params.RMR.Tkb.UH);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */