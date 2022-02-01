package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.ezl;
import com.tencent.mm.protocal.protobuf.ezm;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public o(List<sa> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ezl();
    ((c.a)localObject).otF = new ezm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((c.a)localObject).funcId = 386;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ezl)c.b.b(this.rr.otB);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      sa localsa = (sa)paramList.next();
      al localal = new al();
      localal.UserName = localsa.userName;
      localLinkedList.add(localal);
    }
    ((ezl)localObject).vgN = localLinkedList.size();
    ((ezl)localObject).vgO = localLinkedList;
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5595);
    this.callback = paramh;
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
      params = (ezm)c.c.b(this.rr.otC);
      Log.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(params.aanR) });
      b.G(196610, Integer.valueOf(params.aanR));
      b.G(196611, Boolean.FALSE);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5594);
      return;
      b.G(196611, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.o
 * JD-Core Version:    0.7.0.1
 */