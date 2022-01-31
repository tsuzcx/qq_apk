package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gw;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class b
  extends m
  implements k
{
  protected f callback;
  public com.tencent.mm.ai.b rr;
  
  public b(LinkedList<vd> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(17315);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new gu();
    ((b.a)localObject).fsY = new gw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((b.a)localObject).funcId = 704;
    this.rr = ((b.a)localObject).ado();
    localObject = (gu)this.rr.fsV.fta;
    ((gu)localObject).wta = paramLinkedList.size();
    ((gu)localObject).wtb = paramLinkedList;
    ((gu)localObject).wtd = r.Zn();
    ((gu)localObject).wtc = com.tencent.mm.compatible.e.q.LN();
    ((gu)localObject).wte = paramString;
    ((gu)localObject).jJO = 0L;
    ((gu)localObject).Scene = 2;
    AppMethodBeat.o(17315);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(17316);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(17316);
    return i;
  }
  
  public final int getType()
  {
    return 704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17317);
    ab.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(17317);
      return;
    }
    paramq = (gw)this.rr.fsW.fta;
    ab.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramq.wth });
    d.an(paramq.wsu.getBuffer().pW);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(17317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */