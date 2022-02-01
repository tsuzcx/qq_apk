package com.tencent.mm.plugin.backup.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  protected h callback;
  public c rr;
  
  public b(LinkedList<afx> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(21373);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ja();
    ((c.a)localObject).otF = new jc();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
    ((c.a)localObject).funcId = 704;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ja)c.b.b(this.rr.otB);
    ((ja)localObject).YKK = paramLinkedList.size();
    ((ja)localObject).YKL = paramLinkedList;
    ((ja)localObject).YKN = z.bAM();
    ((ja)localObject).YKM = q.aPj();
    ((ja)localObject).YKO = paramString;
    ((ja)localObject).vhg = 0L;
    ((ja)localObject).IJG = 2;
    AppMethodBeat.o(21373);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(21374);
    this.callback = paramh;
    c.b.b(this.rr.otB);
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
    params = (jc)c.c.b(this.rr.otC);
    Log.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { params.YKR });
    d.bf(params.YKf.aaxD.Op);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(21375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.e.b
 * JD-Core Version:    0.7.0.1
 */