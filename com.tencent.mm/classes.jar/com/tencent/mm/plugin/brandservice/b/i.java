package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  LinkedList<String> pnD;
  private final d rr;
  
  public i()
  {
    AppMethodBeat.i(5577);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new bhp();
    ((d.a)localObject1).iLO = new bhq();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((d.a)localObject1).funcId = 387;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    this.pnD = new LinkedList();
    bhp localbhp = (bhp)this.rr.iLK.iLR;
    com.tencent.mm.kernel.g.aAi();
    Object localObject2 = com.tencent.mm.kernel.g.aAh().azQ().get(196610, null);
    if (localObject2 == null) {}
    for (localObject1 = "null";; localObject1 = localObject2.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), localObject1 });
      localbhp.LSe = Util.nullAs((Integer)localObject2, 0);
      Log.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(localbhp.LSe) });
      AppMethodBeat.o(5577);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(5579);
    this.callback = parami;
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
      params = (bhq)this.rr.iLL.iLR;
      Log.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(params.LSe), Integer.valueOf(params.oTz) });
      b.k(196610, Integer.valueOf(params.LSe));
      params = params.oTA.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (al)params.next();
        this.pnD.add(paramArrayOfByte.UserName);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.i
 * JD-Core Version:    0.7.0.1
 */