package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ak;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public c()
  {
    AppMethodBeat.i(26149);
    b.a locala = new b.a();
    locala.gUU = new aso();
    locala.gUV = new asp();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(26149);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(26151);
    this.callback = paramg;
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
    ad.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(209408, Long.valueOf(System.currentTimeMillis()));
      paramq = (asp)this.rr.gUT.gUX;
      if ((paramq != null) && (paramq.Cxi != null))
      {
        paramq = paramq.Cxi;
        paramArrayOfByte = new ArrayList();
        int j = paramq.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          bkp localbkp = (bkp)paramq.get(paramInt1);
          ah localah = new ah();
          localah.field_labelID = localbkp.DIq;
          localah.field_labelName = localbkp.DIp;
          localah.field_labelPYFull = f.Br(localbkp.DIp);
          localah.field_labelPYShort = f.Bs(localbkp.DIp);
          paramArrayOfByte.add(localah);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.e.cIR().gT(paramArrayOfByte);
        com.tencent.mm.plugin.label.e.cIR().gU(com.tencent.mm.plugin.label.e.cIR().gV(paramArrayOfByte));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26150);
      return;
      ad.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */