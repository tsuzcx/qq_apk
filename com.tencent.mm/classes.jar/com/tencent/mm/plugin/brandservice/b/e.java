package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private f callback;
  LinkedList<String> jSP;
  private final com.tencent.mm.ai.b rr;
  
  public e()
  {
    AppMethodBeat.i(13836);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new afl();
    ((b.a)localObject1).fsY = new afm();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/getapplist";
    ((b.a)localObject1).funcId = 387;
    ((b.a)localObject1).reqCmdId = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).ado();
    this.jSP = new LinkedList();
    afl localafl = (afl)this.rr.fsV.fta;
    g.RM();
    Object localObject2 = g.RL().Ru().get(196610, null);
    if (localObject2 == null) {}
    for (localObject1 = "null";; localObject1 = localObject2.toString())
    {
      ab.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), localObject1 });
      localafl.wYJ = bo.a((Integer)localObject2, 0);
      ab.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[] { Integer.valueOf(localafl.wYJ) });
      AppMethodBeat.o(13836);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(13838);
    this.callback = paramf;
    ab.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13838);
    return i;
  }
  
  public final int getType()
  {
    return 387;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13837);
    ab.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (afm)this.rr.fsW.fta;
      ab.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[] { Integer.valueOf(paramq.wYJ), Integer.valueOf(paramq.jJu) });
      com.tencent.mm.plugin.brandservice.b.i(196610, Integer.valueOf(paramq.wYJ));
      paramq = paramq.jJv.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (ah)paramq.next();
        this.jSP.add(paramArrayOfByte.jJA);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(13837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.e
 * JD-Core Version:    0.7.0.1
 */