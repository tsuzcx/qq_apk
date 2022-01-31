package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class i
  extends m
  implements k
{
  private f callback;
  private WakerLock dYK;
  private final q ftU;
  
  public i()
  {
    AppMethodBeat.i(58376);
    this.dYK = new WakerLock(ah.getContext(), "MicroMsg.NetSceneSynCheck");
    this.dYK.lock(3000L, "NetSceneSynCheck");
    this.ftU = new i.a();
    g.RM();
    if (g.RL() != null)
    {
      g.RM();
      if (g.RL().Ru() != null)
      {
        g.RM();
        Object localObject = (String)g.RL().Ru().get(8195, null);
        ((y.a)this.ftU.getReqObj()).fIx = bo.apQ((String)localObject);
        localObject = (y.a)this.ftU.getReqObj();
        g.RM();
        g.RJ();
        ((y.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((y.a)this.ftU.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(ah.getContext());
        ((y.a)this.ftU.getReqObj()).wiu = com.tencent.mm.protocal.a.dqk();
        ab.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(58376);
        return;
      }
    }
    ab.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(58376);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(58377);
    this.callback = paramf;
    int i = dispatch(parame, this.ftU, this);
    if ((i == -1) && (this.dYK.isLocking())) {
      this.dYK.unLock();
    }
    AppMethodBeat.o(58377);
    return i;
  }
  
  public final long getReturnTimeout()
  {
    return 240000L;
  }
  
  public final int getType()
  {
    return 39;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58378);
    paramArrayOfByte = (y.b)paramq.getRespObj();
    ab.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.wiX);
    if ((g.RG()) && (!com.tencent.mm.kernel.a.QP()))
    {
      paramq = ((y.a)paramq.getReqObj()).eHy;
      if (bo.ce(paramq)) {
        ab.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.eHy = paramq;
      ((b)g.E(b.class)).aio().a(paramArrayOfByte.wiX, 2, paramArrayOfByte.dqD());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.dYK.unLock();
    AppMethodBeat.o(58378);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.i
 * JD-Core Version:    0.7.0.1
 */