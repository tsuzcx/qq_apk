package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.efs;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public o(List<qp> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new efs();
    ((d.a)localObject).lBV = new eft();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((d.a)localObject).funcId = 386;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (efs)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qp localqp = (qp)paramList.next();
      aj localaj = new aj();
      localaj.UserName = localqp.userName;
      localLinkedList.add(localaj);
    }
    ((efs)localObject).rVx = localLinkedList.size();
    ((efs)localObject).rVy = localLinkedList;
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5595);
    this.callback = parami;
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5595);
    return i;
  }
  
  public final int getType()
  {
    return 386;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5594);
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (eft)d.c.b(this.rr.lBS);
      Log.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(params.TaP) });
      b.n(196610, Integer.valueOf(params.TaP));
      b.n(196611, Boolean.FALSE);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5594);
      return;
      b.n(196611, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.o
 * JD-Core Version:    0.7.0.1
 */