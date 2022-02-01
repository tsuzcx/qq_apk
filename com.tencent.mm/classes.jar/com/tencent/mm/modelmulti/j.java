package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.l;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class j
  extends n
  implements k
{
  private f callback;
  private WakerLock fGc;
  private final com.tencent.mm.network.q hRG;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.fGc = new WakerLock(ak.getContext(), "MicroMsg.NetSceneSynCheck");
    this.fGc.lock(3000L, "NetSceneSynCheck");
    this.hRG = new a();
    g.ajS();
    if (g.ajR() != null)
    {
      g.ajS();
      if (g.ajR().ajA() != null)
      {
        g.ajS();
        Object localObject = (String)g.ajR().ajA().get(8195, null);
        ((aa.a)this.hRG.getReqObj()).ihP = bu.aSx((String)localObject);
        localObject = (aa.a)this.hRG.getReqObj();
        g.ajS();
        g.ajP();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((aa.a)this.hRG.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(ak.getContext());
        ((aa.a)this.hRG.getReqObj()).FGv = com.tencent.mm.protocal.a.fjP();
        ae.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    ae.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(132567);
    this.callback = paramf;
    int i = dispatch(parame, this.hRG, this);
    if ((i == -1) && (this.fGc.isLocking())) {
      this.fGc.unLock();
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132568);
    paramArrayOfByte = (aa.b)paramq.getRespObj();
    ae.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.FHg);
    if ((g.ajM()) && (!com.tencent.mm.kernel.a.aiT()))
    {
      paramq = ((aa.a)paramq.getReqObj()).gDA;
      if (bu.cF(paramq)) {
        ae.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.gDA = paramq;
      ((b)g.ab(b.class)).aJQ().a(paramArrayOfByte.FHg, 2, paramArrayOfByte.fkm());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.fGc.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends l
  {
    private final aa.a iid;
    private final aa.b iie;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.iid = new aa.a();
      this.iie = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.iid;
    }
    
    public final l.e getRespObj()
    {
      return this.iie;
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