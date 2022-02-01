package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  
  public k(LinkedList<nx> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5584);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ctl();
    ((b.a)localObject).hNN = new ctm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((b.a)localObject).funcId = 2645;
    ((b.a)localObject).hNO = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ctl)this.rr.hNK.hNQ;
    ((ctl)localObject).HlE = paramLinkedList;
    ((ctl)localObject).HlF = paramInt1;
    ((ctl)localObject).HlG = paramInt2;
    ((ctl)localObject).FEY = paramInt3;
    ad.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[] { Integer.valueOf(((ctl)localObject).HlE.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(5584);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5586);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */