package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public n(List<pv> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dcm();
    ((b.a)localObject).hQG = new dcn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((b.a)localObject).funcId = 386;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dcm)this.rr.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pv localpv = (pv)paramList.next();
      aj localaj = new aj();
      localaj.nIJ = localpv.userName;
      localLinkedList.add(localaj);
    }
    ((dcm)localObject).nID = localLinkedList.size();
    ((dcm)localObject).nIE = localLinkedList;
    ae.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5595);
    this.callback = paramf;
    ae.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5595);
    return i;
  }
  
  public final int getType()
  {
    return 386;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5594);
    ae.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (dcn)this.rr.hQE.hQJ;
      ae.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(paramq.GNY) });
      com.tencent.mm.plugin.brandservice.b.j(196610, Integer.valueOf(paramq.GNY));
      com.tencent.mm.plugin.brandservice.b.j(196611, Boolean.FALSE);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5594);
      return;
      com.tencent.mm.plugin.brandservice.b.j(196611, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.n
 * JD-Core Version:    0.7.0.1
 */