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
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class j
  extends q
  implements m
{
  private i callback;
  private final d rr;
  LinkedList<String> swD;
  
  public j()
  {
    AppMethodBeat.i(5577);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpa();
    ((d.a)localObject).lBV = new bpb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((d.a)localObject).funcId = 387;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.swD = new LinkedList();
    localObject = (bpa)d.b.b(this.rr.lBR);
    ((bpa)localObject).TaP = Util.nullAs((Integer)b.cyA(), 0);
    Log.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(((bpa)localObject).TaP) });
    AppMethodBeat.o(5577);
  }
  
  public final int doScene(g paramg, i parami)
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
      params = (bpb)d.c.b(this.rr.lBS);
      Log.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(params.TaP), Integer.valueOf(params.rVx) });
      b.n(196610, Integer.valueOf(params.TaP));
      params = params.rVy.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (aj)params.next();
        this.swD.add(paramArrayOfByte.UserName);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */