package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private final b rr;
  
  public c()
  {
    AppMethodBeat.i(26149);
    b.a locala = new b.a();
    locala.hQF = new bag();
    locala.hQG = new bah();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(26149);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(26151);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26151);
    return i;
  }
  
  public final int getType()
  {
    return 639;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(26150);
    ae.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(209408, Long.valueOf(System.currentTimeMillis()));
      paramq = (bah)this.rr.hQE.hQJ;
      if ((paramq != null) && (paramq.FNr != null))
      {
        paramq = paramq.FNr;
        paramArrayOfByte = new ArrayList();
        int j = paramq.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          bts localbts = (bts)paramq.get(paramInt1);
          ap localap = new ap();
          localap.field_labelID = localbts.HgP;
          localap.field_labelName = localbts.HgO;
          localap.field_labelPYFull = com.tencent.mm.platformtools.f.Jk(localbts.HgO);
          localap.field_labelPYShort = com.tencent.mm.platformtools.f.Jl(localbts.HgO);
          paramArrayOfByte.add(localap);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.e.dif().hC(paramArrayOfByte);
        com.tencent.mm.plugin.label.e.dif().hD(com.tencent.mm.plugin.label.e.dif().hE(paramArrayOfByte));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26150);
      return;
      ae.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */