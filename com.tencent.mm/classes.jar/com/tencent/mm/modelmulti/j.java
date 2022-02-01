package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class j
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private WakerLock flR;
  private final q hwy;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.flR = new WakerLock(ai.getContext(), "MicroMsg.NetSceneSynCheck");
    this.flR.lock(3000L, "NetSceneSynCheck");
    this.hwy = new a();
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agR() != null)
    {
      com.tencent.mm.kernel.g.agS();
      if (com.tencent.mm.kernel.g.agR().agA() != null)
      {
        com.tencent.mm.kernel.g.agS();
        Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(8195, null);
        ((aa.a)this.hwy.getReqObj()).hMd = bs.aLu((String)localObject);
        localObject = (aa.a)this.hwy.getReqObj();
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agP();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((aa.a)this.hwy.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(ai.getContext());
        ((aa.a)this.hwy.getReqObj()).DIQ = com.tencent.mm.protocal.a.eQV();
        ac.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    ac.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132567);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
    if ((i == -1) && (this.flR.isLocking())) {
      this.flR.unLock();
    }
    AppMethodBeat.o(132567);
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
    AppMethodBeat.i(132568);
    paramArrayOfByte = (aa.b)paramq.getRespObj();
    ac.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.DJB);
    if ((com.tencent.mm.kernel.g.agM()) && (!com.tencent.mm.kernel.a.afS()))
    {
      paramq = ((aa.a)paramq.getReqObj()).ghj;
      if (bs.cv(paramq)) {
        ac.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.ghj = paramq;
      ((b)com.tencent.mm.kernel.g.ab(b.class)).aGm().a(paramArrayOfByte.DJB, 2, paramArrayOfByte.eRs());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.flR.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends l
  {
    private final aa.a hMq;
    private final aa.b hMr;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.hMq = new aa.a();
      this.hMr = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.hMq;
    }
    
    public final l.e getRespObj()
    {
      return this.hMr;
    }
    
    public final int getType()
    {
      return 39;
    }
    
    public final String getUri()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j
 * JD-Core Version:    0.7.0.1
 */