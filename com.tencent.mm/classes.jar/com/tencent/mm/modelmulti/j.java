package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.l;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class j
  extends n
  implements k
{
  private f callback;
  private WakerLock fDY;
  private final com.tencent.mm.network.q hON;
  
  public j()
  {
    AppMethodBeat.i(132566);
    this.fDY = new WakerLock(aj.getContext(), "MicroMsg.NetSceneSynCheck");
    this.fDY.lock(3000L, "NetSceneSynCheck");
    this.hON = new a();
    g.ajD();
    if (g.ajC() != null)
    {
      g.ajD();
      if (g.ajC().ajl() != null)
      {
        g.ajD();
        Object localObject = (String)g.ajC().ajl().get(8195, null);
        ((aa.a)this.hON.getReqObj()).ieX = bt.aRa((String)localObject);
        localObject = (aa.a)this.hON.getReqObj();
        g.ajD();
        g.ajA();
        ((aa.a)localObject).setUin(com.tencent.mm.kernel.a.getUin());
        ((aa.a)this.hON.getReqObj()).netType = com.tencent.mm.protocal.a.getNetType(aj.getContext());
        ((aa.a)this.hON.getReqObj()).FnX = com.tencent.mm.protocal.a.ffZ();
        ad.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
        AppMethodBeat.o(132566);
        return;
      }
    }
    ad.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
    AppMethodBeat.o(132566);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(132567);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
    if ((i == -1) && (this.fDY.isLocking())) {
      this.fDY.unLock();
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
    ad.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + paramArrayOfByte.FoI);
    if ((g.ajx()) && (!com.tencent.mm.kernel.a.aiE()))
    {
      paramq = ((aa.a)paramq.getReqObj()).gAT;
      if (bt.cC(paramq)) {
        ad.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
      }
      paramArrayOfByte.gAT = paramq;
      ((b)g.ab(b.class)).aJx().a(paramArrayOfByte.FoI, 2, paramArrayOfByte.fgw());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.fDY.unLock();
    AppMethodBeat.o(132568);
  }
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
  
  public static final class a
    extends l
  {
    private final aa.a ifk;
    private final aa.b ifl;
    
    public a()
    {
      AppMethodBeat.i(132565);
      this.ifk = new aa.a();
      this.ifl = new aa.b();
      AppMethodBeat.o(132565);
    }
    
    public final int getOptions()
    {
      return 1;
    }
    
    public final l.d getReqObjImp()
    {
      return this.ifk;
    }
    
    public final l.e getRespObj()
    {
      return this.ifl;
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