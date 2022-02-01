package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class b
  extends n
  implements k
{
  private f callback;
  public String oGs;
  public String oIf;
  private final com.tencent.mm.ak.b rr;
  
  public b(double paramDouble1, double paramDouble2, String paramString)
  {
    AppMethodBeat.i(112957);
    this.oIf = "";
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new azh();
    ((b.a)localObject).hQG = new azi();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
    ((b.a)localObject).funcId = 1164;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (azh)this.rr.hQD.hQJ;
    ((azh)localObject).latitude = paramDouble1;
    ((azh)localObject).longitude = paramDouble2;
    ((azh)localObject).oIf = paramString;
    ((azh)localObject).GPw = ((String)g.ajR().ajA().get(am.a.ILT, ""));
    ae.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + ((azh)localObject).GPw);
    AppMethodBeat.o(112957);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112959);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112959);
    return i;
  }
  
  public final int getType()
  {
    return 1164;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112958);
    ae.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azi)this.rr.hQE.hQJ;
      ae.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + paramq.oGs);
      this.oGs = paramq.oGs;
      this.oIf = paramq.oIf;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.b
 * JD-Core Version:    0.7.0.1
 */