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
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends p
  implements m
{
  private h callback;
  private final c rr;
  LinkedList<String> vCk;
  
  public j()
  {
    AppMethodBeat.i(5577);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cdn();
    ((c.a)localObject).otF = new cdo();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((c.a)localObject).funcId = 387;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.vCk = new LinkedList();
    localObject = (cdn)c.b.b(this.rr.otB);
    ((cdn)localObject).aanR = Util.nullAs((Integer)b.dbv(), 0);
    Log.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(((cdn)localObject).aanR) });
    AppMethodBeat.o(5577);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5579);
    this.callback = paramh;
    Log.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5579);
    return i;
  }
  
  public final int getType()
  {
    return 387;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5578);
    Log.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cdo)c.c.b(this.rr.otC);
      Log.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(params.aanR), Integer.valueOf(params.vgN) });
      b.G(196610, Integer.valueOf(params.aanR));
      params = params.vgO.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (al)params.next();
        this.vCk.add(paramArrayOfByte.UserName);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.j
 * JD-Core Version:    0.7.0.1
 */