package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public n(List<pt> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dbs();
    ((b.a)localObject).hNN = new dbt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((b.a)localObject).funcId = 386;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dbs)this.rr.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pt localpt = (pt)paramList.next();
      aj localaj = new aj();
      localaj.nDo = localpt.userName;
      localLinkedList.add(localaj);
    }
    ((dbs)localObject).nDi = localLinkedList.size();
    ((dbs)localObject).nDj = localLinkedList;
    ad.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5595);
    this.callback = paramf;
    ad.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
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
    ad.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (dbt)this.rr.hNL.hNQ;
      ad.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(paramq.Guz) });
      com.tencent.mm.plugin.brandservice.b.j(196610, Integer.valueOf(paramq.Guz));
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