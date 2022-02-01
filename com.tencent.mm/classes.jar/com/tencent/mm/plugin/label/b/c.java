package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private final b rr;
  
  public c()
  {
    AppMethodBeat.i(26149);
    b.a locala = new b.a();
    locala.hNM = new azq();
    locala.hNN = new azr();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(26149);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
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
    ad.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(209408, Long.valueOf(System.currentTimeMillis()));
      paramq = (azr)this.rr.hNL.hNQ;
      if ((paramq != null) && (paramq.FuT != null))
      {
        paramq = paramq.FuT;
        paramArrayOfByte = new ArrayList();
        int j = paramq.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          bsy localbsy = (bsy)paramq.get(paramInt1);
          ao localao = new ao();
          localao.field_labelID = localbsy.GNp;
          localao.field_labelName = localbsy.GNo;
          localao.field_labelPYFull = com.tencent.mm.platformtools.f.IL(localbsy.GNo);
          localao.field_labelPYShort = com.tencent.mm.platformtools.f.IM(localbsy.GNo);
          paramArrayOfByte.add(localao);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.e.dfn().hs(paramArrayOfByte);
        com.tencent.mm.plugin.label.e.dfn().ht(com.tencent.mm.plugin.label.e.dfn().hu(paramArrayOfByte));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */