package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.k.a;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private f callback;
  public com.tencent.mm.network.q ftU;
  
  public a(LinkedList<vd> paramLinkedList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(17312);
    this.ftU = new a.a();
    k.a locala = (k.a)this.ftU.getReqObj();
    locala.wis = d.aSP();
    locala.wir.wta = paramLinkedList.size();
    locala.wir.wtb = paramLinkedList;
    locala.wir.wtc = com.tencent.mm.compatible.e.q.LN();
    locala.wir.wtd = r.Zn();
    locala.wir.Scene = 2;
    locala.wir.jJO = 0L;
    locala.wir.wte = paramString1;
    locala.wir.wtf = paramString2;
    locala.setPassKey(locala.wis);
    locala.setReqPackControl(new a.1(this, locala));
    AppMethodBeat.o(17312);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(17313);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(17313);
    return i;
  }
  
  public final int getType()
  {
    return 1000;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17314);
    ab.i("MicroMsg.BackupCreateQRCodeOfflineScene", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(17314);
      return;
    }
    ab.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { ((k.b)paramq.getRespObj()).wit.wth });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(17314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.a
 * JD-Core Version:    0.7.0.1
 */