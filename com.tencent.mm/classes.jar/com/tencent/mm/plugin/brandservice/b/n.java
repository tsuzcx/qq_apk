package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.cwg;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  private final com.tencent.mm.ak.b rr;
  
  public n(List<oo> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cwf();
    ((b.a)localObject).hvu = new cwg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((b.a)localObject).funcId = 386;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cwf)this.rr.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oo localoo = (oo)paramList.next();
      aj localaj = new aj();
      localaj.ncR = localoo.userName;
      localLinkedList.add(localaj);
    }
    ((cwf)localObject).ncL = localLinkedList.size();
    ((cwf)localObject).ncM = localLinkedList;
    ac.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5595);
    this.callback = paramg;
    ac.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
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
    ac.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cwg)this.rr.hvs.hvw;
      ac.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(paramq.ELw) });
      com.tencent.mm.plugin.brandservice.b.j(196610, Integer.valueOf(paramq.ELw));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.n
 * JD-Core Version:    0.7.0.1
 */