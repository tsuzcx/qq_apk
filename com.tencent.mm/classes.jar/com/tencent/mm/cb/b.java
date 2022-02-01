package com.tencent.mm.cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eqo;
import com.tencent.mm.protocal.protobuf.eqp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b
  extends p
  implements m
{
  private h callback;
  private final c otw;
  
  public b(eqo parameqo)
  {
    AppMethodBeat.i(9330);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new eqo();
    ((c.a)localObject).otF = new eqp();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/reportmediainfo";
    ((c.a)localObject).funcId = 809;
    this.otw = ((c.a)localObject).bEF();
    localObject = (eqo)c.b.b(this.otw.otB);
    ((eqo)localObject).abup = parameqo.abup;
    ((eqo)localObject).abuo = parameqo.abuo;
    ((eqo)localObject).YRE = parameqo.YRE;
    ((eqo)localObject).Zvf.addAll(parameqo.Zvf);
    ((eqo)localObject).vhJ = parameqo.vhJ;
    AppMethodBeat.o(9330);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(9331);
    this.callback = paramh;
    int i = dispatch(paramg, this.otw, this);
    AppMethodBeat.o(9331);
    return i;
  }
  
  public final int getType()
  {
    return 809;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9332);
    Log.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(hashCode()) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(9332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cb.b
 * JD-Core Version:    0.7.0.1
 */