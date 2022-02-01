package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class l
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public l(LinkedList<mu> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5584);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cjb();
    ((b.a)localObject).gUV = new cjc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((b.a)localObject).funcId = 2645;
    ((b.a)localObject).reqCmdId = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).atI();
    localObject = (cjb)this.rr.gUS.gUX;
    ((cjb)localObject).Eer = paramLinkedList;
    ((cjb)localObject).Ees = paramInt1;
    ((cjb)localObject).Eet = paramInt2;
    ((cjb)localObject).CGZ = paramInt3;
    ad.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[] { Integer.valueOf(((cjb)localObject).Eer.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(5584);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5586);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5586);
    return i;
  }
  
  public final int getType()
  {
    return 2645;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5585);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */